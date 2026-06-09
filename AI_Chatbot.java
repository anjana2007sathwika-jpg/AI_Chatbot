import java.util.Scanner;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class AI_Chatbot extends JFrame implements ActionListener {

    private JTextArea chatArea;
    private JTextField inputField;
    private JButton sendButton;

    public AI_Chatbot() {
        setTitle("AI Chatbot");
        setSize(500, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        chatArea = new JTextArea();
        chatArea.setEditable(false);
        chatArea.setLineWrap(true);

        JScrollPane scrollPane = new JScrollPane(chatArea);

        inputField = new JTextField();
        sendButton = new JButton("Send");

        JPanel panel = new JPanel(new BorderLayout());
        panel.add(inputField, BorderLayout.CENTER);
        panel.add(sendButton, BorderLayout.EAST);

        add(scrollPane, BorderLayout.CENTER);
        add(panel, BorderLayout.SOUTH);

        sendButton.addActionListener(this);
        inputField.addActionListener(this);

        chatArea.append("Bot: Hello! I am your AI Chatbot.\n");
        chatArea.append("Bot: Ask me anything.\n\n");

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String userInput = inputField.getText();

        if (!userInput.trim().isEmpty()) {
            chatArea.append("You: " + userInput + "\n");

            String response = getBotResponse(userInput);

            chatArea.append("Bot: " + response + "\n\n");
            inputField.setText("");
        }
    }

    private String getBotResponse(String input) {

        input = input.toLowerCase();

        if (input.contains("hello") || input.contains("hi")) {
            return "Hello! How can I help you today?";
        }

        else if (input.contains("your name")) {
            return "I am a Java AI Chatbot.";
        }

        else if (input.contains("how are you")) {
            return "I am functioning perfectly!";
        }

        else if (input.contains("java")) {
            return "Java is a popular object-oriented programming language.";
        }

        else if (input.contains("college")) {
            return "Please contact the college administration for detailed information.";
        }

        else if (input.contains("course")) {
            return "Our institution offers various technical and professional courses.";
        }

        else if (input.contains("bye")) {
            return "Goodbye! Have a great day.";
        }

        else {
            return "Sorry, I don't understand that. Please try another question.";
        }
    }

    public static void main(String[] args) {
        new AI_Chatbot();
    }
}