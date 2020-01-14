package ca.pjer.app;

import ca.pjer.spring.boot.jdbi.AutoSqlObject;
import org.jdbi.v3.sqlobject.config.RegisterBeanMapper;
import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;

import java.util.Date;
import java.util.List;

@AutoSqlObject
public interface VisitDao {

    @SqlQuery("SELECT COUNT(*) FROM visit")
    long getCount();


    @SqlQuery("SELECT * FROM visit ORDER BY datetime DESC LIMIT :count")
    @RegisterBeanMapper(Visit.class)
    List<Visit> getLastVisits(int count);

    @SqlUpdate("INSERT INTO visit (id, datetime, useragent) VALUES (UUID(), :datetime, :useragent)")
    void insert(Date datetime, String useragent);

}
