package androidx.media;

import android.annotation.TargetApi;
import android.media.AudioAttributes;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import androidx.annotation.NonNull;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

@TargetApi(21)
class AudioAttributesImplApi21 implements AudioAttributesImpl {
    private static final String TAG = "AudioAttributesCompat21";

    /* renamed from: c  reason: collision with root package name */
    public static Method f36176c;

    /* renamed from: a  reason: collision with root package name */
    public AudioAttributes f36177a;

    /* renamed from: b  reason: collision with root package name */
    public int f36178b;

    public AudioAttributesImplApi21() {
        this.f36178b = -1;
    }

    public static Method a() {
        Class<AudioAttributes> cls = AudioAttributes.class;
        try {
            if (f36176c == null) {
                f36176c = cls.getMethod("toLegacyStreamType", new Class[]{cls});
            }
            return f36176c;
        } catch (NoSuchMethodException unused) {
            return null;
        }
    }

    public static AudioAttributesImpl fromBundle(Bundle bundle) {
        AudioAttributes audioAttributes;
        if (bundle == null || (audioAttributes = (AudioAttributes) bundle.getParcelable("androidx.media.audio_attrs.FRAMEWORKS")) == null) {
            return null;
        }
        return new AudioAttributesImplApi21(audioAttributes, bundle.getInt("androidx.media.audio_attrs.LEGACY_STREAM_TYPE", -1));
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof AudioAttributesImplApi21)) {
            return false;
        }
        return this.f36177a.equals(((AudioAttributesImplApi21) obj).f36177a);
    }

    public Object getAudioAttributes() {
        return this.f36177a;
    }

    public int getContentType() {
        return this.f36177a.getContentType();
    }

    public int getFlags() {
        return this.f36177a.getFlags();
    }

    public int getLegacyStreamType() {
        int i11 = this.f36178b;
        if (i11 != -1) {
            return i11;
        }
        Method a11 = a();
        if (a11 == null) {
            Log.w(TAG, "No AudioAttributes#toLegacyStreamType() on API: " + Build.VERSION.SDK_INT);
            return -1;
        }
        try {
            return ((Integer) a11.invoke((Object) null, new Object[]{this.f36177a})).intValue();
        } catch (IllegalAccessException | InvocationTargetException e11) {
            Log.w(TAG, "getLegacyStreamType() failed on API: " + Build.VERSION.SDK_INT, e11);
            return -1;
        }
    }

    public int getRawLegacyStreamType() {
        return this.f36178b;
    }

    public int getUsage() {
        return this.f36177a.getUsage();
    }

    public int getVolumeControlStream() {
        if (Build.VERSION.SDK_INT >= 26) {
            return this.f36177a.getVolumeControlStream();
        }
        return AudioAttributesCompat.a(true, getFlags(), getUsage());
    }

    public int hashCode() {
        return this.f36177a.hashCode();
    }

    @NonNull
    public Bundle toBundle() {
        Bundle bundle = new Bundle();
        bundle.putParcelable("androidx.media.audio_attrs.FRAMEWORKS", this.f36177a);
        int i11 = this.f36178b;
        if (i11 != -1) {
            bundle.putInt("androidx.media.audio_attrs.LEGACY_STREAM_TYPE", i11);
        }
        return bundle;
    }

    public String toString() {
        return "AudioAttributesCompat: audioattributes=" + this.f36177a;
    }

    public AudioAttributesImplApi21(AudioAttributes audioAttributes) {
        this(audioAttributes, -1);
    }

    public AudioAttributesImplApi21(AudioAttributes audioAttributes, int i11) {
        this.f36177a = audioAttributes;
        this.f36178b = i11;
    }
}
