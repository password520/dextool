package main;

import javax.swing.text.View;

import parseFormat.*;

public class DexMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/**
		 * ��Ҫɾ������ʱ����
		 */
		String fp = "E:\\eclipseProjects\\parse_androiddex-master\\dex\\classes.dex";
		
		/**
		 * ��ӡdex�ļ����нṹ����Ϣ
		 */
		
		int ftype;
		ftype = Utils.getFileType(fp);
		switch (ftype) {
		//file type��APK
		case 0:
			
			break;
		//file type��dex
		case 1:
			paseFormatView mView =new paseFormatView();
			mView.showAllStruct(fp);
			break;
		default:
			
			break;
		}
		
		
				
		
	}

}
