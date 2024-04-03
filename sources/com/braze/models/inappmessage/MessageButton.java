package com.braze.models.inappmessage;

import android.graphics.Color;
import android.net.Uri;
import bo.app.o3;
import com.braze.enums.inappmessage.ClickAction;
import com.braze.models.IPutIntoJson;
import com.braze.support.BrazeLogger;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(bv = {}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u001b\b\u0017\u0018\u0000 :2\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00012\u00020\u0003:\u0001;B\t\b\u0016¢\u0006\u0004\b4\u00105B\u001d\b\u0017\u0012\u0006\u0010\f\u001a\u00020\u0002\u0012\n\b\u0002\u00106\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b4\u00107Bc\b\u0012\u0012\u0006\u0010\f\u001a\u00020\u0002\u0012\b\u00108\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010\u0010\u001a\u00020\u000e\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u001a\u0012\u0006\u0010\u001b\u001a\u00020\u001a\u0012\b\b\u0001\u0010(\u001a\u00020\u000e\u0012\b\b\u0001\u0010,\u001a\u00020\u000e\u0012\u0006\u0010\"\u001a\u00020!\u0012\b\b\u0001\u0010/\u001a\u00020\u000e¢\u0006\u0004\b4\u00109J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\u001c\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\bH\u0007J\n\u0010\u000b\u001a\u0004\u0018\u00010\u0002H\u0016R\u0018\u0010\f\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\f\u0010\rR$\u0010\u0010\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000e8\u0006@BX\u000e¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R$\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u00068\u0006@BX\u000e¢\u0006\f\n\u0004\b\u0007\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R(\u0010\t\u001a\u0004\u0018\u00010\b2\b\u0010\u000f\u001a\u0004\u0018\u00010\b8\u0006@BX\u000e¢\u0006\f\n\u0004\b\t\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R$\u0010\u001b\u001a\u0004\u0018\u00010\u001a8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\"\u0010\"\u001a\u00020!8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R\"\u0010(\u001a\u00020\u000e8G@\u0006X\u000e¢\u0006\u0012\n\u0004\b(\u0010\u0011\u001a\u0004\b)\u0010\u0013\"\u0004\b*\u0010+R\"\u0010,\u001a\u00020\u000e8G@\u0006X\u000e¢\u0006\u0012\n\u0004\b,\u0010\u0011\u001a\u0004\b-\u0010\u0013\"\u0004\b.\u0010+R\"\u0010/\u001a\u00020\u000e8G@\u0006X\u000e¢\u0006\u0012\n\u0004\b/\u0010\u0011\u001a\u0004\b0\u0010\u0013\"\u0004\b1\u0010+R\u0011\u00103\u001a\u00020\u001a8F¢\u0006\u0006\u001a\u0004\b2\u0010\u001e¨\u0006<"}, d2 = {"Lcom/braze/models/inappmessage/MessageButton;", "Lcom/braze/models/IPutIntoJson;", "Lorg/json/JSONObject;", "Lcom/braze/models/inappmessage/IInAppMessageThemeable;", "", "enableDarkTheme", "Lcom/braze/enums/inappmessage/ClickAction;", "clickAction", "Landroid/net/Uri;", "uri", "setClickBehavior", "forJsonPut", "jsonObject", "Lorg/json/JSONObject;", "", "<set-?>", "id", "I", "getId", "()I", "Lcom/braze/enums/inappmessage/ClickAction;", "getClickAction", "()Lcom/braze/enums/inappmessage/ClickAction;", "Landroid/net/Uri;", "getUri", "()Landroid/net/Uri;", "", "text", "Ljava/lang/String;", "getText", "()Ljava/lang/String;", "setText", "(Ljava/lang/String;)V", "", "openUriInWebview", "Z", "getOpenUriInWebview", "()Z", "setOpenUriInWebview", "(Z)V", "backgroundColor", "getBackgroundColor", "setBackgroundColor", "(I)V", "textColor", "getTextColor", "setTextColor", "borderColor", "getBorderColor", "setBorderColor", "getStringId", "stringId", "<init>", "()V", "darkThemeObject", "(Lorg/json/JSONObject;Lorg/json/JSONObject;)V", "darkThemeJsonObject", "(Lorg/json/JSONObject;Lorg/json/JSONObject;ILcom/braze/enums/inappmessage/ClickAction;Ljava/lang/String;Ljava/lang/String;IIZI)V", "Companion", "a", "android-sdk-base_release"}, k = 1, mv = {1, 6, 0})
public class MessageButton implements IPutIntoJson<JSONObject>, IInAppMessageThemeable {
    private static final String BG_COLOR = "bg_color";
    private static final String BORDER_COLOR = "border_color";
    private static final String CLICK_ACTION = "click_action";
    public static final a Companion = new a((DefaultConstructorMarker) null);
    private static final String ID = "id";
    private static final String OPEN_URI_IN_WEBVIEW = "use_webview";
    private static final String TAG = BrazeLogger.getBrazeLogTag((Class<?>) MessageButton.class);
    private static final String TEXT = "text";
    private static final String TEXT_COLOR = "text_color";
    private static final String URI = "uri";
    private int backgroundColor;
    private int borderColor;
    private ClickAction clickAction;
    private o3 darkTheme;

    /* renamed from: id  reason: collision with root package name */
    private int f43802id;
    private JSONObject jsonObject;
    private boolean openUriInWebview;
    private String text;
    private int textColor;
    private Uri uri;

    @Metadata(bv = {}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\r\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\r\u0010\u000eR\u0014\u0010\u0003\u001a\u00020\u00028\u0002XT¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0002XT¢\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00028\u0002XT¢\u0006\u0006\n\u0004\b\u0006\u0010\u0004R\u0014\u0010\u0007\u001a\u00020\u00028\u0002XT¢\u0006\u0006\n\u0004\b\u0007\u0010\u0004R\u0014\u0010\b\u001a\u00020\u00028\u0002XT¢\u0006\u0006\n\u0004\b\b\u0010\u0004R\u0014\u0010\t\u001a\u00020\u00028\u0002X\u0004¢\u0006\u0006\n\u0004\b\t\u0010\u0004R\u0014\u0010\n\u001a\u00020\u00028\u0002XT¢\u0006\u0006\n\u0004\b\n\u0010\u0004R\u0014\u0010\u000b\u001a\u00020\u00028\u0002XT¢\u0006\u0006\n\u0004\b\u000b\u0010\u0004R\u0014\u0010\f\u001a\u00020\u00028\u0002XT¢\u0006\u0006\n\u0004\b\f\u0010\u0004¨\u0006\u000f"}, d2 = {"Lcom/braze/models/inappmessage/MessageButton$a;", "", "", "BG_COLOR", "Ljava/lang/String;", "BORDER_COLOR", "CLICK_ACTION", "ID", "OPEN_URI_IN_WEBVIEW", "TAG", "TEXT", "TEXT_COLOR", "URI", "<init>", "()V", "android-sdk-base_release"}, k = 1, mv = {1, 6, 0})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class b extends Lambda implements Function0<String> {

        /* renamed from: b  reason: collision with root package name */
        public static final b f43803b = new b();

        public b() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "Cannot apply dark theme with a null themes wrapper";
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class c extends Lambda implements Function0<String> {

        /* renamed from: b  reason: collision with root package name */
        public static final c f43804b = new c();

        public c() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "A non-null URI is required in order to set the button ClickAction to URI.";
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class d extends Lambda implements Function0<String> {

        /* renamed from: b  reason: collision with root package name */
        public static final d f43805b = new d();

        public d() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "ClickAction of URI is required in order to set a non-null URI";
        }
    }

    public MessageButton() {
        this.f43802id = -1;
        this.clickAction = ClickAction.NONE;
        int parseColor = Color.parseColor("#1B78CF");
        this.backgroundColor = parseColor;
        this.textColor = -1;
        this.borderColor = parseColor;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public MessageButton(JSONObject jSONObject) {
        this(jSONObject, (JSONObject) null, 2, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(jSONObject, "jsonObject");
    }

    public static /* synthetic */ void setClickBehavior$default(MessageButton messageButton, ClickAction clickAction2, Uri uri2, int i11, Object obj) {
        if (obj == null) {
            if ((i11 & 2) != 0) {
                uri2 = null;
            }
            messageButton.setClickBehavior(clickAction2, uri2);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setClickBehavior");
    }

    public void enableDarkTheme() {
        o3 o3Var = this.darkTheme;
        if (o3Var == null) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, TAG, (BrazeLogger.Priority) null, (Throwable) null, false, (Function0) b.f43803b, 14, (Object) null);
            return;
        }
        if (o3Var.a() != null) {
            setBackgroundColor(o3Var.a().intValue());
        }
        if (o3Var.c() != null) {
            setTextColor(o3Var.c().intValue());
        }
        if (o3Var.b() != null) {
            setBorderColor(o3Var.b().intValue());
        }
    }

    public final int getBackgroundColor() {
        return this.backgroundColor;
    }

    public final int getBorderColor() {
        return this.borderColor;
    }

    public final ClickAction getClickAction() {
        return this.clickAction;
    }

    public final int getId() {
        return this.f43802id;
    }

    public final boolean getOpenUriInWebview() {
        return this.openUriInWebview;
    }

    public final String getStringId() {
        return String.valueOf(this.f43802id);
    }

    public final String getText() {
        return this.text;
    }

    public final int getTextColor() {
        return this.textColor;
    }

    public final Uri getUri() {
        return this.uri;
    }

    public final void setBackgroundColor(int i11) {
        this.backgroundColor = i11;
    }

    public final void setBorderColor(int i11) {
        this.borderColor = i11;
    }

    public final void setClickBehavior(ClickAction clickAction2) {
        Intrinsics.checkNotNullParameter(clickAction2, "clickAction");
        setClickBehavior$default(this, clickAction2, (Uri) null, 2, (Object) null);
    }

    public final void setClickBehavior(ClickAction clickAction2, Uri uri2) {
        Intrinsics.checkNotNullParameter(clickAction2, "clickAction");
        if (uri2 == null && clickAction2 == ClickAction.URI) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, TAG, BrazeLogger.Priority.W, (Throwable) null, false, (Function0) c.f43804b, 12, (Object) null);
        } else if (uri2 == null || clickAction2 == ClickAction.URI) {
            this.clickAction = clickAction2;
            this.uri = uri2;
        } else {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, TAG, BrazeLogger.Priority.W, (Throwable) null, false, (Function0) d.f43805b, 12, (Object) null);
        }
    }

    public final void setOpenUriInWebview(boolean z11) {
        this.openUriInWebview = z11;
    }

    public final void setText(String str) {
        this.text = str;
    }

    public final void setTextColor(int i11) {
        this.textColor = i11;
    }

    public JSONObject forJsonPut() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("id", this.f43802id);
            jSONObject.put("click_action", (Object) this.clickAction.toString());
            Uri uri2 = this.uri;
            if (uri2 != null) {
                jSONObject.put("uri", (Object) String.valueOf(uri2));
            }
            jSONObject.putOpt("text", this.text);
            jSONObject.put("bg_color", this.backgroundColor);
            jSONObject.put("text_color", this.textColor);
            jSONObject.put("use_webview", this.openUriInWebview);
            jSONObject.put(BORDER_COLOR, this.borderColor);
            return jSONObject;
        } catch (JSONException unused) {
            return this.jsonObject;
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ MessageButton(JSONObject jSONObject, JSONObject jSONObject2, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this(jSONObject, (i11 & 2) != 0 ? null : jSONObject2);
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public MessageButton(org.json.JSONObject r14, org.json.JSONObject r15) {
        /*
            r13 = this;
            java.lang.String r0 = "jsonObject"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r14, r0)
            java.lang.String r0 = "id"
            r1 = -1
            int r5 = r14.optInt(r0, r1)
            java.lang.String r0 = "click_action"
            com.braze.enums.inappmessage.ClickAction r1 = com.braze.enums.inappmessage.ClickAction.NEWS_FEED
            r2 = 0
            bo.app.u0 r3 = bo.app.u0.f39450a     // Catch:{ Exception -> 0x004c }
            java.lang.String r0 = r14.getString(r0)     // Catch:{ Exception -> 0x004c }
            java.lang.String r3 = "jsonObject.getString(key)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r3)     // Catch:{ Exception -> 0x004c }
            java.util.Locale r3 = java.util.Locale.US     // Catch:{ Exception -> 0x004c }
            java.lang.String r4 = "US"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r4)     // Catch:{ Exception -> 0x004c }
            java.lang.String r0 = r0.toUpperCase(r3)     // Catch:{ Exception -> 0x004c }
            java.lang.String r3 = "this as java.lang.String).toUpperCase(locale)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r3)     // Catch:{ Exception -> 0x004c }
            com.braze.enums.inappmessage.ClickAction[] r3 = com.braze.enums.inappmessage.ClickAction.values()     // Catch:{ Exception -> 0x004c }
            int r4 = r3.length     // Catch:{ Exception -> 0x004c }
            r6 = r2
        L_0x0032:
            if (r6 >= r4) goto L_0x0044
            r7 = r3[r6]     // Catch:{ Exception -> 0x004c }
            int r6 = r6 + 1
            java.lang.String r8 = r7.name()     // Catch:{ Exception -> 0x004c }
            boolean r8 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r8, (java.lang.Object) r0)     // Catch:{ Exception -> 0x004c }
            if (r8 == 0) goto L_0x0032
            r6 = r7
            goto L_0x004d
        L_0x0044:
            java.util.NoSuchElementException r0 = new java.util.NoSuchElementException     // Catch:{ Exception -> 0x004c }
            java.lang.String r3 = "Array contains no element matching the predicate."
            r0.<init>(r3)     // Catch:{ Exception -> 0x004c }
            throw r0     // Catch:{ Exception -> 0x004c }
        L_0x004c:
            r6 = r1
        L_0x004d:
            java.lang.String r0 = "uri"
            java.lang.String r7 = r14.optString(r0)
            java.lang.String r0 = "text"
            java.lang.String r8 = r14.optString(r0)
            java.lang.String r0 = "jsonObject.optString(TEXT)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r8, r0)
            java.lang.String r0 = "bg_color"
            int r9 = r14.optInt(r0)
            java.lang.String r0 = "text_color"
            int r10 = r14.optInt(r0)
            java.lang.String r0 = "use_webview"
            boolean r11 = r14.optBoolean(r0, r2)
            java.lang.String r0 = "border_color"
            int r12 = r14.optInt(r0)
            r2 = r13
            r3 = r14
            r4 = r15
            r2.<init>(r3, r4, r5, r6, r7, r8, r9, r10, r11, r12)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.braze.models.inappmessage.MessageButton.<init>(org.json.JSONObject, org.json.JSONObject):void");
    }

    private MessageButton(JSONObject jSONObject, JSONObject jSONObject2, int i11, ClickAction clickAction2, String str, String str2, int i12, int i13, boolean z11, int i14) {
        o3 o3Var;
        this.f43802id = -1;
        this.clickAction = ClickAction.NONE;
        int parseColor = Color.parseColor("#1B78CF");
        this.backgroundColor = parseColor;
        this.textColor = -1;
        this.borderColor = parseColor;
        this.jsonObject = jSONObject;
        this.f43802id = i11;
        this.clickAction = clickAction2;
        if (clickAction2 == ClickAction.URI) {
            if (!(str == null || StringsKt__StringsJVMKt.isBlank(str))) {
                this.uri = Uri.parse(str);
            }
        }
        this.text = str2;
        this.backgroundColor = i12;
        this.textColor = i13;
        this.openUriInWebview = z11;
        this.borderColor = i14;
        if (jSONObject2 == null) {
            o3Var = null;
        } else {
            o3Var = new o3(jSONObject2);
        }
        this.darkTheme = o3Var;
    }
}
