package algorithmsAndDataStructures.linear;

import java.util.Arrays;
import java.util.Random;

public class ShuffleRand {
    // A Function to generate a random permutation of arr[]
    /*
        The assumption here is, we are given a function rand()
        that generates random number in O(1) time.
        The idea is to start from the last element,
        swap it with a randomly selected element from the whole array (including last).
        Now consider the array from 0 to n-2 (size reduced by 1),
        and repeat the process till we hit the first element.*/
    /*
        explanation:
        1 2 3 ... i ... n

        What is a good shuffle?
        : any element has 1/n probability to a position

        1. The probability that ith element (including the last one)
        goes to last position is 1/n, because we randomly pick an element in first iteration.

        2. The probability that ith element goes to second last position can be proved to be 1/n by dividing it in two cases.
        Case 1: i = n-1 (index of last element):
        The probability of last element going to second last position is
        = (probability that last element doesn't stay at its original position)
           x (probability that the index picked in previous step is picked again so that the last element is swapped)
        So the probability = ((n-1)/n) x (1/(n-1)) = 1/n

        Case 2: 0 < i < n-1 (index of non-last):
        The probability of ith element going to second position
        = (probability that ith element is not picked in previous iteration)
          x (probability that ith element is picked in this iteration)
        So the probability = ((n-1)/n) x (1/(n-1)) = 1/n

        3. We can easily generalize above proof for any other position.
     */
    static void randomize( int arr[], int n)
    {
        // Creating a object for Random class
        Random r = new Random();

        // Start from the last element and swap one by one. We don't
        // need to run for the first element that's why i > 0
        for (int i = n-1; i > 0; i--) {

            // Pick a random index from 0 to i
            int j = r.nextInt(i + 1);

            // Swap arr[i] with the element at random index
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
        // Prints the random array
        System.out.println(Arrays.toString(arr));
    }

    // Driver Program to test above function
    public static void main(String[] args)
    {

        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8};
        int n = arr.length;
        randomize (arr, n);
    }
}
