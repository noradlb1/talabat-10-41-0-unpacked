package com.instabug.chat.synchronization;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import androidx.annotation.Nullable;
import com.instabug.chat.model.b;
import com.instabug.chat.model.d;
import com.instabug.chat.model.j;
import com.instabug.chat.model.k;
import com.instabug.library.internal.storage.cache.InMemoryCache;
import com.instabug.library.util.InstabugSDKLogger;
import com.newrelic.agent.android.instrumentation.Instrumented;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

@Instrumented
public class a {

    /* renamed from: b  reason: collision with root package name */
    private static a f46174b;

    /* renamed from: a  reason: collision with root package name */
    private List f46175a = new ArrayList();

    @Nullable
    private k a(k kVar, List list) {
        Iterator it = list.iterator();
        while (it.hasNext()) {
            k kVar2 = (k) it.next();
            if (kVar.f().equals(kVar2.f())) {
                return kVar2;
            }
        }
        return null;
    }

    private List a(List list) {
        ArrayList arrayList = new ArrayList(list);
        Iterator it = list.iterator();
        while (it.hasNext()) {
            k kVar = (k) it.next();
            if (g(kVar) || f(kVar) || e(kVar) || kVar.o() || kVar.p()) {
                InstabugSDKLogger.d("IBG-BR", "Message removed from list to be notified");
                arrayList.remove(kVar);
            }
        }
        return arrayList;
    }

    private List a(List list, List list2) {
        ArrayList arrayList = new ArrayList(list);
        Iterator it = list2.iterator();
        while (it.hasNext()) {
            k kVar = (k) it.next();
            if (b(kVar, list)) {
                arrayList.add(kVar);
            }
            if (kVar.h() == j.SENT && a(kVar, list) != null) {
                arrayList.remove(a(kVar, list));
            }
        }
        return arrayList;
    }

    private void a() {
        if (com.instabug.chat.settings.a.c() != null) {
            try {
                new Handler(Looper.getMainLooper()).post(com.instabug.chat.settings.a.c());
            } catch (Exception e11) {
                InstabugSDKLogger.e("IBG-BR", "new message runnable failed to run.", e11);
            }
        }
    }

    private void a(Context context, List list) {
        InstabugSDKLogger.v("IBG-BR", "START Invalidate Cache");
        List d11 = com.instabug.chat.cache.k.d();
        InMemoryCache b11 = com.instabug.chat.cache.k.b();
        if (b11 != null) {
            b11.invalidate();
        }
        InstabugSDKLogger.v("IBG-BR", "finish Invalidate Cache");
        b(context, a(list, d11));
    }

    @SuppressLint({"ERADICATE_PARAMETER_NOT_NULLABLE"})
    private void a(k kVar) {
        d b11 = b(kVar);
        if (b11 == null && kVar.d() != null) {
            InstabugSDKLogger.v("IBG-BR", "Chat with id " + kVar.d() + " doesn't exist, creating new one");
            b11 = new d(kVar.d());
            b11.a(b.SENT);
        }
        if (b11 != null) {
            b11.f().add(kVar);
            InstabugSDKLogger.v("IBG-BR", "Message added to cached chat: " + b11);
        }
        InMemoryCache b12 = com.instabug.chat.cache.k.b();
        if (b12 != null && b11 != null) {
            b12.put(b11.getId(), b11);
        }
    }

    @Nullable
    private d b(k kVar) {
        d dVar;
        if (kVar.d() == null) {
            return null;
        }
        InMemoryCache b11 = com.instabug.chat.cache.k.b();
        if (b11 != null && (dVar = (d) b11.get(kVar.d())) != null) {
            return dVar;
        }
        InstabugSDKLogger.e("IBG-BR", "No local chats match messages's chat");
        return null;
    }

    public static a b() {
        if (f46174b == null) {
            f46174b = new a();
        }
        return f46174b;
    }

    private void b(Context context, List list) {
        InstabugSDKLogger.v("IBG-BR", "updating chats cache new messages count: " + list.size());
        Iterator it = list.iterator();
        while (it.hasNext()) {
            k kVar = (k) it.next();
            if (h(kVar)) {
                a(kVar);
            } else if (f(kVar)) {
                InstabugSDKLogger.d("IBG-BR", "Message with id:" + kVar.f() + " is ready to be synced");
                try {
                    com.instabug.chat.cache.k.a(context, kVar);
                } catch (IOException e11) {
                    InstabugSDKLogger.e("IBG-BR", "Failed to update local message with synced message, " + e11.getMessage(), e11);
                }
            }
        }
    }

    private void b(List list) {
        if (com.instabug.chat.settings.a.j()) {
            int size = this.f46175a.size() - 1;
            while (size >= 0) {
                b bVar = (b) this.f46175a.get(size);
                InstabugSDKLogger.d("IBG-BR", "Notifying listener " + bVar);
                if (list != null && list.size() > 0) {
                    InstabugSDKLogger.d("IBG-BR", "Notifying listener with " + list.size() + " message(s)");
                    list = bVar.onNewMessagesReceived(list);
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("Notified listener remained ");
                    sb2.append(list != null ? Integer.valueOf(list.size()) : null);
                    sb2.append(" message(s) to be sent to next listener");
                    InstabugSDKLogger.d("IBG-BR", sb2.toString());
                    size--;
                } else {
                    return;
                }
            }
            return;
        }
        InstabugSDKLogger.v("IBG-BR", "Chat notification disabled");
    }

    private boolean b(k kVar, List list) {
        Iterator it = list.iterator();
        while (it.hasNext()) {
            k kVar2 = (k) it.next();
            if (kVar.d() != null && kVar.d().equals(kVar2.d())) {
                return true;
            }
        }
        return false;
    }

    @Nullable
    private List c(k kVar) {
        d b11 = b(kVar);
        if (b11 == null) {
            return null;
        }
        return b11.f();
    }

    @Nullable
    private k d(k kVar) {
        List<k> c11 = c(kVar);
        if (c11 == null) {
            return null;
        }
        for (k kVar2 : c11) {
            if (kVar2.f().equals(kVar.f())) {
                return kVar2;
            }
        }
        return null;
    }

    private boolean e(k kVar) {
        k d11 = d(kVar);
        return d11 != null && d11.f().equals(kVar.f()) && d11.h().equals(j.SENT) && d11.b().size() != kVar.b().size();
    }

    private boolean f(k kVar) {
        k d11 = d(kVar);
        return d11 != null && d11.f().equals(kVar.f()) && d11.h().equals(j.READY_TO_BE_SYNCED) && d11.b().size() == kVar.b().size();
    }

    private boolean g(k kVar) {
        k d11 = d(kVar);
        return d11 != null && d11.f().equals(kVar.f()) && d11.h().equals(j.SYNCED) && d11.b().size() == kVar.b().size();
    }

    private boolean h(k kVar) {
        return d(kVar) == null;
    }

    /* JADX WARNING: Removed duplicated region for block: B:30:0x00e5 A[Catch:{ JSONException -> 0x0179 }] */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x010b A[Catch:{ JSONException -> 0x0179 }] */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x0111 A[Catch:{ JSONException -> 0x0179 }] */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x011d A[Catch:{ JSONException -> 0x0179 }, LOOP:1: B:49:0x011b->B:50:0x011d, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x0154 A[Catch:{ JSONException -> 0x0179 }] */
    @androidx.annotation.VisibleForTesting
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.util.List a(org.json.JSONObject[] r19) {
        /*
            r18 = this;
            r0 = r19
            java.lang.String r1 = "read_at"
            java.lang.String r2 = "messaged_at"
            java.util.ArrayList r3 = new java.util.ArrayList
            r3.<init>()
            r5 = 0
        L_0x000c:
            int r6 = r0.length
            if (r5 >= r6) goto L_0x0184
            r6 = r0[r5]     // Catch:{ JSONException -> 0x0177 }
            java.lang.String r7 = "attachments"
            org.json.JSONArray r7 = r6.getJSONArray(r7)     // Catch:{ JSONException -> 0x0177 }
            java.lang.String r8 = "actions"
            org.json.JSONArray r8 = r6.getJSONArray(r8)     // Catch:{ JSONException -> 0x0177 }
            com.instabug.chat.model.k r9 = new com.instabug.chat.model.k     // Catch:{ JSONException -> 0x0177 }
            java.lang.String r10 = "id"
            java.lang.String r10 = r6.getString(r10)     // Catch:{ JSONException -> 0x0177 }
            java.lang.String r11 = com.instabug.library.user.UserManagerWrapper.getUserName()     // Catch:{ JSONException -> 0x0177 }
            java.lang.String r12 = com.instabug.library.user.UserManagerWrapper.getUserEmail()     // Catch:{ JSONException -> 0x0177 }
            java.lang.String r13 = com.instabug.library.core.InstabugCore.getPushNotificationToken()     // Catch:{ JSONException -> 0x0177 }
            r9.<init>(r10, r11, r12, r13)     // Catch:{ JSONException -> 0x0177 }
            java.lang.String r10 = "chat_number"
            java.lang.String r10 = r6.getString(r10)     // Catch:{ JSONException -> 0x0177 }
            com.instabug.chat.model.k r9 = r9.b((java.lang.String) r10)     // Catch:{ JSONException -> 0x0177 }
            java.lang.String r10 = "body"
            java.lang.String r10 = r6.getString(r10)     // Catch:{ JSONException -> 0x0177 }
            com.instabug.chat.model.k r9 = r9.a((java.lang.String) r10)     // Catch:{ JSONException -> 0x0177 }
            java.lang.String r10 = "from"
            org.json.JSONObject r10 = r6.getJSONObject(r10)     // Catch:{ JSONException -> 0x0177 }
            java.lang.String r11 = "name"
            java.lang.String r10 = r10.getString(r11)     // Catch:{ JSONException -> 0x0177 }
            com.instabug.chat.model.k r9 = r9.e(r10)     // Catch:{ JSONException -> 0x0177 }
            java.lang.String r10 = "avatar"
            java.lang.String r10 = r6.getString(r10)     // Catch:{ JSONException -> 0x0177 }
            com.instabug.chat.model.k r9 = r9.d(r10)     // Catch:{ JSONException -> 0x0177 }
            com.instabug.chat.model.j r10 = com.instabug.chat.model.j.SYNCED     // Catch:{ JSONException -> 0x0177 }
            com.instabug.chat.model.k r9 = r9.a((com.instabug.chat.model.j) r10)     // Catch:{ JSONException -> 0x0177 }
            java.lang.String r10 = r6.getString(r2)     // Catch:{ JSONException -> 0x0177 }
            r11 = 1000(0x3e8, double:4.94E-321)
            java.lang.String r13 = "null"
            java.lang.String r14 = ""
            if (r10 == 0) goto L_0x00a6
            java.lang.String r10 = r6.getString(r2)     // Catch:{ JSONException -> 0x0177 }
            boolean r10 = r10.equals(r14)     // Catch:{ JSONException -> 0x0177 }
            if (r10 != 0) goto L_0x00a6
            java.lang.String r10 = r6.getString(r2)     // Catch:{ JSONException -> 0x0177 }
            boolean r10 = r10.equals(r13)     // Catch:{ JSONException -> 0x0177 }
            if (r10 != 0) goto L_0x00a6
            java.lang.String r10 = r6.getString(r2)     // Catch:{ JSONException -> 0x0177 }
            java.util.Date r10 = com.instabug.library.util.InstabugDateFormatter.getDate(r10)     // Catch:{ JSONException -> 0x0177 }
            if (r10 == 0) goto L_0x00a6
            java.lang.String r10 = r6.getString(r2)     // Catch:{ JSONException -> 0x0177 }
            java.util.Date r10 = com.instabug.library.util.InstabugDateFormatter.getDate(r10)     // Catch:{ JSONException -> 0x0177 }
            long r15 = r10.getTime()     // Catch:{ JSONException -> 0x0177 }
            r17 = r5
            long r4 = r15 / r11
            r9.a((long) r4)     // Catch:{ JSONException -> 0x0179 }
            goto L_0x00a8
        L_0x00a6:
            r17 = r5
        L_0x00a8:
            java.lang.String r4 = r6.getString(r1)     // Catch:{ JSONException -> 0x0179 }
            if (r4 == 0) goto L_0x00dc
            java.lang.String r4 = r6.getString(r1)     // Catch:{ JSONException -> 0x0179 }
            boolean r4 = r4.equals(r14)     // Catch:{ JSONException -> 0x0179 }
            if (r4 != 0) goto L_0x00dc
            java.lang.String r4 = r6.getString(r1)     // Catch:{ JSONException -> 0x0179 }
            boolean r4 = r4.equals(r13)     // Catch:{ JSONException -> 0x0179 }
            if (r4 != 0) goto L_0x00dc
            java.lang.String r4 = r6.getString(r1)     // Catch:{ JSONException -> 0x0179 }
            java.util.Date r4 = com.instabug.library.util.InstabugDateFormatter.getDate(r4)     // Catch:{ JSONException -> 0x0179 }
            if (r4 == 0) goto L_0x00dc
            java.lang.String r4 = r6.getString(r1)     // Catch:{ JSONException -> 0x0179 }
            java.util.Date r4 = com.instabug.library.util.InstabugDateFormatter.getDate(r4)     // Catch:{ JSONException -> 0x0179 }
            long r4 = r4.getTime()     // Catch:{ JSONException -> 0x0179 }
            long r4 = r4 / r11
            r9.b((long) r4)     // Catch:{ JSONException -> 0x0179 }
        L_0x00dc:
            java.lang.String r4 = "direction"
            java.lang.String r4 = r6.getString(r4)     // Catch:{ JSONException -> 0x0179 }
            r5 = 1
            if (r4 == 0) goto L_0x0116
            int r6 = r4.hashCode()     // Catch:{ JSONException -> 0x0179 }
            r11 = 57076464(0x366eaf0, float:6.786062E-37)
            if (r6 == r11) goto L_0x00fe
            r11 = 1941740409(0x73bc9b79, float:2.9886022E31)
            if (r6 == r11) goto L_0x00f4
            goto L_0x0108
        L_0x00f4:
            java.lang.String r6 = "inbound"
            boolean r4 = r4.equals(r6)     // Catch:{ JSONException -> 0x0179 }
            if (r4 == 0) goto L_0x0108
            r4 = 0
            goto L_0x0109
        L_0x00fe:
            java.lang.String r6 = "outbound"
            boolean r4 = r4.equals(r6)     // Catch:{ JSONException -> 0x0179 }
            if (r4 == 0) goto L_0x0108
            r4 = r5
            goto L_0x0109
        L_0x0108:
            r4 = -1
        L_0x0109:
            if (r4 == 0) goto L_0x0111
            if (r4 == r5) goto L_0x010e
            goto L_0x0116
        L_0x010e:
            com.instabug.chat.model.i r4 = com.instabug.chat.model.i.OUTBOUND     // Catch:{ JSONException -> 0x0179 }
            goto L_0x0113
        L_0x0111:
            com.instabug.chat.model.i r4 = com.instabug.chat.model.i.INBOUND     // Catch:{ JSONException -> 0x0179 }
        L_0x0113:
            r9.a((com.instabug.chat.model.i) r4)     // Catch:{ JSONException -> 0x0179 }
        L_0x0116:
            int r4 = r7.length()     // Catch:{ JSONException -> 0x0179 }
            int r4 = r4 - r5
        L_0x011b:
            if (r4 < 0) goto L_0x014d
            org.json.JSONObject r6 = r7.getJSONObject(r4)     // Catch:{ JSONException -> 0x0179 }
            java.lang.String r11 = "metadata"
            org.json.JSONObject r11 = r6.getJSONObject(r11)     // Catch:{ JSONException -> 0x0179 }
            com.instabug.chat.model.a r12 = new com.instabug.chat.model.a     // Catch:{ JSONException -> 0x0179 }
            r12.<init>()     // Catch:{ JSONException -> 0x0179 }
            java.lang.String r13 = "url"
            java.lang.String r6 = r6.getString(r13)     // Catch:{ JSONException -> 0x0179 }
            r12.f(r6)     // Catch:{ JSONException -> 0x0179 }
            java.lang.String r6 = "synced"
            r12.d(r6)     // Catch:{ JSONException -> 0x0179 }
            java.lang.String r6 = "file_type"
            java.lang.String r6 = r11.getString(r6)     // Catch:{ JSONException -> 0x0179 }
            r12.e(r6)     // Catch:{ JSONException -> 0x0179 }
            java.util.ArrayList r6 = r9.b()     // Catch:{ JSONException -> 0x0179 }
            r6.add(r12)     // Catch:{ JSONException -> 0x0179 }
            int r4 = r4 + -1
            goto L_0x011b
        L_0x014d:
            int r4 = r8.length()     // Catch:{ JSONException -> 0x0179 }
            int r4 = r4 - r5
        L_0x0152:
            if (r4 < 0) goto L_0x0173
            org.json.JSONObject r5 = r8.getJSONObject(r4)     // Catch:{ JSONException -> 0x0179 }
            com.instabug.chat.model.m r6 = new com.instabug.chat.model.m     // Catch:{ JSONException -> 0x0179 }
            r6.<init>()     // Catch:{ JSONException -> 0x0179 }
            boolean r7 = r5 instanceof org.json.JSONObject     // Catch:{ JSONException -> 0x0179 }
            if (r7 != 0) goto L_0x0166
            java.lang.String r5 = r5.toString()     // Catch:{ JSONException -> 0x0179 }
            goto L_0x016a
        L_0x0166:
            java.lang.String r5 = com.newrelic.agent.android.instrumentation.JSONObjectInstrumentation.toString(r5)     // Catch:{ JSONException -> 0x0179 }
        L_0x016a:
            r6.fromJson(r5)     // Catch:{ JSONException -> 0x0179 }
            r9.a((com.instabug.chat.model.m) r6)     // Catch:{ JSONException -> 0x0179 }
            int r4 = r4 + -1
            goto L_0x0152
        L_0x0173:
            r3.add(r9)     // Catch:{ JSONException -> 0x0179 }
            goto L_0x0180
        L_0x0177:
            r17 = r5
        L_0x0179:
            java.lang.String r4 = "IBG-BR"
            java.lang.String r5 = "Failed to parse chat message"
            com.instabug.library.util.InstabugSDKLogger.e(r4, r5)
        L_0x0180:
            int r5 = r17 + 1
            goto L_0x000c
        L_0x0184:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.instabug.chat.synchronization.a.a(org.json.JSONObject[]):java.util.List");
    }

    public void a(Context context, boolean z11, JSONObject... jSONObjectArr) {
        List a11 = a(jSONObjectArr);
        List a12 = a(a11);
        if (z11) {
            a(context, a11);
        } else {
            b(context, a11);
        }
        if (a12.size() > 0) {
            a();
        }
        if (this.f46175a.size() > 0) {
            b(a12);
            return;
        }
        throw new IllegalStateException("No one is listening for unread messages");
    }

    public void a(b bVar) {
        if (!this.f46175a.contains(bVar)) {
            this.f46175a.add(bVar);
        }
    }

    public void b(b bVar) {
        this.f46175a.remove(bVar);
    }
}
