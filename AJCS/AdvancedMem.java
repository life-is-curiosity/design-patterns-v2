package AJCS;

import java.util.Date;
import java.util.Scanner;
import java.util.Vector;

import Tools.ExceptionManagement;

public class AdvancedMem {

	private Member[] members;

	public AdvancedMem(Vector<Member> vect) {

		members = new Member[vect.size()];
		for (int i = 0; i < vect.size(); i++) {
			members[i] = (Member) vect.get(i);
		}
	}

	public Member createMem() {

		try {
			Scanner sc = new Scanner(System.in);
			Date date = new Date();

			System.out.println("Enter id, type, name and address : ");
			String memberInfo = sc.nextLine();

			Vector<String> list = new Vector<String>();
			String exceptSpace = memberInfo.replaceAll(" ", "");
			String[] content = exceptSpace.split(",");

			String str = new String();

			for (int i = 0; i < content.length; i++) { // Handling string
				if (i > 2) {
					str += content[i] + ",";
					continue;
				} else {
					list.add(content[i]);
				}
			}
			str = new StringBuffer(str).replace(str.length() - 1, str.length(),
					".").toString();
			list.add(str);

			Member member = null;

			while (member == null) {

				if (list.get(1).toString().equals("Pri")) {
					member = new PrimaryMember();
					if (member.validate(list.get(0).toString()) == true) {
						member.setId(list.get(0).toString());
						member.setName(list.get(2).toString());
						member.setPostal(list.get(3).toString());
						member.setGoodTill(date);
						System.out.println();
						System.out.println("New member record created.");
						System.out.println();
						return member;

					} else {
						ExceptionManagement.invalidIdException(null);
						return null;
					}

				} else if (list.get(1).toString().equals("Com")) {

					member = new CompanyMember();
					if (member.validate(list.get(0).toString()) == true) {
						member.setId(list.get(0).toString());
						member.setName(list.get(2).toString());
						member.setPostal(list.get(3).toString());
						member.setGoodTill(date);
						System.out.println();
						System.out.println("New member record created.");
						System.out.println();
						return member;

					} else {
						ExceptionManagement.invalidIdException(null);
						return null;
					}

				} else {
					ExceptionManagement.noSuchTypeException(null);
					return null;
				}
			}

			sc.close();
			return member;

		} catch (Exception e) {
			System.err.println("Insufficient information provided.\n");
		}

		return null;
	}

	public Member searchMem(String id) {

		Member member = null;
		for (int i = 0; i < members.length; i++) {
			if (members[i].getId().toString().equals(id)) {
				member = members[i];
			}
		}
		return member;

	}

	public void updateAddress(String id) {
	}

	public void extendGoodTill(String id) {
	}

	public boolean stillGood(String id) {
		return false;
	}
}
