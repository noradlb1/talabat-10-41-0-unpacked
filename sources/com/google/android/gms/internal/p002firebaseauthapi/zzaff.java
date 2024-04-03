package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.internal.p002firebaseauthapi.zzafe;
import com.google.android.gms.internal.p002firebaseauthapi.zzaff;
import java.io.IOException;
import java.io.OutputStream;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzaff  reason: invalid package */
public abstract class zzaff<MessageType extends zzaff<MessageType, BuilderType>, BuilderType extends zzafe<MessageType, BuilderType>> implements zzaif {
    protected int zza = 0;

    public int zzn(zzair zzair) {
        throw null;
    }

    public final zzafv zzo() {
        try {
            int zzs = zzs();
            zzafv zzafv = zzafv.zzb;
            byte[] bArr = new byte[zzs];
            zzagi zzC = zzagi.zzC(bArr, 0, zzs);
            zzJ(zzC);
            zzC.zzD();
            return new zzafs(bArr);
        } catch (IOException e11) {
            String name2 = getClass().getName();
            throw new RuntimeException("Serializing " + name2 + " to a ByteString threw an IOException (should never happen).", e11);
        }
    }

    public final void zzp(OutputStream outputStream) throws IOException {
        int zzs = zzs();
        int i11 = zzagi.zzf;
        if (zzs > 4096) {
            zzs = 4096;
        }
        zzagg zzagg = new zzagg(outputStream, zzs);
        zzJ(zzagg);
        zzagg.zzI();
    }

    public final byte[] zzq() {
        try {
            int zzs = zzs();
            byte[] bArr = new byte[zzs];
            zzagi zzC = zzagi.zzC(bArr, 0, zzs);
            zzJ(zzC);
            zzC.zzD();
            return bArr;
        } catch (IOException e11) {
            String name2 = getClass().getName();
            throw new RuntimeException("Serializing " + name2 + " to a byte array threw an IOException (should never happen).", e11);
        }
    }
}
