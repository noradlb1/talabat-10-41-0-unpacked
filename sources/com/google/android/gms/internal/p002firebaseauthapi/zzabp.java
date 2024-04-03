package com.google.android.gms.internal.p002firebaseauthapi;

import android.app.Activity;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.Preconditions;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.PhoneAuthProvider;
import com.google.firebase.auth.internal.zzao;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzabp  reason: invalid package */
abstract class zzabp implements zzabr {
    @VisibleForTesting
    Object zzA;
    @VisibleForTesting
    Status zzB;
    /* access modifiers changed from: private */
    public boolean zza;
    protected final int zze;
    protected final zzabm zzf = new zzabm(this);
    protected FirebaseApp zzg;
    protected FirebaseUser zzh;
    protected Object zzi;
    protected zzao zzj;
    protected zzabf zzk;
    protected final List zzl = new ArrayList();
    protected Executor zzm;
    protected zzadr zzn;
    protected zzadi zzo;
    protected zzacs zzp;
    protected zzaea zzq;
    protected String zzr;
    protected String zzs;
    protected AuthCredential zzt;
    protected String zzu;
    protected String zzv;
    protected zzwv zzw;
    protected zzadq zzx;
    protected zzadn zzy;
    protected zzaei zzz;

    public zzabp(int i11) {
        this.zze = i11;
    }

    public static /* bridge */ /* synthetic */ void zzj(zzabp zzabp) {
        zzabp.zzb();
        Preconditions.checkState(zzabp.zza, "no success or failure set on method implementation");
    }

    public static /* bridge */ /* synthetic */ void zzk(zzabp zzabp, Status status) {
        zzao zzao = zzabp.zzj;
        if (zzao != null) {
            zzao.zzb(status);
        }
    }

    public abstract void zzb();

    public final zzabp zzd(Object obj) {
        this.zzi = Preconditions.checkNotNull(obj, "external callback cannot be null");
        return this;
    }

    public final zzabp zze(zzao zzao) {
        this.zzj = (zzao) Preconditions.checkNotNull(zzao, "external failure callback cannot be null");
        return this;
    }

    public final zzabp zzf(FirebaseApp firebaseApp) {
        this.zzg = (FirebaseApp) Preconditions.checkNotNull(firebaseApp, "firebaseApp cannot be null");
        return this;
    }

    public final zzabp zzg(FirebaseUser firebaseUser) {
        this.zzh = (FirebaseUser) Preconditions.checkNotNull(firebaseUser, "firebaseUser cannot be null");
        return this;
    }

    public final zzabp zzh(PhoneAuthProvider.OnVerificationStateChangedCallbacks onVerificationStateChangedCallbacks, @Nullable Activity activity, Executor executor, String str) {
        PhoneAuthProvider.OnVerificationStateChangedCallbacks zza2 = zzacd.zza(str, onVerificationStateChangedCallbacks, this);
        synchronized (this.zzl) {
            this.zzl.add((PhoneAuthProvider.OnVerificationStateChangedCallbacks) Preconditions.checkNotNull(zza2));
        }
        if (activity != null) {
            zzabg.zza(activity, this.zzl);
        }
        this.zzm = (Executor) Preconditions.checkNotNull(executor);
        return this;
    }

    public final void zzl(Status status) {
        this.zza = true;
        this.zzB = status;
        this.zzk.zza((Object) null, status);
    }

    public final void zzm(Object obj) {
        this.zza = true;
        this.zzA = obj;
        this.zzk.zza(obj, (Status) null);
    }
}
