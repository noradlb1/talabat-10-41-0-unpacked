package com.instabug.survey;

public class Survey {
    private long surveyId;
    private String title;

    public Survey(long j11, String str) {
        this.title = str;
        this.surveyId = j11;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String str) {
        this.title = str;
    }

    public void show() {
        if (h.e() != null) {
            h.e().b(this.surveyId);
        }
    }
}
