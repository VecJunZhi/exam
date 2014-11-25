package cn.gov.scciq.basicSettings.item;

public interface IItemService {
	public String SaveItem (ItemBean bean) throws Exception;
	public String SaveItemSub (ItemBean bean) throws Exception;
	public String DelItem (ItemBean bean) throws Exception;
	public String GetItem (ItemBean bean) throws Exception;
	public String GetItemSub (ItemBean bean) throws Exception;
}
