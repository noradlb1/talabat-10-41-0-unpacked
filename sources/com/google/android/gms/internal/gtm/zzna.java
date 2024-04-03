package com.google.android.gms.internal.gtm;

import android.content.Context;
import java.io.IOException;
import java.io.InputStream;

final class zzna implements zzne {
    private final /* synthetic */ Context val$context;

    public zzna(Context context) {
        this.val$context = context;
    }

    public final InputStream open(String str) throws IOException {
        return this.val$context.getAssets().open(str);
    }
}
