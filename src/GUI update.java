import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
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
    JButton transbutton;
    JButton capButtOn;
    JButton capButtOff;
    JButton save1;
    JButton save2;
    JButton copyManager;
    
    JPanel vidpanel1;
    JPanel vidpanel2;

    JFrame frame;

    JLabel label1;
    JLabel label2;
    JLabel label3;

    JTextField textfilename;

    TextArea transcribedtext;
    TextArea capturedtext;

public void guiDesign(){

    frame = new JFrame();
    frame.setTitle("Speech Character Caption"); 
    frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE); 
    frame.setSize(800,540);
    frame.setResizable(false);
    frame.setLayout(new GridLayout(1,2));
    
    label1 = new JLabel("Upload a video to transcribe:");
    label1.setForeground(Color.decode("#FFFFFF"));
    label1.setFont(new Font("Verdana", Font.PLAIN, 14));

    
    textfilename = new JTextField(35);
    textfilename.setFont(new Font("Verdana", Font.ITALIC, 10));

    vidpanel1 = new JPanel();
    vidpanel1.setBackground(Color.decode("#23272a"));
    
    uploadbutton = new JButton();
    Image image = Toolkit.getDefaultToolkit().getImage("C:/ScreenCharaCap/Schara/src/upload.png");
    uploadbutton.setIcon(new ImageIcon(image));
    uploadbutton.setFocusable(false);
    uploadbutton.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent arg0) {
            showOpenFileDialog();
        }
    });
    uploadbutton.setBorder(null);
    uploadbutton.setOpaque(false);
    uploadbutton.setContentAreaFilled(false);
    uploadbutton.setBorderPainted(false);

    transbutton = new JButton("Click Here to Transcribe!");
    transbutton.setFont(new Font("Verdana", Font.PLAIN, 14));
    transbutton.setForeground(Color.decode("#FFFFFF"));
    transbutton.setBorder(null);
    transbutton.setOpaque(false);
    transbutton.setContentAreaFilled(false);
    transbutton.setBorderPainted(false);

    transbutton.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent arg0) {
            JOptionPane.showMessageDialog(null, "(Placeholder) When clicked, Transcribe the text using RNN.");
        }
    });
    transcribedtext = new TextArea("Transcribed text goes here", 25, 45,1);
    transcribedtext.setFont(new Font("Arial", Font.PLAIN, 12));
    transcribedtext.setBackground(Color.decode("#99aab5"));
    transcribedtext.setForeground(Color.decode("#FFFFFF"));

    save1 = new JButton("Save file as .txt");
    save1.setFont(new Font("Verdana", Font.PLAIN, 14));
    save1.setForeground(Color.decode("#FFFFFF"));
    save1.setBorder(null);
    save1.setOpaque(false);
    save1.setContentAreaFilled(false);
    save1.setBorderPainted(false);
    save1.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent arg0) {
            JOptionPane.showMessageDialog(null, "(Placeholder) When clicked, Save the file as .txt in chosen folder.");
        }
    });

    vidpanel1.add(label1);
    vidpanel1.add(uploadbutton);
    vidpanel1.add(textfilename);
    vidpanel1.add(transbutton);
    vidpanel1.add(transcribedtext);
    vidpanel1.add(save1);
    frame.add(vidpanel1);

    vidpanel2 = new JPanel();
    vidpanel2.setBackground(Color.decode("#23272a"));

    label2 = new JLabel("Character Capture:");
    label2.setForeground(Color.decode("#FFFFFF"));
    label2.setFont(new Font("Verdana", Font.PLAIN, 14));

    capButtOn = new JButton("ON");
    capButtOn.setFont(new Font("Verdana", Font.PLAIN, 14));
    capButtOn.setForeground(Color.decode("#FFFFFF"));
    capButtOn.setBorder(null);
    capButtOn.setOpaque(false);
    capButtOn.setContentAreaFilled(false);
    capButtOn.setBorderPainted(false);
    capButtOn.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent arg0) {
            JOptionPane.showMessageDialog(null, "(Placeholder) Toggle Character Capture On.");
        }
    });

    capButtOff = new JButton("OFF");
    capButtOff.setFont(new Font("Verdana", Font.PLAIN, 14));
    capButtOff.setForeground(Color.decode("#FFFFFF"));
    capButtOff.setBorder(null);
    capButtOff.setOpaque(false);
    capButtOff.setContentAreaFilled(false);
    capButtOff.setBorderPainted(false);
    capButtOff.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent arg0) {
            JOptionPane.showMessageDialog(null, "(Placeholder) Toggle Character Capture Off.");
        }
    });

    copyManager = new JButton("Clipboard Manager: Copied text will appear here.");
    copyManager.setFont(new Font("Verdana", Font.PLAIN, 14));
    copyManager.setForeground(Color.decode("#FFFFFF"));
    copyManager.setBorder(null);
    copyManager.setOpaque(false);
    copyManager.setContentAreaFilled(false);
    copyManager.setBorderPainted(false);
    copyManager.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent arg0) {
            JOptionPane.showMessageDialog(null, "(Placeholder) Copied text will Appear Here.");
        }
    });

    capturedtext = new TextArea("Copied Text Here", 25, 45,3);
    capturedtext.setFont(new Font("Arial", Font.PLAIN, 12));
    capturedtext.setBackground(Color.decode("#99aab5"));
    capturedtext.setForeground(Color.decode("#FFFFFF"));

    vidpanel2.add(label2);
    vidpanel2.add(capButtOn);
    vidpanel2.add(capButtOff);
    vidpanel2.add(copyManager);

    frame.add(vidpanel2);   

    frame.setVisible(true);
}
    
public void SystemTray  (){
    

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
    //set ui look and feel
    try {
        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
    } catch (Exception e) { }


    GUI mygui = new GUI();
    mygui.guiDesign();
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

