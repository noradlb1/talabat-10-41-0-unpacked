package com.talabat.gem.adapters.presentation.collections;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.talabat.gem.IntegrationKt;
import com.talabat.gem.adapters.R;
import com.talabat.gem.adapters.presentation.GemView;
import com.talabat.gem.adapters.presentation.offer.GemOfferMainActivity;
import com.talabat.gem.adapters.presentation.restaurants.RouterKt;
import com.talabat.gem.domain.entities.GemMode;
import com.talabat.gem.domain.entities.GemOffer;
import com.talabat.gem.domain.entities.GemRestaurant;
import com.talabat.gem.domain.usecases.GemCounterBusinessRulesKt;
import com.talabat.gem.domain.usecases.GemEntryBusinessRulesKt;
import com.talabat.gem.domain.usecases.GemOfferRequester;
import com.talabat.gem.domain.usecases.GemViewBusinessRulesKt;
import com.talabat.gem.domain.usecases.SaveUpToAmountText;
import com.talabat.gem.ports.presentation.GemEntryViewPort;
import com.talabat.talabatcommon.extentions.SingleAccess;
import com.talabat.talabatcommon.lifecycle.AutoDisposableDsl;
import com.talabat.talabatcommon.lifecycle.AutoDisposableKt;
import com.talabat.talabatcommon.views.StartForResultCallbacks;
import com.talabat.talabatcommon.views.StartForResultExecutor;
import com.talabat.talabatcore.adapters.FunctionalAdaptersKt;
import io.reactivex.Scheduler;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subjects.BehaviorSubject;
import io.reactivex.subjects.PublishSubject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import sq.a;

@Metadata(d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0000\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\r\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\f\u0010D\u001a\u00020\b*\u00020(H\u0002R\u0016\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\t\u0010\nR\u0016\u0010\f\u001a\u00020\bX\u0004¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\r\u0010\nR\u0016\u0010\u000e\u001a\u00020\bX\u0004¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\u000f\u0010\nR\u0016\u0010\u0010\u001a\u00020\bX\u0004¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\u0011\u0010\nR\"\u0010\u0012\u001a\u0010\u0012\f\u0012\n \u0015*\u0004\u0018\u00010\u00140\u00140\u0013X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\"\u0010\u0018\u001a\u0010\u0012\f\u0012\n \u0015*\u0004\u0018\u00010\u00190\u00190\u0013X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0017R\"\u0010\u001b\u001a\u0010\u0012\f\u0012\n \u0015*\u0004\u0018\u00010\u001c0\u001c0\u0013X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0017R\u0014\u0010\u001e\u001a\u00020\u001fX\u0004¢\u0006\b\n\u0000\u001a\u0004\b \u0010!R\"\u0010\"\u001a\u0010\u0012\f\u0012\n \u0015*\u0004\u0018\u00010$0$0#X\u0004¢\u0006\b\n\u0000\u001a\u0004\b%\u0010&R\u0014\u0010'\u001a\u00020(X\u0004¢\u0006\b\n\u0000\u001a\u0004\b)\u0010*R\u001c\u0010+\u001a\u0010\u0012\f\u0012\n \u0015*\u0004\u0018\u00010,0,0\u0013X\u0004¢\u0006\u0002\n\u0000R\"\u0010-\u001a\u0010\u0012\f\u0012\n \u0015*\u0004\u0018\u00010.0.0\u0013X\u0004¢\u0006\b\n\u0000\u001a\u0004\b/\u0010\u0017R\u0014\u00100\u001a\b\u0012\u0004\u0012\u00020\b01X\u000e¢\u0006\u0002\n\u0000R\u001c\u00102\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b01\u0018\u000103X\u000e¢\u0006\u0002\n\u0000R\u001c\u00104\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b01\u0018\u000103X\u000e¢\u0006\u0002\n\u0000R\u001a\u00105\u001a\u000e\u0012\u0004\u0012\u000207\u0012\u0004\u0012\u00020\b06X\u000e¢\u0006\u0002\n\u0000R\"\u00108\u001a\u0010\u0012\f\u0012\n \u0015*\u0004\u0018\u000109090\u0013X\u0004¢\u0006\b\n\u0000\u001a\u0004\b:\u0010\u0017R\"\u0010;\u001a\u0010\u0012\f\u0012\n \u0015*\u0004\u0018\u00010<0<0\u0013X\u0004¢\u0006\b\n\u0000\u001a\u0004\b=\u0010\u0017R\u0014\u0010>\u001a\u00020?X\u0004¢\u0006\b\n\u0000\u001a\u0004\b@\u0010AR\"\u0010B\u001a\u0010\u0012\f\u0012\n \u0015*\u0004\u0018\u00010\u00190\u00190\u0013X\u0004¢\u0006\b\n\u0000\u001a\u0004\bC\u0010\u0017¨\u0006E"}, d2 = {"Lcom/talabat/gem/adapters/presentation/collections/GemCollectionViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lcom/talabat/gem/ports/presentation/GemEntryViewPort;", "Lcom/talabat/gem/adapters/presentation/GemView;", "parent", "Landroid/view/ViewGroup;", "(Landroid/view/ViewGroup;)V", "bindCounterAndVisibility", "", "getBindCounterAndVisibility", "()Lkotlin/Unit;", "Lkotlin/Unit;", "bindCounterExpired", "getBindCounterExpired", "bindOffer", "getBindOffer", "bindSaveUpToAmountText", "getBindSaveUpToAmountText", "counter", "Lio/reactivex/subjects/BehaviorSubject;", "", "kotlin.jvm.PlatformType", "getCounter", "()Lio/reactivex/subjects/BehaviorSubject;", "counterExpired", "", "getCounterExpired", "counterSubscription", "Lio/reactivex/disposables/Disposable;", "getCounterSubscription", "disposables", "Lio/reactivex/disposables/CompositeDisposable;", "getDisposables", "()Lio/reactivex/disposables/CompositeDisposable;", "errors", "Lio/reactivex/subjects/PublishSubject;", "", "getErrors", "()Lio/reactivex/subjects/PublishSubject;", "initialize", "Landroid/view/View;", "getInitialize", "()Landroid/view/View;", "mode", "Lcom/talabat/gem/domain/entities/GemMode;", "offer", "Lcom/talabat/gem/domain/entities/GemOffer;", "getOffer", "onCancelledAction", "Lkotlin/Function0;", "onDisabledAction", "Lcom/talabat/talabatcommon/extentions/SingleAccess;", "onEnabledAction", "onSelectedAction", "Lkotlin/Function1;", "Lcom/talabat/gem/domain/entities/GemRestaurant;", "remainingSeconds", "", "getRemainingSeconds", "saveUpToAmountText", "Lcom/talabat/gem/domain/usecases/SaveUpToAmountText;", "getSaveUpToAmountText", "scheduler", "Lio/reactivex/Scheduler;", "getScheduler", "()Lio/reactivex/Scheduler;", "visibility", "getVisibility", "openOffers", "com_talabat_Components_gem_gem"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class GemCollectionViewHolder extends RecyclerView.ViewHolder implements GemEntryViewPort, GemView {
    @NotNull
    private final Unit bindCounterAndVisibility;
    @NotNull
    private final Unit bindCounterExpired;
    @NotNull
    private final Unit bindOffer;
    @NotNull
    private final Unit bindSaveUpToAmountText;
    @NotNull
    private final BehaviorSubject<String> counter;
    @NotNull
    private final BehaviorSubject<Boolean> counterExpired;
    @NotNull
    private final BehaviorSubject<Disposable> counterSubscription;
    @NotNull
    private final CompositeDisposable disposables = new CompositeDisposable();
    @NotNull
    private final PublishSubject<Throwable> errors;
    @NotNull
    private final View initialize;
    /* access modifiers changed from: private */
    @NotNull
    public final BehaviorSubject<GemMode> mode;
    @NotNull
    private final BehaviorSubject<GemOffer> offer;
    /* access modifiers changed from: private */
    @NotNull
    public Function0<Unit> onCancelledAction;
    /* access modifiers changed from: private */
    @Nullable
    public SingleAccess<Function0<Unit>> onDisabledAction;
    /* access modifiers changed from: private */
    @Nullable
    public SingleAccess<Function0<Unit>> onEnabledAction;
    /* access modifiers changed from: private */
    @NotNull
    public Function1<? super GemRestaurant, Unit> onSelectedAction;
    @NotNull
    private final BehaviorSubject<Long> remainingSeconds;
    @NotNull
    private final BehaviorSubject<SaveUpToAmountText> saveUpToAmountText;
    @NotNull
    private final Scheduler scheduler;
    @NotNull
    private final BehaviorSubject<Boolean> visibility;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public GemCollectionViewHolder(@NotNull ViewGroup viewGroup) {
        super(FunctionalAdaptersKt.inflateView(viewGroup, R.layout.gem_collections_item));
        Intrinsics.checkNotNullParameter(viewGroup, "parent");
        Scheduler io2 = Schedulers.io();
        Intrinsics.checkNotNullExpressionValue(io2, "io()");
        this.scheduler = io2;
        PublishSubject<Throwable> create = PublishSubject.create();
        Intrinsics.checkNotNullExpressionValue(create, "create<Throwable>()");
        this.errors = create;
        BehaviorSubject<Boolean> create2 = BehaviorSubject.create();
        Intrinsics.checkNotNullExpressionValue(create2, "create<Boolean>()");
        this.visibility = create2;
        BehaviorSubject<GemOffer> create3 = BehaviorSubject.create();
        Intrinsics.checkNotNullExpressionValue(create3, "create<GemOffer>()");
        this.offer = create3;
        BehaviorSubject<String> create4 = BehaviorSubject.create();
        Intrinsics.checkNotNullExpressionValue(create4, "create<String>()");
        this.counter = create4;
        BehaviorSubject<Disposable> create5 = BehaviorSubject.create();
        Intrinsics.checkNotNullExpressionValue(create5, "create<Disposable>()");
        this.counterSubscription = create5;
        BehaviorSubject<SaveUpToAmountText> create6 = BehaviorSubject.create();
        Intrinsics.checkNotNullExpressionValue(create6, "create<SaveUpToAmountText>()");
        this.saveUpToAmountText = create6;
        BehaviorSubject<Boolean> create7 = BehaviorSubject.create();
        Intrinsics.checkNotNullExpressionValue(create7, "create<Boolean>()");
        this.counterExpired = create7;
        BehaviorSubject<Long> create8 = BehaviorSubject.create();
        Intrinsics.checkNotNullExpressionValue(create8, "create<Long>()");
        this.remainingSeconds = create8;
        GemCounterBusinessRulesKt.bindCounterExpired(this);
        Unit unit = Unit.INSTANCE;
        this.bindCounterExpired = unit;
        GemViewBusinessRulesKt.bindOffer$default(this, GemOfferRequester.Existing.INSTANCE, (Function1) null, 2, (Object) null);
        this.bindOffer = unit;
        GemCounterBusinessRulesKt.bindCounterAndVisibility$default(this, (Long) null, 1, (Object) null);
        this.bindCounterAndVisibility = unit;
        GemEntryBusinessRulesKt.bindSaveUpToAmountText(this);
        this.bindSaveUpToAmountText = unit;
        this.onSelectedAction = GemCollectionViewHolder$onSelectedAction$1.INSTANCE;
        this.onCancelledAction = GemCollectionViewHolder$onCancelledAction$1.INSTANCE;
        BehaviorSubject<GemMode> create9 = BehaviorSubject.create();
        Intrinsics.checkNotNullExpressionValue(create9, "create<GemMode>()");
        this.mode = create9;
        View view = this.itemView;
        view.setOnClickListener(new a(this, view));
        Context context = viewGroup.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "parent.context");
        AutoDisposableKt.withAutoDisposables(context, new GemCollectionViewHolder$initialize$1$2(viewGroup, this, view));
        Intrinsics.checkNotNullExpressionValue(view, "itemView.apply {\n\n      …        }\n        }\n    }");
        this.initialize = view;
    }

    /* access modifiers changed from: private */
    /* renamed from: initialize$lambda-1$lambda-0  reason: not valid java name */
    public static final void m10535initialize$lambda1$lambda0(GemCollectionViewHolder gemCollectionViewHolder, View view, View view2) {
        Intrinsics.checkNotNullParameter(gemCollectionViewHolder, "this$0");
        Intrinsics.checkNotNullParameter(view, "$this_apply");
        gemCollectionViewHolder.openOffers(view);
    }

    private final void openOffers(View view) {
        IntegrationKt.getAnalytics().onGemOfferDetailsShown();
        Context context = view.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        StartForResultExecutor<GemRestaurant> startActivityForResult = RouterKt.startActivityForResult(context, GemOfferMainActivity.class);
        StartForResultCallbacks startForResultCallbacks = new StartForResultCallbacks();
        startForResultCallbacks.getOn().success(new GemCollectionViewHolder$openOffers$1$1(this));
        startForResultCallbacks.getOn().cancelled(new GemCollectionViewHolder$openOffers$1$2(this));
        startActivityForResult.with(startForResultCallbacks);
    }

    @AutoDisposableDsl
    public void autoDispose(@NotNull Function0<? extends Disposable> function0) {
        GemEntryViewPort.DefaultImpls.autoDispose(this, function0);
    }

    @NotNull
    public Unit getBindCounterAndVisibility() {
        return this.bindCounterAndVisibility;
    }

    @NotNull
    public Unit getBindCounterExpired() {
        return this.bindCounterExpired;
    }

    @NotNull
    public Unit getBindOffer() {
        return this.bindOffer;
    }

    @NotNull
    public Unit getBindSaveUpToAmountText() {
        return this.bindSaveUpToAmountText;
    }

    @NotNull
    public BehaviorSubject<String> getCounter() {
        return this.counter;
    }

    @NotNull
    public BehaviorSubject<Boolean> getCounterExpired() {
        return this.counterExpired;
    }

    @NotNull
    public BehaviorSubject<Disposable> getCounterSubscription() {
        return this.counterSubscription;
    }

    @NotNull
    public CompositeDisposable getDisposables() {
        return this.disposables;
    }

    @NotNull
    public BehaviorSubject<GemOffer> getOffer() {
        return this.offer;
    }

    @NotNull
    public BehaviorSubject<Long> getRemainingSeconds() {
        return this.remainingSeconds;
    }

    @NotNull
    public BehaviorSubject<SaveUpToAmountText> getSaveUpToAmountText() {
        return this.saveUpToAmountText;
    }

    @NotNull
    public Scheduler getScheduler() {
        return this.scheduler;
    }

    @NotNull
    public BehaviorSubject<Boolean> getVisibility() {
        return this.visibility;
    }

    public void onCleared() {
        GemEntryViewPort.DefaultImpls.onCleared(this);
    }

    @AutoDisposableDsl
    public void onClearedImplementation() {
        GemEntryViewPort.DefaultImpls.onClearedImplementation(this);
    }

    @NotNull
    public PublishSubject<Throwable> getErrors() {
        return this.errors;
    }

    @NotNull
    public View getInitialize() {
        return this.initialize;
    }
}
