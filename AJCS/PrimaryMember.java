package AJCS;

import Tools.ExceptionManagement;

public class PrimaryMember extends Member {

	@Override
	public boolean validate(String id) {

		int sum = 0;
		try {
			if (id.length() == 8) {
				for (int i = 0; i < id.length(); i++) {
					sum += Integer.parseInt(Character.toString(id.charAt(i)));
				}
				if (sum % 3 == 0) {
					return true;
				} else {
					return false;
				}
			} else {
				return false;
			}

		} catch (Exception e) {
			ExceptionManagement.invalidIdException(e);
			return false;
		}
	}
}
