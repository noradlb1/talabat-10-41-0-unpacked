package com.google.android.gms.ads.formats;

import android.annotation.TargetApi;
import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.annotation.RecentlyNonNull;
import com.google.android.gms.ads.MediaContent;

@Deprecated
public class MediaView extends FrameLayout {
    private MediaContent zza;
    private ImageView.ScaleType zzb;

    public MediaView(@RecentlyNonNull Context context) {
        super(context);
    }

    public void setImageScaleType(@RecentlyNonNull ImageView.ScaleType scaleType) {
        this.zzb = scaleType;
    }

    public void setMediaContent(@RecentlyNonNull MediaContent mediaContent) {
        this.zza = mediaContent;
    }

    public MediaView(@RecentlyNonNull Context context, @RecentlyNonNull AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public MediaView(@RecentlyNonNull Context context, @RecentlyNonNull AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
    }

    @TargetApi(21)
    public MediaView(@RecentlyNonNull Context context, @RecentlyNonNull AttributeSet attributeSet, int i11, int i12) {
        super(context, attributeSet, i11, i12);
    }
}
