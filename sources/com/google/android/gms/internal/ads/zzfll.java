package com.google.android.gms.internal.ads;

import android.view.View;
import android.view.ViewParent;
import java.util.HashMap;
import java.util.HashSet;

public final class zzfll {
    private final HashMap<View, String> zza = new HashMap<>();
    private final HashMap<View, zzflk> zzb = new HashMap<>();
    private final HashMap<String, View> zzc = new HashMap<>();
    private final HashSet<View> zzd = new HashSet<>();
    private final HashSet<String> zze = new HashSet<>();
    private final HashSet<String> zzf = new HashSet<>();
    private final HashMap<String, String> zzg = new HashMap<>();
    private boolean zzh;

    public final View zza(String str) {
        return this.zzc.get(str);
    }

    public final zzflk zzb(View view) {
        zzflk zzflk = this.zzb.get(view);
        if (zzflk != null) {
            this.zzb.remove(view);
        }
        return zzflk;
    }

    public final String zzc(String str) {
        return this.zzg.get(str);
    }

    public final String zzd(View view) {
        if (this.zza.size() == 0) {
            return null;
        }
        String str = this.zza.get(view);
        if (str != null) {
            this.zza.remove(view);
        }
        return str;
    }

    public final HashSet<String> zze() {
        return this.zzf;
    }

    public final HashSet<String> zzf() {
        return this.zze;
    }

    public final void zzg() {
        this.zza.clear();
        this.zzb.clear();
        this.zzc.clear();
        this.zzd.clear();
        this.zze.clear();
        this.zzf.clear();
        this.zzg.clear();
        this.zzh = false;
    }

    public final void zzh() {
        this.zzh = true;
    }

    public final void zzi() {
        String str;
        zzfkp zza2 = zzfkp.zza();
        if (zza2 != null) {
            for (zzfke next : zza2.zzb()) {
                View zzf2 = next.zzf();
                if (next.zzj()) {
                    String zzh2 = next.zzh();
                    if (zzf2 != null) {
                        if (zzf2.hasWindowFocus()) {
                            HashSet hashSet = new HashSet();
                            View view = zzf2;
                            while (true) {
                                if (view == null) {
                                    this.zzd.addAll(hashSet);
                                    str = null;
                                    break;
                                }
                                String zzb2 = zzflj.zzb(view);
                                if (zzb2 != null) {
                                    str = zzb2;
                                    break;
                                }
                                hashSet.add(view);
                                ViewParent parent = view.getParent();
                                if (parent instanceof View) {
                                    view = (View) parent;
                                } else {
                                    view = null;
                                }
                            }
                        } else {
                            str = "noWindowFocus";
                        }
                        if (str == null) {
                            this.zze.add(zzh2);
                            this.zza.put(zzf2, zzh2);
                            for (zzfks next2 : next.zzi()) {
                                View view2 = (View) next2.zzb().get();
                                if (view2 != null) {
                                    zzflk zzflk = this.zzb.get(view2);
                                    if (zzflk != null) {
                                        zzflk.zzc(next.zzh());
                                    } else {
                                        this.zzb.put(view2, new zzflk(next2, next.zzh()));
                                    }
                                }
                            }
                        } else {
                            this.zzf.add(zzh2);
                            this.zzc.put(zzh2, zzf2);
                            this.zzg.put(zzh2, str);
                        }
                    } else {
                        this.zzf.add(zzh2);
                        this.zzg.put(zzh2, "noAdView");
                    }
                }
            }
        }
    }

    public final int zzj(View view) {
        if (this.zzd.contains(view)) {
            return 1;
        }
        return this.zzh ? 2 : 3;
    }
}
