<<<<<<< HEAD
package Lab6;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.io.File;

 class lab6{

    public static String vowel_count(String contents) {  
        int[] vowelCount = new int[5];
        for (int i = 0; i < contents.length(); i++) {
            char c = contents.charAt(i);
            if (c == 'a') {
                vowelCount[0]++;
            } else if (c == 'e') {
                vowelCount[1]++;
            } else if (c == 'i') {
                vowelCount[2]++;
            } else if (c == 'o') {
                vowelCount[3]++;
            } else if (c == 'u') {
                vowelCount[4]++;
            }
        }

        return "a:" + vowelCount[0] + "\n" +
                "e:" + vowelCount[1] + "\n" +
                "i:" + vowelCount[2] + "\n" +
                "o:" + vowelCount[3] + "\n" +
                "u:" + vowelCount[4];
    }

    public static String digit_count(String contents) {   // Function to count the unique digits.
        int[] digitCount = new int[10];
        for (int i = 0; i < contents.length(); i++) {
            char c = contents.charAt(i);
            if (c == '0') {
                digitCount[0]++;
            } else if (c == '1') {
                digitCount[1]++;
            } else if (c == '2') {
                digitCount[2]++;
            } else if (c == '3') {
                digitCount[3]++;
            } else if (c == '4') {
                digitCount[4]++;
            } else if (c == '5') {
                digitCount[5]++;
            } else if (c == '6') {
                digitCount[6]++;
            } else if (c == '7') {
                digitCount[7]++;
            } else if (c == '8') {
                digitCount[8]++;
            } else if (c == '9') {
                digitCount[9]++;
            }
        }

        return "0:" + digitCount[0] + "\n" +
                "1:" + digitCount[1] + "\n" +
                "2:" + digitCount[2] + "\n" +
                "3:" + digitCount[3] + "\n" +
                "4:" + digitCount[4] + "\n" +
                "5:" + digitCount[5] + "\n" +
                "6:" + digitCount[6] + "\n" +
                "7:" + digitCount[7] + "\n" +
                "8:" + digitCount[8] + "\n" +
                "9:" + digitCount[9];

    }

    static String[] bubbleSortByNumber(String[] arr) {              //Function to bubble sort the given array
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                try {
                    String[] split1 = arr[j].split(" ");
                    String[] split2 = arr[j + 1].split(" ");
                    int num1 = Integer.parseInt(split1[1]);
                    int num2 = Integer.parseInt(split2[1]);
                    if (num1 > num2) {
                        String temp = arr[j];
                        arr[j] = arr[j + 1];
                        arr[j + 1] = temp;
                    }
                } catch (NullPointerException e) {
                    continue;
                }
            }
        }
        return arr;

    }

    public static void least_5_words(String[] contents) {
        for (int i = 0; i < 5; i++) {
            System.out.println(contents[i]);
        }
    }

    public static void top_5_words(String[] contents) {
        for (int i = contents.length - 1; i > contents.length - 6; i--) {
            System.out.println(contents[i]);
        }
    }

    public static int indexOf(char[] arr, char target) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                return i;
            }
        }
        return -1;
    }

    public static String[] to_unique(String content) {         //Function to find unique words

        String[] words = content.split("[\\s.,()]");
        String[] uniqueWords = new String[words.length];

        int count = 0;

        for (int i = 0; i < words.length; i++) {
            int j;
            for (j = i + 1; j < words.length; j++) {
                if (words[i].equals(words[j])) {
                    break;
                }
            }
            if (j == words.length) {
                uniqueWords[count] = words[i].replaceAll("[\\s.,()]", "");
                count++;
            }
        }
        return uniqueWords;
    }

    public static String[] words_count(String[] unique_words, String[] words) {
        int cnt = unique_words.length;                                 

        String[] words_cnt = new String[cnt];                   //Function to find unique words count
        for (int i = 0; i < cnt; i++) {
            int c = 0;
            for (int j = 0; j < words.length; j++) {
                try {
                    if (words[j].equals(unique_words[i])) {
                        c += 1;
                    }
                } catch (NullPointerException e) {
                    continue;
                }
            }
            if (unique_words[i] == "") {
                continue;
            } else {
                words_cnt[i] = unique_words[i] + " " + c;
            }
        }
        return words_cnt;
    }

    public static void main(String[] args) {
        String filename = "text.txt";

        try {
            String content = new String(Files.readAllBytes(Paths.get(filename)));

            content = (content.toLowerCase());

            String[] words = content.split("[\\s.,()]");

            String[] unique_words = to_unique(content);
            String[] count_words = words_count(unique_words, words);

            String[] sortedArr = bubbleSortByNumber(count_words);

            char[] uniqueChars = new char[5000];
            int uniqueCount = 0;

            for (String word : words) {
                char[] letters = word.toCharArray();
                for (char letter : letters) {
                    if (indexOf(uniqueChars, letter) == -1) {
                        uniqueChars[uniqueCount] = letter;
                        uniqueCount++;
                    }
                }
            }

            String[] char_cnt = new String[uniqueCount];
            for (int i = 0; i < uniqueCount; i++) {
                int cnt = 1;
                for (int j = 0; j < words.length; j++) {
                    char[] tc = words[j].toCharArray();
                    for (int k = 0; k < tc.length; k++) {
                        if (uniqueChars[i] == tc[k]) {
                            cnt += 1;
                        }
                    }
                    char_cnt[i] = uniqueChars[i] + " " + cnt;

                }
            }
            
            System.out.println("The total vowel counts are: ");
            System.out.println(vowel_count(content));
            
            System.out.println("The total digit counts are: ");
            System.out.println(digit_count(content));
            
            System.out.println("The Least Five repeated words and their count: ");System.out.println("--------------------------------------------------------------------");
            System.out.println("The Top Five repeated words and their count: ");
            top_5_words(sortedArr);
            
            String[] sortedChar = bubbleSortByNumber(char_cnt);
            System.out.println("The Least Five repeated characters and their count: ");
            least_5_words(sortedChar);
            
            System.out.println("The Top Five repeated characters and their count: ");
            top_5_words(sortedChar);
            

        } catch (IOException e) {
            e.printStackTrace();
        }

        
        System.out.println("Optional Question - Top categories");
        

        String filename1 = "htmlFile.txt";
        String startTag = "<div class=\"trending-head\">Top Categories</div>";
        String endTag = "</ul>			</div>";
        try (BufferedReader br = new BufferedReader(new FileReader(filename1))) {
            FileWriter writer = new FileWriter("display.txt", true);
            String[] contentLines = new String[20];
            int lineCount = 0;
            String line;
            boolean insideDiv = false;
            while ((line = br.readLine()) != null) {

                if (line.contains(startTag)) {
                    insideDiv = true;
                } else if (line.contains(endTag)) {
                    insideDiv = false;
                    break;
                } else if (insideDiv) {
                    contentLines[lineCount++] = line;
                }
            }
            
            System.out.println("The top categories are: ");
            for (int j = 0; j < lineCount; j++) {
                Pattern pattern = Pattern.compile("<a[^>]>(.?)</a>");
                Matcher matcher = pattern.matcher(contentLines[j]);
                if (matcher.find()) {
                    String menuText = matcher.group(1);
                    System.out.println((j + 1) + ". " + menuText);
                    writer.write((j + 1) + ". " + menuText + "\n");
                }
            }
            
            writer.close();
        }

        catch (IOException e) {
            e.printStackTrace();
        }
    }
}
=======
package Lab6;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.io.File;

 class lab6{

    public static String vowel_count(String contents) {  //Function to check vowel count
        int[] vowelCount = new int[5];
        for (int i = 0; i < contents.length(); i++) {
            char c = contents.charAt(i);
            if (c == 'a') {
                vowelCount[0]++;
            } else if (c == 'e') {
                vowelCount[1]++;
            } else if (c == 'i') {
                vowelCount[2]++;
            } else if (c == 'o') {
                vowelCount[3]++;
            } else if (c == 'u') {
                vowelCount[4]++;
            }
        }

        return "a:" + vowelCount[0] + "\n" +
                "e:" + vowelCount[1] + "\n" +
                "i:" + vowelCount[2] + "\n" +
                "o:" + vowelCount[3] + "\n" +
                "u:" + vowelCount[4];
    }

    public static String digit_count(String contents) {   // Function to count the unique digits.
        int[] digitCount = new int[10];
        for (int i = 0; i < contents.length(); i++) {
            char c = contents.charAt(i);
            if (c == '0') {
                digitCount[0]++;
            } else if (c == '1') {
                digitCount[1]++;
            } else if (c == '2') {
                digitCount[2]++;
            } else if (c == '3') {
                digitCount[3]++;
            } else if (c == '4') {
                digitCount[4]++;
            } else if (c == '5') {
                digitCount[5]++;
            } else if (c == '6') {
                digitCount[6]++;
            } else if (c == '7') {
                digitCount[7]++;
            } else if (c == '8') {
                digitCount[8]++;
            } else if (c == '9') {
                digitCount[9]++;
            }
        }

        return "0:" + digitCount[0] + "\n" +
                "1:" + digitCount[1] + "\n" +
                "2:" + digitCount[2] + "\n" +
                "3:" + digitCount[3] + "\n" +
                "4:" + digitCount[4] + "\n" +
                "5:" + digitCount[5] + "\n" +
                "6:" + digitCount[6] + "\n" +
                "7:" + digitCount[7] + "\n" +
                "8:" + digitCount[8] + "\n" +
                "9:" + digitCount[9];

    }

    static String[] bubbleSortByNumber(String[] arr) {              //Function to bubble sort the given array
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                try {
                    String[] split1 = arr[j].split(" ");
                    String[] split2 = arr[j + 1].split(" ");
                    int num1 = Integer.parseInt(split1[1]);
                    int num2 = Integer.parseInt(split2[1]);
                    if (num1 > num2) {
                        String temp = arr[j];
                        arr[j] = arr[j + 1];
                        arr[j + 1] = temp;
                    }
                } catch (NullPointerException e) {
                    continue;
                }
            }
        }
        return arr;

    }

    public static void least_5_words(String[] contents) {
        for (int i = 0; i < 5; i++) {
            System.out.println(contents[i]);
        }
    }

    public static void top_5_words(String[] contents) {
        for (int i = contents.length - 1; i > contents.length - 6; i--) {
            System.out.println(contents[i]);
        }
    }

    public static int indexOf(char[] arr, char target) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                return i;
            }
        }
        return -1;
    }

    public static String[] to_unique(String content) {         //Function to find unique words

        String[] words = content.split("[\\s.,()]");
        String[] uniqueWords = new String[words.length];

        int count = 0;

        for (int i = 0; i < words.length; i++) {
            int j;
            for (j = i + 1; j < words.length; j++) {
                if (words[i].equals(words[j])) {
                    break;
                }
            }
            if (j == words.length) {
                uniqueWords[count] = words[i].replaceAll("[\\s.,()]", "");
                count++;
            }
        }
        return uniqueWords;
    }

    public static String[] words_count(String[] unique_words, String[] words) {
        int cnt = unique_words.length;                                 

        String[] words_cnt = new String[cnt];                   //Function to find unique words count
        for (int i = 0; i < cnt; i++) {
            int c = 0;
            for (int j = 0; j < words.length; j++) {
                try {
                    if (words[j].equals(unique_words[i])) {
                        c += 1;
                    }
                } catch (NullPointerException e) {
                    continue;
                }
            }
            if (unique_words[i] == "") {
                continue;
            } else {
                words_cnt[i] = unique_words[i] + " " + c;
            }
        }
        return words_cnt;
    }

    public static void main(String[] args) {
        String filename = "text.txt";

        try {
            String content = new String(Files.readAllBytes(Paths.get(filename)));

            content = (content.toLowerCase());

            String[] words = content.split("[\\s.,()]");

            String[] unique_words = to_unique(content);
            String[] count_words = words_count(unique_words, words);

            String[] sortedArr = bubbleSortByNumber(count_words);

            char[] uniqueChars = new char[5000];
            int uniqueCount = 0;

            for (String word : words) {
                char[] letters = word.toCharArray();
                for (char letter : letters) {
                    if (indexOf(uniqueChars, letter) == -1) {
                        uniqueChars[uniqueCount] = letter;
                        uniqueCount++;
                    }
                }
            }

            String[] char_cnt = new String[uniqueCount];
            for (int i = 0; i < uniqueCount; i++) {
                int cnt = 1;
                for (int j = 0; j < words.length; j++) {
                    char[] tc = words[j].toCharArray();
                    for (int k = 0; k < tc.length; k++) {
                        if (uniqueChars[i] == tc[k]) {
                            cnt += 1;
                        }
                    }
                    char_cnt[i] = uniqueChars[i] + " " + cnt;

                }
            }
            
            System.out.println("The total vowel counts are: ");
            System.out.println(vowel_count(content));
            
            System.out.println("The total digit counts are: ");
            System.out.println(digit_count(content));
            
            System.out.println("The Least Five repeated words and their count: ");System.out.println("--------------------------------------------------------------------");
            System.out.println("The Top Five repeated words and their count: ");
            top_5_words(sortedArr);
            
            String[] sortedChar = bubbleSortByNumber(char_cnt);
            System.out.println("The Least Five repeated characters and their count: ");
            least_5_words(sortedChar);
            
            System.out.println("The Top Five repeated characters and their count: ");
            top_5_words(sortedChar);
            

        } catch (IOException e) {
            e.printStackTrace();
        }

        
        System.out.println("Optional Question - Top categories");
        

        String filename1 = "htmlFile.txt";
        String startTag = "<div class=\"trending-head\">Top Categories</div>";
        String endTag = "</ul>			</div>";
        try (BufferedReader br = new BufferedReader(new FileReader(filename1))) {
            FileWriter writer = new FileWriter("display.txt", true);
            String[] contentLines = new String[20];
            int lineCount = 0;
            String line;
            boolean insideDiv = false;
            while ((line = br.readLine()) != null) {

                if (line.contains(startTag)) {
                    insideDiv = true;
                } else if (line.contains(endTag)) {
                    insideDiv = false;
                    break;
                } else if (insideDiv) {
                    contentLines[lineCount++] = line;
                }
            }
            
            System.out.println("The top categories are: ");
            for (int j = 0; j < lineCount; j++) {
                Pattern pattern = Pattern.compile("<a[^>]>(.?)</a>");
                Matcher matcher = pattern.matcher(contentLines[j]);
                if (matcher.find()) {
                    String menuText = matcher.group(1);
                    System.out.println((j + 1) + ". " + menuText);
                    writer.write((j + 1) + ". " + menuText + "\n");
                }
            }
            
            writer.close();
        }

        catch (IOException e) {
            e.printStackTrace();
        }
    }
}
>>>>>>> 889cba18defb8c9a9c6cf91865d09439fd9cc69f
