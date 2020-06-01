import lab4.car;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class naz {
    int quantity;
    String sent;
    public naz(int quantity, String sent){
        this.quantity = quantity;
        this.sent = sent;
    }


    public static void main(String[] args) {
        StringBuffer text = new StringBuffer();
        Scanner scan = new Scanner(System.in);
        System.out.println("Введіть текст:");
        text.append(scan.nextLine());
        String txt = text.toString();


        String [] sent = txt.split("[.!?]\\s*");
        String [][] words = new String[sent.length][];
        naz [] arr = new naz[sent.length] ;
        for(int i = 0; i<sent.length;i++){
            sent[i] = sent[i].replaceAll("\\p{Punct}", "");
            sent[i] = sent[i].replaceAll(" – ", "");
            sent[i] = sent[i].replaceAll("[\\s]{2,}", " ");
        }
        for(int i = 0; i< sent.length; i++){
            words[i] = sent[i].split("[\\s]");
            arr[i] = new naz(words[i].length, sent[i]);

        }
        Arrays.sort(arr, new sort());
        for(int i = 0; i < arr.length; i++){
            System.out.format("%d: [%s] Кількість слів: %d \n", i+1, arr[i].sent, arr[i].quantity);
        }
}}
class sort implements Comparator<naz>{
    @Override
    public int compare(naz o1, naz o2) {
        return o1.quantity - o2.quantity;
    }
}