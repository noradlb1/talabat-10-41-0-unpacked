package com.google.android.gms.internal.places;

import java.io.IOException;

public class zzbk extends IOException {
    private zzck zzje = null;

    public zzbk(String str) {
        super(str);
    }

    public static zzbk zzbp() {
        return new zzbk("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
    }

    public static zzbk zzbq() {
        return new zzbk("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
    }

    public static zzbk zzbr() {
        return new zzbk("Protocol message contained an invalid tag (zero).");
    }

    public static zzbj zzbs() {
        return new zzbj("Protocol message tag had invalid wire type.");
    }

    public static zzbk zzbt() {
        return new zzbk("Failed to parse the message.");
    }

    public static zzbk zzbu() {
        return new zzbk("Protocol message had invalid UTF-8.");
    }

    public final zzbk zzh(zzck zzck) {
        this.zzje = zzck;
        return this;
    }
}
