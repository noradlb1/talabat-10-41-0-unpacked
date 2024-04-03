package com.huawei.location.nlp.scan;

import android.os.Build;
import android.os.SystemClock;
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
import android.util.Pair;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import com.huawei.location.lite.common.log.LogConsole;
import com.huawei.location.lite.common.util.ReflectionUtils;
import com.huawei.location.nlp.api.Vw;
import com.huawei.location.nlp.network.request.cell.CellSourceInfo;
import com.huawei.location.nlp.network.request.cell.CurrentCell;
import com.huawei.location.nlp.network.request.cell.HwCellInfo;
import com.huawei.location.nlp.network.request.cell.HwNeighborCellInfo;
import com.huawei.location.nlp.network.request.cell.NeighborCell;
import com.huawei.location.nlp.network.request.wifi.WifiInfo;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import net.bytebuddy.utility.JavaConstant;

public class LW {
    private boolean FB;

    /* renamed from: a  reason: collision with root package name */
    public Vw f50193a;

    /* renamed from: b  reason: collision with root package name */
    public long f50194b = 30000;

    public LW(Vw vw2) {
        this.f50193a = vw2;
        this.FB = ReflectionUtils.isSupportClass("android.telephony.CellInfoNr");
    }

    private void yn(long j11, long j12, long j13, HwCellInfo hwCellInfo) {
        if (j13 > 5000000000L) {
            long boottime = hwCellInfo.getBoottime();
            if (Math.abs(j11 - boottime) <= 30000000000L && Math.abs(j12 - boottime) >= 30000000000L) {
                hwCellInfo.setBoottime(boottime + j13);
                LogConsole.i("ScanBase", "amendCellTimeStamp bootTime is " + hwCellInfo.getBoottime());
            }
        }
    }

    private boolean yn(@NonNull HwCellInfo hwCellInfo) {
        if (hwCellInfo.getMcc() < 1 || hwCellInfo.getMcc() >= Integer.MAX_VALUE) {
            LogConsole.w("ScanBase", "hwCellInfo is invalid, mcc error");
            return false;
        } else if (hwCellInfo.getMnc() < 0 || hwCellInfo.getMnc() >= Integer.MAX_VALUE) {
            LogConsole.w("ScanBase", "hwCellInfo is invalid, mnc error");
            return false;
        } else if (hwCellInfo.getRssi() < -139 || hwCellInfo.getRssi() > -1) {
            LogConsole.w("ScanBase", "hwCellInfo is invalid, rssi error");
            return false;
        } else {
            int rat = hwCellInfo.getRat();
            long cellId = hwCellInfo.getCellId();
            if (!(rat != 4 ? !(cellId < 1 || hwCellInfo.getCellId() >= 2147483647L) : !(cellId < 1 || hwCellInfo.getCellId() >= Long.MAX_VALUE))) {
                LogConsole.w("ScanBase", "hwCellInfo is invalid, cellId error");
                return false;
            }
            if (!(hwCellInfo.getRat() != 4 ? !(hwCellInfo.getLac() < 0 || hwCellInfo.getLac() > 65535) : !(hwCellInfo.getLac() < 0 || hwCellInfo.getLac() > 16777215))) {
                LogConsole.w("ScanBase", "hwCellInfo is invalid, lac error");
                return false;
            } else if (hwCellInfo.getChannelNumber() >= 1 && hwCellInfo.getChannelNumber() < Integer.MAX_VALUE) {
                return true;
            } else {
                LogConsole.w("ScanBase", "hwCellInfo is invalid, channelNumber error");
                return false;
            }
        }
    }

    public static boolean yn(List<WifiInfo> list, List<WifiInfo> list2) {
        if (list2 == null || list2.isEmpty() || list.isEmpty()) {
            LogConsole.e("ScanBase", "wifi cache is null");
            return false;
        } else if (list.size() != list2.size()) {
            return false;
        } else {
            HashMap hashMap = new HashMap();
            for (int i11 = 0; i11 < list2.size(); i11++) {
                WifiInfo wifiInfo = list2.get(i11);
                hashMap.put(String.valueOf(wifiInfo.getMac()), String.valueOf(wifiInfo.getRssi()));
            }
            for (int i12 = 0; i12 < list.size(); i12++) {
                WifiInfo wifiInfo2 = list.get(i12);
                String valueOf = String.valueOf(wifiInfo2.getMac());
                if (!hashMap.containsKey(valueOf) || !TextUtils.equals((CharSequence) hashMap.get(valueOf), String.valueOf(wifiInfo2.getRssi()))) {
                    return false;
                }
            }
            return true;
        }
    }

    public Pair<Long, List<CellSourceInfo>> Vw(List<CellInfo> list) {
        ArrayList arrayList = new ArrayList();
        if (list.isEmpty()) {
            return new Pair<>(0L, arrayList);
        }
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        for (CellInfo next : list) {
            if (next.isRegistered()) {
                if (next instanceof CellInfoGsm) {
                    HwCellInfo hwCellInfo = new HwCellInfo();
                    CellInfoGsm cellInfoGsm = (CellInfoGsm) next;
                    hwCellInfo.setBoottime(next.getTimeStamp());
                    hwCellInfo.setMcc(cellInfoGsm.getCellIdentity().getMcc());
                    hwCellInfo.setMnc(cellInfoGsm.getCellIdentity().getMnc());
                    hwCellInfo.setLac(cellInfoGsm.getCellIdentity().getLac());
                    hwCellInfo.setCellId((long) cellInfoGsm.getCellIdentity().getCid());
                    hwCellInfo.setRssi((short) cellInfoGsm.getCellSignalStrength().getDbm());
                    hwCellInfo.setRat(1);
                    if (Build.VERSION.SDK_INT >= 24) {
                        hwCellInfo.setChannelNumber(cellInfoGsm.getCellIdentity().getArfcn());
                    }
                    if (yn(hwCellInfo)) {
                        arrayList2.add(hwCellInfo);
                    }
                } else if (next instanceof CellInfoWcdma) {
                    HwCellInfo hwCellInfo2 = new HwCellInfo();
                    CellInfoWcdma cellInfoWcdma = (CellInfoWcdma) next;
                    hwCellInfo2.setBoottime(next.getTimeStamp());
                    hwCellInfo2.setMcc(cellInfoWcdma.getCellIdentity().getMcc());
                    hwCellInfo2.setMnc(cellInfoWcdma.getCellIdentity().getMnc());
                    hwCellInfo2.setLac(cellInfoWcdma.getCellIdentity().getLac());
                    hwCellInfo2.setCellId((long) cellInfoWcdma.getCellIdentity().getCid());
                    hwCellInfo2.setRssi((short) cellInfoWcdma.getCellSignalStrength().getDbm());
                    hwCellInfo2.setRat(2);
                    if (Build.VERSION.SDK_INT >= 24) {
                        hwCellInfo2.setChannelNumber(cellInfoWcdma.getCellIdentity().getUarfcn());
                    }
                    if (yn(hwCellInfo2)) {
                        arrayList2.add(hwCellInfo2);
                    }
                } else if (next instanceof CellInfoLte) {
                    HwCellInfo hwCellInfo3 = new HwCellInfo();
                    CellInfoLte cellInfoLte = (CellInfoLte) next;
                    hwCellInfo3.setBoottime(next.getTimeStamp());
                    hwCellInfo3.setMcc(cellInfoLte.getCellIdentity().getMcc());
                    hwCellInfo3.setMnc(cellInfoLte.getCellIdentity().getMnc());
                    hwCellInfo3.setLac(cellInfoLte.getCellIdentity().getTac());
                    hwCellInfo3.setCellId((long) cellInfoLte.getCellIdentity().getCi());
                    hwCellInfo3.setRssi((short) cellInfoLte.getCellSignalStrength().getDbm());
                    hwCellInfo3.setRat(3);
                    if (Build.VERSION.SDK_INT >= 24) {
                        hwCellInfo3.setChannelNumber(cellInfoLte.getCellIdentity().getEarfcn());
                    }
                    if (yn(hwCellInfo3)) {
                        arrayList2.add(hwCellInfo3);
                    }
                } else if (!this.FB) {
                    LogConsole.i("ScanBase", "getCurrentCellList fail");
                } else if (Build.VERSION.SDK_INT >= 29 && (next instanceof CellInfoNr)) {
                    CellInfoNr cellInfoNr = (CellInfoNr) next;
                    CellIdentity a11 = cellInfoNr.getCellIdentity();
                    if (a11 instanceof CellIdentityNr) {
                        CellIdentityNr cellIdentityNr = (CellIdentityNr) a11;
                        String a12 = cellIdentityNr.getMccString();
                        String a13 = cellIdentityNr.getMncString();
                        if (!(a12 == null || a13 == null)) {
                            HwCellInfo hwCellInfo4 = new HwCellInfo();
                            hwCellInfo4.setBoottime(next.getTimeStamp());
                            hwCellInfo4.setMcc(Integer.parseInt(a12));
                            hwCellInfo4.setMnc(Integer.parseInt(a13));
                            hwCellInfo4.setLac(cellIdentityNr.getTac());
                            hwCellInfo4.setCellId(cellIdentityNr.getNci());
                            hwCellInfo4.setRssi((short) yn(cellInfoNr));
                            hwCellInfo4.setRat(4);
                            hwCellInfo4.setChannelNumber(cellIdentityNr.getNrarfcn());
                            if (yn(hwCellInfo4)) {
                                arrayList2.add(hwCellInfo4);
                            }
                        }
                    }
                }
            } else if (next instanceof CellInfoGsm) {
                CellInfoGsm cellInfoGsm2 = (CellInfoGsm) next;
                HwNeighborCellInfo hwNeighborCellInfo = new HwNeighborCellInfo();
                hwNeighborCellInfo.setMcc(cellInfoGsm2.getCellIdentity().getMcc());
                hwNeighborCellInfo.setMnc(cellInfoGsm2.getCellIdentity().getMnc());
                hwNeighborCellInfo.setRssi((short) cellInfoGsm2.getCellSignalStrength().getDbm());
                hwNeighborCellInfo.setRat(1);
                if (Build.VERSION.SDK_INT >= 24) {
                    hwNeighborCellInfo.setChannelNumber(cellInfoGsm2.getCellIdentity().getArfcn());
                    hwNeighborCellInfo.setPhysicalIdentity(cellInfoGsm2.getCellIdentity().getBsic());
                }
                arrayList3.add(hwNeighborCellInfo);
            } else if (next instanceof CellInfoWcdma) {
                CellInfoWcdma cellInfoWcdma2 = (CellInfoWcdma) next;
                HwNeighborCellInfo hwNeighborCellInfo2 = new HwNeighborCellInfo();
                hwNeighborCellInfo2.setMcc(cellInfoWcdma2.getCellIdentity().getMcc());
                hwNeighborCellInfo2.setMnc(cellInfoWcdma2.getCellIdentity().getMnc());
                hwNeighborCellInfo2.setPhysicalIdentity(cellInfoWcdma2.getCellIdentity().getPsc());
                hwNeighborCellInfo2.setRssi((short) cellInfoWcdma2.getCellSignalStrength().getDbm());
                hwNeighborCellInfo2.setRat(2);
                if (Build.VERSION.SDK_INT >= 24) {
                    hwNeighborCellInfo2.setChannelNumber(cellInfoWcdma2.getCellIdentity().getUarfcn());
                }
                arrayList3.add(hwNeighborCellInfo2);
            } else if (next instanceof CellInfoLte) {
                CellInfoLte cellInfoLte2 = (CellInfoLte) next;
                HwNeighborCellInfo hwNeighborCellInfo3 = new HwNeighborCellInfo();
                hwNeighborCellInfo3.setMcc(cellInfoLte2.getCellIdentity().getMcc());
                hwNeighborCellInfo3.setMnc(cellInfoLte2.getCellIdentity().getMnc());
                hwNeighborCellInfo3.setPhysicalIdentity(cellInfoLte2.getCellIdentity().getPci());
                hwNeighborCellInfo3.setRssi((short) cellInfoLte2.getCellSignalStrength().getDbm());
                hwNeighborCellInfo3.setRat(3);
                if (Build.VERSION.SDK_INT >= 24) {
                    hwNeighborCellInfo3.setChannelNumber(cellInfoLte2.getCellIdentity().getEarfcn());
                }
                arrayList3.add(hwNeighborCellInfo3);
            } else if (!this.FB) {
                LogConsole.e("ScanBase", "getNeighborCellInfoList fail");
            } else if (Build.VERSION.SDK_INT >= 29 && (next instanceof CellInfoNr)) {
                CellInfoNr cellInfoNr2 = (CellInfoNr) next;
                CellIdentity a14 = cellInfoNr2.getCellIdentity();
                if (a14 instanceof CellIdentityNr) {
                    CellIdentityNr cellIdentityNr2 = (CellIdentityNr) a14;
                    String a15 = cellIdentityNr2.getMccString();
                    String a16 = cellIdentityNr2.getMncString();
                    if (!(a15 == null || a16 == null)) {
                        HwNeighborCellInfo hwNeighborCellInfo4 = new HwNeighborCellInfo();
                        hwNeighborCellInfo4.setMcc(Integer.parseInt(a15));
                        hwNeighborCellInfo4.setMnc(Integer.parseInt(a16));
                        hwNeighborCellInfo4.setPhysicalIdentity(cellIdentityNr2.getPci());
                        hwNeighborCellInfo4.setRssi((short) yn(cellInfoNr2));
                        hwNeighborCellInfo4.setRat(4);
                        hwNeighborCellInfo4.setChannelNumber(cellIdentityNr2.getNrarfcn());
                        arrayList3.add(hwNeighborCellInfo4);
                    }
                }
            }
        }
        int size = arrayList2.size();
        long nanoTime = System.nanoTime();
        long elapsedRealtimeNanos = SystemClock.elapsedRealtimeNanos();
        long j11 = elapsedRealtimeNanos < nanoTime ? 0 : elapsedRealtimeNanos - nanoTime;
        LogConsole.i("ScanBase", "current cell is " + size + ", neighbor Cell size is " + arrayList3.size());
        if (size == 2 && ((HwCellInfo) arrayList2.get(0)).getMcc() == ((HwCellInfo) arrayList2.get(1)).getMcc() && ((HwCellInfo) arrayList2.get(0)).getMnc() == ((HwCellInfo) arrayList2.get(1)).getMnc() && ((HwCellInfo) arrayList2.get(0)).getRat() == ((HwCellInfo) arrayList2.get(1)).getRat()) {
            yn((HwCellInfo) arrayList2.get(1), arrayList3, arrayList);
            yn(nanoTime, elapsedRealtimeNanos, j11, (HwCellInfo) arrayList2.get(1));
            return new Pair<>(Long.valueOf(((HwCellInfo) arrayList2.get(1)).getBoottime()), arrayList);
        }
        long j12 = -1;
        for (int i11 = 0; i11 < size; i11++) {
            HwCellInfo hwCellInfo5 = (HwCellInfo) arrayList2.get(i11);
            yn(hwCellInfo5, arrayList3, arrayList);
            if (hwCellInfo5.getBoottime() >= j12) {
                yn(nanoTime, elapsedRealtimeNanos, j11, hwCellInfo5);
                j12 = hwCellInfo5.getBoottime();
            }
        }
        return new Pair<>(Long.valueOf(j12), arrayList);
    }

    @RequiresApi(api = 29)
    public int yn(CellInfoNr cellInfoNr) {
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
        LogConsole.d("ScanBase", "getCellSignalStrength error");
        return dbm;
    }

    public void yn(HwCellInfo hwCellInfo, List<HwNeighborCellInfo> list, List<CellSourceInfo> list2) {
        boolean z11;
        String str = hwCellInfo.getMcc() + JavaConstant.Dynamic.DEFAULT_NAME + hwCellInfo.getMnc();
        if (hwCellInfo.getRat() == 2 || hwCellInfo.getRat() == 3) {
            str = str + JavaConstant.Dynamic.DEFAULT_NAME + hwCellInfo.getChannelNumber();
            z11 = true;
        } else {
            z11 = false;
        }
        ArrayList arrayList = new ArrayList();
        if (list.size() > 0) {
            for (int i11 = 0; i11 < list.size(); i11++) {
                HwNeighborCellInfo hwNeighborCellInfo = list.get(i11);
                String str2 = hwNeighborCellInfo.getMcc() + JavaConstant.Dynamic.DEFAULT_NAME + hwNeighborCellInfo.getMnc();
                if (z11) {
                    str2 = str2 + JavaConstant.Dynamic.DEFAULT_NAME + hwNeighborCellInfo.getChannelNumber();
                }
                if (str2.equals(str)) {
                    arrayList.add(new NeighborCell(hwNeighborCellInfo.getChannelNumber(), hwNeighborCellInfo.getPhysicalIdentity(), hwNeighborCellInfo.getRssi()));
                }
                if (arrayList.size() == 8) {
                    break;
                }
            }
        }
        CurrentCell currentCell = new CurrentCell();
        currentCell.setBoottime(hwCellInfo.getBoottime());
        currentCell.setMcc(hwCellInfo.getMcc());
        currentCell.setMnc(hwCellInfo.getMnc());
        currentCell.setLac(hwCellInfo.getLac());
        currentCell.setCellId(hwCellInfo.getCellId());
        currentCell.setRat(hwCellInfo.getRat());
        currentCell.setRssi(hwCellInfo.getRssi());
        list2.add(new CellSourceInfo(currentCell, arrayList));
    }

    /* JADX WARNING: Removed duplicated region for block: B:27:0x007a  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x0117  */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x000b A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x015e A[EDGE_INSN: B:63:0x015e->B:58:0x015e ?: BREAK  , SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public android.util.Pair<java.lang.Long, java.util.List<com.huawei.location.nlp.network.request.wifi.WifiInfo>> yn(java.util.List<android.net.wifi.ScanResult> r21) {
        /*
            r20 = this;
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            java.util.Iterator r1 = r21.iterator()
            r4 = -1
        L_0x000b:
            boolean r6 = r1.hasNext()
            java.lang.String r7 = "ScanBase"
            if (r6 == 0) goto L_0x0090
            java.lang.Object r6 = r1.next()
            android.net.wifi.ScanResult r6 = (android.net.wifi.ScanResult) r6
            java.lang.String r8 = r6.BSSID
            java.lang.String r9 = ":"
            java.lang.String r10 = ""
            java.lang.String r8 = r8.replace(r9, r10)
            r9 = 16
            long r11 = java.lang.Long.parseLong(r8, r9)
            java.util.concurrent.TimeUnit r8 = java.util.concurrent.TimeUnit.MICROSECONDS
            long r9 = r6.timestamp
            long r14 = r8.toMillis(r9)
            int r8 = r6.level
            long r9 = r6.timestamp
            int r13 = r6.frequency
            r16 = 1
            int r16 = (r11 > r16 ? 1 : (r11 == r16 ? 0 : -1))
            r17 = 0
            if (r16 < 0) goto L_0x0073
            r18 = 281474976710654(0xfffffffffffe, double:1.39067116156699E-309)
            int r16 = (r11 > r18 ? 1 : (r11 == r18 ? 0 : -1))
            if (r16 <= 0) goto L_0x0049
            goto L_0x0073
        L_0x0049:
            if (r8 >= 0) goto L_0x0070
            r2 = -120(0xffffffffffffff88, float:NaN)
            if (r8 > r2) goto L_0x0050
            goto L_0x0070
        L_0x0050:
            r2 = 0
            int r2 = (r9 > r2 ? 1 : (r9 == r2 ? 0 : -1))
            if (r2 > 0) goto L_0x0059
            java.lang.String r2 = "isValidScanResult false boot"
            goto L_0x0075
        L_0x0059:
            r2 = 2400(0x960, float:3.363E-42)
            if (r13 < r2) goto L_0x0061
            r2 = 2500(0x9c4, float:3.503E-42)
            if (r13 <= r2) goto L_0x006a
        L_0x0061:
            r2 = 4900(0x1324, float:6.866E-42)
            if (r13 < r2) goto L_0x006d
            r2 = 5850(0x16da, float:8.198E-42)
            if (r13 <= r2) goto L_0x006a
            goto L_0x006d
        L_0x006a:
            r17 = 1
            goto L_0x0078
        L_0x006d:
            java.lang.String r2 = "isValidScanResult false frequency"
            goto L_0x0075
        L_0x0070:
            java.lang.String r2 = "isValidScanResult false rssi"
            goto L_0x0075
        L_0x0073:
            java.lang.String r2 = "isValidScanResult false mac"
        L_0x0075:
            com.huawei.location.lite.common.log.LogConsole.e(r7, r2)
        L_0x0078:
            if (r17 == 0) goto L_0x000b
            int r2 = (r14 > r4 ? 1 : (r14 == r4 ? 0 : -1))
            if (r2 <= 0) goto L_0x007f
            r4 = r14
        L_0x007f:
            com.huawei.location.nlp.network.request.wifi.WifiInfo r2 = new com.huawei.location.nlp.network.request.wifi.WifiInfo
            int r13 = r6.level
            int r3 = r6.frequency
            r10 = r2
            r16 = r3
            r10.<init>(r11, r13, r14, r16)
            r0.add(r2)
            goto L_0x000b
        L_0x0090:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "convertScanResult size is "
            r1.append(r2)
            int r2 = r0.size()
            r1.append(r2)
            java.lang.String r2 = ", current time is "
            r1.append(r2)
            long r2 = android.os.SystemClock.elapsedRealtime()
            r1.append(r2)
            java.lang.String r2 = ", bootTimeMax is "
            r1.append(r2)
            r1.append(r4)
            java.lang.String r1 = r1.toString()
            com.huawei.location.lite.common.log.LogConsole.i(r7, r1)
            android.util.Pair r1 = new android.util.Pair
            java.lang.Long r2 = java.lang.Long.valueOf(r4)
            r1.<init>(r2, r0)
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r2 = "filterResult, wifiScanResult bootTime is "
            r0.append(r2)
            java.lang.Object r2 = r1.first
            r0.append(r2)
            java.lang.String r0 = r0.toString()
            com.huawei.location.lite.common.log.LogConsole.i(r7, r0)
            java.lang.Object r0 = r1.second
            java.util.List r0 = (java.util.List) r0
            int r0 = r0.size()
            r2 = 120(0x78, float:1.68E-43)
            if (r0 <= r2) goto L_0x015c
            java.lang.Object r0 = r1.first
            java.lang.Long r0 = (java.lang.Long) r0
            long r3 = r0.longValue()
            java.lang.Object r0 = r1.second
            java.util.List r0 = (java.util.List) r0
            com.huawei.location.nlp.scan.FB r5 = new com.huawei.location.nlp.scan.FB     // Catch:{ Exception -> 0x00fe }
            r6 = r20
            r5.<init>(r6)     // Catch:{ Exception -> 0x0100 }
            java.util.Collections.sort(r0, r5)     // Catch:{ Exception -> 0x0100 }
            goto L_0x0105
        L_0x00fe:
            r6 = r20
        L_0x0100:
            java.lang.String r5 = "sort exception"
            com.huawei.location.lite.common.log.LogConsole.e(r7, r5)
        L_0x0105:
            java.util.ArrayList r5 = new java.util.ArrayList
            r5.<init>()
            java.util.Iterator r7 = r0.iterator()
            r8 = -1
            r18 = -1
        L_0x0111:
            boolean r9 = r7.hasNext()
            if (r9 == 0) goto L_0x015e
            java.lang.Object r9 = r7.next()
            com.huawei.location.nlp.network.request.wifi.WifiInfo r9 = (com.huawei.location.nlp.network.request.wifi.WifiInfo) r9
            long r10 = r9.getTime()
            long r10 = r3 - r10
            r12 = 8000000(0x7a1200, float:1.1210388E-38)
            long r12 = (long) r12
            int r10 = (r10 > r12 ? 1 : (r10 == r12 ? 0 : -1))
            if (r10 < 0) goto L_0x012e
            r7.remove()
        L_0x012e:
            long r10 = r9.getMac()
            r12 = 16
            long r10 = r10 / r12
            int r10 = (r18 > r10 ? 1 : (r18 == r10 ? 0 : -1))
            if (r10 != 0) goto L_0x013f
            int r10 = r9.getFrequency()
            if (r8 == r10) goto L_0x014d
        L_0x013f:
            r5.add(r9)
            long r10 = r9.getMac()
            long r10 = r10 / r12
            int r8 = r9.getFrequency()
            r18 = r10
        L_0x014d:
            int r9 = r5.size()
            int r10 = r0.size()
            int r9 = r9 + r10
            if (r9 != r2) goto L_0x0111
            r5.addAll(r0)
            goto L_0x015e
        L_0x015c:
            r6 = r20
        L_0x015e:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.location.nlp.scan.LW.yn(java.util.List):android.util.Pair");
    }
}
