package com.google.android.gms.internal.clearcut;

import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.clearcut.ClearcutLogger;
import com.google.android.gms.clearcut.zze;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BaseImplementation;

final class zzh extends BaseImplementation.ApiMethodImpl<Status, zzj> {
    private final zze zzao;

    public zzh(zze zze, GoogleApiClient googleApiClient) {
        super((Api<?>) ClearcutLogger.API, googleApiClient);
        this.zzao = zze;
    }

    public final /* synthetic */ Result createFailedResult(Status status) {
        return status;
    }

    public final /* synthetic */ void doExecute(Api.AnyClient anyClient) throws RemoteException {
        zzj zzj = (zzj) anyClient;
        zzi zzi = new zzi(this);
        try {
            zze zze = this.zzao;
            ClearcutLogger.zzb zzb = zze.zzt;
            if (zzb != null) {
                zzha zzha = zze.zzaa;
                if (zzha.zzbjp.length == 0) {
                    zzha.zzbjp = zzb.zza();
                }
            }
            ClearcutLogger.zzb zzb2 = zze.zzan;
            if (zzb2 != null) {
                zzha zzha2 = zze.zzaa;
                if (zzha2.zzbjw.length == 0) {
                    zzha2.zzbjw = zzb2.zza();
                }
            }
            zzha zzha3 = zze.zzaa;
            int zzas = zzha3.zzas();
            byte[] bArr = new byte[zzas];
            zzfz.zza(zzha3, bArr, 0, zzas);
            zze.zzah = bArr;
            ((zzn) zzj.getService()).zza(zzi, this.zzao);
        } catch (RuntimeException e11) {
            Log.e("ClearcutLoggerApiImpl", "derived ClearcutLogger.MessageProducer ", e11);
            setFailedResult(new Status(10, "MessageProducer"));
        }
    }
}
