/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package firstapplet;
import java.applet.Applet;
import java.awt.*;
import java.awt.event.*;

/**
 *
 * @author STT2
 */
public class FirstApplet extends Applet implements KeyListener{
        int nrIncercari,nrIntrodus,nrGenerat;
        Label l1=new Label();
        Label l2=new Label();
        Label l3=new Label();
        TextField intrare = new TextField();
        Button restart = new Button("Restart");
        public void keyTyped(KeyEvent evt) { };
    public void init(){
        setSize(300,370);    
        setLayout(new GridLayout(10,1));
        setBackground(Color.BLUE);
        l1.setBackground(new Color(255,255,0));//codul pt yellow
        l1.setForeground(Color.RED);
        Font f1 = new Font("Verdana",Font.PLAIN,30);
        Font f2 = new Font("Verdana",Font.PLAIN,20);
        l2.setBackground(Color.BLACK);
        l2.setForeground(Color.YELLOW);
        l3.setForeground(Color.YELLOW);
        intrare.setFont(f1);
        l1.setFont(f2);
        add(l1);
        add(intrare);
        add(l2);
        add(l3);
        add(restart);
        restart.addActionListener(e->{start();});
        intrare.addActionListener(e->{checkNumber();});
        intrare.addKeyListener(new KeyAdapter(){
                public void keyTyped(KeyEvent evt) {
            char c = evt.getKeyChar();
            if(!(c>='0'&&c<='9') && !(c==(char)(10)))//// car de enter
                evt.consume();            
            } 
        });
    }
        public void keyPressed(KeyEvent e)   {   }
        public void keyReleased(KeyEvent e)  {   }

        public void start(){
            l1.setText("Introduceti un numar intre 1 si 20");
            intrare.setEnabled(true);
            intrare.setText("");
            l2.setText("");
            l3.setText("Mai aveti 5 incercari");
            nrIncercari=5;
            nrGenerat=(int)(Math.random()*20+1);
            System.out.println(nrGenerat);
        }
        public void checkNumber(){
            try{
                    nrIntrodus=Integer.parseInt(intrare.getText());
            }
            catch(NumberFormatException error){
                l2.setText("Nu ati introdus un numar !");
                nrIncercari--;
                if(nrIncercari>0){
                l3.setText("Mai aveti " + nrIncercari+" incercari");
                
                }
                else{
                    intrare.setEnabled(false);
                    restart.setEnabled(true);
                    l2.setText("Aiurea, ai pierdut !");
                    l3.setText("Numarul era : "+nrGenerat);
                    repaint();
                }
                return;
            }
            
            if(nrIntrodus==nrGenerat){
                intrare.setEnabled(false);
                restart.setEnabled(true);
                l2.setText("Felicitari, ati castigat !");
                l3.setText("");
                repaint();
            }
            else{
                nrIncercari--;
                if(nrIncercari==0){
                    intrare.setEnabled(false);
                    restart.setEnabled(true);
                    l2.setText("Aiurea, ai pierdut !");
                    l3.setText("Numarul era : "+nrGenerat);
                    repaint();
                }
                else {
                    l3.setText("Mai aveti "+nrIncercari+" incercari");
                    if(nrIntrodus<nrGenerat)
                        l2.setText("Introduceti un numar mai mare");
                    else
                        l2.setText("Introduceti un numar mai mic");
                }
            }
        }
        public void paint(Graphics g){
            if(nrIntrodus==nrGenerat){
                
                g.setColor(Color.GREEN);
                g.drawString("YUHUUU",WIDTH,WIDTH);
                g.setColor(Color.RED);
                g.drawOval(120, 195, 60, 60);
                g.drawLine(130,210,140,210);
                g.drawLine(160,210,170,210);
                g.drawLine(130,210,140,210);
                g.drawArc(130, 205, 40, 40,225,90);
            }
            else
                if(nrIncercari==0){
                    g.setColor(Color.GREEN);
                g.drawString("YUHUUU",WIDTH,WIDTH);
                g.setColor(Color.RED);
                g.drawOval(120, 195, 60, 60);
                g.drawLine(130,210,140,210);
                g.drawLine(160,210,170,210);
                g.drawLine(150,210,150,230);
                
                g.drawArc(130, 240, 40, 40,45,90);
                }
        }
}
