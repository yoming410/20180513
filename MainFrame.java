import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.Random;

public class MainFrame extends JFrame {
    private JButton jbutge = new JButton("Generate");
    private JButton jbutexit = new JButton("Exit");
    private JLabel jlb [] = new JLabel[6];
    private Random rand = new Random();
    private Container cp;
    private JPanel jpnn = new JPanel(new GridLayout(1,6,3,3));
    private JPanel jpnc = new JPanel(new GridLayout(1,2,3,3));
    public MainFrame (){
        init();
    }
    private void init(){
        setBounds(200,200,420,108);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        cp = this.getContentPane();
        jpnc.add(jbutge);
        jpnc.add(jbutexit);
        cp.add(jpnn,BorderLayout.NORTH);
        cp.add(jpnc,BorderLayout.SOUTH);

        for (int i =0 ; i < 6 ;i++){
            jlb[i] = new JLabel(" ",JLabel.CENTER);
            jlb[i].setFont(new Font(null,Font.ITALIC,32));
            jlb[i].setForeground(Color.BLUE);
            jpnn.add(jlb[i]);
        }


        jbutge.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                int[] num=new int[6];
                int x=0,cnt=0,flag=0;

                while (cnt < 6){
                    x=rand.nextInt(49)+1;

                    for (int i=0; i<cnt; i++)
                        if (x==num[i]){
                            flag++;
                            break;
                        }

                    if (flag==0 ){
                        num[cnt]=x;
                        cnt++;
                    }
                    else
                        flag=0;
                }

                for (int i=0; i<6; i++) {
                    System.out.println(num[i]);
                    jlb[i].setText(Integer.toString(num[i]));
                    jpnn.add(jlb[i]);
                }
                System.out.println("************");
            }
        });

        jbutexit.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                System.exit(0);
            }
        });

    }
}
