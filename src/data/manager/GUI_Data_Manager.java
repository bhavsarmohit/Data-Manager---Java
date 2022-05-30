package data.manager;

import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Image;
import java.awt.Insets;
import static java.awt.SystemColor.text;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.imageio.ImageIO;
import javax.swing.AbstractAction;
import javax.swing.ActionMap;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.InputMap;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;
import javax.swing.event.UndoableEditEvent;
import javax.swing.event.UndoableEditListener;
import javax.swing.text.BadLocationException;
import javax.swing.text.DefaultHighlighter;
import javax.swing.text.Document;
import javax.swing.text.Highlighter;
import javax.swing.text.Highlighter.HighlightPainter;
import javax.swing.text.JTextComponent;
import javax.swing.undo.CannotUndoException;
import javax.swing.undo.UndoManager;

public class GUI_Data_Manager extends javax.swing.JFrame {

    
    public GUI_Data_Manager() {
        initComponents();
        
        //Set Icon
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("DManager_Icon.png")));
        
        //set Maximum Window mode
        setExtendedState(GUI_Data_Manager.MAXIMIZED_BOTH);
        
        
        //Disable All Features
        //jPanel3.setVisible(false);
        jMenu1_Save.setEnabled(false);
        jMenu2_Find.setEnabled(false);
        jMenu1_Tools.setEnabled(false);
        
        //turn off menubar undo/redo
        jMenuItem4_Undo.setEnabled(false);
        jMenuItem5_Redo.setEnabled(false);
        
        //Disable Visibility of Panels
        jPanel2_Find.setVisible(false);
        jPanel3_notification.setVisible(false);
        jPanel4_changePassword.setVisible(false);
        
        //Disable change Password Panel
        jPanel4_changePassword.setEnabled(false);
//        jPasswordField2.setEnabled(false);
//        jPasswordField3.setEnabled(false);
//        jButton3_changePass.setEnabled(false);
//        jButton4_cancel.setEnabled(false);
        
        
        
        //=============================================
        //image resize to set their size auto
        ImageIcon myimage;
        Image img1;
        Image img2;
        ImageIcon format;
                
        //search icon
        myimage = new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("Search-Icon.png")));
        
        img1 = myimage.getImage();
        img2 = img1.getScaledInstance(find_btn.getWidth(), find_btn.getHeight(), Image.SCALE_SMOOTH);
        format = new ImageIcon(img2);
        find_btn.setIcon(format);
        find_btn.setIcon(format);
        find_btn.setBorderPainted(false);
        find_btn.setBorder(null);
        find_btn.setMargin(new Insets(0,0,0,0));
        find_btn.setContentAreaFilled(false);
        
        //close icon
        myimage = new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("close.png")));
        
        img1 = myimage.getImage();
        img2 = img1.getScaledInstance(jButton2_Close.getWidth(), jButton2_Close.getHeight(), Image.SCALE_SMOOTH);
        format = new ImageIcon(img2);
        jButton2_Close.setIcon(format);
        jButton2_Close.setBorderPainted(false);
        jButton2_Close.setBorder(null);
        jButton2_Close.setMargin(new Insets(0,0,0,0));
        jButton2_Close.setContentAreaFilled(false);
        
        
        //find down icon
        myimage = new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("down_round.png")));
        
        img1 = myimage.getImage();
        img2 = img1.getScaledInstance(jButton2.getWidth(), jButton2.getHeight(), Image.SCALE_SMOOTH);
        format = new ImageIcon(img2);
        jButton2.setIcon(format);
        jButton2.setBorderPainted(false);
        jButton2.setBorder(null);
        jButton2.setMargin(new Insets(0,0,0,0));
        jButton2.setContentAreaFilled(false);
        
        //find up icon
        myimage = new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("up_round.png")));
        
        img1 = myimage.getImage();
        img2 = img1.getScaledInstance(jButton1.getWidth(), jButton1.getHeight(), Image.SCALE_SMOOTH);
        format = new ImageIcon(img2);
        jButton1.setIcon(format);
        jButton1.setBorderPainted(false);
        jButton1.setBorder(null);
        jButton1.setMargin(new Insets(0,0,0,0));
        jButton1.setContentAreaFilled(false);
        
        //Logo icon
        
        myimage = new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("DManager_Icon.png")));
        
        img1 = myimage.getImage();
        img2 = img1.getScaledInstance(jLabel3_logo.getWidth(), jLabel3_logo.getHeight(), Image.SCALE_SMOOTH);
        format = new ImageIcon(img2);
        jLabel3_logo.setIcon(format);

        //save icon
        myimage = new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("save_black.png")));
        
        img1 = myimage.getImage();
        img2 = img1.getScaledInstance(20, 20, Image.SCALE_SMOOTH);
        format = new ImageIcon(img2);
        jMenuItem1_save.setIcon(format);
        
        //find icon
        myimage = new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("Search-Icon.png")));
        
        img1 = myimage.getImage();
        img2 = img1.getScaledInstance(25, 25, Image.SCALE_SMOOTH);
        format = new ImageIcon(img2);
        jMenuItem2_find.setIcon(format);
        
        //undo icon
        myimage = new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("undo_black.png")));
        
        img1 = myimage.getImage();
        img2 = img1.getScaledInstance(25, 25, Image.SCALE_SMOOTH);
        format = new ImageIcon(img2);
        jMenuItem4_Undo.setIcon(format);
        
        //redo icon
        myimage = new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("redo_black.png")));
        
        img1 = myimage.getImage();
        img2 = img1.getScaledInstance(20, 20, Image.SCALE_SMOOTH);
        format = new ImageIcon(img2);
        jMenuItem5_Redo.setIcon(format);
        
        //change password icon
        myimage = new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("key-icon.png")));
        
        img1 = myimage.getImage();
        img2 = img1.getScaledInstance(25, 25, Image.SCALE_SMOOTH);
        format = new ImageIcon(img2);
        jMenuItem1_changePassword.setIcon(format);
        

        //=============================================
        
        
        //set text
        alert_jLabel3.setText("");
        
        //check whether User Created Database or Not
        String DataDB = get_User_Data_DB(); //receive Data from DB
            if(DataDB == null){
                alert_jLabel3.setText("Unable to Find Database!!!");
                disable_jPanel3_notification_TimeLaps();
               
                //set text for create database
                jLabel1.setText("Type New Password :");
                submit_btn.setText("Create Database");
                }
            else if(DataDB.equals("SQL_DATABASE_EXCEPTION")){
                alert_jLabel3.setText("SQL_DATABASE_EXCEPTION");
                jPanel3_notification.setVisible(true);
                disable_jPanel3_notification_TimeLaps();
            }else if(DataDB.equals("CLASS_NOT_FOUND_EXCEPTION")){
                alert_jLabel3.setText("CLASS_NOT_FOUND_EXCEPTION");
                jPanel3_notification.setVisible(true);
                disable_jPanel3_notification_TimeLaps();
            }else if(DataDB.equals("IOEXCEPTION")){
                alert_jLabel3.setText("IOEXCEPTION_CANNOT_CREATE_DATABASE");
                jPanel3_notification.setVisible(true);
                disable_jPanel3_notification_TimeLaps();
            }
        
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuItem3 = new javax.swing.JMenuItem();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel3_logo = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPasswordField1 = new javax.swing.JPasswordField();
        submit_btn = new javax.swing.JButton();
        jPanel4_changePassword = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jPasswordField2 = new javax.swing.JPasswordField();
        jLabel5 = new javax.swing.JLabel();
        jPasswordField3 = new javax.swing.JPasswordField();
        jButton3_changePass = new javax.swing.JButton();
        jButton4_cancel = new javax.swing.JButton();
        jScrollPane21 = new javax.swing.JScrollPane();
        jTextPane1 = new javax.swing.JTextPane();
        jPanel3_notification = new javax.swing.JPanel();
        jSeparator1 = new javax.swing.JSeparator();
        jButton2_Close = new javax.swing.JButton();
        jPanel2_Find = new javax.swing.JPanel();
        find_et = new javax.swing.JTextField();
        find_btn = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        alert_jLabel3 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1_Save = new javax.swing.JMenu();
        jMenuItem1_save = new javax.swing.JMenuItem();
        jMenu2_Find = new javax.swing.JMenu();
        jMenuItem2_find = new javax.swing.JMenuItem();
        jMenuItem4_Undo = new javax.swing.JMenuItem();
        jMenuItem5_Redo = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenu1_Tools = new javax.swing.JMenu();
        jMenuItem1_changePassword = new javax.swing.JMenuItem();
        jMenu1_Help = new javax.swing.JMenu();
        jMenuItem2_about = new javax.swing.JMenuItem();

        jMenuItem3.setText("jMenuItem3");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setBackground(new java.awt.Color(243, 247, 255));

        jLabel2.setFont(new java.awt.Font("Britannic Bold", 1, 24)); // NOI18N
        jLabel2.setText("DATA MANAGER");

        jLabel3.setFont(new java.awt.Font("Aharoni", 1, 12)); // NOI18N
        jLabel3.setText("by Mohit Bhavsar");

        jPanel3.setBackground(new java.awt.Color(243, 247, 255));

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 15)); // NOI18N
        jLabel1.setText("Enter Password : ");

        jPasswordField1.setFont(new java.awt.Font("Dialog", 0, 15)); // NOI18N
        jPasswordField1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jPasswordField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jPasswordField1ActionPerformed(evt);
            }
        });

        submit_btn.setFont(new java.awt.Font("Dialog", 1, 15)); // NOI18N
        submit_btn.setText("SUBMIT");
        submit_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submit_btnActionPerformed(evt);
            }
        });
        submit_btn.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                submit_btnKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPasswordField1, javax.swing.GroupLayout.PREFERRED_SIZE, 307, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(submit_btn, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jPasswordField1, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(submit_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel4_changePassword.setBackground(new java.awt.Color(243, 247, 255));

        jLabel4.setFont(new java.awt.Font("Dialog", 1, 15)); // NOI18N
        jLabel4.setText("Old Password :");

        jPasswordField2.setFont(new java.awt.Font("Dialog", 0, 15)); // NOI18N
        jPasswordField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jPasswordField2ActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Dialog", 1, 15)); // NOI18N
        jLabel5.setText("New Password :");

        jPasswordField3.setFont(new java.awt.Font("Dialog", 0, 15)); // NOI18N
        jPasswordField3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jPasswordField3ActionPerformed(evt);
            }
        });

        jButton3_changePass.setText("Change Password");
        jButton3_changePass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3_changePassActionPerformed(evt);
            }
        });

        jButton4_cancel.setText("Cancel");
        jButton4_cancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4_cancelActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4_changePasswordLayout = new javax.swing.GroupLayout(jPanel4_changePassword);
        jPanel4_changePassword.setLayout(jPanel4_changePasswordLayout);
        jPanel4_changePasswordLayout.setHorizontalGroup(
            jPanel4_changePasswordLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4_changePasswordLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4_changePasswordLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(18, 18, 18)
                .addGroup(jPanel4_changePasswordLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel4_changePasswordLayout.createSequentialGroup()
                        .addComponent(jButton4_cancel, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton3_changePass, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jPasswordField3, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPasswordField2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 294, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4_changePasswordLayout.setVerticalGroup(
            jPanel4_changePasswordLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4_changePasswordLayout.createSequentialGroup()
                .addContainerGap(24, Short.MAX_VALUE)
                .addGroup(jPanel4_changePasswordLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jPasswordField2, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4_changePasswordLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jPasswordField3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4_changePasswordLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton3_changePass)
                    .addComponent(jButton4_cancel))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addComponent(jLabel3_logo, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 55, Short.MAX_VALUE)
                .addComponent(jPanel4_changePassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel4_changePassword, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel3))
                    .addComponent(jLabel3_logo, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTextPane1.setFont(new java.awt.Font("Dialog", 1, 22)); // NOI18N
        jTextPane1.setEnabled(false);
        jTextPane1.setMargin(new java.awt.Insets(15, 15, 15, 15));
        jScrollPane21.setViewportView(jTextPane1);

        jPanel3_notification.setBackground(new java.awt.Color(222, 222, 222));
        jPanel3_notification.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                jPanel3_notificationMouseDragged(evt);
            }
        });

        jButton2_Close.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                jButton2_CloseMouseMoved(evt);
            }
        });
        jButton2_Close.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButton2_CloseMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButton2_CloseMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jButton2_CloseMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jButton2_CloseMouseReleased(evt);
            }
        });
        jButton2_Close.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2_CloseActionPerformed(evt);
            }
        });

        jPanel2_Find.setBackground(new java.awt.Color(222, 222, 222));
        jPanel2_Find.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                jPanel2_FindMouseMoved(evt);
            }
        });

        find_et.setFont(new java.awt.Font("Dialog", 1, 22)); // NOI18N
        find_et.setEnabled(false);
        find_et.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                find_etActionPerformed(evt);
            }
        });

        find_btn.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        find_btn.setEnabled(false);
        find_btn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                find_btnMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                find_btnMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                find_btnMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                find_btnMouseReleased(evt);
            }
        });
        find_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                find_btnActionPerformed(evt);
            }
        });

        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButton1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButton1MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jButton1MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jButton1MouseReleased(evt);
            }
        });
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButton2MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButton2MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jButton2MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jButton2MouseReleased(evt);
            }
        });
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2_FindLayout = new javax.swing.GroupLayout(jPanel2_Find);
        jPanel2_Find.setLayout(jPanel2_FindLayout);
        jPanel2_FindLayout.setHorizontalGroup(
            jPanel2_FindLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2_FindLayout.createSequentialGroup()
                .addComponent(find_et, javax.swing.GroupLayout.PREFERRED_SIZE, 302, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(find_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 40, Short.MAX_VALUE))
        );
        jPanel2_FindLayout.setVerticalGroup(
            jPanel2_FindLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2_FindLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(find_et, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addComponent(find_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2_FindLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        alert_jLabel3.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        alert_jLabel3.setForeground(new java.awt.Color(226, 0, 27));
        alert_jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        alert_jLabel3.setText("alert");

        javax.swing.GroupLayout jPanel3_notificationLayout = new javax.swing.GroupLayout(jPanel3_notification);
        jPanel3_notification.setLayout(jPanel3_notificationLayout);
        jPanel3_notificationLayout.setHorizontalGroup(
            jPanel3_notificationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3_notificationLayout.createSequentialGroup()
                .addGap(3, 3, 3)
                .addComponent(jButton2_Close)
                .addGap(18, 18, 18)
                .addComponent(jPanel2_Find, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 657, Short.MAX_VALUE)
                .addComponent(alert_jLabel3)
                .addGap(14, 14, 14))
            .addComponent(jSeparator1)
        );
        jPanel3_notificationLayout.setVerticalGroup(
            jPanel3_notificationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3_notificationLayout.createSequentialGroup()
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel3_notificationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3_notificationLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 16, Short.MAX_VALUE)
                        .addGroup(jPanel3_notificationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(alert_jLabel3, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jPanel2_Find, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap())
                    .addGroup(jPanel3_notificationLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton2_Close, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3_notification, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jScrollPane21, javax.swing.GroupLayout.Alignment.TRAILING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane21, javax.swing.GroupLayout.DEFAULT_SIZE, 268, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3_notification, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jMenu1_Save.setText("File");

        jMenuItem1_save.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        jMenuItem1_save.setText("Save");
        jMenuItem1_save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1_saveActionPerformed(evt);
            }
        });
        jMenu1_Save.add(jMenuItem1_save);

        jMenuBar1.add(jMenu1_Save);

        jMenu2_Find.setText("Edit");

        jMenuItem2_find.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        jMenuItem2_find.setText("Find");
        jMenuItem2_find.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2_findActionPerformed(evt);
            }
        });
        jMenu2_Find.add(jMenuItem2_find);

        jMenuItem4_Undo.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_Z, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        jMenuItem4_Undo.setText("Undo");
        jMenuItem4_Undo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4_UndoActionPerformed(evt);
            }
        });
        jMenu2_Find.add(jMenuItem4_Undo);

        jMenuItem5_Redo.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_Y, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        jMenuItem5_Redo.setText("Redo");
        jMenuItem5_Redo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5_RedoActionPerformed(evt);
            }
        });
        jMenu2_Find.add(jMenuItem5_Redo);

        jMenuItem4.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_ESCAPE, 0));
        jMenuItem4.setText("Escape");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        jMenu2_Find.add(jMenuItem4);

        jMenuBar1.add(jMenu2_Find);

        jMenu1_Tools.setText("Tools");
        jMenu1_Tools.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenu1_ToolsActionPerformed(evt);
            }
        });

        jMenuItem1_changePassword.setText("Change Password");
        jMenuItem1_changePassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1_changePasswordActionPerformed(evt);
            }
        });
        jMenu1_Tools.add(jMenuItem1_changePassword);

        jMenuBar1.add(jMenu1_Tools);

        jMenu1_Help.setText("Help");

        jMenuItem2_about.setText("About");
        jMenuItem2_about.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2_aboutActionPerformed(evt);
            }
        });
        jMenu1_Help.add(jMenuItem2_about);

        jMenuBar1.add(jMenu1_Help);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jPanel2_FindMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel2_FindMouseMoved
        // TODO add your handling code here:
        //jPanel2.setVisible(evt.getY() < 10);
    }//GEN-LAST:event_jPanel2_FindMouseMoved

    private void jMenuItem1_saveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1_saveActionPerformed
        // TODO add your handling code here:
        //Save Data
        String User_Data = jTextPane1.getText();
        String encryptedData = Encrypt_User_Data(User_Data);
        Boolean status = update_User_Data_DB(encryptedData);
        if(status == true){
            alert_jLabel3.setText("Saved...");
            jPanel3_notification.setVisible(true);
            disable_jPanel3_notification_TimeLaps();
        }else{
            
            alert_jLabel3.setText("Error Occured while Saving Data!!!");
            jPanel3_notification.setVisible(true);
            disable_jPanel3_notification_TimeLaps();
            //joptionpane
            JOptionPane.showConfirmDialog(null,"Error Occured while Saving Data!!!", "Unable to Save Data...", JOptionPane.WARNING_MESSAGE);
            JOptionPane.showConfirmDialog(null,"Data Does not Saved!!!", "Error Occured", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_jMenuItem1_saveActionPerformed

    private void jMenuItem2_findActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2_findActionPerformed
        // TODO add your handling code here:
        jPanel3_notification.setVisible(true);
        jPanel2_Find.setVisible(true);
        find_et.requestFocusInWindow();
        find_et.selectAll();
    }//GEN-LAST:event_jMenuItem2_findActionPerformed

    private void jPanel3_notificationMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel3_notificationMouseDragged
        // TODO add your handling code here:
        
    }//GEN-LAST:event_jPanel3_notificationMouseDragged

    private void jButton2_CloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2_CloseActionPerformed
        // TODO add your handling code here:
        jPanel2_Find.setVisible(false);
        jPanel3_notification.setVisible(false);
        removeHighlights(jTextPane1);
        //Search word list
        pos_list.removeAll(pos_list);
        down_up.removeAll(down_up);
    }//GEN-LAST:event_jButton2_CloseActionPerformed

    private void submit_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submit_btnActionPerformed
        // TODO add your handling code here:
        submit_button();
        /*
        String DataDB = get_User_Data_DB(); //receive Data from DB
        if(DataDB.equals("SQL_DATABASE_EXCEPTION")){
            jPanel3.setVisible(true);
            alert_jLabel3.setText("SQL_DATABASE_EXCEPTION");

        }else{
            if(DataDB == null){
                Insert_User_Data_DB();
            }
            DataDB = get_User_Data_DB(); //receive Data from DB

            String decryptedData = Decrypt_User_Data(DataDB);
            if(decryptedData == "!@&#INCORRECT_PASSWORD##@!"){
                jPanel3.setVisible(true);
                alert_jLabel3.setText("INCORRECT PASSWORD!!!");
                jPasswordField1.setText("");
                //jPasswordField1.setFocus();
            }else{
                alert_jLabel3.setText("");
                jPasswordField1.setEnabled(false);
                submit_btn.setEnabled(false);
                jPanel2.setVisible(false);
                jPanel2_Find.setVisible(false);
                jPanel3.setVisible(false);
                //save_btn.setEnabled(true);
                jTextPane1.setEnabled(true);
                find_et.setEnabled(true);
                find_btn.setEnabled(true);
                jTextPane1.setText(decryptedData);
                
                //Undo-Redo Manager==================start
                UndoManager undoManager;

                undoManager = new UndoManager();
                Document doc = jTextPane1.getDocument();
                doc.addUndoableEditListener(new UndoableEditListener() {
                @Override
                public void undoableEditHappened(UndoableEditEvent e) {
                    System.out.println("Add edit");
                    undoManager.addEdit(e.getEdit());
                }
                });

                InputMap im = jTextPane1.getInputMap(JComponent.WHEN_FOCUSED);
                ActionMap am = jTextPane1.getActionMap();

                im.put(KeyStroke.getKeyStroke(KeyEvent.VK_Z, Toolkit.getDefaultToolkit().getMenuShortcutKeyMask()), "Undo");
                im.put(KeyStroke.getKeyStroke(KeyEvent.VK_Y, Toolkit.getDefaultToolkit().getMenuShortcutKeyMask()), "Redo");

                am.put("Undo", new AbstractAction() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        try {
                            if (undoManager.canUndo()) {
                                undoManager.undo();
                            }
                        } catch (CannotUndoException exp) {
                            exp.printStackTrace();
                        }
                    }
                });
                am.put("Redo", new AbstractAction() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        try {
                            if (undoManager.canRedo()) {
                                undoManager.redo();
                            }
                        } catch (CannotUndoException exp) {
                            exp.printStackTrace();
                        }
                    }
                });
                //Undo-Redo Manager==================end

            }
        }
        */
    }//GEN-LAST:event_submit_btnActionPerformed

    private void jPasswordField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jPasswordField1ActionPerformed
        // TODO add your handling code here:
        //submit_btn.requestFocusInWindow(); //focus to submit button
        
        submit_button();
    }//GEN-LAST:event_jPasswordField1ActionPerformed

    private void find_etActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_find_etActionPerformed
        // TODO add your handling code here:
        //find_btn.requestFocusInWindow();
        
        //Enter event to Search
        String search_word = find_et.getText();

        if(search_word.equals("") || search_word=="null"){
            removeHighlights(jTextPane1);
        }else{
            search_highligh_down(jTextPane1, search_word);
        }
    }//GEN-LAST:event_find_etActionPerformed

    private void jMenuItem4_UndoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4_UndoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem4_UndoActionPerformed

    private void submit_btnKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_submit_btnKeyReleased
        // TODO add your handling code here:
        submit_button();
    }//GEN-LAST:event_submit_btnKeyReleased

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        // TODO add your handling code here:
        jPanel2_Find.setVisible(false);
        jPanel3_notification.setVisible(false);
        removeHighlights(jTextPane1);
        //Search word list
        pos_list.removeAll(pos_list);
        down_up.removeAll(down_up);
        
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        String search_word = find_et.getText();
        search_highligh_down(jTextPane1, search_word);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        String search_word = find_et.getText();
        search_highligh_up(jTextPane1, search_word);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void find_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_find_btnActionPerformed
        // TODO add your handling code here:

        //Enter event to Search
        String search_word = find_et.getText();

        if(search_word.equals("") || search_word=="null"){
            removeHighlights(jTextPane1);
        }else{
            search_highligh_down(jTextPane1, search_word);
        }

        //highligh(jTextPane1, search_word);
    }//GEN-LAST:event_find_btnActionPerformed

    private void jButton2_CloseMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2_CloseMouseMoved
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2_CloseMouseMoved

    private void jButton2_CloseMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2_CloseMouseEntered
        // TODO add your handling code here:
        //image resize to set their size auto
        ImageIcon myimage;
        Image img1;
        Image img2;
        ImageIcon format;
        //close icon
        myimage = new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("close_light.png")));
        
        img1 = myimage.getImage();
        img2 = img1.getScaledInstance(jButton2_Close.getWidth(), jButton2_Close.getHeight(), Image.SCALE_SMOOTH);
        format = new ImageIcon(img2);
        jButton2_Close.setIcon(format);
        jButton2_Close.setBorderPainted(false);
        jButton2_Close.setBorder(null);
        jButton2_Close.setMargin(new Insets(0,0,0,0));
        jButton2_Close.setContentAreaFilled(false);
    }//GEN-LAST:event_jButton2_CloseMouseEntered

    private void jButton2_CloseMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2_CloseMouseExited
        // TODO add your handling code here:
        //image resize to set their size auto
        ImageIcon myimage;
        Image img1;
        Image img2;
        ImageIcon format;
        //close icon
        myimage = new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("close.png")));
        
        img1 = myimage.getImage();
        img2 = img1.getScaledInstance(jButton2_Close.getWidth(), jButton2_Close.getHeight(), Image.SCALE_SMOOTH);
        format = new ImageIcon(img2);
        jButton2_Close.setIcon(format);
        jButton2_Close.setBorderPainted(false);
        jButton2_Close.setBorder(null);
        jButton2_Close.setMargin(new Insets(0,0,0,0));
        jButton2_Close.setContentAreaFilled(false);
    }//GEN-LAST:event_jButton2_CloseMouseExited

    private void jButton2_CloseMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2_CloseMousePressed
        // TODO add your handling code here:
        //image resize to set their size auto
        ImageIcon myimage;
        Image img1;
        Image img2;
        ImageIcon format;
        //close icon
        myimage = new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("close_dark.png")));
        
        img1 = myimage.getImage();
        img2 = img1.getScaledInstance(jButton2_Close.getWidth(), jButton2_Close.getHeight(), Image.SCALE_SMOOTH);
        format = new ImageIcon(img2);
        jButton2_Close.setIcon(format);
        jButton2_Close.setBorderPainted(false);
        jButton2_Close.setBorder(null);
        jButton2_Close.setMargin(new Insets(0,0,0,0));
        jButton2_Close.setContentAreaFilled(false);
    }//GEN-LAST:event_jButton2_CloseMousePressed

    private void jButton2_CloseMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2_CloseMouseReleased
        // TODO add your handling code here:
        //image resize to set their size auto
        ImageIcon myimage;
        Image img1;
        Image img2;
        ImageIcon format;
        //close icon
        myimage = new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("close.png")));
        
        img1 = myimage.getImage();
        img2 = img1.getScaledInstance(jButton2_Close.getWidth(), jButton2_Close.getHeight(), Image.SCALE_SMOOTH);
        format = new ImageIcon(img2);
        jButton2_Close.setIcon(format);
        jButton2_Close.setBorderPainted(false);
        jButton2_Close.setBorder(null);
        jButton2_Close.setMargin(new Insets(0,0,0,0));
        jButton2_Close.setContentAreaFilled(false);
    }//GEN-LAST:event_jButton2_CloseMouseReleased

    private void find_btnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_find_btnMouseEntered
        // TODO add your handling code here:
        //image resize to set their size auto
        ImageIcon myimage;
        Image img1;
        Image img2;
        ImageIcon format;
                
        //search icon
        myimage = new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("Search-Icon_light.png")));
        
        img1 = myimage.getImage();
        img2 = img1.getScaledInstance(find_btn.getWidth(), find_btn.getHeight(), Image.SCALE_SMOOTH);
        format = new ImageIcon(img2);
        find_btn.setIcon(format);
        find_btn.setIcon(format);
        find_btn.setBorderPainted(false);
        find_btn.setBorder(null);
        find_btn.setMargin(new Insets(0,0,0,0));
        find_btn.setContentAreaFilled(false);
    }//GEN-LAST:event_find_btnMouseEntered

    private void find_btnMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_find_btnMouseReleased
        // TODO add your handling code here:
        //image resize to set their size auto
        ImageIcon myimage;
        Image img1;
        Image img2;
        ImageIcon format;
                
        //search icon
        myimage = new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("Search-Icon.png")));
        
        img1 = myimage.getImage();
        img2 = img1.getScaledInstance(find_btn.getWidth(), find_btn.getHeight(), Image.SCALE_SMOOTH);
        format = new ImageIcon(img2);
        find_btn.setIcon(format);
        find_btn.setIcon(format);
        find_btn.setBorderPainted(false);
        find_btn.setBorder(null);
        find_btn.setMargin(new Insets(0,0,0,0));
        find_btn.setContentAreaFilled(false);
    }//GEN-LAST:event_find_btnMouseReleased

    private void find_btnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_find_btnMouseExited
        // TODO add your handling code here:
        //image resize to set their size auto
        ImageIcon myimage;
        Image img1;
        Image img2;
        ImageIcon format;
                
        //search icon
        myimage = new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("Search-Icon.png")));
        
        img1 = myimage.getImage();
        img2 = img1.getScaledInstance(find_btn.getWidth(), find_btn.getHeight(), Image.SCALE_SMOOTH);
        format = new ImageIcon(img2);
        find_btn.setIcon(format);
        find_btn.setIcon(format);
        find_btn.setBorderPainted(false);
        find_btn.setBorder(null);
        find_btn.setMargin(new Insets(0,0,0,0));
        find_btn.setContentAreaFilled(false);
    }//GEN-LAST:event_find_btnMouseExited

    private void find_btnMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_find_btnMousePressed
        // TODO add your handling code here:
        //image resize to set their size auto
        ImageIcon myimage;
        Image img1;
        Image img2;
        ImageIcon format;
                
        //search icon
        myimage = new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("Search-Icon_dark.png")));
        
        img1 = myimage.getImage();
        img2 = img1.getScaledInstance(find_btn.getWidth(), find_btn.getHeight(), Image.SCALE_SMOOTH);
        format = new ImageIcon(img2);
        find_btn.setIcon(format);
        find_btn.setIcon(format);
        find_btn.setBorderPainted(false);
        find_btn.setBorder(null);
        find_btn.setMargin(new Insets(0,0,0,0));
        find_btn.setContentAreaFilled(false);
    }//GEN-LAST:event_find_btnMousePressed

    private void jButton2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MouseEntered
        // TODO add your handling code here:
        //image resize to set their size auto
        ImageIcon myimage;
        Image img1;
        Image img2;
        ImageIcon format;
        //find down icon
        myimage = new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("down_round_light.png")));
        
        img1 = myimage.getImage();
        img2 = img1.getScaledInstance(jButton2.getWidth(), jButton2.getHeight(), Image.SCALE_SMOOTH);
        format = new ImageIcon(img2);
        jButton2.setIcon(format);
        jButton2.setBorderPainted(false);
        jButton2.setBorder(null);
        jButton2.setMargin(new Insets(0,0,0,0));
        jButton2.setContentAreaFilled(false);
    }//GEN-LAST:event_jButton2MouseEntered

    private void jButton2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MouseExited
        // TODO add your handling code here:
        //image resize to set their size auto
        ImageIcon myimage;
        Image img1;
        Image img2;
        ImageIcon format;
        //find down icon
        myimage = new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("down_round.png")));
        
        img1 = myimage.getImage();
        img2 = img1.getScaledInstance(jButton2.getWidth(), jButton2.getHeight(), Image.SCALE_SMOOTH);
        format = new ImageIcon(img2);
        jButton2.setIcon(format);
        jButton2.setBorderPainted(false);
        jButton2.setBorder(null);
        jButton2.setMargin(new Insets(0,0,0,0));
        jButton2.setContentAreaFilled(false);
    }//GEN-LAST:event_jButton2MouseExited

    private void jButton2MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MousePressed
        // TODO add your handling code here:
        //image resize to set their size auto
        ImageIcon myimage;
        Image img1;
        Image img2;
        ImageIcon format;
        //find down icon
        myimage = new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("down_round_dark.png")));
        
        img1 = myimage.getImage();
        img2 = img1.getScaledInstance(jButton2.getWidth(), jButton2.getHeight(), Image.SCALE_SMOOTH);
        format = new ImageIcon(img2);
        jButton2.setIcon(format);
        jButton2.setBorderPainted(false);
        jButton2.setBorder(null);
        jButton2.setMargin(new Insets(0,0,0,0));
        jButton2.setContentAreaFilled(false);
    }//GEN-LAST:event_jButton2MousePressed

    private void jButton2MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MouseReleased
        // TODO add your handling code here:
        //image resize to set their size auto
        ImageIcon myimage;
        Image img1;
        Image img2;
        ImageIcon format;
        //find down icon
        myimage = new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("down_round.png")));
        
        img1 = myimage.getImage();
        img2 = img1.getScaledInstance(jButton2.getWidth(), jButton2.getHeight(), Image.SCALE_SMOOTH);
        format = new ImageIcon(img2);
        jButton2.setIcon(format);
        jButton2.setBorderPainted(false);
        jButton2.setBorder(null);
        jButton2.setMargin(new Insets(0,0,0,0));
        jButton2.setContentAreaFilled(false);
    }//GEN-LAST:event_jButton2MouseReleased

    private void jButton1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseEntered
        // TODO add your handling code here:
        //image resize to set their size auto
        ImageIcon myimage;
        Image img1;
        Image img2;
        ImageIcon format;
        //find up icon
        myimage = new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("up_round_light.png")));
        
        img1 = myimage.getImage();
        img2 = img1.getScaledInstance(jButton1.getWidth(), jButton1.getHeight(), Image.SCALE_SMOOTH);
        format = new ImageIcon(img2);
        jButton1.setIcon(format);
        jButton1.setBorderPainted(false);
        jButton1.setBorder(null);
        jButton1.setMargin(new Insets(0,0,0,0));
        jButton1.setContentAreaFilled(false);
    }//GEN-LAST:event_jButton1MouseEntered

    private void jButton1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseExited
        // TODO add your handling code here:
        //image resize to set their size auto
        ImageIcon myimage;
        Image img1;
        Image img2;
        ImageIcon format;
        //find up icon
        myimage = new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("up_round.png")));
        
        img1 = myimage.getImage();
        img2 = img1.getScaledInstance(jButton1.getWidth(), jButton1.getHeight(), Image.SCALE_SMOOTH);
        format = new ImageIcon(img2);
        jButton1.setIcon(format);
        jButton1.setBorderPainted(false);
        jButton1.setBorder(null);
        jButton1.setMargin(new Insets(0,0,0,0));
        jButton1.setContentAreaFilled(false);
    }//GEN-LAST:event_jButton1MouseExited

    private void jButton1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MousePressed
        // TODO add your handling code here:
        //image resize to set their size auto
        ImageIcon myimage;
        Image img1;
        Image img2;
        ImageIcon format;
        //find up icon
        myimage = new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("up_round_dark.png")));
        
        img1 = myimage.getImage();
        img2 = img1.getScaledInstance(jButton1.getWidth(), jButton1.getHeight(), Image.SCALE_SMOOTH);
        format = new ImageIcon(img2);
        jButton1.setIcon(format);
        jButton1.setBorderPainted(false);
        jButton1.setBorder(null);
        jButton1.setMargin(new Insets(0,0,0,0));
        jButton1.setContentAreaFilled(false);
    }//GEN-LAST:event_jButton1MousePressed

    private void jButton1MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseReleased
        // TODO add your handling code here:
        //image resize to set their size auto
        ImageIcon myimage;
        Image img1;
        Image img2;
        ImageIcon format;
        //find up icon
        myimage = new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("up_round.png")));
        
        img1 = myimage.getImage();
        img2 = img1.getScaledInstance(jButton1.getWidth(), jButton1.getHeight(), Image.SCALE_SMOOTH);
        format = new ImageIcon(img2);
        jButton1.setIcon(format);
        jButton1.setBorderPainted(false);
        jButton1.setBorder(null);
        jButton1.setMargin(new Insets(0,0,0,0));
        jButton1.setContentAreaFilled(false);
    }//GEN-LAST:event_jButton1MouseReleased

    private void jMenuItem1_changePasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1_changePasswordActionPerformed
        // TODO add your handling code here:
        jPasswordField2.setText("");
        jPasswordField3.setText("");
        jPanel3.setVisible(false);
        jPanel2.setVisible(true);
        alert_jLabel3.setText("");
        jPasswordField2.setEnabled(true);
        jPasswordField3.setEnabled(true);
        jButton3_changePass.setEnabled(true);
        jPanel4_changePassword.setVisible(true);
        jPanel2_Find.setVisible(false);
        jPanel3_notification.setVisible(false);
        //save_btn.setEnabled(true);
        jTextPane1.setEnabled(false);
        find_et.setEnabled(false);
        find_btn.setEnabled(false);

        //Enable All Features
        //jPanel3.setVisible(true);
        jMenu1_Save.setEnabled(false);
        jMenu2_Find.setEnabled(false);
        jMenu1_Tools.setEnabled(false);
        //jMenu1_Help.setEnabled(false);
    }//GEN-LAST:event_jMenuItem1_changePasswordActionPerformed

    private void jMenuItem2_aboutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2_aboutActionPerformed
        // TODO add your handling code here:
        //show pop up show about data
        //JOptionPane.showConfirmDialog(null,"'Data Manager' is a very Powerful Software to Store Credentials/Data.\n\n Software Details:\n* It Uses Standard Encryption Algorithm to Encrypt Data.\n* Store Data with Secure End to End Encryption.\n* Uses Powerful Database Algorithms to Store Data.\n\nSoftware Developer:- Mohit Manish Bhavsar.\nRELIGION INDIA\n\nFollow us on Instagram: https://www.instagram.com/__space_walker_____/<html><a href=\\\"http://google.com/\\\">a link</a></html> \nFollow us on Twitter: LINK_AVAILABLE_AS_SOON_AS_POSSIBLE", "About", JOptionPane.WARNING_MESSAGE);
        JOptionPane.showConfirmDialog(null,"Secure Data with 'DATA MANAGER'\n\n Software Details:\n*  It Uses Standard Encryption Algorithm to Encrypt Data.\n*  Store Data with Secure End to End Encryption.\n*  Uses Powerful Database Algorithms to Store Data.\n\nSoftware Developer:- Mohit Manish Bhavsar.\nRELIGION INDIA\n\nDonate Us on PhonePe/GooglePay : 8180992103", "About", JOptionPane.WARNING_MESSAGE);
    }//GEN-LAST:event_jMenuItem2_aboutActionPerformed

    private void jButton3_changePassActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3_changePassActionPerformed
        // TODO add your handling code here:
        
        //old password
        char[] jPass_old = jPasswordField2.getPassword();
        String p_old = String.valueOf(jPass_old);
        
        //new password
        char[] jPass_new = jPasswordField3.getPassword();
        String p_new = String.valueOf(jPass_new);
        
        
        //receive data from database
        
        if("".equals(p_old)){
            alert_jLabel3.setText("Please Enter Valid Password!!!");
            jPanel3_notification.setVisible(true);
            disable_jPanel3_notification_TimeLaps();
        }else if("".equals(p_new)){
            alert_jLabel3.setText("Please Enter Valid Password!!!");
            jPanel3_notification.setVisible(true);
            disable_jPanel3_notification_TimeLaps();
        }
        else{
            String DataDB = get_User_Data_DB(); //receive Data from DB
            if(DataDB == null){
                alert_jLabel3.setText("Unable to Find Database!!!");
                disable_jPanel3_notification_TimeLaps();
                }
            else if(DataDB.equals("SQL_DATABASE_EXCEPTION")){
                alert_jLabel3.setText("SQL_DATABASE_EXCEPTION");
                jPanel3_notification.setVisible(true);
                disable_jPanel3_notification_TimeLaps();
            }else if(DataDB.equals("CLASS_NOT_FOUND_EXCEPTION")){
                alert_jLabel3.setText("CLASS_NOT_FOUND_EXCEPTION");
                jPanel3_notification.setVisible(true);
                disable_jPanel3_notification_TimeLaps();
            }else if(DataDB.equals("IOEXCEPTION")){
                alert_jLabel3.setText("IOEXCEPTION_CANNOT_CREATE_DATABASE");
                jPanel3_notification.setVisible(true);
                disable_jPanel3_notification_TimeLaps();
            }
            else{

                DataDB = get_User_Data_DB(); //receive Data from DB
                String decrypt_p_main = decrypt_p;
                //System.out.println("old password main:"+decrypt_p);
                //set password variable
                char[] jPass = jPasswordField2.getPassword();
                decrypt_p = String.valueOf(jPass);

                String decryptedData = Decrypt_User_Data(DataDB);
                if(decryptedData == "!@&#INCORRECT_PASSWORD##@!"){
                    //set old main password to password variable
                    decrypt_p = decrypt_p_main;
                    jPanel3_notification.setVisible(true);
                    alert_jLabel3.setText("INCORRECT OLD PASSWORD!!!");
                    jPasswordField1.setText("");
                    disable_jPanel3_notification_TimeLaps();
                    jPasswordField3.setText("");
                    jPasswordField2.setText("");
                    //jPasswordField1.setFocus();
                    
                }else if(decryptedData == null){
                //set old main password to password variable
                    decrypt_p = decrypt_p_main;
                    jPasswordField3.setText("");
                    jPasswordField2.setText("");}
                
                else{
                    jPass = jPasswordField3.getPassword();
                    decrypt_p = String.valueOf(jPass);
                    
                    
                //}
                    
                    //Save Data
                    String User_Data = jTextPane1.getText();
                    String encryptedData = Encrypt_User_Data(User_Data);
                    Boolean status = update_User_Data_DB(encryptedData);
                    if(status == true){
                        jPanel2.setVisible(false);
                        alert_jLabel3.setText("Saved...");
                        jPanel3_notification.setVisible(true);
                        disable_jPanel3_notification_TimeLaps();
                        //alert_jLabel3.setText("");
                    jPasswordField2.setEnabled(false);
                    jPasswordField3.setEnabled(false);
                    jButton3_changePass.setEnabled(false);
                    jPanel4_changePassword.setVisible(false);
                    jPanel2_Find.setVisible(false);
                    //jPanel3_notification.setVisible(false);
                    //save_btn.setEnabled(true);
                    jTextPane1.setEnabled(true);
                    find_et.setEnabled(true);
                    find_btn.setEnabled(true);
                    
                    //Enable All Features
                    //jPanel3.setVisible(true);
                    jMenu1_Save.setEnabled(true);
                    jMenu2_Find.setEnabled(true);
                    jMenu1_Tools.setEnabled(true);
                    //jMenu1_Help.setEnabled(true);

                    jPasswordField3.setText("");
                    jPasswordField2.setText("");
                    }else{
                        alert_jLabel3.setText("Error Occured while Saving Data!!!");
                        jPanel3_notification.setVisible(true);
                        disable_jPanel3_notification_TimeLaps();
                        JOptionPane.showConfirmDialog(null,"Data Does not Saved!!!", "Error Occured", JOptionPane.ERROR);
                    }
                    System.out.println("Done");
                    
                    
                    
                }
            }
        }
        
    }//GEN-LAST:event_jButton3_changePassActionPerformed

    private void jButton4_cancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4_cancelActionPerformed
        // TODO add your handling code here:
        alert_jLabel3.setText("");
        jPasswordField2.setEnabled(false);
        jPasswordField3.setEnabled(false);
        jButton3_changePass.setEnabled(false);
        jPanel4_changePassword.setVisible(false);
        jPanel2_Find.setVisible(false);
        jPanel2.setVisible(false);
        jPanel3_notification.setVisible(false);
        //save_btn.setEnabled(true);
        jTextPane1.setEnabled(true);
        find_et.setEnabled(true);
        find_btn.setEnabled(true);

        //Enable All Features
        //jPanel3.setVisible(true);
        jMenu1_Save.setEnabled(true);
        jMenu2_Find.setEnabled(true);
        jMenu1_Tools.setEnabled(true);
        //jMenu1_Help.setEnabled(true);
    }//GEN-LAST:event_jButton4_cancelActionPerformed

    private void jMenu1_ToolsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenu1_ToolsActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenu1_ToolsActionPerformed

    private void jPasswordField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jPasswordField2ActionPerformed
        // TODO add your handling code here:
        jPasswordField3.requestFocusInWindow();
    }//GEN-LAST:event_jPasswordField2ActionPerformed

    private void jPasswordField3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jPasswordField3ActionPerformed
        // TODO add your handling code here:
        jButton3_changePass.requestFocusInWindow();
    }//GEN-LAST:event_jPasswordField3ActionPerformed

    private void jMenuItem5_RedoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5_RedoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem5_RedoActionPerformed

    void disable_jPanel3_notification_TimeLaps(){
        //set visible=false after some time (1 seconds)
            new java.util.Timer().schedule(
                new java.util.TimerTask(){
                    @Override
                    public void run(){
                        jPanel3_notification.setVisible(false);
                        jPanel2_Find.setVisible(false);
                        removeHighlights(jTextPane1);
                        alert_jLabel3.setText("");
                    }
                        
                },
                1000
            );
    }
    
    //GLOBAL VARIABLES
    //Search word Array
    List<Integer> pos_list = new ArrayList<Integer>();
    //down=0, up=1
    List<Integer> down_up = new ArrayList<Integer>();
    //Password Decrypt
    String decrypt_p = null;
    
    
    //search highlight function
    //add Highlight search next
    public void search_highligh_down(JTextComponent textComp, String pattern){
        Highlighter.HighlightPainter myHighlightPainterCyan = new DefaultHighlighter.DefaultHighlightPainter( Color.cyan ); //cyan
        //Highlighter.HighlightPainter myHighlightPainterRed = new DefaultHighlighter.DefaultHighlightPainter( Color.red ); //red
    
        //if list is empty add 0
        if((pos_list.size()-1) == -1){
            pos_list.add(0);
        }
        
        removeHighlights(textComp);
        try{
           Highlighter hilite  = textComp.getHighlighter();
           Document doc = textComp.getDocument();
           String text = doc.getText(0,doc.getLength());
           
           int pos = pos_list.get(pos_list.size()-1);
           //System.out.println(pos_list.size()-1);
           int i = 0;
           
           //Manage down-up search/find
           try{
                if(down_up.get(down_up.size()-1) == 1){
                    //add
                    if(pos_list.size() != 1){
                        if((pos=text.toUpperCase().indexOf(pattern.toUpperCase(),pos))>=0){
                             pos += pattern.length();
                        }pos_list.add(pos);
                    }
                     

                     //add
                    if((pos=text.toUpperCase().indexOf(pattern.toUpperCase(),pos))>=0){
                         pos += pattern.length();
                         System.out.println("pos12=="+pos);
                     }
                     pos_list.add(pos);
                }
           }catch(Exception e){}
             
           
           //manage up-down find/search
           //if(down_up.get(pos_list.size()-1) == 1){
           //    pos_list.add(pos);
           //    pos_list.add(pos);
           //}
           
           /*while((pos=text.toUpperCase().indexOf(pattern.toUpperCase(),pos))>=0){
               hilite.addHighlight(pos,pos+pattern.length(),myHighlightPainterCyan);
               pos += pattern.length();
               //jTextPane1.setSelectionStart(pos);
               //jTextPane1.setSelectionEnd(pos+pattern.length());
               //jTextPane1.setCaretPosition(pos);
               
               //POS[i] = pos;
               //POS_PATTERN[i] = pos+pattern.length();
               
               i++;
               
           }*/
           if((pos=text.toUpperCase().indexOf(pattern.toUpperCase(),pos))>=0){
               
               //System.out.println("pos=="+pos);
               hilite.addHighlight(pos,pos+pattern.length(),myHighlightPainterCyan);
               jTextPane1.setSelectionStart(pos);
               jTextPane1.setSelectionEnd(pos+pattern.length());
               
               pos += pattern.length();
               
               //System.out.println("pos12=="+pos);
           }
           pos_list.add(pos);
           down_up.add(0);
           //System.out.println(pos_list);
           
           //System.out.println(down_up);
           
           
           
           
           
           
       }catch(Exception e){
           System.out.println(e);
       }
    }
    //add Highlight search next
    public void search_highligh_up(JTextComponent textComp, String pattern){
        Highlighter.HighlightPainter myHighlightPainterCyan = new DefaultHighlighter.DefaultHighlightPainter( Color.cyan ); //cyan
        //Highlighter.HighlightPainter myHighlightPainterRed = new DefaultHighlighter.DefaultHighlightPainter( Color.red ); //red
    
        removeHighlights(textComp);
        try{
           Highlighter hilite  = textComp.getHighlighter();
           Document doc = textComp.getDocument();
           String text = doc.getText(0,doc.getLength());
           
           
           //System.out.println("01last="+down_up.get(down_up.size()-1));
           //Manage down-up search/find
           if(down_up.get(down_up.size()-1) == 0){
               pos_list.remove(pos_list.size()-1);
               pos_list.remove(pos_list.size()-1);
           }
           
           int pos = pos_list.get(pos_list.size()-1);
           int i = 0;
           
           
           
           /*while((pos=text.toUpperCase().indexOf(pattern.toUpperCase(),pos))>=0){
               hilite.addHighlight(pos,pos+pattern.length(),myHighlightPainterCyan);
               pos += pattern.length();
               //jTextPane1.setSelectionStart(pos);
               //jTextPane1.setSelectionEnd(pos+pattern.length());
               //jTextPane1.setCaretPosition(pos);
               
               //POS[i] = pos;
               //POS_PATTERN[i] = pos+pattern.length();
               
               i++;
               
           }*/
           if((pos=text.toUpperCase().indexOf(pattern.toUpperCase(),pos))>=0){
               
               
           
               hilite.addHighlight(pos,pos+pattern.length(),myHighlightPainterCyan);
               jTextPane1.setSelectionStart(pos);
               jTextPane1.setSelectionEnd(pos+pattern.length());
               
               //pos += pattern.length();
           }
           
           pos_list.remove(pos_list.size()-1);
           down_up.add(1);
           
           
           
       }catch(Exception e){
           System.out.println(e);
       }
    }
    
    
    
    /*
    //point Highlight
    public void pointHighlights(JTextComponent textComp){
        Highlighter hilite  = textComp.getHighlighter();
        Highlighter.Highlight[] hilites  = hilite.getHighlights();
        
        for(int i=0; i<hilites.length;i++){
            if(hilites[i].getPainter() instanceof HighlightPainter){
                hilite.removeHighlight(hilites[i]);
                
                //jTextPane1.setCaretPosition(hilites[i]);
            }
        }
    }
    */
    
    //remove Highlight
    public void removeHighlights(JTextComponent textComp){
        Highlighter hilite  = textComp.getHighlighter();
        Highlighter.Highlight[] hilites  = hilite.getHighlights();
        
        for(int i=0; i<hilites.length;i++){
            if(hilites[i].getPainter() instanceof HighlightPainter){
                hilite.removeHighlight(hilites[i]);
                
            }
        }
    }
    
    //Insert Data from DB for first time
    public String Insert_User_Data_DB(){
        ////////////Database
        Connection con = null;
        Statement st = null;
        //ResultSet rs = null;
        String Data = null;
        
        String encryptedData = Encrypt_User_Data("______WELCOME______\n\n");

        String url = "jdbc:sqlite:DManager.db";
        String query = "INSERT INTO DATA (ID,USER_DATA) VALUES (0,'"+encryptedData+"')";
        //String url1 = "jdbc:derby://localhost:1527/Shop Management System";
        try{
            Class.forName("org.sqlite.JDBC");
            con = DriverManager.getConnection(url);
            st=con.createStatement();
            st.executeUpdate(query);
            //st=con.createStatement();
            //rs = st.executeQuery(query);
          
            
            //rs.close();
            st.close();
            con.close();
                                 
        }
        catch(SQLException e){
            e.printStackTrace();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(GUI_Data_Manager.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return Data;
    }

    //receive Data from DB
    public String get_User_Data_DB(){
        ////////////Database
        Connection con = null;
        Statement st = null;
        ResultSet rs = null;
        String Data = null;
        
        String table_name = "DATA";

        String url = "jdbc:sqlite:DManager.db";
        String query = "select * from DATA;";
        String table_create_query = "CREATE TABLE IF NOT EXISTS " +
                    table_name +
                    "(ID INTEGER PRIMARY KEY ,USER_DATA TEXT NOT NULL)";
        //String url1 = "jdbc:derby://localhost:1527/Shop Management System";
        try{
            //Create DManager.db file if not Exists
            File myFile = new File("DManager.db");
            myFile.createNewFile(); //if already exists do nothing
            //FileOutputStream oFile = new FileOutputStream(myFile,false);
            
            
            Class.forName("org.sqlite.JDBC");
            con = DriverManager.getConnection(url);
            st=con.createStatement();
            //st.executeUpdate(query);
            //st=con.createStatement();
            
            //Create Table if not exists
            st.executeUpdate(table_create_query);
            //System.out.println("table created");
            
            //Execute Query (Request DATA)
            rs = st.executeQuery(query);
            //System.out.println("executed query rs="+rs);
            
            while(rs.next())
            {
                Data = rs.getString("USER_DATA");
                //System.out.println("DATArs="+Data);
                //Data=rs.getString("USER_DATA");
            }	
            
            
            //System.out.println("DATA="+Data);
            
            st.close();
            con.close();
            rs.close();
                                 
        }
        catch(SQLException e){
            e.printStackTrace();
            Data = "SQL_DATABASE_EXCEPTION";
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(GUI_Data_Manager.class.getName()).log(Level.SEVERE, null, ex);
            Data = "CLASS_NOT_FOUND_EXCEPTION";
            
        } catch (IOException ex) {
            Logger.getLogger(GUI_Data_Manager.class.getName()).log(Level.SEVERE, null, ex);
            Data = "IOEXCEPTION"; //file creation exception
        }
        
        return Data;
    }
    
    //Update Data to DB
    public Boolean update_User_Data_DB(String EData){
        ////////////Database
        Connection con = null;
        Statement st = null;
        //ResultSet rs = null;
        Boolean status = false;

        
        
        String url = "jdbc:sqlite:DManager.db";
        //String query = "select USER_DATA from DATA";
        String query = "UPDATE DATA SET USER_DATA = '"+EData+"' WHERE ID = 0";
        
        //String url1 = "jdbc:derby://localhost:1527/Shop Management System";
        try{
            Class.forName("org.sqlite.JDBC");
            con = DriverManager.getConnection(url);
            st=con.createStatement();
            //st=con.createStatement();
            //rs = st.executeQuery(query);
            
            
            st.executeUpdate(query);
            		
            //rs.close();
            st.close();
            con.close();
            status = true;
                                    
            
        }
        catch(SQLException e){
            e.printStackTrace();
            jPanel3_notification.setVisible(true);
            alert_jLabel3.setText("Error while Saving...");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(GUI_Data_Manager.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return status;
    }
    
    //Encrypt User Data
    public String Encrypt_User_Data(String User_Data){
//        char[] jPass = jPasswordField1.getPassword();
//        String p = String.valueOf(jPass);
        String encryptedString = AES.encrypt(User_Data, decrypt_p) ;
        
        return encryptedString;
    }

    //Decrypt User Data
    public String Decrypt_User_Data(String DataDB){
        //get password from jpasswordField1
        //char[] jPass = jPasswordField1.getPassword();
        //String p = String.valueOf(jPass);
        String decryptedData = AES.decrypt(DataDB, decrypt_p) ;
        
        return decryptedData;
    }
    
    
    //Submit Button Verify,decrypt_DB,allow_access
    void submit_button(){
        char[] jPass = jPasswordField1.getPassword();
        decrypt_p = String.valueOf(jPass);
        
        
        if("".equals(decrypt_p)){
            alert_jLabel3.setText("Please Enter Valid Password!!!");
            jPanel3_notification.setVisible(true);
            disable_jPanel3_notification_TimeLaps();
        }else if(decrypt_p == null){
            alert_jLabel3.setText("Please Enter Valid Password!!!");
            jPanel3_notification.setVisible(true);
            disable_jPanel3_notification_TimeLaps();
        }else{

            String DataDB = get_User_Data_DB(); //receive Data from DB
            if(DataDB == null){
                alert_jLabel3.setText("Unable to Find Database!!!");
                disable_jPanel3_notification_TimeLaps();
               
                //joptionpane
                int confirmed = JOptionPane.showConfirmDialog(null,"Do you wan't to Create a New Database with Recently typed Password?", "Unable to Find Database...", JOptionPane.YES_NO_OPTION);
                if(confirmed == JOptionPane.YES_OPTION){
                    //Create Database
                    Insert_User_Data_DB();
                    alert_jLabel3.setText("DATABASE CREATED SUCCESSFULLY!!!");
                    jPasswordField1.setText("");
                    jPanel3_notification.setVisible(true);
                    disable_jPanel3_notification_TimeLaps();
                    //set text for login database
                    jLabel1.setText("Enter Password : ");
                    submit_btn.setText("SUBMIT");
                }else{
                    alert_jLabel3.setText("Unable to Find Database!!!");
                    jPanel3_notification.setVisible(true);
                    disable_jPanel3_notification_TimeLaps();
                }
                
                }
            else if(DataDB.equals("SQL_DATABASE_EXCEPTION")){
                alert_jLabel3.setText("SQL_DATABASE_EXCEPTION");
                jPanel3_notification.setVisible(true);
                disable_jPanel3_notification_TimeLaps();
            }else if(DataDB.equals("CLASS_NOT_FOUND_EXCEPTION")){
                alert_jLabel3.setText("CLASS_NOT_FOUND_EXCEPTION");
                jPanel3_notification.setVisible(true);
                disable_jPanel3_notification_TimeLaps();
            }else if(DataDB.equals("IOEXCEPTION")){
                alert_jLabel3.setText("IOEXCEPTION_CANNOT_CREATE_DATABASE");
                jPanel3_notification.setVisible(true);
                disable_jPanel3_notification_TimeLaps();
            }
            else{

                //DataDB = get_User_Data_DB(); //receive Data from DB

                String decryptedData = Decrypt_User_Data(DataDB);
                if(decryptedData == "!@&#INCORRECT_PASSWORD##@!"){
                    jPanel3_notification.setVisible(true);
                    alert_jLabel3.setText("INCORRECT PASSWORD!!!");
                    jPasswordField1.setText("");
                    disable_jPanel3_notification_TimeLaps();
                    //jPasswordField1.setFocus();
                }
                else if(decryptedData == null){}
                else{
                    alert_jLabel3.setText("");
                    jPasswordField1.setEnabled(false);
                    submit_btn.setEnabled(false);
                    jPanel2.setVisible(false);
                    jPanel2_Find.setVisible(false);
                    jPanel3_notification.setVisible(false);
                    //save_btn.setEnabled(true);
                    jTextPane1.setEnabled(true);
                    find_et.setEnabled(true);
                    find_btn.setEnabled(true);
                    jTextPane1.setText(decryptedData);
                    
                    //Window Close Listener for Save
                    addWindowListener(new WindowAdapter(){
                        public void windowClosing(WindowEvent e){
                            int confirmed = JOptionPane.showConfirmDialog(null,"Do you wan't to Save Data before Exit?", "Exit Program Message Box", JOptionPane.YES_NO_OPTION);
                            
                            if(confirmed == JOptionPane.YES_OPTION){
                                //Save Data
                                String User_Data = jTextPane1.getText();
                                String encryptedData = Encrypt_User_Data(User_Data);
                                Boolean status = update_User_Data_DB(encryptedData);
                                if(status == true){
                                    alert_jLabel3.setText("Saved...");
                                    jPanel3_notification.setVisible(true);
                                    disable_jPanel3_notification_TimeLaps();
                                    dispose(); //close program
                                }else{
                                    alert_jLabel3.setText("Error Occured while Saving Data!!!");
                                    jPanel3_notification.setVisible(true);
                                    disable_jPanel3_notification_TimeLaps();
                                    JOptionPane.showConfirmDialog(null,"Data Does not Saved!!!", "Error Occured", JOptionPane.ERROR);
                                }
                                
                            }
                        }
                    });

                    //Enable All Features
                    //jPanel3.setVisible(true);
                    jMenu1_Save.setEnabled(true);
                    jMenu2_Find.setEnabled(true);
                    jMenu1_Tools.setEnabled(true);

                    //Undo-Redo Manager==================start
                    UndoManager undoManager;

                    undoManager = new UndoManager();
                    Document doc = jTextPane1.getDocument();
                    doc.addUndoableEditListener(new UndoableEditListener() {
                    @Override
                    public void undoableEditHappened(UndoableEditEvent e) {
                        System.out.println("Add edit");
                        undoManager.addEdit(e.getEdit());
                    }
                    });

                    InputMap im = jTextPane1.getInputMap(JComponent.WHEN_FOCUSED);
                    ActionMap am = jTextPane1.getActionMap();

                    im.put(KeyStroke.getKeyStroke(KeyEvent.VK_Z, Toolkit.getDefaultToolkit().getMenuShortcutKeyMask()), "Undo");
                    im.put(KeyStroke.getKeyStroke(KeyEvent.VK_Y, Toolkit.getDefaultToolkit().getMenuShortcutKeyMask()), "Redo");

                    am.put("Undo", new AbstractAction() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            try {
                                if (undoManager.canUndo()) {
                                    undoManager.undo();
                                }
                            } catch (CannotUndoException exp) {
                                exp.printStackTrace();
                            }
                        }
                    });
                    am.put("Redo", new AbstractAction() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            try {
                                if (undoManager.canRedo()) {
                                    undoManager.redo();
                                }
                            } catch (CannotUndoException exp) {
                                exp.printStackTrace();
                            }
                        }
                    });
                    //Undo-Redo Manager==================end

                }
            }
        }
    }
        
    
    public static void main(String args[]) {
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {                
                new GUI_Data_Manager().setVisible(true);
                
                
                
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel alert_jLabel3;
    private static javax.swing.JButton find_btn;
    private static javax.swing.JTextField find_et;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton2_Close;
    private javax.swing.JButton jButton3_changePass;
    private javax.swing.JButton jButton4_cancel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel3_logo;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JMenu jMenu1_Help;
    private javax.swing.JMenu jMenu1_Save;
    private javax.swing.JMenu jMenu1_Tools;
    private javax.swing.JMenu jMenu2_Find;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1_changePassword;
    private javax.swing.JMenuItem jMenuItem1_save;
    private javax.swing.JMenuItem jMenuItem2_about;
    private javax.swing.JMenuItem jMenuItem2_find;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem4_Undo;
    private javax.swing.JMenuItem jMenuItem5_Redo;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel2_Find;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel3_notification;
    private javax.swing.JPanel jPanel4_changePassword;
    private javax.swing.JPasswordField jPasswordField1;
    private javax.swing.JPasswordField jPasswordField2;
    private javax.swing.JPasswordField jPasswordField3;
    private javax.swing.JScrollPane jScrollPane21;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextPane jTextPane1;
    private javax.swing.JButton submit_btn;
    // End of variables declaration//GEN-END:variables
}
