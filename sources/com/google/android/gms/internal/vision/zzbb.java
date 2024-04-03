package com.google.android.gms.internal.vision;

import android.net.Uri;
import androidx.annotation.GuardedBy;
import androidx.collection.ArrayMap;

public final class zzbb {
    @GuardedBy("PhenotypeConstants.class")
    private static final ArrayMap<String, Uri> zzfu = new ArrayMap<>();

    public static synchronized Uri getContentProviderUri(String str) {
        Uri uri;
        String str2;
        synchronized (zzbb.class) {
            ArrayMap<String, Uri> arrayMap = zzfu;
            uri = arrayMap.get(str);
            if (uri == null) {
                String valueOf = String.valueOf(Uri.encode(str));
                if (valueOf.length() != 0) {
                    str2 = "content://com.google.android.gms.phenotype/".concat(valueOf);
                } else {
                    str2 = new String("content://com.google.android.gms.phenotype/");
                }
                uri = Uri.parse(str2);
                arrayMap.put(str, uri);
            }
        }
        return uri;
    }
}
