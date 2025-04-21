package PDDInternship.T1;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    String[] split = sc.nextLine().trim().split(" ");
    Integer N = Integer.valueOf(split[0]);
    Integer K = Integer.valueOf(split[1]);
    char[] str = new char[K];
    while (N-- > 0) {
      String[] split2 = sc.nextLine().trim().split(" ");
      char[] charArray = split2[0].toCharArray();
      Arrays.sort(charArray);
      int x = Integer.valueOf(split2[1]);
      for(int i = 0; i < x;i++){
        str[--K] = charArray[i];
      }
    }
    Arrays.sort(str);
    StringBuffer sb = new StringBuffer();
    sb.append(str);
    System.out.println(sb.toString());
  }
}
