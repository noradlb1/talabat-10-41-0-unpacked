package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.Nullable;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.OnPaidEventListener;
import com.google.android.gms.ads.ResponseInfo;
import com.google.android.gms.ads.VideoController;
import com.google.android.gms.ads.VideoOptions;
import com.google.android.gms.ads.admanager.AppEventListener;
import com.google.android.gms.ads.zza;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.util.concurrent.atomic.AtomicBoolean;
import org.checkerframework.checker.initialization.qual.NotOnlyInitialized;

public final class zzbji {
    @VisibleForTesting
    final zzbgp zza;
    private final zzbxe zzb;
    private final zzbfh zzc;
    private final AtomicBoolean zzd;
    /* access modifiers changed from: private */
    public final VideoController zze;
    @Nullable
    private zzbes zzf;
    private AdListener zzg;
    private AdSize[] zzh;
    @Nullable
    private AppEventListener zzi;
    @Nullable
    private zzbhk zzj;
    private VideoOptions zzk;
    private String zzl;
    @NotOnlyInitialized
    private final ViewGroup zzm;
    private int zzn;
    private boolean zzo;
    @Nullable
    private OnPaidEventListener zzp;

    public zzbji(ViewGroup viewGroup) {
        this(viewGroup, (AttributeSet) null, false, zzbfh.zza, (zzbhk) null, 0);
    }

    private static zzbfi zzB(Context context, AdSize[] adSizeArr, int i11) {
        for (AdSize equals : adSizeArr) {
            if (equals.equals(AdSize.INVALID)) {
                return zzbfi.zze();
            }
        }
        zzbfi zzbfi = new zzbfi(context, adSizeArr);
        zzbfi.zzj = zzC(i11);
        return zzbfi;
    }

    private static boolean zzC(int i11) {
        return i11 == 1;
    }

    public final AdSize[] zzA() {
        return this.zzh;
    }

    public final AdListener zza() {
        return this.zzg;
    }

    @Nullable
    public final AdSize zzb() {
        zzbfi zzg2;
        try {
            zzbhk zzbhk = this.zzj;
            if (!(zzbhk == null || (zzg2 = zzbhk.zzg()) == null)) {
                return zza.zzc(zzg2.zze, zzg2.zzb, zzg2.zza);
            }
        } catch (RemoteException e11) {
            zzciz.zzl("#007 Could not call remote method.", e11);
        }
        AdSize[] adSizeArr = this.zzh;
        if (adSizeArr != null) {
            return adSizeArr[0];
        }
        return null;
    }

    @Nullable
    public final OnPaidEventListener zzc() {
        return this.zzp;
    }

    @Nullable
    public final ResponseInfo zzd() {
        zzbiw zzbiw = null;
        try {
            zzbhk zzbhk = this.zzj;
            if (zzbhk != null) {
                zzbiw = zzbhk.zzk();
            }
        } catch (RemoteException e11) {
            zzciz.zzl("#007 Could not call remote method.", e11);
        }
        return ResponseInfo.zza(zzbiw);
    }

    public final VideoController zzf() {
        return this.zze;
    }

    public final VideoOptions zzg() {
        return this.zzk;
    }

    @Nullable
    public final AppEventListener zzh() {
        return this.zzi;
    }

    @Nullable
    public final zzbiz zzi() {
        zzbhk zzbhk = this.zzj;
        if (zzbhk != null) {
            try {
                return zzbhk.zzl();
            } catch (RemoteException e11) {
                zzciz.zzl("#007 Could not call remote method.", e11);
            }
        }
        return null;
    }

    public final String zzj() {
        zzbhk zzbhk;
        if (this.zzl == null && (zzbhk = this.zzj) != null) {
            try {
                this.zzl = zzbhk.zzr();
            } catch (RemoteException e11) {
                zzciz.zzl("#007 Could not call remote method.", e11);
            }
        }
        return this.zzl;
    }

    public final void zzk() {
        try {
            zzbhk zzbhk = this.zzj;
            if (zzbhk != null) {
                zzbhk.zzx();
            }
        } catch (RemoteException e11) {
            zzciz.zzl("#007 Could not call remote method.", e11);
        }
    }

    public final void zzl(zzbjg zzbjg) {
        zzbhk zzbhk;
        try {
            if (this.zzj == null) {
                if (this.zzh == null || this.zzl == null) {
                    throw new IllegalStateException("The ad size and ad unit ID must be set before loadAd is called.");
                }
                Context context = this.zzm.getContext();
                zzbfi zzB = zzB(context, this.zzh, this.zzn);
                if ("search_v2".equals(zzB.zza)) {
                    zzbhk = (zzbhk) new zzbgb(zzbgo.zza(), context, zzB, this.zzl).zzd(context, false);
                } else {
                    zzbhk = (zzbhk) new zzbfz(zzbgo.zza(), context, zzB, this.zzl, this.zzb).zzd(context, false);
                }
                this.zzj = zzbhk;
                zzbhk.zzD(new zzbey(this.zza));
                zzbes zzbes = this.zzf;
                if (zzbes != null) {
                    this.zzj.zzC(new zzbet(zzbes));
                }
                AppEventListener appEventListener = this.zzi;
                if (appEventListener != null) {
                    this.zzj.zzG(new zzayo(appEventListener));
                }
                VideoOptions videoOptions = this.zzk;
                if (videoOptions != null) {
                    this.zzj.zzU(new zzbkq(videoOptions));
                }
                this.zzj.zzP(new zzbkj(this.zzp));
                this.zzj.zzN(this.zzo);
                zzbhk zzbhk2 = this.zzj;
                if (zzbhk2 != null) {
                    try {
                        IObjectWrapper zzn2 = zzbhk2.zzn();
                        if (zzn2 != null) {
                            this.zzm.addView((View) ObjectWrapper.unwrap(zzn2));
                        }
                    } catch (RemoteException e11) {
                        zzciz.zzl("#007 Could not call remote method.", e11);
                    }
                }
            }
            zzbhk zzbhk3 = this.zzj;
            zzbhk3.getClass();
            if (zzbhk3.zzaa(this.zzc.zza(this.zzm.getContext(), zzbjg))) {
                this.zzb.zzd(zzbjg.zzr());
            }
        } catch (RemoteException e12) {
            zzciz.zzl("#007 Could not call remote method.", e12);
        }
    }

    public final void zzm() {
        try {
            zzbhk zzbhk = this.zzj;
            if (zzbhk != null) {
                zzbhk.zzz();
            }
        } catch (RemoteException e11) {
            zzciz.zzl("#007 Could not call remote method.", e11);
        }
    }

    public final void zzn() {
        if (!this.zzd.getAndSet(true)) {
            try {
                zzbhk zzbhk = this.zzj;
                if (zzbhk != null) {
                    zzbhk.zzA();
                }
            } catch (RemoteException e11) {
                zzciz.zzl("#007 Could not call remote method.", e11);
            }
        }
    }

    public final void zzo() {
        try {
            zzbhk zzbhk = this.zzj;
            if (zzbhk != null) {
                zzbhk.zzB();
            }
        } catch (RemoteException e11) {
            zzciz.zzl("#007 Could not call remote method.", e11);
        }
    }

    public final void zzp(@Nullable zzbes zzbes) {
        zzbet zzbet;
        try {
            this.zzf = zzbes;
            zzbhk zzbhk = this.zzj;
            if (zzbhk != null) {
                if (zzbes != null) {
                    zzbet = new zzbet(zzbes);
                } else {
                    zzbet = null;
                }
                zzbhk.zzC(zzbet);
            }
        } catch (RemoteException e11) {
            zzciz.zzl("#007 Could not call remote method.", e11);
        }
    }

    public final void zzq(AdListener adListener) {
        this.zzg = adListener;
        this.zza.zza(adListener);
    }

    public final void zzr(AdSize... adSizeArr) {
        if (this.zzh == null) {
            zzs(adSizeArr);
            return;
        }
        throw new IllegalStateException("The ad size can only be set once on AdView.");
    }

    public final void zzs(AdSize... adSizeArr) {
        this.zzh = adSizeArr;
        try {
            zzbhk zzbhk = this.zzj;
            if (zzbhk != null) {
                zzbhk.zzF(zzB(this.zzm.getContext(), this.zzh, this.zzn));
            }
        } catch (RemoteException e11) {
            zzciz.zzl("#007 Could not call remote method.", e11);
        }
        this.zzm.requestLayout();
    }

    public final void zzt(String str) {
        if (this.zzl == null) {
            this.zzl = str;
            return;
        }
        throw new IllegalStateException("The ad unit ID can only be set once on AdView.");
    }

    public final void zzu(@Nullable AppEventListener appEventListener) {
        zzayo zzayo;
        try {
            this.zzi = appEventListener;
            zzbhk zzbhk = this.zzj;
            if (zzbhk != null) {
                if (appEventListener != null) {
                    zzayo = new zzayo(appEventListener);
                } else {
                    zzayo = null;
                }
                zzbhk.zzG(zzayo);
            }
        } catch (RemoteException e11) {
            zzciz.zzl("#007 Could not call remote method.", e11);
        }
    }

    public final void zzv(boolean z11) {
        this.zzo = z11;
        try {
            zzbhk zzbhk = this.zzj;
            if (zzbhk != null) {
                zzbhk.zzN(z11);
            }
        } catch (RemoteException e11) {
            zzciz.zzl("#007 Could not call remote method.", e11);
        }
    }

    public final void zzw(@Nullable OnPaidEventListener onPaidEventListener) {
        try {
            this.zzp = onPaidEventListener;
            zzbhk zzbhk = this.zzj;
            if (zzbhk != null) {
                zzbhk.zzP(new zzbkj(onPaidEventListener));
            }
        } catch (RemoteException e11) {
            zzciz.zzl("#008 Must be called on the main UI thread.", e11);
        }
    }

    public final void zzx(VideoOptions videoOptions) {
        zzbkq zzbkq;
        this.zzk = videoOptions;
        try {
            zzbhk zzbhk = this.zzj;
            if (zzbhk != null) {
                if (videoOptions == null) {
                    zzbkq = null;
                } else {
                    zzbkq = new zzbkq(videoOptions);
                }
                zzbhk.zzU(zzbkq);
            }
        } catch (RemoteException e11) {
            zzciz.zzl("#007 Could not call remote method.", e11);
        }
    }

    public final boolean zzy(zzbhk zzbhk) {
        try {
            IObjectWrapper zzn2 = zzbhk.zzn();
            if (zzn2 == null || ((View) ObjectWrapper.unwrap(zzn2)).getParent() != null) {
                return false;
            }
            this.zzm.addView((View) ObjectWrapper.unwrap(zzn2));
            this.zzj = zzbhk;
            return true;
        } catch (RemoteException e11) {
            zzciz.zzl("#007 Could not call remote method.", e11);
            return false;
        }
    }

    public final boolean zzz() {
        try {
            zzbhk zzbhk = this.zzj;
            if (zzbhk != null) {
                return zzbhk.zzY();
            }
            return false;
        } catch (RemoteException e11) {
            zzciz.zzl("#007 Could not call remote method.", e11);
            return false;
        }
    }

    public zzbji(ViewGroup viewGroup, int i11) {
        this(viewGroup, (AttributeSet) null, false, zzbfh.zza, (zzbhk) null, i11);
    }

    public zzbji(ViewGroup viewGroup, AttributeSet attributeSet, boolean z11) {
        this(viewGroup, attributeSet, z11, zzbfh.zza, (zzbhk) null, 0);
    }

    public zzbji(ViewGroup viewGroup, AttributeSet attributeSet, boolean z11, int i11) {
        this(viewGroup, attributeSet, z11, zzbfh.zza, (zzbhk) null, i11);
    }

    @VisibleForTesting
    public zzbji(ViewGroup viewGroup, @Nullable AttributeSet attributeSet, boolean z11, zzbfh zzbfh, @Nullable zzbhk zzbhk, int i11) {
        zzbfi zzbfi;
        this.zzb = new zzbxe();
        this.zze = new VideoController();
        this.zza = new zzbjh(this);
        this.zzm = viewGroup;
        this.zzc = zzbfh;
        this.zzj = null;
        this.zzd = new AtomicBoolean(false);
        this.zzn = i11;
        if (attributeSet != null) {
            Context context = viewGroup.getContext();
            try {
                zzbfq zzbfq = new zzbfq(context, attributeSet);
                this.zzh = zzbfq.zzb(z11);
                this.zzl = zzbfq.zza();
                if (viewGroup.isInEditMode()) {
                    zzcis zzb2 = zzbgo.zzb();
                    AdSize adSize = this.zzh[0];
                    int i12 = this.zzn;
                    if (adSize.equals(AdSize.INVALID)) {
                        zzbfi = zzbfi.zze();
                    } else {
                        zzbfi zzbfi2 = new zzbfi(context, adSize);
                        zzbfi2.zzj = zzC(i12);
                        zzbfi = zzbfi2;
                    }
                    zzb2.zzh(viewGroup, zzbfi, "Ads by Google");
                }
            } catch (IllegalArgumentException e11) {
                zzbgo.zzb().zzg(viewGroup, new zzbfi(context, AdSize.BANNER), e11.getMessage(), e11.getMessage());
            }
        }
    }
}
