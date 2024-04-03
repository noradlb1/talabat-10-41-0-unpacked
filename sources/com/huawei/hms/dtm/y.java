package com.huawei.hms.dtm;

import android.content.Context;
import android.os.Bundle;
import com.huawei.hms.dtm.A;

public class y implements A.a {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ A f48679a;

    public y(A a11) {
        this.f48679a = a11;
    }

    public Context a(Context context, Bundle bundle, boolean z11) {
        if (!z11) {
            return this.f48679a.a(context);
        }
        B.b("RemoteDtmDelegate", "after 5000, HMS is still initializing!!");
        return null;
    }

    public String a() {
        return "HMS is still initializing";
    }
}
