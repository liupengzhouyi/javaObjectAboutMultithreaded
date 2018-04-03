package 多线程;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * 1)	自定义一个类Ticket，使其实现Runnable接口，并在该类中创建int类型私有属性tickets，赋初值为10。
 * 2)	在Ticket类中重写run()方法，在方法内编写一个while循环。循环体内判断ticket值，当大于0时，使用sleep(long millis)方法使线程休眠1秒钟，
 *      并打印：当前线程名称+“正在出售第”+循环次数；否则结束循环。每执行一次while循环，tickets值减一。
 * 3)	编写测试类Example05，在Example05类的main()方法中，创建一个Ticket对象，利用Thread的构造方法创建三个线程对象并命名，
 *      并开启三个线程的start()方法。

 */


public class Domon05 {
    public static void main(String [] args) {

        Frame lpMainWindow = new Frame("练习五") ;
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
                Ticket test = new Ticket(lpText);

                Thread test01 = new Thread(test, "0001");

                Thread test02 = new Thread(test, "0002");

                Thread test03 = new Thread(test, "0003");

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


class Ticket implements Runnable{
    public int getTickets() {
        return tickets;
    }

    public void setTickets(int tickets) {
        this.tickets = tickets;
    }

    //创建int类型私有属性tickets，赋初值为10。
    private int tickets ;

    private TextArea tempText;

    public Ticket(TextArea lp_TempText) {
        this.tempText = lp_TempText;
        this.tickets = 10;
    }

    @Override
    public void run() {
        while(this.tickets > 0) {

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            String lpString = new String(Thread.currentThread() + "线程正在打印" + this.tickets + '\n');
            this.tickets--;
            tempText.append(lpString);
        }
    }
}