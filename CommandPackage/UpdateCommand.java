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

public class UpdateCommand implements Command {

	private Vector<Member> memberList = new Vector<Member>();
	private Vector<Client> clientList = new Vector<Client>();
	private Vector<Command> undoList = new Vector<Command>();
	private Vector<Command> redoList = new Vector<Command>();
	private Scanner sc = new Scanner(System.in);

	@Override
	public void execute() {

		System.out.println("Enter id ( *999 to show all ).");
		String id = sc.nextLine();
		if (id.equals("*999")) {
			System.out
					.println("ExpireDate \t| ID \t\t| Type \t\t| Name \t\t| Address\n");
			System.out
					.print("----------------------------------------------------------------------------------");
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

			System.out.println();

		} else {

			try {
				Member member = new AdvancedMem(memberList).searchMem(id);
				Client client = new ClientCare(clientList).foundClient(Integer
						.parseInt(id));
				if (member != null) {
					System.out.println("Enter address : ");
					member.setPostal(sc.nextLine());
					System.out.println("Member address updated");
				} else if (client != null) {
					System.out.println("Enter address : ");
					client.setAddress(sc.nextLine());
					System.out.println("Client address updated");
					System.out.println();
				} else {
					System.out.println("No Record found.");
					System.out.println();
				}
			} catch (Exception x) {
				System.out.println("No Record found.");
				System.out.println();
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
