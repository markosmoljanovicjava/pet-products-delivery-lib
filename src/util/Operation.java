/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.io.Serializable;

/**
 *
 * @author student1
 */
public interface Operation extends Serializable {

    public static final int LOGIN = 1;
    public static final int SAVE_PRODUCT = 2;
    public static final int GET_ALL_MANUFACTURERS = 3;
    public static final int UPDATE_PRODUCT = 4;
    public static final int GET_ALL_PRODUCTS = 5;
    public static final int DELETE_PRODUCT = 6;
    public static final int GET_ALL_CUSTOMERS = 7;
    public static final int GET_ALL_PRODUCST_FOR_MANUFACTURER = 8;
    public static final int SAVE_CONTRACT = 9;
    public static final int IS_CONNECTED = 10;
    public static final int REGISTER_CUSTOMER = 11;

}
