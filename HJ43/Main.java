import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

// 注意类名必须为 Main, 不要有任何 package xxx 信息
public class Main {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    // 注意 hasNext 和 hasNextLine 的区别
    int h = in.nextInt();
    int w = in.nextInt();
    int[][] map = new int[h][w];
    in.nextLine();
    for (int i = 0; i < h; i++) {
      String[] block = in.nextLine().split(" ", w);
      for(int j = 0; j < w; j++){
        map[i][j] = Integer.valueOf(block[j]);
      }
    }
    List<Coordinate> path = new ArrayList<>();
    int[][] moveOptions = new int[][]{{1,0},{0,1},{-1,0},{0,-1}};
    path.add(new Coordinate(0, 0));
    Coordinate end = new Coordinate(h - 1, w - 1);
    Main so = new Main();
    List<Coordinate> res = new ArrayList<>();
    so.dfs(map, h, w, path, end, moveOptions, res);
    res.forEach(e->{
      System.out.println(e.toString());
    });
  }

  public void dfs(int[][] map, int h, int w, List<Coordinate> path, Coordinate end, int[][] moveOptions, List<Coordinate> res){
    if(path.get(path.size() - 1).equals(end)) {
      res.addAll(path);
    }
    Coordinate currentCoordinate = path.get(path.size() - 1);

    for (int[] moveOption : moveOptions) {
      Coordinate newCoordinate = currentCoordinate.move(moveOption);
      if(path.size() > 1 && newCoordinate.equals(path.get(path.size() - 2))){
        //不往回走
        continue;
      }
      if(newCoordinate.x < 0 || newCoordinate.x >= h || newCoordinate.y < 0 || newCoordinate.y >= w){
        //不越界
        continue;
      }
      if(map[newCoordinate.x][newCoordinate.y] == 1){
        //不撞墙
        continue;
      }
      path.add(newCoordinate);
      dfs(map, h, w, path, end, moveOptions, res);
      if(res.size() != 0){
        //只有一解
        return;
      }
      path.remove(path.size() - 1);
    }
    
  }
}

class Coordinate {
  public int x, y;
  Coordinate(int x, int y){
    this.x = x;
    this.y = y;
  }
  @Override
  public boolean equals(Object obj) {
    if(!(obj instanceof Coordinate)) {
      return false;
    }
    Coordinate other = (Coordinate)obj;
    return  this.x == other.x && this.y == other.y;
  }
  public Coordinate move(int[] dir){
    Coordinate newCoordinate = new Coordinate(this.x + dir[0], this.y + dir[1]);
    return newCoordinate;
  }
  @Override
  public String toString() {
    return "(" + String.valueOf(this.x) + "," + String.valueOf(this.y) + ")";
  }
}