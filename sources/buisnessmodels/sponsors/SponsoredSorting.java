package buisnessmodels.sponsors;

import android.annotation.SuppressLint;
import androidx.annotation.RestrictTo;
import buisnessmodels.sponsors.Sponsored;
import com.talabat.talabatcommon.views.wallet.cardViewWidgets.view.DefaultCardView;
import com.talabat.talabatcore.logger.LogManager;
import io.reactivex.functions.Function;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.JvmName;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u0000 \u000f*\b\b\u0000\u0010\u0001*\u00020\u00022\u001a\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00010\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00010\u00040\u0003:\u0001\u000fB\u0011\b\u0007\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u001c\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\u00042\f\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004H\u0016J\u0017\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\f\u001a\u00020\rH\u0002¢\u0006\u0002\u0010\u000eR\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lbuisnessmodels/sponsors/SponsoredSorting;", "T", "Lbuisnessmodels/sponsors/Sponsored;", "Lio/reactivex/functions/Function;", "", "repository", "Lbuisnessmodels/sponsors/SponsorsRepository;", "(Lbuisnessmodels/sponsors/SponsorsRepository;)V", "apply", "list", "log", "", "message", "", "(Ljava/lang/String;)Lkotlin/Unit;", "Companion", "com_talabat_talabatlib_talabatlib"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class SponsoredSorting<T extends Sponsored> implements Function<List<? extends T>, List<? extends T>> {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @NotNull
    private final SponsorsRepository repository;

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J+\u0010\u0003\u001a\b\u0012\u0004\u0012\u0002H\u00050\u0004\"\b\b\u0001\u0010\u0005*\u00020\u00062\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u0002H\u00050\u0004H\u0007¢\u0006\u0002\b\b¨\u0006\t"}, d2 = {"Lbuisnessmodels/sponsors/SponsoredSorting$Companion;", "", "()V", "apply", "", "T", "Lbuisnessmodels/sponsors/Sponsored;", "list", "with", "com_talabat_talabatlib_talabatlib"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @SuppressLint({"RestrictedApi"})
        @JvmStatic
        @NotNull
        @JvmName(name = "with")
        public final <T extends Sponsored> List<T> with(@NotNull List<? extends T> list) {
            Intrinsics.checkNotNullParameter(list, DefaultCardView.CARD_LIST);
            return new SponsoredSorting((SponsorsRepository) null, 1, (DefaultConstructorMarker) null).apply(list);
        }
    }

    @RestrictTo({RestrictTo.Scope.TESTS})
    public SponsoredSorting() {
        this((SponsorsRepository) null, 1, (DefaultConstructorMarker) null);
    }

    @RestrictTo({RestrictTo.Scope.TESTS})
    public SponsoredSorting(@NotNull SponsorsRepository sponsorsRepository) {
        Intrinsics.checkNotNullParameter(sponsorsRepository, "repository");
        this.repository = sponsorsRepository;
    }

    private final Unit log(String str) {
        Object obj;
        try {
            Result.Companion companion = Result.Companion;
            LogManager.info(str);
            obj = Result.m6329constructorimpl(Unit.INSTANCE);
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.m6329constructorimpl(ResultKt.createFailure(th2));
        }
        if (Result.m6335isFailureimpl(obj)) {
            obj = null;
        }
        return (Unit) obj;
    }

    @SuppressLint({"RestrictedApi"})
    @JvmStatic
    @NotNull
    @JvmName(name = "with")
    public static final <T extends Sponsored> List<T> with(@NotNull List<? extends T> list) {
        return Companion.with(list);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v1, resolved type: java.util.List<? extends T>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v4, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v18, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v19, resolved type: java.util.List<? extends T>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v20, resolved type: java.util.List<? extends T>} */
    /* JADX WARNING: Multi-variable type inference failed */
    @org.jetbrains.annotations.NotNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.util.List<T> apply(@org.jetbrains.annotations.NotNull java.util.List<? extends T> r10) {
        /*
            r9 = this;
            java.lang.String r0 = "list"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r10, r0)
            kotlin.Result$Companion r0 = kotlin.Result.Companion     // Catch:{ all -> 0x00a1 }
            buisnessmodels.sponsors.SponsorsRepository r0 = r9.repository     // Catch:{ all -> 0x00a1 }
            boolean r0 = r0.isSponsoredSortingActive()     // Catch:{ all -> 0x00a1 }
            if (r0 != 0) goto L_0x0010
            return r10
        L_0x0010:
            r0 = r10
            java.lang.Iterable r0 = (java.lang.Iterable) r0     // Catch:{ all -> 0x00a1 }
            java.util.ArrayList r1 = new java.util.ArrayList     // Catch:{ all -> 0x00a1 }
            r1.<init>()     // Catch:{ all -> 0x00a1 }
            java.util.Iterator r0 = r0.iterator()     // Catch:{ all -> 0x00a1 }
        L_0x001c:
            boolean r2 = r0.hasNext()     // Catch:{ all -> 0x00a1 }
            r3 = 1
            r4 = 0
            if (r2 == 0) goto L_0x0039
            java.lang.Object r2 = r0.next()     // Catch:{ all -> 0x00a1 }
            r5 = r2
            buisnessmodels.sponsors.Sponsored r5 = (buisnessmodels.sponsors.Sponsored) r5     // Catch:{ all -> 0x00a1 }
            int r5 = r5.getAvailabilityStatus()     // Catch:{ all -> 0x00a1 }
            if (r5 != 0) goto L_0x0032
            goto L_0x0033
        L_0x0032:
            r3 = r4
        L_0x0033:
            if (r3 == 0) goto L_0x001c
            r1.add(r2)     // Catch:{ all -> 0x00a1 }
            goto L_0x001c
        L_0x0039:
            java.util.ArrayList r0 = new java.util.ArrayList     // Catch:{ all -> 0x00a1 }
            r0.<init>()     // Catch:{ all -> 0x00a1 }
            java.util.Iterator r1 = r1.iterator()     // Catch:{ all -> 0x00a1 }
        L_0x0042:
            boolean r2 = r1.hasNext()     // Catch:{ all -> 0x00a1 }
            if (r2 == 0) goto L_0x0066
            java.lang.Object r2 = r1.next()     // Catch:{ all -> 0x00a1 }
            r5 = r2
            buisnessmodels.sponsors.Sponsored r5 = (buisnessmodels.sponsors.Sponsored) r5     // Catch:{ all -> 0x00a1 }
            long r5 = r5.getSponsoredRank()     // Catch:{ all -> 0x00a1 }
            buisnessmodels.sponsors.SponsorsRepository r7 = r9.repository     // Catch:{ all -> 0x00a1 }
            long r7 = r7.getMaxSponsoredRank()     // Catch:{ all -> 0x00a1 }
            int r5 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            if (r5 >= 0) goto L_0x005f
            r5 = r3
            goto L_0x0060
        L_0x005f:
            r5 = r4
        L_0x0060:
            if (r5 == 0) goto L_0x0042
            r0.add(r2)     // Catch:{ all -> 0x00a1 }
            goto L_0x0042
        L_0x0066:
            buisnessmodels.sponsors.SponsoredSorting$apply$lambda-4$$inlined$sortedBy$1 r1 = new buisnessmodels.sponsors.SponsoredSorting$apply$lambda-4$$inlined$sortedBy$1     // Catch:{ all -> 0x00a1 }
            r1.<init>()     // Catch:{ all -> 0x00a1 }
            java.util.List r0 = kotlin.collections.CollectionsKt___CollectionsKt.sortedWith(r0, r1)     // Catch:{ all -> 0x00a1 }
            java.lang.Iterable r0 = (java.lang.Iterable) r0     // Catch:{ all -> 0x00a1 }
            buisnessmodels.sponsors.SponsorsRepository r1 = r9.repository     // Catch:{ all -> 0x00a1 }
            int r1 = r1.getMaxSponsoredSlots()     // Catch:{ all -> 0x00a1 }
            java.util.List r0 = kotlin.collections.CollectionsKt___CollectionsKt.take(r0, r1)     // Catch:{ all -> 0x00a1 }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x00a1 }
            r1.<init>()     // Catch:{ all -> 0x00a1 }
            java.lang.String r2 = "sponsored items: "
            r1.append(r2)     // Catch:{ all -> 0x00a1 }
            r1.append(r0)     // Catch:{ all -> 0x00a1 }
            java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x00a1 }
            r9.log(r1)     // Catch:{ all -> 0x00a1 }
            java.lang.Iterable r0 = (java.lang.Iterable) r0     // Catch:{ all -> 0x00a1 }
            r1 = r10
            java.lang.Iterable r1 = (java.lang.Iterable) r1     // Catch:{ all -> 0x00a1 }
            java.util.Set r0 = kotlin.collections.CollectionsKt___CollectionsKt.union(r0, r1)     // Catch:{ all -> 0x00a1 }
            java.util.List r0 = kotlin.collections.CollectionsKt___CollectionsKt.toMutableList(r0)     // Catch:{ all -> 0x00a1 }
            java.lang.Object r0 = kotlin.Result.m6329constructorimpl(r0)     // Catch:{ all -> 0x00a1 }
            goto L_0x00ac
        L_0x00a1:
            r0 = move-exception
            kotlin.Result$Companion r1 = kotlin.Result.Companion
            java.lang.Object r0 = kotlin.ResultKt.createFailure(r0)
            java.lang.Object r0 = kotlin.Result.m6329constructorimpl(r0)
        L_0x00ac:
            boolean r1 = kotlin.Result.m6335isFailureimpl(r0)
            if (r1 == 0) goto L_0x00b3
            goto L_0x00b4
        L_0x00b3:
            r10 = r0
        L_0x00b4:
            java.util.List r10 = (java.util.List) r10
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: buisnessmodels.sponsors.SponsoredSorting.apply(java.util.List):java.util.List");
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ SponsoredSorting(buisnessmodels.sponsors.SponsorsRepository r1, int r2, kotlin.jvm.internal.DefaultConstructorMarker r3) {
        /*
            r0 = this;
            r2 = r2 & 1
            if (r2 == 0) goto L_0x000d
            buisnessmodels.sponsors.SponsorsRepository r1 = com.talabat.helpers.GlobalDataModel.sponsorsRepository()
            java.lang.String r2 = "sponsorsRepository()"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
        L_0x000d:
            r0.<init>(r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: buisnessmodels.sponsors.SponsoredSorting.<init>(buisnessmodels.sponsors.SponsorsRepository, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }
}
