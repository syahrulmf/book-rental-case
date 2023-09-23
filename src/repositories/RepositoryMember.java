package repositories;

import models.Member;

import java.util.Arrays;
import java.util.List;

public class RepositoryMember {
  public static List<Member> getAllMember() {
    Member member1 = new Member("Risman","Bandung", "M-001");
    Member member2 = new Member("Budi","Bandung", "M-002");
    Member member3 = new Member("Resti","Kab. Bandung", "M-003");

    List<Member> listDataMember = Arrays.asList(member1, member2, member3);

    return listDataMember;
  }
}
