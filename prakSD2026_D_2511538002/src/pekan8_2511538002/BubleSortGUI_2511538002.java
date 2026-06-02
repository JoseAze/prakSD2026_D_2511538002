package pekan8_2511538002;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

public class BubleSortGUI_2511538002 extends JFrame {

	private static final long serialVersionUID = 1L;
	private int[] array_8002;
	private JLabel[] labelArray_8002;
	private JButton stepButton_8002, resetButton_8002, setButton_8002;
	private JTextField inputField_8002;
	private JPanel panelArray_8002;
	private JTextArea stepArea_8002;

	private int i_8002 = 0, j_8002 = 0;
	private boolean sorting_8002 = false;
	private int stepCount_8002 = 1;

	public BubleSortGUI_2511538002() {
		setTitle("Buble Sort Langkah per Langkah");
		setSize(750, 400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setLayout(new BorderLayout());

		// panel input
		JPanel inputPanel_8002 = new JPanel(new FlowLayout());
		inputField_8002 = new JTextField(30);
		setButton_8002 = new JButton("Set Array");
		inputPanel_8002.add(new JLabel("Masukan angka (pisahkan dengan koma)"));
		inputPanel_8002.add(inputField_8002);
		inputPanel_8002.add(setButton_8002);

		// panel array visual
		panelArray_8002 = new JPanel();
		panelArray_8002.setLayout(new FlowLayout());

		// panel kontrol
		JPanel controlPanel_8002 = new JPanel();
		stepButton_8002 = new JButton("Langkah selanjutnya");
		resetButton_8002 = new JButton("Reset");
		controlPanel_8002.add(stepButton_8002);
		controlPanel_8002.add(resetButton_8002);

		// area text untuk log langkah langkah
		stepArea_8002 = new JTextArea(8, 60);
		stepArea_8002.setEditable(false);
		stepArea_8002.setFont(new Font("Monospaced", Font.PLAIN, 14));
		JScrollPane scrollPane_8002 = new JScrollPane(stepArea_8002);

		// tambahkan panel ke frame
		add(inputPanel_8002, BorderLayout.NORTH);
		add(panelArray_8002, BorderLayout.CENTER);
		add(controlPanel_8002, BorderLayout.SOUTH);
		add(scrollPane_8002, BorderLayout.EAST);

		// event set array
		setButton_8002.addActionListener(e -> setArrayFromInput_8002());

		// event selanjutnya
		stepButton_8002.addActionListener(e -> performStep_8002());

		// event reset
		resetButton_8002.addActionListener(e -> reset_8002());
	}

	private void setArrayFromInput_8002() {
		String text_8002 = inputField_8002.getText().trim();
		if (text_8002.isEmpty()) return;
		String[] parts_8002 = text_8002.split(",");
		array_8002 = new int[parts_8002.length];
		try {
			for (int k = 0; k < parts_8002.length; k++) {
				array_8002[k] = Integer.parseInt(parts_8002[k].trim());
			}
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(this, "Masukkan hanya angka "
					+ "yang dipisahkan koma!", "Error", JOptionPane.ERROR_MESSAGE);
			return;
		}

		i_8002 = 0;
		j_8002 = 0;
		stepCount_8002 = 1;
		sorting_8002 = true;
		stepButton_8002.setEnabled(true);
		stepArea_8002.setText("");
		panelArray_8002.removeAll();
		labelArray_8002 = new JLabel[array_8002.length];
		for (int k = 0; k < array_8002.length; k++) {
			labelArray_8002[k] = new JLabel(String.valueOf(array_8002[k]));
			labelArray_8002[k].setFont(new Font("Arial", Font.BOLD, 24));
			labelArray_8002[k].setOpaque(true);
			labelArray_8002[k].setBackground(Color.WHITE);
			labelArray_8002[k].setBorder(BorderFactory.createLineBorder(Color.BLACK));
			labelArray_8002[k].setPreferredSize(new Dimension(50, 50));
			labelArray_8002[k].setHorizontalAlignment(SwingConstants.CENTER);
			panelArray_8002.add(labelArray_8002[k]);
		}

		panelArray_8002.revalidate();
		panelArray_8002.repaint();
	}

	private void performStep_8002() {
		if (!sorting_8002 || i_8002 >= array_8002.length - 1) {
			sorting_8002 = false;
			stepButton_8002.setEnabled(false);
			JOptionPane.showMessageDialog(this, "Sorting selesai!");
			return;
		}

		resetHighlights_8002();
		StringBuilder stepLog_8002 = new StringBuilder();

		labelArray_8002[j_8002].setBackground(Color.CYAN);
		labelArray_8002[j_8002 + 1].setBackground(Color.CYAN);

		if (array_8002[j_8002] > array_8002[j_8002 + 1]) {
			// Swap
			int temp_8002 = array_8002[j_8002];
			array_8002[j_8002] = array_8002[j_8002 + 1];
			array_8002[j_8002 + 1] = temp_8002;
			labelArray_8002[j_8002].setBackground(Color.RED);
			labelArray_8002[j_8002 + 1].setBackground(Color.RED);
			stepLog_8002.append("Langkah ").append(stepCount_8002).append(": Menukar elemen ke-")
					.append(j_8002).append(" (").append(array_8002[j_8002 + 1]).append(") dengan ke-")
					.append(j_8002 + 1).append(" (").append(array_8002[j_8002]).append(")\n");
		} else {
			stepLog_8002.append("Langkah ").append(stepCount_8002).append(": Tidak ada pertukaran antara ke-")
					.append(j_8002).append(" dan ke-").append(j_8002 + 1).append("\n");
		}

		stepLog_8002.append("Hasil: ").append(arrayToString_8002(array_8002)).append("\n\n");
		stepArea_8002.append(stepLog_8002.toString());
		updateLabels_8002();

		j_8002++;
		if (j_8002 >= array_8002.length - i_8002 - 1) {
			j_8002 = 0;
			i_8002++;
		}
		stepCount_8002++;

		if (i_8002 >= array_8002.length - 1) {
			sorting_8002 = false;
			stepButton_8002.setEnabled(false);
			JOptionPane.showMessageDialog(this, "Sorting selesai!");
		}
	}

	private void updateLabels_8002() {
		for (int k = 0; k < array_8002.length; k++) {
			labelArray_8002[k].setText(String.valueOf(array_8002[k]));
		}
	}

	private void resetHighlights_8002() {
		for (JLabel label : labelArray_8002) {
			label.setBackground(Color.WHITE);
		}
	}

	private void reset_8002() {
		inputField_8002.setText("");
		panelArray_8002.removeAll();
		panelArray_8002.revalidate();
		panelArray_8002.repaint();
		stepArea_8002.setText("");
		stepButton_8002.setEnabled(false);
		sorting_8002 = false;
		i_8002 = 0;
		j_8002 = 0;
		stepCount_8002 = 1;
	}

	private String arrayToString_8002(int[] arr) {
		StringBuilder sb_8002 = new StringBuilder();
		for (int k = 0; k < arr.length; k++) {
			sb_8002.append(arr[k]);
			if (k < arr.length - 1) sb_8002.append(", ");
		}
		return sb_8002.toString();
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(() -> {
			BubleSortGUI_2511538002 gui = new BubleSortGUI_2511538002();
			gui.setVisible(true);
		});
	}
}