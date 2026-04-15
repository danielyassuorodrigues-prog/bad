package ExercicioFIxacao;

import ExercicioResolvido.Product;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Progam {
    static void main() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Digite o caminho : ");
        String path = sc.nextLine();
        File sourceFile = new File(path);
        double sum = 0.0 ;

        List<String> email = new ArrayList<>();

        System.out.println("Informe um sálario para ser usada como comparação : ");
        double comparacao = sc.nextDouble();

        try(BufferedReader br = new BufferedReader(new FileReader(path))){
            List<Funcionario> list = new ArrayList<>();
            String linha = br.readLine();

            while(linha != null) {
                String fields[] = linha.split(",");
                list.add(new Funcionario(fields[0], fields[1], Double.parseDouble(fields[2])));
                linha = br.readLine();
                double fi = Double.parseDouble(fields[2]);
                if(fi > comparacao) {
                    email.add(fields[1]);
                }

                String nome = fields[0];

                if(nome.charAt(0) == 'M') {
                    sum+= fi;
                }


            }

            Collections.sort(email);





            for(String e : email) {
                System.out.println(e);
            }

            System.out.println("Soma dos S´larios dos funcionários com a letra M : " + sum );

        }catch(IOException e) {
            System.out.println("ERROR : " + e.getMessage());
        }
        sc.close();
    }
}
