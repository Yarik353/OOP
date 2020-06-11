package lab5;

public class Sentences{
    Punctuations[] punctuation;
    public Words[] words;
    public  String sentt;
    public  int qunt;
    public Sentences (String sent){
        sentt = sent;
        String punctuationSymbols = ".!,-?";
        sent = sent.replaceAll("[\\s]{2,}", " ");
        String [] splitedSentence = sent.split("(?=,|\\.|\\,|\\S+\\-+\\s|!|\\?)|\\s");
        int counter_puncts = 0;
        int counter_words = 0;
        for (int i = 0; i < splitedSentence.length; i++) {
            if(punctuationSymbols.contains(splitedSentence[i])){
                if(!splitedSentence[i].equals("")){
                    punctuation = addPuncts(counter_puncts, punctuation, splitedSentence[i]);
                    counter_puncts+=1;
                }
            }
            else{
                words = addWord(counter_words, words, splitedSentence[i]);
                counter_words+=1;
            }
        }
        qunt=counter_words;
    }
    public Punctuations[] addPuncts(int n, Punctuations[] arr, String x)
    {
        int i;
        Punctuations[] newarr = new Punctuations[n + 1];
        for (i = 0; i < n; i++)
            newarr[i] = arr[i];

        newarr[n] = new Punctuations(x);
        return newarr;
    }
    public  Words[] addWord(int n, Words[] arr, String x)
    {
        int i;
        Words[] newarr = new Words[n + 1];
        for (i = 0; i < n; i++)
            newarr[i] = arr[i];
        newarr[n] = new Words(x);
        return newarr;
    }
}
