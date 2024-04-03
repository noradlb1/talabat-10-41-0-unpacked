package com.talabat.restaurants.inlineads.data;

import com.talabat.core.network.network.TalabatAPIBuilder;
import com.talabat.restaurants.inlineads.InlineAdsRepository;
import com.talabat.restaurants.v2.data.InMemoryCache;
import ft.a;
import io.reactivex.Single;
import kotlin.Lazy;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u0000 \n2\u00020\u0001:\u0001\nB\u000f\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0016\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\b\u001a\u00020\tH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/talabat/restaurants/inlineads/data/InlineAdsRepositoryImpl;", "Lcom/talabat/restaurants/inlineads/InlineAdsRepository;", "inlineAdsApi", "Lcom/talabat/restaurants/inlineads/data/InlineAdsApi;", "(Lcom/talabat/restaurants/inlineads/data/InlineAdsApi;)V", "getInlineAds", "Lio/reactivex/Single;", "Lcom/talabat/restaurants/inlineads/data/InLineAdsResponse;", "countryId", "", "Companion", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class InlineAdsRepositoryImpl implements InlineAdsRepository {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    @NotNull
    public static final Lazy<InMemoryCache> inMemoryCache$delegate = LazyKt__LazyJVMKt.lazy(LazyThreadSafetyMode.NONE, InlineAdsRepositoryImpl$Companion$inMemoryCache$2.INSTANCE);
    @NotNull
    private final InlineAdsApi inlineAdsApi;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u001b\u0010\u0003\u001a\u00020\u00048BX\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/talabat/restaurants/inlineads/data/InlineAdsRepositoryImpl$Companion;", "", "()V", "inMemoryCache", "Lcom/talabat/restaurants/v2/data/InMemoryCache;", "getInMemoryCache", "()Lcom/talabat/restaurants/v2/data/InMemoryCache;", "inMemoryCache$delegate", "Lkotlin/Lazy;", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* access modifiers changed from: private */
        public final InMemoryCache getInMemoryCache() {
            return (InMemoryCache) InlineAdsRepositoryImpl.inMemoryCache$delegate.getValue();
        }
    }

    public InlineAdsRepositoryImpl() {
        this((InlineAdsApi) null, 1, (DefaultConstructorMarker) null);
    }

    public InlineAdsRepositoryImpl(@NotNull InlineAdsApi inlineAdsApi2) {
        Intrinsics.checkNotNullParameter(inlineAdsApi2, "inlineAdsApi");
        this.inlineAdsApi = inlineAdsApi2;
    }

    /* access modifiers changed from: private */
    /* renamed from: getInlineAds$lambda-0  reason: not valid java name */
    public static final void m10727getInlineAds$lambda0(InLineAdsResponse inLineAdsResponse) {
        Companion.getInMemoryCache().setInlineAdsResponse(inLineAdsResponse);
    }

    @NotNull
    public Single<InLineAdsResponse> getInlineAds(int i11) {
        Companion companion = Companion;
        if (companion.getInMemoryCache().getInlineAdsResponse() != null) {
            Single<InLineAdsResponse> just = Single.just(companion.getInMemoryCache().getInlineAdsResponse());
            Intrinsics.checkNotNullExpressionValue(just, "just(inMemoryCache.inlineAdsResponse)");
            return just;
        }
        Single<InLineAdsResponse> doOnSuccess = this.inlineAdsApi.getInlineAds(i11).doOnSuccess(new a());
        Intrinsics.checkNotNullExpressionValue(doOnSuccess, "inlineAdsApi.getInlineAd…se = it\n                }");
        return doOnSuccess;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ InlineAdsRepositoryImpl(InlineAdsApi inlineAdsApi2, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this((i11 & 1) != 0 ? new InlineAdsApiImpl((TalabatAPIBuilder) null, 1, (DefaultConstructorMarker) null) : inlineAdsApi2);
    }
}
