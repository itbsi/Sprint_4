package validator;

public class Praktikum {

    public static void main(String[] args) {
        String cardHolderName = "Boris Ian";
        Account account = new Account(cardHolderName);
        System.out.println(account.checkNameToEmboss());
    }
}
