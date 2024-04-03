package bo.app;

import com.braze.models.BrazeGeofence;
import com.braze.support.BrazeLogger;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(bv = {}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0016\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007¨\u0006\t"}, d2 = {"Lbo/app/l1;", "", "Lorg/json/JSONArray;", "geofenceJson", "", "Lcom/braze/models/BrazeGeofence;", "a", "<init>", "()V", "android-sdk-base_release"}, k = 1, mv = {1, 6, 0})
public final class l1 {

    /* renamed from: a  reason: collision with root package name */
    public static final l1 f38908a = new l1();

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class a extends Lambda implements Function0<String> {

        /* renamed from: b  reason: collision with root package name */
        public static final a f38909b = new a();

        public a() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "Received null or blank geofence Json. Not parsing.";
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class b extends Lambda implements Function0<String> {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ JSONObject f38910b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(JSONObject jSONObject) {
            super(0);
            this.f38910b = jSONObject;
        }

        /* renamed from: a */
        public final String invoke() {
            return Intrinsics.stringPlus("Failed to deserialize geofence Json due to JSONException: ", this.f38910b);
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class c extends Lambda implements Function0<String> {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ JSONObject f38911b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public c(JSONObject jSONObject) {
            super(0);
            this.f38911b = jSONObject;
        }

        /* renamed from: a */
        public final String invoke() {
            return Intrinsics.stringPlus("Failed to deserialize geofence Json:", this.f38911b);
        }
    }

    private l1() {
    }

    @JvmStatic
    public static final List<BrazeGeofence> a(JSONArray jSONArray) {
        Intrinsics.checkNotNullParameter(jSONArray, "geofenceJson");
        ArrayList arrayList = new ArrayList();
        int length = jSONArray.length();
        int i11 = 0;
        while (i11 < length) {
            int i12 = i11 + 1;
            JSONObject optJSONObject = jSONArray.optJSONObject(i11);
            if (optJSONObject == null) {
                try {
                    BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) f38908a, BrazeLogger.Priority.W, (Throwable) null, false, (Function0) a.f38909b, 6, (Object) null);
                } catch (JSONException e11) {
                    BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) f38908a, BrazeLogger.Priority.W, (Throwable) e11, false, (Function0) new b(optJSONObject), 4, (Object) null);
                } catch (Exception e12) {
                    BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) f38908a, BrazeLogger.Priority.E, (Throwable) e12, false, (Function0) new c(optJSONObject), 4, (Object) null);
                }
            } else {
                arrayList.add(new BrazeGeofence(optJSONObject));
            }
            i11 = i12;
        }
        return arrayList;
    }
}
