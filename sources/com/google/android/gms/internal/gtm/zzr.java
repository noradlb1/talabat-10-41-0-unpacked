package com.google.android.gms.internal.gtm;

import android.text.TextUtils;
import com.google.android.gms.analytics.zzi;
import com.google.android.gms.common.internal.ShowFirstParty;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.HashMap;

@ShowFirstParty
public final class zzr extends zzi<zzr> {

    /* renamed from: name  reason: collision with root package name */
    private String f35102name;
    private String zzno;
    private String zztz;
    private String zzua;
    private String zzub;
    private String zzuc;
    private String zzud;
    private String zzue;
    private String zzuf;
    private String zzug;

    public final String getId() {
        return this.zzno;
    }

    public final String getName() {
        return this.f35102name;
    }

    public final String getSource() {
        return this.zztz;
    }

    public final void setName(String str) {
        this.f35102name = str;
    }

    public final String toString() {
        HashMap hashMap = new HashMap();
        hashMap.put("name", this.f35102name);
        hashMap.put("source", this.zztz);
        hashMap.put("medium", this.zzua);
        hashMap.put("keyword", this.zzub);
        hashMap.put("content", this.zzuc);
        hashMap.put("id", this.zzno);
        hashMap.put("adNetworkId", this.zzud);
        hashMap.put("gclid", this.zzue);
        hashMap.put("dclid", this.zzuf);
        hashMap.put(FirebaseAnalytics.Param.ACLID, this.zzug);
        return zzi.zza((Object) hashMap);
    }

    public final /* synthetic */ void zzb(zzi zzi) {
        zzr zzr = (zzr) zzi;
        if (!TextUtils.isEmpty(this.f35102name)) {
            zzr.f35102name = this.f35102name;
        }
        if (!TextUtils.isEmpty(this.zztz)) {
            zzr.zztz = this.zztz;
        }
        if (!TextUtils.isEmpty(this.zzua)) {
            zzr.zzua = this.zzua;
        }
        if (!TextUtils.isEmpty(this.zzub)) {
            zzr.zzub = this.zzub;
        }
        if (!TextUtils.isEmpty(this.zzuc)) {
            zzr.zzuc = this.zzuc;
        }
        if (!TextUtils.isEmpty(this.zzno)) {
            zzr.zzno = this.zzno;
        }
        if (!TextUtils.isEmpty(this.zzud)) {
            zzr.zzud = this.zzud;
        }
        if (!TextUtils.isEmpty(this.zzue)) {
            zzr.zzue = this.zzue;
        }
        if (!TextUtils.isEmpty(this.zzuf)) {
            zzr.zzuf = this.zzuf;
        }
        if (!TextUtils.isEmpty(this.zzug)) {
            zzr.zzug = this.zzug;
        }
    }

    public final String zzbd() {
        return this.zzua;
    }

    public final String zzbe() {
        return this.zzub;
    }

    public final String zzbf() {
        return this.zzuc;
    }

    public final String zzbg() {
        return this.zzud;
    }

    public final String zzbh() {
        return this.zzue;
    }

    public final String zzbi() {
        return this.zzuf;
    }

    public final String zzbj() {
        return this.zzug;
    }

    public final void zzc(String str) {
        this.zztz = str;
    }

    public final void zzd(String str) {
        this.zzua = str;
    }

    public final void zze(String str) {
        this.zzub = str;
    }

    public final void zzf(String str) {
        this.zzuc = str;
    }

    public final void zzg(String str) {
        this.zzno = str;
    }

    public final void zzh(String str) {
        this.zzud = str;
    }

    public final void zzi(String str) {
        this.zzue = str;
    }

    public final void zzj(String str) {
        this.zzuf = str;
    }

    public final void zzk(String str) {
        this.zzug = str;
    }
}
