package com.yys.auto.utils;

import com.yys.auto.entity.Coordinate;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;

/**
 * describe:
 *
 * @author lianying
 * @date 2019/1/5
 */
public class ImageUtils {
    /**
     * 获取屏幕截图
     *
     * @return
     */
    public static BufferedImage getScreen() {
        try {
            Robot rb = null;
            // java.awt.image包中的类，可以用来抓取屏幕，即截屏。
            rb = new Robot();
            Toolkit tk = Toolkit.getDefaultToolkit();
            // 获取缺省工具包
            Dimension di = tk.getScreenSize();
            // 屏幕尺寸规格
            Rectangle rec = new Rectangle(0, 0, di.width, di.height);
            BufferedImage bi = rb.createScreenCapture(rec);
            return bi;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 获取图片的int数组
     *
     * @param image
     * @return
     */
    public static int[] getIntArray(BufferedImage image) {

        int[] a = new int[image.getWidth() * image.getHeight()];
        image.getRGB(0, 0, image.getWidth(), image.getHeight(), a, 0, image.getWidth());

        return a;
    }

    /**
     * 查找单行src是否包含tag
     *
     * @param src
     * @param tag
     * @return
     */
    public static int find(int[] src, int[] tag) {
        //相同的int下标起始位
        int index = -1;
        for (int i = 0; i < src.length - tag.length; i++) {
            //如果两个相同，需要登记他的起始下标，相同个数加1
            for (int j = 0; j < tag.length; j++) {
                if (src[i + j] != tag[j]) {
                    break;
                }
                //j=0时记录下下标
                if (j == 0) {
                    index = i;
                }
                if (j == (tag.length - 1)) {
                    return index;
                }
            }
        }
        //如果循环到这里还没return index说明没有相似度大于0.9的数组了。也就是没有包含该数组
        return -1;
    }

    /**
     * 从文件获取BufferedImage
     *
     * @param file
     * @return
     */
    public static BufferedImage getBufferedImage(File file) {
        InputStream in = null;
        try {
            in = new FileInputStream(file);
            BufferedImage bi = ImageIO.read(in);
            in.close();
            return bi;
        } catch (FileNotFoundException e) {
        } catch (IOException e) {
        }
        return null;
    }

    /**
     * 从资源目录获取BufferedImage
     *
     * @param name 文件名
     * @return
     */
    public static BufferedImage getBufferedImage(String name) {
        InputStream in = null;
        try {
            in = new FileInputStream(new File(PathUtils.getClassPath() + name));
            BufferedImage bi = ImageIO.read(in);
            in.close();
            return bi;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 查找src是否包含tag如果包含就返回一个Coordinate对象，它包含了x和y
     *
     * @param src
     * @param tag
     * @return
     */
    public static Coordinate find(BufferedImage src, BufferedImage tag) {
        int[] srcArray = getIntArray(src);
        int[] tagArray = getIntArray(tag);
        int x = -1;
        int someLen = 0;

        for (int i = 0; i < src.getHeight(); i++) {
            //这个是大图的第i行数组
            int[] arg1 = new int[src.getWidth()];
            System.arraycopy(srcArray, i * src.getWidth(), arg1, 0, src.getWidth());
            //这个是小图的第someLen行数组
            int[] arg2 = new int[tag.getWidth()];
            System.arraycopy(tagArray, someLen*tag.getWidth(), arg2, 0, tag.getWidth());
            //对比完大于-1说明，这行包含了小图的第一行。
            int pos = find(arg1, arg2);
            if (pos > -1) {
                //相似行数+1
                someLen++;
                x = pos;
                //如果相似度大于0.9
                if (someLen==(tag.getHeight()-1)) {
                    Coordinate coordinate = new Coordinate(x, i - tag.getHeight());
                    return coordinate;
                }
                //相同所以要返回，继续判断下一行
                continue;
            }
            //运行到这里说明，不相同。则要初始化一些记录数据
            someLen = 0;
            x = -1;
        }
        //遍历完了还没返回就返回null
        return null;
    }
}

