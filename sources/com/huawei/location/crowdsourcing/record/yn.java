package com.huawei.location.crowdsourcing.record;

import android.content.Context;
import android.location.Location;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.SystemClock;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.google.gson.annotations.SerializedName;
import com.huawei.location.lite.common.log.LogConsole;
import com.huawei.secure.android.common.intent.SafeBundle;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

public class yn {
    @SerializedName("ACC")
    private int E5;
    @SerializedName("SRCTYPE")
    private int EF;
    @SerializedName("LAT")
    private String FB;
    @SerializedName("BOOTTIME")
    private long G3;
    @SerializedName("LON")
    private String LW;
    @SerializedName("ARSTATUS")
    private int OB;
    @SerializedName("DIFF_TIME")
    private long Ot = 2147483647L;
    @SerializedName("HappenTime")
    private String Vw;
    @SerializedName("AVGPRESSURE")
    private float Wf;
    @SerializedName("CURRENTCELL")
    private List<Vw> Yx;
    @SerializedName("BEARING")

    /* renamed from: d2  reason: collision with root package name */
    private int f50060d2;
    @SerializedName("ALT")
    private String dC;
    @SerializedName("WIFIAPINFO")
    private List<FB> dW;
    @SerializedName("NEIGHBORCELL")

    /* renamed from: h1  reason: collision with root package name */
    private List<Vw> f50061h1;
    @SerializedName("TYPE")

    /* renamed from: oc  reason: collision with root package name */
    private int f50062oc;
    @SerializedName("FIX_TIME")

    /* renamed from: ut  reason: collision with root package name */
    private long f50063ut;

    /* renamed from: yn  reason: collision with root package name */
    private transient long f50064yn;
    @SerializedName("SPEED")

    /* renamed from: zp  reason: collision with root package name */
    private int f50065zp;

    public String toString() {
        return "CommonParam{happenTime='" + this.Vw + '\'' + ", latitude=" + this.FB + ", longitude=" + this.LW + ", altitude=" + this.dC + ", accuracy=" + this.E5 + ", bearing=" + this.f50060d2 + ", speed=" + this.f50065zp + ", locationTime=" + this.f50063ut + ", type=" + this.f50062oc + ", diffTime=" + this.Ot + ", bootTime=" + this.G3 + ", currentCells=" + this.Yx + ", neighborCells=" + this.f50061h1 + ", wifiInfos=" + this.dW + ", avgPressure=" + this.Wf + ", sourceType=" + this.EF + ", arStatus=" + this.OB + ", locationBootTime=" + this.f50064yn + AbstractJsonLexerKt.END_OBJ;
    }

    public void yn(Location location) {
        this.Vw = new SimpleDateFormat("yyyyMMddHHmmss", Locale.US).format(new Date());
        if (location != null) {
            double latitude = location.getLatitude();
            this.FB = latitude + "";
            double longitude = location.getLongitude();
            this.LW = longitude + "";
            double altitude = location.getAltitude();
            this.dC = altitude + "";
            this.E5 = (int) location.getAccuracy();
            this.f50060d2 = (int) location.getBearing();
            this.f50065zp = (int) location.getSpeed();
            this.f50063ut = location.getTime();
            this.f50064yn = (location.getElapsedRealtimeNanos() / 1000) / 1000;
            String provider = location.getProvider();
            this.f50062oc = (!TextUtils.isEmpty(provider) && provider.equals("gps")) ? 0 : 1;
            this.EF = new SafeBundle(location.getExtras()).getInt("SourceType", -1);
        }
        this.G3 = SystemClock.elapsedRealtime();
        this.Wf = 0.0f;
    }

    public void yn(@NonNull List<com.huawei.location.crowdsourcing.common.entity.yn> list) {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (com.huawei.location.crowdsourcing.common.entity.yn next : list) {
            if (next.Vw().isRegistered()) {
                Vw vw2 = new Vw();
                vw2.b(next);
                arrayList.add(vw2);
            } else {
                Vw vw3 = new Vw();
                vw3.a(next);
                arrayList2.add(vw3);
            }
        }
        if (arrayList2.size() != 0) {
            if (arrayList.size() == 1) {
                if (Vw.c((Vw) arrayList.get(0), arrayList2)) {
                    Vw.Vw((Vw) arrayList.get(0), arrayList2);
                }
            } else if (arrayList.size() == 2) {
                Vw vw4 = (Vw) arrayList.get(0);
                Vw vw5 = (Vw) arrayList.get(1);
                if ((vw4 == null || vw5 == null) ? false : vw4.yn(vw5)) {
                    boolean c11 = Vw.c(vw4, arrayList2);
                    boolean c12 = Vw.c(vw5, arrayList2);
                    if (c11) {
                        Vw.Vw(vw4, arrayList2);
                    }
                    if (c12) {
                        Vw.Vw(vw5, arrayList2);
                    }
                } else {
                    Vw vw6 = (Vw) arrayList.get(0);
                    Vw vw7 = (Vw) arrayList.get(1);
                    ArrayList arrayList3 = new ArrayList(arrayList2.size());
                    ArrayList arrayList4 = new ArrayList(arrayList2.size());
                    Iterator it = arrayList2.iterator();
                    while (it.hasNext()) {
                        Vw vw8 = (Vw) it.next();
                        if (vw6.yn(vw8)) {
                            arrayList3.add(vw8);
                        } else if (vw7.yn(vw8)) {
                            arrayList4.add(vw8);
                        } else {
                            LogConsole.d("LocCellInfo", "neighborCellBy5GRules: not fit");
                        }
                    }
                    if (Vw.c(vw4, arrayList3)) {
                        Vw.Vw(vw4, arrayList3);
                    }
                    if (Vw.c(vw5, arrayList4)) {
                        Vw.Vw(vw5, arrayList4);
                    }
                }
            } else {
                LogConsole.d("LocCellInfo", "neighborCellBy5GRules: Not supported Three SIM Card");
            }
        }
        this.Yx = arrayList;
        this.f50061h1 = arrayList2;
    }

    public void yn(List<ScanResult> list, Context context) {
        if (!list.isEmpty()) {
            ArrayList arrayList = new ArrayList();
            Object systemService = context.getApplicationContext().getSystemService("wifi");
            String str = "";
            if (!(systemService instanceof WifiManager)) {
                LogConsole.d("LocWifiInfo", "not get WIFI_SERVICE");
            } else {
                WifiInfo connectionInfo = ((WifiManager) systemService).getConnectionInfo();
                if (connectionInfo != null) {
                    str = connectionInfo.getBSSID();
                }
            }
            for (ScanResult a11 : list) {
                FB fb2 = new FB();
                fb2.a(a11, str);
                this.Ot = Math.min(this.Ot, (long) ((int) Math.abs(this.f50064yn - fb2.yn())));
                arrayList.add(fb2);
            }
            this.dW = arrayList;
        }
    }
}
