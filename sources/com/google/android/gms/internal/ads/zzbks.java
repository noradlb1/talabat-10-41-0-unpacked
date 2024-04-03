package com.google.android.gms.internal.ads;

import android.os.Environment;
import java.util.concurrent.Callable;

final class zzbks implements Callable<Boolean> {
    public final /* bridge */ /* synthetic */ Object call() throws Exception {
        return Boolean.valueOf("mounted".equals(Environment.getExternalStorageState()));
    }
}
