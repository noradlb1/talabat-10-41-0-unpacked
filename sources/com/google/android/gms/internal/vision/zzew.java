package com.google.android.gms.internal.vision;

import com.google.android.gms.internal.vision.zzet;
import com.google.android.gms.internal.vision.zzew;
import java.io.IOException;

public abstract class zzew<MessageType extends zzet<MessageType, BuilderType>, BuilderType extends zzew<MessageType, BuilderType>> implements zzib {
    public abstract BuilderType zza(MessageType messagetype);

    public abstract BuilderType zza(zzft zzft, zzgd zzgd) throws IOException;

    public BuilderType zza(byte[] bArr, int i11, int i12, zzgd zzgd) throws zzhc {
        try {
            zzft zza = zzft.zza(bArr, 0, i12, false);
            zza(zza, zzgd);
            zza.zzaq(0);
            return this;
        } catch (zzhc e11) {
            throw e11;
        } catch (IOException e12) {
            String name2 = getClass().getName();
            StringBuilder sb2 = new StringBuilder(name2.length() + 60 + "byte array".length());
            sb2.append("Reading ");
            sb2.append(name2);
            sb2.append(" from a ");
            sb2.append("byte array");
            sb2.append(" threw an IOException (should never happen).");
            throw new RuntimeException(sb2.toString(), e12);
        }
    }

    /* renamed from: zzdn */
    public abstract BuilderType clone();

    public final /* synthetic */ zzib zza(zzic zzic) {
        if (zzgd().getClass().isInstance(zzic)) {
            return zza((zzet) zzic);
        }
        throw new IllegalArgumentException("mergeFrom(MessageLite) can only merge messages of the same type.");
    }
}
