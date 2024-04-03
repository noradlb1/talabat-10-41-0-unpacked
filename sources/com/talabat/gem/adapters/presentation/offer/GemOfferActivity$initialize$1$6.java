package com.talabat.gem.adapters.presentation.offer;

import android.content.Context;
import android.view.View;
import androidx.lifecycle.LifecycleCoroutineScope;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.recyclerview.widget.RecyclerView;
import com.talabat.gem.adapters.R;
import com.talabat.gem.adapters.presentation.home.SwimlanesRestaurantsBindingKt;
import com.talabat.gem.domain.entities.GemRestaurant;
import com.talabat.gem.domain.usecases.GemRestaurantsBusinessRulesKt;
import com.talabat.talabatcore.adapters.FunctionalAdaptersKt;
import datamodels.Restaurant;
import io.reactivex.disposables.Disposable;
import io.reactivex.subjects.BehaviorSubject;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tracking.gtm.RestaurantsEventsKt;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0004\u0018\u00010\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lio/reactivex/disposables/Disposable;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class GemOfferActivity$initialize$1$6 extends Lambda implements Function0<Disposable> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ GemOfferActivity f60202g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ GemOfferViewModel f60203h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ boolean f60204i;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public GemOfferActivity$initialize$1$6(GemOfferActivity gemOfferActivity, GemOfferViewModel gemOfferViewModel, boolean z11) {
        super(0);
        this.f60202g = gemOfferActivity;
        this.f60203h = gemOfferViewModel;
        this.f60204i = z11;
    }

    @Nullable
    public final Disposable invoke() {
        GemOfferActivity gemOfferActivity = this.f60202g;
        int i11 = R.id.restaurantsRecyclerView;
        GemOfferActivity gemOfferActivity2 = this.f60202g;
        Context applicationContext = gemOfferActivity2.getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(applicationContext, "applicationContext");
        ((RecyclerView) gemOfferActivity._$_findCachedViewById(i11)).addItemDecoration(gemOfferActivity2.generateItemDecoration(applicationContext));
        RecyclerView recyclerView = (RecyclerView) this.f60202g._$_findCachedViewById(i11);
        Intrinsics.checkNotNullExpressionValue(recyclerView, "restaurantsRecyclerView");
        int i12 = R.layout.gem_restaurant_card_view;
        BehaviorSubject<List<GemRestaurant>> restaurants = this.f60203h.getRestaurants();
        final GemOfferViewModel gemOfferViewModel = this.f60203h;
        final GemOfferActivity gemOfferActivity3 = this.f60202g;
        final boolean z11 = this.f60204i;
        return FunctionalAdaptersKt.invoke$default(recyclerView, i12, restaurants, (RecyclerView.LayoutManager) null, (Function2) null, new Function2<View, GemRestaurant, Unit>() {
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                invoke((View) obj, (GemRestaurant) obj2);
                return Unit.INSTANCE;
            }

            public final void invoke(@NotNull View view, @NotNull final GemRestaurant gemRestaurant) {
                Intrinsics.checkNotNullParameter(view, "$this$invoke");
                Intrinsics.checkNotNullParameter(gemRestaurant, "it");
                final GemOfferViewModel gemOfferViewModel = gemOfferViewModel;
                final GemOfferActivity gemOfferActivity = gemOfferActivity3;
                final boolean z11 = z11;
                SwimlanesRestaurantsBindingKt.bindGemSwimlaneRestaurant(view, gemRestaurant, new Function0<Unit>() {

                    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 6, 0})
                    @DebugMetadata(c = "com.talabat.gem.adapters.presentation.offer.GemOfferActivity$initialize$1$6$1$1$1", f = "GemOfferActivity.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
                    /* renamed from: com.talabat.gem.adapters.presentation.offer.GemOfferActivity$initialize$1$6$1$1$1  reason: invalid class name */
                    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

                        /* renamed from: h  reason: collision with root package name */
                        public int f60212h;

                        @NotNull
                        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
                            return new AnonymousClass1(gemOfferActivity, gemRestaurant, data2, continuation);
                        }

                        @Nullable
                        public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
                            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                        }

                        @Nullable
                        public final Object invokeSuspend(@NotNull Object obj) {
                            Object unused = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                            if (this.f60212h == 0) {
                                ResultKt.throwOnFailure(obj);
                                gemOfferActivity.navigateToMenu(gemRestaurant, data2);
                                return Unit.INSTANCE;
                            }
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                    }

                    public final void invoke() {
                        Restaurant data = gemRestaurant.getData();
                        if (data != null) {
                            RestaurantsEventsKt.clearSponsoringData(data);
                        }
                        GemRestaurantsBusinessRulesKt.onRestaurantSelected$default(gemOfferViewModel, gemRestaurant, false, 2, (Object) null);
                        gemOfferActivity.setResult(-1, GemOfferActivityKt.toData(gemRestaurant));
                        final Restaurant data2 = gemRestaurant.getData();
                        if (z11 && data2 != null) {
                            LifecycleCoroutineScope lifecycleScope = LifecycleOwnerKt.getLifecycleScope(gemOfferActivity);
                            final GemOfferActivity gemOfferActivity = gemOfferActivity;
                            final GemRestaurant gemRestaurant = gemRestaurant;
                            Job unused = BuildersKt__Builders_commonKt.launch$default(lifecycleScope, (CoroutineContext) null, (CoroutineStart) null, new AnonymousClass1((Continuation<? super AnonymousClass1>) null), 3, (Object) null);
                        }
                        GemOfferActivityKt.close(gemOfferActivity);
                    }
                });
            }
        }, 12, (Object) null);
    }
}
