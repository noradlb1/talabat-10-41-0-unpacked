package com.google.android.gms.internal.places;

final class zzcu {
    private static final zzcs zzlj = zzcp();
    private static final zzcs zzlk = new zzcr();

    public static zzcs zzcn() {
        return zzlj;
    }

    public static zzcs zzco() {
        return zzlk;
    }

    private static zzcs zzcp() {
        try {
            return (zzcs) Class.forName("com.google.protobuf.NewInstanceSchemaFull").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception unused) {
            return null;
        }
    }
}
