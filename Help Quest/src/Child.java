public class Child {

	private String name;
	private int xp;
	private int money;

	public Child(String name) {
		this.name = name;
		xp = 0;
		money = 0;
	}

	public Child(String name, int xp, int money) {
		this.name = name;
		this.xp = xp;
		this.money = money;
	}

	public String getName() {
		return name;
	}

	public int getXp() {
		return xp;
	}

	public int getMoney() {
		return money;
	}

	public void addXp(int amount) {
		xp += amount;
	}

	public void addMoney(int amount) {
		money += amount;
	}

	public void showStatus() {

		int level = (xp / 100) + 1;

		System.out.println();
		System.out.println("===== 子供のステータス =====");
		System.out.println();
		System.out.println("名前：" + name);
		System.out.println();
		System.out.println("レベル：" + level);
		System.out.println();
		System.out.println("経験値：" + xp + " XP");
		System.out.println();
		System.out.println("お小遣い：" + money + " 円");
		System.out.println();
		System.out.println("============================");
	}
}