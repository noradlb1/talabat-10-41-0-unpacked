package com.talabat.gem.samples;

import android.view.View;
import android.widget.ImageButton;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import com.talabat.gem.adapters.R;
import com.talabat.gem.adapters.presentation.GemEntryViewConfigurations;
import com.talabat.gem.adapters.presentation.GemSelectionCallbacks;
import com.talabat.gem.adapters.presentation.offer.RestaurantsBindingKt;
import com.talabat.gem.adapters.presentation.restaurants.GemFloatingView;
import com.talabat.gem.domain.entities.GemRestaurant;
import com.talabat.talabatcommon.extension.ViewKt;
import com.talabat.talabatcommon.extentions.RxKt;
import com.talabat.talabatcore.adapters.FunctionalAdaptersKt;
import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Reflection;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "Landroidx/appcompat/app/AppCompatActivity;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class SampleGemRestaurantsActivity$initialize$1 extends Lambda implements Function1<AppCompatActivity, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ SampleGemRestaurantsActivity f60546g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SampleGemRestaurantsActivity$initialize$1(SampleGemRestaurantsActivity sampleGemRestaurantsActivity) {
        super(1);
        this.f60546g = sampleGemRestaurantsActivity;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((AppCompatActivity) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull final AppCompatActivity appCompatActivity) {
        Intrinsics.checkNotNullParameter(appCompatActivity, "$this$withLayout");
        ImageButton imageButton = (ImageButton) appCompatActivity.findViewById(R.id.refreshButton);
        Intrinsics.checkNotNullExpressionValue(imageButton, "refreshButton");
        final SampleGemRestaurantsActivity sampleGemRestaurantsActivity = this.f60546g;
        ViewKt.invoke(imageButton, new Function1<View, Unit>() {
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((View) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(@NotNull View view) {
                Intrinsics.checkNotNullParameter(view, "$this$invoke");
                RxKt.plusAssign(sampleGemRestaurantsActivity.collections, SampleGemRestaurantsActivityKt.Collections$default(0, 1, (Object) null));
            }
        });
        final SampleGemRestaurantsActivity sampleGemRestaurantsActivity2 = this.f60546g;
        sampleGemRestaurantsActivity2.autoDispose(new Function0<Disposable>() {
            @Nullable
            public final Disposable invoke() {
                RecyclerView recyclerView = (RecyclerView) appCompatActivity.findViewById(R.id.collectionsRecyclerView);
                Intrinsics.checkNotNullExpressionValue(recyclerView, "collectionsRecyclerView");
                return FunctionalAdaptersKt.invoke$default(recyclerView, R.layout.sample_collection_item, sampleGemRestaurantsActivity2.collections, SampleGemRestaurantsActivityKt.horizontalLayout(appCompatActivity), (Function2) null, AnonymousClass1.INSTANCE, 8, (Object) null);
            }
        });
        this.f60546g.autoDispose(new Function0<Disposable>() {
            @Nullable
            public final Disposable invoke() {
                RecyclerView recyclerView = (RecyclerView) appCompatActivity.findViewById(R.id.restaurantsRecyclerView);
                Intrinsics.checkNotNullExpressionValue(recyclerView, "restaurantsRecyclerView");
                int i11 = R.layout.gem_restaurant_card_view;
                Observable<T> just = Observable.just(SampleDataSourcesKt.Restaurants());
                Intrinsics.checkNotNullExpressionValue(just, "just(Restaurants())");
                final AppCompatActivity appCompatActivity = appCompatActivity;
                return FunctionalAdaptersKt.invoke$default(recyclerView, i11, just, (RecyclerView.LayoutManager) null, (Function2) null, new Function2<View, GemRestaurant, Unit>() {
                    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                        invoke((View) obj, (GemRestaurant) obj2);
                        return Unit.INSTANCE;
                    }

                    public final void invoke(@NotNull View view, @NotNull final GemRestaurant gemRestaurant) {
                        Intrinsics.checkNotNullParameter(view, "$this$invoke");
                        Intrinsics.checkNotNullParameter(gemRestaurant, "restaurant");
                        final AppCompatActivity appCompatActivity = appCompatActivity;
                        RestaurantsBindingKt.bindGemRestaurant(view, gemRestaurant, new Function0<Unit>() {
                            public final void invoke() {
                                Integer id2 = gemRestaurant.getId();
                                if (id2 != null) {
                                    RouterKt.navigate$default(appCompatActivity, Reflection.getOrCreateKotlinClass(SampleGemMenuActivity.class), id2.intValue(), 0.0d, 4, (Object) null);
                                }
                            }
                        });
                    }
                }, 12, (Object) null);
            }
        });
        ((GemFloatingView) appCompatActivity.findViewById(R.id.gemFloatingButton)).invoke(new Function1<GemEntryViewConfigurations, Unit>() {
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((GemEntryViewConfigurations) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(@NotNull GemEntryViewConfigurations gemEntryViewConfigurations) {
                Intrinsics.checkNotNullParameter(gemEntryViewConfigurations, "$this$invoke");
                GemSelectionCallbacks<GemRestaurant> on2 = gemEntryViewConfigurations.getOn();
                final AppCompatActivity appCompatActivity = appCompatActivity;
                on2.selected(new Function1<GemRestaurant, Unit>() {
                    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                        invoke((GemRestaurant) obj);
                        return Unit.INSTANCE;
                    }

                    public final void invoke(@NotNull GemRestaurant gemRestaurant) {
                        Intrinsics.checkNotNullParameter(gemRestaurant, "selection");
                        Integer id2 = gemRestaurant.getId();
                        if (id2 != null) {
                            RouterKt.navigate$default(appCompatActivity, Reflection.getOrCreateKotlinClass(SampleGemMenuActivity.class), id2.intValue(), 0.0d, 4, (Object) null);
                        }
                    }
                });
            }
        });
        this.f60546g.withGemCollectionsView(new Function1<GemEntryViewConfigurations, Unit>() {
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((GemEntryViewConfigurations) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(@NotNull GemEntryViewConfigurations gemEntryViewConfigurations) {
                Intrinsics.checkNotNullParameter(gemEntryViewConfigurations, "$this$withGemCollectionsView");
                GemSelectionCallbacks<GemRestaurant> on2 = gemEntryViewConfigurations.getOn();
                final AppCompatActivity appCompatActivity = appCompatActivity;
                on2.selected(new Function1<GemRestaurant, Unit>() {
                    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                        invoke((GemRestaurant) obj);
                        return Unit.INSTANCE;
                    }

                    public final void invoke(@NotNull GemRestaurant gemRestaurant) {
                        Intrinsics.checkNotNullParameter(gemRestaurant, "selection");
                        Integer id2 = gemRestaurant.getId();
                        if (id2 != null) {
                            RouterKt.navigate$default(appCompatActivity, Reflection.getOrCreateKotlinClass(SampleGemMenuActivity.class), id2.intValue(), 0.0d, 4, (Object) null);
                        }
                    }
                });
            }
        });
    }
}
