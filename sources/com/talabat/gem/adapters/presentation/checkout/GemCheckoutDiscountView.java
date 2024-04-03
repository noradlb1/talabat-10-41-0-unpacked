package com.talabat.gem.adapters.presentation.checkout;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.talabat.gem.adapters.presentation.ConfigurationsKt;
import com.talabat.gem.adapters.presentation.GemCheckoutDiscountConfigurations;
import com.talabat.gem.adapters.presentation.GemView;
import com.talabat.gem.adapters.presentation.GemViewKt;
import com.talabat.gem.adapters.presentation.GemViewsDsl;
import com.talabat.gem.domain.entities.GemOffer;
import com.talabat.gem.domain.entities.GemRestaurant;
import com.talabat.gem.domain.entities.GemTier;
import com.talabat.gem.domain.usecases.GemCounterBusinessRulesKt;
import com.talabat.gem.domain.usecases.GemDiscountBusinessRulesKt;
import com.talabat.gem.domain.usecases.GemOfferRequester;
import com.talabat.gem.domain.usecases.GemPerRestaurantBusinessRulesKt;
import com.talabat.gem.domain.usecases.GemSubTotalBusinessRulesKt;
import com.talabat.gem.domain.usecases.GemTiersBusinessRulesKt;
import com.talabat.gem.domain.usecases.GemViewBusinessRulesKt;
import com.talabat.gem.domain.usecases.SubTotalLineOne;
import com.talabat.gem.domain.usecases.SubTotalLineTwo;
import com.talabat.gem.ports.presentation.GemDiscountViewPort;
import com.talabat.talabatcommon.extentions.RxKt;
import com.talabat.talabatcommon.extentions.SingleAccess;
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
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000Ì\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0006\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u0017\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bJ\"\u0010v\u001a\u00020\n2\u0017\u0010w\u001a\u0013\u0012\u0004\u0012\u00020*\u0012\u0004\u0012\u00020\n0R¢\u0006\u0002\bxH\u0002R\u0016\u0010\t\u001a\u00020\nX\u0004¢\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u000b\u0010\fR\u0016\u0010\u000e\u001a\u00020\nX\u0004¢\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u000f\u0010\fR\u0016\u0010\u0010\u001a\u00020\nX\u0004¢\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u0011\u0010\fR\u0016\u0010\u0012\u001a\u00020\nX\u0004¢\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u0013\u0010\fR\u0016\u0010\u0014\u001a\u00020\nX\u0004¢\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u0015\u0010\fR\u0016\u0010\u0016\u001a\u00020\nX\u0004¢\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u0017\u0010\fR\u0016\u0010\u0018\u001a\u00020\nX\u0004¢\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u0019\u0010\fR\u0016\u0010\u001a\u001a\u00020\nX\u0004¢\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u001b\u0010\fR\u0016\u0010\u001c\u001a\u00020\nX\u0004¢\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u001d\u0010\fR\u0016\u0010\u001e\u001a\u00020\nX\u0004¢\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u001f\u0010\fR\u0016\u0010 \u001a\u00020\nX\u0004¢\u0006\n\n\u0002\u0010\r\u001a\u0004\b!\u0010\fR\u0016\u0010\"\u001a\u00020\nX\u0004¢\u0006\n\n\u0002\u0010\r\u001a\u0004\b#\u0010\fR\u0016\u0010$\u001a\u00020\nX\u0004¢\u0006\n\n\u0002\u0010\r\u001a\u0004\b%\u0010\fR\u0016\u0010&\u001a\u00020\nX\u0004¢\u0006\n\n\u0002\u0010\r\u001a\u0004\b'\u0010\fR\u001c\u0010(\u001a\u0010\u0012\f\u0012\n +*\u0004\u0018\u00010*0*0)X\u0004¢\u0006\u0002\n\u0000R\"\u0010,\u001a\u0010\u0012\f\u0012\n +*\u0004\u0018\u00010.0.0-X\u0004¢\u0006\b\n\u0000\u001a\u0004\b/\u00100R\"\u00101\u001a\u0010\u0012\f\u0012\n +*\u0004\u0018\u000102020-X\u0004¢\u0006\b\n\u0000\u001a\u0004\b3\u00100R\"\u00104\u001a\u0010\u0012\f\u0012\n +*\u0004\u0018\u000105050-X\u0004¢\u0006\b\n\u0000\u001a\u0004\b6\u00100R\"\u00107\u001a\u0010\u0012\f\u0012\n +*\u0004\u0018\u00010.0.0-X\u0004¢\u0006\b\n\u0000\u001a\u0004\b8\u00100R\"\u00109\u001a\u0010\u0012\f\u0012\n +*\u0004\u0018\u00010:0:0-X\u0004¢\u0006\b\n\u0000\u001a\u0004\b;\u00100R\"\u0010<\u001a\u0010\u0012\f\u0012\n +*\u0004\u0018\u00010.0.0-X\u0004¢\u0006\b\n\u0000\u001a\u0004\b=\u00100R\"\u0010>\u001a\u0010\u0012\f\u0012\n +*\u0004\u0018\u000102020-X\u0004¢\u0006\b\n\u0000\u001a\u0004\b?\u00100R\u0014\u0010@\u001a\u00020AX\u0004¢\u0006\b\n\u0000\u001a\u0004\bB\u0010CR\"\u0010D\u001a\u0010\u0012\f\u0012\n +*\u0004\u0018\u00010F0F0EX\u0004¢\u0006\b\n\u0000\u001a\u0004\bG\u0010HR\u0016\u0010I\u001a\u00020\nX\u0004¢\u0006\n\n\u0002\u0010\r\u001a\u0004\bJ\u0010\fR\"\u0010K\u001a\u0010\u0012\f\u0012\n +*\u0004\u0018\u00010L0L0-X\u0004¢\u0006\b\n\u0000\u001a\u0004\bM\u00100R\u001c\u0010N\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0P\u0018\u00010OX\u000e¢\u0006\u0002\n\u0000R\u001c\u0010Q\u001a\u0010\u0012\u0004\u0012\u00020:\u0012\u0004\u0012\u00020\n\u0018\u00010RX\u000e¢\u0006\u0002\n\u0000R\u001c\u0010S\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0P\u0018\u00010OX\u000e¢\u0006\u0002\n\u0000R\"\u0010T\u001a\u0010\u0012\f\u0012\n +*\u0004\u0018\u00010U0U0-X\u0004¢\u0006\b\n\u0000\u001a\u0004\bV\u00100R\u0014\u0010W\u001a\u00020XX\u0004¢\u0006\b\n\u0000\u001a\u0004\bY\u0010ZR\"\u0010[\u001a\u0010\u0012\f\u0012\n +*\u0004\u0018\u00010\\0\\0-X\u0004¢\u0006\b\n\u0000\u001a\u0004\b]\u00100R\"\u0010^\u001a\u0010\u0012\f\u0012\n +*\u0004\u0018\u00010_0_0-X\u0004¢\u0006\b\n\u0000\u001a\u0004\b`\u00100R\"\u0010a\u001a\u0010\u0012\f\u0012\n +*\u0004\u0018\u000102020-X\u0004¢\u0006\b\n\u0000\u001a\u0004\bb\u00100R\"\u0010c\u001a\u0010\u0012\f\u0012\n +*\u0004\u0018\u00010d0d0-X\u0004¢\u0006\b\n\u0000\u001a\u0004\be\u00100R\"\u0010f\u001a\u0010\u0012\f\u0012\n +*\u0004\u0018\u00010g0g0-X\u0004¢\u0006\b\n\u0000\u001a\u0004\bh\u00100R\"\u0010i\u001a\u0010\u0012\f\u0012\n +*\u0004\u0018\u00010:0:0-X\u0004¢\u0006\b\n\u0000\u001a\u0004\bj\u00100R\"\u0010k\u001a\u0010\u0012\f\u0012\n +*\u0004\u0018\u000102020-X\u0004¢\u0006\b\n\u0000\u001a\u0004\bl\u00100R8\u0010m\u001a&\u0012\"\u0012 \u0012\u0004\u0012\u00020o +*\u0010\u0012\u0004\u0012\u00020o\u0018\u00010nj\u0004\u0018\u0001`p0nj\u0002`p0-X\u0004¢\u0006\b\n\u0000\u001a\u0004\bq\u00100R\"\u0010r\u001a\u0010\u0012\f\u0012\n +*\u0004\u0018\u000102020-X\u0004¢\u0006\b\n\u0000\u001a\u0004\bs\u00100R\"\u0010t\u001a\u0010\u0012\f\u0012\n +*\u0004\u0018\u000102020-X\u0004¢\u0006\b\n\u0000\u001a\u0004\bu\u00100¨\u0006y"}, d2 = {"Lcom/talabat/gem/adapters/presentation/checkout/GemCheckoutDiscountView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "Lcom/talabat/gem/ports/presentation/GemDiscountViewPort;", "Lcom/talabat/gem/adapters/presentation/GemView;", "context", "Landroid/content/Context;", "attribute", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "bindCounterAndVisibility", "", "getBindCounterAndVisibility", "()Lkotlin/Unit;", "Lkotlin/Unit;", "bindCounterExpired", "getBindCounterExpired", "bindCurrency", "getBindCurrency", "bindDiscountAmount", "getBindDiscountAmount", "bindDiscountText", "getBindDiscountText", "bindDiscountVisibility", "getBindDiscountVisibility", "bindOffer", "getBindOffer", "bindSelectedGemRestaurant", "getBindSelectedGemRestaurant", "bindStaticTiersMode", "getBindStaticTiersMode", "bindSubTitleLineOne", "getBindSubTitleLineOne", "bindSubTitleLineTwo", "getBindSubTitleLineTwo", "bindSubTotalVisibility", "getBindSubTotalVisibility", "bindTiers", "getBindTiers", "bindVisibilityPerRestaurant", "getBindVisibilityPerRestaurant", "configurations", "Lio/reactivex/subjects/ReplaySubject;", "Lcom/talabat/gem/adapters/presentation/GemCheckoutDiscountConfigurations;", "kotlin.jvm.PlatformType", "counter", "Lio/reactivex/subjects/BehaviorSubject;", "", "getCounter", "()Lio/reactivex/subjects/BehaviorSubject;", "counterExpired", "", "getCounterExpired", "counterSubscription", "Lio/reactivex/disposables/Disposable;", "getCounterSubscription", "currency", "getCurrency", "discountAmount", "", "getDiscountAmount", "discountText", "getDiscountText", "discountVisibility", "getDiscountVisibility", "disposables", "Lio/reactivex/disposables/CompositeDisposable;", "getDisposables", "()Lio/reactivex/disposables/CompositeDisposable;", "errors", "Lio/reactivex/subjects/PublishSubject;", "", "getErrors", "()Lio/reactivex/subjects/PublishSubject;", "initialize", "getInitialize", "offer", "Lcom/talabat/gem/domain/entities/GemOffer;", "getOffer", "onDisabledAction", "Lcom/talabat/talabatcommon/extentions/SingleAccess;", "Lkotlin/Function0;", "onDiscountAction", "Lkotlin/Function1;", "onEnabledAction", "remainingSeconds", "", "getRemainingSeconds", "scheduler", "Lio/reactivex/Scheduler;", "getScheduler", "()Lio/reactivex/Scheduler;", "selectedGemRestaurant", "Lcom/talabat/gem/domain/entities/GemRestaurant;", "getSelectedGemRestaurant", "selectedRestaurantId", "", "getSelectedRestaurantId", "staticTiersMode", "getStaticTiersMode", "subTitleLineOne", "Lcom/talabat/gem/domain/usecases/SubTotalLineOne;", "getSubTitleLineOne", "subTitleLineTwo", "Lcom/talabat/gem/domain/usecases/SubTotalLineTwo;", "getSubTitleLineTwo", "subTotal", "getSubTotal", "subTotalVisibility", "getSubTotalVisibility", "tiers", "", "Lcom/talabat/gem/domain/entities/GemTier;", "Lcom/talabat/gem/domain/entities/GemTiers;", "getTiers", "visibility", "getVisibility", "visibilityPerRestaurant", "getVisibilityPerRestaurant", "invoke", "configurationInitializer", "Lkotlin/ExtensionFunctionType;", "com_talabat_Components_gem_gem"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class GemCheckoutDiscountView extends ConstraintLayout implements GemDiscountViewPort, GemView {
    @NotNull
    public Map<Integer, View> _$_findViewCache = new LinkedHashMap();
    @NotNull
    private final Unit bindCounterAndVisibility;
    @NotNull
    private final Unit bindCounterExpired;
    @NotNull
    private final Unit bindCurrency;
    @NotNull
    private final Unit bindDiscountAmount;
    @NotNull
    private final Unit bindDiscountText;
    @NotNull
    private final Unit bindDiscountVisibility;
    @NotNull
    private final Unit bindOffer;
    @NotNull
    private final Unit bindSelectedGemRestaurant;
    @NotNull
    private final Unit bindStaticTiersMode;
    @NotNull
    private final Unit bindSubTitleLineOne;
    @NotNull
    private final Unit bindSubTitleLineTwo;
    @NotNull
    private final Unit bindSubTotalVisibility;
    @NotNull
    private final Unit bindTiers;
    @NotNull
    private final Unit bindVisibilityPerRestaurant;
    /* access modifiers changed from: private */
    @NotNull
    public final ReplaySubject<GemCheckoutDiscountConfigurations> configurations;
    @NotNull
    private final BehaviorSubject<String> counter;
    @NotNull
    private final BehaviorSubject<Boolean> counterExpired;
    @NotNull
    private final BehaviorSubject<Disposable> counterSubscription;
    @NotNull
    private final BehaviorSubject<String> currency;
    @NotNull
    private final BehaviorSubject<Double> discountAmount;
    @NotNull
    private final BehaviorSubject<String> discountText;
    @NotNull
    private final BehaviorSubject<Boolean> discountVisibility;
    @NotNull
    private final CompositeDisposable disposables;
    @NotNull
    private final PublishSubject<Throwable> errors;
    @NotNull
    private final Unit initialize;
    @NotNull
    private final BehaviorSubject<GemOffer> offer;
    /* access modifiers changed from: private */
    @Nullable
    public SingleAccess<Function0<Unit>> onDisabledAction;
    /* access modifiers changed from: private */
    @Nullable
    public Function1<? super Double, Unit> onDiscountAction;
    /* access modifiers changed from: private */
    @Nullable
    public SingleAccess<Function0<Unit>> onEnabledAction;
    @NotNull
    private final BehaviorSubject<Long> remainingSeconds;
    @NotNull
    private final Scheduler scheduler;
    @NotNull
    private final BehaviorSubject<GemRestaurant> selectedGemRestaurant;
    @NotNull
    private final BehaviorSubject<Integer> selectedRestaurantId;
    @NotNull
    private final BehaviorSubject<Boolean> staticTiersMode;
    @NotNull
    private final BehaviorSubject<SubTotalLineOne> subTitleLineOne;
    @NotNull
    private final BehaviorSubject<SubTotalLineTwo> subTitleLineTwo;
    @NotNull
    private final BehaviorSubject<Double> subTotal;
    @NotNull
    private final BehaviorSubject<Boolean> subTotalVisibility;
    @NotNull
    private final BehaviorSubject<List<GemTier>> tiers;
    @NotNull
    private final BehaviorSubject<Boolean> visibility;
    @NotNull
    private final BehaviorSubject<Boolean> visibilityPerRestaurant;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public GemCheckoutDiscountView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        this.disposables = new CompositeDisposable();
        Scheduler io2 = Schedulers.io();
        Intrinsics.checkNotNullExpressionValue(io2, "io()");
        this.scheduler = io2;
        BehaviorSubject<String> create = BehaviorSubject.create();
        Intrinsics.checkNotNullExpressionValue(create, "create<String>()");
        this.discountText = create;
        BehaviorSubject<Double> create2 = BehaviorSubject.create();
        Intrinsics.checkNotNullExpressionValue(create2, "create<Double>()");
        this.subTotal = create2;
        BehaviorSubject<String> create3 = BehaviorSubject.create();
        Intrinsics.checkNotNullExpressionValue(create3, "create<String>()");
        this.currency = create3;
        BehaviorSubject<SubTotalLineOne> create4 = BehaviorSubject.create();
        Intrinsics.checkNotNullExpressionValue(create4, "create<SubTotalLineOne>()");
        this.subTitleLineOne = create4;
        BehaviorSubject<SubTotalLineTwo> create5 = BehaviorSubject.create();
        Intrinsics.checkNotNullExpressionValue(create5, "create<SubTotalLineTwo>()");
        this.subTitleLineTwo = create5;
        BehaviorSubject<Boolean> create6 = BehaviorSubject.create();
        Intrinsics.checkNotNullExpressionValue(create6, "create<Boolean>()");
        this.subTotalVisibility = create6;
        BehaviorSubject<List<GemTier>> create7 = BehaviorSubject.create();
        Intrinsics.checkNotNullExpressionValue(create7, "create<GemTiers>()");
        this.tiers = create7;
        BehaviorSubject<Boolean> create8 = BehaviorSubject.create();
        Intrinsics.checkNotNullExpressionValue(create8, "create<Boolean>()");
        this.visibility = create8;
        PublishSubject<Throwable> create9 = PublishSubject.create();
        Intrinsics.checkNotNullExpressionValue(create9, "create<Throwable>()");
        this.errors = create9;
        BehaviorSubject<GemOffer> create10 = BehaviorSubject.create();
        Intrinsics.checkNotNullExpressionValue(create10, "create<GemOffer>()");
        this.offer = create10;
        BehaviorSubject<Integer> create11 = BehaviorSubject.create();
        Intrinsics.checkNotNullExpressionValue(create11, "create<Int>()");
        this.selectedRestaurantId = create11;
        BehaviorSubject<GemRestaurant> create12 = BehaviorSubject.create();
        Intrinsics.checkNotNullExpressionValue(create12, "create<GemRestaurant>()");
        this.selectedGemRestaurant = create12;
        BehaviorSubject<Boolean> create13 = BehaviorSubject.create();
        Intrinsics.checkNotNullExpressionValue(create13, "create<Boolean>()");
        this.visibilityPerRestaurant = create13;
        BehaviorSubject<String> create14 = BehaviorSubject.create();
        Intrinsics.checkNotNullExpressionValue(create14, "create<String>()");
        this.counter = create14;
        BehaviorSubject<Disposable> create15 = BehaviorSubject.create();
        Intrinsics.checkNotNullExpressionValue(create15, "create<Disposable>()");
        this.counterSubscription = create15;
        BehaviorSubject<Boolean> create16 = BehaviorSubject.create();
        Intrinsics.checkNotNullExpressionValue(create16, "create<Boolean>()");
        this.counterExpired = create16;
        BehaviorSubject<Long> create17 = BehaviorSubject.create();
        Intrinsics.checkNotNullExpressionValue(create17, "create<Long>()");
        this.remainingSeconds = create17;
        BehaviorSubject<Boolean> create18 = BehaviorSubject.create();
        Intrinsics.checkNotNullExpressionValue(create18, "create<Boolean>()");
        this.discountVisibility = create18;
        BehaviorSubject<Double> create19 = BehaviorSubject.create();
        Intrinsics.checkNotNullExpressionValue(create19, "create<Double>()");
        this.discountAmount = create19;
        BehaviorSubject<Boolean> create20 = BehaviorSubject.create();
        Intrinsics.checkNotNullExpressionValue(create20, "create<Boolean>()");
        this.staticTiersMode = create20;
        GemTiersBusinessRulesKt.bindStaticTiersMode(this);
        Unit unit = Unit.INSTANCE;
        this.bindStaticTiersMode = unit;
        GemCounterBusinessRulesKt.bindCounterExpired(this);
        this.bindCounterExpired = unit;
        GemDiscountBusinessRulesKt.bindDiscountText(this);
        this.bindDiscountText = unit;
        GemSubTotalBusinessRulesKt.bindCurrency(this);
        this.bindCurrency = unit;
        GemSubTotalBusinessRulesKt.bindSubTitleLineOne(this);
        this.bindSubTitleLineOne = unit;
        GemSubTotalBusinessRulesKt.bindSubTitleLineTwo(this);
        this.bindSubTitleLineTwo = unit;
        GemSubTotalBusinessRulesKt.bindSubTotalVisibility(this);
        this.bindSubTotalVisibility = unit;
        GemTiersBusinessRulesKt.bindTiers(this);
        this.bindTiers = unit;
        GemViewBusinessRulesKt.bindOffer$default(this, GemOfferRequester.Existing.INSTANCE, (Function1) null, 2, (Object) null);
        this.bindOffer = unit;
        GemPerRestaurantBusinessRulesKt.bindSelectedGemRestaurant(this);
        this.bindSelectedGemRestaurant = unit;
        GemPerRestaurantBusinessRulesKt.bindVisibilityPerRestaurant(this);
        this.bindVisibilityPerRestaurant = unit;
        GemCounterBusinessRulesKt.bindCounterAndVisibility$default(this, (Long) null, 1, (Object) null);
        this.bindCounterAndVisibility = unit;
        GemDiscountBusinessRulesKt.bindDiscountVisibility(this);
        this.bindDiscountVisibility = unit;
        GemDiscountBusinessRulesKt.bindDiscountAmount(this);
        this.bindDiscountAmount = unit;
        this.configurations = ConfigurationsKt.Configurations();
        GemViewKt.withGemFlowTracking(this, context, new GemCheckoutDiscountView$initialize$1(this, context));
        this.initialize = unit;
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
        GemDiscountViewPort.DefaultImpls.autoDispose(this, function0);
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
    public Unit getBindCurrency() {
        return this.bindCurrency;
    }

    @NotNull
    public Unit getBindDiscountAmount() {
        return this.bindDiscountAmount;
    }

    @NotNull
    public Unit getBindDiscountText() {
        return this.bindDiscountText;
    }

    @NotNull
    public Unit getBindDiscountVisibility() {
        return this.bindDiscountVisibility;
    }

    @NotNull
    public Unit getBindOffer() {
        return this.bindOffer;
    }

    @NotNull
    public Unit getBindSelectedGemRestaurant() {
        return this.bindSelectedGemRestaurant;
    }

    @NotNull
    public Unit getBindSelectedRestaurantId() {
        return GemDiscountViewPort.DefaultImpls.getBindSelectedRestaurantId(this);
    }

    @NotNull
    public Unit getBindStaticTiersMode() {
        return this.bindStaticTiersMode;
    }

    @NotNull
    public Unit getBindSubTitleLineOne() {
        return this.bindSubTitleLineOne;
    }

    @NotNull
    public Unit getBindSubTitleLineTwo() {
        return this.bindSubTitleLineTwo;
    }

    @NotNull
    public Unit getBindSubTotalVisibility() {
        return this.bindSubTotalVisibility;
    }

    @NotNull
    public Unit getBindTiers() {
        return this.bindTiers;
    }

    @NotNull
    public Unit getBindVisibilityPerRestaurant() {
        return this.bindVisibilityPerRestaurant;
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
    public BehaviorSubject<String> getCurrency() {
        return this.currency;
    }

    @NotNull
    public BehaviorSubject<Double> getDiscountAmount() {
        return this.discountAmount;
    }

    @NotNull
    public BehaviorSubject<String> getDiscountText() {
        return this.discountText;
    }

    @NotNull
    public BehaviorSubject<Boolean> getDiscountVisibility() {
        return this.discountVisibility;
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
    public Scheduler getScheduler() {
        return this.scheduler;
    }

    @NotNull
    public BehaviorSubject<GemRestaurant> getSelectedGemRestaurant() {
        return this.selectedGemRestaurant;
    }

    @NotNull
    public BehaviorSubject<Integer> getSelectedRestaurantId() {
        return this.selectedRestaurantId;
    }

    @NotNull
    public BehaviorSubject<Boolean> getStaticTiersMode() {
        return this.staticTiersMode;
    }

    @NotNull
    public BehaviorSubject<SubTotalLineOne> getSubTitleLineOne() {
        return this.subTitleLineOne;
    }

    @NotNull
    public BehaviorSubject<SubTotalLineTwo> getSubTitleLineTwo() {
        return this.subTitleLineTwo;
    }

    @NotNull
    public BehaviorSubject<Double> getSubTotal() {
        return this.subTotal;
    }

    @NotNull
    public BehaviorSubject<Boolean> getSubTotalVisibility() {
        return this.subTotalVisibility;
    }

    @NotNull
    public BehaviorSubject<List<GemTier>> getTiers() {
        return this.tiers;
    }

    @NotNull
    public BehaviorSubject<Boolean> getVisibility() {
        return this.visibility;
    }

    @NotNull
    public BehaviorSubject<Boolean> getVisibilityPerRestaurant() {
        return this.visibilityPerRestaurant;
    }

    @GemViewsDsl
    public final void invoke(@NotNull Function1<? super GemCheckoutDiscountConfigurations, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "configurationInitializer");
        ReplaySubject<GemCheckoutDiscountConfigurations> replaySubject = this.configurations;
        GemCheckoutDiscountConfigurations gemCheckoutDiscountConfigurations = new GemCheckoutDiscountConfigurations();
        function1.invoke(gemCheckoutDiscountConfigurations);
        RxKt.plusAssign(replaySubject, gemCheckoutDiscountConfigurations);
    }

    public void onCleared() {
        GemDiscountViewPort.DefaultImpls.onCleared(this);
    }

    @AutoDisposableDsl
    public void onClearedImplementation() {
        GemDiscountViewPort.DefaultImpls.onClearedImplementation(this);
    }

    @NotNull
    public PublishSubject<Throwable> getErrors() {
        return this.errors;
    }

    @NotNull
    public Unit getInitialize() {
        return this.initialize;
    }
}
