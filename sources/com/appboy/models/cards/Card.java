package com.appboy.models.cards;

import bo.app.b2;
import bo.app.d2;
import bo.app.x1;
import com.appboy.enums.CardCategory;
import com.appboy.enums.CardKey;
import com.appboy.enums.CardType;
import com.appboy.enums.Channel;
import com.braze.models.IPutIntoJson;
import com.braze.storage.ICardStorageProvider;
import com.braze.support.BrazeLogger;
import com.braze.support.DateTimeUtils;
import com.braze.support.JsonUtils;
import java.util.EnumSet;
import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.json.JSONArray;
import org.json.JSONObject;

@Metadata(bv = {}, d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\u001e\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b\u0017\u0018\u0000 j2\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001:\u0001kB9\u0012\u0006\u0010\u0013\u001a\u00020\u0002\u0012\u0006\u0010a\u001a\u00020`\u0012\b\u0010c\u001a\u0004\u0018\u00010b\u0012\f\u0010\u0016\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0015\u0012\b\u0010e\u001a\u0004\u0018\u00010d¢\u0006\u0004\bf\u0010gB\u0019\b\u0016\u0012\u0006\u0010\u0013\u001a\u00020\u0002\u0012\u0006\u0010h\u001a\u00020`¢\u0006\u0004\bf\u0010iJ\u0006\u0010\u0004\u001a\u00020\u0003J\u0006\u0010\u0005\u001a\u00020\u0003J\u0014\u0010\t\u001a\u00020\u00032\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006J\b\u0010\n\u001a\u00020\u0002H\u0016J\b\u0010\f\u001a\u00020\u000bH\u0016J\b\u0010\r\u001a\u00020\u0003H\u0007J\u0013\u0010\u0010\u001a\u00020\u00032\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0002J\b\u0010\u0012\u001a\u00020\u0011H\u0016R\u0014\u0010\u0013\u001a\u00020\u00028\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0016\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u00158\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R#\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b0\u00188\u0006¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR\u0017\u0010\u001d\u001a\u00020\u000b8\u0006¢\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 R\u0017\u0010\"\u001a\u00020!8\u0006¢\u0006\f\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010%R\u0017\u0010&\u001a\u00020!8\u0006¢\u0006\f\n\u0004\b&\u0010#\u001a\u0004\b'\u0010%R\u0017\u0010(\u001a\u00020!8\u0006¢\u0006\f\n\u0004\b(\u0010#\u001a\u0004\b)\u0010%R4\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00062\u000e\u0010*\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00068\u0006@BX\u000e¢\u0006\f\n\u0004\b\b\u0010+\u001a\u0004\b,\u0010-R\u0017\u0010.\u001a\u00020\u00038\u0006¢\u0006\f\n\u0004\b.\u0010/\u001a\u0004\b.\u00100R\u0017\u00101\u001a\u00020\u00038\u0006¢\u0006\f\n\u0004\b1\u0010/\u001a\u0004\b1\u00100R\"\u00102\u001a\u00020\u00038\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b2\u0010/\u001a\u0004\b2\u00100\"\u0004\b3\u00104R$\u00105\u001a\u00020\u00032\u0006\u0010*\u001a\u00020\u00038\u0006@BX\u000e¢\u0006\f\n\u0004\b5\u0010/\u001a\u0004\b5\u00100R\u001d\u00106\u001a\u00020\u00038\u0006¢\u0006\u0012\n\u0004\b6\u0010/\u0012\u0004\b8\u00109\u001a\u0004\b7\u00100R\"\u0010:\u001a\u00020\u00038\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b:\u0010/\u001a\u0004\b:\u00100\"\u0004\b;\u00104R\"\u0010<\u001a\u00020\u00038\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b<\u0010/\u001a\u0004\b<\u00100\"\u0004\b=\u00104R\u001c\u0010>\u001a\u0004\u0018\u00010\u000b8\u0016X\u0004¢\u0006\f\n\u0004\b>\u0010\u001e\u001a\u0004\b?\u0010 R\u001a\u0010A\u001a\u00020@8\u0016X\u0004¢\u0006\f\n\u0004\bA\u0010B\u001a\u0004\bC\u0010DR\u0016\u0010E\u001a\u00020\u00038\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bE\u0010/R\u0016\u0010F\u001a\u00020\u00038\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bF\u0010/R\u0016\u0010G\u001a\u00020\u00038\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bG\u0010/R\u0017\u0010I\u001a\u00020H8\u0006¢\u0006\f\n\u0004\bI\u0010J\u001a\u0004\bK\u0010LR$\u0010N\u001a\u0004\u0018\u00010M8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\bN\u0010O\u001a\u0004\bP\u0010Q\"\u0004\bR\u0010SR$\u0010U\u001a\u00020\u00032\u0006\u0010T\u001a\u00020\u00038F@FX\u000e¢\u0006\f\u001a\u0004\bU\u00100\"\u0004\bV\u00104R*\u0010W\u001a\u00020\u00032\u0006\u0010W\u001a\u00020\u00038F@FX\u000e¢\u0006\u0012\u0012\u0004\bY\u00109\u001a\u0004\bW\u00100\"\u0004\bX\u00104R*\u0010Z\u001a\u00020\u00032\u0006\u0010Z\u001a\u00020\u00038F@FX\u000e¢\u0006\u0012\u0012\u0004\b]\u00109\u001a\u0004\b[\u00100\"\u0004\b\\\u00104R\u0011\u0010^\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b^\u00100R\u0011\u0010_\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b_\u00100¨\u0006l"}, d2 = {"Lcom/appboy/models/cards/Card;", "Lcom/braze/models/IPutIntoJson;", "Lorg/json/JSONObject;", "", "logImpression", "logClick", "Ljava/util/EnumSet;", "Lcom/appboy/enums/CardCategory;", "categories", "isInCategorySet", "forJsonPut", "", "toString", "isValidCard", "", "other", "equals", "", "hashCode", "jsonObject", "Lorg/json/JSONObject;", "Lcom/braze/storage/ICardStorageProvider;", "cardStorage", "Lcom/braze/storage/ICardStorageProvider;", "", "extras", "Ljava/util/Map;", "getExtras", "()Ljava/util/Map;", "id", "Ljava/lang/String;", "getId", "()Ljava/lang/String;", "", "created", "J", "getCreated", "()J", "updated", "getUpdated", "expiresAt", "getExpiresAt", "<set-?>", "Ljava/util/EnumSet;", "getCategories", "()Ljava/util/EnumSet;", "isContentCard", "Z", "()Z", "isRemoved", "isPinned", "setPinned", "(Z)V", "isClicked", "openUriInWebView", "getOpenUriInWebView", "getOpenUriInWebView$annotations", "()V", "isDismissibleByUser", "setDismissibleByUser", "isTest", "setTest", "url", "getUrl", "Lcom/appboy/enums/CardType;", "cardType", "Lcom/appboy/enums/CardType;", "getCardType", "()Lcom/appboy/enums/CardType;", "wasViewedInternal", "isIndicatorHighlightedInternal", "isDismissedInternal", "Lcom/appboy/enums/Channel;", "channel", "Lcom/appboy/enums/Channel;", "getChannel", "()Lcom/appboy/enums/Channel;", "Lcom/appboy/models/cards/ICardListener;", "listener", "Lcom/appboy/models/cards/ICardListener;", "getListener", "()Lcom/appboy/models/cards/ICardListener;", "setListener", "(Lcom/appboy/models/cards/ICardListener;)V", "enabled", "isIndicatorHighlighted", "setIndicatorHighlighted", "isDismissed", "setDismissed", "isDismissed$annotations", "viewed", "getViewed", "setViewed", "getViewed$annotations", "isExpired", "isControl", "Lcom/appboy/enums/CardKey$Provider;", "cardKeysProvider", "Lbo/app/b2;", "brazeManager", "Lbo/app/d2;", "cardAnalytics", "<init>", "(Lorg/json/JSONObject;Lcom/appboy/enums/CardKey$Provider;Lbo/app/b2;Lcom/braze/storage/ICardStorageProvider;Lbo/app/d2;)V", "cardKeyProvider", "(Lorg/json/JSONObject;Lcom/appboy/enums/CardKey$Provider;)V", "Companion", "a", "android-sdk-base_release"}, k = 1, mv = {1, 6, 0})
public class Card implements IPutIntoJson<JSONObject> {
    public static final a Companion = new a((DefaultConstructorMarker) null);
    private static final long DEFAULT_EXPIRES_AT_VALUE = -1;
    private final b2 brazeManager;
    private final d2 cardAnalytics;
    private final ICardStorageProvider<?> cardStorage;
    private final CardType cardType;
    private EnumSet<CardCategory> categories;
    private final Channel channel;
    private final long created;
    private final long expiresAt;
    private final Map<String, String> extras;

    /* renamed from: id  reason: collision with root package name */
    private final String f40732id;
    private boolean isClicked;
    private final boolean isContentCard;
    private boolean isDismissedInternal;
    private boolean isDismissibleByUser;
    private boolean isIndicatorHighlightedInternal;
    private boolean isPinned;
    private final boolean isRemoved;
    private boolean isTest;
    private final JSONObject jsonObject;
    private ICardListener listener;
    private final boolean openUriInWebView;
    private final long updated;
    private final String url;
    private boolean wasViewedInternal;

    @Metadata(bv = {}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002XT¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004¨\u0006\u0007"}, d2 = {"Lcom/appboy/models/cards/Card$a;", "", "", "DEFAULT_EXPIRES_AT_VALUE", "J", "<init>", "()V", "android-sdk-base_release"}, k = 1, mv = {1, 6, 0})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\u0010\u0004\u001a\u00020\u0003\"\u0006\b\u0000\u0010\u0000\u0018\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\n¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"T", "", "it", "", "a", "(I)Ljava/lang/Boolean;", "com/braze/support/JsonUtils$e"}, k = 3, mv = {1, 6, 0})
    public static final class b extends Lambda implements Function1<Integer, Boolean> {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ JSONArray f40733b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(JSONArray jSONArray) {
            super(1);
            this.f40733b = jSONArray;
        }

        public final Boolean a(int i11) {
            return Boolean.valueOf(this.f40733b.opt(i11) instanceof String);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            return a(((Number) obj).intValue());
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0010\u0003\u001a\u00028\u0000\"\u0006\b\u0000\u0010\u0000\u0018\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\n¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"T", "", "it", "a", "(I)Ljava/lang/Object;", "com/braze/support/JsonUtils$f"}, k = 3, mv = {1, 6, 0})
    public static final class c extends Lambda implements Function1<Integer, String> {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ JSONArray f40734b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public c(JSONArray jSONArray) {
            super(1);
            this.f40734b = jSONArray;
        }

        public final String a(int i11) {
            Object obj = this.f40734b.get(i11);
            if (obj != null) {
                return (String) obj;
            }
            throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            return a(((Number) obj).intValue());
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class d extends Lambda implements Function0<String> {

        /* renamed from: b  reason: collision with root package name */
        public static final d f40735b = new d();

        public d() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "Cannot dismiss a card more than once. Doing nothing.";
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class e extends Lambda implements Function0<String> {

        /* renamed from: b  reason: collision with root package name */
        public static final e f40736b = new e();

        public e() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "Failed to log card as dismissed.";
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class f extends Lambda implements Function0<String> {

        /* renamed from: b  reason: collision with root package name */
        public static final f f40737b = new f();

        public f() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "Failed to mark card indicator as highlighted.";
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class g extends Lambda implements Function0<String> {

        /* renamed from: b  reason: collision with root package name */
        public static final g f40738b = new g();

        public g() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "Card ID cannot be null";
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class h extends Lambda implements Function0<String> {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Card f40739b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public h(Card card) {
            super(0);
            this.f40739b = card;
        }

        /* renamed from: a */
        public final String invoke() {
            return Intrinsics.stringPlus("Logged click for card with id: ", this.f40739b.getId());
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class i extends Lambda implements Function0<String> {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Card f40740b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public i(Card card) {
            super(0);
            this.f40740b = card;
        }

        /* renamed from: a */
        public final String invoke() {
            return Intrinsics.stringPlus("Failed to log card clicked for id: ", this.f40740b.getId());
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class j extends Lambda implements Function0<String> {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Card f40741b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public j(Card card) {
            super(0);
            this.f40741b = card;
        }

        /* renamed from: a */
        public final String invoke() {
            return Intrinsics.stringPlus("Failed to log card as clicked for id: ", this.f40741b.getId());
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class k extends Lambda implements Function0<String> {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Card f40742b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public k(Card card) {
            super(0);
            this.f40742b = card;
        }

        /* renamed from: a */
        public final String invoke() {
            return Intrinsics.stringPlus("Logging impression event for card with id: ", this.f40742b.getId());
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class l extends Lambda implements Function0<String> {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Card f40743b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public l(Card card) {
            super(0);
            this.f40743b = card;
        }

        /* renamed from: a */
        public final String invoke() {
            return Intrinsics.stringPlus("Logging control impression event for card with id: ", this.f40743b.getId());
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class m extends Lambda implements Function0<String> {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Card f40744b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public m(Card card) {
            super(0);
            this.f40744b = card;
        }

        /* renamed from: a */
        public final String invoke() {
            return Intrinsics.stringPlus("Failed to log card impression for card id: ", this.f40744b.getId());
        }
    }

    public Card(JSONObject jSONObject, CardKey.Provider provider, b2 b2Var, ICardStorageProvider<?> iCardStorageProvider, d2 d2Var) {
        Intrinsics.checkNotNullParameter(jSONObject, "jsonObject");
        Intrinsics.checkNotNullParameter(provider, "cardKeysProvider");
        this.jsonObject = jSONObject;
        this.brazeManager = b2Var;
        this.cardStorage = iCardStorageProvider;
        this.cardAnalytics = d2Var;
        this.extras = JsonUtils.convertJSONObjectToMap(jSONObject.optJSONObject(provider.getKey(CardKey.EXTRAS)));
        String string = jSONObject.getString(provider.getKey(CardKey.ID));
        Intrinsics.checkNotNullExpressionValue(string, "jsonObject.getString(car…vider.getKey(CardKey.ID))");
        this.f40732id = string;
        this.isContentCard = provider.isContentCardProvider();
        this.cardType = CardType.DEFAULT;
        this.channel = provider.isContentCardProvider() ? Channel.CONTENT_CARD : Channel.NEWS_FEED;
        this.wasViewedInternal = jSONObject.optBoolean(provider.getKey(CardKey.VIEWED));
        this.isDismissedInternal = jSONObject.optBoolean(provider.getKey(CardKey.DISMISSED), false);
        this.isPinned = jSONObject.optBoolean(provider.getKey(CardKey.PINNED), false);
        this.created = jSONObject.getLong(provider.getKey(CardKey.CREATED));
        this.expiresAt = jSONObject.optLong(provider.getKey(CardKey.EXPIRES_AT), -1);
        this.openUriInWebView = jSONObject.optBoolean(provider.getKey(CardKey.OPEN_URI_IN_WEBVIEW), false);
        this.isRemoved = jSONObject.optBoolean(provider.getKey(CardKey.REMOVED), false);
        JSONArray optJSONArray = jSONObject.optJSONArray(provider.getKey(CardKey.CATEGORIES));
        if (optJSONArray == null || optJSONArray.length() == 0) {
            this.categories = EnumSet.of(CardCategory.NO_CATEGORY);
        } else {
            EnumSet<CardCategory> noneOf = EnumSet.noneOf(CardCategory.class);
            for (String str : SequencesKt___SequencesKt.map(SequencesKt___SequencesKt.filter(CollectionsKt___CollectionsKt.asSequence(RangesKt___RangesKt.until(0, optJSONArray.length())), new b(optJSONArray)), new c(optJSONArray))) {
                CardCategory cardCategory = CardCategory.get(str);
                if (cardCategory != null) {
                    noneOf.add(cardCategory);
                }
            }
            this.categories = noneOf;
        }
        this.updated = this.jsonObject.optLong(provider.getKey(CardKey.UPDATED), this.created);
        this.isDismissibleByUser = this.jsonObject.optBoolean(provider.getKey(CardKey.DISMISSIBLE), false);
        this.isIndicatorHighlightedInternal = this.jsonObject.optBoolean(provider.getKey(CardKey.READ), this.wasViewedInternal);
        this.isClicked = this.jsonObject.optBoolean(provider.getKey(CardKey.CLICKED), false);
        this.isTest = this.jsonObject.optBoolean(provider.getKey(CardKey.IS_TEST), false);
    }

    public static /* synthetic */ void getOpenUriInWebView$annotations() {
    }

    public static /* synthetic */ void getViewed$annotations() {
    }

    public static /* synthetic */ void isDismissed$annotations() {
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !Intrinsics.areEqual((Object) getClass(), (Object) obj.getClass())) {
            return false;
        }
        Card card = (Card) obj;
        if (this.updated != card.updated || !Intrinsics.areEqual((Object) this.f40732id, (Object) card.f40732id)) {
            return false;
        }
        return true;
    }

    public CardType getCardType() {
        return this.cardType;
    }

    public final EnumSet<CardCategory> getCategories() {
        return this.categories;
    }

    public final Channel getChannel() {
        return this.channel;
    }

    public final long getCreated() {
        return this.created;
    }

    public final long getExpiresAt() {
        return this.expiresAt;
    }

    public final Map<String, String> getExtras() {
        return this.extras;
    }

    public final String getId() {
        return this.f40732id;
    }

    public final ICardListener getListener() {
        return this.listener;
    }

    public final boolean getOpenUriInWebView() {
        return this.openUriInWebView;
    }

    public final long getUpdated() {
        return this.updated;
    }

    public String getUrl() {
        return this.url;
    }

    public final boolean getViewed() {
        return this.wasViewedInternal;
    }

    public int hashCode() {
        long j11 = this.updated;
        return (this.f40732id.hashCode() * 31) + ((int) (j11 ^ (j11 >>> 32)));
    }

    public final boolean isClicked() {
        return this.isClicked;
    }

    public final boolean isContentCard() {
        return this.isContentCard;
    }

    public final boolean isControl() {
        return getCardType() == CardType.CONTROL;
    }

    public final boolean isDismissed() {
        return this.isDismissedInternal;
    }

    public final boolean isDismissibleByUser() {
        return this.isDismissibleByUser;
    }

    public final boolean isExpired() {
        long j11 = this.expiresAt;
        return j11 != -1 && j11 <= DateTimeUtils.nowInSeconds();
    }

    public final boolean isInCategorySet(EnumSet<CardCategory> enumSet) {
        Intrinsics.checkNotNullParameter(enumSet, "categories");
        EnumSet<CardCategory> enumSet2 = this.categories;
        if (enumSet2 == null) {
            return false;
        }
        Iterator<CardCategory> it = enumSet.iterator();
        while (it.hasNext()) {
            if (enumSet2.contains(it.next())) {
                return true;
            }
        }
        return false;
    }

    public final boolean isIndicatorHighlighted() {
        return this.isIndicatorHighlightedInternal;
    }

    public final boolean isPinned() {
        return this.isPinned;
    }

    public final boolean isRemoved() {
        return this.isRemoved;
    }

    public final boolean isTest() {
        return this.isTest;
    }

    public final boolean isValidCard() {
        if (!StringsKt__StringsJVMKt.isBlank(this.f40732id)) {
            return true;
        }
        BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.W, (Throwable) null, false, (Function0) g.f40738b, 6, (Object) null);
        return false;
    }

    public final boolean logClick() {
        try {
            this.isClicked = true;
            if (this.brazeManager == null || this.cardAnalytics == null || this.cardStorage == null || !isValidCard()) {
                BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.W, (Throwable) null, false, (Function0) new i(this), 6, (Object) null);
                return false;
            }
            x1 a11 = this.cardAnalytics.a(this.f40732id);
            if (a11 != null) {
                this.brazeManager.a(a11);
            }
            this.cardStorage.markCardAsClicked(this.f40732id);
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, false, (Function0) new h(this), 7, (Object) null);
            return true;
        } catch (Exception e11) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.W, (Throwable) e11, false, (Function0) new j(this), 4, (Object) null);
            return false;
        }
    }

    public final boolean logImpression() {
        try {
            if (this.brazeManager == null || this.cardAnalytics == null || this.cardStorage == null || !isValidCard()) {
                return false;
            }
            if (!isControl()) {
                BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.V, (Throwable) null, false, (Function0) new k(this), 6, (Object) null);
                x1 c11 = this.cardAnalytics.c(this.f40732id);
                if (c11 != null) {
                    this.brazeManager.a(c11);
                }
            } else {
                BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.V, (Throwable) null, false, (Function0) new l(this), 6, (Object) null);
                x1 b11 = this.cardAnalytics.b(this.f40732id);
                if (b11 != null) {
                    this.brazeManager.a(b11);
                }
            }
            this.cardStorage.markCardAsViewed(this.f40732id);
            return true;
        } catch (Exception e11) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.W, (Throwable) e11, false, (Function0) new m(this), 4, (Object) null);
            return false;
        }
    }

    public final void setDismissed(boolean z11) {
        if (!this.isDismissedInternal || !z11) {
            this.isDismissedInternal = z11;
            ICardStorageProvider<?> iCardStorageProvider = this.cardStorage;
            if (iCardStorageProvider != null) {
                iCardStorageProvider.markCardAsDismissed(this.f40732id);
            }
            if (z11) {
                try {
                    if (this.brazeManager != null && this.cardAnalytics != null && isValidCard()) {
                        x1 d11 = this.cardAnalytics.d(this.f40732id);
                        if (d11 != null) {
                            this.brazeManager.a(d11);
                        }
                    }
                } catch (Exception e11) {
                    BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.W, (Throwable) e11, false, (Function0) e.f40736b, 4, (Object) null);
                }
            }
        } else {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.W, (Throwable) null, false, (Function0) d.f40735b, 6, (Object) null);
        }
    }

    public final void setDismissibleByUser(boolean z11) {
        this.isDismissibleByUser = z11;
    }

    public final void setIndicatorHighlighted(boolean z11) {
        ICardStorageProvider<?> iCardStorageProvider;
        this.isIndicatorHighlightedInternal = z11;
        try {
            ICardListener iCardListener = this.listener;
            if (iCardListener != null) {
                iCardListener.onCardUpdate();
            }
        } catch (Exception unused) {
        }
        if (z11 && (iCardStorageProvider = this.cardStorage) != null) {
            try {
                iCardStorageProvider.markCardAsVisuallyRead(this.f40732id);
            } catch (Exception e11) {
                BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.D, (Throwable) e11, false, (Function0) f.f40737b, 4, (Object) null);
            }
        }
    }

    public final void setListener(ICardListener iCardListener) {
        this.listener = iCardListener;
    }

    public final void setPinned(boolean z11) {
        this.isPinned = z11;
    }

    public final void setTest(boolean z11) {
        this.isTest = z11;
    }

    public final void setViewed(boolean z11) {
        this.wasViewedInternal = z11;
        ICardStorageProvider<?> iCardStorageProvider = this.cardStorage;
        if (iCardStorageProvider != null) {
            iCardStorageProvider.markCardAsViewed(this.f40732id);
        }
    }

    public String toString() {
        return StringsKt__IndentKt.trimIndent("\n            Card{\n            extras=" + this.extras + "\n            id='" + this.f40732id + "'\n            created=" + this.created + "\n            updated=" + this.updated + "\n            expiresAt=" + this.expiresAt + "\n            categories=" + this.categories + "\n            isContentCard=" + this.isContentCard + "\n            viewed=" + this.wasViewedInternal + "\n            isRead=" + this.isIndicatorHighlightedInternal + "\n            isDismissed=" + this.isDismissedInternal + "\n            isRemoved=" + this.isRemoved + "\n            isPinned=" + this.isPinned + "\n            isClicked=" + this.isClicked + "\n            openUriInWebview=" + this.openUriInWebView + "\n            isDismissibleByUser=" + this.isDismissibleByUser + "\n            isTest=" + this.isTest + "\n            json=" + JsonUtils.getPrettyPrintedString(this.jsonObject) + "\n            }\n\n        ");
    }

    public JSONObject forJsonPut() {
        return this.jsonObject;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public Card(JSONObject jSONObject, CardKey.Provider provider) {
        this(jSONObject, provider, (b2) null, (ICardStorageProvider<?>) null, (d2) null);
        Intrinsics.checkNotNullParameter(jSONObject, "jsonObject");
        Intrinsics.checkNotNullParameter(provider, "cardKeyProvider");
    }
}
