package com.talabat.geminterfaces;

import android.app.Dialog;

public interface OnGemMinimize {
    void onMinimizeButtonClicked(Dialog dialog);

    void setFloatingGemTimer(String str);

    void timeOut();
}
