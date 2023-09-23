package models;

import abstracts.BookForLoan;
import interfaces.IFee;

public class LoanBookOrder implements IFee {
  private String loanID;
  private Member member;
  private BookForLoan loanBook;
  private int loanDuration;
  private double loanFee;

  public LoanBookOrder() {
  }

  public LoanBookOrder(String loanID, Member member, BookForLoan loanBook, int loanDuration, double loanFee) {
    this.loanID = loanID;
    this.member = member;
    this.loanBook = loanBook;
    this.loanDuration = loanDuration;
    this.loanFee = loanFee;

    calculateLoanFee();
  }

  @Override
  public void calculateLoanFee() {
    double fee = 0;

    fee = loanDuration * loanBook.getLoanPrice();

    setLoanFee(fee);
  }

  public String getLoanID() {
    return loanID;
  }

  public void setLoanID(String loanID) {
    this.loanID = loanID;
  }

  public Member getMember() {
    return member;
  }

  public void setMember(Member member) {
    this.member = member;
  }

  public BookForLoan getLoanBook() {
    return loanBook;
  }

  public void setLoanBook(BookForLoan loanBook) {
    this.loanBook = loanBook;
  }

  public int getLoanDuration() {
    return loanDuration;
  }

  public void setLoanDuration(int loanDuration) {
    this.loanDuration = loanDuration;
  }

  public double getLoanFee() {
    return loanFee;
  }

  public void setLoanFee(double loanFee) {
    this.loanFee = loanFee;
  }
}
