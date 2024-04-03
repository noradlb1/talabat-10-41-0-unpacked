package com.google.android.gms.internal.gtm;

import com.google.android.gms.internal.gtm.zzpl;
import com.google.android.gms.internal.gtm.zzpm;
import java.io.IOException;

public abstract class zzpl<MessageType extends zzpl<MessageType, BuilderType>, BuilderType extends zzpm<MessageType, BuilderType>> implements zzsk {
    private static boolean zzavq = false;
    protected int zzavp = 0;

    public void zzag(int i11) {
        throw new UnsupportedOperationException();
    }

    public final zzps zzmv() {
        try {
            zzqa zzam = zzps.zzam(zzpe());
            zzb(zzam.zznh());
            return zzam.zzng();
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

    public int zzmw() {
        throw new UnsupportedOperationException();
    }
}
