package services;

import abstracts.BookForLoan;
import models.LoanBookOrder;

import java.util.List;

public class DataOutput {
  public static void printDataBook(List<BookForLoan> listData, String title) {
    int number = 1;
    String formatTabel = "| %-3s | %-12s | %-40s | %-18s | %-6s |%n";

    System.out.println("===============================================================================================");
    System.out.format("| %-91s |%n", title);
    System.out.println("===============================================================================================");
    System.out.printf(formatTabel, "No", "Book ID", "Title", "Author", "Stock");
    System.out.println("===============================================================================================");

    // iterates over the list
    for(BookForLoan data: listData){
      if (data.getStock() > 0) {
        System.out.format(formatTabel, number, data.getBookID(), data.getTitle(), data.getAuthor(), data.getStock());
        number++;
      }
    }
    System.out.println("===============================================================================================");
    System.out.format("| %-3s | %-85s |%n", 0, "Kembali Ke Main Menu");
    System.out.println("===============================================================================================");
  }

  public static void printDataLoan(List<LoanBookOrder> listData, String title) {
    int number = 1;
    String formatTabel = "| %-3s | %-8s | %-12s | %-10s | %-40s | %-15s | %-13s | %-8s |%n";

    System.out.println("======================================================================================================================================");
    System.out.format("| %-130s |%n", title);
    System.out.println("======================================================================================================================================");
    System.out.printf(formatTabel, "No", "Loan ID", "Member Name", "Book ID", "Title", "Loan Book Price", "Loan Duration", "Loan Fee");
    System.out.println("======================================================================================================================================");
    for (LoanBookOrder data : listData) {
      System.out.format(formatTabel, number, data.getLoanID(), data.getMember().getName(), data.getLoanBook().getBookID(), data.getLoanBook().getTitle(), String.format("%.1f", data.getLoanBook().getLoanPrice()), data.getLoanDuration(), String.format("%.1f", data.getLoanFee()));
      number++;
    }
    System.out.println("======================================================================================================================================");
  }

  public static void printMenu(String title, String[] listMenu) {
    int number = 1;
    String formatTabel = "| %-3s | %-48s |%n";
    System.out.println(title);
    System.out.println("==========================================================");
    System.out.printf(formatTabel, "No", "Menu");
    System.out.println("==========================================================");

    for (String menu : listMenu) {
      if (number == listMenu.length) {
        System.out.printf(formatTabel, 0, menu);
      }else {
        System.out.printf(formatTabel, number, menu);
      }
      number++;
    }
    System.out.println("==========================================================");
  }
}
