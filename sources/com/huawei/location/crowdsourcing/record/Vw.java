package com.huawei.location.crowdsourcing.record;

import android.os.Build;
import android.telephony.CellIdentity;
import android.telephony.CellIdentityNr;
import android.telephony.CellInfo;
import android.telephony.CellInfoGsm;
import android.telephony.CellInfoLte;
import android.telephony.CellInfoNr;
import android.telephony.CellInfoWcdma;
import android.telephony.CellSignalStrength;
import android.telephony.CellSignalStrengthNr;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.google.gson.annotations.SerializedName;
import com.huawei.location.crowdsourcing.common.entity.yn;
import com.huawei.location.lite.common.log.LogConsole;
import java.util.List;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

class Vw {
    @SerializedName("RAT")
    private int E5;
    @SerializedName("LAC")
    private int FB;
    @SerializedName("CELLID")
    private long LW;
    @SerializedName("MNC")
    private int Vw;
    @SerializedName("CHANNELNUM")

    /* renamed from: d2  reason: collision with root package name */
    private int f50056d2;
    @SerializedName("SIGNALSTRENGTH")
    private int dC;
    @SerializedName("BOOTTIME")

    /* renamed from: ut  reason: collision with root package name */
    private long f50057ut;
    @SerializedName("MCC")

    /* renamed from: yn  reason: collision with root package name */
    private int f50058yn;
    @SerializedName("PHYSICAL_IDENTITY")

    /* renamed from: zp  reason: collision with root package name */
    private int f50059zp;

    public static void Vw(Vw vw2, List<Vw> list) {
        vw2.E5 = 9;
        for (Vw next : list) {
            int i11 = next.E5;
            if (i11 == 4 || i11 == 3) {
                next.E5 = 9;
            }
        }
    }

    public static boolean c(Vw vw2, List<Vw> list) {
        if (vw2.E5 == 3) {
            for (Vw vw3 : list) {
                if (vw3.E5 == 4) {
                    return true;
                }
            }
        }
        return false;
    }

    public void a(yn ynVar) {
        long j11;
        if (!b(ynVar)) {
            LogConsole.d("LocCellInfo", "set cell param failed");
            return;
        }
        int i11 = this.FB;
        int i12 = -1;
        if (i11 == Integer.MAX_VALUE) {
            i11 = -1;
        }
        this.FB = i11;
        if (Build.VERSION.SDK_INT < 29 || !(ynVar.Vw() instanceof CellInfoNr)) {
            int i13 = (int) this.LW;
            if (i13 != Integer.MAX_VALUE) {
                i12 = i13;
            }
            j11 = (long) i12;
        } else {
            j11 = this.LW;
            if (j11 == Long.MAX_VALUE) {
                j11 = -1;
            }
        }
        this.LW = j11;
    }

    public boolean b(yn ynVar) {
        CellInfo Vw2 = ynVar.Vw();
        if (Vw2 instanceof CellInfoGsm) {
            CellInfoGsm cellInfoGsm = (CellInfoGsm) Vw2;
            if (cellInfoGsm != null) {
                this.f50058yn = cellInfoGsm.getCellIdentity().getMcc();
                this.Vw = cellInfoGsm.getCellIdentity().getMnc();
                this.FB = cellInfoGsm.getCellIdentity().getLac();
                this.LW = (long) cellInfoGsm.getCellIdentity().getCid();
                this.dC = cellInfoGsm.getCellSignalStrength().getDbm();
                if (Build.VERSION.SDK_INT >= 24) {
                    this.f50056d2 = cellInfoGsm.getCellIdentity().getArfcn();
                    this.f50059zp = cellInfoGsm.getCellIdentity().getBsic();
                }
                this.E5 = 1;
            }
        } else if (Vw2 instanceof CellInfoWcdma) {
            CellInfoWcdma cellInfoWcdma = (CellInfoWcdma) Vw2;
            if (cellInfoWcdma != null) {
                this.f50058yn = cellInfoWcdma.getCellIdentity().getMcc();
                this.Vw = cellInfoWcdma.getCellIdentity().getMnc();
                this.FB = cellInfoWcdma.getCellIdentity().getLac();
                this.LW = (long) cellInfoWcdma.getCellIdentity().getCid();
                this.dC = cellInfoWcdma.getCellSignalStrength().getDbm();
                if (Build.VERSION.SDK_INT >= 24) {
                    this.f50056d2 = cellInfoWcdma.getCellIdentity().getUarfcn();
                }
                this.f50059zp = cellInfoWcdma.getCellIdentity().getPsc();
                this.E5 = 2;
            }
        } else if (Vw2 instanceof CellInfoLte) {
            CellInfoLte cellInfoLte = (CellInfoLte) Vw2;
            if (cellInfoLte != null) {
                this.f50058yn = cellInfoLte.getCellIdentity().getMcc();
                this.Vw = cellInfoLte.getCellIdentity().getMnc();
                this.FB = cellInfoLte.getCellIdentity().getTac();
                this.LW = (long) cellInfoLte.getCellIdentity().getCi();
                this.dC = cellInfoLte.getCellSignalStrength().getDbm();
                if (Build.VERSION.SDK_INT >= 24) {
                    this.f50056d2 = cellInfoLte.getCellIdentity().getEarfcn();
                }
                this.f50059zp = cellInfoLte.getCellIdentity().getPci();
                this.E5 = 3;
            }
        } else if (Build.VERSION.SDK_INT < 29 || !(Vw2 instanceof CellInfoNr)) {
            LogConsole.e("LocCellInfo", "unknown cellInfo");
            return false;
        } else {
            CellInfoNr cellInfoNr = (CellInfoNr) Vw2;
            if (cellInfoNr != null) {
                CellIdentity a11 = cellInfoNr.getCellIdentity();
                if (a11 instanceof CellIdentityNr) {
                    CellIdentityNr cellIdentityNr = (CellIdentityNr) a11;
                    String a12 = cellIdentityNr.getMccString();
                    String a13 = cellIdentityNr.getMncString();
                    this.dC = Integer.MAX_VALUE;
                    int dbm = cellInfoNr.getCellSignalStrength().getDbm();
                    this.dC = dbm;
                    if (dbm == Integer.MAX_VALUE) {
                        CellSignalStrength a14 = cellInfoNr.getCellSignalStrength();
                        if (a14 instanceof CellSignalStrengthNr) {
                            CellSignalStrengthNr cellSignalStrengthNr = (CellSignalStrengthNr) a14;
                            int a15 = cellSignalStrengthNr.getSsRsrp();
                            int a16 = cellSignalStrengthNr.getSsRsrq();
                            int a17 = cellSignalStrengthNr.getSsSinr();
                            int a18 = cellSignalStrengthNr.getCsiRsrp();
                            int a19 = cellSignalStrengthNr.getCsiRsrq();
                            int a21 = cellSignalStrengthNr.getCsiSinr();
                            if (a15 != Integer.MAX_VALUE && a16 != Integer.MAX_VALUE && a17 != Integer.MAX_VALUE) {
                                if (a15 > 0) {
                                    a15 = -a15;
                                }
                                this.dC = a15;
                            } else if (!(a18 == Integer.MAX_VALUE || a19 == Integer.MAX_VALUE || a21 == Integer.MAX_VALUE)) {
                                if (a18 > 0) {
                                    a18 = -a18;
                                }
                                this.dC = a18;
                            }
                        }
                    }
                    if (this.dC != Integer.MAX_VALUE) {
                        if (!TextUtils.isEmpty(a12)) {
                            this.f50058yn = Integer.parseInt(a12);
                        }
                        if (!TextUtils.isEmpty(a13)) {
                            this.Vw = Integer.parseInt(a13);
                        }
                        this.LW = cellIdentityNr.getNci();
                        this.FB = cellIdentityNr.getTac();
                        this.f50056d2 = cellIdentityNr.getNrarfcn();
                        this.f50059zp = cellIdentityNr.getPci();
                        this.E5 = 4;
                    }
                }
            }
        }
        this.f50057ut = ynVar.yn() / 1000000;
        return true;
    }

    @NonNull
    public String toString() {
        return "LocCellInfo{mcc=" + this.f50058yn + ", mnc=" + this.Vw + ", lac=" + this.FB + ", signalStrength=" + this.dC + ", bootTime=" + this.f50057ut + ", Rat=" + this.E5 + ", channelNum=" + this.f50056d2 + AbstractJsonLexerKt.END_OBJ;
    }

    public boolean yn(Vw vw2) {
        return vw2 != null && this.f50058yn == vw2.f50058yn && this.Vw == vw2.Vw;
    }
}
