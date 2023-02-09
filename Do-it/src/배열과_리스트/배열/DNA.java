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
        for (int i = 0; i < p; i++) {  // 처음에 p 길이만큼 ADD 함수를 동작한다.
            ADD(a[i]);
        }
        if (checkSeceret == 4) { // 처음에 p 길이만큼 ADD한 결과가 checkSeceret이 4이면 처음에 한 경우의 수가 비밀번호가 되는 경우이므로 result 값을 1증가시켜준다.
            result++;
        }
        for (int i = p; i < s; i++) {
            int j = i - p;
            // 여기서 j는 슬라이딩 윈도우 크기의 맨 처음 인덱스를 의미하고 i는 마지막 인덱스를 의미한다. 즉 i가 1씩 커지면 j도 따라서 커지는 영향을 받으므로
            // 슬라이딩 윈도우의 크기를 유지하면서 갈 수 있다.
            ADD(a[i]);  // 슬라이딩 윈도우를 사용하므로 맨 처음에 a[i] ~ a[p-1]까지 ADD해주었으므로 이제 a[p]를 넣어주고 a[i-p]인 처음 인덱스 값을 빼준다.
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
                // if문을 먼저 하는 이유는 myarr의 값이 checkarr의 값과 같으면 비밀번호를 충족한 조건이 이제는 충족하지 않기 때문에 checkSeceret을 빼주어야 한다.
                // 그것을 먼저 검증하기 위해서 if 조건문을 먼저 해준다.
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
