package com.google.android.gms.internal.ads;

import android.media.AudioManager;
import android.os.Handler;

final class zzfu implements AudioManager.OnAudioFocusChangeListener {
    final /* synthetic */ zzfw zza;
    private final Handler zzb;

    public zzfu(zzfw zzfw, Handler handler) {
        this.zza = zzfw;
        this.zzb = handler;
    }

    public final void onAudioFocusChange(int i11) {
        this.zzb.post(new zzft(this, i11));
    }
}
