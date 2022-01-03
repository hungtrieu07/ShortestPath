import java.util.Random;
// A Java program for Bellman-Ford's single source shortest path
// algorithm.

// A class to represent a connected, directed and weighted graph
class BellmanFord {
	// A class to represent a weighted edge in graph
	class Edge {
		int src, dest, weight;
		Edge()
		{
			src = dest = weight = 0;
		}
	};

	int V, E;
	Edge edge[];

	// Creates a graph with V vertices and E edges
	BellmanFord(int v, int e)
	{
		V = v;
		E = e;
		edge = new Edge[e];
		for (int i = 0; i < e; ++i)
			edge[i] = new Edge();
	}

	// The main function that finds shortest distances from src
	// to all other vertices using Bellman-Ford algorithm. The
	// function also detects negative weight cycle
	void BellmanFord(BellmanFord graph, int src)
	{
		int V = graph.V, E = graph.E;
		int dist[] = new int[V];

		// Step 1: Initialize distances from src to all other
		// vertices as INFINITE
		for (int i = 0; i < V; ++i)
			dist[i] = Integer.MAX_VALUE;
		dist[src] = 0;

		// Step 2: Relax all edges |V| - 1 times. A simple
		// shortest path from src to any other vertex can
		// have at-most |V| - 1 edges
		for (int i = 1; i < V; ++i) {
			for (int j = 0; j < E; ++j) {
				int u = graph.edge[j].src;
				int v = graph.edge[j].dest;
				int weight = graph.edge[j].weight;
				if (dist[u] != Integer.MAX_VALUE && dist[u] + weight < dist[v])
					dist[v] = dist[u] + weight;
			}
		}

		// Step 3: check for negative-weight cycles. The above
		// step guarantees shortest distances if graph doesn't
		// contain negative weight cycle. If we get a shorter
		// path, then there is a cycle.
		for (int j = 0; j < E; ++j) {
			int u = graph.edge[j].src;
			int v = graph.edge[j].dest;
			int weight = graph.edge[j].weight;
			if (dist[u] != Integer.MAX_VALUE && dist[u] + weight < dist[v]) {
				System.out.println("Graph contains negative weight cycle");
				return;
			}
		}
		printArr(dist, V);
	}

	// A utility function used to print the solution
	void printArr(int dist[], int V)
	{
		System.out.println("Vertex\t\tDistance from Source");
		for (int i = 0; i < V; ++i)
			System.out.println(i + "\t\t" + dist[i]);
	}

	// Driver method to test above function
	public static void main(String[] args)
	{
		int V = 5; // Number of vertices in graph
		int E = 10; // Number of edges in graph
		double total = 0;
		double average = 0;

		Random random = new Random();

		BellmanFord graph = new BellmanFord(V, E);

		//1
		graph.edge[0].src = 0;
		graph.edge[0].dest = 1;
		graph.edge[0].weight = random.nextInt((9+9)-9);
		//2
		graph.edge[1].src = 0;
		graph.edge[1].dest = 2;
		graph.edge[1].weight = random.nextInt((9+9)-9);
		//3
		graph.edge[2].src = 0;
		graph.edge[2].dest = 3;
		graph.edge[2].weight = random.nextInt((9+9)-9);
		//4
		graph.edge[3].src = 0;
		graph.edge[3].dest = 4;
		graph.edge[3].weight = random.nextInt((9+9)-9);
		//5
		graph.edge[4].src = 1;
		graph.edge[4].dest = 2;
		graph.edge[4].weight = random.nextInt((9+9)-9);
		//6
		graph.edge[5].src = 1;
		graph.edge[5].dest = 3;
		graph.edge[5].weight = random.nextInt((9+9)-9);
		//7
		graph.edge[6].src = 1;
		graph.edge[6].dest = 4;
		graph.edge[6].weight = random.nextInt((9+9)-9);
		//8
		graph.edge[7].src = 2;
		graph.edge[7].dest = 3;
		graph.edge[7].weight = random.nextInt((9+9)-9);
		//9
		graph.edge[8].src = 2;
		graph.edge[8].dest = 4;
		graph.edge[8].weight = random.nextInt((9+9)-9);
		//10
		graph.edge[9].src = 3;
		graph.edge[9].dest = 4;
		graph.edge[9].weight = random.nextInt((9+9)-9);
		//11
		graph.edge[10].src = 0;
		graph.edge[10].dest = 1;
		graph.edge[10].weight = random.nextInt((9+9)-9);
		//12
		graph.edge[11].src = 0;
		graph.edge[11].dest = 1;
		graph.edge[11].weight = random.nextInt((9+9)-9);
		//13
		graph.edge[12].src = 0;
		graph.edge[12].dest = 1;
		graph.edge[12].weight = random.nextInt((9+9)-9);
		//14
		graph.edge[13].src = 0;
		graph.edge[13].dest = 1;
		graph.edge[13].weight = random.nextInt((9+9)-9);
		//15
		graph.edge[14].src = 0;
		graph.edge[14].dest = 1;
		graph.edge[14].weight = random.nextInt((9+9)-9);
		//16
		graph.edge[15].src = 0;
		graph.edge[15].dest = 1;
		graph.edge[15].weight = random.nextInt((9+9)-9);
		//17
		graph.edge[16].src = 0;
		graph.edge[16].dest = 1;
		graph.edge[16].weight = random.nextInt((9+9)-9);
		//18
		graph.edge[17].src = 0;
		graph.edge[17].dest = 1;
		graph.edge[17].weight = random.nextInt((9+9)-9);
		//19
		graph.edge[18].src = 0;
		graph.edge[18].dest = 1;
		graph.edge[18].weight = random.nextInt((9+9)-9);
		//20
		graph.edge[19].src = 0;
		graph.edge[19].dest = 1;
		graph.edge[19].weight = random.nextInt((9+9)-9);

		for(int i=0; i<10; i++)
		{
			long startTime = System.nanoTime();
			graph.BellmanFord(graph, 0);
			long endTime = System.nanoTime();
			double duration = (endTime - startTime) / Math.pow(10, 6);
			total+=duration;
		}

		average = total / 10;
		System.out.println("Average time: " + average + " ms");
	}
}
// Contributed by Aakash Hasija
