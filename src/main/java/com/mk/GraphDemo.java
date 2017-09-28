package com.mk;

import java.util.HashSet;
import java.util.Random;
import java.util.Vector;
import java.util.stream.IntStream;

/**
 * Created by manoj.kumar1 on 9/28/2017.
 */
public class GraphDemo {

    Vector<Pair> createRandomGraph(){
        Vector<Pair> data= new Vector<>();
        Random rnd= new Random();
        IntStream.range(1, 25).forEach(x ->  {
            Integer a=Math.abs(rnd.nextInt()%5);
            Integer b=Math.abs(rnd.nextInt()%5);
            if (a!=b)
            data.add(new Pair(a,b));
        });
        return data;
    }
    class Vertex{
        int data;
        HashSet<Integer> edges=new HashSet<>();
        Vertex(int value){
            data=value;
        }

        @Override
        public String toString(){
            StringBuffer sb=new StringBuffer();
            sb.append("EDGE : "+data+":");
            for (Integer x:edges)
                sb.append("->"+x);
            return sb.toString();
        }

        @Override
        public boolean equals(Object v) {
            boolean retVal = false;

            if (v instanceof Vertex){
                Vertex ptr = (Vertex) v;
                retVal = ptr.data == this.data;
            }

            return retVal;
        }
    }

    public void PrintGraph (){
        IntStream.range(0,5).forEach(x->{
            System.out.println(graph.get(x));
        });
    }
    Vector<Vertex> graph = new Vector<>();
    Vector<Pair> Edges = createRandomGraph();
    GraphDemo() {
        createRandomGraph();
        for (Pair x : Edges){
            if (graph.contains(new Vertex((Integer)x.getFirst()))) {
                try {
                    graph.elementAt((Integer) x.getFirst()).edges.add((Integer) x.getSecond());
                } catch (Exception e) {
                    graph.add(new Vertex((Integer) x.getFirst()));
                }
            }else{
                graph.add(new Vertex((Integer) x.getFirst()));
            }
        }
    }
}
