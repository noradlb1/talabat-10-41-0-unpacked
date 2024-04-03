package com.instabug.featuresrequest.utils;

import android.text.TextPaint;
import android.text.style.ClickableSpan;

public abstract class m extends ClickableSpan {
    public void updateDrawState(TextPaint textPaint) {
        textPaint.setUnderlineText(false);
    }
}
