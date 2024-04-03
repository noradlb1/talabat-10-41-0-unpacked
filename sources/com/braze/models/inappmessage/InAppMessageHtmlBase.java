package com.braze.models.inappmessage;

import bo.app.b2;
import bo.app.e3;
import bo.app.j;
import bo.app.w2;
import bo.app.x1;
import com.braze.enums.inappmessage.MessageType;
import com.braze.support.BrazeLogger;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.json.JSONObject;

@Metadata(bv = {}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b'\u0018\u00002\u00020\u00012\u00020\u0002B\t\b\u0014¢\u0006\u0004\b\u0015\u0010\u0016B\u0019\b\u0016\u0012\u0006\u0010\u0018\u001a\u00020\u0017\u0012\u0006\u0010\u001a\u001a\u00020\u0019¢\u0006\u0004\b\u0015\u0010\u001bJ\u001c\u0010\u0007\u001a\u00020\u00062\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0003H\u0016J\u0010\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0004H\u0016J\b\u0010\u000b\u001a\u00020\u0006H\u0016R$\u0010\f\u001a\u0004\u0018\u00010\u00048\u0016@\u0016X\u000e¢\u0006\u0012\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0012\u001a\u00020\t8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0018\u0010\u0014\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0014\u0010\r¨\u0006\u001c"}, d2 = {"Lcom/braze/models/inappmessage/InAppMessageHtmlBase;", "Lcom/braze/models/inappmessage/InAppMessageBase;", "Lcom/braze/models/inappmessage/IInAppMessageHtml;", "", "", "remotePathToLocalAssetMap", "", "setLocalPrefetchedAssetPaths", "buttonId", "", "logButtonClick", "onAfterClosed", "localAssetsDirectoryUrl", "Ljava/lang/String;", "getLocalAssetsDirectoryUrl", "()Ljava/lang/String;", "setLocalAssetsDirectoryUrl", "(Ljava/lang/String;)V", "wasButtonClickLogged", "Z", "buttonIdClicked", "<init>", "()V", "Lorg/json/JSONObject;", "jsonObject", "Lbo/app/b2;", "brazeManager", "(Lorg/json/JSONObject;Lbo/app/b2;)V", "android-sdk-base_release"}, k = 1, mv = {1, 6, 0})
public abstract class InAppMessageHtmlBase extends InAppMessageBase implements IInAppMessageHtml {
    private String buttonIdClicked;
    private String localAssetsDirectoryUrl;
    private boolean wasButtonClickLogged;

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class a extends Lambda implements Function0<String> {

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f43788g;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(String str) {
            super(0);
            this.f43788g = str;
        }

        /* renamed from: a */
        public final String invoke() {
            return Intrinsics.stringPlus("Trigger id not found (this is expected for test sends). Not logging html in-app message button click for id: ", this.f43788g);
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class b extends Lambda implements Function0<String> {

        /* renamed from: b  reason: collision with root package name */
        public static final b f43789b = new b();

        public b() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "Button Id was null or blank for this html in-app message. Ignoring.";
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class c extends Lambda implements Function0<String> {

        /* renamed from: b  reason: collision with root package name */
        public static final c f43790b = new c();

        public c() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "Button click already logged for this html in-app message. Ignoring.";
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class d extends Lambda implements Function0<String> {

        /* renamed from: b  reason: collision with root package name */
        public static final d f43791b = new d();

        public d() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "Cannot log an html in-app message button click because the BrazeManager is null.";
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class e extends Lambda implements Function0<String> {

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f43792g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ String f43793h;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public e(String str, String str2) {
            super(0);
            this.f43792g = str;
            this.f43793h = str2;
        }

        /* renamed from: a */
        public final String invoke() {
            return "Logged button click for button id: " + this.f43792g + " and trigger id: " + this.f43793h;
        }
    }

    public InAppMessageHtmlBase() {
        setOpenUriInWebView(true);
    }

    public String getLocalAssetsDirectoryUrl() {
        return this.localAssetsDirectoryUrl;
    }

    public boolean logButtonClick(String str) {
        boolean z11;
        Intrinsics.checkNotNullParameter(str, "buttonId");
        String triggerId = getTriggerId();
        b2 brazeManager = getBrazeManager();
        if (triggerId == null || triggerId.length() == 0) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (z11) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, false, (Function0) new a(str), 7, (Object) null);
            return false;
        } else if (StringsKt__StringsJVMKt.isBlank(str)) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.I, (Throwable) null, false, (Function0) b.f43789b, 6, (Object) null);
            return false;
        } else if (this.wasButtonClickLogged && getMessageType() != MessageType.HTML) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.I, (Throwable) null, false, (Function0) c.f43790b, 6, (Object) null);
            return false;
        } else if (brazeManager == null) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.W, (Throwable) null, false, (Function0) d.f43791b, 6, (Object) null);
            return false;
        } else {
            x1 d11 = j.f38653h.d(triggerId, str);
            if (d11 != null) {
                brazeManager.a(d11);
            }
            this.buttonIdClicked = str;
            this.wasButtonClickLogged = true;
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, false, (Function0) new e(str, triggerId), 7, (Object) null);
            return true;
        }
    }

    public void onAfterClosed() {
        boolean z11;
        b2 brazeManager;
        super.onAfterClosed();
        if (this.wasButtonClickLogged) {
            String triggerId = getTriggerId();
            boolean z12 = false;
            if (triggerId == null || StringsKt__StringsJVMKt.isBlank(triggerId)) {
                z11 = true;
            } else {
                z11 = false;
            }
            if (!z11) {
                String str = this.buttonIdClicked;
                if (str == null || StringsKt__StringsJVMKt.isBlank(str)) {
                    z12 = true;
                }
                if (!z12 && (brazeManager = getBrazeManager()) != null) {
                    brazeManager.a((w2) new e3(getTriggerId(), this.buttonIdClicked));
                }
            }
        }
    }

    public void setLocalAssetsDirectoryUrl(String str) {
        this.localAssetsDirectoryUrl = str;
    }

    public void setLocalPrefetchedAssetPaths(Map<String, String> map) {
        Intrinsics.checkNotNullParameter(map, "remotePathToLocalAssetMap");
        if (!map.isEmpty()) {
            Object[] array = map.values().toArray(new String[0]);
            if (array != null) {
                setLocalAssetsDirectoryUrl(((String[]) array)[0]);
                return;
            }
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public InAppMessageHtmlBase(JSONObject jSONObject, b2 b2Var) {
        super(jSONObject, b2Var, false, false, 12, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(jSONObject, "jsonObject");
        Intrinsics.checkNotNullParameter(b2Var, "brazeManager");
        setOpenUriInWebView(jSONObject.optBoolean(InAppMessageBase.OPEN_URI_IN_WEBVIEW, true));
    }
}
