package com.instabug.library.experiments;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.instabug.library.experiments.di.a;
import com.instabug.library.settings.SettingsManager;
import com.instabug.library.util.InstabugSDKLogger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import org.json.JSONObject;

public class e implements a {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public static final Object f34363a = new Object();

    /* access modifiers changed from: private */
    public List c(List list) {
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            String str = (String) it.next();
            if (!arrayList.contains(str.toLowerCase(Locale.getDefault()))) {
                arrayList.add(str);
            }
        }
        return arrayList;
    }

    /* access modifiers changed from: private */
    public List d(List list) {
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        boolean z11 = false;
        while (it.hasNext()) {
            String str = (String) it.next();
            if (str.trim().length() > 70) {
                z11 = true;
            } else {
                arrayList.add(str.trim());
            }
        }
        if (z11) {
            InstabugSDKLogger.e("Instabug", "Some experiments weren't added. Max allowed experiments characters limit is reached. Please note that you can add experiments with characters count up to 70 characters.");
        }
        return arrayList;
    }

    public void a(@NonNull List list) {
        if (list != null && !list.isEmpty()) {
            a.e().execute(new b(this, list));
        }
    }

    public void b(@NonNull List list) {
        if (list != null && !list.isEmpty()) {
            a.e().execute(new c(this, list));
        }
    }

    public void a() {
        a.e().execute(new d(this));
    }

    /* access modifiers changed from: private */
    public int c() {
        SettingsManager instance = SettingsManager.getInstance();
        if (instance != null) {
            return instance.getExperimentsStoreLimit();
        }
        return 200;
    }

    @Nullable
    public List a(float f11) {
        return a.b().a(f11);
    }

    public void a(@NonNull JSONObject jSONObject) {
        if (jSONObject != null) {
            int optInt = jSONObject.optInt("experiments_limit", 200);
            SettingsManager instance = SettingsManager.getInstance();
            if (instance != null) {
                instance.setExperimentsStoreLimit(optInt);
            }
        }
    }
}
