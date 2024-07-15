package Java_Projects.Brick_Breaker_Game;
import java.awt.*;
public class Map_generator {
    public int[][] map;
    public int brickWidth;
    public int brickHeight;
    Map_generator(int row,int col){
        map=new int[row][col];
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                map[i][j]=1;
            }
        }
        brickWidth=540/col;
        brickHeight=150/row;
    }
    public void setBrick(int value,int row,int col){
        map[row][col]=value;
    }
    public void draw(Graphics2D g){
        for(int i=0;i< map.length;i++){
            for(int j=0;j< map[0].length;j++){
                if(map[i][j]>0){
                    g.setColor(Color.gray);
                    g.fillRect(j*brickWidth+80,i*brickHeight+50,brickWidth,brickHeight);
                    //border of bricks
                    g.setColor(Color.black);
                    g.setStroke(new BasicStroke(5));
                    g.drawRect(j*brickWidth+80,i*brickHeight+50,brickWidth,brickHeight);
                }
            }
        }
    }
}