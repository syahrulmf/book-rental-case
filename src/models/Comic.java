package models;

import abstracts.BookForLoan;

import utilities.Utility;

public class Comic extends BookForLoan {
  String genre;

  public Comic() {
  }

  public Comic(String title, String author, double bookPrice, double loanPrice, int stock, String genre) {
    super(Utility.getUniqueID("Comic-", "Comic"), title, author, bookPrice, loanPrice, stock);
    this.genre = genre;

    calculateBookLoanPrice();
  }

  @Override
  public void calculateBookLoanPrice() {
    double price = 0;

    if (getStock() < 10) {
      price = (COMIC_PERCENTAGE + STOCK_UNDER_10_PERCENTAGE) * getBookPrice();
    } else if (getStock() >= 10) {
      price = (COMIC_PERCENTAGE + STOCK_10_UP_PERCENTAGE) * getBookPrice();
    }

    setLoanPrice(price);
  }

  public String getGenre() {
    return genre;
  }

  public void setGenre(String genre) {
    this.genre = genre;
  }
}
