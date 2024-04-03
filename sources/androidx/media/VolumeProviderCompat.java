package androidx.media;

import androidx.annotation.RestrictTo;
import androidx.media.VolumeProviderCompatApi21;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public abstract class VolumeProviderCompat {
    public static final int VOLUME_CONTROL_ABSOLUTE = 2;
    public static final int VOLUME_CONTROL_FIXED = 0;
    public static final int VOLUME_CONTROL_RELATIVE = 1;
    private Callback mCallback;
    private final int mControlType;
    private int mCurrentVolume;
    private final int mMaxVolume;
    private Object mVolumeProviderObj;

    public static abstract class Callback {
        public abstract void onVolumeChanged(VolumeProviderCompat volumeProviderCompat);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    @Retention(RetentionPolicy.SOURCE)
    public @interface ControlType {
    }

    public VolumeProviderCompat(int i11, int i12, int i13) {
        this.mControlType = i11;
        this.mMaxVolume = i12;
        this.mCurrentVolume = i13;
    }

    public final int getCurrentVolume() {
        return this.mCurrentVolume;
    }

    public final int getMaxVolume() {
        return this.mMaxVolume;
    }

    public final int getVolumeControl() {
        return this.mControlType;
    }

    public Object getVolumeProvider() {
        if (this.mVolumeProviderObj == null) {
            this.mVolumeProviderObj = VolumeProviderCompatApi21.createVolumeProvider(this.mControlType, this.mMaxVolume, this.mCurrentVolume, new VolumeProviderCompatApi21.Delegate() {
                public void onAdjustVolume(int i11) {
                    VolumeProviderCompat.this.onAdjustVolume(i11);
                }

                public void onSetVolumeTo(int i11) {
                    VolumeProviderCompat.this.onSetVolumeTo(i11);
                }
            });
        }
        return this.mVolumeProviderObj;
    }

    public void onAdjustVolume(int i11) {
    }

    public void onSetVolumeTo(int i11) {
    }

    public void setCallback(Callback callback) {
        this.mCallback = callback;
    }

    public final void setCurrentVolume(int i11) {
        this.mCurrentVolume = i11;
        Object volumeProvider = getVolumeProvider();
        if (volumeProvider != null) {
            VolumeProviderCompatApi21.setCurrentVolume(volumeProvider, i11);
        }
        Callback callback = this.mCallback;
        if (callback != null) {
            callback.onVolumeChanged(this);
        }
    }
}
