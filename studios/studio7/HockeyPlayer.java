package studio7;

public class HockeyPlayer {
	
	private String name;
	private int backNum;
	private int game, goal, assist;
	
	public HockeyPlayer(String name, int backNum) {
		this.name = name;
		this.backNum = backNum;
		this.game = 0;
		this.goal = 0;
		this.assist = 0;
	}
	
	/**
	 * 
	 * @return name
	 */
	public String getName() {
		return this.name;
	}

	/**
	 * 
	 * @return jersey number
	 */
	public int getBackNum() {
		return this.backNum;
	}

	/**
	 * 
	 * @return # of games played
	 */
	public int getGame() {
		return this.game;
	}
	
	/**
	 * 
	 * @return # of goals
	 */
	public int getGoal() {
		return this.goal;
	}
	
	/**
	 * 
	 * @return # of assists
	 */
	public int getAssist() {
		return this.assist;
	}
	
	/**
	 * 	
	 * @param g (goals scored)
	 * @param a (assists)
	 */
	public void game(int g, int a) {
		this.game++;
		this.goal = this.goal + g;
		this.assist = this.assist + a;
	}
	
	/**
	 * 
	 * @return points
	 */
	public int getPoint() {
		return this.goal + this.assist;
	}
	
}
