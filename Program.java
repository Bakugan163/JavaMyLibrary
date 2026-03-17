import java.util.List;
import java.util.Scanner;


public class Program {
    public static void main(String[] args) {
        MyBooks bob = new MyBooks();
        bob.load();
        

         Scanner input = new Scanner(System.in, "CP866");

          while(true) {
      
        System.out.println("1. Добавить книгу");
        System.out.println("2. Отметить книгу как прочитанную");
        System.out.println("3. Поиск книги по автору");
        System.out.println("4. Поиск книги по названию");
        System.out.println("5. Поиск книги по жанру");
        System.out.println("6. Показать все книги по рейтингу");
        System.out.println("7. Показать все книги по году");
        System.out.println("8. Показать все книги по дате добавления");
        System.out.println("9. Показать всю библиотеку");
        System.out.println("10. Удаление книги");
        System.out.println("11. Удаление всей библиотеки");
        System.out.println("0. Выход");

        String user = input.next();

        if (user.equals("1")) {

            input.nextLine();
            System.out.println("Введите название книги");
            String title = input.nextLine();
            System.out.println("Введите ФИО автора");
            String author = input.nextLine();
            System.out.println("Введите год публикации книги");
            int year = input.nextInt();
            input.nextLine();
            System.out.println("Укажите жанр книги");
            String genre = input.nextLine();
            System.out.println("Книга прочитана? Да/нет");
            String statusInput = input.next();

            boolean status;
            Double rating = 0.0;
            String feedback = "";

            if (statusInput.equalsIgnoreCase("да")) {
                status = true;
                System.out.println("Укажите рейтинг");
            rating = input.nextDouble();
            input.nextLine();
            System.out.println("Напишите отзыв");
            feedback = input.nextLine();
            System.out.println("Книга добавлена в библиотеку");

            } else { 
                
                status = false;
                System.out.println("Добавлена как непрочитанная");
            }
            
            bob.add(title, author, year, genre, status, rating, feedback);
            
            } else if (user.equals("2")) {
            input.nextLine();
            System.out.println("Введите название книги, которую прочитали");
            String title = input.nextLine();
            System.out.println("Укажите рейтинг:");
            double rating = input.nextDouble();
            input.nextLine();
            System.out.println("Напишите отзыв:");
            String feedback = input.nextLine();
            bob.markAsRead(title, rating, feedback);
            bob.save();
           
               
            
        } else if (user.equals("3")) {
            input.nextLine();
            System.out.println("Введите ФИО автора");
            String author = input.nextLine();
            List<Book> found = bob.findByAuthor(author);
            if (found.isEmpty()) {  
        System.out.println("Книги не найдены!");
        } else {
        System.out.println("Найдено книг: " + found.size());
        for (Book book : found) {
           book.show();  
        }
    }



        } else if (user.equals("4")) {
            input.nextLine();
            System.out.println("Введите название книги");
            String title = input.nextLine();
            Book found = bob.findByTitle(title);
            if (found == null) {
            System.out.println("Книга не найдена!");
        } else {
            found.show();
        }

            
        } else if (user.equals("5")) {
            input.nextLine();
            System.out.println("Введите жанр книги");
            String genre = input.nextLine();
            List<Book> found = bob.findByGenre(genre);
            if (found.isEmpty()) {
                System.out.println("Книги не найдены!");
            } else {
                System.out.println("Найдено книг: " + found.size());
                for (Book book : found) {
                    book.show();
                }
            
            } 

        }else if (user.equals("6")) {
                bob.sortByRating();
                bob.print();


            }else if (user.equals("7")) {
                bob.sortByYear();
                bob.print();
            
            }else if (user.equals("8")) {
                bob.sortByDateAdded();
                bob.print();

        } else if (user.equals("10")) {
            input.nextLine();
            System.out.println("Какую книгу Вы хотите удалить?");
            String title = input.nextLine();
            bob.remove(title);

            } else if (user.equals("11")) {
                 System.out.println("Хотите удалить всю библиотеку?");
                 String delete = input.next();
                 if (delete.equalsIgnoreCase("да")) {
                    bob.deleteAllBooks();
                    System.out.println("Библиотека удалена");
               } else {
                System.out.println("Отмена удаления");
               }        

        } else if (user.equals("0")) {
            System.out.println("Выход");
                break;

        } else if (user.equals("9")) {
          bob.print();
          }
        
}
            input.close();     

}
}
