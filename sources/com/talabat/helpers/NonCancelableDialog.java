package com.talabat.helpers;

import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.WindowManager;
import androidx.annotation.NonNull;
import library.talabat.com.talabatlib.R;

public class NonCancelableDialog extends Dialog {
    public NonCancelableDialog(@NonNull Context context) {
        super(context);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        requestWindowFeature(1);
        setContentView(R.layout.cutom_progress_bar);
        getWindow().setBackgroundDrawable(new ColorDrawable(0));
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        int applyDimension = (int) TypedValue.applyDimension(1, 92.0f, getContext().getResources().getDisplayMetrics());
        layoutParams.width = applyDimension;
        layoutParams.height = applyDimension;
        setCancelable(false);
        setCanceledOnTouchOutside(false);
        getWindow().setAttributes(layoutParams);
    }
}
