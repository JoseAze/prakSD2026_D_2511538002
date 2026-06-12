package pekan9_2511538002;

import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.util.List;

public class PetaKampus_2511538002 extends JFrame {
    
    // Struktur Graph menggunakan Adjacency List
    private Map<String, List<String>> graph_8002 = new LinkedHashMap<>();
    private Map<String, Point> positions = new HashMap<>();
    
    // Penampung Hasil Pencarian
    private List<String> visitedNodes = new ArrayList<>();
    private List<String> finalPath = new ArrayList<>();
    private int exploredCount = 0;
    
    // Komponen GUI
    private JComboBox<String> startCombo;
    private JComboBox<String> goalCombo;
    private JTextArea resultArea;
    private GraphPanel graphPanel;

    public PetaKampus_2511538002() {
        setTitle("PENCARIAN JALUR MENGGUNAKAN BFS DAN DFS");
        setSize(650, 480);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        // Inisialisasi 7 Node & Sisi sesuai gambar
        initGraphData();

        // 1. Panel Atas (Kontrol & Tombol Utama)
        JPanel topPanel = new JPanel(new GridBagLayout());
        topPanel.setBackground(new Color(238, 238, 238));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(8, 8, 8, 8);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        String[] locations = graph_8002.keySet().toArray(new String[0]);
        startCombo = new JComboBox<>(locations);
        goalCombo = new JComboBox<>(locations);
        
        // Atur default combo box sesuai gambar
        startCombo.setSelectedItem("Rektorat");
        goalCombo.setSelectedItem("Labor AI");

        // Baris 1: Lokasi Awal & Tombol
        gbc.gridx = 0; gbc.gridy = 0;
        topPanel.add(new JLabel("Lokasi Awal : "), gbc);
        gbc.gridx = 1;
        topPanel.add(startCombo, gbc);
        
        gbc.gridx = 2;
        JButton btnBFS = new JButton("[ BFS ]");
        btnBFS.setBackground(new Color(144, 238, 144)); // Hijau terang
        topPanel.add(btnBFS, gbc);

        gbc.gridx = 3;
        JButton btnDFS = new JButton("[ DFS ]");
        btnDFS.setBackground(new Color(255, 182, 73)); // Oranye
        topPanel.add(btnDFS, gbc);

        gbc.gridx = 4;
        JButton btnReset = new JButton("[ RESET ]");
        btnReset.setBackground(new Color(255, 120, 120)); // Merah muda/salmon
        topPanel.add(btnReset, gbc);

        // Baris 2: Lokasi Tujuan
        gbc.gridx = 0; gbc.gridy = 1;
        topPanel.add(new JLabel("Lokasi Tujuan : "), gbc);
        gbc.gridx = 1;
        topPanel.add(goalCombo, gbc);

        add(topPanel, BorderLayout.NORTH);

        // 2. Panel Tengah (Visualisasi Graph Persis Gambar)
        graphPanel = new GraphPanel();
        add(graphPanel, BorderLayout.CENTER);

        // 3. Panel Bawah (Hasil Pencarian Teks)
        JPanel bottomPanel = new JPanel(new BorderLayout());
        bottomPanel.setBackground(Color.WHITE);
        
        resultArea = new JTextArea(5, 40);
        resultArea.setEditable(false);
        resultArea.setFont(new Font("Monospaced", Font.PLAIN, 13));
        resultArea.setBorder(BorderFactory.createEmptyBorder(10, 15, 10, 15));
        bottomPanel.add(resultArea, BorderLayout.CENTER);
        
        add(bottomPanel, BorderLayout.SOUTH);

        // Event Listener Aksi Tombol
        btnBFS.addActionListener(e -> BFS());
        btnDFS.addActionListener(e -> DFS());
        btnReset.addActionListener(e -> resetGraph());

        resetGraph(); // Set text format pertama kali
    }

    private void initGraphData() {
        // Daftar 7 Node Utama sesuai gambar
        String[] nodes = {"Perpus", "FTI", "Rektorat", "PKM", "Lab Jaringan", "Masjid", "Labor AI"};
        for (String node : nodes) {
            graph_8002.put(node, new ArrayList<>());
        }

        // Koordinat Layout Grid Teks (X, Y) agar presisi sejajar
        positions.put("Perpus", new Point(180, 50));
        positions.put("FTI", new Point(420, 50));
        
        positions.put("Rektorat", new Point(180, 120));
        positions.put("PKM", new Point(300, 120));
        positions.put("Lab Jaringan", new Point(420, 120));
        
        positions.put("Masjid", new Point(180, 190));
        positions.put("Labor AI", new Point(420, 190));

        // Struktur Sisi Relasi Garis (Undirected)
        addEdge("Perpus", "FTI");
        addEdge("Perpus", "Rektorat");
        addEdge("Rektorat", "PKM");
        addEdge("PKM", "Lab Jaringan");
        addEdge("FTI", "Lab Jaringan");
        addEdge("Rektorat", "Masjid");
        addEdge("Masjid", "Labor AI");
        addEdge("Lab Jaringan", "Labor AI");
    }

    private void addEdge(String source, String dest) {
        graph_8002.get(source).add(dest);
        graph_8002.get(dest).add(source);
    }

    public void BFS() {
        String start = (String) startCombo.getSelectedItem();
        String goal = (String) goalCombo.getSelectedItem();
        
        visitedNodes.clear();
        finalPath.clear();
        exploredCount = 0;

        Queue<String> queue = new LinkedList<>();
        Map<String, String> parentMap = new HashMap<>();

        queue.add(start);
        visitedNodes.add(start);

        boolean found = false;

        while (!queue.isEmpty()) {
            String current = queue.poll();
            exploredCount++;

            if (current.equals(goal)) {
                found = true;
                break;
            }

            for (String neighbor : graph_8002.get(current)) {
                if (!visitedNodes.contains(neighbor)) {
                    visitedNodes.add(neighbor);
                    parentMap.put(neighbor, current);
                    queue.add(neighbor);
                }
            }
        }

        if (found) {
            String curr = goal;
            while (curr != null) {
                finalPath.add(0, curr);
                curr = parentMap.get(curr);
            }
        }
        
        displayPath("BFS");
        graphPanel.repaint();
    }

    public void DFS() {
        String start = (String) startCombo.getSelectedItem();
        String goal = (String) goalCombo.getSelectedItem();

        visitedNodes.clear();
        finalPath.clear();
        exploredCount = 0;

        Stack<String> stack = new Stack<>();
        Map<String, String> parentMap = new HashMap<>();
        Set<String> visitedSet = new LinkedHashSet<>();

        stack.push(start);

        boolean found = false;

        while (!stack.isEmpty()) {
            String current = stack.pop();

            if (!visitedSet.contains(current)) {
                visitedSet.add(current);
                visitedNodes.add(current);
                exploredCount++;

                if (current.equals(goal)) {
                    found = true;
                    break;
                }

                List<String> neighbors = graph_8002.get(current);
                for (int i = neighbors.size() - 1; i >= 0; i--) {
                    String neighbor = neighbors.get(i);
                    if (!visitedSet.contains(neighbor)) {
                        stack.push(neighbor);
                        parentMap.put(neighbor, current);
                    }
                }
            }
        }

        if (found) {
            String curr = goal;
            while (curr != null) {
                finalPath.add(0, curr);
                curr = parentMap.get(curr);
            }
        }

        displayPath("DFS");
        graphPanel.repaint();
    }

    public void displayPath(String methodType) {
        StringBuilder sb = new StringBuilder();
        sb.append("Hasil Pencarian :\n");
        sb.append("Jalur : ").append(String.join(" -> ", finalPath)).append("\n");
        sb.append("Node Dikunjungi : ").append(String.join(", ", visitedNodes)).append("\n");
        sb.append("Jumlah Node Dikunjungi : ").append(exploredCount);
        resultArea.setText(sb.toString());
    }

    public void resetGraph() {
        visitedNodes.clear();
        finalPath.clear();
        exploredCount = 0;
        resultArea.setText("Hasil Pencarian :\nJalur :\nNode Dikunjungi :\nJumlah Node Dikunjungi : 0");
        graphPanel.repaint();
    }

    // Panel khusus penggambaran Graf tanpa Lingkaran Node
    private class GraphPanel extends JPanel {
        public GraphPanel() {
            setBackground(new Color(240, 240, 240));
            setBorder(BorderFactory.createTitledBorder(
                BorderFactory.createLineBorder(Color.LIGHT_GRAY), "VISUALISASI GRAPH"));
        } 

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);

            Graphics2D g2d = (Graphics2D) g;
            g2d.setRenderingHint(
                    RenderingHints.KEY_ANTIALIASING,
                    RenderingHints.VALUE_ANTIALIAS_ON);

            float[] dashPattern = {4f, 4f};

            Stroke dashedStroke = new BasicStroke(
                    1.5f,
                    BasicStroke.CAP_BUTT,
                    BasicStroke.JOIN_MITER,
                    10.0f,
                    dashPattern,
                    0.0f);

            Stroke solidRedStroke = new BasicStroke(3.0f);

            g2d.setFont(new Font("SansSerif", Font.PLAIN, 13));
            FontMetrics fm = g2d.getFontMetrics();

            // Gambar garis antar node
            for (String node : graph_8002.keySet()) {

                Point p1 = positions.get(node);
                int w1 = fm.stringWidth(node);

                for (String neighbor : graph_8002.get(node)) {

                    Point p2 = positions.get(neighbor);
                    int w2 = fm.stringWidth(neighbor);

                    int x1 = p1.x + w1 / 2;
                    int y1 = p1.y;
                    int x2 = p2.x + w2 / 2;
                    int y2 = p2.y;

                    if (p1.y == p2.y) {
                        if (p1.x < p2.x) {
                            x1 = p1.x + w1 + 5;
                            x2 = p2.x - 5;
                        } else {
                            x1 = p1.x - 5;
                            x2 = p2.x + w2 + 5;
                        }
                    }
                    else if (p1.x == p2.x) {
                        if (p1.y < p2.y) {
                            y1 = p1.y + 5;
                            y2 = p2.y - fm.getAscent();
                        } else {
                            y1 = p1.y - fm.getAscent();
                            y2 = p2.y + 5;
                        }
                    }

                    boolean isPathEdge = false;

                    if (!finalPath.isEmpty()
                            && finalPath.contains(node)
                            && finalPath.contains(neighbor)) {

                        int idx1 = finalPath.indexOf(node);
                        int idx2 = finalPath.indexOf(neighbor);

                        if (Math.abs(idx1 - idx2) == 1) {
                            isPathEdge = true;
                        }
                    }

                    if (isPathEdge) {
                        g2d.setColor(Color.RED);
                        g2d.setStroke(solidRedStroke);
                    } else {
                        g2d.setColor(Color.DARK_GRAY);
                        g2d.setStroke(dashedStroke);
                    }

                    g2d.drawLine(x1, y1, x2, y2);
                }
            }

            // Gambar nama node
            for (String node : graph_8002.keySet()) {

                Point p = positions.get(node);

                if (!finalPath.isEmpty() && finalPath.contains(node)) {
                    g2d.setColor(Color.RED);
                    g2d.setFont(new Font("SansSerif", Font.BOLD, 13));

                } else if (visitedNodes.contains(node)) {
                    g2d.setColor(new Color(0, 128, 255));
                    g2d.setFont(new Font("SansSerif", Font.BOLD, 13));

                } else {
                    g2d.setColor(Color.BLACK);
                    g2d.setFont(new Font("SansSerif", Font.PLAIN, 13));
                }

                g2d.drawString(node, p.x, p.y);
            }
        }
        	}
 
public static void main(String[] args) {
	SwingUtilities.invokeLater(() -> {
		new PetaKampus_2511538002().setVisible(true);
		});
	}
}
                
                	
                  