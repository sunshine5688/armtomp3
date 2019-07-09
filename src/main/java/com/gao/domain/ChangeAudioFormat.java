package com.gao.domain;
 
import ws.schild.jave.*;
import ws.schild.jave.EncoderException;
import ws.schild.jave.EncodingAttributes;

import java.io.File;
 
public class ChangeAudioFormat {
	public static void main(String[] args) throws Exception {
		changeToMp3("C:\\Users\\gaolinfang\\Desktop\\voicemsg.wav",
				"C:\\Users\\gaolinfang\\Desktop\\123.mp3");
	}

	private static void viderEncode(String sourcePath, String targetPath){
		try {
			File source = new File(sourcePath);  //源avi格式视频
			File target = new File(targetPath);//转换后的mp4格式视频
			AudioAttributes audio = new AudioAttributes();
			audio.setCodec("libmp3lame"); //音频编码格式
			audio.setBitRate(new Integer(64000));
			audio.setChannels(new Integer(1));
			audio.setSamplingRate(new Integer(22050));
			VideoAttributes video = new VideoAttributes();
			video.setCodec("libx264");//视频编码格式
			video.setBitRate(new Integer(180000));
			video.setFrameRate(new Integer(1));
			EncodingAttributes attrs = new EncodingAttributes();
			attrs.setFormat("mp4");
			attrs.setAudioAttributes(audio);
			attrs.setVideoAttributes(video);
			Encoder encoder = new Encoder();
			MultimediaObject multimediaObject = new MultimediaObject(source);
			encoder.encode(multimediaObject, target, attrs);//转换开始。。。
		} catch (EncoderException e) {
			e.printStackTrace();
		}
	}

	public static void changeToMp3(String sourcePath, String targetPath) {
		File source = new File(sourcePath);
		File target = new File(targetPath);
		AudioAttributes audio = new AudioAttributes();
		Encoder encoder = new Encoder();

		audio.setCodec("libmp3lame");
		EncodingAttributes attrs = new EncodingAttributes();
		attrs.setFormat("mp3");
		attrs.setAudioAttributes(audio);
		MultimediaObject multimediaObject = new MultimediaObject(source);

		try {
			encoder.encode(multimediaObject, target, attrs);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
