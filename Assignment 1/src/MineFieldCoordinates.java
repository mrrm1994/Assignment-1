
public class MineFieldCoordinates {
	private int x;
	private int y;
	
	public MineFieldCoordinates(int xCord, int yCord){
		this.x = xCord;
		this.y = yCord;		
	}
	public void setXCord(int xCord){
		
	}
	public void setYCord(int yCord){
		
	}
    public int getXCord(){
    	return x;
   }
    public int getYCord(){
    	return y;
    }
    public String string(){
    	return "(" +  getXCord() + "," + getYCord() + ")";
    }
}
