package struct;

import java.util.ArrayList;
import java.util.List;

public class ClassCodeItem {
	
//	struct DexCode {
//	    u2 registersSize;   /* ʹ�õļĴ������� */
//	    u2 insSize;         /* �������� */
//	    u2 outsSize;        /* ������������ʱ��������ʹ�õļĴ��������������Լ��ĵ���ջ���룬��ѹջ���²⣩ */
//	    u2 triesSize;       /* Try/Catch���� */
//	    u4 debugInfoOff;    /* ָ�������Ϣ��ƫ�� */
//	    u4 insnsSize;       /* ָ���������2�ֽ�Ϊ��λ */
//	    u2 insns[1];        /* ָ� */
//	};
	public short registersSize;
	public short insSize;
	public short outsSize;
	public short triesSize;
	public int debugInfoOff;
	public int insnsSize;
	public List<Short> insns = new ArrayList<Short>();
	
}
