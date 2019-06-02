package in.himtech.java.movies.info.models;

public class Movies {
	
	private String name;
	
	private String desc;

	public Movies() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Movies(String name, String desc) {
		super();
		this.name = name;
		this.desc = desc;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	@Override
	public String toString() {
		return String.format("Movies [name=%s, desc=%s]", name, desc);
	}
}
