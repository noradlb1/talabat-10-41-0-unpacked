package com.talabat.gem.ports.data;

import com.talabat.gem.domain.entities.GemOffer;
import com.talabat.talabatcommon.extentions.KotlinResultKt;
import io.reactivex.Observable;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J/\u0010\u0004\u001a\u001e\b\u0001\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0005H\u0016ø\u0001\u0000ø\u0001\u0000¢\u0006\u0002\u0010\tJ\u000e\u0010\n\u001a\b\u0012\u0004\u0012\u00020\b0\u000bH\u0016J\u000f\u0010\f\u001a\u0004\u0018\u00010\rH\u0016¢\u0006\u0002\u0010\u000eJ/\u0010\u000f\u001a\u001e\b\u0001\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0005H\u0016ø\u0001\u0000ø\u0001\u0000¢\u0006\u0002\u0010\tJ/\u0010\u0010\u001a\u001e\b\u0001\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0005H\u0016ø\u0001\u0000ø\u0001\u0000¢\u0006\u0002\u0010\tJ7\u0010\u0011\u001a\u001e\b\u0001\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00052\u0006\u0010\u0012\u001a\u00020\bH\u0016ø\u0001\u0000ø\u0001\u0000¢\u0006\u0002\u0010\u0013J\u0010\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0003H\u0016J\u0017\u0010\u0017\u001a\u00020\u00152\b\u0010\u0018\u001a\u0004\u0018\u00010\rH\u0016¢\u0006\u0002\u0010\u0019\u0002\u0004\n\u0002\b\u0019¨\u0006\u001a"}, d2 = {"Lcom/talabat/gem/ports/data/GemOfferDataSourcesPort;", "", "isOfferAutoTriggered", "", "loadGemOffer", "Lkotlin/Function1;", "Lkotlin/coroutines/Continuation;", "Lkotlin/Result;", "Lcom/talabat/gem/domain/entities/GemOffer;", "()Lkotlin/jvm/functions/Function1;", "observeOnGemOffer", "Lio/reactivex/Observable;", "openedRestaurantIdFromAllEntryPoint", "", "()Ljava/lang/Integer;", "requestGemOffer", "requestGemOfferFromFlutterHome", "saveGemOffer", "gemOffer", "(Lcom/talabat/gem/domain/entities/GemOffer;)Lkotlin/jvm/functions/Function1;", "saveOfferAutoTriggered", "", "triggered", "saveRestaurantIdFromAllEntryPoint", "id", "(Ljava/lang/Integer;)V", "com_talabat_Components_gem-core_gem-core"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface GemOfferDataSourcesPort {

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public static final class DefaultImpls {
        public static boolean isOfferAutoTriggered(@NotNull GemOfferDataSourcesPort gemOfferDataSourcesPort) {
            return false;
        }

        @NotNull
        public static Function1<Continuation<? super Result<GemOffer>>, Object> loadGemOffer(@NotNull GemOfferDataSourcesPort gemOfferDataSourcesPort) {
            return KotlinResultKt.Either(new GemOfferDataSourcesPort$loadGemOffer$1((Continuation<? super GemOfferDataSourcesPort$loadGemOffer$1>) null));
        }

        @NotNull
        public static Observable<GemOffer> observeOnGemOffer(@NotNull GemOfferDataSourcesPort gemOfferDataSourcesPort) {
            Observable<GemOffer> empty = Observable.empty();
            Intrinsics.checkNotNullExpressionValue(empty, "empty<GemOffer>()");
            return empty;
        }

        @Nullable
        public static Integer openedRestaurantIdFromAllEntryPoint(@NotNull GemOfferDataSourcesPort gemOfferDataSourcesPort) {
            return null;
        }

        @NotNull
        public static Function1<Continuation<? super Result<GemOffer>>, Object> requestGemOffer(@NotNull GemOfferDataSourcesPort gemOfferDataSourcesPort) {
            return KotlinResultKt.Either(new GemOfferDataSourcesPort$requestGemOffer$1((Continuation<? super GemOfferDataSourcesPort$requestGemOffer$1>) null));
        }

        @NotNull
        public static Function1<Continuation<? super Result<GemOffer>>, Object> requestGemOfferFromFlutterHome(@NotNull GemOfferDataSourcesPort gemOfferDataSourcesPort) {
            return KotlinResultKt.Either(new GemOfferDataSourcesPort$requestGemOfferFromFlutterHome$1((Continuation<? super GemOfferDataSourcesPort$requestGemOfferFromFlutterHome$1>) null));
        }

        @NotNull
        public static Function1<Continuation<? super Result<GemOffer>>, Object> saveGemOffer(@NotNull GemOfferDataSourcesPort gemOfferDataSourcesPort, @NotNull GemOffer gemOffer) {
            Intrinsics.checkNotNullParameter(gemOffer, "gemOffer");
            return KotlinResultKt.Either(new GemOfferDataSourcesPort$saveGemOffer$1(gemOffer, (Continuation<? super GemOfferDataSourcesPort$saveGemOffer$1>) null));
        }

        public static void saveOfferAutoTriggered(@NotNull GemOfferDataSourcesPort gemOfferDataSourcesPort, boolean z11) {
        }

        public static void saveRestaurantIdFromAllEntryPoint(@NotNull GemOfferDataSourcesPort gemOfferDataSourcesPort, @Nullable Integer num) {
        }
    }

    boolean isOfferAutoTriggered();

    @NotNull
    Function1<Continuation<? super Result<GemOffer>>, Object> loadGemOffer();

    @NotNull
    Observable<GemOffer> observeOnGemOffer();

    @Nullable
    Integer openedRestaurantIdFromAllEntryPoint();

    @NotNull
    Function1<Continuation<? super Result<GemOffer>>, Object> requestGemOffer();

    @NotNull
    Function1<Continuation<? super Result<GemOffer>>, Object> requestGemOfferFromFlutterHome();

    @NotNull
    Function1<Continuation<? super Result<GemOffer>>, Object> saveGemOffer(@NotNull GemOffer gemOffer);

    void saveOfferAutoTriggered(boolean z11);

    void saveRestaurantIdFromAllEntryPoint(@Nullable Integer num);
}
