package hibernateDemo.test;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

import hibernateDemo.bean.Account;
import hibernateDemo.bean.User;

public class HibernateDemo {
	private Configuration conf = new Configuration().configure("hibernate-cfg.xml");
	private SessionFactory sf = conf.buildSessionFactory();
	private Session session = sf.openSession();

	/**
	 * session添加
	 */
	@Test
	public void test() {
		Transaction tx = session.beginTransaction();
		User user = new User();
		
		Account acc = new Account();
		acc.setaMess("acc01");
		acc.setaName("acc01");
		acc.setaPass("acc");
		
		
		user.setuName("hello");
		user.setUpass("123");
		
		user.getAs().add(acc);
		acc.getUs().add(user);
		
		session.save(acc);
		tx.commit();
		System.out.println(user.getUid());
	}

	/**
	 * session查询
	 */
	@Test
	public void test01() {
		Transaction tx = session.beginTransaction();
		User user = session.get(User.class, 2);
		 Set<Account> as = user.getAs();
		 for (Account account : as) {
			
			 System.out.println(account);
		}
		tx.commit();
	}

	/**
	 * session修改
	 */
	@Test
	public void test02() {
		Transaction tx = session.beginTransaction();
		User user = session.get(User.class, 3);
		user.setuName("three!");
		tx.commit();
	}

	/**
	 * 删除
	 */
	@Test
	public void test03() {
		Transaction tx = session.beginTransaction();
		User user = session.get(User.class, 3);
		//user.setUid(2);
		session.delete(user);
		tx.commit();
	}

	
	/**
	 * hql分页查询
	 */
	@Test
	public void test04(){
		  Transaction tx = session.beginTransaction();
		  Query hql = session.createQuery("from User");
		  hql.setFirstResult(1);
		  hql.setMaxResults(3);
		  List<User> ul = hql.list();
		  for (User user : ul) {
			System.out.println(user);
		};
		System.out.println("=====================");
		Iterator it = hql.iterate();
		 while(it.hasNext()){
			 System.out.println(it.next());
		 }
		  tx.commit();
	}
	
	/**
	 * 修改
	 */
	@Test
	  public void test05(){
	        Transaction tx = session.beginTransaction();     	  
	        Query hql = session.createQuery("update User u set u.uName=?,u.upass=? where u.uid=?");
	        hql.setString(0, "hqlTest");
	        hql.setString(1, "12345");
	        hql.setInteger(2, 3);
	        hql.executeUpdate();
	        tx.commit();
	         
	  }

	/**
	 * 添加无法实现
	 */
	@Test
	public void test06(){
		
	}
	 
	/**
	 * hql
	 * 实现删除
	 */
	@Test
	public void test07(){
		  Transaction tx = session.beginTransaction();
		  Query hql = session.createQuery("delete from User u  where u.uid=:id");
		  hql.setInteger("id", 2);
		  hql.executeUpdate();
		  tx.commit();
		  
	}
	
	
	/**
	 * 查询
	 */
	@Test
	public void test08(){
	      Transaction tx = session.beginTransaction();
	      Query hql = session.createQuery("select u from User u left join fetch u.as where u.uid=:a");
	     //hql.setInteger(0, 5);
	      hql.setInteger("a", 5);
           List<User> ul = hql.list();
           for (User user : ul) {
			 Set<Account> as = user.getAs();
			 for (Account account : as) {
				System.out.println(account);
			}
		}
	      tx.commit();
		
	   }

	@Test
	public void test10(){
		 Transaction tx = session.beginTransaction();
		 Criteria cri = session.createCriteria(User.class);
	}
	
	}
	

