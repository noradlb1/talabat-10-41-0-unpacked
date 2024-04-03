package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.res.TypedArray;
import android.text.TextUtils;
import android.util.AttributeSet;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.R;

public final class zzbfq {
    private final AdSize[] zza;
    private final String zzb;

    public zzbfq(Context context, AttributeSet attributeSet) {
        TypedArray obtainAttributes = context.getResources().obtainAttributes(attributeSet, R.styleable.AdsAttrs);
        String string = obtainAttributes.getString(R.styleable.AdsAttrs_adSize);
        String string2 = obtainAttributes.getString(R.styleable.AdsAttrs_adSizes);
        boolean z11 = !TextUtils.isEmpty(string);
        boolean z12 = !TextUtils.isEmpty(string2);
        if (z11 && !z12) {
            this.zza = zzc(string);
        } else if (!z11 && z12) {
            this.zza = zzc(string2);
        } else if (z11) {
            obtainAttributes.recycle();
            throw new IllegalArgumentException("Either XML attribute \"adSize\" or XML attribute \"supportedAdSizes\" should be specified, but not both.");
        } else {
            obtainAttributes.recycle();
            throw new IllegalArgumentException("Required XML attribute \"adSize\" was missing.");
        }
        String string3 = obtainAttributes.getString(R.styleable.AdsAttrs_adUnitId);
        this.zzb = string3;
        obtainAttributes.recycle();
        if (TextUtils.isEmpty(string3)) {
            throw new IllegalArgumentException("Required XML attribute \"adUnitId\" was missing.");
        }
    }

    private static AdSize[] zzc(String str) {
        String str2;
        String str3;
        String str4;
        int i11;
        int i12;
        String[] split = str.split("\\s*,\\s*");
        int length = split.length;
        AdSize[] adSizeArr = new AdSize[length];
        for (int i13 = 0; i13 < split.length; i13++) {
            String trim = split[i13].trim();
            if (trim.matches("^(\\d+|FULL_WIDTH)\\s*[xX]\\s*(\\d+|AUTO_HEIGHT)$")) {
                String[] split2 = trim.split("[xX]");
                split2[0] = split2[0].trim();
                split2[1] = split2[1].trim();
                try {
                    if ("FULL_WIDTH".equals(split2[0])) {
                        i11 = -1;
                    } else {
                        i11 = Integer.parseInt(split2[0]);
                    }
                    if ("AUTO_HEIGHT".equals(split2[1])) {
                        i12 = -2;
                    } else {
                        i12 = Integer.parseInt(split2[1]);
                    }
                    adSizeArr[i13] = new AdSize(i11, i12);
                } catch (NumberFormatException unused) {
                    if (trim.length() != 0) {
                        str4 = "Could not parse XML attribute \"adSize\": ".concat(trim);
                    } else {
                        str4 = new String("Could not parse XML attribute \"adSize\": ");
                    }
                    throw new IllegalArgumentException(str4);
                }
            } else if ("BANNER".equals(trim)) {
                adSizeArr[i13] = AdSize.BANNER;
            } else if ("LARGE_BANNER".equals(trim)) {
                adSizeArr[i13] = AdSize.LARGE_BANNER;
            } else if ("FULL_BANNER".equals(trim)) {
                adSizeArr[i13] = AdSize.FULL_BANNER;
            } else if ("LEADERBOARD".equals(trim)) {
                adSizeArr[i13] = AdSize.LEADERBOARD;
            } else if ("MEDIUM_RECTANGLE".equals(trim)) {
                adSizeArr[i13] = AdSize.MEDIUM_RECTANGLE;
            } else if ("SMART_BANNER".equals(trim)) {
                adSizeArr[i13] = AdSize.SMART_BANNER;
            } else if ("WIDE_SKYSCRAPER".equals(trim)) {
                adSizeArr[i13] = AdSize.WIDE_SKYSCRAPER;
            } else if ("FLUID".equals(trim)) {
                adSizeArr[i13] = AdSize.FLUID;
            } else if ("ICON".equals(trim)) {
                adSizeArr[i13] = AdSize.zza;
            } else {
                if (trim.length() != 0) {
                    str3 = "Could not parse XML attribute \"adSize\": ".concat(trim);
                } else {
                    str3 = new String("Could not parse XML attribute \"adSize\": ");
                }
                throw new IllegalArgumentException(str3);
            }
        }
        if (length != 0) {
            return adSizeArr;
        }
        if (str.length() != 0) {
            str2 = "Could not parse XML attribute \"adSize\": ".concat(str);
        } else {
            str2 = new String("Could not parse XML attribute \"adSize\": ");
        }
        throw new IllegalArgumentException(str2);
    }

    public final String zza() {
        return this.zzb;
    }

    public final AdSize[] zzb(boolean z11) {
        if (z11 || this.zza.length == 1) {
            return this.zza;
        }
        throw new IllegalArgumentException("The adSizes XML attribute is only allowed on PublisherAdViews.");
    }
}
