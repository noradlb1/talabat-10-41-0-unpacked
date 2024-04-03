package com.huawei.hms.dtm;

import android.content.Context;
import android.os.Bundle;
import com.huawei.hms.dtm.core.DynamicTagManager;
import java.util.Map;

public class m implements q {

    /* renamed from: a  reason: collision with root package name */
    public DynamicTagManager f48662a = DynamicTagManager.getInstance();

    public void a(Context context, Context context2, Map<Object, Object> map) {
        this.f48662a.initialize(context, context, map);
    }

    public void a(C0472d dVar) {
        this.f48662a.setDtmFilter(dVar);
    }

    public void logAutoEvent(String str, Bundle bundle) {
        this.f48662a.logAutoEvent(str, bundle);
    }

    public void logEvent(String str, Bundle bundle) {
        this.f48662a.logEvent(str, bundle);
    }

    public void preview(String str) {
        this.f48662a.preview(str);
    }

    public void setParameter(Map<Object, Object> map) {
        this.f48662a.setParameter(map);
    }

    public void startVisualTrace(String str) {
        this.f48662a.startVisualTrace(str);
    }
}
