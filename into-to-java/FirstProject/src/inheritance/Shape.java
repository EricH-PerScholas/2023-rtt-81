package inheritance;

public abstract class Shape implements Area {

	private String name;

	public String getName() {
		return name;
	}

	public final void setName(String name) {
		this.name = name;
	}
	
	abstract public double calculateParimiter();

}
