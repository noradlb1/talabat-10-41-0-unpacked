package com.uxcam.internals;

import java.nio.ByteBuffer;
import java.util.HashSet;
import java.util.Set;

public class ad extends ci {

    /* renamed from: c  reason: collision with root package name */
    public static final Set f12974c;

    static {
        HashSet hashSet = new HashSet();
        f12974c = hashSet;
        hashSet.add(14);
        hashSet.add(15);
    }

    public ad() {
        super(new da("alis", 0));
    }

    public void a(ByteBuffer byteBuffer) {
        byteBuffer.putInt((this.f13131b & 16777215) | 0);
        if ((this.f13131b & 1) == 0) {
            dh.a((String) null);
            throw null;
        }
    }

    public void a(StringBuilder sb2) {
        super.a(sb2);
        sb2.append(": ");
        boolean z11 = true;
        if ((this.f13131b & 1) == 0) {
            z11 = false;
        }
        if (z11) {
            sb2.append("'self'");
            return;
        }
        throw null;
    }
}
