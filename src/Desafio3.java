import java.util.Scanner;

public class Desafio3 {
    public static class Student {
        private String nome;
        private double[] notas = {0, 0, 0};

        Student(){
            studentInserirDados();
        }

        public void studentInserirDados(){
            Scanner sc = new Scanner(System.in);

            System.out.print("Digite seu nome: ");
            this.nome = sc.nextLine();


            for(int i = 0; i < 3; i++){
                System.out.print("Digite usa nota do " + (i+1) + " trimestre: ");
                notas[i] = sc.nextDouble();

                int limite = 30;
                if(i >= 1) {limite = 35;}

                while((notas[i] > 35 && i >= 1) || (notas[i] > 30 && i == 0)){
                    System.out.print("Nota ultrapassa o limite do trimestre "+(i+1)+" e "+limite+": ");
                    notas[i] = sc.nextDouble();
                }
            };

            studentHavePass();
        }

        public void studentHavePass(){
            double notaFinal = 0;
            double falta = 0;

            String msg = "PASS";


            for(double nota : this.notas){
                notaFinal+=nota;
            }

            falta = 60.0 - notaFinal;

            if (falta <= 0) {msg = "PASS";}
            if (falta > 0) {msg = "FAILED";}

            System.out.println("FINAL GRADE = "+notaFinal);
            System.out.println(msg);
            if (falta > 0) {System.out.println("Faltante: "+falta);}
        }
    }

    public static void main(String[] args) {
        Student st = new Student();
    }
}