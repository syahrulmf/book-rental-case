package abstracts;

import interfaces.ILoanBook;
import interfaces.IPrice;

public abstract class BookForLoan extends Book implements IPrice, ILoanBook {
  private double loanPrice;
  private int stock;

  public BookForLoan() {
  }

  public BookForLoan(String bookID, String title, String author, double bookPrice, double loanPrice, int stock) {
    super(bookID, title, author, bookPrice);
    this.loanPrice = loanPrice;
    this.stock = stock;
  }

  @Override
  public void calculateBookLoanPrice() {

  }

  public double getLoanPrice() {
    return loanPrice;
  }

  public void setLoanPrice(double loanPrice) {
    this.loanPrice = loanPrice;
  }

  public int getStock() {
    return stock;
  }

  public void setStock(int stock) {
    this.stock = stock;
  }
}
