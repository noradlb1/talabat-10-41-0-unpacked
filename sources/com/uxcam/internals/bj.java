package com.uxcam.internals;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Point;
import android.media.MediaMetadataRetriever;
import android.net.Uri;
import android.os.Build;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.Pair;
import com.facebook.appevents.UserDataStore;
import com.facebook.internal.AnalyticsEvents;
import com.facebook.internal.security.CertificateUtil;
import com.instabug.library.core.eventbus.coreeventbus.SDKCoreEvent;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.newrelic.agent.android.instrumentation.JSONArrayInstrumentation;
import com.newrelic.agent.android.instrumentation.JSONObjectInstrumentation;
import com.talabat.configuration.discovery.RealDiscoveryConfigurationRepository;
import com.uxcam.internals.as;
import com.uxcam.internals.gu;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.zip.GZIPOutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;
import org.apache.commons.compress.archivers.ArchiveStreamFactory;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@Instrumented
public class bj {

    /* renamed from: f  reason: collision with root package name */
    public static final String[] f13069f = {"cordova", "xamarin", "react-native", "appcelerator", "flutter"};

    /* renamed from: g  reason: collision with root package name */
    public static boolean f13070g = false;

    /* renamed from: h  reason: collision with root package name */
    public static boolean f13071h = false;

    /* renamed from: i  reason: collision with root package name */
    public static boolean f13072i = false;

    /* renamed from: a  reason: collision with root package name */
    public final ArrayList f13073a = new ArrayList();

    /* renamed from: b  reason: collision with root package name */
    public String f13074b;

    /* renamed from: c  reason: collision with root package name */
    public long f13075c = -1;

    /* renamed from: d  reason: collision with root package name */
    public int f13076d = -1;

    /* renamed from: e  reason: collision with root package name */
    public String f13077e = "";

    public class aa implements FilenameFilter {
        public aa(bj bjVar) {
        }

        public boolean accept(File file, String str) {
            return by.a(str);
        }
    }

    public bj(String str) {
        this.f13074b = str;
    }

    public static JSONArray a(double d11) {
        JSONArray jSONArray = new JSONArray();
        List asList = Arrays.asList(new String[]{"v", "d", "e", "w", "i"});
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(Runtime.getRuntime().exec(new String[]{"logcat", "-d", "-v epoch"}).getInputStream()));
        while (true) {
            String readLine = bufferedReader.readLine();
            if (readLine != null) {
                String[] split = readLine.trim().split("\\s+");
                if (split.length > 4) {
                    String str = split[3];
                    Locale locale = Locale.ENGLISH;
                    if (asList.contains(str.toLowerCase(locale))) {
                        JSONObject jSONObject = new JSONObject();
                        try {
                            float parseLong = (float) ((((double) Long.parseLong(split[0].replace(RealDiscoveryConfigurationRepository.VERSION_DELIMETER, ""))) - (((double) System.currentTimeMillis()) - (d11 * 1000.0d))) / 1000.0d);
                            if (parseLong >= 0.0f) {
                                jSONObject.put("timeLine", (double) parseLong);
                                jSONObject.put("level", (Object) split[3].toLowerCase(locale));
                                String join = TextUtils.join(" ", Arrays.copyOfRange(split, 4, split.length));
                                String[] split2 = join.split(CertificateUtil.DELIMITER);
                                if (split2.length >= 2) {
                                    jSONObject.put("tag", (Object) split2[0]);
                                    jSONObject.put("message", (Object) join.replaceFirst(split2[0] + CertificateUtil.DELIMITER, "").trim());
                                    jSONArray.put((Object) jSONObject);
                                }
                            }
                        } catch (NumberFormatException | JSONException unused) {
                        }
                    }
                }
            } else {
                try {
                    break;
                } catch (Exception e11) {
                    e11.getMessage();
                }
            }
        }
        Runtime.getRuntime().exec(new String[]{"logcat", "-c"});
        return jSONArray;
    }

    public final boolean b() {
        return this.f13076d > 0;
    }

    public final String b(double d11) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS z", Locale.US);
        Calendar instance = Calendar.getInstance();
        instance.set(14, (int) (((double) instance.get(14)) - (d11 * 1000.0d)));
        return simpleDateFormat.format(instance.getTime());
    }

    public final void b(int i11, int i12, boolean z11) {
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(hb.c().b());
        arrayList.addAll(hb.c().f13532c);
        ca caVar = new ca(arrayList, gm.f13472u, z11, i12, i11);
        if (!caVar.d()) {
            this.f13073a.addAll(caVar.f13104d);
            f13070g = true;
            gu.a("filter11").getClass();
        }
    }

    public void a(int i11, String str) {
        this.f13076d = i11;
        this.f13077e = str;
        a();
        hu.a("createdCancelledSessionFile", (Map) null);
    }

    public File a() {
        JSONObject jSONObject;
        double d11;
        boolean z11;
        String str;
        String str2;
        JSONArray jSONArray;
        JSONArray jSONArray2;
        ib ibVar = hb.c().f13531b;
        try {
            hu.a("fileWriteStarted", (Map) null);
            JSONObject jSONObject2 = new JSONObject();
            JSONObject jSONObject3 = new JSONObject();
            JSONObject jSONObject4 = new JSONObject();
            JSONObject jSONObject5 = new JSONObject();
            hz hzVar = hm.f().f13582g;
            hz hzVar2 = hzVar.f13614c;
            if (hzVar2 == null) {
                jSONObject = hzVar.b();
                hzVar.a();
            } else {
                jSONObject = hzVar2.b();
                hzVar.f13614c = null;
            }
            jSONObject2.put("usr", (Object) jSONObject);
            gu.ab a11 = gu.a("userTest");
            if (!(jSONObject instanceof JSONObject)) {
                jSONObject.toString();
            } else {
                JSONObjectInstrumentation.toString(jSONObject);
            }
            a11.getClass();
            Context context = ia.f13617c;
            if (!b()) {
                jSONObject3.put("cust", (Object) hm.f().f13577b.b());
                hm.f().f13577b.a();
                DecimalFormat decimalFormat = (DecimalFormat) NumberFormat.getNumberInstance(Locale.US);
                decimalFormat.applyPattern("0.000");
                d11 = (double) a(context);
                if (ibVar != null) {
                    a((float) d11);
                }
                jSONObject3.put(TtmlNode.TAG_TT, (Object) Double.valueOf(decimalFormat.format(d11)));
            } else {
                d11 = 0.0d;
            }
            jSONObject3.put("networkSummary", (Object) as.ab.a());
            jSONObject3.put("pixelCopyCaptureEnabled", hm.e().f12946f);
            jSONObject3.put("nt", (Object) ia.e(context));
            jSONObject3.put("isvo", gm.f13477z);
            String str3 = gm.L;
            if (str3 != null && !str3.isEmpty()) {
                jSONObject3.put("id", (Object) gm.L);
            }
            String str4 = gm.f13455d;
            if (str4 != null && !str4.isEmpty()) {
                jSONObject3.put("appId", (Object) gm.f13455d);
            }
            if (!this.f13074b.isEmpty()) {
                jSONObject2.put("crashData", (Object) new JSONObject(this.f13074b));
                z11 = true;
            } else {
                z11 = false;
            }
            jSONObject3.put("isc", z11);
            jSONObject2.put(SDKCoreEvent.Session.TYPE_SESSION, (Object) jSONObject3);
            JSONArray jSONArray3 = new JSONArray();
            JSONObject jSONObject6 = gm.J;
            if (jSONObject6 != null) {
                jSONArray3.put((Object) jSONObject6);
            }
            JSONObject d12 = ia.d(context);
            if (d12 != null) {
                jSONArray3.put((Object) d12);
            }
            jSONObject4.put("battery", (Object) jSONArray3);
            SharedPreferences sharedPreferences = new eq(context).f13291a;
            jSONObject4.put("pushToken", (Object) sharedPreferences == null ? "" : sharedPreferences.getString("push_notification_token", (String) null));
            jSONObject4.put("did", (Object) bm.a(context));
            jSONObject4.put("osn", (Object) bm.a());
            jSONObject4.put("dvt", (Object) bm.f(context) ? "Tablet" : "Phone");
            Point c11 = bm.c(context);
            int i11 = c11.y;
            int i12 = c11.x;
            if (i12 > i11) {
                jSONObject4.put("dwt", (Object) Integer.toString(i11));
                jSONObject4.put("dht", (Object) Integer.toString(i12));
            } else {
                jSONObject4.put("dwt", i12);
                jSONObject4.put("dht", i11);
            }
            jSONObject4.put("ahp", fl.a().f13360e);
            Point c12 = bm.c(context);
            JSONArray jSONArray4 = new JSONArray();
            jSONArray4.put(c12.x);
            jSONArray4.put(c12.y);
            jSONObject4.put(ArchiveStreamFactory.AR, (Object) jSONArray4);
            DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
            JSONArray jSONArray5 = new JSONArray();
            jSONArray5.put((double) displayMetrics.xdpi);
            jSONArray5.put((double) displayMetrics.ydpi);
            jSONObject4.put("xyDpi", (Object) jSONArray5);
            jSONObject4.put("dpi", bm.e(context));
            jSONObject4.put("osv", (Object) Build.VERSION.RELEASE);
            jSONObject4.put("mnf", (Object) Build.MANUFACTURER);
            jSONObject4.put("mdl", (Object) Build.MODEL);
            jSONObject4.put("isr", ia.g());
            jSONObject4.put("ttr", ia.f(context));
            jSONObject4.put("tts", (int) ia.e());
            jSONObject4.put("tfs", (int) ia.a());
            jSONObject4.put("cr", (Object) ((TelephonyManager) context.getSystemService("phone")).getNetworkOperatorName());
            jSONObject4.put("cc", (Object) ((TelephonyManager) context.getSystemService("phone")).getNetworkOperator());
            jSONObject4.put("cnt", (Object) Locale.getDefault().getDisplayCountry());
            jSONObject4.put("lng", (Object) Locale.getDefault().getDisplayLanguage());
            if (hm.f13566i == null || !Arrays.asList(f13069f).contains(hm.f13566i)) {
                str2 = "";
                str = str2;
            } else {
                String str5 = hm.f13566i;
                str = hm.f13567j;
                str2 = str5;
            }
            jSONObject4.put("plf", (Object) "android");
            jSONObject2.put("device", (Object) jSONObject4);
            gu.ab a12 = gu.a("bj");
            JSONObjectInstrumentation.toString(jSONObject4);
            a12.getClass();
            jSONObject5.put("version", (Object) "3.4.4");
            jSONObject5.put("versionNumber", 561);
            jSONObject5.put("pluginType", (Object) str2);
            jSONObject5.put("pluginVersion", (Object) str);
            jSONObject2.put("sdkv", (Object) jSONObject5);
            jSONObject2.put("ron", (Object) b(d11));
            Pair<String, Integer> c13 = ia.c(context);
            jSONObject2.put("appv", c13.first);
            jSONObject2.put("appvc", c13.second);
            jSONObject2.put("appn", (Object) ia.a(ia.f13617c));
            jSONObject2.put("misc", (Object) new JSONObject(gm.f13464m));
            jSONObject2.put("pushNotificationData", (Object) et.a(context, d11));
            if (gm.A) {
                this.f13073a.add(10);
            }
            JSONArray jSONArray6 = new JSONArray();
            if (!b()) {
                int e11 = hb.c().e();
                if (!gm.f13469r && (jSONArray2 = gm.f13471t) != null && jSONArray2.length() > 0) {
                    a(e11, (int) d11, z11);
                }
                if (!gm.f13470s && (jSONArray = gm.f13472u) != null && jSONArray.length() > 0) {
                    b(e11, (int) d11, z11);
                }
                if (f13072i) {
                    this.f13073a.add(8);
                }
                JSONObject jSONObject7 = new JSONObject();
                jSONObject7.put("recordStatus", gm.f13457f);
                if (!this.f13073a.isEmpty()) {
                    Iterator it = this.f13073a.iterator();
                    while (it.hasNext()) {
                        jSONArray6.put(((Integer) it.next()).intValue());
                    }
                    jSONObject7.putOpt("reasonForNoVideo", jSONArray6);
                }
                if (gm.f13457f) {
                    jSONObject7.putOpt("videoSize", Long.valueOf(this.f13075c));
                }
                jSONObject3.put("video", (Object) jSONObject7);
                if (ibVar != null) {
                    ibVar.b();
                }
                jSONObject2.put("evt", (Object) hb.c().f());
                jSONObject2.put("anr", (Object) hb.c().f13534e);
                jSONObject2.put("bugReport", (Object) hb.c().f13535f);
                hb.c().f13532c = new ArrayList();
                hb.c().f13533d = new ArrayList();
                hb.c().f13534e = new JSONArray();
                hb.c().f13535f = new JSONArray();
                gu.a("bj").getClass();
                jSONObject2.put(UserDataStore.STATE, (Object) hb.c().h());
                if (gm.f13465n) {
                    jSONObject2.put("sessionCancelled", 1);
                    f13070g = true;
                    gm.f13465n = false;
                } else if (gm.f13466o) {
                    jSONObject2.put("sessionCancelled", 6);
                    f13070g = true;
                    gm.f13466o = false;
                } else if (f13070g && gm.f13473v) {
                    jSONObject2.put("sessionCancelled", 7);
                } else if (f13071h) {
                    f13071h = false;
                    f13070g = true;
                }
            }
            if (b()) {
                jSONObject2.put("sessionCancelled", this.f13076d);
            }
            gu.ab a13 = gu.a("bj");
            jSONObject2.toString();
            a13.getClass();
            if (gm.M) {
                try {
                    jSONObject3.put("appLogJson", (Object) a(d11));
                } catch (Exception e12) {
                    jSONObject3.put("appLogError", (Object) "Exception occurred when getting app log : " + e12.getMessage());
                }
            } else {
                jSONObject3.put("appLogError", (Object) "recordAppLog flag is disabled.");
            }
            String c14 = b() ? this.f13077e : by.c();
            a(JSONObjectInstrumentation.toString(jSONObject2), c14);
            File file = new File(c14 + by.d());
            gm.f13469r = false;
            gm.f13470s = false;
            if (!f13070g || b()) {
                new eq(context).c();
            } else {
                f13070g = false;
                try {
                    File[] listFiles = file.getParentFile().listFiles(new aa(this));
                    ia.c(listFiles[0]);
                    gu.ab a14 = gu.a("filter11");
                    listFiles[0].getAbsolutePath();
                    a14.getClass();
                    HashMap hashMap = new HashMap();
                    hashMap.put("recordStatus", Boolean.valueOf(gm.f13457f));
                    hashMap.put("ignoreScreenVideo", Boolean.valueOf(f13070g));
                    hashMap.put("reasonForNoVideo", JSONArrayInstrumentation.toString(jSONArray6));
                    hu.a("screenVideoIgnored", hashMap);
                } catch (Exception e13) {
                    e13.printStackTrace();
                }
                new eq(context).c();
            }
            HashMap hashMap2 = new HashMap();
            hashMap2.put("file_size", Long.valueOf(file.length() / 1024));
            hashMap2.put(AnalyticsEvents.PARAMETER_SHARE_OUTCOME_CANCELLED, Integer.valueOf(jSONObject2.optInt("sessionCancelled")));
            hu.a("fileWriteCompleted", hashMap2);
            if (!b()) {
                f13072i = false;
                if (!bi.f13066a) {
                    gk.f13444f = 0;
                }
            }
            return file;
        } catch (JSONException unused) {
            gu.a("bj").getClass();
            gu.f13504c.getClass();
            hu.c("textFileWriteException", (Map) null);
            return null;
        }
    }

    public final float a(Context context) {
        float d11 = ia.d();
        String c11 = by.c();
        int i11 = gm.f13452a;
        File file = new File(c11, "video.mp4");
        if (((double) d11) < ((double) (((float) gm.f13458g) / 1000.0f)) + 0.3d) {
            f13071h = true;
            this.f13073a.add(6);
        } else if (file.exists()) {
            try {
                new HashMap();
                MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
                mediaMetadataRetriever.setDataSource(context, Uri.fromFile(file));
                float intValue = ((float) Integer.valueOf(mediaMetadataRetriever.extractMetadata(9)).intValue()) / 1000.0f;
                if (intValue > d11) {
                    d11 = intValue;
                }
                this.f13075c = file.length();
            } catch (Exception unused) {
                gu.a("bj").getClass();
                gu.a("bj").getClass();
            }
        }
        return d11;
    }

    public final void a(int i11, int i12, boolean z11) {
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(hb.c().b());
        arrayList.addAll(hb.c().f13532c);
        ca caVar = new ca(arrayList, gm.f13471t, z11, i12, i11);
        if (!caVar.d()) {
            this.f13073a.addAll(caVar.f13104d);
            gm.f13466o = true;
            gu.a("filter11").getClass();
        }
    }

    public final void a(float f11) {
        try {
            ArrayList arrayList = hb.c().f13530a;
            gz gzVar = (gz) arrayList.get(arrayList.size() - 1);
            gzVar.f13519d = f11 - gzVar.f13517b;
        } catch (Exception e11) {
            e11.printStackTrace();
        }
    }

    public void a(String str, String str2) {
        try {
            File file = new File(str2);
            if (!file.exists()) {
                file.mkdirs();
            }
            if (gm.C) {
                ZipOutputStream zipOutputStream = new ZipOutputStream(new FileOutputStream(new File(file, by.d())));
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                hj hjVar = new hj();
                GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(hjVar.a(byteArrayOutputStream));
                gZIPOutputStream.write(str.getBytes());
                gZIPOutputStream.close();
                zipOutputStream.putNextEntry(new ZipEntry("data.json.gz.aes"));
                zipOutputStream.write(byteArrayOutputStream.toByteArray());
                zipOutputStream.closeEntry();
                zipOutputStream.putNextEntry(new ZipEntry("metadata.json"));
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("decryptKey", (Object) hjVar.c());
                jSONObject.put("decryptiv", (Object) hjVar.b());
                JSONObjectInstrumentation.toString(jSONObject);
                zipOutputStream.write(JSONObjectInstrumentation.toString(jSONObject).getBytes());
                zipOutputStream.closeEntry();
                zipOutputStream.close();
                return;
            }
            FileOutputStream fileOutputStream = new FileOutputStream(new File(file, by.d()));
            fileOutputStream.write(str.getBytes());
            fileOutputStream.close();
        } catch (IOException e11) {
            e11.printStackTrace();
            fx fxVar = new fx();
            fxVar.a("EXCEPTION");
            fxVar.a("site_of_error", "DataFile::generateFileOnSD() -> catch1");
            fxVar.a("reason", e11.getMessage());
            fxVar.a("file_path", this.f13077e).a(2);
        } catch (JSONException e12) {
            e12.printStackTrace();
            fx fxVar2 = new fx();
            fxVar2.a("EXCEPTION");
            fxVar2.a("site_of_error", "DataFile::generateFileOnSD() -> catch2");
            fxVar2.a("reason", e12.getMessage());
            fxVar2.a(2);
        }
    }

    public void a(String str) {
        try {
            File file = new File(by.c());
            if (!file.exists()) {
                file.mkdirs();
            }
            FileOutputStream fileOutputStream = new FileOutputStream(new File(file, str));
            fileOutputStream.write("".getBytes());
            fileOutputStream.close();
        } catch (IOException e11) {
            e11.printStackTrace();
            fx fxVar = new fx();
            fxVar.a("EXCEPTION");
            fxVar.a("site_of_error", "DataFile::generateEmptyDataFileOnSD()");
            fxVar.a("reason", e11.getMessage());
            fxVar.a(2);
        }
    }
}
