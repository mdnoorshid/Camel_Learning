package com.bizruntime.dao.services;
public interface IAchievementDao
{
public void getAchievement(String firstName,String lastName,int departmentId);
public void addAchievement(String firstName,String lastName,int departmentId,String achievements);
public void updateAchievement(String firstName,String lastName,int departmentId);
public void deleteAchievement(String firstName,String lastName,int departmentId);
}
