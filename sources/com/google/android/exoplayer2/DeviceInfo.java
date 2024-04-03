package com.google.android.exoplayer2;

import android.os.Bundle;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.Bundleable;
import com.google.android.exoplayer2.util.Util;
import g7.h;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

public final class DeviceInfo implements Bundleable {
    public static final Bundleable.Creator<DeviceInfo> CREATOR = new h();
    private static final String FIELD_MAX_VOLUME = Util.intToStringMaxRadix(2);
    private static final String FIELD_MIN_VOLUME = Util.intToStringMaxRadix(1);
    private static final String FIELD_PLAYBACK_TYPE = Util.intToStringMaxRadix(0);
    public static final int PLAYBACK_TYPE_LOCAL = 0;
    public static final int PLAYBACK_TYPE_REMOTE = 1;
    public static final DeviceInfo UNKNOWN = new DeviceInfo(0, 0, 0);
    public final int maxVolume;
    public final int minVolume;
    public final int playbackType;

    @Documented
    @Target({ElementType.TYPE_USE})
    @Retention(RetentionPolicy.SOURCE)
    public @interface PlaybackType {
    }

    public DeviceInfo(int i11, int i12, int i13) {
        this.playbackType = i11;
        this.minVolume = i12;
        this.maxVolume = i13;
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ DeviceInfo lambda$static$0(Bundle bundle) {
        return new DeviceInfo(bundle.getInt(FIELD_PLAYBACK_TYPE, 0), bundle.getInt(FIELD_MIN_VOLUME, 0), bundle.getInt(FIELD_MAX_VOLUME, 0));
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof DeviceInfo)) {
            return false;
        }
        DeviceInfo deviceInfo = (DeviceInfo) obj;
        if (this.playbackType == deviceInfo.playbackType && this.minVolume == deviceInfo.minVolume && this.maxVolume == deviceInfo.maxVolume) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return ((((527 + this.playbackType) * 31) + this.minVolume) * 31) + this.maxVolume;
    }

    public Bundle toBundle() {
        Bundle bundle = new Bundle();
        bundle.putInt(FIELD_PLAYBACK_TYPE, this.playbackType);
        bundle.putInt(FIELD_MIN_VOLUME, this.minVolume);
        bundle.putInt(FIELD_MAX_VOLUME, this.maxVolume);
        return bundle;
    }
}
