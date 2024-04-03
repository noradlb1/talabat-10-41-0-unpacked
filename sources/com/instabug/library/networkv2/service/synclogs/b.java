package com.instabug.library.networkv2.service.synclogs;

import com.instabug.library.util.InstabugSDKLogger;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;

class b implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ File[] f51679b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ String f51680c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ String f51681d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ String f51682e;

    /* renamed from: f  reason: collision with root package name */
    public final /* synthetic */ c f51683f;

    public b(c cVar, File[] fileArr, String str, String str2, String str3) {
        this.f51683f = cVar;
        this.f51679b = fileArr;
        this.f51680c = str;
        this.f51681d = str2;
        this.f51682e = str3;
    }

    public void run() {
        if (this.f51683f.f51689e != null) {
            try {
                this.f51683f.f51689e.a(Arrays.asList(this.f51679b), this.f51680c, this.f51681d, this.f51682e);
            } catch (UnsupportedEncodingException e11) {
                InstabugSDKLogger.e("IBG-Core", "error while syncing logs", e11);
            }
        }
    }
}
