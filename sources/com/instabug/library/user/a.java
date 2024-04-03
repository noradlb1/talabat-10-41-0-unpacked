package com.instabug.library.user;

import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;
import com.instabug.library.internal.storage.cache.db.userAttribute.UserAttributeCacheManager;
import com.instabug.library.model.l;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class a {

    /* renamed from: a  reason: collision with root package name */
    private static a f51993a;

    private a() {
    }

    public static a a() {
        if (f51993a == null) {
            f51993a = new a();
        }
        return f51993a;
    }

    @VisibleForTesting
    public List b(String str, @NonNull HashMap hashMap) {
        ArrayList arrayList = new ArrayList();
        for (Map.Entry entry : hashMap.entrySet()) {
            arrayList.add(new l.a((String) entry.getKey(), (String) entry.getValue()).a(0).a(false).a(str).a());
        }
        return arrayList;
    }

    @VisibleForTesting
    public void c(@NonNull List list, @NonNull HashMap hashMap) {
        Iterator it = list.iterator();
        while (it.hasNext()) {
            l lVar = (l) it.next();
            hashMap.put(lVar.b(), lVar.e());
        }
    }

    public void a(String str) {
        List<l> retrieveAnonymousUserAttributes = UserAttributeCacheManager.retrieveAnonymousUserAttributes();
        if (!retrieveAnonymousUserAttributes.isEmpty()) {
            a(retrieveAnonymousUserAttributes, str);
            UserAttributeCacheManager.deleteAnonymousUserAttribute();
        }
    }

    private void a(List list, String str) {
        HashMap<String, String> retrieveAll = UserAttributeCacheManager.retrieveAll();
        c(list, retrieveAll);
        UserAttributeCacheManager.insertAll(b(str, retrieveAll));
    }
}
