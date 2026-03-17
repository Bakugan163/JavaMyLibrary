
import java.time.LocalDate;

public class Book {
    public String title;
    public String author;
    public int year;
    public String genre;
    public boolean status;
    public double  rating;
    public String feedback;
    public LocalDate date;

       
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public String getFeedback() {
        return feedback;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Book(String title, String author, int  year, String genre, boolean  status, double  rating, String feedback) {
        this.title = title;
        this.author = author;
        this.year = year;
        this.genre = genre;
        this.status = status;
        this.rating = rating;
        this.feedback = feedback;
        this.date = LocalDate.now();
        
    }
   
     public void show() {
        System.out.println("Название: " + title);
        System.out.println("Автор: " + author);
        System.out.println("Год издания: " + year);
        System.out.println("Жанр: " + genre);
        String statusText = status ? "прочитана" : "не прочитана";
        System.out.println("Статус: " + statusText);
        System.out.println("Рейтинг: " + rating);
        System.out.println("Отзыв: " + feedback);
        System.out.println("Дата добавления: " + date);
        
        
    }

}
