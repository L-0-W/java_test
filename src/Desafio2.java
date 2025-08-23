import java.util.Scanner;

public class Desafio2 {
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

        public void AumentarSalario() {
            System.out.print("\nDigite a % de quantos deseja aumentar seu salario: ");
            Scanner sc = new Scanner(System.in);
            double porcentagem = sc.nextDouble();

            this.salario *= (porcentagem / 100) + 1;
            System.out.println();
            MostrarDados();
        }

        public double recalcularLiquido(){
            return this.salario - this.imposto;
        }
    }

    public static void main(String[] args) {
        Funcionario fn = new Funcionario();
        fn.AumentarSalario();
    }
}