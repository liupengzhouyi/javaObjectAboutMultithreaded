package 多线程;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * 1)	自定义一个类Demo，使其实现Runnable接口。
 * 2)	在Demo类中重写run()方法，在方法内编写一个for循环，循环体内打印：线程名称+循环次数。
 * 3)	编写测试类Example04，在Example04类的main()方法中，创建一个Demo对象，利用Thread的构造方法创建三个线程对象并命名，
 *      使用setPriority()方法将其中两个线程的优先级设为最大和最小，最后开启三个线程的start()方法。

 */
public class Domon04 {
    public static void main(String [] args) {

        Frame lpMainWindow = new Frame("练习四") ;
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
                Demo04 test = new Demo04(lpText);

                Thread test01 = new Thread(test, "min");
                test01.setPriority(Thread.MIN_PRIORITY);
                Thread test02 = new Thread(test, "------5");
                test02.setPriority(Thread.NORM_PRIORITY);
                Thread test03 = new Thread(test, "max");
                test03.setPriority(Thread.MAX_PRIORITY);

                test01.start();
                test02.start();
                test03.start();

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

        lpButtonOfOut.addMouseListener(new MouseListener() {
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



class Demo04 implements Runnable{

    private TextArea lpTempArea;


    public Demo04(TextArea tempText) {
        this.lpTempArea = tempText;
    }

    @Override
    public void run() {
        while(true) {
            String lpString = new String(Thread.currentThread() + "正在运行Domon方法！" + '\n');
            lpTempArea.append(lpString);
        }
    }
}