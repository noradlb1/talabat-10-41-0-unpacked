package com.huawei.location.activity.model;

import android.content.Context;
import android.location.Location;
import android.location.LocationManager;
import android.os.Build;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import com.google.gson.Gson;
import com.huawei.hms.location.LocationRequest;
import com.huawei.hms.support.api.entity.location.updates.RequestLocationUpdatesRequest;
import com.huawei.location.lite.common.android.context.ContextUtil;
import com.huawei.location.lite.common.grs.LocationNlpGrsHelper;
import com.huawei.location.lite.common.grs.LocationNlpGrsServiceEnum;
import com.huawei.location.lite.common.http.HttpClientEx;
import com.huawei.location.lite.common.http.adapter.HttpClientBuilder;
import com.huawei.location.lite.common.http.exception.AuthException;
import com.huawei.location.lite.common.http.exception.ErrorCode;
import com.huawei.location.lite.common.http.exception.OnErrorException;
import com.huawei.location.lite.common.http.exception.OnFailureException;
import com.huawei.location.lite.common.http.request.BaseRequest;
import com.huawei.location.lite.common.http.request.HeadBuilder;
import com.huawei.location.lite.common.http.request.RequestJsonBody;
import com.huawei.location.lite.common.log.LogConsole;
import com.huawei.location.lite.common.log.logwrite.LogWriteConstants;
import com.huawei.location.lite.common.util.GsonUtil;
import com.huawei.location.lite.common.util.PermissionUtil;
import com.huawei.location.lite.common.util.ROMUtil;
import com.huawei.location.lite.common.util.SystemPropertiesUtil;
import com.huawei.location.vdr.util.yn;
import com.huawei.riemann.gnsslocation.core.bean.DeviceInfo;
import com.newrelic.agent.android.instrumentation.GsonInstrumentation;
import com.newrelic.agent.android.instrumentation.Instrumented;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Array;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.UUID;
import org.json.JSONException;
import org.json.JSONObject;

@Instrumented
public class Vw {
    public static boolean FB(int i11) {
        return i11 == 200 || i11 == 100 || i11 == 102 || i11 == 104 || i11 == 300 || i11 == 105;
    }

    public static byte[] FB(String str, String str2) {
        StringBuilder sb2;
        String str3;
        try {
            RequestJsonBody.Builder builder = new RequestJsonBody.Builder();
            return new HttpClientEx(ContextUtil.getContext(), new HttpClientBuilder().setNeedCheckUcsAuth(false)).newSubmit(new BaseRequest.Builder(str2).setBaseUrl(str).setHeads(new HeadBuilder(String.valueOf(UUID.randomUUID()))).setMethod("GET").setBody(builder.build()).build()).executeOriginal();
        } catch (OnErrorException e11) {
            sb2 = new StringBuilder();
            sb2.append("OnErrorException:code:");
            sb2.append(e11.getErrorCode().code);
            sb2.append(",apiCode:");
            sb2.append(e11.getApiCode());
            sb2.append(",apiMsg:");
            str3 = e11.getApiMsg();
            sb2.append(str3);
            LogConsole.e("DownloadUtils", sb2.toString());
            return new byte[0];
        } catch (OnFailureException e12) {
            sb2 = new StringBuilder();
            sb2.append("OnFailureException:");
            sb2.append(e12.getErrorCode().code);
            sb2.append(",");
            str3 = e12.getErrorCode().msg;
            sb2.append(str3);
            LogConsole.e("DownloadUtils", sb2.toString());
            return new byte[0];
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0019, code lost:
        if (r3 != null) goto L_0x001b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:?, code lost:
        r3.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0023, code lost:
        throw r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0018, code lost:
        r0 = move-exception;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void LW(java.lang.String r2, java.lang.String r3) {
        /*
            android.content.Context r0 = com.huawei.location.lite.common.android.context.ContextUtil.getContext()     // Catch:{ IOException -> 0x0024 }
            r1 = 0
            java.io.FileOutputStream r3 = r0.openFileOutput(r3, r1)     // Catch:{ IOException -> 0x0024 }
            java.nio.charset.Charset r0 = java.nio.charset.StandardCharsets.UTF_8     // Catch:{ all -> 0x0016 }
            byte[] r2 = r2.getBytes(r0)     // Catch:{ all -> 0x0016 }
            r3.write(r2)     // Catch:{ all -> 0x0016 }
            r3.close()     // Catch:{ IOException -> 0x0024 }
            goto L_0x002b
        L_0x0016:
            r2 = move-exception
            throw r2     // Catch:{ all -> 0x0018 }
        L_0x0018:
            r0 = move-exception
            if (r3 == 0) goto L_0x0023
            r3.close()     // Catch:{ all -> 0x001f }
            goto L_0x0023
        L_0x001f:
            r3 = move-exception
            r2.addSuppressed(r3)     // Catch:{ IOException -> 0x0024 }
        L_0x0023:
            throw r0     // Catch:{ IOException -> 0x0024 }
        L_0x0024:
            java.lang.String r2 = "FileUtil"
            java.lang.String r3 = "save to file failed"
            com.huawei.location.lite.common.log.LogConsole.e(r2, r3)
        L_0x002b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.location.activity.model.Vw.LW(java.lang.String, java.lang.String):void");
    }

    public static DeviceInfo Vw() {
        DeviceInfo.Builder withSdkLevel = DeviceInfo.Builder.aDeviceInfo().withChipName(yn.Vw(SystemPropertiesUtil.getProperty("ro.board.platform", ""))).withManufacturer(Build.MANUFACTURER).withSdkLevel(Build.VERSION.SDK_INT);
        StringBuilder sb2 = new StringBuilder();
        sb2.append("DeviceInfo:");
        Gson instance = GsonUtil.getInstance();
        sb2.append(!(instance instanceof Gson) ? instance.toJson((Object) withSdkLevel) : GsonInstrumentation.toJson(instance, (Object) withSdkLevel));
        LogConsole.i("VdrAlgoUtil", sb2.toString());
        return withSdkLevel.build();
    }

    public static String Vw(String str) {
        String str2;
        ErrorCode errorCode;
        StringBuilder sb2;
        try {
            RequestJsonBody.Builder builder = new RequestJsonBody.Builder();
            HeadBuilder headBuilder = new HeadBuilder(String.valueOf(UUID.randomUUID()));
            String grsHostAddress = LocationNlpGrsHelper.getGrsHostAddress(LocationNlpGrsServiceEnum.CONFIG_SERVER);
            if (TextUtils.isEmpty(grsHostAddress)) {
                LogConsole.i("DownloadUtils", "Failed to obtain the domain name using GRS.");
                return null;
            }
            return new String(new HttpClientEx().newSubmit(new BaseRequest.Builder("/servicesupport/updateserver/data/com.huawei.higeo_dataModule_SDMConfigV2?cityId=" + str).setBaseUrl(grsHostAddress).setHeads(headBuilder).setMethod("GET").setBody(builder.build()).build()).executeOriginal(), "UTF-8");
        } catch (OnErrorException e11) {
            str2 = "OnErrorException:code:" + e11.getErrorCode().code + ",apiCode:" + e11.getApiCode() + ",apiMsg:" + e11.getApiMsg();
            LogConsole.e("DownloadUtils", str2);
            return null;
        } catch (OnFailureException e12) {
            sb2 = new StringBuilder();
            sb2.append("OnFailureException:");
            sb2.append(e12.getErrorCode().code);
            sb2.append(",");
            errorCode = e12.getErrorCode();
            sb2.append(errorCode.msg);
            str2 = sb2.toString();
            LogConsole.e("DownloadUtils", str2);
            return null;
        } catch (IOException e13) {
            if (e13 instanceof AuthException) {
                AuthException authException = (AuthException) e13;
                sb2 = new StringBuilder();
                sb2.append("IOException:");
                sb2.append(authException.getErrorCode().code);
                sb2.append(",");
                errorCode = authException.getErrorCode();
                sb2.append(errorCode.msg);
                str2 = sb2.toString();
                LogConsole.e("DownloadUtils", str2);
                return null;
            }
            str2 = "IOException:" + ErrorCode.valueOf(10300) + "," + ErrorCode.valueOfKey(10300);
            LogConsole.e("DownloadUtils", str2);
            return null;
        }
    }

    public static boolean Vw(int i11) {
        return i11 == 0;
    }

    public static boolean Vw(Context context, String str, String str2) {
        String str3 = context.getDir("libs", 0).getAbsolutePath() + File.separator + str;
        try {
            boolean Vw = Vw(new File(str2).getCanonicalPath(), new File(str3).getCanonicalPath());
            StringBuilder sb2 = new StringBuilder();
            sb2.append("ret=");
            sb2.append(Vw);
            System.load(str3);
            return true;
        } catch (IOException unused) {
            return false;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0035, code lost:
        r4 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:?, code lost:
        r7.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x003a, code lost:
        r7 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:?, code lost:
        r3.addSuppressed(r7);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x003e, code lost:
        throw r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x0041, code lost:
        r3 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:?, code lost:
        r6.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x0046, code lost:
        r6 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:?, code lost:
        r7.addSuppressed(r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x004a, code lost:
        throw r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x004d, code lost:
        r7 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:?, code lost:
        r2.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:0x0056, code lost:
        throw r7;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean Vw(java.lang.String r6, java.lang.String r7) {
        /*
            java.lang.String r0 = "SdmLocationLite"
            r1 = 0
            java.io.FileInputStream r2 = new java.io.FileInputStream     // Catch:{ FileNotFoundException -> 0x005d, IOException -> 0x0057 }
            r2.<init>(r6)     // Catch:{ FileNotFoundException -> 0x005d, IOException -> 0x0057 }
            java.io.FileOutputStream r6 = new java.io.FileOutputStream     // Catch:{ all -> 0x004b }
            r6.<init>(r7)     // Catch:{ all -> 0x004b }
            java.io.ByteArrayOutputStream r7 = new java.io.ByteArrayOutputStream     // Catch:{ all -> 0x003f }
            r7.<init>()     // Catch:{ all -> 0x003f }
            r3 = 1024(0x400, float:1.435E-42)
            byte[] r3 = new byte[r3]     // Catch:{ all -> 0x0033 }
        L_0x0016:
            int r4 = r2.read(r3)     // Catch:{ all -> 0x0033 }
            r5 = -1
            if (r4 == r5) goto L_0x0021
            r7.write(r3, r1, r4)     // Catch:{ all -> 0x0033 }
            goto L_0x0016
        L_0x0021:
            byte[] r3 = r7.toByteArray()     // Catch:{ all -> 0x0033 }
            r6.write(r3)     // Catch:{ all -> 0x0033 }
            r7.close()     // Catch:{ all -> 0x003f }
            r6.close()     // Catch:{ all -> 0x004b }
            r2.close()     // Catch:{ FileNotFoundException -> 0x005d, IOException -> 0x0057 }
            r6 = 1
            return r6
        L_0x0033:
            r3 = move-exception
            throw r3     // Catch:{ all -> 0x0035 }
        L_0x0035:
            r4 = move-exception
            r7.close()     // Catch:{ all -> 0x003a }
            goto L_0x003e
        L_0x003a:
            r7 = move-exception
            r3.addSuppressed(r7)     // Catch:{ all -> 0x003f }
        L_0x003e:
            throw r4     // Catch:{ all -> 0x003f }
        L_0x003f:
            r7 = move-exception
            throw r7     // Catch:{ all -> 0x0041 }
        L_0x0041:
            r3 = move-exception
            r6.close()     // Catch:{ all -> 0x0046 }
            goto L_0x004a
        L_0x0046:
            r6 = move-exception
            r7.addSuppressed(r6)     // Catch:{ all -> 0x004b }
        L_0x004a:
            throw r3     // Catch:{ all -> 0x004b }
        L_0x004b:
            r6 = move-exception
            throw r6     // Catch:{ all -> 0x004d }
        L_0x004d:
            r7 = move-exception
            r2.close()     // Catch:{ all -> 0x0052 }
            goto L_0x0056
        L_0x0052:
            r2 = move-exception
            r6.addSuppressed(r2)     // Catch:{ FileNotFoundException -> 0x005d, IOException -> 0x0057 }
        L_0x0056:
            throw r7     // Catch:{ FileNotFoundException -> 0x005d, IOException -> 0x0057 }
        L_0x0057:
            java.lang.String r6 = "IOException"
        L_0x0059:
            android.util.Log.e(r0, r6)
            return r1
        L_0x005d:
            java.lang.String r6 = "FileNotFoundException"
            goto L_0x0059
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.location.activity.model.Vw.Vw(java.lang.String, java.lang.String):boolean");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0019, code lost:
        if (r3 != null) goto L_0x001b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:?, code lost:
        r3.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0023, code lost:
        throw r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0018, code lost:
        r0 = move-exception;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void dC(java.lang.String r2, java.lang.String r3) {
        /*
            android.content.Context r0 = com.huawei.location.lite.common.android.context.ContextUtil.getContext()     // Catch:{ IOException -> 0x0024 }
            r1 = 0
            java.io.FileOutputStream r3 = r0.openFileOutput(r3, r1)     // Catch:{ IOException -> 0x0024 }
            java.nio.charset.Charset r0 = java.nio.charset.StandardCharsets.UTF_8     // Catch:{ all -> 0x0016 }
            byte[] r2 = r2.getBytes(r0)     // Catch:{ all -> 0x0016 }
            r3.write(r2)     // Catch:{ all -> 0x0016 }
            r3.close()     // Catch:{ IOException -> 0x0024 }
            goto L_0x002b
        L_0x0016:
            r2 = move-exception
            throw r2     // Catch:{ all -> 0x0018 }
        L_0x0018:
            r0 = move-exception
            if (r3 == 0) goto L_0x0023
            r3.close()     // Catch:{ all -> 0x001f }
            goto L_0x0023
        L_0x001f:
            r3 = move-exception
            r2.addSuppressed(r3)     // Catch:{ IOException -> 0x0024 }
        L_0x0023:
            throw r0     // Catch:{ IOException -> 0x0024 }
        L_0x0024:
            java.lang.String r2 = "FileUtil"
            java.lang.String r3 = "save to file failed"
            com.huawei.location.lite.common.log.LogConsole.e(r2, r3)
        L_0x002b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.location.activity.model.Vw.dC(java.lang.String, java.lang.String):void");
    }

    public static long yn(double d11, double d12, int i11) {
        int i12 = i11;
        long j11 = -9223372036854775808 >>> (i12 > 29 ? 59 : (i12 * 2) + 1);
        double d13 = -90.0d;
        double d14 = 90.0d;
        double d15 = -180.0d;
        double d16 = 180.0d;
        long j12 = 0;
        boolean z11 = true;
        for (long j13 = Long.MIN_VALUE; j13 != j11; j13 >>>= 1) {
            if (z11) {
                double d17 = (d15 + d16) / 2.0d;
                if (d11 >= d17) {
                    j12 |= j13;
                    d15 = d17;
                } else {
                    d16 = d17;
                }
            } else {
                double d18 = (d13 + d14) / 2.0d;
                if (d12 >= d18) {
                    j12 |= j13;
                    d13 = d18;
                } else {
                    d14 = d18;
                }
            }
            z11 = !z11;
        }
        return (((long) i12) << 59) | (j12 >>> 5);
    }

    public static String yn(int i11) {
        if (Vw(i11)) {
            return "Success";
        }
        if (i11 == -1) {
            return "INVALID";
        }
        if (i11 == 100002 || i11 == 100003) {
            return "The channel requests are too frequent";
        }
        if (i11 == 200001) {
            return "The required parameter is empty or missing";
        }
        if (i11 == 200002) {
            return "Parameter format error";
        }
        if (i11 == 200007) {
            return "Interface authentication failed";
        }
        if (i11 == 200008) {
            return "Log file unique id not found";
        }
        if (i11 == 200009) {
            return "Fragmentation policy is inconsistent";
        }
        if (i11 == 302001) {
            return "The channel does not exist or the channel is illegal";
        }
        if (i11 == 302002) {
            return "The country is not supported";
        }
        if (i11 == 302003) {
            return "The country code does not match the log server site";
        }
        if (i11 == 302004) {
            return "Upload log file is not supported for this mode";
        }
        return "Unknown error:" + i11;
    }

    public static String yn(Context context) {
        if (Build.VERSION.SDK_INT >= 24) {
            context = context.createDeviceProtectedStorageContext();
        }
        return context.getFilesDir().getPath();
    }

    public static ArrayList<float[]> yn(ArrayList<float[]> arrayList, int i11) {
        float[][] fArr;
        ArrayList<float[]> arrayList2 = arrayList;
        int i12 = i11;
        int size = arrayList.size();
        int[] iArr = new int[2];
        iArr[1] = arrayList2.get(0).length;
        iArr[0] = size;
        float[][] fArr2 = (float[][]) Array.newInstance(Float.TYPE, iArr);
        for (int i13 = 0; i13 < arrayList.size(); i13++) {
            System.arraycopy(arrayList2.get(i13), 0, fArr2[i13], 0, arrayList2.get(i13).length);
        }
        if (fArr2.length == 0) {
            return arrayList2;
        }
        int[] iArr2 = new int[2];
        iArr2[1] = fArr2[0].length;
        iArr2[0] = i12;
        float[][] fArr3 = (float[][]) Array.newInstance(Float.TYPE, iArr2);
        double doubleValue = new BigDecimal((double) (((float) fArr2.length) / ((float) i12))).setScale(2, 4).doubleValue();
        int i14 = 0;
        while (i14 < fArr2[0].length) {
            int i15 = 0;
            int i16 = 0;
            while (true) {
                if (i15 >= fArr2.length) {
                    break;
                } else if (i16 == i12 - 1) {
                    fArr3[i16][i14] = fArr2[fArr2.length - 1][i14];
                    break;
                } else if (i15 == 0) {
                    fArr3[i16][i14] = fArr2[i15][i14];
                    i16++;
                    i15 += (int) Math.round(doubleValue);
                } else {
                    double round = (((double) ((int) Math.round(doubleValue))) * doubleValue) / 2.0d;
                    if (Math.abs(round) >= 1.0E-6d) {
                        fArr = fArr3;
                        fArr3[i16][i14] = (float) (((double) fArr2[i15 - ((int) Math.round(doubleValue))][i14]) + (((double) (fArr2[i15][i14] - fArr2[i15 - ((int) Math.round(doubleValue))][i14])) / round));
                    } else {
                        fArr = fArr3;
                        fArr[i16][i14] = 0.0f;
                    }
                    i16++;
                    i15 += (int) Math.round(doubleValue);
                    fArr3 = fArr;
                    i12 = i11;
                }
            }
            i14++;
            fArr3 = fArr3;
            i12 = i11;
        }
        float[][] fArr4 = fArr3;
        ArrayList<float[]> arrayList3 = new ArrayList<>(i11);
        float[][] fArr5 = fArr4;
        for (float[] add : fArr5) {
            arrayList3.add(add);
        }
        return arrayList3;
    }

    public static ArrayList<float[]> yn(ArrayList<float[]> arrayList, ArrayList<float[]> arrayList2, int i11) {
        int size = arrayList.size();
        int[] iArr = new int[2];
        iArr[1] = arrayList.get(0).length;
        iArr[0] = size;
        float[][] fArr = (float[][]) Array.newInstance(Float.TYPE, iArr);
        for (int i12 = 0; i12 < arrayList.size(); i12++) {
            System.arraycopy(arrayList.get(i12), 0, fArr[i12], 0, arrayList.get(i12).length);
        }
        int size2 = arrayList2.size();
        int[] iArr2 = new int[2];
        iArr2[1] = arrayList2.get(0).length;
        iArr2[0] = size2;
        float[][] fArr2 = (float[][]) Array.newInstance(Float.TYPE, iArr2);
        for (int i13 = 0; i13 < arrayList2.size(); i13++) {
            System.arraycopy(arrayList2.get(i13), 0, fArr2[i13], 0, arrayList2.get(i13).length);
        }
        int[] iArr3 = new int[2];
        iArr3[1] = i11;
        iArr3[0] = i11;
        float[][] fArr3 = (float[][]) Array.newInstance(Float.TYPE, iArr3);
        for (int i14 = 0; i14 < i11; i14++) {
            for (int i15 = 0; i15 < i11; i15++) {
                fArr3[i14][i15] = 0.0f;
                for (int i16 = 0; i16 < i11; i16++) {
                    float[] fArr4 = fArr3[i14];
                    fArr4[i15] = fArr4[i15] + (fArr[i14][i16] * fArr2[i16][i15]);
                }
            }
        }
        ArrayList<float[]> arrayList3 = new ArrayList<>(i11);
        for (float[] add : fArr3) {
            arrayList3.add(add);
        }
        return arrayList3;
    }

    public static JSONObject yn(Location location) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        if (location == null) {
            return jSONObject;
        }
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put("mProvider", (Object) location.getProvider());
        jSONObject2.put("mAltitude", location.getAltitude());
        jSONObject2.put("mBearing", (double) location.getBearing());
        jSONObject2.put("mHorizontalAccuracyMeters", (double) location.getAccuracy());
        jSONObject2.put("mLatitude", location.getLatitude());
        jSONObject2.put("mLongitude", location.getLongitude());
        jSONObject2.put("mSpeed", (double) location.getSpeed());
        jSONObject2.put("mTime", location.getTime());
        int i11 = Build.VERSION.SDK_INT;
        jSONObject2.put("mElapsedRealtimeNanos", location.getElapsedRealtimeNanos());
        if (i11 >= 26) {
            jSONObject2.put("mBearingAccuracyDegrees", (double) location.getBearingAccuracyDegrees());
            jSONObject2.put("mSpeedAccuracyMetersPerSecond", (double) location.getSpeedAccuracyMetersPerSecond());
            jSONObject2.put("mVerticalAccuracyMeters", (double) location.getVerticalAccuracyMeters());
        }
        if (location.getExtras() != null) {
            JSONObject jSONObject3 = new JSONObject();
            if (location.getExtras().containsKey("SourceType")) {
                jSONObject3.put("SourceType", location.getExtras().getInt("SourceType", -1));
            }
            if (location.getExtras().containsKey("LocationSource")) {
                jSONObject3.put("LocationSource", location.getExtras().getInt("LocationSource", 0));
            }
            if (location.getExtras().containsKey("session_id")) {
                jSONObject3.put("session_id", (Object) location.getExtras().getString("session_id"));
            }
            if (location.getExtras().containsKey(LogWriteConstants.VENDOR_TYPE)) {
                jSONObject3.put(LogWriteConstants.VENDOR_TYPE, location.getExtras().getInt(LogWriteConstants.VENDOR_TYPE));
            }
            if (location.getExtras().containsKey(LogWriteConstants.LOCATE_TYPE)) {
                jSONObject3.put(LogWriteConstants.LOCATE_TYPE, (Object) location.getExtras().getString(LogWriteConstants.LOCATE_TYPE));
            }
            JSONObject jSONObject4 = new JSONObject();
            jSONObject4.put("mExtraInfo", (Object) jSONObject3);
            jSONObject.put("address", (Object) jSONObject4);
        }
        jSONObject.put("location", (Object) jSONObject2);
        return jSONObject;
    }

    public static boolean yn() {
        try {
            if (Build.VERSION.SDK_INT <= 30) {
                return false;
            }
            if (ROMUtil.isChineseRom()) {
                return false;
            }
            return true ^ PermissionUtil.checkSelfPermission(ContextUtil.getContext(), "android.permission.ACCESS_FINE_LOCATION");
        } catch (Exception unused) {
            LogConsole.e("LocationInnerUtil", "checkApproximatelyPermission exception");
            return true;
        }
    }

    public static boolean yn(Context context, String str, String str2) {
        StringBuilder sb2;
        String str3;
        File file = new File(str2);
        try {
            String str4 = context.getDir("libs", 0).getCanonicalPath() + File.separator + str;
            File file2 = new File(str4);
            StringBuilder sb3 = new StringBuilder();
            sb3.append("src: ");
            sb3.append(file.getCanonicalPath());
            sb3.append(",");
            sb3.append(str4);
            boolean yn2 = yn(file.getCanonicalPath(), file2.getCanonicalPath());
            StringBuilder sb4 = new StringBuilder();
            sb4.append("ret=");
            sb4.append(yn2);
            if (!yn2) {
                return false;
            }
            System.load(str4);
            return true;
        } catch (IOException e11) {
            e = e11;
            sb2 = new StringBuilder();
            str3 = "load file dir error: ";
            sb2.append(str3);
            sb2.append(e.getMessage());
            Log.e("LibraryUtils", sb2.toString());
            return false;
        } catch (UnsatisfiedLinkError e12) {
            e = e12;
            sb2 = new StringBuilder();
            str3 = "invalid file: ";
            sb2.append(str3);
            sb2.append(e.getMessage());
            Log.e("LibraryUtils", sb2.toString());
            return false;
        }
    }

    public static boolean yn(RequestLocationUpdatesRequest requestLocationUpdatesRequest) {
        String str;
        if (requestLocationUpdatesRequest == null) {
            return false;
        }
        LocationRequest locationRequest = requestLocationUpdatesRequest.getLocationRequest();
        if (locationRequest == null) {
            str = "checkRequestInvalid false, locationRequest is invalid";
        } else {
            if (locationRequest.getExpirationTime() >= SystemClock.elapsedRealtime()) {
                return locationRequest.getNumUpdates() >= 1;
            }
            str = "checkRequestInvalid false, expirationTime is invalid";
        }
        LogConsole.i("LocationInnerUtil", str);
        return false;
    }

    public static boolean yn(String str) {
        String str2;
        try {
            Object systemService = ContextUtil.getContext().getSystemService("location");
            if (systemService instanceof LocationManager) {
                return ((LocationManager) systemService).isProviderEnabled(str);
            }
            return false;
        } catch (IllegalArgumentException unused) {
            str2 = "isProviderEnabled IllegalArgumentException";
            LogConsole.e("LocationInnerUtil", str2);
            return false;
        } catch (SecurityException unused2) {
            str2 = "isProviderEnabled SecurityException";
            LogConsole.e("LocationInnerUtil", str2);
            return false;
        } catch (Exception unused3) {
            str2 = "isProviderEnabled exception";
            LogConsole.e("LocationInnerUtil", str2);
            return false;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:37:0x008a A[SYNTHETIC, Splitter:B:37:0x008a] */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x0092 A[Catch:{ IOException -> 0x008e }] */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x0097 A[Catch:{ IOException -> 0x008e }] */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x00b7 A[SYNTHETIC, Splitter:B:50:0x00b7] */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x00bf A[Catch:{ IOException -> 0x00bb }] */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x00c4 A[Catch:{ IOException -> 0x00bb }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean yn(java.lang.String r8, java.lang.String r9) {
        /*
            java.lang.String r0 = "close fileStream error: "
            java.lang.String r1 = "LibraryUtils"
            r2 = 0
            r3 = 0
            java.io.FileInputStream r4 = new java.io.FileInputStream     // Catch:{ Exception -> 0x006d, all -> 0x0068 }
            r4.<init>(r8)     // Catch:{ Exception -> 0x006d, all -> 0x0068 }
            java.io.FileOutputStream r8 = new java.io.FileOutputStream     // Catch:{ Exception -> 0x0065, all -> 0x0061 }
            r8.<init>(r9)     // Catch:{ Exception -> 0x0065, all -> 0x0061 }
            java.io.ByteArrayOutputStream r9 = new java.io.ByteArrayOutputStream     // Catch:{ Exception -> 0x005c, all -> 0x0058 }
            r9.<init>()     // Catch:{ Exception -> 0x005c, all -> 0x0058 }
            r3 = 1024(0x400, float:1.435E-42)
            byte[] r3 = new byte[r3]     // Catch:{ Exception -> 0x0052, all -> 0x004e }
        L_0x0019:
            int r5 = r4.read(r3)     // Catch:{ Exception -> 0x0052, all -> 0x004e }
            r6 = -1
            if (r5 == r6) goto L_0x0024
            r9.write(r3, r2, r5)     // Catch:{ Exception -> 0x0052, all -> 0x004e }
            goto L_0x0019
        L_0x0024:
            byte[] r3 = r9.toByteArray()     // Catch:{ Exception -> 0x0052, all -> 0x004e }
            r8.write(r3)     // Catch:{ Exception -> 0x0052, all -> 0x004e }
            r9.close()     // Catch:{ IOException -> 0x0035 }
            r8.close()     // Catch:{ IOException -> 0x0035 }
            r4.close()     // Catch:{ IOException -> 0x0035 }
            goto L_0x004c
        L_0x0035:
            r8 = move-exception
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            r9.<init>()
            r9.append(r0)
            java.lang.String r8 = r8.getMessage()
            r9.append(r8)
            java.lang.String r8 = r9.toString()
            android.util.Log.e(r1, r8)
        L_0x004c:
            r8 = 1
            return r8
        L_0x004e:
            r2 = move-exception
            r3 = r9
            goto L_0x00b5
        L_0x0052:
            r3 = move-exception
            r7 = r9
            r9 = r8
            r8 = r3
            r3 = r7
            goto L_0x0070
        L_0x0058:
            r9 = move-exception
            r2 = r9
            goto L_0x00b5
        L_0x005c:
            r9 = move-exception
            r7 = r9
            r9 = r8
            r8 = r7
            goto L_0x0070
        L_0x0061:
            r8 = move-exception
            r2 = r8
            r8 = r3
            goto L_0x00b5
        L_0x0065:
            r8 = move-exception
            r9 = r3
            goto L_0x0070
        L_0x0068:
            r8 = move-exception
            r2 = r8
            r8 = r3
            r4 = r8
            goto L_0x00b5
        L_0x006d:
            r8 = move-exception
            r9 = r3
            r4 = r9
        L_0x0070:
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ all -> 0x00b2 }
            r5.<init>()     // Catch:{ all -> 0x00b2 }
            java.lang.String r6 = "copy file error: "
            r5.append(r6)     // Catch:{ all -> 0x00b2 }
            java.lang.String r8 = r8.getMessage()     // Catch:{ all -> 0x00b2 }
            r5.append(r8)     // Catch:{ all -> 0x00b2 }
            java.lang.String r8 = r5.toString()     // Catch:{ all -> 0x00b2 }
            android.util.Log.e(r1, r8)     // Catch:{ all -> 0x00b2 }
            if (r3 == 0) goto L_0x0090
            r3.close()     // Catch:{ IOException -> 0x008e }
            goto L_0x0090
        L_0x008e:
            r8 = move-exception
            goto L_0x009b
        L_0x0090:
            if (r9 == 0) goto L_0x0095
            r9.close()     // Catch:{ IOException -> 0x008e }
        L_0x0095:
            if (r4 == 0) goto L_0x00b1
            r4.close()     // Catch:{ IOException -> 0x008e }
            goto L_0x00b1
        L_0x009b:
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            r9.<init>()
            r9.append(r0)
            java.lang.String r8 = r8.getMessage()
            r9.append(r8)
            java.lang.String r8 = r9.toString()
            android.util.Log.e(r1, r8)
        L_0x00b1:
            return r2
        L_0x00b2:
            r8 = move-exception
            r2 = r8
            r8 = r9
        L_0x00b5:
            if (r3 == 0) goto L_0x00bd
            r3.close()     // Catch:{ IOException -> 0x00bb }
            goto L_0x00bd
        L_0x00bb:
            r8 = move-exception
            goto L_0x00c8
        L_0x00bd:
            if (r8 == 0) goto L_0x00c2
            r8.close()     // Catch:{ IOException -> 0x00bb }
        L_0x00c2:
            if (r4 == 0) goto L_0x00de
            r4.close()     // Catch:{ IOException -> 0x00bb }
            goto L_0x00de
        L_0x00c8:
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            r9.<init>()
            r9.append(r0)
            java.lang.String r8 = r8.getMessage()
            r9.append(r8)
            java.lang.String r8 = r9.toString()
            android.util.Log.e(r1, r8)
        L_0x00de:
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.location.activity.model.Vw.yn(java.lang.String, java.lang.String):boolean");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:43:0x00bd, code lost:
        r5 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:?, code lost:
        r4.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:0x00c6, code lost:
        throw r5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:77:?, code lost:
        r3.delete();
        com.huawei.location.lite.common.log.LogConsole.e("DownloadUtils", "downloadUrl is illegal");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:79:0x011e, code lost:
        return false;
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Missing exception handler attribute for start block: B:76:0x0113 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static synchronized boolean yn(java.lang.String r6, java.lang.String r7, java.lang.String r8, java.lang.String r9) {
        /*
            java.lang.Class<com.huawei.location.activity.model.Vw> r0 = com.huawei.location.activity.model.Vw.class
            monitor-enter(r0)
            java.lang.String r1 = "DownloadUtils"
            java.lang.String r2 = "download zip files from the cloud"
            com.huawei.location.lite.common.log.LogConsole.i(r1, r2)     // Catch:{ all -> 0x0128 }
            boolean r1 = android.text.TextUtils.isEmpty(r7)     // Catch:{ all -> 0x0128 }
            r2 = 0
            if (r1 != 0) goto L_0x011f
            boolean r1 = android.text.TextUtils.isEmpty(r6)     // Catch:{ all -> 0x0128 }
            if (r1 == 0) goto L_0x0019
            goto L_0x011f
        L_0x0019:
            java.io.File r1 = new java.io.File     // Catch:{ all -> 0x0128 }
            r1.<init>(r6)     // Catch:{ all -> 0x0128 }
            boolean r1 = r1.exists()     // Catch:{ all -> 0x0128 }
            if (r1 == 0) goto L_0x002d
            java.lang.String r6 = "DownloadUtils"
            java.lang.String r7 = "The file already exists."
            com.huawei.location.lite.common.log.LogConsole.i(r6, r7)     // Catch:{ all -> 0x0128 }
            monitor-exit(r0)
            return r2
        L_0x002d:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x0128 }
            r1.<init>()     // Catch:{ all -> 0x0128 }
            r1.append(r6)     // Catch:{ all -> 0x0128 }
            java.lang.String r3 = ".temp"
            r1.append(r3)     // Catch:{ all -> 0x0128 }
            java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x0128 }
            java.io.File r3 = new java.io.File     // Catch:{ all -> 0x0128 }
            r3.<init>(r1)     // Catch:{ all -> 0x0128 }
            java.io.File r4 = r3.getParentFile()     // Catch:{ all -> 0x0128 }
            boolean r4 = r4.exists()     // Catch:{ all -> 0x0128 }
            if (r4 != 0) goto L_0x0060
            java.io.File r4 = r3.getParentFile()     // Catch:{ all -> 0x0128 }
            boolean r4 = r4.mkdirs()     // Catch:{ all -> 0x0128 }
            if (r4 != 0) goto L_0x0060
            java.lang.String r6 = "DownloadUtils"
            java.lang.String r7 = "Failed to create the file directory."
            com.huawei.location.lite.common.log.LogConsole.e(r6, r7)     // Catch:{ all -> 0x0128 }
            monitor-exit(r0)
            return r2
        L_0x0060:
            boolean r4 = r3.exists()     // Catch:{ all -> 0x0128 }
            if (r4 == 0) goto L_0x006f
            java.lang.String r6 = "DownloadUtils"
            java.lang.String r7 = "The file is being downloaded."
            com.huawei.location.lite.common.log.LogConsole.e(r6, r7)     // Catch:{ all -> 0x0128 }
            monitor-exit(r0)
            return r2
        L_0x006f:
            java.net.URI r7 = java.net.URI.create(r7)     // Catch:{ IllegalArgumentException -> 0x0113 }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ IllegalArgumentException -> 0x0113 }
            r4.<init>()     // Catch:{ IllegalArgumentException -> 0x0113 }
            java.lang.String r5 = r7.getScheme()     // Catch:{ IllegalArgumentException -> 0x0113 }
            r4.append(r5)     // Catch:{ IllegalArgumentException -> 0x0113 }
            java.lang.String r5 = java.io.File.pathSeparator     // Catch:{ IllegalArgumentException -> 0x0113 }
            r4.append(r5)     // Catch:{ IllegalArgumentException -> 0x0113 }
            java.lang.String r5 = java.io.File.separator     // Catch:{ IllegalArgumentException -> 0x0113 }
            r4.append(r5)     // Catch:{ IllegalArgumentException -> 0x0113 }
            r4.append(r5)     // Catch:{ IllegalArgumentException -> 0x0113 }
            java.lang.String r5 = r7.getHost()     // Catch:{ IllegalArgumentException -> 0x0113 }
            r4.append(r5)     // Catch:{ IllegalArgumentException -> 0x0113 }
            java.lang.String r4 = r4.toString()     // Catch:{ IllegalArgumentException -> 0x0113 }
            java.lang.String r7 = r7.getPath()     // Catch:{ IllegalArgumentException -> 0x0113 }
            byte[] r7 = FB(r4, r7)     // Catch:{ IllegalArgumentException -> 0x0113 }
            int r4 = r7.length     // Catch:{ IllegalArgumentException -> 0x0113 }
            if (r4 > 0) goto L_0x00ab
            java.lang.String r6 = "DownloadUtils"
            java.lang.String r7 = "zip file InputStream is null"
            com.huawei.location.lite.common.log.LogConsole.d(r6, r7)     // Catch:{ IllegalArgumentException -> 0x0113 }
            monitor-exit(r0)
            return r2
        L_0x00ab:
            java.io.FileOutputStream r4 = new java.io.FileOutputStream     // Catch:{ IOException -> 0x00c7 }
            r4.<init>(r3, r2)     // Catch:{ IOException -> 0x00c7 }
            int r5 = r7.length     // Catch:{ all -> 0x00bb }
            r4.write(r7, r2, r5)     // Catch:{ all -> 0x00bb }
            r4.flush()     // Catch:{ all -> 0x00bb }
            r4.close()     // Catch:{ IOException -> 0x00c7 }
            goto L_0x00ce
        L_0x00bb:
            r7 = move-exception
            throw r7     // Catch:{ all -> 0x00bd }
        L_0x00bd:
            r5 = move-exception
            r4.close()     // Catch:{ all -> 0x00c2 }
            goto L_0x00c6
        L_0x00c2:
            r4 = move-exception
            r7.addSuppressed(r4)     // Catch:{ IOException -> 0x00c7 }
        L_0x00c6:
            throw r5     // Catch:{ IOException -> 0x00c7 }
        L_0x00c7:
            java.lang.String r7 = "FileUtils"
            java.lang.String r4 = "saveToSd createSdFile stream read write exception"
            com.huawei.location.lite.common.log.LogConsole.e(r7, r4)     // Catch:{ IllegalArgumentException -> 0x0113 }
        L_0x00ce:
            java.lang.String r7 = com.huawei.location.tiles.utils.LW.yn(r1, r8)     // Catch:{ IllegalArgumentException -> 0x0113 }
            boolean r8 = android.text.TextUtils.isEmpty(r7)     // Catch:{ IllegalArgumentException -> 0x0113 }
            if (r8 != 0) goto L_0x0107
            boolean r7 = r7.equals(r9)     // Catch:{ IllegalArgumentException -> 0x0113 }
            if (r7 != 0) goto L_0x00df
            goto L_0x0107
        L_0x00df:
            java.io.File r7 = new java.io.File     // Catch:{ IllegalArgumentException -> 0x0113 }
            r7.<init>(r6)     // Catch:{ IllegalArgumentException -> 0x0113 }
            boolean r6 = r3.renameTo(r7)     // Catch:{ IllegalArgumentException -> 0x0113 }
            if (r6 != 0) goto L_0x00f6
            r3.delete()     // Catch:{ IllegalArgumentException -> 0x0113 }
            java.lang.String r6 = "DownloadUtils"
            java.lang.String r7 = "download file error"
            com.huawei.location.lite.common.log.LogConsole.d(r6, r7)     // Catch:{ IllegalArgumentException -> 0x0113 }
            monitor-exit(r0)
            return r2
        L_0x00f6:
            java.lang.String r6 = "DownloadUtils"
            java.lang.String r7 = "download file success"
            com.huawei.location.lite.common.log.LogConsole.d(r6, r7)     // Catch:{ IllegalArgumentException -> 0x0113 }
            java.lang.String r6 = "DownloadUtils"
            java.lang.String r7 = "The zip file is downloaded successfully."
            com.huawei.location.lite.common.log.LogConsole.i(r6, r7)     // Catch:{ all -> 0x0128 }
            monitor-exit(r0)
            r6 = 1
            return r6
        L_0x0107:
            r3.delete()     // Catch:{ IllegalArgumentException -> 0x0113 }
            java.lang.String r6 = "DownloadUtils"
            java.lang.String r7 = "Signature verification failed"
            com.huawei.location.lite.common.log.LogConsole.d(r6, r7)     // Catch:{ IllegalArgumentException -> 0x0113 }
            monitor-exit(r0)
            return r2
        L_0x0113:
            r3.delete()     // Catch:{ all -> 0x0128 }
            java.lang.String r6 = "DownloadUtils"
            java.lang.String r7 = "downloadUrl is illegal"
            com.huawei.location.lite.common.log.LogConsole.e(r6, r7)     // Catch:{ all -> 0x0128 }
            monitor-exit(r0)
            return r2
        L_0x011f:
            java.lang.String r6 = "DownloadUtils"
            java.lang.String r7 = "The url or file path is abnormal."
            com.huawei.location.lite.common.log.LogConsole.e(r6, r7)     // Catch:{ all -> 0x0128 }
            monitor-exit(r0)
            return r2
        L_0x0128:
            r6 = move-exception
            monitor-exit(r0)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.location.activity.model.Vw.yn(java.lang.String, java.lang.String, java.lang.String, java.lang.String):boolean");
    }
}
