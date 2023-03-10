package 배열과_리스트.스택_큐;

import java.util.Scanner;
import java.util.Stack;

// 설명 : 크기가 N인 수열이 있다. 수열의 각 원소에 관련된 오큰수를 구하려고 한다. 오큰수는 오른쪽에 있으면서 a보다 큰 수 중 가장 왼쪽에 있는 수를 의미한다. 이러한 수가 없을 때는 오큰수는 -1이다.
// 입력 예시 : 4
//           3 5 2 7
// 출력 예시 : 5 7 7 -1
// 시간 제한 : 1초
public class 오큰수구하기 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] arr = new int[N];
        for(int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }
        Stack<Integer> stack = new Stack<>();
        
    }
}
