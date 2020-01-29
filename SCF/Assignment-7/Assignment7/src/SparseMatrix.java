
/**
 * @author Anjali
 * An immutable class for representing two-dimensional sparse matrices.
 * For space efficiency storing only non zero elements of a matrix.
 */
final class SparseMatrix 
{
	final int[] row;
	final int[] column;
	final int[] value;
	final int size;

	/**
	 * Parameterized Constructor
	 * @param matrix, integer type 2D matrix
	 */
	SparseMatrix(int[][] matrix)
	{
		if(matrix.length == 0)
			throw new AssertionError("Matrix is Empty.");
		int countNonZero = 0;
		int k = 0;
		size = matrix.length;
		
		for(int i=0 ; i<size ; i++)
		{
			for(int j=0 ; j<size ; j++)
			{
				if(matrix[i][j]!=0)
					countNonZero++;
			}
		}
		
		this.row = new int[countNonZero];
		this.column = new int[countNonZero];
		this.value = new int[countNonZero];
		
		for(int i=0 ; i<size ; i++)
		{
			for(int j=0 ; j<size ; j++)
			{
				if(matrix[i][j]!=0)
				{
					this.row[k] = i;
					this.column[k] = j;
					this.value[k] = matrix[i][j];
					k++;
				}
			}
		}
	}
	
	/**
	 * Method return transpose of the matrix
	 * @return transpose of matrix
	 */
	public int[][] transpose()
	{
		int []transposeRows = this.column.clone();
		int []transposeCols = this.row.clone();
		
		if(transposeRows.length== 0 || transposeCols.length==0)
			return new int [][]{};
		
		int [][]transpose= new int[size][size];
		
		for(int i=0; i<this.row.length; i++)
		{
			transpose[transposeRows[i]][transposeCols[i]] = this.value[i];
		}
		
		return transpose;
	}
	
	/**
	 * Method to check whether it is a symmetrical matrix
	 * @return boolean value, if Symmetric then true, else false
	 */
	public boolean checkSymmetricalMatrix()
	{
		int[][] matrix = new int[size][size];
		for(int i=0 ; i<row.length ; i++)
		{
			matrix[row[i]][column[i]] = value[i];
 		}
		SparseMatrix matrix1 = new SparseMatrix(matrix);
		
		int[][] transposed = matrix1.transpose();
		
		for(int i=0; i<matrix.length; i++)
		{
			for(int j=0; j<matrix.length; j++)
			{
				if(matrix[i][j] != transposed[i][j])
					return false;
			}
		}
		return true;
	}
	
	/**
	 * Method to add two matrices
	 * @param sMatrix1, matrix which need to be added
	 * @return 2D matrix, after adding
	 */
	public int[][] add(SparseMatrix sMatrix1)
	{
		int [][] matrix1= new int[size][size];
		int [][] matrix2= new int[size][size];
		
		if(size==0)
			return new int[][]{};
		
		int sum[][]=new int[size][size];
		
		for(int i=0; i<this.row.length; i++)
		{
			matrix1[this.row[i]][this.column[i]]=this.value[i];
			
		}
		for(int i=0; i<sMatrix1.row.length; i++)
		{
			matrix2[sMatrix1.row[i]][sMatrix1.column[i]]=sMatrix1.value[i];
		}
		
		for(int i=0; i<size; i++)
		{
			for(int j=0; j<size; j++)
			{
				sum[i][j]=matrix1[i][j]+matrix2[i][j];
			}
		}
		return sum;
	}
	
	/**
	 * Method to multiply two matrices
	 * @param sMatrix1, matrix which need to be added
	 * @return 2D matrix, after multiplying
	 */
	public int[][] multiply(SparseMatrix sMatrix)
	{
		int [][] matrix1= new int[size][size];
		int [][] matrix2= new int[size][size];
		
		if(size==0)
			return new int[][]{};
		
		for(int i=0; i<this.row.length; i++)
		{
			matrix1[this.row[i]][this.column[i]]=this.value[i];
			
		}
		for(int i=0; i<sMatrix.row.length; i++)
		{
			matrix2[sMatrix.row[i]][sMatrix.column[i]] = sMatrix.value[i];
		}
		
		int [][]multipliedMatrix= new int[size][size];
		
		for(int i=0; i<size; i++)
		{
			for(int j=0; j<size; j++)
			{
				for(int k=0; k<size; k++)
				{
					multipliedMatrix[i][j] += matrix1[i][k]*matrix2[k][j];
				}
			}
		}
		return multipliedMatrix;
	}
 
	/**
	 * Method to print the nonZero values stored in the Matrix
	 */
	public void print()
	{
		System.out.println("Row" + "  " + "Column" + "  " + "Value");
		for(int i=0 ; i<row.length ; i++)
		{
			System.out.println(row[i] + "	" + column[i] + "	" + value[i]);
 		}
	}
	
	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		int [][]matrix1= {{0,2,0,0},
				  {1,0,0,0},
				  {3,0,0,0},
				  {0,0,0,1}};
		SparseMatrix sparseMatrix1 = new SparseMatrix(matrix1);
		
		int [][]matrix2= {{0,1,0,0},
		 		  {1,0,0,0},
		 		  {0,0,0,0},
		 		  {0,0,0,0}};

		SparseMatrix sparseMatrix2= new SparseMatrix(matrix2);
		
		int[][] resultTrans = sparseMatrix1.transpose();
		SparseMatrix resultTanspose = new SparseMatrix(resultTrans);
		System.out.println("TransPose : ");
		resultTanspose.print();
		System.out.println();
		
		boolean resultSymmetry=sparseMatrix1.checkSymmetricalMatrix();
		System.out.println(resultSymmetry);
		
		boolean resultSymmetry1=sparseMatrix2.checkSymmetricalMatrix();
		System.out.println(resultSymmetry1);
		
		System.out.println();
		int[][] sum=sparseMatrix1.add(sparseMatrix2);
		SparseMatrix resultSum = new SparseMatrix(sum);
		resultSum.print();
		
		System.out.println();
		int[][] multiply=sparseMatrix1.multiply(sparseMatrix2);
		SparseMatrix resultMultiply = new SparseMatrix(multiply);
		resultMultiply.print();
	}

}
