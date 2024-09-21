import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import java.util.HashMap;

public class Main
{
    private static Scanner scanner = new Scanner(System.in);
    private static int badGuessCounter = 0;
    
    public static void main(String[] args) {
        clearTerminal();
        createHangman();
        insertLetter();
        if(badGuessCounter < 6){ System.out.println("You Win!");}
        
    }

    private static void insertLetter() {
        System.out.println("Enter letter:");
        printWord(word.length());
        int length = word.length();
        System.out.println("\n\n\n\n"+ hangman(badGuessCounter));
        for(int i = 0; i < length; i++) {
            while(true) {
                String guessedCharacter = scanner.next();
                char correctChar = word.charAt(i);
                String correctCharacter = Character.toString(correctChar);
                if(guessedCharacter.equalsIgnoreCase(correctCharacter)) {
                    guessedLetters.add(correctCharacter);
                    break;
                } else { 
                    badGuessCounter++;
                }
                clearTerminal();
                System.out.println("You were incorrect!");
                System.out.println("Enter letter:");
                printWord(word.length() - i);
                System.out.println("\n\n\n"+ hangman(badGuessCounter));
                if(badGuessCounter >= 6){ break;}
            }

            clearTerminal();

            System.out.println("You were correct!");
            System.out.println("Enter letter:");
            printWord((word.length() - i) - 1);
            System.out.println("\n\n\n"+ hangman(badGuessCounter));
            if(badGuessCounter >= 6) { 
                System.out.println("\u000C" +"You lose!\n\n\n\n\n\n"+ hangman(badGuessCounter));
                break;}
        }
    }
    
    
    
    private static ArrayList<String> guessedLetters = new ArrayList<String>();
    
    private static HashMap<String, String> hangmans = new HashMap<String, String>();
    private static void createHangman() {
        
        hangmans.put("bare",
        "         ▦----▦    \n" +
        "         |    |    \n" +
        "         |         \n" +
        "         |         \n" +
        "         |         \n" +
        "         |         \n" +
        "         |         \n" +
        "---------▦---------\n" 
        );
        
        hangmans.put("oneLeg",
        "         ▦----▦    \n" +
        "         |    |    \n" +
        "         |    o    \n" +
        "         |  -OOO-  \n" +
        "         |   OOO   \n" +
        "         |   |     \n" +
        "         |         \n" +
        "---------▦---------\n" 
        );
        
        hangmans.put("noLegs",
        "         ▦----▦    \n" +
        "         |    |    \n" +
        "         |    o    \n" +
        "         |  -OOO-  \n" +
        "         |   OOO   \n" +
        "         |         \n" +
        "         |         \n" +
        "---------▦---------\n" 
        );
        
        hangmans.put("oneArm",
        "         ▦----▦    \n" +
        "         |    |    \n" +
        "         |    o    \n" +
        "         |  -OOO   \n" +
        "         |   OOO   \n" +
        "         |         \n" +
        "         |         \n" +
        "---------▦---------\n" 
        );
        
        hangmans.put("body",
        "         ▦----▦    \n" +
        "         |    |    \n" +
        "         |    o    \n" +
        "         |   OOO   \n" +
        "         |   OOO   \n" +
        "         |         \n" +
        "         |         \n" +
        "---------▦---------\n" 
        );
        
        hangmans.put("head",
        "         ▦----▦    \n" +
        "         |    |    \n" +
        "         |    o    \n" +
        "         |         \n" +
        "         |         \n" +
        "         |         \n" +
        "         |         \n" +
        "---------▦---------\n" 
        );
        
        hangmans.put("over",
        "         ▦----▦    \n" +
        "         |    |    \n" +
        "         |    o    \n" +
        "         |  -OOO-  \n" +
        "         |   OOO   \n" +
        "         |   | |   \n" +
        "         |         \n" +
        "---------▦---------\n"
        );
    }
    
    private static String hangman(int trigger) {
        switch (trigger){
            case 0:
                return hangmans.get("bare");
            case 1:
                return hangmans.get("head");
            case 2:
                return hangmans.get("body");
            case 3:
                return hangmans.get("oneArm");
            case 4:
                return hangmans.get("noLegs");
            case 5:
                return hangmans.get("oneLeg");
            default:
                return hangmans.get("over");
        }
    }
    
    private static String word = generateWord();
    
    private static void printWord(int lines) {
        for(int x = 0; x < guessedLetters.size(); x++) {
                System.out.print(guessedLetters.get(x) + " ");
            }
            
        for(int i = lines; i > 0; i--) {
            System.out.print("_ ");
        }
    }

    private static String generateWord() {
        ArrayList<String> words = new ArrayList<String>();
        words.add("COOL");
        words.add("AWESOME");
        words.add("FUN");
        Random rand = new Random();
        int randomInt = rand.nextInt(3);
        if(randomInt == 1) {return words.get(0);}
        else if(randomInt == 2) {return words.get(1);}
        else {return words.get(2);}
        
    }


public static void clearTerminal() {
    try {
        if (System.getProperty("os.name").contains("Windows")) {
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        } else {
            System.out.print("\033[H\033[2J");
            System.out.flush();
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
}

}