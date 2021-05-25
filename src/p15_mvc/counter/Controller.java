package p15_mvc.counter;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controller {

    private Model model;
    private CounterFrame counterFrame;

    public Controller() {
        counterFrame = new CounterFrame(new ButtonListener());
        model = new Model(new CounterMonitor());
    }


    class ButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            String action = e.getActionCommand();
            switch (action) {
                case "increase":
                    model.increase();
                    counterFrame.counterChanged(model.getCounter());
                    break;
                case "decrease":
                    model.decrease();
                    counterFrame.counterChanged(model.getCounter());
                    break;
            }
        }
    }

    class CounterMonitor implements CounterChangedListener {

        @Override
        public void counterHasNewValue(int value) {
            counterFrame.counterChanged(model.getCounter());
        }
    }
}
