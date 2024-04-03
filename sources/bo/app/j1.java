package bo.app;

import android.content.Context;
import android.content.SharedPreferences;
import com.appboy.enums.CardKey;
import com.appboy.events.FeedUpdatedEvent;
import com.appboy.models.cards.Card;
import com.braze.storage.ICardStorageProvider;
import com.braze.support.BrazeLogger;
import com.braze.support.DateTimeUtils;
import com.braze.support.StringUtils;
import com.deliveryhero.chatsdk.util.PushNotificationParser;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.newrelic.agent.android.instrumentation.JSONArrayInstrumentation;
import datamodels.TypesAliasesKt;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentSkipListSet;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import okhttp3.HttpUrl;
import org.json.JSONArray;
import org.json.JSONObject;

@Instrumented
@Metadata(bv = {}, d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010#\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\"\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u000b\u001fB!\u0012\u0006\u0010\u001a\u001a\u00020\u0019\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u001c\u001a\u00020\u001b¢\u0006\u0004\b\u001d\u0010\u001eJ*\u0010\u000b\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH\u0002J\u0016\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00050\u000e2\u0006\u0010\r\u001a\u00020\fH\u0002J\u0018\u0010\u000b\u001a\u00020\u000f2\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\tH\u0002J\u0012\u0010\u000b\u001a\u00020\u000f2\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0002J\u0010\u0010\u0011\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0005H\u0016J\u0010\u0010\u0012\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0005H\u0016J\u0010\u0010\u0013\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0005H\u0016J\u0010\u0010\u0014\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0005H\u0016J\u001a\u0010\u000b\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0004\u001a\u00020\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005J\u001c\u0010\u000b\u001a\u00020\u000f2\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00050\u00152\u0006\u0010\r\u001a\u00020\fR\u0014\u0010\u0018\u001a\u00020\u00028VX\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\u0017¨\u0006 "}, d2 = {"Lbo/app/j1;", "Lcom/braze/storage/ICardStorageProvider;", "Lcom/appboy/events/FeedUpdatedEvent;", "Lorg/json/JSONArray;", "cardsArray", "", "userId", "", "isFromOfflineStorage", "", "cardsTimestamp", "a", "Lbo/app/j1$a;", "property", "", "", "cardId", "markCardAsVisuallyRead", "markCardAsViewed", "markCardAsDismissed", "markCardAsClicked", "", "cardIds", "()Lcom/appboy/events/FeedUpdatedEvent;", "cachedCardsAsEvent", "Landroid/content/Context;", "context", "Lbo/app/b2;", "brazeManager", "<init>", "(Landroid/content/Context;Ljava/lang/String;Lbo/app/b2;)V", "b", "android-sdk-base_release"}, k = 1, mv = {1, 6, 0})
public final class j1 implements ICardStorageProvider<FeedUpdatedEvent> {

    /* renamed from: f  reason: collision with root package name */
    public static final b f38740f = new b((DefaultConstructorMarker) null);

    /* renamed from: a  reason: collision with root package name */
    private final b2 f38741a;

    /* renamed from: b  reason: collision with root package name */
    private final SharedPreferences f38742b;

    /* renamed from: c  reason: collision with root package name */
    private final Set<String> f38743c;

    /* renamed from: d  reason: collision with root package name */
    private final Set<String> f38744d;

    /* renamed from: e  reason: collision with root package name */
    private final d2 f38745e = new i1();

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\t\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0019\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\t\u0010\nR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0017\u0010\u0007\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006¨\u0006\u000b"}, d2 = {"Lbo/app/j1$a;", "", "", "setKey", "Ljava/lang/String;", "c", "()Ljava/lang/String;", "flatKey", "b", "<init>", "(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;)V", "android-sdk-base_release"}, k = 1, mv = {1, 6, 0})
    public enum a {
        READ_CARDS("read_cards_set", "read_cards_flat"),
        VIEWED_CARDS("viewed_cards_set", "viewed_cards_flat");
        

        /* renamed from: b  reason: collision with root package name */
        private final String f38749b;

        /* renamed from: c  reason: collision with root package name */
        private final String f38750c;

        private a(String str, String str2) {
            this.f38749b = str;
            this.f38750c = str2;
        }

        public final String b() {
            return this.f38750c;
        }

        public final String c() {
            return this.f38749b;
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class c extends Lambda implements Function0<String> {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ String f38751b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public c(String str) {
            super(0);
            this.f38751b = str;
        }

        /* renamed from: a */
        public final String invoke() {
            return Intrinsics.stringPlus("Updating offline feed for user with id: ", this.f38751b);
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class d extends Lambda implements Function0<String> {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ String f38752b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ String f38753c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public d(String str, String str2) {
            super(0);
            this.f38752b = str;
            this.f38753c = str2;
        }

        /* renamed from: a */
        public final String invoke() {
            return "The received cards are for user " + this.f38752b + " and the current user is " + this.f38753c + ", the cards will be discarded and no changes will be made.";
        }
    }

    public j1(Context context, String str, b2 b2Var) {
        String str2;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(b2Var, "brazeManager");
        this.f38741a = b2Var;
        if (str == null) {
            str2 = "";
        } else {
            str2 = str;
        }
        SharedPreferences sharedPreferences = context.getSharedPreferences(Intrinsics.stringPlus("com.appboy.storage.feedstorageprovider", StringUtils.getCacheFileSuffix(context, str2)), 0);
        Intrinsics.checkNotNullExpressionValue(sharedPreferences, "context.getSharedPrefere…Id, Context.MODE_PRIVATE)");
        this.f38742b = sharedPreferences;
        this.f38743c = a(a.VIEWED_CARDS);
        this.f38744d = a(a.READ_CARDS);
        a(str);
    }

    /* renamed from: a */
    public FeedUpdatedEvent getCachedCardsAsEvent() {
        return a(new JSONArray(this.f38742b.getString("cards", HttpUrl.PATH_SEGMENT_ENCODE_SET_URI)), this.f38742b.getString(PushNotificationParser.PUSH_ID_KEY, ""), true, this.f38742b.getLong("cards_timestamp", -1));
    }

    public void markCardAsClicked(String str) {
        Intrinsics.checkNotNullParameter(str, "cardId");
    }

    public void markCardAsDismissed(String str) {
        Intrinsics.checkNotNullParameter(str, "cardId");
    }

    public void markCardAsViewed(String str) {
        Intrinsics.checkNotNullParameter(str, "cardId");
        if (!this.f38743c.contains(str)) {
            this.f38743c.add(str);
            a(this.f38743c, a.VIEWED_CARDS);
        }
    }

    public void markCardAsVisuallyRead(String str) {
        Intrinsics.checkNotNullParameter(str, "cardId");
        if (!this.f38744d.contains(str)) {
            this.f38744d.add(str);
            a(this.f38744d, a.READ_CARDS);
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010#\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\b\r\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0013\u0010\u0014J\u0016\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007J\u0016\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0007R\u0014\u0010\t\u001a\u00020\u00028\u0002XT¢\u0006\u0006\n\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\u00020\u00028\u0002XT¢\u0006\u0006\n\u0004\b\u000b\u0010\nR\u0014\u0010\f\u001a\u00020\u00028\u0002XT¢\u0006\u0006\n\u0004\b\f\u0010\nR\u0014\u0010\r\u001a\u00020\u00028\u0002XT¢\u0006\u0006\n\u0004\b\r\u0010\nR\u0014\u0010\u000e\u001a\u00020\u00028\u0002XT¢\u0006\u0006\n\u0004\b\u000e\u0010\nR\u0014\u0010\u000f\u001a\u00020\u00028\u0002XT¢\u0006\u0006\n\u0004\b\u000f\u0010\nR\u0014\u0010\u0010\u001a\u00020\u00028\u0002XT¢\u0006\u0006\n\u0004\b\u0010\u0010\nR\u0014\u0010\u0011\u001a\u00020\u00028\u0002XT¢\u0006\u0006\n\u0004\b\u0011\u0010\nR\u0014\u0010\u0012\u001a\u00020\u00028\u0002XT¢\u0006\u0006\n\u0004\b\u0012\u0010\n¨\u0006\u0015"}, d2 = {"Lbo/app/j1$b;", "", "", "input", "", "a", "Lorg/json/JSONArray;", "cardsArray", "", "CARDS_KEY", "Ljava/lang/String;", "CARDS_TIMESTAMP_KEY", "FILE_NAME", "READ_CARDS_KEY_FLAT", "READ_CARDS_KEY_SET", "SEMICOLON_SEPARATOR", "USER_ID_KEY", "VIEWED_CARDS_KEY_FLAT", "VIEWED_CARDS_KEY_SET", "<init>", "()V", "android-sdk-base_release"}, k = 1, mv = {1, 6, 0})
    public static final class b {
        private b() {
        }

        public /* synthetic */ b(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public final Set<String> a(String str) {
            Intrinsics.checkNotNullParameter(str, "input");
            HashSet hashSet = new HashSet();
            Object[] array = StringsKt__StringsKt.split$default((CharSequence) str, new String[]{TypesAliasesKt.separator}, false, 0, 6, (Object) null).toArray(new String[0]);
            if (array != null) {
                String[] strArr = (String[]) array;
                Collections.addAll(hashSet, Arrays.copyOf(strArr, strArr.length));
                return hashSet;
            }
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        }

        @JvmStatic
        public final Set<String> a(JSONArray jSONArray) {
            Intrinsics.checkNotNullParameter(jSONArray, "cardsArray");
            HashSet hashSet = new HashSet();
            int length = jSONArray.length();
            int i11 = 0;
            while (i11 < length) {
                int i12 = i11 + 1;
                JSONObject jSONObject = jSONArray.getJSONObject(i11);
                CardKey cardKey = CardKey.ID;
                if (jSONObject.has(cardKey.getFeedKey())) {
                    String string = jSONObject.getString(cardKey.getFeedKey());
                    Intrinsics.checkNotNullExpressionValue(string, "card.getString(CardKey.ID.feedKey)");
                    hashSet.add(string);
                }
                i11 = i12;
            }
            return hashSet;
        }
    }

    public final FeedUpdatedEvent a(JSONArray jSONArray, String str) {
        Intrinsics.checkNotNullParameter(jSONArray, "cardsArray");
        String str2 = str == null ? "" : str;
        String string = this.f38742b.getString(PushNotificationParser.PUSH_ID_KEY, "");
        if (Intrinsics.areEqual((Object) string, (Object) str2)) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.I, (Throwable) null, false, (Function0) new c(str), 6, (Object) null);
            long nowInSeconds = DateTimeUtils.nowInSeconds();
            a(jSONArray, nowInSeconds);
            Set<String> set = this.f38743c;
            b bVar = f38740f;
            set.retainAll(bVar.a(jSONArray));
            a(this.f38743c, a.VIEWED_CARDS);
            this.f38744d.retainAll(bVar.a(jSONArray));
            a(this.f38744d, a.READ_CARDS);
            return a(jSONArray, str, false, nowInSeconds);
        }
        BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, false, (Function0) new d(str, string), 7, (Object) null);
        return null;
    }

    private final FeedUpdatedEvent a(JSONArray jSONArray, String str, boolean z11, long j11) {
        List list;
        if (jSONArray.length() == 0) {
            list = new ArrayList();
        } else {
            list = u.a(jSONArray, new CardKey.Provider(false), this.f38741a, (ICardStorageProvider<?>) this, this.f38745e);
        }
        List<Card> list2 = list;
        for (Card card : list2) {
            if (this.f38743c.contains(card.getId())) {
                card.setViewed(true);
                card.setIndicatorHighlighted(true);
            }
            if (this.f38744d.contains(card.getId())) {
                card.setIndicatorHighlighted(true);
            }
        }
        return new FeedUpdatedEvent(list2, str, z11, j11);
    }

    private final Set<String> a(a aVar) {
        String b11 = aVar.b();
        if (this.f38742b.contains(b11)) {
            Set<String> set = null;
            String string = this.f38742b.getString(b11, (String) null);
            if (string != null) {
                set = f38740f.a(string);
            }
            SharedPreferences.Editor edit = this.f38742b.edit();
            edit.remove(b11);
            edit.apply();
            if (set != null) {
                a(set, aVar);
                return set;
            }
        }
        return new ConcurrentSkipListSet(this.f38742b.getStringSet(aVar.c(), new HashSet()));
    }

    private final void a(JSONArray jSONArray, long j11) {
        SharedPreferences.Editor edit = this.f38742b.edit();
        if (jSONArray.length() == 0) {
            edit.remove("cards");
        } else {
            edit.putString("cards", JSONArrayInstrumentation.toString(jSONArray));
        }
        edit.putLong("cards_timestamp", j11);
        edit.apply();
    }

    private final void a(String str) {
        SharedPreferences.Editor edit = this.f38742b.edit();
        edit.putString(PushNotificationParser.PUSH_ID_KEY, str);
        edit.apply();
    }

    public final void a(Set<String> set, a aVar) {
        Intrinsics.checkNotNullParameter(set, "cardIds");
        Intrinsics.checkNotNullParameter(aVar, "property");
        String c11 = aVar.c();
        SharedPreferences.Editor edit = this.f38742b.edit();
        if (set.isEmpty()) {
            edit.remove(c11);
        } else {
            edit.putStringSet(c11, set);
        }
        edit.apply();
    }
}
