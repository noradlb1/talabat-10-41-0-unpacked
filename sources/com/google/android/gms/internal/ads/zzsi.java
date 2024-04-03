package com.google.android.gms.internal.ads;

import android.content.Context;
import android.util.SparseArray;
import android.util.SparseBooleanArray;
import androidx.annotation.Nullable;
import java.util.Map;

public final class zzsi extends zzcn {
    public static final zzsi zzB;
    @Deprecated
    public static final zzsi zzC;
    public static final zzj<zzsi> zzD = zzsg.zza;
    public final int zzE;
    public final boolean zzF;
    public final boolean zzG;
    public final boolean zzH;
    public final boolean zzI;
    public final boolean zzJ;
    public final boolean zzK;
    public final boolean zzL;
    public final boolean zzM;
    public final boolean zzN;
    public final boolean zzO;
    /* access modifiers changed from: private */
    public final SparseArray<Map<zzch, zzsm>> zzP;
    /* access modifiers changed from: private */
    public final SparseBooleanArray zzQ;

    static {
        zzsi zzsi = new zzsi(new zzsk());
        zzB = zzsi;
        zzC = zzsi;
    }

    private zzsi(zzsk zzsk) {
        super(zzsk);
        this.zzF = zzsk.zza;
        this.zzG = false;
        this.zzH = zzsk.zzb;
        this.zzI = zzsk.zzc;
        this.zzJ = false;
        this.zzK = false;
        this.zzL = false;
        this.zzE = 0;
        this.zzM = zzsk.zzd;
        this.zzN = false;
        this.zzO = zzsk.zze;
        this.zzP = zzsk.zzf;
        this.zzQ = zzsk.zzg;
    }

    public static zzsi zzc(Context context) {
        return new zzsi(new zzsk(context));
    }

    public final boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && zzsi.class == obj.getClass()) {
            zzsi zzsi = (zzsi) obj;
            if (super.equals(zzsi) && this.zzF == zzsi.zzF && this.zzH == zzsi.zzH && this.zzI == zzsi.zzI && this.zzM == zzsi.zzM && this.zzO == zzsi.zzO) {
                SparseBooleanArray sparseBooleanArray = this.zzQ;
                SparseBooleanArray sparseBooleanArray2 = zzsi.zzQ;
                int size = sparseBooleanArray.size();
                if (sparseBooleanArray2.size() == size) {
                    int i11 = 0;
                    while (true) {
                        if (i11 >= size) {
                            SparseArray<Map<zzch, zzsm>> sparseArray = this.zzP;
                            SparseArray<Map<zzch, zzsm>> sparseArray2 = zzsi.zzP;
                            int size2 = sparseArray.size();
                            if (sparseArray2.size() == size2) {
                                int i12 = 0;
                                while (i12 < size2) {
                                    int indexOfKey = sparseArray2.indexOfKey(sparseArray.keyAt(i12));
                                    if (indexOfKey >= 0) {
                                        Map valueAt = sparseArray.valueAt(i12);
                                        Map valueAt2 = sparseArray2.valueAt(indexOfKey);
                                        if (valueAt2.size() == valueAt.size()) {
                                            for (Map.Entry entry : valueAt.entrySet()) {
                                                zzch zzch = (zzch) entry.getKey();
                                                if (valueAt2.containsKey(zzch)) {
                                                    if (!zzfn.zzP(entry.getValue(), valueAt2.get(zzch))) {
                                                    }
                                                }
                                            }
                                            i12++;
                                        }
                                    }
                                }
                                return true;
                            }
                        } else if (sparseBooleanArray2.indexOfKey(sparseBooleanArray.keyAt(i11)) < 0) {
                            break;
                        } else {
                            i11++;
                        }
                    }
                }
            }
        }
        return false;
    }

    public final int hashCode() {
        return ((((((((((super.hashCode() + 31) * 31) + (this.zzF ? 1 : 0)) * 961) + (this.zzH ? 1 : 0)) * 31) + (this.zzI ? 1 : 0)) * 28629151) + (this.zzM ? 1 : 0)) * 961) + (this.zzO ? 1 : 0);
    }

    public final zzsk zzd() {
        return new zzsk(this, (zzsj) null);
    }

    @Nullable
    public final zzsm zze(int i11, zzch zzch) {
        Map map = this.zzP.get(i11);
        if (map != null) {
            return (zzsm) map.get(zzch);
        }
        return null;
    }

    public final boolean zzf(int i11) {
        return this.zzQ.get(i11);
    }

    public final boolean zzg(int i11, zzch zzch) {
        Map map = this.zzP.get(i11);
        if (map == null || !map.containsKey(zzch)) {
            return false;
        }
        return true;
    }
}
