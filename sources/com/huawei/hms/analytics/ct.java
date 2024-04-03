package com.huawei.hms.analytics;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.hms.analytics.bg;
import com.huawei.hms.analytics.core.log.HiLog;
import com.huawei.hms.analytics.core.storage.Event;
import com.huawei.hms.analytics.framework.config.ICallback;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.newrelic.agent.android.instrumentation.JSONArrayInstrumentation;
import com.newrelic.agent.android.instrumentation.JSONObjectInstrumentation;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@Instrumented
public final class ct implements ICallback {
    private boolean ikl = false;
    public boolean klm = true;
    public boolean lmn = false;

    private static void klm(List<String> list) {
        Context context = av.lmn().lmn.ghi;
        try {
            JSONArray jSONArray = new JSONArray(dv.klm(context, "global_v2", "camp_evt", ""));
            JSONArray jSONArray2 = new JSONArray();
            int length = jSONArray.length();
            if (length != 0) {
                for (int i11 = 0; i11 < length; i11++) {
                    JSONObject jSONObject = jSONArray.getJSONObject(i11);
                    if (!list.contains(jSONObject.getString("f")) && !dl.klm(jSONObject.getString("t"))) {
                        jSONArray2.put((Object) jSONArray.getJSONObject(i11));
                    }
                }
                if (jSONArray2.length() == 0) {
                    dv.lmn(av.lmn().lmn.ghi, "global_v2", "camp_evt");
                } else if (jSONArray2.length() != length) {
                    dv.lmn(context, "global_v2", "camp_evt", JSONArrayInstrumentation.toString(jSONArray2));
                }
            }
        } catch (JSONException unused) {
            dv.lmn(av.lmn().lmn.ghi, "global_v2", "camp_evt");
        }
    }

    private static List<String> lmn(List<Event> list) {
        ArrayList arrayList = new ArrayList();
        for (Event pushEvtFlag : list) {
            String pushEvtFlag2 = pushEvtFlag.getPushEvtFlag();
            if (!TextUtils.isEmpty(pushEvtFlag2)) {
                arrayList.add(pushEvtFlag2);
            }
        }
        return arrayList;
    }

    private void lmn(int i11, int i12, List<Event> list) {
        if (this.lmn) {
            klm(lmn(list));
        }
        if (i11 != 200 && i12 != -2) {
            if (isStopEvent() && list.size() == 1 && isNeedStorage()) {
                JSONObject json = list.get(0).toJson();
                if (json != null) {
                    dv.lmn(av.lmn().lmn.ghi, "stop_v2_1", "stop_event", JSONObjectInstrumentation.toString(json));
                }
            } else if (this.lmn) {
                cde.lmn().lmn(list.get(0).getServiceTag()).klm(list);
            }
        }
    }

    public final boolean isAAIDChanged(String str, boolean z11) {
        if (!"_openness_config_tag".equals(str) || !dh.lmn().klm(av.lmn().lmn.ghi)) {
            return false;
        }
        av.lmn().lmn.f47869p = false;
        HiLog.i("ReportRingback", "aaid is changed,then reset");
        try {
            if (TextUtils.isEmpty(str)) {
                return true;
            }
            bl lmn2 = cde.lmn().lmn(str);
            if (!(lmn2 instanceof ijk)) {
                return true;
            }
            ((ijk) lmn2).klm(z11);
            return true;
        } catch (Exception e11) {
            HiLog.w("ReportRingback", "reset analytics exception: " + e11.getMessage());
            return true;
        }
    }

    public final boolean isNeedStorage() {
        return this.klm;
    }

    public final boolean isStopEvent() {
        return this.ikl;
    }

    public final void onResult(int i11, long j11, int i12, List<Event> list) {
        HiLog.i("ReportRingback", "report callback");
        if (dp.ghi(av.lmn().lmn.ghi)) {
            HiLog.i("ReportRingback", "do not enable APIEvt in debug model");
        } else if (list != null && list.size() != 0) {
            if (i11 == -1) {
                lmn(i11, i12, list);
                return;
            }
            if (i11 == 200) {
                try {
                    bs.lmn();
                    if (bs.ikl() && bg.lmn(av.lmn().lmn.ghi).ikl().size() == 0) {
                        bs.lmn().ijk();
                    }
                } catch (bg.lmn unused) {
                    HiLog.w("ReportRingback", "checkLocalKeyRefresh, DBException, init DB error");
                }
            }
            lmn(i11, i12, list);
            long currentTimeMillis = System.currentTimeMillis() - j11;
            HashMap hashMap = new HashMap();
            for (Event evtId : list) {
                String evtId2 = evtId.getEvtId();
                Integer num = (Integer) hashMap.get(evtId2);
                int i13 = 1;
                if (num != null) {
                    i13 = 1 + num.intValue();
                }
                hashMap.put(evtId2, Integer.valueOf(i13));
            }
            ck.lmn(hashMap, "ITransportHandler#execute()", currentTimeMillis, i11);
        }
    }

    public final void setStopEventReport(boolean z11) {
        this.ikl = z11;
    }
}
