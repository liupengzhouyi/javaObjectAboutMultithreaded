package 多线程;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/*
 *1)	自定义一个类Demo，使其继承Thread类。
 *2)	在Demo类中重写run()方法，在run()方法内编写一个for循环，循环体内打印：“Demo：”+当前循环次数。
 *3)	编写测试类Example01，在Example01类的main()方法中，创建一个Demo对象，并执行其   start()方法，接着编写一个for循环，循环体内打印：“main：”+当前循环次数。

 */
public class Domon  {
    public static void main(String [] args) {

        Frame lpMainWindow = new Frame("练习一") ;
        lpMainWindow.setSize(800,500);
        lpMainWindow.addWindowListener(new newWindowL());
        lpMainWindow.addMouseListener(new newMonseL());

        Panel lpPanelForButton = new Panel();

        lpMainWindow.setLayout(new BorderLayout());

        TextArea lpText = new TextArea(750,450);

        lpMainWindow.add(lpText, BorderLayout.CENTER);

        Button lpButtonOfOK = new Button("OK");
        Button lpButtonOfOut = new Button("Out") ;

        lpPanelForButton.setLayout(new FlowLayout());
        lpPanelForButton.add(lpButtonOfOut);
        lpPanelForButton.add(lpButtonOfOK);

        lpButtonOfOK.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {

                Demo lp_01 = new Demo();
                lp_01.run(lpText);

                 for (int i = 0; i < 109999; i++) {
                     lpText.append("Main: 正在执行第" + i + "次！" + '\n');
                 }
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });

        lpButtonOfOut.addMouseListener(new MouseListener()  {
            @Override
            public void mouseClicked(MouseEvent e) {
                Window tempWindow = lpMainWindow;
                tempWindow.setVisible(false);
                tempWindow.dispose();
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });


        lpMainWindow.add(lpPanelForButton, BorderLayout.SOUTH);
        lpMainWindow.setVisible(true);



    }
}

class Demo extends Thread{

    public void run(TextArea whichTextArea) {
        // super.run();
        for (int i = 0; i < 109999; i++) {
            whichTextArea.append("Domo: 正在执行第" + i + "次！" + '\n');
        }
    }
}