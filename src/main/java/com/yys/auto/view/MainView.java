package com.yys.auto.view;

import com.yys.auto.core.ScriptExecutor;
import com.yys.auto.utils.PathUtils;
import org.apache.log4j.Logger;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

/**
 * describe:主视图
 *
 * @author lianying
 * @date 2019/01/15
 */
public class MainView implements ActionListener{
    /**
     * log4j
     */
    private final Logger logger= Logger.getLogger(MainView.class);
    JFrame frame = new JFrame("java自动化");
    JTabbedPane tabPane = new JTabbedPane();
    Container con = new Container();
    JLabel selectDicLabel = new JLabel("选择素材目录");
    JLabel selectScriptLabel = new JLabel("选择脚本");
    JTextField dicInput = new JTextField();
    JTextField scriptInput = new JTextField();
    JButton selectDicBt = new JButton("...");
    JButton selectScriptBt = new JButton("...");
    JFileChooser jfc = new JFileChooser();
    JButton button3 = new JButton("运行");
    private File scriptFile;
    private String scriptString;

    public MainView() {

        // 文件选择器的初始目录定为桌面
        jfc.setCurrentDirectory(new File("C:\\Users\\Administrator\\Desktop"));
        double lx = Toolkit.getDefaultToolkit().getScreenSize().getWidth();
        double ly = Toolkit.getDefaultToolkit().getScreenSize().getHeight();
        // 设定窗口出现位置
        frame.setLocation(new Point((int) (lx / 2) - 150, (int) (ly / 2) - 150));
        // 设定窗口大小
        frame.setSize(380, 200);
        // 设置布局
        frame.setContentPane(tabPane);
        selectDicLabel.setBounds(10, 10, 120, 20);
        dicInput.setBounds(130, 10, 120, 20);
        selectDicBt.setBounds(260, 10, 50, 20);
        selectScriptLabel.setBounds(10, 35, 120, 20);
        scriptInput.setBounds(130, 35, 120, 20);
        selectScriptBt.setBounds(260, 35, 50, 20);
        button3.setBounds(30, 60, 60, 20);
        // 添加事件处理
        selectDicBt.addActionListener(this);
        selectScriptBt.addActionListener(this);
        button3.addActionListener(this);
        con.add(selectDicLabel);
        con.add(dicInput);
        con.add(selectDicBt);
        con.add(selectScriptLabel);
        con.add(scriptInput);
        con.add(selectScriptBt);
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
        if (e.getSource().equals(selectDicBt)) {
            // 设定只能选择到文件夹
            jfc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
            // 此句是打开文件选择器界面的触发语句
            int state = jfc.showOpenDialog(null);
            if (state == 1) {
                return;
            } else {
                // f为选择到的目录
                File f = jfc.getSelectedFile();
                dicInput.setText(f.getAbsolutePath());
                logger.info("设置素材文件夹:"+f.getAbsolutePath());
                PathUtils.setPath(f.getAbsolutePath());
            }
        }
        // 绑定到选择文件，先择文件事件
        if (e.getSource().equals(selectScriptBt)) {
            // 设定只能选择到文件
            jfc.setFileSelectionMode(JFileChooser.FILES_ONLY);
            // 此句是打开文件选择器界面的触发语句
            int state = jfc.showOpenDialog(null);
            if (state == 1) {
                // 撤销则返回
                return;
            } else {
                // scriptFile为选择到的脚本文件
                scriptFile = jfc.getSelectedFile();
                logger.info("选择了脚本文件:"+scriptFile.getAbsolutePath());
                scriptInput.setText(scriptFile.getAbsolutePath());
            }
        }
        if (e.getSource().equals(button3)) {
            //将脚本文件内的内容读取并运行
            logger.info("开始运行脚本！");
            FileInputStream fileInputStream = null;
            try {
                fileInputStream=new FileInputStream(scriptFile);
                byte [] bytes=new byte[(int) scriptFile.length()];
                fileInputStream.read(bytes);
                scriptString=new String(bytes);
                logger.info("读取到了脚本内容："+scriptString);
            } catch (FileNotFoundException e1) {
                logger.info("文件不存在",e1);
                JOptionPane.showMessageDialog(null, "文件不存在", "提示", 2);
            } catch (IOException e1) {
                logger.info("IO错误",e1);
                JOptionPane.showMessageDialog(null, "IO错误", "提示", 2);
            }finally {
                //不过如何这里都要执行关闭
                try {
                    if(fileInputStream!=null)
                    {
                        fileInputStream.close();
                    }
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
            //运行脚本
            ScriptExecutor.run(scriptString);
        }
    }

}
