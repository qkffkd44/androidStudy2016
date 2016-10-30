package com.example.inyoung.hw02.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.inyoung.hw02.DTO.ContentDTO;
import com.example.inyoung.hw02.Holder.ContentHolder;
import com.example.inyoung.hw02.R;

import java.util.ArrayList;

/**
 * Created by Inyoung on 2016-06-03.
 */
public class CustomAdapter extends BaseAdapter {

    private ArrayList<ContentDTO> data;
    private CustomAdapter adapter;

    //생성자 메소드 1 은 메모리영역을 넘어갔을때 늘어나는 양
    public CustomAdapter(){
        data = new ArrayList<ContentDTO>(1);

        //아래서 데이터 변경알림을 주기위해서
        adapter = this;
    }

    //리스트 데이터 교체
    public void setList(ArrayList<ContentDTO>list){
        this.data = list;
    }

    //데이터를 추가하는 메소드
    public void addData(ContentDTO dto){
        data.add(dto);
    }

    //몇개의 아이템이있나요
    @Override
    public int getCount() {
        return data.size();
    }

    //해당데이터에서 데이터주는거 (클릭을하면 아이템을 찾아주는 메소드)
    @Override
    public Object getItem(int i) {
        return data.get(i);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    //데이터 사이즈만큼 호출
    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {

        //context 는 현재 어플리케이션에 정보를 가지고있다.
        //final 은 다른 클래스에서도 호출할수 있다. 아래에서 Toast에서 쓰인다
        final Context context = parent.getContext();

        ContentDTO dto = null;
        ContentHolder holder = null;

        //화면에 없던 view가 나타나면 호출이 된다... 근데 그게 이미 생성됫던건지 아닌지
        if (convertView == null){ //이미 view가 존재 안할때 = 이미 한번 생성한적이 있다..

            //안드로이드 시스템이 가지고 있음
            LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            //xml 파일의 레이아웃을 객체로 변환시켜주는 inflate
            convertView = inflater.inflate(R.layout.item_list, parent, false);

            holder = new ContentHolder();

            //convertView.findeViewById
            holder.Title = (TextView)convertView.findViewById(R.id.tv_item_title);
            holder.Content = (TextView)convertView.findViewById(R.id.tv_item_content);
            holder.Btn = (ImageButton)convertView.findViewById(R.id.btn_item_Delete);

            //setTag는 맵 :  key value 값으로
            convertView.setTag(holder);


        }
        else{ //view 가 존재 할때
            holder = (ContentHolder)convertView.getTag();
        }

        dto = data.get(position);

        holder.Title.setText(dto.getTitle());
        holder.Content.setText(dto.getContent());

        holder.Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, position + "번째 : 클릭 " , Toast.LENGTH_SHORT).show();

                //데이터 삭제
                data.remove(position);

                //데이터 변경 알림(UI를 고치세요)
                adapter.notifyDataSetChanged();
            }
        });


        return convertView;
    }
}
