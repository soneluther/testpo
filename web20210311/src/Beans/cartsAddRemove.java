package Beans;

import java.util.ArrayList;


public class cartsAddRemove {
	private String submit=null;
	private String item=null;
	private ArrayList<String> list=new ArrayList<>();
			
	public void setSubmit(String name) {
		submit = name;
	}
	
	public void setItem(String name) {
		item = name;
	}	
	
	//add
	private void addItem(String name) {
		list.add(name);
	}
	
	//remove
	private void removeItem(String name) {
		list.remove(name);
	}
	
	//get listItem
	public String[] getItems() {
		String[] temp = null;
		temp = new String[list.size()];
		for (int i = 0; i < temp.length; i++)
			temp[i] = list.get(i);

		return temp;
	}
	
	public void processRequest() {
		/*
		if (submit == null)
			addItem(item);
		*/
		if (submit.equals("add"))
			addItem(item);
		else if (submit.equals("remove"))
			removeItem(item);

		// reset at the end of the request
		reset();
	}

	// reset
	private void reset() {
		submit = null;
		item = null;
	}
}
