package com.uxcam.internals;

import java.nio.ByteBuffer;
import java.util.Collection;
import java.util.LinkedList;

public class bz extends am {

    /* renamed from: b  reason: collision with root package name */
    public String f13098b;

    /* renamed from: c  reason: collision with root package name */
    public int f13099c;

    /* renamed from: d  reason: collision with root package name */
    public Collection f13100d;

    public bz(String str, int i11, Collection collection) {
        super(new da("ftyp"));
        new LinkedList();
        this.f13098b = str;
        this.f13099c = i11;
        this.f13100d = collection;
    }

    public void a(ByteBuffer byteBuffer) {
        byteBuffer.put(dh.a(this.f13098b));
        byteBuffer.putInt(this.f13099c);
        for (String a11 : this.f13100d) {
            byteBuffer.put(dh.a(a11));
        }
    }

    public bz() {
        super(new da("ftyp"));
        this.f13100d = new LinkedList();
    }
}
