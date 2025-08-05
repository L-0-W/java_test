import java.util.*;

public class QuickSort {
    public static class Car {
        private int id;
        private String color;
        private int price;

        public Car(int id, String color, int price) {
            this.id = id;
            this.color = color;
            this.price = price;
        }

        public int getPrice() {
            return price;
        }
    }

    public static class Cars {
        private List<Car> cars;

        public Cars() {
            this.cars = new ArrayList<>();
        }

        public void searchCars(int id) {
            cars.forEach(car -> {
                if (car.id == id) {
                    System.out.print(car.getPrice());
                }
            });
        }

        public void addCar(Car car) {
            cars.add(car);
        }
    }

    private static int steps = 0;

    private static void quickSort(int a[], int start_index, int end_index) {
        if(start_index >= end_index) return;

        int pivot = partition(a, start_index, end_index);

        quickSort(a, start_index, pivot);
        quickSort(a, pivot + 1, end_index);
    }

    private static int partition(int a[], int start_index, int end_index) {

        Random rand = new Random();

        int pivot_index = rand.nextInt(end_index - start_index) + start_index;

        if (pivot_index == start_index || pivot_index == end_index) {
            pivot_index = rand.nextInt(end_index - start_index) + start_index;
        }

        int pivot = a[start_index];

        int lt = start_index + 1;
        int rt = end_index - 1;

        while(lt <= rt) {
            while(lt <= end_index && a[lt] <= pivot) lt++;
            while(rt >= start_index && a[rt] > pivot) rt--;

            if(lt < rt) {
                swap(a, lt, rt);
            }
        }

        swap(a, start_index, rt);
        return rt;
    }

    private static void swap(int a[], int i, int j){
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
        steps++;
    }


    public static void main(String[] args) {
        Random rand = new Random();

        Cars cars = new Cars();
        Car newCar = new Car(1, "Preto", 2000);
        Car newCar2 = new Car(2, "Preto", 2000);

        cars.addCar(newCar);
        cars.addCar(newCar2);

        cars.searchCars(1);

    }
}