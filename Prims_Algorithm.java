package graph.prims.algo;

import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.PriorityQueue;
import java.util.Scanner;

import graph.kruskals.algo.Kruskals_Algorithm;

public class Prims_Algorithm {
	
	HashMap<Integer, HashMap<Integer, Integer>> map = new HashMap<>();
	
	public Prims_Algorithm(int v)					// number of vertexes in the graph
	{
		for (int i = 1; i <= v; i++) {
			map.put(i, new HashMap<>());
		}
	}
	
	public void addEdges(int v1, int v2, int cost)
	{
		map.get(v1).put(v2, cost);
		map.get(v2).put(v1, cost);
	}
	
	public class PrimPair {
		int vtx;
		int vtx_acqr;								// vtx gets/acquired from which vertex
		int cost;
		
		
		public PrimPair(int vtx, int vtx_acqr, int cost)
		{
			this.vtx = vtx;
			this.vtx_acqr = vtx_acqr;
			this.cost = cost;
		}
		
		@Override
		public String toString()
		{
			return this.vtx + " <--- " + this.vtx_acqr + "  @  " + this.cost;
		}
	}
	
	public void primsAlgo(int src)
	{
		PriorityQueue<PrimPair> pq = new PriorityQueue<>(new Comparator<PrimPair>() {

			@Override
			public int compare(PrimPair o1, PrimPair o2) {
				// TODO Auto-generated method stub
				return o1.cost-o2.cost;
			}
		});
		
		int ans = 0;	// min cost for building spanning tree
		HashSet<Integer> visited = new HashSet<>();
		pq.add(new PrimPair(src, src, 0));			// src vertex ne khudko khudse acqr kia wid cost 0.. start toh krna pdega source se
		
		while(!pq.isEmpty())
		{
			PrimPair rem = pq.poll();
			
			if(visited.contains(rem.vtx))
				continue;
			
			visited.add(rem.vtx);
			
			System.out.println(rem);
			ans+=rem.cost;
			
			for(int nbrs : map.get(rem.vtx).keySet())
			{
				if(!visited.contains(nbrs))
				{
					int c = map.get(rem.vtx).get(nbrs);		// sirf uski cost add krte hai PQ me.. acqr_vtx --> se vtx ki
					PrimPair nvnbrs = new PrimPair(nbrs, rem.vtx, c);
					pq.add(nvnbrs);
				}
			}
		}
		
		System.out.println(ans);
	}
	
	public static void main(String[] args) {
//		Prims_Algorithm pma = new Prims_Algorithm(5);
//		pma.addEdges(1, 2, 2);
//		pma.addEdges(2, 3, 1);
//		pma.addEdges(1, 4, 3);
//		pma.addEdges(4, 3, 5);
//		pma.addEdges(3, 5, 6);
//		pma.addEdges(4, 5, 7);
		
//		Prims_Algorithm pma = new Prims_Algorithm(7);
//		pma.addEdges(1, 2, 2);
//		pma.addEdges(2, 3, 3);
//		pma.addEdges(1, 4, 10);
//		pma.addEdges(4, 5, 8);
//		pma.addEdges(3, 4, 1);
//		pma.addEdges(5, 6, 5);
//		pma.addEdges(5, 7, 6);
//		pma.addEdges(6, 7, 4);
//		pma.addEdges(1, 2, 20);
//
//
//		pma.primsAlgo(1);
		
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();					// no of nodes --> vertex
		Prims_Algorithm ks = new Prims_Algorithm(n);
		
		int m = sc.nextInt();				// no of edges
		
		for (int i = 0; i < m; i++) {			// Creating a Graph
			int v1 = sc.nextInt();
			int v2 = sc.nextInt();
			int cost = sc.nextInt();
			
			ks.addEdges(v1, v2, cost);
		}
		
		 ks.primsAlgo(1);
//		System.out.println(minCostOfSpanningTree);
	}
	
}
