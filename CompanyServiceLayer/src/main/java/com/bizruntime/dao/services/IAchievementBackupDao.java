package com.bizruntime.dao.services;
import java.sql.SQLException;
import com.bizruntime.dao.persistence.impl.SqlExceptionFound;
public interface IAchievementBackupDao
{
	public void getAchievement(String firstName,String lastName,int departmentId) throws SQLException, SqlExceptionFound;
	public void addAchievement(String firstName,String lastName,int departmentId,String achievements);
	public void updateAchievement(String firstName,String lastName,int departmentId);
	public void deleteAchievement(String firstName,String lastName,int departmentId);
}
