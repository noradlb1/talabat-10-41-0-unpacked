package bo.app;

import android.content.Context;
import android.content.SharedPreferences;
import com.appboy.enums.CardKey;
import com.appboy.models.cards.Card;
import com.braze.events.ContentCardsUpdatedEvent;
import com.braze.storage.ICardStorageProvider;
import com.braze.support.BrazeLogger;
import com.braze.support.DateTimeUtils;
import com.braze.support.StringUtils;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.newrelic.agent.android.instrumentation.JSONObjectInstrumentation;
import com.visa.checkout.Profile;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@Instrumented
@Metadata(bv = {}, d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0010\"\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010#\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001:\u0001\u0012B3\b\u0007\u0012\u0006\u00100\u001a\u00020/\u0012\u0006\u0010\u0011\u001a\u00020\t\u0012\u0006\u00101\u001a\u00020\t\u0012\u0006\u00103\u001a\u000202\u0012\b\b\u0002\u00104\u001a\u00020\t¢\u0006\u0004\b5\u00106J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\b\u001a\u00020\u0007H\u0002J\u0010\u0010\u000b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH\u0016J\u0010\u0010\f\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH\u0016J\u0010\u0010\r\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH\u0016J\u0010\u0010\u000e\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH\u0016J\u001a\u0010\u0012\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0010\u001a\u00020\u000f2\b\u0010\u0011\u001a\u0004\u0018\u00010\tJ\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u0013\u001a\u00020\u0003J\u0010\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u0005H\u0007J\u0010\u0010\u0012\u001a\u00020\u00072\u0006\u0010\u0016\u001a\u00020\u0014H\u0007J \u0010\u0012\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u001a\u001a\u00020\u0019H\u0007J\u0010\u0010\u0012\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u000fH\u0007J\u0012\u0010\u001b\u001a\u0004\u0018\u00010\u00032\u0006\u0010\n\u001a\u00020\tH\u0007J\u001a\u0010\u0012\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0003H\u0007J\u0010\u0010\u0012\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH\u0007J\u0010\u0010\u001c\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH\u0007J\u0010\u0010\u001d\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH\u0007J\u0010\u0010\u001e\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH\u0007J\u0016\u0010\u0006\u001a\u00020\u00072\f\u0010 \u001a\b\u0012\u0004\u0012\u00020\t0\u001fH\u0007J\u0016\u0010\u001c\u001a\u00020\u00072\f\u0010 \u001a\b\u0012\u0004\u0012\u00020\t0\u001fH\u0007J\u0016\u0010\u0012\u001a\u00020\u00072\f\u0010 \u001a\b\u0012\u0004\u0012\u00020\t0\u001fH\u0007J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH\u0007R\u0014\u0010$\u001a\u00020!8BX\u0004¢\u0006\u0006\u001a\u0004\b\"\u0010#R\u0011\u0010%\u001a\u00020!8F¢\u0006\u0006\u001a\u0004\b\u001e\u0010#R\u0011\u0010&\u001a\u00020!8F¢\u0006\u0006\u001a\u0004\b\u001d\u0010#R\u0017\u0010)\u001a\b\u0012\u0004\u0012\u00020\t0'8G¢\u0006\u0006\u001a\u0004\b\u001c\u0010(R\u0017\u0010+\u001a\b\u0012\u0004\u0012\u00020\t0'8G¢\u0006\u0006\u001a\u0004\b*\u0010(R\u0017\u0010,\u001a\b\u0012\u0004\u0012\u00020\t0'8G¢\u0006\u0006\u001a\u0004\b\u001b\u0010(R\u0014\u0010.\u001a\u00020\u00028VX\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010-¨\u00067"}, d2 = {"Lbo/app/a0;", "Lcom/braze/storage/ICardStorageProvider;", "Lcom/braze/events/ContentCardsUpdatedEvent;", "Lorg/json/JSONObject;", "serverCardJson", "", "b", "", "i", "", "cardId", "markCardAsVisuallyRead", "markCardAsViewed", "markCardAsClicked", "markCardAsDismissed", "Lbo/app/z;", "contentCardsResponse", "userId", "a", "cardJson", "Lcom/appboy/models/cards/Card;", "isFromOfflineStorage", "card", "Lcom/appboy/enums/CardKey;", "cardKey", "", "value", "d", "c", "f", "e", "", "cardIdsToRetain", "", "g", "()J", "localStorageLastUpdatedTime", "lastCardUpdatedAt", "lastFullSyncAt", "", "()Ljava/util/Set;", "dismissedCardIdSet", "h", "testCardIdSet", "expiredCardIdSet", "()Lcom/braze/events/ContentCardsUpdatedEvent;", "cachedCardsAsEvent", "Landroid/content/Context;", "context", "apiKey", "Lbo/app/b2;", "brazeManager", "currentSdkVersion", "<init>", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Lbo/app/b2;Ljava/lang/String;)V", "android-sdk-base_release"}, k = 1, mv = {1, 6, 0})
public final class a0 implements ICardStorageProvider<ContentCardsUpdatedEvent> {

    /* renamed from: f  reason: collision with root package name */
    public static final a f38222f = new a((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public static final Set<String> f38223g = SetsKt__SetsKt.setOf(CardKey.VIEWED.getContentCardsKey(), CardKey.DISMISSED.getContentCardsKey());
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final String f38224a;

    /* renamed from: b  reason: collision with root package name */
    private final b2 f38225b;

    /* renamed from: c  reason: collision with root package name */
    private final SharedPreferences f38226c;

    /* renamed from: d  reason: collision with root package name */
    private final SharedPreferences f38227d;

    /* renamed from: e  reason: collision with root package name */
    private final d2 f38228e;

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class b extends Lambda implements Function0<String> {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ String f38229b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(String str) {
            super(0);
            this.f38229b = str;
        }

        /* renamed from: a */
        public final String invoke() {
            return Intrinsics.stringPlus("Adding card to test cache: ", this.f38229b);
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class c extends Lambda implements Function0<String> {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ String f38230b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public c(String str) {
            super(0);
            this.f38230b = str;
        }

        /* renamed from: a */
        public final String invoke() {
            return Intrinsics.stringPlus("Deleting expired card from storage with id: ", this.f38230b);
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class d extends Lambda implements Function0<String> {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ String f38231b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public d(String str) {
            super(0);
            this.f38231b = str;
        }

        /* renamed from: a */
        public final String invoke() {
            return Intrinsics.stringPlus("Card not present in storage for id: ", this.f38231b);
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class e extends Lambda implements Function0<String> {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ String f38232b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public e(String str) {
            super(0);
            this.f38232b = str;
        }

        /* renamed from: a */
        public final String invoke() {
            return Intrinsics.stringPlus("Failed to read card json from storage. Json: ", this.f38232b);
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class f extends Lambda implements Function0<String> {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ String f38233b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public f(String str) {
            super(0);
            this.f38233b = str;
        }

        /* renamed from: a */
        public final String invoke() {
            return Intrinsics.stringPlus("Removing card from test cache: ", this.f38233b);
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class g extends Lambda implements Function0<String> {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ String f38234b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public g(String str) {
            super(0);
            this.f38234b = str;
        }

        /* renamed from: a */
        public final String invoke() {
            return Intrinsics.stringPlus("Removing card from storage with id: ", this.f38234b);
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class h extends Lambda implements Function0<String> {

        /* renamed from: b  reason: collision with root package name */
        public static final h f38235b = new h();

        public h() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "The server card received is older than the cached card. Discarding the server card.";
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class i extends Lambda implements Function0<String> {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ JSONObject f38236b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public i(JSONObject jSONObject) {
            super(0);
            this.f38236b = jSONObject;
        }

        /* renamed from: a */
        public final String invoke() {
            return Intrinsics.stringPlus("Server card json: ", this.f38236b);
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class j extends Lambda implements Function0<String> {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ JSONObject f38237b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public j(JSONObject jSONObject) {
            super(0);
            this.f38237b = jSONObject;
        }

        /* renamed from: a */
        public final String invoke() {
            return Intrinsics.stringPlus("Cached card json: ", this.f38237b);
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class k extends Lambda implements Function0<String> {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ String f38238b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public k(String str) {
            super(0);
            this.f38238b = str;
        }

        /* renamed from: a */
        public final String invoke() {
            return Intrinsics.stringPlus("Server card is marked as removed. Removing from card storage with id: ", this.f38238b);
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class l extends Lambda implements Function0<String> {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ JSONObject f38239b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public l(JSONObject jSONObject) {
            super(0);
            this.f38239b = jSONObject;
        }

        /* renamed from: a */
        public final String invoke() {
            return Intrinsics.stringPlus("Server card was locally dismissed already. Not adding card to storage. Server card: ", this.f38239b);
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class m extends Lambda implements Function0<String> {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ JSONObject f38240b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public m(JSONObject jSONObject) {
            super(0);
            this.f38240b = jSONObject;
        }

        /* renamed from: a */
        public final String invoke() {
            return Intrinsics.stringPlus("Server card has expired already. Not adding card to storage. Server card: ", this.f38240b);
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class n extends Lambda implements Function0<String> {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ String f38241b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public n(String str) {
            super(0);
            this.f38241b = str;
        }

        /* renamed from: a */
        public final String invoke() {
            return Intrinsics.stringPlus("Server card is marked as dismissed. Adding to dismissed cached and removing from card storage with id: ", this.f38241b);
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class o extends Lambda implements Function0<String> {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ String f38242b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public o(String str) {
            super(0);
            this.f38242b = str;
        }

        /* renamed from: a */
        public final String invoke() {
            return Intrinsics.stringPlus("Can't update card field. Json cannot be parsed from disk or is not present. Id: ", this.f38242b);
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class p extends Lambda implements Function0<String> {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Object f38243b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ CardKey f38244c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public p(Object obj, CardKey cardKey) {
            super(0);
            this.f38243b = obj;
            this.f38244c = cardKey;
        }

        /* renamed from: a */
        public final String invoke() {
            return "Failed to update card json field to " + this.f38243b + " with key: " + this.f38244c;
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\u0010\u0004\u001a\u00020\u0003\"\u0006\b\u0000\u0010\u0000\u0018\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\n¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"T", "", "it", "", "a", "(I)Ljava/lang/Boolean;", "com/braze/support/JsonUtils$e"}, k = 3, mv = {1, 6, 0})
    public static final class q extends Lambda implements Function1<Integer, Boolean> {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ JSONArray f38245b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public q(JSONArray jSONArray) {
            super(1);
            this.f38245b = jSONArray;
        }

        public final Boolean a(int i11) {
            return Boolean.valueOf(this.f38245b.opt(i11) instanceof JSONObject);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            return a(((Number) obj).intValue());
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0010\u0003\u001a\u00028\u0000\"\u0006\b\u0000\u0010\u0000\u0018\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\n¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"T", "", "it", "a", "(I)Ljava/lang/Object;", "com/braze/support/JsonUtils$f"}, k = 3, mv = {1, 6, 0})
    public static final class r extends Lambda implements Function1<Integer, JSONObject> {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ JSONArray f38246b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public r(JSONArray jSONArray) {
            super(1);
            this.f38246b = jSONArray;
        }

        public final JSONObject a(int i11) {
            Object obj = this.f38246b.get(i11);
            if (obj != null) {
                return (JSONObject) obj;
            }
            throw new NullPointerException("null cannot be cast to non-null type org.json.JSONObject");
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            return a(((Number) obj).intValue());
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class s extends Lambda implements Function0<String> {

        /* renamed from: b  reason: collision with root package name */
        public static final s f38247b = new s();

        public s() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "Input user id was null. Defaulting to the empty user id";
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class t extends Lambda implements Function0<String> {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Ref.ObjectRef<String> f38248b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ a0 f38249c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public t(Ref.ObjectRef<String> objectRef, a0 a0Var) {
            super(0);
            this.f38248b = objectRef;
            this.f38249c = a0Var;
        }

        /* renamed from: a */
        public final String invoke() {
            return "The received cards are for user " + this.f38248b.element + " and the current user is " + this.f38249c.f38224a + " , the cards will be discarded and no changes will be made.";
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class u extends Lambda implements Function0<String> {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Ref.ObjectRef<String> f38250b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public u(Ref.ObjectRef<String> objectRef) {
            super(0);
            this.f38250b = objectRef;
        }

        /* renamed from: a */
        public final String invoke() {
            return Intrinsics.stringPlus("Updating offline Content Cards for user with id: ", this.f38250b.element);
        }
    }

    public a0(Context context, String str, String str2, b2 b2Var, String str3) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(str, "userId");
        Intrinsics.checkNotNullParameter(str2, Profile.API_KEY);
        Intrinsics.checkNotNullParameter(b2Var, "brazeManager");
        Intrinsics.checkNotNullParameter(str3, "currentSdkVersion");
        this.f38224a = str;
        this.f38225b = b2Var;
        String cacheFileSuffix = StringUtils.getCacheFileSuffix(context, str, str2);
        this.f38227d = q5.a(context, Intrinsics.stringPlus("com.braze.storage.content_cards_storage_provider.metadata", cacheFileSuffix), str3);
        SharedPreferences sharedPreferences = context.getSharedPreferences(Intrinsics.stringPlus("com.appboy.storage.content_cards_storage_provider.cards", cacheFileSuffix), 0);
        Intrinsics.checkNotNullExpressionValue(sharedPreferences, "context.getSharedPrefere…ix, Context.MODE_PRIVATE)");
        this.f38226c = sharedPreferences;
        this.f38228e = new y();
    }

    private final long g() {
        return this.f38227d.getLong("last_storage_update_timestamp", 0);
    }

    private final void i() {
        this.f38227d.edit().putLong("last_storage_update_timestamp", DateTimeUtils.nowInSeconds()).apply();
    }

    /* renamed from: b */
    public ContentCardsUpdatedEvent getCachedCardsAsEvent() {
        return a(true);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0010, code lost:
        r0 = kotlin.collections.CollectionsKt___CollectionsKt.filterNotNull(r0);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.util.Set<java.lang.String> c() {
        /*
            r3 = this;
            android.content.SharedPreferences r0 = r3.f38227d
            java.util.HashSet r1 = new java.util.HashSet
            r1.<init>()
            java.lang.String r2 = "dismissed"
            java.util.Set r0 = r0.getStringSet(r2, r1)
            if (r0 != 0) goto L_0x0010
            goto L_0x0016
        L_0x0010:
            java.util.List r0 = kotlin.collections.CollectionsKt___CollectionsKt.filterNotNull(r0)
            if (r0 != 0) goto L_0x0018
        L_0x0016:
            r0 = 0
            goto L_0x001c
        L_0x0018:
            java.util.Set r0 = kotlin.collections.CollectionsKt___CollectionsKt.toMutableSet(r0)
        L_0x001c:
            if (r0 != 0) goto L_0x0026
            java.util.Set r0 = kotlin.collections.SetsKt__SetsKt.emptySet()
            java.util.Set r0 = kotlin.collections.CollectionsKt___CollectionsKt.toMutableSet(r0)
        L_0x0026:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: bo.app.a0.c():java.util.Set");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0010, code lost:
        r0 = kotlin.collections.CollectionsKt___CollectionsKt.filterNotNull(r0);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.util.Set<java.lang.String> d() {
        /*
            r3 = this;
            android.content.SharedPreferences r0 = r3.f38227d
            java.util.HashSet r1 = new java.util.HashSet
            r1.<init>()
            java.lang.String r2 = "expired"
            java.util.Set r0 = r0.getStringSet(r2, r1)
            if (r0 != 0) goto L_0x0010
            goto L_0x0016
        L_0x0010:
            java.util.List r0 = kotlin.collections.CollectionsKt___CollectionsKt.filterNotNull(r0)
            if (r0 != 0) goto L_0x0018
        L_0x0016:
            r0 = 0
            goto L_0x001c
        L_0x0018:
            java.util.Set r0 = kotlin.collections.CollectionsKt___CollectionsKt.toMutableSet(r0)
        L_0x001c:
            if (r0 != 0) goto L_0x0026
            java.util.Set r0 = kotlin.collections.SetsKt__SetsKt.emptySet()
            java.util.Set r0 = kotlin.collections.CollectionsKt___CollectionsKt.toMutableSet(r0)
        L_0x0026:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: bo.app.a0.d():java.util.Set");
    }

    public final long e() {
        return this.f38227d.getLong("last_card_updated_at", 0);
    }

    public final long f() {
        return this.f38227d.getLong("last_full_sync_at", 0);
    }

    public final Set<String> h() {
        Set<String> set;
        List filterNotNull;
        Set<String> stringSet = this.f38227d.getStringSet("test", new HashSet());
        if (stringSet == null || (filterNotNull = CollectionsKt___CollectionsKt.filterNotNull(stringSet)) == null) {
            set = null;
        } else {
            set = CollectionsKt___CollectionsKt.toMutableSet(filterNotNull);
        }
        if (set == null) {
            return CollectionsKt___CollectionsKt.toMutableSet(SetsKt__SetsKt.emptySet());
        }
        return set;
    }

    public void markCardAsClicked(String str) {
        Intrinsics.checkNotNullParameter(str, "cardId");
        a(str, CardKey.CLICKED, Boolean.TRUE);
    }

    public void markCardAsDismissed(String str) {
        Intrinsics.checkNotNullParameter(str, "cardId");
        a(str);
        a(str, (JSONObject) null);
    }

    public void markCardAsViewed(String str) {
        Intrinsics.checkNotNullParameter(str, "cardId");
        a(str, CardKey.VIEWED, Boolean.TRUE);
    }

    public void markCardAsVisuallyRead(String str) {
        Intrinsics.checkNotNullParameter(str, "cardId");
        a(str, CardKey.READ, Boolean.TRUE);
    }

    private final boolean b(JSONObject jSONObject) {
        Set<String> c11 = c();
        Set<String> d11 = d();
        String string = jSONObject.getString(CardKey.ID.getContentCardsKey());
        Intrinsics.checkNotNullExpressionValue(string, "serverCardId");
        JSONObject d12 = d(string);
        a aVar = f38222f;
        if (aVar.b(d12, jSONObject)) {
            BrazeLogger brazeLogger = BrazeLogger.INSTANCE;
            BrazeLogger.brazelog$default(brazeLogger, (Object) this, BrazeLogger.Priority.I, (Throwable) null, false, (Function0) h.f38235b, 6, (Object) null);
            BrazeLogger.brazelog$default(brazeLogger, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, false, (Function0) new i(jSONObject), 7, (Object) null);
            BrazeLogger.brazelog$default(brazeLogger, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, false, (Function0) new j(jSONObject), 7, (Object) null);
            return false;
        } else if (aVar.a(jSONObject, CardKey.REMOVED)) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, false, (Function0) new k(string), 7, (Object) null);
            e(string);
            f(string);
            a(string, (JSONObject) null);
            return true;
        } else if (c11.contains(string)) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, false, (Function0) new l(jSONObject), 7, (Object) null);
            return true;
        } else if (d11.contains(string)) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, false, (Function0) new m(jSONObject), 7, (Object) null);
            return true;
        } else if (aVar.a(jSONObject, CardKey.DISMISSED)) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, false, (Function0) new n(string), 7, (Object) null);
            a(string);
            a(string, (JSONObject) null);
            return true;
        } else {
            a(string, aVar.a(d12, jSONObject));
            if (aVar.a(jSONObject, CardKey.IS_TEST)) {
                c(string);
            }
            return true;
        }
    }

    public final void e(String str) {
        Intrinsics.checkNotNullParameter(str, "cardId");
        Set<String> c11 = c();
        c11.remove(str);
        this.f38227d.edit().putStringSet("dismissed", c11).apply();
    }

    public final void f(String str) {
        Intrinsics.checkNotNullParameter(str, "cardId");
        BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.V, (Throwable) null, false, (Function0) new f(str), 6, (Object) null);
        Set<String> h11 = h();
        h11.remove(str);
        this.f38227d.edit().putStringSet("test", h11).apply();
    }

    public final ContentCardsUpdatedEvent a(z zVar, String str) {
        Intrinsics.checkNotNullParameter(zVar, "contentCardsResponse");
        Ref.ObjectRef objectRef = new Ref.ObjectRef();
        objectRef.element = str;
        if (str == null) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, false, (Function0) s.f38247b, 7, (Object) null);
            objectRef.element = "";
        }
        if (!Intrinsics.areEqual((Object) this.f38224a, (Object) objectRef.element)) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.I, (Throwable) null, false, (Function0) new t(objectRef, this), 6, (Object) null);
            return null;
        }
        BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.I, (Throwable) null, false, (Function0) new u(objectRef), 6, (Object) null);
        a(zVar);
        i();
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        JSONArray a11 = zVar.a();
        if (!(a11 == null || a11.length() == 0)) {
            for (JSONObject jSONObject : SequencesKt___SequencesKt.map(SequencesKt___SequencesKt.filter(CollectionsKt___CollectionsKt.asSequence(RangesKt___RangesKt.until(0, a11.length())), new q(a11)), new r(a11))) {
                if (b(jSONObject)) {
                    String string = jSONObject.getString(CardKey.ID.getContentCardsKey());
                    Intrinsics.checkNotNullExpressionValue(string, "serverCardJson.getString…rdKey.ID.contentCardsKey)");
                    linkedHashSet.add(string);
                }
            }
        }
        if (zVar.d()) {
            b((Set<String>) linkedHashSet);
            c((Set<String>) linkedHashSet);
            linkedHashSet.addAll(h());
            a((Set<String>) linkedHashSet);
        }
        return a(false);
    }

    public final void c(String str) {
        Intrinsics.checkNotNullParameter(str, "cardId");
        BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.V, (Throwable) null, false, (Function0) new b(str), 6, (Object) null);
        Set<String> h11 = h();
        h11.add(str);
        this.f38227d.edit().putStringSet("test", h11).apply();
    }

    public final JSONObject d(String str) {
        Intrinsics.checkNotNullParameter(str, "cardId");
        String string = this.f38226c.getString(str, (String) null);
        if (string == null) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, false, (Function0) new d(str), 7, (Object) null);
            return null;
        }
        try {
            return new JSONObject(string);
        } catch (JSONException e11) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.E, (Throwable) e11, false, (Function0) new e(string), 4, (Object) null);
            return null;
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ a0(Context context, String str, String str2, b2 b2Var, String str3, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, str, str2, b2Var, (i11 & 16) != 0 ? "23.3.0" : str3);
    }

    public final void c(Set<String> set) {
        Intrinsics.checkNotNullParameter(set, "cardIdsToRetain");
        Set<String> d11 = d();
        d11.retainAll(set);
        this.f38227d.edit().putStringSet("expired", d11).apply();
    }

    @Metadata(bv = {}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\"\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0019\u0010\u001aJ\u001a\u0010\u0006\u001a\u00020\u00052\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0007J\u001a\u0010\u0007\u001a\u00020\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0007J\u0018\u0010\u0007\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\tH\u0007R\u0014\u0010\f\u001a\u00020\u000b8\u0002XT¢\u0006\u0006\n\u0004\b\f\u0010\rR\u0014\u0010\u000e\u001a\u00020\u000b8\u0002XT¢\u0006\u0006\n\u0004\b\u000e\u0010\rR\u0014\u0010\u000f\u001a\u00020\u000b8\u0002XT¢\u0006\u0006\n\u0004\b\u000f\u0010\rR\u0014\u0010\u0010\u001a\u00020\u000b8\u0002XT¢\u0006\u0006\n\u0004\b\u0010\u0010\rR\u0014\u0010\u0011\u001a\u00020\u000b8\u0002XT¢\u0006\u0006\n\u0004\b\u0011\u0010\rR\u0014\u0010\u0012\u001a\u00020\u000b8\u0002XT¢\u0006\u0006\n\u0004\b\u0012\u0010\rR\u0014\u0010\u0013\u001a\u00020\u000b8\u0002XT¢\u0006\u0006\n\u0004\b\u0013\u0010\rR\u0014\u0010\u0014\u001a\u00020\u000b8\u0002XT¢\u0006\u0006\n\u0004\b\u0014\u0010\rR\u0014\u0010\u0015\u001a\u00020\u000b8\u0002XT¢\u0006\u0006\n\u0004\b\u0015\u0010\rR\u001a\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00168\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018¨\u0006\u001b"}, d2 = {"Lbo/app/a0$a;", "", "Lorg/json/JSONObject;", "cachedCard", "serverCard", "", "b", "a", "json", "Lcom/appboy/enums/CardKey;", "cardKey", "", "CARD_CACHE_FILE_NAME", "Ljava/lang/String;", "DISMISSALS_KEY", "EXPIRED_CARDS_KEY", "LAST_ACCESSED_SDK_VERSION", "LAST_CARD_UPDATED_AT_KEY", "LAST_FULL_SYNC_AT_KEY", "METADATA_CACHE_FILE_NAME", "STORAGE_LAST_UPDATED_TIMESTAMP_KEY", "TEST_CARDS_KEY", "", "localStateMergeKeys", "Ljava/util/Set;", "<init>", "()V", "android-sdk-base_release"}, k = 1, mv = {1, 6, 0})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public final JSONObject a(JSONObject jSONObject, JSONObject jSONObject2) {
            Intrinsics.checkNotNullParameter(jSONObject2, "serverCard");
            if (jSONObject == null) {
                return jSONObject2;
            }
            JSONObject jSONObject3 = new JSONObject();
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                jSONObject3.put(next, jSONObject.get(next));
            }
            Iterator<String> keys2 = jSONObject2.keys();
            while (keys2.hasNext()) {
                String next2 = keys2.next();
                if (a0.f38223g.contains(next2)) {
                    jSONObject3.put(next2, jSONObject.getBoolean(next2) || jSONObject2.getBoolean(next2));
                } else {
                    jSONObject3.put(next2, jSONObject2.get(next2));
                }
            }
            return jSONObject3;
        }

        @JvmStatic
        public final boolean b(JSONObject jSONObject, JSONObject jSONObject2) {
            Intrinsics.checkNotNullParameter(jSONObject2, "serverCard");
            if (jSONObject == null) {
                return false;
            }
            String contentCardsKey = CardKey.CREATED.getContentCardsKey();
            if (!jSONObject.has(contentCardsKey) || !jSONObject2.has(contentCardsKey) || jSONObject.getLong(contentCardsKey) <= jSONObject2.getLong(contentCardsKey)) {
                return false;
            }
            return true;
        }

        @JvmStatic
        public final boolean a(JSONObject jSONObject, CardKey cardKey) {
            Intrinsics.checkNotNullParameter(jSONObject, "json");
            Intrinsics.checkNotNullParameter(cardKey, "cardKey");
            String contentCardsKey = cardKey.getContentCardsKey();
            if (jSONObject.has(contentCardsKey)) {
                return jSONObject.getBoolean(contentCardsKey);
            }
            return false;
        }
    }

    public final void b(Set<String> set) {
        Intrinsics.checkNotNullParameter(set, "cardIdsToRetain");
        Set<String> c11 = c();
        c11.retainAll(set);
        this.f38227d.edit().putStringSet("dismissed", c11).apply();
    }

    public final Card a(JSONObject jSONObject) {
        Intrinsics.checkNotNullParameter(jSONObject, "cardJson");
        return u.a(jSONObject, CardKey.Provider.CONTENT_CARDS, this.f38225b, (ICardStorageProvider<?>) this, this.f38228e);
    }

    public final ContentCardsUpdatedEvent a(boolean z11) {
        CardKey.Provider provider = CardKey.Provider.CONTENT_CARDS;
        Map<String, ?> all = this.f38226c.getAll();
        JSONArray jSONArray = new JSONArray();
        Iterator<?> it = all.values().iterator();
        while (it.hasNext()) {
            jSONArray.put((Object) (String) it.next());
        }
        List<Card> a11 = u.a(jSONArray, provider, this.f38225b, (ICardStorageProvider<?>) this, this.f38228e);
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (T next : a11) {
            if (((Card) next).isExpired()) {
                arrayList.add(next);
            } else {
                arrayList2.add(next);
            }
        }
        Pair pair = new Pair(arrayList, arrayList2);
        List list = (List) pair.component2();
        for (Card a12 : (List) pair.component1()) {
            a(a12);
        }
        return new ContentCardsUpdatedEvent(list, this.f38224a, g(), z11);
    }

    public final void b(String str) {
        Intrinsics.checkNotNullParameter(str, "cardId");
        Set<String> d11 = d();
        d11.add(str);
        this.f38227d.edit().putStringSet("expired", d11).apply();
    }

    public final void a(Card card) {
        Intrinsics.checkNotNullParameter(card, "card");
        String id2 = card.getId();
        BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, false, (Function0) new c(id2), 7, (Object) null);
        a(id2, (JSONObject) null);
        b(id2);
        f(id2);
    }

    public final void a(String str, CardKey cardKey, Object obj) {
        Intrinsics.checkNotNullParameter(str, "cardId");
        Intrinsics.checkNotNullParameter(cardKey, "cardKey");
        Intrinsics.checkNotNullParameter(obj, "value");
        JSONObject d11 = d(str);
        if (d11 == null) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, false, (Function0) new o(str), 7, (Object) null);
            return;
        }
        try {
            d11.put(cardKey.getContentCardsKey(), obj);
            a(str, d11);
        } catch (JSONException e11) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.E, (Throwable) e11, false, (Function0) new p(obj, cardKey), 4, (Object) null);
        }
    }

    public final void a(z zVar) {
        Intrinsics.checkNotNullParameter(zVar, "contentCardsResponse");
        SharedPreferences.Editor edit = this.f38227d.edit();
        if (zVar.b() != -1) {
            edit.putLong("last_card_updated_at", zVar.b());
        }
        if (zVar.c() != -1) {
            edit.putLong("last_full_sync_at", zVar.c());
        }
        edit.apply();
    }

    public final void a(String str, JSONObject jSONObject) {
        Intrinsics.checkNotNullParameter(str, "cardId");
        SharedPreferences.Editor edit = this.f38226c.edit();
        if (jSONObject != null) {
            edit.putString(str, JSONObjectInstrumentation.toString(jSONObject));
        } else {
            edit.remove(str);
        }
        edit.apply();
    }

    public final void a(String str) {
        Intrinsics.checkNotNullParameter(str, "cardId");
        Set<String> c11 = c();
        c11.add(str);
        this.f38227d.edit().putStringSet("dismissed", c11).apply();
    }

    public final void a(Set<String> set) {
        Intrinsics.checkNotNullParameter(set, "cardIdsToRetain");
        Set<String> keySet = this.f38226c.getAll().keySet();
        SharedPreferences.Editor edit = this.f38226c.edit();
        for (String next : keySet) {
            if (!set.contains(next)) {
                BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, false, (Function0) new g(next), 7, (Object) null);
                edit.remove(next);
            }
        }
        edit.apply();
    }
}
