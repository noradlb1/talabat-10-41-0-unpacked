package androidx.media;

import androidx.annotation.RestrictTo;
import androidx.versionedparcelable.VersionedParcel;

@RestrictTo({RestrictTo.Scope.LIBRARY})
public final class AudioAttributesCompatParcelizer {
    public static AudioAttributesCompat read(VersionedParcel versionedParcel) {
        AudioAttributesCompat audioAttributesCompat = new AudioAttributesCompat();
        audioAttributesCompat.f36175a = (AudioAttributesImpl) versionedParcel.readVersionedParcelable(audioAttributesCompat.f36175a, 1);
        return audioAttributesCompat;
    }

    public static void write(AudioAttributesCompat audioAttributesCompat, VersionedParcel versionedParcel) {
        versionedParcel.setSerializationFlags(false, false);
        versionedParcel.writeVersionedParcelable(audioAttributesCompat.f36175a, 1);
    }
}
