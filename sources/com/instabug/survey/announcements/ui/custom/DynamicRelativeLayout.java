package com.instabug.survey.announcements.ui.custom;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.widget.RelativeLayout;
import com.instabug.library.util.DisplayUtils;
import com.instabug.survey.common.f;
import com.instabug.survey.ui.n;

public class DynamicRelativeLayout extends RelativeLayout {

    /* renamed from: a  reason: collision with root package name */
    private boolean f52285a;

    public DynamicRelativeLayout(Context context) {
        super(context);
    }

    public DynamicRelativeLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public DynamicRelativeLayout(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
    }

    private int getStatusBarHeight() {
        int identifier = getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (identifier > 0) {
            return getResources().getDimensionPixelSize(identifier);
        }
        return 0;
    }

    public boolean a() {
        return this.f52285a;
    }

    public void onSizeChanged(int i11, int i12, int i13, int i14) {
        if (getContext() instanceof Activity) {
            Activity activity = (Activity) getContext();
            if (i12 == f.a(activity, n.SECONDARY) || i12 == DisplayUtils.getDisplayHeightInPx(activity) - getStatusBarHeight()) {
                this.f52285a = true;
            }
        }
    }
}
