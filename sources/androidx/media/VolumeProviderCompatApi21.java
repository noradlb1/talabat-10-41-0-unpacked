package androidx.media;

import android.media.VolumeProvider;
import androidx.annotation.RequiresApi;

@RequiresApi(21)
class VolumeProviderCompatApi21 {

    public interface Delegate {
        void onAdjustVolume(int i11);

        void onSetVolumeTo(int i11);
    }

    private VolumeProviderCompatApi21() {
    }

    public static Object createVolumeProvider(int i11, int i12, int i13, final Delegate delegate) {
        return new VolumeProvider(i11, i12, i13) {
            public void onAdjustVolume(int i11) {
                delegate.onAdjustVolume(i11);
            }

            public void onSetVolumeTo(int i11) {
                delegate.onSetVolumeTo(i11);
            }
        };
    }

    public static void setCurrentVolume(Object obj, int i11) {
        ((VolumeProvider) obj).setCurrentVolume(i11);
    }
}
