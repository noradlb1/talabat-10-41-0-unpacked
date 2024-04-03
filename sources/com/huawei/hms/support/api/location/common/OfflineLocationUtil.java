package com.huawei.hms.support.api.location.common;

import android.net.wifi.ScanResult;
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
import androidx.annotation.RequiresApi;
import com.huawei.hms.support.api.entity.location.offlinelocation.HwCellInfo;
import com.huawei.hms.support.api.entity.location.offlinelocation.HwWifiInfo;
import com.huawei.location.lite.common.log.LogConsole;
import com.huawei.location.lite.common.util.ReflectionUtils;
import java.util.ArrayList;
import java.util.List;

public class OfflineLocationUtil {
    private static final boolean HAS_CELL_INFO_NR = ReflectionUtils.isSupportClass("android.telephony.CellInfoNr");
    private static final int RAT_GSM = 1;
    private static final int RAT_LTE = 3;
    private static final int RAT_NR = 4;
    private static final int RAT_WCDMA = 2;
    private static final String TAG = "OfflineLocationUtil";

    @RequiresApi(api = 29)
    private static int getCellSignalStrength(CellInfoNr cellInfoNr) {
        int dbm = cellInfoNr.getCellSignalStrength().getDbm();
        if (dbm != Integer.MAX_VALUE) {
            return dbm;
        }
        CellSignalStrength a11 = cellInfoNr.getCellSignalStrength();
        if (!(a11 instanceof CellSignalStrengthNr)) {
            return Integer.MAX_VALUE;
        }
        CellSignalStrengthNr cellSignalStrengthNr = (CellSignalStrengthNr) a11;
        int a12 = cellSignalStrengthNr.getSsRsrp();
        int a13 = cellSignalStrengthNr.getSsRsrq();
        int a14 = cellSignalStrengthNr.getSsSinr();
        int a15 = cellSignalStrengthNr.getCsiRsrp();
        int a16 = cellSignalStrengthNr.getCsiRsrq();
        int a17 = cellSignalStrengthNr.getCsiSinr();
        if (a12 != Integer.MAX_VALUE && a13 != Integer.MAX_VALUE && a14 != Integer.MAX_VALUE) {
            return a12 > 0 ? -a12 : a12;
        }
        if (a15 != Integer.MAX_VALUE && a16 != Integer.MAX_VALUE && a17 != Integer.MAX_VALUE) {
            return a15 > 0 ? -a15 : a15;
        }
        LogConsole.d(TAG, "getCellSignalStrength error");
        return dbm;
    }

    private static HwCellInfo parseCellInfo(CellInfo cellInfo) {
        HwCellInfo hwCellInfo = new HwCellInfo();
        if (cellInfo instanceof CellInfoGsm) {
            parseCellInfoGsm((CellInfoGsm) cellInfo, hwCellInfo);
        } else if (cellInfo instanceof CellInfoWcdma) {
            parseCellInfoWcdma((CellInfoWcdma) cellInfo, hwCellInfo);
        } else if (cellInfo instanceof CellInfoLte) {
            parseCellInfoLte((CellInfoLte) cellInfo, hwCellInfo);
        } else if (!HAS_CELL_INFO_NR || Build.VERSION.SDK_INT < 29 || !(cellInfo instanceof CellInfoNr)) {
            LogConsole.i(TAG, "parseCellInfo fail");
            return null;
        } else {
            parseCellInfoNr((CellInfoNr) cellInfo, hwCellInfo);
        }
        hwCellInfo.setTimeStamp(cellInfo.getTimeStamp());
        hwCellInfo.setRegistered(cellInfo.isRegistered());
        return hwCellInfo;
    }

    private static void parseCellInfoGsm(CellInfoGsm cellInfoGsm, HwCellInfo hwCellInfo) {
        hwCellInfo.setMcc(cellInfoGsm.getCellIdentity().getMcc());
        hwCellInfo.setMnc(cellInfoGsm.getCellIdentity().getMnc());
        hwCellInfo.setLacOrTac(cellInfoGsm.getCellIdentity().getLac());
        hwCellInfo.setCellId((long) cellInfoGsm.getCellIdentity().getCid());
        hwCellInfo.setRat(1);
        hwCellInfo.setRssi(cellInfoGsm.getCellSignalStrength().getDbm());
        if (Build.VERSION.SDK_INT >= 24) {
            hwCellInfo.setChannelNumber(cellInfoGsm.getCellIdentity().getArfcn());
            hwCellInfo.setPhysicalIdentity(cellInfoGsm.getCellIdentity().getBsic());
        }
    }

    private static void parseCellInfoLte(CellInfoLte cellInfoLte, HwCellInfo hwCellInfo) {
        hwCellInfo.setMcc(cellInfoLte.getCellIdentity().getMcc());
        hwCellInfo.setMnc(cellInfoLte.getCellIdentity().getMnc());
        hwCellInfo.setLacOrTac(cellInfoLte.getCellIdentity().getTac());
        hwCellInfo.setCellId((long) cellInfoLte.getCellIdentity().getCi());
        hwCellInfo.setRat(3);
        hwCellInfo.setRssi(cellInfoLte.getCellSignalStrength().getDbm());
        hwCellInfo.setPhysicalIdentity(cellInfoLte.getCellIdentity().getPci());
        if (Build.VERSION.SDK_INT >= 24) {
            hwCellInfo.setChannelNumber(cellInfoLte.getCellIdentity().getEarfcn());
        }
    }

    @RequiresApi(api = 29)
    private static void parseCellInfoNr(CellInfoNr cellInfoNr, HwCellInfo hwCellInfo) {
        CellIdentity a11 = cellInfoNr.getCellIdentity();
        if (a11 instanceof CellIdentityNr) {
            CellIdentityNr cellIdentityNr = (CellIdentityNr) a11;
            try {
                hwCellInfo.setMcc(Integer.parseInt(cellIdentityNr.getMccString()));
                hwCellInfo.setMnc(Integer.parseInt(cellIdentityNr.getMncString()));
            } catch (NumberFormatException unused) {
                LogConsole.e(TAG, "parse cellInfoNr mcc/mnc failed");
            }
            hwCellInfo.setLacOrTac(cellIdentityNr.getTac());
            hwCellInfo.setCellId(cellIdentityNr.getNci());
            hwCellInfo.setRat(4);
            hwCellInfo.setPhysicalIdentity(cellIdentityNr.getPci());
            hwCellInfo.setChannelNumber(cellIdentityNr.getNrarfcn());
            hwCellInfo.setRssi(getCellSignalStrength(cellInfoNr));
        }
    }

    private static void parseCellInfoWcdma(CellInfoWcdma cellInfoWcdma, HwCellInfo hwCellInfo) {
        hwCellInfo.setMcc(cellInfoWcdma.getCellIdentity().getMcc());
        hwCellInfo.setMnc(cellInfoWcdma.getCellIdentity().getMnc());
        hwCellInfo.setLacOrTac(cellInfoWcdma.getCellIdentity().getLac());
        hwCellInfo.setCellId((long) cellInfoWcdma.getCellIdentity().getCid());
        hwCellInfo.setRat(2);
        hwCellInfo.setRssi(cellInfoWcdma.getCellSignalStrength().getDbm());
        hwCellInfo.setPhysicalIdentity(cellInfoWcdma.getCellIdentity().getPsc());
        if (Build.VERSION.SDK_INT >= 24) {
            hwCellInfo.setChannelNumber(cellInfoWcdma.getCellIdentity().getUarfcn());
        }
    }

    public static List<HwCellInfo> transformCellInfo(List<CellInfo> list) {
        if (list == null || list.size() == 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (CellInfo parseCellInfo : list) {
            HwCellInfo parseCellInfo2 = parseCellInfo(parseCellInfo);
            if (parseCellInfo2 != null) {
                arrayList.add(parseCellInfo2);
            }
        }
        LogConsole.i(TAG, "transformCellInfo end,size is:" + arrayList.size());
        return arrayList;
    }

    public static List<HwWifiInfo> transformWifiInfo(List<ScanResult> list) {
        if (list == null || list.size() == 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (ScanResult next : list) {
            HwWifiInfo hwWifiInfo = new HwWifiInfo();
            try {
                hwWifiInfo.setBssid(next.BSSID);
            } catch (NumberFormatException unused) {
                LogConsole.e(TAG, "parse bssid failed");
            }
            hwWifiInfo.setRssi(next.level);
            hwWifiInfo.setFrequency(next.frequency);
            hwWifiInfo.setTimestamp(next.timestamp);
            arrayList.add(hwWifiInfo);
        }
        LogConsole.i(TAG, "transformWifiInfo end,size is:" + arrayList.size());
        return arrayList;
    }
}
