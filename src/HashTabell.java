import java.util.LinkedList;

public class HashTabell {

	LinkedList<Node>[] arr;

	public HashTabell(int size) {
		arr = new LinkedList[size];

	}

	public void add(Node n) {

		int hash = n.getCity().hashCode() % arr.length;
		arr[hash].add(n);

	}

	public Node find(String name) {

		int hash = name.hashCode() % arr.length;
		for(int i = 0; i < arr[hash].size(); i++) {
			if(arr[hash].get(i).getCity().equals(name)) {
				return arr[hash].get(i);
			}
		}
		return null;

	}
}
