package in.himtech.java.movies.models;

public class Rating {

	private String name;

	private Integer rate;

	public Rating() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Rating(String name, Integer rate) {
		super();
		this.name = name;
		this.rate = rate;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getRate() {
		return rate;
	}

	public void setRate(Integer rate) {
		this.rate = rate;
	}

	@Override
	public String toString() {
		return String.format("Rating [name=%s, rate=%s]", name, rate);
	}

}
