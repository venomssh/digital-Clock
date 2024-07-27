import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class Clock extends JFrame {

    Calendar calendar;
    SimpleDateFormat timeFormat;
    SimpleDateFormat dayFormat;
    SimpleDateFormat dateFormat;

    JLabel timeLabel;
    JLabel dayLabel;
    JLabel dateLabel;
    JLabel madeBYJLabel;
    String time;
    String day;
    String date;

    Clock() {
        //frame configuration
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Digital Clock");
        this.setLayout(new FlowLayout(FlowLayout.CENTER,0,10));
        this.setSize(350, 240);
        this.setResizable(false);
        

        //initialised  the format for time,date and day
        timeFormat = new SimpleDateFormat("hh:mm:ss a");
        dayFormat=new SimpleDateFormat("EEEE");
        dateFormat=new SimpleDateFormat("dd MMMMM, yyyy");
        timeLabel = new JLabel();
        timeLabel.setFont(new Font("SANS_SERIF", Font.PLAIN, 59));
        timeLabel.setBackground(Color.BLACK);
        timeLabel.setForeground(Color.WHITE);
        timeLabel.setOpaque(true);
        
        //creating label 
        dayLabel=new JLabel();
        dayLabel.setFont(new Font("Ink Free",Font.BOLD,35));
        

        dateLabel=new JLabel();
        dateLabel.setFont(new Font("Ink Free",Font.BOLD,30));
        

        madeBYJLabel=new JLabel(" Made By venom ");
        madeBYJLabel.setFont(new Font("Arial",Font.PLAIN,10));
        madeBYJLabel.setForeground(Color.GRAY);
        
        //add labels to frame
        this.add(timeLabel);
        this.add(dayLabel);
        this.add(dateLabel);
        this.add(madeBYJLabel);

        this.setVisible(true);//frame visible and start
        setTimer();
    }

    //timer method to update date time and day
    public void setTimer() {
        while (true) {
            time = timeFormat.format(Calendar.getInstance().getTime());
            timeLabel.setText(time);

            day = dayFormat.format(Calendar.getInstance().getTime());
            dayLabel.setText(day);

            date = dateFormat.format(Calendar.getInstance().getTime());
            dateLabel.setText(date);

            //wait for 1 sec
            try {
                Thread.sleep(1000);
            } catch (Exception e) {
                e.getStackTrace();
            }
        }
    }
    public static void main(String[] args) {
        new Clock();
    }
}