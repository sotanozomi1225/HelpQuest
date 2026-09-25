import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner scn = new Scanner(System.in);

		System.out.println("親の名前を入力してください");
		String parentName = inputName(scn);
		Parent parent = new Parent(parentName);

		System.out.println();
		System.out.println("HelpQuestへようこそ、" + parent.getName() + "さん！");

		System.out.println();
		System.out.println("お子さんの名前を入力してください");
		String childName = inputName(scn);
		Child child = new Child(childName);

		System.out.println();
		System.out.println("お子さんの名前は" + child.getName() + "さんですね！");

		QuestManager questManager = new QuestManager();

		while (true) {

			System.out.println();
			System.out.println("===== HelpQuest =====");
			System.out.println();
			System.out.println("1. 親としてログイン");
			System.out.println();
			System.out.println("2. 子供としてログイン");
			System.out.println();
			System.out.println("3. 終了");
			System.out.println();
			System.out.println("=====================");
			System.out.println();
			System.out.println("番号を入力してください");

			String input = scn.nextLine().trim();

			if (input.equals("1")) {

				System.out.println();
				System.out.println("親としてログインしました。");

				parentMenu(scn, child, questManager);

			} else if (input.equals("2")) {

				System.out.println();
				System.out.println("子供としてログインしました。");

				childMenu(scn, child, questManager);

			} else if (input.equals("3")) {

				System.out.println();
				System.out.println("HelpQuestを終了します。");

				break;

			} else {

				System.out.println();
				System.out.println("1～3の番号を入力してください。");
			}
		}

		scn.close();
	}

	private static String inputName(Scanner scn) {

		while (true) {

			String name = scn.nextLine().trim();

			if (name.isEmpty()) {

				System.out.println("名前を入力してください");

			} else if (name.contains(",")) {

				System.out.println("名前に「,」は使用できません。");

			} else {

				return name;
			}
		}
	}

	private static void parentMenu(
			Scanner scn,
			Child child,
			QuestManager questManager) {

		while (true) {

			System.out.println();
			System.out.println("===== 親メニュー =====");
			System.out.println();
			System.out.println("1. クエストを登録");
			System.out.println();
			System.out.println("2. クエスト一覧");
			System.out.println();
			System.out.println("3. クエストを更新");
			System.out.println();
			System.out.println("4. クエストを削除");
			System.out.println();
			System.out.println("5. 子供のステータスを見る");
			System.out.println();
			System.out.println("6. ログアウト");
			System.out.println();
			System.out.println("=====================");
			System.out.println();
			System.out.println("番号を入力してください");

			String input = scn.nextLine().trim();

			if (input.equals("1")) {

				questManager.addQuest(scn);

			} else if (input.equals("2")) {

				questManager.showQuests();

			} else if (input.equals("3")) {

				questManager.updateQuest(scn);

			} else if (input.equals("4")) {

				questManager.deleteQuest(scn);

			} else if (input.equals("5")) {

				child.showStatus();

			} else if (input.equals("6")) {

				System.out.println();
				System.out.println("ログアウトしました。");
				return;

			} else {

				System.out.println();
				System.out.println("1～6の番号を入力してください。");
			}
		}
	}

	private static void childMenu(
			Scanner scn,
			Child child,
			QuestManager questManager) {

		while (true) {

			System.out.println();
			System.out.println("===== 子供メニュー =====");
			System.out.println();
			System.out.println("1. クエスト一覧");
			System.out.println();
			System.out.println("2. クエストを完了");
			System.out.println();
			System.out.println("3. 自分のステータスを見る");
			System.out.println();
			System.out.println("4. ログアウト");
			System.out.println();
			System.out.println("=======================");
			System.out.println();
			System.out.println("番号を入力してください");

			String input = scn.nextLine().trim();

			if (input.equals("1")) {

				questManager.showQuests();

			} else if (input.equals("2")) {

				Quest quest = questManager.completeQuest(scn);

				if (quest != null) {

					child.addXp(10);
					child.addMoney(quest.getReward());

					System.out.println();
					System.out.println("クエストを完了しました！");
					System.out.println();
					System.out.println("獲得XP：10 XP");
					System.out.println(
							"獲得お小遣い：" + quest.getReward() + " 円");
				}

			} else if (input.equals("3")) {

				child.showStatus();

			} else if (input.equals("4")) {

				System.out.println();
				System.out.println("ログアウトしました。");
				return;

			} else {

				System.out.println();
				System.out.println("1～4の番号を入力してください。");
			}
		}
	}
}