/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author marko
 */
public class AbstractDomainObject implements DomainObject {

    @Override
    public String getTableName() {
        return this.getClass().getSimpleName();
    }

    @Override
    public String getAttributeNamesForInsert() {
        Field[] fields = this.getClass().getDeclaredFields();
        List<String> list = new ArrayList();
        for (Field field : fields) {
            list.add(field.getName());
        }
        list.remove(0);
        return String.join(", ", list);
    }

    @Override
    public String getAttributeValuesForInsert() {
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

}
