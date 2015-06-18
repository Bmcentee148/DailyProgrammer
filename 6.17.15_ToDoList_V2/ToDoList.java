import java.util.ArrayList;
import java.util.List;

public class ToDoList {

	private List<String> agenda;

	public ToDoList() {
		agenda = new ArrayList<String>();
	}

	public void addItem(String newItem) {
		agenda.add(newItem);
	}

	public void deleteItem(String item) {
		boolean status = agenda.remove(item);
		if(!status) {
			System.out.println("Item does not exist");
		}
	}

	public void viewList() {
		for(Object item : agenda) {
			System.out.println(item);
		}
	}

	public static void main(String[] args) {
		ToDoList testList = new ToDoList();

		testList.addItem("Take a shower");
		testList.addItem("Go to Work");
		testList.viewList();

		testList.addItem("Buy a new phone");
		testList.deleteItem("Go to Work");
		testList.viewList();
	} 
}