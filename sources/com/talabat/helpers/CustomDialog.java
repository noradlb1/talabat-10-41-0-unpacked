package com.talabat.helpers;

import android.app.Dialog;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.WindowManager;
import library.talabat.com.talabatlib.R;

public class CustomDialog extends Dialog {

    /* renamed from: b  reason: collision with root package name */
    public Context f60780b;

    public CustomDialog(Context context) {
        super(context);
        this.f60780b = context;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        requestWindowFeature(1);
        setContentView(R.layout.cutom_progress_bar);
        getWindow().setBackgroundDrawable(new ColorDrawable(0));
        Resources resources = this.f60780b.getResources();
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        int applyDimension = (int) TypedValue.applyDimension(1, 92.0f, resources.getDisplayMetrics());
        layoutParams.width = applyDimension;
        layoutParams.height = applyDimension;
        setCanceledOnTouchOutside(false);
        getWindow().setAttributes(layoutParams);
    }

    public boolean onKeyDown(int i11, KeyEvent keyEvent) {
        dismiss();
        return super.onKeyDown(i11, keyEvent);
    }
}
