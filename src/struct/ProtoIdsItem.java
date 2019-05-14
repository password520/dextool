package struct;

import java.util.ArrayList;
import java.util.List;

public class ProtoIdsItem {

	/**
	 * struct proto_id_item
		{
		uint shorty_idx;
		uint return_type_idx;
		uint parameters_off;
		}
	 */
	
	public int shorty_idx;
	public int return_type_idx;
	public int parameters_off;
	
	public static int getSize(){
		return 4 + 4 + 4;
	}
	
	//���в�����Ϣ�Ľṹ��������������DexTypeItem�ṹ��
	//DexTypeItem�ṹ��ֻ��һ�����ԣ���СΪ2�ֽڵ�Type_ids���ε�����������ָ����ַ������ǲ��������ͣ����parameters_off�����ƫ��Ϊ0����û�иýṹ��
	public List<String> parametersList = new ArrayList<String>();
	public int parameterCount;
	
	
}
