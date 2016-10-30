package com.example.inyoung.viewpager.Fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.inyoung.viewpager.Adapter.CustomListAdapter;
import com.example.inyoung.viewpager.DB.DBManager;
import com.example.inyoung.viewpager.DTO.WordDTO;
import com.example.inyoung.viewpager.R;

import java.util.ArrayList;

/**
 * Created by Inyoung on 2016-06-11.
 */
public class Fragment01 extends Fragment{

    View view;
    TextView tv;
    EditText edt_search;
    ImageButton btn_search;
    ListView lv_wordlist;

    CustomListAdapter adapter;

    Context context;


    @Override
    public View onCreateView(LayoutInflater inflater, final ViewGroup container, Bundle savedInstanceState) {

        //여기서 프레그먼트 UI랑 연결결
       view = inflater.inflate(R.layout.tab_fragment01, container, false);

        context = getActivity();

        edt_search = (EditText)view.findViewById(R.id.fr1_edit_search);
        btn_search = (ImageButton) view.findViewById(R.id.fr1_btn_search);
        lv_wordlist = (ListView) view.findViewById(R.id.fr1_listView);

        //어뎁터랑 리스트랑 연동시키는 부분
        adapter = new CustomListAdapter(getActivity());
        lv_wordlist.setAdapter(adapter);

        listUpdate();

        //sample
       /* adapter.addWord(new WordDTO("Apple", "사과"));
      adapter.addWord(new WordDTO("Search", "검색"));
      adapter.addWord(new WordDTO("Delete", "삭제"));
      adapter.addWord(new WordDTO("Bear", "곰"));
      adapter.addWord(new WordDTO("Eraser", "지우개")); */

        lv_wordlist.setAdapter(adapter);

        btn_search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "search Click", Toast.LENGTH_SHORT).show();

                String findword = edt_search.getText().toString();


                //디비연결 후 단어 찾아오기
                DBManager dbManager = DBManager.get_Instance(getActivity());
                ArrayList<WordDTO> list = dbManager.getSelectWord(findword);

                //adapter에 데이터 변경하기
                adapter.setList(list);
                adapter.notifyDataSetChanged();
                edt_search.setText("");
            }
        });

        return view;
    }

    //DBManager랑 연결
    public void listUpdate() {
        //어뎁터가 정상적으로 만들어졌을때 실행하려고 null이면 그냥 리턴
        if(adapter == null){
            return;
        }

        DBManager dbManager = DBManager.get_Instance(getActivity());
        ArrayList<WordDTO> list = dbManager.getSelectAll();

        adapter.setList(list);
        adapter.notifyDataSetChanged();
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        //true 일때 현재 보고있는 현재화면 상태
        if(isVisibleToUser){
            //현재화면이 보여질때 리스트가 갱신
            listUpdate();
        }

        super.setUserVisibleHint(isVisibleToUser);
    }
}
