package lab5;

public class Words  {
    public Letters[] letter;
    public String wordd;
    public Words(String word){
        wordd = word;
        String [] splitedWord = word.split("");
        letter = new Letters[splitedWord.length];
        for (int i = 0; i < splitedWord.length; i++) {
            letter[i] = new Letters(splitedWord[i]);
        }
    }
}

