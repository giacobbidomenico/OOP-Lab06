package it.unibo.oop.lab06.generics1;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class GraphImpl<N> implements Graph<N>{
	private Map<N,Set<N>> edges;
	
	public GraphImpl() {
		edges = new HashMap<>();
	}
	
	@Override
	public void addNode(N node) {
		Set<N> adj = new TreeSet<>();
		this.edges.put(node,adj);
	}

	@Override
	public void addEdge(N source, N target) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Set<N> nodeSet() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Set<N> linkedNodes(N node) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<N> getPath(N source, N target) {
		// TODO Auto-generated method stub
		return null;
	}

}
