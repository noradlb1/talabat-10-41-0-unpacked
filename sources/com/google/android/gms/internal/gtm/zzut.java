package com.google.android.gms.internal.gtm;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

final class zzut implements Cloneable {
    private Object value;
    private zzur<?, ?> zzbhi;
    private List<zzuy> zzbhj = new ArrayList();

    private final byte[] toByteArray() throws IOException {
        byte[] bArr = new byte[zzy()];
        zza(zzuo.zzl(bArr));
        return bArr;
    }

    /* access modifiers changed from: private */
    /* renamed from: zzrz */
    public final zzut clone() {
        zzut zzut = new zzut();
        try {
            zzut.zzbhi = this.zzbhi;
            List<zzuy> list = this.zzbhj;
            if (list == null) {
                zzut.zzbhj = null;
            } else {
                zzut.zzbhj.addAll(list);
            }
            Object obj = this.value;
            if (obj != null) {
                if (obj instanceof zzuw) {
                    zzut.value = (zzuw) ((zzuw) obj).clone();
                } else if (obj instanceof byte[]) {
                    zzut.value = ((byte[]) obj).clone();
                } else {
                    int i11 = 0;
                    if (obj instanceof byte[][]) {
                        byte[][] bArr = (byte[][]) obj;
                        byte[][] bArr2 = new byte[bArr.length][];
                        zzut.value = bArr2;
                        while (i11 < bArr.length) {
                            bArr2[i11] = (byte[]) bArr[i11].clone();
                            i11++;
                        }
                    } else if (obj instanceof boolean[]) {
                        zzut.value = ((boolean[]) obj).clone();
                    } else if (obj instanceof int[]) {
                        zzut.value = ((int[]) obj).clone();
                    } else if (obj instanceof long[]) {
                        zzut.value = ((long[]) obj).clone();
                    } else if (obj instanceof float[]) {
                        zzut.value = ((float[]) obj).clone();
                    } else if (obj instanceof double[]) {
                        zzut.value = ((double[]) obj).clone();
                    } else if (obj instanceof zzuw[]) {
                        zzuw[] zzuwArr = (zzuw[]) obj;
                        zzuw[] zzuwArr2 = new zzuw[zzuwArr.length];
                        zzut.value = zzuwArr2;
                        while (i11 < zzuwArr.length) {
                            zzuwArr2[i11] = (zzuw) zzuwArr[i11].clone();
                            i11++;
                        }
                    }
                }
            }
            return zzut;
        } catch (CloneNotSupportedException e11) {
            throw new AssertionError(e11);
        }
    }

    public final boolean equals(Object obj) {
        List<zzuy> list;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzut)) {
            return false;
        }
        zzut zzut = (zzut) obj;
        if (this.value == null || zzut.value == null) {
            List<zzuy> list2 = this.zzbhj;
            if (list2 != null && (list = zzut.zzbhj) != null) {
                return list2.equals(list);
            }
            try {
                return Arrays.equals(toByteArray(), zzut.toByteArray());
            } catch (IOException e11) {
                throw new IllegalStateException(e11);
            }
        } else {
            zzur<?, ?> zzur = this.zzbhi;
            if (zzur != zzut.zzbhi) {
                return false;
            }
            if (!zzur.zzbhc.isArray()) {
                return this.value.equals(zzut.value);
            }
            Object obj2 = this.value;
            if (obj2 instanceof byte[]) {
                return Arrays.equals((byte[]) obj2, (byte[]) zzut.value);
            }
            if (obj2 instanceof int[]) {
                return Arrays.equals((int[]) obj2, (int[]) zzut.value);
            }
            if (obj2 instanceof long[]) {
                return Arrays.equals((long[]) obj2, (long[]) zzut.value);
            }
            if (obj2 instanceof float[]) {
                return Arrays.equals((float[]) obj2, (float[]) zzut.value);
            }
            if (obj2 instanceof double[]) {
                return Arrays.equals((double[]) obj2, (double[]) zzut.value);
            }
            if (obj2 instanceof boolean[]) {
                return Arrays.equals((boolean[]) obj2, (boolean[]) zzut.value);
            }
            return Arrays.deepEquals((Object[]) obj2, (Object[]) zzut.value);
        }
    }

    public final int hashCode() {
        try {
            return Arrays.hashCode(toByteArray()) + 527;
        } catch (IOException e11) {
            throw new IllegalStateException(e11);
        }
    }

    public final void zza(zzuy zzuy) throws IOException {
        Object obj;
        Object obj2;
        List<zzuy> list = this.zzbhj;
        if (list != null) {
            list.add(zzuy);
            return;
        }
        Object obj3 = this.value;
        if (obj3 instanceof zzuw) {
            byte[] bArr = zzuy.zzawe;
            zzun zzj = zzun.zzj(bArr, 0, bArr.length);
            int zzoa = zzj.zzoa();
            if (zzoa == bArr.length - zzuo.zzbc(zzoa)) {
                obj = ((zzuw) this.value).zza(zzj);
            } else {
                throw zzuv.zzsa();
            }
        } else {
            if (obj3 instanceof zzuw[]) {
                zzuw[] zzuwArr = (zzuw[]) this.zzbhi.zzag(Collections.singletonList(zzuy));
                zzuw[] zzuwArr2 = (zzuw[]) this.value;
                obj2 = (zzuw[]) Arrays.copyOf(zzuwArr2, zzuwArr2.length + zzuwArr.length);
                System.arraycopy(zzuwArr, 0, obj2, zzuwArr2.length, zzuwArr.length);
            } else if (obj3 instanceof zzsk) {
                obj = ((zzsk) this.value).zzpg().zza((zzsk) this.zzbhi.zzag(Collections.singletonList(zzuy))).zzpm();
            } else if (obj3 instanceof zzsk[]) {
                zzsk[] zzskArr = (zzsk[]) this.zzbhi.zzag(Collections.singletonList(zzuy));
                zzsk[] zzskArr2 = (zzsk[]) this.value;
                obj2 = (zzsk[]) Arrays.copyOf(zzskArr2, zzskArr2.length + zzskArr.length);
                System.arraycopy(zzskArr, 0, obj2, zzskArr2.length, zzskArr.length);
            } else {
                obj = this.zzbhi.zzag(Collections.singletonList(zzuy));
            }
            obj = obj2;
        }
        this.zzbhi = this.zzbhi;
        this.value = obj;
        this.zzbhj = null;
    }

    public final <T> T zzb(zzur<?, T> zzur) {
        if (this.value == null) {
            this.zzbhi = zzur;
            this.value = zzur.zzag(this.zzbhj);
            this.zzbhj = null;
        } else if (!this.zzbhi.equals(zzur)) {
            throw new IllegalStateException("Tried to getExtension with a different Extension.");
        }
        return this.value;
    }

    public final int zzy() {
        Object obj = this.value;
        if (obj != null) {
            zzur<?, ?> zzur = this.zzbhi;
            if (!zzur.zzbhd) {
                return zzur.zzaj(obj);
            }
            int length = Array.getLength(obj);
            int i11 = 0;
            for (int i12 = 0; i12 < length; i12++) {
                Object obj2 = Array.get(obj, i12);
                if (obj2 != null) {
                    i11 += zzur.zzaj(obj2);
                }
            }
            return i11;
        }
        int i13 = 0;
        for (zzuy next : this.zzbhj) {
            i13 += zzuo.zzbj(next.tag) + 0 + next.zzawe.length;
        }
        return i13;
    }

    public final void zza(zzuo zzuo) throws IOException {
        Object obj = this.value;
        if (obj != null) {
            zzur<?, ?> zzur = this.zzbhi;
            if (zzur.zzbhd) {
                int length = Array.getLength(obj);
                for (int i11 = 0; i11 < length; i11++) {
                    Object obj2 = Array.get(obj, i11);
                    if (obj2 != null) {
                        zzur.zza(obj2, zzuo);
                    }
                }
                return;
            }
            zzur.zza(obj, zzuo);
            return;
        }
        for (zzuy next : this.zzbhj) {
            zzuo.zzcb(next.tag);
            zzuo.zzm(next.zzawe);
        }
    }
}
