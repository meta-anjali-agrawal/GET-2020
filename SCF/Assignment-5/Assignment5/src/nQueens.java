/**
 * @author Anjali
 * This class implements N Queens problem using recursion.
 * The N Queen is the problem of placing N chess queens on an N×N chessboard so that no two queens attack each other.
 */
public class nQueens
{
	int[][] chessBoard;
	int N;
	
	/**
	 * This method is to check whether placing a queen at this position is safe or not
	 * @param board , entries in the board
	 * @param row, integer type input
	 * @param column, integer type input
	 * @param dimensionOfChessBoard, integer type input 
	 * @return 
	 */
	public boolean isSafe(int[][] board,int row,int column,int dimensionOfChessBoard)
    {
        chessBoard=board;
        for(int i=0;i<row;i++)
        {
            if(chessBoard[i][column]==1)
            {
                return false;
            }
        }
        for(int i=row,j=column;i>=0&&j>=0;i--,j--) 
        {
            if(chessBoard[i][j]==1)
            {
                return false;
            }
        }
        for(int i=row,j=column;i>=0&&j<dimensionOfChessBoard;i--,j++) 
        {
            if(chessBoard[i][j]==1) 
            {
                return false;
            }
        }
        return true;
    }
	
	/**
	 * The N Queen is the problem of placing N chess queens on an N×N chessboard so that no two queens attack each other.
	 * @param board, entries in the board
	 * @param startRow, integer type input
	 * @param dimensionOfChessBoard, integer type input
	 * @return
	 */
	public boolean nOueen(int[][] board,int startRow,int dimensionOfChessBoard)
	   {
	       chessBoard=board;
	       if(startRow>=dimensionOfChessBoard)
	       {
	           return true;
	       }
	       for(int i=0;i<dimensionOfChessBoard;i++)
	       {
	    	   if(isSafe(chessBoard,startRow,i,dimensionOfChessBoard))
	           {
	               chessBoard[startRow][i]=1;
	               if(nOueen(chessBoard,startRow+1,dimensionOfChessBoard))
	               {
	                   return true;
	               }
	               chessBoard[startRow][i]=0;
	           }
	       }
	       return false;
	   }
	
	/**
	 * To print entry of chesscoard
	 */
	void print()
    {
		int dimensionOfChessBoard = chessBoard.length;
        System.out.println(chessBoard.length);
        for(int j=0;j<dimensionOfChessBoard;j++)
        {
            for(int i=0;i<dimensionOfChessBoard;i++)
            {
                System.out.print(chessBoard[i][j]+"  ");
            }
            System.out.println();
        }
    }
	
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		/*nQueens nq = new nQueens();
		int[][] board = new int[][]{{0,0,0,0},{0,0,0,0},{0,0,0,0},{0,0,0,0}};
		Boolean result = nq.nOueen(board, 0, 4);
		System.out.println(result);		
		nq.print();*/

	}

}
