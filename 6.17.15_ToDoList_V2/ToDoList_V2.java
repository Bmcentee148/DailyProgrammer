import java.util.ArrayList;
import java.util.List;

public class ToDoList_V2 {

	private List<String> categories;
	private List<ArrayList<String>> masterList;

	public ToDoList_V2() {
		masterList = new ArrayList<ArrayList<String>>();
		categories = new ArrayList<String>();
	}

	public void addItem(String item, String category) {
		category = category.trim();
		item = item.trim();
		if(categories.contains(category)) {
			int catIndex = categories.indexOf(category);
			masterList.get(catIndex).add(item);
		}
		else {
			categories.add(category);
			ArrayList<String> newList = new ArrayList<String>();
			newList.add(item);
			masterList.add(newList);
		}
	}

	public boolean deleteItem(String item, String category) {
		boolean status = true;
		category = category.trim();
		if(categories.contains(category)) {
			int catIndex = categories.indexOf(category);
			masterList.get(catIndex).remove(item);
		}
		else {
			status = false;
		}
		return status;
	}

	public void viewList(String category) {
		category = category.trim();
		if(categories.contains(category)) {
			int catIndex = categories.indexOf(category);
			ArrayList<String> catList = masterList.get(catIndex);
			String[] listItems = catList.toArray(new String[catList.size()]);
			printItems(listItems);
		}
		else {
			System.out.println("No such list found.");
		}
	}

	public void viewList(String... categories) {
		ArrayList<String> items = new ArrayList<String>();
		for(int i = 0; i < categories.length; i++) {
			String currCategory = categories[i];
			if(this.categories.contains(currCategory)) {
				int catIndex = this.categories.indexOf(currCategory);
				copyItems(masterList.get(catIndex),items);				
			}
		}
		getIntersection(items,categories.length);
		for(String item : items) {
			System.out.println(item);
		}
	}

	private void getIntersection(ArrayList<String> listItems, int freq) {
		for(String currItem : listItems) {
			for(int i = 0; i < freq - 1; i++) {
				listItems.remove(currItem);
			}
		}
	}
	private void copyItems(ArrayList<String> from, ArrayList<String> to) {
		for(String s : from) {
			to.add(s);
		}
	}

	private void printItems(String[] items) {
		for(int i = 0; i < items.length; i++) {
			System.out.println(items[i]);
		}
	}


	public static void main(String[] args) {
		ToDoList_V2 test = new ToDoList_V2();
		test.addItem("Read Code", "Programming");
		test.addItem("Debug this software","Programming");
		test.viewList("Programming");

		test.addItem("Read Code", "Books");
		test.addItem("Review Personal MBA","Books");
		test.viewList("Books");

		test.viewList("Read Code", "Books");
	}
}