package lab5;

public class Text{
    public Sentences [] sentences;

    public Text(String txt){
        String [] sentencesQuantity = txt.split("(?<=[?!.])");
        sentences = new Sentences [sentencesQuantity.length];
        for (int i = 0; i < sentencesQuantity.length; i++) {
            if(!sentencesQuantity[i].equals("")){
            sentences[i] = new Sentences(sentencesQuantity[i]);
        }}
    }

}
