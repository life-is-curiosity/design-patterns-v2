package WLTS;

import java.util.Date;
import java.util.Scanner;
import java.util.Vector;

import Tools.ExceptionManagement;
import WLTS.Client;

public class ClientCare {

	private Client[] clients;

	public ClientCare(Vector<Client> vect) {

		clients = new Client[vect.size()];
		for (int i = 0; i < vect.size(); i++) {
			clients[i] = (Client) vect.get(i);
		}
	}

	public Client createClient() {

		Scanner sc = new Scanner(System.in);
		Date date = new Date();
		try {
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

			Client client = null;

			while (client == null) {

				if (list.get(1).toString().equals("VIP")) {

					client = new VIP();
					if (client.validate((Integer.parseInt(list.get(0)
							.toString())))) {
						client.setCid(Integer.parseInt(list.get(0).toString()));
						client.setName(list.get(2).toString());
						client.setAddress(list.get(3).toString());
						client.setExpiryDate(date);
						System.out.println();
						System.out.println("New client record created.");
						System.out.println();
						return client;

					} else {
						ExceptionManagement.invalidIdException(null);
						return null;
					}

				} else if (list.get(1).toString().equals("VIPF")) {

					client = new VIP_Family();
					if (client.validate(Integer
							.parseInt(list.get(0).toString()))) {
						client.setCid(Integer.parseInt(list.get(0).toString()));
						client.setName(list.get(2).toString());
						client.setAddress(list.get(3).toString());
						client.setExpiryDate(date);
						System.out.println();
						System.out.println("New client record created.");
						System.out.println();
						return client;

					} else {
						ExceptionManagement.invalidIdException(null);
						return null;
					}

				} else {
					ExceptionManagement.noSuchTypeException(null);
					return null;
				}

			}
			return client;
		} catch (Exception e) {
			System.err.println("Insufficient information provided.\n");
		}
		return null;

	}

	public Client foundClient(int cid) {
		Client client = null;
		for (int i = 0; i < clients.length; i++) {
			if (clients[i].getCid() == cid) {
				client = clients[i];
			}
		}
		return client;
	}

	public void amendAddress(int cid) {
	}

	public void extendExpiryDate(int cid) {
	}

	public boolean isExpired(int cid) {
		return false;
	}
}
