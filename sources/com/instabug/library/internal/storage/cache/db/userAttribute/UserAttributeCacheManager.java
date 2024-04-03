package com.instabug.library.internal.storage.cache.db.userAttribute;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.instabug.library.internal.orchestrator.ActionsOrchestrator;
import com.instabug.library.internal.orchestrator.c;
import com.instabug.library.internal.orchestrator.d;
import com.instabug.library.model.l;
import com.instabug.library.user.f;
import com.instabug.library.util.threading.PoolProvider;
import java.util.HashMap;
import java.util.List;

public class UserAttributeCacheManager {
    public static void delete(String str) {
        UserAttributesDbHelper.delete(str, f.k());
    }

    public static void deleteAll(int i11) {
        UserAttributesDbHelper.deleteType(f.k(), i11);
    }

    public static void deleteAnonymousUserAttribute() {
        UserAttributesDbHelper.deleteAnonymousData();
    }

    public static int getType(String str) {
        return UserAttributesDbHelper.getType(str, f.k());
    }

    public static void insert(String str, String str2) {
        String k11 = f.k();
        ActionsOrchestrator.obtainOrchestrator(PoolProvider.getUserActionsExecutor()).addSameThreadAction(new d(k11, f.j())).addSameThreadAction(new c(new l.a(str, str2).a(0).a(!f.p()).a(k11).a())).orchestrate();
    }

    public static void insertAll(List<l> list) {
        UserAttributesDbHelper.insertBulk(list);
    }

    @Nullable
    public static String retrieve(String str) {
        return UserAttributesDbHelper.retrieve(str, f.k());
    }

    @NonNull
    public static HashMap<String, String> retrieveAll() {
        return UserAttributesDbHelper.retrieveAll(f.k());
    }

    public static HashMap<String, String> retrieveAllSDKAttributes() {
        return UserAttributesDbHelper.retrieveAllSDKAttributes(f.k());
    }

    @NonNull
    public static List<l> retrieveAnonymousUserAttributes() {
        return UserAttributesDbHelper.a();
    }

    public static void deleteAll() {
        UserAttributesDbHelper.deleteUserAttributes(f.k());
    }
}
