package restClient;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;
import java.util.List;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.LayoutStyle;
import javax.swing.ListSelectionModel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.WindowConstants;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.xml.transform.Source;

import org.springframework.web.client.RestTemplate;
import org.xml.sax.InputSource;

/**
*
* @author NizarRy
*/
@SuppressWarnings("serial")
public class CVListFrame extends JFrame implements ActionListener{
                  
	   private JButton AjouterButton;
	   private JButton ConsulterBouton;
	   private JTable TCVList;

	private JLabel jLabel1;
	   private JScrollPane jScrollPane1;
	   static String id;
	
   /**
    * Crée un nouveau CVListFrame
    */
   public CVListFrame() {
	   setTitle("Liste des CVs");
       initComponents();
       ConsulterBouton.addActionListener(this);
       AjouterButton.addActionListener(this);
       ConsulterBouton.setEnabled(false);
       ListSelectionModel listSelectionModel = TCVList.getSelectionModel();
       listSelectionModel.addListSelectionListener(new ListSelectionListener() {
               public void valueChanged(ListSelectionEvent e) { 
                   ListSelectionModel lsm = (ListSelectionModel)e.getSource();
                   ConsulterBouton.setEnabled(!lsm.isSelectionEmpty());
       }
       });
       List<Object[]> resultatCVList = new LinkedList<Object[]>();
       RestTemplate restTemplate = new RestTemplate();
		Source cvList = restTemplate.getForObject("http://servicerestryad-ryad.rhcloud.com/ServiceREST/resume", Source.class);
       ParserGETCVList parser = new ParserGETCVList(restTemplate, cvList);
		InputSource isource = parser.sourceToInputSource();
		resultatCVList = parser.ReadXMLInput(isource);
		for(Object[] row : resultatCVList){
		DefaultTableModel tb =(DefaultTableModel) TCVList.getModel();
	          tb.addRow(row);
		}
   }
                           
   private void initComponents() {

       jLabel1 = new JLabel();
       jScrollPane1 = new JScrollPane();
       TCVList = new JTable();
       ConsulterBouton = new JButton();
       AjouterButton = new JButton();

       jLabel1.setText("jLabel1");

       setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

       TCVList.setModel(new DefaultTableModel(
           new Object [][] {

           },
           new String [] {
               "ID", "Nom", "Prenom"
           }
       ) {
           boolean[] canEdit = new boolean [] {
               true, false, false
           };

           public boolean isCellEditable(int rowIndex, int columnIndex) {
               return canEdit [columnIndex];
           }
       });
       jScrollPane1.setViewportView(TCVList);

       ConsulterBouton.setText("Consulter le CV");

       AjouterButton.setText("Ajouter un CV");
       AjouterButton.addActionListener(new java.awt.event.ActionListener() {
           public void actionPerformed(java.awt.event.ActionEvent evt) {
               AjouterButtonActionPerformed(evt);
           }
       });

       GroupLayout layout = new GroupLayout(getContentPane());
       getContentPane().setLayout(layout);
       layout.setHorizontalGroup(
           layout.createParallelGroup(GroupLayout.Alignment.LEADING)
           .addGroup(layout.createSequentialGroup()
               .addGap(18, 18, 18)
               .addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 377, GroupLayout.PREFERRED_SIZE)
               .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
               .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                   .addComponent(ConsulterBouton, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                   .addComponent(AjouterButton))
               .addContainerGap(37, Short.MAX_VALUE))
       );
       layout.setVerticalGroup(
           layout.createParallelGroup(GroupLayout.Alignment.LEADING)
           .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
               .addGap(49, 49, 49)
               .addComponent(AjouterButton)
               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
               .addGap(56, 56, 56)
               .addComponent(ConsulterBouton)
               .addGap(60, 60, 60))
           .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
               .addContainerGap(33, Short.MAX_VALUE)
               .addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 306, GroupLayout.PREFERRED_SIZE)
               .addGap(41, 41, 41))
       );

       pack();
   }                       

   private void AjouterButtonActionPerformed(java.awt.event.ActionEvent evt) {                                              
       // TODO add your handling code here:
   }                                             


   public static void main(String args[]) {
       /* Set the Nimbus look and feel */
       //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
       /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
        * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
        */
       try {
           for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
               if ("Nimbus".equals(info.getName())) {
                   UIManager.setLookAndFeel(info.getClassName());
                   break;
               }
           }
       } catch (ClassNotFoundException ex) {
           java.util.logging.Logger.getLogger(CVListFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
       } catch (InstantiationException ex) {
           java.util.logging.Logger.getLogger(CVListFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
       } catch (IllegalAccessException ex) {
           java.util.logging.Logger.getLogger(CVListFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
       } catch (UnsupportedLookAndFeelException ex) {
           java.util.logging.Logger.getLogger(CVListFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
       }

       java.awt.EventQueue.invokeLater(new Runnable() {
           public void run() {
               new CVListFrame().setVisible(true);
           }
       });
   }  
   
   public  void    actionPerformed(ActionEvent e)
   {if(e.getSource() == ConsulterBouton){
	   if(TCVList.getSelectedRows().length > 1){
		   JOptionPane.showMessageDialog(this.getComponent(0), "Vous avez s\u00E9l\u00E9ctionn\u00E9 plus qu'une ligne, veuillez s\u00E9l\u00E9ctionner le CV qui vous int\u00E9r\u00E9sse", "Erreur", JOptionPane.ERROR_MESSAGE);
	   }
	   else {
		   id=  (String)TCVList.getModel().getValueAt(TCVList.getSelectedRow(), 0);
		   new ConsulterFrame().setVisible(true);
	   }
	 }
   if(e.getSource() == AjouterButton){
   	new AjouterFrame(TCVList.getModel() ).setVisible(true);
   }
   }
   
   public JTable getTCVList() {
		return TCVList;
	}

	public void setTCVList(JTable tCVList) {
		TCVList = tCVList;
	};
	}


