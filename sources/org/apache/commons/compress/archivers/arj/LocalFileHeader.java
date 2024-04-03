package org.apache.commons.compress.archivers.arj;

import java.util.Arrays;
import java.util.Objects;

class LocalFileHeader {

    /* renamed from: a  reason: collision with root package name */
    public int f27534a;

    /* renamed from: b  reason: collision with root package name */
    public int f27535b;

    /* renamed from: c  reason: collision with root package name */
    public int f27536c;

    /* renamed from: d  reason: collision with root package name */
    public int f27537d;

    /* renamed from: e  reason: collision with root package name */
    public int f27538e;

    /* renamed from: f  reason: collision with root package name */
    public int f27539f;

    /* renamed from: g  reason: collision with root package name */
    public int f27540g;

    /* renamed from: h  reason: collision with root package name */
    public int f27541h;

    /* renamed from: i  reason: collision with root package name */
    public long f27542i;

    /* renamed from: j  reason: collision with root package name */
    public long f27543j;

    /* renamed from: k  reason: collision with root package name */
    public long f27544k;

    /* renamed from: l  reason: collision with root package name */
    public int f27545l;

    /* renamed from: m  reason: collision with root package name */
    public int f27546m;

    /* renamed from: n  reason: collision with root package name */
    public int f27547n;

    /* renamed from: o  reason: collision with root package name */
    public int f27548o;

    /* renamed from: p  reason: collision with root package name */
    public int f27549p;

    /* renamed from: q  reason: collision with root package name */
    public int f27550q;

    /* renamed from: r  reason: collision with root package name */
    public int f27551r;

    /* renamed from: s  reason: collision with root package name */
    public int f27552s;

    /* renamed from: t  reason: collision with root package name */
    public String f27553t;

    /* renamed from: u  reason: collision with root package name */
    public String f27554u;

    /* renamed from: v  reason: collision with root package name */
    public byte[][] f27555v;

    public static class FileTypes {
    }

    public static class Flags {
    }

    public static class Methods {
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        LocalFileHeader localFileHeader = (LocalFileHeader) obj;
        if (this.f27534a == localFileHeader.f27534a && this.f27535b == localFileHeader.f27535b && this.f27536c == localFileHeader.f27536c && this.f27537d == localFileHeader.f27537d && this.f27538e == localFileHeader.f27538e && this.f27539f == localFileHeader.f27539f && this.f27540g == localFileHeader.f27540g && this.f27541h == localFileHeader.f27541h && this.f27542i == localFileHeader.f27542i && this.f27543j == localFileHeader.f27543j && this.f27544k == localFileHeader.f27544k && this.f27545l == localFileHeader.f27545l && this.f27546m == localFileHeader.f27546m && this.f27547n == localFileHeader.f27547n && this.f27548o == localFileHeader.f27548o && this.f27549p == localFileHeader.f27549p && this.f27550q == localFileHeader.f27550q && this.f27551r == localFileHeader.f27551r && this.f27552s == localFileHeader.f27552s && Objects.equals(this.f27553t, localFileHeader.f27553t) && Objects.equals(this.f27554u, localFileHeader.f27554u) && Arrays.deepEquals(this.f27555v, localFileHeader.f27555v)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        String str = this.f27553t;
        if (str == null) {
            return 0;
        }
        return str.hashCode();
    }

    public String toString() {
        return "LocalFileHeader [archiverVersionNumber=" + this.f27534a + ", minVersionToExtract=" + this.f27535b + ", hostOS=" + this.f27536c + ", arjFlags=" + this.f27537d + ", method=" + this.f27538e + ", fileType=" + this.f27539f + ", reserved=" + this.f27540g + ", dateTimeModified=" + this.f27541h + ", compressedSize=" + this.f27542i + ", originalSize=" + this.f27543j + ", originalCrc32=" + this.f27544k + ", fileSpecPosition=" + this.f27545l + ", fileAccessMode=" + this.f27546m + ", firstChapter=" + this.f27547n + ", lastChapter=" + this.f27548o + ", extendedFilePosition=" + this.f27549p + ", dateTimeAccessed=" + this.f27550q + ", dateTimeCreated=" + this.f27551r + ", originalSizeEvenForVolumes=" + this.f27552s + ", name=" + this.f27553t + ", comment=" + this.f27554u + ", extendedHeaders=" + Arrays.toString(this.f27555v) + "]";
    }
}
