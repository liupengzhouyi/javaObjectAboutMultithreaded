package 多线程;

import java.awt.*;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class newWindowL implements WindowListener{
    @Override
    public void windowOpened(WindowEvent e) {

    }

    @Override
    public void windowClosing(WindowEvent e) {
        Window tempWindfow = e.getWindow();
        tempWindfow.setVisible(true);
        tempWindfow.dispose();
    }

    @Override
    public void windowClosed(WindowEvent e) {

    }

    @Override
    public void windowIconified(WindowEvent e) {

    }

    @Override
    public void windowDeiconified(WindowEvent e) {

    }

    @Override
    public void windowActivated(WindowEvent e) {

    }

    @Override
    public void windowDeactivated(WindowEvent e) {

    }
}
