package com.google.android.gms.internal.ads;

import android.os.ParcelFileDescriptor;
import java.io.InputStream;

public final /* synthetic */ class zzeeu implements zzfvx {
    public final /* synthetic */ zzefh zza;

    public /* synthetic */ zzeeu(zzefh zzefh) {
        this.zza = zzefh;
    }

    public final zzfxa zza(Object obj) {
        ParcelFileDescriptor[] createPipe = ParcelFileDescriptor.createPipe();
        ParcelFileDescriptor parcelFileDescriptor = createPipe[0];
        zzcjm.zza.execute(new zzfex((InputStream) obj, createPipe[1]));
        return zzfwq.zzi(parcelFileDescriptor);
    }
}
