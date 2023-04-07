import java.awt.Robot;
import java.awt.AWTException;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.util.Calendar;

public class AutoMove {
    
    public static void main(String[] args) {

    int numMin;
    if (args.length < 1 || !isNumeric(args[0]) || Integer.parseInt(args[0]) < 1) {
        numMin = 5;
    } else {
        numMin = Integer.parseInt(args[0]);
    }

    Robot robot;
    try {
        robot = new Robot();
    } catch (AWTException e) {
        e.printStackTrace();
        return;
    }

    robot.setAutoDelay(50);
    robot.setAutoWaitForIdle(true);

    while (true) {
        int x = 0;
        while (x < numMin) {
            try {
                Thread.sleep(60 * 1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
                return;
            }
            x++;
        }

        for (int i = 0; i < 10; i++) {
            robot.mouseMove(0, i * 4);
        }

        robot.mouseMove(1, 1);

        for (int i = 0; i < 3; i++) {
            robot.keyPress(KeyEvent.VK_SHIFT);
        }

        robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);

        System.out.println("Movement made at " + Calendar.getInstance().getTime());
    }

}

public static boolean isNumeric(String str) {
    try {
        int d = Integer.parseInt(str);
    } catch (NumberFormatException nfe) {
        return false;
    }
    return true;
}

}
