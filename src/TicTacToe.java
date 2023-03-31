public class TicTacToe {

    boolean turn  = true;
    String check = "null";
    char[][] tic = {{'-', '-', '-'}, {'-', '-', '-'}, {'-', '-', '-'}};

    void newGame() {
        check = "null";
        turn = true;
        for (int i = 0; i < tic.length; i++) {
            for (int j = 0; j < tic[i].length; j++) {
                tic[i][j] = '-';
            }
        }
    }
    void getField() {
        for (int i = 0; i < tic.length; i++) {
            System.out.print("[ ");
            for (int j = 0; j < tic[i].length; j++) {
                System.out.print(tic[i][j] + " ");
            }
            System.out.print("]");
            System.out.println();
        }
    }
    void checkGame() {
        if (check.equals("null")) System.out.println("null");
        else if (check.equals("X")) System.out.println("X");
        else if (check.equals("O")) System.out.println("O");
        else System.out.println("D");
    }

    String makeMove(int x, int y) {
        String result = "Game was ended";

        x -= 1;
        y -= 1;
        if (turn == true && tic[x][y] == '-' && check.equals("null")) {
            tic[x][y] = 'X';
            int sum1 = 0;
            int sum2 = 0;
            int sum3 = 0;
            int sum4 = 0;
            int sum5 = 0;
            int sum6 = 0;
            int sum7 = 0;
            int sum8 = 0;
            for(int i = 0; i < tic.length; i++) {
                for(int j = 0; j < tic[i].length; j++) {
                    if (i == 0 && tic[i][j] == 'X') sum1++;
                    if (i == 1 && tic[i][j] == 'X') sum2++;
                    if (i == 2 && tic[i][j] == 'X') sum3++;
                    if (j == 0 && tic[i][j] == 'X') sum4++;
                    if (j == 1 && tic[i][j] == 'X') sum5++;
                    if (j == 2 && tic[i][j] == 'X') sum6++;
                    if (i == 0 && j == 0 || i == 1 && j == 1 || i == 2 && j == 2) {
                        if (tic[i][j] == 'X') sum7++;
                    }
                    if (i == 0 && j == 2 || i == 1 && j == 1 || i == 2 && j == 0) {
                        if (tic[i][j] == 'X') sum8++;
                    }
                }
                if (sum1==3 || sum2==3 || sum3==3 || sum4==3 || sum5==3 || sum6==3 || sum7==3 || sum8==3) {
                    result = "Player X won";
                    check = "X";
                    break;
                }
            }
            if (check != "X") result = "Move completed";
            turn = false;
        }
        else if (turn == false && tic[x][y] == '-' && check.equals("null")) {
            tic[x][y] = 'O';
            int sum1 = 0;
            int sum2 = 0;
            int sum3 = 0;
            int sum4 = 0;
            int sum5 = 0;
            int sum6 = 0;
            int sum7 = 0;
            int sum8 = 0;
            for(int i = 0; i < tic.length; i++) {
                for(int j = 0; j < tic[i].length; j++) {
                    if (i == 0 && tic[i][j] == 'O') sum1++;
                    if (i == 1 && tic[i][j] == 'O') sum2++;
                    if (i == 2 && tic[i][j] == 'O') sum3++;
                    if (j == 0 && tic[i][j] == 'O') sum4++;
                    if (j == 1 && tic[i][j] == 'O') sum5++;
                    if (j == 2 && tic[i][j] == 'O') sum6++;
                    if (i == 0 && j == 0 || i == 1 && j == 1 || i == 2 && j == 2) {
                        if (tic[i][j] == 'O') sum7++;
                    }
                    if (i == 0 && j == 2 || i == 1 && j == 1 || i == 2 && j == 0) {
                        if (tic[i][j] == 'O') sum8++;
                    }
                }
                if (sum1==3 || sum2==3 || sum3==3 || sum4==3 || sum5==3 || sum6==3 || sum7==3 || sum8==3) {
                    result = "Move completed and Player O won";
                    check = "O";
                    break;
                }
            }
            if (check != "O") result = "Move completed";
            turn = true;
        }

        else if (tic[x][y] == 'X' && tic[x][y] == 'O' || check.equals("null")) {
            boolean d = true;
            for(int i = 0; i < tic.length; i++) {
                for(int j = 0; j < tic[i].length; j++) {
                    if(tic[i][j] == '-') d = false;
                }
            }
            if (d) {
                check = "D";
            } else result = "Cell " + (x+1) + ", " + (y+1) + " is already occupied";
        }
        return result;
    }
}
