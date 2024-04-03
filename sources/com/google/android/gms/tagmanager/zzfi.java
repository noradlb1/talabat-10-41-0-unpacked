package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.gtm.zzot;
import com.google.android.gms.internal.gtm.zzox;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

final class zzfi {
    private final Set<zzox> zzajx = new HashSet();
    private final Map<zzox, List<zzot>> zzakh = new HashMap();
    private final Map<zzox, List<zzot>> zzaki = new HashMap();
    private final Map<zzox, List<String>> zzakj = new HashMap();
    private final Map<zzox, List<String>> zzakk = new HashMap();
    private zzot zzakl;

    public final void zza(zzox zzox) {
        this.zzajx.add(zzox);
    }

    public final void zzb(zzox zzox, zzot zzot) {
        List list = this.zzaki.get(zzox);
        if (list == null) {
            list = new ArrayList();
            this.zzaki.put(zzox, list);
        }
        list.add(zzot);
    }

    public final Set<zzox> zzjj() {
        return this.zzajx;
    }

    public final Map<zzox, List<zzot>> zzjk() {
        return this.zzakh;
    }

    public final Map<zzox, List<String>> zzjl() {
        return this.zzakj;
    }

    public final Map<zzox, List<String>> zzjm() {
        return this.zzakk;
    }

    public final Map<zzox, List<zzot>> zzjn() {
        return this.zzaki;
    }

    public final zzot zzjo() {
        return this.zzakl;
    }

    public final void zza(zzox zzox, zzot zzot) {
        List list = this.zzakh.get(zzox);
        if (list == null) {
            list = new ArrayList();
            this.zzakh.put(zzox, list);
        }
        list.add(zzot);
    }

    public final void zzb(zzox zzox, String str) {
        List list = this.zzakk.get(zzox);
        if (list == null) {
            list = new ArrayList();
            this.zzakk.put(zzox, list);
        }
        list.add(str);
    }

    public final void zza(zzox zzox, String str) {
        List list = this.zzakj.get(zzox);
        if (list == null) {
            list = new ArrayList();
            this.zzakj.put(zzox, list);
        }
        list.add(str);
    }

    public final void zzb(zzot zzot) {
        this.zzakl = zzot;
    }
}
