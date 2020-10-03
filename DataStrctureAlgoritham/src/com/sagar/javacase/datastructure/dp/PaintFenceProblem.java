package com.sagar.javacase.datastructure.dp;

public class PaintFenceProblem {

    public static void main(String[] args){
        int n = 5;
        int k = 3;

        long same = k * 1;
        long diff = k * (k-1);

        long total = same + diff;

        for(int i=2;i<n;i++){
            same = diff;
            diff = total *(k-1);
            total = same + diff;
        }
        System.out.println("Fence post: "+n+", Color: "+k+" = "+total);
    }
}
