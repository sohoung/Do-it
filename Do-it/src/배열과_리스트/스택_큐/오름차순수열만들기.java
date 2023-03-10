package 배열과_리스트.스택_큐;
import java.util.Scanner;
import java.util.Stack;

// 설명 : 임의의 수열을 스택에 넣었다가 출력하는 방식으로 오름차순 수열을 출력할 수 있는지 확인하고 출력할 수 있다면 push와 pop 연산을 어떤 순서로 수행해야 하는지를 알아내는 프로그램을 작성해보자.
// 입력 예시 : 1번째 줄에 수열의 갯수 n(1<= n <= 100,000)이 주어진다. 2번쨰 줄에서 n개의 줄에는 수열을 이루는 1이상 n이하의 정수가 1개씩 순서대로 주어진다. 이 때 같은 정수가 2번 이상 나오지는 않는다.
// 출력 예시 : 오름차순 수열을 만들기 위한 연산 순서를 출력한다. push 연산은 +, pop 연산은 -로 출력하고 불가능 할 때눈 NO를 출력한다.
// 시간 제한 : 2초
public class 오름차순수열만들기 {
    public static void main(String[] args) {
        오름차순수열만들기 t = new 오름차순수열만들기();
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] arr = new int[N];
        for(int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }
        Stack<Integer> stack = new Stack<>();
        StringBuffer bf = new StringBuffer();
        int num = 1;   // 오름차순 수
        boolean result = true;
        for(int i = 0; i < arr.length; i++) {
            int su = arr[i];  // 현재 수열의 수
            if(su >= num) {   // 현재 수열의 값 >= 오름차순 수 : pop()을 수행해 수열 원소를 꺼낸다.
                while(su >= num) {  // push()
                    stack.push(num++);
                    bf.append("+\n");
                }
                stack.pop();
                bf.append("-\n");
            }
            else {            // 현재 수열 값 < 오름차순 자연수 : pop()을 수행해 수열 원소를 꺼냄
                int n = stack.pop();  // 스택의 가장 위의 수가 만들어야 하는 수열의 수보다 크면 수열을 출력할 수 없음.
                if(n > su) {
                    System.out.println("NO");
                    result = false;
                    break;
                }
                else {
                    bf.append("-\n");
                }
            }
        }
        if(result) {
            System.out.println(bf.toString());
        }
    }
}
