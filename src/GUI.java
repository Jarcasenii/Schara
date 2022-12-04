import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import java.awt.*;
import java.awt.event.*;
import java.io.File;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

public class GUI extends JFrame {

    JButton uploadbutton; 
    JPanel vidpanel1;
    JPanel vidpanel2;
    JFrame frame;
    JLabel label1;
    JLabel label2;
    JTextField textfilename;
    
public void SystemTray  (){
    frame = new JFrame();
    frame.setTitle("SCCaption"); 
    frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE); 
    frame.setSize(800,540);
    frame.setResizable(false);
    frame.setLayout(new GridLayout(1,2));
    
    label1 = new JLabel("Upload a video to transcribe:");
    label1.setForeground(Color.decode("#FBEAEB"));

    label2 = new JLabel("Chosen file:");
    
    textfilename = new JTextField(30);
    textfilename.setFont(new Font("Verdana", Font.ITALIC, 10));

    vidpanel1 = new JPanel();
    vidpanel1.setBackground(Color.decode("#2F3C7E"));
    
    vidpanel2 = new JPanel();
    vidpanel2.setBackground(Color.decode("#FBEAEB"));

    uploadbutton = new JButton("Upload");
    uploadbutton.setFocusable(false);
    uploadbutton.addActionListener(new ActionListener() {

        public void actionPerformed(ActionEvent arg0) {
            showOpenFileDialog();
        }
    });
    vidpanel1.add(label1);
    vidpanel1.add(uploadbutton);
    vidpanel1.add(textfilename);
    frame.add(vidpanel1);
    frame.add(vidpanel2);



    frame.setVisible(true);

    if(!SystemTray.isSupported()){
        System.out.println("System tray is not supported !!! ");
        return ;
    }   
    
    SystemTray systemTray = SystemTray.getSystemTray();
    
    //get default toolkit
    //Toolkit toolkit = Toolkit.getDefaultToolkit();
    //get image 
    //Toolkit.getDefaultToolkit().getImage("src/resources/busylogo.jpg");
    Image image = Toolkit.getDefaultToolkit().getImage("C:/ScreenCharaCap/Schara/src/1.png");
    
    //popupmenu
    PopupMenu trayPopupMenu = new PopupMenu();
    
    //1t menuitem for popupmenu
    MenuItem action = new MenuItem("Character Capture");
    action.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            JOptionPane.showMessageDialog(null, "Select Area");          
        }
    });     
    trayPopupMenu.add(action);
    
    //2nd menuitem of popupmenu
    MenuItem open = new MenuItem("Open");
    open.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            frame.setVisible(true);
        }
    });     
    trayPopupMenu.add(open);

    //3rd menuitem of popupmenu
    MenuItem close = new MenuItem("Close");
    close.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            System.exit(0);             
        }
    });
    trayPopupMenu.add(close);
    
    
    //setting tray icon
    TrayIcon trayIcon = new TrayIcon(image, "SCCaption", trayPopupMenu);
    //adjust to default size as per system recommendation 
    trayIcon.setImageAutoSize(true);
    
    try{
        systemTray.add(trayIcon);
    }catch(AWTException awtException){
        awtException.printStackTrace();
    }
    System.out.println("end of main");
    }

public static void main(String[] args) {
    try {
        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
    } catch (Exception e) { }

    GUI mygui = new GUI();
    mygui.SystemTray();
    }
    private void showOpenFileDialog() {
		JFileChooser fileChooser = new JFileChooser();
		fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));
		fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
		fileChooser.addChoosableFileFilter(new FileNameExtensionFilter("Videos", "mp4", "mov", "wmw", "avi","mkv"));
		fileChooser.setAcceptAllFileFilterUsed(false);

		int result = fileChooser.showOpenDialog(this);
		if (result == JFileChooser.APPROVE_OPTION) {
			File selectedFile = fileChooser.getSelectedFile();
			System.out.println("Selected file: " + selectedFile.getAbsolutePath());
            textfilename.setText(selectedFile.getAbsolutePath());
		}
        if (result == JFileChooser.CANCEL_OPTION)
            textfilename.setText("No file Selected");
	}
}

