package org.tukaani.xz.delta;

abstract class DeltaCoder {

    /* renamed from: a  reason: collision with root package name */
    public final int f63421a;

    /* renamed from: b  reason: collision with root package name */
    public final byte[] f63422b = new byte[256];

    /* renamed from: c  reason: collision with root package name */
    public int f63423c = 0;

    public DeltaCoder(int i11) {
        if (i11 < 1 || i11 > 256) {
            throw new IllegalArgumentException();
        }
        this.f63421a = i11;
    }
}
