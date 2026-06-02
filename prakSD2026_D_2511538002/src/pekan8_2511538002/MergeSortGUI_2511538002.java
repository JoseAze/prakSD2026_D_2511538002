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

import java.util.LinkedList;
import java.util.Queue;

public class MergeSortGUI_2511538002 extends JFrame {

	private static final long serialVersionUID = 1L;
	private int[] array_8002;
	private JLabel[] labelArray_8002;
	private JButton stepButton_8002, resetButton_8002, setButton_8002;
	private JTextField inputField_8002;
	private JPanel panelArray_8002;
	private JTextArea stepArea_8002;

	private Queue<int[]> mergeQueue_8002 = new LinkedList<>();
	private int stepCount_8002 = 1;
	private boolean isMerging_8002 = false;
	private boolean copying_8002 = false;

	private int[] temp_8002;
	private int left_8002, mid_8002, right_8002;
	private int i_8002, j_8002, k_8002;

	public MergeSortGUI_2511538002() {
		setTitle("Merge Sort Langkah per Langkah");
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
			JOptionPane.showMessageDialog(this, "Masukkan hanya angka dengan koma!",
					"Error", JOptionPane.ERROR_MESSAGE);
			return;
		}

		labelArray_8002 = new JLabel[array_8002.length];
		panelArray_8002.removeAll();
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

		mergeQueue_8002.clear();
		generateMergeSteps_8002(0, array_8002.length - 1);
		stepButton_8002.setEnabled(true);
		stepArea_8002.setText("");
		stepCount_8002 = 1;
		isMerging_8002 = false;

		panelArray_8002.revalidate();
		panelArray_8002.repaint();
	}

	private void generateMergeSteps_8002(int left, int right) {
		if (left >= right) return;
		int mid = (left + right) / 2;
		generateMergeSteps_8002(left, mid);
		generateMergeSteps_8002(mid + 1, right);
		mergeQueue_8002.add(new int[]{left, mid, right});
	}

	private void performStep_8002() {
		resetHighlights_8002();

		if (!isMerging_8002 && !mergeQueue_8002.isEmpty()) {
			int[] range_8002 = mergeQueue_8002.poll();
			left_8002 = range_8002[0];
			mid_8002 = range_8002[1];
			right_8002 = range_8002[2];
			temp_8002 = new int[right_8002 - left_8002 + 1];
			i_8002 = left_8002;
			j_8002 = mid_8002 + 1;
			k_8002 = 0;
			copying_8002 = false;
			isMerging_8002 = true;
			stepArea_8002.append("Langkah " + stepCount_8002++ +
					": Mulai merge dari " + left_8002 + " ke " + right_8002 + "\n");
			return;
		}

		if (isMerging_8002 && !copying_8002) {
			if (i_8002 <= mid_8002 && j_8002 <= right_8002) {
				labelArray_8002[i_8002].setBackground(Color.CYAN);
				labelArray_8002[j_8002].setBackground(Color.CYAN);
				if (array_8002[i_8002] <= array_8002[j_8002]) {
					temp_8002[k_8002++] = array_8002[i_8002++];
				} else {
					temp_8002[k_8002++] = array_8002[j_8002++];
				}
				stepArea_8002.append("Langkah " + stepCount_8002++ + ": Bandingkan dan salin elemen\n");
				return;
			} else if (i_8002 <= mid_8002) {
				temp_8002[k_8002++] = array_8002[i_8002++];
				stepArea_8002.append("Langkah " + stepCount_8002++ + ": Salin sisa kiri\n");
				return;
			} else if (j_8002 <= right_8002) {
				temp_8002[k_8002++] = array_8002[j_8002++];
				stepArea_8002.append("Langkah " + stepCount_8002++ + ": Salin sisa kanan\n");
				return;
			} else {
				copying_8002 = true;
				k_8002 = 0;
				return;
			}
		}

		if (copying_8002 && k_8002 < temp_8002.length) {
			array_8002[left_8002 + k_8002] = temp_8002[k_8002];
			labelArray_8002[left_8002 + k_8002].setText(String.valueOf(temp_8002[k_8002]));
			labelArray_8002[left_8002 + k_8002].setBackground(Color.GREEN);
			k_8002++;
			stepArea_8002.append("Langkah " + stepCount_8002++ + ": Tempelkan ke array utama\n");
			return;
		}

		if (copying_8002 && k_8002 == temp_8002.length) {
			isMerging_8002 = false;
			copying_8002 = false;
		}

		if (mergeQueue_8002.isEmpty() && !isMerging_8002) {
			stepArea_8002.append("Selesai.\n");
			stepButton_8002.setEnabled(false);
			JOptionPane.showMessageDialog(this, "Merge Sort selesai!");
		}
	}

	private void resetHighlights_8002() {
		if (labelArray_8002 == null) return;
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
		mergeQueue_8002.clear();
		isMerging_8002 = false;
		stepCount_8002 = 1;
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(() -> {
			MergeSortGUI_2511538002 gui = new MergeSortGUI_2511538002();
			gui.setVisible(true);
		});
	}
}