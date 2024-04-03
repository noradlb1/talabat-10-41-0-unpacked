package com.uxcam.internals;

import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.Set;

public class bl extends ed {

    /* renamed from: c  reason: collision with root package name */
    public static final /* synthetic */ int f13078c = 0;

    public static class aa extends an {
        public aa() {
            HashMap hashMap = new HashMap();
            hashMap.put("url ", hy.class);
            Set set = ad.f12974c;
            Class<ad> cls = ad.class;
            hashMap.put("alis", cls);
            hashMap.put("cios", cls);
        }
    }

    static {
        new aa();
    }

    public bl() {
        this(new da("dref"));
    }

    public void a(ByteBuffer byteBuffer) {
        byteBuffer.putInt(0);
        byteBuffer.putInt(this.f13252b.size());
        super.a(byteBuffer);
    }

    public bl(da daVar) {
        super(daVar);
    }
}
