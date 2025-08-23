import java.util.Scanner;

public class Desafio1 {
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


    public static void main(String[] args) {
        Retangulo rt = new Retangulo();
        rt.Area();
        rt.Perimetro();
        rt.Diagonal();
    }
}