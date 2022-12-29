package graph.algos.dijkstra;

import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.PriorityQueue;

public class Dijkstras_Algorithm {

	HashMap<Integer, HashMap<Integer, Integer>> map = new HashMap<>();

	public Dijkstras_Algorithm(int v)		// map me initials set krdo adrs map ke jitne vtx hai utne create krke
	{
		for (int i = 1; i <= v; i++) {
			map.put(i, new HashMap<>());
		}
	}

	public void addEdges(int v1, int v2, int cost)		// connect the edges vet 2 vertexes with the cost given
	{
		map.get(v1).put(v2, cost);
		map.get(v2).put(v1, cost);
	}

	class DijkstraPair {
		int cost;								// cost dijkstra pair ki
		String pathAcquire;						// kiss path se hokr aya
		int vtx;								// dijkstra pair ka vtx jispe cost bni

		public DijkstraPair(int vtx, int cost, String pathAcq) {
			// TODO Auto-generated constructor stub
			this.cost = cost;
			this.pathAcquire = pathAcq;
			this.vtx = vtx;
		}

		@Override
		public String toString()
		{
			return vtx +" --> " + pathAcquire + "  @  " +cost;
		}

	}


	public void DijkstrasAlgo(int src)		// BFS use krege with Priority Queue
	{					// src --> is a starting point vtx jha se graph me dekhna hai har ek vtx pe

		// But PriorityQueue is having Elements of Type DijkstraPair class objects.. so need to add Comparison Logic into it
		PriorityQueue<DijkstraPair> pq = new PriorityQueue<>(new Comparator<DijkstraPair>() {

			@Override
			public int compare(DijkstraPair o1, DijkstraPair o2) {
				// TODO Auto-generated method stub
				return o1.cost - o2.cost;									// sorting on the basis of Cost of edges (min cost)
			}
		});
		
		
		HashSet<Integer> visited = new HashSet<>();		// visited vertex ka track rkhne

		pq.add(new DijkstraPair(src, 0, ""+src));		// src se start krega so phla point src se src tk cost 0 path nothing vtx src khud

		while(!pq.isEmpty())
		{
			DijkstraPair removed = pq.poll();

			if(visited.contains(removed.vtx))
			{
				continue;							// it means cycle hai agr visited wala vtx wapis se remove hua PriorityQueue se
			}

			visited.add(removed.vtx);								// removed vtx ko visited mark krdo

			// step 4 Self Work
			System.out.println(removed);

			// step 5 Add univisted Neighbours  -->  also update the acquire path with cost acquire at current vtx
			for(int nbrs : map.get(removed.vtx).keySet())
			{
				if(!visited.contains(nbrs))				// agr neighbour ke vtx visited nh hoge toh hi add krege uss neighbour ko
				{
					int cost = removed.cost + map.get(removed.vtx).get(nbrs);		// av ke edge ki cost + phle se milkr aayi hue edge ki cost
					DijkstraPair djp = new DijkstraPair(nbrs, cost, removed.pathAcquire+ nbrs);
					pq.add(djp);
				}
			}

		}
	}

	
	public static void main(String[] args) {
		Dijkstras_Algorithm dj = new Dijkstras_Algorithm(7);		// dijkstra algo wid 7 vertexes graph
		dj.addEdges(1, 2, 2);
		dj.addEdges(2, 3, 3);
		dj.addEdges(1, 4, 10);
		dj.addEdges(4, 5, 8);
		dj.addEdges(3, 4, 1);
		dj.addEdges(5, 6, 5);
		dj.addEdges(5, 7, 6);
		dj.addEdges(6, 7, 4);
		
		dj.DijkstrasAlgo(1);				// calling Dijkstra Algo with src starting vtx (src-src, src-2, src-3, ..)to find min cost with PathAcquired
	}
	
}
