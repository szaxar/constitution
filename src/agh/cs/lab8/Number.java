package agh.cs.lab8;

public class Number {
	private int nr;

	public Number(int nr) {
		this.nr = nr;
	}

	public String get() {
		if (nr == 1)
			return "I";
		if (nr == 2)
			return "II";
		if (nr == 3)
			return "III";
		if (nr == 4)
			return "IV";
		if (nr == 5)
			return "V";
		if (nr == 6)
			return "VI";
		if (nr == 7)
			return "VII";
		if (nr == 8)
			return "VIII";
		if (nr == 9)
			return "IX";
		if (nr == 10)
			return "X";
		if (nr == 11)
			return "XI";
		if (nr == 12)
			return "XII";
		if (nr == 13)
			return "XIII";

		return "";

	}
}
