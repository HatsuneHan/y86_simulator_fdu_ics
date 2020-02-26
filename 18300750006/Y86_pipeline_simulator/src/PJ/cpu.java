package PJ;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class cpu {
	static int halt = 0 ;
	static int nop =  1 ;
	static int rrmovq = 2 ;
	static int irmovq = 3 ;
	static int rmmovq = 4 ;
	static int mrmovq = 5 ;
	static int opq = 6 ;
	static int jxx = 7 ;
	static int cmovxx = 2 ;
	static int call = 8 ;
	static int ret = 9 ;
	static int pushq = 0xa ;
	static int popq =0xb;
	static int iopq =0xc ;

	//ifun
	static int addq =0;
	static int subq =1;
	static int andq =2;
	static int xorq =3;
	static int iaddq = 0 ;
	static int isubq = 1 ;
	static int iandq = 2 ;
	static int ixorq = 3 ;
	static int jmp =0;
	static int jle =1;
	static int jl =2;
	static int je =3;
	static int jne =4;
	static int jge =5;
	static int jg =6;
	static int cmovle =1;
	static int cmovl =2;
	static int cmove =3;
	static int cmovne =4;
	static int cmovge =5;
	static int cmovg =6;

	//register
	static int rax =0;
	static int rcx =1;
	static int rdx =2;
	static int rbx =3;
	static int rsp =4;
	static int rbp =5;
	static int rsi =6;
	static int rdi =7;
	static int r8 =8;
	static int r9 =9;
	static int r10 =0xa;
	static int r11 =0xb;
	static int r12 =0xc;
	static int r13 =0xd;
	static int r14 =0xe;
	static int rnone =0xf;

	static int AOK =0 ;
	static int HLT =1 ;
	static int ADR =2;
	static int INS =3;
	static int BUB =4 ;
	
	public static int sleeptime = 10000 ;
	public static boolean ting = false ;
	public static int timechanger = 10 ;

	public static long filesize = 0 ;
	public static long reg[] = new long[1000005] ;
	public static char getfile[] = new char[1000005] ;
	public static long mem[] = new long[1000005] ;
	public static long pro[] = new long[1000005] ;
	public static long cmd[] = new long[10] ;
	public static int locate[] = new int[1000005] ;
	public static char ca ;
	public static String[][] fuc = {{"halt"} , {"nop"} , {"rrmovq","cmovle","cmovl","cmove","cmovne","cmovge","cmovg"} ,
			{"irmovq"} , {"rmmovq"} , {"mrmovq"} , {"addq","subq","andq","xorq"} , 
			{"jmp","jle","jl","je","jne","jge","jg"},{"call"},{"ret"},{"pushq"},{"popq"},{"iaddq","isubq","iandq","ixorq"} } ;
	
	public static String[] REG = {"%rax","%rcx","%rdx","%rbx","%rsp","%rbp","%rsi","%rdi",
			"%r8","%r9","%r10","%r11","%r12","%r13","%r14","----"} ;
	public static String[] stat = {"AOK","HLT","ADR","INS","BUB"} ;
	
	public static String Stat ;
	
	public static double cpi ;
	
	//fetch
	public static long f_ifun , f_rA , f_rB , f_valC , f_valP , f_stat , f_pc ,f_predpc ;
	public static long F_predpc ;
	public static long f_icode ;
	public static long imem_error, instr_valid ;

	//decode
	public static long d_valA , d_valB , d_dstE , d_dstM , d_srcA , d_srcB , d_rvalA , d_rvalB ;
	public static long D_stat , D_icode , D_ifun , D_rA , D_rB , D_valC , D_valP ;

	//execute
	public static long e_valE ;
	public static long  E_valC, E_valA, E_valB, E_dstE, E_dstM, E_srcA, E_srcB, E_stat;
	public static int E_icode , ALU_fun , E_ifun ;
	public static long  ALUA , ALUB ;
	public static boolean needALU , e_Cnd ;

	//memory
	public static long m_valM , m_addr ;
	public static long M_stat , M_icode , M_ifun , M_valE , M_valA , M_dstE , M_dstM ;
	public static boolean m_stat , m_read , m_write , M_Cnd ;


	//write back
	public static long W_stat , W_icode , W_ifun , W_valE , W_valM , W_dstE , W_dstM ;

	//reference:control
	public static boolean D_bubble , E_bubble , M_bubble;
	public static boolean F_stall , D_stall ;

	//halt
	public static boolean halt_flag;
	public static boolean halt_state;

	public static boolean ZF;
	//condition
	public static boolean SF , OF ;
	public static boolean set_cc ;

	public static long loc ;
	public static int cyclenum = -4 ;
	public static long stacktop = 0 ;
	
	public static boolean finished = false;
	
	public static boolean flag = false ;
	
	public static boolean stepped = false ;
	
	public static int instrnum = 0 ;
	
	
	public void stop() {
        finished = true;    
    }
	
	public void start() {
        finished = false;    
    }
	
	public void stepstop() {
        stepped = true;    
    }
	
	public void stepstart() {
        stepped = false;    
    }
	
	
	public static void run() throws InterruptedException
	{
		System.out.println(" Please input the name of the file \n"); 
		
		Scanner sc = new Scanner(System.in) ;
		String name = sc.nextLine() ; 
		
		Read(name) ;
		initialset() ;
		cycle() ;
	}
	public static void main(String args[]) throws InterruptedException {
		
		System.out.println(" Please input the name of the file \n"); 
		
		Scanner sc = new Scanner(System.in) ;
		String name = sc.nextLine() ; 
		
		Read(name) ;
		initialset() ;
		
		while(  !finished && W_icode != halt && W_stat != ADR )
		{
			
			writeback() ;
			memory() ;
			execute() ;
			decode();
			fetch() ; 

			ctrl() ;
			renew() ;
		//	display() ;
			Thread.sleep(2000);
			

		}
		
	}
	
	public static void cycle() throws InterruptedException
	{
		while(  !finished && W_icode != halt && W_stat != ADR )
		{
			
			writeback() ;
			memory() ;
			execute() ;
			decode();
			fetch() ; 

			ctrl() ;
			renew() ;
			display() ;
			Thread.sleep(2000);
			

		}
	}

	public static void initialset()
	{
		f_icode = nop ; f_ifun = 0 ;
	    D_icode = nop ; D_ifun = 0 ;
	    E_icode = nop ; E_ifun = 0 ;
	    M_icode = nop ; W_icode = nop ;
	    M_ifun = 0 ; W_ifun = 0 ;
		Stat = "AOK" ;
	    
		reg[rax] = 0 ; reg[rbx] = 0 ; reg[rcx] = 0 ; reg[rdx] = 0 ; reg[rsi] = 0 ; reg[rdi] = 0 ; reg[rsp] = 0 ; reg[rbp] = 0 ;
		reg[r8] = 0 ; reg[r9] = 0 ; reg[r10] = 0 ; reg[r11] = 0 ; reg[r12] = 0 ; reg[r13] = 0 ; reg[r14] = 0 ; reg[rnone] = 0 ;
	    
	    f_stat = BUB ;f_rA = rnone ; f_rB = rnone ; f_valC = 0 ; f_valP = 0 ; f_predpc = 0 ; f_pc = 0 ; F_predpc = 0 ;
	    D_stat = BUB ;D_rA = rnone ; D_rB = rnone ; D_valC = 0 ; D_valP = 0 ;
	    d_valA = 0 ; d_valB = 0 ; 
		d_dstE = rnone ; d_dstM = rnone ; d_srcA = rnone ; d_srcB = rnone ;
		e_valE = 0 ;
		E_stat = BUB ;E_valC = 0 ; E_valA = 0 ; E_valB = 0 ;
		E_dstE = rnone ;  E_dstM = rnone ; E_srcA =rnone ; E_srcB = rnone ;
		e_Cnd = true ;
		m_valM = 0 ; m_addr = 0 ;
		M_stat = BUB ;M_valE = 0 ; M_valA = 0 ;
		M_dstE = rnone ; M_dstM = rnone ;
		M_Cnd = true ; m_read = false ; m_write = false ;
		W_stat = BUB ;W_valE = 0 ; W_valM = 0 ; 
		W_dstE = rnone ; W_dstM = rnone ;
		ALUA = 0 ; ALUB = 0 ; needALU = true ;
		ZF = true ; SF = false ; OF = false ;
		halt_flag = false ;
		halt_state = false ;
		stacktop = 0 ;
		loc = 0 ;
		cyclenum = -4 ;
		
		set_cc = false ;
		loc = 999999999 ;
		instrnum = 0 ;
		cpi = 1 ;
	}
	
	
	
	public static void Read(String name) 
	{
		filesize = 0 ;
		for (int i = 0 ; i < 1000005 ; i++ )
			mem[i] = 0 ;
		for ( int i = 0 ; i < 1000005 ; i++ )
			getfile[i] = ' ' ;
		for ( int i = 0 ; i < 1000005 ; i++ )
			pro[i] = 0 ;
		
		int num = 0;
        
        FileReader fr = null;
		try {
			fr = new FileReader(name);
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
       
        try {
			while((num=fr.read(getfile))!=-1) {
			     
				System.out.println(new String(getfile,0,num));;
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        for ( int i = 0 ; i < 10005 ; i++  )
            locate[i] = -1 ;
        
        int n = 0 ; int k = -1 ;
        int flag = 0 ; int F = 0 ;
        
        int g = getfile.length ;
        
        for( int i = 0 ; i <= g ;  i++,n++ )
        {
            if ( flag == 0 && n+6 <= g && getfile[n] == '0'  && getfile[n+1] =='x' && getfile[n+5] == ':' && getfile[n+6] == ' ' )
            {
                n += 6 ;
                i += 6 ;
                flag = 1 ;
                F = 1 ;
                continue ;
            }
            else if ( flag == 1 )
            {
                if ( F == 1 && getfile[n] != ' ' )
                {
                    int tmp = 0 ;
                    int a[] = new int[3] ;
                    for ( int kk = -5 ; kk <= -3 ; kk++ )
                    {
                    
                        if ( getfile[n+kk] <= '9' && getfile[n+kk] >= '0' )
                            a[kk+5] = getfile[n+kk] - '0' ;
                        else if ( getfile[n+kk] >= 'a' && getfile[n+kk] <= 'f' )
                            a[kk+5] = getfile[n+kk] -'a' + 10 ;
        
                    }
                    tmp = a[0]*256+a[1]*16+a[2] ;
                    locate[k+1] = tmp ;
                    F = 0 ;
                
                }
                if ( getfile[n] <= '9' && getfile[n] >= '0' )
                    pro[++k] = getfile[n] - '0' ;
                else if ( getfile[n] >= 'a' && getfile[n] <= 'f' )
                    pro[++k] = getfile[n] -'a' + 10 ;
                else if ( getfile[n] == ' ' || getfile[n] == ':')
                    flag = 0 ; 
            }
        }

        filesize = n ;
        
        for ( int i = 0  ; i + 1 <= k ; i += 2 )
        {
            if(locate[i] == -1 )
                mem[++num] = (( pro[i] & 0x0f ) << 4) + ( pro[i+1] & 0x0f ) ; 
            else
            {
                num = locate[i] ;
                mem[num] = (( pro[i] & 0x0f ) << 4) + ( pro[i+1] & 0x0f ) ;
            }
            
        }
        
       
	}
	
	public static void fetch()
	{
		f_rA = rnone ; f_rB = rnone ; f_valC = 0 ; f_valP = 0 ;

	    if ( (M_icode == jxx) && !M_Cnd )
	        f_pc = M_valA ;
		else if ( W_icode == ret )
	        f_pc = W_valM ;
	    else
	        f_pc = F_predpc ;
	    	
		int i ;
		
		for ( i = 0 ; i < 10 ; i++ )
			cmd[i] = mem[(int) (f_pc+i)] ;
		
		f_icode = (( cmd[0] & 0xf0 ) >> 4) ;
		f_ifun = ( cmd[0] & 0x0f ) ;
		if (f_icode == halt)
			f_stat = HLT ;
		else 
			f_stat = AOK ;

		switch((int)f_icode){
			
			case 0 : 
			case 1 :
			case 9 : 
				f_valP = f_pc + 1 ;
				break ;
			
			case 2 :
			case 6 :
			case 0xa :
			case 0xb :
				f_valP = f_pc + 2 ;
				f_rA = ( cmd[1] & 0xf0 ) >> 4 ;
				f_rB = ( cmd[1] & 0x0f ) ; 
				break ;
			
			case 3 :
			case 4 :
			case 5 :
			case 0xc : // iopq
				f_rA = ( cmd[1] & 0xf0 ) >> 4 ;
				f_rB = ( cmd[1] & 0x0f ) ; 
				f_valC = cmd[2] + ( cmd[3] << 8 ) + ( cmd[4] << 16 ) + ( cmd[5] << 24 ) + ( cmd[6] << 32 ) + ( cmd[7] << 40 ) + ( cmd[8] << 48 ) + ( cmd[9] << 56 ) ;
				f_valP = f_pc + 10 ;
				break ;
				
			case 7 :
			case 8 :
				f_valC = cmd[1] + ( cmd[2] << 8 ) + ( cmd[3] << 16 ) + ( cmd[4] << 24 ) + ( cmd[5] << 32 ) + ( cmd[6] << 40 ) + ( cmd[7] << 48 ) + ( cmd[8] << 56 ) ;
				f_valP = f_pc + 9 ;
				break ;
			default :
				f_valP = f_pc + 1 ;
				f_stat = INS ;
				
		}

		
		
		if ( f_icode == call || f_icode == jxx )
			f_predpc = f_valC ;
		else
			f_predpc = f_valP ;

			
	}
	
	public static void decode()
	{
		if(D_icode == halt)
			halt_flag = true ;
		
		d_valA = 0 ; d_valB = 0 ; 
		d_dstE = rnone ; d_dstM = rnone ; d_srcA = rnone ; d_srcB = rnone ;
		
		// get address 
		if ( D_icode == rrmovq || D_icode == rmmovq || D_icode == opq || D_icode == pushq )
			d_srcA = D_rA ;
		else if ( D_icode == popq || D_icode == ret )
			d_srcA = rsp ;
		else
			d_srcA = rnone ;
		
		if ( D_icode == mrmovq || D_icode == rmmovq || D_icode == opq || D_icode == iopq )
			d_srcB = D_rB ;
		else if ( D_icode == pushq || D_icode == popq || D_icode == ret || D_icode == call )
			d_srcB = rsp ;
		else
			d_srcB = rnone ; 

		if ( D_icode == rrmovq || D_icode == irmovq || D_icode == opq || D_icode == iopq )
			d_dstE = D_rB;
		else if ( D_icode == pushq || D_icode == popq || D_icode == call || D_icode == ret )
			d_dstE = rsp ;
		else
			d_dstE = rnone ;
		
		
		if ( D_icode == mrmovq || D_icode == popq )
			d_dstM = D_rA ;
		else
			d_dstM = rnone ;
		

		

		
		// get valA , valB 
		d_rvalA = reg[(int) d_srcA] ;
		d_rvalB = reg[(int) d_srcB] ;

		if ( D_icode == call || D_icode == jxx )
			d_valA = D_valP ;
		else if ( d_srcA == E_dstE && d_srcA != rnone )
			d_valA = e_valE ;
		else if ( d_srcA == M_dstM && d_srcA != rnone )
			d_valA = m_valM ;
		else if ( d_srcA == M_dstE && d_srcA != rnone )
			d_valA = M_valE ;
		else if ( d_srcA == W_dstM && d_srcA != rnone )
			d_valA = W_valM ;
		else if ( d_srcA == W_dstE && d_srcA != rnone )
			d_valA = W_valE ;
		else if (d_srcA != rnone)
			d_valA = d_rvalA ;

		if ( d_srcB == E_dstE && d_srcB != rnone )
			d_valB = e_valE ;
		else if ( d_srcB == M_dstM && d_srcB != rnone )
			d_valB = m_valM ;
		else if ( d_srcB == M_dstE && d_srcB != rnone )
			d_valB = M_valE ;
		else if ( d_srcB == W_dstM && d_srcB != rnone )
			d_valB = W_valM ;
		else if ( d_srcB == W_dstE && d_srcB != rnone )
			d_valB = W_valE ;
		else if (d_srcB != rnone)
			d_valB = d_rvalB ;
		
	}
	
	public static void execute()
	{
		needALU = true ;
		e_Cnd = true ;
		e_valE = 0 ;

		switch(E_icode){
			case 6 :
			case 2 :
				ALUA = E_valA ;
				break ;
			
			case 3 :
			case 4 :
			case 0xc :
			case 5 :
				ALUA = E_valC ;
				break ;

			case 8 :
			case 0xa :
				ALUA = -8 ;
				break ;

			case 0xb :
			case 9 :
				ALUA = 8 ;
				break ;

			default :
				needALU = false ;
				break ;
		}

		switch(E_icode){
			
			case 4 :
			case 5 :
			case 0xa :
			case 0xb :
			case 8 :
			case 9 :
			case 0xc : 
			case 6 :
				ALUB = E_valB ;
				break ;
			
			case 2 :
			case 3 :
				ALUB = 0 ;
				break ;

			default :
				needALU = false ;
				break ;
			
		}

		//ALU 

		if(needALU) 
		{
			ALU_fun = ( (E_icode == opq || E_icode == iopq ) ? E_ifun : addq ) ;
			if((E_icode == opq || E_icode == iopq) && (M_stat == AOK || M_stat == BUB) && (W_stat == AOK || W_stat == BUB) ) 
				set_cc = true ;
			else
				set_cc = false ;		
				
				switch(ALU_fun){
				
				case 0 :
					e_valE = ALUA + ALUB ;
					if(set_cc)
					{
						ZF = (e_valE == 0);
						OF = (ALUA > 0 && ALUB > 0 && e_valE < 0) || (ALUA < 0 && ALUB < 0 && e_valE > 0);
						SF = (e_valE < 0);
					}
					break ;

				case 1 :
					e_valE = ALUB - ALUA ;
					if(set_cc)
					{
						ZF = (e_valE == 0);
						OF = (ALUA > 0 && ALUB > 0 && e_valE < 0) || (ALUA < 0 && ALUB < 0 && e_valE > 0);
						SF = (e_valE < 0);
					}
					break ;
				
				case 2 :
					e_valE = ALUA & ALUB ;
					if(set_cc)
					{
						ZF = (e_valE == 0);
						OF = (ALUA > 0 && ALUB > 0 && e_valE < 0) || (ALUA < 0 && ALUB < 0 && e_valE > 0);
						SF = (e_valE < 0);
					}
					break ;

				case 3 :
					e_valE = ALUA ^ ALUB ;
					if(set_cc)
					{
						ZF = (e_valE == 0);
						OF = (ALUA > 0 && ALUB > 0 && e_valE < 0) || (ALUA < 0 && ALUB < 0 && e_valE > 0);
						SF = (e_valE < 0);
					}
					break ;

				default :
					E_stat = INS ;
				} 

				
		
			
		}

		if ( E_icode == jxx || E_icode == cmovxx ) 
		{
			switch( E_ifun ){
				
				case 3 :
					e_Cnd = ZF ;
					break ;

				case 6 :
					e_Cnd = !((SF^OF) | ZF) ;
					break ;
				
				case 5 :
					e_Cnd = !(SF^OF) ;
					break ;
				
				case 2 :
					e_Cnd = SF^OF ;
					break ;
				
				case 1 :
					e_Cnd = ((SF^OF) | ZF) ;
					break ;
				
				case 0 :
					e_Cnd = true ;
					break ;
				
				case 4 :
					e_Cnd = !ZF ;
					break ;
			}
		}

		if ( E_icode == cmovxx && e_Cnd == false)
			E_dstE = rnone ;
		
	}
	
	public static void memory()
	{
		m_write = false ;
		m_read = false ;
		m_valM = 0 ;
		
	 
		if ( M_icode == rmmovq || M_icode == pushq || M_icode == call || M_icode == mrmovq )
			m_addr = M_valE ;
		else if ( M_icode == popq || M_icode == ret )
			m_addr = M_valA ;

		if ( M_icode == mrmovq || M_icode == popq || M_icode == ret )
			m_read = true ;
		else
			m_read = false ;
		

		if ( M_icode == rmmovq || M_icode == pushq || M_icode == call )
			m_write = true ;
		else
			m_write = false ;
		
	//	System.out.println(m_addr) ;
 
		
		if ( m_addr < 0 )
		{
			M_stat = ADR ;
		}
		if ( m_write && m_addr > 0  )
		{
			if ( loc > m_addr )
				loc = m_addr ;
			mem[ (int) m_addr ] = M_valA & 0xff ;
			mem[ (int) (m_addr + 1) ] = ( M_valA >> 8 ) & 0xff ;
			mem[ (int) (m_addr + 2) ] = ( M_valA >> 16 ) & 0xff ;
			mem[ (int) (m_addr + 3) ] = ( M_valA >> 24 ) & 0xff ;
			mem[ (int) (m_addr + 4) ] = ( M_valA >> 32 ) & 0xff ;
			mem[ (int) (m_addr + 5) ] = ( M_valA >> 40 ) & 0xff ;
			mem[ (int) (m_addr + 6) ] = ( M_valA >> 48 ) & 0xff ;
			mem[ (int) (m_addr + 7) ] = ( M_valA >> 56 ) & 0xff ;
	 	}
		
		if ( m_read )
			m_valM  = mem[ (int) m_addr ] + ( mem [ (int) (m_addr + 1) ] << 8 ) + ( mem [ (int) (m_addr + 2) ] << 16 )+ 
			( mem [ (int) (m_addr + 3) ] << 24 ) + ( mem [ (int) (m_addr + 4) ] << 32 ) + ( mem [ (int) (m_addr + 5) ] << 40 ) +
			( mem [ (int) (m_addr + 6) ] << 48 ) + ( mem [ (int) (m_addr + 7) ] << 56 ) ;
		
	}
	
	public static void writeback()
	{
		if ( W_icode == halt )
			halt_state = true ;
		if ( W_dstE != rnone )
			reg[(int) W_dstE] = W_valE ;
		if ( W_dstM != rnone )
			reg[(int) W_dstM] = W_valM ; 
		
		if ( stacktop < reg[rsp])
			stacktop = reg[rsp] ;
		
		//System.out.printf("%.10f", cpi) ;
		if ( W_stat == AOK )
			instrnum++ ;
		
		++cyclenum ;
		//System.out.println(cyclenum + " " + instrnum ) ;
		if (instrnum == 0 || cyclenum/instrnum < 1 )
			cpi = 1.00 ;
		else
			cpi = (cyclenum*1.0+1)/(instrnum*1.0+1) ;
	}
	
	public static void ctrl()
	{
		if(((E_icode == mrmovq || E_icode == popq ) && (E_dstM == d_srcA || E_dstM == d_srcB)) ||  (D_icode == ret || E_icode == ret || M_icode == ret) )
			F_stall = true ;
		else
			F_stall = false ;

		if( (E_icode == mrmovq || E_icode == popq ) && (E_dstM == d_srcA || E_dstM == d_srcB) ) 
			D_stall = true ;
		else
			D_stall = false ;

		if ( (E_icode == jxx && !e_Cnd ) || !((E_icode == mrmovq || E_icode == popq ) && (E_dstM == d_srcA || E_dstM == d_srcB)) && (D_icode == ret || E_icode == ret || M_icode == ret) )
			D_bubble = true ;
		else
			D_bubble = false ;

	    if ( (E_icode == jxx && !e_Cnd ) || ((E_icode == mrmovq || E_icode == popq ) && (E_dstM == d_srcA || E_dstM == d_srcB)) )
			E_bubble = true ;
		else
			E_bubble = false ;
	}
	
	public static void renew()
	{
		W_stat = M_stat ; W_icode = M_icode ; W_ifun = M_ifun ; W_valE = M_valE ;
		W_dstE = M_dstE ; W_dstM = M_dstM ; W_valM = m_valM ; 
		
		
			
		
		if(W_stat == HLT)
		{
			M_stat = BUB ; M_icode = nop ; M_Cnd = true ; M_valE = 0 ; 
			M_valA = 0 ;M_dstE = rnone ; M_dstM = rnone ;
		}
		else
		{
			M_stat = E_stat ;  M_icode = E_icode ; M_ifun = E_ifun ; M_Cnd = e_Cnd ; M_valE = e_valE ; 
			M_valA = E_valA ; M_dstE = E_dstE ; M_dstM = E_dstM ;
		}
		

		
		// register	
		
		
		
		if ( E_bubble )	
		{
			E_icode = nop ; E_ifun = 0 ; E_valC = 0 ; E_valA = 0 ; E_valB = 0 ;
			E_dstE = rnone ; E_dstM = rnone ; 
			E_srcA = rnone ; E_srcB = rnone ; E_stat = BUB ;
		}
		else
		{
			E_stat = D_stat ; E_icode = (int) D_icode ; E_ifun = (int) D_ifun ; E_valC = D_valC ;
			E_valA = d_valA ; E_valB = d_valB ; E_dstE = d_dstE ; E_dstM = d_dstM ;
			E_srcA = d_srcA ; E_srcB = d_srcB ;
		}
		

		if ( !D_bubble && !D_stall )
		{
			D_stat = f_stat ;
			D_icode = f_icode;
			D_ifun = f_ifun;
			D_rA = f_rA;
			D_rB = f_rB;
			D_valC = f_valC;
			D_valP = f_valP;
		}
		else if (!D_stall)
		{
			D_stat = BUB ;
			D_icode = nop;
			D_ifun = 0;
			D_rA = rnone;
			D_rB = rnone;
			D_valC = 0;
			D_valP = 0;
		}	
		if(!F_stall)
			F_predpc = f_predpc ;

		if ( W_stat == ADR )
			Stat = "ADR" ;
		else if (W_stat == HLT)
			Stat = "HLT" ;
		else 
			Stat = "AOK" ;
		
		System.out.println("\n");
	}
	
	public static void display()
	{
		System.out.println('\n');
		System.out.println("Cycle " + (++cyclenum) + ". ");
		System.out.println("CC=" + "ZF=" + ZF + " SF=" + SF + " OF=" + OF);
		System.out.println(", Stat=" + Stat + '\n');
		
		
		
		System.out.printf("F: predPC = "+"%010x\n",F_predpc );
		System.out.println(", Stat = "+ stat[(int) f_stat] );
		
		//System.out.println(f_icode + " " + D_ifun );
		System.out.println("D: instr = "+ fuc[(int) D_icode][(int) D_ifun] );
		System.out.println(", rA = " + REG[(int) D_rA]); 	
		System.out.println(", rB = " + REG[(int) D_rB]);
		System.out.printf(", valC = " + "%08x", D_valC );
		System.out.printf(", valP = " + "%08x", D_valP );
		System.out.println(", Stat = " + stat[(int) D_stat] + '\n' );
		
		
		System.out.println("E: instr = "+ fuc[(int) E_icode][(int) E_ifun] );
		System.out.printf(", valC = " +"%08x", E_valC ); 	
		System.out.printf( ", valA = "+ "%08x",E_valA );
		System.out.printf(", valB = " + "%08x",E_valB );
		System.out.println(", srcA = " + REG[(int) E_srcA]);
		System.out.println(", srcB = "+ REG[(int) E_srcB]);
		System.out.println(", Stat = " + stat[(int) E_stat] +'\n' );
	
		System.out.println("M: instr = "+ fuc[(int) M_icode][(int) M_ifun] );
		System.out.println(", Cnd = " + M_Cnd); 	
		System.out.printf( ", valE = " + "%08x",M_valE);
		System.out.printf(", valA = " + "%08x",M_valA);
		System.out.println(", dstE = " + REG[(int) M_dstE]);
		System.out.println(", dstM = " + REG[(int) M_dstM]);
		System.out.println(", Stat = " + stat[(int) M_stat] +'\n' );
	
		System.out.println("W: instr = "+ fuc[(int) W_icode][(int) W_ifun] );	
		System.out.printf( ", valE = " + "%08x",W_valE);
		System.out.printf(", valM = " + "%08x",W_valM );
		System.out.println(", dstE = " + REG[(int) W_dstE]);
		System.out.println(", dstM = " + REG[(int) W_dstM]);
		System.out.println(", Stat = " + stat[(int) W_stat] +'\n' );

		
		System.out.println("#register: \n");
		System.out.println("%rax : "); 
		System.out.printf("%08x",reg[rax]);
		
		System.out.println("%rcx : "); 
		System.out.printf("%08x",reg[rcx]);
		
		System.out.println("%rdx : "); 
		System.out.printf("%08x",reg[rdx]);
		
		System.out.println("%rbx : "); 
		System.out.printf("%08x",reg[rbx]);
		
		System.out.println("%rsp : "); 
		System.out.printf("%08x",reg[rsp]);
		
		System.out.println("%rbp : "); 
		System.out.printf("%08x",reg[rbp]);
		
		System.out.println("%rsi : "); 
		System.out.printf("%08x",reg[rsi]);
		
		System.out.println("%rdi : "); 
		System.out.printf("%08x",reg[rdi]);
		
		System.out.println("%r8 : "); 
		System.out.printf("%08x",reg[r8]);
		
		System.out.println("%r9 : "); 
		System.out.printf("%08x",reg[r9]);
		
		System.out.println("%r10 : "); 
		System.out.printf("%08x",reg[r10]);
		
		System.out.println("%r11 : "); 
		System.out.printf("%08x",reg[r11]);
		
		System.out.println("%r12 : "); 
		System.out.printf("%08x",reg[r12]);
		
		System.out.println("%r13 : "); 
		System.out.printf("%08x",reg[r13]);
		
		System.out.println("%r14 : "); 
		System.out.printf("%08x",reg[r14]);
		
		

		if(W_icode == halt)
		{
			System.out.println('\n') ;
			System.out.println("Memory State:\n");

			for ( int i = (int) loc ; i < reg[rsp] ; i+=8 )
			{
				long  ssum ;
				ssum = mem[i] + ( mem[i+1] << 8 ) + ( mem[i+2] << 16 ) + ( mem[i+3] << 24 ) + 
				( mem[i+4] << 32 ) + ( mem[i+5] << 40 ) + ( mem[i+6] << 48 ) + ( mem[i+7] << 56 ) ;
				System.out.printf("%08x", i );
				System.out.println('\n');
				System.out.printf("%08x", ssum);
				System.out.println('\n') ;
			}
			System.out.println('\n') ;
		}
		//System.out.println(mem[0x6d]) ;
		//000000006f
	}
	
	
	public class MyThread extends Thread {

	    
	    public void run() {
	    	System.out.println(" Please input the name of the file \n"); 
			
			Scanner sc = new Scanner(System.in) ;
			String name = sc.nextLine() ; 
			
			Read(name) ;
			initialset() ;
			
			while(  !finished && W_icode != halt && W_stat != ADR )
			{
				
				writeback() ;
				memory() ;
				execute() ;
				decode();
				fetch() ; 

				ctrl() ;
				renew() ;
				display() ;

			}    
	    }
	    
	    public void main(String[] args) {
	       
	    }
	}

}
