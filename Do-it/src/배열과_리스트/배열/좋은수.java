package 배열과_리스트.배열;

import java.util.Arrays;
import java.util.Scanner;

// 설명 : 주어진 n개의 수에서 다른 두 수의 합으로 표현되는 수가 있다면 그 수를 좋은 수라고 한다. n개의 수 중 좋은 수가 총 몇 개인지 출력하세요.
// 입력 예시 : 10
//           1 2 3 4 5 6 7 8 9 10
// 출력 예시 : 4

public class 좋은수 {
    public static void main(String[] args) {
        좋은수 t = new 좋은수();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();    // 입력 받을 수의 갯수
        int[] arr = new int[n];  // 배열 크기 동적 할당
        for (int i = 0; i < n; i++) {   // for문으로 배열 값 입력
            arr[i] = sc.nextInt();
        }
        Arrays.sort(arr);  // 오름차순으로 배열 정렬
        int answer = 0;  // 출력을 위한 변수
        for (int i = 0; i < n; i++) {
            int find = arr[i];  // 좋은 수를 찾기 위한 변수
            int lt = 0;  // 시작 인덱스
            int rt = arr.length - 1;  // 끝 인덱스
            while (lt < rt) {   // 시작 인덱스가 마지막 인덱스보다 작을 때 수행
                if (arr[lt] + arr[rt] == find) {
                    if (lt != i && rt != i) {  // 자기 자신의 수는 포함 할 수 없다
                        answer++;             // answer 1증가
                        break;
                    } else if (lt == i) {  // 시작 인덱스가 i일 때 lt 값을 변경해주고 수행해준다.
                        lt++;
                    } else if (rt == i) {  // 마지막 인덱스가 i일 대 rt 값을 변경해주고 수행해준다.
                        rt--;
                    }
                } else if (arr[lt] + arr[rt] < find) {
                    lt++;
                } else {
                    rt--;
                }
            }
        }
        System.out.println(answer);
    }
}
