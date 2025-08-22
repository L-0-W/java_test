import java.util.Scanner;

public class Main {
    public static class Retangulo {
        private double largura;
        private double altura;

        Retangulo(){
            Scanner sc = new Scanner(System.in);

            System.out.print("Digite a largura: ");
            this.largura = sc.nextDouble();

            System.out.print("Digite a altura: ");
            this.altura = sc.nextDouble();
        }

        public double Area(){
            double math = this.largura * this.altura;
            System.out.println("Area: " + math);
            return math;
        }

        public double Perimetro(){

            double sum = (this.largura + this.altura);
            sum+=sum;
            System.out.println("Perimetro: " + sum);

            return sum;
        }

        public double Diagonal(){
            double aQ = this.altura * this.altura;
            double lQ = this.largura * this.largura;

            double sum = aQ + lQ;

            System.out.println("Diagonal: " + Math.sqrt(sum));

            return Math.sqrt(sum);
        }
    }


    public static class Funcionario {
        private String nome;
        private double salario;
        private double imposto;

        Funcionario(){
            Scanner sc = new Scanner(System.in);

            System.out.print("Digite seu nome: ");
            this.nome = sc.nextLine();
            System.out.print("Digite seu salario: ");
            this.salario = sc.nextDouble();
            System.out.print("Digite seu imposto: ");
            this.imposto = sc.nextDouble();

            System.out.println("\n");

            MostrarDados();
        }

        public void MostrarDados(){
            System.out.println("Nome: " + this.nome);
            System.out.println("Salario Bruto: " + this.salario);
            System.out.println("Imposto: " + this.imposto);
            System.out.println("Salario Liquido: " + recalcularLiquido());
        }

        public void AumentarSalario(int porcentagem) {
            this.salario *= ((double) porcentagem / 100) + 1;
            System.out.println();
            MostrarDados();
        }

        public double recalcularLiquido(){
            return this.salario - this.imposto;
        }
    }

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

        /*
        Retangulo rt = new Retangulo();
        rt.Area();
        rt.Perimetro();
        rt.Diagonal();

        Funcionario fn = new Funcionario();
        fn.AumentarSalario(10);
        */

        Student st = new Student();
    }
}