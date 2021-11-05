package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyFrame extends JFrame implements ActionListener {


    String[] questions = {
            "Which country produces the most coffee in the world?",
            "Which country invented tea?",
            "What is the national dish of Spain?",
            "Which country is responsible for giving us pizza and pasta?",
            "Which American state is the largest (by area)?",
            "Which two countries share the longest (or largest) international border?",
            "What is the smallest country in the world?",
            "What is celebrated on the 2nd Saturday in June in the United Kingdom?",
            "Which country celebrates the Storming of the Bastille?",
            "Which popular TV show featured house Targaryen and Stark?",
    };

    String[][] options = {
            {"Brazil" , "Turkey" , "USA" , "Germany"},
            {"Egypt" , "Canada" , "China" , "Argentina"},
            {"Jamón" , "Patatas bravas" , "Gazpacho" , "Paella Valenciana"},
            {"Germany" , "Italy" , "France" , "England"},
            {"California" , "Texas" , "Pennsylvania" , "Alaska"},
            {"Canada and the USA" , "Brazil and Argentina" , "Egypt and Libya" , "France and Germany"},
            {"Monaco" , "Nauru" , "Vatican City" , "San Marino"},
            {"THE QUEEN’S OFFICIAL BIRTHDAY" , "ST PATRICK’S DAY" , "SUMMER SOLSTICE" , "EDINBURGH FRINGE FESTIVAL"},
            {"Spain" , "Italy" , "UK" , "France"},
            {"Harry Potter" , "Game of Thrones" , "Peaky Blinders" , "La Casa De Papel"},
    };

    char[] answers = {
            'A',
            'C',
            'D',
            'B',
            'D',
            'A',
            'C',
            'A',
            'D',
            'B'
    };

    //char guess;
    char answer;
    int index;
    int correct_guess = 0;
    int total_questions = questions.length;
    int result;
    int seconds = 10;


    /////////
    JTextField textField = new JTextField();
    JTextArea textArea = new JTextArea();
    JButton buttonA = new JButton();
    JButton buttonB = new JButton();
    JButton buttonC = new JButton();
    JButton buttonD = new JButton();
    JLabel labelA = new JLabel();
    JLabel labelB = new JLabel();
    JLabel labelC = new JLabel();
    JLabel labelD = new JLabel();
    JLabel time_label = new JLabel();
    JLabel seconds_left = new JLabel();
    JTextField number_right = new JTextField();
    JTextField percentage = new JTextField();


    /// most important thing in this program
    Timer timer = new Timer(1000, e -> {

        seconds--;
        seconds_left.setText(String.valueOf(seconds));
        if(seconds <= 0){
            displayAnswers();
        }

    });

    MyFrame(){

        ImageIcon icon = new ImageIcon("Quiz-Games.png");

        ///////////////////////////////////////////////////////////////////
        textField.setBounds(0 , 0 , 600 , 50);
        textField.setBackground(new Color(0 , 255 , 255));
        textField.setForeground(new Color(0 , 0 , 69));
        textField.setFont(new Font("Ink Free" , Font.BOLD , 30));
        textField.setBorder(BorderFactory.createBevelBorder(1));
        textField.setHorizontalAlignment(JTextField.CENTER);
        textField.setEditable(false);

        /////

        textArea.setBounds(0 , 50 , 600 , 50);
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        textArea.setBackground(new Color(0 , 255 , 255));
        textArea.setForeground(new Color(0 , 0 , 69));
        textArea.setFont(new Font("MV Boli" , Font.BOLD , 20));
        textArea.setBorder(BorderFactory.createBevelBorder(1));
        //textArea.setHorizontalAlignment(JTextField.CENTER);
        textArea.setEditable(false);

        //// Buttons
        // A

        buttonA.setBounds(10 , 125 , 65 , 65);
        buttonA.setForeground(new Color(0 , 0 , 69));
        buttonA.setFocusable(false);
        buttonA.setFont(new Font("MV Boli" , Font.BOLD , 25));
        buttonA.setBackground(new Color(0 , 255 , 255));
        buttonA.setBorder(null);
        buttonA.addActionListener(this);
        buttonA.setText("A");

        // B

        buttonB.setBounds(10 , 225 , 65 , 65);
        buttonB.setForeground(new Color(0 , 0 , 69));
        buttonB.setFocusable(false);
        buttonB.setFont(new Font("MV Boli" , Font.BOLD , 25));
        buttonB.setBackground(new Color(0 , 255 , 255));
        buttonB.setBorder(null);
        buttonB.addActionListener(this);
        buttonB.setText("B");

        // C

        buttonC.setBounds(10 , 325 , 65 , 65);
        buttonC.setForeground(new Color(0 , 0 , 69));
        buttonC.setFocusable(false);
        buttonC.setFont(new Font("MV Boli" , Font.BOLD , 25));
        buttonC.setBackground(new Color(0 , 255 , 255));
        buttonC.setBorder(null);
        buttonC.addActionListener(this);
        buttonC.setText("C");

        // D

        buttonD.setBounds(10 , 425 , 65 , 65);
        buttonD.setForeground(new Color(0 , 0 , 69));
        buttonD.setFocusable(false);
        buttonD.setFont(new Font("MV Boli" , Font.BOLD , 25));
        buttonD.setBackground(new Color(0 , 255 , 255));
        buttonD.setBorder(null);
        buttonD.addActionListener(this);
        buttonD.setText("D");


        /////////// Labels

        labelA.setBounds(100 , 125 , 500 , 65);
        labelA.setForeground(new Color(0 , 255 , 255));
        labelA.setFont(new Font("MV Boli" , Font.PLAIN , 25));

        // B
        labelB.setBounds(100 , 225 , 500 , 65);
        labelB.setForeground(new Color(0 , 255 , 255));
        labelB.setFont(new Font("MV Boli" , Font.PLAIN , 25));

        // C
        labelC.setBounds(100 , 325 , 500 , 65);
        labelC.setForeground(new Color(0 , 255 , 255));
        labelC.setFont(new Font("MV Boli" , Font.PLAIN , 25));

        // D
        labelD.setBounds(100 , 425 , 500 , 65);
        labelD.setForeground(new Color(0 , 255 , 255));
        labelD.setFont(new Font("MV Boli" , Font.PLAIN , 25));


        /// second_left
        seconds_left.setBounds(505 , 489 , 80 , 80);
        seconds_left.setBackground(new Color(0 , 255 , 255));
        seconds_left.setForeground(new Color(0 , 0 , 69));
        seconds_left.setFont(new Font("INK Free" , Font.BOLD , 30));
        seconds_left.setOpaque(true);
        seconds_left.setBorder(BorderFactory.createBevelBorder(1));
        seconds_left.setHorizontalAlignment(JTextField.CENTER);
        seconds_left.setText(String.valueOf(seconds));

        /// timer Label
        time_label.setBounds(505 , 455 , 75 , 25);
        time_label.setForeground(new Color(0 , 255 , 255));
        time_label.setFont(new Font("MV Boli" , Font.PLAIN , 15));
        time_label.setHorizontalAlignment(JTextField.CENTER);
        time_label.setText("Timer >:D");


        /////// number_right
        number_right.setBounds(200 , 200 , 200 , 100);
        number_right.setForeground(new Color(0 , 0 , 69));
        number_right.setBackground(new Color(0 , 255 , 255));
        number_right.setFont(new Font("INK Free" , Font.BOLD , 35));
        number_right.setBorder(BorderFactory.createBevelBorder(1));
        number_right.setHorizontalAlignment(JTextField.CENTER);
        number_right.setEditable(false);

        /////// percentage
        percentage.setBounds(200 , 300 , 200 , 100);
        percentage.setForeground(new Color(0 , 0 , 69));
        percentage.setBackground(new Color(0 , 255 , 255));
        percentage.setFont(new Font("INK Free" , Font.BOLD , 35));
        percentage.setBorder(BorderFactory.createBevelBorder(1));
        percentage.setHorizontalAlignment(JTextField.CENTER);
        percentage.setEditable(false);

        ///////////////////////////////////////////////////////////////////

        this.setSize(600 , 600);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setTitle("QUIZ GAME");
        this.setIconImage(icon.getImage());
        this.setLayout(null);
        this.setVisible(true);
        this.getContentPane().setBackground(new Color(0 , 0 , 69));



        this.add(textField);
        this.add(textArea);

        this.add(buttonA);
        this.add(buttonB);
        this.add(buttonC);
        this.add(buttonD);

        this.add(labelA);
        this.add(labelB);
        this.add(labelC);
        this.add(labelD);

        this.add(seconds_left);
        this.add(time_label);

        /*this.add(number_right);
        this.add(percentage);*/

        nextQuestion();

    }



    @Override
    public void actionPerformed(ActionEvent e) {

        buttonA.setEnabled(false);
        buttonB.setEnabled(false);
        buttonC.setEnabled(false);
        buttonD.setEnabled(false);

        if(e.getSource() == buttonA){
            answer = 'A';

            if(answer == answers[index]){
                correct_guess ++;
            }
        }

        if(e.getSource() == buttonB){
            answer = 'B';

            if(answer == answers[index]){
                correct_guess ++;
            }
        }

        if(e.getSource() == buttonC){
            answer = 'C';

            if(answer == answers[index]){
                correct_guess ++;
            }
        }

        if(e.getSource() == buttonD){
            answer = 'D';

            if(answer == answers[index]){
                correct_guess ++;
            }
        }

        displayAnswers();

    }


    public void nextQuestion(){

        if(index >= total_questions){
            results();
        }
        else{
            textField.setText("Question " + (index+1));
            textArea.setText(questions[index]);
            labelA.setText(options[index][0]);
            labelB.setText(options[index][1]);
            labelC.setText(options[index][2]);
            labelD.setText(options[index][3]);

            // start timer
            timer.start();
        }

    }

    public void displayAnswers(){
        // stop timer
        timer.stop();

        buttonA.setEnabled(false);
        buttonB.setEnabled(false);
        buttonC.setEnabled(false);
        buttonD.setEnabled(false);

        if(answers[index] != 'A')
            labelA.setForeground(new Color(191 , 255 , 0));
        if(answers[index] != 'B')
            labelB.setForeground(new Color(191 , 255 , 0));
        if(answers[index] != 'C')
            labelC.setForeground(new Color(191 , 255 , 0));
        if(answers[index] != 'D')
            labelD.setForeground(new Color(191 , 255 , 0));



        /// most important thing in this program
        Timer pause = new Timer(2000, e -> {
            labelA.setForeground(new Color(0 , 255 , 255));
            labelB.setForeground(new Color(0 , 255 , 255));
            labelC.setForeground(new Color(0 , 255 , 255));
            labelD.setForeground(new Color(0 , 255 , 255));

            answer = ' ';
            seconds = 10;
            seconds_left.setText(String.valueOf(seconds));
            buttonA.setEnabled(true);
            buttonB.setEnabled(true);
            buttonC.setEnabled(true);
            buttonD.setEnabled(true);
            index++;
            nextQuestion();
        });

        pause.setRepeats(false);
        pause.start();

    }

    public void results(){

        buttonA.setEnabled(false);
        buttonB.setEnabled(false);
        buttonC.setEnabled(false);
        buttonD.setEnabled(false);

        /*buttonA.setText("");
        buttonA.setBackground(new Color(0 , 0 , 69));*/

        result = (int)((correct_guess / (double) total_questions) * 100);

        textField.setText("RESULTS!!");
        textArea.setText("");
        labelA.setText("");
        labelB.setText("");
        labelC.setText("");
        labelD.setText("");

        number_right.setText("(" + correct_guess + "/" + total_questions + ")");
        percentage.setText(result + "%");
        this.add(number_right);
        this.add(percentage);
    }
}
