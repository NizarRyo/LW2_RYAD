package restClient;

import javax.swing.GroupLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.table.DefaultTableModel;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

/**
*
* @author NizarRy
*/
public class ConsulterFrame extends JFrame {

	private static final long serialVersionUID = 5198322983472482978L;               
	   private JTextField AgeField;
	   private JTextField CompetencesField;
	   private JTextField NomField;
	   private JTextField ObjectifField;
	   private JTextField PrenomField;
	   private JTable TCompetencesInfo;
	   private JTable TExperiencePro;
	   private JTable TFormations;
	   private JTable TLangues;
	   private JLabel jLabel1;
	   private JLabel jLabel10;
	   private JLabel jLabel2;
	   private JLabel jLabel3;
	   private JLabel jLabel4;
	   private JLabel jLabel5;
	   private JLabel jLabel6;
	   private JLabel jLabel7;
	   private JLabel jLabel9;
	   private JScrollPane jScrollPane2;
	   private JScrollPane jScrollPane3;
	   private JScrollPane jScrollPane4;
	   private JScrollPane jScrollPane5; 
	
/**
    * Crée un nouveau ConsulterFrame
    */
   public ConsulterFrame() {
	   setTitle("Curriculum vitae");
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
           java.util.logging.Logger.getLogger(ConsulterFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
       } catch (InstantiationException ex) {
           java.util.logging.Logger.getLogger(ConsulterFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
       } catch (IllegalAccessException ex) {
           java.util.logging.Logger.getLogger(ConsulterFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
       } catch (UnsupportedLookAndFeelException ex) {
           java.util.logging.Logger.getLogger(ConsulterFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
       }
       
       String id = CVListFrame.id;
       ParserGETid parser = new ParserGETid(id);
		InputSource isource = parser.sourceToInputSource();
		try {
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(isource);

			doc.getDocumentElement().normalize();

		         System.out.println("Root element :" + doc.getDocumentElement().getNodeName());
		         
		     	NodeList nList = doc.getElementsByTagName("cv");
		      
		     	System.out.println("----------------------------");
		      
		     	for (int temp = 0; temp < nList.getLength(); temp++) {
		      
		     		Node nNode = nList.item(temp);
		      
		     		System.out.println("\nCurrent Element :" + nNode.getNodeName());
		      
		     		if (nNode.getNodeType() == Node.ELEMENT_NODE) {
		      
		     			Element eElement = (Element) nNode;
		     		System.out.println(eElement.getElementsByTagName("nom").item(temp).getTextContent());
		     	
		     		this.getNomField().setText(eElement.getElementsByTagName("nom").item(temp).getTextContent());
		     		this.getPrenomField().setText(eElement.getElementsByTagName("prenom").item(temp).getTextContent());
		     		this.getAgeField().setText(eElement.getElementsByTagName("age").item(temp).getTextContent());
		     		this.getObjectifField().setText(eElement.getElementsByTagName("objectif").item(temp).getTextContent());
		     		this.getCompetencesField().setText(eElement.getElementsByTagName("competences").item(temp).getTextContent());
		     	
		     for(int i = 0; i < eElement.getElementsByTagName("experiencesPro").getLength(); i++){ 		    
		    	Object[] row ={eElement.getElementsByTagName("experiencesPro").item(i).getChildNodes().item(0).getTextContent(),
		    			eElement.getElementsByTagName("experiencesPro").item(i).getChildNodes().item(2).getTextContent(), 
		    			eElement.getElementsByTagName("experiencesPro").item(i).getChildNodes().item(1).getTextContent()};
	         DefaultTableModel tb =(DefaultTableModel) TExperiencePro.getModel();
	         tb.addRow(row);
		     }
		  for(int j = 0; j < eElement.getElementsByTagName("formations").getLength(); j++){ 		    
	    	Object[] row ={eElement.getElementsByTagName("formations").item(j).getChildNodes().item(1).getTextContent(),
	    			eElement.getElementsByTagName("formations").item(j).getChildNodes().item(2).getTextContent(), 
	    			eElement.getElementsByTagName("formations").item(j).getChildNodes().item(0).getTextContent()};
         DefaultTableModel tb =(DefaultTableModel) TFormations.getModel();
         tb.addRow(row);
	     }
		for(int k = 0; k < eElement.getElementsByTagName("langues").getLength(); k++){ 		    
	    	Object[] row ={eElement.getElementsByTagName("langues").item(k).getChildNodes().item(1).getTextContent(),
	    			eElement.getElementsByTagName("langues").item(k).getChildNodes().item(0).getTextContent()};
        DefaultTableModel tb =(DefaultTableModel) TLangues.getModel();
        tb.addRow(row);
	     }
		for(int m = 0; m < eElement.getElementsByTagName("competencesInfo").getLength(); m++){ 		    
   	Object[] row ={eElement.getElementsByTagName("competencesInfo").item(m).getChildNodes().item(1).getTextContent(),
   			eElement.getElementsByTagName("competencesInfo").item(m).getChildNodes().item(0).getTextContent()};
    DefaultTableModel tb =(DefaultTableModel) TCompetencesInfo.getModel();
    tb.addRow(row);
    }
    		}
	
		      
		     		}
		     	
		         
		      
		      } catch (Exception ex) {
		         ex.printStackTrace();
		      }
		
		   AgeField.setEditable(false);
		   CompetencesField.setEditable(false);
		   NomField.setEditable(false);
		   ObjectifField.setEditable(false);
		   PrenomField.setEditable(false);
   }

                        
   private void initComponents() {

       jLabel1 = new JLabel();
       jLabel2 = new JLabel();
       jLabel3 = new JLabel();
       jLabel4 = new JLabel();
       jLabel5 = new JLabel();
       jLabel6 = new JLabel();
       jLabel7 = new JLabel();
       jLabel9 = new JLabel();
       jLabel10 = new JLabel();
       NomField = new JTextField();
       PrenomField = new JTextField();
       AgeField = new JTextField();
       ObjectifField = new JTextField();
       CompetencesField = new JTextField();
       jScrollPane2 = new JScrollPane();
       TLangues = new JTable();
       jScrollPane3 = new JScrollPane();
       TCompetencesInfo = new JTable();
       jScrollPane4 = new JScrollPane();
       TFormations = new JTable();
       jScrollPane5 = new JScrollPane();
       TExperiencePro = new JTable();

       jLabel1.setText("Nom");

       jLabel2.setText("Prenom");

       jLabel3.setText("Age");

       jLabel4.setText("Objectif");

       jLabel5.setText("Comp\u00E9tences");

       jLabel6.setText("Langues");

       jLabel7.setText("Comp\u00E9tences informatiques");

       jLabel9.setText("Formations");

       jLabel10.setText("Exp\u00E9riences professionnelles");

       NomField.addActionListener(new java.awt.event.ActionListener() {
           public void actionPerformed(java.awt.event.ActionEvent evt) {
               NomFieldActionPerformed(evt);
           }
       });

       PrenomField.addActionListener(new java.awt.event.ActionListener() {
           public void actionPerformed(java.awt.event.ActionEvent evt) {
               PrenomFieldActionPerformed(evt);
           }
       });

       TLangues.setModel(new DefaultTableModel(
           new Object [][] {

           },
           new String [] {
               "Langue", "niveau"
           }
       ) {

		private static final long serialVersionUID = 4586624523631062164L;
		boolean[] canEdit = new boolean [] {
               false, false
           };

           public boolean isCellEditable(int rowIndex, int columnIndex) {
               return canEdit [columnIndex];
           }
       });
       jScrollPane2.setViewportView(TLangues);

       TCompetencesInfo.setModel(new DefaultTableModel(
           new Object [][] {

           },
           new String [] {
               "Nom", "Niveau"
           }
       ) {

		private static final long serialVersionUID = 7995636603946191375L;
		boolean[] canEdit = new boolean [] {
               false, false
           };

           public boolean isCellEditable(int rowIndex, int columnIndex) {
               return canEdit [columnIndex];
           }
       });
       jScrollPane3.setViewportView(TCompetencesInfo);

       TFormations.setModel(new DefaultTableModel(
           new Object [][] {

           },
           new String [] {
               "Ecole", "Ann\u00E9e", "Diplome"
           }
       ) {

		private static final long serialVersionUID = 3624917927198786563L;
		boolean[] canEdit = new boolean [] {
               false, false, false
           };

           public boolean isCellEditable(int rowIndex, int columnIndex) {
               return canEdit [columnIndex];
           }
       });
       jScrollPane4.setViewportView(TFormations);

       TExperiencePro.setModel(new DefaultTableModel(
           new Object [][] {

           },
           new String [] {
               "Ann\u00E9e", "Lieu", "Fonction"
           }
       ) {

		private static final long serialVersionUID = -5035256223437073588L;
		boolean[] canEdit = new boolean [] {
               false, false, false
           };

           public boolean isCellEditable(int rowIndex, int columnIndex) {
               return canEdit [columnIndex];
           }
       });
       jScrollPane5.setViewportView(TExperiencePro);

       GroupLayout layout = new GroupLayout(getContentPane());
       getContentPane().setLayout(layout);
       layout.setHorizontalGroup(
           layout.createParallelGroup(GroupLayout.Alignment.LEADING)
           .addGroup(layout.createSequentialGroup()
               .addGap(21, 21, 21)
               .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                   .addComponent(jLabel10)
                   .addComponent(jScrollPane5, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                   .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                       .addComponent(jScrollPane2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                       .addComponent(jScrollPane3, GroupLayout.PREFERRED_SIZE, 452, GroupLayout.PREFERRED_SIZE))
                   .addGroup(layout.createSequentialGroup()
                       .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                           .addComponent(jLabel3)
                           .addComponent(jLabel5)
                           .addComponent(jLabel6)
                           .addComponent(jLabel4)
                           .addComponent(jLabel1)
                           .addComponent(jLabel2))
                       .addGap(18, 18, 18)
                       .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                           .addComponent(PrenomField)
                           .addComponent(NomField)
                           .addComponent(ObjectifField)
                           .addComponent(CompetencesField, GroupLayout.DEFAULT_SIZE, 255, Short.MAX_VALUE)
                           .addComponent(AgeField, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)))
                   .addComponent(jScrollPane4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                   .addComponent(jLabel9)
                   .addComponent(jLabel7))
               .addGap(0, 189, Short.MAX_VALUE))
       );
       layout.setVerticalGroup(
           layout.createParallelGroup(GroupLayout.Alignment.LEADING)
           .addGroup(layout.createSequentialGroup()
               .addGap(16, 16, 16)
               .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                   .addComponent(jLabel1)
                   .addComponent(NomField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
               .addGap(18, 18, 18)
               .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                   .addComponent(jLabel2)
                   .addComponent(PrenomField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
               .addGap(18, 18, 18)
               .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                   .addComponent(jLabel3)
                   .addComponent(AgeField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
               .addGap(18, 18, 18)
               .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                   .addComponent(jLabel4)
                   .addComponent(ObjectifField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
               .addGap(18, 18, 18)
               .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                   .addComponent(jLabel5)
                   .addComponent(CompetencesField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
               .addGap(18, 18, 18)
               .addComponent(jLabel6)
               .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
               .addComponent(jScrollPane2, GroupLayout.PREFERRED_SIZE, 67, GroupLayout.PREFERRED_SIZE)
               .addGap(18, 18, 18)
               .addComponent(jLabel7)
               .addGap(11, 11, 11)
               .addComponent(jScrollPane3, GroupLayout.PREFERRED_SIZE, 71, GroupLayout.PREFERRED_SIZE)
               .addGap(18, 18, 18)
               .addComponent(jLabel9)
               .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
               .addComponent(jScrollPane4, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
               .addGap(18, 18, 18)
               .addComponent(jLabel10)
               .addGap(18, 18, 18)
               .addComponent(jScrollPane5, GroupLayout.PREFERRED_SIZE, 58, GroupLayout.PREFERRED_SIZE)
               .addContainerGap(42, Short.MAX_VALUE))
       );

       pack();
   }                  

   private void NomFieldActionPerformed(java.awt.event.ActionEvent evt) {                                         
       // TODO add your handling code here:
   }                                        

   private void PrenomFieldActionPerformed(java.awt.event.ActionEvent evt) {                                            
       // TODO add your handling code here:
   }                                           

   public JTextField getAgeField() {
		return AgeField;
	}

	public void setAgeField(JTextField ageField) {
		AgeField = ageField;
	}

	public JTextField getCompetencesField() {
		return CompetencesField;
	}

	public void setCompetencesField(JTextField competencesField) {
		CompetencesField = competencesField;
	}

	public JTextField getNomField() {
		return NomField;
	}

	public void setNomField(JTextField nomField) {
		NomField = nomField;
	}

	public JTextField getObjectifField() {
		return ObjectifField;
	}

	public void setObjectifField(JTextField objectifField) {
		ObjectifField = objectifField;
	}

	public JTextField getPrenomField() {
		return PrenomField;
	}

	public void setPrenomField(JTextField prenomField) {
		PrenomField = prenomField;
	}

	public JTable getTCompetencesInfo() {
		return TCompetencesInfo;
	}

	public void setTCompetencesInfo(JTable tCompetencesInfo) {
		TCompetencesInfo = tCompetencesInfo;
	}

	public JTable getTExperiencePro() {
		return TExperiencePro;
	}

	public void setTExperiencePro(JTable tExperiencePro) {
		TExperiencePro = tExperiencePro;
	}

	public JTable getTFormations() {
		return TFormations;
	}

	public void setTFormations(JTable tFormations) {
		TFormations = tFormations;
	}

	public JTable getTLangues() {
		return TLangues;
	}

	public void setTLangues(JTable tLangues) {
		TLangues = tLangues;
	}
}

