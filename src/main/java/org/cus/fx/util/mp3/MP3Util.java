package org.cus.fx.util.mp3;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;


/**
 * @author ld
 * @name
 * @table
 * @remarks http://developer.baidu.com/vcast?zhidao
 * https://blog.csdn.net/al_assad/article/details/54664842
 */
public class MP3Util {

    public void mp3(String mp3Name) {
        String url = getClass().getResource(mp3Name).toString();
        Media media = new Media(url);
        MediaPlayer player = new MediaPlayer(media);
        player.setAutoPlay(true); //设置自动播放
        player.setCycleCount(1); //设置循环播放次数
    }
}
