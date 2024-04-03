package com.instabug.featuresrequest.ui.custom;

import android.os.Handler;
import android.os.Message;

class g implements Handler.Callback {
    public boolean handleMessage(Message message) {
        int i11 = message.what;
        if (i11 == 0) {
            ((q) message.obj).p();
            return true;
        } else if (i11 != 1) {
            return false;
        } else {
            ((q) message.obj).n(message.arg1);
            return true;
        }
    }
}
