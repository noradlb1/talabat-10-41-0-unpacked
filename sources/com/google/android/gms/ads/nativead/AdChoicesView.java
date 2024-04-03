package com.google.android.gms.ads.nativead;

import android.annotation.TargetApi;
import android.content.Context;
import android.util.AttributeSet;
import android.widget.RelativeLayout;
import androidx.annotation.RecentlyNonNull;

public class AdChoicesView extends RelativeLayout {
    public AdChoicesView(@RecentlyNonNull Context context) {
        super(context);
    }

    public AdChoicesView(@RecentlyNonNull Context context, @RecentlyNonNull AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public AdChoicesView(@RecentlyNonNull Context context, @RecentlyNonNull AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
    }

    @TargetApi(21)
    public AdChoicesView(@RecentlyNonNull Context context, @RecentlyNonNull AttributeSet attributeSet, int i11, int i12) {
        super(context, attributeSet, i11, i12);
    }
}
