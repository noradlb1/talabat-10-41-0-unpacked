package com.instabug.library.model;

import android.annotation.SuppressLint;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.braze.ui.actions.brazeactions.steps.StepData;
import com.deliveryhero.perseus.data.remote.api.client.PerseusRetrofitBuilder;
import com.google.android.exoplayer2.util.MimeTypes;
import com.instabug.library.internal.storage.cache.Cacheable;
import com.instabug.library.util.InstabugSDKLogger;
import com.instabug.library.util.StringUtility;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.newrelic.agent.android.instrumentation.JSONObjectInstrumentation;
import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@Instrumented
public class o implements Cacheable, Serializable {

    /* renamed from: a  reason: collision with root package name */
    private long f51564a;
    @Nullable

    /* renamed from: b  reason: collision with root package name */
    private String f51565b;
    @Nullable

    /* renamed from: c  reason: collision with root package name */
    private n f51566c;
    @Nullable

    /* renamed from: d  reason: collision with root package name */
    private m f51567d;

    public static ArrayList a(JSONArray jSONArray) throws JSONException {
        ArrayList arrayList = new ArrayList();
        if (jSONArray != null && jSONArray.length() > 0) {
            for (int i11 = 0; i11 < jSONArray.length(); i11++) {
                o oVar = new o();
                JSONObject jSONObject = jSONArray.getJSONObject(i11);
                oVar.fromJson(!(jSONObject instanceof JSONObject) ? jSONObject.toString() : JSONObjectInstrumentation.toString(jSONObject));
                arrayList.add(oVar);
            }
        }
        return arrayList;
    }

    @Nullable
    public String b() {
        return this.f51565b;
    }

    public long c() {
        return this.f51564a;
    }

    @Nullable
    public n d() {
        return this.f51566c;
    }

    public void fromJson(String str) throws JSONException {
        JSONObject jSONObject = new JSONObject(str);
        if (jSONObject.has("timestamp")) {
            if (StringUtility.isNumeric(jSONObject.getString("timestamp"))) {
                a(jSONObject.getLong("timestamp"));
            } else {
                try {
                    Date parse = new SimpleDateFormat(PerseusRetrofitBuilder.DATE_FORMAT_DATE_TIME, Locale.US).parse(jSONObject.getString("timestamp"));
                    if (parse != null) {
                        a(parse.getTime());
                    }
                } catch (ParseException e11) {
                    InstabugSDKLogger.e("UserStep", e11.toString());
                }
            }
        }
        if (jSONObject.has("message")) {
            a(jSONObject.getString("message"));
        }
        if (jSONObject.has("type")) {
            String string = jSONObject.getString("type");
            string.hashCode();
            char c11 = 65535;
            switch (string.hashCode()) {
                case -1068318794:
                    if (string.equals("motion")) {
                        c11 = 0;
                        break;
                    }
                    break;
                case -907680051:
                    if (string.equals("scroll")) {
                        c11 = 1;
                        break;
                    }
                    break;
                case -326696768:
                    if (string.equals("long_press")) {
                        c11 = 2;
                        break;
                    }
                    break;
                case 114595:
                    if (string.equals("tap")) {
                        c11 = 3;
                        break;
                    }
                    break;
                case 3619493:
                    if (string.equals("view")) {
                        c11 = 4;
                        break;
                    }
                    break;
                case 106671290:
                    if (string.equals("pinch")) {
                        c11 = 5;
                        break;
                    }
                    break;
                case 109854522:
                    if (string.equals("swipe")) {
                        c11 = 6;
                        break;
                    }
                    break;
                case 779098677:
                    if (string.equals("double_tap")) {
                        c11 = 7;
                        break;
                    }
                    break;
                case 1554253136:
                    if (string.equals(MimeTypes.BASE_TYPE_APPLICATION)) {
                        c11 = 8;
                        break;
                    }
                    break;
            }
            switch (c11) {
                case 0:
                    a(n.MOTION);
                    break;
                case 1:
                    a(n.SCROLL);
                    break;
                case 2:
                    a(n.LONG_PRESS);
                    break;
                case 3:
                    a(n.TAP);
                    break;
                case 4:
                    a(n.VIEW);
                    break;
                case 5:
                    a(n.PINCH);
                    break;
                case 6:
                    a(n.SWIPE);
                    break;
                case 7:
                    a(n.DOUBLE_TAP);
                    break;
                case 8:
                    a(n.APPLICATION);
                    break;
                default:
                    a(n.NOT_AVAILABLE);
                    break;
            }
        }
        if (jSONObject.has(StepData.ARGS)) {
            m mVar = new m();
            mVar.fromJson(jSONObject.getString(StepData.ARGS));
            a(mVar);
        }
    }

    @SuppressLint({"ERADICATE_PARAMETER_NOT_NULLABLE"})
    public String toJson() throws JSONException {
        String str;
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("timestamp", c());
        jSONObject.put("message", (Object) b());
        if (d() == null) {
            str = null;
        } else {
            str = d().toString();
        }
        jSONObject.put("type", (Object) str);
        if (a() != null) {
            jSONObject.put(StepData.ARGS, (Object) a().toJson());
        }
        return JSONObjectInstrumentation.toString(jSONObject);
    }

    @SuppressLint({"ERADICATE_PARAMETER_NOT_NULLABLE"})
    @NonNull
    public String toString() {
        return "UserStep{timeStamp='" + this.f51564a + '\'' + ", message='" + this.f51565b + '\'' + ", type=" + this.f51566c + AbstractJsonLexerKt.END_OBJ;
    }

    public void b(@Nullable String str) {
        if (str == null) {
            a(n.NOT_AVAILABLE);
            return;
        }
        char c11 = 65535;
        switch (str.hashCode()) {
            case -1854350643:
                if (str.equals(StepType.SCROLL)) {
                    c11 = 0;
                    break;
                }
                break;
            case -1647502663:
                if (str.equals(StepType.APPLICATION_CREATED)) {
                    c11 = 1;
                    break;
                }
                break;
            case 82819:
                if (str.equals(StepType.TAP)) {
                    c11 = 2;
                    break;
                }
                break;
            case 76133530:
                if (str.equals(StepType.PINCH)) {
                    c11 = 3;
                    break;
                }
                break;
            case 78862054:
                if (str.equals(StepType.SHAKE)) {
                    c11 = 4;
                    break;
                }
                break;
            case 79316762:
                if (str.equals(StepType.SWIPE)) {
                    c11 = 5;
                    break;
                }
                break;
            case 1074528416:
                if (str.equals(StepType.LONG_PRESS)) {
                    c11 = 6;
                    break;
                }
                break;
            case 1265144341:
                if (str.equals(StepType.DOUBLE_TAP)) {
                    c11 = 7;
                    break;
                }
                break;
        }
        switch (c11) {
            case 0:
                a(n.SCROLL);
                return;
            case 1:
                a(n.APPLICATION);
                return;
            case 2:
                a(n.TAP);
                return;
            case 3:
                a(n.PINCH);
                return;
            case 4:
                a(n.MOTION);
                return;
            case 5:
                a(n.SWIPE);
                return;
            case 6:
                a(n.LONG_PRESS);
                return;
            case 7:
                a(n.DOUBLE_TAP);
                return;
            default:
                a(n.VIEW);
                return;
        }
    }

    public static JSONArray a(@Nullable List list) {
        JSONArray jSONArray = new JSONArray();
        if (list != null && list.size() > 0) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                try {
                    jSONArray.put((Object) new JSONObject(((o) it.next()).toJson()));
                } catch (JSONException e11) {
                    InstabugSDKLogger.v("UserStep", e11.toString());
                }
            }
        }
        return jSONArray;
    }

    public void a(long j11) {
        this.f51564a = j11;
    }

    public void a(@Nullable String str) {
        this.f51565b = str;
    }

    public void a(@Nullable n nVar) {
        this.f51566c = nVar;
    }

    @Nullable
    public m a() {
        return this.f51567d;
    }

    public void a(@Nullable m mVar) {
        this.f51567d = mVar;
    }
}
