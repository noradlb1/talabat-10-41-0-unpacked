package com.talabat.gem.adapters.presentation.offer;

import android.view.View;
import android.widget.ImageView;
import androidx.recyclerview.widget.RecyclerView;
import com.talabat.gem.adapters.R;
import com.talabat.gem.domain.entities.GemRestaurant;
import com.talabat.gem.domain.usecases.GemRestaurantsBusinessRulesKt;
import com.talabat.talabatcore.adapters.FunctionalAdaptersKt;
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

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0004\u0018\u00010\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lio/reactivex/disposables/Disposable;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class GemOfferMainActivity$initialize$1$4 extends Lambda implements Function0<Disposable> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ GemOfferMainActivity f60242g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ GemOfferViewModel f60243h;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public GemOfferMainActivity$initialize$1$4(GemOfferMainActivity gemOfferMainActivity, GemOfferViewModel gemOfferViewModel) {
        super(0);
        this.f60242g = gemOfferMainActivity;
        this.f60243h = gemOfferViewModel;
    }

    @Nullable
    public final Disposable invoke() {
        RecyclerView recyclerView = (RecyclerView) this.f60242g._$_findCachedViewById(R.id.restaurantsRecyclerView);
        Intrinsics.checkNotNullExpressionValue(recyclerView, "restaurantsRecyclerView");
        int i11 = R.layout.gem_restaurant_card_view;
        BehaviorSubject<List<GemRestaurant>> restaurants = this.f60243h.getRestaurants();
        final GemOfferViewModel gemOfferViewModel = this.f60243h;
        final GemOfferMainActivity gemOfferMainActivity = this.f60242g;
        return FunctionalAdaptersKt.invoke$default(recyclerView, i11, restaurants, (RecyclerView.LayoutManager) null, (Function2) null, new Function2<View, GemRestaurant, Unit>() {
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                invoke((View) obj, (GemRestaurant) obj2);
                return Unit.INSTANCE;
            }

            public final void invoke(@NotNull View view, @NotNull final GemRestaurant gemRestaurant) {
                Intrinsics.checkNotNullParameter(view, "$this$invoke");
                Intrinsics.checkNotNullParameter(gemRestaurant, "it");
                final GemOfferViewModel gemOfferViewModel = gemOfferViewModel;
                final GemOfferMainActivity gemOfferMainActivity = gemOfferMainActivity;
                RestaurantsBindingKt.bindGemRestaurant(view, gemRestaurant, new Function0<Unit>() {
                    public final void invoke() {
                        GemRestaurantsBusinessRulesKt.onRestaurantSelected$default(gemOfferViewModel, gemRestaurant, false, 2, (Object) null);
                        gemOfferMainActivity.setResult(-1, GemOfferActivityKt.toData(gemRestaurant));
                        ((ImageView) gemOfferMainActivity._$_findCachedViewById(R.id.backImageView)).performClick();
                    }
                });
            }
        }, 12, (Object) null);
    }
}
