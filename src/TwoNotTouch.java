// Created by Dylan LaMott
// Used to validate and test TwoNotTouch star puzzles
// Currently all provided test cases run efficiently and each invalid and valid cases are caught.
//Changes made: Added user menu. Also added methods for testing cages, rows, columns, horizontal, vertical, and stars.

import java.util.Scanner;

public class TwoNotTouch {

    //***
    //*** You MUST use this code.
    //*** You CANNOT CHANGE any of it
    //***
    final static int ONE_STAR_NUMBER_CAGES = 8;
    final static int TWO_STAR_NUMBER_CAGES = 10;
    final static char STAR = '*';
    final static int CHAR_POS = 0;
    final static int CAGE_POS = 1;
    final static int ASCII_NUM_INDEX = 48;

    final static int ERROR_CODE_VALID = 0;
    final static int ERROR_CODE_INCORRECT_ROW_COUNT = 1;
    final static int ERROR_CODE_INCORRECT_COLUMN_COUNT = 2;
    final static int ERROR_CODE_INCORRECT_CAGE_COUNT = 3;
    final static int ERROR_CODE_HORIZONTAL_CONTACT = 4;
    final static int ERROR_CODE_VERTICAL_CONTACT = 5;
    final static int ERROR_CODE_DIAGONAL_CONTACT = 6;
    //***
    //***
    //***

    public static void main(String[] args) {

        //***
        //*** You MUST use this code.
        //*** You CANNOT CHANGE any of it.
        //***

        //*** This is a valid one-star solution.
        char[][][] oneStarGridValid1 = {
                {{' ', '0'}, {' ', '0'}, {' ', '1'}, {' ', '2'}, {' ', '3'}, {' ', '4'}, {STAR, '4'}, {' ', '4'}},
                {{' ', '0'}, {' ', '0'}, {STAR, '1'}, {' ', '2'}, {' ', '3'}, {' ', '3'}, {' ', '3'}, {' ', '3'}},
                {{STAR, '0'}, {' ', '0'}, {' ', '2'}, {' ', '2'}, {' ', '3'}, {' ', '3'}, {' ', '3'}, {' ', '3'}},
                {{' ', '0'}, {' ', '0'}, {' ', '0'}, {' ', '2'}, {STAR, '2'}, {' ', '3'}, {' ', '3'}, {' ', '3'}},
                {{' ', '5'}, {' ', '5'}, {' ', '5'}, {' ', '5'}, {' ', '6'}, {' ', '6'}, {' ', '3'}, {STAR, '3'}},
                {{' ', '5'}, {' ', '5'}, {' ', '5'}, {' ', '5'}, {' ', '6'}, {STAR, '6'}, {' ', '3'}, {' ', '3'}},
                {{' ', '7'}, {' ', '7'}, {' ', '5'}, {STAR, '5'}, {' ', '7'}, {' ', '7'}, {' ', '7'}, {' ', '7'}},
                {{' ', '7'}, {STAR, '7'}, {' ', '7'}, {' ', '7'}, {' ', '7'}, {' ', '7'}, {' ', '7'}, {' ', '7'}}};

        //*** This is a valid one-star solution.
        char[][][] oneStarGridValid2 = {
                {{STAR, '0'}, {' ', '0'}, {' ', '0'}, {' ', '0'}, {' ', '1'}, {' ', '1'}, {' ', '1'}, {' ', '1'}},
                {{' ', '0'}, {' ', '0'}, {' ', '0'}, {STAR, '1'}, {' ', '1'}, {' ', '1'}, {' ', '2'}, {' ', '2'}},
                {{' ', '0'}, {' ', '0'}, {' ', '3'}, {' ', '3'}, {' ', '1'}, {STAR, '2'}, {' ', '2'}, {' ', '2'}},
                {{' ', '0'}, {STAR, '3'}, {' ', '3'}, {' ', '3'}, {' ', '1'}, {' ', '2'}, {' ', '2'}, {' ', '4'}},
                {{' ', '0'}, {' ', '3'}, {' ', '3'}, {' ', '3'}, {' ', '1'}, {' ', '2'}, {' ', '2'}, {STAR, '4'}},
                {{' ', '0'}, {' ', '3'}, {STAR, '5'}, {' ', '1'}, {' ', '1'}, {' ', '6'}, {' ', '6'}, {' ', '6'}},
                {{' ', '0'}, {' ', '3'}, {' ', '5'}, {' ', '1'}, {STAR, '6'}, {' ', '6'}, {' ', '7'}, {' ', '6'}},
                {{' ', '0'}, {' ', '3'}, {' ', '3'}, {' ', '3'}, {' ', '3'}, {' ', '6'}, {STAR, '7'}, {' ', '6'}}};

        //*** This is an invalid one-star solution that contains incorrect row counts.
        char[][][] oneStarGridInvalidRow = {
                {{' ', '0'}, {' ', '0'}, {STAR, '1'}, {' ', '2'}, {' ', '3'}, {' ', '4'}, {STAR, '4'}, {' ', '4'}},
                {{' ', '0'}, {' ', '0'}, {' ', '1'}, {' ', '2'}, {' ', '3'}, {' ', '3'}, {' ', '3'}, {' ', '3'}},
                {{STAR, '0'}, {' ', '0'}, {' ', '2'}, {' ', '2'}, {' ', '3'}, {' ', '3'}, {' ', '3'}, {' ', '3'}},
                {{' ', '0'}, {' ', '0'}, {' ', '0'}, {' ', '2'}, {STAR, '2'}, {' ', '3'}, {' ', '3'}, {' ', '3'}},
                {{' ', '5'}, {' ', '5'}, {' ', '5'}, {' ', '5'}, {' ', '6'}, {' ', '6'}, {' ', '3'}, {STAR, '3'}},
                {{' ', '5'}, {' ', '5'}, {' ', '5'}, {' ', '5'}, {' ', '6'}, {STAR, '6'}, {' ', '3'}, {' ', '3'}},
                {{' ', '7'}, {' ', '7'}, {' ', '5'}, {STAR, '5'}, {' ', '7'}, {' ', '7'}, {' ', '7'}, {' ', '7'}},
                {{' ', '7'}, {STAR, '7'}, {' ', '7'}, {' ', '7'}, {' ', '7'}, {' ', '7'}, {' ', '7'}, {' ', '7'}}};

        //*** This is an invalid one-star solution that contains incorrect column counts.
        char[][][] oneStarGridInvalidColumn = {
                {{' ', '0'}, {' ', '0'}, {' ', '1'}, {' ', '2'}, {STAR, '3'}, {' ', '4'}, {' ', '4'}, {' ', '4'}},
                {{' ', '0'}, {' ', '0'}, {STAR, '1'}, {' ', '2'}, {' ', '3'}, {' ', '3'}, {' ', '3'}, {' ', '3'}},
                {{STAR, '0'}, {' ', '0'}, {' ', '2'}, {' ', '2'}, {' ', '3'}, {' ', '3'}, {' ', '3'}, {' ', '3'}},
                {{' ', '0'}, {' ', '0'}, {' ', '0'}, {' ', '2'}, {STAR, '2'}, {' ', '3'}, {' ', '3'}, {' ', '3'}},
                {{' ', '5'}, {' ', '5'}, {' ', '5'}, {' ', '5'}, {' ', '6'}, {' ', '6'}, {' ', '3'}, {STAR, '3'}},
                {{' ', '5'}, {' ', '5'}, {' ', '5'}, {' ', '5'}, {' ', '6'}, {STAR, '6'}, {' ', '3'}, {' ', '3'}},
                {{' ', '7'}, {' ', '7'}, {' ', '5'}, {STAR, '5'}, {' ', '7'}, {' ', '7'}, {' ', '7'}, {' ', '7'}},
                {{' ', '7'}, {STAR, '7'}, {' ', '7'}, {' ', '7'}, {' ', '7'}, {' ', '7'}, {' ', '7'}, {' ', '7'}}};

        //*** This is an invalid one-star solution that contains direct contact between stars diagonally.
        char[][][] oneStarGridInValidDiagonal = {
                {{' ', '0'}, {' ', '0'}, {' ', '1'}, {' ', '2'}, {' ', '3'}, {' ', '4'}, {STAR, '4'}, {' ', '4'}},
                {{' ', '0'}, {' ', '0'}, {STAR, '1'}, {' ', '2'}, {' ', '3'}, {' ', '3'}, {' ', '3'}, {' ', '3'}},
                {{STAR, '0'}, {' ', '0'}, {' ', '2'}, {' ', '2'}, {' ', '3'}, {' ', '3'}, {' ', '3'}, {' ', '3'}},
                {{' ', '0'}, {' ', '0'}, {' ', '0'}, {' ', '2'}, {STAR, '2'}, {' ', '3'}, {' ', '3'}, {' ', '3'}},
                {{' ', '5'}, {' ', '5'}, {' ', '5'}, {' ', '5'}, {' ', '6'}, {STAR, '6'}, {' ', '3'}, {' ', '3'}},
                {{' ', '5'}, {' ', '5'}, {' ', '5'}, {' ', '5'}, {' ', '6'}, {' ', '6'}, {' ', '3'}, {STAR, '3'}},
                {{' ', '7'}, {' ', '7'}, {' ', '5'}, {STAR, '5'}, {' ', '7'}, {' ', '7'}, {' ', '7'}, {' ', '7'}},
                {{' ', '7'}, {STAR, '7'}, {' ', '7'}, {' ', '7'}, {' ', '7'}, {' ', '7'}, {' ', '7'}, {' ', '7'}}};

        //*** This is an invalid one-star solution that contains incorrect cage counts.
        char[][][] oneStarGridInvalidCageOnly = {
                {{' ', '0'}, {' ', '0'}, {' ', '1'}, {' ', '2'}, {STAR, '3'}, {' ', '4'}, {' ', '4'}, {' ', '4'}},
                {{' ', '0'}, {' ', '0'}, {STAR, '1'}, {' ', '2'}, {' ', '3'}, {' ', '3'}, {' ', '3'}, {' ', '3'}},
                {{STAR, '0'}, {' ', '0'}, {' ', '2'}, {' ', '2'}, {' ', '3'}, {' ', '3'}, {' ', '3'}, {' ', '3'}},
                {{' ', '0'}, {' ', '0'}, {' ', '0'}, {STAR, '2'}, {' ', '2'}, {' ', '3'}, {' ', '3'}, {' ', '3'}},
                {{' ', '5'}, {' ', '5'}, {' ', '5'}, {' ', '5'}, {' ', '6'}, {' ', '6'}, {' ', '3'}, {STAR, '3'}},
                {{' ', '5'}, {' ', '5'}, {' ', '5'}, {' ', '5'}, {' ', '6'}, {STAR, '6'}, {' ', '3'}, {' ', '3'}},
                {{' ', '7'}, {STAR, '7'}, {' ', '5'}, {' ', '5'}, {' ', '7'}, {' ', '7'}, {' ', '7'}, {' ', '7'}},
                {{' ', '7'}, {' ', '7'}, {' ', '7'}, {' ', '7'}, {' ', '7'}, {' ', '7'}, {STAR, '7'}, {' ', '7'}}};

        //*** This is a valid two-star solution.
        char[][][] twoStarGridValid1 = {
                {{' ', '0'}, {STAR, '0'}, {' ', '0'}, {' ', '0'}, {STAR, '0'}, {' ', '0'}, {' ', '0'}, {' ', '0'}, {' ', '1'}, {' ', '1'}},
                {{' ', '0'}, {' ', '0'}, {' ', '0'}, {' ', '0'}, {' ', '0'}, {' ', '0'}, {STAR, '2'}, {' ', '0'}, {STAR, '1'}, {' ', '1'}},
                {{' ', '3'}, {STAR, '4'}, {' ', '4'}, {STAR, '4'}, {' ', '0'}, {' ', '2'}, {' ', '2'}, {' ', '2'}, {' ', '1'}, {' ', '1'}},
                {{' ', '3'}, {' ', '3'}, {' ', '3'}, {' ', '3'}, {' ', '5'}, {' ', '6'}, {' ', '6'}, {STAR, '2'}, {' ', '1'}, {STAR, '1'}},
                {{' ', '3'}, {' ', '3'}, {' ', '3'}, {STAR, '5'}, {' ', '5'}, {STAR, '5'}, {' ', '6'}, {' ', '6'}, {' ', '1'}, {' ', '1'}},
                {{STAR, '3'}, {' ', '3'}, {' ', '7'}, {' ', '5'}, {' ', '5'}, {' ', '5'}, {' ', '6'}, {STAR, '6'}, {' ', '1'}, {' ', '1'}},
                {{' ', '3'}, {' ', '3'}, {STAR, '7'}, {' ', '7'}, {STAR, '7'}, {' ', '6'}, {' ', '6'}, {' ', '6'}, {' ', '8'}, {' ', '1'}},
                {{' ', '3'}, {' ', '3'}, {' ', '3'}, {' ', '3'}, {' ', '3'}, {' ', '3'}, {STAR, '6'}, {' ', '6'}, {STAR, '8'}, {' ', '1'}},
                {{STAR, '3'}, {' ', '9'}, {STAR, '9'}, {' ', '9'}, {' ', '9'}, {' ', '9'}, {' ', '9'}, {' ', '9'}, {' ', '8'}, {' ', '8'}},
                {{' ', '9'}, {' ', '9'}, {' ', '9'}, {' ', '9'}, {' ', '9'}, {STAR, '9'}, {' ', '9'}, {' ', '9'}, {' ', '9'}, {STAR, '8'}}};

        //*** This is a valid two-star solution.
        char[][][] twoStarGridValid2 = {
                {{' ', '0'}, {' ', '0'}, {' ', '0'}, {' ', '0'}, {STAR, '0'}, {' ', '0'}, {' ', '1'}, {STAR, '1'}, {' ', '1'}, {' ', '1'}},
                {{' ', '0'}, {STAR, '2'}, {' ', '0'}, {' ', '0'}, {' ', '0'}, {' ', '0'}, {' ', '0'}, {' ', '1'}, {' ', '1'}, {STAR, '3'}},
                {{' ', '0'}, {' ', '2'}, {' ', '2'}, {STAR, '0'}, {' ', '0'}, {STAR, '1'}, {' ', '1'}, {' ', '1'}, {' ', '3'}, {' ', '3'}},
                {{' ', '4'}, {STAR, '2'}, {' ', '5'}, {' ', '5'}, {' ', '0'}, {' ', '1'}, {' ', '1'}, {' ', '1'}, {STAR, '3'}, {' ', '3'}},
                {{' ', '4'}, {' ', '4'}, {' ', '5'}, {STAR, '5'}, {' ', '5'}, {STAR, '6'}, {' ', '6'}, {' ', '6'}, {' ', '6'}, {' ', '6'}},
                {{STAR, '4'}, {' ', '4'}, {' ', '5'}, {' ', '5'}, {' ', '5'}, {' ', '5'}, {' ', '6'}, {STAR, '6'}, {' ', '6'}, {' ', '6'}},
                {{' ', '4'}, {' ', '4'}, {STAR, '5'}, {' ', '5'}, {STAR, '7'}, {' ', '7'}, {' ', '6'}, {' ', '6'}, {' ', '6'}, {' ', '6'}},
                {{' ', '4'}, {' ', '4'}, {' ', '5'}, {' ', '5'}, {' ', '5'}, {' ', '7'}, {STAR, '8'}, {' ', '6'}, {' ', '6'}, {STAR, '9'}},
                {{STAR, '4'}, {' ', '4'}, {STAR, '7'}, {' ', '7'}, {' ', '7'}, {' ', '7'}, {' ', '8'}, {' ', '9'}, {' ', '9'}, {' ', '9'}},
                {{' ', '7'}, {' ', '7'}, {' ', '7'}, {' ', '7'}, {' ', '7'}, {' ', '7'}, {STAR, '8'}, {' ', '8'}, {STAR, '9'}, {' ', '9'}}};

        //*** This is an invalid two-star solution that contains incorrect row counts.
        char[][][] twoStarGridInvalidRow = {
                {{' ', '0'}, {STAR, '0'}, {' ', '0'}, {' ', '0'}, {STAR, '0'}, {' ', '0'}, {' ', '0'}, {' ', '0'}, {STAR, '1'}, {' ', '1'}},
                {{' ', '0'}, {' ', '0'}, {' ', '0'}, {' ', '0'}, {' ', '0'}, {' ', '0'}, {STAR, '2'}, {' ', '0'}, {' ', '1'}, {' ', '1'}},
                {{' ', '3'}, {STAR, '4'}, {' ', '4'}, {STAR, '4'}, {' ', '0'}, {' ', '2'}, {' ', '2'}, {' ', '2'}, {' ', '1'}, {' ', '1'}},
                {{' ', '3'}, {' ', '3'}, {' ', '3'}, {' ', '3'}, {' ', '5'}, {' ', '6'}, {' ', '6'}, {STAR, '2'}, {' ', '1'}, {STAR, '1'}},
                {{' ', '3'}, {' ', '3'}, {' ', '3'}, {STAR, '5'}, {' ', '5'}, {STAR, '5'}, {' ', '6'}, {' ', '6'}, {' ', '1'}, {' ', '1'}},
                {{STAR, '3'}, {' ', '3'}, {' ', '7'}, {' ', '5'}, {' ', '5'}, {' ', '5'}, {' ', '6'}, {STAR, '6'}, {' ', '1'}, {' ', '1'}},
                {{' ', '3'}, {' ', '3'}, {STAR, '7'}, {' ', '7'}, {STAR, '7'}, {' ', '6'}, {' ', '6'}, {' ', '6'}, {' ', '8'}, {' ', '1'}},
                {{' ', '3'}, {' ', '3'}, {' ', '3'}, {' ', '3'}, {' ', '3'}, {' ', '3'}, {STAR, '6'}, {' ', '6'}, {STAR, '8'}, {' ', '1'}},
                {{STAR, '3'}, {' ', '9'}, {STAR, '9'}, {' ', '9'}, {' ', '9'}, {' ', '9'}, {' ', '9'}, {' ', '9'}, {' ', '8'}, {' ', '8'}},
                {{' ', '9'}, {' ', '9'}, {' ', '9'}, {' ', '9'}, {' ', '9'}, {STAR, '9'}, {' ', '9'}, {' ', '9'}, {' ', '9'}, {STAR, '8'}}};

        //*** This is an invalid two-star solution that contains incorrect column counts.
        char[][][] twoStarGridInvalidColumn = {
                {{' ', '0'}, {STAR, '0'}, {' ', '0'}, {' ', '0'}, {STAR, '0'}, {' ', '0'}, {' ', '0'}, {' ', '0'}, {' ', '1'}, {' ', '1'}},
                {{' ', '0'}, {' ', '0'}, {' ', '0'}, {' ', '0'}, {' ', '0'}, {' ', '0'}, {STAR, '2'}, {' ', '0'}, {' ', '1'}, {STAR, '1'}},
                {{' ', '3'}, {STAR, '4'}, {' ', '4'}, {STAR, '4'}, {' ', '0'}, {' ', '2'}, {' ', '2'}, {' ', '2'}, {' ', '1'}, {' ', '1'}},
                {{' ', '3'}, {' ', '3'}, {' ', '3'}, {' ', '3'}, {' ', '5'}, {' ', '6'}, {' ', '6'}, {STAR, '2'}, {' ', '1'}, {STAR, '1'}},
                {{' ', '3'}, {' ', '3'}, {' ', '3'}, {STAR, '5'}, {' ', '5'}, {STAR, '5'}, {' ', '6'}, {' ', '6'}, {' ', '1'}, {' ', '1'}},
                {{STAR, '3'}, {' ', '3'}, {' ', '7'}, {' ', '5'}, {' ', '5'}, {' ', '5'}, {' ', '6'}, {STAR, '6'}, {' ', '1'}, {' ', '1'}},
                {{' ', '3'}, {' ', '3'}, {STAR, '7'}, {' ', '7'}, {STAR, '7'}, {' ', '6'}, {' ', '6'}, {' ', '6'}, {' ', '8'}, {' ', '1'}},
                {{' ', '3'}, {' ', '3'}, {' ', '3'}, {' ', '3'}, {' ', '3'}, {' ', '3'}, {STAR, '6'}, {' ', '6'}, {STAR, '8'}, {' ', '1'}},
                {{STAR, '3'}, {' ', '9'}, {STAR, '9'}, {' ', '9'}, {' ', '9'}, {' ', '9'}, {' ', '9'}, {' ', '9'}, {' ', '8'}, {' ', '8'}},
                {{' ', '9'}, {' ', '9'}, {' ', '9'}, {' ', '9'}, {' ', '9'}, {STAR, '9'}, {' ', '9'}, {' ', '9'}, {' ', '9'}, {STAR, '8'}}};

        //*** This is an invalid two-star solution that contains direct contact between stars horizontally (left and/or right).
        char[][][] twoStarGridInvalidHorizontal = {
                {{' ', '0'}, {' ', '0'}, {' ', '0'}, {STAR, '0'}, {STAR, '0'}, {' ', '0'}, {' ', '0'}, {' ', '0'}, {' ', '1'}, {' ', '1'}},
                {{' ', '0'}, {' ', '0'}, {' ', '0'}, {' ', '0'}, {' ', '0'}, {' ', '0'}, {STAR, '2'}, {' ', '0'}, {STAR, '1'}, {' ', '1'}},
                {{' ', '3'}, {STAR, '4'}, {STAR, '4'}, {' ', '4'}, {' ', '0'}, {' ', '2'}, {' ', '2'}, {' ', '2'}, {' ', '1'}, {' ', '1'}},
                {{' ', '3'}, {' ', '3'}, {' ', '3'}, {' ', '3'}, {' ', '5'}, {' ', '6'}, {' ', '6'}, {STAR, '2'}, {' ', '1'}, {STAR, '1'}},
                {{' ', '3'}, {' ', '3'}, {' ', '3'}, {STAR, '5'}, {' ', '5'}, {STAR, '5'}, {' ', '6'}, {' ', '6'}, {' ', '1'}, {' ', '1'}},
                {{STAR, '3'}, {' ', '3'}, {' ', '7'}, {' ', '5'}, {' ', '5'}, {' ', '5'}, {' ', '6'}, {STAR, '6'}, {' ', '1'}, {' ', '1'}},
                {{' ', '3'}, {' ', '3'}, {STAR, '7'}, {' ', '7'}, {STAR, '7'}, {' ', '6'}, {' ', '6'}, {' ', '6'}, {' ', '8'}, {' ', '1'}},
                {{' ', '3'}, {' ', '3'}, {' ', '3'}, {' ', '3'}, {' ', '3'}, {' ', '3'}, {STAR, '6'}, {' ', '6'}, {STAR, '8'}, {' ', '1'}},
                {{STAR, '3'}, {STAR, '9'}, {' ', '9'}, {' ', '9'}, {' ', '9'}, {' ', '9'}, {' ', '9'}, {' ', '9'}, {' ', '8'}, {' ', '8'}},
                {{' ', '9'}, {' ', '9'}, {' ', '9'}, {' ', '9'}, {' ', '9'}, {STAR, '9'}, {' ', '9'}, {' ', '9'}, {' ', '9'}, {STAR, '8'}}};

        //*** This is an invalid two-star solution that contains direct contact between stars vertically (up and/or down).
        char[][][] twoStarGridInvalidVertical = {
                {{' ', '0'}, {' ', '0'}, {' ', '0'}, {' ', '0'}, {STAR, '0'}, {' ', '0'}, {' ', '1'}, {STAR, '1'}, {' ', '1'}, {' ', '1'}},
                {{' ', '0'}, {STAR, '2'}, {' ', '0'}, {' ', '0'}, {' ', '0'}, {' ', '0'}, {' ', '0'}, {' ', '1'}, {' ', '1'}, {STAR, '3'}},
                {{' ', '0'}, {STAR, '2'}, {' ', '2'}, {STAR, '0'}, {' ', '0'}, {' ', '1'}, {' ', '1'}, {' ', '1'}, {' ', '3'}, {' ', '3'}},
                {{' ', '4'}, {' ', '2'}, {' ', '5'}, {' ', '5'}, {' ', '0'}, {STAR, '1'}, {' ', '1'}, {' ', '1'}, {STAR, '3'}, {' ', '3'}},
                {{' ', '4'}, {' ', '4'}, {' ', '5'}, {STAR, '5'}, {' ', '5'}, {STAR, '6'}, {' ', '6'}, {' ', '6'}, {' ', '6'}, {' ', '6'}},
                {{STAR, '4'}, {' ', '4'}, {' ', '5'}, {' ', '5'}, {' ', '5'}, {' ', '5'}, {' ', '6'}, {STAR, '6'}, {' ', '6'}, {' ', '6'}},
                {{' ', '4'}, {' ', '4'}, {STAR, '5'}, {' ', '5'}, {STAR, '7'}, {' ', '7'}, {' ', '6'}, {' ', '6'}, {' ', '6'}, {' ', '6'}},
                {{' ', '4'}, {' ', '4'}, {' ', '5'}, {' ', '5'}, {' ', '5'}, {' ', '7'}, {STAR, '8'}, {' ', '6'}, {' ', '6'}, {STAR, '9'}},
                {{STAR, '4'}, {' ', '4'}, {' ', '7'}, {' ', '7'}, {' ', '7'}, {' ', '7'}, {STAR, '8'}, {' ', '9'}, {' ', '9'}, {' ', '9'}},
                {{' ', '7'}, {' ', '7'}, {STAR, '7'}, {' ', '7'}, {' ', '7'}, {' ', '7'}, {' ', '8'}, {' ', '8'}, {STAR, '9'}, {' ', '9'}}};

        //*** This is an invalid two-star solution that contains direct contact between stars diagonally.
        char[][][] twoStarGridInValidDiagonal = {
                {{' ', '0'}, {STAR, '0'}, {' ', '0'}, {' ', '0'}, {' ', '0'}, {' ', '0'}, {' ', '0'}, {' ', '0'}, {STAR, '1'}, {' ', '1'}},
                {{' ', '0'}, {' ', '0'}, {' ', '0'}, {' ', '0'}, {STAR, '0'}, {' ', '0'}, {STAR, '2'}, {' ', '0'}, {' ', '1'}, {' ', '1'}},
                {{' ', '3'}, {STAR, '4'}, {' ', '4'}, {STAR, '4'}, {' ', '0'}, {' ', '2'}, {' ', '2'}, {' ', '2'}, {' ', '1'}, {' ', '1'}},
                {{' ', '3'}, {' ', '3'}, {' ', '3'}, {' ', '3'}, {' ', '5'}, {' ', '6'}, {' ', '6'}, {STAR, '2'}, {' ', '1'}, {STAR, '1'}},
                {{' ', '3'}, {' ', '3'}, {' ', '3'}, {STAR, '5'}, {' ', '5'}, {STAR, '5'}, {' ', '6'}, {' ', '6'}, {' ', '1'}, {' ', '1'}},
                {{STAR, '3'}, {' ', '3'}, {' ', '7'}, {' ', '5'}, {' ', '5'}, {' ', '5'}, {' ', '6'}, {STAR, '6'}, {' ', '1'}, {' ', '1'}},
                {{' ', '3'}, {' ', '3'}, {STAR, '7'}, {' ', '7'}, {STAR, '7'}, {' ', '6'}, {' ', '6'}, {' ', '6'}, {' ', '8'}, {' ', '1'}},
                {{' ', '3'}, {' ', '3'}, {' ', '3'}, {' ', '3'}, {' ', '3'}, {' ', '3'}, {STAR, '6'}, {' ', '6'}, {STAR, '8'}, {' ', '1'}},
                {{STAR, '3'}, {' ', '9'}, {STAR, '9'}, {' ', '9'}, {' ', '9'}, {' ', '9'}, {' ', '9'}, {' ', '9'}, {' ', '8'}, {' ', '8'}},
                {{' ', '9'}, {' ', '9'}, {' ', '9'}, {' ', '9'}, {' ', '9'}, {STAR, '9'}, {' ', '9'}, {' ', '9'}, {' ', '9'}, {STAR, '8'}}};

        //*** This is an invalid two-star solution that contains incorrect cage counts.
        char[][][] twoStarGridInvalidCageOnly = {
                {{' ', '0'}, {STAR, '0'}, {' ', '0'}, {' ', '0'}, {STAR, '0'}, {' ', '0'}, {' ', '0'}, {' ', '0'}, {' ', '1'}, {' ', '1'}},
                {{' ', '0'}, {' ', '0'}, {' ', '0'}, {' ', '0'}, {' ', '0'}, {' ', '0'}, {STAR, '2'}, {' ', '0'}, {STAR, '1'}, {' ', '1'}},
                {{' ', '3'}, {STAR, '4'}, {' ', '4'}, {STAR, '4'}, {' ', '0'}, {' ', '2'}, {' ', '2'}, {' ', '2'}, {' ', '1'}, {' ', '1'}},
                {{' ', '3'}, {' ', '3'}, {' ', '3'}, {' ', '3'}, {' ', '5'}, {STAR, '6'}, {' ', '6'}, {STAR, '2'}, {' ', '1'}, {' ', '1'}},
                {{' ', '3'}, {' ', '3'}, {' ', '3'}, {STAR, '5'}, {' ', '5'}, {' ', '5'}, {' ', '6'}, {' ', '6'}, {' ', '1'}, {STAR, '1'}},
                {{STAR, '3'}, {' ', '3'}, {' ', '7'}, {' ', '5'}, {' ', '5'}, {' ', '5'}, {' ', '6'}, {STAR, '6'}, {' ', '1'}, {' ', '1'}},
                {{' ', '3'}, {' ', '3'}, {STAR, '7'}, {' ', '7'}, {STAR, '7'}, {' ', '6'}, {' ', '6'}, {' ', '6'}, {' ', '8'}, {' ', '1'}},
                {{' ', '3'}, {' ', '3'}, {' ', '3'}, {' ', '3'}, {' ', '3'}, {' ', '3'}, {STAR, '6'}, {' ', '6'}, {STAR, '8'}, {' ', '1'}},
                {{STAR, '3'}, {' ', '9'}, {STAR, '9'}, {' ', '9'}, {' ', '9'}, {' ', '9'}, {' ', '9'}, {' ', '9'}, {' ', '8'}, {' ', '8'}},
                {{' ', '9'}, {' ', '9'}, {' ', '9'}, {' ', '9'}, {' ', '9'}, {STAR, '9'}, {' ', '9'}, {' ', '9'}, {' ', '9'}, {STAR, '8'}}};
        //***
        //***
        //***

        //***
        //*** You MUST use this code.
        //*** The only change that you can make is which
        //***     char grid is passed to the methods.
        //*** For example: oneStarGridInvalidCageOnly or twoStarGridInvalidCageOnly as used below.

        // boolean added to run while loop for user menu
        boolean validEntry = true;

        //While loop for user selection of puzzles to test
        while (validEntry) {
            //Scanner opens to catch user entry
            Scanner scanner = new Scanner(System.in);
            // User menu
            System.out.println("Please select an option to test \n1. OneStarGridValid1" +
                    "\n2. OneStarGirdValid2 \n3. oneStarGridInvalidRow\n4. OneStarGridInvalidColumn\n5. OneStarGridInvalidDiagonal"
                    + "\n6. OneStarGridInvalidCageOnly\n7. twoStarGridValid1\n8. twoStarGridValid2\n9. twoStarGridInvalidRow" +
                    "\n10. twoStarGridInvalidColumn\n11. twoStarGridInvalidHorizontal\n12. twoStarGridInvalidVertical" +
                    "\n13. twoStarGridInValidDiagonal\n14. twoStarGridInvalidCageOnly\n15. EXIT\nEnter number to test: "
            );

            String input = scanner.nextLine();


            // Switch statement cases are based on the above user menu in the same order
            switch (input) {
                case "1":
                    gridPrint(oneStarGridValid1);
                    System.out.println();

                    processErrorCode(gridValid(oneStarGridValid1, 1, ONE_STAR_NUMBER_CAGES));
                    System.out.println();
                    break;
                case "2":
                    gridPrint(oneStarGridValid2);
                    System.out.println();

                    processErrorCode(gridValid(oneStarGridValid2, 1, ONE_STAR_NUMBER_CAGES));
                    break;
                case "3":
                    gridPrint(oneStarGridInvalidRow);
                    System.out.println();

                    processErrorCode(gridValid(oneStarGridInvalidRow, 1, ONE_STAR_NUMBER_CAGES));
                    System.out.println();
                    break;
                case "4":
                    gridPrint(oneStarGridInvalidColumn);
                    System.out.println();

                    processErrorCode(gridValid(oneStarGridInvalidColumn, 1, ONE_STAR_NUMBER_CAGES));
                    System.out.println();
                    break;
                case "5":
                    gridPrint(oneStarGridInValidDiagonal);
                    System.out.println();

                    processErrorCode(gridValid(oneStarGridInValidDiagonal, 1, ONE_STAR_NUMBER_CAGES));
                    System.out.println();
                    break;
                case "6":
                    gridPrint(oneStarGridInvalidCageOnly);
                    System.out.println();

                    processErrorCode(gridValid(oneStarGridInvalidCageOnly, 1, ONE_STAR_NUMBER_CAGES));
                    System.out.println();
                    break;
                case "7":
                    gridPrint(twoStarGridValid1);
                    System.out.println();

                    processErrorCode(gridValid(twoStarGridValid1, 2, TWO_STAR_NUMBER_CAGES));
                    System.out.println();
                    break;
                case "8":
                    gridPrint(twoStarGridValid2);
                    System.out.println();

                    processErrorCode(gridValid(twoStarGridValid2, 2, TWO_STAR_NUMBER_CAGES));
                    System.out.println();
                    break;
                case "9":
                    gridPrint(twoStarGridInvalidRow);
                    System.out.println();

                    processErrorCode(gridValid(twoStarGridInvalidRow, 2, TWO_STAR_NUMBER_CAGES));
                    System.out.println();
                    break;
                case "10":
                    gridPrint(twoStarGridInvalidColumn);
                    System.out.println();

                    processErrorCode(gridValid(twoStarGridInvalidColumn, 2, TWO_STAR_NUMBER_CAGES));
                    System.out.println();
                    break;
                case "11":
                    gridPrint(twoStarGridInvalidHorizontal);
                    System.out.println();

                    processErrorCode(gridValid(twoStarGridInvalidHorizontal, 2, TWO_STAR_NUMBER_CAGES));
                    System.out.println();
                    break;
                case "12":
                    gridPrint(twoStarGridInvalidVertical);
                    System.out.println();

                    processErrorCode(gridValid(twoStarGridInvalidVertical, 2, TWO_STAR_NUMBER_CAGES));
                    System.out.println();
                    break;
                case "13":
                    gridPrint(twoStarGridInValidDiagonal);
                    System.out.println();

                    processErrorCode(gridValid(twoStarGridInValidDiagonal, 2, TWO_STAR_NUMBER_CAGES));
                    System.out.println();
                    break;
                case "14":
                    gridPrint(twoStarGridInvalidCageOnly);
                    System.out.println();

                    processErrorCode(gridValid(twoStarGridInvalidCageOnly, 2, TWO_STAR_NUMBER_CAGES));
                    System.out.println();
                    break;
                case "15":
                    System.out.println("Good Bye!");
                    validEntry = false;
                    scanner.close();
                    break;
                default:
                    System.out.println("You entered an incorrect entry!");
                    System.out.println("Please enter a correct number for testing!");
                    System.out.println();
                    break;
            }
        }
    }

    //***
    //*** You MUST use this code.
    //*** You CANNOT CHANGE any of it.
    //***
    //*** The numbers in the displayed grid represent the "cages".
    //*** All cells with the same number are in the same cage.
    //*** In other words, all cells with the number 0 are in the same
    //***    cage, all cells with the number 1 are in the same cage,
    //***    and so on.
    //***
    //*** The asterisks represent the cell in which a star is placed.
    //***
    public static void gridPrint(char[][][] grid) {

        System.out.println();
        System.out.print("\t");

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                System.out.print(grid[i][j][CHAR_POS] + "" + grid[i][j][CAGE_POS] + "\t");
            }

            System.out.println();
            System.out.print("\t");
        }
    }

    //***
    //*** You MUST use this code.
    //*** You CANNOT CHANGE any of it.
    //***
    public static void processErrorCode(int errorCode) {
        switch (errorCode) {
            case ERROR_CODE_VALID:
                System.out.println("This is a valid Star Battle solution.");
                break;
            case ERROR_CODE_INCORRECT_ROW_COUNT:
                System.out.println("This is an invalid Star Battle solution. There is an incorrect row count.");
                break;
            case ERROR_CODE_INCORRECT_COLUMN_COUNT:
                System.out.println("This is an invalid Star Battle solution. There is an incorrect column count.");
                break;
            case ERROR_CODE_INCORRECT_CAGE_COUNT:
                System.out.println("This is an invalid Star Battle solution. There is an incorrect cage count.");
                break;
            case ERROR_CODE_HORIZONTAL_CONTACT:
                System.out.println("This is an invalid Star Battle solution. Stars have direct horizontal contact.");
                break;
            case ERROR_CODE_VERTICAL_CONTACT:
                System.out.println("This is an invalid Star Battle solution. Stars have direct vertical contact.");
                break;
            case ERROR_CODE_DIAGONAL_CONTACT:
                System.out.println("This is an invalid Star Battle solution. Stars have direct diagonal contact.");
                break;
        }
    }

    //***
    //*** You MUST use this code.
    //*** You CANNOT CHANGE the parameter list.
    //***
    //*** You MUST make the appropriate code additions.
    //***
    public static int gridValid(char[][][] grid, int stars, int numberCages) {

        //***
        //*** You MUST use this code.
        //***
        int errorCode = ERROR_CODE_VALID;
        int[] cageCount = new int[numberCages];
        //***
        //***
        //***

        //***
        //*** If you want to use my skeleton nested while-loops, then
        //***     you will need this code.
        //***
        int row = 0;
        int col = 0;
        boolean isValid = true;
        //***
        //***
        //***

        while (isValid && row < grid.length) {

            //***
            //*** Write code to check the constraint that there cannot be
            //***     more than parameter variable "stars" number of stars
            //***      in a given row.
            //***

            //*** If this constraint is violated, then set the variable
            //***     "errorCode" to ERROR_CODE_INCORRECT_ROW_COUNT
            /// Solved
            //***
            if (violatesNumberofStars(grid[row], stars)) {
                isValid = false;
                errorCode = ERROR_CODE_INCORRECT_ROW_COUNT;
                // error
            }

            while (isValid && col < grid[row].length) {


                //***
                //*** Write code to check the constraint that there cannot be
                //***     more than parameter variable "stars" number of stars
                //***      in a given column.
                //***
                //*** If this constraint is violated, then set the variable
                //***     "errorCode" to ERROR_CODE_INCORRECT_COLUMN_COUNT
                //***
                /// Solved
                // Create array of columns from grid
                char[][] column = getColumn(grid, col);
                // Pass function to determine column count and if star violation occurs
                if (violatesNumberofStars(column, stars)) {
                    isValid = false;
                    errorCode = ERROR_CODE_INCORRECT_COLUMN_COUNT;
                    // error
                }


                //***
                //*** Write code to check the constraint that there cannot be direct
                //***     contact between two stars horizontally (left or right).
                //***
                //*** If this constraint is violated, then set the variable
                //***     "errorCode" to ERROR_CODE_HORIZONTAL_CONTACT
                //*** SOLVED
                // If else statement for searching star positions diagonally.
                // Methods I have written are called to prevent index out of bound errors when checking the grid.

                // Create array containing grid for usage of hasStar method
                char[] entry = grid[row][col];
                // If has star perform respective checks based on position within array to prevent out of bounds
                if (hasStar(entry)) {
                    //calls method to validate star and moves to the left until end of array
                    if (hasSpaceToLeft(col) && hasStar(grid[row][col - 1])) {
                        isValid = false;
                        errorCode = ERROR_CODE_HORIZONTAL_CONTACT;
                    }
                    // Calls method to validate star and moves to the right until the end of array
                    if (hasSpaceToRight(grid, row, col) && hasStar(grid[row][col + 1])) {
                        isValid = false;
                        errorCode = ERROR_CODE_HORIZONTAL_CONTACT;
                    }
                }


                //***
                //*** Write code to check the constraint that there cannot be direct
                //***     contact between two stars vertically (up or down).
                //***
                //*** If this constraint is violated, then set the variable
                //***     "errorCode" to ERROR_CODE_VERTICAL_CONTACT
                //*** SOLVED

                // If else statement for searching star positions vertically.
                // If has star perform respective checks based on position within array to prevent out of bounds
                if (hasStar(entry)) {
                    // Checks row position throughout the array moving up and determines star position
                    if (hasSpaceUp(row) && hasStar(grid[row - 1][col])) {
                        isValid = false;
                        errorCode = ERROR_CODE_VERTICAL_CONTACT;
                    }
                    // Checks row position throughout the array moving down and determines star position
                    if (hasSpaceBelow(grid, row) && hasStar(grid[row + 1][col])) {
                        isValid = false;
                        errorCode = ERROR_CODE_VERTICAL_CONTACT;
                    }

                }

                //***
                //*** Write code to check the constraint that there cannot be direct
                //***     contact between two stars in the four diagonal directions.
                //***
                //*** If this constraint is violated, then set the variable
                //***     "errorCode" to ERROR_CODE_DIAGONAL_CONTACT
                //*** SOLVED


                // If else statement for searching star positions diagonally.
                // Functions used are the same except we will use all four to determine positions
                if (hasStar(entry)) {
                    // Up to the left
                    if (hasSpaceUp(row) && hasSpaceToLeft(col) && hasStar(grid[row - 1][col - 1])) {
                        isValid = false;
                        errorCode = ERROR_CODE_DIAGONAL_CONTACT;
                    }
                    // UP to the right
                    else if (hasSpaceUp(row) && hasSpaceToRight(grid, row, col) && hasStar(grid[row - 1][col + 1])) {
                        isValid = false;
                        errorCode = ERROR_CODE_DIAGONAL_CONTACT;
                    }
                    //Down to the right
                    else if (hasSpaceBelow(grid, row) && hasSpaceToRight(grid, row, col) && hasStar(grid[row + 1][col + 1])) {
                        isValid = false;
                        errorCode = ERROR_CODE_DIAGONAL_CONTACT;

                    }
                    //Down to the left
                    else if (hasSpaceBelow(grid, row) && hasSpaceToLeft(col) && hasStar(grid[row + 1][col - 1])) {
                        isValid = false;
                        errorCode = ERROR_CODE_DIAGONAL_CONTACT;

                    }
                }

                // Accumulates the count of stars by cage and stores the numbers
                //     in the cageCount array to be processed outside this loop.
                if (grid[row][col][CHAR_POS] == STAR){
                    cageCount[grid[row][col][CAGE_POS] - ASCII_NUM_INDEX]++;
                }

                col++;


            }

            col = 0;
            row++;
        }

        // A valid solution must have exactly variable "stars" number of stars per cage.
        // Spins through the cageCount array and determines if each cage contains the
        //     correct number of stars.
        // If is does not contain the correct number of stars, then variable "errorCode"
        //     is set to the correct error code based upon the error code constants.
        if (isValid) {
            for (int i = 0; i < cageCount.length; i++) {
                if (cageCount[i] != stars) {
                    isValid = false;
                    errorCode = ERROR_CODE_INCORRECT_CAGE_COUNT;
                }
            }
        }

        return errorCode;
    }

    // Returns array of star positions
    private static boolean hasStar(char[] entry) {
        return entry[CHAR_POS] == STAR;
    }

    // Function to assist checking is there a multitude of starts within grid.
    private static boolean violatesNumberofStars(char[][] toTest, int maxStars) {
        // Counter for stars
        int rowStars = 0;
        // step through each char[] and count stars
        for (char[] c : toTest) {
            if (hasStar(c)) {
                rowStars++;
            }
        }
        // Return rowstars if greater than max stars
        return rowStars > maxStars;
    }

    // Function for returning the columns within the grid for processing.
    // Reduces having to pass multiple for loops throughout the program.
    public static char[][] getColumn(char[][][] grid, int index) {
        // Create array to contain columns within grid starting at index 0
        char[][] column = new char[grid[0].length][grid[0][0].length];
        // For columns in grid add columns to new column array for processing outside this method
        for (int i = 0; i < column.length; i++) {
            column[i] = grid[i][index];
        }
        return column;
    }

    // These functions were added to eliminate continued hard coding and or unneeded repetition

    // Function to determine if there is space right to the respective array position through rows
    private static boolean hasSpaceToRight(char[][][] grid, int row, int col) {
        return col + 1 < grid[row].length;
    }

    // Determine if there is space left to the respective array position through rows
    private static boolean hasSpaceToLeft(int row) {
        return row != 0;
    }

    // Determine if there is space above the respective array position through columns
    private static boolean hasSpaceUp(int col) {
        return col != 0;
    }

    // Determine if there is space below the respective array position through columns
    private static boolean hasSpaceBelow(char[][][] grid, int col) {
        char[][] column1 = getColumn(grid, col);
        return col + 1 < column1.length;
    }
}