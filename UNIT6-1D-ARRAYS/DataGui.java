import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;


public class DataGui extends JFrame {
    private JTextField inputField;
    private JTextArea resultsArea;
    private FileOperator file = new FileOperator("UNIT6-1D-ARRAYS/arenas.txt");
    public static int counter = 0;
    
    public DataGui() {
        setTitle("Arena Data Analyzer");
        setSize(500, 400);
        setLayout(new FlowLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        inputField = new JTextField(20);
        JButton analyzeCapacityButton = new JButton("Analyze by Capacity");
        JButton capacityByCityButton = new JButton("Get Capacity by City");
        resultsArea = new JTextArea(10, 40);
        resultsArea.setEditable(false);

        add(inputField);
        add(analyzeCapacityButton);
        add(capacityByCityButton);
        add(new JScrollPane(resultsArea));

        analyzeCapacityButton.addActionListener(e -> analyzeByCapacity());
        capacityByCityButton.addActionListener(e -> analyzeCapacityByCity());

        }
    public static String string(String[] arr) {
        String result = "";
        for(String s : arr) {
            result += s + "\n";
        }
        return result;
    }

    private static String string_int(int[] arr) {
        String result = "";
        for(int s : arr) {
            result += s + "\n";
        }
        return result;
    }

    private void analyzeByCapacity(){
        String[] arenas = DataAnalyzer.arenasByCapacity((inputField.getText()));

        resultsArea.setText("Arenas by Capacity " + inputField.getText() + ": \n" + string(arenas) + "\n");
    }
    private void analyzeCapacityByCity(){
        int[] capacities = DataAnalyzer.capacityByCity((inputField.getText()));

        resultsArea.setText("Capacities by City " + inputField.getText() + ": \n" + string_int(capacities) + "\n");
    }

    public void saveScreen(){
        counter++;
        try{
            int w = resultsArea.getWidth();
            int h = resultsArea.getHeight();
            int type =BufferedImage.TYPE_INT_ARGB;
            BufferedImage sshot = new BufferedImage(w,h,type);

            Graphics2D g2d = sshot.createGraphics();
            resultsArea.paint(g2d);

            File out = new File("Search "+ counter + ".png");
            ImageIO.write(sshot,"png",out);
            g2d.dispose();
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new DataGui().setVisible(true));
        }
    }

