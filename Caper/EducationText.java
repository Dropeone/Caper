package Caper;

import javax.swing.*;
import java.awt.*;

public class EducationText {
    private Point mouseOffset;
    Color mainColor = new Color(1, 1, 43, 255); //���� ����.
    Color colortext = new Color(62, 230, 244); //���� ������.
    public EducationText() {
        JFrame frame = new JFrame("��������."); //�������� ����.
        frame.setResizable(false); //����������� ��������������.
        JTextArea textArea = new JTextArea("����� ������� ���� ��������� ��������, ��� �������� ��� ���, � ������ � ������ ������ �� �������� � ������.\n" + //��� �����.
                "�� ����� ������� ������� ��������� ��� ����� ���������� �������� �������� �� ��������, ��� �������� ����� -" + //��� �����.
                "\n������� ����� ���������� ����, ���� �� �� ������� ��� ���������. " + //��� �����.
                "\n����� �� ���������� �������� ������� � ���, ������� ��� ����������� ������ � ������� ���������. ��������, ����" + //��� �����.
                "\n �� ������ ��� ������� �������� � �� ����� �� ��� ����� �������, ������, ��� ��� ������� � ������ ���������" + //��� �����.
                "\n �������� ����." ); //��� �����.

        int begn = 1; //������.
        int end = 1; //������.

        textArea.replaceRange(null, begn, end);
        textArea.setForeground(colortext); // ���� ������.
        textArea.setBackground(mainColor); //���� ����.

        frame.add(textArea); //���������� ������ �� �����.
        frame.setBounds(850, 300, 665, 150); //���������� ������ + ��� �������.
        frame.setLayout(new GridLayout(1, 1));
        // frame.setBackground(Color.cyan);
        frame.setVisible(true); //��������� ����.
    }
    public static void main(String args[]) {
        new EducationText();
    }
}
