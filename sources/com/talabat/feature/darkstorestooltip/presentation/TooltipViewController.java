package com.talabat.feature.darkstorestooltip.presentation;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.talabat.core.dispatcher.domain.RxSchedulersFactory;
import com.talabat.feature.darkstorestooltip.domain.usecase.SetTooltipShown;
import com.talabat.feature.darkstorestooltip.domain.usecase.WasTooltipAlreadyShown;
import com.talabat.feature.darkstorestooltip.presentation.TooltipViewState;
import com.talabat.feature.darkstorestooltip.presentation.util.ExtensionsKt;
import com.talabat.wrapper.EventWrapper;
import io.reactivex.Completable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;
import io.reactivex.rxkotlin.DisposableKt;
import java.util.concurrent.TimeUnit;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import rm.b;
import rm.c;

@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u001f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\r\u0010\u0017\u001a\u00020\u0018H\u0000¢\u0006\u0002\b\u0019J\u0006\u0010\u001a\u001a\u00020\u0018J\u0006\u0010\u001b\u001a\u00020\u0018J\u000e\u0010\u001c\u001a\u00020\u00182\u0006\u0010\u0011\u001a\u00020\u0012J\u0010\u0010\u001d\u001a\u00020\u00182\u0006\u0010\u0011\u001a\u00020\u0012H\u0002J\b\u0010\u001e\u001a\u00020\u0018H\u0002R\u001a\u0010\t\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u000b0\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X.¢\u0006\u0002\n\u0000R\u001d\u0010\u0013\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u000b0\u00148F¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u001f"}, d2 = {"Lcom/talabat/feature/darkstorestooltip/presentation/TooltipViewController;", "", "wasTooltipAlreadyShown", "Lcom/talabat/feature/darkstorestooltip/domain/usecase/WasTooltipAlreadyShown;", "setTooltipShown", "Lcom/talabat/feature/darkstorestooltip/domain/usecase/SetTooltipShown;", "rxSchedulersFactory", "Lcom/talabat/core/dispatcher/domain/RxSchedulersFactory;", "(Lcom/talabat/feature/darkstorestooltip/domain/usecase/WasTooltipAlreadyShown;Lcom/talabat/feature/darkstorestooltip/domain/usecase/SetTooltipShown;Lcom/talabat/core/dispatcher/domain/RxSchedulersFactory;)V", "_viewStateLiveData", "Landroidx/lifecycle/MutableLiveData;", "Lcom/talabat/wrapper/EventWrapper;", "Lcom/talabat/feature/darkstorestooltip/presentation/TooltipViewState;", "compositeDisposable", "Lio/reactivex/disposables/CompositeDisposable;", "isVisible", "", "tooltipData", "Lcom/talabat/feature/darkstorestooltip/presentation/TooltipData;", "viewState", "Landroidx/lifecycle/LiveData;", "getViewState", "()Landroidx/lifecycle/LiveData;", "hideTooltip", "", "hideTooltip$com_talabat_feature_darkstores_tooltip_presentation_presentation", "onCleared", "onTooltipClicked", "setUp", "setUpDismissOnTimeout", "showTooltip", "com_talabat_feature_darkstores-tooltip_presentation_presentation"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class TooltipViewController {
    @NotNull
    private MutableLiveData<EventWrapper<TooltipViewState>> _viewStateLiveData = new MutableLiveData<>();
    @NotNull
    private final CompositeDisposable compositeDisposable = new CompositeDisposable();
    private boolean isVisible;
    @NotNull
    private final RxSchedulersFactory rxSchedulersFactory;
    @NotNull
    private final SetTooltipShown setTooltipShown;
    private TooltipData tooltipData;
    @NotNull
    private final WasTooltipAlreadyShown wasTooltipAlreadyShown;

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[ShowStrategy.values().length];
            iArr[ShowStrategy.EveryTime.ordinal()] = 1;
            iArr[ShowStrategy.Once.ordinal()] = 2;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    @Inject
    public TooltipViewController(@NotNull WasTooltipAlreadyShown wasTooltipAlreadyShown2, @NotNull SetTooltipShown setTooltipShown2, @NotNull RxSchedulersFactory rxSchedulersFactory2) {
        Intrinsics.checkNotNullParameter(wasTooltipAlreadyShown2, "wasTooltipAlreadyShown");
        Intrinsics.checkNotNullParameter(setTooltipShown2, "setTooltipShown");
        Intrinsics.checkNotNullParameter(rxSchedulersFactory2, "rxSchedulersFactory");
        this.wasTooltipAlreadyShown = wasTooltipAlreadyShown2;
        this.setTooltipShown = setTooltipShown2;
        this.rxSchedulersFactory = rxSchedulersFactory2;
    }

    /* access modifiers changed from: private */
    /* renamed from: setUp$lambda-0  reason: not valid java name */
    public static final void m10213setUp$lambda0(TooltipViewController tooltipViewController, Boolean bool) {
        Intrinsics.checkNotNullParameter(tooltipViewController, "this$0");
        Intrinsics.checkNotNullExpressionValue(bool, "wasShownAtLeastOnce");
        if (bool.booleanValue()) {
            tooltipViewController.hideTooltip$com_talabat_feature_darkstores_tooltip_presentation_presentation();
        } else {
            tooltipViewController.showTooltip();
        }
    }

    private final void setUpDismissOnTimeout(TooltipData tooltipData2) {
        if (tooltipData2.getDismissOnTimeout()) {
            Disposable subscribe = Completable.timer(tooltipData2.getTimeoutDurationSeconds(), TimeUnit.SECONDS, this.rxSchedulersFactory.io()).subscribe((Action) new c(this));
            Intrinsics.checkNotNullExpressionValue(subscribe, "timer(tooltipData.timeou…oltip()\n                }");
            DisposableKt.addTo(subscribe, this.compositeDisposable);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: setUpDismissOnTimeout$lambda-1  reason: not valid java name */
    public static final void m10214setUpDismissOnTimeout$lambda1(TooltipViewController tooltipViewController) {
        Intrinsics.checkNotNullParameter(tooltipViewController, "this$0");
        tooltipViewController.hideTooltip$com_talabat_feature_darkstores_tooltip_presentation_presentation();
    }

    private final void showTooltip() {
        MutableLiveData<EventWrapper<TooltipViewState>> mutableLiveData = this._viewStateLiveData;
        TooltipData tooltipData2 = this.tooltipData;
        TooltipData tooltipData3 = null;
        if (tooltipData2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tooltipData");
            tooltipData2 = null;
        }
        mutableLiveData.postValue(new EventWrapper(new TooltipViewState.Shown(tooltipData2)));
        this.isVisible = true;
        TooltipData tooltipData4 = this.tooltipData;
        if (tooltipData4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tooltipData");
            tooltipData4 = null;
        }
        setUpDismissOnTimeout(tooltipData4);
        SetTooltipShown setTooltipShown2 = this.setTooltipShown;
        TooltipData tooltipData5 = this.tooltipData;
        if (tooltipData5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tooltipData");
        } else {
            tooltipData3 = tooltipData5;
        }
        Disposable subscribe = setTooltipShown2.invoke(tooltipData3.getKey(), true).subscribeOn(this.rxSchedulersFactory.io()).subscribe();
        Intrinsics.checkNotNullExpressionValue(subscribe, "setTooltipShown(tooltipD…\n            .subscribe()");
        DisposableKt.addTo(subscribe, this.compositeDisposable);
    }

    @NotNull
    public final LiveData<EventWrapper<TooltipViewState>> getViewState() {
        return this._viewStateLiveData;
    }

    public final void hideTooltip$com_talabat_feature_darkstores_tooltip_presentation_presentation() {
        if (this.isVisible) {
            this._viewStateLiveData.postValue(new EventWrapper(TooltipViewState.Hidden.INSTANCE));
            this.isVisible = false;
            this.compositeDisposable.clear();
        }
    }

    public final void onCleared() {
        this.compositeDisposable.dispose();
    }

    public final void onTooltipClicked() {
        if (this.isVisible) {
            hideTooltip$com_talabat_feature_darkstores_tooltip_presentation_presentation();
            return;
        }
        TooltipData tooltipData2 = this.tooltipData;
        if (tooltipData2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tooltipData");
            tooltipData2 = null;
        }
        if (tooltipData2.getShowStrategy() == ShowStrategy.EveryTime) {
            showTooltip();
        }
    }

    public final void setUp(@NotNull TooltipData tooltipData2) {
        Unit unit;
        Intrinsics.checkNotNullParameter(tooltipData2, "tooltipData");
        this.tooltipData = tooltipData2;
        int i11 = WhenMappings.$EnumSwitchMapping$0[tooltipData2.getShowStrategy().ordinal()];
        if (i11 == 1) {
            showTooltip();
            unit = Unit.INSTANCE;
        } else if (i11 == 2) {
            Disposable subscribe = this.wasTooltipAlreadyShown.invoke(tooltipData2.getKey()).subscribeOn(this.rxSchedulersFactory.io()).subscribe(new b(this));
            Intrinsics.checkNotNullExpressionValue(subscribe, "wasTooltipAlreadyShown(t…                        }");
            ExtensionsKt.getReturnUnit(DisposableKt.addTo(subscribe, this.compositeDisposable));
            unit = Unit.INSTANCE;
        } else {
            throw new NoWhenBranchMatchedException();
        }
        ExtensionsKt.getExhaustive(unit);
    }
}
