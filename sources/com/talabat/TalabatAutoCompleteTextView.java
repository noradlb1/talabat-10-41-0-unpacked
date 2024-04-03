package com.talabat;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.widget.AutoCompleteTextView;
import android.widget.ProgressBar;

public class TalabatAutoCompleteTextView extends AutoCompleteTextView {
    private static final int DEFAULT_AUTOCOMPLETE_DELAY = 750;
    private static final int MESSAGE_TEXT_CHANGED = 10;
    private int mAutoCompleteDelay = DEFAULT_AUTOCOMPLETE_DELAY;
    private final Handler mHandler = new Handler() {
        public void handleMessage(Message message) {
            TalabatAutoCompleteTextView.super.performFiltering((CharSequence) message.obj, message.arg1);
        }
    };
    private ProgressBar mLoadingIndicator;

    public TalabatAutoCompleteTextView(Context context) {
        super(context);
    }

    public void onCompletedLoading() {
        ProgressBar progressBar = this.mLoadingIndicator;
        if (progressBar != null) {
            progressBar.setVisibility(8);
        }
    }

    public void onFilterComplete(int i11) {
        onCompletedLoading();
        super.onFilterComplete(i11);
    }

    public void performFiltering(CharSequence charSequence, int i11) {
        ProgressBar progressBar = this.mLoadingIndicator;
        if (progressBar != null) {
            progressBar.setVisibility(0);
        }
        this.mHandler.removeMessages(10);
        Handler handler = this.mHandler;
        handler.sendMessageDelayed(handler.obtainMessage(10, charSequence), (long) this.mAutoCompleteDelay);
    }

    public void replaceText(CharSequence charSequence) {
        super.replaceText(charSequence);
    }

    public void setAutoCompleteDelay(int i11) {
        this.mAutoCompleteDelay = i11;
    }

    public void setLoadingIndicator(ProgressBar progressBar) {
        this.mLoadingIndicator = progressBar;
    }

    public TalabatAutoCompleteTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public TalabatAutoCompleteTextView(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
    }
}
