package com.instabug.library.internal.dataretention.core;

import com.instabug.library.InstabugState;
import com.instabug.library.InstabugStateProvider;
import com.instabug.library.internal.resolver.c;
import com.instabug.library.model.h;
import java.util.concurrent.TimeUnit;

/* 'enum' modifier removed */
final class a extends b {
    public a(String str, int i11) {
        super(str, i11, (a) null);
    }

    public long a() {
        int i11;
        h b11 = c.a().b();
        if (b11 == null) {
            i11 = 7;
        } else {
            i11 = b11.e();
        }
        return TimeUnit.DAYS.toMillis((long) i11);
    }

    public boolean b() {
        boolean z11;
        boolean z12;
        h b11 = c.a().b();
        if (b11 == null || b11.d() != 0) {
            z11 = false;
        } else {
            z11 = true;
        }
        if (InstabugStateProvider.getInstance().getState() != InstabugState.DISABLED || b11 == null || b11.l()) {
            z12 = false;
        } else {
            z12 = true;
        }
        if (z11 || z12) {
            return true;
        }
        return false;
    }
}
