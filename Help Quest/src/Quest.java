public class Quest {

	private String name;
	private int reward;
	private boolean completed;

	public Quest(String name, int reward) {
		this.name = name;
		this.reward = reward;
		completed = false;
	}

	public Quest(String name, int reward, boolean completed) {
		this.name = name;
		this.reward = reward;
		this.completed = completed;
	}

	public String getName() {
		return name;
	}

	public int getReward() {
		return reward;
	}

	public boolean isCompleted() {
		return completed;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setReward(int reward) {
		this.reward = reward;
	}

	public void complete() {
		completed = true;
	}
}