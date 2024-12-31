package org.sec.trying;

public interface Calculator {
    int add(int a, int  b);
    default int substract(int a, int b) {
        return a - b;
    };
}
