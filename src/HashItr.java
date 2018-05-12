import java.util.LinkedList;

class HashItr{
		LinkedList<Node> []arr;
		int next;
		
		public HashItr(LinkedList<Node>[] arr) {
			this.arr = arr;
			next = 0;
		}
		
		public LinkedList<Node> next() {
			return arr[next++];
		}
		
		public boolean hasNext() {
			return next < arr.length;
		}
		
		
	}
