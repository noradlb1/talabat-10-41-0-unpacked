package com.huawei.hms.feature.dynamic;

import android.os.Bundle;
import com.huawei.hms.common.util.Logger;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public final class d {

    /* renamed from: a  reason: collision with root package name */
    private static final String f48789a = "d";

    /* renamed from: b  reason: collision with root package name */
    private static final d f48790b = new d();

    /* renamed from: c  reason: collision with root package name */
    public Set<String> f48791c;

    private d() {
    }

    public static d a() {
        return f48790b;
    }

    public void a(Bundle bundle) {
        ArrayList<String> stringArrayList = bundle.getStringArrayList("installed_module_name");
        if (stringArrayList == null || stringArrayList.isEmpty()) {
            Logger.w(f48789a, "Get installed module name failed.");
            this.f48791c = new HashSet();
            return;
        }
        String str = f48789a;
        Logger.i(str, "Installed module name:" + stringArrayList);
        this.f48791c = new HashSet(stringArrayList);
    }
}
