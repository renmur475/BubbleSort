import java.util.Scanner;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;


public class App {

    public static void main(String[] args) throws IOException
    {
        System.out.println("Which array would you like to sort?");
        System.out.println("1. Create random array and save to file");
        System.out.println("2. Create manually and save to a file");
        System.out.println("3. Read array from file");

        Scanner options = new Scanner(System.in);
        int choice = options.nextInt();

        if(choice == 1) // Create a random array
        {
            System.out.print("Enter array length: ");
            int arrayLength = options.nextInt();

            int[] array = new int[arrayLength];
            array = createRandomArray(arrayLength);

            Scanner input = new Scanner(System.in);
            System.out.print("Enter file name (include .txt): "); //User chooses the file name
            String fileName = input.nextLine();
            
            writeArrayToFile(array, fileName);
            bubbleSort(array);

           input.close();
           
        }

        if(choice == 2) //Manually enter everything about an array
        {
            System.out.println("Enter array length: "); //User manually creates array
            Scanner length = new Scanner(System.in);
            int arrayLength = length.nextInt();
            int[] array = new int[arrayLength];

            Scanner number = new Scanner(System.in);

            for(int i = 0; i < arrayLength; i++)
            {
                System.out.println("Enter element at index " + i);
                int element = number.nextInt();
                array[i] = element;
            }

            System.out.print("Enter file name (include .txt): "); //User chooses the file name
            Scanner input = new Scanner(System.in);
            String fileName = input.nextLine();
            
            length.close();
            number.close();
            input.close();

            writeArrayToFile(array, fileName);
            bubbleSort(array);
        }

        if(choice == 3) //Reads array from file
        {
            System.out.print("Enter file name (include .txt): ");
            Scanner file = new Scanner(System.in);
            String fileName = file.nextLine();
            file.close();

            int[] array = readFileToArray(fileName);
            bubbleSort(array);

        }

        options.close();
    }


    public static int[] createRandomArray(int arrayLength)
    {
        int[] randomArray = new int[arrayLength];
        
        //Creates random elements
        for(int i = 0; i < arrayLength; i++)
        {
            Random rand = new Random();
            int randomNumber = rand.nextInt(101); 
            randomArray[i] = randomNumber;
        }
        return randomArray;
    }


    public static void writeArrayToFile(int[] array, String fileName) throws IOException
{
    //Writes the array to the file
    FileWriter writer = new FileWriter(fileName);
    for(int i = 0; i < array.length; i++)
    {
        writer.write(array[i] + "\n");
    }
    writer.close();
}


    public static int[] readFileToArray(String fileName) throws IOException
    {
        BufferedReader counter = new BufferedReader(new FileReader(fileName));

        //Decides the length of array
        int length = 0;
        String currentLine;
        do {
            currentLine = counter.readLine();
            if(currentLine == null)
            {
                break;
            }
            length++;
        } while (true);
        counter.close();

        BufferedReader reader = new BufferedReader(new FileReader(fileName)); 

        //Assigns elements to a String array
        String[] strArray = new String[length];
        String Line;
        for(int j = 0; j < length; j++)
        {
            for(int i = 0; i < length; i++)
                {
                    if((Line = reader.readLine()) != null)
                        {
                            strArray[i] = Line;
                        }
                }
        } 

        //Converts String array into int array
        int[] array = new int[strArray.length];
        for (int i = 0; i < strArray.length; i++) 
        {
            array[i] = Integer.parseInt(strArray[i]);
        }
        reader.close();

        return array;
     }

    public static void bubbleSort(int[] array)
    {
        int i;
        int j;
        int k;
        int n = array.length;
        int temp;

        System.out.println("Unsorted array: "); //Prints unsorted array
        for(k = 0; k < array.length; k++)
        {
            System.out.println(array[k]);
        }

        for(i = 0; i < n - 1; i++)
        {
            for(j = 0; j < n - i - 1; j++)
            {
                if(array[j] < array[j+1]) //If the current number is smaller than the next...
                {
                    temp = array[j];
                    array[j] = array[j + 1]; //Switch places
                    array[j + 1] = temp;
                }
            }
        }

        System.out.println("Sorted array: "); //Prints sorted array
        for(k = 0; k < array.length; k++)
        {
            System.out.println(array[k]);
        }
    }

}







