package lab5;

public class Text{
    public Sentences [] sentences;

    public Text(String txt){
        String [] sentances_quantity = txt.split("(?<=[?!.])");
        sentences = new Sentences [sentances_quantity.length];
        for (int i = 0; i < sentances_quantity.length; i++) {
            if(!sentances_quantity[i].equals("")){
            sentences[i] = new Sentences(sentances_quantity[i]);
        }}
    }

}
