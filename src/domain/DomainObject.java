/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

/**
 *
 * @author marko
 */
public interface DomainObject {

    String getTableName();

    String getAttributeNamesForInsert();

    String getAttributeValuesForInsert();

    Boolean isAutoIncrement();

    void setObjectId(Long id);
}
