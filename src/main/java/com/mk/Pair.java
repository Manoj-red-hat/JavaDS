package com.mk;

/**
 * Created by manoj.kumar1 on 9/28/2017.
 */
public class Pair<F, S> extends java.util.AbstractMap.SimpleImmutableEntry<F, S> {

    public  Pair( F f, S s ) {
        super( f, s );
    }

    public F getFirst() {
        return getKey();
    }

    public S getSecond() {
        return getValue();
    }

    public String toString() {
        return "["+getKey()+","+getValue()+"]";
    }

}
