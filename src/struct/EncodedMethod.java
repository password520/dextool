package struct;

public class EncodedMethod {

	/**
	 * struct encoded_method
		{
			uleb128 method_idx_diff;
			uleb128 access_flags;
			uleb128 code_off;
		}
	 */
	/** ע�⣺���һ�����а���ֱ�ӷ��������鷽������һ������ôÿ������������ֵmethod_idx_diff��ǰ�����з�������ֵ�ĺ�*/
	public byte[] method_idx_diff;
	public byte[] access_flags;
	public byte[] code_off;
	
}
