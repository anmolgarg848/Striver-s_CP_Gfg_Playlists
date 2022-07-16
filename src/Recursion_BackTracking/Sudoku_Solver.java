package Recursion_BackTracking;

import java.util.HashSet;
import java.util.Set;

public class Sudoku_Solver {
    public static void main(String[] args) {


    }

    //https://leetcode.com/problems/sudoku-solver/
    //Approach --> Try All Possible Ways
    public boolean solveSudoku(char[][] board) {
        for (int ro = 0; ro < 9; ro++) {
            for (int co = 0; co < 9; co++) {
                if (board[ro][co] == '.') { //check for first empty place
                    for (char ch = '1'; ch <= '9'; ch++) {
                        if (isSafe(board, ch, ro, co)) {
                            board[ro][co] = ch;
                            //go and will again look for first empty cell from start
                            if (solveSudoku(board) == true) {
                                //represents all cells are Filled go Back
                                return true;
                            } else {
                                //need to Back Track
                                board[ro][co] = '.';
                            }

                        }
                    }
                    return false; //Not able to fill any valid digit go and change Last Filled # backTrack
                }

            }
        }
        return true; //represents Whole Board is filled
    }

    private static boolean isSafe(char[][] board, char dig, int r, int c) {
        for (int i = 0; i < 9; i++) {
            //check row
            if (board[r][i] == dig) return false;
            //Check Col
            if (board[i][c] == dig) return false;
            //Check Box
            //traverse sub_Block use row/3 and col/3
            //find box number then  traverse in that box
            if (board[3 * (r / 3) + (i / 3)][3 * (c / 3) + (i % 3)] == dig) return false;

        }
        return true;
    }

    //https://leetcode.com/problems/valid-sudoku/
    public boolean isValidSudoku(char[][] board) {
        int n = board.length;
        Set<String> st = new HashSet<>();
        for (int r = 0; r < 9; r++) {
            for (int c = 0; c < 9; c++) {
                if (board[r][c] != '.') {
                    //Cell Must Not Empty
                    char num = board[r][c];
                    if (num - '0' > 9) return false;
                    String row = "row" + r + "" + num;
                    String col = "col" + c + "" + num;
                    String Box_rc = "Box" + r / 3 + "" + "" + c / 3 + "" + num;
                    if (st.contains(row) || st.contains(col) || st.contains(Box_rc)) {
                        return false;
                    } else {
                        st.add(row);
                        st.add(col);
                        st.add(Box_rc);
                    }

                }
            }
        }

        return true;
    }
}
