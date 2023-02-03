package 배열과_리스트.배열;
import java.util.ArrayList;
import java.util.Scanner;

// 설명 : n*n개의 수가 n*n 크기의 표에 채워져있다. 표 안의 수 중(x1,y1)에서 (x2,y2)까지의 합을 구하는 프로그램을 작성하세요
// 입력 예시 : 4 3
//           1 2 3 4
//           2 3 4 5
//           3 4 5 6
//           4 5 6 7
//           2 2 3 4
//           3 4 3 4
//           1 1 4 4
// 출력 예시 : 27
//           6
//           64


public class 구간합구하기2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();  // 배열 크기
        int m = sc.nextInt();  // 질의 갯수
        int[][] arr = new int[n+1][n+1];  // 2차원 원본 배열 인덱스 번호를 행,열 번호로 생각하기 때문에 1부터 시작한다. 그러므로 크기를 +1해주어야한다.
        int[][] sum = new int[n+1][n+1];  // 2차원 합 배열 인덱스 번호를 행,열 번호로 생각하기 때문에 1부터 시작한다. 그러므로 크기를 +1해주어야한다.
        for(int i = 1; i <= n; i++) {  // 2차원 배열을 2중 for문으로 값 입력
            for(int j = 1; j <= n; j++) {
                arr[i][j] = sc.nextInt();
            }
        }
        for(int i = 1; i <= n; i++) {   // 2차원 합 배열을 2중 for문으로 값 입력
            for(int j = 1; j <= n; j++) {
                sum[i][j] = sum[i][j-1] + sum[i-1][j] - sum[i-1][j-1] + arr[i][j];
            }
        }
        for(int i = 0; i < m; i++) {  // 테스트 값 입력
            int x1 = sc.nextInt();  // x1 값
            int y1 = sc.nextInt();  // y1 값
            int x2 = sc.nextInt();  // x2 값
            int y2 = sc.nextInt();  // y2 값
            int result = sum[x2][y2] - sum[x1-1][y2] - sum[x2][y1-1] + sum[x1-1][y1-1];
            // x1,y1,x2,y2 좌표에 의한 값이 바로 나오도록 설계해준다.
            System.out.println(result);
        }
    }
}
