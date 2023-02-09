package 배열과_리스트.배열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

// 설명 : 민호가 만든 임의의 DNA 문자열과 비밀번호로 사용할 부분 문자열의 길이 그리고 {'A','C','G','T'}가 각각 몇 번 이상 등장해야 비밀번호로 사용할 수 있는지
//       순서대로 주어졌을 때 민호가 만들 수 있는 비밀번호의 종류의 수를 구하는 프로그램을 작성하세요.
// 입력 예시 : 9 8
//           CCTGGATTG
//           2 0 1 1
// 출력 예시 : 0

public class DNA {
    static int checkarr[];  // 배열 전역으로 잡기
    static int myarr[];     // 배열 전역으로 잡기
    static int checkSeceret;  // 변수 전역으로 잡기

    public static void main(String[] args) throws NumberFormatException, IOException {
        DNA t = new DNA();
        Scanner sc = new Scanner(System.in);
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int s = Integer.parseInt(st.nextToken());  // 문자열 길이
        int p = Integer.parseInt(st.nextToken());  // 부분 문자열 길이
        int result = 0;  // 결과 값
        char[] a = new char[s];  // 문자열 데이터
        checkarr = new int[4];  // 비밀번호 체크 배열
        myarr = new int[4];     // 현재 상태 배열
        checkSeceret = 0;       // 몇 개의 문자와 관련된 갯수를 충족했는지 판단하는 변수
        a = bf.readLine().toCharArray();          // 문자열을 char 배열로 만들어준다.
        st = new StringTokenizer(bf.readLine());
        for (int i = 0; i < 4; i++) {
            checkarr[i] = Integer.parseInt(st.nextToken());  // 2 0 1 1를 for문으로 입력
            if (checkarr[i] == 0) {  // checkarr의 데이터 값 중에 0이라는 값이 있으면 입력받은 문자열에서 부분 문자열로 비밀번호 추출을 할 때 없어도 되는 문자이므로
                checkSeceret++;      // checkseceret를 1증가시켜준다.
            }
        }
        for (int i = 0; i < p; i++) {
            ADD(a[i]);
        }
        if (checkSeceret == 4) {
            result++;
        }
        for (int i = p; i < s; i++) {
            int j = i - p;
            ADD(a[i]);
            Remove(a[j]);
            if (checkSeceret == 4) {
                result++;
            }
        }
        System.out.println(result);
        bf.close();
    }

    private static void ADD(char c) {  // 새로 들어온 문자를 myarr에 업데이트하거나 checkseceret 값 변경하기
        switch (c) {
            case 'A':
                myarr[0]++;
                if (myarr[0] == checkarr[0]) {
                    checkSeceret++;
                }
                break;
            case 'C':
                myarr[1]++;
                if (myarr[1] == checkarr[1]) {
                    checkSeceret++;
                }
                break;
            case 'G':
                myarr[2]++;
                if (myarr[2] == checkarr[2]) {
                    checkSeceret++;
                }
                break;
            case 'T':
                myarr[3]++;
                if (myarr[3] == checkarr[3]) {
                    checkSeceret++;
                }
                break;
        }
    }

    private static void Remove(char c) {  // 제거되는 문자를 myarr에 업데이트하거나 checkseceret 값 변경하기
        switch (c) {
            case 'A':
                if (myarr[0] == checkarr[0]) {
                    checkSeceret--;
                }
                myarr[0]--;
                break;
            case 'C':
                if (myarr[1] == checkarr[1]) {
                    checkSeceret--;
                }
                myarr[1]--;
                break;
            case 'G':
                if (myarr[2] == checkarr[2]) {
                    checkSeceret--;
                }
                myarr[2]--;
                break;
            case 'T':
                if (myarr[3] == checkarr[3]) {
                    checkSeceret--;
                }
                break;
        }
    }
}
