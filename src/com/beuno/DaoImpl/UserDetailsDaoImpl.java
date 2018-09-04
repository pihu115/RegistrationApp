package com.beuno.DaoImpl;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.SQLQuery;
import org.springframework.stereotype.Repository;

import com.beuno.Dao.AbstractDao;
import com.beuno.Dao.UserDetailsDao;
import com.beuno.model.UserDetails;

@Transactional
@Repository("userDetailsDao")
public class UserDetailsDaoImpl extends AbstractDao implements UserDetailsDao {

	@SuppressWarnings("unchecked")
	@Override
	public List<UserDetails> getAllUserData() {
		List<UserDetails> list = new ArrayList<UserDetails>();
		try {
			SQLQuery query = getSession().createSQLQuery("select ud.f_name, ud.m_name,ud.l_name,ud.country,"
					+ "ud.email_id,ud.gender,ud.area,ud.m_no,ud.password from user_details ud;");
			
			List<Object[]> objects = query.list();
			UserDetails u=null;
			for(Object[] obj : objects)
			{
				u=new UserDetails();
				if(null != obj[0])
					u.setfName(obj[0].toString());
				if(null != obj[1])
					u.setmName(obj[1].toString());
				if(null != obj[2])
					u.setlName(obj[2].toString());
				if(null != obj[3])
					u.setCountry(obj[3].toString());
				if(null != obj[4])
					u.setEmailId(obj[4].toString());
				if(null != obj[5])
					u.setGender(obj[5].toString());
				if(null != obj[6])
					u.setArea(obj[6].toString());
				if(null != obj[7])
					u.setmNo(obj[7].toString());
				if(null != obj[8])
					u.setPassword(obj[8].toString());
				list.add(u);
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

}
