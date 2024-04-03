package com.talabat.gem.ports.data;

import com.talabat.gem.domain.entities.GemRestaurant;
import io.reactivex.Observable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\bf\u0018\u00002\u00020\u0001J\n\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\u0016J\u000e\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005H\u0016J\u000e\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00070\u0005H\u0016J\u001a\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\fH\u0016¨\u0006\r"}, d2 = {"Lcom/talabat/gem/ports/data/RestaurantsDataSourcesPort;", "", "loadSelectedGemRestaurant", "Lcom/talabat/gem/domain/entities/GemRestaurant;", "observeOnSelectedGemRestaurant", "Lio/reactivex/Observable;", "observeOnSelectedRestaurantId", "", "updateSelectedGemRestaurant", "", "restaurant", "isGemCollectionRestaurant", "", "com_talabat_Components_gem-core_gem-core"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface RestaurantsDataSourcesPort {

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public static final class DefaultImpls {
        @Nullable
        public static GemRestaurant loadSelectedGemRestaurant(@NotNull RestaurantsDataSourcesPort restaurantsDataSourcesPort) {
            return null;
        }

        @NotNull
        public static Observable<GemRestaurant> observeOnSelectedGemRestaurant(@NotNull RestaurantsDataSourcesPort restaurantsDataSourcesPort) {
            Observable<GemRestaurant> empty = Observable.empty();
            Intrinsics.checkNotNullExpressionValue(empty, "empty()");
            return empty;
        }

        @NotNull
        public static Observable<Integer> observeOnSelectedRestaurantId(@NotNull RestaurantsDataSourcesPort restaurantsDataSourcesPort) {
            Observable<Integer> empty = Observable.empty();
            Intrinsics.checkNotNullExpressionValue(empty, "empty()");
            return empty;
        }

        public static void updateSelectedGemRestaurant(@NotNull RestaurantsDataSourcesPort restaurantsDataSourcesPort, @NotNull GemRestaurant gemRestaurant, boolean z11) {
            Intrinsics.checkNotNullParameter(gemRestaurant, "restaurant");
        }

        public static /* synthetic */ void updateSelectedGemRestaurant$default(RestaurantsDataSourcesPort restaurantsDataSourcesPort, GemRestaurant gemRestaurant, boolean z11, int i11, Object obj) {
            if (obj == null) {
                if ((i11 & 2) != 0) {
                    z11 = false;
                }
                restaurantsDataSourcesPort.updateSelectedGemRestaurant(gemRestaurant, z11);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: updateSelectedGemRestaurant");
        }
    }

    @Nullable
    GemRestaurant loadSelectedGemRestaurant();

    @NotNull
    Observable<GemRestaurant> observeOnSelectedGemRestaurant();

    @NotNull
    Observable<Integer> observeOnSelectedRestaurantId();

    void updateSelectedGemRestaurant(@NotNull GemRestaurant gemRestaurant, boolean z11);
}
