package com.example.inyoung.viewpager.Adapter;

import android.content.Context;
import android.speech.tts.TextToSpeech;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;
import android.speech.tts.TextToSpeech;

import com.example.inyoung.viewpager.DB.DBManager;
import com.example.inyoung.viewpager.DTO.WordDTO;
import com.example.inyoung.viewpager.Holder.WordHolder;
import com.example.inyoung.viewpager.R;

import java.util.ArrayList;
import java.util.Locale;

/**
 * Created by Inyoung on 2016-06-11.
 */
public class CustomListAdapter extends BaseAdapter {

    private ArrayList<WordDTO> data;
    private CustomListAdapter adapter;
    private Context context;
    private TextToSpeech mTts;

    //생성자
    public CustomListAdapter(Context context){
        this.context = context;
        data = new ArrayList<>(1);
        adapter = this;
    }

    public void addWord(WordDTO dto){
        data.add(dto);
    }

    public void setList(ArrayList<WordDTO> list){
        this.data = list;
    }

    public ArrayList<WordDTO>getList(){
        return this.data;
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int position) {
        return data.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {

        //이걸왜넣었지....
        //final Context context = parent.getContext();
        WordHolder holder;
        WordDTO dto;


        if(convertView == null){
            LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            //layout 생성
            convertView = inflater.inflate(R.layout.item_word,parent, false);
            holder = new WordHolder();

            holder.tv_word = (TextView)convertView.findViewById(R.id.item_word);
            holder.tv_mean = (TextView)convertView.findViewById(R.id.item_mean);
            holder.btn_delete = (ImageButton)convertView.findViewById(R.id.item_delete);
            holder.btn_speaker = (ImageButton)convertView.findViewById(R.id.item_speaker);

            //태그로 등록
            convertView.setTag(holder);
        }
        else{
            holder = (WordHolder)convertView.getTag();
        }

        //data 연결

        dto = data.get(position);

        //view에 연결
        holder.tv_word.setText(dto.word);
        holder.tv_mean.setText(dto.mean);

        holder.btn_delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                WordDTO deleteDTO = data.get(position);

                data.remove(position);
                adapter.notifyDataSetChanged();
                //Toast.makeText(context, position + " 번째 삭제 클릭", Toast.LENGTH_SHORT).show();
                Toast.makeText(context,  "단어가 삭제되었습니다.", Toast.LENGTH_SHORT).show();

                DBManager dbManager = DBManager.get_Instance(context);
                dbManager.DeleteWord(deleteDTO.word);

            }
        });

        holder.btn_speaker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                mTts = new TextToSpeech(context, new TextToSpeech.OnInitListener() {
                    @Override
                    public void onInit(int status) {
                        WordDTO speakDTO = data.get(position);
                        String speak_word = speakDTO.word;
                        mTts.setLanguage(Locale.US);
                        mTts.speak(speak_word,TextToSpeech.QUEUE_FLUSH,null);

                    }
                });

            }
        });


        return convertView;
    }
}
