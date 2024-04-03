package bo.app;

import com.appboy.enums.CardKey;
import com.appboy.enums.CardType;
import com.appboy.models.cards.Card;
import com.braze.storage.ICardStorageProvider;
import com.braze.support.BrazeLogger;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.json.JSONArray;
import org.json.JSONObject;

@Metadata(bv = {}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0013\u0010\u0014J:\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\f2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\n\u0010\t\u001a\u0006\u0012\u0002\b\u00030\b2\u0006\u0010\u000b\u001a\u00020\nH\u0007J6\u0010\u000e\u001a\u0004\u0018\u00010\r2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\n\u0010\t\u001a\u0006\u0012\u0002\b\u00030\b2\u0006\u0010\u000b\u001a\u00020\nH\u0007J6\u0010\u000e\u001a\u0004\u0018\u00010\r2\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\n\u0010\t\u001a\u0006\u0012\u0002\b\u00030\b2\u0006\u0010\u000b\u001a\u00020\nH\u0002¨\u0006\u0015"}, d2 = {"Lbo/app/u;", "", "Lorg/json/JSONArray;", "cardJsonStringArray", "Lcom/appboy/enums/CardKey$Provider;", "cardKeyProvider", "Lbo/app/b2;", "brazeManager", "Lcom/braze/storage/ICardStorageProvider;", "cardStorageProvider", "Lbo/app/d2;", "cardAnalyticsProvider", "", "Lcom/appboy/models/cards/Card;", "a", "Lorg/json/JSONObject;", "jsonObject", "", "jsonString", "<init>", "()V", "android-sdk-base_release"}, k = 1, mv = {1, 6, 0})
public final class u {

    /* renamed from: a  reason: collision with root package name */
    public static final u f39439a = new u();

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f39440a;

        static {
            int[] iArr = new int[CardType.values().length];
            iArr[CardType.BANNER.ordinal()] = 1;
            iArr[CardType.CAPTIONED_IMAGE.ordinal()] = 2;
            iArr[CardType.SHORT_NEWS.ordinal()] = 3;
            iArr[CardType.TEXT_ANNOUNCEMENT.ordinal()] = 4;
            iArr[CardType.CONTROL.ordinal()] = 5;
            f39440a = iArr;
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\u0010\u0004\u001a\u00020\u0003\"\u0006\b\u0000\u0010\u0000\u0018\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\n¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"T", "", "it", "", "a", "(I)Ljava/lang/Boolean;", "com/braze/support/JsonUtils$e"}, k = 3, mv = {1, 6, 0})
    public static final class b extends Lambda implements Function1<Integer, Boolean> {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ JSONArray f39441b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(JSONArray jSONArray) {
            super(1);
            this.f39441b = jSONArray;
        }

        public final Boolean a(int i11) {
            return Boolean.valueOf(this.f39441b.opt(i11) instanceof Object);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            return a(((Number) obj).intValue());
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0010\u0003\u001a\u00028\u0000\"\u0006\b\u0000\u0010\u0000\u0018\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\n¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"T", "", "it", "a", "(I)Ljava/lang/Object;", "com/braze/support/JsonUtils$f"}, k = 3, mv = {1, 6, 0})
    public static final class c extends Lambda implements Function1<Integer, Object> {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ JSONArray f39442b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public c(JSONArray jSONArray) {
            super(1);
            this.f39442b = jSONArray;
        }

        public final Object a(int i11) {
            Object obj = this.f39442b.get(i11);
            if (obj != null) {
                return obj;
            }
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Any");
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            return a(((Number) obj).intValue());
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\u000e\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"", "it", "Lcom/appboy/models/cards/Card;", "a", "(Ljava/lang/Object;)Lcom/appboy/models/cards/Card;"}, k = 3, mv = {1, 6, 0})
    public static final class d extends Lambda implements Function1<Object, Card> {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ CardKey.Provider f39443b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ b2 f39444c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ ICardStorageProvider<?> f39445d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ d2 f39446e;

        /* renamed from: f  reason: collision with root package name */
        final /* synthetic */ JSONArray f39447f;

        @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
        public static final class a extends Lambda implements Function0<String> {

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ Object f39448b;

            /* renamed from: c  reason: collision with root package name */
            final /* synthetic */ JSONArray f39449c;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public a(Object obj, JSONArray jSONArray) {
                super(0);
                this.f39448b = obj;
                this.f39449c = jSONArray;
            }

            /* renamed from: a */
            public final String invoke() {
                return "Unable to create Card JSON in array. Ignoring. Was on element: " + this.f39448b + " of json array: " + this.f39449c;
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public d(CardKey.Provider provider, b2 b2Var, ICardStorageProvider<?> iCardStorageProvider, d2 d2Var, JSONArray jSONArray) {
            super(1);
            this.f39443b = provider;
            this.f39444c = b2Var;
            this.f39445d = iCardStorageProvider;
            this.f39446e = d2Var;
            this.f39447f = jSONArray;
        }

        /* renamed from: a */
        public final Card invoke(Object obj) {
            Intrinsics.checkNotNullParameter(obj, "it");
            try {
                return u.f39439a.a(obj.toString(), this.f39443b, this.f39444c, this.f39445d, this.f39446e);
            } catch (Exception e11) {
                BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) u.f39439a, BrazeLogger.Priority.E, (Throwable) e11, false, (Function0) new a(obj, this.f39447f), 4, (Object) null);
                return null;
            }
        }
    }

    private u() {
    }

    /* JADX WARNING: type inference failed for: r6v0 */
    /* JADX WARNING: type inference failed for: r0v15, types: [com.appboy.models.cards.BannerImageCard] */
    /* JADX WARNING: type inference failed for: r0v16, types: [com.appboy.models.cards.CaptionedImageCard] */
    /* JADX WARNING: type inference failed for: r0v17, types: [com.appboy.models.cards.ShortNewsCard] */
    /* JADX WARNING: type inference failed for: r0v18, types: [com.appboy.models.cards.TextAnnouncementCard] */
    /* JADX WARNING: type inference failed for: r0v19, types: [com.appboy.models.cards.ControlCard] */
    /* JADX WARNING: Multi-variable type inference failed */
    @kotlin.jvm.JvmStatic
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final com.appboy.models.cards.Card a(org.json.JSONObject r7, com.appboy.enums.CardKey.Provider r8, bo.app.b2 r9, com.braze.storage.ICardStorageProvider<?> r10, bo.app.d2 r11) {
        /*
            java.lang.String r0 = "jsonObject"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r0)
            java.lang.String r0 = "cardKeyProvider"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r8, r0)
            java.lang.String r0 = "brazeManager"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r9, r0)
            java.lang.String r0 = "cardStorageProvider"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r10, r0)
            java.lang.String r0 = "cardAnalyticsProvider"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r11, r0)
            com.appboy.enums.CardType r0 = r8.getCardTypeFromJson(r7)
            if (r0 != 0) goto L_0x0021
            r0 = -1
            goto L_0x0029
        L_0x0021:
            int[] r1 = bo.app.u.a.f39440a
            int r0 = r0.ordinal()
            r0 = r1[r0]
        L_0x0029:
            r1 = 1
            if (r0 == r1) goto L_0x006b
            r1 = 2
            if (r0 == r1) goto L_0x005f
            r1 = 3
            if (r0 == r1) goto L_0x0053
            r1 = 4
            if (r0 == r1) goto L_0x0047
            r1 = 5
            if (r0 == r1) goto L_0x003b
            r7 = 0
            goto L_0x0077
        L_0x003b:
            com.appboy.models.cards.ControlCard r6 = new com.appboy.models.cards.ControlCard
            r0 = r6
            r1 = r7
            r2 = r8
            r3 = r9
            r4 = r10
            r5 = r11
            r0.<init>(r1, r2, r3, r4, r5)
            goto L_0x0076
        L_0x0047:
            com.appboy.models.cards.TextAnnouncementCard r6 = new com.appboy.models.cards.TextAnnouncementCard
            r0 = r6
            r1 = r7
            r2 = r8
            r3 = r9
            r4 = r10
            r5 = r11
            r0.<init>(r1, r2, r3, r4, r5)
            goto L_0x0076
        L_0x0053:
            com.appboy.models.cards.ShortNewsCard r6 = new com.appboy.models.cards.ShortNewsCard
            r0 = r6
            r1 = r7
            r2 = r8
            r3 = r9
            r4 = r10
            r5 = r11
            r0.<init>(r1, r2, r3, r4, r5)
            goto L_0x0076
        L_0x005f:
            com.appboy.models.cards.CaptionedImageCard r6 = new com.appboy.models.cards.CaptionedImageCard
            r0 = r6
            r1 = r7
            r2 = r8
            r3 = r9
            r4 = r10
            r5 = r11
            r0.<init>(r1, r2, r3, r4, r5)
            goto L_0x0076
        L_0x006b:
            com.appboy.models.cards.BannerImageCard r6 = new com.appboy.models.cards.BannerImageCard
            r0 = r6
            r1 = r7
            r2 = r8
            r3 = r9
            r4 = r10
            r5 = r11
            r0.<init>(r1, r2, r3, r4, r5)
        L_0x0076:
            r7 = r6
        L_0x0077:
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: bo.app.u.a(org.json.JSONObject, com.appboy.enums.CardKey$Provider, bo.app.b2, com.braze.storage.ICardStorageProvider, bo.app.d2):com.appboy.models.cards.Card");
    }

    /* access modifiers changed from: private */
    public final Card a(String str, CardKey.Provider provider, b2 b2Var, ICardStorageProvider<?> iCardStorageProvider, d2 d2Var) {
        return a(new JSONObject(str), provider, b2Var, iCardStorageProvider, d2Var);
    }

    @JvmStatic
    public static final List<Card> a(JSONArray jSONArray, CardKey.Provider provider, b2 b2Var, ICardStorageProvider<?> iCardStorageProvider, d2 d2Var) {
        Intrinsics.checkNotNullParameter(jSONArray, "cardJsonStringArray");
        Intrinsics.checkNotNullParameter(provider, "cardKeyProvider");
        Intrinsics.checkNotNullParameter(b2Var, "brazeManager");
        Intrinsics.checkNotNullParameter(iCardStorageProvider, "cardStorageProvider");
        Intrinsics.checkNotNullParameter(d2Var, "cardAnalyticsProvider");
        return SequencesKt___SequencesKt.toList(SequencesKt___SequencesKt.mapNotNull(SequencesKt__SequencesKt.asSequence(SequencesKt___SequencesKt.map(SequencesKt___SequencesKt.filter(CollectionsKt___CollectionsKt.asSequence(RangesKt___RangesKt.until(0, jSONArray.length())), new b(jSONArray)), new c(jSONArray)).iterator()), new d(provider, b2Var, iCardStorageProvider, d2Var, jSONArray)));
    }
}
