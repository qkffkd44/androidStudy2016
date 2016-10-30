package com.example.inyoung.sqlite.DB;

/**
 * Created by Inyoung on 2016-06-04.
 */
public class DB_MARK {
    public static final String DB_TABLE = "USER";

    public static final String DB_COL_ID ="id";
    public static final String DB_COL_PW ="pw";
    public static final String DB_COL_NAME ="name";
    public static final String DB_COL_AGE ="age";
    public static final String DB_COL_ADDRESS ="address";

    // CREATE TABLE USER (_index INTEGER PRIMARY KEY AUTOINCREMENT, id TEXT, pw TEXT, name TEXT, age TEXT, address TEXT);
    public static final String DB_CREATE = "CREATE TABLE "+DB_TABLE+ "(_index INTEGER PRIMARY KEY AUTOINCREMENT,"
                                                +DB_COL_ID+" TEXT, "
                                                +DB_COL_PW+" TEXT, "
                                                +DB_COL_NAME+" TEXT, "
                                                +DB_COL_AGE+" INTEGER, "
                                                +DB_COL_ADDRESS+" TEXT);";

    //INSERT INTO USER (id, pw, name, age, address) values(?,?,?,?,?);
    public static final String DB_SQL_INSERT = "INSERT INTO "+ DB_TABLE+" ("
                                                    +DB_COL_ID+", "
                                                    +DB_COL_PW+", "
                                                    +DB_COL_NAME+", "
                                                    +DB_COL_AGE+", "
                                                    +DB_COL_ADDRESS+") VALUES (?,?,?,?,?);";
    // SELECT * FROM USER:
    public static final String DB_SQL_ALLSELECT = "SELECT *FROM "+DB_TABLE;

    //SELECT * FROM USER WHERE name = '사용자'
    public static final String DB_SQL_SELECT = "SELECT * FROM " + DB_TABLE + " WHERE name = ?";

    //UPDATE USER set name = ? WHERE id = ?
    public static final String DB_SQL_UPDATE = "UPDATE " + DB_TABLE + " set name = ? WHERE id = ?";


    //DELECT FROM USER WHERE name = ?
    public static final String DB_SQL_DELETE = "DELECT FROMW " + DB_TABLE + " WHERE name = ?" ;

}
