package graph.kruskals.algo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class Kruskals_Algorithm {

	HashMap<Integer, HashMap<Integer, Integer>> map;

	public Kruskals_Algorithm(int v)
	{
		this.map = new HashMap<>();
		for (int i = 1; i <= v; i++) {
			map.put(i, new HashMap<>());
		}
	}

	public void addEges(int v1, int v2, int cost)			// inn dono vertex k bichme edge bnado iss cost ke sath
	{
		map.get(v1).put(v2, cost);
		map.get(v2).put(v1, cost);
	}

	public class EdgePair {
		int e1;
		int e2;
		int cost;

		public EdgePair(int e1, int e2, int cost)			// setting values in ref var when objct is being created
		{
			this.e1 = e1;
			this.e2 = e2;
			this.cost = cost;
		}

		@Override
		public String toString()
		{
			return e1 + "  " + e2 + " @ " + cost;
		}

	}

	public List<EdgePair> getAllEdges()
	{
		List<EdgePair> list = new ArrayList<>();	// contains a class objct pair which v1 connected to v2 wid cost edge
		for(int key : map.keySet())
		{
			for(int nbrs : map.get(key).keySet())
			{
				int cost = map.get(key).get(nbrs);
				EdgePair pair = new EdgePair(key, nbrs, cost);				// yeh pair me konsa vtx kiss vtx ko join hai nd uski edge 
																// ki cost kitni hai Ek class ka objct bnakr usme store krdege
				list.add(pair);												// is vtx vtx cost pair objct ko list me store krege
			}
		}

		return list;										// iss list me vtx-vtx-cost pair hai sare graph ki
	}

	
	public int KruskalsAlgo()
	{
		List<EdgePair> list = getAllEdges();	// this list contains of all the vtx vtx connected pair wid edge cost
		
		// sorting that list acc to cost so can use them to form min cost spanning tree
		Collections.sort(list, new Comparator<EdgePair>() {
			
			@Override
			public int compare(EdgePair o1, EdgePair o2)
			{
				return o1.cost - o2.cost;
			}
		});
		
		// Now the list contains the EdgePair vtx-vtx-cost wid it arranged in ascending order to form min cost spanning tree
		
		// Creating Set of DSU
		DisJoint_Set dsu = new DisJoint_Set();
		for (int i = 1; i <= map.size(); i++) {
			dsu.CreateSet(i);
		}
		
		// Using list which has all info of vtx-vtx connected edge cost.. arranged in min cost ascending pair
		int ans = 0;						// counts the min cost of spanning tree
		for(EdgePair vtx : list)
		{
			int v1 = vtx.e1;
			int v2 = vtx.e2;
			int re1 = dsu.find(v1);						// Representative Element of this set for vtx 1
			int re2 = dsu.find(v2);						// Representative Element of this set for vtx 2
			
			if(re1==re2)
			{
				// ignore... iss case me cycle bnegi agr dono ka RE same hi hai set me
			}
			else
			{
				
				System.out.println(vtx);
				dsu.union(re1, re2);
				ans = ans+vtx.cost;
			}
			
		}
//		System.out.println("=====");
		return ans;
	}
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();					// no of nodes --> vertex
		Kruskals_Algorithm ks = new Kruskals_Algorithm(n);
		
		int m = sc.nextInt();				// no of edges
		
		for (int i = 0; i < m; i++) {			// Creating a Graph
			int v1 = sc.nextInt();
			int v2 = sc.nextInt();
			int cost = sc.nextInt();
			
			ks.addEges(v1, v2, cost);
		}
		
		int minCostOfSpanningTree = ks.KruskalsAlgo();
		System.out.println(minCostOfSpanningTree);
	}

}
