package 배열과_리스트.배열;

import java.util.Scanner;

// 설명 : 어떠한 자연수 n은 몇 개의 연속된 자연수의 합으로 나타낼 수 있다. 당신은 어떤 자연수 n을 몇 개의 연속된 자연수의 합으로 나타내는 가짓수를 알고 싶다.
//       이 때 사용하는 자연수는 n이여야하고 n을 입력받아 연속된 자연수의 합으로 나타내는 가짓수를 출력하는 프로그램을 작성하세요.
// 입력 예시 : 15
// 출력 예시 : 4

public class 투포인터 {
    public static void main(String[] args) {
        투포인터 t = new 투포인터();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int answer = 0;  // 출력을 위한
        int sum = 1;     // 입력된 n과 비교해야 하는 변수
        int lt = 1;      // 시작 인덱스
        int rt = 1;      // 끝 인덱스
        while (rt != n) {   // while문의 조건으로 n이 끝 인덱스가 되기 전까지
            if (sum == n) { // sum이 입력된 n과 같다면
                rt++;       // 다음 비교를 위해서 rt를 1증가해주고
                sum += rt;  // sum에 누적합해주고 answer을 1증가시킨다.
                answer++;
            } else if (sum > n) {  // sum이 입력된 n보다 크다면
                sum -= lt;         // lt값을 먼저 빼주고 다음 비교를 위해서 lt를 1증가
                lt++;
            } else {               // sum이 입력된 n보다 작다면
                rt++;              // rt를 1증가시켜주고 sum에 rt값을 1 증가
                sum += rt;
            }
        }
        System.out.println(answer);
    }
}
