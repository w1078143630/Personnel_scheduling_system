package com.atguigu.service;

import com.atguigu.domain.Architect;
import com.atguigu.domain.Employee;
import com.atguigu.domain.Programmer;

import java.lang.reflect.ParameterizedType;

/**
 * ClassName: TeamService
 * Description:
 *
 * @Author Wei Wang
 * @Create 2024/3/25 14:39
 * @Version 1.0
 */
public class TeamService {
    private static int counter = 1;//给mid自动赋值
    private final int MAX_MEMBER = 5;
    private Programmer[] team = new Programmer[MAX_MEMBER];
    private int total;
    public Programmer[] getTeam(){
        Programmer[] team = new Programmer[total];
        for (int i = 0; i < total; i++) {
            team[i] = this.team[i];
        }
        return team;
    }
    public void addMember(Employee e) throws TeamException{
        if(total >= MAX_MEMBER){
            throw new TeamException("成员已满");
        }
        if(!(e instanceof Programmer)){
            throw new TeamException("该成员不是开发人员");
        }
        Programmer p = (Programmer) e;
        Status status = p.getStatus();
        switch (status){
            case BUSY:
                throw new TeamException("该员工已是某团队人员");
            case VOCATION:
                throw new TeamException("该员工正在休假");
        }
        boolean isExist = isExist(p);
        if(isExist){
            throw new TeamException("该员工已在本团队");
        }
        team[total++] = p;
        p.setMemberId(counter++);
        p.setStatus(Status.BUSY);
    }

    private boolean isExist(Programmer p) {
        for (int i = 0; i < total; i++) {
            if(p.getId() == team[i].getMemberId()){
                return true;
            }
        }
        return false;
    }

    public void removeMember (int memberId) throws TeamException {
        int i = 0;
        for (i = 0; i < total; i++) {
            if (memberId == team[i].getMemberId()) {
                //找到了
                team[i].setStatus(Status.FREE);
                break;
            }
        }
        //没找到
        if(i == total){
            throw new TeamException("找不到");
        }
        //调整数组
        for(int j = i; j < total - 1; j++){
            team[j] = team[j+1];
        }
        team[--total] = null;

    }
}
