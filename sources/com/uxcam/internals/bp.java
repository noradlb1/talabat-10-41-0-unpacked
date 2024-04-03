package com.uxcam.internals;

import java.nio.ByteBuffer;
import java.util.List;

public class bp extends ci {

    /* renamed from: c  reason: collision with root package name */
    public List f13083c;

    public bp(da daVar) {
        super(daVar);
    }

    public void a(ByteBuffer byteBuffer) {
        byteBuffer.putInt((this.f13131b & 16777215) | 0);
        byteBuffer.putInt(this.f13083c.size());
        for (bo boVar : this.f13083c) {
            byteBuffer.putInt((int) boVar.f13081b);
            byteBuffer.putInt((int) boVar.f13082c);
            byteBuffer.putInt((int) (boVar.f13080a * 65536.0f));
        }
    }

    public bp() {
        this(new da("elst"));
    }

    public void a(StringBuilder sb2) {
        super.a(sb2);
        sb2.append(": ");
        hc.a(this, sb2, "edits");
    }
}
