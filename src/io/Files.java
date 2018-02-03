package io;

import java.io.File;

public class Files {
    public static void main(String[] args) {
        // exist
        File f1 = new File("/Users/caden/Downloads", "a.pdf");
        System.out.println("f1: " + f1.length());

        // non-exist
        File f2 = new File("/Users/caden/Downloads", "b.pdf");
        System.out.println("f2: " + f2.length());
    }
}
