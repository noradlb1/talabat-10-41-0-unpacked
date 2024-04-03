package com.huawei.agconnect.credential.obs;

import android.os.Handler;
import android.os.HandlerThread;
import android.text.TextUtils;
import com.huawei.agconnect.AGConnectInstance;
import com.huawei.agconnect.common.api.BackendService;
import com.huawei.agconnect.common.api.Logger;
import com.huawei.hmf.tasks.OnCompleteListener;
import com.huawei.hmf.tasks.Task;
import com.huawei.hmf.tasks.TaskExecutors;
import com.huawei.hms.push.constant.RemoteMessageConst;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.atomic.AtomicBoolean;

public class l {

    /* renamed from: a  reason: collision with root package name */
    private static final l f47582a = new l();

    /* renamed from: b  reason: collision with root package name */
    private Map<String, List<r>> f47583b = new HashMap();

    /* renamed from: c  reason: collision with root package name */
    private Map<String, r> f47584c = new HashMap();

    /* renamed from: d  reason: collision with root package name */
    private AtomicBoolean f47585d = new AtomicBoolean(false);
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public String f47586e;

    /* renamed from: f  reason: collision with root package name */
    private HandlerThread f47587f;

    /* renamed from: g  reason: collision with root package name */
    private Handler f47588g;

    private l() {
        HandlerThread handlerThread = new HandlerThread("subThread");
        this.f47587f = handlerThread;
        handlerThread.start();
        this.f47588g = new Handler(this.f47587f.getLooper());
    }

    public static final l a() {
        return f47582a;
    }

    private String a(AGConnectInstance aGConnectInstance, List<ad> list) {
        for (ad next : list) {
            if (next.a().equalsIgnoreCase(aGConnectInstance.getOptions().getRoutePolicy().getRouteName())) {
                return next.b();
            }
        }
        return null;
    }

    /* access modifiers changed from: private */
    public void a(int i11, String str) {
        Calendar instance = Calendar.getInstance();
        instance.add(13, i11);
        long time = instance.getTime().getTime();
        r rVar = this.f47584c.get(str);
        if (rVar != null) {
            rVar.validTime = time;
        }
        Logger.i("AGCHost", "updateTTL:" + time);
        r.a(str, time);
    }

    private void a(final AGConnectInstance aGConnectInstance, long j11) {
        if (!this.f47585d.get() && a(j11)) {
            this.f47585d.set(true);
            this.f47588g.postDelayed(new Runnable() {
                public void run() {
                    Logger.i("AGCHost", "getCachedHostAsync#start");
                    af afVar = new af(aGConnectInstance);
                    afVar.a(l.this.f47586e);
                    BackendService.sendRequest(afVar, 1, ag.class, new BackendService.Options.Builder().app(aGConnectInstance).clientToken(false).build()).addOnCompleteListener(TaskExecutors.immediate(), new OnCompleteListener<ag>() {
                        public void onComplete(Task<ag> task) {
                            int nextInt = new Random().nextInt(172801) + RemoteMessageConst.DEFAULT_TTL;
                            Logger.i("AGCHost", "default ttl=" + nextInt);
                            if (task.isSuccessful()) {
                                ag result = task.getResult();
                                AnonymousClass1 r12 = AnonymousClass1.this;
                                l.this.a(aGConnectInstance, result);
                                try {
                                    nextInt = Integer.parseInt(result.c());
                                } catch (NumberFormatException unused) {
                                    Logger.i("AGCHost", "parse ttl failed, use default instead");
                                }
                            }
                            AnonymousClass1 r52 = AnonymousClass1.this;
                            l.this.a(nextInt, aGConnectInstance.getIdentifier());
                        }
                    });
                }
            }, 5000);
        }
    }

    /* access modifiers changed from: private */
    public void a(AGConnectInstance aGConnectInstance, ag agVar) {
        String a11 = a(aGConnectInstance, agVar.a());
        String a12 = a(aGConnectInstance, agVar.b());
        Logger.d("AGCHost", "cached main host:" + a11);
        Logger.d("AGCHost", "cached backup host:" + a12);
        String identifier = aGConnectInstance.getIdentifier();
        if (TextUtils.isEmpty(a11) || TextUtils.isEmpty(a12)) {
            this.f47584c.remove(identifier);
            r.c(identifier);
            return;
        }
        r rVar = new r(a11, a12);
        this.f47584c.put(identifier, rVar);
        rVar.a(identifier);
    }

    private boolean a(long j11) {
        return Calendar.getInstance().getTime().after(new Date(j11));
    }

    private r b(String str) {
        return r.b(str);
    }

    public List<r> a(AGConnectInstance aGConnectInstance) {
        long j11;
        List<r> list;
        long j12;
        List<r> list2;
        String identifier = aGConnectInstance.getIdentifier();
        if (this.f47583b.containsKey(identifier)) {
            list = this.f47583b.get(identifier);
            j11 = 0;
        } else {
            r rVar = new r(aGConnectInstance.getOptions().getString("agcgw/url"), aGConnectInstance.getOptions().getString("agcgw/backurl"));
            r rVar2 = this.f47584c.get(identifier);
            if (rVar2 != null) {
                j12 = rVar2.validTime;
                list2 = Arrays.asList(new r[]{rVar2, rVar});
            } else {
                r b11 = b(identifier);
                j12 = b11.validTime;
                if (!b11.e()) {
                    list2 = Collections.singletonList(rVar);
                } else {
                    this.f47584c.put(identifier, b11);
                    list2 = Arrays.asList(new r[]{b11, rVar});
                }
            }
            this.f47583b.put(identifier, list2);
            list = list2;
            j11 = j12;
        }
        a(aGConnectInstance, j11);
        return list;
    }

    public void a(String str) {
        if (!"agconnect-credential".equals(str)) {
            this.f47586e = str;
        }
    }
}
