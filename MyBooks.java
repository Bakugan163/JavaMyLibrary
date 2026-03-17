import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class MyBooks {

    List<Book> books = new ArrayList<>();

    public void print() {
        //вывод всех книг
        for (Book c : books) {
            c.show();
        }
    }

    public void add(Book book) {
        books.add(book);
    }

     public void add(String title, String author, int year, String genre, boolean  status, double  rating, String feedback) {
    
        //Добавление в коллекцию
        books.add(new Book(title, author, year, genre, status, rating, feedback)); 
        save();
    }

       public Book findByTitle(String title) {
        //поиск по названию
        for (Book c : books) {
            if (c.title.equalsIgnoreCase(title.trim())) {
                return c;
            }
        }
        return null;
    }

     public void markAsRead(String title, double rating, String feedback) {
    for (Book book : books) {
        if (book.getTitle().equalsIgnoreCase(title)) {
            book.setStatus(true);
            book.setRating(rating);
            book.setFeedback(feedback);
            System.out.println("Книга '" + title + "' отмечена как прочитанная!");
            return;
        }
    }
}
  
    public List<Book> findByAuthor(String author) {
        //поиск по автору
    List<Book> result = new ArrayList<>();  
    for (Book c : books) {
        if (author.equalsIgnoreCase(c.author)) { 
            result.add(c);
        }
    }
    return result;
}


   public List<Book> findByGenre(String genre) {
    //поиск по жанру
    List<Book> result = new ArrayList<>();  
    for (Book c : books) {
        if (genre.equalsIgnoreCase(c.genre)) {
            result.add(c);
        }
    }
    return result;
}

       public void save() {
        //сохранение
        try (FileWriter wr = new FileWriter("mylibrary.csv")) {
            for (Book c : books) {
                String statusText = c.status ? "прочитана" : "не прочитана";
                wr.write(c.title + "|" + c.author + "|" + c.year + "|" + c.genre + "|" + statusText + "|" + c.rating + "|" + c.feedback + "\n");
            }
        }
        catch (Exception ex) {
            System.out.println("Error save books");
        }
    }

     public void load() {
        //Загрузка из файла
            try (BufferedReader br = new BufferedReader(new FileReader("mylibrary.csv"))) {
            String line;
            while ((line = br.readLine())!= null) {
                String[] items = line.split("\\|", -1);
                if (items.length >= 7) {
                String title = items [0].trim();
                String author = items[1].trim();
                int year = Integer.parseInt(items[2]);
                String genre = items [3].trim();
                boolean status = items[4].equalsIgnoreCase("прочитана");
                double rating = Double.parseDouble(items[5]);
                String feedback = items[6].trim();

                books.add(new Book(title, author, year, genre, status, rating, feedback));
            }
            }
        } catch (Exception ex) {
            System.out.println("Error: " + ex.getMessage());
        }
    }

        // Сортировка по рейтингу 
    public void sortByRating() {
        books.sort((b1, b2) -> Double.compare(b2.rating, b1.rating));
    }

    // Сортировка по году 
    public void sortByYear() {
        books.sort(Comparator.comparingInt(b -> b.year));
    }

    // Сортировка по дате добавления
    public void sortByDateAdded() {
        books.sort(Comparator.comparing(b -> b.date));
    }


     public void remove(String title) {
        //Удаление по названию
        for (int i = 0; i<books.size();i++) {
            if (books.get(i).title.equals(title.trim())){
                books.remove(i);
                save();
                return;
            }
        }

    }
        //удаление всей библиотеки
        public void deleteAllBooks() {
        books.clear();
        save();    
}
}