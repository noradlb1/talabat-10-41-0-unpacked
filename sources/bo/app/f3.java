package bo.app;

import bo.app.j;
import com.braze.enums.inappmessage.InAppMessageFailureType;
import com.braze.enums.inappmessage.MessageType;
import com.braze.models.inappmessage.IInAppMessage;
import com.braze.models.inappmessage.InAppMessageBase;
import com.braze.models.inappmessage.InAppMessageControl;
import com.braze.models.inappmessage.InAppMessageFull;
import com.braze.models.inappmessage.InAppMessageHtml;
import com.braze.models.inappmessage.InAppMessageHtmlFull;
import com.braze.models.inappmessage.InAppMessageModal;
import com.braze.models.inappmessage.InAppMessageSlideup;
import com.braze.support.BrazeLogger;
import com.braze.support.JsonUtils;
import com.visa.checkout.Profile;
import java.util.Locale;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.json.JSONArray;
import org.json.JSONObject;

@Metadata(bv = {}, d1 = {"\u0000.\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\u001a\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002\u001a\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002\u001a\u0010\u0010\u0005\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0007\u001a\u00020\u0006\u001a\u000e\u0010\n\u001a\u00020\t2\u0006\u0010\u0007\u001a\u00020\u0006\u001a\u0018\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0002\u001a\u0010\u0010\r\u001a\u00020\f2\u0006\u0010\u0007\u001a\u00020\u0006H\u0007¨\u0006\u000e"}, d2 = {"", "inAppMessageJsonString", "Lbo/app/b2;", "brazeManager", "Lcom/braze/models/inappmessage/IInAppMessage;", "a", "Lorg/json/JSONObject;", "inAppMessageJson", "Lbo/app/h3;", "Lorg/json/JSONArray;", "b", "", "", "c", "android-sdk-base_release"}, k = 2, mv = {1, 6, 0})
public final class f3 {

    /* renamed from: a  reason: collision with root package name */
    private static final String f38518a = BrazeLogger.INSTANCE.getBrazeLogTag("InAppMessageModelUtils");

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f38519a;

        static {
            int[] iArr = new int[MessageType.values().length];
            iArr[MessageType.FULL.ordinal()] = 1;
            iArr[MessageType.MODAL.ordinal()] = 2;
            iArr[MessageType.SLIDEUP.ordinal()] = 3;
            iArr[MessageType.HTML_FULL.ordinal()] = 4;
            iArr[MessageType.HTML.ordinal()] = 5;
            f38519a = iArr;
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class b extends Lambda implements Function0<String> {

        /* renamed from: b  reason: collision with root package name */
        public static final b f38520b = new b();

        public b() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "Deserializing control in-app message.";
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class c extends Lambda implements Function0<String> {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ JSONObject f38521b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public c(JSONObject jSONObject) {
            super(0);
            this.f38521b = jSONObject;
        }

        /* renamed from: a */
        public final String invoke() {
            return Intrinsics.stringPlus("In-app message type was unknown for in-app message: ", JsonUtils.getPrettyPrintedString(this.f38521b));
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class d extends Lambda implements Function0<String> {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ JSONObject f38522b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public d(JSONObject jSONObject) {
            super(0);
            this.f38522b = jSONObject;
        }

        /* renamed from: a */
        public final String invoke() {
            return Intrinsics.stringPlus("Unknown in-app message type. Returning null: ", JsonUtils.getPrettyPrintedString(this.f38522b));
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class e extends Lambda implements Function0<String> {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ JSONObject f38523b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public e(JSONObject jSONObject) {
            super(0);
            this.f38523b = jSONObject;
        }

        /* renamed from: a */
        public final String invoke() {
            return "Failed to deserialize the in-app message: " + JsonUtils.getPrettyPrintedString(this.f38523b) + ". Returning null.";
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class f extends Lambda implements Function0<String> {

        /* renamed from: b  reason: collision with root package name */
        public static final f f38524b = new f();

        public f() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "In-app message string was blank.";
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class g extends Lambda implements Function0<String> {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ String f38525b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public g(String str) {
            super(0);
            this.f38525b = str;
        }

        /* renamed from: a */
        public final String invoke() {
            return Intrinsics.stringPlus("Failed to deserialize the in-app message string: ", this.f38525b);
        }
    }

    public static final IInAppMessage a(String str, b2 b2Var) {
        Intrinsics.checkNotNullParameter(str, "inAppMessageJsonString");
        Intrinsics.checkNotNullParameter(b2Var, "brazeManager");
        if (StringsKt__StringsJVMKt.isBlank(str)) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, f38518a, BrazeLogger.Priority.I, (Throwable) null, false, (Function0) f.f38524b, 12, (Object) null);
            return null;
        }
        try {
            return a(new JSONObject(str), b2Var);
        } catch (Exception e11) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, f38518a, BrazeLogger.Priority.E, (Throwable) e11, false, (Function0) new g(str), 8, (Object) null);
            return null;
        }
    }

    public static final JSONArray b(JSONObject jSONObject) {
        JSONArray jSONArray;
        JSONObject optJSONObject;
        Intrinsics.checkNotNullParameter(jSONObject, "inAppMessageJson");
        JSONObject optJSONObject2 = jSONObject.optJSONObject("themes");
        if (optJSONObject2 == null || (optJSONObject = optJSONObject2.optJSONObject("dark")) == null) {
            jSONArray = null;
        } else {
            jSONArray = optJSONObject.optJSONArray("btns");
        }
        return jSONArray == null ? new JSONArray() : jSONArray;
    }

    public static final boolean c(JSONObject jSONObject) {
        Intrinsics.checkNotNullParameter(jSONObject, "inAppMessageJson");
        return jSONObject.optBoolean(InAppMessageBase.IS_CONTROL, false);
    }

    private static final void b(JSONObject jSONObject, b2 b2Var) {
        String optString = jSONObject.optString(InAppMessageBase.TRIGGER_ID);
        if (!(optString == null || optString.length() == 0)) {
            j.a aVar = j.f38653h;
            Intrinsics.checkNotNullExpressionValue(optString, "triggerId");
            x1 a11 = aVar.a(optString, InAppMessageFailureType.UNKNOWN_MESSAGE_TYPE);
            if (a11 != null) {
                b2Var.a(a11);
            }
        }
    }

    public static final IInAppMessage a(JSONObject jSONObject, b2 b2Var) {
        MessageType messageType;
        IInAppMessage iInAppMessage;
        Intrinsics.checkNotNullParameter(jSONObject, "inAppMessageJson");
        Intrinsics.checkNotNullParameter(b2Var, "brazeManager");
        try {
            if (c(jSONObject)) {
                BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, f38518a, BrazeLogger.Priority.D, (Throwable) null, false, (Function0) b.f38520b, 12, (Object) null);
                return new InAppMessageControl(jSONObject, b2Var);
            }
            try {
                u0 u0Var = u0.f39450a;
                String string = jSONObject.getString("type");
                Intrinsics.checkNotNullExpressionValue(string, "jsonObject.getString(key)");
                Locale locale = Locale.US;
                Intrinsics.checkNotNullExpressionValue(locale, Profile.Country.US);
                String upperCase = string.toUpperCase(locale);
                Intrinsics.checkNotNullExpressionValue(upperCase, "this as java.lang.String).toUpperCase(locale)");
                MessageType[] values = MessageType.values();
                int length = values.length;
                int i11 = 0;
                while (i11 < length) {
                    messageType = values[i11];
                    i11++;
                    if (Intrinsics.areEqual((Object) messageType.name(), (Object) upperCase)) {
                        if (messageType == null) {
                            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, f38518a, BrazeLogger.Priority.I, (Throwable) null, false, (Function0) new c(jSONObject), 12, (Object) null);
                            b(jSONObject, b2Var);
                            return null;
                        }
                        int i12 = a.f38519a[messageType.ordinal()];
                        if (i12 == 1) {
                            iInAppMessage = new InAppMessageFull(jSONObject, b2Var);
                        } else if (i12 == 2) {
                            iInAppMessage = new InAppMessageModal(jSONObject, b2Var);
                        } else if (i12 == 3) {
                            iInAppMessage = new InAppMessageSlideup(jSONObject, b2Var);
                        } else if (i12 == 4) {
                            iInAppMessage = new InAppMessageHtmlFull(jSONObject, b2Var);
                        } else if (i12 != 5) {
                            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, f38518a, BrazeLogger.Priority.W, (Throwable) null, false, (Function0) new d(jSONObject), 12, (Object) null);
                            b(jSONObject, b2Var);
                            return null;
                        } else {
                            iInAppMessage = new InAppMessageHtml(jSONObject, b2Var);
                        }
                        return iInAppMessage;
                    }
                }
                throw new NoSuchElementException("Array contains no element matching the predicate.");
            } catch (Exception unused) {
                messageType = null;
            }
        } catch (Exception e11) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, f38518a, BrazeLogger.Priority.E, (Throwable) e11, false, (Function0) new e(jSONObject), 8, (Object) null);
            return null;
        }
    }

    public static final h3 a(JSONObject jSONObject) {
        Intrinsics.checkNotNullParameter(jSONObject, "inAppMessageJson");
        JSONObject optJSONObject = jSONObject.optJSONObject("themes");
        JSONObject optJSONObject2 = optJSONObject == null ? null : optJSONObject.optJSONObject("dark");
        if (optJSONObject2 == null) {
            return null;
        }
        return new h3(optJSONObject2);
    }
}
