package pekan7_2511538002;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class SortingGUI_2511538002 extends JFrame {
 JTextField txtNama, txtNim, txtProdi;
 JButton btnTambah, btnHapus, btnSorting;
 JComboBox<String> comboSorting;
 JTextArea txtProses;
 JTable table;
 DefaultTableModel model;

 ArrayList<Mahasiswa_2511538002> listMahasiswa = new ArrayList<>();
 public SortingGUI_2511538002() {
     setTitle("Sorting Data Mahasiswa");
     setSize(700, 550);
     setDefaultCloseOperation(EXIT_ON_CLOSE);
     setLocationRelativeTo(null);

     // PANEL INPUT
     JPanel panelInput = new JPanel(new GridLayout(4, 2, 5, 5));
     panelInput.add(new JLabel("Nama"));
     txtNama = new JTextField();
     panelInput.add(txtNama);

     panelInput.add(new JLabel("NIM"));
     txtNim = new JTextField();
     panelInput.add(txtNim);

     panelInput.add(new JLabel("Prodi"));
     txtProdi = new JTextField();
     panelInput.add(txtProdi);

     btnTambah = new JButton("Tambah");
     panelInput.add(btnTambah);

     btnHapus = new JButton("Hapus");
     panelInput.add(btnHapus);

     // TABLE
     model = new DefaultTableModel();
     model.addColumn("Nama");
     model.addColumn("NIM");
     model.addColumn("Prodi");
     table = new JTable(model);
     JScrollPane scrollTable = new JScrollPane(table);

     // PANEL BAWAH
     JPanel panelBawah = new JPanel();
     comboSorting = new JComboBox<>();
     comboSorting.addItem("Insertion Sort");
     comboSorting.addItem("Selection Sort");
     comboSorting.addItem("Bubble Sort");

     btnSorting = new JButton("Mulai Sorting");

     panelBawah.add(comboSorting);
     panelBawah.add(btnSorting);

     // TEXT AREA PROSES
     txtProses = new JTextArea(10, 50);
     txtProses.setEditable(false);

     JScrollPane scrollText = new JScrollPane(txtProses);
     // LAYOUT
     setLayout(new BorderLayout());
     add(panelInput, BorderLayout.NORTH);
     add(scrollTable, BorderLayout.CENTER);

     JPanel southPanel = new JPanel(new BorderLayout());
     southPanel.add(panelBawah, BorderLayout.NORTH);
     southPanel.add(scrollText, BorderLayout.CENTER);
     add(southPanel, BorderLayout.SOUTH);

     // EVENT TAMBAH
     btnTambah.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
             String nama = txtNama.getText();
             String nim = txtNim.getText();
             String prodi = txtProdi.getText();
             Mahasiswa_2511538002 mhs = new Mahasiswa_2511538002(nama, nim, prodi);
             listMahasiswa.add(mhs);
             model.addRow(new Object[]{
                     nama,
                     nim,
                     prodi
             });

             txtNama.setText("");
             txtNim.setText("");
             txtProdi.setText("");
         }
     });

     // EVENT HAPUS
     btnHapus.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
             int row = table.getSelectedRow();
             if (row >= 0) {
                 listMahasiswa.remove(row);
                 model.removeRow(row);
             }
         }
     });

     // EVENT SORTING
     btnSorting.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
             txtProses.setText("");
             String pilihan = comboSorting.getSelectedItem().toString();
             if (pilihan.equals("Insertion Sort")) {
                 insertionSort();
             } else if (pilihan.equals("Selection Sort")) {
                 selectionSort();
             } else {
                 bubbleSort();
             }
             tampilkanTable();
         }
     });
 }

 // INSERTION SORT
 public void insertionSort() {
     txtProses.append("=== INSERTION SORT ===\n");
     for (int i = 1; i < listMahasiswa.size(); i++) {
         Mahasiswa_2511538002 key = listMahasiswa.get(i);
         int j = i - 1;
         while (j >= 0 &&
                 listMahasiswa.get(j).getNama()
                         .compareToIgnoreCase(key.getNama()) > 0) {
             listMahasiswa.set(j + 1, listMahasiswa.get(j));
             j--;
         }

         listMahasiswa.set(j + 1, key);
         txtProses.append("Langkah " + i + " : ");
         tampilkanArray();
     }
 }
 // SELECTION SORT
 public void selectionSort() {
     txtProses.append("=== SELECTION SORT ===\n");
     for (int i = 0; i < listMahasiswa.size() - 1; i++) {
         int min = i;
         for (int j = i + 1; j < listMahasiswa.size(); j++) {
             if (listMahasiswa.get(j).getNama()
                     .compareToIgnoreCase(
                             listMahasiswa.get(min).getNama()) < 0) {
                 min = j;
             }
         }

         Mahasiswa_2511538002 temp = listMahasiswa.get(i);
         listMahasiswa.set(i, listMahasiswa.get(min));
         listMahasiswa.set(min, temp);

         txtProses.append("Pass " + (i + 1) + " : ");
         tampilkanArray();
     }
 }
 // BUBBLE SORT
 public void bubbleSort() {
     txtProses.append("=== BUBBLE SORT ===\n");
     for (int i = 0; i < listMahasiswa.size() - 1; i++) {
         for (int j = 0; j < listMahasiswa.size() - i - 1; j++) {
             if (listMahasiswa.get(j).getNama()
                     .compareToIgnoreCase(
                             listMahasiswa.get(j + 1).getNama()) > 0) {
                 Mahasiswa_2511538002 temp = listMahasiswa.get(j);
                 listMahasiswa.set(j,
                         listMahasiswa.get(j + 1));
                 listMahasiswa.set(j + 1, temp);
             }
         }
         txtProses.append("Pass " + (i + 1) + " : ");
         tampilkanArray();
     }
 }
 // TAMPILKAN ARRAY KE TEXTAREA
 public void tampilkanArray() {

     txtProses.append("[");

     for (int i = 0; i < listMahasiswa.size(); i++) {

         txtProses.append(listMahasiswa.get(i).getNama());

         if (i < listMahasiswa.size() - 1) {
             txtProses.append(", ");
         }
     }

     txtProses.append("]\n");
 }
 // UPDATE TABLE
 public void tampilkanTable() {

     model.setRowCount(0);

     for (Mahasiswa_2511538002 m : listMahasiswa) {

         model.addRow(new Object[]{
                 m.getNama(),
                 m.getNim(),
                 m.getProdi()
         });
     }
 }

 public static void main(String[] args) {

     new SortingGUI_2511538002().setVisible(true);
 }
}



