package 배열과_리스트.스택_큐;
import java.util.Scanner;

public class 오름차순수열만들기 {
    public static void main(String[] args) {
        오름차순수열만들기 t = new 오름차순수열만들기();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
            System.out.println();
        }

    }
}
