package 배열과_리스트.배열;
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
        int x = sc.nextInt();  // 배열 크기
        int y = sc.nextInt();  // 질의 갯수
        int[][] arr = new int[x][y];  // 2차원 원본 배열
        int[][] sum = new int[x][y];  // 2차원 합 배열
        for(int i = 0; i < x; i++) {  // 2차원 배열을 2중 for문으로 값 입력
            for(int j = 0; j < y; j++) {
                arr[x][y] = sc.nextInt();
            }
        }
        
    }
}
