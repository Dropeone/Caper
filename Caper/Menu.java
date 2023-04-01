package Caper;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;


public class Menu {
    public static void main(String[] args) {
        Framemenu f = new Framemenu();
        f.setVisible(true);
    }
}

class Framemenu extends JFrame{
    boolean isVisible = true; //��������� = ��.
    JLabel lbl;
    private Point mouseOffset; // ������ ����.
    Color button = new Color(0, 0, 0); // ���� ������ � ������.

    Color text = new Color(175, 224, 248, 255); // ���� ������.
    static JButton b; //������ "�������".
    static JButton b2; //������ "��������".
    static JButton b3; //������ "������������".
    static JButton b4; // ������ "�����".
    public Framemenu(){
        setUndecorated(true);

        addMouseListener(new MouseAdapter() { //������ ���, ����� ����� ���� ������ ��� �������, ������ ����.
            @Override
            public void mousePressed(MouseEvent e) {
                mouseOffset = e.getPoint();
            }
        });
        addMouseMotionListener(new MouseAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                setLocation(e.getXOnScreen() - mouseOffset.x, e.getYOnScreen() - mouseOffset.y);
            }
        });

        setContentPane(new BPanel()); //��������� �� ������.
        Container cont = getContentPane(); //�������� ����������.
        cont.setLayout(new FlowLayout( FlowLayout.CENTER, 10, 100)); //���������� ����������.
        cont.setLayout(new LayoutManager() {
            @Override
            public void addLayoutComponent(String name, Component comp) {

            }

            @Override
            public void removeLayoutComponent(Component comp) {

            }

            @Override
            public Dimension preferredLayoutSize(Container parent) {
                return null;
            }

            @Override
            public Dimension minimumLayoutSize(Container parent) {
                return null;
            }

            @Override
            public void layoutContainer(Container parent) {

            }
        });

        setTitle("���� (����) � ����� ���������."); //�������� ����������.
        setBounds(500, 50, 500, 700); // ���������� ������ + ��� �������.
        setResizable(false); //����������� ��������������.


        lbl = new JLabel(); //����� �����.
        lbl.setFont(new Font("Arial", Font.BOLD, 24)); //����� + ������� ������.

        b = new JButton("������."); //�������� ������.
        b.setLocation(180, 200); //������ ������������ ������.
        b.setSize(150, 50); //������ ������ ������(������-������).
        b.setForeground(button); //���� ������ � ������.
        b.setBackground(text); //���� ������.


        b2 = new JButton("�� ����."); //�������� ������.
        b2.setLocation(180, 300); //������ ������������ ������.
        b2.setSize(150, 50); //������ ������ ������(������-������).
        b2.setForeground(button); //���� ������ � ������.
        b2.setBackground(text); //���� ������.

        b3 = new JButton("�����."); //�������� ������.
        b3.setLocation(180, 400); //������ ������������ ������.
        b3.setSize(150, 50); //������ ������ ������(������-������).
        b3.setForeground(button); //���� ������ � ������.
        b3.setBackground(text); //���� ������.

        b4 = new JButton("������."); //�������� ������.
        b4.setLocation(0, 675); //������ ������������ ������.
        b4.setSize(100, 25); //������ ������ ������(������-������).
        b4.setForeground(button); //���� ������ � ������.
        b4.setBackground(text); //���� ������.

        cont.add(b); //������������ ������ ������ � ����������.
        cont.add(b2); //������������ ������ ������ � ����������.
        cont.add(b3); //������������ ������ ������ � ����������.
        cont.add(b4); //������������ ������ ������ � ����������.
        lbl.setLayout(new FlowLayout()); //������� ������ ��������� �� ������������ ������.
        cont.add(lbl); //������������ ����� � ����������.

        b.addActionListener(new ActionListener() { //��������� �� ������ + ������ �� �����.
            @Override
            public void actionPerformed(ActionEvent e) {
                //�������� ����.
                FrameLevels levels = new FrameLevels(); // �������� ������ ������� ����.
                // ��������� = ��.
                levels.setVisible(true);
                // ��������� � ���� ���� = ���.
                setVisible(false);
            }
        });
        b2.addActionListener(new ActionListener() { //��������� �� ������ + ������ �� �����.
            @Override
            public void actionPerformed(ActionEvent e) {
                //�������� ����.
                AboutGame frame3 = new AboutGame(); //�������� �� ����.
            }
        });

        b3.addActionListener(new ActionListener() { //��������� �� ������ + ������ �� �����.
            @Override
            public void actionPerformed(ActionEvent e) {
                //�������� ����.
                if (e.getSource() == b3) System.exit(0);// �����.
            }
        });

        b4.addActionListener(new ActionListener() { //��������� �� ������ + ������ �� �����.
            @Override
            public void actionPerformed(ActionEvent e) {

                if (isVisible) { // ��� ������� �� ������ 5, ������ ��� ��������� ������ �� ������������.
                    b.setVisible(false);
                    b2.setVisible(false);
                    b3.setVisible(false);
                    isVisible = false;
                }
                else { // ��� ������� �� ������ 5, �������� ��� ������ �� ������������.
                    b.setVisible(true);
                    b2.setVisible(true);
                    b3.setVisible(true);
                    isVisible = true;
                }
            }
        });
    }
}

class BPanel extends JPanel { // ������ �����.
    public void paintComponent(Graphics g) {
        Image im = null;
        try {
            im = ImageIO.read(new File("C:\\Foto.jpg")); // ���� �������� �� ����...
        } catch (IOException e) {
        }
        g.drawImage(im, 0, 0, null);

    }
}



