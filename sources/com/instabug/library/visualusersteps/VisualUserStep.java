package com.instabug.library.visualusersteps;

import android.annotation.SuppressLint;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.newrelic.agent.android.instrumentation.JSONArrayInstrumentation;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import org.json.JSONArray;
import org.json.JSONException;

@Instrumented
public class VisualUserStep implements Serializable {
    private static final String KEY_BUTTON_ICON = "button_icon";
    private static final String KEY_DATE = "date";
    private static final String KEY_EVENT_TYPE = "event_type";
    private static final String KEY_IS_CONTAIN_ICON = "is_contains";
    private static final String KEY_PARENT_SCREEN_ID = "parent_screen_identifier";
    private static final String KEY_SCREENSHOT_ID = "screenshot_identifier";
    private static final String KEY_SCREEN_ID = "screen_identifier";
    private static final String KEY_SCREEN_NAME = "screen_name";
    private static final String KEY_VIEW = "view";
    private static final String KEY_VIEW_ORIENTATION = "orientation";
    @Nullable
    private String buttonIcon;
    private long date;
    private boolean isContainIcon;
    @Nullable
    private String orientation;
    @Nullable
    private String parentScreenId;
    @Nullable
    private String screenId;
    @Nullable
    private String screenName;
    @Nullable
    private String screenshotId;
    @Nullable
    private String stepType;
    @Nullable
    private String view;

    public static final class b {
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public long f52123a;
        /* access modifiers changed from: private */

        /* renamed from: b  reason: collision with root package name */
        public boolean f52124b;
        /* access modifiers changed from: private */
        @Nullable

        /* renamed from: c  reason: collision with root package name */
        public String f52125c;
        /* access modifiers changed from: private */
        @Nullable

        /* renamed from: d  reason: collision with root package name */
        public String f52126d;
        /* access modifiers changed from: private */
        @Nullable

        /* renamed from: e  reason: collision with root package name */
        public String f52127e;
        /* access modifiers changed from: private */
        @Nullable

        /* renamed from: f  reason: collision with root package name */
        public String f52128f;
        /* access modifiers changed from: private */
        @Nullable

        /* renamed from: g  reason: collision with root package name */
        public String f52129g;
        /* access modifiers changed from: private */
        @Nullable

        /* renamed from: h  reason: collision with root package name */
        public String f52130h;
        /* access modifiers changed from: private */
        @Nullable

        /* renamed from: i  reason: collision with root package name */
        public String f52131i;
        /* access modifiers changed from: private */
        @Nullable

        /* renamed from: j  reason: collision with root package name */
        public String f52132j;

        public b a(long j11) {
            this.f52123a = j11;
            return this;
        }

        private b(@Nullable String str) {
            this.f52123a = System.currentTimeMillis();
            this.f52132j = str;
        }

        public b a(boolean z11) {
            this.f52124b = z11;
            return this;
        }

        public b b(@Nullable String str) {
            this.f52125c = str;
            return this;
        }

        public b c(@Nullable String str) {
            this.f52128f = str;
            return this;
        }

        public b d(@Nullable String str) {
            this.f52126d = str;
            return this;
        }

        public b e(@Nullable String str) {
            this.f52127e = str;
            return this;
        }

        public b f(@Nullable String str) {
            this.f52129g = str;
            return this;
        }

        public b g(@Nullable String str) {
            this.f52130h = str;
            return this;
        }

        public b a(@Nullable String str) {
            this.f52131i = str;
            return this;
        }

        public VisualUserStep a() {
            return new VisualUserStep(this);
        }
    }

    public static b Builder(@Nullable String str) {
        return new b(str);
    }

    public static ArrayList<VisualUserStep> fromJson(JSONArray jSONArray) throws JSONException {
        ArrayList<VisualUserStep> arrayList = new ArrayList<>();
        if (jSONArray != null && jSONArray.length() > 0) {
            for (int i11 = 0; i11 < jSONArray.length(); i11++) {
                arrayList.add(fromJsonObject(jSONArray.getJSONObject(i11)));
            }
        }
        return arrayList;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:45:0x00b9, code lost:
        if (r14.equals("landscape") == false) goto L_0x00c4;
     */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x00c7  */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x00c9  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.instabug.library.visualusersteps.VisualUserStep fromJsonObject(org.json.JSONObject r14) throws org.json.JSONException {
        /*
            java.lang.String r0 = "event_type"
            boolean r1 = r14.has(r0)
            if (r1 == 0) goto L_0x0021
            java.lang.Object r1 = org.json.JSONObject.NULL
            java.lang.String r1 = r1.toString()
            java.lang.String r2 = r14.getString(r0)
            boolean r1 = r1.equals(r2)
            if (r1 != 0) goto L_0x0021
            java.lang.String r0 = r14.getString(r0)
            java.lang.String r0 = r0.toUpperCase()
            goto L_0x0023
        L_0x0021:
            java.lang.String r0 = "UNKNOWN"
        L_0x0023:
            java.lang.String r1 = "screen_name"
            boolean r2 = r14.has(r1)
            r3 = 0
            if (r2 == 0) goto L_0x0031
            java.lang.String r1 = r14.getString(r1)
            goto L_0x0032
        L_0x0031:
            r1 = r3
        L_0x0032:
            java.lang.String r2 = "screen_identifier"
            boolean r4 = r14.has(r2)
            if (r4 == 0) goto L_0x003f
            java.lang.String r2 = r14.getString(r2)
            goto L_0x0040
        L_0x003f:
            r2 = r3
        L_0x0040:
            java.lang.String r4 = "screenshot_identifier"
            boolean r5 = r14.has(r4)
            if (r5 == 0) goto L_0x004d
            java.lang.String r4 = r14.getString(r4)
            goto L_0x004e
        L_0x004d:
            r4 = r3
        L_0x004e:
            java.lang.String r5 = "date"
            boolean r6 = r14.has(r5)
            if (r6 == 0) goto L_0x005b
            java.lang.String r5 = r14.getString(r5)
            goto L_0x005c
        L_0x005b:
            r5 = r3
        L_0x005c:
            java.lang.String r6 = "parent_screen_identifier"
            boolean r7 = r14.has(r6)
            if (r7 == 0) goto L_0x0069
            java.lang.String r6 = r14.getString(r6)
            goto L_0x006a
        L_0x0069:
            r6 = r3
        L_0x006a:
            java.lang.String r7 = "is_contains"
            boolean r8 = r14.has(r7)
            r9 = 0
            if (r8 == 0) goto L_0x0078
            boolean r7 = r14.getBoolean(r7)
            goto L_0x0079
        L_0x0078:
            r7 = r9
        L_0x0079:
            java.lang.String r8 = "button_icon"
            boolean r10 = r14.has(r8)
            if (r10 == 0) goto L_0x0086
            java.lang.String r8 = r14.getString(r8)
            goto L_0x0087
        L_0x0086:
            r8 = r3
        L_0x0087:
            java.lang.String r10 = "view"
            boolean r11 = r14.has(r10)
            if (r11 == 0) goto L_0x0095
            java.lang.String r10 = r14.getString(r10)
            goto L_0x0096
        L_0x0095:
            r10 = r3
        L_0x0096:
            java.lang.String r11 = "orientation"
            boolean r12 = r14.has(r11)
            if (r12 == 0) goto L_0x00ca
            java.lang.String r14 = r14.getString(r11)
            int r3 = r14.hashCode()
            r11 = 729267099(0x2b77bb9b, float:8.8012383E-13)
            java.lang.String r12 = "landscape"
            java.lang.String r13 = "portrait"
            if (r3 == r11) goto L_0x00bc
            r11 = 1430647483(0x5545f2bb, float:1.36028944E13)
            if (r3 == r11) goto L_0x00b5
            goto L_0x00c4
        L_0x00b5:
            boolean r14 = r14.equals(r12)
            if (r14 == 0) goto L_0x00c4
            goto L_0x00c5
        L_0x00bc:
            boolean r14 = r14.equals(r13)
            if (r14 == 0) goto L_0x00c4
            r9 = 2
            goto L_0x00c5
        L_0x00c4:
            r9 = -1
        L_0x00c5:
            if (r9 == 0) goto L_0x00c9
            r3 = r13
            goto L_0x00ca
        L_0x00c9:
            r3 = r12
        L_0x00ca:
            if (r10 != 0) goto L_0x00ce
            java.lang.String r10 = ""
        L_0x00ce:
            com.instabug.library.visualusersteps.VisualUserStep$b r14 = Builder(r0)
            com.instabug.library.visualusersteps.VisualUserStep$b r14 = r14.d((java.lang.String) r1)
            com.instabug.library.visualusersteps.VisualUserStep$b r14 = r14.e((java.lang.String) r4)
            if (r5 == 0) goto L_0x00dd
            goto L_0x00df
        L_0x00dd:
            java.lang.String r5 = "0"
        L_0x00df:
            long r0 = java.lang.Long.parseLong(r5)
            com.instabug.library.visualusersteps.VisualUserStep$b r14 = r14.a((long) r0)
            com.instabug.library.visualusersteps.VisualUserStep$b r14 = r14.b((java.lang.String) r6)
            com.instabug.library.visualusersteps.VisualUserStep$b r14 = r14.f((java.lang.String) r10)
            com.instabug.library.visualusersteps.VisualUserStep$b r14 = r14.g((java.lang.String) r3)
            com.instabug.library.visualusersteps.VisualUserStep$b r14 = r14.c((java.lang.String) r2)
            com.instabug.library.visualusersteps.VisualUserStep$b r14 = r14.a((boolean) r7)
            com.instabug.library.visualusersteps.VisualUserStep$b r14 = r14.a((java.lang.String) r8)
            com.instabug.library.visualusersteps.VisualUserStep r14 = r14.a()
            return r14
        */
        throw new UnsupportedOperationException("Method not decompiled: com.instabug.library.visualusersteps.VisualUserStep.fromJsonObject(org.json.JSONObject):com.instabug.library.visualusersteps.VisualUserStep");
    }

    @Nullable
    private String getButtonIcon() {
        return this.buttonIcon;
    }

    private boolean isContainIcon() {
        return this.isContainIcon;
    }

    private void setScreenName(@Nullable String str) {
        this.screenName = str;
    }

    private void setStepType(@Nullable String str) {
        this.stepType = str;
    }

    public static String toJsonString(@Nullable ArrayList<VisualUserStep> arrayList) {
        JSONArray jSONArray = new JSONArray();
        if (arrayList != null && arrayList.size() > 0) {
            Iterator<VisualUserStep> it = arrayList.iterator();
            while (it.hasNext()) {
                jSONArray.put((Object) it.next().toJson());
            }
        }
        return JSONArrayInstrumentation.toString(jSONArray);
    }

    public void a(@Nullable String str) {
        this.buttonIcon = str;
    }

    public void b(boolean z11) {
        this.isContainIcon = z11;
    }

    public long getDate() {
        return this.date;
    }

    @Nullable
    public String getParentScreenId() {
        return this.parentScreenId;
    }

    @Nullable
    public String getScreenId() {
        return this.screenId;
    }

    @Nullable
    public String getScreenName() {
        return this.screenName;
    }

    @Nullable
    public String getScreenshotId() {
        return this.screenshotId;
    }

    @Nullable
    public String getStepType() {
        return this.stepType;
    }

    @Nullable
    public String getView() {
        return this.view;
    }

    @Nullable
    public String getViewOrientation() {
        return this.orientation;
    }

    public boolean hasScreenshot() {
        return this.screenshotId != null;
    }

    public void setDate(long j11) {
        this.date = j11;
    }

    public void setParentScreenId(@Nullable String str) {
        this.parentScreenId = str;
    }

    public void setScreenId(@Nullable String str) {
        this.screenId = str;
    }

    public void setScreenshotId(@Nullable String str) {
        this.screenshotId = str;
    }

    public void setView(@Nullable String str) {
        this.view = str;
    }

    public void setViewOrientation(@Nullable String str) {
        this.orientation = str;
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x002c A[Catch:{ JSONException -> 0x00f5 }] */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0049 A[Catch:{ JSONException -> 0x00f5 }] */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0066 A[Catch:{ JSONException -> 0x00f5 }] */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x0083 A[Catch:{ JSONException -> 0x00f5 }] */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x00b0 A[Catch:{ JSONException -> 0x00f5 }] */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x00cd A[Catch:{ JSONException -> 0x00f5 }] */
    @android.annotation.SuppressLint({"ERADICATE_PARAMETER_NOT_NULLABLE"})
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public org.json.JSONObject toJson() {
        /*
            r6 = this;
            org.json.JSONObject r0 = new org.json.JSONObject
            r0.<init>()
            java.lang.String r1 = "parent_screen_identifier"
            java.lang.String r2 = r6.getParentScreenId()     // Catch:{ JSONException -> 0x00f5 }
            java.lang.String r3 = "null"
            if (r2 == 0) goto L_0x001f
            java.lang.String r2 = r6.getParentScreenId()     // Catch:{ JSONException -> 0x00f5 }
            boolean r2 = r2.equals(r3)     // Catch:{ JSONException -> 0x00f5 }
            if (r2 == 0) goto L_0x001a
            goto L_0x001f
        L_0x001a:
            java.lang.String r2 = r6.getParentScreenId()     // Catch:{ JSONException -> 0x00f5 }
            goto L_0x0021
        L_0x001f:
            java.lang.Object r2 = org.json.JSONObject.NULL     // Catch:{ JSONException -> 0x00f5 }
        L_0x0021:
            r0.put((java.lang.String) r1, (java.lang.Object) r2)     // Catch:{ JSONException -> 0x00f5 }
            java.lang.String r1 = "screen_name"
            java.lang.String r2 = r6.getScreenName()     // Catch:{ JSONException -> 0x00f5 }
            if (r2 == 0) goto L_0x003c
            java.lang.String r2 = r6.getScreenName()     // Catch:{ JSONException -> 0x00f5 }
            boolean r2 = r2.equals(r3)     // Catch:{ JSONException -> 0x00f5 }
            if (r2 == 0) goto L_0x0037
            goto L_0x003c
        L_0x0037:
            java.lang.String r2 = r6.getScreenName()     // Catch:{ JSONException -> 0x00f5 }
            goto L_0x003e
        L_0x003c:
            java.lang.Object r2 = org.json.JSONObject.NULL     // Catch:{ JSONException -> 0x00f5 }
        L_0x003e:
            r0.put((java.lang.String) r1, (java.lang.Object) r2)     // Catch:{ JSONException -> 0x00f5 }
            java.lang.String r1 = "screenshot_identifier"
            java.lang.String r2 = r6.getScreenshotId()     // Catch:{ JSONException -> 0x00f5 }
            if (r2 == 0) goto L_0x0059
            java.lang.String r2 = r6.getScreenshotId()     // Catch:{ JSONException -> 0x00f5 }
            boolean r2 = r2.equals(r3)     // Catch:{ JSONException -> 0x00f5 }
            if (r2 == 0) goto L_0x0054
            goto L_0x0059
        L_0x0054:
            java.lang.String r2 = r6.getScreenshotId()     // Catch:{ JSONException -> 0x00f5 }
            goto L_0x005b
        L_0x0059:
            java.lang.Object r2 = org.json.JSONObject.NULL     // Catch:{ JSONException -> 0x00f5 }
        L_0x005b:
            r0.put((java.lang.String) r1, (java.lang.Object) r2)     // Catch:{ JSONException -> 0x00f5 }
            java.lang.String r1 = "screen_identifier"
            java.lang.String r2 = r6.getScreenId()     // Catch:{ JSONException -> 0x00f5 }
            if (r2 == 0) goto L_0x0076
            java.lang.String r2 = r6.getScreenId()     // Catch:{ JSONException -> 0x00f5 }
            boolean r2 = r2.equals(r3)     // Catch:{ JSONException -> 0x00f5 }
            if (r2 == 0) goto L_0x0071
            goto L_0x0076
        L_0x0071:
            java.lang.String r2 = r6.getScreenId()     // Catch:{ JSONException -> 0x00f5 }
            goto L_0x0078
        L_0x0076:
            java.lang.Object r2 = org.json.JSONObject.NULL     // Catch:{ JSONException -> 0x00f5 }
        L_0x0078:
            r0.put((java.lang.String) r1, (java.lang.Object) r2)     // Catch:{ JSONException -> 0x00f5 }
            java.lang.String r1 = "event_type"
            java.lang.String r2 = r6.getStepType()     // Catch:{ JSONException -> 0x00f5 }
            if (r2 == 0) goto L_0x0099
            java.lang.String r2 = r6.getStepType()     // Catch:{ JSONException -> 0x00f5 }
            java.lang.String r4 = "UNKNOWN"
            boolean r2 = r2.equals(r4)     // Catch:{ JSONException -> 0x00f5 }
            if (r2 == 0) goto L_0x0090
            goto L_0x0099
        L_0x0090:
            java.lang.String r2 = r6.getStepType()     // Catch:{ JSONException -> 0x00f5 }
            java.lang.String r2 = r2.toLowerCase()     // Catch:{ JSONException -> 0x00f5 }
            goto L_0x009b
        L_0x0099:
            java.lang.Object r2 = org.json.JSONObject.NULL     // Catch:{ JSONException -> 0x00f5 }
        L_0x009b:
            r0.put((java.lang.String) r1, (java.lang.Object) r2)     // Catch:{ JSONException -> 0x00f5 }
            java.lang.String r1 = "date"
            long r4 = r6.getDate()     // Catch:{ JSONException -> 0x00f5 }
            r0.put((java.lang.String) r1, (long) r4)     // Catch:{ JSONException -> 0x00f5 }
            java.lang.String r1 = "view"
            java.lang.String r2 = r6.getView()     // Catch:{ JSONException -> 0x00f5 }
            if (r2 == 0) goto L_0x00c0
            java.lang.String r2 = r6.getView()     // Catch:{ JSONException -> 0x00f5 }
            boolean r2 = r2.equals(r3)     // Catch:{ JSONException -> 0x00f5 }
            if (r2 == 0) goto L_0x00bb
            goto L_0x00c0
        L_0x00bb:
            java.lang.String r2 = r6.getView()     // Catch:{ JSONException -> 0x00f5 }
            goto L_0x00c2
        L_0x00c0:
            java.lang.Object r2 = org.json.JSONObject.NULL     // Catch:{ JSONException -> 0x00f5 }
        L_0x00c2:
            r0.put((java.lang.String) r1, (java.lang.Object) r2)     // Catch:{ JSONException -> 0x00f5 }
            java.lang.String r1 = "orientation"
            java.lang.String r2 = r6.getViewOrientation()     // Catch:{ JSONException -> 0x00f5 }
            if (r2 == 0) goto L_0x00dd
            java.lang.String r2 = r6.getViewOrientation()     // Catch:{ JSONException -> 0x00f5 }
            boolean r2 = r2.equals(r3)     // Catch:{ JSONException -> 0x00f5 }
            if (r2 == 0) goto L_0x00d8
            goto L_0x00dd
        L_0x00d8:
            java.lang.String r2 = r6.getViewOrientation()     // Catch:{ JSONException -> 0x00f5 }
            goto L_0x00df
        L_0x00dd:
            java.lang.Object r2 = org.json.JSONObject.NULL     // Catch:{ JSONException -> 0x00f5 }
        L_0x00df:
            r0.put((java.lang.String) r1, (java.lang.Object) r2)     // Catch:{ JSONException -> 0x00f5 }
            java.lang.String r1 = "is_contains"
            boolean r2 = r6.isContainIcon()     // Catch:{ JSONException -> 0x00f5 }
            r0.put((java.lang.String) r1, (boolean) r2)     // Catch:{ JSONException -> 0x00f5 }
            java.lang.String r1 = "button_icon"
            java.lang.String r2 = r6.getButtonIcon()     // Catch:{ JSONException -> 0x00f5 }
            r0.put((java.lang.String) r1, (java.lang.Object) r2)     // Catch:{ JSONException -> 0x00f5 }
            goto L_0x00f9
        L_0x00f5:
            r1 = move-exception
            r1.printStackTrace()
        L_0x00f9:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.instabug.library.visualusersteps.VisualUserStep.toJson():org.json.JSONObject");
    }

    @SuppressLint({"ERADICATE_PARAMETER_NOT_NULLABLE"})
    @NonNull
    public String toString() {
        return "VisualUserStep{parentScreenId='" + this.parentScreenId + '\'' + ", screenName='" + this.screenName + '\'' + ", screenshotId='" + this.screenshotId + '\'' + ", screenId='" + this.screenId + '\'' + ", eventType='" + this.stepType + '\'' + ", date=" + this.date + ", view='" + this.view + '\'' + AbstractJsonLexerKt.END_OBJ;
    }

    private VisualUserStep(b bVar) {
        this.stepType = "UNKNOWN";
        setParentScreenId(bVar.f52125c);
        setScreenName(bVar.f52126d);
        setScreenshotId(bVar.f52127e);
        setScreenId(bVar.f52128f);
        setStepType(bVar.f52132j);
        setDate(bVar.f52123a);
        setView(bVar.f52129g);
        setViewOrientation(bVar.f52130h);
        a(bVar.f52131i);
        b(bVar.f52124b);
    }
}
