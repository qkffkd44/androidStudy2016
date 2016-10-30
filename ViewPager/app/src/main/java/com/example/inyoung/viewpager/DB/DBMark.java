package com.example.inyoung.viewpager.DB;

/**
 * Created by Inyoung on 2016-07-15.
 */
public class DBMark {

    public static  final String DB_TABLE= "WordTable";

    public static  final String DB_COL_WORD= "word";
    public static  final String DB_COL_MEAN= "mean";

    //sqlite에서는 string이 아니라 text
    //create table WordTable (_index Integer primary key autoincrement , word Text, mean Text);
    public  static final String DB_CREATE = "CREATE TABLE " + DB_TABLE + " (_index Integer primary key autoincrement,"
                                                + DB_COL_WORD + " TEXT, "
                                                + DB_COL_MEAN + " TEXT);";

    //select * from WordTable
    public static final String DB_SELECT_ALL= "Select * From " + DB_TABLE + ";";

    //Select word, mean From WordTable where word = ?;
    public static String DB_SELECT_WORD = "Select " + DB_COL_WORD + "," + DB_COL_MEAN + " From " + DB_TABLE + " Where " + DB_COL_WORD + "= ?;";

    //Insert into WordTable (word,mean) values (?,?);
    public static String DB_INSERT = "Insert Into " + DB_TABLE + "(" + DB_COL_WORD + "," + DB_COL_MEAN + ") values (?,?);";

    //Delete from WordTable where word = ?;
    public static String DB_DELETE = "Delete from " + DB_TABLE + " Where " + DB_COL_WORD + "=?;";

}
