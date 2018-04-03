package 多线程;

import jdk.nashorn.api.tree.ForInLoopTree;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/*
 *1)	自定义一个类Demo，使其实现Runnable接口。
 *2)	在Demo类中覆写run()方法，在方法编写一个for循环，循环体内打印：当前线程名称：+当前循环次数。
 *3)	编写测试类Example02，在Example02类的main()方法中，创建一个Demo对象，利用Thread（Runnable target）构造方法创建2个线程对象，
 *      分别命名为“蜘蛛侠”和“钢铁侠”，并执行线程对象的start()方法，同时编写for循环，循环内打印“main：”+当前循环次数。
 */
public class Domon02 {
    public static void main(String [] args) {

        Frame lpMainWindow = new Frame("练习二") ;
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

            }

            @Override
            public void mousePressed(MouseEvent e) {

                Demo02 test = new Demo02(lpText);
                Thread test02= new Thread(test, "钢铁侠");
                Thread test01 = new Thread(test, "蜘蛛侠");

                test01.start();
                test02.start();


                for (int i = 0; i < 10000; i++) {
                    String s = new String("Main 正在运行第" + i +"次方法！");
                    lpText.append(s + '\n');
                }
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

class Demo02 implements Runnable {
    private TextArea temp ;

    Demo02(TextArea temp) {
        this.temp = temp;
    }

    @Override
    public void run() {
        int i=0;
        while(true) {
            String lpStringFotOutput = (Thread.currentThread() + "正在运行+" + "第" + i++ + "次！");
            temp.append(lpStringFotOutput + '\n');
        }
    }
}
