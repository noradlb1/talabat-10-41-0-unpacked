package com.huawei.location.utils;

import com.facebook.appevents.integrity.IntegrityManager;
import com.huawei.hms.flutter.map.constants.Param;
import com.huawei.riemann.location.bean.eph.BdsNav;
import com.huawei.riemann.location.bean.eph.GalileoNav;
import com.huawei.riemann.location.bean.eph.GlonassNav;
import com.huawei.riemann.location.bean.eph.GpsNav;
import java.util.ArrayList;
import org.apache.commons.compress.compressors.CompressorStreamFactory;
import org.json.JSONArray;
import org.json.JSONObject;

public class FB {
    public GlonassNav[] FB(JSONArray jSONArray) {
        ArrayList arrayList = new ArrayList();
        for (int i11 = 0; i11 < jSONArray.length(); i11++) {
            JSONObject optJSONObject = jSONArray.optJSONObject(i11);
            arrayList.add(GlonassNav.Builder.aGlonassNav().withDeltaTau(optJSONObject.optDouble("deltaTaun", 0.0d) / 1.073741824E9d).withEn(optJSONObject.optInt("en", 0)).withGamma(optJSONObject.optDouble("gamma", 0.0d) / 1.099511627776E12d).withHealth(optJSONObject.optInt(IntegrityManager.INTEGRITY_TYPE_HEALTH, 0)).withIod(optJSONObject.optInt("iod", 0)).withM(optJSONObject.optInt("m", 0)).withP1(optJSONObject.optInt("p1", 0)).withP2(optJSONObject.optInt("p2", 0)).withSvid(optJSONObject.optInt("svid", 0) + 1).withTaun(optJSONObject.optDouble("taun", 0.0d) / 1.073741824E9d).withX(optJSONObject.optDouble(Param.X, 0.0d) / 2048.0d).withXDot(optJSONObject.optDouble("xDot", 0.0d) / 1048576.0d).withXDotDot(optJSONObject.optDouble("xDotDot", 0.0d) / 1.073741824E9d).withY(optJSONObject.optDouble(Param.Y, 0.0d) / 2048.0d).withYDot(optJSONObject.optDouble("yDot", 0.0d) / 1048576.0d).withYDotDot(optJSONObject.optDouble("yDotDot", 0.0d) / 1.073741824E9d).withZ(optJSONObject.optDouble(CompressorStreamFactory.Z, 0.0d) / 2048.0d).withZDot(optJSONObject.optDouble("zDot", 0.0d) / 1048576.0d).withZDotDot(optJSONObject.optDouble("zDotDot", 0.0d) / 1.073741824E9d).build());
        }
        GlonassNav[] glonassNavArr = new GlonassNav[arrayList.size()];
        arrayList.toArray(glonassNavArr);
        return glonassNavArr;
    }

    public GpsNav[] LW(JSONArray jSONArray) {
        ArrayList arrayList = new ArrayList();
        for (int i11 = 0; i11 < jSONArray.length(); i11++) {
            JSONObject optJSONObject = jSONArray.optJSONObject(i11);
            arrayList.add(GpsNav.Builder.aGpsNav().withAcc(optJSONObject.optInt("acc", 0)).withAf0(optJSONObject.optDouble("af0", 0.0d) / 2.147483648E9d).withAf1(optJSONObject.optDouble("af1", 0.0d) / 8.796093022208E12d).withAf2(optJSONObject.optDouble("af2", 0.0d) / 3.6028797018963968E16d).withAodo(optJSONObject.optInt("aodo", 0)).withCic(optJSONObject.optDouble("cic", 0.0d) / 5.36870912E8d).withCis(optJSONObject.optDouble("cis", 0.0d) / 5.36870912E8d).withCrs(optJSONObject.optDouble("crs", 0.0d) / 32.0d).withCrc(optJSONObject.optDouble("crc", 0.0d) / 32.0d).withCuc(optJSONObject.optDouble("cuc", 0.0d) / 5.36870912E8d).withCus(optJSONObject.optDouble("cus", 0.0d) / 5.36870912E8d).withDeltaN((optJSONObject.optDouble("deltaN", 0.0d) / 8.796093022208E12d) * 3.141592653589793d).withEcc(optJSONObject.optDouble("ecc", 0.0d) / 8.589934592E9d).withGpsTow23b((optJSONObject.optDouble("gpsTow23b", 0.0d) * 4.0d) / 50.0d).withGroupDelay(optJSONObject.optDouble("groupDelay", 0.0d) / 2.147483648E9d).withHealth(optJSONObject.optInt(IntegrityManager.INTEGRITY_TYPE_HEALTH, 0)).withI0((optJSONObject.optDouble("i0", 0.0d) / 2.147483648E9d) * 3.141592653589793d).withIdot((optJSONObject.optDouble("idot", 0.0d) / 8.796093022208E12d) * 3.141592653589793d).withIodc(optJSONObject.optInt("iodc", 0)).withIode(optJSONObject.optInt("iode", 0)).withM0((optJSONObject.optDouble("m0", 0.0d) / 2.147483648E9d) * 3.141592653589793d).withOmega((optJSONObject.optDouble("omega", 0.0d) / 2.147483648E9d) * 3.141592653589793d).withOmega0((optJSONObject.optDouble("omega0", 0.0d) / 2.147483648E9d) * 3.141592653589793d).withOmegaDot((optJSONObject.optDouble("omegaDot", 0.0d) / 8.796093022208E12d) * 3.141592653589793d).withSqrtA(optJSONObject.optDouble("sqrtA", 0.0d) / 524288.0d).withSvid(optJSONObject.optInt("svid", 0) + 1).withToc(optJSONObject.optInt("toc", 0) * 16).withToe(optJSONObject.optInt("toe", 0) * 16).withWeekNumber(optJSONObject.optInt("weekNumber", 0)).build());
        }
        GpsNav[] gpsNavArr = new GpsNav[arrayList.size()];
        arrayList.toArray(gpsNavArr);
        return gpsNavArr;
    }

    public GalileoNav[] Vw(JSONArray jSONArray) {
        ArrayList arrayList = new ArrayList();
        for (int i11 = 0; i11 < jSONArray.length(); i11++) {
            JSONObject optJSONObject = jSONArray.optJSONObject(i11);
            arrayList.add(GalileoNav.Builder.aGalileoNav().withAf0(optJSONObject.optDouble("af0", 0.0d) / 1.7179869184E10d).withAf1(optJSONObject.optDouble("af1", 0.0d) / 7.0368744177664E13d).withAf2(optJSONObject.optDouble("af2", 0.0d) / 5.7646075230342349E17d).withCic(optJSONObject.optDouble("cic", 0.0d) / 5.36870912E8d).withCis(optJSONObject.optDouble("cis", 0.0d) / 5.36870912E8d).withCrc(optJSONObject.optDouble("crc", 0.0d) / 32.0d).withCrs(optJSONObject.optDouble("crs", 0.0d) / 32.0d).withCuc(optJSONObject.optDouble("cuc", 0.0d) / 5.36870912E8d).withCus(optJSONObject.optDouble("cus", 0.0d) / 5.36870912E8d).withDeltaN((optJSONObject.optDouble("deltaN", 0.0d) / 8.796093022208E12d) * 3.141592653589793d).withEcc(optJSONObject.optDouble("ecc", 0.0d) / 8.589934592E9d).withGroupDelay(optJSONObject.optDouble("groupDelay", 0.0d) / 4.294967296E9d).withHealth(optJSONObject.optInt(IntegrityManager.INTEGRITY_TYPE_HEALTH, 0)).withI0((optJSONObject.optDouble("i0", 0.0d) / 2.147483648E9d) * 3.141592653589793d).withIDot((optJSONObject.optDouble("inclinationDot", 0.0d) / 8.796093022208E12d) * 3.141592653589793d).withIodc(optJSONObject.optInt("iodc", 0)).withIode(optJSONObject.optInt("iode", 0)).withM0((optJSONObject.optDouble("m0", 0.0d) / 2.147483648E9d) * 3.141592653589793d).withOmega((optJSONObject.optDouble("omega", 0.0d) / 2.147483648E9d) * 3.141592653589793d).withOmega0((optJSONObject.optDouble("omega0", 0.0d) / 2.147483648E9d) * 3.141592653589793d).withOmegaDot((optJSONObject.optDouble("omegaDot", 0.0d) / 8.796093022208E12d) * 3.141592653589793d).withSqrtA(optJSONObject.optDouble("sqrtA", 0.0d) / 524288.0d).withSvid(optJSONObject.optInt("svid", 0) + 1).withToc(optJSONObject.optInt("toc", 0) * 60).withToe(optJSONObject.optInt("toe", 0) * 60).withNumClockModel(optJSONObject.optInt("numClockModel", 0)).withClockModelId(optJSONObject.optInt("clockModelID", 0)).build());
        }
        GalileoNav[] galileoNavArr = new GalileoNav[arrayList.size()];
        arrayList.toArray(galileoNavArr);
        return galileoNavArr;
    }

    public BdsNav[] yn(JSONArray jSONArray) {
        ArrayList arrayList = new ArrayList();
        for (int i11 = 0; i11 < jSONArray.length(); i11++) {
            JSONObject optJSONObject = jSONArray.optJSONObject(i11);
            arrayList.add(BdsNav.Builder.aBdsNav().withAcc(optJSONObject.optInt("acc", 0)).withAf0(optJSONObject.optDouble("af0", 0.0d) / 8.589934592E9d).withAf1(optJSONObject.optDouble("af1", 0.0d) / 1.125899906842624E15d).withAf2((optJSONObject.optDouble("af2", 0.0d) / 1.15292150460684698E18d) / 64.0d).withAodc(optJSONObject.optInt("aodc", 0)).withAode(optJSONObject.optInt("aode", 0)).withCic(optJSONObject.optDouble("cic", 0.0d) / 2.147483648E9d).withCis(optJSONObject.optDouble("cis", 0.0d) / 2.147483648E9d).withCrs(optJSONObject.optDouble("crs", 0.0d) / 64.0d).withCrc(optJSONObject.optDouble("crc", 0.0d) / 64.0d).withCuc(optJSONObject.optDouble("cuc", 0.0d) / 2.147483648E9d).withCus(optJSONObject.optDouble("cus", 0.0d) / 2.147483648E9d).withDeltaN((optJSONObject.optDouble("deltaN", 0.0d) / 8.796093022208E12d) * 3.141592653589793d).withEcc(optJSONObject.optDouble("ecc", 0.0d) / 8.589934592E9d).withGroupDelay(((double) optJSONObject.optInt("groupDelay", 0)) / Math.pow(10.0d, 10.0d)).withHealth(optJSONObject.optInt(IntegrityManager.INTEGRITY_TYPE_HEALTH, 0)).withI0((optJSONObject.optDouble("i0", 0.0d) / 2.147483648E9d) * 3.141592653589793d).withIDot((optJSONObject.optDouble("inclinationDot", 0.0d) / 8.796093022208E12d) * 3.141592653589793d).withM0((optJSONObject.optDouble("m0", 0.0d) / 2.147483648E9d) * 3.141592653589793d).withOmega((optJSONObject.optDouble("omega", 0.0d) / 2.147483648E9d) * 3.141592653589793d).withOmega0((optJSONObject.optDouble("omega0", 0.0d) / 2.147483648E9d) * 3.141592653589793d).withOmegaDot((optJSONObject.optDouble("omegaDot", 0.0d) / 8.796093022208E12d) * 3.141592653589793d).withSqrtA(optJSONObject.optDouble("sqrtA", 0.0d) / 524288.0d).withSvid(optJSONObject.optInt("svid", 0) + 1).withToc(optJSONObject.optInt("toc", 0) * 8).withToe(optJSONObject.optInt("toe", 0) * 8).build());
        }
        BdsNav[] bdsNavArr = new BdsNav[arrayList.size()];
        arrayList.toArray(bdsNavArr);
        return bdsNavArr;
    }
}
