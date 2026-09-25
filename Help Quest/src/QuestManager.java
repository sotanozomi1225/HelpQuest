import java.util.ArrayList;
import java.util.Scanner;

public class QuestManager {

	private ArrayList<Quest> quests;

	public QuestManager() {
		quests = new ArrayList<>();
	}

	public void addQuest(Scanner scn) {

		System.out.println();
		System.out.println("===== クエスト登録 =====");
		System.out.println();

		System.out.println("クエスト名を入力してください");
		String name = inputQuestName(scn);

		System.out.println();
		System.out.println("お小遣いの金額を入力してください");
		int reward = inputNonNegativeNumber(scn);

		Quest quest = new Quest(name, reward);
		quests.add(quest);

		System.out.println();
		System.out.println("クエストを登録しました。");
	}

	public void showQuests() {

		System.out.println();
		System.out.println("===== クエスト一覧 =====");
		System.out.println();

		if (quests.isEmpty()) {

			System.out.println("クエストは登録されていません。");
			return;
		}

		for (int i = 0; i < quests.size(); i++) {

			Quest quest = quests.get(i);

			String name = quest.getName();
			int reward = quest.getReward();

			System.out.println((i + 1) + ". " + name);
			System.out.println("   報酬：" + reward + " 円");

			if (quest.isCompleted()) {

				System.out.println("   状態：完了");

			} else {

				System.out.println("   状態：未完了");
			}

			System.out.println();
		}
	}

	public void updateQuest(Scanner scn) {

		if (quests.isEmpty()) {

			System.out.println();
			System.out.println("更新できるクエストがありません。");
			return;
		}

		showQuests();

		System.out.println();
		System.out.println("更新するクエストの番号を入力してください");

		int number = inputNumber(scn);

		if (number < 1 || number > quests.size()) {

			System.out.println();
			System.out.println("正しい番号を入力してください。");
			return;
		}

		Quest quest = quests.get(number - 1);

		System.out.println();
		System.out.println("新しいクエスト名を入力してください");

		String name = inputQuestName(scn);

		System.out.println();
		System.out.println("新しいお小遣いの金額を入力してください");

		int reward = inputNonNegativeNumber(scn);

		quest.setName(name);
		quest.setReward(reward);

		System.out.println();
		System.out.println("クエストを更新しました。");
	}

	public Quest completeQuest(Scanner scn) {

		if (quests.isEmpty()) {

			System.out.println();
			System.out.println("クエストは登録されていません。");
			return null;
		}

		showQuests();

		System.out.println();
		System.out.println("完了するクエストの番号を入力してください");

		int number = inputNumber(scn);

		if (number < 1 || number > quests.size()) {

			System.out.println();
			System.out.println("正しい番号を入力してください。");
			return null;
		}

		Quest quest = quests.get(number - 1);

		if (quest.isCompleted()) {

			System.out.println();
			System.out.println("このクエストはすでに完了しています。");
			return null;
		}

		quest.complete();

		return quest;
	}

	public void deleteQuest(Scanner scn) {

		if (quests.isEmpty()) {

			System.out.println();
			System.out.println("削除できるクエストがありません。");
			return;
		}

		showQuests();

		System.out.println();
		System.out.println("削除するクエストの番号を入力してください");

		int number = inputNumber(scn);

		if (number < 1 || number > quests.size()) {

			System.out.println();
			System.out.println("正しい番号を入力してください。");
			return;
		}

		Quest removedQuest = quests.remove(number - 1);

		System.out.println();
		System.out.println(
				"「" + removedQuest.getName() + "」を削除しました。");
	}

	private String inputQuestName(Scanner scn) {

		while (true) {

			String name = scn.nextLine().trim();

			if (name.isEmpty()) {

				System.out.println("クエスト名を入力してください");

			} else if (name.contains(",")) {

				System.out.println(
						"クエスト名に「,」は使用できません。");

			} else {

				return name;
			}
		}
	}

	private int inputNumber(Scanner scn) {

		while (true) {

			String input = scn.nextLine().trim();

			try {

				return Integer.parseInt(input);

			} catch (NumberFormatException e) {

				System.out.println();
				System.out.println(
						"半角数字を入力してください。");
			}
		}
	}

	private int inputNonNegativeNumber(Scanner scn) {

		while (true) {

			int number = inputNumber(scn);

			if (number < 0) {

				System.out.println();
				System.out.println(
						"0以上の数字を入力してください。");

			} else {

				return number;
			}
		}
	}
}