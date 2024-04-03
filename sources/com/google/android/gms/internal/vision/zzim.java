package com.google.android.gms.internal.vision;

final class zzim {
    private static final zzik zzzl = zzhn();
    private static final zzik zzzm = new zzij();

    public static zzik zzhl() {
        return zzzl;
    }

    public static zzik zzhm() {
        return zzzm;
    }

    private static zzik zzhn() {
        try {
            return (zzik) Class.forName("com.google.protobuf.NewInstanceSchemaFull").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception unused) {
            return null;
        }
    }
}
