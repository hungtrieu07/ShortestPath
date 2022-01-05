// Java implementation of SPFA
import java.util.*;
 
class SPF
{
    static class pair
    {
        int first, second;
        public pair(int first, int second)
        {
            this.first = first;
            this.second = second;
        }
    }
     
// Graph is stored as vector of vector of pairs
// first element of pair store vertex
// second element of pair store weight
static Vector<pair> []graph = new Vector[100];
 
// Function to add edges in the graph
// connecting a pair of vertex(frm) and weight
// to another vertex(to) in graph
static void addEdge(int frm, int to, int weight)
{
 
    graph[frm].add(new pair( to, weight ));
}
 
// Function to print shortest distance from source
static void print_distance(int d[], int V)
{
    System.out.print("Vertex \t\t Distance"
        + " from source" +"\n");
 
    for (int i = 0; i < V; i++)
    {
        System.out.printf("%d \t\t %d\n", i, d[i]);
    }
}
 
// Function to compute the SPF algorithm
static void shortestPathFaster(int S, int V)
{
    // Create array d to store shortest distance
    int []d = new int[V + 1];
 
    // Boolean array to check if vertex
    // is present in queue or not
    boolean []inQueue = new boolean[V + 1];
 
    // Initialize the distance from source to
    // other vertex as Integer.MAX_VALUE(infinite)
    for (int i = 0; i <= V; i++)
    {
        d[i] = Integer.MAX_VALUE;
    }
    d[S] = 0;
 
    Queue<Integer> q = new LinkedList<>();
    q.add(S);
    inQueue[S] = true;
 
    while (!q.isEmpty())
    {
 
        // Take the front vertex from Queue
        int u = q.peek();
        q.remove();
        inQueue[u] = false;
 
        // Relaxing all the adjacent edges of
        // vertex taken from the Queue
        for (int i = 0; i < graph[u].size(); i++)
        {
 
            int v = graph[u].get(i).first;
            int weight = graph[u].get(i).second;
 
            if (d[v] > d[u] + weight)
            {
                d[v] = d[u] + weight;
 
                // Check if vertex v is in Queue or not
                // if not then push it into the Queue
                if (!inQueue[v])
                {
                    q.add(v);
                    inQueue[v] = true;
                }
            }
        }
    }
 
    // Print the result
    print_distance(d, V);
}
 
// Driver code
public static void main(String[] args)
{
    Random random = new Random();
    int V = 20;
    int S = 0;
    double total = 0;
    double average = 0;

    for (int i = 0; i < graph.length; i++)
    {
        graph[i] = new Vector<pair>();
    }
     
    // Connect vertex a to b with weight w
    // addEdge(a, b, w)
    addEdge(0, 1, random.nextInt((9+9)-9));
    addEdge(0, 3, random.nextInt((9+9)-9));
    addEdge(0, 16, random.nextInt((9+9)-9));
    addEdge(1, 5, random.nextInt((9+9)-9));
    addEdge(1, 13, random.nextInt((9+9)-9));
    addEdge(2, 5, random.nextInt((9+9)-9));
    addEdge(2, 13, random.nextInt((9+9)-9));
    addEdge(2, 18, random.nextInt((9+9)-9));
    addEdge(3, 4, random.nextInt((9+9)-9));
    addEdge(3, 18, random.nextInt((9+9)-9));
    addEdge(4, 5, random.nextInt((9+9)-9));
    addEdge(4, 15, random.nextInt((9+9)-9));
    addEdge(5, 6, random.nextInt((9+9)-9));
    addEdge(5, 9, random.nextInt((9+9)-9));
    addEdge(5, 19, random.nextInt((9+9)-9));
    addEdge(6, 9, random.nextInt((9+9)-9));
    addEdge(6, 19, random.nextInt((9+9)-9));
    addEdge(7, 9, random.nextInt((9+9)-9));
    addEdge(7, 17, random.nextInt((9+9)-9));
    addEdge(8, 9, random.nextInt((9+9)-9));
    addEdge(8, 15, random.nextInt((9+9)-9));
    addEdge(9, 14, random.nextInt((9+9)-9));
    addEdge(9, 19, random.nextInt((9+9)-9));
    addEdge(10, 17, random.nextInt((9+9)-9));
    addEdge(10, 19, random.nextInt((9+9)-9));
    addEdge(11, 15, random.nextInt((9+9)-9));
    addEdge(11, 17, random.nextInt((9+9)-9));
    addEdge(12, 14, random.nextInt((9+9)-9));
    addEdge(12, 18, random.nextInt((9+9)-9));
    addEdge(13, 14, random.nextInt((9+9)-9));
    addEdge(13, 15, random.nextInt((9+9)-9));
    addEdge(13, 18, random.nextInt((9+9)-9));
    addEdge(14, 18, random.nextInt((9+9)-9));
    addEdge(14, 19, random.nextInt((9+9)-9));
    addEdge(15, 17, random.nextInt((9+9)-9));
    addEdge(15, 19, random.nextInt((9+9)-9));
    addEdge(16, 17, random.nextInt((9+9)-9));
    addEdge(16, 18, random.nextInt((9+9)-9));
    addEdge(17, 18, random.nextInt((9+9)-9));
    addEdge(18, 19, random.nextInt((9+9)-9));
 
    for(int i=0; i<10; i++)
		{
			long startTime = System.nanoTime();
            shortestPathFaster(S, V);
			long endTime = System.nanoTime();
			double duration = (endTime - startTime) / Math.pow(10, 6);
			total+=duration;
		}

	average = total / 10;
	System.out.println("Average time: " + average + " ms");

}
}