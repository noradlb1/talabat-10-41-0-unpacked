package com.instabug.library.invocation.invocationdialog;

import android.net.Uri;
import androidx.annotation.Nullable;

public class InstabugDialogListener {
    private static InstabugDialogListener INSTANCE;
    @Nullable
    private InstabugDialogCallbacks callbacks;

    public interface InstabugDialogCallbacks {
        void onClick(int i11, String str, Uri uri);
    }

    private InstabugDialogListener() {
    }

    public static InstabugDialogListener getInstance() {
        InstabugDialogListener instabugDialogListener = INSTANCE;
        if (instabugDialogListener != null) {
            return instabugDialogListener;
        }
        InstabugDialogListener instabugDialogListener2 = new InstabugDialogListener();
        INSTANCE = instabugDialogListener2;
        return instabugDialogListener2;
    }

    public void onDialogItemClick(int i11, String str, Uri uri) {
        InstabugDialogCallbacks instabugDialogCallbacks = this.callbacks;
        if (instabugDialogCallbacks != null) {
            instabugDialogCallbacks.onClick(i11, str, uri);
        }
    }

    public void setListener(@Nullable InstabugDialogCallbacks instabugDialogCallbacks) {
        this.callbacks = instabugDialogCallbacks;
    }
}
