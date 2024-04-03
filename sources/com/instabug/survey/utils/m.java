package com.instabug.survey.utils;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.instabug.library.core.InstabugCore;
import com.instabug.library.internal.storage.cache.db.InstabugDbContract;
import com.instabug.library.settings.SettingsManager;
import com.instabug.library.util.InstabugDateFormatter;
import com.instabug.library.util.InstabugSDKLogger;
import com.instabug.library.util.ObjectMapper;
import com.instabug.library.util.TimeUtils;
import com.instabug.survey.cache.l;
import com.instabug.survey.common.models.c;
import com.instabug.survey.models.Survey;
import com.instabug.survey.models.a;
import java.io.PrintStream;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class m {

    /* renamed from: a  reason: collision with root package name */
    private l f52592a;
    @Deprecated

    /* renamed from: b  reason: collision with root package name */
    private String f52593b;

    /* renamed from: c  reason: collision with root package name */
    private String f52594c;

    public m(l lVar, String str, String str2) {
        this.f52592a = lVar;
        this.f52593b = str;
        this.f52594c = str2;
    }

    private int a(long j11, long j12) {
        return (int) TimeUnit.DAYS.convert(j12 - j11, TimeUnit.MILLISECONDS);
    }

    @Nullable
    private String a(@Nullable String str) {
        if (str == null) {
            return null;
        }
        Matcher matcher = Pattern.compile("\\d+(\\.\\d+)*").matcher(str);
        if (matcher.find()) {
            return matcher.group(0);
        }
        return null;
    }

    @NonNull
    private List a(List list) {
        int size = list == null ? 0 : list.size();
        b("getAllValidSurveys(availableSurveys: " + size + ")");
        ArrayList arrayList = new ArrayList();
        if (list != null) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                Survey survey = (Survey) it.next();
                if (!survey.isOptInSurvey() && !survey.isPaused() && d(survey) && new b().c(survey)) {
                    arrayList.add(survey);
                }
            }
            b("validSurveys: " + arrayList.size());
            Collections.sort(list, new k(this));
        }
        return arrayList;
    }

    /* JADX WARNING: Removed duplicated region for block: B:28:0x0097  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x00aa  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean a(com.instabug.survey.common.models.c r10) {
        /*
            r9 = this;
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "checkDaysSinceSignUpCondition(condition: "
            r0.append(r1)
            r0.append(r10)
            java.lang.String r1 = ")"
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            r9.b((java.lang.String) r0)
            java.lang.String r0 = r10.c()
            r1 = 0
            if (r0 == 0) goto L_0x00b4
            java.lang.String r0 = r10.b()
            if (r0 != 0) goto L_0x0028
            goto L_0x00b4
        L_0x0028:
            java.lang.String r0 = r10.c()     // Catch:{ NumberFormatException -> 0x00ae }
            int r0 = java.lang.Integer.parseInt(r0)     // Catch:{ NumberFormatException -> 0x00ae }
            long r2 = com.instabug.library.core.InstabugCore.getFirstRunAt()     // Catch:{ NumberFormatException -> 0x00ae }
            int r2 = com.instabug.survey.utils.a.a(r2)     // Catch:{ NumberFormatException -> 0x00ae }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ NumberFormatException -> 0x00ae }
            r3.<init>()     // Catch:{ NumberFormatException -> 0x00ae }
            java.lang.String r4 = "actualDifferenceInDays: "
            r3.append(r4)     // Catch:{ NumberFormatException -> 0x00ae }
            r3.append(r2)     // Catch:{ NumberFormatException -> 0x00ae }
            java.lang.String r3 = r3.toString()     // Catch:{ NumberFormatException -> 0x00ae }
            r9.b((java.lang.String) r3)     // Catch:{ NumberFormatException -> 0x00ae }
            java.lang.String r3 = r10.b()     // Catch:{ NumberFormatException -> 0x00ae }
            int r4 = r3.hashCode()     // Catch:{ NumberFormatException -> 0x00ae }
            r5 = -1374681402(0xffffffffae1006c6, float:-3.2747825E-11)
            r6 = 3
            r7 = 2
            r8 = 1
            if (r4 == r5) goto L_0x008a
            r5 = 96757556(0x5c46734, float:1.8469662E-35)
            if (r4 == r5) goto L_0x0080
            r5 = 365984903(0x15d07c87, float:8.4207E-26)
            if (r4 == r5) goto L_0x0076
            r5 = 1614662344(0x603dcac8, float:5.4703852E19)
            if (r4 == r5) goto L_0x006c
            goto L_0x0094
        L_0x006c:
            java.lang.String r4 = "not_equal"
            boolean r10 = r3.equals(r4)     // Catch:{ NumberFormatException -> 0x00ae }
            if (r10 == 0) goto L_0x0094
            r10 = r8
            goto L_0x0095
        L_0x0076:
            java.lang.String r4 = "less_than"
            boolean r10 = r3.equals(r4)     // Catch:{ NumberFormatException -> 0x00ae }
            if (r10 == 0) goto L_0x0094
            r10 = r6
            goto L_0x0095
        L_0x0080:
            java.lang.String r4 = "equal"
            boolean r10 = r3.equals(r4)     // Catch:{ NumberFormatException -> 0x00ae }
            if (r10 == 0) goto L_0x0094
            r10 = r1
            goto L_0x0095
        L_0x008a:
            java.lang.String r4 = "greater_than"
            boolean r10 = r3.equals(r4)     // Catch:{ NumberFormatException -> 0x00ae }
            if (r10 == 0) goto L_0x0094
            r10 = r7
            goto L_0x0095
        L_0x0094:
            r10 = -1
        L_0x0095:
            if (r10 == 0) goto L_0x00aa
            if (r10 == r8) goto L_0x00a6
            if (r10 == r7) goto L_0x00a2
            if (r10 == r6) goto L_0x009e
            return r1
        L_0x009e:
            if (r2 >= r0) goto L_0x00a1
            r1 = r8
        L_0x00a1:
            return r1
        L_0x00a2:
            if (r2 <= r0) goto L_0x00a5
            r1 = r8
        L_0x00a5:
            return r1
        L_0x00a6:
            if (r2 == r0) goto L_0x00a9
            r1 = r8
        L_0x00a9:
            return r1
        L_0x00aa:
            if (r2 != r0) goto L_0x00ad
            r1 = r8
        L_0x00ad:
            return r1
        L_0x00ae:
            r0 = move-exception
            boolean r10 = com.instabug.survey.utils.q.a((com.instabug.survey.common.models.c) r10, (java.lang.Throwable) r0)
            return r10
        L_0x00b4:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.instabug.survey.utils.m.a(com.instabug.survey.common.models.c):boolean");
    }

    /* JADX WARNING: Removed duplicated region for block: B:28:0x0083  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x0096  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean a(com.instabug.survey.common.models.c r9, int r10) {
        /*
            r8 = this;
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "checkDaysSinceDismissCondition(condition: "
            r0.append(r1)
            r0.append(r9)
            java.lang.String r1 = ", actualSessionCount: "
            r0.append(r1)
            r0.append(r10)
            java.lang.String r1 = ")"
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            r8.b((java.lang.String) r0)
            java.lang.String r0 = r9.c()
            r1 = 0
            if (r0 == 0) goto L_0x00a0
            java.lang.String r0 = r9.b()
            if (r0 != 0) goto L_0x0030
            goto L_0x00a0
        L_0x0030:
            java.lang.String r0 = r9.c()     // Catch:{ NumberFormatException -> 0x009a }
            int r0 = java.lang.Integer.parseInt(r0)     // Catch:{ NumberFormatException -> 0x009a }
            java.lang.String r2 = r9.b()     // Catch:{ NumberFormatException -> 0x009a }
            int r3 = r2.hashCode()     // Catch:{ NumberFormatException -> 0x009a }
            r4 = -1374681402(0xffffffffae1006c6, float:-3.2747825E-11)
            r5 = 3
            r6 = 2
            r7 = 1
            if (r3 == r4) goto L_0x0076
            r4 = 96757556(0x5c46734, float:1.8469662E-35)
            if (r3 == r4) goto L_0x006c
            r4 = 365984903(0x15d07c87, float:8.4207E-26)
            if (r3 == r4) goto L_0x0062
            r4 = 1614662344(0x603dcac8, float:5.4703852E19)
            if (r3 == r4) goto L_0x0058
            goto L_0x0080
        L_0x0058:
            java.lang.String r3 = "not_equal"
            boolean r9 = r2.equals(r3)     // Catch:{ NumberFormatException -> 0x009a }
            if (r9 == 0) goto L_0x0080
            r9 = r7
            goto L_0x0081
        L_0x0062:
            java.lang.String r3 = "less_than"
            boolean r9 = r2.equals(r3)     // Catch:{ NumberFormatException -> 0x009a }
            if (r9 == 0) goto L_0x0080
            r9 = r5
            goto L_0x0081
        L_0x006c:
            java.lang.String r3 = "equal"
            boolean r9 = r2.equals(r3)     // Catch:{ NumberFormatException -> 0x009a }
            if (r9 == 0) goto L_0x0080
            r9 = r1
            goto L_0x0081
        L_0x0076:
            java.lang.String r3 = "greater_than"
            boolean r9 = r2.equals(r3)     // Catch:{ NumberFormatException -> 0x009a }
            if (r9 == 0) goto L_0x0080
            r9 = r6
            goto L_0x0081
        L_0x0080:
            r9 = -1
        L_0x0081:
            if (r9 == 0) goto L_0x0096
            if (r9 == r7) goto L_0x0092
            if (r9 == r6) goto L_0x008e
            if (r9 == r5) goto L_0x008a
            return r1
        L_0x008a:
            if (r10 >= r0) goto L_0x008d
            r1 = r7
        L_0x008d:
            return r1
        L_0x008e:
            if (r10 <= r0) goto L_0x0091
            r1 = r7
        L_0x0091:
            return r1
        L_0x0092:
            if (r10 == r0) goto L_0x0095
            r1 = r7
        L_0x0095:
            return r1
        L_0x0096:
            if (r10 != r0) goto L_0x0099
            r1 = r7
        L_0x0099:
            return r1
        L_0x009a:
            r10 = move-exception
            boolean r9 = com.instabug.survey.utils.q.a((com.instabug.survey.common.models.c) r9, (java.lang.Throwable) r10)
            return r9
        L_0x00a0:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.instabug.survey.utils.m.a(com.instabug.survey.common.models.c, int):boolean");
    }

    /* JADX WARNING: Removed duplicated region for block: B:31:0x008e  */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x00a1  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean a(com.instabug.survey.common.models.c r8, long r9) {
        /*
            r7 = this;
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "checkDaysSinceDismissCondition(condition: "
            r0.append(r1)
            r0.append(r8)
            java.lang.String r1 = ", lastDismissDate: "
            r0.append(r1)
            r0.append(r9)
            java.lang.String r1 = ")"
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            r7.b((java.lang.String) r0)
            java.lang.String r0 = r8.c()
            r1 = 0
            if (r0 == 0) goto L_0x00ab
            java.lang.String r0 = r8.b()
            if (r0 != 0) goto L_0x0030
            goto L_0x00ab
        L_0x0030:
            r2 = 0
            int r0 = (r9 > r2 ? 1 : (r9 == r2 ? 0 : -1))
            r2 = 1
            if (r0 != 0) goto L_0x0038
            return r2
        L_0x0038:
            java.lang.String r0 = r8.c()     // Catch:{ NumberFormatException -> 0x00a5 }
            int r0 = java.lang.Integer.parseInt(r0)     // Catch:{ NumberFormatException -> 0x00a5 }
            int r9 = com.instabug.survey.utils.a.a(r9)     // Catch:{ NumberFormatException -> 0x00a5 }
            java.lang.String r10 = r8.b()     // Catch:{ NumberFormatException -> 0x00a5 }
            int r3 = r10.hashCode()     // Catch:{ NumberFormatException -> 0x00a5 }
            r4 = -1374681402(0xffffffffae1006c6, float:-3.2747825E-11)
            r5 = 3
            r6 = 2
            if (r3 == r4) goto L_0x0081
            r4 = 96757556(0x5c46734, float:1.8469662E-35)
            if (r3 == r4) goto L_0x0077
            r4 = 365984903(0x15d07c87, float:8.4207E-26)
            if (r3 == r4) goto L_0x006d
            r4 = 1614662344(0x603dcac8, float:5.4703852E19)
            if (r3 == r4) goto L_0x0063
            goto L_0x008b
        L_0x0063:
            java.lang.String r3 = "not_equal"
            boolean r8 = r10.equals(r3)     // Catch:{ NumberFormatException -> 0x00a5 }
            if (r8 == 0) goto L_0x008b
            r8 = r2
            goto L_0x008c
        L_0x006d:
            java.lang.String r3 = "less_than"
            boolean r8 = r10.equals(r3)     // Catch:{ NumberFormatException -> 0x00a5 }
            if (r8 == 0) goto L_0x008b
            r8 = r5
            goto L_0x008c
        L_0x0077:
            java.lang.String r3 = "equal"
            boolean r8 = r10.equals(r3)     // Catch:{ NumberFormatException -> 0x00a5 }
            if (r8 == 0) goto L_0x008b
            r8 = r1
            goto L_0x008c
        L_0x0081:
            java.lang.String r3 = "greater_than"
            boolean r8 = r10.equals(r3)     // Catch:{ NumberFormatException -> 0x00a5 }
            if (r8 == 0) goto L_0x008b
            r8 = r6
            goto L_0x008c
        L_0x008b:
            r8 = -1
        L_0x008c:
            if (r8 == 0) goto L_0x00a1
            if (r8 == r2) goto L_0x009d
            if (r8 == r6) goto L_0x0099
            if (r8 == r5) goto L_0x0095
            return r1
        L_0x0095:
            if (r9 >= r0) goto L_0x0098
            r1 = r2
        L_0x0098:
            return r1
        L_0x0099:
            if (r9 <= r0) goto L_0x009c
            r1 = r2
        L_0x009c:
            return r1
        L_0x009d:
            if (r9 == r0) goto L_0x00a0
            r1 = r2
        L_0x00a0:
            return r1
        L_0x00a1:
            if (r9 != r0) goto L_0x00a4
            r1 = r2
        L_0x00a4:
            return r1
        L_0x00a5:
            r9 = move-exception
            boolean r8 = com.instabug.survey.utils.q.a((com.instabug.survey.common.models.c) r8, (java.lang.Throwable) r9)
            return r8
        L_0x00ab:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.instabug.survey.utils.m.a(com.instabug.survey.common.models.c, long):boolean");
    }

    private void b(String str) {
        PrintStream printStream = System.out;
        printStream.println("SurveysValidator: " + str);
    }

    private boolean g(c cVar) {
        return a(cVar);
    }

    /* JADX WARNING: Removed duplicated region for block: B:29:0x0090  */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x00a3  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean h(com.instabug.survey.common.models.c r10) {
        /*
            r9 = this;
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "validateOSApiLevel(condition: "
            r0.append(r1)
            r0.append(r10)
            java.lang.String r1 = ")"
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            r9.b((java.lang.String) r0)
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "Build.VERSION.SDK_INT: "
            r0.append(r1)
            int r1 = android.os.Build.VERSION.SDK_INT
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            r9.b((java.lang.String) r0)
            java.lang.String r0 = r10.c()     // Catch:{ NumberFormatException -> 0x00a7 }
            r2 = 0
            if (r0 == 0) goto L_0x00a6
            java.lang.String r0 = r10.b()     // Catch:{ NumberFormatException -> 0x00a7 }
            if (r0 == 0) goto L_0x00a6
            java.lang.String r0 = r10.c()     // Catch:{ NumberFormatException -> 0x00a7 }
            int r0 = java.lang.Integer.parseInt(r0)     // Catch:{ NumberFormatException -> 0x00a7 }
            java.lang.String r3 = r10.b()     // Catch:{ NumberFormatException -> 0x00a7 }
            int r4 = r3.hashCode()     // Catch:{ NumberFormatException -> 0x00a7 }
            r5 = -1374681402(0xffffffffae1006c6, float:-3.2747825E-11)
            r6 = 3
            r7 = 2
            r8 = 1
            if (r4 == r5) goto L_0x0083
            r5 = 96757556(0x5c46734, float:1.8469662E-35)
            if (r4 == r5) goto L_0x0079
            r5 = 365984903(0x15d07c87, float:8.4207E-26)
            if (r4 == r5) goto L_0x006f
            r5 = 1614662344(0x603dcac8, float:5.4703852E19)
            if (r4 == r5) goto L_0x0065
            goto L_0x008d
        L_0x0065:
            java.lang.String r4 = "not_equal"
            boolean r10 = r3.equals(r4)     // Catch:{ NumberFormatException -> 0x00a7 }
            if (r10 == 0) goto L_0x008d
            r10 = r8
            goto L_0x008e
        L_0x006f:
            java.lang.String r4 = "less_than"
            boolean r10 = r3.equals(r4)     // Catch:{ NumberFormatException -> 0x00a7 }
            if (r10 == 0) goto L_0x008d
            r10 = r6
            goto L_0x008e
        L_0x0079:
            java.lang.String r4 = "equal"
            boolean r10 = r3.equals(r4)     // Catch:{ NumberFormatException -> 0x00a7 }
            if (r10 == 0) goto L_0x008d
            r10 = r2
            goto L_0x008e
        L_0x0083:
            java.lang.String r4 = "greater_than"
            boolean r10 = r3.equals(r4)     // Catch:{ NumberFormatException -> 0x00a7 }
            if (r10 == 0) goto L_0x008d
            r10 = r7
            goto L_0x008e
        L_0x008d:
            r10 = -1
        L_0x008e:
            if (r10 == 0) goto L_0x00a3
            if (r10 == r8) goto L_0x009f
            if (r10 == r7) goto L_0x009b
            if (r10 == r6) goto L_0x0097
            return r2
        L_0x0097:
            if (r1 >= r0) goto L_0x009a
            r2 = r8
        L_0x009a:
            return r2
        L_0x009b:
            if (r1 <= r0) goto L_0x009e
            r2 = r8
        L_0x009e:
            return r2
        L_0x009f:
            if (r1 == r0) goto L_0x00a2
            r2 = r8
        L_0x00a2:
            return r2
        L_0x00a3:
            if (r1 != r0) goto L_0x00a6
            r2 = r8
        L_0x00a6:
            return r2
        L_0x00a7:
            r0 = move-exception
            boolean r10 = com.instabug.survey.utils.q.a((com.instabug.survey.common.models.c) r10, (java.lang.Throwable) r0)
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.instabug.survey.utils.m.h(com.instabug.survey.common.models.c):boolean");
    }

    @Nullable
    public Survey a() {
        String str;
        b("getFirstValidSurvey()");
        List c11 = l.c();
        b("timeTriggeredSurveys: " + c11.size());
        List a11 = a(c11);
        b("timeTriggeredSurveys: " + c11.size());
        Survey survey = a11.size() > 0 ? (Survey) a11.get(0) : null;
        if (survey == null) {
            str = "no valid surveys. Returning null...";
        } else {
            str = "Survey with id:{ " + survey.getId() + "}  is first valid survey";
        }
        b(str);
        return survey;
    }

    @VisibleForTesting
    public boolean a(c cVar, @Nullable a aVar) {
        b("validateOSApiLevel(primitiveTypeCondition: " + cVar + ", countryInfo: " + aVar + ")");
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

    public boolean b(c cVar) {
        if (cVar.c() == null || cVar.b() == null) {
            return false;
        }
        long parseLong = Long.parseLong(cVar.c());
        long a11 = (long) a(b(), TimeUtils.currentTimeMillis());
        b("checkUserEvent(condition: " + cVar + ", daysSinceLastSeen: " + a11 + ")");
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
    public boolean b(c cVar, int i11) {
        return a(cVar, i11);
    }

    @VisibleForTesting
    public boolean b(c cVar, Long l11) {
        return a(cVar, l11.longValue());
    }

    public List c() {
        List<Survey> list;
        try {
            list = a(l.c());
        } catch (ParseException e11) {
            if (e11.getMessage() != null) {
                InstabugSDKLogger.e("IBG-Surveys", "Error:" + e11.getMessage() + "while getting valid surveys", e11);
            }
            list = null;
        }
        LinkedList linkedList = new LinkedList();
        if (list != null) {
            for (Survey survey : list) {
                try {
                    if (d(survey)) {
                        linkedList.add(new com.instabug.survey.Survey(survey.getId(), survey.getTitle()));
                    }
                } catch (ParseException e12) {
                    if (e12.getMessage() != null) {
                        InstabugSDKLogger.e("IBG-Surveys", "Error:" + e12.getMessage() + "while getting valid surveys", e12);
                    }
                }
            }
        }
        return linkedList;
    }

    public void c(String str) {
        b("showSurveysByEventTriggerIfAvailable(triggerEvent: " + str + ")");
        List a11 = com.instabug.survey.cache.m.a(str);
        b("eventTriggeredSurveys: " + a11.size());
        if (a11.size() > 0) {
            List a12 = a(a11);
            b("validSurveys: " + a12.size());
            Survey survey = a12.size() > 0 ? (Survey) a12.get(0) : null;
            if (survey == null) {
                b("no valid surveys for the event" + str + ". Returning null");
                return;
            }
            b("Survey with id:{ " + survey.getId() + "} is first valid survey for the event" + str);
            this.f52592a.b(survey);
        }
    }

    public boolean c(c cVar) {
        return h(cVar);
    }

    @VisibleForTesting
    public boolean c(c cVar, Date date) {
        Date date2;
        b("checkDateCondition(condition: " + cVar + ", actualDate: " + date + ")");
        if (cVar.c() == null || date == null || cVar.b() == null || (date2 = InstabugDateFormatter.getDate(cVar.c())) == null) {
            return false;
        }
        Date standardizedDate = InstabugDateFormatter.getStandardizedDate(date2);
        Date standardizedDate2 = InstabugDateFormatter.getStandardizedDate(date);
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
                return standardizedDate2.after(standardizedDate);
            case 1:
                return standardizedDate2.getDate() == standardizedDate.getDate();
            case 2:
                return standardizedDate2.before(standardizedDate);
            case 3:
                return standardizedDate2.getDate() != standardizedDate.getDate();
            default:
                return false;
        }
    }

    public void d() {
        b("showSurveysByTimeTriggerIfAvailable()");
        List c11 = l.c();
        b("timeTriggeredSurveys: " + c11.size());
        List a11 = a(c11);
        b("validSurveys: " + a11.size());
        Survey survey = a11.size() > 0 ? (Survey) a11.get(0) : null;
        if (survey == null) {
            b("no valid time-triggered surveys. Returning null...");
            return;
        }
        b("Survey with id:{ " + survey.getId() + "}  is first valid survey for time-triggered surveys");
        this.f52592a.a(survey);
    }

    @VisibleForTesting
    public boolean d(Survey survey) {
        b("checkSurveyValidity(survey: " + survey + ")");
        if (survey.getType() == 2 && !survey.isGooglePlayAppRating() && !com.instabug.survey.settings.a.b().k()) {
            return false;
        }
        if (survey.getType() == 1 && !com.instabug.survey.settings.a.b().k()) {
            return false;
        }
        boolean e11 = e(survey.getTargetAudiences(), survey.getConditionsOperator(), survey.getDismissedAt());
        b("primitiveTypesValidity: " + e11);
        boolean a11 = q.a((ArrayList) survey.getCustomAttributes(), survey.getConditionsOperator());
        b("customAttributesValidity: " + a11);
        boolean b11 = q.b(survey.getUserEvents(), survey.getConditionsOperator());
        b("userEventsValidity: " + b11);
        if ((survey.getUserEvents() == null || survey.getUserEvents().size() <= 0) && survey.getCustomAttributes().size() <= 0 && survey.getTargetAudiences().size() <= 0) {
            return true;
        }
        return "or".equals(survey.getConditionsOperator()) ? e11 || a11 || b11 : e11 && a11 && b11;
    }

    @VisibleForTesting
    public boolean e(ArrayList arrayList, String str, long j11) {
        int i11 = 0;
        int size = arrayList == null ? 0 : arrayList.size();
        b("checkPrimitiveTypes(primitiveTypesConditions: " + size + ", conditionsOperator: " + str + ", dismissedAt: " + j11 + ")");
        boolean equals = str.equals("and");
        while (i11 < size) {
            boolean f11 = f((c) arrayList.get(i11), j11);
            equals = i11 == 0 ? f11 : "or".equals(str) ? equals | f11 : equals & f11;
            i11++;
        }
        return equals;
    }

    @VisibleForTesting
    public boolean f(c cVar, long j11) {
        b("checkPrimitiveType(primitiveTypeCondition: " + cVar + ", dismissedAt: " + j11 + ")");
        if (cVar.a() == null) {
            return false;
        }
        String a11 = cVar.a();
        a11.hashCode();
        char c11 = 65535;
        switch (a11.hashCode()) {
            case -1464712027:
                if (a11.equals("days_since_signup")) {
                    c11 = 0;
                    break;
                }
                break;
            case -901870406:
                if (a11.equals("app_version")) {
                    c11 = 1;
                    break;
                }
                break;
            case -12379384:
                if (a11.equals("android_version")) {
                    c11 = 2;
                    break;
                }
                break;
            case 3076014:
                if (a11.equals("date")) {
                    c11 = 3;
                    break;
                }
                break;
            case 96619420:
                if (a11.equals("email")) {
                    c11 = 4;
                    break;
                }
                break;
            case 957831062:
                if (a11.equals("country")) {
                    c11 = 5;
                    break;
                }
                break;
            case 1421955229:
                if (a11.equals("days_since_dismiss")) {
                    c11 = 6;
                    break;
                }
                break;
            case 1694233633:
                if (a11.equals("app_version_v2")) {
                    c11 = 7;
                    break;
                }
                break;
            case 1905908461:
                if (a11.equals("sessions_count")) {
                    c11 = 8;
                    break;
                }
                break;
            case 2013274756:
                if (a11.equals(InstabugDbContract.UserEntity.COLUMN_LAST_SEEN)) {
                    c11 = 9;
                    break;
                }
                break;
        }
        switch (c11) {
            case 0:
                return g(cVar);
            case 1:
                return i(cVar);
            case 2:
                return c(cVar);
            case 3:
                return k(cVar);
            case 4:
                return l(cVar);
            case 5:
                return a(cVar, (a) ObjectMapper.fromJson(com.instabug.survey.settings.c.b(), a.class));
            case 6:
                return b(cVar, Long.valueOf(j11));
            case 7:
                return j(cVar);
            case 8:
                return b(cVar, SettingsManager.getInstance().getSessionsCount());
            case 9:
                return b(cVar);
            default:
                return false;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:34:0x00aa  */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x00bd  */
    @androidx.annotation.VisibleForTesting
    @java.lang.Deprecated
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean i(com.instabug.survey.common.models.c r11) {
        /*
            r10 = this;
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "validateAppVersion(condition: "
            r0.append(r1)
            r0.append(r11)
            java.lang.String r1 = ")"
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            r10.b((java.lang.String) r0)
            java.lang.String r0 = r11.b()
            r1 = 0
            if (r0 != 0) goto L_0x0022
            return r1
        L_0x0022:
            java.lang.String r2 = "equal"
            boolean r3 = r0.equals(r2)
            if (r3 != 0) goto L_0x00c1
            java.lang.String r3 = "not_equal"
            boolean r4 = r0.equals(r3)
            if (r4 != 0) goto L_0x00c1
            java.lang.String r4 = r11.c()
            java.lang.String r4 = r10.a((java.lang.String) r4)
            java.lang.String r5 = r10.f52593b
            java.lang.String r5 = r10.a((java.lang.String) r5)
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            java.lang.String r7 = "appVersionName: "
            r6.append(r7)
            java.lang.String r7 = r10.f52593b
            r6.append(r7)
            java.lang.String r7 = ", currentVersionName: "
            r6.append(r7)
            r6.append(r5)
            java.lang.String r6 = r6.toString()
            r10.b((java.lang.String) r6)
            if (r4 == 0) goto L_0x00c1
            if (r5 == 0) goto L_0x00c1
            int r11 = com.instabug.library.util.StringUtility.compareVersion(r5, r4)     // Catch:{ NumberFormatException -> 0x00c0 }
            int r4 = r0.hashCode()     // Catch:{ NumberFormatException -> 0x00c0 }
            r5 = -1374681402(0xffffffffae1006c6, float:-3.2747825E-11)
            r6 = 3
            r7 = 2
            r8 = -1
            r9 = 1
            if (r4 == r5) goto L_0x009d
            r5 = 96757556(0x5c46734, float:1.8469662E-35)
            if (r4 == r5) goto L_0x0095
            r2 = 365984903(0x15d07c87, float:8.4207E-26)
            if (r4 == r2) goto L_0x008b
            r2 = 1614662344(0x603dcac8, float:5.4703852E19)
            if (r4 == r2) goto L_0x0083
            goto L_0x00a7
        L_0x0083:
            boolean r0 = r0.equals(r3)     // Catch:{ NumberFormatException -> 0x00c0 }
            if (r0 == 0) goto L_0x00a7
            r0 = r9
            goto L_0x00a8
        L_0x008b:
            java.lang.String r2 = "less_than"
            boolean r0 = r0.equals(r2)     // Catch:{ NumberFormatException -> 0x00c0 }
            if (r0 == 0) goto L_0x00a7
            r0 = r6
            goto L_0x00a8
        L_0x0095:
            boolean r0 = r0.equals(r2)     // Catch:{ NumberFormatException -> 0x00c0 }
            if (r0 == 0) goto L_0x00a7
            r0 = r1
            goto L_0x00a8
        L_0x009d:
            java.lang.String r2 = "greater_than"
            boolean r0 = r0.equals(r2)     // Catch:{ NumberFormatException -> 0x00c0 }
            if (r0 == 0) goto L_0x00a7
            r0 = r7
            goto L_0x00a8
        L_0x00a7:
            r0 = r8
        L_0x00a8:
            if (r0 == 0) goto L_0x00bd
            if (r0 == r9) goto L_0x00b9
            if (r0 == r7) goto L_0x00b5
            if (r0 == r6) goto L_0x00b1
            return r1
        L_0x00b1:
            if (r11 != r8) goto L_0x00b4
            r1 = r9
        L_0x00b4:
            return r1
        L_0x00b5:
            if (r11 != r9) goto L_0x00b8
            r1 = r9
        L_0x00b8:
            return r1
        L_0x00b9:
            if (r11 == 0) goto L_0x00bc
            r1 = r9
        L_0x00bc:
            return r1
        L_0x00bd:
            if (r11 != 0) goto L_0x00c0
            r1 = r9
        L_0x00c0:
            return r1
        L_0x00c1:
            java.lang.String r0 = r10.f52593b
            boolean r11 = com.instabug.survey.utils.q.a((com.instabug.survey.common.models.c) r11, (java.lang.String) r0)
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.instabug.survey.utils.m.i(com.instabug.survey.common.models.c):boolean");
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
            r11.b((java.lang.String) r0)
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
            java.lang.String r0 = r11.f52594c
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
        throw new UnsupportedOperationException("Method not decompiled: com.instabug.survey.utils.m.j(com.instabug.survey.common.models.c):boolean");
    }

    @VisibleForTesting
    public boolean k(c cVar) {
        return c(cVar, new Date());
    }

    @VisibleForTesting
    public boolean l(c cVar) {
        return q.a(cVar, InstabugCore.getIdentifiedUserEmail());
    }
}
