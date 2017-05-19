package xdwang.aequilibrium.transformer;

/**
 * @author mwang The IllegalArgumentException is temporary used here. May change
 *         some of them into checked exception in the future.
 * 
 */
public class Transformer implements Fighter {
	public static final String TEAM_AUTOBOT = "Autobots";
	public static final String TEAM_DECEPTION = "Decepticons";
	public static final String SUPER_OPTIMUS_PRIME = "Optimus Prime";
	public static final String SUPER_PREDAKING = "Predaking";

	private String teamName;
	private String name;
	private int strength;
	private int intelligence;
	private int speed;
	private int endurance;
	private int rank;
	private int courage;
	private int firepower;
	private int skill;

	public Transformer(Builder builder) {
		this.teamName = builder.teamName;
		this.name = builder.name;
		this.strength = builder.strength;
		this.intelligence = builder.intelligence;
		this.speed = builder.speed;
		this.endurance = builder.endurance;
		this.rank = builder.rank;
		this.courage = builder.courage;
		this.firepower = builder.firepower;
		this.skill = builder.skill;

	}

	public int getStrength() {
		return strength;
	}

	public int getIntelligence() {
		return intelligence;
	}

	public int getSpeed() {
		return speed;
	}

	public int getEndurance() {
		return endurance;
	}

	public int getRank() {
		return rank;
	}

	public int getCourage() {
		return courage;
	}

	public int getFirepower() {
		return firepower;
	}

	public int getSkill() {
		return skill;
	}

	@Override
	public String toString() {
		return "Transformer [teamName=" + teamName + ", name=" + name + ", strength=" + strength + ", intelligence="
				+ intelligence + ", speed=" + speed + ", endurance=" + endurance + ", rank=" + rank + ", courage="
				+ courage + ", firepower=" + firepower + ", skill=" + skill + "]";
	}

	public static class Builder {
		private String teamName;
		private String name;
		private int strength;
		private int intelligence;
		private int speed;
		private int endurance;
		private int rank;
		private int courage;
		private int firepower;
		private int skill;

		public Builder(String teamName, String name) {
			if (Transformer.TEAM_AUTOBOT.equals(teamName) || Transformer.TEAM_DECEPTION.equals(teamName))
				this.teamName = teamName;
			if (name != null && name.trim().length() > 0)
				this.name = name.trim();
			if (this.teamName == null || this.name == null)
				throw new IllegalArgumentException("wrong team name or name...");
		}

		public Builder strength(int x) {
			if (x >= 1 && x <= 10)
				this.strength = x;
			else
				throw new IllegalArgumentException("wrong attribute value range...");
			return this;
		}

		public Builder intelligence(int x) {
			if (x >= 1 && x <= 10)
				this.intelligence = x;
			else
				throw new IllegalArgumentException("wrong attribute value range...");
			return this;
		}

		public Builder speed(int x) {
			if (x >= 1 && x <= 10)
				this.speed = x;
			else
				throw new IllegalArgumentException("wrong attribute value range...");
			return this;
		}

		public Builder endurance(int x) {
			if (x >= 1 && x <= 10)
				this.endurance = x;
			else
				throw new IllegalArgumentException("wrong attribute value range...");
			return this;
		}

		public Builder rank(int x) {
			if (x >= 1 && x <= 10)
				this.rank = x;
			else
				throw new IllegalArgumentException("wrong attribute value range...");
			return this;
		}

		public Builder courage(int x) {
			if (x >= 1 && x <= 10)
				this.courage = x;
			else
				throw new IllegalArgumentException("wrong attribute value range...");
			return this;
		}

		public Builder firepower(int x) {
			if (x >= 1 && x <= 10)
				this.firepower = x;
			else
				throw new IllegalArgumentException("wrong attribute value range...");
			return this;
		}

		public Builder skill(int x) {
			if (x >= 1 && x <= 10)
				this.skill = x;
			else
				throw new IllegalArgumentException("wrong attribute value range...");
			return this;
		}

		public Transformer build() {
			return new Transformer(this);
		}

	}

	public int getOverallRating() {
		return strength + intelligence + speed + endurance + firepower;
	}

	private int fight(Transformer that) {
		if (this.isSuper() && !that.isSuper())
			return 1;
		if (!this.isSuper() && that.isSuper())
			return -1;
		if (this.isSuper() && that.isSuper())
			return 0;
		if (this.courage - that.courage >= 4 && this.strength - that.strength >= 3)
			return 1;
		if (this.courage - that.courage <= -4 && this.strength - that.strength <= -3)
			return -1;
		if (this.skill - that.getSkill() >= 3)
			return 1;
		if (this.skill - that.getSkill() <= -3)
			return -1;
		return (this.getOverallRating() - that.getOverallRating());
	}

	@Override
	public String getTeamName() {
		return teamName;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public boolean isSuper() {
		if (SUPER_OPTIMUS_PRIME.equals(this.name) || SUPER_PREDAKING.equals(this.name))
			return true;
		else
			return false;
	}

	@Override
	public int fight(Fighter fighter) {
		if (fighter instanceof Transformer)
			return fight((Transformer) fighter);
		else
			return 0;
	}

}
