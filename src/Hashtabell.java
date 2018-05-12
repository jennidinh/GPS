import java.util.LinkedList;

public class Hashtabell {

	LinkedList<Node>[] arr;
	int size;

	public Hashtabell(int size) {
		arr = new LinkedList[size];
		for(int i = 0; i < size; i++) {
			arr[i] = new LinkedList<Node>();
		}
		this.size = 0;

	}

	public void add(Node n) {

		int hash = n.getCity().hashCode() % arr.length;
		hash = Math.abs(hash);
		arr[hash].add(n);
		size++;

	}

	public Node find(String name) {

		int hash = name.hashCode() % arr.length;
		hash = Math.abs(hash);
		for(int i = 0; i < arr[hash].size(); i++) {
			if(arr[hash].get(i).getCity().equals(name)) {
				return arr[hash].get(i);
			}
		}
		return null;

	}
	
	public int size() {
		return size;
	}
	
	public HashItr iterator() {
		
		return new HashItr(arr);
	}
	
	
}
