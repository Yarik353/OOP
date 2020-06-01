package lab3;


import java.util.Scanner;

/**
 * 9121
 * C3= 1   StringBuffer
 * C17=0    Знайти найбільшу кількість речень заданого тексту, в яких є однакові слова.
 **/
public class jv3 {


    public static void main(String[] args) {
        StringBuffer text = new StringBuffer("Колобок – сказка,сказка знакомая каждому взрослому, придется по душе и маленьким детям. Они быстро учат учат учат простые слова песенки Колобка и с удовольствием подпевают родителям. Из этой сказки малыши узнают, как испекла бабка для деда Колобка и положила на окошко остывать. Устал Колобок лежать, да решил спрыгнуть с окошка и укатиться со двора за ворота. Встретил он по дороге Зайчика, Волка и Медведя, спел им свою песенку и убежал от них, не смогли его звери съесть. Катился дальше Колобок и повстречалась ему Лисичка. Попытался и ее Колобок обмануть, да не получилось у него, хитрее Лиса оказалась. Подманила поближе и скушала вкусный колобок.");
        String txt = text.toString();

        String [] sent = txt.split("[.!?]\\s*");
        String [][] words = new String[sent.length][];

        for(int i = 0; i<sent.length;i++){
            sent[i] = sent[i].replaceAll("\\p{Punct}", "");
            sent[i] = sent[i].replaceAll(" – ", "");
            sent[i] = sent[i].replaceAll("[\\s]{2,}", " ");
        }
        for(int i = 0; i< sent.length; i++){
            words[i] = sent[i].split("[\\s]");
        }
        int cn = 1;
        System.out.print("Речення та їх слова:");
        for (String[] i : words) {
            System.out.format("\n%d: ", cn);
            cn+=1;
            for (String j : i) {
                System.out.format("[%s]", j);
            }
        }

        int quantity = 0;
        for(int i = 0; i < words.length;i++){
            int check = quantity;
            for(int j = 0 ; j < words[i].length - 1; j++){
                if(check != quantity){
                    break;
                }
                for(int z = j + 1 ; z < words[i].length; z++){
                    if(words[i][j].equals(words[i][z])){
                        quantity +=1;
                        break;
                    }
                }
            }
        }
        System.out.print("\nРеченя в яких є однакові слова: "+quantity);
    }

}
