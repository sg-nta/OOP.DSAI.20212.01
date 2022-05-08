import java.util.Scanner;

public class SumOfTwoMatrices {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Enter the number of rows");
        int m = keyboard.nextInt();

        System.out.println("Enter the number of columns");
        int n = keyboard.nextInt();

        int matrix1[][] = new int[m][n];
        System.out.println("Enter the elements of the first matrix");
        for (int i=0; i<m; i++) 
        for (int j=0; j<n; j++)
        matrix1[i][j] = keyboard.nextInt();
        System.out.println("The first matrix: ");
        for (int i=0; i<m; i++) 
        {
        for (int j=0; j<n; j++)
        System.out.print(matrix1[i][j] + " "); 
        System.out.println();
        }

        int matrix2[][] = new int[m][n];
        System.out.println("Enter the elements of the second matrix");
        for (int i=0; i<m; i++) 
        for (int j=0; j<n; j++)
        matrix2[i][j] = keyboard.nextInt();
        System.out.println("The second matrix: ");
        for (int i=0; i<m; i++) 
        {
        for (int j=0; j<n; j++)
        System.out.print(matrix2[i][j] + " "); 
        System.out.println();
        }

 
        int sumofthetwo[][] = new int[m][n];
        System.out.println("The sum of the two matrices:");
        for (int i=0; i<m; i++)
        for (int j=0; j<n; j++)
        sumofthetwo[i][j] = matrix1[i][j] + matrix2[i][j];
        for (int i=0; i<m; i++) 
        {
        for (int j=0; j<n; j++)
        System.out.print(sumofthetwo[i][j] + " "); 
        System.out.println();
        }


    }
    
}
