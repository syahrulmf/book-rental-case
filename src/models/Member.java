package models;

import abstracts.Person;

public class Member extends Person {
  private String memberID;

  public Member() {
  }

  public Member(String name, String address, String memberID) {
    super(name, address);
    this.memberID = memberID;
  }

  public String getMemberID() {
    return memberID;
  }

  public void setMemberID(String memberID) {
    this.memberID = memberID;
  }
}
