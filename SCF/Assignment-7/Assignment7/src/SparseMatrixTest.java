import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class SparseMatrixTest 
{
	SparseMatrix sparseMatrix1;
	SparseMatrix sparseMatrix2;
	
	@Before
	public void init()
	{
		int [][]matrix1= {{0,2,0,0},
				  		  {1,0,0,0},
				  		  {3,0,0,0},
				  		  {0,0,0,1}};

		sparseMatrix1=new SparseMatrix(matrix1);

		int [][]matrix2= {{0,9,0,0},
		 		  		  {9,0,0,0},
		 		  		  {0,0,0,0},
		 		  		  {0,0,0,0}};

		sparseMatrix2=new SparseMatrix(matrix2);
		
	}
	
	@Test (expected = AssertionError.class)
	public void Test()
	{
		int [][]matrix3= {};
		SparseMatrix sparseMatrix3= new SparseMatrix(matrix3);
		fail("Matrix is Empty.");
	}
	
	@Test
	public void getTransposeTest1()
	{
		
		int result[][]=sparseMatrix1.transpose();
		int [][]transpose={{0,1,3,0},
							{2,0,0,0},
							{0,0,0,0},
							{0,0,0,1}};
		
		assertArrayEquals(transpose,result);
	}
	
	@Test
	public void addTest1()
	{
		int [][]result=sparseMatrix1.add(sparseMatrix2);
		int [][]expected={{0,11,0,0}, 
						  {10,0,0,0}, 
						  {3,0,0,0},
						  {0,0,0,1}};
		
		assertArrayEquals(expected,result);
	}
	
	@Test
	public void multiplyTest1()
	{
		
		int [][]result=sparseMatrix1.multiply(sparseMatrix2);
		int [][]expected={{18,0,0,0}, 
						  {0,9,0,0}, 
						  {0,27,0,0}, 
						  {0,0,0,0}};
		
		assertArrayEquals(expected,result);
	}
	
	
	@Test
	public void isSymmetricTest1()
	{
		boolean result= sparseMatrix1.checkSymmetricalMatrix();
		assertEquals(false,result);
	}
	
	@Test
	public void isSymmetricTest2()
	{
		boolean result= sparseMatrix2.checkSymmetricalMatrix();
		assertEquals(true,result);
	}
}
