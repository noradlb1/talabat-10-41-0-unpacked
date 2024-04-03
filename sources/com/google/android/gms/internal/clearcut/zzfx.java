package com.google.android.gms.internal.clearcut;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

final class zzfx implements Cloneable {
    private Object value;
    private zzfv<?, ?> zzrp;
    private List<Object> zzrq = new ArrayList();

    private final byte[] toByteArray() throws IOException {
        byte[] bArr = new byte[zzen()];
        zza(zzfs.zzg(bArr));
        return bArr;
    }

    /* access modifiers changed from: private */
    /* renamed from: zzeq */
    public final zzfx clone() {
        Object clone;
        zzfx zzfx = new zzfx();
        try {
            zzfx.zzrp = this.zzrp;
            List<Object> list = this.zzrq;
            if (list == null) {
                zzfx.zzrq = null;
            } else {
                zzfx.zzrq.addAll(list);
            }
            Object obj = this.value;
            if (obj != null) {
                if (obj instanceof zzfz) {
                    clone = (zzfz) ((zzfz) obj).clone();
                } else if (obj instanceof byte[]) {
                    clone = ((byte[]) obj).clone();
                } else {
                    int i11 = 0;
                    if (obj instanceof byte[][]) {
                        byte[][] bArr = (byte[][]) obj;
                        byte[][] bArr2 = new byte[bArr.length][];
                        zzfx.value = bArr2;
                        while (i11 < bArr.length) {
                            bArr2[i11] = (byte[]) bArr[i11].clone();
                            i11++;
                        }
                    } else if (obj instanceof boolean[]) {
                        clone = ((boolean[]) obj).clone();
                    } else if (obj instanceof int[]) {
                        clone = ((int[]) obj).clone();
                    } else if (obj instanceof long[]) {
                        clone = ((long[]) obj).clone();
                    } else if (obj instanceof float[]) {
                        clone = ((float[]) obj).clone();
                    } else if (obj instanceof double[]) {
                        clone = ((double[]) obj).clone();
                    } else if (obj instanceof zzfz[]) {
                        zzfz[] zzfzArr = (zzfz[]) obj;
                        zzfz[] zzfzArr2 = new zzfz[zzfzArr.length];
                        zzfx.value = zzfzArr2;
                        while (i11 < zzfzArr.length) {
                            zzfzArr2[i11] = (zzfz) zzfzArr[i11].clone();
                            i11++;
                        }
                    }
                }
                zzfx.value = clone;
            }
            return zzfx;
        } catch (CloneNotSupportedException e11) {
            throw new AssertionError(e11);
        }
    }

    public final boolean equals(Object obj) {
        List<Object> list;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzfx)) {
            return false;
        }
        zzfx zzfx = (zzfx) obj;
        if (this.value == null || zzfx.value == null) {
            List<Object> list2 = this.zzrq;
            if (list2 != null && (list = zzfx.zzrq) != null) {
                return list2.equals(list);
            }
            try {
                return Arrays.equals(toByteArray(), zzfx.toByteArray());
            } catch (IOException e11) {
                throw new IllegalStateException(e11);
            }
        } else {
            zzfv<?, ?> zzfv = this.zzrp;
            if (zzfv != zzfx.zzrp) {
                return false;
            }
            if (!zzfv.zzrk.isArray()) {
                return this.value.equals(zzfx.value);
            }
            Object obj2 = this.value;
            return obj2 instanceof byte[] ? Arrays.equals((byte[]) obj2, (byte[]) zzfx.value) : obj2 instanceof int[] ? Arrays.equals((int[]) obj2, (int[]) zzfx.value) : obj2 instanceof long[] ? Arrays.equals((long[]) obj2, (long[]) zzfx.value) : obj2 instanceof float[] ? Arrays.equals((float[]) obj2, (float[]) zzfx.value) : obj2 instanceof double[] ? Arrays.equals((double[]) obj2, (double[]) zzfx.value) : obj2 instanceof boolean[] ? Arrays.equals((boolean[]) obj2, (boolean[]) zzfx.value) : Arrays.deepEquals((Object[]) obj2, (Object[]) zzfx.value);
        }
    }

    public final int hashCode() {
        try {
            return Arrays.hashCode(toByteArray()) + 527;
        } catch (IOException e11) {
            throw new IllegalStateException(e11);
        }
    }

    public final void zza(zzfs zzfs) throws IOException {
        if (this.value == null) {
            Iterator<Object> it = this.zzrq.iterator();
            if (it.hasNext()) {
                it.next();
                throw new NoSuchMethodError();
            }
            return;
        }
        throw new NoSuchMethodError();
    }

    public final int zzen() {
        if (this.value == null) {
            Iterator<Object> it = this.zzrq.iterator();
            if (!it.hasNext()) {
                return 0;
            }
            it.next();
            throw new NoSuchMethodError();
        }
        throw new NoSuchMethodError();
    }
}
