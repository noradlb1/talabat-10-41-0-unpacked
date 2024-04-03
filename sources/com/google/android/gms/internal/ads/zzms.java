package com.google.android.gms.internal.ads;

import com.google.common.base.Ascii;
import java.nio.ByteBuffer;

final class zzms extends zzme {
    private static final int zzd = Float.floatToIntBits(Float.NaN);

    private static void zzo(int i11, ByteBuffer byteBuffer) {
        int floatToIntBits = Float.floatToIntBits((float) (((double) i11) * 4.656612875245797E-10d));
        if (floatToIntBits == zzd) {
            floatToIntBits = Float.floatToIntBits(0.0f);
        }
        byteBuffer.putInt(floatToIntBits);
    }

    public final void zze(ByteBuffer byteBuffer) {
        ByteBuffer byteBuffer2;
        int position = byteBuffer.position();
        int limit = byteBuffer.limit();
        int i11 = limit - position;
        int i12 = this.zzb.zzd;
        if (i12 == 536870912) {
            byteBuffer2 = zzj((i11 / 3) * 4);
            while (position < limit) {
                zzo(((byteBuffer.get(position) & 255) << 8) | ((byteBuffer.get(position + 1) & 255) << Ascii.DLE) | ((byteBuffer.get(position + 2) & 255) << Ascii.CAN), byteBuffer2);
                position += 3;
            }
        } else if (i12 == 805306368) {
            byteBuffer2 = zzj(i11);
            while (position < limit) {
                zzo((byteBuffer.get(position) & 255) | ((byteBuffer.get(position + 1) & 255) << 8) | ((byteBuffer.get(position + 2) & 255) << Ascii.DLE) | ((byteBuffer.get(position + 3) & 255) << Ascii.CAN), byteBuffer2);
                position += 4;
            }
        } else {
            throw new IllegalStateException();
        }
        byteBuffer.position(byteBuffer.limit());
        byteBuffer2.flip();
    }

    public final zzlf zzi(zzlf zzlf) throws zzlg {
        int i11 = zzlf.zzd;
        if (!zzfn.zzQ(i11)) {
            throw new zzlg(zzlf);
        } else if (i11 != 4) {
            return new zzlf(zzlf.zzb, zzlf.zzc, 4);
        } else {
            return zzlf.zza;
        }
    }
}
