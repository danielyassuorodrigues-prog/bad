package Predica;

import Consum.ProductConsumer;
import Func.UpperCaseName;
import entities.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;


public class Progam {
    static void main() {
        Locale.setDefault(Locale.US);
        List<Product> list = new ArrayList<>();


        list.add((new Product("Tv", 900.00)));
        list.add((new Product("Mouse", 50.00)));
        list.add((new Product("Tablet", 350.00)));
        list.add((new Product("HD Case", 80.90)));

        Function<Product,String> func = (p) -> p.getName().toUpperCase();

        List<String> names = list.stream().map(func).collect(Collectors.toList());

        names.forEach(System.out::println);




    }
}
