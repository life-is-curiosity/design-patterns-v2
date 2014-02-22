package CommandPackage;

import java.text.SimpleDateFormat;
import java.util.Scanner;
import java.util.Vector;

import AJCS.AdvancedMem;
import AJCS.CompanyMember;
import AJCS.Member;
import AJCS.PrimaryMember;
import WLTS.Client;
import WLTS.ClientCare;
import WLTS.VIP;
import WLTS.VIP_Family;

public class ShowCommand implements Command {

	private Vector<Member> memberList = new Vector<Member>();
	private Vector<Client> clientList = new Vector<Client>();
	private Vector<Command> undoList = new Vector<Command>();
	private Vector<Command> redoList = new Vector<Command>();
	private Scanner sc = new Scanner(System.in);

	@Override
	public void execute() {

		System.out.println("Enter id ( *999 to show all ).");
		String id = sc.nextLine();

		System.out.println("Member information : ");

		if (id.equals("*999")) {
			System.out
					.print("ExpireDate \t| ID \t\t| Type \t\t| Name \t\t| Address\n");
			System.out
					.print("----------------------------------------------------------------------------------\n");

			for (int i = 0; i < memberList.size(); i++) {

				System.out.print(new SimpleDateFormat("dd-MM-YYYY")
						.format(memberList.get(i).getGoodTill()) + "\t| ");
				System.out.print(memberList.get(i).getId() + "\t| ");
				if (memberList.get(i) instanceof PrimaryMember) {
					System.out.print("Pri \t\t|");
				} else if (memberList.get(i) instanceof CompanyMember) {
					System.out.print("Com \t\t|");
				}
				System.out.print(memberList.get(i).getName() + "\t\t| ");
				System.out.print(memberList.get(i).getPostal());
			}
			System.out.print("\n");
			for (int i = 0; i < clientList.size(); i++) {
				System.out.print(new SimpleDateFormat("dd-MM-YYYY")
						.format(clientList.get(i).getExpiryDate()) + "\t| ");
				System.out.print(clientList.get(i).getCid() + "\t| ");
				if (clientList.get(i) instanceof VIP) {
					System.out.print("VIP \t\t|");
				} else if (clientList.get(i) instanceof VIP_Family) {
					System.out.print("VIPF \t\t|");
				}
				System.out.print(clientList.get(i).getName() + "\t\t| ");
				System.out.println(clientList.get(i).getAddress());
			}

		} else {
			try {
				// AJCS
				Member member = new AdvancedMem(memberList).searchMem(id);
				System.out.println();
				System.out.println("ID : " + member.getId());
				System.out.println("Name : " + member.getName());
				if (member instanceof PrimaryMember == true) {
					System.out.println("Type : Pri");
				} else if (member instanceof CompanyMember == true) {
					System.out.println("Type : Com");
				}
				System.out.println("Address : " + member.getPostal());
				System.out.println("Expire Date (DD-MM-YYYY) : "
						+ new SimpleDateFormat("dd-MM-YYYY").format(member
								.getGoodTill()));
				System.out.println();

			} catch (NullPointerException n) {

				try {// WLTS
					Client client = new ClientCare(clientList)
							.foundClient(Integer.parseInt(id));
					System.out.println("ID : " + client.getCid());
					System.out.println("Name : " + client.getName());
					if (client instanceof VIP == true) {
						System.out.println("Type : VIP");
					} else if (client instanceof VIP_Family == true) {
						System.out.println("Type : VIPF");
					}
					System.out.println("Address : " + client.getAddress());
					System.out.println("Expire Date (DD-MM-YYYY) : "
							+ new SimpleDateFormat("dd-MM-YYYY").format(client
									.getExpiryDate()));
					System.out.println();
				} catch (Exception e) {
					System.out.println("No Record found.");
					System.out.println();
				}
			}
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

}
