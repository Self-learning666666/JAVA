package chapter8;
import java.awt.*;  
import java.awt.event.*;  
import java.io.*;  
import javax.swing.*;   
import java.awt.datatransfer.*;  
 
public class NotepadSimple extends JFrame implements ActionListener {
   //菜单  
   JMenu fileMenu,editMenu,helpMenu;  
   //右键弹出菜单项  
   JPopupMenu popupMenu;  
   JMenuItem popupMenu_Cut,popupMenu_Copy,popupMenu_Paste;  
   //“文件”的菜单项  
   JMenuItem fileMenu_New,fileMenu_Open,fileMenu_Save,fileMenu_SaveAs,fileMenu_Exit;  
   //“编辑”的菜单项  
   JMenuItem editMenu_Cut,editMenu_Copy,editMenu_Paste;  
   //“帮助”的菜单项  
   JMenuItem helpMenu_HelpTopics,helpMenu_AboutNotepad;  
   //“文本”编辑区域  
   JTextArea editArea;    
   //系统剪贴板
   //Toolkit.getDefaultToolkit()获得默认的底层控件的基本功能
   Toolkit toolkit=Toolkit.getDefaultToolkit();  
   //Clipboard实现一种使用剪切/复制/粘贴操作传输数据的机制
   Clipboard clipBoard=toolkit.getSystemClipboard();
   //存放编辑区原来的内容，用于比较文本是否有改动  
   String oldValue; 
   //是否新文件(未保存过的) 
   boolean isNewFile=true;
   //新建文件对象，当前文件名 
   File currentFile; 
   //构造函数 
   public NotepadSimple()  
   {    
	   //调用jFrame的构造方法
       super("Java记事本");    
       //创建菜单条  
       JMenuBar menuBar=new JMenuBar();  
       //创建文件菜单及菜单项并注册事件监听  
       fileMenu=new JMenu("文件(F)");
       //设置快捷键ALT+F
       fileMenu.setMnemonic('F');  
       fileMenu_New=new JMenuItem("新建(N)");  
     //设置快捷键ctrl+N
       fileMenu_New.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N,InputEvent.CTRL_MASK));  
       fileMenu_New.addActionListener(this);  
 
       fileMenu_Open=new JMenuItem("打开(O)...");  
       fileMenu_Open.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O,InputEvent.CTRL_MASK));  
       fileMenu_Open.addActionListener(this);  
 
       fileMenu_Save=new JMenuItem("保存(S)");  
       fileMenu_Save.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S,InputEvent.CTRL_MASK));  
       fileMenu_Save.addActionListener(this);  
 
       fileMenu_SaveAs=new JMenuItem("另存为(A)...");  
       fileMenu_SaveAs.addActionListener(this);  
 
       fileMenu_Exit=new JMenuItem("退出(X)");  
       fileMenu_Exit.addActionListener(this);  
 
       //创建编辑菜单及菜单项并注册事件监听  
       editMenu=new JMenu("编辑(E)");  
       //设置快捷键ALT+E 
       editMenu.setMnemonic('E');  
       editMenu_Cut=new JMenuItem("剪切(T)");  
       editMenu_Cut.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X,InputEvent.CTRL_MASK));  
       editMenu_Cut.addActionListener(this);  
 
       editMenu_Copy=new JMenuItem("复制(C)");  
       editMenu_Copy.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C,InputEvent.CTRL_MASK));  
       editMenu_Copy.addActionListener(this);  
 
       editMenu_Paste=new JMenuItem("粘贴(P)");  
       editMenu_Paste.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_V,InputEvent.CTRL_MASK));  
       editMenu_Paste.addActionListener(this);  

       //创建帮助菜单及菜单项并注册事件监听  
       helpMenu = new JMenu("帮助(H)");
       //设置快捷键ALT+H 
       helpMenu.setMnemonic('H'); 
       helpMenu_HelpTopics = new JMenuItem("帮助主题(H)");   
       helpMenu_HelpTopics.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F1,0));  
       helpMenu_HelpTopics.addActionListener(this);  
       helpMenu_AboutNotepad = new JMenuItem("关于记事本(A)");   
       helpMenu_AboutNotepad.addActionListener(this);  
 
       //向菜单条添加"文件"菜单及菜单项  
       menuBar.add(fileMenu);   
       fileMenu.add(fileMenu_New);   
       fileMenu.add(fileMenu_Open);   
       fileMenu.add(fileMenu_Save);   
       fileMenu.add(fileMenu_SaveAs);  
       //分隔线  
       fileMenu.addSeparator();         
       fileMenu.add(fileMenu_Exit);   
 
       //向菜单条添加"编辑"菜单及菜单项   
       menuBar.add(editMenu);     
       editMenu.add(editMenu_Cut);   
       editMenu.add(editMenu_Copy);   
       editMenu.add(editMenu_Paste);     

       //向菜单条添加"帮助"菜单及菜单项  
       menuBar.add(helpMenu);  
       helpMenu.add(helpMenu_HelpTopics);  
       helpMenu.addSeparator();  
       helpMenu.add(helpMenu_AboutNotepad);                   
       //向窗口添加菜单条                
       this.setJMenuBar(menuBar);  
 
       //创建文本编辑区并添加滚动条  
       editArea=new JTextArea(20,50);  
       JScrollPane scroller=new JScrollPane(editArea);  
       //设置垂直滚动条一直存在
       scroller.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);  
       //将文本编辑区添加到中间区域
       this.add(scroller,BorderLayout.CENTER); 
       //设置单词在一行不足容纳时换行
       editArea.setWrapStyleWord(true); 
       //设置文本编辑区自动换行默认为true,即会"自动换行"
       editArea.setLineWrap(true);  
       //获取原文本编辑区的内容  
       oldValue=editArea.getText();
 
       //创建右键弹出菜单  
       popupMenu=new JPopupMenu();    
       popupMenu_Cut=new JMenuItem("剪切(T)");  
       popupMenu_Copy=new JMenuItem("复制(C)");  
       popupMenu_Paste=new JMenuItem("粘帖(P)");      
 
       //向右键菜单添加菜单项和分隔符  
       popupMenu.add(popupMenu_Cut);  
       popupMenu.add(popupMenu_Copy);  
       popupMenu.add(popupMenu_Paste);   
 
       //文本编辑区注册右键菜单事件   
       popupMenu_Cut.addActionListener(this);  
       popupMenu_Copy.addActionListener(this);  
       popupMenu_Paste.addActionListener(this);     
       //文本编辑区注册右键菜单事件  
       editArea.addMouseListener(new MouseAdapter()  {   
    	   //鼠标释放  
           public void mouseReleased(MouseEvent e)  {   
        	   //返回此鼠标事件是否为该平台的弹出菜单触发事件
        	   if(e.isPopupTrigger())  { 
        		   //在组件调用者的坐标空间中的位置 X、Y 显示弹出菜单 
        		   popupMenu.show(e.getComponent(),e.getX(),e.getY()); 
               }
        	   //设置剪切，复制，粘帖，删除等功能的可用性  
               checkMenuItemEnabled(); 
           }  
       }); 
 
       //设置窗口在屏幕上的位置、大小和可见性   
       this.setLocation(100,100);  
       this.setSize(650,550);  
       this.setVisible(true);  
       this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
       checkMenuItemEnabled();  
       editArea.requestFocus();  
   }
   //设置菜单项的可用性：剪切，复制，粘帖，删除功能  
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
       //粘帖功能可用性判断  
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
   //对动作进行操作
   public void actionPerformed(ActionEvent e)  {
	   //新建  
       if(e.getSource()==fileMenu_New)  {    
           String currentValue=editArea.getText();  
           boolean isTextChange=(currentValue.equals(oldValue))?false:true;  
           if(isTextChange)  
           {   int saveChoose=JOptionPane.showConfirmDialog(this,"您的文件尚未保存，是否保存？","提示",JOptionPane.YES_NO_CANCEL_OPTION);  
               if(saveChoose==JOptionPane.YES_OPTION)  {
            	   String str=null;  
               	   //新建文件选择器
                   JFileChooser fileChooser=new JFileChooser();  
                   //只能选择文件
                   fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);  
                   //设置文件选择器标题  
                   fileChooser.setDialogTitle("另存为"); 
                   //显示文件选择器
                   int result=fileChooser.showSaveDialog(this);
                   //获取输入的文件名
                   File saveFileName=fileChooser.getSelectedFile();  
                   if(saveFileName==null || saveFileName.getName().equals(""))  
                   {   JOptionPane.showMessageDialog(this,"不合法的文件名","不合法的文件名",JOptionPane.ERROR_MESSAGE);  
                   }  else   {   
                	   try  {   
                		   //文件写入数据
                		   FileWriter fw=new FileWriter(saveFileName);
                		   //创建缓冲区对象
                           BufferedWriter bfw=new BufferedWriter(fw);  
                           //将字符数据写入到文本文件
                           bfw.write(editArea.getText(),0,editArea.getText().length());  
                           //刷新该流的缓冲  
                           bfw.flush();
                           bfw.close();  
                           isNewFile=false;  
                           currentFile=saveFileName;  
                           oldValue=editArea.getText();  
                           this.setTitle(saveFileName.getName()+" - 记事本");  
                       }  
                       catch (IOException ioException)  {  
                       }  
                   }  
               }  
               else if(saveChoose==JOptionPane.NO_OPTION)  {   
            	   //文本代替为空
            	   editArea.replaceRange("",0,editArea.getText().length());  
                   this.setTitle("无标题 - 记事本");  
                   isNewFile=true;    
                   oldValue=editArea.getText();  
               }  
               else if(saveChoose==JOptionPane.CANCEL_OPTION)  {
            	   return;  
               }  
           }   
       } 
       //打开  
       else if(e.getSource()==fileMenu_Open)  
       {    
           String str=null;  
           JFileChooser fileChooser=new JFileChooser();  
           fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);  
           fileChooser.setDialogTitle("打开文件");  
           int result=fileChooser.showOpenDialog(this);   
           File fileName=fileChooser.getSelectedFile();  
           if(fileName==null || fileName.getName().equals(""))  {  
        	   JOptionPane.showMessageDialog(this,"不合法的文件名","不合法的文件名",JOptionPane.ERROR_MESSAGE);  
           }  else  {   
        	   try  {   
        		   FileReader fr=new FileReader(fileName);  
                   BufferedReader bfr=new BufferedReader(fr);  
                   editArea.setText("");  
                   while((str=bfr.readLine())!=null)  {  
                	   editArea.append(str);  
                   }  
                   this.setTitle(fileName.getName()+" - 记事本");  
                   fr.close();  
                   isNewFile=false;  
                   currentFile=fileName;  
                   oldValue=editArea.getText();  
               }  catch (IOException ioException)  {  
               }  
           }   
       }
       //保存  
       else if(e.getSource()==fileMenu_Save)  {    
           if(isNewFile)  {   
        	   String str=null;  
               JFileChooser fileChooser=new JFileChooser();  
               fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);  
               fileChooser.setDialogTitle("保存");  
               int result=fileChooser.showSaveDialog(this);  
               File saveFileName=fileChooser.getSelectedFile();  
               if(saveFileName==null || saveFileName.getName().equals(""))  {   
            	   JOptionPane.showMessageDialog(this,"不合法的文件名","不合法的文件名",JOptionPane.ERROR_MESSAGE);  
               }  
               else   {   
            	   try  {   
            		   FileWriter fw=new FileWriter(saveFileName);  
                       BufferedWriter bfw=new BufferedWriter(fw);  
                       bfw.write(editArea.getText(),0,editArea.getText().length());  
                       //刷新该流的缓冲  
                       bfw.flush();
                       bfw.close();  
                       isNewFile=false;  
                       currentFile=saveFileName;  
                       oldValue=editArea.getText();  
                       this.setTitle(saveFileName.getName()+" - 记事本");  
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
       //另存为  
       else if(e.getSource()==fileMenu_SaveAs)  {    
           String str=null;  
           JFileChooser fileChooser=new JFileChooser();  
           fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);  
           fileChooser.setDialogTitle("另存为");  
           int result=fileChooser.showSaveDialog(this);                 
           File saveFileName=fileChooser.getSelectedFile();  
           if(saveFileName==null||saveFileName.getName().equals(""))  
           {   JOptionPane.showMessageDialog(this,"不合法的文件名","不合法的文件名",JOptionPane.ERROR_MESSAGE);  
           }     
           else   
           {   try  
               {   FileWriter fw=new FileWriter(saveFileName);  
                   BufferedWriter bfw=new BufferedWriter(fw);  
                   bfw.write(editArea.getText(),0,editArea.getText().length());  
                   bfw.flush();  
                   fw.close();  
                   oldValue=editArea.getText();  
                   this.setTitle(saveFileName.getName()+"  - 记事本");   
               }                         
               catch(IOException ioException)  
               {                     
               }                 
           }  
       } 
       //退出  
       else if(e.getSource()==fileMenu_Exit)  
       {   int exitChoose=JOptionPane.showConfirmDialog(this,"确定要退出吗?","退出提示",JOptionPane.OK_CANCEL_OPTION);  
           if(exitChoose==JOptionPane.OK_OPTION)  
           {   System.exit(0);  
           }  
           else  
           {   return;  
           }  
       }     
       //剪切  
       else if(e.getSource()==editMenu_Cut || e.getSource()==popupMenu_Cut)  {   
           //获取选择的文本
           String text=editArea.getSelectedText(); 
           //StringSelection用于传输选取的文本
           StringSelection selection=new StringSelection(text); 
           //调用选择的文本
           clipBoard.setContents(selection,null);  
           //用空代替选定的字符串
           editArea.replaceRange("",editArea.getSelectionStart(),editArea.getSelectionEnd());  
           checkMenuItemEnabled();  
       } 
       //复制  
       else if(e.getSource()==editMenu_Copy || e.getSource()==popupMenu_Copy)  
       {   editArea.requestFocus();  
           String text=editArea.getSelectedText();  
           StringSelection selection=new StringSelection(text);  
           clipBoard.setContents(selection,null);  
           checkMenuItemEnabled();
       }  
       //粘帖  
       else if(e.getSource()==editMenu_Paste || e.getSource()==popupMenu_Paste)  {   
           //Transferable定义传输操作提供数据使用的接口，getContents获取传输的内容
           Transferable contents=clipBoard.getContents(this);  
           if(contents==null)return;  
           String text="";  
           try  
           {   
        	   //实例化一个DataFlavor用来读取剪贴板上的内容
        	   text=(String)contents.getTransferData(DataFlavor.stringFlavor);  
           }  
           catch (Exception exception)  
           {  
           }  
           editArea.replaceRange(text,editArea.getSelectionStart(),editArea.getSelectionEnd());  
           checkMenuItemEnabled();  
       }         
       //帮助主题  
       else if(e.getSource()==helpMenu_HelpTopics)  {   
           JOptionPane.showMessageDialog(this,"自己想办法!!!","帮助主题",JOptionPane.INFORMATION_MESSAGE);  
       } 
       //关于  
       else if(e.getSource()==helpMenu_AboutNotepad)  {   
           JOptionPane.showMessageDialog(this,  
               "-------------------------------------------------------------------------------\n"+  
               " 编写者：Niubi Panel \n"+  
               " 编写时间：2019-12-04                          \n"+  
               " e-mail：923062186@qq.com                \n"+  
               " 一些地方借鉴他人，不足之处希望大家能提出意见，谢谢！  \n"+  
               "-------------------------------------------------------------------------------\n",  
               "记事本",JOptionPane.INFORMATION_MESSAGE);  
       } 
   }  
   //main函数 
   public static void main(String args[])  {   
	   NotepadSimple notepad=new NotepadSimple();   
   } 
} 
