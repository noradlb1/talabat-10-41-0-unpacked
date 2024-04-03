package com.appboy.enums;

import com.braze.models.inappmessage.InAppMessageBase;
import com.braze.support.BrazeLogger;
import com.braze.support.JsonUtils;
import com.facebook.appevents.UserDataStore;
import com.instabug.library.core.eventbus.coreeventbus.SDKCoreEvent;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.apache.commons.compress.archivers.ArchiveStreamFactory;
import org.json.JSONObject;

@Metadata(bv = {}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b/\b\u0001\u0018\u0000 \u000b2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0002\f\rB\u0019\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\t\u0010\nR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0017\u0010\u0007\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006j\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019j\u0002\b\u001aj\u0002\b\u001bj\u0002\b\u001cj\u0002\b\u001dj\u0002\b\u001ej\u0002\b\u001fj\u0002\b j\u0002\b!j\u0002\b\"j\u0002\b#j\u0002\b$j\u0002\b%j\u0002\b&j\u0002\b'j\u0002\b(j\u0002\b)j\u0002\b*j\u0002\b+j\u0002\b,j\u0002\b-j\u0002\b.j\u0002\b/j\u0002\b0¨\u00061"}, d2 = {"Lcom/appboy/enums/CardKey;", "", "", "feedKey", "Ljava/lang/String;", "getFeedKey", "()Ljava/lang/String;", "contentCardsKey", "getContentCardsKey", "<init>", "(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;)V", "Companion", "a", "Provider", "ID", "VIEWED", "CREATED", "EXPIRES_AT", "EXTRAS", "OPEN_URI_IN_WEBVIEW", "TYPE", "CATEGORIES", "UPDATED", "DISMISSED", "REMOVED", "PINNED", "DISMISSIBLE", "IS_TEST", "READ", "CLICKED", "BANNER_IMAGE_IMAGE", "BANNER_IMAGE_URL", "BANNER_IMAGE_DOMAIN", "BANNER_IMAGE_ASPECT_RATIO", "CAPTIONED_IMAGE_IMAGE", "CAPTIONED_IMAGE_TITLE", "CAPTIONED_IMAGE_DESCRIPTION", "CAPTIONED_IMAGE_URL", "CAPTIONED_IMAGE_DOMAIN", "CAPTIONED_IMAGE_ASPECT_RATIO", "TEXT_ANNOUNCEMENT_TITLE", "TEXT_ANNOUNCEMENT_DESCRIPTION", "TEXT_ANNOUNCEMENT_URL", "TEXT_ANNOUNCEMENT_DOMAIN", "SHORT_NEWS_IMAGE", "SHORT_NEWS_TITLE", "SHORT_NEWS_DESCRIPTION", "SHORT_NEWS_URL", "SHORT_NEWS_DOMAIN", "android-sdk-base_release"}, k = 1, mv = {1, 6, 0})
public enum CardKey {
    ID("id", "id"),
    VIEWED("viewed", "v"),
    CREATED("created", "ca"),
    EXPIRES_AT("expires_at", "ea"),
    EXTRAS("extras", "e"),
    OPEN_URI_IN_WEBVIEW(InAppMessageBase.OPEN_URI_IN_WEBVIEW, "uw"),
    TYPE("type", "tp"),
    CATEGORIES("categories", ""),
    UPDATED(SDKCoreEvent.Feature.VALUE_UPDATED, ""),
    DISMISSED("", "d"),
    REMOVED("", "r"),
    PINNED("", "p"),
    DISMISSIBLE("", UserDataStore.DATE_OF_BIRTH),
    IS_TEST("", "t"),
    READ("", "read"),
    CLICKED("", "cl"),
    BANNER_IMAGE_IMAGE("image", "i"),
    BANNER_IMAGE_URL("url", "u"),
    BANNER_IMAGE_DOMAIN("domain", ""),
    BANNER_IMAGE_ASPECT_RATIO("aspect_ratio", ArchiveStreamFactory.AR),
    CAPTIONED_IMAGE_IMAGE("image", "i"),
    CAPTIONED_IMAGE_TITLE("title", TtmlNode.TAG_TT),
    CAPTIONED_IMAGE_DESCRIPTION("description", "ds"),
    CAPTIONED_IMAGE_URL("url", "u"),
    CAPTIONED_IMAGE_DOMAIN("domain", "dm"),
    CAPTIONED_IMAGE_ASPECT_RATIO("aspect_ratio", ArchiveStreamFactory.AR),
    TEXT_ANNOUNCEMENT_TITLE("title", TtmlNode.TAG_TT),
    TEXT_ANNOUNCEMENT_DESCRIPTION("description", "ds"),
    TEXT_ANNOUNCEMENT_URL("url", "u"),
    TEXT_ANNOUNCEMENT_DOMAIN("domain", "dm"),
    SHORT_NEWS_IMAGE("image", "i"),
    SHORT_NEWS_TITLE("title", TtmlNode.TAG_TT),
    SHORT_NEWS_DESCRIPTION("description", "ds"),
    SHORT_NEWS_URL("url", "u"),
    SHORT_NEWS_DOMAIN("domain", "dm");
    
    private static final String BANNER_IMAGE_KEY = "banner_image";
    private static final String CAPTIONED_IMAGE_KEY = "captioned_image";
    private static final String CONTROL_KEY = "control";
    public static final a Companion = null;
    private static final String SHORT_NEWS_KEY = "short_news";
    private static final String TEXT_ANNOUNCEMENT_KEY = "text_announcement";
    /* access modifiers changed from: private */
    public static final Map<String, CardType> cardTypeMap = null;
    private final String contentCardsKey;
    private final String feedKey;

    @Metadata(bv = {}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\b\b\u0007\u0018\u0000 \u00122\u00020\u0001:\u0001\u0013B\u000f\u0012\u0006\u0010\r\u001a\u00020\f¢\u0006\u0004\b\u0010\u0010\u0011J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u0010\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0007\u001a\u00020\u0006J\u0010\u0010\u000b\u001a\u0004\u0018\u00010\u00042\u0006\u0010\n\u001a\u00020\bR\u0017\u0010\r\u001a\u00020\f8\u0006¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\r\u0010\u000f¨\u0006\u0014"}, d2 = {"Lcom/appboy/enums/CardKey$Provider;", "", "Lcom/appboy/enums/CardKey;", "key", "", "getKey", "Lorg/json/JSONObject;", "jsonObject", "Lcom/appboy/enums/CardType;", "getCardTypeFromJson", "cardType", "getServerKeyFromCardType", "", "isContentCardProvider", "Z", "()Z", "<init>", "(Z)V", "Companion", "a", "android-sdk-base_release"}, k = 1, mv = {1, 6, 0})
    public static final class Provider {
        public static final Provider CONTENT_CARDS = null;
        public static final a Companion = null;
        public static final Provider NEWS_FEED = null;
        private final boolean isContentCardProvider;

        @Metadata(bv = {}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0006\u0010\u0007R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0006X\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u0004¨\u0006\b"}, d2 = {"Lcom/appboy/enums/CardKey$Provider$a;", "", "Lcom/appboy/enums/CardKey$Provider;", "CONTENT_CARDS", "Lcom/appboy/enums/CardKey$Provider;", "NEWS_FEED", "<init>", "()V", "android-sdk-base_release"}, k = 1, mv = {1, 6, 0})
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
            final /* synthetic */ JSONObject f40729b;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public b(JSONObject jSONObject) {
                super(0);
                this.f40729b = jSONObject;
            }

            /* renamed from: a */
            public final String invoke() {
                return Intrinsics.stringPlus("Short News card doesn't contain image url, parsing type as Text Announcement. JSON: ", this.f40729b);
            }
        }

        static {
            Companion = new a((DefaultConstructorMarker) null);
            CONTENT_CARDS = new Provider(true);
            NEWS_FEED = new Provider(false);
        }

        public Provider(boolean z11) {
            this.isContentCardProvider = z11;
        }

        public final CardType getCardTypeFromJson(JSONObject jSONObject) {
            boolean z11;
            Intrinsics.checkNotNullParameter(jSONObject, "jsonObject");
            String optionalString = JsonUtils.getOptionalString(jSONObject, getKey(CardKey.TYPE));
            boolean z12 = false;
            if (optionalString == null || optionalString.length() == 0) {
                z11 = true;
            } else {
                z11 = false;
            }
            if (!z11 && this.isContentCardProvider && Intrinsics.areEqual((Object) optionalString, (Object) CardKey.SHORT_NEWS_KEY)) {
                String optionalString2 = JsonUtils.getOptionalString(jSONObject, getKey(CardKey.SHORT_NEWS_IMAGE));
                if (optionalString2 == null || optionalString2.length() == 0) {
                    z12 = true;
                }
                if (z12) {
                    BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.V, (Throwable) null, false, (Function0) new b(jSONObject), 6, (Object) null);
                    optionalString = CardKey.TEXT_ANNOUNCEMENT_KEY;
                }
            }
            if (CardKey.cardTypeMap.containsKey(optionalString)) {
                return (CardType) CardKey.cardTypeMap.get(optionalString);
            }
            return CardType.DEFAULT;
        }

        public final String getKey(CardKey cardKey) {
            Intrinsics.checkNotNullParameter(cardKey, "key");
            if (this.isContentCardProvider) {
                return cardKey.getContentCardsKey();
            }
            return cardKey.getFeedKey();
        }

        public final String getServerKeyFromCardType(CardType cardType) {
            Intrinsics.checkNotNullParameter(cardType, "cardType");
            for (Map.Entry entry : CardKey.cardTypeMap.entrySet()) {
                String str = (String) entry.getKey();
                if (cardType == ((CardType) entry.getValue())) {
                    return str;
                }
            }
            return null;
        }

        public final boolean isContentCardProvider() {
            return this.isContentCardProvider;
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\r\u0010\u000eR\u0014\u0010\u0003\u001a\u00020\u00028\u0002XT¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0002XT¢\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00028\u0002XT¢\u0006\u0006\n\u0004\b\u0006\u0010\u0004R\u0014\u0010\u0007\u001a\u00020\u00028\u0002XT¢\u0006\u0006\n\u0004\b\u0007\u0010\u0004R\u0014\u0010\b\u001a\u00020\u00028\u0002XT¢\u0006\u0006\n\u0004\b\b\u0010\u0004R \u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\n0\t8\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\f¨\u0006\u000f"}, d2 = {"Lcom/appboy/enums/CardKey$a;", "", "", "BANNER_IMAGE_KEY", "Ljava/lang/String;", "CAPTIONED_IMAGE_KEY", "CONTROL_KEY", "SHORT_NEWS_KEY", "TEXT_ANNOUNCEMENT_KEY", "", "Lcom/appboy/enums/CardType;", "cardTypeMap", "Ljava/util/Map;", "<init>", "()V", "android-sdk-base_release"}, k = 1, mv = {1, 6, 0})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* access modifiers changed from: public */
    static {
        Companion = new a((DefaultConstructorMarker) null);
        cardTypeMap = MapsKt__MapsKt.mapOf(TuplesKt.to(BANNER_IMAGE_KEY, CardType.BANNER), TuplesKt.to(CAPTIONED_IMAGE_KEY, CardType.CAPTIONED_IMAGE), TuplesKt.to(TEXT_ANNOUNCEMENT_KEY, CardType.TEXT_ANNOUNCEMENT), TuplesKt.to(SHORT_NEWS_KEY, CardType.SHORT_NEWS), TuplesKt.to(CONTROL_KEY, CardType.CONTROL));
    }

    private CardKey(String str, String str2) {
        this.feedKey = str;
        this.contentCardsKey = str2;
    }

    public final String getContentCardsKey() {
        return this.contentCardsKey;
    }

    public final String getFeedKey() {
        return this.feedKey;
    }
}
