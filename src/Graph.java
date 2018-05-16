import java.io.File;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Graph {
	private static final int DISTANCE = 0;
	private static final int TIME = 1;
	private Hashtabell cities;

	public Graph() {

		cities = new Hashtabell(100);

	}

	public void generateGraph(String filename) {

		try {

			File file = new File(filename);

			Scanner scan = new Scanner(file);
			Edge edge;
			String from;
			String dest;
			int weight;
			double vel;
			double time;

			while (scan.hasNext()) {

				from = scan.next().toLowerCase();
				dest = scan.next().toLowerCase();
				weight = Integer.parseInt(scan.next());
				vel = Double.parseDouble(scan.next());
				time = weight / vel;
				addEdge(from, dest, weight, time);

			}

		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public void add(String startCity, String destinationCity, int weight, double time) {
		Node s = getNode(startCity);
		Node d = getNode(destinationCity);
		Edge e = new Edge(d, weight, time);
		addEdge(startCity, destinationCity, weight, time);

	}

	public void addEdge(String startCity, String destCity, int weight, double time) {
		Node start = getNode(startCity);
		Node dest = getNode(destCity);
		start.getPaths().add(new Edge(dest, weight, time));

	}

	public Node getNode(String name) {
		Node node = cities.find(name);
		if (node == null) {
			node = new Node(name);
			cities.add(node);
		}
		return node;
	}

	public Path findShortestPath(String start, String dest) {
		if(cities.find(start) == null || cities.find(dest) == null) {
			throw new NoSuchElementException();
		}
		resetAll();
		dijkstra(start, DISTANCE);
		Node destination = getNode(dest);
		int dist = destination.getCost();
		String path = getPath(destination);
		double time = destination.getTime();
		Path p = new Path(path, dist, time);
		return p;

	}

	public void resetAll() {
		HashItr itr = cities.iterator();
		while (itr.hasNext()) {
			LinkedList<Node> l = itr.next();
			Iterator<Node> litr = l.iterator();
			while (litr.hasNext()) {
				litr.next().reset();
			}
		}
	}

	public String getPath(Node dest) {
		Node prev = dest.getPrev();
		if (prev == null) {
			return dest.getCity() + " ";
		}
		return getPath(prev) + " " + dest.getCity() + " ";

	}

	private void dijkstra(String start, int var) {
		PriorityQueue<Node> pq;
		if (var == DISTANCE) {
			pq = new PriorityQueue<Node>(new DistComparator());
		} else if (var == TIME) {

			pq = new PriorityQueue<Node>(new TimeComparator());
		} else {
			return;
		}
		Node startNode = getNode(start);
		startNode.setCost(0);
		startNode.setTime(0);
		int visitedNodes = 0;
		pq.add(startNode);
		while (visitedNodes < cities.size()) {
			visitedNodes++;
			Node currentNode = pq.remove();
			LinkedList<Edge> adj = currentNode.getPaths();

			if (!currentNode.isVisited()) {

				currentNode.setVisited(true);
				for (int i = 0; i < adj.size(); i++) {
					Edge currentPath = adj.get(i);
					Node next = currentPath.getDestination();
					int cost = currentNode.getCost() + currentPath.getDistance();
					double costTime = currentNode.getTime() + currentPath.getTime();

					if (var == DISTANCE) {
						if (cost < next.getCost()) {
							next.setCost(cost);
							next.setTime(costTime);
							next.setPrev(currentNode);
							pq.add(next);
						}
					} else { // var == time
						if (costTime < next.getTime()) {
							next.setTime(costTime);
							next.setCost(cost);
							next.setPrev(currentNode);
							pq.add(next);
						}
					}

				}

			}
		}
	}

	public Path findFastestPath(String start, String dest) {
		resetAll();
		dijkstra(start, TIME);
		Node destination = getNode(dest);
		int dist = destination.getCost();
		String path = getPath(destination);
		double time = destination.getTime();
		Path p = new Path(path, dist, time);
		return p;
	}

}
