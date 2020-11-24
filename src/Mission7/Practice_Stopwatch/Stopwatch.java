package Mission7.Practice_Stopwatch;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Stopwatch implements ActionListener {

    JFrame frame = new JFrame();
    JButton startButton = new JButton("START");
    JButton resetButton = new JButton("RESET");
    JLabel timeLabel = new JLabel();
    int elapsedTime = 0;
    int sec = 0;
    int min = 0;
    int hr = 0;
    boolean started = false;
    String sec_string = String.format("%02d", sec);
    String min_string = String.format("%02d", min);
    String hr_string = String.format("%02d", hr);

    Timer timer = new Timer(1000, e -> {

        elapsedTime += 1000;
        hr = (elapsedTime / 3600000);
        min = (elapsedTime / 60000) % 60; // just to make sure it doesnt go above 60
        sec = (elapsedTime / 1000) % 60;

        String sec_string = String.format("%02d", sec);
        String min_string = String.format("%02d", min);
        String hr_string = String.format("%02d", hr);

        timeLabel.setText(hr_string + ":" + min_string + ":" + sec_string);
    });

    Stopwatch() {

        timeLabel.setText(hr_string + ":" + min_string + ":" + sec_string);
        timeLabel.setBounds(100, 100, 200, 100);
        timeLabel.setFont(new Font("Verdana", Font.PLAIN, 35));
        timeLabel.setBorder(BorderFactory.createBevelBorder(1));
        timeLabel.setOpaque(true);
        timeLabel.setHorizontalAlignment(JTextField.CENTER);

        startButton.setBounds(100, 200, 100, 50);
        startButton.setFont(new Font("Verdana", Font.PLAIN, 20));
        startButton.setFocusable(false);
        startButton.addActionListener(this);

        resetButton.setBounds(200, 200, 100, 50);
        resetButton.setFont(new Font("Verdana", Font.PLAIN, 20));
        resetButton.setFocusable(false);
        resetButton.addActionListener(this);

        frame.add(timeLabel);
        frame.add(startButton);
        frame.add(resetButton);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(420, 420);
        frame.setLayout(null);

        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == startButton) {
            if (!started) {
                start();
                startButton.setText("STOP");
                started = true;
            } else { // TODO: wont work with another 'if' instead of 'if-else'. why?
                stop();
                startButton.setText("START");
                started = false;
            }
        }

        if (e.getSource() == resetButton) {
            started = false;
            startButton.setText("START");
            reset();
        }
    }

    void start() {
        timer.start();
    }

    void stop() {
        timer.stop();
    }

    void reset() {
        timer.stop();
        elapsedTime = 0;
        sec = 0;
        min = 0;
        hr = 0;

        String sec_string = String.format("%02d", sec);
        String min_string = String.format("%02d", min);
        String hr_string = String.format("%02d", hr);

        timeLabel.setText(hr_string + ":" + min_string + ":" + sec_string);
    }
}
