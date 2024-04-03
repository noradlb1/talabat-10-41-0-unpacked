package androidx.media;

import androidx.annotation.RestrictTo;
import androidx.versionedparcelable.VersionedParcel;

@RestrictTo({RestrictTo.Scope.LIBRARY})
public final class AudioAttributesImplBaseParcelizer {
    public static AudioAttributesImplBase read(VersionedParcel versionedParcel) {
        AudioAttributesImplBase audioAttributesImplBase = new AudioAttributesImplBase();
        audioAttributesImplBase.f36179a = versionedParcel.readInt(audioAttributesImplBase.f36179a, 1);
        audioAttributesImplBase.f36180b = versionedParcel.readInt(audioAttributesImplBase.f36180b, 2);
        audioAttributesImplBase.f36181c = versionedParcel.readInt(audioAttributesImplBase.f36181c, 3);
        audioAttributesImplBase.f36182d = versionedParcel.readInt(audioAttributesImplBase.f36182d, 4);
        return audioAttributesImplBase;
    }

    public static void write(AudioAttributesImplBase audioAttributesImplBase, VersionedParcel versionedParcel) {
        versionedParcel.setSerializationFlags(false, false);
        versionedParcel.writeInt(audioAttributesImplBase.f36179a, 1);
        versionedParcel.writeInt(audioAttributesImplBase.f36180b, 2);
        versionedParcel.writeInt(audioAttributesImplBase.f36181c, 3);
        versionedParcel.writeInt(audioAttributesImplBase.f36182d, 4);
    }
}
