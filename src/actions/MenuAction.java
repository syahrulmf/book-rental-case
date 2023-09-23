package actions;

import interfaces.IMenu;
import services.DataOutput;
import services.DataProses;
import utilities.Utility;

public class MenuAction implements IMenu {
  public static void showMainMenu() {
    boolean isLooping = true;

    do {
      DataOutput.printMenu("Main Menu" ,MAIN_MENU);

      int pilih = Utility.validateNumberWithRange("Pilih Menu : ", "Inputan harus berupa angka 0-4!", Utility.regexNumber, 4, 0);

      switch (pilih) {
        case 1:
          DataOutput.printDataBook(DataProses.listDataBook, "Data Book For Loan");
          isLooping = Utility.confirmMenu("Press 0 for Back To Main Menu: ");
          break;

        case 2:
          DataOutput.printDataBook(DataProses.listDataBook, "Available Book");
          String memberID = Utility.validateInput("Masukan Member ID : ", "Inputan harus berupa String!", Utility.regexID);
          String bookID = Utility.validateInput("Masukan Book ID : ", "Inputan harus berupa String!", Utility.regexID);
          int duration = Utility.validateNumberWithRange("Lama Peminjaman : ", "Inputan harus berupa angka positif!", Utility.regexNumber, 99, 1);
          DataProses.validateLoanBook(memberID, bookID, duration);
          isLooping = Utility.confirmMenu("Press 0 for Back To Main Menu: ");
          break;

        case 3:
          DataOutput.printDataLoan(DataProses.listDataLoanBookOrder, "Return Book");
          String loanID = Utility.validateInput("Masukan Loan ID : ", "ID Tidak terdaftar / Inputan harus berupa String!", Utility.regexID);
          DataProses.validateReturnBook(loanID);
          isLooping = Utility.confirmMenu("Press 0 for Back To Main Menu: ");
          break;

        case 4:
          DataOutput.printDataLoan(DataProses.listDataLoanBookOrder, "Data Loan Book Order");
          isLooping = Utility.confirmMenu("Press 0 for Back To Main Menu: ");
          break;

        case 0:
          isLooping = false;
          break;

        default:
          System.out.println("\nPilihan tidak dimengerti!\n");
      }
    } while(isLooping);

    System.out.println("\nAplikasi Berhenti...\n");
  }
}
