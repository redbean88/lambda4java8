package part10;

import java.util.function.Consumer;

public class BuilderMain {
    public static void main(String[] args) {

        Book book = new Book.Builder()
                .with(builder -> {
                    builder.name = "test";
                    builder.code= "1231";
                    builder.author = "jack";
                }).build();
        System.out.println("book.toString() = " + book.toString());
    }
}

class Book {
    private String name;
    private String code;
    private String author;

    private Book() {
    }

    private Book(String name, String code, String author) {
        this.name = name;
        this.code = code;
        this.author = author;
    }

    public static class Builder{
        public String name;
        public String code;
        public String author;

        public Builder with(Consumer<Builder> consumer){
            consumer.accept(this);
            return this;
        }

        public Book build(){
            return new Book(name, code, author);
        }
    }

    @Override
    public String toString() {
        return "Book{" +
                "name='" + name + '\'' +
                ", code='" + code + '\'' +
                ", author='" + author + '\'' +
                '}';
    }
}
