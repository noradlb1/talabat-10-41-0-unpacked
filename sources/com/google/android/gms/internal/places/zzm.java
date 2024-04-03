package com.google.android.gms.internal.places;

import com.google.android.gms.internal.places.zzm;
import com.google.android.gms.internal.places.zzo;
import java.io.IOException;

public abstract class zzm<MessageType extends zzm<MessageType, BuilderType>, BuilderType extends zzo<MessageType, BuilderType>> implements zzck {
    private static boolean zzdu = false;
    protected int zzdt = 0;

    /* access modifiers changed from: package-private */
    public void zze(int i11) {
        throw new UnsupportedOperationException();
    }

    public final zzw zzv() {
        try {
            zzae zzk = zzw.zzk(zzbh());
            zzc(zzk.zzai());
            return zzk.zzah();
        } catch (IOException e11) {
            String name2 = getClass().getName();
            StringBuilder sb2 = new StringBuilder(name2.length() + 62 + "ByteString".length());
            sb2.append("Serializing ");
            sb2.append(name2);
            sb2.append(" to a ");
            sb2.append("ByteString");
            sb2.append(" threw an IOException (should never happen).");
            throw new RuntimeException(sb2.toString(), e11);
        }
    }

    /* access modifiers changed from: package-private */
    public int zzw() {
        throw new UnsupportedOperationException();
    }
}
