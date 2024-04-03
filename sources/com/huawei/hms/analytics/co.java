package com.huawei.hms.analytics;

import android.content.Context;
import android.text.TextUtils;
import com.braze.models.FeatureFlag;
import com.google.android.exoplayer2.upstream.cache.CacheDataSink;
import com.huawei.hms.analytics.bg;
import com.huawei.hms.analytics.core.crypto.AesCipher;
import com.huawei.hms.analytics.core.log.HiLog;
import com.huawei.hms.analytics.core.storage.Event;
import com.talabat.sidemenu.SideMenuRewardViewHolder;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class co implements Runnable {
    private List<Event> klm = new ArrayList();
    private Context lmn;

    public co(Context context) {
        this.lmn = context;
    }

    private static String klm(String str) {
        String decryptCbc = AesCipher.decryptCbc(str, bs.lmn().klm());
        if (!TextUtils.isEmpty(decryptCbc)) {
            return AesCipher.gcmEncrypt(decryptCbc, bs.lmn().klm());
        }
        HiLog.i("HistoricalDataMovement", "decryptCbc content is empty");
        return "";
    }

    private void lmn(String str) {
        String lmn2 = dv.lmn(this.lmn, str);
        long ikl = dv.ikl(this.lmn, lmn2);
        if (ikl != -1) {
            if (ikl > CacheDataSink.DEFAULT_FRAGMENT_SIZE) {
                HiLog.i("HistoricalDataMovement", "sp stat file length > 5M,begin delete it");
                if (dv.ijk(this.lmn, lmn2)) {
                    HiLog.i("HistoricalDataMovement", "sp stat file delete success");
                    return;
                }
                return;
            }
            Map<String, ?> klm2 = dv.klm(this.lmn, str);
            dv.ijk(this.lmn, lmn2);
            if (klm2.size() != 0) {
                for (Map.Entry next : klm2.entrySet()) {
                    String[] split = ((String) next.getKey()).split(SideMenuRewardViewHolder.DEFAULT_LOGGED_IN_USER_POINTS_VALUE);
                    if (split.length == 2) {
                        String str2 = split[0];
                        String str3 = split[1];
                        if (!TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str3)) {
                            try {
                                lmn(str2, next.getValue());
                            } catch (JSONException unused) {
                                HiLog.w("HistoricalDataMovement", "cache data is not json format");
                            }
                        }
                    }
                }
            }
        }
    }

    private void lmn(String str, Object obj) {
        if (obj instanceof String) {
            JSONArray jSONArray = new JSONArray((String) obj);
            int length = jSONArray.length();
            if (length > 5000) {
                HiLog.w("HistoricalDataMovement", "migratingData(): array size is too long");
                return;
            }
            for (int i11 = 0; i11 < length; i11++) {
                JSONObject jSONObject = jSONArray.getJSONObject(i11);
                try {
                    if (System.currentTimeMillis() - Long.parseLong(jSONObject.getString("eventtime")) <= 604800000) {
                        String klm2 = klm(jSONObject.getString(FeatureFlag.PROPERTIES));
                        if (TextUtils.isEmpty(klm2)) {
                            HiLog.i("HistoricalDataMovement", "content is empty");
                        } else {
                            Event event = new Event();
                            event.formJson(jSONObject);
                            event.setServiceTag(str);
                            event.setContent(klm2);
                            this.klm.add(event);
                        }
                    }
                } catch (NumberFormatException unused) {
                }
            }
        }
    }

    public final void run() {
        HiLog.i("HistoricalDataMovement", "handler historical data...");
        lmn("stat_v2_1");
        lmn("cached_v2_1");
        Context context = this.lmn;
        dv.ijk(context, dv.lmn(context, "hyaline_v2_1"));
        if (this.klm.size() > 0) {
            HiLog.i("HistoricalDataMovement", "insert events...");
            try {
                bg.lmn(this.lmn).lmn(this.klm);
            } catch (bg.lmn unused) {
                HiLog.e("HistoricalDataMovement", "DBException");
            }
        }
    }
}
