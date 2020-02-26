package PJ;

import java.awt.BorderLayout;

import java.awt.EventQueue;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.DocumentEvent;
import javax.swing.plaf.FontUIResource;
import javax.swing.text.Document;

import PJ.cpu.MyThread;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.Box;
import javax.swing.ImageIcon;

import java.awt.event.ActionListener;
import java.util.Enumeration;
import java.util.Scanner;
import java.awt.event.ActionEvent;
import javax.swing.JScrollBar;
import javax.swing.JProgressBar;
import javax.swing.JSlider;
import javax.swing.JToggleButton;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.JTextField;
import java.awt.Label;
import javax.swing.JTextArea;
import java.awt.Color;
import javax.swing.JDesktopPane;
import javax.swing.JInternalFrame;
import javax.swing.JLayeredPane;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.JComboBox;
import javax.swing.JList;
import javax.swing.JTree;
import javax.swing.JTable;
import javax.swing.JPopupMenu;
import java.awt.Component;
import java.awt.Container;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;

import javax.swing.JFormattedTextField;
import java.awt.Panel;
import javax.swing.border.TitledBorder;
import javax.swing.JSplitPane;



public class gui extends JFrame {

	cpu hxy = new cpu() ;
	private JPanel contentPane;
	private JTextField W_S_Stat;
	private JTextField W_I_Stat;
	private JTextField W_S_Instr;
	private JTextField W_I_Instr;
	private JTextField W_S_valE;
	private JTextField W_I_valE;
	private JTextField W_S_valM;
	private JTextField W_I_valM;
	private JTextField W_S_dstE;
	private JTextField W_I_dstE;
	private JTextField W_S_dstM;
	private JTextField W_I_dstM;
	private JTextField M_I_Stat;
	private JTextField M_S_Stat;
	private JTextField M_S_Instr;
	private JTextField M_I_Instr;
	private JTextField M_I_valE;
	private JTextField M_S_valE;
	private JTextField M_S_valA;
	private JTextField M_I_valA;
	private JTextField M_I_dstE;
	private JTextField M_S_dstE;
	private JTextField M_S_dstM;
	private JTextField M_I_dstM;
	private JTextField M_S_Cnd;
	private JTextField M_I_Cnd;
	private JTextField E_I_Stat;
	private JTextField E_S_Stat;
	private JTextField E_S_Instr;
	private JTextField E_I_Instr;
	private JTextField E_I_valC;
	private JTextField E_S_valC;
	private JTextField E_S_valA;
	private JTextField E_I_valA;
	private JTextField E_I_dstE;
	private JTextField E_S_dstE;
	private JTextField E_S_dstM;
	private JTextField E_I_dstM;
	private JTextField E_S_valB;
	private JTextField E_I_valB;
	private JTextField E_I_srcA;
	private JTextField E_S_srcA;
	private JLabel lblSrca;
	private JLabel lblSrcb;
	private JTextField E_S_srcB;
	private JTextField E_I_srcB;
	private JLabel lblD;
	private JLabel label_13;
	private JLabel label_17;
	private JTextField D_I_Stat;
	private JTextField D_S_Stat;
	private JLabel label_18;
	private JLabel label_19;
	private JTextField D_S_Instr;
	private JTextField D_I_Instr;
	private JTextField D_I_valC;
	private JTextField D_S_valC;
	private JLabel lblValc_1;
	private JLabel lblValp;
	private JTextField D_S_valP;
	private JTextField D_I_valP;
	private JTextField D_I_rA;
	private JTextField D_S_rA;
	private JLabel lblRa;
	private JLabel lblRb;
	private JTextField D_S_rB;
	private JTextField D_I_rB;
	private JLabel lblF;
	private JLabel label_20;
	private JLabel label_21;
	private JTextField F_I_Stat;
	private JTextField F_S_Stat;
	private JLabel label_22;
	private JLabel lblPredpc;
	private JTextField F_S_predPC;
	private JTextField F_I_predPC;
	private JLabel lblrsp;
	private JLabel lblrbp;
	private JTextField rax;
	private JTextField rcx;
	private JTextField rdx;
	private JTextField rbx;
	private JTextField rsp;
	private JTextField rbp;
	private JLabel lblrsi;
	private JLabel lblrdi;
	private JLabel lblr;
	private JLabel lblr_1;
	private JLabel lblr_2;
	private JLabel lblr_3;
	private JTextField rsi;
	private JTextField rdi;
	private JTextField r8;
	private JTextField r9;
	private JTextField r10;
	private JTextField r11;
	private JLabel lblr_4;
	private JLabel lblr_5;
	private JLabel lblr_6;
	private JTextField r12;
	private JTextField r13;
	private JTextField r14;
	private JLabel lblStat_1;
	private JTextField Stat;
	private JLabel lblZf;
	private JLabel lblSF;
	private JLabel lblOF;
	private JTextField ZF;
	private JTextField SF;
	private JTextField OF;
	private JLabel lblMemoryState;
	private JTextArea textArea;
	private JTextField CPI;
	private JLabel lblBreakpoint;
	private JTextField breakpoint;
	private JTextField FN;

	/**
	 * Launch the application.
	 */
	
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					String lookAndFeel = "com.sun.java.swing.plaf.windows.WindowsLookAndFeel";
					UIManager.setLookAndFeel(lookAndFeel);  
					gui frame = new gui();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
		
	}

	/**
	 * Create the frame.
	 */
	public gui() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1200, 1096);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		JLabel lblYsimulator = new JLabel("y86-simulator");
		lblYsimulator.setForeground(Color.BLACK);
		lblYsimulator.setFont(new Font("Comic Sans MS", Font.BOLD, 22));
		lblYsimulator.setBounds(506, 0, 155, 46);
		contentPane.add(lblYsimulator);
	
		JTextArea Memstate = new JTextArea();
		Memstate.setBounds(751, 615, 312, 149);
		
		JScrollPane scrollPane_1 = new JScrollPane();
        scrollPane_1.setBounds(748, 617, 312, 149);
		contentPane.add(scrollPane_1);               
        scrollPane_1.setViewportView(Memstate);
        
        JTextArea Code = new JTextArea();
		Memstate.setBounds(771, 140, 321, 318);
		
		JScrollPane scrollPane_11 = new JScrollPane();
        scrollPane_11.setBounds(748, 140, 420, 318);
		contentPane.add(scrollPane_11);               
        scrollPane_11.setViewportView(Code);
        
        FN = new JTextField();
		FN.setText("Filename");
		FN.setBounds(85, 177, 174, 24);
		contentPane.add(FN);
		FN.setColumns(10);
		FN.setVisible(false);
        
        JComboBox<String> filebox = new JComboBox();
		filebox.setBounds(85, 135, 174, 24);
		contentPane.add(filebox);
		filebox.addItem("prog1.yo");
		filebox.addItem("prog2.yo");
		filebox.addItem("prog3.yo");
		filebox.addItem("prog4.yo");
		filebox.addItem("prog5.yo");
		filebox.addItem("prog6.yo");
		filebox.addItem("prog7.yo");
		filebox.addItem("prog8.yo");
		filebox.addItem("prog9.yo");
		filebox.addItem("prog10.yo");
		filebox.addItem("abs-asum-cmov.yo");
		filebox.addItem("abs-asum-jmp.yo");
		filebox.addItem("asum.yo");
		filebox.addItem("asumi.yo");
		filebox.addItem("asumr.yo");
		filebox.addItem("cjr.yo");
		filebox.addItem("j-cc.yo");
		filebox.addItem("poptest.yo");
		filebox.addItem("pushtest.yo");
		filebox.addItem("pushquestion.yo");
		filebox.addItem("ret-hazard.yo");
		filebox.addItem("ldriver.yo");
		filebox.addItem("sdriver.yo");
		filebox.addItem("------") ;
		
		filebox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int fileindex = filebox.getSelectedIndex() ;
				if (fileindex == 23)
				{
					FN.setVisible(true);
				}
				else
				{
					FN.setVisible(false); 
				}
			}
		});
		
		
		
		JButton btncontinue = new JButton("Continue");
		btncontinue.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		btncontinue.setBounds(464, 52, 92, 37);
		contentPane.add(btncontinue);
		btncontinue.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				hxy.start();
				hxy.stepstart() ;
				hxy.sleeptime = 10000 ;
				
			//	hxy.stepstart();
				
			}
		});
		JButton btnstop = new JButton("Stop");
		btnstop.setFont(new Font("Comic Sans MS", Font.PLAIN, 15));
		btnstop.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				hxy.stop() ;
				hxy.stepstart();
			}
		});
		btnstop.setBounds(324, 52, 92, 37);
		contentPane.add(btnstop);
		
		JButton btnstart = new JButton("Start");
		btnstart.setFont(new Font("Comic Sans MS", Font.PLAIN, 15));
		btnstart.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				btnstart.setVisible(false); 
				
				new Thread(new Runnable(){
					
                    @Override
                    public void run() {
                        // TODO Auto-generated method stub
                    	int fileindex = filebox.getSelectedIndex() ;
                    	String Name ;
                    	if( fileindex != 23 ) 
                    	{
                    		Name = "src\\y86-code\\" + (String) filebox.getItemAt(fileindex) ;
                    	}
                    	else
                    	{
                    		Name = FN.getText() ;
                    	}
                		
        				hxy.start() ;
        				hxy.stepstart(); 
        				hxy.sleeptime = 10000 ;
        				hxy.ting = false ;
            			hxy.Read(Name) ;
            			hxy.initialset() ;
            			String tmp = breakpoint.getText() ;
            			Code.setText("");
            			int num = 0 ;
            			int flag = 0 ;
            			for ( int i = 0 ; i <= 12000 ; i++ )
            			{
            				Code.append(String.valueOf(hxy.getfile[i])) ;
            				if ( hxy.getfile[i] == ' ')
            					num++ ;
            				else
            					num = 0 ;
            				if ( num >= 50 )
            					break ;
            				
            				String dest = String.valueOf(hxy.getfile,i,5) ;
            				String temp = String.valueOf(hxy.getfile,i+30,5) ;
            				if ( (tmp.equalsIgnoreCase(dest) && hxy.getfile[i+31] != '.' && !temp.equalsIgnoreCase("array") )  || tmp.equalsIgnoreCase("") )
            					flag = 1 ;
            			}
            			
            			if ( flag == 0 )
            			{
            				breakpoint.setText("Error");
            				hxy.ting = true ;
            				btnstart.setVisible(true); 
            			}
            			
        				while( !hxy.ting && hxy.W_icode != hxy.halt && hxy.W_stat != hxy.ADR )
        				{
        					int m = 0 ;
        					
        					hxy.writeback() ;
        					hxy.memory() ;
        					hxy.execute() ;
        					hxy.decode();
        					hxy.fetch() ; 
        						
        					hxy.ctrl() ;
        					
        					W_S_Stat.setText(hxy.stat[(int) hxy.W_stat]);
            				W_S_Instr.setText(hxy.fuc[(int) hxy.W_icode][(int) hxy.W_ifun]);
            				W_S_valE.setText("0x" + Long.toHexString(hxy.W_valE));
            				W_S_valM.setText("0x" + Long.toHexString(hxy.W_valM));
            				W_S_dstE.setText(hxy.REG[(int) hxy.W_dstE]);
            				W_S_dstM.setText(hxy.REG[(int) hxy.W_dstM]);
            				
            				M_S_Cnd.setText(String.valueOf(hxy.M_Cnd));
            				M_S_Stat.setText(hxy.stat[(int) hxy.M_stat]);
            				M_S_Instr.setText(hxy.fuc[(int) hxy.M_icode][(int) hxy.M_ifun]);
            				M_S_valE.setText("0x" + Long.toHexString(hxy.M_valE));
            				M_S_valA.setText("0x" + Long.toHexString(hxy.M_valA));
            				M_S_dstE.setText(hxy.REG[(int) hxy.M_dstE]);
            				M_S_dstM.setText(hxy.REG[(int) hxy.M_dstM]);
            				
            				E_S_Stat.setText(hxy.stat[(int) hxy.E_stat]);
            				E_S_Instr.setText(hxy.fuc[(int) hxy.E_icode][(int) hxy.E_ifun]);
            				E_S_valC.setText("0x" + Long.toHexString( hxy.E_valC));
            				E_S_valA.setText("0x" + Long.toHexString( hxy.E_valA));
            				E_S_valB.setText("0x" + Long.toHexString( hxy.E_valB));
            				E_S_dstE.setText(hxy.REG[(int) hxy.E_dstE]);
            				E_S_dstM.setText(hxy.REG[(int) hxy.E_dstM]);
            				E_S_srcA.setText(hxy.REG[(int) hxy.E_srcA]);
            				E_S_srcB.setText(hxy.REG[(int) hxy.E_srcB]);
            				
            				D_S_Stat.setText(hxy.stat[(int) hxy.D_stat]);
            				
            				D_S_Instr.setText(hxy.fuc[(int) hxy.D_icode][(int) hxy.D_ifun]);
            				D_S_valC.setText("0x" + Long.toHexString(hxy.D_valC));
            				D_S_valP.setText("0x" + Long.toHexString(hxy.D_valP));
            				D_S_rA.setText(hxy.REG[(int) hxy.D_rA]);
            				D_S_rB.setText(hxy.REG[(int) hxy.D_rB]);
            				
            				F_S_Stat.setText(hxy.stat[(int) hxy.f_stat]);
            				F_S_predPC.setText("0x" + Long.toHexString(hxy.F_predpc));
            				Stat.setText(hxy.Stat); 
            				CPI.setText(Double.toString(hxy.cpi));
            				
            				if ( !tmp.equalsIgnoreCase(""))
            				{
            					long out = Integer.parseInt(tmp.substring(2, tmp.length()), 16);
                				
            					if( out  == hxy.F_predpc )
            						m = 1 ;
            					else
            						m = 0 ;
                				
            				}
        					hxy.renew() ;
        					
            				
        					
        					W_I_Stat.setText(hxy.stat[(int) hxy.W_stat]);
            				W_I_Instr.setText(hxy.fuc[(int) hxy.W_icode][(int) hxy.W_ifun]);
            				W_I_valE.setText("0x" + Long.toHexString(hxy.W_valE));
            				W_I_valM.setText("0x" + Long.toHexString(hxy.W_valM));
            				W_I_dstE.setText(hxy.REG[(int) hxy.W_dstE]);
            				W_I_dstM.setText(hxy.REG[(int) hxy.W_dstM]);
            				
            				M_I_Cnd.setText(String.valueOf(hxy.M_Cnd));
            				M_I_Stat.setText(hxy.stat[(int) hxy.M_stat]);
            				M_I_Instr.setText(hxy.fuc[(int) hxy.M_icode][(int) hxy.M_ifun]);
            				M_I_valE.setText("0x" + Long.toHexString( hxy.M_valE));
            				M_I_valA.setText("0x" + Long.toHexString( hxy.M_valA));
            				M_I_dstE.setText(hxy.REG[(int) hxy.M_dstE]);
            				M_I_dstM.setText(hxy.REG[(int) hxy.M_dstM]);
            				
            				E_I_Stat.setText(hxy.stat[(int) hxy.E_stat]);
            				E_I_Instr.setText(hxy.fuc[(int) hxy.E_icode][(int) hxy.E_ifun]);
            				E_I_valC.setText("0x" + Long.toHexString(hxy.E_valC));
            				E_I_valA.setText("0x" + Long.toHexString( hxy.E_valA));
            				E_I_valB.setText("0x" + Long.toHexString(hxy.E_valB));
            				E_I_dstE.setText(hxy.REG[(int) hxy.E_dstE]);
            				E_I_dstM.setText(hxy.REG[(int) hxy.E_dstM]);
            				E_I_srcA.setText(hxy.REG[(int) hxy.E_srcA]);
            				E_I_srcB.setText(hxy.REG[(int) hxy.E_srcB]);
            				
            				D_I_Stat.setText(hxy.stat[(int) hxy.D_stat]);
            				D_I_Instr.setText(hxy.fuc[(int) hxy.D_icode][(int) hxy.D_ifun]);
            				D_I_valC.setText("0x" + Long.toHexString( hxy.D_valC));
            				D_I_valP.setText("0x" + Long.toHexString( hxy.D_valP));
            				D_I_rA.setText(hxy.REG[(int) hxy.D_rA]);
            				D_I_rB.setText(hxy.REG[(int) hxy.D_rB]);
            				
            				F_I_Stat.setText(hxy.stat[(int) hxy.f_stat]);
            				F_I_predPC.setText("0x" + Long.toHexString(hxy.F_predpc));
            				
            				rax.setText("0x" + Long.toHexString(hxy.reg[hxy.rax])); 
            				rcx.setText("0x" + Long.toHexString(hxy.reg[hxy.rcx])); 
            				rdx.setText("0x" + Long.toHexString(hxy.reg[hxy.rdx])); 
            				rbx.setText("0x" + Long.toHexString(hxy.reg[hxy.rbx])); 
            				rsp.setText("0x" + Long.toHexString(hxy.reg[hxy.rsp])); 
            				rbp.setText("0x" + Long.toHexString(hxy.reg[hxy.rbp])); 
            				rsi.setText("0x" + Long.toHexString(hxy.reg[hxy.rsi])); 
            				rdi.setText("0x" + Long.toHexString(hxy.reg[hxy.rdi])); 
            				r8.setText("0x" + Long.toHexString(hxy.reg[hxy.r8])); 
            				r9.setText("0x" + Long.toHexString(hxy.reg[hxy.r9])); 
            				r10.setText("0x" + Long.toHexString(hxy.reg[hxy.r10])); 
            				r11.setText("0x" + Long.toHexString(hxy.reg[hxy.r11])); 
            				r12.setText("0x" + Long.toHexString(hxy.reg[hxy.r12])); 
            				r13.setText("0x" + Long.toHexString(hxy.reg[hxy.r13])); 
            				r14.setText("0x" + Long.toHexString(hxy.reg[hxy.r14])); 
            				
            				
            				ZF.setText(String.valueOf(hxy.ZF)); 
            				SF.setText(String.valueOf(hxy.SF)); 
            				OF.setText(String.valueOf(hxy.OF)); 
            				
            					if(hxy.m_write)
            					{
            						Memstate.setText("");
            						for ( int i = (int) hxy.loc ; i < hxy.stacktop ; i+=8 )
                					{
                						long  ssum ;
                						ssum = hxy.mem[i] + ( hxy.mem[i+1] << 8 ) + ( hxy.mem[i+2] << 16 ) + ( hxy.mem[i+3] << 24 ) + 
                						( hxy.mem[i+4] << 32 ) + ( hxy.mem[i+5] << 40 ) + ( hxy.mem[i+6] << 48 ) + ( hxy.mem[i+7] << 56 ) ;
                						if (i <= 0xff)
                						{
                							Memstate.append("0x" + Long.toHexString(i) + "   :    ") ;
                						}
                						else if ( i <= 0xf )
                						{
                							Memstate.append("0x" + Long.toHexString(i) + "    :    ") ;
                						}
                						else
                							Memstate.append("0x" + Long.toHexString(i) + "  :    ") ;
                						Memstate.append("0x" + Long.toHexString(ssum) + "\n") ;
                					}
            						
            					}
                				
            				if ( m == 1 )
            				{
            					
            					hxy.stop() ;
            					hxy.stepstart();
            					btnstop.setVisible(false);
            				
            					
            				}
            				
            				try {
        						if (tmp.equalsIgnoreCase(""))
        							Thread.sleep((long) (hxy.sleeptime / hxy.timechanger) ) ;
        						else
        							Thread.sleep(0);
        					} catch (InterruptedException e1) {
        						// TODO Auto-generated catch block
        						e1.printStackTrace();
        					}
        					
            				if ( hxy.finished ) 	
            				{
            					while(hxy.finished)
            					{
            						System.out.println("");
            					}
            				}
            				else if ( hxy.stepped )
            				{
            					while(hxy.stepped)
            					{
            						System.out.println("");
            					}
            				}
            				
            				
        				}
        				
        				if(!hxy.ting)
        				{
        					W_S_Stat.setText(hxy.stat[(int) hxy.W_stat]);
            				W_S_Instr.setText(hxy.fuc[(int) hxy.W_icode][(int) hxy.W_ifun]);
            				W_S_valE.setText("0x" + Long.toHexString(hxy.W_valE));
            				W_S_valM.setText("0x" + Long.toHexString( hxy.W_valM));
            				W_S_dstE.setText(hxy.REG[(int) hxy.W_dstE]);
            				W_S_dstM.setText(hxy.REG[(int) hxy.W_dstM]);
            				
            				M_S_Cnd.setText(String.valueOf(hxy.M_Cnd));
            				M_S_Stat.setText(hxy.stat[(int) hxy.M_stat]);
            				M_S_Instr.setText(hxy.fuc[(int) hxy.M_icode][(int) hxy.M_ifun]);
            				M_S_valE.setText("0x" + Long.toHexString( hxy.M_valE));
            				M_S_valA.setText("0x" + Long.toHexString( hxy.M_valA));
            				M_S_dstE.setText(hxy.REG[(int) hxy.M_dstE]);
            				M_S_dstM.setText(hxy.REG[(int) hxy.M_dstM]);
            				
            				E_S_Stat.setText(hxy.stat[(int) hxy.E_stat]);
            				E_S_Instr.setText(hxy.fuc[(int) hxy.E_icode][(int) hxy.E_ifun]);
            				E_S_valC.setText("0x" + Long.toHexString(hxy.E_valC));
            				E_S_valA.setText("0x" + Long.toHexString( hxy.E_valA));
            				E_S_valB.setText("0x" + Long.toHexString(hxy.E_valB));
            				E_S_dstE.setText(hxy.REG[(int) hxy.E_dstE]);
            				E_S_dstM.setText(hxy.REG[(int) hxy.E_dstM]);
            				E_S_srcA.setText(hxy.REG[(int) hxy.E_srcA]);
            				E_S_srcB.setText(hxy.REG[(int) hxy.E_srcB]);
            				
            				D_S_Stat.setText(hxy.stat[(int) hxy.D_stat]);
            				D_S_Instr.setText(hxy.fuc[(int) hxy.D_icode][(int) hxy.D_ifun]);
            				D_S_valC.setText("0x" + Long.toHexString(hxy.D_valC));
            				D_S_valP.setText("0x" + Long.toHexString(hxy.D_valP));
            				D_S_rA.setText(hxy.REG[(int) hxy.D_rA]);
            				D_S_rB.setText(hxy.REG[(int) hxy.D_rB]);
            				
            				F_S_Stat.setText(hxy.stat[(int) hxy.f_stat]);
            				F_S_predPC.setText("0x" + Long.toHexString(hxy.F_predpc));
            				Stat.setText(hxy.Stat); 
            				
        					hxy.renew() ;
        					
            				
        					
        					W_I_Stat.setText(hxy.stat[(int) hxy.W_stat]);
            				W_I_Instr.setText(hxy.fuc[(int) hxy.W_icode][(int) hxy.W_ifun]);
            				W_I_valE.setText("0x" + Long.toHexString( hxy.W_valE));
            				W_I_valM.setText("0x" + Long.toHexString( hxy.W_valM));
            				W_I_dstE.setText(hxy.REG[(int) hxy.W_dstE]);
            				W_I_dstM.setText(hxy.REG[(int) hxy.W_dstM]);
            				
            				M_I_Cnd.setText(String.valueOf(hxy.M_Cnd));
            				M_I_Stat.setText(hxy.stat[(int) hxy.M_stat]);
            				M_I_Instr.setText(hxy.fuc[(int) hxy.M_icode][(int) hxy.M_ifun]);
            				M_I_valE.setText("0x" + Long.toHexString( hxy.M_valE));
            				M_I_valA.setText("0x" + Long.toHexString( hxy.M_valA));
            				M_I_dstE.setText(hxy.REG[(int) hxy.M_dstE]);
            				M_I_dstM.setText(hxy.REG[(int) hxy.M_dstM]);
            				
            				E_I_Stat.setText(hxy.stat[(int) hxy.E_stat]);
            				E_I_Instr.setText(hxy.fuc[(int) hxy.E_icode][(int) hxy.E_ifun]);
            				E_I_valC.setText("0x" + Long.toHexString( hxy.E_valC));
            				E_I_valA.setText("0x" + Long.toHexString( hxy.E_valA));
            				E_I_valB.setText("0x" + Long.toHexString( hxy.E_valB));
            				E_I_dstE.setText(hxy.REG[(int) hxy.E_dstE]);
            				E_I_dstM.setText(hxy.REG[(int) hxy.E_dstM]);
            				E_I_srcA.setText(hxy.REG[(int) hxy.E_srcA]);
            				E_I_srcB.setText(hxy.REG[(int) hxy.E_srcB]);
            				
            				D_I_Stat.setText(hxy.stat[(int) hxy.D_stat]);
            				D_I_Instr.setText(hxy.fuc[(int) hxy.D_icode][(int) hxy.D_ifun]);
            				D_I_valC.setText("0x" + Long.toHexString( hxy.D_valC));
            				D_I_valP.setText("0x" + Long.toHexString( hxy.D_valP));
            				D_I_rA.setText(hxy.REG[(int) hxy.D_rA]);
            				D_I_rB.setText(hxy.REG[(int) hxy.D_rB]);
            				
            				F_I_Stat.setText(hxy.stat[(int) hxy.f_stat]);
            				F_I_predPC.setText("0x" + Long.toHexString(hxy.F_predpc));
            				
            				rax.setText("0x" + Long.toHexString(hxy.reg[hxy.rax])); 
            				rcx.setText("0x" + Long.toHexString(hxy.reg[hxy.rcx])); 
            				rdx.setText("0x" + Long.toHexString(hxy.reg[hxy.rdx])); 
            				rbx.setText("0x" + Long.toHexString(hxy.reg[hxy.rbx])); 
            				rsp.setText("0x" + Long.toHexString(hxy.reg[hxy.rsp])); 
            				rbp.setText("0x" + Long.toHexString(hxy.reg[hxy.rbp])); 
            				rsi.setText("0x" + Long.toHexString(hxy.reg[hxy.rsi])); 
            				rdi.setText("0x" + Long.toHexString(hxy.reg[hxy.rdi])); 
            				r8.setText("0x" + Long.toHexString(hxy.reg[hxy.r8])); 
            				r9.setText("0x" + Long.toHexString(hxy.reg[hxy.r9])); 
            				r10.setText("0x" + Long.toHexString(hxy.reg[hxy.r10])); 
            				r11.setText("0x" + Long.toHexString(hxy.reg[hxy.r11])); 
            				r12.setText("0x" + Long.toHexString(hxy.reg[hxy.r12])); 
            				r13.setText("0x" + Long.toHexString(hxy.reg[hxy.r13])); 
            				r14.setText("0x" + Long.toHexString(hxy.reg[hxy.r14])); 
            				
            				
            				ZF.setText(String.valueOf(hxy.ZF)); 
            				SF.setText(String.valueOf(hxy.SF)); 
            				OF.setText(String.valueOf(hxy.OF)); 
            				
            				
            				
        				}
                    }

					private String toString(double cpi) {
						// TODO Auto-generated method stub
						return null;
					}
                    
                     
                }).start();
				

			}

			private cpu thread(Runnable runnable) {
				// TODO Auto-generated method stub
				return null;
			}
		});
		
		
		btnstart.setBounds(189, 52, 92, 37);
		contentPane.add(btnstart);
		
		
		
		JButton btnreset = new JButton("Reset");
		btnreset.setFont(new Font("Comic Sans MS", Font.PLAIN, 15));
		
		btnreset.setBounds(748, 52, 92, 37);
		contentPane.add(btnreset);
		btnreset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				btnstart.setVisible(true); 
				btncontinue.setVisible(true);
				btnstop.setVisible(true);
				
				hxy.ting = true ;
				hxy.finished = false ;
				hxy.stepped = false ;
				
				breakpoint.setText("");
				FN.setText("");
				CPI.setText("1.00");
				
				W_S_Stat.setText("BUB");
				W_S_Instr.setText("nop");
				W_S_valE.setText("0x"+String.valueOf(0));
				W_S_valM.setText("0x"+String.valueOf(0));
				W_S_dstE.setText("----") ;
				W_S_dstM.setText("----");
				
				M_S_Cnd.setText("true");
				M_S_Stat.setText("BUB");
				M_S_Instr.setText("nop");
				M_S_valE.setText("0");
				M_S_valA.setText("0x"+String.valueOf(0));
				M_S_dstE.setText("----");
				M_S_dstM.setText("----");
				
				E_S_Stat.setText("BUB");
				E_S_Instr.setText("nop");
				E_S_valC.setText("0x"+String.valueOf(0));
				E_S_valA.setText("0x"+String.valueOf(0));
				E_S_valB.setText("0x"+String.valueOf(0));
				E_S_dstE.setText("----");
				E_S_dstM.setText("----");
				E_S_srcA.setText("----");
				E_S_srcB.setText("----");
				
				D_S_Stat.setText("BUB");
				D_S_Instr.setText("nop");
				D_S_valC.setText("0x"+String.valueOf(0));
				D_S_valP.setText("0x"+String.valueOf(0));
				D_S_rA.setText("----");
				D_S_rB.setText("----");
				
				F_S_Stat.setText("AOK");
				F_S_predPC.setText("0x"+String.valueOf(0));
			
				
				W_I_Stat.setText("BUB");
				W_I_Instr.setText("nop");
				W_I_valE.setText("0x"+String.valueOf(0));
				W_I_valM.setText("0x"+String.valueOf(0));
				W_I_dstE.setText("----") ;
				W_I_dstM.setText("----");
				
				M_I_Cnd.setText("true");
				M_I_Stat.setText("BUB");
				M_I_Instr.setText("nop");
				M_I_valE.setText("0");
				M_I_valA.setText("0x"+String.valueOf(0));
				M_I_dstE.setText("----");
				M_I_dstM.setText("----");
				
				E_I_Stat.setText("BUB");
				E_I_Instr.setText("nop");
				E_I_valC.setText("0x"+String.valueOf(0));
				E_I_valA.setText("0x"+String.valueOf(0));
				E_I_valB.setText("0x"+String.valueOf(0));
				E_I_dstE.setText("----");
				E_I_dstM.setText("----");
				E_I_srcA.setText("----");
				E_I_srcB.setText("----");
				
				D_I_Stat.setText("BUB");
				D_I_Instr.setText("nop");
				D_I_valC.setText("0x"+String.valueOf(0));
				D_I_valP.setText("0x"+String.valueOf(0));
				D_I_rA.setText("----");
				D_I_rB.setText("----");
				
				F_I_Stat.setText("AOK");
				F_I_predPC.setText("0x"+String.valueOf(0));
				
				rax.setText("0x"+String.valueOf(0)); 
				rcx.setText("0x"+String.valueOf(0)); 
				rdx.setText("0x"+String.valueOf(0)); 
				rbx.setText("0x"+String.valueOf(0)); 
				rsp.setText("0x"+String.valueOf(0)); 
				rbp.setText("0x"+String.valueOf(0)); 
				rsi.setText("0x"+String.valueOf(0)); 
				rdi.setText("0x"+String.valueOf(0)); 
				r8.setText("0x"+String.valueOf(0)); 
				r9.setText("0x"+String.valueOf(0)); 
				r10.setText("0x"+String.valueOf(0)); 
				r11.setText("0x"+String.valueOf(0)); 
				r12.setText("0x"+String.valueOf(0)); 
				r13.setText("0x"+String.valueOf(0)); 
				r14.setText("0x"+String.valueOf(0)); 
				
				Stat.setText("AOK"); 
				ZF.setText(String.valueOf(true)); 
				SF.setText(String.valueOf(false)); 
				OF.setText(String.valueOf(false)); 
				
				Memstate.setText(""); 
			}
		});
		
		JButton btnquit = new JButton("Quit");
		btnquit.setFont(new Font("Comic Sans MS", Font.PLAIN, 15));
		btnquit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				System.exit(0);
			}
		});
		btnquit.setBounds(888, 52, 92, 37);
		contentPane.add(btnquit);
		
		JButton btnstep = new JButton("Step");
		btnstep.setFont(new Font("Comic Sans MS", Font.PLAIN, 15));
		btnstep.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!hxy.stepped)
				{
					hxy.sleeptime = 10 ;
					hxy.stepstop();
					hxy.start(); 
				}
				else
				{
					hxy.sleeptime = 10 ;
					hxy.stop();
					hxy.stepstart(); 
				}
				
			}
		});
		
		
		
		btnstep.setBounds(608, 52, 92, 37);
		contentPane.add(btnstep);
		
		final JSlider sliderspeed = new JSlider(10,100,10);
		sliderspeed.setFont(new Font("Comic Sans MS", Font.PLAIN, 15));
		sliderspeed.setMajorTickSpacing(10);
		sliderspeed.setMinorTickSpacing(5); 
		sliderspeed.setPaintTicks(true);
        sliderspeed.setPaintLabels(true);
        sliderspeed.setOpaque(false); 
		sliderspeed.setBounds(371, 113, 268, 46);
		contentPane.add(sliderspeed);
		sliderspeed.addChangeListener(new ChangeListener() {
	        public void stateChanged(ChangeEvent evt) {
	            hxy.timechanger = sliderspeed.getValue() ;
	            if ( hxy.timechanger == 0 )
	            	hxy.timechanger = 10 ;
	        }
	    });
			
		
		JLabel lblSpeed = new JLabel("Speed"); 
		lblSpeed.setForeground(Color.BLACK);
		lblSpeed.setFont(new Font("Comic Sans MS", Font.PLAIN, 18));
		lblSpeed.setBounds(301, 113, 56, 26);
		contentPane.add(lblSpeed);
		
		JButton btncode = new JButton("Code");
		btncode.setBounds(748, 114, 71, 27);
		btncode.setFont(new Font("Comic Sans MS", Font.PLAIN, 15));
		contentPane.add(btncode);
		btncode.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				Code.setText("");
				int fileindex = filebox.getSelectedIndex() ;
				String Name = " ";
				if(fileindex != 23)
				{
					Name = "src\\y86-code\\" + (String) filebox.getItemAt(fileindex) ;
				}
				else
				{
					Name = FN.getText() ;
				}
				
    			hxy.Read(Name) ;
    			int num = 0 ;
    			
    			for ( int i = 0 ; i <= 12000 ; i++ )
    			{
    				
    				Code.append(String.valueOf(hxy.getfile[i])) ;
    				if(hxy.getfile[i] == ' ')
    					num++ ;
    				else
    					num = 0 ;
    				if ( num >= 50 )
    					break ;
    			}
			}
		});
		
		
		JLabel lblPipelineregister = new JLabel("PipelineRegister");
		lblPipelineregister.setForeground(Color.BLACK);
		lblPipelineregister.setFont(new Font("Comic Sans MS", Font.BOLD, 22));
		lblPipelineregister.setBounds(411, 152, 176, 49);
		contentPane.add(lblPipelineregister);
		
		JLabel lblW = new JLabel("W");
		lblW.setForeground(Color.BLACK);
		lblW.setFont(new Font("Comic Sans MS", Font.PLAIN, 40));
		lblW.setBounds(14, 235, 53, 65);
		contentPane.add(lblW);
		
		JLabel lblNewLabel = new JLabel("State");
		lblNewLabel.setForeground(Color.BLACK);
		lblNewLabel.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
		lblNewLabel.setBounds(62, 242, 72, 18);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Input");
		lblNewLabel_1.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(62, 273, 72, 27);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblStat = new JLabel("Stat");
		lblStat.setFont(new Font("Comic Sans MS", Font.PLAIN, 18));
		lblStat.setBounds(129, 211, 72, 18);
		contentPane.add(lblStat);
		
		W_S_Stat = new JTextField();
		W_S_Stat.setBounds(129, 241, 39, 24);
		W_S_Stat.setText("BUB");
		contentPane.add(W_S_Stat);
		W_S_Stat.setColumns(10);
		
		W_I_Stat = new JTextField();
		W_I_Stat.setText("BUB");
		W_I_Stat.setColumns(10);
		W_I_Stat.setBounds(129, 276, 39, 24);
		contentPane.add(W_I_Stat);
		
		JLabel lblNewLabel_2 = new JLabel("Instr");
		lblNewLabel_2.setFont(new Font("Comic Sans MS", Font.PLAIN, 18));
		lblNewLabel_2.setBounds(193, 211, 72, 18);
		contentPane.add(lblNewLabel_2);
		
		W_S_Instr = new JTextField();
		W_S_Instr.setText("nop");
		W_S_Instr.setColumns(10);
		W_S_Instr.setBounds(182, 241, 64, 24);
		contentPane.add(W_S_Instr);
		
		W_I_Instr = new JTextField();
		W_I_Instr.setText("nop");
		W_I_Instr.setColumns(10);
		W_I_Instr.setBounds(182, 276, 64, 24);
		contentPane.add(W_I_Instr);
		
		JLabel lblVale = new JLabel("valE");
		lblVale.setFont(new Font("Comic Sans MS", Font.PLAIN, 18));
		lblVale.setBounds(303, 211, 72, 18);
		contentPane.add(lblVale);
		
		W_S_valE = new JTextField();
		W_S_valE.setText("0x0");
		W_S_valE.setBounds(260, 241, 152, 24);
		contentPane.add(W_S_valE);
		W_S_valE.setColumns(10);
		
		W_I_valE = new JTextField();
		W_I_valE.setText("0x0");
		W_I_valE.setColumns(10);
		W_I_valE.setBounds(260, 276, 152, 24);
		contentPane.add(W_I_valE);
		
		JLabel lblValm = new JLabel("valM");
		lblValm.setFont(new Font("Comic Sans MS", Font.PLAIN, 18));
		lblValm.setBounds(470, 211, 72, 18);
		contentPane.add(lblValm);
		
		W_S_valM = new JTextField();
		W_S_valM.setText("0x0");
		W_S_valM.setColumns(10);
		W_S_valM.setBounds(421, 241, 152, 24);
		contentPane.add(W_S_valM);
		
		W_I_valM = new JTextField();
		W_I_valM.setText("0x0");
		W_I_valM.setColumns(10);
		W_I_valM.setBounds(421, 276, 152, 24);
		contentPane.add(W_I_valM);
		
		JLabel lblNewLabel_3 = new JLabel("dstE");
		lblNewLabel_3.setFont(new Font("Comic Sans MS", Font.PLAIN, 18));
		lblNewLabel_3.setBounds(600, 211, 72, 18);
		contentPane.add(lblNewLabel_3);
		
		W_S_dstE = new JTextField();
		W_S_dstE.setText("----");
		W_S_dstE.setColumns(10);
		W_S_dstE.setBounds(591, 241, 51, 24);
		contentPane.add(W_S_dstE);
		
		W_I_dstE = new JTextField();
		W_I_dstE.setText("----");
		W_I_dstE.setColumns(10);
		W_I_dstE.setBounds(591, 276, 51, 24);
		contentPane.add(W_I_dstE);
		
		JLabel lblDstm = new JLabel("dstM");
		lblDstm.setFont(new Font("Comic Sans MS", Font.PLAIN, 18));
		lblDstm.setBounds(656, 211, 72, 18);
		contentPane.add(lblDstm);
		
		W_S_dstM = new JTextField();
		W_S_dstM.setText("----");
		W_S_dstM.setColumns(10);
		W_S_dstM.setBounds(656, 241, 51, 24);
		contentPane.add(W_S_dstM);
		
		W_I_dstM = new JTextField();
		W_I_dstM.setText("----");
		W_I_dstM.setColumns(10);
		W_I_dstM.setBounds(656, 276, 51, 24);
		contentPane.add(W_I_dstM);
		
		JLabel lblM = new JLabel("M");
		lblM.setFont(new Font("Comic Sans MS", Font.PLAIN, 40));
		lblM.setBounds(14, 365, 39, 65);
		contentPane.add(lblM);
		
		JLabel label_1 = new JLabel("State");
		label_1.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
		label_1.setBounds(62, 372, 72, 18);
		contentPane.add(label_1);
		
		JLabel label_2 = new JLabel("Input");
		label_2.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
		label_2.setBounds(62, 403, 72, 27);
		contentPane.add(label_2);
		
		M_I_Stat = new JTextField();
		M_I_Stat.setText("BUB");
		M_I_Stat.setColumns(10);
		M_I_Stat.setBounds(129, 406, 39, 24);
		contentPane.add(M_I_Stat);
		
		M_S_Stat = new JTextField();
		M_S_Stat.setText("BUB");
		M_S_Stat.setColumns(10);
		M_S_Stat.setBounds(129, 371, 39, 24);
		contentPane.add(M_S_Stat);
		
		JLabel label_3 = new JLabel("Stat");
		label_3.setFont(new Font("Comic Sans MS", Font.PLAIN, 18));
		label_3.setBounds(129, 341, 72, 18);
		contentPane.add(label_3);
		
		JLabel label_4 = new JLabel("Instr");
		label_4.setFont(new Font("Comic Sans MS", Font.PLAIN, 18));
		label_4.setBounds(193, 341, 72, 18);
		contentPane.add(label_4);
		
		M_S_Instr = new JTextField();
		M_S_Instr.setText("nop");
		M_S_Instr.setColumns(10);
		M_S_Instr.setBounds(182, 371, 64, 24);
		contentPane.add(M_S_Instr);
		
		M_I_Instr = new JTextField();
		M_I_Instr.setText("nop");
		M_I_Instr.setColumns(10);
		M_I_Instr.setBounds(182, 406, 64, 24);
		contentPane.add(M_I_Instr);
		
		M_I_valE = new JTextField();
		M_I_valE.setText("0x0");
		M_I_valE.setColumns(10);
		M_I_valE.setBounds(314, 406, 152, 24);
		contentPane.add(M_I_valE);
		
		M_S_valE = new JTextField();
		M_S_valE.setText("0x0");
		M_S_valE.setColumns(10);
		M_S_valE.setBounds(314, 371, 152, 24);
		contentPane.add(M_S_valE);
		
		JLabel label_5 = new JLabel("valE");
		label_5.setFont(new Font("Comic Sans MS", Font.PLAIN, 18));
		label_5.setBounds(357, 341, 72, 18);
		contentPane.add(label_5);
		
		JLabel lblVala = new JLabel("valA");
		lblVala.setFont(new Font("Comic Sans MS", Font.PLAIN, 18));
		lblVala.setBounds(523, 341, 72, 18);
		contentPane.add(lblVala);
		
		M_S_valA = new JTextField();
		M_S_valA.setText("0x0");
		M_S_valA.setColumns(10);
		M_S_valA.setBounds(474, 371, 152, 24);
		contentPane.add(M_S_valA);
		
		M_I_valA = new JTextField();
		M_I_valA.setText("0x0");
		M_I_valA.setColumns(10);
		M_I_valA.setBounds(474, 406, 152, 24);
		contentPane.add(M_I_valA);
		
		M_I_dstE = new JTextField();
		M_I_dstE.setText("----");
		M_I_dstE.setColumns(10);
		M_I_dstE.setBounds(631, 406, 51, 24);
		contentPane.add(M_I_dstE);
		
		M_S_dstE = new JTextField();
		M_S_dstE.setText("----");
		M_S_dstE.setColumns(10);
		M_S_dstE.setBounds(631, 371, 51, 24);
		contentPane.add(M_S_dstE);
		
		JLabel label_7 = new JLabel("dstE");
		label_7.setFont(new Font("Comic Sans MS", Font.PLAIN, 18));
		label_7.setBounds(640, 341, 72, 18);
		contentPane.add(label_7);
		
		JLabel label_8 = new JLabel("dstM");
		label_8.setFont(new Font("Comic Sans MS", Font.PLAIN, 18));
		label_8.setBounds(693, 341, 72, 18);
		contentPane.add(label_8);
		
		M_S_dstM = new JTextField();
		M_S_dstM.setText("----");
		M_S_dstM.setColumns(10);
		M_S_dstM.setBounds(690, 371, 51, 24);
		contentPane.add(M_S_dstM);
		
		M_I_dstM = new JTextField();
		M_I_dstM.setText("----");
		M_I_dstM.setColumns(10);
		M_I_dstM.setBounds(690, 406, 51, 24);
		contentPane.add(M_I_dstM);
		
		M_S_Cnd = new JTextField();
		M_S_Cnd.setText("true");
		M_S_Cnd.setColumns(10);
		M_S_Cnd.setBounds(260, 371, 39, 24);
		contentPane.add(M_S_Cnd);
		M_S_Cnd.getDocument().addDocumentListener(null);
		
		M_I_Cnd = new JTextField();
		M_I_Cnd.setText("true");
		M_I_Cnd.setColumns(10);
		M_I_Cnd.setBounds(260, 406, 39, 24);
		contentPane.add(M_I_Cnd);
		
		JLabel lblCnd = new JLabel("Cnd");
		lblCnd.setFont(new Font("Comic Sans MS", Font.PLAIN, 18));
		lblCnd.setBounds(260, 341, 72, 18);
		contentPane.add(lblCnd);
		
		JLabel lblFilename = new JLabel("Filename");
		lblFilename.setFont(new Font("Comic Sans MS", Font.PLAIN, 18));
		lblFilename.setBounds(129, 104, 106, 18);
		contentPane.add(lblFilename);
		
		JLabel lblE = new JLabel("E");
		lblE.setFont(new Font("Comic Sans MS", Font.PLAIN, 40));
		lblE.setBounds(14, 495, 39, 65);
		contentPane.add(lblE);
		
		JLabel label_9 = new JLabel("State");
		label_9.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
		label_9.setBounds(62, 502, 72, 18);
		contentPane.add(label_9);
		
		JLabel label_10 = new JLabel("Input");
		label_10.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
		label_10.setBounds(62, 533, 72, 27);
		contentPane.add(label_10);
		
		E_I_Stat = new JTextField();
		E_I_Stat.setText("BUB");
		E_I_Stat.setColumns(10);
		E_I_Stat.setBounds(129, 536, 39, 24);
		contentPane.add(E_I_Stat);
		
		E_S_Stat = new JTextField();
		E_S_Stat.setText("BUB");
		E_S_Stat.setColumns(10);
		E_S_Stat.setBounds(129, 501, 39, 24);
		contentPane.add(E_S_Stat);
		
		JLabel label_11 = new JLabel("Stat");
		label_11.setFont(new Font("Comic Sans MS", Font.PLAIN, 18));
		label_11.setBounds(129, 471, 72, 18);
		contentPane.add(label_11);
		
		JLabel label_12 = new JLabel("Instr");
		label_12.setFont(new Font("Comic Sans MS", Font.PLAIN, 18));
		label_12.setBounds(193, 471, 72, 18);
		contentPane.add(label_12);
		
		E_S_Instr = new JTextField();
		E_S_Instr.setText("nop");
		E_S_Instr.setColumns(10);
		E_S_Instr.setBounds(182, 501, 64, 24);
		contentPane.add(E_S_Instr);
		
		E_I_Instr = new JTextField();
		E_I_Instr.setText("nop");
		E_I_Instr.setColumns(10);
		E_I_Instr.setBounds(182, 536, 64, 24);
		contentPane.add(E_I_Instr);
		
		E_I_valC = new JTextField();
		E_I_valC.setText("0x0");
		E_I_valC.setColumns(10);
		E_I_valC.setBounds(260, 536, 152, 24);
		contentPane.add(E_I_valC);
		
		E_S_valC = new JTextField();
		E_S_valC.setText("0x0");
		E_S_valC.setColumns(10);
		E_S_valC.setBounds(260, 501, 152, 24);
		contentPane.add(E_S_valC);
		
		JLabel lblValc = new JLabel("valC");
		lblValc.setFont(new Font("Comic Sans MS", Font.PLAIN, 18));
		lblValc.setBounds(303, 471, 72, 18);
		contentPane.add(lblValc);
		
		JLabel label_14 = new JLabel("valA");
		label_14.setFont(new Font("Comic Sans MS", Font.PLAIN, 18));
		label_14.setBounds(471, 471, 72, 18);
		contentPane.add(label_14);
		
		E_S_valA = new JTextField();
		E_S_valA.setText("0x0");
		E_S_valA.setColumns(10);
		E_S_valA.setBounds(422, 501, 152, 24);
		contentPane.add(E_S_valA);
		
		E_I_valA = new JTextField();
		E_I_valA.setText("0x0");
		E_I_valA.setColumns(10);
		E_I_valA.setBounds(422, 536, 152, 24);
		contentPane.add(E_I_valA);
		
		E_I_dstE = new JTextField();
		E_I_dstE.setText("----");
		E_I_dstE.setColumns(10);
		E_I_dstE.setBounds(748, 536, 51, 24);
		contentPane.add(E_I_dstE);
		
		E_S_dstE = new JTextField();
		E_S_dstE.setText("----");
		E_S_dstE.setColumns(10);
		E_S_dstE.setBounds(748, 501, 51, 24);
		contentPane.add(E_S_dstE);
		
		JLabel label_15 = new JLabel("dstE");
		label_15.setFont(new Font("Comic Sans MS", Font.PLAIN, 18));
		label_15.setBounds(757, 471, 72, 18);
		contentPane.add(label_15);
		
		JLabel label_16 = new JLabel("dstM");
		label_16.setFont(new Font("Comic Sans MS", Font.PLAIN, 18));
		label_16.setBounds(813, 471, 72, 18);
		contentPane.add(label_16);
		
		E_S_dstM = new JTextField();
		E_S_dstM.setText("----");
		E_S_dstM.setColumns(10);
		E_S_dstM.setBounds(813, 501, 51, 24);
		contentPane.add(E_S_dstM);
		
		E_I_dstM = new JTextField();
		E_I_dstM.setText("----");
		E_I_dstM.setColumns(10);
		E_I_dstM.setBounds(813, 536, 51, 24);
		contentPane.add(E_I_dstM);
		
		JLabel lblValb = new JLabel("valB");
		lblValb.setFont(new Font("Comic Sans MS", Font.PLAIN, 18));
		lblValb.setBounds(632, 471, 72, 18);
		contentPane.add(lblValb);
		
		E_S_valB = new JTextField();
		E_S_valB.setText("0x0");
		E_S_valB.setColumns(10);
		E_S_valB.setBounds(583, 501, 152, 24);
		contentPane.add(E_S_valB);
		
		E_I_valB = new JTextField();
		E_I_valB.setText("0x0");
		E_I_valB.setColumns(10);
		E_I_valB.setBounds(583, 536, 152, 24);
		contentPane.add(E_I_valB);
		
		E_I_srcA = new JTextField();
		E_I_srcA.setText("----");
		E_I_srcA.setColumns(10);
		E_I_srcA.setBounds(878, 536, 51, 24);
		contentPane.add(E_I_srcA);
		
		E_S_srcA = new JTextField();
		E_S_srcA.setText("----");
		E_S_srcA.setColumns(10);
		E_S_srcA.setBounds(878, 501, 51, 24);
		contentPane.add(E_S_srcA);
		
		lblSrca = new JLabel("srcA");
		lblSrca.setFont(new Font("Comic Sans MS", Font.PLAIN, 18));
		lblSrca.setBounds(887, 471, 72, 18);
		contentPane.add(lblSrca);
		
		lblSrcb = new JLabel("srcB");
		lblSrcb.setFont(new Font("Comic Sans MS", Font.PLAIN, 18));
		lblSrcb.setBounds(952, 471, 72, 18);
		contentPane.add(lblSrcb);
		
		E_S_srcB = new JTextField();
		E_S_srcB.setText("----");
		E_S_srcB.setColumns(10);
		E_S_srcB.setBounds(943, 501, 51, 24);
		contentPane.add(E_S_srcB);
		
		E_I_srcB = new JTextField();
		E_I_srcB.setText("----");
		E_I_srcB.setColumns(10);
		E_I_srcB.setBounds(943, 536, 51, 24);
		contentPane.add(E_I_srcB);
		
		lblD = new JLabel("D");
		lblD.setFont(new Font("Comic Sans MS", Font.PLAIN, 40));
		lblD.setBounds(14, 628, 39, 65);
		contentPane.add(lblD);
		
		label_13 = new JLabel("State");
		label_13.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
		label_13.setBounds(62, 635, 72, 18);
		contentPane.add(label_13);
		
		label_17 = new JLabel("Input");
		label_17.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
		label_17.setBounds(62, 666, 72, 27);
		contentPane.add(label_17);
		
		D_I_Stat = new JTextField();
		D_I_Stat.setText("BUB");
		D_I_Stat.setColumns(10);
		D_I_Stat.setBounds(129, 669, 39, 24);
		contentPane.add(D_I_Stat);
		
		D_S_Stat = new JTextField();
		D_S_Stat.setText("BUB");
		D_S_Stat.setColumns(10);
		D_S_Stat.setBounds(129, 634, 39, 24);
		contentPane.add(D_S_Stat);
		
		label_18 = new JLabel("Stat");
		label_18.setFont(new Font("Comic Sans MS", Font.PLAIN, 18));
		label_18.setBounds(129, 604, 72, 18);
		contentPane.add(label_18);
		
		label_19 = new JLabel("Instr");
		label_19.setFont(new Font("Comic Sans MS", Font.PLAIN, 18));
		label_19.setBounds(193, 604, 72, 18);
		contentPane.add(label_19);
		
		D_S_Instr = new JTextField();
		D_S_Instr.setText("nop");
		D_S_Instr.setColumns(10);
		D_S_Instr.setBounds(182, 634, 64, 24);
		contentPane.add(D_S_Instr);
		
		D_I_Instr = new JTextField();
		D_I_Instr.setText("nop");
		D_I_Instr.setColumns(10);
		D_I_Instr.setBounds(182, 669, 64, 24);
		contentPane.add(D_I_Instr);
		
		D_I_valC = new JTextField();
		D_I_valC.setText("0x0");
		D_I_valC.setColumns(10);
		D_I_valC.setBounds(390, 669, 152, 24);
		contentPane.add(D_I_valC);
		
		D_S_valC = new JTextField();
		D_S_valC.setText("0x0");
		D_S_valC.setColumns(10);
		D_S_valC.setBounds(390, 634, 152, 24);
		contentPane.add(D_S_valC);
		
		lblValc_1 = new JLabel("valC");
		lblValc_1.setFont(new Font("Comic Sans MS", Font.PLAIN, 18));
		lblValc_1.setBounds(433, 604, 72, 18);
		contentPane.add(lblValc_1);
		
		lblValp = new JLabel("valP");
		lblValp.setFont(new Font("Comic Sans MS", Font.PLAIN, 18));
		lblValp.setBounds(600, 604, 72, 18);
		contentPane.add(lblValp);
		
		D_S_valP = new JTextField();
		D_S_valP.setText("0x0");
		D_S_valP.setColumns(10);
		D_S_valP.setBounds(551, 634, 152, 24);
		contentPane.add(D_S_valP);
		
		D_I_valP = new JTextField();
		D_I_valP.setText("0x0");
		D_I_valP.setColumns(10);
		D_I_valP.setBounds(551, 669, 152, 24);
		contentPane.add(D_I_valP);
		
		D_I_rA = new JTextField();
		D_I_rA.setText("----");
		D_I_rA.setColumns(10);
		D_I_rA.setBounds(260, 669, 51, 24);
		contentPane.add(D_I_rA);
		
		D_S_rA = new JTextField();
		D_S_rA.setText("----");
		D_S_rA.setColumns(10);
		D_S_rA.setBounds(260, 634, 51, 24);
		contentPane.add(D_S_rA);
		
		lblRa = new JLabel("rA");
		lblRa.setFont(new Font("Comic Sans MS", Font.PLAIN, 18));
		lblRa.setBounds(269, 604, 72, 18);
		contentPane.add(lblRa);
		
		lblRb = new JLabel("rB");
		lblRb.setFont(new Font("Comic Sans MS", Font.PLAIN, 18));
		lblRb.setBounds(334, 604, 72, 18);
		contentPane.add(lblRb);
		
		D_S_rB = new JTextField();
		D_S_rB.setText("----");
		D_S_rB.setColumns(10);
		D_S_rB.setBounds(325, 634, 51, 24);
		contentPane.add(D_S_rB);
		
		D_I_rB = new JTextField();
		D_I_rB.setText("----");
		D_I_rB.setColumns(10);
		D_I_rB.setBounds(325, 669, 51, 24);
		contentPane.add(D_I_rB);
		
		lblF = new JLabel("F");
		lblF.setFont(new Font("Comic Sans MS", Font.PLAIN, 40));
		lblF.setBounds(14, 754, 39, 65);
		contentPane.add(lblF);
		
		label_20 = new JLabel("State");
		label_20.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
		label_20.setBounds(62, 761, 72, 18);
		contentPane.add(label_20);
		
		label_21 = new JLabel("Input");
		label_21.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
		label_21.setBounds(62, 792, 72, 27);
		contentPane.add(label_21);
		
		F_I_Stat = new JTextField();
		F_I_Stat.setText("AOK");
		F_I_Stat.setColumns(10);
		F_I_Stat.setBounds(129, 795, 39, 24);
		contentPane.add(F_I_Stat);
		
		F_S_Stat = new JTextField();
		F_S_Stat.setText("AOK");
		F_S_Stat.setColumns(10);
		F_S_Stat.setBounds(129, 760, 39, 24);
		contentPane.add(F_S_Stat);
		
		label_22 = new JLabel("Stat");
		label_22.setFont(new Font("Comic Sans MS", Font.PLAIN, 18));
		label_22.setBounds(129, 730, 72, 18);
		contentPane.add(label_22);
		
		lblPredpc = new JLabel("predPC");
		lblPredpc.setFont(new Font("Comic Sans MS", Font.PLAIN, 18));
		lblPredpc.setBounds(215, 730, 72, 18);
		contentPane.add(lblPredpc);
		
		F_S_predPC = new JTextField();
		F_S_predPC.setText("0x0");
		F_S_predPC.setColumns(10);
		F_S_predPC.setBounds(182, 760, 152, 24);
		contentPane.add(F_S_predPC);
		
		F_I_predPC = new JTextField();
		F_I_predPC.setText("0x0");
		F_I_predPC.setColumns(10);
		F_I_predPC.setBounds(182, 795, 152, 24);
		contentPane.add(F_I_predPC);
		
		JLabel lblRegister = new JLabel("Register:");
		lblRegister.setForeground(Color.BLACK);
		lblRegister.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
		lblRegister.setBounds(398, 754, 109, 26);
		contentPane.add(lblRegister);
		
		JLabel lblNewLabel_4 = new JLabel("%rax:");
		lblNewLabel_4.setForeground(Color.BLACK);
		lblNewLabel_4.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
		lblNewLabel_4.setBounds(446, 808, 72, 18);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblrcx = new JLabel("%rcx:");
		lblrcx.setForeground(Color.BLACK);
		lblrcx.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
		lblrcx.setBounds(446, 848, 72, 18);
		contentPane.add(lblrcx);
		
		JLabel lblrbx = new JLabel("%rdx:");
		lblrbx.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
		lblrbx.setBounds(446, 888, 72, 18);
		contentPane.add(lblrbx);
		
		JLabel lblrdx = new JLabel("%rbx:");
		lblrdx.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
		lblrdx.setBounds(446, 928, 72, 18);
		contentPane.add(lblrdx);
		
		lblrsp = new JLabel("%rsp:");
		lblrsp.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
		lblrsp.setBounds(446, 966, 72, 26);
		contentPane.add(lblrsp);
		
		lblrbp = new JLabel("%rbp:");
		lblrbp.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
		lblrbp.setBounds(670, 805, 72, 24);
		contentPane.add(lblrbp);
		
		rax = new JTextField();
		rax.setText("0x0");
		rax.setBounds(501, 808, 155, 24);
		contentPane.add(rax);
		rax.setColumns(10);
		
		rcx = new JTextField();
		rcx.setText("0x0");
		rcx.setColumns(10);
		rcx.setBounds(501, 848, 155, 24);
		contentPane.add(rcx);
		
		rdx = new JTextField();
		rdx.setText("0x0");
		rdx.setColumns(10);
		rdx.setBounds(501, 888, 155, 24);
		contentPane.add(rdx);
		
		rbx = new JTextField();
		rbx.setText("0x0");
		rbx.setColumns(10);
		rbx.setBounds(501, 928, 155, 24);
		contentPane.add(rbx);
		
		rsp = new JTextField();
		rsp.setText("0x0");
		rsp.setColumns(10);
		rsp.setBounds(501, 968, 155, 24);
		contentPane.add(rsp);
		
		rbp = new JTextField();
		rbp.setText("0x0");
		rbp.setColumns(10);
		rbp.setBounds(724, 808, 156, 24);
		contentPane.add(rbp);
		
		lblrsi = new JLabel("%rsi:");
		lblrsi.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
		lblrsi.setBounds(671, 848, 72, 18);
		contentPane.add(lblrsi);
		
		lblrdi = new JLabel("%rdi:");
		lblrdi.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
		lblrdi.setBounds(671, 888, 72, 18);
		contentPane.add(lblrdi);
		
		lblr = new JLabel("%r8:");
		lblr.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
		lblr.setBounds(671, 928, 72, 18);
		contentPane.add(lblr);
		
		lblr_1 = new JLabel("%r9:");
		lblr_1.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
		lblr_1.setBounds(671, 968, 72, 18);
		contentPane.add(lblr_1);
		
		lblr_2 = new JLabel("%r10:");
		lblr_2.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
		lblr_2.setBounds(894, 802, 72, 26);
		contentPane.add(lblr_2);
		
		lblr_3 = new JLabel("%r11:");
		lblr_3.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
		lblr_3.setBounds(894, 842, 72, 24);
		contentPane.add(lblr_3);
		
		rsi = new JTextField();
		rsi.setText("0x0");
		rsi.setColumns(10);
		rsi.setBounds(724, 848, 156, 24);
		contentPane.add(rsi);
		
		rdi = new JTextField();
		rdi.setText("0x0");
		rdi.setColumns(10);
		rdi.setBounds(724, 888, 155, 24);
		contentPane.add(rdi);
		
		r8 = new JTextField();
		r8.setText("0x0");
		r8.setColumns(10);
		r8.setBounds(724, 928, 156, 24);
		contentPane.add(r8);
		
		r9 = new JTextField();
		r9.setText("0x0");
		r9.setColumns(10);
		r9.setBounds(724, 968, 156, 24);
		contentPane.add(r9);
		
		r10 = new JTextField();
		r10.setText("0x0");
		r10.setColumns(10);
		r10.setBounds(948, 808, 155, 24);
		contentPane.add(r10);
		
		r11 = new JTextField();
		r11.setText("0x0");
		r11.setColumns(10);
		r11.setBounds(948, 848, 155, 24);
		contentPane.add(r11);
		
		lblr_4 = new JLabel("%r12:");
		lblr_4.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
		lblr_4.setBounds(894, 888, 72, 18);
		contentPane.add(lblr_4);
		
		lblr_5 = new JLabel("%r13:");
		lblr_5.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
		lblr_5.setBounds(894, 928, 72, 18);
		contentPane.add(lblr_5);
		
		lblr_6 = new JLabel("%r14:");
		lblr_6.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
		lblr_6.setBounds(894, 968, 72, 18);
		contentPane.add(lblr_6);
		
		r12 = new JTextField();
		r12.setText("0x0");
		r12.setColumns(10);
		r12.setBounds(948, 888, 155, 24);
		contentPane.add(r12);
		
		r13 = new JTextField();
		r13.setText("0x0");
		r13.setColumns(10);
		r13.setBounds(948, 928, 155, 24);
		contentPane.add(r13);
		
		r14 = new JTextField();
		r14.setText("0x0");
		r14.setColumns(10);
		r14.setBounds(948, 968, 155, 24);
		contentPane.add(r14);
		
		lblStat_1 = new JLabel("Stat:");
		lblStat_1.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
		lblStat_1.setBounds(85, 867, 72, 18);
		contentPane.add(lblStat_1);
		
		Stat = new JTextField();
		Stat.setText("AOK");
		Stat.setBounds(152, 866, 86, 24);
		contentPane.add(Stat);
		Stat.setColumns(10);
		
		lblZf = new JLabel("ZF:");
		lblZf.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
		lblZf.setBounds(37, 909, 27, 18);
		contentPane.add(lblZf);
		
		lblSF = new JLabel("SF:");
		lblSF.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
		lblSF.setBounds(129, 909, 27, 18);
		contentPane.add(lblSF);
		
		lblOF = new JLabel("OF:");
		lblOF.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
		lblOF.setBounds(230, 909, 29, 18);
		contentPane.add(lblOF);
		
		ZF = new JTextField();
		ZF.setText("true");
		ZF.setBounds(67, 907, 48, 24);
		contentPane.add(ZF);
		ZF.setColumns(10);
		
		SF = new JTextField();
		SF.setText("false");
		SF.setColumns(10);
		SF.setBounds(166, 908, 51, 24);
		contentPane.add(SF);
		
		OF = new JTextField();
		OF.setText("false");
		OF.setColumns(10);
		OF.setBounds(266, 907, 56, 24);
		contentPane.add(OF);
		
		lblMemoryState = new JLabel("Memory state:");
		lblMemoryState.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
		lblMemoryState.setBounds(748, 585, 355, 26);
		contentPane.add(lblMemoryState);
		
		
		JLabel lblCpi = new JLabel("CPI:");
		lblCpi.setBounds(84, 955, 72, 18);
		lblCpi.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
		contentPane.add(lblCpi);
		
		CPI = new JTextField();
		CPI.setText("1.00");
		CPI.setBounds(149, 954, 68, 24);
		contentPane.add(CPI);
		CPI.setColumns(10);
		
		lblBreakpoint = new JLabel("Breakpoint (5chars or none) :");
		lblBreakpoint.setBounds(0, 32, 207, 26);
		lblBreakpoint.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		contentPane.add(lblBreakpoint);
	

		breakpoint = new JTextField();
		breakpoint.setBounds(48, 59, 86, 24);
		contentPane.add(breakpoint);
		breakpoint.setColumns(10);
		
		
		
		
		ImageIcon bg = new ImageIcon("src/gui3.jpg"); 
		JLabel lblNewLabel_5 = new JLabel(bg);
		lblNewLabel_5.setBounds(0,0,bg.getIconWidth(),bg.getIconHeight());
		contentPane.add(lblNewLabel_5);
		
		
		
		
	}
	private static void addPopup(Component component, final JPopupMenu popup) {
		component.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			public void mouseReleased(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			private void showMenu(MouseEvent e) {
				popup.show(e.getComponent(), e.getX(), e.getY());
			}
		});
	}
}

