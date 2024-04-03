package com.huawei.hms.dtm.core.report;

import com.huawei.hms.dtm.core.J;
import com.huawei.hms.dtm.core.M;
import com.huawei.hms.dtm.core.Q;
import com.huawei.hms.dtm.core.debug.a;
import com.huawei.hms.dtm.core.util.Logger;

public class k implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private a f48584a;

    /* renamed from: b  reason: collision with root package name */
    private Q f48585b;

    public k(a aVar, Q q11) {
        this.f48584a = aVar;
        this.f48585b = q11;
    }

    public void run() {
        boolean a11 = M.b().a(this.f48585b);
        Logger.info("DTM-Report", "insert new report event to db, result: " + a11);
        if (a11) {
            if (a.a(J.a())) {
                this.f48584a.b();
            }
            this.f48584a.a(false);
        }
    }
}
