package com.huawei.riemann.location;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.Messenger;
import android.util.Log;
import androidx.annotation.NonNull;
import com.huawei.riemann.common.api.location.CityTileCallback;
import com.huawei.riemann.location.bean.obs.Pvt;
import com.talabat.talabatnavigation.sdsquad.SdSquadActions;
import java.util.ArrayList;
import java.util.Iterator;

public final class yn {
    public dC E5;
    public boolean FB;
    public SdmLocationAlgoWrapper G3;
    public ServiceConnection LW;
    public boolean Ot;
    public final Object Vw;
    public CityTileCallback Yx;

    /* renamed from: d2  reason: collision with root package name */
    public FB f50484d2;
    public Messenger dC;
    public volatile boolean dW;

    /* renamed from: h1  reason: collision with root package name */
    public CityTileCallback f50485h1;

    /* renamed from: oc  reason: collision with root package name */
    public Intent f50486oc;

    /* renamed from: ut  reason: collision with root package name */
    public ArrayList<com.huawei.riemann.common.api.location.yn> f50487ut;

    /* renamed from: yn  reason: collision with root package name */
    public Context f50488yn;

    /* renamed from: zp  reason: collision with root package name */
    public LW f50489zp;

    public class E5 implements Runnable {
        public byte[] Vw;

        /* renamed from: yn  reason: collision with root package name */
        public long f50490yn;

        public E5(long j11, byte[] bArr) {
            this.f50490yn = j11;
            this.Vw = bArr;
        }

        public void run() {
            SdmLocationAlgoWrapper sdmLocationAlgoWrapper = yn.this.G3;
            if (sdmLocationAlgoWrapper == null || !sdmLocationAlgoWrapper.FB) {
                Log.e("SdmLocationManager", "wp is null");
            } else {
                sdmLocationAlgoWrapper.sdmUpdateTileById(this.f50490yn, this.Vw);
            }
        }
    }

    public static class FB extends HandlerThread {

        /* renamed from: yn  reason: collision with root package name */
        public yn f50491yn;

        public FB(String str, yn ynVar) {
            super(str);
            this.f50491yn = ynVar;
        }

        public void onLooperPrepared() {
            super.onLooperPrepared();
            if (this.f50491yn == null) {
                Log.i("SdmLocationManager", "slmgr null");
            }
        }
    }

    public class LW extends Handler {
        public LW(Looper looper) {
            super(looper);
        }

        public void handleMessage(@NonNull Message message) {
            String str;
            String str2 = null;
            try {
                super.handleMessage(message);
                int i11 = message.what;
                if (i11 == 11) {
                    str2 = "handleMessage REGISTER LISTENER";
                    Object obj = message.obj;
                    if (obj instanceof com.huawei.riemann.common.api.location.yn) {
                        yn.this.f50487ut.add((com.huawei.riemann.common.api.location.yn) obj);
                    }
                } else if (i11 == 12) {
                    str2 = "handleMessage UNREGISTER LISTENER";
                    Object obj2 = message.obj;
                    if (obj2 instanceof com.huawei.riemann.common.api.location.yn) {
                        yn.this.f50487ut.remove((com.huawei.riemann.common.api.location.yn) obj2);
                    }
                } else if (i11 == 17) {
                } else {
                    if (i11 != 18) {
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append("handleMessage unknown ");
                        sb2.append(message.what);
                        return;
                    }
                    str2 = "handleMessage REQUEST REMOTE TILE";
                    Bundle data = message.getData();
                    if (data == null) {
                        Log.e("SdmLocationManager", "bundle is null");
                        return;
                    }
                    long j11 = data.getLong(SdSquadActions.ARG_TILE_ID);
                    CityTileCallback cityTileCallback = yn.this.f50485h1;
                    if (cityTileCallback != null) {
                        byte[] bArr = cityTileCallback.get(j11);
                        yn ynVar = yn.this;
                        ynVar.getClass();
                        dC dCVar = ynVar.E5;
                        if (dCVar != null) {
                            dCVar.postAtFrontOfQueue(new E5(j11, bArr));
                            return;
                        }
                        str = "result hd is null";
                    } else {
                        str = "rcb null";
                    }
                    Log.e("SdmLocationManager", str);
                }
            } catch (ClassCastException e11) {
                Log.e("SdmLocationManager", e11.getMessage() != null ? e11.getMessage() : "ClassCastException2");
                if (str2 == null) {
                    str2 = "handleMessage";
                }
                Log.e("SdmLocationManager", "SdmOpsHandler-" + str2);
            }
        }
    }

    public static class Vw implements CityTileCallback {
        public Handler Vw;

        /* renamed from: yn  reason: collision with root package name */
        public CityTileCallback f50493yn;

        public Vw(Handler handler, CityTileCallback cityTileCallback) {
            this.Vw = handler;
            this.f50493yn = cityTileCallback;
        }

        public byte[] get(long j11) {
            if (this.Vw != null) {
                Bundle bundle = new Bundle();
                bundle.putLong(SdSquadActions.ARG_TILE_ID, j11);
                Message obtain = Message.obtain();
                obtain.what = 18;
                obtain.setData(bundle);
                this.Vw.sendMessageAtFrontOfQueue(obtain);
                return new byte[0];
            } else if (this.f50493yn != null) {
                return this.f50493yn.get(j11);
            } else {
                Log.e("SdmLocationManager", "hd and remote cb null");
                return new byte[0];
            }
        }
    }

    public class dC extends Handler {
        public dC() {
        }

        public dC(Looper looper) {
            super(looper);
        }

        public void handleMessage(@NonNull Message message) {
            String str = null;
            try {
                super.handleMessage(message);
                StringBuilder sb2 = new StringBuilder();
                sb2.append("SdmHandler msg - ");
                sb2.append(message.what);
                int i11 = message.what;
                if (i11 == 10001) {
                    Message obtain = Message.obtain();
                    obtain.what = 10002;
                    obtain.setData(message.getData());
                    yn.this.E5.sendMessageAtFrontOfQueue(obtain);
                } else if (i11 == 10002) {
                    str = "handleMessage INVOKE CALLBACK";
                    Bundle data = message.getData();
                    if (data == null) {
                        Log.e("SdmLocationManager", "bundle is null");
                        return;
                    }
                    Pvt pvt = (Pvt) data.getParcelable("imp-pvt");
                    Iterator<com.huawei.riemann.common.api.location.yn> it = yn.this.f50487ut.iterator();
                    while (it.hasNext()) {
                        it.next().yn(pvt);
                    }
                }
            } catch (ClassCastException e11) {
                Log.e("SdmLocationManager", e11.getMessage() != null ? e11.getMessage() : "ClassCastException1");
                if (str == null) {
                    str = "handleMessage";
                }
                Log.e("SdmLocationManager", "SdmResultHandler-" + str);
            }
        }
    }

    /* renamed from: com.huawei.riemann.location.yn$yn  reason: collision with other inner class name */
    public class C0094yn implements ServiceConnection {
        public C0094yn() {
        }

        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            yn.this.dC = new Messenger(iBinder);
            boolean unused = yn.this.FB = true;
        }

        public void onServiceDisconnected(ComponentName componentName) {
            yn ynVar = yn.this;
            ynVar.dC = null;
            boolean unused = ynVar.FB = false;
        }
    }

    public yn(Context context, Intent intent, Looper looper, String str) {
        this.Vw = new Object();
        this.FB = false;
        this.dC = null;
        this.f50487ut = new ArrayList<>();
        this.f50486oc = null;
        this.Ot = false;
        this.G3 = null;
        this.Yx = null;
        this.f50485h1 = null;
        this.dW = false;
        this.LW = new C0094yn();
        this.f50488yn = context;
        this.f50486oc = intent;
        this.G3 = SdmLocationAlgoWrapper.yn(context, str);
        yn(looper);
        com.huawei.location.LW.yn();
    }

    public yn(Context context, Intent intent, String str) {
        this(context, intent, (Looper) null, str);
    }

    public yn(Context context, Looper looper, String str) {
        this(context, (Intent) null, looper, str);
    }

    public yn(Context context, String str) {
        this(context, (Intent) null, (Looper) null, str);
    }

    public final void yn(Looper looper) {
        if (!this.Ot) {
            if (looper == null) {
                this.E5 = Looper.myLooper() == null ? new dC(this.f50488yn.getMainLooper()) : new dC();
            } else {
                this.E5 = new dC(looper);
            }
            FB fb2 = new FB("SdmLocationManagerThread", this);
            this.f50484d2 = fb2;
            fb2.start();
            this.f50489zp = new LW(this.f50484d2.getLooper());
        }
        this.Ot = true;
    }
}
