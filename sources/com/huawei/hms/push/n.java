package com.huawei.hms.push;

import android.content.Context;
import android.content.Intent;
import com.huawei.hms.support.log.HMSLog;

public class n extends Thread {

    /* renamed from: a  reason: collision with root package name */
    private Context f49776a;

    /* renamed from: b  reason: collision with root package name */
    private m f49777b;

    public n(Context context, m mVar) {
        this.f49776a = context;
        this.f49777b = mVar;
    }

    private static Intent a(Context context, m mVar) {
        if (mVar == null) {
            return null;
        }
        Intent b11 = d.b(context, mVar.d());
        if (mVar.n() != null) {
            try {
                Intent parseUri = Intent.parseUri(mVar.n(), 0);
                parseUri.setSelector((Intent) null);
                HMSLog.d("PushSelfShowLog", "Intent.parseUri(msg.intentUri, 0), action:" + parseUri.getAction());
                if (d.a(context, mVar.d(), parseUri).booleanValue()) {
                    return parseUri;
                }
                return b11;
            } catch (Exception e11) {
                HMSLog.w("PushSelfShowLog", "intentUri error," + e11.toString());
                return b11;
            }
        } else {
            if (mVar.a() != null) {
                Intent intent = new Intent(mVar.a());
                if (d.a(context, mVar.d(), intent).booleanValue()) {
                    b11 = intent;
                }
            }
            b11.setPackage(mVar.d());
            return b11;
        }
    }

    private boolean b(Context context) {
        if ("cosa".equals(this.f49777b.i())) {
            return a(context);
        }
        return true;
    }

    public void run() {
        HMSLog.i("PushSelfShowLog", "enter run()");
        try {
            if (b(this.f49776a) && !b(this.f49776a, this.f49777b)) {
                l.a(this.f49776a, this.f49777b);
            }
        } catch (Exception e11) {
            HMSLog.e("PushSelfShowLog", e11.toString());
        }
    }

    private boolean b(Context context, m mVar) {
        if (!"cosa".equals(mVar.i()) || a(context, mVar) != null) {
            return false;
        }
        HMSLog.d("PushSelfShowLog", "launchCosaApp,intent == null");
        return true;
    }

    private boolean a(Context context) {
        return d.c(context, this.f49777b.d());
    }
}
