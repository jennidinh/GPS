import java.util.LinkedList;

public class Hashtabell {

	private LinkedList<Node>[] arr;
	private int size;

	/**
	 * creats a hashtable with size size.
	 * @param size the size of the hashtable.
	 */
	public Hashtabell(int size) {
		arr = new LinkedList[size];
		for(int i = 0; i < size; i++) {
			arr[i] = new LinkedList<Node>();
		}
		this.size = 0;

	}

	/**
	 * adds a node to the hashtable.
	 * @param n the node. 
	 */
	public void add(Node n) {

		int hash = n.getCity().hashCode() % arr.length;
		hash = Math.abs(hash);
		arr[hash].add(n);
		size++;

	}

	/**
	 * finds the name of the city in the hashtable.
	 * @param name name of the city.
	 * @return a node with the specified name. returns null if it's not found.
	 */
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
	
	/**
	 * returns the new size of the hashtable.
	 * @return return size.
	 */
	public int size() {
		return size;
	}
	
	/**
	 * @return iterator.
	 */
	public HashItr iterator() {
		
		return new HashItr(arr);
	}
	
	
}
