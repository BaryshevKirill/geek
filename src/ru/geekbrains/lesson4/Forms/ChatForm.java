package ru.geekbrains.lesson4.Forms;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ChatForm extends JFrame {

    private JTextField messageField = new JTextField();
    private JTextArea messagesArea = new JTextArea();
//    private JTextPane tPane;

    public ChatForm() throws HeadlessException {

        setTitle("GeekChat");
        setBounds(200, 200, 500, 500);
        setResizable(false);
//        setMaximumSize(new Dimension(500,500));
//        setMinimumSize(new Dimension(500,500));
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

       /* tPane = new JTextPane(){
            public boolean getScrollableTracksViewportWidth()
            {
                return getUI().getPreferredSize(this).width
                        <= getParent().getSize().width;
            }
        };*/

//        tPane = new JTextPane();
//        JPanel noWrapPanel = new JPanel( new BorderLayout() );
//        noWrapPanel.add( tPane );
//        JScrollPane scrollPane = new JScrollPane( noWrapPanel );
//        add(scrollPane);



//Поле для вывода истории сообщений
        messagesArea.setLineWrap(true);
        messagesArea.setWrapStyleWord(true);
        messagesArea.setEditable(false);
        messagesArea.setForeground(Color.BLUE);
        messagesArea.setBackground(Color.GRAY);


//Скрол для поля с сообщениями
        JScrollPane scroll = new JScrollPane(messagesArea,
                JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
                JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        add(scroll, BorderLayout.CENTER);
//        messageHistoriesPanel.add(scroll, BorderLayout.CENTER);

//Панель хранящая кнопку и поле для нового сообщения
        JPanel sendMessagePanel = new JPanel();
        sendMessagePanel.setLayout(new BorderLayout());
        JButton sendButton = new JButton("Отправить");

//        Обработка нажатия кнопки отправить
        sendButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (messageField.getText() == null || "".equals(messageField.getText())) {
                    return;
                }
                String message = "Мистер Х: " + messageField.getText() + "\n";
//                appendToPane(tPane, message, Color.blue);
                messagesArea.append(message);
//                try {
//                    messagesArea.getHighlighter().addHighlight(0, message.length(), new DefaultHighlighter.DefaultHighlightPainter(Color.GRAY));
//                } catch (BadLocationException e1) {
//                    e1.printStackTrace();
//                }
                messageField.setText("");
            }
        });

//      Обработка нажатия Enter на поле ввода сообщения
        messageField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (messageField.getText() == null || "".equals(messageField.getText())) {
                    return;
                }
                String message = "Мистер Х: " + messageField.getText() + "\n";
//                appendToPane(tPane, message, Color.blue);
                messagesArea.append(message);
//                try {
//                    messagesArea.getHighlighter().addHighlight(0, message.length(), new DefaultHighlighter.DefaultHighlightPainter(Color.GRAY));
//                } catch (BadLocationException e1) {
//                    e1.printStackTrace();
//                }
                messageField.setText("");


            }
        });

        sendMessagePanel.add(sendButton, BorderLayout.EAST);
        sendMessagePanel.add(messageField, BorderLayout.CENTER);
        add(sendMessagePanel, BorderLayout.SOUTH);

        messagesArea.append("");

        setVisible(true);

    }

    // Из гугла разбираюсь как это работает
//    private void appendToPane(JTextPane tp, String msg, Color c)
//    {
//        StyleContext sc = StyleContext.getDefaultStyleContext();
//        AttributeSet aset = sc.addAttribute(SimpleAttributeSet.EMPTY, StyleConstants.Foreground, c);
//
//        aset = sc.addAttribute(aset, StyleConstants.FontFamily, "Lucida Console");
//        aset = sc.addAttribute(aset, StyleConstants.Alignment, StyleConstants.ALIGN_JUSTIFIED);
//
//        int len = tp.getDocument().getLength();
//        tp.setCaretPosition(len);
//        tp.setCharacterAttributes(aset, false);
//        tp.replaceSelection(msg);
//    }

}
