package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * BOJ-9663
 *
 * https://www.acmicpc.net/problem/9663
 *
 * N개의 Queen을 서로 공격할 수 없는 곳에 위치할 수 있는 모든 방법
 *
 */
public class BOJ9663 {
  static int result = 0;

  static int N;

  static int[] board;

  public static void main(String[] args) throws IOException {
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    String[] line = bufferedReader.readLine()
        .split(" ");
    N = Integer.parseInt(line[0]);
    board = new int[N];

    NQueen main = new NQueen();
    main.setQueen(0);

    System.out.println(result);
  }

  static class NQueen {

    private void setQueen(int row) {
      if (row == N) {
        result++;
        return;
      }

      for (int col = 0; col < N; ++col) {
        board[row] = col;

        if (this.possible(row)) {
          setQueen(row + 1);
        }
      }
    }

    private boolean possible(int row) {
      for (int i = 0; i < row; ++i) {
        if (board[i] == board[row] || (row - i) == Math.abs(board[i] - board[row])) {
          return false;
        }
      }

      return true;
    }
  }

}
