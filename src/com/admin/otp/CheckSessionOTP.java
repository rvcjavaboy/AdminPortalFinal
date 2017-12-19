package com.admin.otp;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;

import com.admin.bean.AdminOTP;
import com.dev.mgm.db.MySessionFactory;

/*
 * Sets the session with the for the OTP pages
 */
public class CheckSessionOTP {
	private static Logger log=Logger.getLogger(CheckSessionOTP.class);
	// checks Whether the session is assigns kor not
	public static  boolean checkSession(String key) {
		Session session = null;
		if(key==null) 
			return false;
		
		try {
			log.info("Chanage password session checking");
			SessionFactory sf=MySessionFactory.getSessionFactory();
			session =sf.openSession();
			Criteria cr=session.createCriteria(AdminOTP.class);
		
			cr.add(Restrictions.eqOrIsNull("uuid", key));
			
			AdminOTP admin=(AdminOTP) cr.uniqueResult();// checks admin to return unique result having same OTP
			if(admin!=null) {
				return true;
			}
			
		}//prints the exception if any arrives at the time of OTP
		catch(HibernateException e) {
			session.close();
			
			log.info("CheckSessionOTP exception",e);
		}
		
		
		
		return false;
	}
}
