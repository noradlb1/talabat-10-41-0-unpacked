package com.google.android.gms.internal.gtm;

final class zzsh {
    private static final zzsf zzbcu = zzqk();
    private static final zzsf zzbcv = new zzsg();

    public static zzsf zzqi() {
        return zzbcu;
    }

    public static zzsf zzqj() {
        return zzbcv;
    }

    private static zzsf zzqk() {
        try {
            return (zzsf) Class.forName("com.google.protobuf.MapFieldSchemaFull").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception unused) {
            return null;
        }
    }
}
