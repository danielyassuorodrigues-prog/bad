package ExercicioResolvido;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.io.FileReader;
import java.io.BufferedReader;
import java.util.stream.Collectors;

public class Progam {
    static void main() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Digite o caminho : ");
        String path = sc.nextLine();
        File sourceFile = new File(path);

        try(BufferedReader br = new BufferedReader(new FileReader(path))){
            List<Product> list = new ArrayList<>();
            String linha = br.readLine();
            while(linha !=null){
                String[] fields = linha.split(",");
                list.add(new Product(fields[0], Double.parseDouble(fields[1])));
                linha = br.readLine();
            }

            double avg = list.stream()
                    .map(p -> p.getPrice())
                    .reduce(0.0 , (x, y) -> x + y) / list.size();

            System.out.println("Average Price : " + String.format("%.2f", avg));

            Comparator<String> comp = ((s1, s2) -> s1.toUpperCase().compareTo(s2.toUpperCase()));
            List<String> names = list.stream()
                    .filter(p -> p.getPrice() < avg)
                    .map(p -> p.getName())
                    .sorted(comp.reversed())
                    .collect(Collectors.toList());

            names.forEach(System.out::println);

        }catch (IOException e) {
            System.out.println("ERROR : " + e.getMessage());
        }

    }
}
