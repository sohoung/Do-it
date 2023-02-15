package 배열과_리스트.배열;

// 헷갈리는 문제 복습해보는 연습장

import java.io.*;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;


public class 복습 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        복습 t = new 복습();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        Deque<Node> mydeque = new LinkedList<>();
        for(int i = 0; i < n; i++) {
            int now = Integer.parseInt(st.nextToken());
            while(!mydeque.isEmpty() && mydeque.getLast().value > now) {
                mydeque.removeLast();
            }
            mydeque.addLast(new Node(now,i));
            if(mydeque.getFirst().index <= i - m) {
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