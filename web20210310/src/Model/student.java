package Model;

public class student {
	private String name;
	private Integer age;
	
	public student() {
		super();
		// TODO Auto-generated constructor stub
	}
	public student(String name, Integer age) {
		super();
		this.name = name;
		this.age = age;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	
	public String toString() {
		return name+"->"+age;
	}
}
