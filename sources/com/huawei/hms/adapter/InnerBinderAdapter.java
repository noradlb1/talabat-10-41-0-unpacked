package com.huawei.hms.adapter;

import android.content.Context;
import com.google.android.exoplayer2.PlaybackException;
import com.huawei.hms.support.log.HMSLog;

public class InnerBinderAdapter extends BinderAdapter {

    /* renamed from: j  reason: collision with root package name */
    private static final Object f47799j = new Object();

    /* renamed from: k  reason: collision with root package name */
    private static BinderAdapter f47800k;

    private InnerBinderAdapter(Context context, String str, String str2) {
        super(context, str, str2);
    }

    public static BinderAdapter getInstance(Context context, String str, String str2) {
        BinderAdapter binderAdapter;
        HMSLog.i("InnerBinderAdapter", "InnerBinderAdapter getInstance.");
        synchronized (f47799j) {
            if (f47800k == null) {
                f47800k = new InnerBinderAdapter(context, str, str2);
            }
            binderAdapter = f47800k;
        }
        return binderAdapter;
    }

    public int getConnTimeOut() {
        return 2001;
    }

    public int getMsgDelayDisconnect() {
        return PlaybackException.ERROR_CODE_IO_NETWORK_CONNECTION_TIMEOUT;
    }
}
