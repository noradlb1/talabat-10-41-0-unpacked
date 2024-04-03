package org.apache.commons.compress.archivers.arj;

import java.util.Arrays;

class MainHeader {

    /* renamed from: a  reason: collision with root package name */
    public int f27556a;

    /* renamed from: b  reason: collision with root package name */
    public int f27557b;

    /* renamed from: c  reason: collision with root package name */
    public int f27558c;

    /* renamed from: d  reason: collision with root package name */
    public int f27559d;

    /* renamed from: e  reason: collision with root package name */
    public int f27560e;

    /* renamed from: f  reason: collision with root package name */
    public int f27561f;

    /* renamed from: g  reason: collision with root package name */
    public int f27562g;

    /* renamed from: h  reason: collision with root package name */
    public int f27563h;

    /* renamed from: i  reason: collision with root package name */
    public int f27564i;

    /* renamed from: j  reason: collision with root package name */
    public long f27565j;

    /* renamed from: k  reason: collision with root package name */
    public int f27566k;

    /* renamed from: l  reason: collision with root package name */
    public int f27567l;

    /* renamed from: m  reason: collision with root package name */
    public int f27568m;

    /* renamed from: n  reason: collision with root package name */
    public int f27569n;

    /* renamed from: o  reason: collision with root package name */
    public int f27570o;

    /* renamed from: p  reason: collision with root package name */
    public int f27571p;

    /* renamed from: q  reason: collision with root package name */
    public int f27572q;

    /* renamed from: r  reason: collision with root package name */
    public String f27573r;

    /* renamed from: s  reason: collision with root package name */
    public String f27574s;

    /* renamed from: t  reason: collision with root package name */
    public byte[] f27575t;

    public static class Flags {
    }

    public static class HostOS {
    }

    public String toString() {
        return "MainHeader [archiverVersionNumber=" + this.f27556a + ", minVersionToExtract=" + this.f27557b + ", hostOS=" + this.f27558c + ", arjFlags=" + this.f27559d + ", securityVersion=" + this.f27560e + ", fileType=" + this.f27561f + ", reserved=" + this.f27562g + ", dateTimeCreated=" + this.f27563h + ", dateTimeModified=" + this.f27564i + ", archiveSize=" + this.f27565j + ", securityEnvelopeFilePosition=" + this.f27566k + ", fileSpecPosition=" + this.f27567l + ", securityEnvelopeLength=" + this.f27568m + ", encryptionVersion=" + this.f27569n + ", lastChapter=" + this.f27570o + ", arjProtectionFactor=" + this.f27571p + ", arjFlags2=" + this.f27572q + ", name=" + this.f27573r + ", comment=" + this.f27574s + ", extendedHeaderBytes=" + Arrays.toString(this.f27575t) + "]";
    }
}
