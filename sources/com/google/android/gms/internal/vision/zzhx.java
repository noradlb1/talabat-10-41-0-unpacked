package com.google.android.gms.internal.vision;

final class zzhx {
    private static final zzhv zzyq = zzhh();
    private static final zzhv zzyr = new zzhy();

    public static zzhv zzhf() {
        return zzyq;
    }

    public static zzhv zzhg() {
        return zzyr;
    }

    private static zzhv zzhh() {
        try {
            return (zzhv) Class.forName("com.google.protobuf.MapFieldSchemaFull").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception unused) {
            return null;
        }
    }
}
