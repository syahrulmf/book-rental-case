package repositories;

import abstracts.BookForLoan;
import models.Comic;
import models.Novel;

import java.util.Arrays;
import java.util.List;

public class RepositoryBookForLoan {
  public static List<BookForLoan> getAllBookForLoan() {
    // Comic
    Comic comic1 = new Comic("Uzumaki Naruto", "Masashi Kisimoto", 55000, 0, 10, "Shounen");
    Comic comic2 = new Comic("The Worst Client", "Masashi Kisimoto", 55000, 0, 10, "Shounen");
    Comic comic3 = new Comic("For the Sake of Dreams...!!", "Masashi Kisimoto", 35000, 0, 15, "Shounen");
    Comic comic4 = new Comic("Hunter X Hunter : The Day of Departure", "Yoshihiro Togashi", 50000, 0, 15, "Fantasy");
    Comic comic5 = new Comic("Hunter X Hunter : A Struggle in the Mist", "Yoshihiro Togashi", 80000, 0, 25, "Fantasy");

    // Novel
    Novel novel1 = new Novel("Harry Potter and the Philosopher's Stone", "J.K Rowling", 150000, 0, 10, true);
    Novel novel2 = new Novel("Harry Potter and the Chamber of Secrets", "J.K Rowling", 150000, 0, 10, true);
    Novel novel3 = new Novel("Harry Potter and the Prisoner of Azkaban", "J.K Rowling", 200000, 0, 15, true);
    Novel novel4 = new Novel("Ayah Aku Berbeda", "Tere Liye", 35000, 0, 15, false);
    Novel novel5 = new Novel("Madre", "Dee Lestari", 80000, 0, 10, false);

    List<BookForLoan> listDataBook = Arrays.asList(comic1, comic2, comic3, comic4, comic5, novel1, novel2, novel3, novel4, novel5);

    return listDataBook;
  }
}
