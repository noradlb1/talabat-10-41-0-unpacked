package com.instabug.survey.network;

import android.content.Context;
import com.instabug.library.util.TimeUtils;
import com.instabug.survey.network.service.g;
import com.instabug.survey.settings.c;
import com.instabug.survey.utils.j;

public class f {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public e f52411a;

    public f(e eVar) {
        this.f52411a = eVar;
    }

    private boolean a() {
        return TimeUtils.currentTimeMillis() - c.e() > 10000;
    }

    public void a(Context context, String str) {
        if (j.d() && a()) {
            g.a().a(str, new d(this));
        }
    }
}
