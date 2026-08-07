package main;

public class Main {

    public static void main(String args[]){

        System.out.print(factorial(5));

    }


    static int factorial(int n){

        System.out.println("Antes: " + n);

        if( n <= 1 )
            return 1;

        return n * factorial(n - 1);


    }

}

