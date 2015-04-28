package restClient;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;

import org.springframework.web.client.RestTemplate;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

/**
*
* @author NizarRy
*/
@SuppressWarnings("serial")
public class AjouterFrame extends JFrame implements ActionListener{
	
	   private JTable TCompetences;
	   private JTable TExperiences;
	   private JTable TFormations;
	   private JTable TLangues;
	   private JTextField ageField;
	   private JButton ajouterCVBouton;
	   private JButton ajouterCompetenceBouton;
	   private JButton ajouterExperienceBouton;
	   private JButton ajouterFormationBouton;
	   private JButton ajouterLangueBoutton;
	   private JTextField anneeExperienceField;
	   private JTextField anneeFormationField;
	   private JButton annulerBouton;
	   private JTextField competencesField;
	   private JTextField diplomeField;
	   private JTextField ecoleField;
	   private JTextField fonctionField;
	   private JLabel jLabel1;
	   private JLabel jLabel10;
	   private JLabel jLabel11;
	   private JLabel jLabel12;
	   private JLabel jLabel13;
	   private JLabel jLabel14;
	   private JLabel jLabel15;
	   private JLabel jLabel16;
	   private JLabel jLabel17;
	   private JLabel jLabel18;
	   private JLabel jLabel19;
	   private JLabel jLabel2;
	   private JLabel jLabel3;
	   private JLabel jLabel4;
	   private JLabel jLabel5;
	   private JLabel jLabel6;
	   private JLabel jLabel7;
	   private JLabel jLabel8;
	   private JLabel jLabel9;
	   private JScrollPane jScrollPane1;
	   private JScrollPane jScrollPane2;
	   private JScrollPane jScrollPane3;
	   private JScrollPane jScrollPane4;
	   private JScrollPane jScrollPane5;
	   private JSeparator jSeparator1;
	   private JSeparator jSeparator2;
	   private JSeparator jSeparator3;
	   private JSeparator jSeparator4;
	   private JSeparator jSeparator5;
	   private JSeparator jSeparator6;
	   private JTable jTable3;
	   private JTextField langueField;
	   private JTextField lieuField;
	   private JTextField niveauCompetenceField;
	   private JTextField niveauLangueField;
	   private JTextField nomCompetenceField;
	   private JTextField nomField;
	   private JTextField objectifField;
	   private JTextField prenomField;  

	private TableModel tableModel;
	private String CVEntry;
   /**
    * Crée un nouveau AjouterFrame
 * @param tableModel 
    */
   public AjouterFrame(TableModel tableModel) {
	   setTitle("Ajoutez votre Curriculum vitae");
       initComponents();
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
           java.util.logging.Logger.getLogger(AjouterFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
       } catch (InstantiationException ex) {
           java.util.logging.Logger.getLogger(AjouterFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
       } catch (IllegalAccessException ex) {
           java.util.logging.Logger.getLogger(AjouterFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
       } catch (UnsupportedLookAndFeelException ex) {
           java.util.logging.Logger.getLogger(AjouterFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
       }

       this.tableModel = tableModel;
       ajouterLangueBoutton.addActionListener(this);
       ajouterFormationBouton.addActionListener(this);
       ajouterCompetenceBouton.addActionListener(this);
       ajouterExperienceBouton.addActionListener(this);
       ajouterCVBouton.addActionListener(this);
       annulerBouton.addActionListener(this);
       
   }
                
   private void initComponents() {

       jScrollPane3 = new JScrollPane();
       jTable3 = new JTable();
       jLabel1 = new JLabel();
       jLabel2 = new JLabel();
       jLabel3 = new JLabel();
       jLabel4 = new JLabel();
       jLabel5 = new JLabel();
       nomField = new JTextField();
       prenomField = new JTextField();
       ageField = new JTextField();
       objectifField = new JTextField();
       competencesField = new JTextField();
       jSeparator1 = new JSeparator();
       jSeparator2 = new JSeparator();
       jLabel6 = new JLabel();
       jScrollPane1 = new JScrollPane();
       TLangues = new JTable();
       langueField = new JTextField();
       jLabel7 = new JLabel();
       jLabel8 = new JLabel();
       niveauLangueField = new JTextField();
       ajouterLangueBoutton = new JButton();
       jSeparator3 = new JSeparator();
       jScrollPane2 = new JScrollPane();
       TFormations = new JTable();
       jLabel9 = new JLabel();
       jLabel10 = new JLabel();
       jLabel11 = new JLabel();
       jLabel12 = new JLabel();
       ecoleField = new JTextField();
       anneeFormationField = new JTextField();
       diplomeField = new JTextField();
       ajouterFormationBouton = new JButton();
       jSeparator4 = new JSeparator();
       jSeparator5 = new JSeparator();
       jSeparator6 = new JSeparator();
       jLabel13 = new JLabel();
       nomCompetenceField = new JTextField();
       jLabel14 = new JLabel();
       jLabel15 = new JLabel();
       niveauCompetenceField = new JTextField();
       ajouterCompetenceBouton = new JButton();
       jScrollPane4 = new JScrollPane();
       TCompetences = new JTable();
       jLabel16 = new JLabel();
       jLabel17 = new JLabel();
       jLabel18 = new JLabel();
       anneeExperienceField = new JTextField();
       lieuField = new JTextField();
       jLabel19 = new JLabel();
       fonctionField = new JTextField();
       ajouterExperienceBouton = new JButton();
       jScrollPane5 = new JScrollPane();
       TExperiences = new JTable();
       ajouterCVBouton = new JButton();
       annulerBouton = new JButton();

       jTable3.setModel(new DefaultTableModel(
           new Object [][] {
               {null, null, null, null},
               {null, null, null, null},
               {null, null, null, null},
               {null, null, null, null}
           },
           new String [] {
               "Title 1", "Title 2", "Title 3", "Title 4"
           }
       ));
       jScrollPane3.setViewportView(jTable3);

       jLabel1.setText("Nom");

       jLabel2.setText("Prenom");

       jLabel3.setText("Age");

       jLabel4.setText("Objectif");

       jLabel5.setText("Comp\u00E9tences");

       nomField.addActionListener(new java.awt.event.ActionListener() {
           public void actionPerformed(java.awt.event.ActionEvent evt) {
               nomFieldActionPerformed(evt);
           }
       });

       jSeparator2.setBorder(BorderFactory.createEtchedBorder());

       jLabel6.setText("Langues");

       TLangues.setModel(new DefaultTableModel(
           new Object [][] {

           },
           new String [] {
               "Langue", "Niveau"
           }
       ));
       jScrollPane1.setViewportView(TLangues);

       langueField.addActionListener(new java.awt.event.ActionListener() {
           public void actionPerformed(java.awt.event.ActionEvent evt) {
               langueFieldActionPerformed(evt);
           }
       });

       jLabel7.setText("Langue");

       jLabel8.setText("Niveau");

       ajouterLangueBoutton.setText("Ajouter");

       TFormations.setModel(new DefaultTableModel(
           new Object [][] {

           },
           new String [] {
               "Ecole", "Ann\u00E9e", "Diplome"
           }
       ));
       jScrollPane2.setViewportView(TFormations);

       jLabel9.setText("Formations");

       jLabel10.setText("Ecole");

       jLabel11.setText("Ann\u00E9e");

       jLabel12.setText("Diplome");

       ecoleField.addActionListener(new java.awt.event.ActionListener() {
           public void actionPerformed(java.awt.event.ActionEvent evt) {
               ecoleFieldActionPerformed(evt);
           }
       });

       ajouterFormationBouton.setText("Ajouter");

       jSeparator5.setBorder(BorderFactory.createEtchedBorder());

       jLabel13.setText("Comp\u00E9tences informatiques");

       nomCompetenceField.addActionListener(new java.awt.event.ActionListener() {
           public void actionPerformed(java.awt.event.ActionEvent evt) {
               nomCompetenceFieldActionPerformed(evt);
           }
       });

       jLabel14.setText("Nom");

       jLabel15.setText("Niveau");

       ajouterCompetenceBouton.setText("Ajouter");

       TCompetences.setModel(new DefaultTableModel(
           new Object [][] {

           },
           new String [] {
               "Nom", "Niveau"
           }
       ));
       jScrollPane4.setViewportView(TCompetences);

       jLabel16.setText("Exp\u00E9riences professionelles");

       jLabel17.setText("Ann\u00E9e");

       jLabel18.setText("Lieu");

       jLabel19.setText("Fonction");

       fonctionField.addActionListener(new java.awt.event.ActionListener() {
           public void actionPerformed(java.awt.event.ActionEvent evt) {
               fonctionFieldActionPerformed(evt);
           }
       });

       ajouterExperienceBouton.setText("Ajouter");
       ajouterExperienceBouton.addActionListener(new java.awt.event.ActionListener() {
           public void actionPerformed(java.awt.event.ActionEvent evt) {
               ajouterExperienceFieldActionPerformed(evt);
           }
       });

       TExperiences.setModel(new DefaultTableModel(
           new Object [][] {

           },
           new String [] {
               "Ann\u00E9e", "Lieu", "Fonction"
           }
       ));
       jScrollPane5.setViewportView(TExperiences);

       ajouterCVBouton.setText("Ajouter votre CV");
       ajouterCVBouton.addActionListener(new java.awt.event.ActionListener() {
           public void actionPerformed(java.awt.event.ActionEvent evt) {
               ajouterCVBoutonActionPerformed(evt);
           }
       });

       annulerBouton.setText("Annuler");

       GroupLayout layout = new GroupLayout(getContentPane());
       getContentPane().setLayout(layout);
       layout.setHorizontalGroup(
           layout.createParallelGroup(GroupLayout.Alignment.LEADING)
           .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
               .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                   .addGroup(layout.createSequentialGroup()
                       .addContainerGap()
                       .addComponent(jLabel6)
                       .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                       .addComponent(jSeparator1))
                   .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                       .addContainerGap()
                       .addComponent(jLabel13)
                       .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                       .addComponent(jSeparator6))
                   .addGroup(layout.createSequentialGroup()
                       .addContainerGap()
                       .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                           .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                               .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                   .addComponent(jLabel7)
                                   .addComponent(jLabel8))
                               .addGap(42, 42, 42)
                               .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                   .addComponent(langueField)
                                   .addComponent(niveauLangueField, GroupLayout.DEFAULT_SIZE, 113, Short.MAX_VALUE))
                               .addGap(48, 48, 48)
                               .addComponent(ajouterLangueBoutton, GroupLayout.PREFERRED_SIZE, 137, GroupLayout.PREFERRED_SIZE))
                           .addComponent(jScrollPane1, GroupLayout.Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 414, GroupLayout.PREFERRED_SIZE)))
                   .addGroup(layout.createSequentialGroup()
                       .addGap(62, 62, 62)
                       .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                           .addComponent(jLabel14)
                           .addComponent(jLabel15))
                       .addGap(34, 34, 34)
                       .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                           .addComponent(nomCompetenceField, GroupLayout.PREFERRED_SIZE, 94, GroupLayout.PREFERRED_SIZE)
                           .addComponent(niveauCompetenceField, GroupLayout.PREFERRED_SIZE, 94, GroupLayout.PREFERRED_SIZE))
                       .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                       .addComponent(ajouterCompetenceBouton, GroupLayout.PREFERRED_SIZE, 132, GroupLayout.PREFERRED_SIZE)
                       .addGap(9, 9, 9))
                   .addGroup(layout.createSequentialGroup()
                       .addContainerGap()
                       .addComponent(jScrollPane4, GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
               .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                   .addComponent(jSeparator5, GroupLayout.DEFAULT_SIZE, 12, Short.MAX_VALUE)
                   .addComponent(jSeparator2))
               .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                   .addGroup(layout.createSequentialGroup()
                       .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                           .addGroup(layout.createSequentialGroup()
                               .addGap(30, 30, 30)
                               .addComponent(jSeparator3))
                           .addGroup(layout.createSequentialGroup()
                               .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                   .addGroup(layout.createSequentialGroup()
                                       .addGap(30, 30, 30)
                                       .addComponent(jScrollPane2, GroupLayout.PREFERRED_SIZE, 409, GroupLayout.PREFERRED_SIZE))
                                   .addGroup(layout.createSequentialGroup()
                                       .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                       .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                           .addGroup(layout.createSequentialGroup()
                                               .addComponent(jLabel16)
                                               .addGap(24, 24, 24)
                                               .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                                   .addComponent(jSeparator4, GroupLayout.PREFERRED_SIZE, 583, GroupLayout.PREFERRED_SIZE)
                                                   .addGroup(layout.createSequentialGroup()
                                                       .addGap(33, 33, 33)
                                                       .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                                           .addComponent(jLabel11)
                                                           .addComponent(jLabel10)
                                                           .addComponent(jLabel12))
                                                       .addGap(31, 31, 31)
                                                       .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                                           .addComponent(anneeFormationField, GroupLayout.PREFERRED_SIZE, 95, GroupLayout.PREFERRED_SIZE)
                                                           .addComponent(ecoleField, GroupLayout.PREFERRED_SIZE, 217, GroupLayout.PREFERRED_SIZE)
                                                           .addComponent(diplomeField, GroupLayout.PREFERRED_SIZE, 217, GroupLayout.PREFERRED_SIZE))
                                                       .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                       .addComponent(ajouterFormationBouton)
                                                       .addGap(108, 108, 108))))
                                           .addComponent(jLabel9)))
                                   .addGroup(layout.createSequentialGroup()
                                       .addGap(207, 207, 207)
                                       .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                           .addComponent(jLabel18)
                                           .addComponent(jLabel17))
                                       .addGap(18, 18, 18)
                                       .addComponent(anneeExperienceField, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)))
                               .addGap(0, 0, Short.MAX_VALUE))
                           .addGroup(layout.createSequentialGroup()
                               .addGap(199, 199, 199)
                               .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                   .addComponent(lieuField, GroupLayout.PREFERRED_SIZE, 197, GroupLayout.PREFERRED_SIZE)
                                   .addGroup(layout.createSequentialGroup()
                                       .addComponent(jLabel19)
                                       .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                       .addComponent(fonctionField, GroupLayout.PREFERRED_SIZE, 197, GroupLayout.PREFERRED_SIZE)))
                               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                               .addComponent(ajouterExperienceBouton)
                               .addGap(105, 105, 105)))
                       .addContainerGap())
                   .addGroup(layout.createSequentialGroup()
                       .addGap(27, 27, 27)
                       .addComponent(jScrollPane5, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                       .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
           .addGroup(layout.createSequentialGroup()
               .addGap(21, 21, 21)
               .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                   .addComponent(jLabel1)
                   .addComponent(jLabel2)
                   .addComponent(jLabel3)
                   .addComponent(jLabel4)
                   .addComponent(jLabel5))
               .addGap(78, 78, 78)
               .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                   .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                       .addComponent(nomField, GroupLayout.DEFAULT_SIZE, 176, Short.MAX_VALUE)
                       .addComponent(prenomField)
                       .addComponent(ageField, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE))
                   .addComponent(objectifField, GroupLayout.DEFAULT_SIZE, 303, Short.MAX_VALUE)
                   .addComponent(competencesField))
               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
               .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                   .addComponent(ajouterCVBouton)
                   .addComponent(annulerBouton))
               .addGap(90, 90, 90))
       );
       layout.setVerticalGroup(
           layout.createParallelGroup(GroupLayout.Alignment.LEADING)
           .addGroup(layout.createSequentialGroup()
               .addContainerGap(29, Short.MAX_VALUE)
               .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                   .addComponent(jLabel1)
                   .addComponent(nomField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
               .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                   .addGroup(layout.createSequentialGroup()
                       .addGap(3, 3, 3)
                       .addComponent(ajouterCVBouton))
                   .addGroup(layout.createSequentialGroup()
                       .addGap(21, 21, 21)
                       .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                           .addGroup(layout.createSequentialGroup()
                               .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                   .addComponent(jLabel2)
                                   .addComponent(prenomField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                               .addGap(19, 19, 19)
                               .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                   .addComponent(jLabel3)
                                   .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                       .addComponent(ageField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                       .addComponent(annulerBouton)))
                               .addGap(28, 28, 28)
                               .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                   .addComponent(objectifField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                   .addComponent(jLabel4))
                               .addGap(18, 18, 18)
                               .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                   .addComponent(jLabel5)
                                   .addComponent(competencesField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                               .addGap(20, 20, 20)
                               .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                   .addGroup(layout.createSequentialGroup()
                                       .addGap(0, 0, Short.MAX_VALUE)
                                       .addComponent(ajouterCompetenceBouton)
                                       .addGap(5, 5, 5)
                                       .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                           .addComponent(niveauCompetenceField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                           .addComponent(jLabel15))
                                       .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                       .addComponent(jScrollPane4, GroupLayout.PREFERRED_SIZE, 58, GroupLayout.PREFERRED_SIZE)
                                       .addGap(54, 54, 54))
                                   .addGroup(layout.createSequentialGroup()
                                       .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                           .addGroup(layout.createSequentialGroup()
                                               .addGap(4, 4, 4)
                                               .addComponent(jLabel9)
                                               .addGap(286, 286, 286)
                                               .addComponent(ajouterExperienceBouton)
                                               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                           .addGroup(layout.createSequentialGroup()
                                               .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                   .addGroup(layout.createSequentialGroup()
                                                       .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                                           .addComponent(jSeparator1, GroupLayout.PREFERRED_SIZE, 10, GroupLayout.PREFERRED_SIZE)
                                                           .addComponent(jLabel6))
                                                       .addGap(38, 38, 38)
                                                       .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                           .addComponent(jLabel7)
                                                           .addComponent(langueField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                           .addComponent(ajouterLangueBoutton))
                                                       .addGap(7, 7, 7)
                                                       .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                           .addComponent(jLabel8)
                                                           .addComponent(niveauLangueField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                                       .addGap(10, 10, 10)
                                                       .addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 83, GroupLayout.PREFERRED_SIZE)
                                                       .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                       .addComponent(nomCompetenceField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                       .addGap(17, 17, 17))
                                                   .addGroup(layout.createSequentialGroup()
                                                       .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                                           .addComponent(jSeparator2, GroupLayout.PREFERRED_SIZE, 235, GroupLayout.PREFERRED_SIZE)
                                                           .addGroup(layout.createSequentialGroup()
                                                               .addGap(4, 4, 4)
                                                               .addComponent(jSeparator3, GroupLayout.PREFERRED_SIZE, 10, GroupLayout.PREFERRED_SIZE)
                                                               .addGap(22, 22, 22)
                                                               .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                                   .addComponent(jLabel10)
                                                                   .addComponent(ecoleField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                                               .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                                               .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                                   .addComponent(jLabel11)
                                                                   .addComponent(anneeFormationField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                                   .addComponent(ajouterFormationBouton))
                                                               .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                                               .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                                   .addComponent(jLabel12)
                                                                   .addComponent(diplomeField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                                               .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                                               .addComponent(jScrollPane2, GroupLayout.PREFERRED_SIZE, 58, GroupLayout.PREFERRED_SIZE)
                                                               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                               .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                                   .addComponent(jSeparator4, GroupLayout.Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 10, GroupLayout.PREFERRED_SIZE)
                                                                   .addComponent(jLabel16, GroupLayout.Alignment.TRAILING))))
                                                       .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                       .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                           .addComponent(anneeExperienceField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                           .addComponent(jLabel17))
                                                       .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                                       .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                           .addComponent(jLabel18)
                                                           .addComponent(lieuField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                                       .addGap(0, 5, Short.MAX_VALUE)))
                                               .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                   .addComponent(jLabel19)
                                                   .addComponent(fonctionField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                               .addGap(26, 26, 26)))
                                       .addComponent(jScrollPane5, GroupLayout.PREFERRED_SIZE, 56, GroupLayout.PREFERRED_SIZE)
                                       .addGap(42, 42, 42))))
                           .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                               .addComponent(jSeparator6, GroupLayout.PREFERRED_SIZE, 10, GroupLayout.PREFERRED_SIZE)
                               .addComponent(jSeparator5, GroupLayout.PREFERRED_SIZE, 214, GroupLayout.PREFERRED_SIZE)
                               .addGroup(layout.createSequentialGroup()
                                   .addComponent(jLabel13)
                                   .addGap(18, 18, 18)
                                   .addComponent(jLabel14))))))
               .addContainerGap())
       );

       pack();
   }                       

   private void nomFieldActionPerformed(java.awt.event.ActionEvent evt) {                                         
       // TODO add your handling code here:
   }                                        

   private void langueFieldActionPerformed(java.awt.event.ActionEvent evt) {                                            
       // TODO add your handling code here:
   }                                           

   private void ecoleFieldActionPerformed(java.awt.event.ActionEvent evt) {                                           
       // TODO add your handling code here:
   }                                          

   private void nomCompetenceFieldActionPerformed(java.awt.event.ActionEvent evt) {                                                   
       // TODO add your handling code here:
   }                                                  

   private void fonctionFieldActionPerformed(java.awt.event.ActionEvent evt) {                                              
       // TODO add your handling code here:
   }                                             

   private void ajouterExperienceFieldActionPerformed(java.awt.event.ActionEvent evt) {                                                       
       // TODO add your handling code here:
   }                                                      

   private void ajouterCVBoutonActionPerformed(java.awt.event.ActionEvent evt) {                                                
       // TODO add your handling code here:
	   if((!nomField.getText().trim().isEmpty()) && (!prenomField.getText().trim().isEmpty())){
		   JOptionPane.showMessageDialog(this.getComponent(0), "Votre CV a bien \u00E9t\u00E9 ajout\u00E9, souvenez vous des informations suivantes pour le consulter ulterieurement :\n\n" + CVEntry, "Ajout avec succ\u00E8s", JOptionPane.INFORMATION_MESSAGE);
	   }
   }                                               
   
   public  void    actionPerformed(ActionEvent e)
   {
	   if(e.getSource() == ajouterLangueBoutton){

		   Object[] row ={langueField.getText(),
	    		   niveauLangueField.getText(), 
	   			};
	    DefaultTableModel tb =(DefaultTableModel) TLangues.getModel();
	    tb.addRow(row);
	    langueField.setText("");
		   niveauLangueField.setText("");
	 }
   if(e.getSource() == ajouterCompetenceBouton){
	   Object[] row ={nomCompetenceField.getText(),
			   niveauCompetenceField.getText(), 
   			};
    DefaultTableModel tb =(DefaultTableModel) TCompetences.getModel();
    tb.addRow(row);
    nomCompetenceField.setText("");
	   niveauCompetenceField.setText("");
   }
   
   if(e.getSource() == ajouterExperienceBouton){
	   	Object[] row ={anneeExperienceField.getText(),
			   lieuField.getText(),
			   fonctionField.getText()
   			};
    DefaultTableModel tb =(DefaultTableModel) TExperiences.getModel();
    tb.addRow(row);
    anneeExperienceField.setText("");
	   lieuField.setText("");
	   fonctionField.setText("");
	   }
   
   if(e.getSource() == ajouterFormationBouton){
	   Object[] row ={ecoleField.getText(),
			   anneeFormationField.getText(),
			   diplomeField.getText()
   			};
    DefaultTableModel tb =(DefaultTableModel) TFormations.getModel();
    tb.addRow(row);
    ecoleField.setText("");
	   anneeFormationField.setText("");
	   diplomeField.setText("");
	   }
   
   if(e.getSource() == annulerBouton){
	   dispose();
   }

   if(e.getSource() == ajouterCVBouton){
	   if(prenomField.getText().trim().isEmpty() || nomField.getText().trim().isEmpty()){
		   JOptionPane.showMessageDialog(this.getComponent(0), "Les champs pour le Nom et le Prénom sont obligatoires", "Message", JOptionPane.INFORMATION_MESSAGE);
	   }
	   
	   else {
		   DOMSource source;
		try {
           //Crée un document XML vide
           DocumentBuilderFactory dbfac = DocumentBuilderFactory.newInstance();
           DocumentBuilder docBuilder = dbfac.newDocumentBuilder();
           Document doc = docBuilder.newDocument();

           //Crée la structure du CV

           //crée l'élément de la racine
           Element root = doc.createElement("cv");
           doc.appendChild(root);

           //créer les éléments fils
           //age
           Element age = doc.createElement("age");
   		age.appendChild(doc.createTextNode(ageField.getText()));
   		root.appendChild(age);
   		//competences
   		Element competences = doc.createElement("competences");
   		competences.appendChild(doc.createTextNode(competencesField.getText()));
   		root.appendChild(competences);
           //nom
           Element nom = doc.createElement("nom");
           nom.appendChild(doc.createTextNode(nomField.getText()));
   		root.appendChild(nom);
           //objectif
           Element objectif = doc.createElement("objectif");
           objectif.appendChild(doc.createTextNode(objectifField.getText()));
   		root.appendChild(objectif);
           //prenom
           Element prenom = doc.createElement("prenom");
           prenom.appendChild(doc.createTextNode(prenomField.getText()));
   		root.appendChild(prenom);
   		
   		for(int i = 0; i < TLangues.getModel().getRowCount(); i++) {
        //Langues
   		Element langues = doc.createElement("langues");
   		root.appendChild(langues);

   		// niveauLangue
   		Element niveauLangue = doc.createElement("niveauLangue");
   		niveauLangue.appendChild(doc.createTextNode((String)TLangues.getModel().getValueAt(i, 1)));
   		langues.appendChild(niveauLangue);
    
   		// nomLangue
   		Element nomLangue = doc.createElement("nomLangue");
   		nomLangue.appendChild(doc.createTextNode((String)TLangues.getModel().getValueAt(i, 0)));
   		langues.appendChild(nomLangue);
   		}
  
   		for(int i = 0; i < TCompetences.getModel().getRowCount(); i++) {
   	//competencesInfo
   		Element competencesInfo = doc.createElement("competencesInfo");
   		root.appendChild(competencesInfo);

   		// niveauCompetence
   		Element niveauCompetence = doc.createElement("niveauCompetence");
   		niveauCompetence.appendChild(doc.createTextNode((String)TCompetences.getModel().getValueAt(i, 1)));
   		competencesInfo.appendChild(niveauCompetence);
    
   		// nomCompetence
   		Element nomCompetence = doc.createElement("nomCompetence");
   		nomCompetence.appendChild(doc.createTextNode((String)TCompetences.getModel().getValueAt(i, 0)));
   		competencesInfo.appendChild(nomCompetence);
   		}
   		
   		for(int i = 0; i < TExperiences.getModel().getRowCount(); i++) {
   	//experiencesPro
   		Element experiencesPro = doc.createElement("experiencesPro");
   		root.appendChild(experiencesPro);

   		// annee
   		Element annee = doc.createElement("annee");
   		annee.appendChild(doc.createTextNode((String)TExperiences.getModel().getValueAt(i, 0)));
   		experiencesPro.appendChild(annee);
    
   		// fonction
   		Element fonction = doc.createElement("fonction");
   		fonction.appendChild(doc.createTextNode((String)TExperiences.getModel().getValueAt(i, 2)));
   		experiencesPro.appendChild(fonction);
   		
   		// lieu
   		Element lieu = doc.createElement("lieu");
   		lieu.appendChild(doc.createTextNode((String)TExperiences.getModel().getValueAt(i, 1)));
   		experiencesPro.appendChild(lieu);
   		}
   		
   		for(int i = 0; i < TFormations.getModel().getRowCount(); i++) {
   	//formations
   		Element formations = doc.createElement("formations");
   		root.appendChild(formations);

   		// anneeFormation
   		Element anneeFormation = doc.createElement("anneeFormation");
   		anneeFormation.appendChild(doc.createTextNode((String)TFormations.getModel().getValueAt(i, 1)));
   		formations.appendChild(anneeFormation);
    
   		// diplome
   		Element diplome = doc.createElement("diplome");
   		diplome.appendChild(doc.createTextNode((String)TFormations.getModel().getValueAt(i, 2)));
   		formations.appendChild(diplome);
   		
   		// ecole
   		Element ecole = doc.createElement("ecole");
   		ecole.appendChild(doc.createTextNode((String)TFormations.getModel().getValueAt(i, 0)));
   		formations.appendChild(ecole);
   		}

           TransformerFactory transfac = TransformerFactory.newInstance();
           Transformer trans = transfac.newTransformer();
           trans.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "yes");
           trans.setOutputProperty(OutputKeys.INDENT, "yes");
           source = new DOMSource(doc);
           final String uri = "http://servicerestryad-ryad.rhcloud.com/ServiceREST/resume";
           RestTemplate restTemplate = new RestTemplate();
           Source cvEntry = restTemplate.postForObject( uri, source, Source.class);
           // Retourner le CVEntry correspondant au CV ajouté
           List<Object[]> cve = new LinkedList<Object[]>();
           ParserGETCVList parser = new ParserGETCVList(restTemplate, cvEntry);
           InputSource isource = parser.sourceToInputSource();
   		try {
   			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
   			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
   			Document document = dBuilder.parse(isource);
   		 
   			document.getDocumentElement().normalize();
   		 
   			NodeList nList = document.getElementsByTagName("CVEntry");
   		 
   			for (int temp = 0; temp < nList.getLength(); temp++) {
   		 
   				Node nNode = nList.item(temp);
   		 
   				if (nNode.getNodeType() == Node.ELEMENT_NODE) {
   		 
   					Element eElement = (Element) nNode;
   					Object[] row ={eElement.getElementsByTagName("id").item(0).getTextContent(),
      		     		     	eElement.getElementsByTagName("nom").item(0).getTextContent(), 
      		    		     	eElement.getElementsByTagName("prenom").item(0).getTextContent()};
   					cve.add(row);
   				}
   			}
   			CVEntry = "Identifiant : " + cve.get(0)[0] + "\nNom : " + cve.get(0)[1] + "\nPrenom : " + cve.get(0)[2];
   		    } catch (Exception exception) {
   			exception.printStackTrace();
   			System.out.println("Les informations du CV n'ont pas pu être récupéré !");
   			cve.add(new String[] {"Les informations du CV n'ont pas pu être r\u00E9cup\u00E9r\u00E9 !"});
   			CVEntry = "Erreur : " + cve.get(0)[0];
   		    }
       } catch (Exception exception) {
           System.out.println("Erreur : " + exception.getMessage());
       }
		List<Object[]> resultatCVList = new LinkedList<Object[]>();
		RestTemplate restTemplate = new RestTemplate();
		Source cv = restTemplate.getForObject("http://servicerestryad-ryad.rhcloud.com/ServiceREST/resume", Source.class);
	       ParserGETCVList parser = new ParserGETCVList(restTemplate, cv);
			InputSource isource = parser.sourceToInputSource();
			resultatCVList = parser.ReadXMLInput(isource);
				Object[] row = resultatCVList.get(resultatCVList.size() - 1);
			DefaultTableModel tb =(DefaultTableModel) tableModel;
		          tb.addRow(row);
		          dispose();
	   }
	   }
   
   }
}

