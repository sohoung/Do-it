package 배열과_리스트.배열;
// 설명 : n개의 수와 l이 주어진다. 주어진 수 중에서 최솟값을 d라고 할 때 d에 저장된 수를 출력하는 프로그램을 작성하세요.
// 입력 예씨 : 12 3
//           1 5 2 3 6 2 3 7 3 5 2 6
// 출력 예시 : 1 1 1 2 2 2 2 2 3 3 2 2
import java.io.*;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.StringTokenizer;

public class 최솟값찾기 {
    public static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        최솟값찾기 t = new 최솟값찾기();
        BufferedReader br = new BufferedReader((new InputStreamReader(System.in)));
        BufferedWriter bw = new BufferedWriter((new OutputStreamWriter(System.out)));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());  // 데이터 갯수
        int m = Integer.parseInt(st.nextToken());  // 최솟값을 구하는 범위
        st = new StringTokenizer(br.readLine());
        Deque<Node> mydeque = new LinkedList<>();  // Deque 객체 생성
        for(int i = 0; i < n; i++) {
            int now = Integer.parseInt(st.nextToken());  // 주어진 숫자 데이터를 가지는 리스트
            while(!mydeque.isEmpty() && mydeque.getLast().value > now) {  // 덱의 마지막 위치에서부터 현재 값보다 큰 값은 덱에서 제거
                mydeque.removeLast();
            }
            // 여기서 중요한 것은 새로운 값이 들어올 때마다 정렬을 하는 대신 현재 수보다 큰 값을 덱에서 제거해 정렬에 필요한 시간 복잡도를 줄인다.
            mydeque.addLast(new Node(now,i));  // 새로운 데이터 가져오기
            if(mydeque.getFirst().index <= i - m){  // 슬라이딩 윈도우의 범위를 벗어나는 인덱스 값은 제거
                mydeque.removeFirst();
            }
            bw.write(mydeque.getFirst().value + " ");
        }
        bw.flush();
        bw.close();
    }
    private static class Node {
        public int value;
        public int index;
        Node(int value, int index) {
            this.value = value;
            this.index = index;
        }
    }
}
