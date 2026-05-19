package pekan7_2511538002;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.io.Serial;

public class InsertionSortGui_2511538002 extends JFrame {

    @Serial
    private static final long serialVersionUID = 1L;
    private JLabel[] labelArray_8002;
    private JTextField textField_8002;
    private JButton setArray_8002;
    private final JButton stepButton_8002;
    private final JTextField inputField_8002;
    private final JPanel panelArray_8002;
    private final JTextArea stepArea_8002;

    private int[] array_8002;
    private int i_8002 = 1;
    private boolean sorting_8002 = false;
    private int stepCount = 1;

    // Constructor
    public InsertionSortGui_2511538002() {
        setTitle("Insertion Sort Langkah per Langkah");
        setSize(1750, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        JPanel contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5,5));

        // Panel Input
        JPanel inputPanel_8002 = new JPanel(new FlowLayout());
        inputField_8002 = new JTextField(30);
        JButton setButton = new JButton("Set Array");
        inputPanel_8002.add(new JLabel("Masukan angka (pisahkan dengan koma): "));
        inputPanel_8002.add(inputField_8002);
        inputPanel_8002.add(setButton);

        // Panel Array Visual
        panelArray_8002 = new JPanel();
        panelArray_8002.setLayout(new FlowLayout());

        // Panel Kontrol
        JPanel controlPanel_8002 = new JPanel();
        stepButton_8002 = new JButton("Langkah Selanjutnya");
        JButton resetButton = new JButton("Reset");
        stepButton_8002.setEnabled(false);
        controlPanel_8002.add(stepButton_8002);
        controlPanel_8002.add(resetButton);

        setContentPane(contentPane);

        // Area teks untuk log langkah-langkah
        stepArea_8002 = new JTextArea(8, 60);
        stepArea_8002.setEditable(false);
        stepArea_8002.setFont(new Font("Monospaced", Font.PLAIN, 14));
        JScrollPane scrollPane = new JScrollPane(stepArea_8002);

        // Tambahkan panel ke frame
        add(inputPanel_8002, BorderLayout.NORTH);
        add(panelArray_8002, BorderLayout.CENTER);
        add(controlPanel_8002, BorderLayout.SOUTH);
        add(scrollPane, BorderLayout.EAST);

        // Event set Array
        setButton.addActionListener(e -> setArrayFromInput_2511538002());

        // Event langkah selanjutnya
        stepButton_8002.addActionListener(e -> performStep_2511538002());

        // Event reset
        resetButton.addActionListener(e -> reset_2511538002());
    }

    private void setArrayFromInput_2511538002() {
        String text_8002 = inputField_8002.getText().trim();

        if (text_8002.isEmpty())
            return;

        String[] parts_8002 = text_8002.split(",");
        array_8002 = new int[parts_8002.length];

        try {
            for (int k = 0; k < parts_8002.length; k++) {
                array_8002[k] = Integer.parseInt(parts_8002[k].trim());
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Masukan hanya angka yang dipisahkan "
                + "dengan koma!", "Error", JOptionPane.ERROR_MESSAGE);

            return;
        }

        i_8002 = 1;
        sorting_8002 = true;
        stepButton_8002.setEnabled(true);
        stepArea_8002.setText("");
        panelArray_8002.removeAll();
        labelArray_8002 = new JLabel[array_8002.length];

        for (int k = 0; k < array_8002.length; k++) {
            labelArray_8002[k] = new JLabel(String.valueOf(array_8002[k]));
            labelArray_8002[k].setFont(new Font("Arial", Font.BOLD, 24));
            labelArray_8002[k].setBorder(BorderFactory.createLineBorder(Color.BLACK));
            labelArray_8002[k].setPreferredSize(new Dimension(50, 50));
            labelArray_8002[k].setHorizontalAlignment(SwingConstants.CENTER);
            panelArray_8002.add(labelArray_8002[k]);
        }

        panelArray_8002.revalidate();
        panelArray_8002.repaint();
    }

    private void performStep_2511538002() {
        if (i_8002 < array_8002.length && sorting_8002) {
            int key = array_8002[i_8002];
            int j_8002 = i_8002 - 1;

            StringBuilder stepLog = new StringBuilder();
            stepLog.append("Langkah ").append(stepCount)
                    .append(": Memasukkan ").append(key).append("\n");

            while (j_8002 >= 0 && array_8002[j_8002] > key) {
                array_8002[j_8002 + 1] = array_8002[j_8002];
                j_8002--;
            }

            array_8002[j_8002 + 1] = key;

            updateLabels_2511538002();
            stepLog.append("Hasil: ").append(arrayToString_2511538002(array_8002)).append("\n\n");
            stepArea_8002.append(stepLog.toString());

            i_8002++;
            stepCount++;

            if (i_8002 == array_8002.length) {
                sorting_8002 = false;
                stepButton_8002.setEnabled(false);
                JOptionPane.showMessageDialog(this, "Sorting selesai!");
            }
        }
    }

    private void reset_2511538002() {
        inputField_8002.setText("");
        panelArray_8002.removeAll();
        panelArray_8002.revalidate();
        panelArray_8002.repaint();
        stepArea_8002.setText("");
        stepButton_8002.setEnabled(false);
        sorting_8002 = false;
        i_8002 = 1;
        stepCount = 1;
    }

    private void updateLabels_2511538002() {
        for (int k = 0; k < array_8002.length; k++) {
            labelArray_8002[k].setText(String.valueOf(array_8002[k]));
        }
    }

    private String arrayToString_2511538002(int[] array_8002) {
        StringBuilder sb = new StringBuilder();
        for (int k = 0; k < array_8002.length; k++) {
            sb.append(array_8002[k]);
            if (k < array_8002.length - 1)
                sb.append(", ");
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    InsertionSortGui_2511538002 frame = new InsertionSortGui_2511538002();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}