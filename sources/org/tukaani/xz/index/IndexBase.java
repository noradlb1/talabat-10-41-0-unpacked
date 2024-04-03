package org.tukaani.xz.index;

import org.tukaani.xz.XZIOException;
import org.tukaani.xz.common.Util;

abstract class IndexBase {

    /* renamed from: a  reason: collision with root package name */
    public long f63425a = 0;

    /* renamed from: b  reason: collision with root package name */
    public long f63426b = 0;

    /* renamed from: c  reason: collision with root package name */
    public long f63427c = 0;

    /* renamed from: d  reason: collision with root package name */
    public long f63428d = 0;
    private final XZIOException invalidIndexException;

    public IndexBase(XZIOException xZIOException) {
        this.invalidIndexException = xZIOException;
    }

    private long getUnpaddedIndexSize() {
        return ((long) (Util.getVLISize(this.f63428d) + 1)) + this.f63427c + 4;
    }

    public int a() {
        return (int) ((4 - getUnpaddedIndexSize()) & 3);
    }

    public void add(long j11, long j12) throws XZIOException {
        this.f63425a += (3 + j11) & -4;
        this.f63426b += j12;
        this.f63427c += (long) (Util.getVLISize(j11) + Util.getVLISize(j12));
        this.f63428d++;
        if (this.f63425a < 0 || this.f63426b < 0 || getIndexSize() > Util.BACKWARD_SIZE_MAX || getStreamSize() < 0) {
            throw this.invalidIndexException;
        }
    }

    public long getIndexSize() {
        return (getUnpaddedIndexSize() + 3) & -4;
    }

    public long getStreamSize() {
        return this.f63425a + 12 + getIndexSize() + 12;
    }
}
