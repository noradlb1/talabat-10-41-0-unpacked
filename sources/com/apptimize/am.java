package com.apptimize;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import android.os.TransactionTooLargeException;
import com.apptimize.bq;
import com.braze.ui.actions.brazeactions.steps.StepData;
import com.facebook.internal.NativeProtocol;
import com.facebook.internal.security.CertificateUtil;
import j$.util.concurrent.ConcurrentHashMap;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

class am extends al {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public static final String f41156a = "am";

    /* renamed from: q  reason: collision with root package name */
    private static Messenger f41157q;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public final bq f41158b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public final int f41159c;

    /* renamed from: d  reason: collision with root package name */
    private final Context f41160d;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public final ak f41161e;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public final boolean f41162f;

    /* renamed from: g  reason: collision with root package name */
    private Messenger f41163g = null;

    /* renamed from: h  reason: collision with root package name */
    private ah f41164h;

    /* renamed from: i  reason: collision with root package name */
    private long f41165i = 0;
    /* access modifiers changed from: private */

    /* renamed from: j  reason: collision with root package name */
    public Map<Integer, Messenger> f41166j = new ConcurrentHashMap();

    /* renamed from: k  reason: collision with root package name */
    private Set<Integer> f41167k = Collections.newSetFromMap(new ConcurrentHashMap());
    /* access modifiers changed from: private */

    /* renamed from: l  reason: collision with root package name */
    public Map<String, Bundle> f41168l = new ConcurrentHashMap();
    /* access modifiers changed from: private */

    /* renamed from: m  reason: collision with root package name */
    public Map<String, Bundle> f41169m = new ConcurrentHashMap();

    /* renamed from: n  reason: collision with root package name */
    private boolean f41170n = false;

    /* renamed from: o  reason: collision with root package name */
    private Map<String, Set<Integer>> f41171o = new ConcurrentHashMap();

    /* renamed from: p  reason: collision with root package name */
    private int f41172p = 0;

    public class a extends Handler {
        public a(Looper looper) {
            super(looper);
        }

        public void handleMessage(final Message message) {
            if (av.f41239b || am.this.f41162f) {
                String c11 = am.f41156a;
                bo.k(c11, "server handleMessage " + message.what + " msg.arg1:" + message.arg1);
            }
            fe.a(am.f41156a, new fi() {
                public void run() {
                    Message message = message;
                    switch (message.what) {
                        case 1:
                            am.this.b(message);
                            return;
                        case 2:
                            am.this.a(message);
                            return;
                        case 3:
                            am.this.a(message, true);
                            return;
                        case 4:
                            am.this.c(message);
                            return;
                        case 5:
                            am.this.d(message);
                            return;
                        case 6:
                            am.this.d();
                            return;
                        default:
                            a.super.handleMessage(message);
                            return;
                    }
                }
            });
        }
    }

    public am(ak akVar, Context context, bq bqVar, int i11, boolean z11) {
        this.f41161e = akVar;
        this.f41160d = context;
        this.f41158b = bqVar;
        this.f41159c = i11;
        this.f41162f = z11;
        if (z11) {
            ah a11 = ah.a();
            this.f41164h = a11;
            this.f41165i = a11.getId();
            Messenger messenger = new Messenger(new a(this.f41164h.b()));
            this.f41163g = messenger;
            f41157q = messenger;
        }
    }

    /* access modifiers changed from: private */
    public void d(Message message) {
        if (this.f41172p == message.arg1) {
            this.f41172p = 0;
        }
    }

    /* access modifiers changed from: private */
    public void e() {
        Set<Integer> k11 = c.k(this.f41160d);
        Iterator<Integer> it = this.f41167k.iterator();
        while (it.hasNext()) {
            Integer next = it.next();
            if (!k11.contains(next)) {
                String str = f41156a;
                bo.k(str, "Removing client PID " + next);
                it.remove();
                this.f41166j.remove(next);
            }
        }
    }

    public static Messenger b() {
        return f41157q;
    }

    /* access modifiers changed from: private */
    public void c(Message message) {
        Message obtain = Message.obtain();
        int i11 = message.arg1;
        obtain.what = 5;
        int i12 = this.f41172p;
        if (i12 == i11 || i12 == 0) {
            this.f41172p = i11;
            obtain.what = 4;
        }
        a(message.replyTo, obtain, i11);
    }

    /* access modifiers changed from: private */
    public void d() {
        if (!this.f41170n) {
            this.f41170n = true;
            Message obtain = Message.obtain();
            obtain.what = 6;
            for (Map.Entry next : this.f41166j.entrySet()) {
                a((Messenger) next.getValue(), obtain, ((Integer) next.getKey()).intValue());
            }
        }
    }

    public void b(Message message) {
        int i11 = message.getData().getInt("pid");
        String str = f41156a;
        bo.k(str, "Adding client with PID " + i11);
        this.f41167k.add(Integer.valueOf(i11));
        this.f41166j.put(Integer.valueOf(i11), message.replyTo);
        Message obtain = Message.obtain();
        obtain.what = 1;
        a(message.replyTo, obtain, i11);
        if (this.f41170n) {
            Message obtain2 = Message.obtain();
            obtain2.what = 6;
            a(message.replyTo, obtain2, i11);
            return;
        }
        if (i11 != this.f41159c) {
            a(message.replyTo, this.f41169m, i11);
        }
        a(message.replyTo, this.f41168l, i11);
    }

    public Messenger a() {
        if (this.f41163g == null) {
            bo.k(f41156a, "incomingMessenger is null. creating new one");
            ah a11 = ah.a();
            this.f41164h = a11;
            this.f41165i = a11.getId();
            this.f41163g = new Messenger(new a(this.f41164h.b()));
        }
        String str = f41156a;
        bo.k(str, "incomingMessenger is " + this.f41163g);
        return this.f41163g;
    }

    /* access modifiers changed from: private */
    public Set<Integer> a(String str) {
        if (!this.f41171o.containsKey(str)) {
            this.f41171o.put(str, Collections.newSetFromMap(new ConcurrentHashMap()));
        }
        return this.f41171o.get(str);
    }

    private void a(Messenger messenger, Map<String, Bundle> map, int i11) {
        for (Map.Entry<String, Bundle> value : map.entrySet()) {
            Message obtain = Message.obtain();
            obtain.what = 3;
            obtain.setData((Bundle) value.getValue());
            a(messenger, obtain, i11);
        }
    }

    /* access modifiers changed from: private */
    public void a(Messenger messenger, Message message, int i11) {
        boolean z11 = true;
        int i12 = 0;
        while (z11 && i12 < 3) {
            try {
                messenger.send(message);
            } catch (RemoteException e11) {
                if (TransactionTooLargeException.class.isAssignableFrom(e11.getClass())) {
                    try {
                        Thread.sleep(30);
                    } catch (InterruptedException unused) {
                    }
                    z11 = true;
                } else {
                    bo.e(f41156a, "Error", e11);
                    if (this.f41172p == i11) {
                        this.f41172p = 0;
                    }
                }
            }
            z11 = false;
            i12++;
        }
    }

    public void a(final Message message) {
        this.f41161e.b((fi) new fi() {
            public void run() {
                Bundle data = message.getData();
                String string = data.getString("state_provider");
                String string2 = data.getString("action_name");
                long j11 = data.getLong("checksum");
                Object[] objArr = (Object[]) data.getSerializable(StepData.ARGS);
                ap a11 = am.this.f41161e.a(string);
                int i11 = data.getInt("pid");
                am.this.a(string).add(Integer.valueOf(i11));
                if (i11 != am.this.f41159c) {
                    String c11 = am.f41156a;
                    bo.k(c11, "performStateChange actionName:" + string2 + " providerName:" + string);
                    long a12 = a11.a(string2, objArr);
                    if (am.this.a(string).size() == 1 && j11 != a12) {
                        am.this.a(string).add(Integer.valueOf(am.this.f41159c));
                        bo.e(am.f41156a, String.format("Mismatch in checksum when processing action %s  for state provider %s, args %s. Expected: %d; Actual: %d", new Object[]{string2, string, Arrays.toString(objArr), Long.valueOf(j11), Long.valueOf(a12)}));
                        am.this.f41158b.a(bq.b.MultiprocessChecksumMismatch, (Map<String, Object>) new HashMap<String, Object>(string, string2, objArr, j11, a12) {

                            /* renamed from: a  reason: collision with root package name */
                            final /* synthetic */ String f41175a;

                            /* renamed from: b  reason: collision with root package name */
                            final /* synthetic */ String f41176b;

                            /* renamed from: c  reason: collision with root package name */
                            final /* synthetic */ Object[] f41177c;

                            /* renamed from: d  reason: collision with root package name */
                            final /* synthetic */ long f41178d;

                            /* renamed from: e  reason: collision with root package name */
                            final /* synthetic */ long f41179e;

                            {
                                this.f41175a = r3;
                                this.f41176b = r4;
                                this.f41177c = r5;
                                this.f41178d = r6;
                                this.f41179e = r8;
                                put("where", "performStateChange");
                                put("provider", r3);
                                put(NativeProtocol.WEB_DIALOG_ACTION, r4);
                                put(StepData.ARGS, Arrays.toString(r5));
                                put("msgChecksum", Long.valueOf(r6));
                                put("myChecksum", Long.valueOf(r8));
                            }
                        });
                    }
                }
                a11.a().c();
            }
        });
    }

    public void a(final Message message, final boolean z11) {
        this.f41161e.b((fi) new fi() {
            public void run() {
                am.this.e();
                for (Map.Entry entry : am.this.f41166j.entrySet()) {
                    if (z11 || ((Integer) entry.getKey()).intValue() != am.this.f41159c) {
                        Message obtain = Message.obtain(message);
                        obtain.what = 3;
                        am.this.a((Messenger) entry.getValue(), obtain, ((Integer) entry.getKey()).intValue());
                    }
                }
                Bundle data = message.getData();
                String str = data.getString("state_provider") + CertificateUtil.DELIMITER + data.getString("action_name");
                if (z11) {
                    am.this.f41168l.put(str, data);
                } else {
                    am.this.f41169m.put(str, data);
                }
            }
        });
    }

    public void a(final String str, final String str2, final Object... objArr) {
        this.f41161e.b((fi) new fi() {
            /* JADX WARNING: type inference failed for: r2v4, types: [java.lang.Object[], java.io.Serializable] */
            public void run() {
                fd.b((Object) objArr);
                Bundle bundle = new Bundle();
                bundle.putString("state_provider", str);
                bundle.putString("action_name", str2);
                bundle.putLong("checksum", 0);
                bundle.putInt("pid", am.this.f41159c);
                bundle.putSerializable(StepData.ARGS, objArr);
                Message obtain = Message.obtain();
                obtain.what = 3;
                obtain.setData(bundle);
                am.this.a(obtain, false);
            }
        });
    }

    /* access modifiers changed from: private */
    public boolean a(int i11, String str) {
        return a(str).size() == 1 && a(str).contains(Integer.valueOf(i11));
    }

    public void a(final String str, final ft<Long> ftVar) {
        this.f41161e.b((fi) new fi() {
            public void run() {
                am.this.e();
                Bundle bundle = new Bundle();
                bundle.putString("state_provider", str);
                bundle.putLong("checksum", ((Long) ftVar.b()).longValue());
                Message obtain = Message.obtain();
                obtain.what = 2;
                obtain.setData(bundle);
                for (Map.Entry entry : am.this.f41166j.entrySet()) {
                    if (!((Integer) entry.getKey()).equals(Integer.valueOf(am.this.f41159c)) && !am.this.a(((Integer) entry.getKey()).intValue(), str)) {
                        am.this.a((Messenger) entry.getValue(), Message.obtain(obtain), ((Integer) entry.getKey()).intValue());
                    }
                }
                am.this.a(str).clear();
            }
        });
    }

    public boolean a(long j11) {
        return j11 == this.f41165i;
    }
}
