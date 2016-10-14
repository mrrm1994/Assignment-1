import java.util.Random;

public class CoordenadasDeBombas {
	private CoordenadasDeGrid[] CoordenadasDeBombas;
	
	public CoordenadasDeGrid[] getCoordenadasDeBombas(){
		return CoordenadasDeBombas;
	}
	public CoordenadasDeBombas(int length){
		CoordenadasDeBombas = new CoordenadasDeGrid[length];
	}
   private CoordenadasDeGrid Coordenadas(){
	   Random r = new Random();
	   return new CoordenadasDeGrid(r.nextInt(9), r.nextInt(9));
   }
   public void LlenarConBombas(){
	   for(int i = 0; i< CoordenadasDeBombas.length; i++){
		   CoordenadasDeBombas[i] = Coordenadas();
	   }
   }
   public boolean VerificarCoordenadas(int x,int y, CoordenadasDeGrid z){
	   return x == z.getXCord() && x == z.getYCord();
   }
   public boolean VerificarClick(int x, int y){
	   for(int i=0; i<CoordenadasDeBombas.length; i++){
		   if(VerificarCoordenadas(x,y,CoordenadasDeBombas[i])){
			   return true;
		   }
	   }
	   return false;
   }
   public boolean BombasAlrededor(int x, int y){
	   if(VerificarClick(x-1,y-1) || VerificarClick(x+1,y+1) || VerificarClick(x+1,y-1) || VerificarClick(x+1,y) || VerificarClick(x,y+1)|| VerificarClick(x-1,y) || VerificarClick(x,y-1) || VerificarClick(x-1,y+1))
	   {
		   return true;
	   }
	   else return false;
   }
   public int ContadorDeMinas(int x, int y){
	   int counter = 0;
	   for(int i= x-1; i<=x+1; i++){
		   for(int i2 = y-1; i2 <=y+1; i2++){
			   if(!(i == x && i2 ==y)){
				   if(VerificarClick(i,i2))
					   counter++;
			   }
		   }
	   }
	   return counter;
   }
}
