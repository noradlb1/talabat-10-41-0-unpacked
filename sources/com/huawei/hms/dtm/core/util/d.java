package com.huawei.hms.dtm.core.util;

import android.view.View;
import java.util.Comparator;

public class d implements Comparator<View> {
    /* renamed from: a */
    public int compare(View view, View view2) {
        return view.getLeft() - view2.getLeft();
    }
}
