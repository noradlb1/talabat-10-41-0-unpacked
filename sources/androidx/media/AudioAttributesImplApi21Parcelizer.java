package androidx.media;

import android.media.AudioAttributes;
import androidx.annotation.RestrictTo;
import androidx.versionedparcelable.VersionedParcel;

@RestrictTo({RestrictTo.Scope.LIBRARY})
public final class AudioAttributesImplApi21Parcelizer {
    public static AudioAttributesImplApi21 read(VersionedParcel versionedParcel) {
        AudioAttributesImplApi21 audioAttributesImplApi21 = new AudioAttributesImplApi21();
        audioAttributesImplApi21.f36177a = (AudioAttributes) versionedParcel.readParcelable(audioAttributesImplApi21.f36177a, 1);
        audioAttributesImplApi21.f36178b = versionedParcel.readInt(audioAttributesImplApi21.f36178b, 2);
        return audioAttributesImplApi21;
    }

    public static void write(AudioAttributesImplApi21 audioAttributesImplApi21, VersionedParcel versionedParcel) {
        versionedParcel.setSerializationFlags(false, false);
        versionedParcel.writeParcelable(audioAttributesImplApi21.f36177a, 1);
        versionedParcel.writeInt(audioAttributesImplApi21.f36178b, 2);
    }
}
