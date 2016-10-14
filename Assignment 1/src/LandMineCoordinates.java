import java.util.Random;

public class LandMineCoordinates {
	private MineFieldCoordinates[] landMineCoordinates;
	
	public MineFieldCoordinates[] getLandMineCoordinates(){
		return landMineCoordinates;
	}
	public LandMineCoordinates(int length){
		landMineCoordinates = new MineFieldCoordinates[length];
	}
   private MineFieldCoordinates coordinates(){
	   Random r = new Random();
	   return new MineFieldCoordinates(r.nextInt(9), r.nextInt(9));
   }
   public void fillWithLandMines(){
	   for(int i = 0; i< landMineCoordinates.length; i++){
		   landMineCoordinates[i] = coordinates();
	   }
   }
   public boolean verifyCoordinates(int x,int y, MineFieldCoordinates z){
	   return x == z.getXCord() && x == z.getYCord();
   }
   public boolean verifyClick(int x, int y){
	   for(int i=0; i<landMineCoordinates.length; i++){
		   if(verifyCoordinates(x,y,landMineCoordinates[i])){
			   return true;
		   }
	   }
	   return false;
   }
   public boolean landMinesAround(int x, int y){
	   if(verifyClick(x-1,y-1) || verifyClick(x+1,y+1) || verifyClick(x+1,y-1) || verifyClick(x+1,y) || verifyClick(x,y+1)|| verifyClick(x-1,y) || verifyClick(x,y-1) || verifyClick(x-1,y+1))
	   {
		   return true;
	   }
	   else return false;
   }
   public int landMineCounter(int x, int y){
	   int counter = 0;
	   for(int i= x-1; i<=x+1; i++){
		   for(int i2 = y-1; i2 <=y+1; i2++){
			   if(!(i == x && i2 ==y)){
				   if(verifyClick(i,i2))
					   counter++;
			   }
		   }
	   }
	   return counter;
   }
}
