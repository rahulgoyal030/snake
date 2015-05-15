import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;


class MyFrame  implements ActionListener,KeyListener
{ 
	 JFrame f,f2;
	 JLabel  position[]= new JLabel[10000];
	 JButton start;
	 static int randomNum=0;
	 int value,count=0,front=0,rare=0;
     Timer up,down,left,right;
     int temp,score=
     0;
     JLabel heading,frameColor,scr;

	
	 MyFrame() {
		f = new JFrame("ClickMe");
        f.setSize(620,750);
		f.setLayout(null);
		//setContentPane(new JLabel( new ImageIcon("pic.png")));
		Container can = f.getContentPane();
		Color c= new Color(135,238,250);
		can.setBackground(c);    // to change backgroung color of frame
		f.setBounds(270,1,650,750);

		//frameColor = new JLabel(new ImageIcon("pic2.jpg"));
		//frameColor.setBounds(0,0,650,750);
		//f.add(frameColor);




		int j=1;  int k=1,margin=140;
		for(int i=1;i<=600;i++)
		{
 			if(j>30)
 			{
 				j=1;
 				k++;
 			}	

 			position[i]= new JLabel();
 			position[i].setBounds(j*20,margin+k*15,18,13);
 			f.add(position[i]);
 			position[i].setOpaque(true);
 		    position[i].setBackground(Color.black);
 			position[i].setVisible(false);

 			j++;


		}

		start = new JButton("NEW GAME");
		start.setBounds(220,480,150,30);
		f.add(start);

		scr = new JLabel("score " + score);
		scr.setBounds(220,530,200,40);
		f.add(scr);
		score=10;
		scr.setFont(new Font("", Font.BOLD,35));


		start.addActionListener(this);
		

		up= new Timer(500,this);
		down= new Timer(500,this);
		left= new Timer(500,this);
		right= new Timer(500,this);

		//up.setRepeats(false);
		//down.setRepeats(false);
		//left.setRepeats(false);
		//right.setRepeats(false);

		heading = new JLabel("SNAKE");
		heading.setBounds(230,20,300,40);
		f.add(heading);
		heading.setFont(new Font("",Font.BOLD,40));
		start.addKeyListener(this);

       
       // if(position[1].isVisible()==false)
        //	System.out.println("sdsd");
		

		

		
	  
      
		f.setVisible(true);



	}
	
	public static void main(String[] args) {
		new MyFrame();
	}
    

	public static int randInt() {

    // NOTE: Usually this should be a field rather than a method
    // variable so that it is not re-seeded every call.
    Random rand = new Random();

    // nextInt is normally exclusive of the top value,
    // so add 1 to make it inclusive
     randomNum = rand.nextInt(600)+1 ;
    if(randomNum==0)
         	randomNum=5;

    return randomNum;

    }


    public  void actionPerformed(ActionEvent e)
    {

    	if(e.getSource()==start)
    	{
    		value=254;
    		position[value].setVisible(true);
    		//count=1;

    		front=value;
    		rare=value;

    		start.setVisible(true);

    		value=MyFrame.randInt();
    		position[value].setVisible(true);

    		count=1;

    	}
    	

    	if(e.getSource()==up)
    	{
              

    		if(randomNum==front-30)
    		{
    			front=front-30;

    			value= MyFrame.randInt();
    			position[value].setVisible(true);
    			count++;
    		}
    		else if(front-30<0)
    		{

    		}
    		else
    		{

    			front -=30;
    			position[rare].setVisible(false);

    		    if((rare-30>0)&&(rare-30!=randomNum)&&(position[rare-30].isVisible()==true))
    		    {
    		     	rare = rare-30;
 
    		    }
    		    else  if((rare-1!=randomNum)&&(position[rare-1].isVisible()==true))
    		    {
    		     	rare =rare - 1;
    		    } 
    		     else if((rare+1!=randomNum)&&(position[rare+1].isVisible()==true))
    		    {
    		     	rare =rare + 1;
    		    }

    			position[front].setVisible(true);

    		}




    	}
    	if(e.getSource()==down)
    	{
    		

    		if(randomNum==front+30)
    		{
    			front=front+30;

    			value= MyFrame.randInt();
    			position[value].setVisible(true);
    			count++;


    		}
    		else if(front+30>600)               			// add termination condition
    		{

    		}
    		else
    		{    
    			
    			 front = front+30;
    			 position[rare].setVisible(false);
    		     
                  if((rare+30<600)&&(rare+30!=randomNum)&&(position[rare+30].isVisible()==true))
                 {
                    rare = rare+30;
 
                 }
    		     
    		     else if((rare+1!=randomNum)&&(position[rare+1].isVisible()==true))
                 {
                    rare =rare + 1;
                 }
    		     else  if((rare-1!=randomNum)&&(position[rare-1].isVisible()==true))
    		     {
    		     	rare =rare - 1;
    		     }
    		     

    			 position[front].setVisible(true);

    			 



    		}

    	}	
    	if(e.getSource()==left)
    	{
    		if(randomNum==front-1)
    		{
    			front=front-1;
    			value= MyFrame.randInt();
    			position[value].setVisible(true);
    			count++;

    		}
    		else if((front-1)%30==0)
    		{

    		}
    		else
    		{
    			front -=1;
    			position[rare].setVisible(false);
    		    
 				 if((rare-1!=randomNum)&&(position[rare-1].isVisible()==true))
    		     {
    		     	rare =rare - 1;
    		     }
    		     
    		     else if((rare-30>0)&&(rare-30!=randomNum)&&(position[rare-30].isVisible()==true))
    		     {
    		     	rare = rare-30;
 
    		     }
    		     else if((rare+30<600)&&(rare+30!=randomNum)&&(position[rare+30].isVisible()==true))
    		     {
    		     	rare = rare+30;
 
    		     }


    			position[front].setVisible(true);


    		}

    		

    	}	
    	if(e.getSource()==right)
    	{
    		if(randomNum==front+1)
    		{
    			front +=1;
    			value= MyFrame.randInt();
    			position[value].setVisible(true);
    			count++;

    		}
    		else if((front%30)==0) {
    			
    		}
    		else
    		{
    			front +=1;
    			position[rare].setVisible(false);

    			if((rare+1!=randomNum)&&(position[rare+1].isVisible()==true))
    		     {
    		     	rare =rare + 1;
    		     }
    		     else if((rare+30<600)&&(rare+30!=randomNum)&&(position[rare+30].isVisible()==true))
    		     {
    		     	rare = rare+30;
 
    		     }
    		     else if((rare-30>0)&&(rare-30!=randomNum)&&(position[rare-30].isVisible()==true))
    		     {
    		     	rare = rare-30;
 
    		     }
    		    
    			position[front].setVisible(true);

    		}
    	}

    	scr.setText("score "+ (score*count) );	
        position[front].setBackground(Color.red);


    }


    public void keyTyped(KeyEvent e)
    {
        
    }

    
    public void keyPressed(KeyEvent e)
    {
        if(e.getKeyCode()==KeyEvent.VK_UP)
        {
        	down.stop();
            left.stop();
            right.stop();
        	up.start();
        }
        else if(e.getKeyCode()==KeyEvent.VK_DOWN)
        {
        	up.stop();
    	    left.stop();
    		right.stop();
            down.start(); 

        }
        else if(e.getKeyCode()==KeyEvent.VK_LEFT)
        {
               
               up.stop();
    		   down.stop();
    		   right.stop();
    		   left.start();
        }
        else if(e.getKeyCode()==KeyEvent.VK_RIGHT)
        {
               
               up.stop();
    		   down.stop();
    	       left.stop();
    	       right.start();

        }
    }
    public void keyReleased(KeyEvent e)
    {

    }
    
	
}

