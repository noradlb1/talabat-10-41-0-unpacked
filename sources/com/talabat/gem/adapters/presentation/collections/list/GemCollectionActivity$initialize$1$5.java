package com.talabat.gem.adapters.presentation.collections.list;

import com.talabat.core.navigation.domain.screen.gem.GemCollectionEntrypoint;
import com.talabat.gem.IntegrationKt;
import com.talabat.gem.adapters.presentation.offer.GemOfferViewModel;
import com.talabat.gem.domain.entities.GemRestaurant;
import com.talabat.talabatcommon.extentions.ObserverCallbacks;
import com.talabat.talabatcommon.extentions.RxKt;
import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import io.reactivex.subjects.BehaviorSubject;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0004\u0018\u00010\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lio/reactivex/disposables/Disposable;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class GemCollectionActivity$initialize$1$5 extends Lambda implements Function0<Disposable> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ GemOfferViewModel f60032g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ GemCollectionEntrypoint f60033h;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public GemCollectionActivity$initialize$1$5(GemOfferViewModel gemOfferViewModel, GemCollectionEntrypoint gemCollectionEntrypoint) {
        super(0);
        this.f60032g = gemOfferViewModel;
        this.f60033h = gemCollectionEntrypoint;
    }

    @Nullable
    public final Disposable invoke() {
        BehaviorSubject<List<GemRestaurant>> restaurants = this.f60032g.getRestaurants();
        final GemCollectionEntrypoint gemCollectionEntrypoint = this.f60033h;
        return RxKt.invoke(restaurants, new Function1<ObserverCallbacks<List<? extends GemRestaurant>, Observable<List<? extends GemRestaurant>>>, Unit>() {
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((ObserverCallbacks<List<GemRestaurant>, Observable<List<GemRestaurant>>>) (ObserverCallbacks) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(@NotNull ObserverCallbacks<List<GemRestaurant>, Observable<List<GemRestaurant>>> observerCallbacks) {
                Intrinsics.checkNotNullParameter(observerCallbacks, "$this$invoke");
                ObserverCallbacks<List<GemRestaurant>, Observable<List<GemRestaurant>>> on2 = observerCallbacks.getOn();
                final GemCollectionEntrypoint gemCollectionEntrypoint = gemCollectionEntrypoint;
                on2.next(new Function1<List<? extends GemRestaurant>, Unit>() {

                    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
                    /* renamed from: com.talabat.gem.adapters.presentation.collections.list.GemCollectionActivity$initialize$1$5$1$1$WhenMappings */
                    public /* synthetic */ class WhenMappings {
                        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

                        static {
                            int[] iArr = new int[GemCollectionEntrypoint.values().length];
                            iArr[GemCollectionEntrypoint.HOME.ordinal()] = 1;
                            iArr[GemCollectionEntrypoint.FOOD_LIST.ordinal()] = 2;
                            $EnumSwitchMapping$0 = iArr;
                        }
                    }

                    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                        invoke((List<GemRestaurant>) (List) obj);
                        return Unit.INSTANCE;
                    }

                    public final void invoke(List<GemRestaurant> list) {
                        int i11;
                        GemCollectionEntrypoint gemCollectionEntrypoint = gemCollectionEntrypoint;
                        String str = "";
                        String str2 = gemCollectionEntrypoint == GemCollectionEntrypoint.HOME ? "GEM" : str;
                        if (gemCollectionEntrypoint == null) {
                            i11 = -1;
                        } else {
                            i11 = WhenMappings.$EnumSwitchMapping$0[gemCollectionEntrypoint.ordinal()];
                        }
                        if (i11 == 1) {
                            str = "home_swimlane";
                        } else if (i11 == 2) {
                            str = "home_restaurants";
                        }
                        IntegrationKt.getAnalytics().onGemCollectionRestaurantLoaded(str2, str);
                    }
                });
            }
        });
    }
}
