package chapter8;
import java.awt.*;  
import java.awt.event.*;  
import java.io.*;  
import javax.swing.*;   
import java.awt.datatransfer.*;  
 
public class NotepadSimple extends JFrame implements ActionListener {
   //�˵�  
   JMenu fileMenu,editMenu,helpMenu;  
   //�Ҽ������˵���  
   JPopupMenu popupMenu;  
   JMenuItem popupMenu_Cut,popupMenu_Copy,popupMenu_Paste;  
   //���ļ����Ĳ˵���  
   JMenuItem fileMenu_New,fileMenu_Open,fileMenu_Save,fileMenu_SaveAs,fileMenu_Exit;  
   //���༭���Ĳ˵���  
   JMenuItem editMenu_Cut,editMenu_Copy,editMenu_Paste;  
   //���������Ĳ˵���  
   JMenuItem helpMenu_HelpTopics,helpMenu_AboutNotepad;  
   //���ı����༭����  
   JTextArea editArea;    
   //ϵͳ������
   //Toolkit.getDefaultToolkit()���Ĭ�ϵĵײ�ؼ��Ļ�������
   Toolkit toolkit=Toolkit.getDefaultToolkit();  
   //Clipboardʵ��һ��ʹ�ü���/����/ճ�������������ݵĻ���
   Clipboard clipBoard=toolkit.getSystemClipboard();
   //��ű༭��ԭ�������ݣ����ڱȽ��ı��Ƿ��иĶ�  
   String oldValue; 
   //�Ƿ����ļ�(δ�������) 
   boolean isNewFile=true;
   //�½��ļ����󣬵�ǰ�ļ��� 
   File currentFile; 
   //���캯�� 
   public NotepadSimple()  
   {    
	   //����jFrame�Ĺ��췽��
       super("Java���±�");    
       //�����˵���  
       JMenuBar menuBar=new JMenuBar();  
       //�����ļ��˵����˵��ע���¼�����  
       fileMenu=new JMenu("�ļ�(F)");
       //���ÿ�ݼ�ALT+F
       fileMenu.setMnemonic('F');  
       fileMenu_New=new JMenuItem("�½�(N)");  
     //���ÿ�ݼ�ctrl+N
       fileMenu_New.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N,InputEvent.CTRL_MASK));  
       fileMenu_New.addActionListener(this);  
 
       fileMenu_Open=new JMenuItem("��(O)...");  
       fileMenu_Open.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O,InputEvent.CTRL_MASK));  
       fileMenu_Open.addActionListener(this);  
 
       fileMenu_Save=new JMenuItem("����(S)");  
       fileMenu_Save.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S,InputEvent.CTRL_MASK));  
       fileMenu_Save.addActionListener(this);  
 
       fileMenu_SaveAs=new JMenuItem("���Ϊ(A)...");  
       fileMenu_SaveAs.addActionListener(this);  
 
       fileMenu_Exit=new JMenuItem("�˳�(X)");  
       fileMenu_Exit.addActionListener(this);  
 
       //�����༭�˵����˵��ע���¼�����  
       editMenu=new JMenu("�༭(E)");  
       //���ÿ�ݼ�ALT+E 
       editMenu.setMnemonic('E');  
       editMenu_Cut=new JMenuItem("����(T)");  
       editMenu_Cut.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X,InputEvent.CTRL_MASK));  
       editMenu_Cut.addActionListener(this);  
 
       editMenu_Copy=new JMenuItem("����(C)");  
       editMenu_Copy.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C,InputEvent.CTRL_MASK));  
       editMenu_Copy.addActionListener(this);  
 
       editMenu_Paste=new JMenuItem("ճ��(P)");  
       editMenu_Paste.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_V,InputEvent.CTRL_MASK));  
       editMenu_Paste.addActionListener(this);  

       //���������˵����˵��ע���¼�����  
       helpMenu = new JMenu("����(H)");
       //���ÿ�ݼ�ALT+H 
       helpMenu.setMnemonic('H'); 
       helpMenu_HelpTopics = new JMenuItem("��������(H)");   
       helpMenu_HelpTopics.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F1,0));  
       helpMenu_HelpTopics.addActionListener(this);  
       helpMenu_AboutNotepad = new JMenuItem("���ڼ��±�(A)");   
       helpMenu_AboutNotepad.addActionListener(this);  
 
       //��˵������"�ļ�"�˵����˵���  
       menuBar.add(fileMenu);   
       fileMenu.add(fileMenu_New);   
       fileMenu.add(fileMenu_Open);   
       fileMenu.add(fileMenu_Save);   
       fileMenu.add(fileMenu_SaveAs);  
       //�ָ���  
       fileMenu.addSeparator();         
       fileMenu.add(fileMenu_Exit);   
 
       //��˵������"�༭"�˵����˵���   
       menuBar.add(editMenu);     
       editMenu.add(editMenu_Cut);   
       editMenu.add(editMenu_Copy);   
       editMenu.add(editMenu_Paste);     

       //��˵������"����"�˵����˵���  
       menuBar.add(helpMenu);  
       helpMenu.add(helpMenu_HelpTopics);  
       helpMenu.addSeparator();  
       helpMenu.add(helpMenu_AboutNotepad);                   
       //�򴰿���Ӳ˵���                
       this.setJMenuBar(menuBar);  
 
       //�����ı��༭������ӹ�����  
       editArea=new JTextArea(20,50);  
       JScrollPane scroller=new JScrollPane(editArea);  
       //���ô�ֱ������һֱ����
       scroller.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);  
       //���ı��༭����ӵ��м�����
       this.add(scroller,BorderLayout.CENTER); 
       //���õ�����һ�в�������ʱ����
       editArea.setWrapStyleWord(true); 
       //�����ı��༭���Զ�����Ĭ��Ϊtrue,����"�Զ�����"
       editArea.setLineWrap(true);  
       //��ȡԭ�ı��༭��������  
       oldValue=editArea.getText();
 
       //�����Ҽ������˵�  
       popupMenu=new JPopupMenu();    
       popupMenu_Cut=new JMenuItem("����(T)");  
       popupMenu_Copy=new JMenuItem("����(C)");  
       popupMenu_Paste=new JMenuItem("ճ��(P)");      
 
       //���Ҽ��˵���Ӳ˵���ͷָ���  
       popupMenu.add(popupMenu_Cut);  
       popupMenu.add(popupMenu_Copy);  
       popupMenu.add(popupMenu_Paste);   
 
       //�ı��༭��ע���Ҽ��˵��¼�   
       popupMenu_Cut.addActionListener(this);  
       popupMenu_Copy.addActionListener(this);  
       popupMenu_Paste.addActionListener(this);     
       //�ı��༭��ע���Ҽ��˵��¼�  
       editArea.addMouseListener(new MouseAdapter()  {   
    	   //����ͷ�  
           public void mouseReleased(MouseEvent e)  {   
        	   //���ش�����¼��Ƿ�Ϊ��ƽ̨�ĵ����˵������¼�
        	   if(e.isPopupTrigger())  { 
        		   //����������ߵ�����ռ��е�λ�� X��Y ��ʾ�����˵� 
        		   popupMenu.show(e.getComponent(),e.getX(),e.getY()); 
               }
        	   //���ü��У����ƣ�ճ����ɾ���ȹ��ܵĿ�����  
               checkMenuItemEnabled(); 
           }  
       }); 
 
       //���ô�������Ļ�ϵ�λ�á���С�Ϳɼ���   
       this.setLocation(100,100);  
       this.setSize(650,550);  
       this.setVisible(true);  
       this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
       checkMenuItemEnabled();  
       editArea.requestFocus();  
   }
   //���ò˵���Ŀ����ԣ����У����ƣ�ճ����ɾ������  
   public void checkMenuItemEnabled()  
   {   String selectText=editArea.getSelectedText();  
       if(selectText==null)  
       {   editMenu_Cut.setEnabled(false);  
           popupMenu_Cut.setEnabled(false);  
           editMenu_Copy.setEnabled(false);  
           popupMenu_Copy.setEnabled(false);   
       }  
       else  
       {   editMenu_Cut.setEnabled(true);  
           popupMenu_Cut.setEnabled(true);   
           editMenu_Copy.setEnabled(true);  
           popupMenu_Copy.setEnabled(true);   
       }  
       //ճ�����ܿ������ж�  
       Transferable contents=clipBoard.getContents(this);  
       if(contents==null)  
       {   editMenu_Paste.setEnabled(false);  
           popupMenu_Paste.setEnabled(false);  
       }  
       else  
       {   editMenu_Paste.setEnabled(true);  
           popupMenu_Paste.setEnabled(true);     
       }  
   }
   //�Զ������в���
   public void actionPerformed(ActionEvent e)  {
	   //�½�  
       if(e.getSource()==fileMenu_New)  {    
           String currentValue=editArea.getText();  
           boolean isTextChange=(currentValue.equals(oldValue))?false:true;  
           if(isTextChange)  
           {   int saveChoose=JOptionPane.showConfirmDialog(this,"�����ļ���δ���棬�Ƿ񱣴棿","��ʾ",JOptionPane.YES_NO_CANCEL_OPTION);  
               if(saveChoose==JOptionPane.YES_OPTION)  {
            	   String str=null;  
               	   //�½��ļ�ѡ����
                   JFileChooser fileChooser=new JFileChooser();  
                   //ֻ��ѡ���ļ�
                   fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);  
                   //�����ļ�ѡ��������  
                   fileChooser.setDialogTitle("���Ϊ"); 
                   //��ʾ�ļ�ѡ����
                   int result=fileChooser.showSaveDialog(this);
                   //��ȡ������ļ���
                   File saveFileName=fileChooser.getSelectedFile();  
                   if(saveFileName==null || saveFileName.getName().equals(""))  
                   {   JOptionPane.showMessageDialog(this,"���Ϸ����ļ���","���Ϸ����ļ���",JOptionPane.ERROR_MESSAGE);  
                   }  else   {   
                	   try  {   
                		   //�ļ�д������
                		   FileWriter fw=new FileWriter(saveFileName);
                		   //��������������
                           BufferedWriter bfw=new BufferedWriter(fw);  
                           //���ַ�����д�뵽�ı��ļ�
                           bfw.write(editArea.getText(),0,editArea.getText().length());  
                           //ˢ�¸����Ļ���  
                           bfw.flush();
                           bfw.close();  
                           isNewFile=false;  
                           currentFile=saveFileName;  
                           oldValue=editArea.getText();  
                           this.setTitle(saveFileName.getName()+" - ���±�");  
                       }  
                       catch (IOException ioException)  {  
                       }  
                   }  
               }  
               else if(saveChoose==JOptionPane.NO_OPTION)  {   
            	   //�ı�����Ϊ��
            	   editArea.replaceRange("",0,editArea.getText().length());  
                   this.setTitle("�ޱ��� - ���±�");  
                   isNewFile=true;    
                   oldValue=editArea.getText();  
               }  
               else if(saveChoose==JOptionPane.CANCEL_OPTION)  {
            	   return;  
               }  
           }   
       } 
       //��  
       else if(e.getSource()==fileMenu_Open)  
       {    
           String str=null;  
           JFileChooser fileChooser=new JFileChooser();  
           fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);  
           fileChooser.setDialogTitle("���ļ�");  
           int result=fileChooser.showOpenDialog(this);   
           File fileName=fileChooser.getSelectedFile();  
           if(fileName==null || fileName.getName().equals(""))  {  
        	   JOptionPane.showMessageDialog(this,"���Ϸ����ļ���","���Ϸ����ļ���",JOptionPane.ERROR_MESSAGE);  
           }  else  {   
        	   try  {   
        		   FileReader fr=new FileReader(fileName);  
                   BufferedReader bfr=new BufferedReader(fr);  
                   editArea.setText("");  
                   while((str=bfr.readLine())!=null)  {  
                	   editArea.append(str);  
                   }  
                   this.setTitle(fileName.getName()+" - ���±�");  
                   fr.close();  
                   isNewFile=false;  
                   currentFile=fileName;  
                   oldValue=editArea.getText();  
               }  catch (IOException ioException)  {  
               }  
           }   
       }
       //����  
       else if(e.getSource()==fileMenu_Save)  {    
           if(isNewFile)  {   
        	   String str=null;  
               JFileChooser fileChooser=new JFileChooser();  
               fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);  
               fileChooser.setDialogTitle("����");  
               int result=fileChooser.showSaveDialog(this);  
               File saveFileName=fileChooser.getSelectedFile();  
               if(saveFileName==null || saveFileName.getName().equals(""))  {   
            	   JOptionPane.showMessageDialog(this,"���Ϸ����ļ���","���Ϸ����ļ���",JOptionPane.ERROR_MESSAGE);  
               }  
               else   {   
            	   try  {   
            		   FileWriter fw=new FileWriter(saveFileName);  
                       BufferedWriter bfw=new BufferedWriter(fw);  
                       bfw.write(editArea.getText(),0,editArea.getText().length());  
                       //ˢ�¸����Ļ���  
                       bfw.flush();
                       bfw.close();  
                       isNewFile=false;  
                       currentFile=saveFileName;  
                       oldValue=editArea.getText();  
                       this.setTitle(saveFileName.getName()+" - ���±�");  
                   }  catch (IOException ioException)  {  
                   }  
               }  
           }  else  {   
        	   try  {   
        		   FileWriter fw=new FileWriter(currentFile);  
                   BufferedWriter bfw=new BufferedWriter(fw);  
                   bfw.write(editArea.getText(),0,editArea.getText().length());  
                   bfw.flush();  
                   fw.close();  
               }catch(IOException ioException)  {                     
               }  
           }  
       } 
       //���Ϊ  
       else if(e.getSource()==fileMenu_SaveAs)  {    
           String str=null;  
           JFileChooser fileChooser=new JFileChooser();  
           fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);  
           fileChooser.setDialogTitle("���Ϊ");  
           int result=fileChooser.showSaveDialog(this);                 
           File saveFileName=fileChooser.getSelectedFile();  
           if(saveFileName==null||saveFileName.getName().equals(""))  
           {   JOptionPane.showMessageDialog(this,"���Ϸ����ļ���","���Ϸ����ļ���",JOptionPane.ERROR_MESSAGE);  
           }     
           else   
           {   try  
               {   FileWriter fw=new FileWriter(saveFileName);  
                   BufferedWriter bfw=new BufferedWriter(fw);  
                   bfw.write(editArea.getText(),0,editArea.getText().length());  
                   bfw.flush();  
                   fw.close();  
                   oldValue=editArea.getText();  
                   this.setTitle(saveFileName.getName()+"  - ���±�");   
               }                         
               catch(IOException ioException)  
               {                     
               }                 
           }  
       } 
       //�˳�  
       else if(e.getSource()==fileMenu_Exit)  
       {   int exitChoose=JOptionPane.showConfirmDialog(this,"ȷ��Ҫ�˳���?","�˳���ʾ",JOptionPane.OK_CANCEL_OPTION);  
           if(exitChoose==JOptionPane.OK_OPTION)  
           {   System.exit(0);  
           }  
           else  
           {   return;  
           }  
       }     
       //����  
       else if(e.getSource()==editMenu_Cut || e.getSource()==popupMenu_Cut)  {   
           //��ȡѡ����ı�
           String text=editArea.getSelectedText(); 
           //StringSelection���ڴ���ѡȡ���ı�
           StringSelection selection=new StringSelection(text); 
           //����ѡ����ı�
           clipBoard.setContents(selection,null);  
           //�ÿմ���ѡ�����ַ���
           editArea.replaceRange("",editArea.getSelectionStart(),editArea.getSelectionEnd());  
           checkMenuItemEnabled();  
       } 
       //����  
       else if(e.getSource()==editMenu_Copy || e.getSource()==popupMenu_Copy)  
       {   editArea.requestFocus();  
           String text=editArea.getSelectedText();  
           StringSelection selection=new StringSelection(text);  
           clipBoard.setContents(selection,null);  
           checkMenuItemEnabled();
       }  
       //ճ��  
       else if(e.getSource()==editMenu_Paste || e.getSource()==popupMenu_Paste)  {   
           //Transferable���崫������ṩ����ʹ�õĽӿڣ�getContents��ȡ���������
           Transferable contents=clipBoard.getContents(this);  
           if(contents==null)return;  
           String text="";  
           try  
           {   
        	   //ʵ����һ��DataFlavor������ȡ�������ϵ�����
        	   text=(String)contents.getTransferData(DataFlavor.stringFlavor);  
           }  
           catch (Exception exception)  
           {  
           }  
           editArea.replaceRange(text,editArea.getSelectionStart(),editArea.getSelectionEnd());  
           checkMenuItemEnabled();  
       }         
       //��������  
       else if(e.getSource()==helpMenu_HelpTopics)  {   
           JOptionPane.showMessageDialog(this,"�Լ���취!!!","��������",JOptionPane.INFORMATION_MESSAGE);  
       } 
       //����  
       else if(e.getSource()==helpMenu_AboutNotepad)  {   
           JOptionPane.showMessageDialog(this,  
               "-------------------------------------------------------------------------------\n"+  
               " ��д�ߣ�Niubi Panel \n"+  
               " ��дʱ�䣺2019-12-04                          \n"+  
               " e-mail��923062186@qq.com                \n"+  
               " һЩ�ط�������ˣ�����֮��ϣ���������������лл��  \n"+  
               "-------------------------------------------------------------------------------\n",  
               "���±�",JOptionPane.INFORMATION_MESSAGE);  
       } 
   }  
   //main���� 
   public static void main(String args[])  {   
	   NotepadSimple notepad=new NotepadSimple();   
   } 
} 
