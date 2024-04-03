package com.talabat.feature.tpro.presentation.helperview.mov.wrapper;

import androidx.lifecycle.LifecycleOwner;
import buisnessmodels.Customer;
import com.talabat.core.flutter.channels.impl.data.tpro.TProChannelCallbackImpl;
import com.talabat.feature.subscriptions.domain.ISubscriptionStatusRepository;
import com.talabat.feature.subscriptions.domain.model.ProVendorMov;
import com.talabat.feature.tpro.presentation.helperview.mov.VendorMovViewModel;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import xo.a;
import xo.b;

@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJN\u0010\u0011\u001a\u00020\u00102\b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0014\u001a\u00020\u00152/\u0010\u0016\u001a+\u0012!\u0012\u001f\u0012\u0004\u0012\u00020\f\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u000b¢\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u000f\u0012\u0004\u0012\u00020\u00100\n¢\u0006\u0002\u0010\u0017J\u0010\u0010\u0018\u001a\u00020\u00102\u0006\u0010\u0019\u001a\u00020\u001aH\u0002J\u0010\u0010\u001b\u001a\u00020\u00102\u0006\u0010\u001c\u001a\u00020\u001dH\u0002J\u0012\u0010\u001e\u001a\u00020\u00102\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0002J\u0010\u0010\u001f\u001a\u00020\u00102\u0006\u0010\u0002\u001a\u00020\u0003H\u0002R9\u0010\t\u001a-\u0012!\u0012\u001f\u0012\u0004\u0012\u00020\f\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u000b¢\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u000f\u0012\u0004\u0012\u00020\u0010\u0018\u00010\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006 "}, d2 = {"Lcom/talabat/feature/tpro/presentation/helperview/mov/wrapper/VendorMenuTProMovWrapper;", "", "lifecycleOwner", "Landroidx/lifecycle/LifecycleOwner;", "vendorMovViewModel", "Lcom/talabat/feature/tpro/presentation/helperview/mov/VendorMovViewModel;", "subscriptionStatusRepository", "Lcom/talabat/feature/subscriptions/domain/ISubscriptionStatusRepository;", "(Landroidx/lifecycle/LifecycleOwner;Lcom/talabat/feature/tpro/presentation/helperview/mov/VendorMovViewModel;Lcom/talabat/feature/subscriptions/domain/ISubscriptionStatusRepository;)V", "proVendorMovMapCallback", "Lkotlin/Function1;", "", "", "Lkotlin/ParameterName;", "name", "map", "", "fetchTalabatProConfigs", "branchId", "", "isProVendor", "", "vendorMovCallback", "(Ljava/lang/Integer;ZLkotlin/jvm/functions/Function1;)V", "handleProVendorMov", "proMov", "Lcom/talabat/feature/subscriptions/domain/model/ProVendorMov;", "handleProVendorMovFailure", "error", "", "sendProVendorMovMap", "setupObservers", "com_talabat_feature_tpro_presentation_presentation"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class VendorMenuTProMovWrapper {
    @Nullable
    private Function1<? super Map<String, ? extends Object>, Unit> proVendorMovMapCallback;
    @NotNull
    private final ISubscriptionStatusRepository subscriptionStatusRepository;
    @NotNull
    private final VendorMovViewModel vendorMovViewModel;

    public VendorMenuTProMovWrapper(@NotNull LifecycleOwner lifecycleOwner, @NotNull VendorMovViewModel vendorMovViewModel2, @NotNull ISubscriptionStatusRepository iSubscriptionStatusRepository) {
        Intrinsics.checkNotNullParameter(lifecycleOwner, "lifecycleOwner");
        Intrinsics.checkNotNullParameter(vendorMovViewModel2, "vendorMovViewModel");
        Intrinsics.checkNotNullParameter(iSubscriptionStatusRepository, "subscriptionStatusRepository");
        this.vendorMovViewModel = vendorMovViewModel2;
        this.subscriptionStatusRepository = iSubscriptionStatusRepository;
        setupObservers(lifecycleOwner);
    }

    /* access modifiers changed from: private */
    public final void handleProVendorMov(ProVendorMov proVendorMov) {
        if (proVendorMov.getMov() == null || Intrinsics.areEqual(proVendorMov.getMov(), 0.0f)) {
            sendProVendorMovMap((ProVendorMov) null);
        } else {
            sendProVendorMovMap(proVendorMov);
        }
    }

    /* access modifiers changed from: private */
    public final void handleProVendorMovFailure(Throwable th2) {
        sendProVendorMovMap((ProVendorMov) null);
    }

    private final void sendProVendorMovMap(ProVendorMov proVendorMov) {
        Float f11;
        Function1<? super Map<String, ? extends Object>, Unit> function1 = this.proVendorMovMapCallback;
        if (function1 != null) {
            Pair[] pairArr = new Pair[3];
            pairArr[0] = TuplesKt.to(TProChannelCallbackImpl.USER_IS_TPRO_RESULT_KEY, Boolean.valueOf(this.subscriptionStatusRepository.isTProUser()));
            if (proVendorMov != null) {
                f11 = proVendorMov.getMov();
            } else {
                f11 = null;
            }
            pairArr[1] = TuplesKt.to(TProChannelCallbackImpl.MINIMUM_ORDER_VALUE_KEY, f11);
            pairArr[2] = TuplesKt.to(TProChannelCallbackImpl.IS_PRO_ENABLED_VALUE_KEY, Boolean.valueOf(Customer.getInstance().isShowPro()));
            function1.invoke(MapsKt__MapsKt.mapOf(pairArr));
        }
    }

    private final void setupObservers(LifecycleOwner lifecycleOwner) {
        this.vendorMovViewModel.getVendorMovLiveData().observe(lifecycleOwner, new a(this));
        this.vendorMovViewModel.getFailureLiveData().observe(lifecycleOwner, new b(this));
    }

    public final void fetchTalabatProConfigs(@Nullable Integer num, boolean z11, @NotNull Function1<? super Map<String, ? extends Object>, Unit> function1) {
        Unit unit;
        Intrinsics.checkNotNullParameter(function1, "vendorMovCallback");
        this.proVendorMovMapCallback = function1;
        if (num != null) {
            this.vendorMovViewModel.loadVendorMov(num.intValue(), z11);
            unit = Unit.INSTANCE;
        } else {
            unit = null;
        }
        if (unit == null) {
            handleProVendorMovFailure(new Throwable());
        }
    }
}
