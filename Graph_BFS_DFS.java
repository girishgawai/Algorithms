package graph.algos;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Graph_BFS_DFS {

	HashMap<Integer, HashMap<Integer, Integer>> map = new HashMap<>();

	public Graph_BFS_DFS(int v)
	{
		for(int i=1;i<=v;i++)
		{
			map.put(i, new HashMap<>());
		}
	}

	public void addEdge(int v1, int v2, int cost)
	{
		map.get(v1).put(v2, cost);
		map.get(v2).put(v1, cost);
	}

	/*********************************  BFS Algorithm  ***************************************/
	// Are this 2 vertex connected..?  // BFS is same as LEVEL ORDER TRANSVERSAL OF TREE using Queue

	public boolean BFS(int src, int des)
	{
		HashSet<Integer> visited = new HashSet<>();
		Queue<Integer> q = new LinkedList<>();

		q.add(src);

		while(!q.isEmpty())
		{
			// step 1 - remove
			int removed = q.poll();

			// step 2 - check if already visited is removed>.? if yes don't perform below steps directly continue with next one
			if(visited.contains(removed))
				continue;									// agr visited wala wapis aya queue me niklne toh cycle hai graph me

			// step 3 - mark it as visited if not already visited (jo removed data hai usko)
			visited.add(removed);

			// step 4 - self work.. jo v hoga tumhare case me perform kro
			if(removed==des)
				return true;							// agr destination same ho gyi remove kiye hue data pe mil gyi.. toh src se aate aate
			// destination pe pohoch gye removed wale vertex ke through

			// step 5 - add the neighbours (unvisited)
			for(int neighbours : map.get(removed).keySet())
			{
				if(!visited.contains(neighbours))							// agr visited nhi hai phle se neighbours toh hi add krege
					q.add(neighbours);
			}
		}

		return false;							// means dono vertexes connected nhi hai.. doesn't from any path

	}


	/*********************************  DFS Algorithm  ***************************************/
	// Are this 2 vertex connected..?  // DFS is same as BFS just with using STACK so Top data is being removed first always
	// Agr ek hi branch puri explore krni hogi and then dusri branch pe jana hoga toh BFS use hoga

	public boolean DFS(int src, int des)
	{
		HashSet<Integer> visited = new HashSet<>();
		Stack<Integer> s = new Stack<>();

		s.add(src);

		while(!s.isEmpty())
		{
			// step 1 - remove
			int removed = s.pop();

			// step 2 - unknown step? check if already visited is being removed..? agr aisa hai toh Cycle hai Graph me
			// cycle detect hue toh ignore kro niche ke steps directly next se continue kro
			if(visited.contains(removed))
				continue;

			// step 3 - mark it as visited
			visited.add(removed);

			// step 4 - self work
			if(removed==des)
				return true;

			// step 5 - add univisited neighbours
			for(int nbrs : map.get(removed).keySet())
			{
				if(!visited.contains(nbrs))
					s.push(nbrs);
			}
		}

		return false;											// means path connected nhi hai dono vertexes ka
	}


	/************************ BFT BFS ka Vertex toh Vertex Transversal har vertex pe jakr transverse krna **************************/
	// Sab kuch BFS jaise hoga bss calls loop se lgege iss baar repeatedly.. agr visited nhi hai toh hi call jayega
	//  Har vertex se transversal print krao (Path)..?
	//  Yeh 2 alg alg components wale graph rhe toh unme v transverse kra dega
	//  Yeh Cycle Detect v kr dega

	public void BFT()					// agr 2 alg alg components diye hoge 2 diff graphs toh  unko traverse krke path print krega BFT
	{
		HashSet<Integer> visited = new HashSet<>();
		Queue<Integer> q = new LinkedList<>();

		for(int src : map.keySet())
		{
			// step A - agr visited hai vertex already it means isse path bnaya hai
			if(visited.contains(src))
				continue;

			q.add(src);

			while(!q.isEmpty())
			{
				// step 1 - remove
				int remove = q.poll();

				// step 2 - unknown step? check if already visited is being removed..? agr aisa hai toh Cycle hai Graph me
				// cycle detect hue toh ignore kro niche ke steps directly next se continue kro
				if(visited.contains(remove))
					continue;					// it means cycle hai..// agr visited wala wapis aya queue me niklne toh cycle hai graph me

				// step 3 - mark visited
				visited.add(remove);

				// step 4 - self work  --> we have to print the path of traversal
				System.out.print(remove + " ");

				// step 5 - add univisited neighbours
				for(int nbrs : map.get(remove).keySet())
				{
					if(!visited.contains(nbrs))
						q.add(nbrs);
				}
			}

			System.out.println();							// agr multiple paths honge alg alg graph ke toh alg line me aane k liye
		}
	}


	/************************ DFT DFS ka Vertex toh Vertex Transversal har vertex pe jakr transverse krna **************************/
	// Sab kuch DFS jaise hoga bss calls loop se lgege iss baar repeatedly.. agr visited nhi hai toh hi call jayega
	//  Har vertex se transversal print krao (Path)..?
	//  Yeh 2 alg alg components wale graph rhe toh unme v transverse kra dega
	//  Yeh Cycle Detect v kr dega

	public void DFT()					// agr 2 alg alg components diye hoge 2 diff graphs toh  unko traverse krke path print krega BFT
	{
		HashSet<Integer> visited = new HashSet<>();
		Stack<Integer> s = new Stack<>();

		for(int src : map.keySet())
		{
			// step A - agr visited hai vertex already it means isse path bnaya hai
			if(visited.contains(src))
				continue;

			s.add(src);

			while(!s.isEmpty())
			{
				// step 1 - remove
				int removed = s.pop();

				// step 2 - unknown step? check if already visited is being removed..? agr aisa hai toh Cycle hai Graph me
				// cycle detect hue toh ignore kro niche ke steps directly next se continue kro
				if(visited.contains(removed))
					continue;

				// step 3 - mark it as visited
				visited.add(removed);

				// step 4 - self work
				System.out.print(removed + " ");

				// step 5 - add univisited neighbours
				for(int nbrs : map.get(removed).keySet())
				{
					if(!visited.contains(nbrs))
						s.push(nbrs);
				}
			}

			System.out.println();									// agr multiple paths honge alg alg graph ke toh alg line me aane k liye
		}
	}


	// Cycle Detection in Graph
	public boolean Cycle_Detection()					// cycle hai kya graph me..? aur agr 2 component hoge toh v cycle hai kya kisi me..?
	{
		HashSet<Integer> visited = new HashSet<>();
		Queue<Integer> q = new LinkedList<>();

		for(int src : map.keySet())
		{
			// step A - agr visited hai vertex already it means isse path bnaya hai
			if(visited.contains(src))
				continue;

			q.add(src);

			while(!q.isEmpty())
			{
				// step 1 - remove
				int remove = q.poll();

				// step 2 - unknown step? check if already visited is being removed..? agr aisa hai toh Cycle hai Graph me
				// cycle detect hue toh ignore kro niche ke steps directly next se continue kro
				if(visited.contains(remove))
				{
					return true;					// it means cycle hai..// agr visited wala wapis aya queue me niklne toh cycle hai graph me
				}

				// step 3 - mark visited
				visited.add(remove);

				// step 4 - self work  --> we have to print the path of traversal
//				System.out.print(remove + " ");

				// step 5 - add univisited neighbours
				for(int nbrs : map.get(remove).keySet())
				{
					if(!visited.contains(nbrs))
						q.add(nbrs);
				}
			}
		}
		
		return false;
	}

	
	// Count the Components in the Graph.. How many Graphs are there
	public int countComponents()					
	{
		HashSet<Integer> visited = new HashSet<>();
		Stack<Integer> s = new Stack<>();

		int ans = 0;											// count of components in graph
		for(int src : map.keySet())
		{
			// step A - agr visited hai vertex already it means isse path bnaya hai
			if(visited.contains(src))
				continue;

			ans++;				// agr call jayega inn vertex se mtlb vid=sited nh hai mtlb component bnra hai inn vertex se vtx++
			s.add(src);

			while(!s.isEmpty())
			{
				// step 1 - remove
				int removed = s.pop();

				// step 2 - unknown step? check if already visited is being removed..? agr aisa hai toh Cycle hai Graph me
				// cycle detect hue toh ignore kro niche ke steps directly next se continue kro
				if(visited.contains(removed))
					continue;

				// step 3 - mark it as visited
				visited.add(removed);

				// step 4 - self work
//				System.out.print(removed + " ");

				// step 5 - add univisited neighbours
				for(int nbrs : map.get(removed).keySet())
				{
					if(!visited.contains(nbrs))
						s.push(nbrs);
				}
			}

		}
		
		return ans;								// total components calculate hue isme.. agr alg alg graphs hai fir v count hue hai
	}

}
