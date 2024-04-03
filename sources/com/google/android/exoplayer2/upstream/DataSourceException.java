package com.google.android.exoplayer2.upstream;

import androidx.annotation.Nullable;
import java.io.IOException;

public class DataSourceException extends IOException {
    @Deprecated
    public static final int POSITION_OUT_OF_RANGE = 2008;
    public final int reason;

    public DataSourceException(int i11) {
        this.reason = i11;
    }

    public static boolean isCausedByPositionOutOfRange(IOException iOException) {
        Throwable th2;
        while (th2 != null) {
            if ((th2 instanceof DataSourceException) && ((DataSourceException) th2).reason == 2008) {
                return true;
            }
            Throwable cause = th2.getCause();
            th2 = iOException;
            th2 = cause;
        }
        return false;
    }

    public DataSourceException(@Nullable Throwable th2, int i11) {
        super(th2);
        this.reason = i11;
    }

    public DataSourceException(@Nullable String str, int i11) {
        super(str);
        this.reason = i11;
    }

    public DataSourceException(@Nullable String str, @Nullable Throwable th2, int i11) {
        super(str, th2);
        this.reason = i11;
    }
}
