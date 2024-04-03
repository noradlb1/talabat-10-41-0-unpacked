package com.huawei.agconnect.credential.obs;

import android.content.Context;
import com.huawei.agconnect.common.api.Logger;
import com.huawei.hms.aaid.HmsInstanceId;

public class d {

    /* renamed from: a  reason: collision with root package name */
    private Object f47572a;

    public d(Context context) {
        Class<HmsInstanceId> cls = HmsInstanceId.class;
        try {
            String str = HmsInstanceId.TAG;
            this.f47572a = cls.getDeclaredMethod("getInstance", new Class[]{Context.class}).invoke((Object) null, new Object[]{context});
        } catch (Throwable unused) {
            Logger.w("HMSInstanceIdWrapper", "not find package HmsInstanceId");
        }
    }

    public boolean a() {
        return this.f47572a != null;
    }

    public String b() {
        try {
            Logger.d("HMSInstanceIdWrapper", "call hms wrapper : getId");
            return (String) this.f47572a.getClass().getDeclaredMethod("getId", new Class[0]).invoke(this.f47572a, new Object[0]);
        } catch (Throwable unused) {
            Logger.e("HMSInstanceIdWrapper", "get id fail");
            return null;
        }
    }

    public long c() {
        try {
            Logger.d("HMSInstanceIdWrapper", "call hms wrapper : getCreationTime");
            return ((Long) this.f47572a.getClass().getDeclaredMethod("getCreationTime", new Class[0]).invoke(this.f47572a, new Object[0])).longValue();
        } catch (Throwable unused) {
            Logger.e("HMSInstanceIdWrapper", "get create time fail");
            return 0;
        }
    }

    public void d() {
        try {
            Logger.d("HMSInstanceIdWrapper", "call hms wrapper : deleteAAID");
            this.f47572a.getClass().getDeclaredMethod("deleteAAID", new Class[0]).invoke(this.f47572a, new Object[0]);
        } catch (Throwable unused) {
            Logger.e("HMSInstanceIdWrapper", "delete aaid fail");
        }
    }
}
