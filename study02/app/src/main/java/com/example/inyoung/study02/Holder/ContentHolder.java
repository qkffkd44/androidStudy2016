package com.example.inyoung.study02.Holder;

import android.widget.ImageButton;
import android.widget.TextView;

/**
 * Created by Inyoung on 2016-05-28.
 */
public class ContentHolder {

    public TextView Title;
    public TextView Content;
    public ImageButton Btn;

    public TextView getTitle() {
        return Title;
    }

    public void setTitle(TextView title) {
        Title = title;
    }

    public TextView getContent() {
        return Content;
    }

    public void setContent(TextView content) {
        Content = content;
    }

    public ImageButton getBtn() {
        return Btn;
    }

    public void setBtn(ImageButton btn) {
        Btn = btn;
    }
}
