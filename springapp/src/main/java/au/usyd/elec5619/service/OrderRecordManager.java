package au.usyd.elec5619.service;

import java.util.List;

import au.usyd.elec5619.domain.OrderRecord;

public interface OrderRecordManager {
	
	

    public void addOrderRecord(OrderRecord OrderRecord);

    public boolean deleteOrderRecord(long id);

    public List<OrderRecord> getShoppingRecords(int userId);

    public List<OrderRecord> getAllOrderRecords();

    //public boolean getUserProductRecord(int userId,int productId);
}
