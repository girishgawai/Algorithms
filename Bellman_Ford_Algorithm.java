package graph.algos.bellman_ford;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.PriorityQueue;

public class Bellman_Ford_Algorithm {
	
	HashMap<Integer, HashMap<Integer, Integer>> map = new HashMap<>();
	
	public Bellman_Ford_Algorithm(int v) {
		for (int i = 1; i <= v; i++) {
			map.put(i, new HashMap<>());
		}
	}
	
	public void addEdges(int v1, int v2, int cost)			// creating graph by adding weighted edges between the 2 vertex v1 & v2
	{
		map.get(v1).put(v2, cost);							// v1--> v2 me Edge with cost  --> directed graph ki edges
	}

	public class EdgePair {
		int e1;					// vtx1
		int e2;					// vtx2 jo connected hai edge se
		int cost;
		
		public EdgePair(int v1, int v2, int cost)
		{
			this.e1 = v1;
			this.e2 = v2;
			this.cost = cost;
		}
		
		@Override
		public String toString()
		{
			return this.e1 + " --> " + this.e2 + "  @  " + this.cost;
		}
	}
	
	public ArrayList<EdgePair> allEdges()
	{
		ArrayList<EdgePair> list = new ArrayList<>();
		
		for(int e1 : map.keySet())
		{
			for(int e2 : map.get(e1).keySet())
			{
				EdgePair eg_vtx_pair = new EdgePair(e1, e2, map.get(e1).get(e2));			// jo vtx jis vtx se connected hai graph me
				list.add(eg_vtx_pair);										// use add krdo wid edge
			}
		}
		
		return list;
	}
	
	public void Bellman_Ford_Algo( )		// starting of graph jisse graph ke shortest path cum cost wale dhundne hai
	{
		ArrayList<EdgePair> list = allEdges();			// graph me vtx ke nbrs jise vtx connected hai directly with edge cost
		
		// v-1 times chalaye loop me same process toh cum shprtest path milega..
		// Aur agr vth time ek aur bar loop chlaya nd koi changes aaye ans me dis[] me mtlb -ve Cycle generate hori hai
		int v = map.size();							// num of nodes i.e. vertex in graph
		
		int[] dis = new int[v+1];				// distance array .. bet vertexes.. v+1 lia bcaz array fill 1th index se krege
		// default dis[] me 0 hoga.. means 1-1 ka distnc 0 hai
		// 2nd index se distcn 1-2, 1-3,.. sab infinite rkhege bcaz compare krna hai.. sbse cum distnc find out kra hai
		// infinite rkhna means Integer.Max_VAlue nhi rkhege wrna har edge pe -ve cycle bnjayegi.. thtas y keep range ke bahr ka val
		
		for (int i = 2; i < dis.length; i++) {
			dis[i] = 878878484;						// filling infinite distnc inititally bet vertexes 1-2,1-3,1-n,...
		}
		
//		dis[1]=0				--> vtx1 - vtx2 ==0 distnc
		
		for (int i = 1; i <= v; i++) 			// agr i=1;i<v--> v-1 tk means sbse shortest path dega min cost ka
		{									// v--> i=1;i<=v --> kia mtlb v th time me agr chnages hue ans me mtlb -ve Cycle bnri hai
			
			for(EdgePair e : list)
			{
				
				if(i==v && dis[e.e2] > dis[e.e1]+e.cost)			// will detects the -ve Cycle formation
				{
					System.out.println("-ve Weighted Cycle");
					return;												// -ve cycle mil gyi toh fir aage kuch check krne ki jarurat hi nhi
				}														// wrna -ve cycle ke wjese gol gol hi ghumte rhega
				
				if(dis[e.e2] > dis[e.e1]+e.cost)
				{
					dis[e.e2] = dis[e.e1]+e.cost;					// agr dis[src-v2] bda hai > dis[v1]+av ke vtx ki cost se toh
				}																// iss index ke src-v2 pe dis[] me cum wala cost dalo
			}
		}
		
		
		for (int i = 1; i < dis.length; i++) {
			System.out.print(dis[i] + " ");
		}
		
	}
	
	
	public static void main(String[] args) {
		Bellman_Ford_Algorithm bfd = new Bellman_Ford_Algorithm(5);
		
		bfd.addEdges(1, 2, 8);
		bfd.addEdges(2, 5, -2);
		bfd.addEdges(2, 5, 2);					// agr isko comment krdia.. toh -ve cycle form ho jayegi
		bfd.addEdges(5, 2, 1);
		bfd.addEdges(4, 5, 4);
		bfd.addEdges(3, 4, -3);
		bfd.addEdges(1, 3, 4);
		bfd.addEdges(1, 4, 5);
		
		bfd.Bellman_Ford_Algo();
	}
	
}
