
public class TestClass {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		try{
			SVector v1 = new SVector();
			SVector v2 = new SVector(3);
			
			for(int i = 0; i < 3; i++){
				String str = new String();
				str.valueOf(i);
				v1.add(str);
//				v2.add(new Integer(i));
			}
			v1.show();
			v2.show();
		}
//		catch(Exception e){
//			System.out.println("Exeption!");
//		}
		
	}

//}
