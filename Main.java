import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        clearTerminal();
        createHangman();
        String displayText = null;
        generateLetters();
        int badGuessCounter = 0;
        while(true) {
            
            clearTerminal();
            System.out.println("Enter letter:");
            printStuff();
            

            System.out.println("\n\n\n\n"+ hangman(badGuessCounter));
            if(displayText != null) {
                System.out.println(displayText);
            } 
            else {
                System.out.println(" ");
            }
            
            System.out.println("\n\n\n");
            String letter = scanner.next().toUpperCase();
            if (lettersInWord.contains(letter)) {
                

                if(guessedLetters.contains(letter)) {
                    displayText = "You already guessed that letter!";
                }
                else {
                    displayText = "Correct!";
                }
                guessedLetters.add(letter);
            } else {
                displayText = "Incorrect!";
                badGuessCounter++;
                if(badGuessCounter >= 6) { 
                    clearTerminal();
                    System.out.println("You lose!\n\n\n\n\n\n"+ hangman(badGuessCounter));
                    break;
                }
            }
            boolean win = false;
            for(int i = 0; i < lettersInWord.size(); i++) {
                System.out.println(lettersInWord);
                System.out.println(guessedLetters);
                if(guessedLetters.contains(lettersInWord.get(i))) {
                    if(i == lettersInWord.size() - 1) {
                        win = true;
                        break;
                    }
                } else {
                    break;
                }
            }
            if(win) {
                clearTerminal();
                System.out.println("You Win!");
                break;
            }
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

    private static void generateLetters() {
        for(int i = 0; i < word.length(); i++) {
            String character = Character.toString(word.charAt(i));
            if(lettersInWord.contains(word.charAt(i)) == false) {
                lettersInWord.add(character);
            }
        }
    }

    private static ArrayList<String> lettersInWord = new ArrayList<String>();
    private static ArrayList<String> guessedLetters = new ArrayList<String>();

    private static String word = generateWord();
    private static void printStuff() {
        for(int i = 0; i < word.length(); i++) {
            
            if(guessedLetters.contains(Character.toString(word.charAt(i)))) {
                System.out.print(word.charAt(i) + " ");
            } else {
                System.out.print("_ ");
            }

        }
    }

    private static void clearTerminal() {
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
}
