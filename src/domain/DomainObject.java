/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author marko
 */
public interface DomainObject {

    String getTableName();

    String getAttributeNamesInsert();

    String getAttributeValuesInsert();

    Boolean isAutoIncrement();

    void setObjectId(Long id);

    Long getObjectId();

    String getWhere(DomainObject domainObject, Boolean isJoin);

    DomainObject getObject(ResultSet rs) throws SQLException;

    List<DomainObject> getList(ResultSet rs) throws SQLException;

    String getSET();

    String getAttributeNamesForJoin();

    String getTableNameForJoin();

    String getConditionForJoin();

    String getORDERBYForJoin();

    String getConditionForWhere(DomainObject domainObject);

}
