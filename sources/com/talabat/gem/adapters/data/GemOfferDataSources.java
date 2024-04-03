package com.talabat.gem.adapters.data;

import com.talabat.gem.domain.entities.GemOffer;
import com.talabat.gem.ports.data.GemOfferDataSourcesPort;
import com.talabat.talabatcommon.extentions.KotlinResultKt;
import com.talabat.talabatcommon.extentions.Nullable;
import com.talabat.talabatcommon.extentions.RxKt;
import io.reactivex.Observable;
import io.reactivex.Single;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import oq.d;
import oq.e;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016J/\u0010\u0005\u001a\u001e\b\u0001\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b0\u0007\u0012\u0006\u0012\u0004\u0018\u00010\n0\u0006H\u0016ø\u0001\u0000ø\u0001\u0000¢\u0006\u0002\u0010\u000bJ\u000e\u0010\f\u001a\b\u0012\u0004\u0012\u00020\t0\rH\u0016J\u000f\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0016¢\u0006\u0002\u0010\u0010J7\u0010\u0011\u001a&\b\u0001\u0012\u0018\u0012\u0016\u0012\u0012\u0012\u0010\u0012\f\u0012\n \u0012*\u0004\u0018\u00010\t0\t0\b0\u0007\u0012\u0006\u0012\u0004\u0018\u00010\n0\u0006H\u0016ø\u0001\u0000ø\u0001\u0000¢\u0006\u0002\u0010\u000bJ7\u0010\u0013\u001a&\b\u0001\u0012\u0018\u0012\u0016\u0012\u0012\u0012\u0010\u0012\f\u0012\n \u0012*\u0004\u0018\u00010\t0\t0\b0\u0007\u0012\u0006\u0012\u0004\u0018\u00010\n0\u0006H\u0016ø\u0001\u0000ø\u0001\u0000¢\u0006\u0002\u0010\u000bJ7\u0010\u0014\u001a\u001e\b\u0001\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b0\u0007\u0012\u0006\u0012\u0004\u0018\u00010\n0\u00062\u0006\u0010\u0015\u001a\u00020\tH\u0016ø\u0001\u0000ø\u0001\u0000¢\u0006\u0002\u0010\u0016J\u0010\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u0004H\u0016J\u0017\u0010\u001a\u001a\u00020\u00182\b\u0010\u001b\u001a\u0004\u0018\u00010\u000fH\u0016¢\u0006\u0002\u0010\u001c\u0002\u0004\n\u0002\b\u0019¨\u0006\u001d"}, d2 = {"Lcom/talabat/gem/adapters/data/GemOfferDataSources;", "Lcom/talabat/gem/ports/data/GemOfferDataSourcesPort;", "()V", "isOfferAutoTriggered", "", "loadGemOffer", "Lkotlin/Function1;", "Lkotlin/coroutines/Continuation;", "Lkotlin/Result;", "Lcom/talabat/gem/domain/entities/GemOffer;", "", "()Lkotlin/jvm/functions/Function1;", "observeOnGemOffer", "Lio/reactivex/Observable;", "openedRestaurantIdFromAllEntryPoint", "", "()Ljava/lang/Integer;", "requestGemOffer", "kotlin.jvm.PlatformType", "requestGemOfferFromFlutterHome", "saveGemOffer", "gemOffer", "(Lcom/talabat/gem/domain/entities/GemOffer;)Lkotlin/jvm/functions/Function1;", "saveOfferAutoTriggered", "", "triggered", "saveRestaurantIdFromAllEntryPoint", "id", "(Ljava/lang/Integer;)V", "com_talabat_Components_gem_gem"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class GemOfferDataSources implements GemOfferDataSourcesPort {
    /* access modifiers changed from: private */
    /* renamed from: observeOnGemOffer$lambda-0  reason: not valid java name */
    public static final boolean m10504observeOnGemOffer$lambda0(Nullable nullable) {
        Intrinsics.checkNotNullParameter(nullable, "it");
        return RxKt.isNotNull(nullable);
    }

    /* access modifiers changed from: private */
    /* renamed from: observeOnGemOffer$lambda-1  reason: not valid java name */
    public static final GemOffer m10505observeOnGemOffer$lambda1(Nullable nullable) {
        Intrinsics.checkNotNullParameter(nullable, "it");
        return (GemOffer) nullable.getValue();
    }

    public boolean isOfferAutoTriggered() {
        return CacheKt.getOfferTrigger();
    }

    @NotNull
    public Function1<Continuation<? super Result<GemOffer>>, Object> loadGemOffer() {
        Nullable nullable = (Nullable) RxKt.invoke(CacheKt.getCachedOffer());
        return KotlinResultKt.toNonNullEither(nullable != null ? (GemOffer) nullable.getValue() : null);
    }

    @NotNull
    public Observable<GemOffer> observeOnGemOffer() {
        Observable<R> map = CacheKt.getCachedOffer().share().filter(new d()).map(new e());
        Intrinsics.checkNotNullExpressionValue(map, "cachedOffer.share().filt…Null() }.map { it.value }");
        return map;
    }

    @org.jetbrains.annotations.Nullable
    public Integer openedRestaurantIdFromAllEntryPoint() {
        return CacheKt.getOpenedRestaurantFromEntryPoint();
    }

    @NotNull
    public Function1<Continuation<? super Result<GemOffer>>, Object> requestGemOffer() {
        Single<GemOffer> newOffer = ServerKt.getNewOffer();
        Intrinsics.checkNotNullExpressionValue(newOffer, "newOffer");
        return KotlinResultKt.toEither(newOffer);
    }

    @NotNull
    public Function1<Continuation<? super Result<GemOffer>>, Object> requestGemOfferFromFlutterHome() {
        Single<GemOffer> newOfferRequestFromFlutterHome = ServerKt.getNewOfferRequestFromFlutterHome();
        Intrinsics.checkNotNullExpressionValue(newOfferRequestFromFlutterHome, "newOfferRequestFromFlutterHome");
        return KotlinResultKt.toEither(newOfferRequestFromFlutterHome);
    }

    @NotNull
    public Function1<Continuation<? super Result<GemOffer>>, Object> saveGemOffer(@NotNull GemOffer gemOffer) {
        Intrinsics.checkNotNullParameter(gemOffer, "gemOffer");
        return KotlinResultKt.Either(new GemOfferDataSources$saveGemOffer$1(gemOffer, (Continuation<? super GemOfferDataSources$saveGemOffer$1>) null));
    }

    public void saveOfferAutoTriggered(boolean z11) {
        CacheKt.setOfferTrigger(z11);
    }

    public void saveRestaurantIdFromAllEntryPoint(@org.jetbrains.annotations.Nullable Integer num) {
        CacheKt.setOpenedRestaurantFromEntryPoint(num);
    }
}
