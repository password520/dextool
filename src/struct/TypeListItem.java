package struct;

import java.util.ArrayList;
import java.util.List;

public class TypeListItem {
	
//	struct DexTypeList {
//	    u4 size;             /* DexTypeItem�ĸ��������������� */
//	    DexTypeItem list[size]; /* size��TypeList�ṹ�� */
//	};
	
	public int typeItemCount;
	
	public List<TypeItem> typeitemList = new ArrayList<TypeItem>();

}
