import javax.swing.*;
import java.awt.*;
public class AIChatBot extends JFrame {
    private JTextArea chatArea;
    private JTextField inputField;
    private JButton sendButton;

    public AIChatBot() {
        // Frame setup
        setTitle("AI ChatBot - Dark Mode");
        setSize(600, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Colors
        Color bgColor = new Color(30, 30, 30); // dark gray
        Color textColor = Color.WHITE;
        Color accentColor = new Color(0, 150, 255); // blue

        // Chat display area
        chatArea = new JTextArea();
        chatArea.setEditable(false);
        chatArea.setBackground(bgColor);
        chatArea.setForeground(textColor);
        chatArea.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        chatArea.setLineWrap(true);
        chatArea.setWrapStyleWord(true);
        JScrollPane scrollPane = new JScrollPane(chatArea);
        scrollPane.setBorder(BorderFactory.createEmptyBorder());
        add(scrollPane, BorderLayout.CENTER);

        // Input field
        inputField = new JTextField();
        inputField.setBackground(new Color(45, 45, 45));
        inputField.setForeground(textColor);
        inputField.setCaretColor(textColor);
        inputField.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        inputField.setBorder(BorderFactory.createEmptyBorder(8, 8, 8, 8));

        // Send button with style
        sendButton = new JButton("Send");
        sendButton.setBackground(accentColor);
        sendButton.setForeground(Color.WHITE);
        sendButton.setFont(new Font("Segoe UI", Font.BOLD, 14));
        sendButton.setFocusPainted(false);
        sendButton.setBorder(BorderFactory.createEmptyBorder(8, 16, 8, 16));
        sendButton.setCursor(new Cursor(Cursor.HAND_CURSOR));

        // Hover effect
        sendButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                sendButton.setBackground(accentColor.brighter());
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                sendButton.setBackground(accentColor);
            }
        });

        // Bottom panel
        JPanel inputPanel = new JPanel(new BorderLayout());
        inputPanel.setBackground(bgColor);
        inputPanel.add(inputField, BorderLayout.CENTER);
        inputPanel.add(sendButton, BorderLayout.EAST);
        add(inputPanel, BorderLayout.SOUTH);

        // Event listeners
        sendButton.addActionListener(e -> processInput());
        inputField.addActionListener(e -> processInput());

        // Final touches
        getContentPane().setBackground(bgColor);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void processInput() {
        String input = inputField.getText().trim().toLowerCase();
        if (input.isEmpty()) return;

        chatArea.append("You: " + input + "\n");
        inputField.setText("");

        String response;
        if (input.contains("bye")) {
            response = "Goodbye! Have a great day!";
        } else if (input.contains("hello") || input.contains("hi")) {
            response = "Hello! How can I help you today?";
        } else if (input.contains("your name")) {
            response = "I'm your AI ChatBot!";
        } else if (input.contains("time")) {
            response = "The current time is " + java.time.LocalTime.now().toString();
        } else if (input.contains("what can you do")) {
            response = "I can answer frequently asked questions. Try asking me about my purpose or who created me.";
        } else if (input.contains("purpose")) {
            response = "My purpose is to assist you with your questions.";
        } else if (input.contains("who created you")) {
            response = "I was created by a skilled software engineer.";
        } else if (input.contains("capital of france")) {
            response = "The capital of France is Paris.";
        } else if (input.contains("highest mountain")) {
            response = "Mount Everest is the highest mountain in the world.";
        } else if (input.contains("romeo and juliet")) {
            response = "William Shakespeare wrote \"Romeo and Juliet\".";
        } else {
            response = "I don't understand that yet, but I'm learning!";
        }

        chatArea.append("Bot: " + response + "\n");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(AIChatBot::new);
    }
}
