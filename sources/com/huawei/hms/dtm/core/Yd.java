package com.huawei.hms.dtm.core;

import com.huawei.hms.dtm.core.util.Logger;
import java.math.BigDecimal;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class Yd {

    /* renamed from: a  reason: collision with root package name */
    private final Executor f48440a = Executors.newSingleThreadExecutor(new C0442u("DTM-JsDownloader"));

    private String a(Hc hc2, long j11) {
        int c11 = hc2.c();
        if (c11 == 200) {
            Logger.info("DTM-Decode", "load js from network#success delay=" + j11);
            return hc2.a();
        }
        Logger.error("DTM-Decode", "load js from network#" + c11);
        return "";
    }

    /* access modifiers changed from: private */
    public String a(String str) {
        Logger.info("DTM-Decode", "load js from network begin...");
        int i11 = 0;
        while (true) {
            int i12 = i11 + 1;
            if (i11 > 3) {
                return "";
            }
            long nanoTime = System.nanoTime();
            Hc a11 = Fc.a(str);
            int c11 = a11.c();
            long round = c11 == 0 ? -1 : Math.round(((double) (System.nanoTime() - nanoTime)) / new BigDecimal("1000000").doubleValue());
            if (c11 != 0) {
                return a(a11, round);
            }
            if (i12 == 3) {
                return a(a11, round);
            }
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e11) {
                Logger.warn("DTM-Decode", "InterruptedException#" + e11.getMessage());
            }
            i11 = i12;
        }
    }

    public void a() {
        this.f48440a.execute(new Xd(this));
    }
}
