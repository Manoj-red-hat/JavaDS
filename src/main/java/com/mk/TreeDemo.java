package com.mk;

import java.util.TreeMap;
import java.util.Vector;

/**
 * Created by manoj.kumar1 on 9/28/2017.
 */

public class TreeDemo {

    static abstract class Node {
        Node left;
        Node right;
        Integer data;

        abstract public Node add(Node n);

        abstract public Node addElement(int x);

        int LCA(Node root, int x, int y) {
            if (root.data > x && root.data < y)
                return root.data;
            else if (root.data > x && root.data > y) return this.LCA(root.left, x, y);
            else if (root.data < x && root.data < y) return this.LCA(root.right, x, y);
            else if (root.data == x || root.data == y) return root.data;
            return -0;
        }

        private TreeMap<Integer, Vector<Integer>> addValue(TreeMap<Integer, Vector<Integer>> tm, Integer daa) {
            if (tm.containsKey(daa))
                tm.get(daa).add(daa);
            else {
                tm.put(daa, new Vector<Integer>(daa));
            }

            return tm;

        }

        public void VerticalSlicing(Node root) {

            TreeMap data = new TreeMap<Integer, Vector<Integer>>();


        }

    }

    static class Empty extends Node {

        private static Empty single_instance = null;

        private Empty() {
            this.left = null;
            this.right = null;
        }

        // static method to create instance of Singleton class
        public static Empty getInstance() {
            if (single_instance == null)
                single_instance = new Empty();

            return single_instance;
        }


        @Override
        public String toString() {
            return ".";
        }

        @Override
        public Node add(Node n) {
            return n;
        }

        @Override
        public Node addElement(int x) {
            return new NonEmpty(Empty.getInstance(), Empty.getInstance(), x);
        }
    }

    static class NonEmpty extends Node {
        NonEmpty(Node l, Node r, Integer data) {
            this.left = l;
            this.right = r;
            this.data = data;
        }

        @Override
        public Node add(Node l) {
            if (l.data > this.data) {
                if (this.right instanceof NonEmpty) {
                    this.right.add(l);
                } else {
                    this.right = l;
                }
            } else if (l.data < this.data) {
                if (this.left instanceof NonEmpty) {
                    this.left.add(l);
                } else {
                    this.left = l;
                }
            }
            return this;
        }

        public Node addElement(int x) {
            return this.add(new NonEmpty(Empty.getInstance(), Empty.getInstance(), x));
        }

        @Override
        public String toString() {
            return "{" + left + this.data + right + "}";
        }
    }

    TreeDemo(){
        Node root=new NonEmpty(Empty.getInstance(), Empty.getInstance(),5);
        Node l=new NonEmpty(Empty.getInstance(), Empty.getInstance(),3);
        Node l1=new NonEmpty(Empty.getInstance(), Empty.getInstance(),4);
        Node r=new NonEmpty(Empty.getInstance(), Empty.getInstance(),7);
        Node r1=new NonEmpty(Empty.getInstance(), Empty.getInstance(),6);
        Node l2=new NonEmpty(Empty.getInstance(), Empty.getInstance(),2);
        Node l3=new NonEmpty(Empty.getInstance(), Empty.getInstance(),1);
        Node r2=new NonEmpty(Empty.getInstance(), Empty.getInstance(),8);
        Node r3=new NonEmpty(Empty.getInstance(), Empty.getInstance(),9);
        root=root.add(l).add(l1).add(r).add(r1).add(l2).add(l3).add(r2).add(r3);

        System.out.println(root.LCA(root,2,4));
        System.out.println(root.addElement(100));
    }
}