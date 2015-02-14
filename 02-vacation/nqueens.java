import java.io.*;
import java.util.*;

public class nqueens {

    private char[][] board;
    private int side, maxX, maxY;
    private char taken = '.';
    private char space = 'x';
    private char queen = 'Q';

    public void delay(int n){
	try {
	    Thread.sleep(n);
	} catch (Exception e) {}
    }

    public nqueens(int a) {
	side = a;
	maxX = side;
	maxY = side;
	board = new char[maxX][maxY];
	filler();
    }

    public void filler() {
	for(int a=0;a<maxX;a++){
	    for(int b=0;b<maxY;b++)
		board[a][b] = space;
	}
    }

    public String toString(){
	String s = "[2J\n";
	s+="+";
	for (int y=0;y<2*maxY+1;y++){s += "-";}
	s+="+ \n";
	for (int y=0;y<maxY;y++){
	    s+="| ";
	    for (int x=0;x<maxX;x++){s = s +board[x][y] + " ";}
	    s=s+"| \n";}
	s+="+";
        for (int y=0;y<2*maxY+1;y++){s += "-";}
        s+="+ \n";
	return s;
    }

    public boolean checker(){
	for(int a=0;a<side;a++){
	    for(int b=0;b<side;b++){
		if (board[a][b] == space){return true;}
	    }
	}
	return false;
    }

    public void taker(int spX, int spY){
	for(int a=0; a<side;a++){
	    if (board[spX][a] != queen){board[spX][a] = taken; }
	    if (board[a][spY] != queen){board[a][spY] = taken;}
	}
       	for(int r=0; r<side;r++){
	    for(int s=0; s<side;s++){
		if((spX-r) == (spY-s)){board[r][s]=taken;}
		if((spX-r) == (s-spY)){board[r][s]=taken;}
		board[spX][spY]=queen;}
	    }
    }

    public void solve(){
	//PLOTS A QUEEN ---------------
	Random r = new Random();
	int spotX = r.nextInt(side);
        int spotY = r.nextInt(side);
	if (board[spotX][spotY] == space){board[spotX][spotY] = queen;
	//FINDS IMPOSSIBLE PLACES -----
	    taker(spotX,spotY);	
	    System.out.println(this);
	    delay(100);
	}
	if (checker() == true){solve();}
    }

    public static void main(String[] args){
	nqueens q = new nqueens(20);
	System.out.println(q);
	q.solve();
	System.out.println(q);
    }
}
