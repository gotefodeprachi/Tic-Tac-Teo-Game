import javax.swing.*;
import java.awt.event.*;
import java.awt.Font;
import java.awt.*;
public class tic_tac_toe implements ActionListener{
JFrame jf ;
JButton b[];
int count=0;
String txt;
Color c1,c2;
boolean win;

public tic_tac_toe()
{
jf=new JFrame("WELCOME TO TIC TAC TOE GAME!");
b= new JButton[9];
//Color clr=Color.BLACK;
for(int i=0;i<9;i++)
{
    b[i]=new JButton();
    jf.add(b[i]);
    b[i].setBorder(BorderFactory.createLineBorder(Color.black));
    b[i].addActionListener(this);
    
}
jf.setSize(1000, 1000);;
jf.setLocationRelativeTo( null);
jf.setResizable(false);
jf.setLayout(new GridLayout(3,3,10,10));
jf.setVisible(true);
}
    public static void main(String[] args) {
            new tic_tac_toe();
    }
public void actionPerformed(ActionEvent e) {
    count+=1;
    Font f = new Font("Courier",Font.PLAIN,100);
    if(count%2==0)
    {
        txt="X";
        c1= Color.red;
        c2=Color.PINK;
    }
    if(count%2==1)
    {
        txt="O";
        c1= Color.BLUE;
        c2=Color.WHITE;
    }
    for(int i=0;i<9;i++){
        if(e.getSource()==b[i])
        {
            b[i].setText(txt);
            b[i].setBackground(c1);
            b[i].setForeground(c2);
            b[i].setEnabled(false);
            b[i].setFont(f);
        }
    }
    winpossibilities();
}
    void winpossibilities()
    {

        if((b[0].getText()==b[1].getText()) && b[0].getText()==b[2].getText()&&b[0].getText()!="")
        {
            win=true;
        }
        else if((b[3].getText()==b[4].getText()) && b[3].getText()==b[5].getText()&&b[3].getText()!="")
        {
            win = true;
        }
        else if((b[6].getText()==b[7].getText()) && b[6].getText()==b[8].getText()&&b[6].getText()!="")
        {
            win=true;
        }
        else if((b[0].getText()==b[3].getText()) && b[0].getText()==b[6].getText()&&b[0].getText()!="")
        {
            win=true;
        }
        else if((b[1].getText()==b[4].getText()) && b[1].getText()==b[7].getText()&&b[1].getText()!="")
        {
            win=true;
        }
        else if((b[2].getText()==b[5].getText()) && b[2].getText()==b[8].getText()&&b[2].getText()!="")
        {
            win=true;
        }
        else if((b[0].getText()==b[4].getText()) && b[0].getText()==b[8].getText()&&b[0].getText()!="")
        {
            win=true;
        }
        else if((b[2].getText()==b[4].getText()) && b[2].getText()==b[6].getText()&&b[2].getText()!="")
        {
            win=true;
        }
        else
        {
            win=false;
        }
        whowins();
    }

void whowins()
{
    if(win==true)
    {
        JOptionPane.showMessageDialog(jf,(txt+" Wins"),"Congratulation!",JOptionPane.INFORMATION_MESSAGE);
        restartgame();
    }
    else if(win==false && count==9)
    {
        JOptionPane.showConfirmDialog(jf,("Draw"), "Try Again",JOptionPane.INFORMATION_MESSAGE);
        restartgame();
    }
}
void restartgame()
{
    int i = JOptionPane.showConfirmDialog(jf,"Do u wnt to restart");
    if(i==0)
    {
        for(int j=0;i<9;j++)
        {
            count=0;
            txt="";
            win=false;
            b[j].setEnabled(true);
            b[j].setText("");
            b[j].setBackground(null);

        }
    }
    else{
        jf.setVisible(false);
    }
}
}

