import java.io.*; 
import java.util.*; 
public class MyClass
{
	public static int[][] moves = new int[][]{
		{0,1,3},
		{3,1,0},//1-1
		{0,2,5},//3-2
		{5,2,0},
		{1,3,6},
		{6,3,1},//4-5
		{1,4,8},//9-6
		{8,4,1},
		{2,4,7},
		{7,4,2},
		{3,4,5},
		{5,4,3},//2-11
		{2,5,9},//8-12
		{9,5,2},//5-13
		{3,6,10},
		{10,6,3},
		{3,7,12},
		{12,7,3},
		{4,7,11},
		{11,7,4},//6-19
		{6,7,8},
		{8,7,6},
		{4,8,13},
		{13,8,4},
		{5,8,12},//11-24
		{12,8,5},//7-25
		{7,8,9},
		{9,8,7},
		{5,9,14},
		{14,9,5},//10-29
		{10,11,12},//13-30
		{12,11,10},
		{11,12,13},
		{13,12,11},//12-33
		{12,13,14},
		{14,13,12}
	};
	public static ArrayList<Integer> sol = new ArrayList<Integer>(); 
	public static int[] board = new int[15];
	public static void main(String[] args)
	{
		for(int i=0;i<5;i++)
		{
			System.out.println("----------"+i+"-----------");
			for(int l=0;l<MyClass.board.length;l++)
			{
				MyClass.board[l] = 1;
			}
			// for the beginning peghole to empty
			MyClass.board[i] = 0;
			int[] cboard = new int[15];
			for(int n=0;n<MyClass.board.length;n++){cboard[n]=board[n];}
			MyClass.sol = solve(cboard,14);
			repl(MyClass.board,MyClass.sol);
		}
	}
	public static ArrayList<Integer> solve(int[] board, int numoc)
	{
		int[] cboard = new int[15];
		for(int n=0;n<board.length;n++){cboard[n]=board[n];}
		ArrayList<Integer> step = new ArrayList<Integer>();
		int ocu=0;
		for(int num:cboard)
		{
			if(num==1){ocu++;}
		}
		if(ocu==1)
		{	
			step.add(100);
			return step;
		}
		ArrayList<Integer> tmp = new ArrayList<Integer>(); 
		int k=0;
		for(int[] x:moves)
		{
			if(cboard[x[0]]==1 && cboard[x[1]] == 1 && cboard[x[2]] == 0)// if move is possible
			{
				cboard[x[0]] = 0;
				cboard[x[1]] = 0;
				cboard[x[2]] = 1;
				step.add(k);
				tmp = solve(cboard,(numoc-1));//try next move
				if(tmp.isEmpty())// if no solution restart board and try next move
				{	
					if(step.size()>=1){step.remove((step.size()-1));}
					cboard[x[0]] = 1;
					cboard[x[1]] = 1;
					cboard[x[2]] = 0;
				}
				else//add steps to previous and return them
				{
					if(tmp.size()>=1 && tmp.get(tmp.size()-1)==100){tmp.remove((tmp.size()-1));}
					for(int d=0;d<tmp.size();d++){step.add(tmp.get(d));}
					tmp.clear();
					return step;
				}

			}
			k++;
		}
		step.clear();
		return step;
	}
	public static void repl(int[] bar, ArrayList<Integer> st)
	{
		int F,O,T;
		display(bar);
		for(int num:st)
		{
			F = moves[num][0];
			O = moves[num][1];
			T = moves[num][2];
			bar[F] = 0;
			bar[O] = 0;
			bar[T] = 1;
			System.out.println("F"+F+" O"+O+" T"+T);
			display(bar);

		}
	}
	public static void display(int[] bard)
	{
		System.out.println("     "+bard[0]);
		System.out.println("    "+bard[1]+" "+bard[2]);
		System.out.println("   "+bard[3]+" "+bard[4]+" "+bard[5]);
		System.out.println("  "+bard[6]+" "+bard[7]+" "+bard[8]+" "+bard[9]);
		System.out.println(" "+bard[10]+" "+bard[11]+" "+bard[12]+" "+bard[13]+" "+bard[14]);
	}
} 