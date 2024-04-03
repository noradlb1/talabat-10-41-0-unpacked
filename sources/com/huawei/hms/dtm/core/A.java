package com.huawei.hms.dtm.core;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.hms.dtm.core.util.Logger;
import com.huawei.hms.dtm.core.util.f;

public class A implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ boolean f48256a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ boolean f48257b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ B f48258c;

    public A(B b11, boolean z11, boolean z12) {
        this.f48258c = b11;
        this.f48256a = z11;
        this.f48257b = z12;
    }

    public void run() {
        C c11;
        Context a11 = J.a();
        if (a11 == null) {
            Logger.error("loadJson#context is null");
            return;
        }
        String str = "";
        try {
            Logger.info("DTM-Decode", "schedule json task#begin");
            B b11 = this.f48258c;
            String unused = b11.f48261c = b11.f48264f.a(a11);
            if (TextUtils.isEmpty(this.f48258c.f48261c)) {
                Logger.error("DTM-Decode", "can not get dtm configuration id");
                if (c11 == null) {
                    return;
                }
                return;
            }
            if (this.f48258c.f48265g != null) {
                this.f48258c.f48265g.a(this.f48256a);
            }
            String a12 = this.f48258c.a(a11, this.f48256a);
            if (TextUtils.isEmpty(a12)) {
                boolean a13 = this.f48258c.a(this.f48256a, str);
                if (this.f48256a && !a13) {
                    Logger.info("DTM-Decode", "preview failed");
                    f.a(J.a(R.string.dtm_preview_toast_failed));
                }
                if (this.f48258c.f48265g != null) {
                    this.f48258c.f48265g.b(a13);
                    return;
                }
                return;
            }
            StringBuilder sb2 = new StringBuilder();
            sb2.append("json download url:");
            sb2.append(a12);
            Logger.test(sb2.toString());
            str = this.f48258c.a(a11, this.f48256a, this.f48257b, a12);
            if (TextUtils.isEmpty(str)) {
                Logger.info("DTM-Decode", "json is empty");
                boolean a14 = this.f48258c.a(this.f48256a, str);
                if (this.f48256a && !a14) {
                    Logger.info("DTM-Decode", "preview failed");
                    f.a(J.a(R.string.dtm_preview_toast_failed));
                }
                if (this.f48258c.f48265g != null) {
                    this.f48258c.f48265g.b(a14);
                    return;
                }
                return;
            }
            this.f48258c.f48262d.a(str);
            Logger.info("DTM-Decode", "schedule json task#end");
            boolean a15 = this.f48258c.a(this.f48256a, str);
            if (this.f48256a && !a15) {
                Logger.info("DTM-Decode", "preview failed");
                f.a(J.a(R.string.dtm_preview_toast_failed));
            }
            if (this.f48258c.f48265g != null) {
                this.f48258c.f48265g.b(a15);
            }
        } finally {
            boolean a16 = this.f48258c.a(this.f48256a, str);
            if (this.f48256a && !a16) {
                Logger.info("DTM-Decode", "preview failed");
                f.a(J.a(R.string.dtm_preview_toast_failed));
            }
            if (this.f48258c.f48265g != null) {
                this.f48258c.f48265g.b(a16);
            }
        }
    }
}
