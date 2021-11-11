package it.unibo.oop.lab06.generics1;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class GraphImpl<N> implements Graph<N>{
	private final Map<N,Set<N>> edges;
	
	public GraphImpl() {
		edges = new HashMap<>();
	}
	
	@Override
	public void addNode(N node) {
		final Set<N> adj = new TreeSet<>();
		this.edges.put(node,adj);
	}

	@Override
	public void addEdge(N source, N target) {
		if(nodeExist(source)) {
			final Set<N> sourceSet = this.edges.get(source);
			if(sourceSet != null) {
				sourceSet.add(target);
			}
			if(!nodeExist(target)) {
				this.addNode(target);
			}
		}
	}

	@Override
	public Set<N> nodeSet() {
		return this.edges.keySet();
	}

	@Override
	public Set<N> linkedNodes(N node) {
		if(this.nodeExist(node)) {
			return this.edges.get(node);
		}
		
		return Collections.emptySet();
	}

	private boolean nodeExist(N node){
		return this.edges.containsKey(node);
	}
	
	@Override
	public List<N> getPath(N source, N target) {
		//check the existence of the nodes
		if((!nodeExist(source)) || (!nodeExist(target))) {
			return Collections.emptyList();
		}
		
		final List<N> path = new ArrayList<>();
		
		path.add(source);
		
		if(source == target) return path;
		
		final Set<N> adj = this.edges.get(source);
		
		//visit adjacent nodes recursively until i find the node
		for(N currentNode : adj) {
			
			if(currentNode == target) {
				path.add(currentNode);
				return path;
			}
		
			path.addAll(getPath(currentNode,target));
			
			if(!path.isEmpty()) {
				return path;
			}
		}
		
		final List<N> app = new ArrayList<>();
		app.add(source);
		
		if(path.equals(app)){
			path.remove(0);
		}
		
		return path;
	}

}
