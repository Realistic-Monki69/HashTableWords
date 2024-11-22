import java.io.*;
import java.util.*;

public class HashTableWords
{
    public static void main(String[] args) throws IOException
    {
        int size = 500;
        LinkedList[] hashTable = new LinkedList[size];

        // Initialize hash table buckets
        for (int i = 0; i < hashTable.length; i++)
        {
            hashTable[i] = new LinkedList();
        }

        File myObj = new File("1000-most-common-words.txt");
        Scanner scan = new Scanner(myObj);

        while (scan.hasNext())
        {
            String data = scan.next();
            int bucketIndex = Math.abs(data.hashCode() % size); // Ensure non-negative bucket index
            hashTable[bucketIndex].add(data);
        }
        scan.close();

        for (int i = 0; i < size; i++)
        {
            if (!hashTable[i].isEmpty())
            {
                System.out.println("Bucket " + i + ": " + hashTable[i]);
            }
        }

        Scanner userInput = new Scanner(System.in);
        System.out.println("\nEnter a word to search:");
        String word = userInput.nextLine();
        int bucketIndex = Math.abs(word.hashCode() % size);

        if (hashTable[bucketIndex].contains(word))
        {
            System.out.println("The word '" + word + "' is found in bucket " + bucketIndex + ".");
        }
        else
        {
            System.out.println("The word '" + word + "' is not found in the hash table.");
        }
        userInput.close();
    }
}
