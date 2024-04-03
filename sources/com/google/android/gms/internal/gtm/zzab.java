package com.google.android.gms.internal.gtm;

import android.text.TextUtils;
import com.facebook.internal.NativeProtocol;
import com.google.android.gms.analytics.zzi;
import com.google.android.gms.common.internal.ShowFirstParty;
import com.instabug.library.core.eventbus.coreeventbus.SDKCoreEvent;
import java.util.HashMap;

@ShowFirstParty
public final class zzab extends zzi<zzab> {
    public String zzvh;
    public String zzvi;
    public String zzvj;

    public final String toString() {
        HashMap hashMap = new HashMap();
        hashMap.put(SDKCoreEvent.Network.TYPE_NETWORK, this.zzvh);
        hashMap.put(NativeProtocol.WEB_DIALOG_ACTION, this.zzvi);
        hashMap.put("target", this.zzvj);
        return zzi.zza((Object) hashMap);
    }

    public final /* synthetic */ void zzb(zzi zzi) {
        zzab zzab = (zzab) zzi;
        if (!TextUtils.isEmpty(this.zzvh)) {
            zzab.zzvh = this.zzvh;
        }
        if (!TextUtils.isEmpty(this.zzvi)) {
            zzab.zzvi = this.zzvi;
        }
        if (!TextUtils.isEmpty(this.zzvj)) {
            zzab.zzvj = this.zzvj;
        }
    }
}
