package com.instabug.survey.announcements;

import android.os.Build;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.instabug.library.Instabug;
import com.instabug.library.core.InstabugCore;
import com.instabug.library.internal.device.InstabugDeviceProperties;
import com.instabug.library.internal.storage.cache.db.InstabugDbContract;
import com.instabug.library.settings.SettingsManager;
import com.instabug.library.util.InstabugSDKLogger;
import com.instabug.library.util.ObjectMapper;
import com.instabug.library.util.TimeUtils;
import com.instabug.survey.announcements.cache.f;
import com.instabug.survey.announcements.models.a;
import com.instabug.survey.utils.q;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class c {
    @Deprecated

    /* renamed from: a  reason: collision with root package name */
    private String f52223a;

    /* renamed from: b  reason: collision with root package name */
    private String f52224b;

    public c(String str, String str2) {
        this.f52223a = str;
        this.f52224b = str2;
    }

    private int a(long j11, long j12) {
        return (int) TimeUnit.DAYS.convert(j12 - j11, TimeUnit.MILLISECONDS);
    }

    private boolean a(com.instabug.survey.common.models.c cVar, int i11) {
        b("checkSessionCountCondition(condition: " + cVar + "). actualSessionCount: " + i11);
        if (cVar.c() == null || cVar.b() == null) {
            return false;
        }
        int parseInt = Integer.parseInt(cVar.c());
        String b11 = cVar.b();
        b11.hashCode();
        char c11 = 65535;
        switch (b11.hashCode()) {
            case -1374681402:
                if (b11.equals("greater_than")) {
                    c11 = 0;
                    break;
                }
                break;
            case 96757556:
                if (b11.equals("equal")) {
                    c11 = 1;
                    break;
                }
                break;
            case 365984903:
                if (b11.equals("less_than")) {
                    c11 = 2;
                    break;
                }
                break;
            case 1614662344:
                if (b11.equals("not_equal")) {
                    c11 = 3;
                    break;
                }
                break;
        }
        switch (c11) {
            case 0:
                return i11 > parseInt;
            case 1:
                return i11 == parseInt;
            case 2:
                return i11 < parseInt;
            case 3:
                return i11 != parseInt;
            default:
                return false;
        }
    }

    @Nullable
    private static com.instabug.survey.common.models.c b(a aVar) {
        if (aVar == null) {
            b("getTargetVersionCondition(announcement: null)");
            return null;
        }
        b("getTargetVersionCondition(announcementId: " + aVar.i() + ")");
        Iterator it = aVar.n().e().iterator();
        while (it.hasNext()) {
            com.instabug.survey.common.models.c cVar = (com.instabug.survey.common.models.c) it.next();
            if (cVar.a() != null && cVar.a().equals("app_version_v2")) {
                b("condition: " + cVar);
                return cVar;
            }
        }
        return null;
    }

    private static void b(String str) {
        InstabugSDKLogger.i("AnnouncementValidator", str);
    }

    private boolean b(com.instabug.survey.common.models.c cVar, int i11) {
        return a(cVar, i11);
    }

    private boolean c(a aVar) {
        com.instabug.survey.common.models.c b11;
        if (Instabug.getApplicationContext() == null || InstabugDeviceProperties.isFirstInstall(Instabug.getApplicationContext()) || (b11 = b(aVar)) == null) {
            return false;
        }
        return j(b11);
    }

    private List d() {
        List<a> a11 = f.a(101);
        ArrayList arrayList = new ArrayList();
        if (a11 != null && a11.size() > 0) {
            for (a aVar : a11) {
                if (f(aVar) && e(aVar)) {
                    arrayList.add(aVar);
                }
            }
        }
        return arrayList;
    }

    private boolean d(a aVar) {
        return aVar.e() == 1;
    }

    private List e() {
        List<a> a11 = f.a(100);
        ArrayList arrayList = new ArrayList();
        if (a11 != null && a11.size() > 0) {
            for (a aVar : a11) {
                if (c(aVar) && e(aVar) && d(aVar)) {
                    arrayList.add(aVar);
                }
            }
        }
        return arrayList;
    }

    private boolean e(a aVar) {
        boolean z11 = aVar.z();
        b("validateShowingRepetition(announcement: " + aVar + "). ShouldShow ? " + z11);
        return z11;
    }

    private boolean f(com.instabug.survey.common.models.c cVar) {
        b("validateOSApiLevel(condition: " + cVar + ")");
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Build.VERSION.SDK_INT: ");
        int i11 = Build.VERSION.SDK_INT;
        sb2.append(i11);
        b(sb2.toString());
        if (cVar.c() == null || cVar.b() == null) {
            return false;
        }
        int parseInt = Integer.parseInt(cVar.c());
        String b11 = cVar.b();
        b11.hashCode();
        char c11 = 65535;
        switch (b11.hashCode()) {
            case -1374681402:
                if (b11.equals("greater_than")) {
                    c11 = 0;
                    break;
                }
                break;
            case 96757556:
                if (b11.equals("equal")) {
                    c11 = 1;
                    break;
                }
                break;
            case 365984903:
                if (b11.equals("less_than")) {
                    c11 = 2;
                    break;
                }
                break;
            case 1614662344:
                if (b11.equals("not_equal")) {
                    c11 = 3;
                    break;
                }
                break;
        }
        switch (c11) {
            case 0:
                return i11 > parseInt;
            case 1:
                return i11 == parseInt;
            case 2:
                return i11 < parseInt;
            case 3:
                return i11 != parseInt;
            default:
                return false;
        }
    }

    @Nullable
    public a a() {
        List c11 = c();
        if (c11 == null || c11.size() <= 0) {
            b("getFirstValidAnnouncement: no valid announcements. Returning null...");
            return null;
        }
        a aVar = (a) c11.get(0);
        b("getFirstValidAnnouncement:" + c11.size() + " available announcements");
        StringBuilder sb2 = new StringBuilder();
        sb2.append("getFirstValidAnnouncement: ");
        sb2.append(aVar);
        b(sb2.toString());
        return aVar;
    }

    @Nullable
    public String a(@Nullable String str) {
        if (str == null) {
            return null;
        }
        Matcher matcher = Pattern.compile("\\d+(\\.\\d+)*").matcher(str);
        if (matcher.find()) {
            return matcher.group(0);
        }
        return null;
    }

    public boolean a(com.instabug.survey.common.models.c cVar) {
        if (cVar.b() == null || cVar.c() == null) {
            return false;
        }
        long parseLong = Long.parseLong(cVar.c());
        long a11 = (long) a(b(), TimeUtils.currentTimeMillis());
        b("checkLastSeenTimestamp(condition: " + cVar + "). daysSinceLastSeen: " + a11);
        String b11 = cVar.b();
        b11.hashCode();
        char c11 = 65535;
        switch (b11.hashCode()) {
            case -1374681402:
                if (b11.equals("greater_than")) {
                    c11 = 0;
                    break;
                }
                break;
            case 96757556:
                if (b11.equals("equal")) {
                    c11 = 1;
                    break;
                }
                break;
            case 365984903:
                if (b11.equals("less_than")) {
                    c11 = 2;
                    break;
                }
                break;
            case 1614662344:
                if (b11.equals("not_equal")) {
                    c11 = 3;
                    break;
                }
                break;
        }
        switch (c11) {
            case 0:
                return a11 > parseLong;
            case 1:
                return a11 == parseLong;
            case 2:
                return a11 < parseLong;
            case 3:
                return a11 != parseLong;
            default:
                return false;
        }
    }

    @VisibleForTesting
    public boolean a(com.instabug.survey.common.models.c cVar, @Nullable com.instabug.survey.models.a aVar) {
        if (!(aVar == null || cVar == null)) {
            String c11 = aVar.c();
            if ("equal".equals(cVar.b()) && cVar.c() != null) {
                return cVar.c().equalsIgnoreCase(c11);
            }
        }
        return false;
    }

    @VisibleForTesting
    public long b() {
        return InstabugCore.getLastSeenTimestamp();
    }

    public boolean b(com.instabug.survey.common.models.c cVar) {
        return f(cVar);
    }

    public List c() {
        List d11 = d();
        return d11.size() == 0 ? e() : d11;
    }

    @VisibleForTesting
    public boolean f(a aVar) {
        b("checkStringCondition(announcement: " + aVar + ")");
        boolean g11 = g(aVar.n().e(), aVar.f());
        b("primitiveTypesValidity: " + g11);
        boolean a11 = q.a(aVar.n().c(), aVar.f());
        b("customAttributesValidity: " + a11);
        boolean b11 = q.b(aVar.n().g(), aVar.f());
        b("userEventsValidity: " + b11);
        if (aVar.n().g().size() > 0 || aVar.n().c().size() > 0 || aVar.n().e().size() > 0) {
            return "or".equals(aVar.f()) ? g11 || a11 || b11 : g11 && a11 && b11;
        }
        return true;
    }

    @VisibleForTesting
    public boolean g(ArrayList arrayList, String str) {
        int i11 = 0;
        int size = arrayList == null ? 0 : arrayList.size();
        b("checkPrimitiveTypes(primitiveTypesConditions: " + size + ", conditionsOperator: " + str + ")");
        boolean equals = str.equals("and");
        while (i11 < size) {
            boolean h11 = h((com.instabug.survey.common.models.c) arrayList.get(i11));
            equals = i11 == 0 ? h11 : "or".equals(str) ? equals | h11 : equals & h11;
            i11++;
        }
        return equals;
    }

    @VisibleForTesting
    public boolean h(com.instabug.survey.common.models.c cVar) {
        b("checkPrimitiveType(primitiveTypeCondition: " + cVar + ")");
        if (cVar.a() == null) {
            return false;
        }
        String a11 = cVar.a();
        a11.hashCode();
        char c11 = 65535;
        switch (a11.hashCode()) {
            case -901870406:
                if (a11.equals("app_version")) {
                    c11 = 0;
                    break;
                }
                break;
            case -12379384:
                if (a11.equals("android_version")) {
                    c11 = 1;
                    break;
                }
                break;
            case 96619420:
                if (a11.equals("email")) {
                    c11 = 2;
                    break;
                }
                break;
            case 957831062:
                if (a11.equals("country")) {
                    c11 = 3;
                    break;
                }
                break;
            case 1694233633:
                if (a11.equals("app_version_v2")) {
                    c11 = 4;
                    break;
                }
                break;
            case 1905908461:
                if (a11.equals("sessions_count")) {
                    c11 = 5;
                    break;
                }
                break;
            case 2013274756:
                if (a11.equals(InstabugDbContract.UserEntity.COLUMN_LAST_SEEN)) {
                    c11 = 6;
                    break;
                }
                break;
        }
        switch (c11) {
            case 0:
                return i(cVar);
            case 1:
                return b(cVar);
            case 2:
                return k(cVar);
            case 3:
                return a(cVar, (com.instabug.survey.models.a) ObjectMapper.fromJson(com.instabug.survey.announcements.settings.a.a(), com.instabug.survey.models.a.class));
            case 4:
                return j(cVar);
            case 5:
                return b(cVar, SettingsManager.getInstance().getSessionsCount());
            case 6:
                return a(cVar);
            default:
                return false;
        }
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    @java.lang.Deprecated
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean i(com.instabug.survey.common.models.c r6) {
        /*
            r5 = this;
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "validateAppVersion(condition: "
            r0.append(r1)
            r0.append(r6)
            java.lang.String r1 = ")"
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            b((java.lang.String) r0)
            java.lang.String r0 = r6.c()
            java.lang.String r0 = r5.a((java.lang.String) r0)
            java.lang.String r1 = r5.f52224b
            java.lang.String r1 = r5.a((java.lang.String) r1)
            if (r0 == 0) goto L_0x008a
            r2 = 0
            if (r1 != 0) goto L_0x002e
            return r2
        L_0x002e:
            int r0 = com.instabug.library.util.StringUtility.compareVersion(r1, r0)     // Catch:{ NumberFormatException -> 0x0089 }
            java.lang.String r1 = r6.b()
            if (r1 != 0) goto L_0x0039
            return r2
        L_0x0039:
            java.lang.String r6 = r6.b()
            r6.hashCode()
            int r1 = r6.hashCode()
            r3 = -1
            r4 = 1
            switch(r1) {
                case -1374681402: goto L_0x006c;
                case 96757556: goto L_0x0061;
                case 365984903: goto L_0x0056;
                case 1614662344: goto L_0x004b;
                default: goto L_0x0049;
            }
        L_0x0049:
            r6 = r3
            goto L_0x0076
        L_0x004b:
            java.lang.String r1 = "not_equal"
            boolean r6 = r6.equals(r1)
            if (r6 != 0) goto L_0x0054
            goto L_0x0049
        L_0x0054:
            r6 = 3
            goto L_0x0076
        L_0x0056:
            java.lang.String r1 = "less_than"
            boolean r6 = r6.equals(r1)
            if (r6 != 0) goto L_0x005f
            goto L_0x0049
        L_0x005f:
            r6 = 2
            goto L_0x0076
        L_0x0061:
            java.lang.String r1 = "equal"
            boolean r6 = r6.equals(r1)
            if (r6 != 0) goto L_0x006a
            goto L_0x0049
        L_0x006a:
            r6 = r4
            goto L_0x0076
        L_0x006c:
            java.lang.String r1 = "greater_than"
            boolean r6 = r6.equals(r1)
            if (r6 != 0) goto L_0x0075
            goto L_0x0049
        L_0x0075:
            r6 = r2
        L_0x0076:
            switch(r6) {
                case 0: goto L_0x0086;
                case 1: goto L_0x0082;
                case 2: goto L_0x007e;
                case 3: goto L_0x007a;
                default: goto L_0x0079;
            }
        L_0x0079:
            return r2
        L_0x007a:
            if (r0 == 0) goto L_0x007d
            r2 = r4
        L_0x007d:
            return r2
        L_0x007e:
            if (r0 != r3) goto L_0x0081
            r2 = r4
        L_0x0081:
            return r2
        L_0x0082:
            if (r0 != 0) goto L_0x0085
            r2 = r4
        L_0x0085:
            return r2
        L_0x0086:
            if (r0 != r4) goto L_0x0089
            r2 = r4
        L_0x0089:
            return r2
        L_0x008a:
            java.lang.String r0 = r5.f52223a
            boolean r6 = com.instabug.survey.utils.q.a((com.instabug.survey.common.models.c) r6, (java.lang.String) r0)
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.instabug.survey.announcements.c.i(com.instabug.survey.common.models.c):boolean");
    }

    /* JADX WARNING: Removed duplicated region for block: B:29:0x007b  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x0084  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean j(com.instabug.survey.common.models.c r12) {
        /*
            r11 = this;
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "validateAppVersion(condition: "
            r0.append(r1)
            r0.append(r12)
            java.lang.String r1 = ")"
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            b((java.lang.String) r0)
            java.lang.String r0 = r12.b()
            r1 = 0
            if (r0 == 0) goto L_0x0089
            java.lang.String r2 = r12.c()
            if (r2 != 0) goto L_0x0029
            goto L_0x0089
        L_0x0029:
            java.lang.String r2 = "greater_than"
            boolean r3 = r0.equals(r2)
            java.lang.String r4 = "less_than"
            if (r3 != 0) goto L_0x0041
            boolean r3 = r0.equals(r4)
            if (r3 == 0) goto L_0x003a
            goto L_0x0041
        L_0x003a:
            java.lang.String r0 = r11.f52224b
            boolean r12 = com.instabug.survey.utils.q.a((com.instabug.survey.common.models.c) r12, (java.lang.String) r0)
            return r12
        L_0x0041:
            java.lang.String r12 = r12.c()     // Catch:{ NumberFormatException -> 0x0089 }
            long r5 = java.lang.Long.parseLong(r12)     // Catch:{ NumberFormatException -> 0x0089 }
            long r7 = com.instabug.survey.settings.c.d()     // Catch:{ NumberFormatException -> 0x0089 }
            r9 = -1
            int r12 = (r5 > r9 ? 1 : (r5 == r9 ? 0 : -1))
            if (r12 == 0) goto L_0x0089
            int r12 = (r7 > r9 ? 1 : (r7 == r9 ? 0 : -1))
            if (r12 != 0) goto L_0x0058
            goto L_0x0089
        L_0x0058:
            int r12 = r0.hashCode()     // Catch:{ NumberFormatException -> 0x0089 }
            r3 = -1374681402(0xffffffffae1006c6, float:-3.2747825E-11)
            r9 = 1
            if (r12 == r3) goto L_0x0070
            r2 = 365984903(0x15d07c87, float:8.4207E-26)
            if (r12 == r2) goto L_0x0068
            goto L_0x0078
        L_0x0068:
            boolean r12 = r0.equals(r4)     // Catch:{ NumberFormatException -> 0x0089 }
            if (r12 == 0) goto L_0x0078
            r12 = r9
            goto L_0x0079
        L_0x0070:
            boolean r12 = r0.equals(r2)     // Catch:{ NumberFormatException -> 0x0089 }
            if (r12 == 0) goto L_0x0078
            r12 = r1
            goto L_0x0079
        L_0x0078:
            r12 = -1
        L_0x0079:
            if (r12 == 0) goto L_0x0084
            if (r12 == r9) goto L_0x007e
            return r1
        L_0x007e:
            int r12 = (r7 > r5 ? 1 : (r7 == r5 ? 0 : -1))
            if (r12 >= 0) goto L_0x0083
            r1 = r9
        L_0x0083:
            return r1
        L_0x0084:
            int r12 = (r7 > r5 ? 1 : (r7 == r5 ? 0 : -1))
            if (r12 <= 0) goto L_0x0089
            r1 = r9
        L_0x0089:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.instabug.survey.announcements.c.j(com.instabug.survey.common.models.c):boolean");
    }

    @VisibleForTesting
    public boolean k(com.instabug.survey.common.models.c cVar) {
        String identifiedUserEmail = InstabugCore.getIdentifiedUserEmail();
        b("validateUserEmail(condition: " + cVar + "). userEmail: " + identifiedUserEmail);
        return q.a(cVar, identifiedUserEmail);
    }
}
