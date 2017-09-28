package com.mk;

import java.util.HashSet;
import java.util.Random;
import java.util.TreeMap;
import java.util.Vector;
import java.util.stream.IntStream;

/**
 * Created by manoj.kumar1 on 9/28/2017.
 */
public class GraphDemo {

    Vector<Pair> createRandomGraphEdge(){
        Vector<Pair> data= new Vector<>();
        Random rnd= new Random();
        IntStream.range(1, 25).forEach(x ->  {
            Integer a=Math.abs(rnd.nextInt()%5)+1;
            Integer b=Math.abs(rnd.nextInt()%5)+1;
            if (a!=b)
            data.add(new Pair(a,b));
        });
        return data;
    }
    class VertexInfo{
        HashSet<Integer> edges=new HashSet<>();

        @Override
        public String toString(){
            StringBuffer sb=new StringBuffer();
            sb.append("EDGE Info: ");
            for (Integer x:edges)
                sb.append("->"+x);
            return sb.toString();
        }

        @Override
        public boolean equals(Object v) {
            boolean retVal = false;

            if (v instanceof VertexInfo){
                VertexInfo ptr = (VertexInfo) v;
                retVal = ptr.edges.equals(this.edges);
            }

            return retVal;
        }
    }

    public void PrintGraph (){
        IntStream.range(1,6).forEach(x->{
            System.out.println("Vertex with value: "+x+" ->"+graph.get(new Integer(x)));
        });
    }

    TreeMap<Integer,VertexInfo> graph = new TreeMap<>();
    Vector<Pair> Edges = createRandomGraphEdge();
    GraphDemo() {
        for (Pair x : Edges){
            Integer key=(Integer)x.getFirst();
            if (graph.containsKey(key)) {
                graph.get(key).edges.add((Integer) x.getSecond());
            }else{
                VertexInfo nodeInfo = new VertexInfo();
                nodeInfo.edges.add( (Integer) x.getSecond());
                graph.put((Integer) x.getFirst(),nodeInfo);
            }
        }
    }

}
