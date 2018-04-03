package 多线程;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * 1)	自定义一个类Watcher，使其实现Runnable接口。
   2)	在Watcher类中覆写run()方法，在方法内编写一个for循环，循环体内打印：线程名称+循环次数。
   3)	编写测试类Example03，在Example03类的main()方法中，创建一个Watcher对象，利用Thread（Runnable target）构造方法创建线程对象并命名，
        将线程设置为后台线程，执行该线程的start()方法，接着编写一个for循环，循环内打印循环次数。

 */

public class Domon03 {
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
                Watcher03 test = new Watcher03(lpText);
                Thread domon = new Thread(test, "后台线程");

                // 必须在启动线程之前调用SetDaemon()方法，才能把这个线程设置为后台线程
                domon.setDaemon(true);

                domon.start();

                System.out.print("是否是后台线程？");
                System.out.println(domon.isDaemon());

                Button lpIsDaemon = new Button("是否是后台线程？");

                lpPanelForButton.add(lpIsDaemon);


                lpIsDaemon.addMouseListener(new MouseListener() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        System.out.print("是否是后台线程？");
                        System.out.println(domon.isDaemon());
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

class Watcher03 implements Runnable{

    private TextArea lpText;
    Watcher03(TextArea lpText) {
        this.lpText = lpText;
    }

    @Override
    public void run() {
        int i=0;
        while(true) {
            String lpStringForText = new String(Thread.currentThread() + "线程这个在运行第" + i++ +"次！" + '\n');
            lpText.append(lpStringForText);
        }
    }
}