package com.yys.auto.view;

import com.yys.auto.core.ScriptRunner;
import com.yys.auto.utils.PathUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

/**
 * describe:
 *
 * @author lianying
 * @date 2019/01/15
 */
public class MainView implements ActionListener{
    JFrame frame = new JFrame("java自动化");
    JTabbedPane tabPane = new JTabbedPane();
    Container con = new Container();
    JLabel label1 = new JLabel("选择素材目录");
    JLabel label2 = new JLabel("选择脚本");
    JTextField text1 = new JTextField();
    JTextField text2 = new JTextField();
    JButton button1 = new JButton("...");
    JButton button2 = new JButton("...");
    JFileChooser jfc = new JFileChooser();
    JButton button3 = new JButton("运行");
    private File scriptFile;
    private String scriptString;

    public MainView() {

        // 文件选择器的初始目录定为d盘
        jfc.setCurrentDirectory(new File("d://"));

        double lx = Toolkit.getDefaultToolkit().getScreenSize().getWidth();

        double ly = Toolkit.getDefaultToolkit().getScreenSize().getHeight();
        // 设定窗口出现位置
        frame.setLocation(new Point((int) (lx / 2) - 150, (int) (ly / 2) - 150));
        // 设定窗口大小
        frame.setSize(380, 200);
        // 设置布局
        frame.setContentPane(tabPane);
        label1.setBounds(10, 10, 120, 20);
        text1.setBounds(130, 10, 120, 20);
        button1.setBounds(260, 10, 50, 20);
        label2.setBounds(10, 35, 120, 20);
        text2.setBounds(130, 35, 120, 20);
        button2.setBounds(260, 35, 50, 20);
        button3.setBounds(30, 60, 60, 20);
        // 添加事件处理
        button1.addActionListener(this);
        button2.addActionListener(this);
        button3.addActionListener(this);
        con.add(label1);
        con.add(text1);
        con.add(button1);
        con.add(label2);
        con.add(text2);
        con.add(button2);
        con.add(button3);
        // 窗口可见
        frame.setVisible(true);
        // 使能关闭窗口，结束程序
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // 添加布局1
        tabPane.add("设置", con);
    }
    /**
     * 时间监听的方法
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        // 判断触发方法的按钮是哪个
        if (e.getSource().equals(button1)) {
            // 设定只能选择到文件夹
            jfc.setFileSelectionMode(1);
            // 此句是打开文件选择器界面的触发语句
            int state = jfc.showOpenDialog(null);
            if (state == 1) {
                return;
            } else {
                // f为选择到的目录
                File f = jfc.getSelectedFile();
                text1.setText(f.getAbsolutePath());
                PathUtils.setPath(f.getAbsolutePath());
            }
        }
        // 绑定到选择文件，先择文件事件
        if (e.getSource().equals(button2)) {
            // 设定只能选择到文件
            jfc.setFileSelectionMode(0);
            // 此句是打开文件选择器界面的触发语句
            int state = jfc.showOpenDialog(null);
            if (state == 1) {
                // 撤销则返回
                return;
            } else {
                // scriptFile为选择到的脚本文件
                scriptFile = jfc.getSelectedFile();
                text2.setText(scriptFile.getAbsolutePath());
            }
        }
        if (e.getSource().equals(button3)) {
            //将脚本文件内的内容运行
            try {
                FileInputStream fileInputStream=new FileInputStream(scriptFile);
                byte [] bytes=new byte[(int) scriptFile.length()];
                fileInputStream.read(bytes);
                scriptString=new String(bytes);
            } catch (FileNotFoundException e1) {
                e1.printStackTrace();
                JOptionPane.showMessageDialog(null, "还未选择脚本", "提示", 2);
            } catch (IOException e1) {
                e1.printStackTrace();
                JOptionPane.showMessageDialog(null, "还未选择脚本", "提示", 2);
            }
            //运行脚本
            ScriptRunner.run(scriptString);
        }
    }

}
