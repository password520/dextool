package common;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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
	
	/**
	 * ��byte���������ת��int��
	 * 
	 * @param res	��Ҫ��ת�����ֽ�����
	 * @return	����ת����ɵ�int�͵�ֵ
	 */
	public static int byte2int(byte[] res) { 
		int targets = (res[0] & 0xff) | ((res[1] << 8) & 0xff00)
				| ((res[2] << 24) >>> 8) | (res[3] << 24); 
		return targets; 
	}
	
	/**
	 * ��byte���������ת��short��(����Ϊ2�ֽ�)
	 * 
	 * @param b
	 * @return
	 */
	public static short byte2Short(byte[] b) { 
        short s = 0; 
        short s0 = (short) (b[0] & 0xff);
        short s1 = (short) (b[1] & 0xff); 
        s1 <<= 8; 
        s = (short) (s0 | s1); 
        return s; 
    }
	
	/**
	 * ���ṩ��ʮ�������ַ��������ŷ�
	 * 
	 * @param hexstr	��Ҫ���ŷŵ�ʮ�������ַ���
	 * @return	����ŷź�ĵ�ʮ�������ַ���
	 */
	public static String reverseOrderHexStr(String hexstr) {
		String[] hexs = hexstr.split(" ");
		int len = hexs.length;
		String result = "";
		for(int i=hexs.length; i>0; i--) {
			int index = i - 1;
			result = result + hexs[index];
		}
		return result;
	}
	
	/**
	 * �����ṩ�Ĳ�������srcByte�ֽ����У���startOffƫ��λ�ÿ�ʼ��ȡ�ֽ�����ת���ַ�����������0x00
	 * 
	 * @param srcByte	��ȡֵ���ֽ���
	 * @param startOff	ȡֵ����ʼλ��
	 * @return	��ȡ���ֽ�����ת�����ַ������͵�ֵ
	 */
	public static String getString(byte[] srcByte, int startOff){
		byte size = srcByte[startOff];
		byte[] strByte = Utils.copyByte(srcByte, startOff+1, size);
		String result = "";
		try{
			result = new String(strByte, "UTF-8");
		}catch(Exception e){
		}
		return result;
	}
	
	/**
	 * ��ȡC�����е�uleb����,һֱ�����ֽڵ����λΪ1Ϊֹ������ȡ�������ֽڷ��أ�ͨ��decodeUleb128������������intֵ
	 * 
	 * Ŀ���ǽ��������ֵ�˷�����
	 * ���Ȳ��̶�����1~5���ֽ��и���
	 * @param srcByte	��Ҫ��ȡ���ֽ���
	 * @param offset	��ʼ��ȡ��ƫ��λ��
	 * @return	1~5���ֽ���ɵ��ֽ�����
	 */
	public static byte[] readUnsignedLeb128(byte[] srcByte, int offset){
		List<Byte> byteAryList = new ArrayList<Byte>();
		byte bytes = Utils.copyByte(srcByte, offset, 1)[0];
		byte highBit = (byte)(bytes & 0x80);
		byteAryList.add(bytes);
		offset ++;
		while(highBit != 0){
			bytes = Utils.copyByte(srcByte, offset, 1)[0];
			highBit = (byte)(bytes & 0x80);
			offset ++;
			byteAryList.add(bytes);
		}
		byte[] byteAry = new byte[byteAryList.size()];
		for(int j=0;j<byteAryList.size();j++){
			byteAry[j] = byteAryList.get(j);
		}
		return byteAry;
	}
	
	/**
	 * ����leb128����
	 * ÿ���ֽ�ȥ�����λ��Ȼ�����ƴ�ӣ����¹���һ��int������ֵ���ӵ�λ��ʼ
	 * @param byteAry
	 * @return
	 */
	public static int decodeUleb128(byte[] byteAry) {
	    int result = 0;
		
	    if(byteAry.length == 1){
	    	return byteAry[0];
	    }
	    if(byteAry.length == 2){
	        result = (byteAry[0] & 0x7f) | ((byteAry[1] & 0x7f) << 7);
	        return result;
	    }
	    if(byteAry.length == 3){
	        result = (byteAry[0] & 0x7f) | ((byteAry[1] & 0x7f) << 7) | ((byteAry[2] & 0x7f) << 14);
	        return result;
	    }
	    if(byteAry.length == 4){
	    	result = (byteAry[0] & 0x7f) | ((byteAry[1] & 0x7f) << 7) | ((byteAry[2] & 0x7f) << 14) | ((byteAry[3] & 0x7f) << 21);
	        return result;
	    }
        if(byteAry.length == 5){
        	result = (byteAry[0] & 0x7f) | ((byteAry[1] & 0x7f) << 7) | ((byteAry[2] & 0x7f) << 14) | ((byteAry[3] & 0x7f) << 21) | ((byteAry[4] & 0x7f) << 28);
            return result;
        }
        return result;
	}
}
