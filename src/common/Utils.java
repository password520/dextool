package common;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import struct.HeaderType;

public class Utils {
	
	public static int FT_APK = 0;
	
	public static int FT_DEX = 1;

	
	/**
	 * ��ȡ�ļ�ͷmagic���ж��ļ�����
	 * 
	 * @param filePath ��Ҫ����ļ���·��
	 * @return	���ش���ͬ�ļ����͵�intֵ
	 */
	public static int getFileType(String filePath) {
		int ft;
		byte[] bt = new byte[4];
		String fMagic;
		try {
			FileInputStream fileInputStream = new FileInputStream(filePath);
			fileInputStream.read(bt, 0, 4);
			fMagic = new String(bt);
			if(fMagic.startsWith("PK"))
				return FT_APK;
			if(fMagic.startsWith("dex"))
				return FT_DEX;
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return FT_DEX;
	}
	
	/**
	 * ��src�ֽ������У���startΪ��ʼ�±꣬���Ƴ���Ϊlen���ֽڲ����䷵��
	 * 
	 * @param src	��Ҫ�����Ƶ��ֽ�����
	 * @param start	�����Ƶ���ʼλ��
	 * @param len	�����Ƶ��ֽڵĳ���
	 * @return	�����Ƶ��ֽ�����
	 */
	public static byte[] copyByte(byte[] src, int start, int len){
		if(src == null){
			return null;
		}
		if(start > src.length){
			return null;
		}
		if((start+len) > src.length){
			return null;
		}
		if(start<0){
			return null;
		}
		if(len<=0){
			return null;
		}
		byte[] resultByte = new byte[len];
		for(int i=0;i<len;i++){
			resultByte[i] = src[i+start];
		}
		return resultByte;
	}
	
	/**
	 * ���ֽ�����ת��16���Ƶ��ַ���
	 * 
	 * @param src	��Ҫת�����ֽ�����
	 * @return	���ص�ʮ�������ַ���
	 */
	public static String bytesToHexString(byte[] src){  
		StringBuilder stringBuilder = new StringBuilder("");  
		if (src == null || src.length <= 0) {  
			return null;  
		}  
		for (int i = 0; i < src.length; i++) {  
			//������0-255��Χ��
			int v = src[i] & 0xFF;
			String hv = Integer.toHexString(v);  
			if (hv.length() < 2) {  
				stringBuilder.append(0);  
			}  
			stringBuilder.append(hv+" "); 
		}  
		return stringBuilder.toString();  
	}  
	
	/**
	 * ��int������ת���ֽ����顣
	 * ����int�ͳ�������ֻȡ����λ(����������)��������Ҫ�õ�һ���ֽڶ�����λ��������ڵ���8С��16������
	 * ����������ж��ٸ�������0����ȷ�����int�Ͳ����Ķ�����λ����Ȼ������40(32+8)����ȥ���λ����
	 * ��int�Ͳ����Ķ�����λ����8�������Ϳ��Ա�֤���int������0-8λ��������ʱ���ؼ���8�պ���8-16���䣬
	 * 
	 * @param integer	��Ҫת����int����
	 * @return	��Ҫ���ص��ֽ�����
	 */
	public static byte[] int2Byte(final int integer) {
		//���������ռ�ü����ֽ�
		int byteNum = (40 -Integer.numberOfLeadingZeros (integer < 0 ? ~integer : integer))/ 8;
		byte[] byteArray = new byte[4];
		for (int n = 0; n < byteNum; n++)
			byteArray[3 - n] = (byte) (integer>>> (n * 8));
		return (byteArray);
	}
	
	
	
}
