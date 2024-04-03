package com.talabat.gem.adapters.presentation.collections.list;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.talabat.core.navigation.domain.screen.gem.GemCollectionEntrypoint;
import com.talabat.gem.IntegrationKt;
import com.talabat.gem.adapters.R;
import com.talabat.gem.adapters.presentation.offer.GemOfferViewModel;
import com.talabat.gem.adapters.presentation.offer.RestaurantsBindingKt;
import com.talabat.gem.domain.entities.GemRestaurant;
import com.talabat.gem.domain.usecases.GemRestaurantsBusinessRulesKt;
import com.talabat.helpers.GlobalDataModel;
import com.talabat.talabatcore.adapters.FunctionalAdaptersKt;
import com.talabat.talabatnavigation.Navigator;
import com.talabat.talabatnavigation.opSquad.OPNavigatorActions;
import datamodels.Restaurant;
import io.reactivex.disposables.Disposable;
import io.reactivex.subjects.BehaviorSubject;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tracking.gtm.RestaurantsEventsKt;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0004\u0018\u00010\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lio/reactivex/disposables/Disposable;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class GemCollectionActivity$initialize$1$6 extends Lambda implements Function0<Disposable> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ GemCollectionActivity f60036g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ GemOfferViewModel f60037h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ GemCollectionEntrypoint f60038i;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public GemCollectionActivity$initialize$1$6(GemCollectionActivity gemCollectionActivity, GemOfferViewModel gemOfferViewModel, GemCollectionEntrypoint gemCollectionEntrypoint) {
        super(0);
        this.f60036g = gemCollectionActivity;
        this.f60037h = gemOfferViewModel;
        this.f60038i = gemCollectionEntrypoint;
    }

    @Nullable
    public final Disposable invoke() {
        RecyclerView recyclerView = (RecyclerView) this.f60036g._$_findCachedViewById(R.id.restaurantsRecyclerView);
        Intrinsics.checkNotNullExpressionValue(recyclerView, "restaurantsRecyclerView");
        int i11 = R.layout.v2_item_gem_restaurants;
        BehaviorSubject<List<GemRestaurant>> restaurants = this.f60037h.getRestaurants();
        final GemOfferViewModel gemOfferViewModel = this.f60037h;
        final GemCollectionEntrypoint gemCollectionEntrypoint = this.f60038i;
        return FunctionalAdaptersKt.invoke$default(recyclerView, i11, restaurants, (RecyclerView.LayoutManager) null, (Function2) null, new Function2<View, GemRestaurant, Unit>() {
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                invoke((View) obj, (GemRestaurant) obj2);
                return Unit.INSTANCE;
            }

            public final void invoke(@NotNull final View view, @NotNull final GemRestaurant gemRestaurant) {
                Intrinsics.checkNotNullParameter(view, "$this$invoke");
                Intrinsics.checkNotNullParameter(gemRestaurant, "it");
                final GemOfferViewModel gemOfferViewModel = gemOfferViewModel;
                final GemCollectionEntrypoint gemCollectionEntrypoint = gemCollectionEntrypoint;
                RestaurantsBindingKt.bindGemRestaurant(view, gemRestaurant, new Function0<Unit>() {

                    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
                    /* renamed from: com.talabat.gem.adapters.presentation.collections.list.GemCollectionActivity$initialize$1$6$1$1$WhenMappings */
                    public /* synthetic */ class WhenMappings {
                        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

                        static {
                            int[] iArr = new int[GemCollectionEntrypoint.values().length];
                            iArr[GemCollectionEntrypoint.HOME.ordinal()] = 1;
                            iArr[GemCollectionEntrypoint.FOOD_LIST.ordinal()] = 2;
                            $EnumSwitchMapping$0 = iArr;
                        }
                    }

                    public final void invoke() {
                        Restaurant data = gemRestaurant.getData();
                        if (data != null) {
                            RestaurantsEventsKt.clearSponsoringData(data);
                        }
                        GemRestaurantsBusinessRulesKt.onRestaurantSelected(gemOfferViewModel, gemRestaurant, true);
                        GemCollectionEntrypoint gemCollectionEntrypoint = gemCollectionEntrypoint;
                        int i11 = gemCollectionEntrypoint == null ? -1 : WhenMappings.$EnumSwitchMapping$0[gemCollectionEntrypoint.ordinal()];
                        String str = "";
                        GlobalDataModel.ShopClickOrigin = i11 != 1 ? i11 != 2 ? str : "channel" : "gem_swimlane_home";
                        if (gemCollectionEntrypoint == GemCollectionEntrypoint.FOOD_LIST) {
                            str = "gem";
                        }
                        IntegrationKt.getAnalytics().onShopClicked(gemRestaurant, str);
                        Restaurant data2 = gemRestaurant.getData();
                        if (data2 != null) {
                            Navigator.Companion companion = Navigator.Companion;
                            Context context = view.getContext();
                            Intrinsics.checkNotNullExpressionValue(context, "context");
                            companion.navigate(context, OPNavigatorActions.Companion.createNavigatorModelForMenuBridgeActivity$default(OPNavigatorActions.Companion, data2.branchId, data2.shopType, data2.isGlrEnabled, data2.isDarkStore, data2.isMigrated, false, (String) null, (Bundle) null, 224, (Object) null));
                        }
                    }
                });
            }
        }, 12, (Object) null);
    }
}
