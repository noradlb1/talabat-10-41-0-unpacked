package com.uxcam.internals;

import java.nio.ByteBuffer;

public class cz extends ci {

    /* renamed from: c  reason: collision with root package name */
    public String f13180c;

    /* renamed from: d  reason: collision with root package name */
    public String f13181d;

    /* renamed from: e  reason: collision with root package name */
    public String f13182e;

    /* renamed from: f  reason: collision with root package name */
    public int f13183f;

    /* renamed from: g  reason: collision with root package name */
    public int f13184g;

    /* renamed from: h  reason: collision with root package name */
    public String f13185h;

    public cz(String str, String str2, String str3, int i11, int i12) {
        super(new da("hdlr"));
        this.f13180c = str;
        this.f13181d = str2;
        this.f13182e = str3;
        this.f13183f = i11;
        this.f13184g = i12;
        this.f13185h = "";
    }

    public void a(ByteBuffer byteBuffer) {
        byteBuffer.putInt((this.f13131b & 16777215) | 0);
        byteBuffer.put(dh.a(this.f13180c));
        byteBuffer.put(dh.a(this.f13181d));
        byteBuffer.put(dh.a(this.f13182e));
        byteBuffer.putInt(this.f13183f);
        byteBuffer.putInt(this.f13184g);
        String str = this.f13185h;
        if (str != null) {
            byteBuffer.put(dh.a(str));
        }
    }

    public cz() {
        super(new da("hdlr"));
    }
}
