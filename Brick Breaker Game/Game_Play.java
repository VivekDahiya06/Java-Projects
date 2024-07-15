package Java_Projects.Brick_Breaker_Game;
import javax.swing.*;
import javax.swing.Timer;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;
public class Game_Play extends JPanel{
    private boolean play=false;
    private int score=0;
    private int totalBricks=21;
    private int playerX=350;
    private int ballposX=120;
    private int ballposY=350;
    private int ballXdir=-1;
    private int ballYdir=-3;
    private Map_generator mg;
    Game_Play(){
        final Timer timer;
        final int delay = 8;
        KeyListener ky=new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }
            @Override
            public void keyPressed(KeyEvent e) {
                if(e.getKeyCode()==KeyEvent.VK_LEFT){
                    if(playerX<=3){
                        playerX=7;
                    }
                    else
                        moveLeft();
                }
                if(e.getKeyCode()==KeyEvent.VK_RIGHT){
                    if(playerX>=590){
                        playerX=586;
                    }
                    else
                        moveRight();
                }
                if(e.getKeyCode()==KeyEvent.VK_ENTER){
                    if(!play) {
                        Random ran=new Random();
                        score=0;
                        totalBricks=21;
                        ballposX=120;
                        ballposY=350;
                        playerX=350;
                        ballXdir=ran.nextInt(-5,-1);
                        ballYdir=ran.nextInt(-5,-1);
                        mg=new Map_generator(3,7);
                    }
                }
                repaint();
            }
            @Override
            public void keyReleased(KeyEvent e) {

            }
        };
        ActionListener ab=new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(play){
                    if(ballposX<=0)
                        ballXdir=-ballXdir;
                    if(ballposY<=0)
                        ballYdir=-ballYdir;
                    if(ballposX>=675)
                        ballXdir=-ballXdir;
                    Rectangle ballrect=new Rectangle(ballposX,ballposY,18,18); //used to check if the ball is hitting any object by forming a rectangle around the ball
                    Rectangle padrect=new Rectangle(playerX,550,100,8); //used to check if the paddle is hitted by the ball by forming a rectangle around the paddle
                    Rectangle brickRect;
                    A :for(int i=0;i<mg.map.length;i++){
                        for(int j=0;j<mg.map[0].length;j++){
                            if(mg.map[i][j]>0){
                                int brickXpos=j*mg.brickWidth+80;
                                int brickYpos=i*mg.brickHeight+50;
                                int brickWidth=mg.brickWidth;
                                int brickHeight=mg.brickHeight;
                                brickRect=new Rectangle(brickXpos,brickYpos,brickWidth,brickHeight); //Rectangle is made around every brick to check if it is hit by the ball
                                if(ballrect.intersects(brickRect)){
                                    mg.setBrick(0,i,j); //if the value of brick is zero then it is removed from the frame for each changing loop
                                    totalBricks--;//used to track if you have won the game
                                    score+=5;
                                    if(ballposX+19<=brickXpos || ballposX+1>=brickXpos) { //Condition to check if the ball hitts the left or right side of the bricks
                                        ballXdir = -ballXdir;
                                    }
                                    else{
                                        ballYdir=-ballYdir;
                                    }
                                    break A;
                                }
                            }
                        }
                    }
                    if(ballrect.intersects(padrect)){
                        ballYdir=-ballYdir;
                    }
                    ballposX+=ballXdir;
                    ballposY+=ballYdir;
                }

                repaint();
            }
        };
        addKeyListener(ky);
        setFocusable(true);
        setFocusTraversalKeysEnabled(true);
        timer=new Timer(delay,ab);
        mg=new Map_generator(3,7);
        timer.start();
    }
    public void paint(Graphics g) {
        //black Canavas
        g.setColor(Color.black);
        g.fillRect(1, 1, 692, 592);
        //border
        g.setColor(Color.yellow);
        g.fillRect(0, 0, 692, 3);
        g.fillRect(0, 3, 3, 592);
        g.fillRect(691, 3, 4, 592);
        //paddle
        g.setColor(Color.green);
        g.fillRect(playerX,550,100,8);
        //bricks
        mg.draw((Graphics2D) g);
        //ball
        g.setColor(Color.RED);
        g.fillOval(ballposX,ballposY,18,18);
        //Score
        g.setColor(Color.white);
        g.setFont(new Font("serif",Font.BOLD,20));
        g.drawString("Score : "+score,570,28);
        //Game Over
        if(ballposY>570) {
            play = false;
            g.setColor(Color.BLUE);
            g.setFont(new Font("serif", Font.BOLD, 30));
            g.drawString("Game Over", 270, 230);
            g.drawString("Score : " + score, 285, 260);
            g.drawString("Press Enter to Restart !!!", 190, 290);
        }
        //Game Won
        if(totalBricks==0){
            play = false;
            g.setColor(Color.BLUE);
            g.setFont(new Font("serif", Font.BOLD, 30));
            g.drawString("You Won !!!", 270, 230);
            g.drawString("Score : " + score, 285, 260);
            g.drawString("Press Enter to Restart !!!", 190, 290);
        }
    }
    public void moveRight(){
        play=true;
        playerX+=20;
    }
    public void moveLeft(){
        play=true;
        playerX-=20;
    }
}