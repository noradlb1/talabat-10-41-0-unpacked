package bo.app;

import com.braze.models.IPutIntoJson;
import com.google.android.gms.analytics.ecommerce.ProductAction;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002:\u0001\bB\u0011\b\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\u0004\u001a\u00020\u0003H\u0016¨\u0006\t"}, d2 = {"Lbo/app/c1;", "", "Lcom/braze/models/IPutIntoJson;", "", "w", "jsonKey", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "a", "android-sdk-base_release"}, k = 1, mv = {1, 6, 0})
public enum c1 implements IPutIntoJson<String> {
    LOCATION_RECORDED("lr"),
    CUSTOM_EVENT("ce"),
    f38333g("p"),
    PUSH_STORY_PAGE_CLICK("cic"),
    PUSH_CLICKED("pc"),
    PUSH_ACTION_BUTTON_CLICKED("ca"),
    INTERNAL("i"),
    INTERNAL_ERROR("ie"),
    NEWS_FEED_CARD_IMPRESSION("ci"),
    NEWS_FEED_CARD_CLICK("cc"),
    GEOFENCE("g"),
    CONTENT_CARDS_CLICK("ccc"),
    CONTENT_CARDS_IMPRESSION("cci"),
    CONTENT_CARDS_CONTROL_IMPRESSION("ccic"),
    CONTENT_CARDS_DISMISS("ccd"),
    INCREMENT("inc"),
    ADD_TO_CUSTOM_ATTRIBUTE_ARRAY(ProductAction.ACTION_ADD),
    REMOVE_FROM_CUSTOM_ATTRIBUTE_ARRAY("rem"),
    SET_CUSTOM_ATTRIBUTE_ARRAY("set"),
    INAPP_MESSAGE_IMPRESSION("si"),
    INAPP_MESSAGE_CONTROL_IMPRESSION("iec"),
    INAPP_MESSAGE_CLICK("sc"),
    INAPP_MESSAGE_BUTTON_CLICK("sbc"),
    INAPP_MESSAGE_DISPLAY_FAILURE("sfe"),
    USER_ALIAS("uae"),
    SESSION_START("ss"),
    SESSION_END("se"),
    TEST_TYPE(TtmlNode.TAG_TT),
    LOCATION_CUSTOM_ATTRIBUTE_ADD("lcaa"),
    LOCATION_CUSTOM_ATTRIBUTE_REMOVE("lcar"),
    SUBSCRIPTION_GROUP_UPDATE("sgu"),
    UNKNOWN("");
    

    /* renamed from: c  reason: collision with root package name */
    public static final a f38329c = null;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public static final Map<String, c1> f38330d = null;

    /* renamed from: b  reason: collision with root package name */
    private final String f38353b;

    @Metadata(bv = {}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007R \u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00040\u00068\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Lbo/app/c1$a;", "", "", "value", "Lbo/app/c1;", "a", "", "map", "Ljava/util/Map;", "<init>", "()V", "android-sdk-base_release"}, k = 1, mv = {1, 6, 0})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public final c1 a(String str) {
            Intrinsics.checkNotNullParameter(str, "value");
            Object obj = c1.f38330d.get(str);
            if (obj == null) {
                obj = c1.UNKNOWN;
            }
            return (c1) obj;
        }
    }

    /* access modifiers changed from: public */
    static {
        int i11;
        f38329c = new a((DefaultConstructorMarker) null);
        c1[] values = values();
        LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt___RangesKt.coerceAtLeast(MapsKt__MapsJVMKt.mapCapacity(values.length), 16));
        int length = values.length;
        while (i11 < length) {
            c1 c1Var = values[i11];
            i11++;
            linkedHashMap.put(c1Var.f38353b, c1Var);
        }
        f38330d = linkedHashMap;
    }

    private c1(String str) {
        this.f38353b = str;
    }

    /* renamed from: w */
    public String forJsonPut() {
        return this.f38353b;
    }
}
