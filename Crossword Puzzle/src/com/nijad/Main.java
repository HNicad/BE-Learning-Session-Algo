package com.nijad;

import javafx.util.Pair;

import java.util.*;

public class Main {
    static private final int SIZE = 10;
    static private ArrayList< ArrayList<String> > wordsByLength = new ArrayList<>();
    static private HashMap<String,Boolean> isUsed = new HashMap<>();
    static private boolean hasX = false;
    static char[][] getCopyOfCrossword(char[][] crossword){
        char[][] copy = new char[SIZE][SIZE];
        for(int i = 0; i < SIZE; i++){
            for(int j = 0; j < SIZE; j++){
                copy[i][j] = crossword[i][j];
            }
        }
        return copy;
    }
    static void printCrossword(char[][] crossword){
        for(int i = 0; i < SIZE; i++){
            for(int j = 0; j < SIZE; j++){
                char ch = crossword[i][j];
                if(ch == '+' && hasX){
                    ch = 'X';
                }
                System.out.print(ch);
            }
            System.out.println();
        }
    }
    // gets the starting and ending position in column 'j' where we can insert word
    static Pair<Integer,Integer> getColumn(char[][] crossword,int i, int j){
        int up = i;
        int down = i;
        while((crossword[up][j] == '-' || Character.isAlphabetic(crossword[up][j])) && up > 0){
            up--;
        }
        if( !(crossword[up][j] == '-') && !(Character.isAlphabetic(crossword[up][j])) ){
            ++up;
        }
        while( (crossword[down][j] == '-' || Character.isAlphabetic(crossword[down][j])) && down + 1 < SIZE ){
            ++down;
        }
        if( !(crossword[down][j] == '-') && !(Character.isAlphabetic(crossword[down][j])) ){
            --down;
        }
        return new Pair<>(up,down);
    }
    // gets the starting and ending position in row 'i' where we can insert word
    static Pair<Integer,Integer> getRow(char[][] crossword,int i, int j){
        int left = j;
        int right = j;
        while( (crossword[i][left] == '-' || Character.isAlphabetic(crossword[i][left])) && left > 0 ){
            left--;
        }

        if( !(crossword[i][left] == '-') && !(Character.isAlphabetic(crossword[i][left])) ){
            ++left;
        }

        while( (crossword[i][right] == '-' || Character.isAlphabetic(crossword[i][right])) && right + 1 < SIZE ){
            ++right;
        }

        if(!(crossword[i][right] == '-') && !(Character.isAlphabetic(crossword[i][right])) ){
            --right;
        }
        return new Pair<>(left,right);

    }
    // if we can insert the word to given position 'p', in column 'j', it inserts the word and returns true
    // otherwise it returns false and does nothing
    static boolean tryToInsertForColumn(char[][] crossword,Pair<Integer,Integer> p,String word,int j){
        for(int i = p.getKey(), k = 0; i <= p.getValue(); i++, k++){
            if( Character.isAlphabetic(crossword[i][j]) && crossword[i][j] != word.charAt(k)) {
                return false;
            }
        }
        for(int i = p.getKey(), k = 0; i <= p.getValue(); i++, k++){
            crossword[i][j] = word.charAt(k);
        }
        return true;
    }
    // if we can insert the word to given position 'p', in row 'i', it inserts the word and returns true
    // otherwise it returns false and does nothing
    static boolean tryToInsertForRow(char[][] crossword,Pair<Integer,Integer> p,String word,int i){
        for(int j = p.getKey(), k = 0; j <= p.getValue(); j++, k++){
            if( Character.isAlphabetic(crossword[i][j]) && crossword[i][j] != word.charAt(k)) {
                return false;
            }
        }
        for(int j = p.getKey(), k = 0; j <= p.getValue(); j++, k++){
            crossword[i][j] = word.charAt(k);
        }
        return true;
    }
    // removes the inserted word from column 'j' from the position 'p'
    static void rollBackColumn(char[][] crossword, Pair<Integer,Integer> p, int j){
        for(int i = p.getKey(); i <= p.getValue(); i++){
            boolean can = true;
            if(j > 0 && Character.isAlphabetic(crossword[i][j-1]) ){
                can = false;
            }
            if(j + 1 < SIZE &&  Character.isAlphabetic(crossword[i][j+1]) ){
                can = false;
            }
            if(can){
                crossword[i][j] = '-';
            }
        }
    }
    // removes the inserted word from row 'i' from the position 'p'
    static void rollBackRow(char[][] crossword, Pair<Integer,Integer> p, int i){
        for(int j = p.getKey(); j <= p.getValue(); j++){
            boolean can = true;
            if(i > 0 && Character.isAlphabetic(crossword[i-1][j]) ){
                can = false;
            }
            if(i + 1 < SIZE &&  Character.isAlphabetic(crossword[i+1][j]) ){
                can = false;
            }
            if(can){
                crossword[i][j] = '-';
            }
        }
    }

    static boolean dfs(char[][] crossword){
        boolean foundAnswer = true;
        for(int i = 0; i < SIZE; i++){
            for(int j = 0; j < SIZE; j++){
                if(crossword[i][j]=='-'){
                    Pair<Integer,Integer> p = getColumn(crossword,i,j);
                    foundAnswer = false;
                    {
                       int l = p.getValue() - p.getKey() + 1;
                       for(String k : wordsByLength.get(l)){
                           if(!isUsed.get(k) && tryToInsertForColumn(crossword,p,k,j)){
                               isUsed.put(k,true);
                               char[][] crosswordCopy = getCopyOfCrossword(crossword);
                               if(dfs(crosswordCopy)){
                                   return true;
                               }
                               rollBackColumn(crossword,p,j);
                               isUsed.put(k,false);
                           }
                       }
                    }
                    p = getRow(crossword,i,j);
                    {
                        int l = p.getValue() - p.getKey() + 1;
                        for(String k : wordsByLength.get(l)){
                            if(!isUsed.get(k) && tryToInsertForRow(crossword,p,k,i)){
                                isUsed.put(k,true);
                                char[][] crosswordCopy = getCopyOfCrossword(crossword);
                                if(dfs(crosswordCopy)){
                                    return true;
                                }
                                rollBackRow(crossword,p,i);
                                isUsed.put(k,false);
                            }
                        }

                    }

                }
            }
        }
        for(int i = 1; i < SIZE+1; i++ ){
            for(String k : wordsByLength.get(i)){
                if(!isUsed.get(k)){
                    return false;
                }
            }
        }
        if(foundAnswer){
            printCrossword(crossword);
        }
        return true;
    }

    static void convertToPlus(char[][] crossword){
        for(int i = 0; i < SIZE; i++){
            for(int j = 0; j < SIZE; j++){
                if(crossword[i][j] == 'X'){
                    hasX = true;
                    crossword[i][j] = '+';
                }
            }
        }
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char[][] crossword = new char[SIZE][SIZE];
        for(int i = 0; i < SIZE; i++){
            String s = scanner.nextLine();
            for(int j = 0; j < SIZE; j++){
                crossword[i][j] = s.charAt(j);
            }
        }

        for(int i = 0; i < SIZE + 1; i++){
            wordsByLength.add(new ArrayList<>());
        }

        String[] line = scanner.nextLine().split(";");

        for(int i = 0; i < line.length; i++){
            int length = line[i].length();
            isUsed.put(line[i],false);
            wordsByLength.get(length).add(line[i]);
        }
        convertToPlus(crossword);
        dfs(crossword);
    }
}
