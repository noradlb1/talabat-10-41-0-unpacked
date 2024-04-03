package com.google.android.gms.ads.formats;

import android.view.View;
import androidx.annotation.RecentlyNonNull;
import com.google.android.gms.ads.VideoController;
import com.google.android.gms.ads.formats.NativeAd;
import java.util.List;

@Deprecated
public interface NativeCustomTemplateAd {
    @RecentlyNonNull
    public static final String ASSET_NAME_VIDEO = "_videoMediaView";

    public interface DisplayOpenMeasurement {
        void setView(@RecentlyNonNull View view);

        boolean start();
    }

    public interface OnCustomClickListener {
        void onCustomClick(@RecentlyNonNull NativeCustomTemplateAd nativeCustomTemplateAd, @RecentlyNonNull String str);
    }

    public interface OnCustomTemplateAdLoadedListener {
        void onCustomTemplateAdLoaded(@RecentlyNonNull NativeCustomTemplateAd nativeCustomTemplateAd);
    }

    void destroy();

    @RecentlyNonNull
    List<String> getAvailableAssetNames();

    @RecentlyNonNull
    String getCustomTemplateId();

    @RecentlyNonNull
    DisplayOpenMeasurement getDisplayOpenMeasurement();

    @RecentlyNonNull
    NativeAd.Image getImage(@RecentlyNonNull String str);

    @RecentlyNonNull
    CharSequence getText(@RecentlyNonNull String str);

    @RecentlyNonNull
    VideoController getVideoController();

    @RecentlyNonNull
    MediaView getVideoMediaView();

    void performClick(@RecentlyNonNull String str);

    void recordImpression();
}
