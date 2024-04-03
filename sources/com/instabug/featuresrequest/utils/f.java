package com.instabug.featuresrequest.utils;

import android.annotation.SuppressLint;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.ListView;
import androidx.annotation.Nullable;

public abstract class f {
    @SuppressLint({"ERADICATE_PARAMETER_NOT_NULLABLE"})
    public static void a(@Nullable ListView listView) {
        ListAdapter adapter;
        if (listView != null && (adapter = listView.getAdapter()) != null) {
            int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(listView.getWidth(), Integer.MIN_VALUE);
            int i11 = 0;
            for (int i12 = 0; i12 < adapter.getCount(); i12++) {
                View view = adapter.getView(i12, (View) null, listView);
                if (view != null) {
                    view.measure(makeMeasureSpec, View.MeasureSpec.makeMeasureSpec(0, 0));
                    i11 += view.getMeasuredHeight();
                }
            }
            ViewGroup.LayoutParams layoutParams = listView.getLayoutParams();
            layoutParams.height = i11 + (listView.getDividerHeight() * (adapter.getCount() - 1));
            listView.setLayoutParams(layoutParams);
            listView.requestLayout();
        }
    }
}
