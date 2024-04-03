package org.apache.commons.compress.archivers.sevenz;

class StreamMap {

    /* renamed from: a  reason: collision with root package name */
    public int[] f27635a;

    /* renamed from: b  reason: collision with root package name */
    public long[] f27636b;

    /* renamed from: c  reason: collision with root package name */
    public int[] f27637c;

    /* renamed from: d  reason: collision with root package name */
    public int[] f27638d;

    public String toString() {
        return "StreamMap with indices of " + this.f27635a.length + " folders, offsets of " + this.f27636b.length + " packed streams, first files of " + this.f27637c.length + " folders and folder indices for " + this.f27638d.length + " files";
    }
}
