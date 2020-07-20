package com.example.spring.repository;

import com.example.spring.model.Emp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public class EmpDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    public int getCount() {
        return this.jdbcTemplate.queryForObject("select count(*) as total from emp", Integer.class);
    }
    public Emp getEmp(int empno) {
        return this.jdbcTemplate.queryForObject("select * from emp where empno = ?", empRowMapper, empno);
    }
    public List<Emp> getEmps(int start, int pageSize) {
        return this.jdbcTemplate.query("select * from emp limit ?, ?", empRowMapper, start, pageSize);
    }
    public List<String> getEnameByParams(int start, int pageSize) {
        return this.jdbcTemplate.queryForList("select ename from emp limit ?, ?", String.class, start, pageSize);
    }
    public List<Map<String, Object>> getMap() {
        return this.jdbcTemplate.queryForList("select empno,ename from emp");
    }
    public int insert(int empno, String ename, String job, int deptno) {
        return this.jdbcTemplate.update("insert into emp(empno, ename, job, deptno) values (?, ?, ?, ?)", empno, ename, job, deptno);
    }
    public int update(int empno, String ename, String job) {
        return this.jdbcTemplate.update("update emp set ename = ?, job = ? where empno = ?", ename, job, empno);
    }
    public int delete(int empno) {
        return this.jdbcTemplate.update("delete from emp where empno = ?", empno);
    }
    private final RowMapper<Emp> empRowMapper = (rs, rowNum) -> {
        return new Emp(rs.getInt("empno"), rs.getString("ename"));
        //                rs.getString("job"), rs.getInt("mgr"),
//                rs.getDate("hiredate"), rs.getDouble("sal"),
//                rs.getDouble("comm"), rs.getInt("deptno"));
    };
}