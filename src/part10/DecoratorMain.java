package part10;

public class DecoratorMain {
    public static void main(String[] args) {
        
        ReplaceChar replaceChar = new ReplaceChar();
        ReplaceChar2 replaceChar2 = new ReplaceChar2();
        
        Parser parser = replaceChar.andThen(replaceChar2);

        Text text = new Text("start");
        System.out.println("parser.parse(\"\") = " + parser.parse(text).getText());
    }
}

class Text{
    String text;

    public Text(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }
}


interface Parser{
    Text parse(Text text);

    default Parser andThen(Parser next){
        return text -> next.parse(parse(text));
    }
}

class ReplaceChar implements Parser{

    @Override
    public Text parse(Text text) {
        return new Text(text.getText() + " end");
    }
}
class ReplaceChar2 implements Parser{

    @Override
    public Text parse(Text text) {
        return new Text(text.getText() +  " done");
    }
}