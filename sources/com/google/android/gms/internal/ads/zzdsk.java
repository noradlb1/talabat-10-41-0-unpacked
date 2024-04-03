package com.google.android.gms.internal.ads;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Looper;
import com.google.android.gms.ads.internal.util.zzbs;
import com.google.android.gms.ads.internal.util.zze;
import com.google.android.gms.common.util.Clock;
import com.newrelic.agent.android.instrumentation.BitmapFactoryInstrumentation;
import com.newrelic.agent.android.instrumentation.Instrumented;
import java.util.concurrent.Executor;

@Instrumented
public final class zzdsk {
    private final zzbs zza;
    private final Clock zzb;
    private final Executor zzc;

    public zzdsk(zzbs zzbs, Clock clock, Executor executor) {
        this.zza = zzbs;
        this.zzb = clock;
        this.zzc = executor;
    }

    public static /* bridge */ /* synthetic */ Bitmap zza(zzdsk zzdsk, byte[] bArr, double d11, boolean z11) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inDensity = (int) (d11 * 160.0d);
        if (!z11) {
            options.inPreferredConfig = Bitmap.Config.RGB_565;
        }
        if (((Boolean) zzbgq.zzc().zzb(zzblj.zzeB)).booleanValue()) {
            options.inJustDecodeBounds = true;
            zzdsk.zzc(bArr, options);
            options.inJustDecodeBounds = false;
            int i11 = options.outWidth * options.outHeight;
            if (i11 > 0) {
                options.inSampleSize = 1 << ((33 - Integer.numberOfLeadingZeros((i11 - 1) / ((Integer) zzbgq.zzc().zzb(zzblj.zzeC)).intValue())) / 2);
            }
        }
        return zzdsk.zzc(bArr, options);
    }

    private final Bitmap zzc(byte[] bArr, BitmapFactory.Options options) {
        long elapsedRealtime = this.zzb.elapsedRealtime();
        boolean z11 = false;
        Bitmap decodeByteArray = BitmapFactoryInstrumentation.decodeByteArray(bArr, 0, bArr.length, options);
        long elapsedRealtime2 = this.zzb.elapsedRealtime();
        if (decodeByteArray != null) {
            int width = decodeByteArray.getWidth();
            int height = decodeByteArray.getHeight();
            int allocationByteCount = decodeByteArray.getAllocationByteCount();
            long j11 = elapsedRealtime2 - elapsedRealtime;
            if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
                z11 = true;
            }
            StringBuilder sb2 = new StringBuilder(108);
            sb2.append("Decoded image w: ");
            sb2.append(width);
            sb2.append(" h:");
            sb2.append(height);
            sb2.append(" bytes: ");
            sb2.append(allocationByteCount);
            sb2.append(" time: ");
            sb2.append(j11);
            sb2.append(" on ui thread: ");
            sb2.append(z11);
            zze.zza(sb2.toString());
        }
        return decodeByteArray;
    }

    public final zzfxa<Bitmap> zzb(String str, double d11, boolean z11) {
        return zzfwq.zzm(this.zza.zza(str), new zzdsj(this, d11, z11), this.zzc);
    }
}
