package models.daos.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import models.daos.VoteDao;
import models.entities.Topic;
import models.entities.Vote;
import models.utils.levelEducation;

public class VoteDaoJdbc extends GenericDaoJdbc<Topic, Integer> implements VoteDao {

	private Vote create(ResultSet resultSet) {
		Vote vote;
		try {
			if (resultSet != null && resultSet.next()) {
				vote = new Vote(resultSet.getString(Vote.IP), resultSet.getInt(Vote.SCORE),
						(levelEducation)resultSet.getObject(Vote.EDUCATION));
				return vote;
			}
		} catch (SQLException e) {
			log.error("read: " + e.getMessage());
		}
		return null;
	}

	private static final String SQL_INSERT = "INSERT INTO %s (%s,%s,%s,%s) VALUES (%d,%s,%d,%s)";
	@Override
	public void create(Vote vote) {
		this.updateSql(String.format(SQL_INSERT, Vote.TABLE, Vote.ID, Vote.IP ,Vote.SCORE ,Vote.EDUCATION,
				vote.getId(),vote.getIp(),vote.getScore(),vote.getEducation());
	}


	@Override
	public Vote read(Integer id) {
		ResultSet resultSet = this.query(String.format(SQL_SELECT_ID, Vote.TABLE, id));
		return this.create(resultSet);
	}

	@Override
	public void update(Topic entity) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteById(Integer id) {
		// TODO Auto-generated method stub
		Vote vote=this.read(id);
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
