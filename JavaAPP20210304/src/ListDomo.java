import java.util.ArrayList;
import java.util.List;

public class ListDomo {

	public static void main(String[] args) {
		List<MyDate> mydate=new ArrayList<>();
		
		mydate.add(new MyDate(2));
		mydate.add(new MyDate(1));
		mydate.add(new MyDate(4));
		
		//mydate.indexOf(2);
		System.out.println(mydate.indexOf(new MyDate(2)));
		System.out.println(mydate.indexOf(new MyDate(1)));
		System.out.println(mydate.indexOf(new MyDate(4)));
	}

}

class MyDate{
	private Integer mydate;

	public Integer getMydate() {
		return mydate;
	}

	public void setMydate(Integer mydate) {
		this.mydate = mydate;
	}

	public MyDate(Integer mydate) {
		super();
		this.mydate = mydate;
	}
	
	public String toString() {
		return "mydate="+mydate;
	}
	
	@Override
	public boolean equals(Object o) {
		MyDate MyDate=(MyDate) o;
		return this.mydate==MyDate.mydate;
	}
}