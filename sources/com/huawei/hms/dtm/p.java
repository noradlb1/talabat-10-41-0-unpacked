package com.huawei.hms.dtm;

import android.content.Context;
import android.os.Bundle;
import java.util.Map;

public class p implements q {

    /* renamed from: a  reason: collision with root package name */
    public C0472d f48668a;

    public void a(Context context, Context context2, Map<Object, Object> map) {
        B.c("HMS-DTM", "DtmHandleNone#initialize with config");
    }

    public void a(C0472d dVar) {
        B.c("HMS-DTM", "DtmHandleNone#registerCallback");
        this.f48668a = dVar;
    }

    public void logAutoEvent(String str, Bundle bundle) {
        B.c("HMS-DTM", "DtmHandleNone#logAutoEvent");
    }

    public void logEvent(String str, Bundle bundle) {
        B.c("HMS-DTM", "DtmHandleNone#logEvent");
        C0472d dVar = this.f48668a;
        if (dVar != null) {
            dVar.onFiltered(str, bundle);
        }
    }

    public void preview(String str) {
        B.c("HMS-DTM", "DtmHandleNone#preview");
    }

    public void setParameter(Map<Object, Object> map) {
        B.c("HMS-DTM", "DtmHandleNone#setParameter");
    }

    public void startVisualTrace(String str) {
        B.c("HMS-DTM", "DtmHandleNone#startVisualTrace");
    }
}
