import java.util.*;
import java.lang.Math;


class Node {
    int coeff;
    int pow;
    Node next;
    Node(int a, int b)
    {
        coeff = a;
        pow = b;
    }
}
public class Solution {

    static SingleLinkedList A = new SingleLinkedList();
    static SingleLinkedList B = new SingleLinkedList();
    static SingleLinkedList C = new SingleLinkedList();
    static SingleLinkedList R = new SingleLinkedList();
    public static class SingleLinkedList {

        Node head = null;
        Node tail = null;

        static Node curr;
        static Node prev;
        static int length;
        static String[] arr;

        public void add(int a, int b) {
            Node newNode = new Node(a, b);
            newNode.coeff = a;
            newNode.pow = b;
            if (head == null) {
                head = tail = newNode;
                tail.next = null;
            } else {
                tail.next = newNode;
                tail = newNode;
            }
        }//end of method
        public void clear() {
            head = null;
        }//end of method
        public void printlist(Node node) {
            if(node==null)
                System.out.print("]");
            else {
                System.out.print(node.coeff);
                System.out.print(node.pow);
                if(node.next!=null) {System.out.print(", ");}
                printlist(node.next);
            }
        }//end of method
    }//end of static class
    public static void setPolynomial(char poly, int[][] terms) {
        switch (poly){
            case 'A':
                if (terms[0].length == 0 ) {
                    System.out.print("Error");
                    System.exit(0);
                }
                else {
                    for (int i = 0; i < terms[0].length; i++) {
                        A.add(terms[0][i], terms[1][i]);
                    }}
                break;
            case 'B':
                if (terms[0].length == 0 ) {
                    System.out.print("Error");
                    System.exit(0);
                }
                else {
                    for (int i = 0; i < terms[0].length; i++) {
                        B.add(terms[0][i], terms[1][i]);
                    }}
                break;
            case 'C':
                if (terms[0].length == 0 ) {
                    System.out.print("Error");
                    System.exit(0);
                }
                else {
                    for (int i = 0; i < terms[0].length; i++) {
                        C.add(terms[0][i], terms[1][i]);
                    }}
                break;
            default:
                System.out.print("Error");
                System.exit(0);
                break;
        }
    }//end of method
    static String res = "";
    static String res1 = "";
    static String res2 = "";
    static String res3 = "";
    static String print(char poly){
        switch (poly){
            case 'A':
                Node term = A.head;
                Node ter = A.tail;
                int z = 0;
                int q = 0;
                while (term != null) {
                    q++;
                    if(term.coeff != 0) {
                        if(term.coeff==1 && term.pow!=1 && term.pow!=0)
                            res = res + "x^" + term.pow;
                        else if(term.coeff==-1 && term.pow!=1 && term.pow!=0) {
                            res = res + "-1x^" + term.pow;
                        }
                        else if(term.coeff==-1 && term.pow==1) {
                            res = res + "-1x";
                        }
                        else if(term.coeff==1 && term.pow==1) {
                            res = res + "x";
                        }
                        else if(term.coeff!=1 && term.coeff!=-1 && term.pow==1) {
                            res = res + term.coeff + "x";
                        }
                        else if(term.pow == 0){
                            res = res + term.coeff;
                        }
                        else {
                            res = res + term.coeff + "x^" + term.pow;
                        }
                        Node asmaa = term;
                        while(term.next!=null) {
                            if(term.next.coeff > 0) {
                                res = res + "+";
                                break;
                            }
                            else if(term.next.coeff < 0){
                                break;
                            }
                            else if(term.next.coeff == 0) {
                                term = term.next;
                            }
                        }
                        term = asmaa;
                    }
                    else {
                        z++;
                    }
                    term = term.next;
                }//end of while
                if(q==z) {
                    res = "0";
                }
                return res;
            case 'B':
                Node tempOfB = B.head;
                Node ter1 = B.tail;
                int z1 = 0;
                int q1 = 0;
                while (tempOfB != null) {
                    q1++;
                    if(tempOfB.coeff != 0) {
                        if(tempOfB.coeff==1 && tempOfB.pow!=1 && tempOfB.pow!=0)
                            res1 = res1 + "x^" + tempOfB.pow;
                        else if(tempOfB.coeff==-1 && tempOfB.pow!=1 && tempOfB.pow!=0) {
                            res1 = res1 + "-1x^" + tempOfB.pow;
                        }
                        else if(tempOfB.coeff==-1 && tempOfB.pow==1) {
                            res1 = res1 + "-1x";
                        }
                        else if(tempOfB.coeff==1 && tempOfB.pow==1) {
                            res1 = res1 + "x";
                        }
                        else if(tempOfB.coeff!=1 && tempOfB.coeff!=-1 && tempOfB.pow==1) {
                            res1 = res1 + tempOfB.coeff + "x";
                        }
                        else if(tempOfB.pow == 0){
                            res1 = res1 + tempOfB.coeff;
                        }
                        else {
                            res1 = res1 + tempOfB.coeff + "x^" + tempOfB.pow;
                        }
                        Node asmaa = tempOfB;
                        while(tempOfB.next!=null) {
                            if(tempOfB.next.coeff > 0) {
                                res1 = res1 + "+";
                                break;
                            }
                            else if(tempOfB.next.coeff < 0){
                                break;
                            }
                            else if(tempOfB.next.coeff == 0) {
                                tempOfB = tempOfB.next;
                            }
                        }
                        tempOfB = asmaa;
                    }
                    else {
                        z1++;
                    }
                    tempOfB = tempOfB.next;
                }//end of while
                if(q1==z1) {
                    res1 = "0";
                }
                res = res1;
                return res1;
            case 'C':
                Node term2 = C.head;
                Node ter2 = C.tail;
                int z2 = 0;
                int q2 = 0;
                while (term2 != null) {
                    q2++;
                    if(term2.coeff != 0) {
                        if(term2.coeff==1 && term2.pow!=1 && term2.pow!=0)
                            res2 = res2 + "x^" + term2.pow;
                        else if(term2.coeff==-1 && term2.pow!=1 && term2.pow!=0) {
                            res2 = res2 + "-1x^" + term2.pow;
                        }
                        else if(term2.coeff==-1 && term2.pow==1) {
                            res2 = res2 + "-1x";
                        }
                        else if(term2.coeff==1 && term2.pow==1) {
                            res2 = res2 + "x";
                        }
                        else if(term2.coeff!=1 && term2.coeff!=-1 && term2.pow==1) {
                            res2 = res2 + term2.coeff + "x";
                        }
                        else if(term2.pow == 0){
                            res2 = res2 + term2.coeff;
                        }
                        else {
                            res2 = res2 + term2.coeff + "x^" + term2.pow;
                        }
                        Node asmaa = term2;
                        while(term2.next!=null) {
                            if(term2.next.coeff > 0) {
                                res2 = res2 + "+";
                                break;
                            }
                            else if(term2.next.coeff < 0){
                                break;
                            }
                            else if(term2.next.coeff == 0) {
                                term2 = term2.next;
                            }
                        }
                        term2 = asmaa;
                    }
                    else {
                        z2++;
                    }
                    term2 = term2.next;
                }//end of while
                if(q2==z2) {
                    res2 = "0";
                }
                res = res2;
                return res2;
            case 'D':
                Node term3 = R.head;
                Node ter3 = R.tail;
                int z3 = 0;
                int q3 = 0;
                while (term3 != null) {
                    q3++;
                    if(term3.coeff != 0) {
                        if(term3.coeff==1 && term3.pow!=1 && term3.pow!=0)
                            res3 = res3 + "x^" + term3.pow;
                        else if(term3.coeff==-1 && term3.pow!=1 && term3.pow!=0) {
                            res3 = res3 + "-1x^" + term3.pow;
                        }
                        else if(term3.coeff==-1 && term3.pow==1) {
                            res3 = res3 + "-1x";
                        }
                        else if(term3.coeff==1 && term3.pow==1) {
                            res3 = res3 + "x";
                        }
                        else if(term3.coeff!=1 && term3.coeff!=-1 && term3.pow==1) {
                            res3 = res3 + term3.coeff + "x";
                        }
                        else if(term3.pow == 0){
                            res3 = res3 + term3.coeff;
                        }
                        else {
                            res3 = res3 + term3.coeff + "x^" + term3.pow;
                        }
                        Node asmaa = term3;
                        while(term3.next!=null) {
                            if(term3.next.coeff > 0) {
                                res3 = res3 + "+";
                                break;
                            }
                            else if(term3.next.coeff < 0){
                                break;
                            }
                            else if(term3.next.coeff == 0) {
                                term = term3.next;
                            }
                        }
                        term3 = asmaa;
                    }
                    else {
                        z3++;
                    }
                    term3 = term3.next;
                }//end of while
                if(q3==z3) {
                    res3 = "0";
                }
                res = res3;
                return res3;
            default:
                System.out.print("Error");
                break;
        }
        return res;
    }//end of method
    static void clearPolynomial(char poly){
        switch(poly){
            case 'A':
                A.clear();
                System.out.println("[]");
                break;
            case 'B':
                B.clear();
                System.out.println("[]");
                break;
            case 'C':
                C.clear();
                System.out.println("[]");
                break;
            default:
                System.out.print("Error");
                break;
        }
    }//end of method
    static float evaluatePolynomial(char poly, float value){
        float res = 0;
        float res1 = 0;
        float res2 = 0;
        switch(poly){
            case 'A':
                Node term = A.head;
                while(term != null){
                    res = (float) (res + (float)term.coeff * Math.pow(value, (float)term.pow));
                    term = term.next;
                }
                return res;
            case 'B':
                Node tempOfB = B.head;
                while(tempOfB != null){
                    res1 = (float) (res1 + (float)tempOfB.coeff * Math.pow(value, (float)tempOfB.pow));
                    tempOfB = tempOfB.next;
                }
                res = res1;
                return res1;
            case 'C':
                Node term2 = C.head;
                while(term2 != null){
                    res2 = (float) (res2 + (float)term2.coeff * Math.pow(value, (float)term2.pow));
                    term2 = term2.next;
                }
                res = res2;
                return res2;
            default:
                System.out.print("Error");
                break;
        }
        return res;
    }//end of method
    public static int[][] add(char poly1,char poly2){
        int len1=0 , len2=0 , lenD=0;
        //11111111111111111111111111111
        if(poly1=='A' && poly2=='B') {
            Node tempOfB = A.head;
            Node term2 = B.head;
            Node curr1 = tempOfB;
            Node curr2 = term2;
            while(curr1!=null) {
                len1++;
                curr1 = curr1.next;
            }
            while(curr2!=null) {
                len2++;
                curr2 = curr2.next;
            }
            while(tempOfB.pow>term2.pow && tempOfB!=null && term2!=null) {
                R.add(tempOfB.coeff ,tempOfB.pow);
                lenD++;
                tempOfB = tempOfB.next;
            }
            while(term2.pow>tempOfB.pow && tempOfB!=null && term2!=null) {
                R.add(term2.coeff ,term2.pow);
                lenD++;
                term2 = term2.next;
            }
            while(tempOfB!=null && term2!=null ) {
                if(tempOfB.pow==term2.pow) {
                    if(tempOfB.pow!=0) {
                        R.add((tempOfB.coeff+term2.coeff) ,(tempOfB.pow));
                        lenD++;
                    }
                    else {
                        R.add((tempOfB.coeff+term2.coeff),0);
                        lenD++;
                    }
                    tempOfB = tempOfB.next;
                    term2 = term2.next;
                }
                else if(tempOfB.pow>term2.pow) {
                    R.add(tempOfB.coeff ,tempOfB.pow);
                    lenD++;
                    tempOfB = tempOfB.next;
                }
                else if(term2.pow>tempOfB.pow) {
                    R.add(term2.coeff ,term2.pow);
                    lenD++;
                    term2 = term2.next;
                }
            }
        }
        //2222222222222222222222222
        else if(poly1=='A' && poly2=='C') {
            Node tempOfB = A.head;
            Node term2 = C.head;
            Node curr1 = tempOfB;
            Node curr2 = term2;
            while(curr1!=null) {
                len1++;
                curr1 = curr1.next;
            }
            while(curr2!=null) {
                len2++;
                curr2 = curr2.next;
            }
            while(tempOfB.pow>term2.pow && tempOfB!=null && term2!=null) {
                R.add(tempOfB.coeff ,tempOfB.pow);
                lenD++;
                tempOfB = tempOfB.next;
            }
            while(term2.pow>tempOfB.pow && tempOfB!=null && term2!=null) {
                R.add(term2.coeff ,term2.pow);
                lenD++;
                term2 = term2.next;
            }
            while(tempOfB!=null && term2!=null ) {
                if(tempOfB.pow==term2.pow) {
                    if(tempOfB.pow!=0) {
                        R.add((tempOfB.coeff+term2.coeff) ,(tempOfB.pow));
                        lenD++;
                    }
                    else {
                        R.add((tempOfB.coeff+term2.coeff),0);
                        lenD++;
                    }
                    tempOfB = tempOfB.next;
                    term2 = term2.next;
                }
                else if(tempOfB.pow>term2.pow) {
                    R.add(tempOfB.coeff ,tempOfB.pow);
                    lenD++;
                    tempOfB = tempOfB.next;
                }
                else if(term2.pow>tempOfB.pow) {
                    R.add(term2.coeff ,term2.pow);
                    lenD++;
                    term2 = term2.next;
                }
            }
        }
        //333333333333333333333333333333
        else if(poly1=='B' && poly2=='C') {
            Node tempOfB = B.head;
            Node term2 = C.head;
            Node curr1 = tempOfB;
            Node curr2 = term2;
            while(curr1!=null) {
                len1++;
                curr1 = curr1.next;
            }
            while(curr2!=null) {
                len2++;
                curr2 = curr2.next;
            }
            while(tempOfB.pow>term2.pow && tempOfB!=null && term2!=null) {
                R.add(tempOfB.coeff ,tempOfB.pow);
                lenD++;
                tempOfB = tempOfB.next;
            }
            while(term2.pow>tempOfB.pow && tempOfB!=null && term2!=null) {
                R.add(term2.coeff ,term2.pow);
                lenD++;
                term2 = term2.next;
            }
            while(tempOfB!=null && term2!=null ) {
                if(tempOfB.pow==term2.pow) {
                    if(tempOfB.pow!=0) {
                        R.add((tempOfB.coeff+term2.coeff) ,(tempOfB.pow));
                        lenD++;
                    }
                    else {
                        R.add((tempOfB.coeff+term2.coeff),0);
                        lenD++;
                    }
                    tempOfB = tempOfB.next;
                    term2 = term2.next;
                }
                else if(tempOfB.pow>term2.pow) {
                    R.add(tempOfB.coeff ,tempOfB.pow);
                    lenD++;
                    tempOfB = tempOfB.next;
                }
                else if(term2.pow>tempOfB.pow) {
                    R.add(term2.coeff ,term2.pow);
                    lenD++;
                    term2 = term2.next;
                }
            }
        }

        int[][] array = new int [lenD][lenD];
        //convert R to 2D array
        Node current = R.head;
        for(int i=0;i<lenD;i++) {
            array[0][i] = current.coeff;
            current = current.next;
        }
        int j=0;
        for(int i=lenD-1;i>=0;i--) {
            array[1][j++] = i;
        }
        System.out.println(print('D'));
        return array;
    }//end of add
    public static int[][] subtract(char poly1,char poly2){
        int len1=0 , len2=0 , lenD=0;
        //11111111111111111111111111111
        if(poly1=='A' && poly2=='B') {
            Node tempOfB = A.head;
            Node term2 = B.head;
            Node curr1 = tempOfB;
            Node curr2 = term2;
            while(curr1!=null) {
                len1++;
                curr1 = curr1.next;
            }
            while(curr2!=null) {
                len2++;
                curr2 = curr2.next;
            }
            while(tempOfB.pow>term2.pow && tempOfB!=null && term2!=null) {
                R.add(tempOfB.coeff ,tempOfB.pow);
                lenD++;
                tempOfB = tempOfB.next;
            }
            while(term2.pow>tempOfB.pow && tempOfB!=null && term2!=null) {
                R.add(term2.coeff ,term2.pow);
                lenD++;
                term2 = term2.next;
            }
            while(tempOfB!=null && term2!=null ) {
                if(tempOfB.pow==term2.pow) {
                    if(tempOfB.pow!=0) {
                        R.add((tempOfB.coeff-term2.coeff) ,(tempOfB.pow));
                        lenD++;
                    }
                    else {
                        R.add((tempOfB.coeff-term2.coeff),0);
                        lenD++;
                    }
                    tempOfB = tempOfB.next;
                    term2 = term2.next;
                }
                else if(tempOfB.pow>term2.pow) {
                    R.add(tempOfB.coeff ,tempOfB.pow);
                    lenD++;
                    tempOfB = tempOfB.next;
                }
                else if(term2.pow>tempOfB.pow) {
                    R.add(term2.coeff ,term2.pow);
                    lenD++;
                    term2 = term2.next;
                }
            }
        }
        //2222222222222222222222222
        else if(poly1=='A' && poly2=='C') {
            Node tempOfB = A.head;
            Node term2 = C.head;
            Node curr1 = tempOfB;
            Node curr2 = term2;
            while(curr1!=null) {
                len1++;
                curr1 = curr1.next;
            }
            while(curr2!=null) {
                len2++;
                curr2 = curr2.next;
            }
            while(tempOfB.pow>term2.pow && tempOfB!=null && term2!=null) {
                R.add(tempOfB.coeff ,tempOfB.pow);
                lenD++;
                tempOfB = tempOfB.next;
            }
            while(term2.pow>tempOfB.pow && tempOfB!=null && term2!=null) {
                R.add(term2.coeff ,term2.pow);
                lenD++;
                term2 = term2.next;
            }
            while(tempOfB!=null && term2!=null ) {
                if(tempOfB.pow==term2.pow) {
                    if(tempOfB.pow!=0) {
                        R.add((tempOfB.coeff-term2.coeff) ,(tempOfB.pow));
                        lenD++;
                    }
                    else {
                        R.add((tempOfB.coeff-term2.coeff),0);
                        lenD++;
                    }
                    tempOfB = tempOfB.next;
                    term2 = term2.next;
                }
                else if(tempOfB.pow>term2.pow) {
                    R.add(tempOfB.coeff ,tempOfB.pow);
                    lenD++;
                    tempOfB = tempOfB.next;
                }
                else if(term2.pow>tempOfB.pow) {
                    R.add(term2.coeff ,term2.pow);
                    lenD++;
                    term2 = term2.next;
                }
            }
        }
        //333333333333333333333333333333
        else if(poly1=='B' && poly2=='C') {
            Node tempOfB = B.head;
            Node term2 = C.head;
            Node curr1 = tempOfB;
            Node curr2 = term2;
            while(curr1!=null) {
                len1++;
                curr1 = curr1.next;
            }
            while(curr2!=null) {
                len2++;
                curr2 = curr2.next;
            }
            while(tempOfB.pow>term2.pow && tempOfB!=null && term2!=null) {
                R.add(tempOfB.coeff ,tempOfB.pow);
                lenD++;
                tempOfB = tempOfB.next;
            }
            while(term2.pow>tempOfB.pow && tempOfB!=null && term2!=null) {
                R.add(term2.coeff ,term2.pow);
                lenD++;
                term2 = term2.next;
            }
            while(tempOfB!=null && term2!=null ) {
                if(tempOfB.pow==term2.pow) {
                    if(tempOfB.pow!=0) {
                        R.add((tempOfB.coeff-term2.coeff) ,(tempOfB.pow));
                        lenD++;
                    }
                    else {
                        R.add((tempOfB.coeff-term2.coeff),0);
                        lenD++;
                    }
                    tempOfB = tempOfB.next;
                    term2 = term2.next;
                }
                else if(tempOfB.pow>term2.pow) {
                    R.add(tempOfB.coeff ,tempOfB.pow);
                    lenD++;
                    tempOfB = tempOfB.next;
                }
                else if(term2.pow>tempOfB.pow) {
                    R.add(term2.coeff ,term2.pow);
                    lenD++;
                    term2 = term2.next;
                }
            }
        }
        //4444444444444444444444444444444
        else if(poly1=='B' && poly2=='A') {
            Node tempOfB = B.head;
            Node term2 = A.head;
            Node curr1 = tempOfB;
            Node curr2 = term2;
            while(curr1!=null) {
                len1++;
                curr1 = curr1.next;
            }
            while(curr2!=null) {
                len2++;
                curr2 = curr2.next;
            }
            while(tempOfB.pow>term2.pow && tempOfB!=null && term2!=null) {
                R.add(tempOfB.coeff ,tempOfB.pow);
                lenD++;
                tempOfB = tempOfB.next;
            }
            while(term2.pow>tempOfB.pow && tempOfB!=null && term2!=null) {
                R.add(term2.coeff ,term2.pow);
                lenD++;
                term2 = term2.next;
            }
            while(tempOfB!=null && term2!=null ) {
                if(tempOfB.pow==term2.pow) {
                    if(tempOfB.pow!=0) {
                        R.add((tempOfB.coeff-term2.coeff) ,(tempOfB.pow));
                        lenD++;
                    }
                    else {
                        R.add((tempOfB.coeff-term2.coeff),0);
                        lenD++;
                    }
                    tempOfB = tempOfB.next;
                    term2 = term2.next;
                }
                else if(tempOfB.pow>term2.pow) {
                    R.add(tempOfB.coeff ,tempOfB.pow);
                    lenD++;
                    tempOfB = tempOfB.next;
                }
                else if(term2.pow>tempOfB.pow) {
                    R.add(term2.coeff ,term2.pow);
                    lenD++;
                    term2 = term2.next;
                }
            }
        }
        //55555555555555555555555555555555555
        else if(poly1=='C' && poly2=='A') {
            Node tempOfB = C.head;
            Node term2 = A.head;
            Node curr1 = tempOfB;
            Node curr2 = term2;
            while(curr1!=null) {
                len1++;
                curr1 = curr1.next;
            }
            while(curr2!=null) {
                len2++;
                curr2 = curr2.next;
            }
            while(tempOfB.pow>term2.pow && tempOfB!=null && term2!=null) {
                R.add(tempOfB.coeff ,tempOfB.pow);
                lenD++;
                tempOfB = tempOfB.next;
            }
            while(term2.pow>tempOfB.pow && tempOfB!=null && term2!=null) {
                R.add(term2.coeff ,term2.pow);
                lenD++;
                term2 = term2.next;
            }
            while(tempOfB!=null && term2!=null ) {
                if(tempOfB.pow==term2.pow) {
                    if(tempOfB.pow!=0) {
                        R.add((tempOfB.coeff-term2.coeff) ,(tempOfB.pow));
                        lenD++;
                    }
                    else {
                        R.add((tempOfB.coeff-term2.coeff),0);
                        lenD++;
                    }
                    tempOfB = tempOfB.next;
                    term2 = term2.next;
                }
                else if(tempOfB.pow>term2.pow) {
                    R.add(tempOfB.coeff ,tempOfB.pow);
                    lenD++;
                    tempOfB = tempOfB.next;
                }
                else if(term2.pow>tempOfB.pow) {
                    R.add(term2.coeff ,term2.pow);
                    lenD++;
                    term2 = term2.next;
                }
            }
        }
        //6666666666666666666666666666666
        else if(poly1=='C' && poly2=='B') {
            Node tempOfB = B.head;
            Node term2 = C.head;
            Node curr1 = tempOfB;
            Node curr2 = term2;
            while(curr1!=null) {
                len1++;
                curr1 = curr1.next;
            }
            while(curr2!=null) {
                len2++;
                curr2 = curr2.next;
            }
            while(tempOfB.pow>term2.pow && tempOfB!=null && term2!=null) {
                R.add(tempOfB.coeff ,tempOfB.pow);
                lenD++;
                tempOfB = tempOfB.next;
            }
            while(term2.pow>tempOfB.pow && tempOfB!=null && term2!=null) {
                R.add(term2.coeff ,term2.pow);
                lenD++;
                term2 = term2.next;
            }
            while(tempOfB!=null && term2!=null ) {
                if(tempOfB.pow==term2.pow) {
                    if(tempOfB.pow!=0) {
                        R.add((tempOfB.coeff-term2.coeff) ,(tempOfB.pow));
                        lenD++;
                    }
                    else {
                        R.add((tempOfB.coeff-term2.coeff),0);
                        lenD++;
                    }
                    tempOfB = tempOfB.next;
                    term2 = term2.next;
                }
                else if(tempOfB.pow>term2.pow) {
                    R.add(tempOfB.coeff ,tempOfB.pow);
                    lenD++;
                    tempOfB = tempOfB.next;
                }
                else if(term2.pow>tempOfB.pow) {
                    R.add(term2.coeff ,term2.pow);
                    lenD++;
                    term2 = term2.next;
                }
            }
        }
        int[][] array = new int [lenD][lenD];
        //convert D to 2D array
        Node current = R.head;
        for(int i=0;i<lenD;i++) {
            array[0][i] = current.coeff;
            current = current.next;
        }
        int j=0;
        for(int i=lenD-1;i>=0;i--) {
            array[1][j++] = i;
        }
        System.out.println(print('D'));
        return array;
    }//end of subtract
    public static int isUpper(int n1,int n2) {
        if(n1>=n2)
            return n1;
        return n2;
    }
    static void removeDuplicates(Node start)
    {
        Node ptr1, ptr2, dup;
        ptr1 = start;

        while (ptr1 != null && ptr1.next != null) {
            ptr2 = ptr1;

            while (ptr2.next != null) {

                if (ptr1.pow == ptr2.next.pow) {

                    ptr1.coeff = ptr1.coeff + ptr2.next.coeff;
                    dup = ptr2.next;
                    ptr2.next = ptr2.next.next;

                }
                else
                    ptr2 = ptr2.next;
            }
            ptr1 = ptr1.next;
        }
    }
    static int[][] multiply(char poly1, char poly2)
    {


        Node ptr1 = null;
        Node ptr2 = null;
        switch(poly1){
            case 'A':
                ptr1 = A.head;
                break;

            case 'B':
                ptr1 = B.head;
                break;

            case 'C':
                ptr1 = C.head;
                break;
        }

        switch(poly2){
            case 'A':
                ptr2 = A.head;
                break;

            case 'B':
                ptr2 = B.head;
                break;

            case 'C':
                ptr2 = C.head;
                break;
        }
        while (ptr1 != null) {
            while (ptr2 != null) {
                int coeff, power;

                coeff = ptr1.coeff * ptr2.coeff;

                power = ptr1.pow + ptr2.pow;

                R.add(coeff, power);

                ptr2 = ptr2.next;
            }

            switch(poly2){
                case 'A':
                    ptr2 = A.head;
                    break;

                case 'B':
                    ptr2 = B.head;
                    break;

                case 'C':
                    ptr2 = C.head;
                    break;
            }

            ptr1 = ptr1.next;
        }

        removeDuplicates(R.head);
        Node abdelrahman = R.head;
        int lenD = 0;
        while(abdelrahman != null){
            lenD++;
            abdelrahman = abdelrahman.next;
        }
        int[][] array = new int [lenD][lenD];
        //convert D to 2D array
        Node current = R.head;
        for(int i=0;i<lenD;i++) {
            array[0][i] = current.coeff;
            current = current.next;
        }
        int j=0;
        for(int i=lenD-1;i>=0;i--) {
            array[1][j++] = i;
        }
        System.out.println(print('D'));
        return array;
    }

    public static void main(String[] args) {
        Scanner MyInput = new Scanner(System.in);

        int count = 0;

        while(MyInput.hasNextLine()){
            String oper = MyInput.nextLine();
            switch (oper){
                case "set":
                    if(count == 3){
                        System.out.println("Error");
                        System.exit(0);
                    }
                    else{
                        //   System.out.print("Enter the poly: ");
                        String str = MyInput.nextLine();
                        char poly = str.charAt(0);
                        if(poly == 'A' || poly == 'B' || poly == 'C'){
                            String sin = MyInput.nextLine().replaceAll("\\[|\\]", "");
                            String[] s = sin.split(",");
                            int z = s.length;
                            int[][] arr = new int[z][z];
                            if (s.length == 1 && s[0].isEmpty()){
                                System.out.println("Error");
                                System.exit(0);
                            }
                            else {
                                int x = 0;
                                for (int j = 0; j < z; j++) {
                                    arr[0][j] = Integer.parseInt(s[x]);
                                    x++;
                                }
                                int y = z - 1;
                                for (int j = 0; j < z; j++) {
                                    arr[1][j] = y;
                                    y--;
                                }
                            }
                            setPolynomial(poly, arr);
                            count++;}
                        else{

                            System.out.println("Error");
                            System.exit(0);

                        }}
                    break;
                case "print":
                    if(count == 0){
                        System.out.println("Error");
                        System.exit(0);
                    }
                    else{
                        //     System.out.print("Enter the poly: ");
                        String str = MyInput.nextLine();
                        char poly = str.charAt(0);
                        if(poly == 'A' || poly == 'B' || poly == 'C'){
                            String hla = print(poly);
                            System.out.println(hla);}
                        else{
                            System.out.println("Error");
                            System.exit(0);

                        }
                    }
                    break;
                case "clear":
                    if(count == 0){
                        System.out.println("Error");
                        System.exit(0);
                    }
                    else{
                        String str = MyInput.nextLine();
                        char poly = str.charAt(0);
                        if(poly == 'A' || poly == 'B' || poly == 'C'){
                            clearPolynomial(poly);}
                        else{
                            System.out.println("Error");
                            System.exit(0);
                        }}
                    break;
                case "eval":
                    if(count == 0){
                        System.out.println("Error");
                        System.exit(0);
                    }
                    else{
                        String str1 = MyInput.nextLine();
                        char poly1 = str1.charAt(0);
                        if(poly1 == 'A' || poly1 == 'B' || poly1 == 'C'){
                            float value = MyInput.nextFloat();
                            int val = (int) evaluatePolynomial( poly1, value);
                            System.out.println(val);}
                        else{
                            System.out.println("Error");
                            System.exit(0);
                        }}

                    break;
                case "add" :
                    if(count == 0){
                        System.out.println("Error");
                        System.exit(0);
                    }
                    else{
                        //  System.out.print("Enter the first poly: ");
                        String str2 = MyInput.nextLine();
                        char poly2 = str2.charAt(0);
                        if(poly2 == 'A' || poly2 == 'B' || poly2 == 'C'){
                            //  System.out.print("Enter the second poly: ");
                            String str3 = MyInput.nextLine();
                            char poly3 = str3.charAt(0);
                            if(poly3 == 'A' || poly3 == 'B' || poly3 == 'C'){
                                add(poly2,poly3);}
                            else{
                                System.out.println("Error");
                                System.exit(0);
                            }}


                        else{
                            System.out.println("Error");
                            System.exit(0);
                        }
                    }
                    break;
                case "sub":
                    if(count == 0){
                        System.out.println("Error");
                        System.exit(0);
                    }
                    else{
                        //   System.out.print("Enter the first poly: ");
                        String str4 = MyInput.nextLine();
                        char poly4 = str4.charAt(0);
                        if(poly4 == 'A' || poly4 == 'B' || poly4 == 'C'){
                            //   System.out.print("Enter the second poly: ");
                            String str5 = MyInput.nextLine();
                            char poly5 = str5.charAt(0);
                            if(poly5 == 'A' || poly5 == 'B' || poly5 == 'C'){
                                subtract(poly4,poly5);}

                            else{
                                System.out.println("Error");
                                System.exit(0);
                            }}
                        else{
                            System.out.println("Error");
                            System.exit(0);
                        }
                    }
                    break;


                case "mult":
                    if(count == 0){
                        System.out.println("Error");
                        System.exit(0);
                    }
                    else{
                        //   System.out.print("Enter the first poly: ");

                        String str6 = MyInput.nextLine();
                        char poly6 = str6.charAt(0);
                        if(poly6 == 'A' || poly6 == 'B' || poly6 == 'C'){
                            //   System.out.print("Enter the second poly: ");
                            String str7 = MyInput.nextLine();
                            char poly7 = str7.charAt(0);
                            if(poly7 == 'A' || poly7 == 'B' || poly7 == 'C'){
                                multiply(poly6, poly7);}
                            else{
                                System.out.println("Error");
                                System.exit(0);
                            }
                        }
                        else{
                            System.out.println("Error");
                            System.exit(0);
                        }
                    }
                    break;
                default:
                    System.out.println("Error");
                    System.exit(0);
                    break;
            }

        }
    }}