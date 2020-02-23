/*     */ package pixelart.exemples;
/*     */ import java.awt.event.ActionEvent;
/*     */ import java.awt.event.ActionListener;
/*     */ import java.awt.event.ItemEvent;
/*     */ import java.awt.event.ItemListener;
/*     */ import java.util.Hashtable;
/*     */ import java.util.Iterator;
/*     */ import java.util.Map;
/*     */ import javax.swing.JButton;
/*     */ import javax.swing.JComboBox;
/*     */ import javax.swing.JFrame;
/*     */ import javax.swing.JLabel;
/*     */ import javax.swing.JPanel;
/*     */ import javax.swing.JTable;
/*     */ import javax.swing.JTextArea;
/*     */ import javax.swing.event.TableModelListener;
/*     */ import javax.swing.table.TableModel;
/*     */ import pixelart.exemples.neuralnetwerken.Colors;
/*     */ import pixelart.exemples.planets.Planets;
/*     */ import pixelart.exemples.planets.Planets2;
/*     */ 
/*     */ public class JRunner extends Runner {
/*     */   public void test() {
/*  24 */     Hashtable<String, Object> gens = new Hashtable<String, Object>();
/*  25 */     gens.put("ecran", Boolean.valueOf(true));
/*  26 */     gens.put("largeur", Integer.valueOf(1388));
/*  27 */     gens.put("hauteur", Integer.valueOf(768));
/*  28 */     gens.put("nombre", Integer.valueOf(2000));
/*  29 */     addGen(pixelart.exemples.maxibulles.Bulles.class, gens);
/*  30 */     gens = new Hashtable<String, Object>();
/*  31 */     gens.put("ecran", Boolean.valueOf(true));
/*  32 */     gens.put("largeur", Integer.valueOf(1388));
/*  33 */     gens.put("hauteur", Integer.valueOf(768));
/*  34 */     gens.put("nombre", Integer.valueOf(2000));
/*  35 */     addGen(Colors.class, gens);
/*  36 */     gens = new Hashtable<String, Object>();
/*  37 */     gens.put("ecran", Boolean.valueOf(true));
/*  38 */     gens.put("largeur", Integer.valueOf(1388));
/*  39 */     gens.put("hauteur", Integer.valueOf(768));
/*  40 */     gens.put("numElectrons", Integer.valueOf(200));
/*  41 */     gens.put("nombre", Integer.valueOf(2000));
/*  42 */     addGen(Planets.class, gens);
/*  43 */     gens = new Hashtable<String, Object>();
/*  44 */     gens.put("ecran", Boolean.valueOf(true));
/*  45 */     gens.put("largeur", Integer.valueOf(1388));
/*  46 */     gens.put("hauteur", Integer.valueOf(768));
/*  47 */     gens.put("numElectrons", Integer.valueOf(200));
/*  48 */     gens.put("nombre", Integer.valueOf(2000));
/*  49 */     addGen(pixelart.exemples.planets.Planets2.class, gens);
/*     */   }
/*     */ 
/*     */   
/*     */   public class JButton2
/*     */     extends JButton
/*     */   {
/*     */     private static final long serialVersionUID = -653490506806790496L;
/*     */     
/*     */     private String item;
/*     */     
/*     */     public JButton2(String string) {
/*  61 */       super(string);
/*     */     }
/*     */     
/*     */     public void setItem(String item) {
/*  65 */       this.item = item;
/*     */     }
/*     */     
/*     */     public String getItem() {
/*  69 */       return this.item;
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public class JComboBox2
/*     */     extends JComboBox
/*     */   {
/*     */     private static final long serialVersionUID = 3385956098648555129L;
/*     */     
/*     */     private JRunner.JButton2 jbutton;
/*     */     
/*     */     public void setButton(JRunner.JButton2 jbutton) {
/*  82 */       setJbutton(jbutton);
/*     */     }
/*     */     
/*     */     public void setJbutton(JRunner.JButton2 jbutton) {
/*  86 */       this.jbutton = jbutton;
/*     */     }
/*     */     
/*     */     public JRunner.JButton2 getJbutton() {
/*  90 */       return this.jbutton;
/*     */     }
/*     */   }
/*     */   
/*     */   public class JTable2
/*     */     extends JTable
/*     */   {
/*     */     private static final long serialVersionUID = 2774980650901708095L;
/*     */     private Class theClass;
/*     */     
/*     */     public JTable2(int rows, int cols) {
/* 101 */       super(rows, cols);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public Class getTheClass() {
/* 109 */       return this.theClass;
/*     */     }
/*     */   }
/*     */   
/*     */   public class GenTableModel implements TableModel {
/*     */     private Object[][] data;
/*     */     private Hashtable<String, Object> gen;
/*     */     
/*     */     public GenTableModel(int rows, int cols, Hashtable<String, Object> gen) {
/* 118 */       this.data = new Object[rows][cols];
/* 119 */       this.gen = gen;
/* 120 */       Iterator<Map.Entry<String, Object>> it = gen.entrySet().iterator();
/* 121 */       int i = 0;
/* 122 */       while (it.hasNext()) {
/* 123 */         Map.Entry<String, Object> e = it.next();
/* 124 */         this.data[i][0] = e.getKey();
/* 125 */         this.data[i][1] = e.getValue();
/* 126 */         i++;
/*     */       } 
/*     */     }
/*     */     
/*     */     public void save() {
/* 131 */       this.gen.clear();
/* 132 */       for (int i = 0; i < this.data.length; i++) {
/* 133 */         if (this.data[i][0] != null) {
/* 134 */           this.gen.put((String)this.data[i][0], this.data[i][1]);
/*     */         }
/*     */       } 
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public void addTableModelListener(TableModelListener l) {}
/*     */ 
/*     */ 
/*     */     
/*     */     public Class<?> getColumnClass(int columnIndex) {
/* 146 */       return (columnIndex == 0) ? String.class : Object.class;
/*     */     }
/*     */ 
/*     */     
/*     */     public int getColumnCount() {
/* 151 */       return (this.data[0]).length;
/*     */     }
/*     */ 
/*     */     
/*     */     public String getColumnName(int columnIndex) {
/* 156 */       return ""+ columnIndex;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public int getRowCount() {
/* 162 */       return this.data.length;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public Object getValueAt(int rowIndex, int columnIndex) {
/* 168 */       return this.data[rowIndex][columnIndex];
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean isCellEditable(int rowIndex, int columnIndex) {
/* 173 */       return true;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public void removeTableModelListener(TableModelListener l) {}
/*     */ 
/*     */ 
/*     */     
/*     */     public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
/* 184 */       this.data[rowIndex][columnIndex] = aValue;
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void choix() {
/* 192 */     JFrame jFrame = new JFrame("Choisir");
/* 193 */     JPanel jPanel = new JPanel();
/* 194 */     final JTable2 table = new JTable2(20, 3);
/* 195 */     final JLabel label = new JLabel("");
/* 196 */     jFrame.add(jPanel);
/* 197 */     jFrame.setContentPane(jPanel);
/* 198 */     jFrame.setBounds(0, 0, 800, 600);
/* 199 */     JComboBox2 combobox = new JComboBox2();
/* 200 */     final JButton2 jbutton = new JButton2("GO!");
/* 201 */     Iterator<Map.Entry<Class, Hashtable<String, Object>>> it2 = getGens()
/* 202 */       .entrySet().iterator();
/* 203 */     while (it2.hasNext()) {
/* 204 */       Map.Entry<Class, Hashtable<String, Object>> o = it2.next();
/* 205 */       combobox.addItem(((Class)o.getKey()).getName());
/*     */     } 
/* 207 */     combobox.addItemListener(new ItemListener()
/*     */         {
/*     */           public JRunner.JTable2 getProprietes(Class<?> theClass, JRunner.JTable2 table) {
/* 210 */             for (int i = 0; i < table.getRowCount(); i++) {
/* 211 */               for (int j = 0; j < table.getColumnCount(); j++)
/* 212 */                 table.getModel().setValueAt("", i, j); 
/* 213 */             }  Hashtable<String, Object> gen = JRunner.this.getGens().get(theClass);
/*     */             
/* 215 */             table.setModel(new JRunner.GenTableModel(20, 2, gen));
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */             
/* 226 */             return table;
/*     */           }
/*     */ 
/*     */           
/*     */           public void itemStateChanged(ItemEvent e) {
/* 231 */             jbutton.setItem(e.getItem().toString());
/*     */             
/*     */             try {
/* 234 */               getProprietes(Class.forName(e.getItem().toString()), table);
/* 235 */             } catch (ClassNotFoundException e1) {
/*     */               
/* 237 */               e1.printStackTrace();
/*     */             } 
/*     */           }
/*     */         });
/*     */ 
/*     */     
/* 243 */     jbutton.addActionListener(new ActionListener()
/*     */         {
/*     */           public void actionPerformed(ActionEvent arg0)
/*     */           {
/*     */             try {
/*     */               try {
/* 249 */                 ((JRunner.GenTableModel)table.getModel()).save();
/* 250 */                 JRunner.this.doit(Class.forName(jbutton.item), label);
/* 251 */               } catch (ClassNotFoundException e1) {
/*     */                 
/* 253 */                 e1.printStackTrace();
/*     */               } 
/* 255 */             } catch (InstantiationException e1) {
/*     */               
/* 257 */               e1.printStackTrace();
/* 258 */             } catch (IllegalAccessException e1) {
/*     */               
/* 260 */               e1.printStackTrace();
/*     */             } 
/* 262 */             if (jbutton.getText().equals("GO!")) {
/* 263 */               jbutton.setText("STOP");
/*     */             } else {
/* 265 */               jbutton.setText("GO!");
/*     */             } 
/*     */           }
/*     */         });
/* 269 */     JTextArea textarea = new JTextArea();
/* 270 */     textarea.setBounds(0, 0, 320, 200);
/* 271 */     jPanel.add(combobox);
/* 272 */     jPanel.add(textarea);
/* 273 */     jPanel.add(table);
/* 274 */     jPanel.add(jbutton);
/* 275 */     jPanel.add(label);
/* 276 */     jFrame.pack();
/* 277 */     jFrame.setVisible(true);
/*     */   }
/*     */   
/*     */   public static void main(String[] args) {
/* 281 */     JRunner jr = new JRunner();
/* 282 */     jr.test();
/* 283 */     jr.choix();
/*     */   }
/*     */ }


/* Location:              C:\Users\P1779\Downloads\pixelart.jar!\pixelart\exemples\JRunner.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */