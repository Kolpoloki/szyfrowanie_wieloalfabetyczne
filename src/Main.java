import java.util.Scanner;

public class Main {
    static Scanner scan = new Scanner(System.in);
    static String alphabet = "ABCDEFGHIJKLMNOPQRSTUWXYZ";

    public static void main(String[] args) {
        System.out.println("Podaj tekst do zaszyfrowania:");
        String phrase = getPhrase();

        System.out.println("Podaj słowo/zdanie klucz:");
        String keyword = getKeyword();

        System.out.println("Zakodowany tekst:");
        String encryptedText = encryptPhrase(phrase,keyword);
        System.out.println(encryptedText);

        System.out.println("Odkodowany tekst:");
        System.out.println(decryptPhrase(encryptedText,keyword));


    }
    public static String getPhrase(){
        String phrase = scan.nextLine().toUpperCase();
        String reducedPhrase = "";
        for (int i = 0; i < phrase.length(); i++) {
            if (alphabet.contains(String.valueOf(phrase.charAt(i)))){
                reducedPhrase = reducedPhrase.concat(String.valueOf(phrase.charAt(i)));
            }
        } return reducedPhrase;
    }

    public static String getKeyword(){
        String keyword = scan.nextLine().toUpperCase();
        String reducedKeyword = "";
        for (int i = 0; i < keyword.length(); i++) {
            if (!reducedKeyword.contains(String.valueOf(keyword.charAt(i)))
                    && alphabet.contains(String.valueOf(keyword.charAt(i)))){
                reducedKeyword = reducedKeyword.concat(String.valueOf(keyword.charAt(i)));
            }
        } return reducedKeyword;
    }
    public static String encryptPhrase(String phrase, String keyword){
        int alphabetLength = alphabet.length();
        int phraseLength = phrase.length();
        int keywordLength = keyword.length();
        String encryptedPhrase = "";
        int numberKey;
        char encryptedChar;
        for (int i = 0; i < phraseLength; i++) {
            numberKey = alphabet.indexOf(keyword.charAt(i % keywordLength));
            encryptedChar = alphabet.charAt((alphabet.indexOf(phrase.charAt(i)) + numberKey) % alphabetLength);
            encryptedPhrase = encryptedPhrase.concat(String.valueOf(encryptedChar));
        }
        return encryptedPhrase;
    }

    public static String decryptPhrase(String encryptedPhrase, String keyword){
        int alphabetLength = alphabet.length();
        int phraseLength = encryptedPhrase.length();
        int keywordLength = keyword.length();
        String decryptedPhrase = "";
        int numberKey;
        char encryptedChar;
        for (int i = 0; i < phraseLength; i++) {
            numberKey = alphabet.indexOf(keyword.charAt(i % keywordLength));
            encryptedChar = alphabet.charAt((alphabet.indexOf(encryptedPhrase.charAt(i)) - numberKey + alphabetLength) % alphabetLength);
            decryptedPhrase = decryptedPhrase.concat(String.valueOf(encryptedChar));
        }
        return decryptedPhrase;
    }


}
