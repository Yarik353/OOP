package lab5;

import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Введіть текст:");
        Text text = new Text(scan.nextLine());
        String [] array= {"апельсин", "яблуко", "банан", "ананас", "манго"};
        int [] quantity_array = new int[array.length];
        int counter;
        for(int i = 0; i < array.length; i++){
            counter = 0;
            for(int j = 0; j < text.sentences.length; j++){
                for(int k = 0; k < text.sentences[j].qunt; k++){
                    if(array[i].equals(text.sentences[j].words[k].wordd)){
                        counter+=1;
                        quantity_array[i]=counter;
                        break;
                    }
                }
            }
        }
        for(int i = 0; i < array.length; i++){
            System.out.format("Слово \"%s\" зустрічається у %s реченнях.\n", array[i], quantity_array[i]);
        }
    }
}

