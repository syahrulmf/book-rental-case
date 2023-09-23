package abstracts;

public abstract class BookWithSeries extends BookForLoan {
  private boolean isAseries;

  public BookWithSeries() {
  }

  public BookWithSeries(String bookID, String title, String author, double bookPrice, double loanPrice, int stock, boolean isAseries) {
    super(bookID, title, author, bookPrice, loanPrice, stock);
    this.isAseries = isAseries;
  }

  public boolean isAseries() {
    return isAseries;
  }

  public void setAseries(boolean aseries) {
    isAseries = aseries;
  }
}
