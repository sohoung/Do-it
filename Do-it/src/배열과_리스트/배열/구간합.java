package 배열과_리스트.배열;
import java.util.Scanner;

// 설명 : 구간 합은 합 배열을 이용하여 시간 복잡도를 더 줄이기 위해 사용하는 특수한 목적의 알고리즘이다. 구간 합 알고리즘을 활용하려면 먼저 합 배열을 구해야 합니다.
//       합 배열은 기존의 배열을 전처리한 배열이라고 생각하면 된다. 합 배열을 미리 구해놓으면 기존 배열의 일점 범위의 합을 구하는 시간 복잡도가 O(N)에서 O(1)로 감소한다.
// 입력 예시 : 5 3
//           5 4 3 2 1
//           1 3
//           2 4
//           5 5
// 출력 예시 : 12
//           9
//           1
public class 구간합 {
    public static void main(String[] args) {
        구간합 t = new 구간합();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();  // 입력받을 숫자의 갯수
        int m = sc.nextInt();  // 테스트 갯수
        int[] sum = new int[n+1];  // 배열의 구간 합 배열
        int[] arr = new int[n+1];  // 입력받을 숫자에 의한 배열크기 동적 할당
        for(int i = 1; i <= n; i++) {  // for문으로 배열에 값 입력
            arr[i] = sc.nextInt();
            sum[i] = sum[i-1] + arr[i];  // 구간 합을 구하는 공식
        }
        for(int i = 0; i < m; i++) {
            int a = sc.nextInt();  // a번째 인덱스부터
            int b = sc.nextInt();  // b번째 인덱스까지
            System.out.println(sum[b] - sum[a-1]);
        }
    }
}
