/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.lang.reflect.Field;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author marko
 */
public class AbstractDomainObject implements DomainObject {

    protected final List<String> attributeNames;
    protected final String tableName;

    public AbstractDomainObject() {
        attributeNames = createListAttributes();
        tableName = this.getClass().getSimpleName();
    }

    private List<String> createListAttributes() {
        Field[] fields = this.getClass().getDeclaredFields();
        List<String> list = new ArrayList();
        for (Field field : fields) {
            list.add(field.getName());
        }
        return list;
    }

    @Override
    public String getTableName() {
        return tableName;
    }

    @Override
    public String getAttributeNamesInsert() {
        List<String> list = new ArrayList<>(attributeNames);
        list.remove(0);
        return String.join(", ", list);
    }

    @Override
    public String getAttributeValuesInsert() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Boolean isAutoIncrement() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setObjectId(Long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public DomainObject getObject(ResultSet rs) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<DomainObject> getList(ResultSet rs) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getSET() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getAttributeNamesForJoin() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getTableNameForJoin() {
        String string = this.getClass().getSimpleName();
        return String.format("%s %s", string, string);
    }

    @Override
    public String getConditionForJoin() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getORDERBYForJoin() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getConditionForWhere(DomainObject domainObject) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getWhere(DomainObject domainObject, Boolean isJoin) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Long getObjectId() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
