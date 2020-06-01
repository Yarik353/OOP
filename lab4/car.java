package lab4;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Objects;

/**
 * 9121
 * C11 = 2   2	Визначити клас автомобіль, який складається як мінімум з 5-и полів.
 **/

public class car  {
    //Визначення полів класу
    private String cartype;
    private String model;
    private String color;
    private int price;
    private int mileage;

    //Метод ініціалізації (Конструктор) класу
    public car (String itype, String imodel, String icolor, int iprice, int imileage){
        cartype = itype;
        model = imodel;
        color = icolor;
        price = iprice;
        mileage = imileage;
    }

    //Оскільки поля приватні то доступ до їх значень відбувається за допомогою Get-ерів описаних нижче
    public String getCartype(){
        return cartype;
    }
    public String getModel(){
        return model;
    }
    public String getColor(){
        return color;
    }
    public int getPrice(){
        return price;
    }
    public int getMileage(){
        return mileage;
    }

    public static void main(String[] args) {

        //Створення масиву з об'єктами класу "car"
        car [] arr = {new car("pickup", "Volkswagen", "red", 200_000, 2_000),
                        new car("crossover", "Ford", "silver", 30_000, 100),
                        new car("cabriolet", "Lamborghini", "yellow", 900_000, 0)
        };

        //Сортування за допомогою нижче визначеного класу і вивід даних за допомогою форматування
        Arrays.sort(arr, new sort_price());
        System.out.println("Масив сортований по ціні за зростанням:\n");
        for(int i = 0; i < arr.length; i++){
            System.out.format("Марка{ %-12s}  Тип{ %-12s}  Колір{ %-12s}  Ціна{ %-8d$}  Пробіг{ %-8d miles}\n", arr[i].getModel(), arr[i].getCartype(), arr[i].getColor(), arr[i].getPrice(), arr[i].getMileage());
        }

        String a = "alolo";
        String b = "alodh";
        String [] al = a.split("");
        String [] bl = b.split("");
        if (al[0].equals(bl[0])){
            System.out.println(a);
        }

        //Сортування за допомогою нижче визначеного класу і вивід даних за допомогою форматування
        Arrays.sort(arr, new sort_mileage_rev());
        System.out.println("\nМасив сортований по пробігу за спаданням:\n");
        for(int i = 0; i < arr.length; i++){
            System.out.format("Марка{ %-12s}  Тип{ %-12s}  Колір{ %-12s}  Ціна{ %-8d$}  Пробіг{ %-8d miles}\n", arr[i].getModel(), arr[i].getCartype(), arr[i].getColor(), arr[i].getPrice(), arr[i].getMileage());
        }
    }

}
//Визначення класу для сортування по ціні за зростанням
class sort_price implements Comparator<car>{
    @Override
    public int compare(car o1, car o2) {
        return o1.getPrice() - o2.getPrice();
    }
}
//Визначення класу для сортування по пробігу за спаданням
class sort_mileage_rev implements Comparator<car>{
    @Override
    public int compare(car o1, car o2) {
        return o2.getMileage() - o1.getMileage();
    }
}
