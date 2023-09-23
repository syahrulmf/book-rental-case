package models;

import abstracts.BookWithSeries;
import utilities.Utility;

public class Novel extends BookWithSeries {
  public Novel() {
  }

  public Novel(String title, String author, double bookPrice, double loanPrice, int stock, boolean isAseries) {
    super(Utility.getUniqueID("Novel-", "Novel"), title, author, bookPrice, loanPrice, stock, isAseries);

    calculateBookLoanPrice();
  }

  @Override
  public void calculateBookLoanPrice() {
    double price = 0;

    if (getStock() >= 10) {
      price = (NOVEL_PERCENTAGE + STOCK_10_UP_PERCENTAGE) * getBookPrice();
    } else if (getStock() < 10) {
      price = (NOVEL_PERCENTAGE + STOCK_UNDER_10_PERCENTAGE) * getBookPrice();
    }

    setLoanPrice(price);
  }

}
