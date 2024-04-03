package androidx.media;

import android.os.Bundle;
import androidx.annotation.NonNull;
import java.util.Arrays;
import org.tukaani.xz.LZMA2Options;

class AudioAttributesImplBase implements AudioAttributesImpl {

    /* renamed from: a  reason: collision with root package name */
    public int f36179a;

    /* renamed from: b  reason: collision with root package name */
    public int f36180b;

    /* renamed from: c  reason: collision with root package name */
    public int f36181c;

    /* renamed from: d  reason: collision with root package name */
    public int f36182d;

    public AudioAttributesImplBase() {
        this.f36179a = 0;
        this.f36180b = 0;
        this.f36181c = 0;
        this.f36182d = -1;
    }

    public static AudioAttributesImpl fromBundle(Bundle bundle) {
        if (bundle == null) {
            return null;
        }
        return new AudioAttributesImplBase(bundle.getInt("androidx.media.audio_attrs.CONTENT_TYPE", 0), bundle.getInt("androidx.media.audio_attrs.FLAGS", 0), bundle.getInt("androidx.media.audio_attrs.USAGE", 0), bundle.getInt("androidx.media.audio_attrs.LEGACY_STREAM_TYPE", -1));
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof AudioAttributesImplBase)) {
            return false;
        }
        AudioAttributesImplBase audioAttributesImplBase = (AudioAttributesImplBase) obj;
        if (this.f36180b == audioAttributesImplBase.getContentType() && this.f36181c == audioAttributesImplBase.getFlags() && this.f36179a == audioAttributesImplBase.getUsage() && this.f36182d == audioAttributesImplBase.f36182d) {
            return true;
        }
        return false;
    }

    public Object getAudioAttributes() {
        return null;
    }

    public int getContentType() {
        return this.f36180b;
    }

    public int getFlags() {
        int i11 = this.f36181c;
        int legacyStreamType = getLegacyStreamType();
        if (legacyStreamType == 6) {
            i11 |= 4;
        } else if (legacyStreamType == 7) {
            i11 |= 1;
        }
        return i11 & LZMA2Options.NICE_LEN_MAX;
    }

    public int getLegacyStreamType() {
        int i11 = this.f36182d;
        if (i11 != -1) {
            return i11;
        }
        return AudioAttributesCompat.a(false, this.f36181c, this.f36179a);
    }

    public int getRawLegacyStreamType() {
        return this.f36182d;
    }

    public int getUsage() {
        return this.f36179a;
    }

    public int getVolumeControlStream() {
        return AudioAttributesCompat.a(true, this.f36181c, this.f36179a);
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(this.f36180b), Integer.valueOf(this.f36181c), Integer.valueOf(this.f36179a), Integer.valueOf(this.f36182d)});
    }

    @NonNull
    public Bundle toBundle() {
        Bundle bundle = new Bundle();
        bundle.putInt("androidx.media.audio_attrs.USAGE", this.f36179a);
        bundle.putInt("androidx.media.audio_attrs.CONTENT_TYPE", this.f36180b);
        bundle.putInt("androidx.media.audio_attrs.FLAGS", this.f36181c);
        int i11 = this.f36182d;
        if (i11 != -1) {
            bundle.putInt("androidx.media.audio_attrs.LEGACY_STREAM_TYPE", i11);
        }
        return bundle;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder("AudioAttributesCompat:");
        if (this.f36182d != -1) {
            sb2.append(" stream=");
            sb2.append(this.f36182d);
            sb2.append(" derived");
        }
        sb2.append(" usage=");
        sb2.append(AudioAttributesCompat.c(this.f36179a));
        sb2.append(" content=");
        sb2.append(this.f36180b);
        sb2.append(" flags=0x");
        sb2.append(Integer.toHexString(this.f36181c).toUpperCase());
        return sb2.toString();
    }

    public AudioAttributesImplBase(int i11, int i12, int i13, int i14) {
        this.f36180b = i11;
        this.f36181c = i12;
        this.f36179a = i13;
        this.f36182d = i14;
    }
}
