package CommandPackage;

import java.lang.reflect.InvocationTargetException;
import java.util.Scanner;
import java.util.Vector;
import Tools.AJCSAdapter;
import Tools.Adapter;
import Tools.ExceptionManagement;
import Tools.WLTSAdapter;
import AJCS.*;
import WLTS.*;

public class CreateCommand implements Command {

	private Vector<Member> memberList = new Vector<Member>();
	private Vector<Client> clientList = new Vector<Client>();
	private Vector<Command> undoList = new Vector<Command>();
	private Vector<Command> redoList = new Vector<Command>();
	private Scanner sc = new Scanner(System.in);

	@Override
	public void execute() throws IllegalAccessException,
			IllegalArgumentException, InvocationTargetException,
			SecurityException, NoSuchMethodException {

		try {

			System.out.println("Enter Company Code ( ajcs / wlts ).");
			String companyCode = sc.nextLine().toUpperCase();

			Class<?> c = Class.forName("Tools." + companyCode + "Adapter");

			Adapter company = (c.getSimpleName().equals("AJCSAdapter")) ? (Adapter) c
					.getConstructor(Vector.class).newInstance(memberList) : ((c
					.getSimpleName().equals("WLTSAdapter")) ? (Adapter) c
					.getConstructor(Vector.class).newInstance(clientList)
					: null);

			company.getPrepare(memberList, clientList, undoList, redoList);

			Member temp1 = null;
			Client temp2 = null;

			if (company instanceof AJCSAdapter) {
				temp1 = (Member) company.create();
				if (temp1 != null) {
					if (CheckMemberIdExisted(temp1)) {
						memberList.add(temp1);
					} else {
						ExceptionManagement.IdExistedException(null);
					}
				} else {
					System.err.println("No record inserted.");
				}

			} else if (company instanceof WLTSAdapter) {
				temp2 = (Client) company.create();
				if (temp2 != null) {
					if (CheckClientIdExisted(temp2)) {
						clientList.add(temp2);
					} else {
						ExceptionManagement.IdExistedException(null);
					}
				} else {
					System.err.println("No record inserted.");
				}
			}

		} catch (ClassNotFoundException | InstantiationException
				| NoSuchMethodException classnotfound) {
			ExceptionManagement.factoryClassException(classnotfound);
		} catch (NullPointerException n) {
			ExceptionManagement.noSuchTypeException(n);
		} catch (Exception e) {
			ExceptionManagement.exception(e);
		}

	}

	@Override
	public void getPrepare(Vector<Member> memberlist,
			Vector<Client> clientList, Vector<Command> undo,
			Vector<Command> redo) {

		this.memberList = memberlist;
		this.clientList = clientList;
		this.undoList = undo;
		this.redoList = redo;

	}

	private boolean CheckMemberIdExisted(Member m) {
		for (int i = 0; i < memberList.size(); i++) {
			if (m.getId().equals(memberList.get(i).getId())) {
				return false;
			}
		}
		return true;
	}

	private boolean CheckClientIdExisted(Client c) {
		for (int i = 0; i < clientList.size(); i++) {
			if (c.getCid() == clientList.get(i).getCid()) {
				return false;
			}
		}
		return true;
	}
}
