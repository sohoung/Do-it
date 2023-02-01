package 배열과_리스트.배열;
import java.util.Scanner;

// 설명 : n개의 숫자가 공백없이 있다. 이 숫자를 모두 합해 출력하는 프로그램을 작성하세요.
// 입력 예시 : 5
//          54321
// 출력 예시 : 15
public class 숫자의합구하기 {
    public static void main(String[] args) {
        숫자의합구하기 t = new 숫자의합구하기();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();  // 입력받을 숫자의 갯수
        String str = sc.next();  // 입력받을 숫자가 다 공백이 없으므로 숫자가 구분이 안되므로 String형으로 먼저 숫자르 받아준다.
        char[] c = str.toCharArray();
        // 입력받은 String형 숫자를 char배열에 저장해주면 54321이라는 공백이 없는 숫자가 char 배열에 들어가면 5 4 3 2 1이라는 인덱스에 의해 접근되는 각각의 숫자로 변환된다.
        int sum = 0;  // 입력받은 숫자를 더한 값
        for(int i = 0; i < n; i++) {
            sum += c[i] - '0';
            // 이 문제에서 가장 주의할 점이다. sum은 int형이고 c배열은 char형이다. sum을 구하기 위해서는 c배열을 int형으로 바꿔주어야한다.
            // 문자형을 숫자형으로 변환하기 위해서는 아스키 코드를 알아야한다.
            // 1의 아스키 코드는 49이고 0은 48이다. 즉 c라는 char형 배열을 숫자형으로 바꾸기 위해서는 아스키 코드를 이용하여 '1' - 48 또는 '1' - '0'을 해주어야 숫자형으로
            // 형변환이 완료된다. 만약 sum += c[i]를 하면 c[i]의 값이 아스키 코드의 값 그대로 누적합연산이 되므로 꼭 '0'이나 48을 빼주어야 한다.
        }
        System.out.println(sum);
    }
}
