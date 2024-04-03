package com.google.android.gms.internal.p002firebaseauthapi;

import java.io.IOException;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzahi  reason: invalid package */
public class zzahi extends IOException {
    private zzaif zza = null;
    private boolean zzb;

    public zzahi(IOException iOException) {
        super(iOException.getMessage(), iOException);
    }

    public static zzahh zza() {
        return new zzahh("Protocol message tag had invalid wire type.");
    }

    public static zzahi zzb() {
        return new zzahi("Protocol message end-group tag did not match expected tag.");
    }

    public static zzahi zzc() {
        return new zzahi("Protocol message contained an invalid tag (zero).");
    }

    public static zzahi zzd() {
        return new zzahi("Protocol message had invalid UTF-8.");
    }

    public static zzahi zze() {
        return new zzahi("CodedInputStream encountered a malformed varint.");
    }

    public static zzahi zzf() {
        return new zzahi("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
    }

    public static zzahi zzg() {
        return new zzahi("Failed to parse the message.");
    }

    public static zzahi zzi() {
        return new zzahi("Protocol message was too large.  May be malicious.  Use CodedInputStream.setSizeLimit() to increase the size limit.");
    }

    public static zzahi zzj() {
        return new zzahi("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
    }

    public final zzahi zzh(zzaif zzaif) {
        this.zza = zzaif;
        return this;
    }

    public final void zzk() {
        this.zzb = true;
    }

    public final boolean zzl() {
        return this.zzb;
    }

    public zzahi(String str) {
        super(str);
    }
}
