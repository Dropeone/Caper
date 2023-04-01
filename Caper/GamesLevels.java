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


public class GamesLevels {
    public static void main(String[] args) {
        FrameLevels f = new FrameLevels();
        f.setVisible(true);
    }
}

class FrameLevels extends JFrame{
    JLabel lbl;
    boolean isVisible = true; // ��������� = ��.
    private Point mouseOffset; //������ �����.
    Color button = new Color(0, 0, 0); //���� ������ � ������.

    Color text = new Color(175, 224, 248, 255); //���� ������.

    static JButton education; //������ "��������".
    static JButton b; // ������ "�������".
    static JButton b2; //������ "��������".
    static JButton b3; //������ "������������".

    static JButton b4; // ������ "������".
    static JButton b5; // ������ "�����".
    static JButton b6; //������ "������".
    public FrameLevels(){

        setUndecorated(true); //������ ����� ������.

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

        setContentPane(new LevelPanel()); //��������� �� ������.
        Container cont = getContentPane(); //������ ���������.
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

        education = new JButton("��������."); //�������� ������.
        education.setLocation(180, 150); //������ ������������ ������.
        education.setSize(150, 50); //������ ������ ������(������-������).
        education.setForeground(button);  //���� ������ � ������.
        education.setBackground(text); //���� ������.

        b = new JButton("�������."); //�������� ������.
        b.setLocation(180, 250); //������ ������������ ������.
        b.setSize(150, 50); //������ ������ ������(������-������).
        b.setForeground(button); //���� ������ � ������.
        b.setBackground(text); //���� ������.

        b2 = new JButton("��������."); //�������� ������.
        b2.setLocation(180, 350); //������ ������������ ������.
        b2.setSize(150, 50); //������ ������ ������(������-������).
        b2.setForeground(button); //���� ������ � ������.
        b2.setBackground(text); //���� ������.

        b3 = new JButton("������������."); //�������� ������.
        b3.setLocation(180, 450); //������ ������������ ������.
        b3.setSize(150, 50); //������ ������ ������(������-������).
        b3.setForeground(button); //���� ������ � ������.
        b3.setBackground(text); //���� ������.

        b4 = new JButton("�����."); //�������� ������.
        b4.setLocation(180, 550); //������ ������������ ������.
        b4.setSize(150, 50); //������ ������ ������(������-������).
        b4.setForeground(button); //���� ������ � ������.
        b4.setBackground(text); //���� ������.

        b5 = new JButton("<--"); //�������� ������.
        b5.setLocation(0, 0); //������ ������������ ������.
        b5.setSize(50, 50); //������ ������ ������(������-������).
        b5.setForeground(button); //���� ������ � ������.
        b5.setBackground(text); //���� ������.

        b6 = new JButton("������."); //�������� ������.
        b6.setLocation(0, 675); //������ ������������ ������.
        b6.setSize(100, 25); //������ ������ ������(������-������).
        b6.setForeground(button); //���� ������ � ������.
        b6.setBackground(text); //���� ������.

        cont.add(education); //������������ ������ ������ � ����������.
        cont.add(b); //������������ ������ ������ � ����������.
        cont.add(b2); //������������ ������ ������ � ����������.
        cont.add(b3); //������������ ������ ������ � ����������.
        cont.add(b4); //������������ ������ ������ � ����������.
        cont.add(b5); //������������ ������ ������ � ����������.
        cont.add(b6); //������������ ������ ������ � ����������.
        lbl.setLayout(new FlowLayout()); //������� ������ ��������� �� ������������ ������.
        cont.add(lbl); //������������ ����� � ����������.

        education.addActionListener(new ActionListener() { //��������� �� ������ + ������ �� �����.
            @Override
            public void actionPerformed(ActionEvent e) {
                //�������� ��� ����. ���� ���� �������� ��� ����, � �������� �����.
                EducationJava edu = new EducationJava(); // �������� ���������� ���� �����.
                EducationText edutext = new EducationText(); //�������� ������ ���� � ������� ��� ��������.
                setVisible(false); //��������� (���), ��� ���� � ������� �������.
            }
        });

        b.addActionListener(new ActionListener() { //��������� �� ������ + ������ �� �����.
            @Override
            public void actionPerformed(ActionEvent e) {
                //�������� ����.
                StudentMinesweeper frame = new StudentMinesweeper(); // �������� ���������� ���� �����.
            }
        });

        b2.addActionListener(new ActionListener() { //��������� �� ������ + ������ �� �����.
            @Override
            public void actionPerformed(ActionEvent e) {
                //�������� ����.
                StudentMinesweeper2 frame2 = new StudentMinesweeper2(); //�������� �������� ���� �����.
            }
        });

        b3.addActionListener(new ActionListener() { //��������� �� ������ + ������ �� �����.
            @Override
            public void actionPerformed(ActionEvent e) {
                //�������� ����.
                StudentMinesweeper3 frame3 = new StudentMinesweeper3(); // �������� �������� ���� �����.
            }
        });

        b4.addActionListener(new ActionListener() { //��������� �� ������ + ������ �� �����.
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == b4) System.exit(0); // ������ ������.
            }
        });

        b5.addActionListener(new ActionListener() { //��������� �� ������ + ������ �� �����.
            @Override
            public void actionPerformed(ActionEvent e) {
                //�������� ����.
                Framemenu frame = new Framemenu(); //������������ � ���� "����"
                frame.setVisible(true); // ������ ��� �������.
                setVisible(false); // ������ ���� � ��������... ��������� (���).
            }
        });

        b6.addActionListener(new ActionListener() { //��������� �� ������ + ������ �� �����.
            @Override
            public void actionPerformed(ActionEvent e) {
                if (isVisible) { // ��� ������� �� ������ 5, ������ ��� ��������� ������ �� ������������.
                    education.setVisible(false);
                    b.setVisible(false);
                    b2.setVisible(false);
                    b3.setVisible(false);
                    b4.setVisible(false);
                    b5.setVisible(false);
                    isVisible = false;
                }
                else { // ��� ������� �� ������ 5, �������� ��� ������ �� ������������.
                    education.setVisible(true);
                    b.setVisible(true);
                    b2.setVisible(true);
                    b3.setVisible(true);
                    b4.setVisible(true);
                    b5.setVisible(true);
                    isVisible = true;
                }
            }
        });
    }
    class LevelPanel extends JPanel{ // ������ �����.
        public void paintComponent(Graphics g){
            Image im = null;
            try {
                im = ImageIO.read(new File("C:\\Foto.jpg")); // ���� �������� �� ����...
            } catch (IOException e) {}
            g.drawImage(im, 0, 0, null);

        }
    }
}


