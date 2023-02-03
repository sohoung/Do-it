package 배열과_리스트.배열;

import java.util.Arrays;
import java.util.Scanner;

// 설명 : n개의 수가 주어졌을 때 연속된 부분의 합이 m으로 나누어떨어지는 구간의 갯수를 구하는 프로그램을 작성하세요.
// 입력 예시 : 5 3
//           1 2 3 1 2
// 출력 예시 : 7

public class 나머지합구하기 {
    public static void main(String[] args) {
        나머지합구하기 t = new 나머지합구하기();
        Scanner sc = new Scanner(System.in);
        int answer = 0;
        int n = sc.nextInt();  // 입력받을 갯수
        int m = sc.nextInt();  // 비교하는 수
        int[] arr = new int[n];  // 배열 동적 할당
        int[] sum = new int[n];  // arr 배열의 값을 더한 합 배열
        int[] c = new int[m];    // 같은 나머지의 인덱스를 카운트하는 배열
        for (int i = 0; i < n; i++) {  // for문으로 arr 값 입력
            arr[i] = sc.nextInt();
        }
        sum[0] = arr[0];
        for(int i = 1; i < n; i++) {  // sum 배열 입력
            sum[i] = (sum[i-1] + arr[i]);
        }
        for(int i = 0 ; i < n; i++) {
            int remain = sum[i] % m;  // sum인 합 배열을 입력받은 m으로 나눈 나머지 값
            if(remain == 0) {
                answer++;
            }
            c[remain]++;
        }
        for(int i = 0; i < m; i++) {
            if(c[i] > 1) {   // combination 연산 이용
                answer = answer + (c[i] * (c[i]-1)/2);  // 나머지가 같은 인덱스 중 2개를 뽑는 경우의 수인 3C2 즉 Combination 연산을 사용한다.
            }
        }
        System.out.println(answer);
    }
}
