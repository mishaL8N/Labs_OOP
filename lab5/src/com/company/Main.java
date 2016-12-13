package com.company;

import java.util.*;

public  class Main<T> /*implements Rebro<T>*/ {
    public String ver1, ver2;
    Scanner scan = new Scanner(System.in);

    public static HashMap<String, List<String>> graph = new HashMap<String, List<String>>();
    public ArrayList<GN> id = new ArrayList();

    public void addVertex(String Person) {
            graph.put(Person, new ArrayList<String>());
            id.add(new GN(Person));
    }

    public boolean hasVertex(String Person) {
        return graph.containsKey(Person);
    }

    public boolean hasEdge(String Person1, String Person2) {
        if (!hasVertex(Person1)) return false;
        List<String> edges = graph.get(Person1);
        return Collections.binarySearch(edges, Person2) != -1;
    }

    public void addEdge(String Person1, String Person2) {
        if(!hasEdge(Person1,Person2)){
        if (!hasVertex(Person1)) {addVertex(Person1); id.add(new GN(Person1));}
        if (!hasVertex(Person2)) {addVertex(Person2); id.add(new GN(Person2));}
        List<String> edges1 = graph.get(Person1);
        List<String> edges2 = graph.get(Person2);
        edges1.add(Person2);
        edges2.add(Person1);
        Collections.sort(edges1);
        Collections.sort(edges2);
    }}


    public static void Enter(){
        for (Map.Entry entry : graph.entrySet()) {
            System.out.println("Вершина: " + entry.getKey() + " зв'язана з: "
                    + entry.getValue());
        }

    }

    public void Search() {
        int k = scan.nextInt();
        System.out.println("Вершина з id "+k+": "+id.get(k-1).getob());
    }

}

