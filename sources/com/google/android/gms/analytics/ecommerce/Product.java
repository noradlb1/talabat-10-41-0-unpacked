package com.google.android.gms.analytics.ecommerce;

import com.google.android.gms.analytics.zzd;
import com.google.android.gms.analytics.zzi;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.VisibleForTesting;
import java.util.HashMap;
import java.util.Map;

@VisibleForTesting
public class Product {
    private Map<String, String> zzvn = new HashMap();

    private final void put(String str, String str2) {
        Preconditions.checkNotNull(str, "Name should be non-null");
        this.zzvn.put(str, str2);
    }

    public Product setBrand(String str) {
        put("br", str);
        return this;
    }

    public Product setCategory(String str) {
        put("ca", str);
        return this;
    }

    public Product setCouponCode(String str) {
        put("cc", str);
        return this;
    }

    public Product setCustomDimension(int i11, String str) {
        put(zzd.zzo(i11), str);
        return this;
    }

    public Product setCustomMetric(int i11, int i12) {
        put(zzd.zzp(i11), Integer.toString(i12));
        return this;
    }

    public Product setId(String str) {
        put("id", str);
        return this;
    }

    public Product setName(String str) {
        put("nm", str);
        return this;
    }

    public Product setPosition(int i11) {
        put("ps", Integer.toString(i11));
        return this;
    }

    public Product setPrice(double d11) {
        put("pr", Double.toString(d11));
        return this;
    }

    public Product setQuantity(int i11) {
        put("qt", Integer.toString(i11));
        return this;
    }

    public Product setVariant(String str) {
        put("va", str);
        return this;
    }

    public String toString() {
        return zzi.zza((Map) this.zzvn);
    }

    public final Map<String, String> zzn(String str) {
        String str2;
        HashMap hashMap = new HashMap();
        for (Map.Entry next : this.zzvn.entrySet()) {
            String valueOf = String.valueOf(str);
            String valueOf2 = String.valueOf((String) next.getKey());
            if (valueOf2.length() != 0) {
                str2 = valueOf.concat(valueOf2);
            } else {
                str2 = new String(valueOf);
            }
            hashMap.put(str2, (String) next.getValue());
        }
        return hashMap;
    }
}
