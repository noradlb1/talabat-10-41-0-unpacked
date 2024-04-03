package com.braze.support;

import android.os.Bundle;
import bo.app.u0;
import com.braze.models.IPutIntoJson;
import com.braze.support.BrazeLogger;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.newrelic.agent.android.instrumentation.JSONArrayInstrumentation;
import com.newrelic.agent.android.instrumentation.JSONObjectInstrumentation;
import com.visa.checkout.Profile;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.sequences.Sequence;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@Instrumented
@Metadata(d1 = {"\u0000h\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0010\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\u001e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0005\n\u0002\u0010(\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u001a\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u001a\u0016\u0010\u0007\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u0005\u001a2\u0010\n\u001a\u0004\u0018\u0001H\u000b\"\u0010\b\u0000\u0010\u000b\u0018\u0001*\b\u0012\u0004\u0012\u0002H\u000b0\f2\u0006\u0010\r\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u0001H\b¢\u0006\u0002\u0010\u000f\u001a8\u0010\n\u001a\u0002H\u000b\"\u0010\b\u0000\u0010\u000b\u0018\u0001*\b\u0012\u0004\u0012\u0002H\u000b0\f2\u0006\u0010\r\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u00012\u0006\u0010\u0010\u001a\u0002H\u000bH\b¢\u0006\u0002\u0010\u0011\u001aC\u0010\n\u001a\u0002H\u000b\"\u0010\b\u0000\u0010\u000b*\n\u0012\u0004\u0012\u0002H\u000b\u0018\u00010\f2\u0006\u0010\r\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u00012\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u0002H\u000b0\u00132\u0006\u0010\u0010\u001a\u0002H\u000b¢\u0006\u0002\u0010\u0014\u001a\u001b\u0010\u0015\u001a\u00020\u0016\"\u0004\b\u0000\u0010\u0017*\b\u0012\u0004\u0012\u0002H\u00170\u0018¢\u0006\u0002\u0010\u0019\u001a\u001c\u0010\u0015\u001a\u00020\u0016\"\u0004\b\u0000\u0010\u0017*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00170\u001b0\u001a\u001a\u0018\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00010\u001d*\u0004\u0018\u00010\u0005\u001a\u0012\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00010\u001f*\u0004\u0018\u00010\u0016\u001a\n\u0010 \u001a\u00020\u0005*\u00020\u0005\u001a\u001d\u0010!\u001a\u0004\u0018\u00010\"*\u00020\u00052\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001H\u0007¢\u0006\u0002\u0010#\u001a\u001b\u0010$\u001a\u0004\u0018\u00010%*\u00020\u00052\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001¢\u0006\u0002\u0010&\u001a\u0016\u0010'\u001a\u0004\u0018\u00010\u0001*\u00020\u00052\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001\u001a\f\u0010(\u001a\u00020\u0001*\u0004\u0018\u00010\u0016\u001a\f\u0010(\u001a\u00020\u0001*\u0004\u0018\u00010\u0005\u001a\u0016\u0010)\u001a\u00020\u0003*\u0004\u0018\u00010\u00052\b\u0010\r\u001a\u0004\u0018\u00010\u0005\u001a\u001d\u0010*\u001a\b\u0012\u0004\u0012\u0002H\u00170+\"\u0006\b\u0000\u0010\u0017\u0018\u0001*\u0004\u0018\u00010\u0016H\n\u001a\u001b\u0010*\u001a\b\u0012\u0004\u0012\u0002H\u00170+\"\u0006\b\u0000\u0010\u0017\u0018\u0001*\u00020\u0005H\n\u001a\f\u0010,\u001a\u00020-*\u0004\u0018\u00010\u0001\u001a\u0015\u0010.\u001a\u00020\u0005*\u00020\u00052\u0006\u0010/\u001a\u00020\u0005H\u0002\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0004¢\u0006\u0002\n\u0000¨\u00060"}, d2 = {"TAG", "", "areJsonObjectsEqual", "", "target", "Lorg/json/JSONObject;", "source", "mergeJsonObjects", "oldJson", "newJson", "optEnum", "TargetEnum", "", "jsonObject", "key", "(Lorg/json/JSONObject;Ljava/lang/String;)Ljava/lang/Enum;", "defaultEnum", "(Lorg/json/JSONObject;Ljava/lang/String;Ljava/lang/Enum;)Ljava/lang/Enum;", "targetEnumClass", "Ljava/lang/Class;", "(Lorg/json/JSONObject;Ljava/lang/String;Ljava/lang/Class;Ljava/lang/Enum;)Ljava/lang/Enum;", "constructJsonArray", "Lorg/json/JSONArray;", "T", "", "([Ljava/lang/Object;)Lorg/json/JSONArray;", "", "Lcom/braze/models/IPutIntoJson;", "convertJSONObjectToMap", "", "convertStringJsonArrayToList", "", "deepcopy", "getColorIntegerOrNull", "", "(Lorg/json/JSONObject;Ljava/lang/String;)Ljava/lang/Integer;", "getDoubleOrNull", "", "(Lorg/json/JSONObject;Ljava/lang/String;)Ljava/lang/Double;", "getOptionalString", "getPrettyPrintedString", "isEqualTo", "iterator", "", "parseJsonObjectIntoBundle", "Landroid/os/Bundle;", "plus", "otherJson", "android-sdk-base_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class JsonUtils {
    private static final String TAG = BrazeLogger.INSTANCE.getBrazeLogTag("JsonUtils");

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class a extends Lambda implements Function0<String> {

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ int f43944g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ JSONArray f43945h;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(int i11, JSONArray jSONArray) {
            super(0);
            this.f43944g = i11;
            this.f43945h = jSONArray;
        }

        /* renamed from: a */
        public final String invoke() {
            return "Failed to get string for item at index: " + this.f43944g + " and array: " + this.f43945h;
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class b extends Lambda implements Function0<String> {

        /* renamed from: b  reason: collision with root package name */
        public static final b f43946b = new b();

        public b() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "Failed to retrieve color integer from JSON";
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class c extends Lambda implements Function0<String> {

        /* renamed from: b  reason: collision with root package name */
        public static final c f43947b = new c();

        public c() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "Caught Throwable while generating pretty printed json. Returning blank string.";
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class d extends Lambda implements Function0<String> {

        /* renamed from: b  reason: collision with root package name */
        public static final d f43948b = new d();

        public d() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "Caught Throwable while generating pretty printed json. Returning blank string.";
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u0010\u0004\u001a\u00020\u0003\"\u0006\b\u0000\u0010\u0000\u0018\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"T", "", "it", "", "a", "(I)Ljava/lang/Boolean;"}, k = 3, mv = {1, 6, 0})
    public static final class e extends Lambda implements Function1<Integer, Boolean> {

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ JSONArray f43949g;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public e(JSONArray jSONArray) {
            super(1);
            this.f43949g = jSONArray;
        }

        public final Boolean a(int i11) {
            Object opt = this.f43949g.opt(i11);
            Intrinsics.reifiedOperationMarker(3, "T");
            return Boolean.valueOf(opt instanceof Object);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            return a(((Number) obj).intValue());
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\u0010\u0003\u001a\u00028\u0000\"\u0006\b\u0000\u0010\u0000\u0018\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"T", "", "it", "a", "(I)Ljava/lang/Object;"}, k = 3, mv = {1, 6, 0})
    public static final class f extends Lambda implements Function1<Integer, T> {

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ JSONArray f43950g;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public f(JSONArray jSONArray) {
            super(1);
            this.f43950g = jSONArray;
        }

        public final T a(int i11) {
            T t11 = this.f43950g.get(i11);
            Intrinsics.reifiedOperationMarker(1, "T");
            return t11;
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            return a(((Number) obj).intValue());
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\u0010\u0005\u001a\u00020\u0004\"\u0006\b\u0000\u0010\u0000\u0018\u00012\u000e\u0010\u0003\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"T", "", "kotlin.jvm.PlatformType", "it", "", "a", "(Ljava/lang/String;)Ljava/lang/Boolean;"}, k = 3, mv = {1, 6, 0})
    public static final class g extends Lambda implements Function1<String, Boolean> {

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ JSONObject f43951g;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public g(JSONObject jSONObject) {
            super(1);
            this.f43951g = jSONObject;
        }

        /* renamed from: a */
        public final Boolean invoke(String str) {
            Object opt = this.f43951g.opt(str);
            Intrinsics.reifiedOperationMarker(3, "T");
            return Boolean.valueOf(opt instanceof Object);
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\u0010\u0004\u001a\u00028\u0000\"\u0006\b\u0000\u0010\u0000\u0018\u00012\u000e\u0010\u0003\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"T", "", "kotlin.jvm.PlatformType", "it", "a", "(Ljava/lang/String;)Ljava/lang/Object;"}, k = 3, mv = {1, 6, 0})
    public static final class h extends Lambda implements Function1<String, T> {

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ JSONObject f43952g;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public h(JSONObject jSONObject) {
            super(1);
            this.f43952g = jSONObject;
        }

        /* renamed from: a */
        public final T invoke(String str) {
            T t11 = this.f43952g.get(str);
            Intrinsics.reifiedOperationMarker(1, "T");
            return t11;
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class i extends Lambda implements Function0<String> {

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f43953g;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public i(String str) {
            super(0);
            this.f43953g = str;
        }

        /* renamed from: a */
        public final String invoke() {
            return Intrinsics.stringPlus("Caught exception merging JSON for old key ", this.f43953g);
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class j extends Lambda implements Function0<String> {

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f43954g;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public j(String str) {
            super(0);
            this.f43954g = str;
        }

        /* renamed from: a */
        public final String invoke() {
            return Intrinsics.stringPlus("Caught exception merging JSON for new key ", this.f43954g);
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class k extends Lambda implements Function0<String> {

        /* renamed from: b  reason: collision with root package name */
        public static final k f43955b = new k();

        public k() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "Unable parse JSON into a bundle.";
        }
    }

    public static final boolean areJsonObjectsEqual(JSONObject jSONObject, JSONObject jSONObject2) {
        if (jSONObject == null && jSONObject2 == null) {
            return true;
        }
        if (jSONObject == null || jSONObject2 == null || jSONObject.length() != jSONObject2.length()) {
            return false;
        }
        Iterator<String> keys = jSONObject.keys();
        Intrinsics.checkNotNullExpressionValue(keys, "target.keys()");
        while (keys.hasNext()) {
            String next = keys.next();
            if (!jSONObject2.has(next)) {
                return false;
            }
            Object opt = jSONObject.opt(next);
            Object opt2 = jSONObject2.opt(next);
            if (!(opt instanceof JSONObject) || !(opt2 instanceof JSONObject)) {
                if (!(opt == null || opt2 == null || Intrinsics.areEqual(opt, opt2))) {
                    return false;
                }
            } else if (!isEqualTo((JSONObject) opt, (JSONObject) opt2)) {
                return false;
            }
        }
        return true;
    }

    public static final <T> JSONArray constructJsonArray(Collection<? extends IPutIntoJson<T>> collection) {
        Intrinsics.checkNotNullParameter(collection, "<this>");
        JSONArray jSONArray = new JSONArray();
        for (IPutIntoJson forJsonPut : collection) {
            jSONArray.put(forJsonPut.forJsonPut());
        }
        return jSONArray;
    }

    public static final Map<String, String> convertJSONObjectToMap(JSONObject jSONObject) {
        if (jSONObject == null) {
            return MapsKt__MapsKt.emptyMap();
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Iterator<String> keys = jSONObject.keys();
        Intrinsics.checkNotNullExpressionValue(keys, "this.keys()");
        while (keys.hasNext()) {
            String next = keys.next();
            Intrinsics.checkNotNullExpressionValue(next, "key");
            String string = jSONObject.getString(next);
            Intrinsics.checkNotNullExpressionValue(string, "this.getString(key)");
            linkedHashMap.put(next, string);
        }
        return linkedHashMap;
    }

    public static final List<String> convertStringJsonArrayToList(JSONArray jSONArray) {
        ArrayList arrayList = new ArrayList();
        if (jSONArray == null) {
            return arrayList;
        }
        int length = jSONArray.length();
        int i11 = 0;
        while (i11 < length) {
            int i12 = i11 + 1;
            try {
                String string = jSONArray.getString(i11);
                Intrinsics.checkNotNullExpressionValue(string, "this.getString(i)");
                arrayList.add(string);
            } catch (Exception e11) {
                BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, TAG, BrazeLogger.Priority.E, (Throwable) e11, false, (Function0) new a(i11, jSONArray), 8, (Object) null);
            }
            i11 = i12;
        }
        return arrayList;
    }

    public static final JSONObject deepcopy(JSONObject jSONObject) {
        String str;
        Intrinsics.checkNotNullParameter(jSONObject, "<this>");
        if (!(jSONObject instanceof JSONObject)) {
            str = jSONObject.toString();
        } else {
            str = JSONObjectInstrumentation.toString(jSONObject);
        }
        return new JSONObject(str);
    }

    public static final Integer getColorIntegerOrNull(JSONObject jSONObject, String str) {
        Intrinsics.checkNotNullParameter(jSONObject, "<this>");
        if (str == null || !jSONObject.has(str)) {
            return null;
        }
        try {
            return Integer.valueOf(jSONObject.getInt(str));
        } catch (Throwable th2) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, TAG, BrazeLogger.Priority.E, th2, false, (Function0) b.f43946b, 8, (Object) null);
            return null;
        }
    }

    public static final Double getDoubleOrNull(JSONObject jSONObject, String str) {
        Intrinsics.checkNotNullParameter(jSONObject, "<this>");
        if (!jSONObject.has(str) || jSONObject.isNull(str)) {
            return null;
        }
        return Double.valueOf(jSONObject.optDouble(str));
    }

    public static final String getOptionalString(JSONObject jSONObject, String str) {
        Intrinsics.checkNotNullParameter(jSONObject, "<this>");
        if (!jSONObject.has(str) || jSONObject.isNull(str)) {
            return null;
        }
        return jSONObject.optString(str);
    }

    public static final String getPrettyPrintedString(JSONObject jSONObject) {
        String str = "";
        if (jSONObject != null) {
            try {
                str = JSONObjectInstrumentation.toString(jSONObject, 2);
            } catch (Throwable th2) {
                BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, TAG, BrazeLogger.Priority.E, th2, false, (Function0) c.f43947b, 8, (Object) null);
            }
            Intrinsics.checkNotNullExpressionValue(str, "try {\n        this.toStr…ring.\" }\n        \"\"\n    }");
        }
        return str;
    }

    public static final boolean isEqualTo(JSONObject jSONObject, JSONObject jSONObject2) {
        return areJsonObjectsEqual(jSONObject, jSONObject2);
    }

    public static final /* synthetic */ <T> Iterator<T> iterator(JSONArray jSONArray) {
        if (jSONArray == null) {
            return CollectionsKt__CollectionsKt.emptyList().iterator();
        }
        Sequence asSequence = CollectionsKt___CollectionsKt.asSequence(RangesKt___RangesKt.until(0, jSONArray.length()));
        Intrinsics.needClassReification();
        Sequence filter = SequencesKt___SequencesKt.filter(asSequence, new e(jSONArray));
        Intrinsics.needClassReification();
        return SequencesKt___SequencesKt.map(filter, new f(jSONArray)).iterator();
    }

    public static final JSONObject mergeJsonObjects(JSONObject jSONObject, JSONObject jSONObject2) {
        Intrinsics.checkNotNullParameter(jSONObject, "oldJson");
        Intrinsics.checkNotNullParameter(jSONObject2, "newJson");
        JSONObject jSONObject3 = new JSONObject();
        Iterator<String> keys = jSONObject.keys();
        Intrinsics.checkNotNullExpressionValue(keys, "oldJson.keys()");
        while (keys.hasNext()) {
            String next = keys.next();
            try {
                jSONObject3.put(next, jSONObject.get(next));
            } catch (JSONException e11) {
                BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, TAG, BrazeLogger.Priority.E, (Throwable) e11, false, (Function0) new i(next), 8, (Object) null);
            }
        }
        Iterator<String> keys2 = jSONObject2.keys();
        Intrinsics.checkNotNullExpressionValue(keys2, "newJson.keys()");
        while (keys2.hasNext()) {
            String next2 = keys2.next();
            try {
                jSONObject3.put(next2, jSONObject2.get(next2));
            } catch (JSONException e12) {
                BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, TAG, BrazeLogger.Priority.E, (Throwable) e12, false, (Function0) new j(next2), 8, (Object) null);
            }
        }
        return jSONObject3;
    }

    public static final <TargetEnum extends Enum<TargetEnum>> TargetEnum optEnum(JSONObject jSONObject, String str, Class<TargetEnum> cls, TargetEnum targetenum) {
        Intrinsics.checkNotNullParameter(jSONObject, "jsonObject");
        Intrinsics.checkNotNullParameter(str, "key");
        Intrinsics.checkNotNullParameter(cls, "targetEnumClass");
        try {
            String string = jSONObject.getString(str);
            Intrinsics.checkNotNullExpressionValue(string, "jsonObject.getString(key)");
            Locale locale = Locale.US;
            Intrinsics.checkNotNullExpressionValue(locale, Profile.Country.US);
            String upperCase = string.toUpperCase(locale);
            Intrinsics.checkNotNullExpressionValue(upperCase, "this as java.lang.String).toUpperCase(locale)");
            TargetEnum a11 = u0.a(upperCase, cls);
            return a11 == null ? targetenum : a11;
        } catch (Exception unused) {
            return targetenum;
        }
    }

    public static final Bundle parseJsonObjectIntoBundle(String str) {
        boolean z11;
        Bundle bundle = new Bundle();
        if (str == null || StringsKt__StringsJVMKt.isBlank(str)) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (z11) {
            return bundle;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                bundle.putString(next, jSONObject.getString(next));
            }
        } catch (Exception e11) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, TAG, BrazeLogger.Priority.E, (Throwable) e11, false, (Function0) k.f43955b, 8, (Object) null);
        }
        return bundle;
    }

    public static final JSONObject plus(JSONObject jSONObject, JSONObject jSONObject2) {
        Intrinsics.checkNotNullParameter(jSONObject, "<this>");
        Intrinsics.checkNotNullParameter(jSONObject2, "otherJson");
        return mergeJsonObjects(jSONObject, jSONObject2);
    }

    public static final /* synthetic */ <TargetEnum extends Enum<TargetEnum>> TargetEnum optEnum(JSONObject jSONObject, String str, TargetEnum targetenum) {
        Intrinsics.checkNotNullParameter(jSONObject, "jsonObject");
        Intrinsics.checkNotNullParameter(str, "key");
        Intrinsics.checkNotNullParameter(targetenum, "defaultEnum");
        try {
            u0 u0Var = u0.f39450a;
            String string = jSONObject.getString(str);
            Intrinsics.checkNotNullExpressionValue(string, "jsonObject.getString(key)");
            Locale locale = Locale.US;
            Intrinsics.checkNotNullExpressionValue(locale, Profile.Country.US);
            Intrinsics.checkNotNullExpressionValue(string.toUpperCase(locale), "this as java.lang.String).toUpperCase(locale)");
            Intrinsics.reifiedOperationMarker(5, "TargetEnum");
            throw new NoSuchElementException("Array contains no element matching the predicate.");
        } catch (Exception unused) {
            return targetenum;
        }
    }

    public static final <T> JSONArray constructJsonArray(T[] tArr) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        JSONArray jSONArray = new JSONArray();
        int length = tArr.length;
        int i11 = 0;
        while (i11 < length) {
            T t11 = tArr[i11];
            i11++;
            jSONArray.put((Object) t11);
        }
        return jSONArray;
    }

    public static final String getPrettyPrintedString(JSONArray jSONArray) {
        String str = "";
        if (jSONArray != null) {
            try {
                str = JSONArrayInstrumentation.toString(jSONArray, 2);
            } catch (Throwable th2) {
                BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, TAG, BrazeLogger.Priority.E, th2, false, (Function0) d.f43948b, 8, (Object) null);
            }
            Intrinsics.checkNotNullExpressionValue(str, "try {\n        this.toStr…ring.\" }\n        \"\"\n    }");
        }
        return str;
    }

    public static final /* synthetic */ <TargetEnum extends Enum<TargetEnum>> TargetEnum optEnum(JSONObject jSONObject, String str) {
        Intrinsics.checkNotNullParameter(jSONObject, "jsonObject");
        Intrinsics.checkNotNullParameter(str, "key");
        try {
            u0 u0Var = u0.f39450a;
            String string = jSONObject.getString(str);
            Intrinsics.checkNotNullExpressionValue(string, "jsonObject.getString(key)");
            Locale locale = Locale.US;
            Intrinsics.checkNotNullExpressionValue(locale, Profile.Country.US);
            Intrinsics.checkNotNullExpressionValue(string.toUpperCase(locale), "this as java.lang.String).toUpperCase(locale)");
            Intrinsics.reifiedOperationMarker(5, "TargetEnum");
            throw new NoSuchElementException("Array contains no element matching the predicate.");
        } catch (Exception unused) {
            return null;
        }
    }

    public static final /* synthetic */ <T> Iterator<T> iterator(JSONObject jSONObject) {
        Intrinsics.checkNotNullParameter(jSONObject, "<this>");
        Iterator<String> keys = jSONObject.keys();
        Intrinsics.checkNotNullExpressionValue(keys, "this.keys()");
        Sequence asSequence = SequencesKt__SequencesKt.asSequence(keys);
        Intrinsics.needClassReification();
        Sequence filter = SequencesKt___SequencesKt.filter(asSequence, new g(jSONObject));
        Intrinsics.needClassReification();
        return SequencesKt___SequencesKt.map(filter, new h(jSONObject)).iterator();
    }
}
