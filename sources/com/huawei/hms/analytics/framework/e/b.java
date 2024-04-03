package com.huawei.hms.analytics.framework.e;

import com.huawei.hms.analytics.core.log.HiLog;
import com.huawei.hms.analytics.framework.b.c;
import com.talabat.sidemenu.SideMenuRewardViewHolder;
import java.util.Calendar;
import java.util.UUID;
import net.bytebuddy.utility.JavaConstant;

public final class b {

    /* renamed from: a  reason: collision with root package name */
    public long f47991a = 1800000;

    /* renamed from: b  reason: collision with root package name */
    public long f47992b = 30000;

    /* renamed from: c  reason: collision with root package name */
    public volatile boolean f47993c = false;

    /* renamed from: d  reason: collision with root package name */
    public volatile long f47994d = 0;

    /* renamed from: e  reason: collision with root package name */
    private a f47995e = null;

    public class a {

        /* renamed from: a  reason: collision with root package name */
        String f47996a = UUID.randomUUID().toString().replace(SideMenuRewardViewHolder.DEFAULT_LOGGED_IN_USER_POINTS_VALUE, "");

        /* renamed from: b  reason: collision with root package name */
        boolean f47997b;

        /* renamed from: d  reason: collision with root package name */
        private long f47999d;

        public a(long j11) {
            this.f47996a += JavaConstant.Dynamic.DEFAULT_NAME + j11;
            this.f47999d = j11;
            this.f47997b = true;
            b.this.f47993c = false;
        }

        private void a(long j11) {
            HiLog.i("SessionKeeper", "getNewSession() session is flush!");
            String uuid = UUID.randomUUID().toString();
            this.f47996a = uuid;
            this.f47996a = uuid.replace(SideMenuRewardViewHolder.DEFAULT_LOGGED_IN_USER_POINTS_VALUE, "");
            this.f47996a += JavaConstant.Dynamic.DEFAULT_NAME + j11;
            this.f47999d = j11;
            this.f47997b = true;
        }

        private static boolean a(long j11, long j12) {
            Calendar instance = Calendar.getInstance();
            instance.setTimeInMillis(j11);
            Calendar instance2 = Calendar.getInstance();
            instance2.setTimeInMillis(j12);
            return (instance.get(1) == instance2.get(1) && instance.get(6) == instance2.get(6)) ? false : true;
        }

        private boolean b(long j11, long j12) {
            return j12 - j11 >= b.this.f47991a;
        }

        public final void a(String str, long j11) {
            c b11 = com.huawei.hms.analytics.framework.b.b.a().b(str);
            if (b11 == null || !b11.f47926a) {
                if (b.this.f47993c) {
                    b bVar = b.this;
                    if (j11 - b.this.f47994d > bVar.f47992b) {
                        bVar.f47993c = false;
                        b.this.f47994d = 0;
                        a(j11);
                        return;
                    }
                }
                if (b(this.f47999d, j11) || a(this.f47999d, j11)) {
                    a(j11);
                    return;
                }
                this.f47999d = j11;
                this.f47997b = false;
                return;
            }
            b11.f47926a = false;
            a(j11);
        }
    }

    public final String a() {
        a aVar = this.f47995e;
        if (aVar != null) {
            return aVar.f47996a;
        }
        HiLog.w("SessionKeeper", "getSessionName(): session not prepared. onEvent() must be called first.");
        return "";
    }

    public final void a(String str, long j11) {
        a aVar = this.f47995e;
        if (aVar == null) {
            HiLog.i("SessionKeeper", "Session is first flush");
            this.f47995e = new a(j11);
            return;
        }
        aVar.a(str, j11);
    }

    public final boolean b() {
        a aVar = this.f47995e;
        if (aVar != null) {
            return aVar.f47997b;
        }
        HiLog.w("SessionKeeper", "isFirstEvent(): session not prepared. onEvent() must be called first.");
        return false;
    }
}
