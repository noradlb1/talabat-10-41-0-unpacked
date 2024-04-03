package com.google.android.gms.internal.ads;

import android.system.ErrnoException;
import android.system.OsConstants;
import androidx.annotation.DoNotInline;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

@RequiresApi(21)
final class zztr {
    /* access modifiers changed from: private */
    @DoNotInline
    public static boolean zzb(@Nullable Throwable th2) {
        return (th2 instanceof ErrnoException) && ((ErrnoException) th2).errno == OsConstants.EACCES;
    }
}
