package com.catCake.cakeonline.admin.cake.dao;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

import com.catCake.cakeonline.admin.entity.Cake;

@Repository
public class cakeAdminDao {
	@Resource
	private SessionFactory sessionfactory ;
	//��ѯ���е���
	public List<Cake> findAll(){	
		String hql = "from Cake" ;
		Session session = sessionfactory.openSession();
		Transaction tran = session.beginTransaction();
		Query query = session.createQuery(hql);
		return query.list();
	}
	
	//delete
	public void deleteCake(@RequestParam("deleteHid")int id) {
		String hql = "delete Cake where cakeId=:name";
		Session session = sessionfactory.openSession();
		Transaction tran = session.beginTransaction();
		Query query = session.createQuery(hql);
		query.setParameter("name",id);
		int ret = query.executeUpdate();
		System.out.println(ret);
		tran.commit();
	}
	//�������֣�
	public void updateCake(@RequestParam("saveHid")int id,@RequestParam("cake1")String aa) {
		Session session = sessionfactory.openSession();
		Transaction tx = session.beginTransaction();
		Cake cake = (Cake) session.get(Cake.class, id);
		cake.setCakeName(aa);
		tx.commit();
	}
	//����ͼƬ·��
		public void updateCake1(@RequestParam("saveHid")int id,@RequestParam("cake2")String aa) {
			Session session = sessionfactory.openSession();
			Transaction tx = session.beginTransaction();
			Cake cake = (Cake) session.get(Cake.class, id);
			cake.setImg1(aa);
			tx.commit();
		}
	//���¼۸�
		public void updateCake2(@RequestParam("saveHid")int id,@RequestParam("cake3")int aa) {
			Session session = sessionfactory.openSession();
			Transaction tx = session.beginTransaction();
			Cake cake = (Cake) session.get(Cake.class, id);
			cake.setPrice(aa);
			tx.commit();
		}
	
	
}
