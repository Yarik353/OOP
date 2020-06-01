package lab5;

public class Words  {
    public Letters[] letter;
    public String wordd;
    public Words(String word){
        wordd = word;
        String [] splited_word = word.split("");
        letter = new Letters[splited_word.length];
        for (int i = 0; i < splited_word.length; i++) {
            letter[i] = new Letters(splited_word[i]);
        }
    }
}

