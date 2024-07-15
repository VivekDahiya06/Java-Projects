package Java_Projects.Brick_Breaker_Game;
import javax.swing.*;
public class Start {
    Start(){
        JFrame f=new JFrame("Brick Breaker Game");
        Game_Play gp=new Game_Play();
        f.setSize(707,600);
        f.setLocationRelativeTo(null);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setResizable(false);
        f.setVisible(true);
        f.add(gp);
    }
    public static void main(String[] args) {
        new Start();
    }
}