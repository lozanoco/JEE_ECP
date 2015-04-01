package models.daos.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import models.daos.VoteDao;
import models.entities.Vote;
import models.utils.levelEducation;

public class VoteDaoJdbc extends GenericDaoJdbc<Vote, Integer> implements VoteDao {
	
	private Logger log = LogManager.getLogger(VoteDaoJdbc.class);

	private Vote create(ResultSet resultSet) {
		Vote vote;
		try {
			if (resultSet != null && resultSet.next()) {
				vote = new Vote(resultSet.getString(Vote.IP), resultSet.getInt(Vote.SCORE),
						(levelEducation)resultSet.getObject(Vote.EDUCATION));
				vote.setId(resultSet.getInt(Vote.ID));
				return vote;
			}
		} catch (SQLException e) {
			log.error("read: " + e.getMessage());
		}
		return null;
	}
	
	private static final String SQL_CREATE_TABLE = "CREATE TABLE %s (%s INT NOT NULL AUTO_INCREMENT, %s VARCHAR(255), "
            + "%s INT, %s VARCHAR(255),PRIMARY KEY (%s))";

    public static String sqlToCreateTable() {
        return String
                .format(SQL_CREATE_TABLE, Vote.TABLE, Vote.ID, Vote.IP, Vote.SCORE, Vote.EDUCATION, Vote.ID);
    }

	private static final String SQL_INSERT = "INSERT INTO %s (%s,%s,%s) VALUES (%s,%d,%s)";
	@Override
	public void create(Vote vote) {
		this.updateSql(String.format(SQL_INSERT, Vote.TABLE, Vote.IP ,Vote.SCORE ,Vote.EDUCATION,
				vote.getId(),vote.getIp(),vote.getScore(),vote.getEducationString()));
	}


	@Override
	public Vote read(Integer id) {
		ResultSet resultSet = this.query(String.format(SQL_SELECT_ID, Vote.TABLE, id));
		return this.create(resultSet);
	}

	private static final String SQL_UPDATE = "UPDATE %s SET %s='%s', %s='%d', %s='%s' WHERE ID=%s";
	@Override
	public void update(Vote vote) {
		this.updateSql(String.format(SQL_UPDATE, Vote.IP, vote.getIp(), Vote.SCORE,vote.getScore(),
				Vote.EDUCATION,vote.getEducationString(), vote.getId()));		
	}


	@Override
	public void deleteById(Integer id) {
		this.updateSql(String.format(SQL_DELETE_ID, Vote.TABLE, id));
	}


	@Override
	public List<Vote> findAll() {
		List<Vote> list = new ArrayList<Vote>();
		ResultSet resultSet = this.query(String.format(SQL_SELECT_ALL, Vote.TABLE));
		Vote vote = this.create(resultSet);
		while (vote != null) {
			list.add(vote);
			vote = this.create(resultSet);
		}
		return list;
	}


}
