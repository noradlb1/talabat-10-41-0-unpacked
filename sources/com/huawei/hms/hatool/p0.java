package com.huawei.hms.hatool;

import com.talabat.sidemenu.SideMenuRewardViewHolder;
import java.util.Calendar;
import java.util.UUID;
import net.bytebuddy.utility.JavaConstant;

public class p0 {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public long f49093a = 1800000;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public volatile boolean f49094b = false;

    /* renamed from: c  reason: collision with root package name */
    private a f49095c = null;

    public class a {

        /* renamed from: a  reason: collision with root package name */
        String f49096a = UUID.randomUUID().toString().replace(SideMenuRewardViewHolder.DEFAULT_LOGGED_IN_USER_POINTS_VALUE, "");

        /* renamed from: b  reason: collision with root package name */
        boolean f49097b;

        /* renamed from: c  reason: collision with root package name */
        private long f49098c;

        public a(long j11) {
            this.f49096a += JavaConstant.Dynamic.DEFAULT_NAME + j11;
            this.f49098c = j11;
            this.f49097b = true;
            boolean unused = p0.this.f49094b = false;
        }

        private boolean a(long j11, long j12) {
            Calendar instance = Calendar.getInstance();
            instance.setTimeInMillis(j11);
            Calendar instance2 = Calendar.getInstance();
            instance2.setTimeInMillis(j12);
            return (instance.get(1) == instance2.get(1) && instance.get(6) == instance2.get(6)) ? false : true;
        }

        private void b(long j11) {
            v.c("hmsSdk", "getNewSession() session is flush!");
            String uuid = UUID.randomUUID().toString();
            this.f49096a = uuid;
            this.f49096a = uuid.replace(SideMenuRewardViewHolder.DEFAULT_LOGGED_IN_USER_POINTS_VALUE, "");
            this.f49096a += JavaConstant.Dynamic.DEFAULT_NAME + j11;
            this.f49098c = j11;
            this.f49097b = true;
        }

        private boolean b(long j11, long j12) {
            return j12 - j11 >= p0.this.f49093a;
        }

        public void a(long j11) {
            if (p0.this.f49094b) {
                boolean unused = p0.this.f49094b = false;
                b(j11);
            } else if (b(this.f49098c, j11) || a(this.f49098c, j11)) {
                b(j11);
            } else {
                this.f49098c = j11;
                this.f49097b = false;
            }
        }
    }

    public String a() {
        a aVar = this.f49095c;
        if (aVar != null) {
            return aVar.f49096a;
        }
        v.f("hmsSdk", "getSessionName(): session not prepared. onEvent() must be called first.");
        return "";
    }

    public void a(long j11) {
        a aVar = this.f49095c;
        if (aVar == null) {
            v.c("hmsSdk", "Session is first flush");
            this.f49095c = new a(j11);
            return;
        }
        aVar.a(j11);
    }

    public boolean b() {
        a aVar = this.f49095c;
        if (aVar != null) {
            return aVar.f49097b;
        }
        v.f("hmsSdk", "isFirstEvent(): session not prepared. onEvent() must be called first.");
        return false;
    }
}
