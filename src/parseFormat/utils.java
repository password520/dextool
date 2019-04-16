package parseFormat;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

public class utils {
	
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
	
	public static void praseDexHeader(ArrayList<String> mArrayList){
		
	}
	
}
