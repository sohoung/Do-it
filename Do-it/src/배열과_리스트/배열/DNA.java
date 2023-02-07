package 배열과_리스트.배열;
import java.util.Scanner;

// 설명 : 민호가 만든 임의의 DNA 문자열과 비밀번호로 사용할 부분 문자열의 길이 그리고 {'A','C','G','T'}가 각각 몇 번 이상 등장해야 비밀번호로 사용할 수 있는지
//       순서대로 주어졌을 때 민호가 만들 수 있는 비밀번호의 종류의 수를 구하는 프로그램을 작성하세요.
// 입력 예시 : 9 8
//           CCTGGATTG
//           2 0 1 1
// 출력 예시 : 0

public class DNA {
    public static void main(String[] args) {
        DNA t = new DNA();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        String str = sc.next();
        char[] c = str.toCharArray();
        int[] DNA = new int[4];
        for(int i = 0; i < DNA.length; i++) {
            DNA[i] = sc.nextInt();
        }
        
    }
}
