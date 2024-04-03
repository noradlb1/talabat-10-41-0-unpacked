package com.google.android.libraries.places.internal;

import com.google.android.datatransport.Transformer;
import java.io.IOException;

public final /* synthetic */ class zzdi implements Transformer {
    public static final /* synthetic */ zzdi zza = new zzdi();

    private /* synthetic */ zzdi() {
    }

    public final Object apply(Object obj) {
        zzjr zzjr = (zzjr) obj;
        try {
            byte[] bArr = new byte[zzjr.zzv()];
            zzabf zzC = zzabf.zzC(bArr);
            zzjr.zzH(zzC);
            zzC.zzD();
            return bArr;
        } catch (IOException e11) {
            String name2 = zzjr.getClass().getName();
            StringBuilder sb2 = new StringBuilder(name2.length() + 72);
            sb2.append("Serializing ");
            sb2.append(name2);
            sb2.append(" to a byte array threw an IOException (should never happen).");
            throw new RuntimeException(sb2.toString(), e11);
        }
    }
}
