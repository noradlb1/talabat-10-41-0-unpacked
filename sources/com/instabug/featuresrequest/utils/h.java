package com.instabug.featuresrequest.utils;

import android.content.Context;
import android.graphics.Color;
import android.widget.TextView;
import androidx.annotation.ColorRes;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import com.instabug.featuresrequest.R;
import com.instabug.featuresrequest.models.b;

public abstract class h {
    public static void a(b bVar, String str, @Nullable TextView textView, Context context) {
        int i11;
        int i12;
        if (textView != null) {
            int i13 = g.f46829a[bVar.ordinal()];
            if (i13 == 1) {
                textView.setText(R.string.ib_feature_rq_status_completed);
                i11 = R.color.ib_fr_color_completed;
            } else if (i13 != 2) {
                if (i13 == 3) {
                    i12 = R.string.ib_feature_rq_status_planned;
                } else if (i13 == 4) {
                    i12 = R.string.ib_feature_rq_status_open;
                } else if (i13 == 5) {
                    textView.setText(R.string.ib_feature_rq_status_maybe_later);
                    i11 = R.color.ib_fr_color_maybe_later;
                } else {
                    return;
                }
                textView.setText(i12);
                i11 = R.color.ib_fr_color_planned;
            } else {
                textView.setText(R.string.ib_feature_rq_status_inprogress);
                i11 = R.color.ib_fr_color_in_progress;
            }
            a(str, textView, context, i11);
        }
    }

    private static void a(String str, TextView textView, Context context, @ColorRes int i11) {
        b.a(textView, str != null ? Color.parseColor(str) : ContextCompat.getColor(context, i11));
    }
}
