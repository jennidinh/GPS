import java.io.File;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;

public class Graph {

	private Hashtabell cities;

	public Graph() {

		cities = new Hashtabell(10);

	}

	public void generateGraph(String filename) {

		try {

			File file = new File(filename);

			Scanner scan = new Scanner(file);
			Edge edge;
			String from;
			String dest;
			int weight;

			while (scan.hasNext()) {

				from = scan.next();
				System.out.print(from);
				dest = scan.next();
				System.out.print(dest);

				weight = Integer.parseInt(scan.next());
				//System.out.println(weight);
				//System.out.println("innan addEdge");
				addEdge(from, dest, weight);
				//System.out.println("efter addEdge");

			}

		} catch (Exception e) {
			//System.out.println("i generate graph");
			System.out.println(e);
		}
		//System.out.println("klar");
	}

	public void add(String startCity, String destinationCity, int weight) {
		Node s = getNode(startCity);
		Node d = getNode(destinationCity);
		Edge e = new Edge(d, weight);
		addEdge(startCity, destinationCity, weight);

	}

	public void addEdge(String startCity, String destCity, int weight) {
		//System.out.println("innan");
		Node start = getNode(startCity);
		//System.out.println("start");
		Node dest = getNode(destCity);
		//System.out.println("dest");
		start.getPaths().add(new Edge(dest, weight));
		//System.out.println("edge");

	}

	public Node getNode(String name) {
		//System.out.println("innan find");
		Node node = cities.find(name);
		//System.out.println("efter find");
		if (node == null) {
			node = new Node(name);
			cities.add(node);
		}
		//System.out.println("innan return");
		return node;
	}

	public Path findShortestPath(String start, String dest) {
		resetAll();
		//System.out.println("start dijk");
		dijkstra(start);
		//System.out.println("efter metoden");
		Node destination = getNode(dest);
		int dist = destination.getCost();
		String path = getPath(destination);
		System.out.println(destination.getCity() + " är: " + destination.getCost());
		//System.out.println("slut dijk");
		Path p = new Path(path, dist);
		System.out.println("path: " + p.getPath());
		return p;
		
	}
	
	public void resetAll() {
		System.out.println("inne i resetall");
		HashItr itr = cities.iterator();
		while(itr.hasNext()) {
			System.out.println("2");
			LinkedList<Node> l = itr.next();
			Iterator<Node> litr = l.iterator();
			while(litr.hasNext()) {
				System.out.print("1");
				litr.next().reset();
			}
		}
		System.out.println("klar med resetall");
	}
	
	public String getPath(Node dest) {
		Node prev = dest.getPrev();
		if(prev == null) {
			return dest.getCity() + " " + dest.getCost();
		}
		return getPath(prev) + " " + dest.getCity() + " " + dest.getCost();
		
	}
	
	private void dijkstra(String start) {
		PriorityQueue<Node> pq = new PriorityQueue<Node>();
		Node startNode = getNode(start);
		startNode.setCost(0);
		int visitedNodes = 0;
		pq.add(startNode);
		while (visitedNodes < cities.size()) {
			Node currentNode = pq.remove();
			currentNode.setVisited(true);
			LinkedList<Edge> adj = currentNode.getPaths();
			System.out.println();
			System.out.println(currentNode.getCity() + " " + currentNode.getCost());
			for (int i = 0; i < adj.size(); i++) {
				Edge currentPath = adj.get(i);
				Node next = currentPath.getDestination();
				if (!next.isVisited()) {
					int cost = currentNode.getCost() + currentPath.getWeight();
					if (cost < next.getCost()) {
						next.setCost(cost);
						next.setPrev(currentNode);
						pq.add(next);
					}
					System.out.print(next.getCity()+ " " + next.getCost() + " ");

				}

			}
			
			visitedNodes++;
		}
	}

	public void findFastestPath() {

	}

}
