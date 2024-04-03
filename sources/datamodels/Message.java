package datamodels;

import androidx.annotation.IntegerRes;

public class Message {
    private String message;
    @IntegerRes
    private int resId;

    public String getMessage() {
        return this.message;
    }

    public int getResId() {
        return this.resId;
    }

    public void setMessage(String str) {
        this.message = str;
    }

    public void setResId(int i11) {
        this.resId = i11;
    }
}
