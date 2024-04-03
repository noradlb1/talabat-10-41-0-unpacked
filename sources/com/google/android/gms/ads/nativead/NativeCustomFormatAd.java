package com.google.android.gms.ads.nativead;

import android.view.View;
import androidx.annotation.RecentlyNonNull;
import androidx.annotation.RecentlyNullable;
import com.google.android.gms.ads.VideoController;
import com.google.android.gms.ads.nativead.NativeAd;
import java.util.List;

public interface NativeCustomFormatAd {
    @RecentlyNonNull
    public static final String ASSET_NAME_VIDEO = "_videoMediaView";

    public interface DisplayOpenMeasurement {
        void setView(@RecentlyNonNull View view);

        boolean start();
    }

    public interface OnCustomClickListener {
        void onCustomClick(@RecentlyNonNull NativeCustomFormatAd nativeCustomFormatAd, @RecentlyNonNull String str);
    }

    public interface OnCustomFormatAdLoadedListener {
        void onCustomFormatAdLoaded(@RecentlyNonNull NativeCustomFormatAd nativeCustomFormatAd);
    }

    void destroy();

    @RecentlyNullable
    List<String> getAvailableAssetNames();

    @RecentlyNullable
    String getCustomFormatId();

    @RecentlyNonNull
    DisplayOpenMeasurement getDisplayOpenMeasurement();

    @RecentlyNullable
    NativeAd.Image getImage(@RecentlyNonNull String str);

    @RecentlyNullable
    CharSequence getText(@RecentlyNonNull String str);

    @RecentlyNonNull
    VideoController getVideoController();

    @RecentlyNullable
    MediaView getVideoMediaView();

    void performClick(@RecentlyNonNull String str);

    void recordImpression();
}
