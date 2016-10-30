package com.example.inyoung.sqlite.DB;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteStatement;
import android.widget.Toast;

import com.example.inyoung.sqlite.DTO.User;

/**
 * Created by Inyoung on 2016-06-04.
 */
public class DBManager extends SQLiteOpenHelper {

    //file.db에서 file의 이름을 지정
    private static final String DB_NAME = "Person.db";
    private static final int DB_VERSION = 1;

    //데이터베이스와 연결시키는
    private static SQLiteDatabase mSQL;

    //
    private Context context;

    //싱글톤 : staric이 싱글톤을 위해서 존재
    private static DBManager mDBManager;

    //싱글톤 메소드
    public static DBManager get_Instance(Context context) {
        if(mDBManager == null)
            mDBManager = new DBManager(context, DB_NAME, null, DB_VERSION);

        return  mDBManager;
    }

    //생성자 메소드를 오버라이딩 해줘야 한다.
    public DBManager(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, DB_NAME, factory, version); //name:DB이름 factory:기본값 쓸거니까 그냥 냅두 version을 비교해서 onupgrde 함수를.....

        //context복사
        this.context = context;
    }

    //제일 처음 DB가 생성 되었을때 = 패키지 안에 file.db 파일이 없을때
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(DB_MARK.DB_CREATE);

    }

    //DB가 업데이트 되었을때 = 이미 패키지 안에 file.db가 존재 할때
    // 이걸 구분하는데 version 숫자 사용
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    //mysql db와 연결 하는 메소드
    public void DB_OPEN(){
        mSQL = this.getWritableDatabase();
    }


    //mysql db와 닫는 메소드
    public void DB_CLOSE(){
        mSQL.close();

    }

    public void Insert(User user){
        if(mSQL == null)
            this.DB_OPEN();

        SQLiteStatement stmt = mSQL.compileStatement(DB_MARK.DB_SQL_INSERT);
        stmt.bindString(1,user.id);
        stmt.bindString(2,user.pw);
        stmt.bindString(3,user.name);
        stmt.bindLong(4,user.age);
        stmt.bindString(5,user.addr);

        //쿼리문 실행
        long result = stmt.executeInsert();
        Toast.makeText(context, "입력 결과: " + result , Toast.LENGTH_SHORT).show();

        //state문도 사용하고 닫아야한다
        stmt.close();
    }

    //업데이트문 추가 한것
    public void Update(String id, String name){
        if(mSQL == null)
            this.DB_OPEN();

        SQLiteStatement stmt = mSQL.compileStatement(DB_MARK.DB_SQL_UPDATE);

        stmt.bindString(1, id);
        stmt.bindString(2, name);

        long result = stmt.executeUpdateDelete();

        Toast.makeText(context, "입력 결과 :" + result, Toast.LENGTH_LONG).show();
                stmt.close();

    }

    public User Select(String name){ //u는 User
        if(mSQL == null)
            this.DB_OPEN();

        Cursor c = null;
        User u = null;
        SQLiteStatement stmt = mSQL.compileStatement(DB_MARK.DB_SQL_SELECT);
        stmt.bindString(1, name);
        String sql = stmt.simpleQueryForString();

        c = mSQL.rawQuery(sql, null);

        while(c.moveToNext()){
            u = new User();
            u.id = c.getString(1);
            u.pw = c.getString(2);
            u.name = c.getString(3);
            u.age = c.getInt(4);
            u.addr = c.getString(5);
        }

        c.close();


        return u;
    }

    public void Delete(String name){
        SQLiteStatement stmt = mSQL.compileStatement(DB_MARK.DB_SQL_DELETE);

        // =?
        stmt.bindString(1,name);
        stmt.executeUpdateDelete();
    }




}

//핸드폰에서 설치된 프로그램 경로 : system -> app> .apk 파일들이.....+ come 어쩌구에 들어가사 db


















