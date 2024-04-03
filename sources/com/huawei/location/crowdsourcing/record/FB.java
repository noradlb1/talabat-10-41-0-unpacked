package com.huawei.location.crowdsourcing.record;

import android.net.wifi.ScanResult;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.google.gson.annotations.SerializedName;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

class FB {
    private int E5;
    @SerializedName("RSSI")
    private int FB;
    @SerializedName("Frequency")
    private int LW;
    @SerializedName("SSID")
    private String Vw;
    @SerializedName("SCANTIME")

    /* renamed from: d2  reason: collision with root package name */
    private long f50054d2;
    @SerializedName("IsConnect")
    private int dC;
    @SerializedName("BSSID")

    /* renamed from: yn  reason: collision with root package name */
    private String f50055yn;

    public void a(ScanResult scanResult, String str) {
        boolean z11;
        String str2 = scanResult.BSSID;
        this.f50055yn = str2;
        this.Vw = scanResult.SSID;
        this.FB = scanResult.level;
        this.LW = scanResult.frequency;
        int i11 = 0;
        if (TextUtils.isEmpty(str)) {
            z11 = false;
        } else {
            z11 = str.equals(str2);
        }
        this.dC = z11 ? 1 : 0;
        if (scanResult.is80211mcResponder()) {
            i11 = 2;
        } else {
            String str3 = scanResult.capabilities;
            if (!str3.contains("PSK") && !str3.contains("WEP")) {
                i11 = 1;
            }
        }
        this.E5 = i11;
        this.f50054d2 = scanResult.timestamp / 1000;
    }

    @NonNull
    public String toString() {
        return "LocWifiInfo{ssid='" + this.Vw + '\'' + ", rssi=" + this.FB + ", frequency=" + this.LW + ", isConnect=" + this.dC + ", type=" + this.E5 + ", scanTime=" + this.f50054d2 + AbstractJsonLexerKt.END_OBJ;
    }

    public long yn() {
        return this.f50054d2;
    }
}
