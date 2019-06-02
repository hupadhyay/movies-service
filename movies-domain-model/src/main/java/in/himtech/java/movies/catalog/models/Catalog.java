package in.himtech.java.movies.catalog.models;

public class Catalog {

	private String name;
	
	private String desc;
	
	private Integer rate;

	public Catalog() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Catalog(String name, String desc, Integer rate) {
		super();
		this.name = name;
		this.desc = desc;
		this.rate = rate;
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

	public Integer getRate() {
		return rate;
	}

	public void setRate(Integer rate) {
		this.rate = rate;
	}

	@Override
	public String toString() {
		return String.format("Catalog [name=%s, desc=%s, rate=%s]", name, desc, rate);
	}
	
	
}
