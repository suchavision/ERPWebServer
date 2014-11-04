package com.xinyuan.dao.impl;

import java.sql.Connection;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import com.Global.HibernateAbstractDAO;
import com.xinyuan.dao.PurchaseOrderDao;
import com.xinyuan.model.Purchase.PurchaseOrder;

public class PurchaseOrderDaoImpl extends HibernateAbstractDAO  implements PurchaseOrderDao {

	@Override
	public List getfinanceiptorder(PurchaseOrder pull) {
		Connection connection=null;
		Session session=null;
		String hql="from PurchaseOder where (OrderNO="+pull.getOrderNO()+" and bookPurhaseNO="+pull.getBookPurhaseNO()+" and bookDate="+pull.getBookDate()+" and vendorNumber="+pull.getVendorNumber()+" oand contact="+pull.getContact()+" and phoneNO="+pull.getPhoneNO()+" and payCondition="+pull.getPayCondition()+" and payMode="+pull.getPayMode()+" and freight="+pull.getFreight()+" and deliveryDate="+pull.getDeliveryDate()+" and deliveryPlace="+pull.getDeliveryPlace()+")";
		Query query=this.createQuery(hql);
		return query.list();
	}
	

}
