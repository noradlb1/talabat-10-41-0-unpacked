package com.talabat.gem.adapters.presentation.home.entrypoint;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.talabat.configuration.location.LocationConfigurationRepository;
import com.talabat.core.experiment.data.TalabatExperiment;
import com.talabat.core.experiment.domain.TalabatExperimentDataSourceStrategy;
import com.talabat.core.fwfprojectskeys.domain.projects.adex.AdExExperimentsKeys;
import com.talabat.core.navigation.domain.Navigator;
import com.talabat.core.navigation.domain.screen.gem.FlutterGemCollectionScreen;
import com.talabat.core.navigation.domain.screen.gem.GemCollectionEntrypoint;
import com.talabat.core.navigation.domain.screen.gem.GemCollectionScreen;
import com.talabat.gem.IntegrationKt;
import com.talabat.gem.adapters.R;
import com.talabat.gem.adapters.presentation.GemView;
import com.talabat.gem.adapters.presentation.GemViewKt;
import com.talabat.gem.domain.entities.GemMode;
import com.talabat.gem.domain.entities.GemOffer;
import com.talabat.gem.domain.entities.GemRestaurant;
import com.talabat.gem.domain.entities.Location;
import com.talabat.gem.domain.usecases.GemCounterBusinessRulesKt;
import com.talabat.gem.domain.usecases.GemEntryBusinessRulesKt;
import com.talabat.gem.domain.usecases.GemOfferRequester;
import com.talabat.gem.domain.usecases.GemRefreshableBusinessRulesKt;
import com.talabat.gem.domain.usecases.GemRestaurantsBusinessRulesKt;
import com.talabat.gem.domain.usecases.GemViewBusinessRulesKt;
import com.talabat.gem.domain.usecases.SaveUpToAmountText;
import com.talabat.gem.ports.presentation.GemEntryViewPort;
import com.talabat.gem.ports.presentation.GemRefreshableViewPort;
import com.talabat.gem.ports.presentation.GemRestaurantsViewPort;
import com.talabat.talabatcommon.extension.ViewKt;
import com.talabat.talabatcommon.lifecycle.AutoDisposableDsl;
import io.reactivex.Scheduler;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subjects.BehaviorSubject;
import io.reactivex.subjects.PublishSubject;
import io.reactivex.subjects.ReplaySubject;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000¼\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u0005B%\b\u0007\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\fJ\u0010\u0010b\u001a\u00020%2\u0006\u0010c\u001a\u00020%H\u0002J\u0010\u0010d\u001a\u00020%2\u0006\u0010c\u001a\u00020%H\u0002J\b\u0010e\u001a\u00020\u000eH\u0002J\b\u0010f\u001a\u00020\u000eH\u0016J\u001a\u0010g\u001a\u00020\u000e2\u0012\u0010H\u001a\u000e\u0012\u0004\u0012\u00020%\u0012\u0004\u0012\u00020\u000e0IR\u0016\u0010\r\u001a\u00020\u000eX\u0004¢\u0006\n\n\u0002\u0010\u0011\u001a\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0012\u001a\u00020\u000eX\u0004¢\u0006\n\n\u0002\u0010\u0011\u001a\u0004\b\u0013\u0010\u0010R\u0016\u0010\u0014\u001a\u00020\u000eX\u0004¢\u0006\n\n\u0002\u0010\u0011\u001a\u0004\b\u0015\u0010\u0010R\u0016\u0010\u0016\u001a\u00020\u000eX\u0004¢\u0006\n\n\u0002\u0010\u0011\u001a\u0004\b\u0017\u0010\u0010R\u0016\u0010\u0018\u001a\u00020\u000eX\u0004¢\u0006\n\n\u0002\u0010\u0011\u001a\u0004\b\u0019\u0010\u0010R\u0016\u0010\u001a\u001a\u00020\u000eX\u0004¢\u0006\n\n\u0002\u0010\u0011\u001a\u0004\b\u001b\u0010\u0010R\u0016\u0010\u001c\u001a\u00020\u000eX\u0004¢\u0006\n\n\u0002\u0010\u0011\u001a\u0004\b\u001d\u0010\u0010R\"\u0010\u001e\u001a\u0010\u0012\f\u0012\n !*\u0004\u0018\u00010 0 0\u001fX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010#R\"\u0010$\u001a\u0010\u0012\f\u0012\n !*\u0004\u0018\u00010%0%0\u001fX\u0004¢\u0006\b\n\u0000\u001a\u0004\b&\u0010#R\"\u0010'\u001a\u0010\u0012\f\u0012\n !*\u0004\u0018\u00010(0(0\u001fX\u0004¢\u0006\b\n\u0000\u001a\u0004\b)\u0010#R\u0014\u0010*\u001a\u00020+X\u0004¢\u0006\b\n\u0000\u001a\u0004\b,\u0010-R\"\u0010.\u001a\u0010\u0012\f\u0012\n !*\u0004\u0018\u000100000/X\u0004¢\u0006\b\n\u0000\u001a\u0004\b1\u00102R\u0016\u00103\u001a\u00020\u000eX\u0004¢\u0006\n\n\u0002\u0010\u0011\u001a\u0004\b4\u0010\u0010R\u001c\u00105\u001a\u0010\u0012\f\u0012\n !*\u0004\u0018\u00010%0%0\u001fX\u0004¢\u0006\u0002\n\u0000R\u001a\u00106\u001a\b\u0012\u0004\u0012\u00020 07X\u0004¢\u0006\b\n\u0000\u001a\u0004\b8\u00109R\u001b\u0010:\u001a\u00020;8FX\u0002¢\u0006\f\n\u0004\b>\u0010?\u001a\u0004\b<\u0010=R\u001a\u0010@\u001a\b\u0012\u0004\u0012\u00020A07X\u0004¢\u0006\b\n\u0000\u001a\u0004\bB\u00109R\u001c\u0010C\u001a\u0010\u0012\f\u0012\n !*\u0004\u0018\u00010D0D0\u001fX\u0004¢\u0006\u0002\n\u0000R\"\u0010E\u001a\u0010\u0012\f\u0012\n !*\u0004\u0018\u00010F0F0\u001fX\u0004¢\u0006\b\n\u0000\u001a\u0004\bG\u0010#R&\u0010H\u001a\u000e\u0012\u0004\u0012\u00020%\u0012\u0004\u0012\u00020\u000e0IX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bJ\u0010K\"\u0004\bL\u0010MR\"\u0010N\u001a\u0010\u0012\f\u0012\n !*\u0004\u0018\u00010A0A0\u001fX\u0004¢\u0006\b\n\u0000\u001a\u0004\bO\u0010#R\"\u0010P\u001a\u0010\u0012\f\u0012\n !*\u0004\u0018\u00010Q0Q0\u001fX\u0004¢\u0006\b\n\u0000\u001a\u0004\bR\u0010#R8\u0010S\u001a&\u0012\"\u0012 \u0012\u0004\u0012\u00020U !*\u0010\u0012\u0004\u0012\u00020U\u0018\u00010Tj\u0004\u0018\u0001`V0Tj\u0002`V0\u001fX\u0004¢\u0006\b\n\u0000\u001a\u0004\bW\u0010#R\"\u0010X\u001a\u0010\u0012\f\u0012\n !*\u0004\u0018\u00010Y0Y0\u001fX\u0004¢\u0006\b\n\u0000\u001a\u0004\bZ\u0010#R\u0014\u0010[\u001a\u00020\\X\u0004¢\u0006\b\n\u0000\u001a\u0004\b]\u0010^R\u001c\u0010_\u001a\u0010\u0012\f\u0012\n !*\u0004\u0018\u00010%0%0\u001fX\u0004¢\u0006\u0002\n\u0000R\"\u0010`\u001a\u0010\u0012\f\u0012\n !*\u0004\u0018\u00010%0%0\u001fX\u0004¢\u0006\b\n\u0000\u001a\u0004\ba\u0010#¨\u0006h"}, d2 = {"Lcom/talabat/gem/adapters/presentation/home/entrypoint/GemHomeEntryPointView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "Lcom/talabat/gem/adapters/presentation/GemView;", "Lcom/talabat/gem/ports/presentation/GemEntryViewPort;", "Lcom/talabat/gem/ports/presentation/GemRestaurantsViewPort;", "Lcom/talabat/gem/ports/presentation/GemRefreshableViewPort;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "bindCounterAndVisibility", "", "getBindCounterAndVisibility", "()Lkotlin/Unit;", "Lkotlin/Unit;", "bindCounterExpired", "getBindCounterExpired", "bindLocalizationHistory", "getBindLocalizationHistory", "bindLocationsHistory", "getBindLocationsHistory", "bindOffer", "getBindOffer", "bindRestaurants", "getBindRestaurants", "bindSaveUpToAmountText", "getBindSaveUpToAmountText", "counter", "Lio/reactivex/subjects/BehaviorSubject;", "", "kotlin.jvm.PlatformType", "getCounter", "()Lio/reactivex/subjects/BehaviorSubject;", "counterExpired", "", "getCounterExpired", "counterSubscription", "Lio/reactivex/disposables/Disposable;", "getCounterSubscription", "disposables", "Lio/reactivex/disposables/CompositeDisposable;", "getDisposables", "()Lio/reactivex/disposables/CompositeDisposable;", "errors", "Lio/reactivex/subjects/PublishSubject;", "", "getErrors", "()Lio/reactivex/subjects/PublishSubject;", "initialize", "getInitialize", "loadedState", "localizationHistory", "Lio/reactivex/subjects/ReplaySubject;", "getLocalizationHistory", "()Lio/reactivex/subjects/ReplaySubject;", "locationConfigRepository", "Lcom/talabat/configuration/location/LocationConfigurationRepository;", "getLocationConfigRepository", "()Lcom/talabat/configuration/location/LocationConfigurationRepository;", "locationConfigRepository$delegate", "Lkotlin/Lazy;", "locationsHistory", "Lcom/talabat/gem/domain/entities/Location;", "getLocationsHistory", "mode", "Lcom/talabat/gem/domain/entities/GemMode;", "offer", "Lcom/talabat/gem/domain/entities/GemOffer;", "getOffer", "onGemAvailabilityCallback", "Lkotlin/Function1;", "getOnGemAvailabilityCallback", "()Lkotlin/jvm/functions/Function1;", "setOnGemAvailabilityCallback", "(Lkotlin/jvm/functions/Function1;)V", "refreshedLocation", "getRefreshedLocation", "remainingSeconds", "", "getRemainingSeconds", "restaurants", "", "Lcom/talabat/gem/domain/entities/GemRestaurant;", "Lcom/talabat/gem/domain/entities/GemRestaurants;", "getRestaurants", "saveUpToAmountText", "Lcom/talabat/gem/domain/usecases/SaveUpToAmountText;", "getSaveUpToAmountText", "scheduler", "Lio/reactivex/Scheduler;", "getScheduler", "()Lio/reactivex/Scheduler;", "viewVisibility", "visibility", "getVisibility", "isAlreadyGone", "visible", "isAlreadyVisible", "navigateToGemCollection", "onCleared", "setAvailabilityCallBack", "com_talabat_Components_gem_gem"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class GemHomeEntryPointView extends ConstraintLayout implements GemView, GemEntryViewPort, GemRestaurantsViewPort, GemRefreshableViewPort {
    @NotNull
    public Map<Integer, View> _$_findViewCache;
    @NotNull
    private final Unit bindCounterAndVisibility;
    @NotNull
    private final Unit bindCounterExpired;
    @NotNull
    private final Unit bindLocalizationHistory;
    @NotNull
    private final Unit bindLocationsHistory;
    @NotNull
    private final Unit bindOffer;
    @NotNull
    private final Unit bindRestaurants;
    @NotNull
    private final Unit bindSaveUpToAmountText;
    @NotNull
    private final BehaviorSubject<String> counter;
    @NotNull
    private final BehaviorSubject<Boolean> counterExpired;
    @NotNull
    private final BehaviorSubject<Disposable> counterSubscription;
    @NotNull
    private final CompositeDisposable disposables;
    @NotNull
    private final PublishSubject<Throwable> errors;
    @NotNull
    private final Unit initialize;
    /* access modifiers changed from: private */
    @NotNull
    public final BehaviorSubject<Boolean> loadedState;
    @NotNull
    private final ReplaySubject<String> localizationHistory;
    @NotNull
    private final Lazy locationConfigRepository$delegate;
    @NotNull
    private final ReplaySubject<Location> locationsHistory;
    /* access modifiers changed from: private */
    @NotNull
    public final BehaviorSubject<GemMode> mode;
    @NotNull
    private final BehaviorSubject<GemOffer> offer;
    @NotNull
    private Function1<? super Boolean, Unit> onGemAvailabilityCallback;
    @NotNull
    private final BehaviorSubject<Location> refreshedLocation;
    @NotNull
    private final BehaviorSubject<Long> remainingSeconds;
    @NotNull
    private final BehaviorSubject<List<GemRestaurant>> restaurants;
    @NotNull
    private final BehaviorSubject<SaveUpToAmountText> saveUpToAmountText;
    @NotNull
    private final Scheduler scheduler;
    /* access modifiers changed from: private */
    @NotNull
    public final BehaviorSubject<Boolean> viewVisibility;
    @NotNull
    private final BehaviorSubject<Boolean> visibility;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public GemHomeEntryPointView(@NotNull Context context) {
        this(context, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public GemHomeEntryPointView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public GemHomeEntryPointView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        Intrinsics.checkNotNullParameter(context, "context");
        this._$_findViewCache = new LinkedHashMap();
        this.locationConfigRepository$delegate = LazyKt__LazyJVMKt.lazy(LazyThreadSafetyMode.NONE, new GemHomeEntryPointView$locationConfigRepository$2(this));
        this.disposables = new CompositeDisposable();
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
        BehaviorSubject<List<GemRestaurant>> create9 = BehaviorSubject.create();
        Intrinsics.checkNotNullExpressionValue(create9, "create<GemRestaurants>()");
        this.restaurants = create9;
        BehaviorSubject<Location> create10 = BehaviorSubject.create();
        Intrinsics.checkNotNullExpressionValue(create10, "create<Location>()");
        this.refreshedLocation = create10;
        this.locationsHistory = GemRefreshableBusinessRulesKt.createLocationsSubject(this);
        GemRefreshableBusinessRulesKt.bindLocationsHistory$default(this, (Function0) null, 1, (Object) null);
        Unit unit = Unit.INSTANCE;
        this.bindLocationsHistory = unit;
        this.localizationHistory = GemRefreshableBusinessRulesKt.createLocalizationSubject(this);
        GemRefreshableBusinessRulesKt.bindLocalizationHistory$default(this, (Function0) null, 1, (Object) null);
        this.bindLocalizationHistory = unit;
        GemViewBusinessRulesKt.bindOffer$default(this, GemOfferRequester.Refresh.INSTANCE, (Function1) null, 2, (Object) null);
        this.bindOffer = unit;
        GemCounterBusinessRulesKt.bindCounterExpired(this);
        this.bindCounterExpired = unit;
        GemCounterBusinessRulesKt.bindCounterAndVisibility$default(this, (Long) null, 1, (Object) null);
        this.bindCounterAndVisibility = unit;
        GemEntryBusinessRulesKt.bindSaveUpToAmountText(this);
        this.bindSaveUpToAmountText = unit;
        GemRestaurantsBusinessRulesKt.bindRestaurants(this);
        this.bindRestaurants = unit;
        this.onGemAvailabilityCallback = GemHomeEntryPointView$onGemAvailabilityCallback$1.INSTANCE;
        BehaviorSubject<GemMode> create11 = BehaviorSubject.create();
        Intrinsics.checkNotNullExpressionValue(create11, "create<GemMode>()");
        this.mode = create11;
        BehaviorSubject<Boolean> create12 = BehaviorSubject.create();
        Intrinsics.checkNotNullExpressionValue(create12, "create<Boolean>()");
        this.loadedState = create12;
        this.viewVisibility = getVisibility();
        GemViewKt.withGemFlowTracking(this, context, new GemHomeEntryPointView$initialize$1(this, context));
        this.initialize = unit;
    }

    /* access modifiers changed from: private */
    public final boolean isAlreadyGone(boolean z11) {
        return !z11 && !ViewKt.isVisible(this);
    }

    /* access modifiers changed from: private */
    public final boolean isAlreadyVisible(boolean z11) {
        if (z11) {
            View _$_findCachedViewById = _$_findCachedViewById(R.id.layout_gem_loaded);
            Intrinsics.checkNotNullExpressionValue(_$_findCachedViewById, "layout_gem_loaded");
            if (ViewKt.isVisible(_$_findCachedViewById)) {
                return true;
            }
        }
        return false;
    }

    /* access modifiers changed from: private */
    public final void navigateToGemCollection() {
        if (Intrinsics.areEqual((Object) TalabatExperiment.INSTANCE.getStringVariant(AdExExperimentsKeys.SHOW_FLUTTER_GEM_COLLECTION, "Control", TalabatExperimentDataSourceStrategy.FWF), (Object) "Control")) {
            Navigator navigator = IntegrationKt.getNavigator();
            Context context = getContext();
            Intrinsics.checkNotNullExpressionValue(context, "context");
            Navigator.DefaultImpls.navigateTo$default(navigator, context, new GemCollectionScreen(new GemCollectionScreen.GemCollectionData(GemCollectionEntrypoint.HOME)), (Function1) null, 4, (Object) null);
            return;
        }
        Navigator navigator2 = IntegrationKt.getNavigator();
        Context context2 = getContext();
        Intrinsics.checkNotNullExpressionValue(context2, "context");
        Navigator.DefaultImpls.navigateTo$default(navigator2, context2, new FlutterGemCollectionScreen(new FlutterGemCollectionScreen.FlutterGemCollectionData(GemCollectionEntrypoint.HOME)), (Function1) null, 4, (Object) null);
    }

    public void _$_clearFindViewByIdCache() {
        this._$_findViewCache.clear();
    }

    @Nullable
    public View _$_findCachedViewById(int i11) {
        Map<Integer, View> map = this._$_findViewCache;
        View view = map.get(Integer.valueOf(i11));
        if (view != null) {
            return view;
        }
        View findViewById = findViewById(i11);
        if (findViewById == null) {
            return null;
        }
        map.put(Integer.valueOf(i11), findViewById);
        return findViewById;
    }

    @AutoDisposableDsl
    public void autoDispose(@NotNull Function0<? extends Disposable> function0) {
        GemView.DefaultImpls.autoDispose(this, function0);
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
    public Unit getBindLocalizationHistory() {
        return this.bindLocalizationHistory;
    }

    @NotNull
    public Unit getBindLocationsHistory() {
        return this.bindLocationsHistory;
    }

    @NotNull
    public Unit getBindOffer() {
        return this.bindOffer;
    }

    @NotNull
    public Unit getBindRestaurants() {
        return this.bindRestaurants;
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
    public ReplaySubject<String> getLocalizationHistory() {
        return this.localizationHistory;
    }

    @NotNull
    public final LocationConfigurationRepository getLocationConfigRepository() {
        return (LocationConfigurationRepository) this.locationConfigRepository$delegate.getValue();
    }

    @NotNull
    public ReplaySubject<Location> getLocationsHistory() {
        return this.locationsHistory;
    }

    @NotNull
    public BehaviorSubject<GemOffer> getOffer() {
        return this.offer;
    }

    @NotNull
    public final Function1<Boolean, Unit> getOnGemAvailabilityCallback() {
        return this.onGemAvailabilityCallback;
    }

    @NotNull
    public BehaviorSubject<Location> getRefreshedLocation() {
        return this.refreshedLocation;
    }

    @NotNull
    public BehaviorSubject<Long> getRemainingSeconds() {
        return this.remainingSeconds;
    }

    @NotNull
    public BehaviorSubject<List<GemRestaurant>> getRestaurants() {
        return this.restaurants;
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
        GemView.DefaultImpls.onClearedImplementation(this);
    }

    public final void setAvailabilityCallBack(@NotNull Function1<? super Boolean, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "onGemAvailabilityCallback");
        this.onGemAvailabilityCallback = function1;
    }

    public final void setOnGemAvailabilityCallback(@NotNull Function1<? super Boolean, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "<set-?>");
        this.onGemAvailabilityCallback = function1;
    }

    @NotNull
    public PublishSubject<Throwable> getErrors() {
        return this.errors;
    }

    @NotNull
    public Unit getInitialize() {
        return this.initialize;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ GemHomeEntryPointView(Context context, AttributeSet attributeSet, int i11, int i12, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i12 & 2) != 0 ? null : attributeSet, (i12 & 4) != 0 ? 0 : i11);
    }
}
