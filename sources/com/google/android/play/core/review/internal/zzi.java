package com.google.android.play.core.review.internal;

import android.os.Process;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.Nullable;
import java.util.IllegalFormatException;
import java.util.Locale;
import org.junit.jupiter.api.IndicativeSentencesGeneration;

public final class zzi {
    private final String zza;

    public zzi(String str) {
        int myUid = Process.myUid();
        int myPid = Process.myPid();
        this.zza = ("UID: [" + myUid + "]  PID: [" + myPid + "] ").concat(str);
    }

    private static String zzf(String str, String str2, @Nullable Object... objArr) {
        if (objArr.length > 0) {
            try {
                str2 = String.format(Locale.US, str2, objArr);
            } catch (IllegalFormatException e11) {
                Log.e("PlayCore", "Unable to format ".concat(str2), e11);
                str2 = str2 + " [" + TextUtils.join(IndicativeSentencesGeneration.DEFAULT_SEPARATOR, objArr) + "]";
            }
        }
        return str + " : " + str2;
    }

    public final int zza(String str, @Nullable Object... objArr) {
        if (Log.isLoggable("PlayCore", 3)) {
            return Log.d("PlayCore", zzf(this.zza, "Already connected to the service.", objArr));
        }
        return 0;
    }

    public final int zzb(String str, @Nullable Object... objArr) {
        if (Log.isLoggable("PlayCore", 6)) {
            return Log.e("PlayCore", zzf(this.zza, "Play Store app is either not installed or not the official version", objArr));
        }
        return 0;
    }

    public final int zzc(Throwable th2, String str, @Nullable Object... objArr) {
        if (Log.isLoggable("PlayCore", 6)) {
            return Log.e("PlayCore", zzf(this.zza, str, objArr), th2);
        }
        return 0;
    }

    public final int zzd(String str, @Nullable Object... objArr) {
        if (Log.isLoggable("PlayCore", 4)) {
            return Log.i("PlayCore", zzf(this.zza, str, objArr));
        }
        return 0;
    }

    public final int zze(String str, @Nullable Object... objArr) {
        if (Log.isLoggable("PlayCore", 5)) {
            return Log.w("PlayCore", zzf(this.zza, "Phonesky package is not signed -- possibly self-built package. Could not verify.", objArr));
        }
        return 0;
    }
}
