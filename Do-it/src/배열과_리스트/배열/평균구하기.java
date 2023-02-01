package 배열과_리스트.배열;
import java.util.Scanner;

// 설명 : 세준이는 기말고사를 망쳤다. 그래서 점수를 조작해 집에 가져가기로 했다. 일단 세준이는 자기 점수 중 최댓값을 고르고 최댓값을 M이라고 할 때 모든 점수를 점수/M*100으로 고치려고 한다.
//       세준이의 성적을 이 방법으로 계산했을 때 새로운 평균을 구하는 프로그램을 작성하세요.
// 시간 제한 : 2초
// 입력 예시 : 3
//           40 80 60
// 출력 예시 : 75.0
public class 평균구하기 {
    public static void main(String[] args) {
        평균구하기 t = new 평균구하기();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();  // 입력받을 점수의 갯수
        int[] arr = new int[n];  // 입력받을 점수의 갯수에 따른 배열 동적 할당
        for(int i = 0; i < n; i++) {  // for문으로 점수 입력
            arr[i] = sc.nextInt();
        }
        int sum = 0;   // 입력받은 점수의 총 합
        int max = 0;   // 입력받은 점수 중에서 제일 큰 값
        for(int i = 0; i < n; i++) {
            if(arr[i] > max) {
                max = arr[i];
            }
                sum += arr[i];
        }
        System.out.println(sum * 100.0 / max / n);
    }
}
