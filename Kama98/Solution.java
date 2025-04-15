package Kama98;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

class Solution {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    String[] split = sc.nextLine().split(" ");
    int n = Integer.valueOf(split[0]);
    HashMap<Integer, List<Integer>> map = new HashMap<>();
    for (int i = 0; i < Integer.valueOf(split[1]); i++) {
      String[] split2 = sc.nextLine().split(" ");
      if (map.containsKey(Integer.valueOf(split2[0]))) {
        map.get(Integer.valueOf(split2[0])).add(Integer.valueOf(split2[1]));
      } else {
        List<Integer> nodes = new ArrayList<>();
        nodes.add(Integer.valueOf(split2[1]));
        map.put(Integer.valueOf(split2[0]), nodes);
      }
    }
    List<List<Integer>> ans = new ArrayList<>();
    List<Integer> path = new ArrayList<>();
    Solution so = new Solution();
    path.add(Integer.valueOf(1));
    so.dfs(map, ans, path, n);
    ans.forEach(res->{
      String output = res.stream().map(String::valueOf).collect(Collectors.joining(" "));
      System.out.println(output);
    });
  }

  void dfs(HashMap<Integer, List<Integer>> map, List<List<Integer>> ans, List<Integer> path, int n) {
    Integer currentNode = path.get(path.size() - 1);
    if (currentNode == n) {
      ans.add(new ArrayList<>(path));
      return;
    }
    for (Integer node : map.getOrDefault(currentNode, new ArrayList<>())) {
      if (path.contains(node)) {
        continue;
      }
      path.add(node);
      dfs(map, ans, path, n);
      path.remove(node);
    }
  }
}
