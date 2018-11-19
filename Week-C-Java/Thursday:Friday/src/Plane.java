public class Plane extends vehicle {

	public Plane() {
		super();  // calls the superclass constructor, implicitly added if not included.
	}
	public Plane(String type, String color) {
		this.type = type;
		this.color = color;
	}

	private String type;
	private String color;

	public String getType() {
		return this.type;

	}

	public String getColor(){
		return this.color;
	}

	public void setType() {
		this.type = type;
	}

	public void setColor() {
		this.color = color;
	}

	@Override
	public void move() {
		System.out.println("Plane is accelerating");
	}
}