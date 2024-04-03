package com.instabug.survey.utils;

import android.widget.TextView;
import androidx.annotation.NonNull;
import com.instabug.library.internal.device.InstabugDeviceProperties;

public abstract class o {
    public static void a(@NonNull TextView textView) {
        float f11;
        if (!InstabugDeviceProperties.isTablet(textView.getContext())) {
            if (textView.getText().toString().length() > 150) {
                textView.setTextSize(2, 15.0f);
                textView.setLineSpacing(1.0f, 1.1f);
                textView.setMaxLines(5);
                return;
            } else if (textView.getText().toString().length() > 100) {
                f11 = 16.0f;
                textView.setTextSize(2, f11);
                textView.setLineSpacing(1.0f, 1.2f);
                textView.setMaxLines(4);
            } else if (textView.getText().toString().length() < 150) {
                textView.post(new n(textView));
                return;
            }
        }
        f11 = 18.0f;
        textView.setTextSize(2, f11);
        textView.setLineSpacing(1.0f, 1.2f);
        textView.setMaxLines(4);
    }
}
