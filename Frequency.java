import java.util.Scanner;

class Frequency {
    static int n;
    static int[] arr;

    Frequency() {
        n = 0;
    }

    static void freq_finder(int K) {
        int temp;
        int[] freq = new int[K];
        int[] rep = new int[K];
    int k = 0;
    int flag=0;
    int samp[] = new int[n];
 for(int i =0;i<=n-1;i++)
 samp[i] =arr[i];

    for (int i = 0; i <= n-1; i++)
    {
        for (int j = i + 1; j <= n-1; j++) 
        {
            if(k < K)
            {
            if (samp[i] == samp[j] && samp[i]!= -1)
            {
                rep[k] = samp[i];
                freq[k]++;
                flag =1;
                samp[j] = -1;
            
            }
            }
        }
        if(flag ==1 && k < K)
        {
        k++;
        flag =0;
        }
        else if(samp[i] != -1 && k < K)
        {
            rep[k] = samp[i];
            freq[k] =0;
            k++;
        }
    }

        for (int i = 0; i < K; i++) {
            System.out.println("[" + rep[i] + "]" + "  " + (freq[i]+1));
        }
        for (int i = 0; i < k; i++)
 {
    for (int j = 0; j < k - i - 1; j++)
     {
         if (freq[j]+1 < freq[j + 1]+1)
           {
                temp = rep[j];
                 rep[j] = rep[j + 1];
                 rep[j + 1] = temp;
                 temp = freq[j];
                  freq[j] = freq[j + 1];
                  freq[j + 1] = temp;
                } 
         else if (freq[j]+1 == freq[j + 1]+1)
             {
		if (rep[j]+1 < rep[j + 1]+1) 
			{
                        temp = rep[j + 1];
                        rep[j + 1] = rep[j];
                        rep[j] = temp;
                        temp = freq[j + 1];
                        freq[j + 1] = freq[j];
                        freq[j] = temp;
                    }
                }
            }
        }
        if(k< K)
            System.out.println("The number of elements in the array is less than the desired highest occurrences (k) entered");
                for(int i=0; i<K ;i++)
        System.out.print(rep[i] + " ");
    }
    

    public static void main(String args[]) {
        int k = 0;
        Frequency f = new Frequency();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter the size of the array");
        n = scanner.nextInt();
        arr = new int[n];
        System.out.println("Please enter the " + n + " array elements:");
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        System.out.println("Please enter the number of highest occurrences to find(K)");
        k = scanner.nextInt();
        freq_finder(k);
        scanner.close();
    }
}
