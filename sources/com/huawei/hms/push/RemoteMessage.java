package com.huawei.hms.push;

import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.huawei.hms.push.utils.DateUtil;
import com.huawei.hms.push.utils.JsonUtil;
import com.huawei.hms.support.api.push.PushException;
import com.huawei.hms.support.log.HMSLog;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.newrelic.agent.android.instrumentation.JSONObjectInstrumentation;
import java.io.Serializable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.text.ParseException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public class RemoteMessage implements Parcelable {
    public static final Parcelable.Creator<RemoteMessage> CREATOR = new a();
    public static final int PRIORITY_HIGH = 1;
    public static final int PRIORITY_NORMAL = 2;
    public static final int PRIORITY_UNKNOWN = 0;

    /* renamed from: c  reason: collision with root package name */
    private static final String[] f49700c;

    /* renamed from: d  reason: collision with root package name */
    private static final int[] f49701d;

    /* renamed from: e  reason: collision with root package name */
    private static final long[] f49702e;

    /* renamed from: f  reason: collision with root package name */
    private static final HashMap<String, Object> f49703f;

    /* renamed from: g  reason: collision with root package name */
    private static final HashMap<String, Object> f49704g;

    /* renamed from: h  reason: collision with root package name */
    private static final HashMap<String, Object> f49705h;

    /* renamed from: i  reason: collision with root package name */
    private static final HashMap<String, Object> f49706i;

    /* renamed from: j  reason: collision with root package name */
    private static final HashMap<String, Object> f49707j;

    /* renamed from: a  reason: collision with root package name */
    private Bundle f49708a;

    /* renamed from: b  reason: collision with root package name */
    private Notification f49709b;

    @Instrumented
    public static class Builder {

        /* renamed from: a  reason: collision with root package name */
        private final Bundle f49710a;

        /* renamed from: b  reason: collision with root package name */
        private final Map<String, String> f49711b = new HashMap();

        public Builder(String str) {
            Bundle bundle = new Bundle();
            this.f49710a = bundle;
            bundle.putString("to", str);
        }

        public Builder addData(String str, String str2) {
            if (str != null) {
                this.f49711b.put(str, str2);
                return this;
            }
            throw new IllegalArgumentException("add data failed, key is null.");
        }

        public RemoteMessage build() {
            Bundle bundle = new Bundle();
            JSONObject jSONObject = new JSONObject();
            try {
                for (Map.Entry next : this.f49711b.entrySet()) {
                    jSONObject.put((String) next.getKey(), next.getValue());
                }
                try {
                    String jSONObjectInstrumentation = JSONObjectInstrumentation.toString(jSONObject);
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put(RemoteMessageConst.COLLAPSE_KEY, (Object) this.f49710a.getString(RemoteMessageConst.COLLAPSE_KEY));
                    jSONObject2.put(RemoteMessageConst.TTL, this.f49710a.getInt(RemoteMessageConst.TTL));
                    jSONObject2.put(RemoteMessageConst.SEND_MODE, this.f49710a.getInt(RemoteMessageConst.SEND_MODE));
                    jSONObject2.put(RemoteMessageConst.RECEIPT_MODE, this.f49710a.getInt(RemoteMessageConst.RECEIPT_MODE));
                    JSONObject jSONObject3 = new JSONObject();
                    if (jSONObject.length() != 0) {
                        jSONObject3.put("data", (Object) jSONObjectInstrumentation);
                    }
                    jSONObject3.put(RemoteMessageConst.MSGID, (Object) this.f49710a.getString(RemoteMessageConst.MSGID));
                    jSONObject2.put(RemoteMessageConst.MessageBody.MSG_CONTENT, (Object) jSONObject3);
                    bundle.putByteArray(RemoteMessageConst.MSGBODY, JSONObjectInstrumentation.toString(jSONObject2).getBytes(k.f49748a));
                    bundle.putString("to", this.f49710a.getString("to"));
                    bundle.putString("message_type", this.f49710a.getString("message_type"));
                    return new RemoteMessage(bundle);
                } catch (JSONException unused) {
                    HMSLog.w("RemoteMessage", "JSONException: parse message body failed.");
                    throw new PushException(PushException.EXCEPTION_SEND_FAILED);
                }
            } catch (JSONException unused2) {
                HMSLog.w("RemoteMessage", "JSONException: parse data to json failed.");
                throw new PushException(PushException.EXCEPTION_SEND_FAILED);
            }
        }

        public Builder clearData() {
            this.f49711b.clear();
            return this;
        }

        public Builder setCollapseKey(String str) {
            this.f49710a.putString(RemoteMessageConst.COLLAPSE_KEY, str);
            return this;
        }

        public Builder setData(Map<String, String> map) {
            this.f49711b.clear();
            for (Map.Entry next : map.entrySet()) {
                this.f49711b.put(next.getKey(), next.getValue());
            }
            return this;
        }

        public Builder setMessageId(String str) {
            this.f49710a.putString(RemoteMessageConst.MSGID, str);
            return this;
        }

        public Builder setMessageType(String str) {
            this.f49710a.putString("message_type", str);
            return this;
        }

        public Builder setReceiptMode(int i11) {
            if (i11 == 1 || i11 == 0) {
                this.f49710a.putInt(RemoteMessageConst.RECEIPT_MODE, i11);
                return this;
            }
            throw new IllegalArgumentException("receipt mode can only be 0 or 1.");
        }

        public Builder setSendMode(int i11) {
            if (i11 == 0 || i11 == 1) {
                this.f49710a.putInt(RemoteMessageConst.SEND_MODE, i11);
                return this;
            }
            throw new IllegalArgumentException("send mode can only be 0 or 1.");
        }

        public Builder setTtl(int i11) {
            if (i11 < 1 || i11 > 1296000) {
                throw new IllegalArgumentException("ttl must be greater than or equal to 1 and less than or equal to 1296000");
            }
            this.f49710a.putInt(RemoteMessageConst.TTL, i11);
            return this;
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface MessagePriority {
    }

    public static class Notification implements Serializable {
        private final long[] A;
        private final String B;

        /* renamed from: a  reason: collision with root package name */
        private final String f49712a;

        /* renamed from: b  reason: collision with root package name */
        private final String f49713b;

        /* renamed from: c  reason: collision with root package name */
        private final String[] f49714c;

        /* renamed from: d  reason: collision with root package name */
        private final String f49715d;

        /* renamed from: e  reason: collision with root package name */
        private final String f49716e;

        /* renamed from: f  reason: collision with root package name */
        private final String[] f49717f;

        /* renamed from: g  reason: collision with root package name */
        private final String f49718g;

        /* renamed from: h  reason: collision with root package name */
        private final String f49719h;

        /* renamed from: i  reason: collision with root package name */
        private final String f49720i;

        /* renamed from: j  reason: collision with root package name */
        private final String f49721j;

        /* renamed from: k  reason: collision with root package name */
        private final String f49722k;

        /* renamed from: l  reason: collision with root package name */
        private final String f49723l;

        /* renamed from: m  reason: collision with root package name */
        private final String f49724m;

        /* renamed from: n  reason: collision with root package name */
        private final Uri f49725n;

        /* renamed from: o  reason: collision with root package name */
        private final int f49726o;

        /* renamed from: p  reason: collision with root package name */
        private final String f49727p;

        /* renamed from: q  reason: collision with root package name */
        private final int f49728q;

        /* renamed from: r  reason: collision with root package name */
        private final int f49729r;

        /* renamed from: s  reason: collision with root package name */
        private final int f49730s;

        /* renamed from: t  reason: collision with root package name */
        private final int[] f49731t;

        /* renamed from: u  reason: collision with root package name */
        private final String f49732u;

        /* renamed from: v  reason: collision with root package name */
        private final int f49733v;

        /* renamed from: w  reason: collision with root package name */
        private final String f49734w;

        /* renamed from: x  reason: collision with root package name */
        private final int f49735x;

        /* renamed from: y  reason: collision with root package name */
        private final String f49736y;

        /* renamed from: z  reason: collision with root package name */
        private final String f49737z;

        public /* synthetic */ Notification(Bundle bundle, a aVar) {
            this(bundle);
        }

        private Integer a(String str) {
            if (str != null) {
                try {
                    return Integer.valueOf(str);
                } catch (NumberFormatException unused) {
                    HMSLog.w("RemoteMessage", "NumberFormatException: get " + str + " failed.");
                }
            }
            return null;
        }

        public Integer getBadgeNumber() {
            return a(this.f49734w);
        }

        public String getBody() {
            return this.f49715d;
        }

        public String[] getBodyLocalizationArgs() {
            String[] strArr = this.f49717f;
            return strArr == null ? new String[0] : (String[]) strArr.clone();
        }

        public String getBodyLocalizationKey() {
            return this.f49716e;
        }

        public String getChannelId() {
            return this.f49724m;
        }

        public String getClickAction() {
            return this.f49722k;
        }

        public String getColor() {
            return this.f49721j;
        }

        public String getIcon() {
            return this.f49718g;
        }

        public Uri getImageUrl() {
            String str = this.f49727p;
            if (str == null) {
                return null;
            }
            return Uri.parse(str);
        }

        public Integer getImportance() {
            return a(this.f49736y);
        }

        public String getIntentUri() {
            return this.f49723l;
        }

        public int[] getLightSettings() {
            int[] iArr = this.f49731t;
            return iArr == null ? new int[0] : (int[]) iArr.clone();
        }

        public Uri getLink() {
            return this.f49725n;
        }

        public int getNotifyId() {
            return this.f49726o;
        }

        public String getSound() {
            return this.f49719h;
        }

        public String getTag() {
            return this.f49720i;
        }

        public String getTicker() {
            return this.f49737z;
        }

        public String getTitle() {
            return this.f49712a;
        }

        public String[] getTitleLocalizationArgs() {
            String[] strArr = this.f49714c;
            return strArr == null ? new String[0] : (String[]) strArr.clone();
        }

        public String getTitleLocalizationKey() {
            return this.f49713b;
        }

        public long[] getVibrateConfig() {
            long[] jArr = this.A;
            return jArr == null ? new long[0] : (long[]) jArr.clone();
        }

        public Integer getVisibility() {
            return a(this.B);
        }

        public Long getWhen() {
            if (!TextUtils.isEmpty(this.f49732u)) {
                try {
                    return Long.valueOf(DateUtil.parseUtcToMillisecond(this.f49732u));
                } catch (ParseException unused) {
                    HMSLog.w("RemoteMessage", "ParseException: parse when failed.");
                } catch (StringIndexOutOfBoundsException unused2) {
                    HMSLog.w("RemoteMessage", "StringIndexOutOfBoundsException: parse when failed.");
                }
            }
            return null;
        }

        public boolean isAutoCancel() {
            return this.f49735x == 1;
        }

        public boolean isDefaultLight() {
            return this.f49728q == 1;
        }

        public boolean isDefaultSound() {
            return this.f49729r == 1;
        }

        public boolean isDefaultVibrate() {
            return this.f49730s == 1;
        }

        public boolean isLocalOnly() {
            return this.f49733v == 1;
        }

        private Notification(Bundle bundle) {
            this.f49712a = bundle.getString(RemoteMessageConst.Notification.NOTIFY_TITLE);
            this.f49715d = bundle.getString("content");
            this.f49713b = bundle.getString(RemoteMessageConst.Notification.TITLE_LOC_KEY);
            this.f49716e = bundle.getString(RemoteMessageConst.Notification.BODY_LOC_KEY);
            this.f49714c = bundle.getStringArray(RemoteMessageConst.Notification.TITLE_LOC_ARGS);
            this.f49717f = bundle.getStringArray(RemoteMessageConst.Notification.BODY_LOC_ARGS);
            this.f49718g = bundle.getString("icon");
            this.f49721j = bundle.getString("color");
            this.f49719h = bundle.getString(RemoteMessageConst.Notification.SOUND);
            this.f49720i = bundle.getString("tag");
            this.f49724m = bundle.getString(RemoteMessageConst.Notification.CHANNEL_ID);
            this.f49722k = bundle.getString(RemoteMessageConst.Notification.CLICK_ACTION);
            this.f49723l = bundle.getString(RemoteMessageConst.Notification.INTENT_URI);
            this.f49726o = bundle.getInt(RemoteMessageConst.Notification.NOTIFY_ID);
            String string = bundle.getString("url");
            this.f49725n = !TextUtils.isEmpty(string) ? Uri.parse(string) : null;
            this.f49727p = bundle.getString(RemoteMessageConst.Notification.NOTIFY_ICON);
            this.f49728q = bundle.getInt(RemoteMessageConst.Notification.DEFAULT_LIGHT_SETTINGS);
            this.f49729r = bundle.getInt(RemoteMessageConst.Notification.DEFAULT_SOUND);
            this.f49730s = bundle.getInt(RemoteMessageConst.Notification.DEFAULT_VIBRATE_TIMINGS);
            this.f49731t = bundle.getIntArray(RemoteMessageConst.Notification.LIGHT_SETTINGS);
            this.f49732u = bundle.getString(RemoteMessageConst.Notification.WHEN);
            this.f49733v = bundle.getInt(RemoteMessageConst.Notification.LOCAL_ONLY);
            this.f49734w = bundle.getString(RemoteMessageConst.Notification.BADGE_SET_NUM, (String) null);
            this.f49735x = bundle.getInt(RemoteMessageConst.Notification.AUTO_CANCEL);
            this.f49736y = bundle.getString("priority", (String) null);
            this.f49737z = bundle.getString(RemoteMessageConst.Notification.TICKER);
            this.A = bundle.getLongArray(RemoteMessageConst.Notification.VIBRATE_TIMINGS);
            this.B = bundle.getString("visibility", (String) null);
        }
    }

    public class a implements Parcelable.Creator<RemoteMessage> {
        /* renamed from: a */
        public RemoteMessage createFromParcel(Parcel parcel) {
            return new RemoteMessage(parcel);
        }

        /* renamed from: a */
        public RemoteMessage[] newArray(int i11) {
            return new RemoteMessage[i11];
        }
    }

    static {
        String[] strArr = new String[0];
        f49700c = strArr;
        int[] iArr = new int[0];
        f49701d = iArr;
        long[] jArr = new long[0];
        f49702e = jArr;
        HashMap<String, Object> hashMap = new HashMap<>(8);
        f49703f = hashMap;
        hashMap.put("from", "");
        hashMap.put(RemoteMessageConst.COLLAPSE_KEY, "");
        hashMap.put(RemoteMessageConst.SEND_TIME, "");
        hashMap.put(RemoteMessageConst.TTL, Integer.valueOf(RemoteMessageConst.DEFAULT_TTL));
        hashMap.put(RemoteMessageConst.URGENCY, 2);
        hashMap.put(RemoteMessageConst.ORI_URGENCY, 2);
        hashMap.put(RemoteMessageConst.SEND_MODE, 0);
        hashMap.put(RemoteMessageConst.RECEIPT_MODE, 0);
        HashMap<String, Object> hashMap2 = new HashMap<>(8);
        f49704g = hashMap2;
        hashMap2.put(RemoteMessageConst.Notification.TITLE_LOC_KEY, "");
        hashMap2.put(RemoteMessageConst.Notification.BODY_LOC_KEY, "");
        hashMap2.put(RemoteMessageConst.Notification.NOTIFY_ICON, "");
        hashMap2.put(RemoteMessageConst.Notification.TITLE_LOC_ARGS, strArr);
        hashMap2.put(RemoteMessageConst.Notification.BODY_LOC_ARGS, strArr);
        hashMap2.put(RemoteMessageConst.Notification.TICKER, "");
        hashMap2.put(RemoteMessageConst.Notification.NOTIFY_TITLE, "");
        hashMap2.put("content", "");
        HashMap<String, Object> hashMap3 = new HashMap<>(8);
        f49705h = hashMap3;
        hashMap3.put("icon", "");
        hashMap3.put("color", "");
        hashMap3.put(RemoteMessageConst.Notification.SOUND, "");
        hashMap3.put(RemoteMessageConst.Notification.DEFAULT_LIGHT_SETTINGS, 1);
        hashMap3.put(RemoteMessageConst.Notification.LIGHT_SETTINGS, iArr);
        hashMap3.put(RemoteMessageConst.Notification.DEFAULT_SOUND, 1);
        hashMap3.put(RemoteMessageConst.Notification.DEFAULT_VIBRATE_TIMINGS, 1);
        hashMap3.put(RemoteMessageConst.Notification.VIBRATE_TIMINGS, jArr);
        HashMap<String, Object> hashMap4 = new HashMap<>(8);
        f49706i = hashMap4;
        hashMap4.put("tag", "");
        hashMap4.put(RemoteMessageConst.Notification.WHEN, "");
        hashMap4.put(RemoteMessageConst.Notification.LOCAL_ONLY, 1);
        hashMap4.put(RemoteMessageConst.Notification.BADGE_SET_NUM, "");
        hashMap4.put("priority", "");
        hashMap4.put(RemoteMessageConst.Notification.AUTO_CANCEL, 1);
        hashMap4.put("visibility", "");
        hashMap4.put(RemoteMessageConst.Notification.CHANNEL_ID, "");
        HashMap<String, Object> hashMap5 = new HashMap<>(3);
        f49707j = hashMap5;
        hashMap5.put(RemoteMessageConst.Notification.CLICK_ACTION, "");
        hashMap5.put(RemoteMessageConst.Notification.INTENT_URI, "");
        hashMap5.put("url", "");
    }

    public RemoteMessage(Bundle bundle) {
        this.f49708a = a(bundle);
    }

    private Bundle a(Bundle bundle) {
        Bundle bundle2 = new Bundle();
        JSONObject b11 = b(bundle);
        JSONObject a11 = a(b11);
        String string = JsonUtil.getString(a11, "data", (String) null);
        bundle2.putString(RemoteMessageConst.ANALYTIC_INFO, JsonUtil.getString(a11, RemoteMessageConst.ANALYTIC_INFO, (String) null));
        bundle2.putString(RemoteMessageConst.DEVICE_TOKEN, bundle.getString(RemoteMessageConst.DEVICE_TOKEN));
        JSONObject d11 = d(a11);
        JSONObject b12 = b(d11);
        JSONObject c11 = c(d11);
        if (bundle.getInt(RemoteMessageConst.INPUT_TYPE) != 1 || !c.a(a11, d11, string)) {
            String string2 = bundle.getString("to");
            String string3 = bundle.getString("message_type");
            String string4 = JsonUtil.getString(a11, RemoteMessageConst.MSGID, (String) null);
            bundle2.putString("to", string2);
            bundle2.putString("data", string);
            bundle2.putString(RemoteMessageConst.MSGID, string4);
            bundle2.putString("message_type", string3);
            JsonUtil.transferJsonObjectToBundle(b11, bundle2, f49703f);
            bundle2.putBundle(RemoteMessageConst.NOTIFICATION, a(b11, a11, d11, b12, c11));
            return bundle2;
        }
        bundle2.putString("data", a.a(bundle.getByteArray(RemoteMessageConst.MSGBODY)));
        return bundle2;
    }

    private static JSONObject b(Bundle bundle) {
        try {
            return new JSONObject(a.a(bundle.getByteArray(RemoteMessageConst.MSGBODY)));
        } catch (JSONException unused) {
            HMSLog.w("RemoteMessage", "JSONException:parse message body failed.");
            return null;
        }
    }

    private static JSONObject c(JSONObject jSONObject) {
        if (jSONObject != null) {
            return jSONObject.optJSONObject(RemoteMessageConst.MessageBody.PARAM);
        }
        return null;
    }

    private static JSONObject d(JSONObject jSONObject) {
        if (jSONObject != null) {
            return jSONObject.optJSONObject(RemoteMessageConst.MessageBody.PS_CONTENT);
        }
        return null;
    }

    public final int describeContents() {
        return 0;
    }

    public String getAnalyticInfo() {
        return this.f49708a.getString(RemoteMessageConst.ANALYTIC_INFO);
    }

    public Map<String, String> getAnalyticInfoMap() {
        HashMap hashMap = new HashMap();
        String string = this.f49708a.getString(RemoteMessageConst.ANALYTIC_INFO);
        if (string != null && !string.trim().isEmpty()) {
            try {
                JSONObject jSONObject = new JSONObject(string);
                Iterator<String> keys = jSONObject.keys();
                while (keys.hasNext()) {
                    String valueOf = String.valueOf(keys.next());
                    hashMap.put(valueOf, String.valueOf(jSONObject.get(valueOf)));
                }
            } catch (JSONException unused) {
                HMSLog.w("RemoteMessage", "JSONException: get analyticInfo from map failed.");
            }
        }
        return hashMap;
    }

    public String getCollapseKey() {
        return this.f49708a.getString(RemoteMessageConst.COLLAPSE_KEY);
    }

    public String getData() {
        return this.f49708a.getString("data");
    }

    public Map<String, String> getDataOfMap() {
        HashMap hashMap = new HashMap();
        String string = this.f49708a.getString("data");
        if (string != null && !string.trim().isEmpty()) {
            try {
                JSONObject jSONObject = new JSONObject(string);
                Iterator<String> keys = jSONObject.keys();
                while (keys.hasNext()) {
                    String valueOf = String.valueOf(keys.next());
                    hashMap.put(valueOf, String.valueOf(jSONObject.get(valueOf)));
                }
            } catch (JSONException unused) {
                HMSLog.w("RemoteMessage", "JSONException: get data from map failed");
            }
        }
        return hashMap;
    }

    public String getFrom() {
        return this.f49708a.getString("from");
    }

    public String getMessageId() {
        return this.f49708a.getString(RemoteMessageConst.MSGID);
    }

    public String getMessageType() {
        return this.f49708a.getString("message_type");
    }

    public Notification getNotification() {
        Bundle bundle = this.f49708a.getBundle(RemoteMessageConst.NOTIFICATION);
        if (this.f49709b == null && bundle != null) {
            this.f49709b = new Notification(bundle, (a) null);
        }
        if (this.f49709b == null) {
            this.f49709b = new Notification(new Bundle(), (a) null);
        }
        return this.f49709b;
    }

    public int getOriginalUrgency() {
        int i11 = this.f49708a.getInt(RemoteMessageConst.ORI_URGENCY);
        if (i11 == 1 || i11 == 2) {
            return i11;
        }
        return 0;
    }

    public int getReceiptMode() {
        return this.f49708a.getInt(RemoteMessageConst.RECEIPT_MODE);
    }

    public int getSendMode() {
        return this.f49708a.getInt(RemoteMessageConst.SEND_MODE);
    }

    public long getSentTime() {
        try {
            String string = this.f49708a.getString(RemoteMessageConst.SEND_TIME);
            if (!TextUtils.isEmpty(string)) {
                return Long.parseLong(string);
            }
            return 0;
        } catch (NumberFormatException unused) {
            HMSLog.w("RemoteMessage", "NumberFormatException: get sendTime error.");
            return 0;
        }
    }

    public String getTo() {
        return this.f49708a.getString("to");
    }

    public String getToken() {
        return this.f49708a.getString(RemoteMessageConst.DEVICE_TOKEN);
    }

    public int getTtl() {
        return this.f49708a.getInt(RemoteMessageConst.TTL);
    }

    public int getUrgency() {
        int i11 = this.f49708a.getInt(RemoteMessageConst.URGENCY);
        if (i11 == 1 || i11 == 2) {
            return i11;
        }
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i11) {
        parcel.writeBundle(this.f49708a);
        parcel.writeSerializable(this.f49709b);
    }

    public RemoteMessage(Parcel parcel) {
        this.f49708a = parcel.readBundle();
        this.f49709b = (Notification) parcel.readSerializable();
    }

    private static JSONObject b(JSONObject jSONObject) {
        if (jSONObject != null) {
            return jSONObject.optJSONObject(RemoteMessageConst.MessageBody.NOTIFY_DETAIL);
        }
        return null;
    }

    private Bundle a(JSONObject jSONObject, JSONObject jSONObject2, JSONObject jSONObject3, JSONObject jSONObject4, JSONObject jSONObject5) {
        Bundle bundle = new Bundle();
        JsonUtil.transferJsonObjectToBundle(jSONObject3, bundle, f49704g);
        JsonUtil.transferJsonObjectToBundle(jSONObject4, bundle, f49705h);
        JsonUtil.transferJsonObjectToBundle(jSONObject, bundle, f49706i);
        JsonUtil.transferJsonObjectToBundle(jSONObject5, bundle, f49707j);
        bundle.putInt(RemoteMessageConst.Notification.NOTIFY_ID, JsonUtil.getInt(jSONObject2, RemoteMessageConst.Notification.NOTIFY_ID, 0));
        return bundle;
    }

    private static JSONObject a(JSONObject jSONObject) {
        if (jSONObject != null) {
            return jSONObject.optJSONObject(RemoteMessageConst.MessageBody.MSG_CONTENT);
        }
        return null;
    }
}
