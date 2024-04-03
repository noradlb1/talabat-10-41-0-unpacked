package com.google.android.gms.internal.vision;

final class zzdi<E> extends zzdf<E> {
    static final zzdf<Object> zzlt = new zzdi(new Object[0], 0);
    private final transient int size;
    private final transient Object[] zzlu;

    public zzdi(Object[] objArr, int i11) {
        this.zzlu = objArr;
        this.size = i11;
    }

    public final E get(int i11) {
        zzct.zzc(i11, this.size);
        return this.zzlu[i11];
    }

    public final int size() {
        return this.size;
    }

    public final int zza(Object[] objArr, int i11) {
        System.arraycopy(this.zzlu, 0, objArr, i11, this.size);
        return i11 + this.size;
    }

    public final Object[] zzbz() {
        return this.zzlu;
    }

    public final int zzca() {
        return 0;
    }

    public final int zzcb() {
        return this.size;
    }
}
