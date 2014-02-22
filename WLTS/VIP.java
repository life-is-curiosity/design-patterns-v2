package WLTS;

public class VIP extends Client {

	@Override
	public boolean validate(int cid) {
		int sum = 0;
		String digits = Integer.toString(cid);
		try {
			if (cid > 300000000) {
				if (digits.length() == 9) {
					for (int i = 0; i < digits.length(); i++) {
						sum += Integer.parseInt(Character.toString(digits
								.charAt(i)));
					}
					if (sum % 6 == 0) {
						return true;
					} else {
						return false;
					}
				} else {
					return false;
				}
			} else {
				return false;
			}
		} catch (Exception e) {
			return false;
		}
	}

}
