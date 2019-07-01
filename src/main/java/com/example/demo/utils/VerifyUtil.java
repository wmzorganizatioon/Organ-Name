package com.example.demo.utils;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Random;

/**
 *@Author 86151
 *@date 2019/7/1 14:25
 *@description 随机数生成
 *return
 */
public class VerifyUtil {

    /**
     *验证码字符串
     */
    private static final char[] chars = {
            '0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
            'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n',
            'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z',
            'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N',
            'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'
    };

    /**
     *字符数量
     */
    private static final int SIZE = 4;

    /**
     *干扰线数量
     */
    private static final int LINES = 5;

    /**
     *图形宽度
     */
    private static final int WIDTH = 80;

    /**
     *图形高度
     */
    private static final int HEIGHT = 40;

    /**
     *字体大小
     */
    private static final int FONT_SIZE = 30;

    /**
     *@Author 86151
     *@Date 2019/7/1 14:34
     *Description 创建图层、生成数字
     @Param 
     *return
     */
    public static Object[] createImage(){
        StringBuffer sb = new StringBuffer();

        //1.创建图层
        BufferedImage image = new BufferedImage(WIDTH,HEIGHT,BufferedImage.TYPE_INT_RGB);

        //2.获取图片画笔
        Graphics graphics = image.getGraphics();

        //3.设置图层颜色
        graphics.setColor(Color.LIGHT_GRAY);

        //4.绘制矩形背景
        graphics.fillRect(0,0,WIDTH,HEIGHT);

        //5.开始绘制随机字符
        Random random = new Random();
        for (int i = 0; i<SIZE; i++){
            //取随机字符的索引
            int n = random.nextInt(chars.length);

            //随机取色
            graphics.setColor(getRandomColor());

            //设置字体颜色
            graphics.setFont(new Font(null,Font.ITALIC,FONT_SIZE));

            //画字符
            graphics.drawString(chars[n] + "",i * WIDTH / SIZE,HEIGHT * 2 / 3);

            //记录字符
            sb.append(chars[n]);

        }

        //6画干扰线
        for (int i = 0; i<LINES;i++){
            //设置随机颜色
            graphics.setColor(getRandomColor());

            //随机画线
            graphics.drawLine(random.nextInt(WIDTH), random.nextInt(HEIGHT),
                    random.nextInt(WIDTH), random.nextInt(HEIGHT));
        }
        return new Object[]{sb.toString(),image};
    }

    /**
     *@Author 86151
     *@Date 2019/7/1 14:47
     *Description 随机取色，来满足颜色的查看
     @Param
     *return
     */
    public static Color getRandomColor(){
        Random random = new Random();
        Color color = new Color(random.nextInt(256),random.nextInt(256),random.nextInt(256));
        return color;
    }
}
