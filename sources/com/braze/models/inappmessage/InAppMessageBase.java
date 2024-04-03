package com.braze.models.inappmessage;

import android.graphics.Color;
import android.net.Uri;
import bo.app.b2;
import bo.app.e3;
import bo.app.f3;
import bo.app.h3;
import bo.app.u0;
import bo.app.w2;
import bo.app.x1;
import com.braze.enums.inappmessage.ClickAction;
import com.braze.enums.inappmessage.CropType;
import com.braze.enums.inappmessage.DismissType;
import com.braze.enums.inappmessage.InAppMessageFailureType;
import com.braze.enums.inappmessage.MessageType;
import com.braze.enums.inappmessage.Orientation;
import com.braze.enums.inappmessage.TextAlign;
import com.braze.support.BrazeLogger;
import com.braze.support.JsonUtils;
import com.visa.checkout.Profile;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(bv = {}, d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b$\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000e\b'\u0018\u0000 \u00012\u00020\u00012\u00020\u0002:\u0002\u0001B\n\b\u0010¢\u0006\u0005\b\u0001\u0010-B2\b\u0017\u0012\u0007\u0010\u0001\u001a\u00020\u0017\u0012\b\u0010\u0001\u001a\u00030\u0001\u0012\b\b\u0002\u0010t\u001a\u00020\t\u0012\b\b\u0002\u0010v\u001a\u00020\t¢\u0006\u0006\b\u0001\u0010\u0001J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016J\u001a\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u00032\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016J\b\u0010\n\u001a\u00020\tH\u0016J\b\u0010\u000b\u001a\u00020\tH\u0016J\b\u0010\f\u001a\u00020\u0005H\u0016J\u0010\u0010\u000f\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\rH\u0016J\b\u0010\u0010\u001a\u00020\u0005H\u0016J\u000e\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011H\u0016J\u001c\u0010\u0016\u001a\u00020\u00052\u0012\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00120\u0014H\u0016J\b\u0010\u0018\u001a\u00020\u0017H\u0016R\u0016\u0010\u0019\u001a\u00020\u00038\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0018\u0010\u001b\u001a\u0004\u0018\u00010\u00078\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u001b\u0010\u001cR$\u0010\u001d\u001a\u0004\u0018\u00010\u00128\u0016@\u0016X\u000e¢\u0006\u0012\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R$\u0010#\u001a\u0004\u0018\u00010\u00128\u0016@\u0016X\u000e¢\u0006\u0012\n\u0004\b#\u0010\u001e\u001a\u0004\b$\u0010 \"\u0004\b%\u0010\"R(\u0010&\u001a\u00020\t8\u0016@\u0016X\u000e¢\u0006\u0018\n\u0004\b&\u0010'\u0012\u0004\b,\u0010-\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R.\u0010.\u001a\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00120\u00148\u0016@\u0016X\u000e¢\u0006\u0012\n\u0004\b.\u0010/\u001a\u0004\b0\u00101\"\u0004\b2\u00103R(\u00104\u001a\u00020\t8\u0016@\u0016X\u000e¢\u0006\u0018\n\u0004\b4\u0010'\u0012\u0004\b7\u0010-\u001a\u0004\b5\u0010)\"\u0004\b6\u0010+R(\u00108\u001a\u00020\t8\u0016@\u0016X\u000e¢\u0006\u0018\n\u0004\b8\u0010'\u0012\u0004\b;\u0010-\u001a\u0004\b9\u0010)\"\u0004\b:\u0010+R\"\u0010=\u001a\u00020<8\u0016@\u0016X\u000e¢\u0006\u0012\n\u0004\b=\u0010>\u001a\u0004\b?\u0010@\"\u0004\bA\u0010BR*\u0010E\u001a\u00020C2\u0006\u0010D\u001a\u00020C8\u0016@VX\u000e¢\u0006\u0012\n\u0004\bE\u0010F\u001a\u0004\bG\u0010H\"\u0004\bI\u0010JR\"\u0010L\u001a\u00020K8\u0016@\u0016X\u000e¢\u0006\u0012\n\u0004\bL\u0010M\u001a\u0004\bN\u0010O\"\u0004\bP\u0010QR\"\u0010S\u001a\u00020R8\u0016@\u0016X\u000e¢\u0006\u0012\n\u0004\bS\u0010T\u001a\u0004\bU\u0010V\"\u0004\bW\u0010XR\"\u0010Z\u001a\u00020Y8\u0016@\u0016X\u000e¢\u0006\u0012\n\u0004\bZ\u0010[\u001a\u0004\b\\\u0010]\"\u0004\b^\u0010_R\"\u0010a\u001a\u00020`8\u0016@\u0016X\u000e¢\u0006\u0012\n\u0004\ba\u0010b\u001a\u0004\bc\u0010d\"\u0004\be\u0010fR\"\u0010g\u001a\u00020C8\u0016@\u0016X\u000e¢\u0006\u0012\n\u0004\bg\u0010F\u001a\u0004\bh\u0010H\"\u0004\bi\u0010JR\"\u0010j\u001a\u00020C8\u0016@\u0016X\u000e¢\u0006\u0012\n\u0004\bj\u0010F\u001a\u0004\bk\u0010H\"\u0004\bl\u0010JR\"\u0010m\u001a\u00020C8\u0016@\u0016X\u000e¢\u0006\u0012\n\u0004\bm\u0010F\u001a\u0004\bn\u0010H\"\u0004\bo\u0010JR\"\u0010p\u001a\u00020C8\u0016@\u0016X\u000e¢\u0006\u0012\n\u0004\bp\u0010F\u001a\u0004\bq\u0010H\"\u0004\br\u0010JR\u0014\u0010t\u001a\u00020s8\u0002X\u0004¢\u0006\u0006\n\u0004\bt\u0010uR\u0014\u0010v\u001a\u00020s8\u0002X\u0004¢\u0006\u0006\n\u0004\bv\u0010uR\u0014\u0010w\u001a\u00020s8\u0002X\u0004¢\u0006\u0006\n\u0004\bw\u0010uR$\u0010x\u001a\u0004\u0018\u00010\u00178\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\bx\u0010y\u001a\u0004\bz\u0010{\"\u0004\b|\u0010}R\u0014\u0010\u0004\u001a\u00020\u00038VX\u0004¢\u0006\u0006\u001a\u0004\b~\u0010R\u0018\u0010\b\u001a\u0004\u0018\u00010\u00078VX\u0004¢\u0006\b\u001a\u0006\b\u0001\u0010\u0001R\u0016\u0010\u0001\u001a\u00020\t8VX\u0004¢\u0006\u0007\u001a\u0005\b\u0001\u0010)R,\u0010\u0001\u001a\u0005\u0018\u00010\u00018\u0006@\u0006X\u000e¢\u0006\u0018\n\u0006\b\u0001\u0010\u0001\u001a\u0006\b\u0001\u0010\u0001\"\u0006\b\u0001\u0010\u0001R,\u0010\u0001\u001a\u0005\u0018\u00010\u00018\u0006@\u0006X\u000e¢\u0006\u0018\n\u0006\b\u0001\u0010\u0001\u001a\u0006\b\u0001\u0010\u0001\"\u0006\b\u0001\u0010\u0001R\u0015\u0010\u0001\u001a\u0004\u0018\u00010\u00128F¢\u0006\u0007\u001a\u0005\b\u0001\u0010 ¨\u0006\u0001"}, d2 = {"Lcom/braze/models/inappmessage/InAppMessageBase;", "Lcom/braze/models/inappmessage/IInAppMessage;", "Lcom/braze/models/inappmessage/IInAppMessageThemeable;", "Lcom/braze/enums/inappmessage/ClickAction;", "clickAction", "", "setClickBehavior", "Landroid/net/Uri;", "uri", "", "logImpression", "logClick", "onAfterClosed", "Lcom/braze/enums/inappmessage/InAppMessageFailureType;", "failureType", "logDisplayFailure", "enableDarkTheme", "", "", "getRemoteAssetPathsForPrefetch", "", "remotePathToLocalAssetMap", "setLocalPrefetchedAssetPaths", "Lorg/json/JSONObject;", "forJsonPut", "internalClickAction", "Lcom/braze/enums/inappmessage/ClickAction;", "internalUri", "Landroid/net/Uri;", "message", "Ljava/lang/String;", "getMessage", "()Ljava/lang/String;", "setMessage", "(Ljava/lang/String;)V", "icon", "getIcon", "setIcon", "openUriInWebView", "Z", "getOpenUriInWebView", "()Z", "setOpenUriInWebView", "(Z)V", "getOpenUriInWebView$annotations", "()V", "extras", "Ljava/util/Map;", "getExtras", "()Ljava/util/Map;", "setExtras", "(Ljava/util/Map;)V", "animateIn", "getAnimateIn", "setAnimateIn", "getAnimateIn$annotations", "animateOut", "getAnimateOut", "setAnimateOut", "getAnimateOut$annotations", "Lcom/braze/enums/inappmessage/DismissType;", "dismissType", "Lcom/braze/enums/inappmessage/DismissType;", "getDismissType", "()Lcom/braze/enums/inappmessage/DismissType;", "setDismissType", "(Lcom/braze/enums/inappmessage/DismissType;)V", "", "value", "durationInMilliseconds", "I", "getDurationInMilliseconds", "()I", "setDurationInMilliseconds", "(I)V", "Lcom/braze/enums/inappmessage/Orientation;", "orientation", "Lcom/braze/enums/inappmessage/Orientation;", "getOrientation", "()Lcom/braze/enums/inappmessage/Orientation;", "setOrientation", "(Lcom/braze/enums/inappmessage/Orientation;)V", "Lcom/braze/enums/inappmessage/CropType;", "cropType", "Lcom/braze/enums/inappmessage/CropType;", "getCropType", "()Lcom/braze/enums/inappmessage/CropType;", "setCropType", "(Lcom/braze/enums/inappmessage/CropType;)V", "Lcom/braze/enums/inappmessage/TextAlign;", "messageTextAlign", "Lcom/braze/enums/inappmessage/TextAlign;", "getMessageTextAlign", "()Lcom/braze/enums/inappmessage/TextAlign;", "setMessageTextAlign", "(Lcom/braze/enums/inappmessage/TextAlign;)V", "", "expirationTimestamp", "J", "getExpirationTimestamp", "()J", "setExpirationTimestamp", "(J)V", "iconBackgroundColor", "getIconBackgroundColor", "setIconBackgroundColor", "messageTextColor", "getMessageTextColor", "setMessageTextColor", "backgroundColor", "getBackgroundColor", "setBackgroundColor", "iconColor", "getIconColor", "setIconColor", "Ljava/util/concurrent/atomic/AtomicBoolean;", "impressionLogged", "Ljava/util/concurrent/atomic/AtomicBoolean;", "clickLogged", "displayFailureLogged", "jsonObject", "Lorg/json/JSONObject;", "getJsonObject", "()Lorg/json/JSONObject;", "setJsonObject", "(Lorg/json/JSONObject;)V", "getClickAction", "()Lcom/braze/enums/inappmessage/ClickAction;", "getUri", "()Landroid/net/Uri;", "isControl", "Lbo/app/b2;", "brazeManager", "Lbo/app/b2;", "getBrazeManager", "()Lbo/app/b2;", "setBrazeManager", "(Lbo/app/b2;)V", "Lbo/app/h3;", "inAppMessageDarkThemeWrapper", "Lbo/app/h3;", "getInAppMessageDarkThemeWrapper", "()Lbo/app/h3;", "setInAppMessageDarkThemeWrapper", "(Lbo/app/h3;)V", "getTriggerId", "triggerId", "<init>", "json", "(Lorg/json/JSONObject;Lbo/app/b2;ZZ)V", "Companion", "a", "android-sdk-base_release"}, k = 1, mv = {1, 6, 0})
public abstract class InAppMessageBase implements IInAppMessage, IInAppMessageThemeable {
    public static final String BG_COLOR = "bg_color";
    public static final String CLICK_ACTION = "click_action";
    public static final String CROP_TYPE = "crop_type";
    public static final a Companion = new a((DefaultConstructorMarker) null);
    public static final String DISMISS_TYPE = "message_close";
    public static final String DURATION = "duration";
    public static final String EXTRAS = "extras";
    public static final String ICON = "icon";
    public static final String ICON_BG_COLOR = "icon_bg_color";
    public static final String ICON_COLOR = "icon_color";
    public static final int INAPP_MESSAGE_DURATION_DEFAULT_MILLIS = 5000;
    public static final int INAPP_MESSAGE_DURATION_MIN_MILLIS = 999;
    public static final String IS_CONTROL = "is_control";
    public static final String MESSAGE = "message";
    public static final String MESSAGE_TEXT_ALIGN = "text_align_message";
    public static final String MESSAGE_TEXT_COLOR = "text_color";
    public static final String OPEN_URI_IN_WEBVIEW = "use_webview";
    public static final String ORIENTATION = "orientation";
    public static final String TRIGGER_ID = "trigger_id";
    public static final String TYPE = "type";
    public static final String URI = "uri";
    private boolean animateIn;
    private boolean animateOut;
    private int backgroundColor;
    private b2 brazeManager;
    private final AtomicBoolean clickLogged;
    private CropType cropType;
    private DismissType dismissType;
    private final AtomicBoolean displayFailureLogged;
    private int durationInMilliseconds;
    private long expirationTimestamp;
    private Map<String, String> extras;
    private String icon;
    private int iconBackgroundColor;
    private int iconColor;
    private final AtomicBoolean impressionLogged;
    private h3 inAppMessageDarkThemeWrapper;
    private ClickAction internalClickAction;
    private Uri internalUri;
    private JSONObject jsonObject;
    private String message;
    private TextAlign messageTextAlign;
    private int messageTextColor;
    private boolean openUriInWebView;
    private Orientation orientation;

    @Metadata(bv = {}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\b\n\u0002\b\u000f\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u001c\u0010\u001dR\u0014\u0010\u0003\u001a\u00020\u00028\u0004XT¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0004XT¢\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00028\u0000XT¢\u0006\u0006\n\u0004\b\u0006\u0010\u0004R\u0014\u0010\u0007\u001a\u00020\u00028\u0000XT¢\u0006\u0006\n\u0004\b\u0007\u0010\u0004R\u0014\u0010\b\u001a\u00020\u00028\u0000XT¢\u0006\u0006\n\u0004\b\b\u0010\u0004R\u0014\u0010\t\u001a\u00020\u00028\u0000XT¢\u0006\u0006\n\u0004\b\t\u0010\u0004R\u0014\u0010\n\u001a\u00020\u00028\u0000XT¢\u0006\u0006\n\u0004\b\n\u0010\u0004R\u0014\u0010\u000b\u001a\u00020\u00028\u0000XT¢\u0006\u0006\n\u0004\b\u000b\u0010\u0004R\u0014\u0010\f\u001a\u00020\u00028\u0000XT¢\u0006\u0006\n\u0004\b\f\u0010\u0004R\u0014\u0010\r\u001a\u00020\u00028\u0000XT¢\u0006\u0006\n\u0004\b\r\u0010\u0004R\u0014\u0010\u000e\u001a\u00020\u00028\u0000XT¢\u0006\u0006\n\u0004\b\u000e\u0010\u0004R\u0014\u0010\u0010\u001a\u00020\u000f8\u0006XT¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0012\u001a\u00020\u000f8\u0006XT¢\u0006\u0006\n\u0004\b\u0012\u0010\u0011R\u0014\u0010\u0013\u001a\u00020\u00028\u0006XT¢\u0006\u0006\n\u0004\b\u0013\u0010\u0004R\u0014\u0010\u0014\u001a\u00020\u00028\u0000XT¢\u0006\u0006\n\u0004\b\u0014\u0010\u0004R\u0014\u0010\u0015\u001a\u00020\u00028\u0000XT¢\u0006\u0006\n\u0004\b\u0015\u0010\u0004R\u0014\u0010\u0016\u001a\u00020\u00028\u0000XT¢\u0006\u0006\n\u0004\b\u0016\u0010\u0004R\u0014\u0010\u0017\u001a\u00020\u00028\u0000XT¢\u0006\u0006\n\u0004\b\u0017\u0010\u0004R\u0014\u0010\u0018\u001a\u00020\u00028\u0000XT¢\u0006\u0006\n\u0004\b\u0018\u0010\u0004R\u0014\u0010\u0019\u001a\u00020\u00028\u0000XT¢\u0006\u0006\n\u0004\b\u0019\u0010\u0004R\u0014\u0010\u001a\u001a\u00020\u00028\u0006XT¢\u0006\u0006\n\u0004\b\u001a\u0010\u0004R\u0014\u0010\u001b\u001a\u00020\u00028\u0000XT¢\u0006\u0006\n\u0004\b\u001b\u0010\u0004¨\u0006\u001e"}, d2 = {"Lcom/braze/models/inappmessage/InAppMessageBase$a;", "", "", "ANIMATE_IN", "Ljava/lang/String;", "ANIMATE_OUT", "BG_COLOR", "CLICK_ACTION", "CROP_TYPE", "DISMISS_TYPE", "DURATION", "EXTRAS", "ICON", "ICON_BG_COLOR", "ICON_COLOR", "", "INAPP_MESSAGE_DURATION_DEFAULT_MILLIS", "I", "INAPP_MESSAGE_DURATION_MIN_MILLIS", "IS_CONTROL", "MESSAGE", "MESSAGE_TEXT_ALIGN", "MESSAGE_TEXT_COLOR", "OPEN_URI_IN_WEBVIEW", "ORIENTATION", "TRIGGER_ID", "TYPE", "URI", "<init>", "()V", "android-sdk-base_release"}, k = 1, mv = {1, 6, 0})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class b extends Lambda implements Function0<String> {

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ int f43764g;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(int i11) {
            super(0);
            this.f43764g = i11;
        }

        /* renamed from: a */
        public final String invoke() {
            return "Requested in-app message duration " + this.f43764g + " is lower than the minimum of 999. Defaulting to 5000 milliseconds.";
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class c extends Lambda implements Function0<String> {

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ int f43765g;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public c(int i11) {
            super(0);
            this.f43765g = i11;
        }

        /* renamed from: a */
        public final String invoke() {
            return "Set in-app message duration to " + this.f43765g + " milliseconds.";
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class d extends Lambda implements Function0<String> {

        /* renamed from: b  reason: collision with root package name */
        public static final d f43766b = new d();

        public d() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "Cannot apply dark theme with a null themes wrapper";
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class e extends Lambda implements Function0<String> {

        /* renamed from: b  reason: collision with root package name */
        public static final e f43767b = new e();

        public e() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "Failed to construct json for in-app message";
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class f extends Lambda implements Function0<String> {

        /* renamed from: b  reason: collision with root package name */
        public static final f f43768b = new f();

        public f() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "Trigger id not found (this is expected for test sends). Not logging in-app message click.";
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class g extends Lambda implements Function0<String> {

        /* renamed from: b  reason: collision with root package name */
        public static final g f43769b = new g();

        public g() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "Cannot log an in-app message click because the BrazeManager is null.";
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class h extends Lambda implements Function0<String> {

        /* renamed from: b  reason: collision with root package name */
        public static final h f43770b = new h();

        public h() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "Click already logged for this in-app message. Ignoring.";
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class i extends Lambda implements Function0<String> {

        /* renamed from: b  reason: collision with root package name */
        public static final i f43771b = new i();

        public i() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "Display failure already logged for this in-app message. Ignoring.";
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class j extends Lambda implements Function0<String> {

        /* renamed from: b  reason: collision with root package name */
        public static final j f43772b = new j();

        public j() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "Logging click on in-app message";
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class k extends Lambda implements Function0<String> {

        /* renamed from: b  reason: collision with root package name */
        public static final k f43773b = new k();

        public k() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "Trigger id not found (this is expected for test sends). Not logging in-app message display failure.";
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class l extends Lambda implements Function0<String> {

        /* renamed from: b  reason: collision with root package name */
        public static final l f43774b = new l();

        public l() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "Cannot log an in-app message display failure because the BrazeManager is null.";
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class m extends Lambda implements Function0<String> {

        /* renamed from: b  reason: collision with root package name */
        public static final m f43775b = new m();

        public m() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "Display failure already logged for this in-app message. Ignoring.";
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class n extends Lambda implements Function0<String> {

        /* renamed from: b  reason: collision with root package name */
        public static final n f43776b = new n();

        public n() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "Click already logged for this in-app message. Ignoring.";
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class o extends Lambda implements Function0<String> {

        /* renamed from: b  reason: collision with root package name */
        public static final o f43777b = new o();

        public o() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "Impression already logged for this in-app message. Ignoring.";
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class p extends Lambda implements Function0<String> {

        /* renamed from: b  reason: collision with root package name */
        public static final p f43778b = new p();

        public p() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "Trigger id not found (this is expected for test sends). Not logging in-app message impression.";
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class q extends Lambda implements Function0<String> {

        /* renamed from: b  reason: collision with root package name */
        public static final q f43779b = new q();

        public q() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "Cannot log an in-app message impression because the BrazeManager is null.";
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class r extends Lambda implements Function0<String> {

        /* renamed from: b  reason: collision with root package name */
        public static final r f43780b = new r();

        public r() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "Impression already logged for this in-app message. Ignoring.";
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class s extends Lambda implements Function0<String> {

        /* renamed from: b  reason: collision with root package name */
        public static final s f43781b = new s();

        public s() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "Display failure already logged for this in-app message. Ignoring.";
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class t extends Lambda implements Function0<String> {

        /* renamed from: b  reason: collision with root package name */
        public static final t f43782b = new t();

        public t() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "A non-null URI is required in order to set the message ClickAction to URI.";
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class u extends Lambda implements Function0<String> {

        /* renamed from: b  reason: collision with root package name */
        public static final u f43783b = new u();

        public u() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "A non-null URI is required in order to set the message ClickAction to URI.";
        }
    }

    public InAppMessageBase() {
        this.internalClickAction = ClickAction.NONE;
        this.extras = MapsKt__MapsKt.emptyMap();
        this.animateIn = true;
        this.animateOut = true;
        this.dismissType = DismissType.AUTO_DISMISS;
        this.durationInMilliseconds = 5000;
        this.orientation = Orientation.ANY;
        this.cropType = CropType.FIT_CENTER;
        this.messageTextAlign = TextAlign.CENTER;
        this.expirationTimestamp = -1;
        this.iconBackgroundColor = Color.parseColor("#ff0073d5");
        this.messageTextColor = Color.parseColor("#555555");
        this.backgroundColor = -1;
        this.iconColor = -1;
        this.impressionLogged = new AtomicBoolean(false);
        this.clickLogged = new AtomicBoolean(false);
        this.displayFailureLogged = new AtomicBoolean(false);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public InAppMessageBase(JSONObject jSONObject, b2 b2Var) {
        this(jSONObject, b2Var, false, false, 12, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(jSONObject, "json");
        Intrinsics.checkNotNullParameter(b2Var, "brazeManager");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public InAppMessageBase(JSONObject jSONObject, b2 b2Var, boolean z11) {
        this(jSONObject, b2Var, z11, false, 8, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(jSONObject, "json");
        Intrinsics.checkNotNullParameter(b2Var, "brazeManager");
    }

    public static /* synthetic */ void getAnimateIn$annotations() {
    }

    public static /* synthetic */ void getAnimateOut$annotations() {
    }

    public static /* synthetic */ void getOpenUriInWebView$annotations() {
    }

    public void enableDarkTheme() {
        h3 h3Var = this.inAppMessageDarkThemeWrapper;
        if (h3Var == null) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, false, (Function0) d.f43766b, 7, (Object) null);
            return;
        }
        if (h3Var.a() != null) {
            setBackgroundColor(h3Var.a().intValue());
        }
        if (h3Var.f() != null) {
            setIconColor(h3Var.f().intValue());
        }
        if (h3Var.e() != null) {
            setIconBackgroundColor(h3Var.e().intValue());
        }
        if (h3Var.g() != null) {
            setMessageTextColor(h3Var.g().intValue());
        }
    }

    public boolean getAnimateIn() {
        return this.animateIn;
    }

    public boolean getAnimateOut() {
        return this.animateOut;
    }

    public int getBackgroundColor() {
        return this.backgroundColor;
    }

    public final b2 getBrazeManager() {
        return this.brazeManager;
    }

    public ClickAction getClickAction() {
        return this.internalClickAction;
    }

    public CropType getCropType() {
        return this.cropType;
    }

    public DismissType getDismissType() {
        return this.dismissType;
    }

    public int getDurationInMilliseconds() {
        return this.durationInMilliseconds;
    }

    public long getExpirationTimestamp() {
        return this.expirationTimestamp;
    }

    public Map<String, String> getExtras() {
        return this.extras;
    }

    public String getIcon() {
        return this.icon;
    }

    public int getIconBackgroundColor() {
        return this.iconBackgroundColor;
    }

    public int getIconColor() {
        return this.iconColor;
    }

    public final h3 getInAppMessageDarkThemeWrapper() {
        return this.inAppMessageDarkThemeWrapper;
    }

    public final JSONObject getJsonObject() {
        return this.jsonObject;
    }

    public /* synthetic */ Map getLocalPrefetchedAssetPaths() {
        return t3.a.a(this);
    }

    public String getMessage() {
        return this.message;
    }

    public TextAlign getMessageTextAlign() {
        return this.messageTextAlign;
    }

    public int getMessageTextColor() {
        return this.messageTextColor;
    }

    public boolean getOpenUriInWebView() {
        return this.openUriInWebView;
    }

    public Orientation getOrientation() {
        return this.orientation;
    }

    public List<String> getRemoteAssetPathsForPrefetch() {
        return CollectionsKt__CollectionsKt.emptyList();
    }

    public final String getTriggerId() {
        JSONObject jSONObject = this.jsonObject;
        if (jSONObject == null) {
            return null;
        }
        return jSONObject.optString(TRIGGER_ID);
    }

    public Uri getUri() {
        return this.internalUri;
    }

    public boolean isControl() {
        JSONObject jSONObject = this.jsonObject;
        return jSONObject != null && jSONObject.optBoolean(IS_CONTROL);
    }

    public boolean logClick() {
        boolean z11;
        String triggerId = getTriggerId();
        if (triggerId == null || StringsKt__StringsJVMKt.isBlank(triggerId)) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (z11) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, false, (Function0) f.f43768b, 7, (Object) null);
            return false;
        }
        b2 b2Var = this.brazeManager;
        if (b2Var == null) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.W, (Throwable) null, false, (Function0) g.f43769b, 6, (Object) null);
            return false;
        } else if (this.clickLogged.get() && getMessageType() != MessageType.HTML) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.I, (Throwable) null, false, (Function0) h.f43770b, 6, (Object) null);
            return false;
        } else if (this.displayFailureLogged.get()) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.I, (Throwable) null, false, (Function0) i.f43771b, 6, (Object) null);
            return false;
        } else {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.V, (Throwable) null, false, (Function0) j.f43772b, 6, (Object) null);
            x1 g11 = bo.app.j.f38653h.g(triggerId);
            if (g11 != null) {
                b2Var.a(g11);
            }
            this.clickLogged.set(true);
            return true;
        }
    }

    public boolean logDisplayFailure(InAppMessageFailureType inAppMessageFailureType) {
        boolean z11;
        Intrinsics.checkNotNullParameter(inAppMessageFailureType, "failureType");
        String triggerId = getTriggerId();
        if (triggerId == null || StringsKt__StringsJVMKt.isBlank(triggerId)) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (z11) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, false, (Function0) k.f43773b, 7, (Object) null);
            return false;
        }
        b2 b2Var = this.brazeManager;
        if (b2Var == null) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.W, (Throwable) null, false, (Function0) l.f43774b, 6, (Object) null);
            return false;
        } else if (this.displayFailureLogged.get()) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.I, (Throwable) null, false, (Function0) m.f43775b, 6, (Object) null);
            return false;
        } else if (this.clickLogged.get()) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.I, (Throwable) null, false, (Function0) n.f43776b, 6, (Object) null);
            return false;
        } else if (this.impressionLogged.get()) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.I, (Throwable) null, false, (Function0) o.f43777b, 6, (Object) null);
            return false;
        } else {
            x1 a11 = bo.app.j.f38653h.a(triggerId, inAppMessageFailureType);
            if (a11 != null) {
                b2Var.a(a11);
            }
            this.displayFailureLogged.set(true);
            return true;
        }
    }

    public boolean logImpression() {
        boolean z11;
        String triggerId = getTriggerId();
        if (triggerId == null || StringsKt__StringsJVMKt.isBlank(triggerId)) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (z11) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.D, (Throwable) null, false, (Function0) p.f43778b, 6, (Object) null);
            return false;
        }
        b2 b2Var = this.brazeManager;
        if (b2Var == null) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.W, (Throwable) null, false, (Function0) q.f43779b, 6, (Object) null);
            return false;
        } else if (this.impressionLogged.get()) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.I, (Throwable) null, false, (Function0) r.f43780b, 6, (Object) null);
            return false;
        } else if (this.displayFailureLogged.get()) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.I, (Throwable) null, false, (Function0) s.f43781b, 6, (Object) null);
            return false;
        } else {
            x1 i11 = bo.app.j.f38653h.i(triggerId);
            if (i11 != null) {
                b2Var.a(i11);
            }
            this.impressionLogged.set(true);
            return true;
        }
    }

    public void onAfterClosed() {
        boolean z11;
        b2 b2Var;
        String triggerId = getTriggerId();
        if (this.clickLogged.get()) {
            if (triggerId == null || triggerId.length() == 0) {
                z11 = true;
            } else {
                z11 = false;
            }
            if (!z11 && (b2Var = this.brazeManager) != null) {
                b2Var.a((w2) new e3(triggerId));
            }
        }
    }

    public void setAnimateIn(boolean z11) {
        this.animateIn = z11;
    }

    public void setAnimateOut(boolean z11) {
        this.animateOut = z11;
    }

    public void setBackgroundColor(int i11) {
        this.backgroundColor = i11;
    }

    public final void setBrazeManager(b2 b2Var) {
        this.brazeManager = b2Var;
    }

    public void setClickBehavior(ClickAction clickAction) {
        Intrinsics.checkNotNullParameter(clickAction, "clickAction");
        setClickBehavior(clickAction, (Uri) null);
    }

    public void setCropType(CropType cropType2) {
        Intrinsics.checkNotNullParameter(cropType2, "<set-?>");
        this.cropType = cropType2;
    }

    public void setDismissType(DismissType dismissType2) {
        Intrinsics.checkNotNullParameter(dismissType2, "<set-?>");
        this.dismissType = dismissType2;
    }

    public void setDurationInMilliseconds(int i11) {
        if (i11 < 999) {
            this.durationInMilliseconds = 5000;
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, false, (Function0) new b(i11), 7, (Object) null);
            return;
        }
        this.durationInMilliseconds = i11;
        BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, false, (Function0) new c(i11), 7, (Object) null);
    }

    public void setExpirationTimestamp(long j11) {
        this.expirationTimestamp = j11;
    }

    public void setExtras(Map<String, String> map) {
        Intrinsics.checkNotNullParameter(map, "<set-?>");
        this.extras = map;
    }

    public void setIcon(String str) {
        this.icon = str;
    }

    public void setIconBackgroundColor(int i11) {
        this.iconBackgroundColor = i11;
    }

    public void setIconColor(int i11) {
        this.iconColor = i11;
    }

    public final void setInAppMessageDarkThemeWrapper(h3 h3Var) {
        this.inAppMessageDarkThemeWrapper = h3Var;
    }

    public final void setJsonObject(JSONObject jSONObject) {
        this.jsonObject = jSONObject;
    }

    public void setLocalPrefetchedAssetPaths(Map<String, String> map) {
        Intrinsics.checkNotNullParameter(map, "remotePathToLocalAssetMap");
    }

    public void setMessage(String str) {
        this.message = str;
    }

    public void setMessageTextAlign(TextAlign textAlign) {
        Intrinsics.checkNotNullParameter(textAlign, "<set-?>");
        this.messageTextAlign = textAlign;
    }

    public void setMessageTextColor(int i11) {
        this.messageTextColor = i11;
    }

    public void setOpenUriInWebView(boolean z11) {
        this.openUriInWebView = z11;
    }

    public void setOrientation(Orientation orientation2) {
        Intrinsics.checkNotNullParameter(orientation2, "<set-?>");
        this.orientation = orientation2;
    }

    public JSONObject forJsonPut() {
        JSONObject jSONObject = this.jsonObject;
        if (jSONObject == null) {
            jSONObject = new JSONObject();
            try {
                jSONObject.putOpt("message", getMessage());
                jSONObject.put("duration", getDurationInMilliseconds());
                jSONObject.putOpt(TRIGGER_ID, getTriggerId());
                jSONObject.putOpt(CLICK_ACTION, getClickAction().toString());
                jSONObject.putOpt(DISMISS_TYPE, getDismissType().toString());
                if (getUri() != null) {
                    jSONObject.put("uri", (Object) String.valueOf(getUri()));
                }
                jSONObject.put(OPEN_URI_IN_WEBVIEW, getOpenUriInWebView());
                jSONObject.put("animate_in", getAnimateIn());
                jSONObject.put("animate_out", getAnimateOut());
                jSONObject.put(BG_COLOR, getBackgroundColor());
                jSONObject.put(MESSAGE_TEXT_COLOR, getMessageTextColor());
                jSONObject.put(ICON_COLOR, getIconColor());
                jSONObject.put(ICON_BG_COLOR, getIconBackgroundColor());
                jSONObject.putOpt("icon", getIcon());
                jSONObject.putOpt(CROP_TYPE, getCropType().toString());
                jSONObject.putOpt("orientation", getOrientation().toString());
                jSONObject.putOpt(MESSAGE_TEXT_ALIGN, getMessageTextAlign().toString());
                jSONObject.putOpt(IS_CONTROL, Boolean.valueOf(isControl()));
                if (!getExtras().isEmpty()) {
                    jSONObject.put("extras", (Object) getExtras());
                }
            } catch (JSONException e11) {
                BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.E, (Throwable) e11, false, (Function0) e.f43767b, 4, (Object) null);
            }
        }
        return jSONObject;
    }

    public void setClickBehavior(ClickAction clickAction, Uri uri) {
        Intrinsics.checkNotNullParameter(clickAction, "clickAction");
        if (uri == null && clickAction == ClickAction.URI) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.W, (Throwable) null, false, (Function0) t.f43782b, 6, (Object) null);
        } else if (uri != null && clickAction == ClickAction.URI) {
            this.internalClickAction = clickAction;
            this.internalUri = uri;
        } else if (clickAction != ClickAction.URI) {
            this.internalClickAction = clickAction;
            this.internalUri = null;
        } else {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.W, (Throwable) null, false, (Function0) u.f43783b, 6, (Object) null);
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ InAppMessageBase(JSONObject jSONObject, b2 b2Var, boolean z11, boolean z12, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this(jSONObject, b2Var, (i11 & 4) != 0 ? false : z11, (i11 & 8) != 0 ? false : z12);
    }

    public InAppMessageBase(JSONObject jSONObject, b2 b2Var, boolean z11, boolean z12) {
        JSONObject jSONObject2 = jSONObject;
        b2 b2Var2 = b2Var;
        Intrinsics.checkNotNullParameter(jSONObject2, "json");
        Intrinsics.checkNotNullParameter(b2Var2, "brazeManager");
        this.internalClickAction = ClickAction.NONE;
        this.extras = MapsKt__MapsKt.emptyMap();
        boolean z13 = true;
        this.animateIn = true;
        this.animateOut = true;
        this.dismissType = DismissType.AUTO_DISMISS;
        this.durationInMilliseconds = 5000;
        Orientation orientation2 = Orientation.ANY;
        this.orientation = orientation2;
        this.cropType = CropType.FIT_CENTER;
        this.messageTextAlign = TextAlign.CENTER;
        this.expirationTimestamp = -1;
        this.iconBackgroundColor = Color.parseColor("#ff0073d5");
        this.messageTextColor = Color.parseColor("#555555");
        this.backgroundColor = -1;
        this.iconColor = -1;
        int i11 = 0;
        this.impressionLogged = new AtomicBoolean(false);
        this.clickLogged = new AtomicBoolean(false);
        this.displayFailureLogged = new AtomicBoolean(false);
        this.jsonObject = jSONObject2;
        this.brazeManager = b2Var2;
        setMessage(jSONObject2.optString("message"));
        setAnimateIn(jSONObject2.optBoolean("animate_in", true));
        setAnimateOut(jSONObject2.optBoolean("animate_out", true));
        setDurationInMilliseconds(jSONObject2.optInt("duration"));
        setIcon(jSONObject2.optString("icon"));
        try {
            u0 u0Var = u0.f39450a;
            String string = jSONObject2.getString("orientation");
            Intrinsics.checkNotNullExpressionValue(string, "jsonObject.getString(key)");
            Locale locale = Locale.US;
            Intrinsics.checkNotNullExpressionValue(locale, Profile.Country.US);
            String upperCase = string.toUpperCase(locale);
            Intrinsics.checkNotNullExpressionValue(upperCase, "this as java.lang.String).toUpperCase(locale)");
            Orientation[] values = Orientation.values();
            int length = values.length;
            int i12 = 0;
            while (i12 < length) {
                Orientation orientation3 = values[i12];
                i12++;
                if (Intrinsics.areEqual((Object) orientation3.name(), (Object) upperCase)) {
                    orientation2 = orientation3;
                    setOrientation(orientation2);
                    setOpenUriInWebView(jSONObject2.optBoolean(OPEN_URI_IN_WEBVIEW, false));
                    setIconBackgroundColor(jSONObject2.optInt(ICON_BG_COLOR));
                    setMessageTextColor(jSONObject2.optInt(MESSAGE_TEXT_COLOR));
                    setBackgroundColor(jSONObject2.optInt(BG_COLOR));
                    setIconColor(jSONObject2.optInt(ICON_COLOR));
                    this.impressionLogged.set(z11);
                    this.clickLogged.set(z12);
                    setExtras(JsonUtils.convertJSONObjectToMap(jSONObject2.optJSONObject("extras")));
                    String optString = jSONObject2.optString("uri");
                    ClickAction clickAction = ClickAction.NONE;
                    try {
                        u0 u0Var2 = u0.f39450a;
                        String string2 = jSONObject2.getString(CLICK_ACTION);
                        Intrinsics.checkNotNullExpressionValue(string2, "jsonObject.getString(key)");
                        Locale locale2 = Locale.US;
                        Intrinsics.checkNotNullExpressionValue(locale2, Profile.Country.US);
                        String upperCase2 = string2.toUpperCase(locale2);
                        Intrinsics.checkNotNullExpressionValue(upperCase2, "this as java.lang.String).toUpperCase(locale)");
                        ClickAction[] values2 = ClickAction.values();
                        int length2 = values2.length;
                        int i13 = 0;
                        while (i13 < length2) {
                            ClickAction clickAction2 = values2[i13];
                            i13++;
                            if (Intrinsics.areEqual((Object) clickAction2.name(), (Object) upperCase2)) {
                                clickAction = clickAction2;
                                if (clickAction == ClickAction.URI) {
                                    if (optString != null && !StringsKt__StringsJVMKt.isBlank(optString)) {
                                        z13 = false;
                                    }
                                    if (!z13) {
                                        this.internalUri = Uri.parse(optString);
                                    }
                                }
                                this.internalClickAction = clickAction;
                                DismissType dismissType2 = DismissType.AUTO_DISMISS;
                                try {
                                    u0 u0Var3 = u0.f39450a;
                                    String string3 = jSONObject2.getString(DISMISS_TYPE);
                                    Intrinsics.checkNotNullExpressionValue(string3, "jsonObject.getString(key)");
                                    Locale locale3 = Locale.US;
                                    Intrinsics.checkNotNullExpressionValue(locale3, Profile.Country.US);
                                    String upperCase3 = string3.toUpperCase(locale3);
                                    Intrinsics.checkNotNullExpressionValue(upperCase3, "this as java.lang.String).toUpperCase(locale)");
                                    DismissType[] values3 = DismissType.values();
                                    int length3 = values3.length;
                                    while (i11 < length3) {
                                        DismissType dismissType3 = values3[i11];
                                        i11++;
                                        if (Intrinsics.areEqual((Object) dismissType3.name(), (Object) upperCase3)) {
                                            dismissType2 = dismissType3;
                                            setDismissType(dismissType2 == DismissType.SWIPE ? DismissType.MANUAL : dismissType2);
                                            this.inAppMessageDarkThemeWrapper = f3.a(jSONObject);
                                            return;
                                        }
                                    }
                                    throw new NoSuchElementException("Array contains no element matching the predicate.");
                                } catch (Exception unused) {
                                }
                            }
                        }
                        throw new NoSuchElementException("Array contains no element matching the predicate.");
                    } catch (Exception unused2) {
                    }
                }
            }
            throw new NoSuchElementException("Array contains no element matching the predicate.");
        } catch (Exception unused3) {
        }
    }
}
