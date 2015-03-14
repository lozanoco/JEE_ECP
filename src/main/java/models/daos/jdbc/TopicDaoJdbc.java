package models.daos.jdbc;

import java.util.List;

import models.daos.TopicDao;
import models.entities.Topic;

public class TopicDaoJdbc extends GenericDaoJdbc<Topic, Integer> implements TopicDao {

	@Override
	public void create(Topic entity) {
		// TODO Auto-generated method stub

	}

	@Override
	public Topic read(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(Topic entity) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteById(Integer id) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Topic> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	public static String sqlToCreateTable() {
		// TODO Auto-generated method stub
		return null;
	}

}
