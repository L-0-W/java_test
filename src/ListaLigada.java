public class ListaLigada {
    public static class no {
        int data;
        no proximo;
        no anterior;

        public no(int data, no proximo, no anterior) {
            this.data = data;
            this.proximo = proximo;
            this.anterior = anterior;
        }
    }

    public static class lista {
        private no head = null;
        private no follower = null;
        private final no tail = head;

        public lista(){
            no init = new no(0, this.tail, this.head);
            this.head = init;
            this.follower = init;
        }

        public void insert(int data){
            no novoNo = new no(data, this.head.proximo, this.follower);
            head.anterior = novoNo;
            this.follower.proximo = novoNo;
            this.follower = novoNo;
        }

        public void insert_many(int []data){
            for (int number : data) {
                no novoNo = new no(number, this.head.proximo, this.follower);
                this.head.anterior = novoNo;
                this.follower.proximo = novoNo;
                this.follower = novoNo;
            }
        }

        // LIFO - ultimo a entrar e o primeiro a sair
        public void pop(){
            no last = this.head.anterior;
            last.anterior.proximo = this.head.proximo;
            System.out.println("\n"+"Removido: " + last.data + "\n");

            this.head.anterior = last.anterior.proximo;
        }

        //FIFO - primeiro a entrar primeiro a sair
        public void dequeue(){

        }



        public void remover(int valor){
            no anterior = null;
            no atual = this.head;
            while(atual != null){

                if (atual.data == valor) {
                    assert anterior != null;
                    anterior.proximo = atual.proximo;
                    atual.proximo.anterior = anterior;
                };

                anterior = atual;

                atual = atual.proximo;

            }
        }

        public void loopList(){
            no atual = this.head.proximo;;


            while(true){
                System.out.println(atual.data);
                atual = atual.proximo;
            }
        }

        public void printLista(){
            no atual = this.head.proximo;

            while(true){
                System.out.println("Numero: " + atual.data);
                atual = atual.proximo;

                if (atual == this.head.proximo) break;
            }
        }
    }

    public static void main(String[] args){
        lista novaLista = new lista();

        int []data = {1, 2, 3, 4, 5};
        novaLista.insert_many(data);


        //novaLista.loopList();
        novaLista.printLista();
        novaLista.pop();
        novaLista.printLista();


        System.out.println("main");
    }
}
