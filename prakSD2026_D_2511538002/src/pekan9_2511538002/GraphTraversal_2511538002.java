package pekan9_2511538002; 
import java.util.*;

public class GraphTraversal_2511538002 { 
	private Map<String, List<String>> graph = new HashMap<>();
	
	//meanmbakan edge
	public void addEdge (String node1, String node2) {
		graph.putIfAbsent(node1, new ArrayList<>()); 
		graph.putIfAbsent(node2, new ArrayList<>());
		graph.get(node1).add(node2);
		graph.get(node2).add(node1);
	}
	// menampilkan graf awal
	public void printGraph() { 
		System.out.println("graf awal (adjacency list):");
		for (String node_8002 : graph.keySet()) { 
			System.out.print(node_8002 + "->");
			List<String> neighbors = graph.get(node_8002);
			System.out.println(String.join(", ", neighbors));
		}
		System.out.println();
			
		}
	//DFS rekrusif
	public void dfs(String Start) { 
		Set<String> visited = new HashSet<>();
		System.out.println("penelusuran DFS: ");
		dfsHelper(Start, visited);
		System.out.println();
	}
	private void dfsHelper (String current, Set<String> visited) {
	if (visited.contains(current)) return;
	visited.add(current);
	System.out.print(current + " "); 
	for (String neighbor : graph.getOrDefault(current, new ArrayList<>())) {
		dfsHelper(neighbor, visited);
	}
	}

	// bfs public iteratif 
	public void bfs(String start) { 
		Set<String> visited = new HashSet<>();
		Queue<String> queue = new LinkedList<>();
		queue.add(start);
		visited.add(start);
		System.out.println("Penelusuran BFS: ");
		while (!queue.isEmpty()) {
			String current = queue.poll();
			System.out.print(current + " ");
			for (String neighbor : graph.getOrDefault(current, new ArrayList<>())) {
				if(!visited.contains(neighbor)) {
					queue.add(neighbor);
					visited.add(neighbor);
				}
			}
		} 
		System.out.println();
	} 
	// main
	public static void main(String[] args) { 
		GraphTraversal_2511538002 graph = new GraphTraversal_2511538002(); 
		// contoh.addEdge(A-B....
		graph.addEdge("A", "B");
		graph.addEdge ("A", "C");
		graph.addEdge ("B", "D");
		graph.addEdge ("B", "E"); 
		//cetak graf awal
		System.out.println("Graf awal adalah: ");
		graph.printGraph();
		
		// lakukann penelusuran
		graph.dfs("A");
		graph.bfs("A");
	}
}
