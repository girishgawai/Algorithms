package graph.kruskals.algo;

import java.util.HashMap;

public class DisJoint_Set {

	public class Node {
		int value;								// value of vertex
		Node parent;							// parent of that vertex
		int rank;								// height of that vertex tree
	}

	HashMap<Integer, Node> map = new HashMap<>();		// iss map me adrs rhega harr uss vertex ke node ka.. jise hm find krege graph me

	// step 1
	public void CreateSet(int v)
	{
		Node nn = new Node();
		nn.value = v;								// vertex ki value
		nn.parent = nn;					// jb ye node bnega tb iss vertex ka parent yeh node khud bnega
		nn.rank = 0;					// initial rank of this vertex is 0

		map.put(v, nn);					// map me add kroge iss vertex ko nd value me adrs vtx ka
	}


	// step 2
	public int find(int v)							// find krna hai iss vertex ka Set Representative Element
	{														
		Node vtx_adrs = map.get(v);				// vtx element ka adrs
		return find(vtx_adrs).value;										// iss vtx ka adrs ko find krege spanning tree wale graph me
	}														// jisse set ka RE milega uska addrs uski val means RE ki value


	private Node find(Node node) {						// yeh fn iss vtx ke adrs ko find krega set me iska RE element ka adrs kon hai
		// TODO Auto-generated method stub
		if(node.parent==node)						// vtx ka parent agr khud vtx ka adrs mila mtlb woh vtx element uss set ka RE hai
			return node;

		/***
		 *  Node nn = find(node.parent);
		 *	node.parent = nn;								// path compression
		 *	return nn; 
		 */
		return find(node.parent);						// parent ka adrs bhejte jayege current node ka .. uska RE find krne iske set ka
	}


	// step 3
	public void union(int v1, int v2)					// yeh dono vtx jis set me hai uske RE ko find kro nd accodingly merge kro
	{
		int s1 = find(v1);
		int s2 = find(v2);
		Node re1 = map.get(s1);	// map se iss node vtx ka adrs lelo.. jisse RE k adrs se compare krege dono sets ke RE ko and unje ranks ko
		Node re2 = map.get(s2);						// set 2 ka RE ka adrs

		if(re1.rank==re2.rank)	// agr dono set ke trees ke RE ki ranks same hai toh kisi ko v kisise merge krdo (parent kiska v join kro)
		{											// jisse merge hora uska RE ka rank+1 hoga
			re1.parent = re2;
			re2.rank = re2.rank + 1;								// jisse merge hua uske RE ka rank 1 se bdhega
		}
		else if(re1.rank>re2.rank)	// agr RE2 ka rank chota hai RE1 se toh chote wala ka parent chng kro.. usse rank chng nh hoga
		{
			re2.parent = re1;
		}
		else
		{
			re1.parent = re2;						// RE2 ka rank bda hai set 2 ke RE k rank se.. so chote wale ka parent chng krege
		}
	}

}
