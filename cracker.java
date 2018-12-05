import java.io.*; 
import java.util.*; 
public class MyClass
{
	public static int[][] moves = new int[][]{
		{0,1,3},
		{0,2,5},
		{1,3,6},
		{1,4,8},
		{2,4,7},
		{3,4,5},
		{2,5,9},
		{3,6,10},
		{3,7,12},
		{4,7,11},
		{6,7,8},
		{4,8,13},
		{5,8,12},
		{7,8,9},
		{5,9,14},
		{10,11,12},
		{11,12,13},
		{12,13,14}
	};
	public static int[] board = new int[15];
	public static void main(String[] args)
	{
		for(int l=0;l<MyClass.board.length;l++)
		{
			MyClass.board[l] = 1;
		}
		// for the beginning peghole to empty
		MyClass.board[0] = 0;
		int[] cboard = new int[15];
		for(int n=0;n<MyClass.board.length;n++){cboard[n]=board[n];}
		display(solve(cboard,cboard,14));
		//display(board);
	}
	public static int[] solve(int[] ocu, int[] curboard, int numoc)
	{
		//display(ocu);
		int[] nuocu = new int[15];
		if(numoc ==1)
		{	System.out.println("output");
			for(int n=0;n<board.length;n++){board[n]=ocu[n];return ocu;}
		}
		for(int F=0;F<ocu.length;F++)
		{
			if(ocu[F]!=0)
			{
				for(int Ov=0;Ov<ocu.length;Ov++)
				{
					if(ocu[Ov]!=0 && Ov!=F)
					{
						for(int T=0;T<ocu.length;T++)
						{
							if(ocu[T]==0 && T!=F && T!=Ov)
							{
								//System.out.println("F"+F+"O"+Ov+"T"+T);
								for(int[] mov:MyClass.moves)
								{
									if(numoc ==2)
									{	System.out.println("output");
										return ocu;
									}
									else if(Ov==mov[1] && (F==mov[0] || F==mov[2]) && (T==mov[2] || T==mov[0]))
									{
										for(int n=0;n<ocu.length;n++){nuocu[n]=ocu[n];}
										nuocu[F]=0;
										nuocu[Ov]=0;
										nuocu[T]=1;
										//display(nuocu);
										System.out.println("F"+F+"O"+Ov+"T"+T+"numoc="+(numoc-1));
										solve(nuocu,ocu,numoc-1);
									}

								}
							}
						}
					}
				}
			}
		}
		return ocu;
	}
	public static void display(int[] bard)
	{
		System.out.println("    "+bard[0]);
		System.out.println("   "+bard[1]+" "+bard[2]);
		System.out.println("  "+bard[3]+" "+bard[4]+" "+bard[5]);
		System.out.println(" "+bard[6]+" "+bard[7]+" "+bard[8]+" "+bard[9]);
		System.out.println(""+bard[10]+" "+bard[11]+" "+bard[12]+" "+bard[13]+" "+bard[14]);
	}
} 