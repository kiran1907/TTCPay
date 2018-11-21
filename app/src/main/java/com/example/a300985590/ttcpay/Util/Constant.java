package com.example.a300985590.ttcpay.Util;

public class Constant {

    public static final String DATABASE_NAME="TTCPay";
    public static final int DATABASE_VERSION=1;

    public static String QUERY="query";

    /*User Table Columns Data */
    public static String USER_TABLE_NAME="USER";
    public static String USER_NO="userNo";
    public static String USER_ID="userId";
    public static String USER_FIRST_NAME="userFirstName";
    public static String USER_LAST_NAME="userLastName";
    public static String EMAIL="email";
    public static String PASSWORD="password";
    public static String ADDRESS="address";
    public static String PHONE="phone";

    public static String USER_TABLE_QUERY="CREATE TABLE "+USER_TABLE_NAME+"("+USER_NO+" int PRIMARY KEY AUTO_INCREMENT,"+USER_ID+" TEXT,"+USER_FIRST_NAME+" text" +
            ","+USER_LAST_NAME+" text,"+EMAIL+" text,"+PASSWORD+" text,"+ADDRESS+" text,"+PHONE+" long)";


    /*Items Type Table data */
    public static String ITEM_TYPE="itemType";
    public static String ITEM_TYPE_ID="itemTypeId";
    public static String ITEM_TYPE_NAME="itemTypeName";
    public static String ITEM_TYPE_QUERY="CREATE TABLE "+ITEM_TYPE+"("+ITEM_TYPE_ID+
            " int PRIMARY KEY AUTO_INCREMENT,"+ITEM_TYPE_NAME+" TEXT)";


    /*Items like Pass and Tickets Tables */
    public static String ITEM="ITEM";
    public static String ITEM_ID="itemId";
    public static String ITEM_NAME="itemName";
    public static String ITEM_QUANTITY="itemQuantity";
    public static String ITEM_UNIT_PRICE="unitPrice";

    public static String ITEM_INVENTORY_QUERY="CREATE TABLE "+ITEM+"("+ITEM_ID+
            " int PRIMARY KEY AUTO_INCREMENT,"+ITEM_NAME+" TEXT,"+ITEM_TYPE+" text,"+ITEM_UNIT_PRICE+" long,"+ITEM_QUANTITY+" int)";


    /*Shopping Cart Columns Table Data */
    public static String CART_ID="cartId";
    public static String SHOPPINGCART_TABLE_QUERY="";




    /*Order Table Columns Detail*/
    public static String orderTablName="ORDER";
    public static String ORDER_ID="orderId";
    public static String ORDER_NUMBER="orderNumber";
    public static String CREATED_BY="createdBy";
    public static String CREATED_DATE="createdDate";
    public static String TOTAL_PRICE="totalPrice";

    public static String ORDER_TABLE_QUERY="CREATE TABLE "+orderTablName+"("+ORDER_ID+" " +
            "INTEGER PRIMARY KEY AUTO_INCREMENT,"+ORDER_NUMBER+" text,"+CREATED_BY+" INTEGER,"
            +CREATED_DATE+"  text,"+ITEM_ID+" INTEGER,"+ITEM_QUANTITY+" int,"+TOTAL_PRICE+" long)";




}
