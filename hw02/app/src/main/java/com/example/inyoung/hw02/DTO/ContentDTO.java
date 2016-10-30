package com.example.inyoung.hw02.DTO;

/**
 * Created by Inyoung on 2016-06-03.
 */
public class ContentDTO { //data transfer object

    private String Title;
    private String Content;

    public ContentDTO(String Title, String Content){
        this.Title = Title;
        this.Content = Content;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getContent() {
        return Content;
    }

    public void setContent(String content) {
        Content = content;
    }
}
