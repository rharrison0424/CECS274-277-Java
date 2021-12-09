
public class Triangle {
	
	public static int pascalTriangle(int row, int col) {
		
		if (row==0) {
			return 1;
		}
		if (row==col) {
			return pascalTriangle(row-1,col-1);
			
		}
		if(col==1) {
			return pascalTriangle(row-1,col);
		}
		else {
			return pascalTriangle(row-1,col-1) + pascalTriangle(row-1,col);
		}
	}

	public static void main(String[] args) {
		int x=pascalTriangle(3,2);
		System.out.println(x);
		

	}

}
