package HJ64;

import java.util.Scanner;

/*牛客网 华为机试 64 mp3翻页问题*/
public class Main {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int musicCount = Integer.valueOf(in.nextLine());
    String instrutions = in.nextLine().trim();
    Mp3 mp3 = new Mp3(musicCount);
    for (int i = 0; i < instrutions.length(); i++) {
      mp3.operate(instrutions.charAt(i));
      mp3.printPage();
      mp3.printSelectedMusic();
    }
    in.close();
    mp3.printPage();
    mp3.printSelectedMusic();
  }
}

class Mp3 {
  int musicCount;
  int pageCount;
  int currentPage;
  int selectedMusic;

  Mp3(int musicCount) {
    // 第n页会包含[n,n+3]四首歌n n+1 n+2 n+3
    this.musicCount = musicCount;
    this.pageCount = musicCount - 3 > 0 ? musicCount - 3 : 1;
    this.currentPage = 0;
    if (musicCount > 0) {
      this.selectedMusic = 0;
    }
  }

  public void printPage() {
    if(this.musicCount > 3){
      for (int i = 0; i < 3; i++) {
        System.out.print(String.valueOf(this.currentPage + i + 1) + " ");
      }
      System.out.println(String.valueOf(this.currentPage + 3 + 1));
    }else {
      for (int i = 0; i < this.musicCount - 1; i++) {
        System.out.print(String.valueOf(i + 1) + " ");
      }
      System.out.println(String.valueOf(this.musicCount));
    }
  }

  public void printSelectedMusic() {
    System.out.println(this.selectedMusic + 1);
  }

  public void operate(Character instruct) {
    if (instruct.equals('U')) {
      // java取模还比较特殊
      this.selectedMusic = ((this.selectedMusic - 1) % this.musicCount + this.musicCount) % this.musicCount;
      if (selectedMusic == this.currentPage - 1) {
        this.currentPage--;
      } else if (this.selectedMusic > this.currentPage - 1 && this.selectedMusic < this.currentPage + 3 + 1) {
        return;
      } else {
        this.currentPage = this.pageCount - 1;
      }
    } else if (instruct.equals('D')) {
      this.selectedMusic = ((this.selectedMusic + 1) % this.musicCount + this.musicCount) % this.musicCount;
      if (selectedMusic == this.currentPage +3 + 1) {
        this.currentPage++;
      } else if (this.selectedMusic > this.currentPage - 1 && this.selectedMusic < this.currentPage + 3 + 1) {
        return;
      } else {
        this.currentPage = 0;
      }
    }
  }
}
