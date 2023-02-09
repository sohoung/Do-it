package 배열과_리스트.배열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 복습하는곳 {
    static int myarr[];
    static int checkarr[];
    static int checkSeceret;
    public static void main(String[] args) throws NumberFormatException, IOException {
        복습하는곳 t = new 복습하는곳();
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int s = Integer.parseInt(st.nextToken());
        int p = Integer.parseInt(st.nextToken());
        int result = 0;
        myarr = new int[s];
        checkarr = new int[4];
        checkSeceret = 0;
        char[] a = new char[s];
        a = bf.readLine().toCharArray();
        st = new StringTokenizer(bf.readLine());
        for(int i = 0; i < 4; i++) {
            checkarr[i] = Integer.parseInt(st.nextToken());
            if(checkarr[i] == 0) {
                checkSeceret++;
            }
        }
        for(int i = 0; i < p; i++) {
            ADD(a[i]);
        }
        if(checkSeceret == 4) {
            result++;
        }
        for(int i = p; i < s; i++) {
            int j = i-p;
            ADD(a[i]);
            Remove(a[j]);
            if(checkSeceret == 4) {
                result++;
            }
        }
        System.out.println(result);
        bf.close();
    }
    private static void ADD(char c) {
        switch (c) {
            case 'A' :
                myarr[0]++;
                if(myarr[0] == checkarr[0]) {
                    checkSeceret++;
                }
                break;
            case 'C' :
                myarr[1]++;
                if(myarr[1] == checkarr[1]) {
                    checkSeceret++;
                }
                break;
            case 'G' :
                myarr[2]++;
                if(myarr[2] == checkarr[2]) {
                    checkSeceret++;
                }
                break;
            case 'T' :
                myarr[3]++;
                if(myarr[3] == checkarr[3]) {
                    checkSeceret++;
                }
                break;
        }
    }

    private static void Remove(char c) {
        switch (c) {
            case 'A' :
                if(myarr[0] == checkarr[0]) {
                    checkSeceret--;
                }
                myarr[0]--;
                break;
            case 'B' :
                if(myarr[1] == checkarr[1]) {
                    checkSeceret--;
                }
                myarr[1]--;
                break;
            case 'G' :
                if(myarr[2] == checkarr[2]) {
                    checkSeceret--;
                }
                myarr[2]--;
                break;
            case 'T' :
                if(myarr[3] == checkarr[3]) {
                    checkSeceret--;
                }
                myarr[3]--;
                break;
        }
    }
}
