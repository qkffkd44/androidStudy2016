package com.example.inyoung.viewpager.DB;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteStatement;
import android.widget.Toast;

import com.example.inyoung.viewpager.DTO.WordDTO;

import java.sql.PreparedStatement;
import java.util.ArrayList;

/**
 * Created by Inyoung on 2016-07-15.
 */
public class DBManager extends SQLiteOpenHelper {

    private static final int DB_VERSION = 1;
    private static final String DB_NAME = "Word.db";
    private SQLiteDatabase mSQL;
    private static DBManager dbManager;
    private Context mContext;

    public DBManager(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, DB_NAME, factory, DB_VERSION);
        dbManager = this;
        mContext = context;

    }

    //외부에서는 이곳을 통해서 디비를 다룰수있다.
    public static DBManager get_Instance(Context context){

        if(dbManager == null){
            dbManager = new DBManager(context, DB_NAME, null, DB_VERSION);
        }

        return dbManager;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(DBMark.DB_CREATE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void DeleteWord(String deleteWord){
        SQLiteStatement stmt = mSQL.compileStatement(DBMark.DB_DELETE);

        //Delete from WordTable where word = ?;
        stmt.bindString(1,deleteWord);

        long result = stmt.executeUpdateDelete();

        if(result > 0){
            //Toast.makeText(mContext, result + " : 번재 데이터가 삭제 되었습니다..", Toast.LENGTH_SHORT).show();
        }
    }

    public long InserWord(WordDTO dto){

        SQLiteStatement stmt = mSQL.compileStatement(DBMark.DB_INSERT);

        stmt.bindString(1,dto.word);
        stmt.bindString(2,dto.mean);

        //result 는 indext와 같음 -1일 경우 db에 x
        long result = stmt.executeInsert();

        stmt.close();

        //Toast.makeText(mContext, result + " : 번재 데이터가 입력 되었습니다.", Toast.LENGTH_SHORT).show();

        return result;
    }

    public ArrayList<WordDTO>getSelectWord(String findWord){
        ArrayList<WordDTO> list = new ArrayList<>(1);

        // 쿼리문을 가져옴
        //SQLiteStatement stmt = mSQL.compileStatement(DBMark.DB_SELECT_WORD);

        //Select word, mean From WordTable where word = ?;
        //첫번째 물음표 = 1 에 findword를 넣어준다.
        //stmt.bindString(1,findWord);

      String [] arg = new String[1];
        arg[0] = findWord;
        //커서에 쿼리문을 넣어준다
        Cursor c = mSQL.rawQuery(DBMark.DB_SELECT_WORD, arg);

        while(c.moveToNext()){
            String word = c.getString(0);
            String mean = c.getString(1);

            WordDTO dto = new WordDTO(word, mean);
            list.add(dto);
        }

        // 꼭 꼭 사용한 자원 반납
        //stmt.close();
        c.close();
        return list;
    }


    public ArrayList<WordDTO>getSelectAll(){
        ArrayList<WordDTO> list = new ArrayList<>(1);

        // 쿼리문을 가져옴
        //에러나요 SQLiteStatement stmt = mSQL.compileStatement(DBMark.DB_SELECT_ALL);
        //String sql = stmt.simpleQueryForString();

        //커서에 쿼리문을 넣어준다
        Cursor c = mSQL.rawQuery(DBMark.DB_SELECT_ALL,null);

        while(c.moveToNext()){
            String word = c.getString(1);
            String mean = c.getString(2);

            WordDTO dto = new WordDTO(word, mean);
            list.add(dto);
        }

        // 꼭 꼭 사용한 자원 반납
        //stmt.close();
        c.close();

        return list;

    }

    public void DB_OPEN(){
        mSQL = this.getWritableDatabase();
    }

    public void DB_CLOSE(){
        mSQL.close();
    }

}
