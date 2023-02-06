package 배열과_리스트.배열;
import java.util.Arrays;
import java.util.Scanner;

// 설명 : 주몽은 철기군을 양성하기 위한 프로젝트에 나섰다. 그래서 야철대장에게 철기군이 입을 갑옷을 만들라고 명령했다. 야철대장은 주몽의 명령에 따르기 위해 연구에 착수하던 중
//       갑옷을 만드는 재료들은 각각 고유한 번호가 있고 갑옷은 2개의 재료로 만드는 데 2가지 재료의 고유한 번호를 합쳐 m이 되면 갑옷이 만들어진다는 사실을 발견했다.
//       야철대장은 자신이 만들고 있는 재료로 갑옷을 몇 개나 만들 수 있는지 궁금해졌다. 애철대장의 궁금증을 풀기 위해서 n개의 재료와 m이 주어졌을 때 몇 개의 갑옷을 만들 수 있는지를 구하는
//       프로그램을 작성하세요.
// 입력 예시 : 6
//           9
//           2 7 4 1 5 3
// 출력 예시 : 2
public class 주몽의명령 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();  // 재료의 갯수
        int m = sc.nextInt();  // 갑옷이 완성되는 번호의 합
        int[] arr = new int[n];  // 배열 동적 할당
        for(int i = 0; i < n; i++) {  // 배열 값 입력
            arr[i] = sc.nextInt();
        }
        Arrays.sort(arr);  // 1 2 3 4 5 7로 오름차순 정렬
        int lt = 0;  // 시작 인덱스
        int rt = arr.length-1;  // 마지막 인덱스
        int answer = 0;  // 출력을 위한 변수
        while(lt < rt) {  // while문으로 lt가 rt보다 작을 때만 수행
            if(arr[lt] + arr[rt] == m) {  // 입력받은 m과 값이 같다면 rt는 1감소 lt는 1증가 시켜주고 answer 1증가
                lt++;
                rt--;
                answer++;
            }
            else if(arr[lt] + arr[rt] < m) {  // 입력받은 m보다 작다면 lt를 1증가
                lt++;
            }
            else {  // 입력받은 m보다 크다면 rt를 1감소
                rt--;
            }
        }
        System.out.println(answer);
    }
}
