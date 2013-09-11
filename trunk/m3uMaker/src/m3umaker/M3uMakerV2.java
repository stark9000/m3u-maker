/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package m3umaker;

import com.sun.awt.AWTUtilities;
import java.awt.Desktop;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.MenuItem;
import java.awt.PopupMenu;
import java.awt.Shape;
import java.awt.SystemTray;
import java.awt.TrayIcon;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.RoundRectangle2D;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 *
 * @author xyBerWise
 */
public class M3uMakerV2 extends javax.swing.JFrame {

    private TrayIcon trayIcon;
    private SystemTray tray;
    private Dimension oldDimensions;
    private Dimension newDimensions;
    private ComponentMover cm;
    private boolean shapeR = true;
    private JFileChooser jfdir;
    private String dirp;
    private exFiles exf;
    private boolean autoName = true;
    private JFileChooser _jfdir;
    private String _dirp;
    private final String junk = "m3u";
    private boolean Only = true;
    private String Fname;
    private boolean sdIr = true;
    public static List<File> files0 = null;

    /**
     * Creates new form M3uMakerV2
     */
    public M3uMakerV2() {
        initComponents();
        Cinit();
    }

    public final void Cinit() {
        cm = new ComponentMover(this, jLabel1);
        oldDimensions = new Dimension();
        if (shapeR != false) {
            setSahpe();
        }
        ImageIcon icon = new ImageIcon(this.getClass().getResource("/img/_Mi.png"));
        this.setIconImage(icon.getImage());
        jfdir = new JFileChooser();
        _jfdir = new JFileChooser();
        exf = new exFiles();
        jCheckBox2.setSelected(true);
        jCheckBox3.setSelected(true);
        jTextField2.setEnabled(false);
        jTextField3.setEnabled(false);

    }

    public final void setSahpe() {
        try {
            Shape shape = (Shape) new RoundRectangle2D.Float(0, 0, this.getWidth(), this.getHeight(), 5, 5);
            AWTUtilities.setWindowShape(this, shape);

        } catch (Exception e) {
            shapeR = false;
        }
    }

    public void toTray() {
        if (SystemTray.isSupported()) {
            oldDimensions = this.getSize();
            newDimensions = new Dimension(0, 0);
            try {
                tray = SystemTray.getSystemTray();

                ActionListener exitListener = new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {

                        fromTray();
                        tray.remove(trayIcon);
                    }
                };

                PopupMenu popup = new PopupMenu();
                popup.setFont(new Font(this.getFont().getName(), Font.PLAIN, 11));
                MenuItem defaultItem = new MenuItem("Show");

                defaultItem.addActionListener(exitListener);
                popup.add(defaultItem);
                defaultItem = new MenuItem("Exit");

                defaultItem.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        System.exit(0);
                    }
                });
                ImageIcon icon = new ImageIcon(this.getClass().getResource("/img/_Mi.png"));
                popup.add(defaultItem);
                trayIcon = new TrayIcon(icon.getImage(), "M3uMakerV2", popup);
                trayIcon.setImageAutoSize(true);
                tray.add(trayIcon);
                trayIcon.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent evt) {
                        if (evt.getModifiers() == MouseEvent.BUTTON1_MASK) {
                            if (evt.getClickCount() > 1) {
                                fromTray();
                                tray.remove(trayIcon);
                            }
                        }
                    }
                });
            } catch (Exception e) {
                System.out.println("" + e);
                JOptionPane.showMessageDialog(null, "error");
                System.exit(0);
            }
            this.setSize(newDimensions);
            this.setVisible(false);
        } else {
            System.out.println("dsdsrfff");
        }
    }

    public void fromTray() {
        this.setSize(oldDimensions);
        this.setVisible(true);
    }

    public String uniqFname() {
        File f = null;
        try {
            f = File.createTempFile(junk, null, new File("/"));
            f.delete();
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }

        return f.getName();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox();
        jButton2 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jCheckBox1 = new javax.swing.JCheckBox();
        jButton5 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jButton6 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jCheckBox2 = new javax.swing.JCheckBox();
        jCheckBox3 = new javax.swing.JCheckBox();
        jCheckBox4 = new javax.swing.JCheckBox();
        jTextField3 = new javax.swing.JTextField();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jButton10 = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jButton11 = new javax.swing.JButton();
        jButton12 = new javax.swing.JButton();
        jButton13 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("M3uMakerV2");
        setUndecorated(true);
        setResizable(false);
        getContentPane().setLayout(new javax.swing.BoxLayout(getContentPane(), javax.swing.BoxLayout.LINE_AXIS));

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/_6.png"))); // NOI18N
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 10, -1, -1));

        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/_7.png"))); // NOI18N
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 10, -1, -1));

        jTabbedPane1.setForeground(new java.awt.Color(102, 153, 255));

        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setForeground(new java.awt.Color(102, 153, 255));
        jLabel2.setText("Media Folder :");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, 20));

        jTextField1.setEditable(false);
        jTextField1.setForeground(new java.awt.Color(102, 153, 255));
        jPanel2.add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 10, 260, -1));

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/_4.png"))); // NOI18N
        jButton1.setText("open");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 8, -1, -1));

        jLabel3.setForeground(new java.awt.Color(102, 153, 255));
        jLabel3.setText("Only :");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(49, 40, -1, 20));

        jComboBox1.setForeground(new java.awt.Color(102, 153, 255));
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "mp3", "wma", "flac", "aac", "amr", "m4a", "m4r", "ogg", "wav", "wavepack", "wma", "flac", "aac", "amr", "m4a", "m4r", "ogg", "wav", "wavepack", "avi", "flv", "mp4", "wmv", "3gp", "rmvb", "mkv", "mpg", "vob", "mov" }));
        jComboBox1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jComboBox1MouseClicked(evt);
            }
        });
        jPanel2.add(jComboBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 40, 110, -1));

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/_8.png"))); // NOI18N
        jButton2.setText("Settings");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 38, -1, -1));

        jLabel4.setForeground(new java.awt.Color(102, 153, 255));
        jLabel4.setText("Mix :");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(54, 70, -1, 20));

        jCheckBox1.setForeground(new java.awt.Color(102, 153, 255));
        jCheckBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox1ActionPerformed(evt);
            }
        });
        jPanel2.add(jCheckBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 70, -1, -1));

        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/_9.png"))); // NOI18N
        jPanel2.add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 38, 40, -1));

        jLabel5.setForeground(new java.awt.Color(102, 153, 255));
        jLabel5.setText("File Name :");
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(22, 100, -1, 20));

        jTextField2.setForeground(new java.awt.Color(102, 153, 255));
        jPanel2.add(jTextField2, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 100, 260, -1));

        jButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/_10.png"))); // NOI18N
        jButton6.setText("go !");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton6, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 100, 70, -1));

        jButton9.setForeground(new java.awt.Color(102, 153, 255));
        jButton9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/_12.png"))); // NOI18N
        jButton9.setText("Files");
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton9, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 70, -1, -1));

        jTabbedPane1.addTab("M3U", new javax.swing.ImageIcon(getClass().getResource("/img/_0.png")), jPanel2); // NOI18N

        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jCheckBox2.setForeground(new java.awt.Color(102, 153, 255));
        jCheckBox2.setText("Auto Name m3u file ");
        jCheckBox2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox2ActionPerformed(evt);
            }
        });
        jPanel3.add(jCheckBox2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        buttonGroup1.add(jCheckBox3);
        jCheckBox3.setForeground(new java.awt.Color(102, 153, 255));
        jCheckBox3.setText("Save m3u in same dir ");
        jCheckBox3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox3ActionPerformed(evt);
            }
        });
        jPanel3.add(jCheckBox3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, -1, -1));

        buttonGroup1.add(jCheckBox4);
        jCheckBox4.setForeground(new java.awt.Color(102, 153, 255));
        jCheckBox4.setText("Save m3u in other dir :");
        jCheckBox4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox4ActionPerformed(evt);
            }
        });
        jPanel3.add(jCheckBox4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, -1, -1));

        jTextField3.setEditable(false);
        jTextField3.setForeground(new java.awt.Color(102, 153, 255));
        jPanel3.add(jTextField3, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 70, 210, -1));

        jButton7.setForeground(new java.awt.Color(102, 153, 255));
        jButton7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/_4.png"))); // NOI18N
        jButton7.setText("open");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton7, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 68, 70, -1));

        jButton8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/_11.png"))); // NOI18N
        jButton8.setText("ok");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton8, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 110, 70, -1));

        jTabbedPane1.addTab("Settings", new javax.swing.ImageIcon(getClass().getResource("/img/_2.png")), jPanel3); // NOI18N

        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton10.setForeground(new java.awt.Color(102, 153, 255));
        jButton10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/_14.png"))); // NOI18N
        jButton10.setText("cool !");
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });
        jPanel4.add(jButton10, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 160, -1, -1));

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/_j.png"))); // NOI18N
        jPanel4.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 170, -1, -1));

        jLabel8.setForeground(new java.awt.Color(102, 153, 255));
        jLabel8.setText("Screen Name : stark9000 | xyBerWise");
        jPanel4.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, -1, -1));

        jButton11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/gp.png"))); // NOI18N
        jButton11.setContentAreaFilled(false);
        jButton11.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton11ActionPerformed(evt);
            }
        });
        jPanel4.add(jButton11, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 80, 100));

        jButton12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/yt.png"))); // NOI18N
        jButton12.setContentAreaFilled(false);
        jButton12.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton12ActionPerformed(evt);
            }
        });
        jPanel4.add(jButton12, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 40, 80, 100));

        jButton13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/fb.png"))); // NOI18N
        jButton13.setContentAreaFilled(false);
        jButton13.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton13ActionPerformed(evt);
            }
        });
        jPanel4.add(jButton13, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 40, 80, 100));

        jTabbedPane1.addTab("About", new javax.swing.ImageIcon(getClass().getResource("/img/_3.png")), jPanel4); // NOI18N

        jPanel1.add(jTabbedPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 31, 450, 230));
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 400, 30));

        getContentPane().add(jPanel1);

        setSize(new java.awt.Dimension(464, 265));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        toTray();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        if (tray != null) {
            tray.remove(trayIcon);
            System.exit(0);
        } else {
            System.exit(0);
        }

    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        jfdir.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);

        if (jfdir.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
            if (jfdir.getSelectedFile() != null) {
                jfdir.getSelectedFile().setReadOnly();
                dirp = jfdir.getSelectedFile().getAbsolutePath();
                jTextField1.setText(dirp);
            }
            jTextField1.setToolTipText("" + jTextField1.getText());
        } else {
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed

        if (jTextField1.getText().toString().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please Select a Folder !");
            return;
        }
        if (autoName == true) {
            Fname = uniqFname();
            // System.out.println(""+Fname);
        } else if ("".equals(jTextField2.getText())) {
            JOptionPane.showMessageDialog(this, "Type a Name for .m3u File !");
            return;
        } else {
            Fname = jTextField2.getText();
        }
        if (sdIr == true) {
            if (Only == true) {
                String[] ext = new String[1];
                ext[0] = jComboBox1.getSelectedItem().toString();
                files0 = exf.getFiles(dirp, ext);
                exf.genFile(Fname, files0);
            } else if (Only == false) {
                exf.genFile(Fname, exf.getFiles(dirp));
            }
        } else {
            if ("".equals(jTextField3.getText())) {
                JOptionPane.showMessageDialog(null, "Save .m3u in Different Folder  : Please Select a Folder !");
            }
            if (Only == true) {
                String[] ext = new String[1];
                ext[0] = jComboBox1.getSelectedItem().toString();
                files0 = exf.getFiles(dirp, ext);
                exf.genFile(jTextField3.getText().toString(), Fname, files0);
            } else if (Only == false) {
                files0 = exf.getFiles(dirp);
                exf.genFile(jTextField3.getText().toString(), Fname, files0);
            }
        }

//        if (Only == true) {
//            String[] ext = new String[1];
//            ext[0] = jComboBox1.getSelectedItem().toString();
//            exf.genFile(Fname, exf.getFiles(dirp, ext));
//        } else if (Only == false) {
//            exf.genFile(Fname, exf.getFiles(dirp));
//        }
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        jTabbedPane1.setSelectedIndex(1);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        if (sdIr == false && jTextField3.getText().toString().isEmpty()) {
            JOptionPane.showMessageDialog(null, "select folder !");
            return;
        }
        jTabbedPane1.setSelectedIndex(0);
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jCheckBox2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox2ActionPerformed
        if (jCheckBox2.isSelected()) {
            autoName = true;
            jTextField2.setEnabled(false);
        } else {
            autoName = false;
            jTextField2.setEnabled(true);
        }
    }//GEN-LAST:event_jCheckBox2ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        _jfdir.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);

        if (_jfdir.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
            if (_jfdir.getSelectedFile() != null) {
                _jfdir.getSelectedFile().setReadOnly();
                _dirp = _jfdir.getSelectedFile().getAbsolutePath();
                jTextField3.setText(_dirp);
            }
            jTextField1.setToolTipText("" + jTextField3.getText());
        } else {
        }
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jCheckBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox1ActionPerformed
        if (jCheckBox1.isSelected()) {
            jComboBox1.setEnabled(false);
            Only = false;
        } else {
            jComboBox1.setEnabled(true);
            Only = true;
        }
    }//GEN-LAST:event_jCheckBox1ActionPerformed

    private void jComboBox1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jComboBox1MouseClicked
        if (!jComboBox1.isEnabled() || jCheckBox1.isSelected()) {
            jCheckBox1.setSelected(false);
            jComboBox1.setEnabled(true);
        }
    }//GEN-LAST:event_jComboBox1MouseClicked

    private void jCheckBox3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox3ActionPerformed
        if (jCheckBox3.isSelected()) {
            sdIr = true;
            jTextField3.setEnabled(false);
        } else {
            sdIr = false;
            jTextField3.setEnabled(true);
        }
    }//GEN-LAST:event_jCheckBox3ActionPerformed

    private void jCheckBox4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox4ActionPerformed
        if (jCheckBox4.isSelected()) {
            sdIr = false;
            jTextField3.setEnabled(true);
        } else {
            sdIr = true;
            jTextField3.setEnabled(false);
        }
    }//GEN-LAST:event_jCheckBox4ActionPerformed

    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed
        try {
            URI gpuri = new URI("https://plus.google.com/u/0/101874849145221011001?tab=wX");
            openWebpage(gpuri);
        } catch (Exception e) {
        }
    }//GEN-LAST:event_jButton11ActionPerformed

    private void jButton12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton12ActionPerformed
        try {
            URI yturi = new URI("http://www.youtube.com/channel/UCAnq1Qo9FXfNEVAG3L4EUgw");
            openWebpage(yturi);
        } catch (Exception e) {
        }
    }//GEN-LAST:event_jButton12ActionPerformed

    private void jButton13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton13ActionPerformed
        try {
            URI fburi = new URI("https://www.facebook.com/stark9000");
            openWebpage(fburi);
        } catch (Exception e) {
        }
    }//GEN-LAST:event_jButton13ActionPerformed

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
        jTabbedPane1.setSelectedIndex(0);
    }//GEN-LAST:event_jButton10ActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed

        if (jTextField1.getText().toString().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please Select a Folder !");
            return;
        }

        if (Only == true) {
            String[] ext = new String[1];
            ext[0] = jComboBox1.getSelectedItem().toString();
            files0 = exf.getFiles(dirp, ext);
        } else if (Only == false) {
            files0 = exf.getFiles(dirp);
        }

        if (Only == true) {
            String[] ext = new String[1];
            ext[0] = jComboBox1.getSelectedItem().toString();
            files0 = exf.getFiles(dirp, ext);
        } else if (Only == false) {
            files0 = exf.getFiles(dirp);
        }

        if (files0 == null || files0.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No Files to List !");
            return;
        }
        new fileList(this, true).setVisible(true);
    }//GEN-LAST:event_jButton9ActionPerformed
    public static void openWebpage(URI uri) {
        Desktop desktop = Desktop.isDesktopSupported() ? Desktop.getDesktop() : null;
        if (desktop != null && desktop.isSupported(Desktop.Action.BROWSE)) {
            try {
                desktop.browse(uri);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(M3uMakerV2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(M3uMakerV2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(M3uMakerV2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(M3uMakerV2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new M3uMakerV2().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton13;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JCheckBox jCheckBox2;
    private javax.swing.JCheckBox jCheckBox3;
    private javax.swing.JCheckBox jCheckBox4;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    // End of variables declaration//GEN-END:variables

}
