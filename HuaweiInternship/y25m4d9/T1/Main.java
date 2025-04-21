package HuaweiInternship.y25m4d9.T1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

class Node {
  String name;
  List<Node> children;

  Node(String name, ArrayList<Node> children) {
    this.name = name;
    this.children = children;
  }
}
//树的深度优先遍历
public class Main {

  static ArrayList<Node> ans = new ArrayList<>();
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    Integer N = Integer.valueOf(sc.nextLine().trim()); // 版本数量
    HashMap<String, Node> nodeMap = new HashMap<>();
    for (int i = 0; i < N; i++) {
      String[] nodes = sc.nextLine().trim().split(" "); // child node and parent node
      Node parent;
      if (nodeMap.containsKey(nodes[1])) {
        parent = nodeMap.get(nodes[1]);
        parent.children.add(new Node(nodes[0], new ArrayList<Node>()));
      } else {
        ArrayList<Node> children = new ArrayList<>();
        Node child = nodeMap.getOrDefault(nodes[0], new Node(nodes[0], new ArrayList<Node>()));
        children.add(child);
        parent = new Node(nodes[1], children);
        nodeMap.put(nodes[1], parent);
      }
    }
    Node startNode = nodeMap.get("NA");
    int currentDeepth = 0, maxDeepth = 0;
    maxDeepth = dfs(startNode, currentDeepth, maxDeepth);
    ans.sort(Comparator.comparing(node -> node.name));
    ans.forEach(a -> {
      System.out.println(a.name);
    });
  }

  private static int dfs(Node startNode, int currentDeepth, int maxDeepth) {
    if(startNode.children.size() == 0) {
      //说明是叶子节点
      if(currentDeepth > maxDeepth){
        ans = new ArrayList<>();
        ans.add(startNode);
        return currentDeepth;
      }else if(currentDeepth == maxDeepth){
        ans.add(startNode);
        return currentDeepth;
      }
      else{
        return maxDeepth;
      }
    }
    for (Node child : startNode.children) {
      maxDeepth = dfs(child, currentDeepth + 1, maxDeepth);
    }
    return maxDeepth;
  }
}
