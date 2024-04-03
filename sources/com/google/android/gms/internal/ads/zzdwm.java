package com.google.android.gms.internal.ads;

import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import com.google.android.gms.ads.internal.util.zzaw;
import java.util.ArrayList;

public final class zzdwm extends FrameLayout {
    private final zzaw zza;

    public zzdwm(Context context, @NonNull View view, @NonNull zzaw zzaw) {
        super(context);
        setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        addView(view);
        this.zza = zzaw;
    }

    public final boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        this.zza.zzm(motionEvent);
        return false;
    }

    public final void removeAllViews() {
        ArrayList arrayList = new ArrayList();
        for (int i11 = 0; i11 < getChildCount(); i11++) {
            View childAt = getChildAt(i11);
            if (childAt != null && (childAt instanceof zzcop)) {
                arrayList.add((zzcop) childAt);
            }
        }
        super.removeAllViews();
        int size = arrayList.size();
        for (int i12 = 0; i12 < size; i12++) {
            ((zzcop) arrayList.get(i12)).destroy();
        }
    }
}
