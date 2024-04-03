package com.google.android.gms.internal.clearcut;

import com.google.android.gms.internal.clearcut.zzas;
import com.google.android.gms.internal.clearcut.zzat;
import java.io.IOException;

public abstract class zzas<MessageType extends zzas<MessageType, BuilderType>, BuilderType extends zzat<MessageType, BuilderType>> implements zzdo {
    private static boolean zzey = false;
    protected int zzex = 0;

    /* access modifiers changed from: package-private */
    public void zzf(int i11) {
        throw new UnsupportedOperationException();
    }

    public final zzbb zzr() {
        try {
            zzbg zzk = zzbb.zzk(zzas());
            zzb(zzk.zzae());
            return zzk.zzad();
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
    public int zzs() {
        throw new UnsupportedOperationException();
    }
}
