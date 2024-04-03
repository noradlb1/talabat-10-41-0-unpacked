package com.google.android.gms.internal.ads;

import android.media.MediaCodec;
import android.media.MediaFormat;
import android.os.Bundle;
import android.view.Surface;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import java.nio.ByteBuffer;

public interface zzof {
    int zza();

    int zzb(MediaCodec.BufferInfo bufferInfo);

    MediaFormat zzc();

    @Nullable
    ByteBuffer zzf(int i11);

    @Nullable
    ByteBuffer zzg(int i11);

    void zzi();

    void zzj(int i11, int i12, int i13, long j11, int i14);

    void zzk(int i11, int i12, zzcx zzcx, long j11, int i13);

    void zzl();

    @RequiresApi(21)
    void zzm(int i11, long j11);

    void zzn(int i11, boolean z11);

    @RequiresApi(23)
    void zzo(Surface surface);

    @RequiresApi(19)
    void zzp(Bundle bundle);

    void zzq(int i11);

    boolean zzr();
}
