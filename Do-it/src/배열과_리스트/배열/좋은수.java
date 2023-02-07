package 배열과_리스트.배열;
import java.util.Scanner;

// 설명 : 주어진 n개의 수에서 다른 두 수의 합으로 표현되는 수가 있다면 그 수를 좋은 수라고 한다. n개의 수 중 좋은 수가 총 몇 개인지 출력하세요.
// 입력 예시 : 10
//           1 2 3 4 5 6 7 8 9 10
// 출력 예시 : 4

public class 좋은수 {
    public static void main(String[] args) {
        좋은수 t = new 좋은수();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        
    }
}
