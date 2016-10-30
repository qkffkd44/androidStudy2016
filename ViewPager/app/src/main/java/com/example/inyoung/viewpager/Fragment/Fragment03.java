package com.example.inyoung.viewpager.Fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.inyoung.viewpager.DB.DBManager;
import com.example.inyoung.viewpager.DTO.WordDTO;
import com.example.inyoung.viewpager.R;

/**
 * Created by Inyoung on 2016-06-11.
 */
public class Fragment03 extends Fragment{

    View view;

    private EditText edt_Word;
    private EditText edt_Mean;
    private Button btn_Input;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.tab_fragment03, container, false);
        edt_Word = (EditText)view.findViewById(R.id.edt_word);
        edt_Mean = (EditText)view.findViewById(R.id.edt_mean);
        btn_Input = (Button)view.findViewById(R.id.btn_Input);

        final Context context = getContext();

        btn_Input.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String word = edt_Word.getText().toString();
                String mean = edt_Mean.getText().toString();


                if(word.getBytes().length <= 0 || mean.getBytes().length <= 0){
                    Toast.makeText(context,"단어와 뜻을 모두 입력해주세요.", Toast.LENGTH_SHORT).show();

                }else{
                    WordDTO dto = new WordDTO(word, mean);

                    DBManager dbManager = DBManager.get_Instance(getActivity());

                    long result = dbManager.InserWord(dto);

                    edt_Word.setText("");
                    edt_Mean.setText("");
                    Toast.makeText(context,"단어가 입력 되었습니다.", Toast.LENGTH_SHORT).show();
                }

            }
        });
        return view;
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        //true 일때 현재 보고있는 현재화면 상태
        if(isVisibleToUser){

        }

        super.setUserVisibleHint(isVisibleToUser);
    }
}
