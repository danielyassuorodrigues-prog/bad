package application;

import entities.Product;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Progam {

    public static int compareProducts(Product p1, Product p2){
        return p1.getPrice().compareTo(p2.getPrice());
    }
   public static void main() {

       List<Product> list = new ArrayList<>();

       list.add(new Product("TV", 900.00));
       list.add(new Product("Notebook", 1200.00));
       list.add(new Product("Tablet", 450.00));

       list.sort(Progam :: compareProducts);

       // função lambda é uma função anônima de primeira classe
       //list.sort((p1,  p2) -> p1.getPrice().compareTo(p2.getPrice()));

       for(Product p : list) {
           System.out.println(p);
       }
    }
}
