package com.example.a300985590.ttcpay.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.a300985590.ttcpay.Util.Constant;

public class DbHelper extends SQLiteOpenHelper {


    private String tableName;
    public DbHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    public void dbInitialize(String tableName)
    {
        this.tableName=tableName;
        //this.tableCreatorString=tableCreatorString;
    }


    @Override
    public void onCreate(SQLiteDatabase db) {

            db.execSQL(Constant.USER_TABLE_QUERY);
            db.execSQL(Constant.ITEM_TYPE_QUERY);
            db.execSQL(Constant.ITEM_INVENTORY_QUERY);
            //db.execSQL(Constant.SHOPPINGCART_TABLE_QUERY);
            db.execSQL(Constant.ORDER_TABLE_QUERY);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public boolean addRow  (ContentValues values) throws Exception {
        SQLiteDatabase db = this.getWritableDatabase();
        // Insert the row
        long nr= db.insert(tableName, null, values);
        db.close(); //close database connection
        return nr> -1;
    }

    public boolean editRow (Object id, String fieldName, ContentValues values) throws Exception {
        SQLiteDatabase db = this.getWritableDatabase();
        //
        int nr = db.update(tableName, values, fieldName + " = ? ", new String[]{String.valueOf(id)});
        return nr > 0;
    }

}
