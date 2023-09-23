package services;

import abstracts.BookForLoan;
import models.Comic;
import models.LoanBookOrder;
import models.Member;
import models.Novel;
import repositories.RepositoryBookForLoan;
import repositories.RepositoryMember;
import utilities.Utility;

import java.util.ArrayList;
import java.util.List;

public class DataProses {
  public static int numberID = 1;
  public static List<Member> listDataMember = RepositoryMember.getAllMember();

  public static List<LoanBookOrder> listDataLoanBookOrder = new ArrayList<LoanBookOrder>();

  public static List<BookForLoan> listDataBook = RepositoryBookForLoan.getAllBookForLoan();

  public static List<BookForLoan> getDataBook(String bookID) {
    List<BookForLoan> dataBook = new ArrayList<BookForLoan>();

    for (BookForLoan book : DataProses.listDataBook) {
      if (book.getBookID().equalsIgnoreCase(bookID)) {
        dataBook.add(book);
      }
    }

    return dataBook;
  }

  public static List<Member> getDataMember(String memberID) {
    List<Member> dataMember = new ArrayList<Member>();

    for (Member member : DataProses.listDataMember) {
      if (member.getMemberID().equalsIgnoreCase(memberID)) {
        dataMember.add(member);
      }
    }

    return dataMember;
  }

  public static List<LoanBookOrder> getDataLoan(String loanID) {
    List<LoanBookOrder> dataBook = new ArrayList<LoanBookOrder>();

    for (LoanBookOrder data : DataProses.listDataLoanBookOrder) {
      if (data.getLoanID().equalsIgnoreCase(loanID)) {
        dataBook.add(data);
      }
    }

    return dataBook;
  }

  public static List<BookForLoan> getDataBookForLoan(List<BookForLoan> dataBook) {
    List<BookForLoan> bookTemp = new ArrayList<BookForLoan>();

    if (!dataBook.isEmpty()) {
      if (dataBook.get(0) instanceof Comic) {
        Comic comic = new Comic();
        comic.setBookID(dataBook.get(0).getBookID());
        comic.setLoanPrice(dataBook.get(0).getLoanPrice());
        comic.setGenre(((Comic) dataBook.get(0)).getGenre());
        comic.setStock(dataBook.get(0).getStock());
        comic.setBookPrice(dataBook.get(0).getBookPrice());
        comic.setAuthor(dataBook.get(0).getAuthor());
        comic.setTitle(dataBook.get(0).getTitle());

        comic.calculateBookLoanPrice();

        bookTemp.add(comic);
      } else if (dataBook.get(0) instanceof Novel) {
        Novel novel = new Novel();
        novel.setBookID(dataBook.get(0).getBookID());
        novel.setLoanPrice(dataBook.get(0).getLoanPrice());
        novel.setAseries(((Novel) dataBook.get(0)).isAseries());
        novel.setStock(dataBook.get(0).getStock());
        novel.setBookPrice(dataBook.get(0).getBookPrice());
        novel.setAuthor(dataBook.get(0).getAuthor());
        novel.setTitle(dataBook.get(0).getTitle());

        novel.calculateBookLoanPrice();

        bookTemp.add(novel);
      }
    }


    return bookTemp;
  }

  public static void validateLoanBook(String memberID, String bookID, int duration) {
    String result = "";

    List<BookForLoan> dataBook = getDataBook(bookID);
    List<BookForLoan> bookTemp = getDataBookForLoan(dataBook);
    List<Member> dataMember = getDataMember(memberID);

    if (!dataMember.isEmpty() && !dataBook.isEmpty() && !bookTemp.isEmpty()){
      // add data order
      listDataLoanBookOrder.add(new LoanBookOrder(Utility.getUniqueID("Ord-", "Order"), dataMember.get(0), bookTemp.get(0), duration, 0));
      // stock - 1
      dataBook.get(0).setStock(dataBook.get(0).getStock() - 1);

      result = "Loan Success...";
      numberID++;
    } else {
      result = "Loan Failed! Make sure your input is valid.";
    }

    System.out.println("\n" + result + "\n");
  }

  public static void validateReturnBook(String loanID) {
    String result = "";
    List<LoanBookOrder> dataLoan = getDataLoan(loanID);

    if (!dataLoan.isEmpty()) {
      // remove loan order data from loan book order list
      listDataLoanBookOrder.removeIf(data -> data.getLoanID().toLowerCase().contains(loanID.toLowerCase()));
      // get book based on loan order
      List<BookForLoan> dataBook = getDataBook(dataLoan.get(0).getLoanBook().getBookID());
      // return book stock
      dataBook.get(0).setStock(dataBook.get(0).getStock() + 1);
      result = "Return Book Success!";
    } else {
      result = "Return Book Failed! Make sure Loan ID is valid!";
    }

    System.out.println("\n" + result + "\n");
  }

}
