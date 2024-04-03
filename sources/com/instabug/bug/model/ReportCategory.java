package com.instabug.bug.model;

import androidx.annotation.DrawableRes;
import androidx.annotation.Nullable;
import com.instabug.bug.settings.b;
import com.instabug.library.util.StringUtility;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public class ReportCategory {
    private static final String CATEGORY_ASK_A_QUESTION = "ask-a-question";
    private static final String CATEGORY_REPORT_A_PROBLEM = "report-a-problem";
    private static final String CATEGORY_SUGGEST_AN_IMPROVEMENT = "suggest-an-improvement";
    private static final String KEY_DESCRIPTION = "description";
    private static final String KEY_LABEL = "name";
    private static final String KEY_SLUG = "slug";
    private static final String KEY_SUBS = "subs";
    @Nullable
    private String description;
    private int icon;
    @Nullable
    private String label;
    @Nullable
    private List<ReportCategory> subs;

    private ReportCategory() {
    }

    private static ReportCategory fromJsonObject(JSONObject jSONObject) {
        ReportCategory reportCategory = new ReportCategory();
        if (jSONObject.has("name")) {
            reportCategory.setLabel(jSONObject.getString("name"));
        }
        if (jSONObject.has("description")) {
            reportCategory.setDescription(jSONObject.getString("description"));
        }
        ArrayList arrayList = new ArrayList();
        if (jSONObject.has(KEY_SUBS)) {
            JSONArray jSONArray = jSONObject.getJSONArray(KEY_SUBS);
            for (int i11 = 0; i11 < jSONArray.length(); i11++) {
                arrayList.add(fromJsonObject(jSONArray.getJSONObject(i11)));
            }
        }
        reportCategory.setSubs(arrayList);
        return reportCategory;
    }

    public static ReportCategory getInstance() {
        return new ReportCategory();
    }

    /* JADX WARNING: Removed duplicated region for block: B:21:0x0046 A[Catch:{ JSONException -> 0x0078 }] */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x0069 A[Catch:{ JSONException -> 0x0078 }] */
    @androidx.annotation.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static java.util.List<com.instabug.bug.model.ReportCategory> getRemoteSubReportCategories(java.lang.String r5) {
        /*
            com.instabug.bug.settings.b r0 = com.instabug.bug.settings.b.f()
            java.lang.String r0 = r0.j()
            if (r0 == 0) goto L_0x0080
            org.json.JSONArray r1 = new org.json.JSONArray     // Catch:{ JSONException -> 0x0078 }
            r1.<init>((java.lang.String) r0)     // Catch:{ JSONException -> 0x0078 }
            int r0 = r5.hashCode()     // Catch:{ JSONException -> 0x0078 }
            r2 = -191501435(0xfffffffff495eb85, float:-9.502309E31)
            r3 = 2
            r4 = 1
            if (r0 == r2) goto L_0x0039
            r2 = 97908(0x17e74, float:1.37198E-40)
            if (r0 == r2) goto L_0x002f
            r2 = 1621082316(0x609fc0cc, float:9.20914E19)
            if (r0 == r2) goto L_0x0025
            goto L_0x0043
        L_0x0025:
            java.lang.String r0 = "ask a question"
            boolean r5 = r5.equals(r0)     // Catch:{ JSONException -> 0x0078 }
            if (r5 == 0) goto L_0x0043
            r5 = r3
            goto L_0x0044
        L_0x002f:
            java.lang.String r0 = "bug"
            boolean r5 = r5.equals(r0)     // Catch:{ JSONException -> 0x0078 }
            if (r5 == 0) goto L_0x0043
            r5 = 0
            goto L_0x0044
        L_0x0039:
            java.lang.String r0 = "feedback"
            boolean r5 = r5.equals(r0)     // Catch:{ JSONException -> 0x0078 }
            if (r5 == 0) goto L_0x0043
            r5 = r4
            goto L_0x0044
        L_0x0043:
            r5 = -1
        L_0x0044:
            if (r5 == 0) goto L_0x0069
            if (r5 == r4) goto L_0x005a
            if (r5 == r3) goto L_0x004b
            goto L_0x0080
        L_0x004b:
            java.lang.String r5 = "ask-a-question"
            java.util.List r5 = getSubCategories(r1, r5)     // Catch:{ JSONException -> 0x0078 }
            if (r5 == 0) goto L_0x0080
            int r0 = r5.size()     // Catch:{ JSONException -> 0x0078 }
            if (r0 <= 0) goto L_0x0080
            return r5
        L_0x005a:
            java.lang.String r5 = "suggest-an-improvement"
            java.util.List r5 = getSubCategories(r1, r5)     // Catch:{ JSONException -> 0x0078 }
            if (r5 == 0) goto L_0x0080
            int r0 = r5.size()     // Catch:{ JSONException -> 0x0078 }
            if (r0 <= 0) goto L_0x0080
            return r5
        L_0x0069:
            java.lang.String r5 = "report-a-problem"
            java.util.List r5 = getSubCategories(r1, r5)     // Catch:{ JSONException -> 0x0078 }
            if (r5 == 0) goto L_0x0080
            int r0 = r5.size()     // Catch:{ JSONException -> 0x0078 }
            if (r0 <= 0) goto L_0x0080
            return r5
        L_0x0078:
            r5 = move-exception
            java.lang.String r0 = "IBG-BR"
            java.lang.String r1 = "error while getRemoteSubReportCategories"
            com.instabug.library.util.InstabugSDKLogger.e(r0, r1, r5)
        L_0x0080:
            r5 = 0
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.instabug.bug.model.ReportCategory.getRemoteSubReportCategories(java.lang.String):java.util.List");
    }

    @Nullable
    private static List<ReportCategory> getSubCategories(JSONArray jSONArray, String str) {
        for (int i11 = 0; i11 < jSONArray.length(); i11++) {
            if (str.equals(jSONArray.getJSONObject(i11).getString(KEY_SLUG))) {
                return fromJsonObject(jSONArray.getJSONObject(i11)).getSubs();
            }
        }
        return null;
    }

    @Nullable
    public static List<ReportCategory> getSubReportCategories(String str) {
        List<ReportCategory> remoteSubReportCategories = getRemoteSubReportCategories(str);
        return remoteSubReportCategories != null ? remoteSubReportCategories : b.f().k();
    }

    public static boolean hasSubCategories(String str) {
        boolean z11;
        List<ReportCategory> remoteSubReportCategories = getRemoteSubReportCategories("bug");
        List<ReportCategory> remoteSubReportCategories2 = getRemoteSubReportCategories("feedback");
        List<ReportCategory> remoteSubReportCategories3 = getRemoteSubReportCategories("ask a question");
        if (remoteSubReportCategories == null || remoteSubReportCategories.isEmpty()) {
            z11 = false;
        } else if (str.equals("bug")) {
            return true;
        } else {
            z11 = true;
        }
        if (remoteSubReportCategories2 != null && !remoteSubReportCategories2.isEmpty()) {
            if (str.equals("feedback")) {
                return true;
            }
            z11 = true;
        }
        if (remoteSubReportCategories3 != null && !remoteSubReportCategories3.isEmpty()) {
            if (str.equals("ask a question")) {
                return true;
            }
            z11 = true;
        }
        List k11 = b.f().k();
        return !z11 && k11 != null && k11.size() > 0;
    }

    private void setSubs(@Nullable List<ReportCategory> list) {
        this.subs = list;
    }

    @Nullable
    public String getDescription() {
        return this.description;
    }

    public int getIcon() {
        return this.icon;
    }

    @Nullable
    public String getLabel() {
        return this.label;
    }

    @Nullable
    public List<ReportCategory> getSubs() {
        return this.subs;
    }

    public void setDescription(String str) {
        this.description = StringUtility.ellipsize(str, 75);
    }

    public void setIcon(@DrawableRes int i11) {
        this.icon = i11;
    }

    public void setLabel(String str) {
        this.label = StringUtility.ellipsize(str, 35);
    }

    public ReportCategory withIcon(@DrawableRes int i11) {
        this.icon = i11;
        return this;
    }

    public ReportCategory withLabel(String str) {
        this.label = str;
        return this;
    }
}
