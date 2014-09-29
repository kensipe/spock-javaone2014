package com.math

/**
 *
 * @author kensipe
 */
class SimpleInterestCalcDataProvider implements Iterator{
    // (1, 2, 1000.0, 10000), (2, 5, 25.0, 100)
    def list = [[2, 1000.0, 10000], [5, 25.0, 100]]
    int position = 0

    @Override
    boolean hasNext() {
        position < list.size()
    }

    @Override
    Object next() {
        list[position++]
    }

    @Override
    void remove() {
    }

//    def close() { println "closing"}
}
