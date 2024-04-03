package com.talabat.feature.tpro.presentation.management.details;

import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.LifecycleOwner;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.designsystem.ds_button_v2.DSPrimaryButton;
import com.talabat.configuration.location.LocationConfigurationRepository;
import com.talabat.core.deeplink.domain.DeepLinkNavigator;
import com.talabat.feature.subscriptions.domain.model.Subscription;
import com.talabat.feature.subscriptions.domain.model.SubscriptionSavingsInfo;
import com.talabat.feature.tpro.presentation.databinding.FragmentTproSubscriptionDetailsBinding;
import com.talabat.feature.tpro.presentation.management.details.adapter.TproSubscriptionDetailsRecyclerViewAdapter;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 6, 0})
@DebugMetadata(c = "com.talabat.feature.tpro.presentation.management.details.TProSubscriptionDetailsFragment$bindContent$1", f = "TProSubscriptionDetailsFragment.kt", i = {}, l = {563}, m = "invokeSuspend", n = {}, s = {})
public final class TProSubscriptionDetailsFragment$bindContent$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* renamed from: h  reason: collision with root package name */
    public int f59308h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ TProSubscriptionDetailsFragment f59309i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ Subscription f59310j;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TProSubscriptionDetailsFragment$bindContent$1(TProSubscriptionDetailsFragment tProSubscriptionDetailsFragment, Subscription subscription, Continuation<? super TProSubscriptionDetailsFragment$bindContent$1> continuation) {
        super(2, continuation);
        this.f59309i = tProSubscriptionDetailsFragment;
        this.f59310j = subscription;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new TProSubscriptionDetailsFragment$bindContent$1(this.f59309i, this.f59310j, continuation);
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((TProSubscriptionDetailsFragment$bindContent$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object obj2;
        RecyclerView.Adapter adapter;
        int i11;
        Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i12 = this.f59308h;
        if (i12 == 0) {
            ResultKt.throwOnFailure(obj);
            DeepLinkNavigator deepLinkNavigator = this.f59309i.getDeepLinkNavigator();
            String access$getChangePaymentDeeplink$p = this.f59309i.changePaymentDeeplink;
            this.f59308h = 1;
            obj2 = deepLinkNavigator.canHandleDeepLink(access$getChangePaymentDeeplink$p, this);
            if (obj2 == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i12 == 1) {
            ResultKt.throwOnFailure(obj);
            obj2 = obj;
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        boolean booleanValue = ((Boolean) obj2).booleanValue();
        LocationConfigurationRepository locationRepository = this.f59309i.getLocationRepository();
        TProSubscriptionDetailsFragment$bindContent$1$contentAdapter$1 tProSubscriptionDetailsFragment$bindContent$1$contentAdapter$1 = new TProSubscriptionDetailsFragment$bindContent$1$contentAdapter$1(this.f59309i);
        TProSubscriptionDetailsFragment$bindContent$1$contentAdapter$2 tProSubscriptionDetailsFragment$bindContent$1$contentAdapter$2 = new TProSubscriptionDetailsFragment$bindContent$1$contentAdapter$2(this.f59309i);
        LifecycleOwner viewLifecycleOwner = this.f59309i.getViewLifecycleOwner();
        FragmentManager childFragmentManager = this.f59309i.getChildFragmentManager();
        TProSubscriptionDetailsFragment$bindContent$1$contentAdapter$3 tProSubscriptionDetailsFragment$bindContent$1$contentAdapter$3 = new TProSubscriptionDetailsFragment$bindContent$1$contentAdapter$3(this.f59309i);
        SubscriptionSavingsInfo value = this.f59309i.getViewModel().getSubscriptionsSaving().getValue();
        if (value == null) {
            value = new SubscriptionSavingsInfo(0.0f, 0.0f);
        }
        SubscriptionSavingsInfo subscriptionSavingsInfo = value;
        boolean access$isSavingsEnabled = this.f59309i.isSavingsEnabled();
        TProSubscriptionDetailsFragment$bindContent$1$contentAdapter$4 tProSubscriptionDetailsFragment$bindContent$1$contentAdapter$4 = new TProSubscriptionDetailsFragment$bindContent$1$contentAdapter$4(this.f59309i);
        boolean access$isTproSubscriptionUpgradeEnabled$p = this.f59309i.isTproSubscriptionUpgradeEnabled;
        TProSubscriptionDetailsFragment$bindContent$1$contentAdapter$5 tProSubscriptionDetailsFragment$bindContent$1$contentAdapter$5 = new TProSubscriptionDetailsFragment$bindContent$1$contentAdapter$5(this.f59309i);
        TProSubscriptionDetailsFragment$bindContent$1$contentAdapter$6 tProSubscriptionDetailsFragment$bindContent$1$contentAdapter$6 = new TProSubscriptionDetailsFragment$bindContent$1$contentAdapter$6(this.f59309i);
        TProSubscriptionDetailsFragment$bindContent$1$contentAdapter$7 tProSubscriptionDetailsFragment$bindContent$1$contentAdapter$7 = new TProSubscriptionDetailsFragment$bindContent$1$contentAdapter$7(this.f59309i);
        TProSubscriptionDetailsFragment$bindContent$1$contentAdapter$8 tProSubscriptionDetailsFragment$bindContent$1$contentAdapter$8 = new TProSubscriptionDetailsFragment$bindContent$1$contentAdapter$8(this.f59309i);
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "viewLifecycleOwner");
        Intrinsics.checkNotNullExpressionValue(childFragmentManager, "childFragmentManager");
        new TproSubscriptionDetailsRecyclerViewAdapter(locationRepository, tProSubscriptionDetailsFragment$bindContent$1$contentAdapter$1, tProSubscriptionDetailsFragment$bindContent$1$contentAdapter$2, tProSubscriptionDetailsFragment$bindContent$1$contentAdapter$3, viewLifecycleOwner, childFragmentManager, this.f59310j, subscriptionSavingsInfo, access$isSavingsEnabled, tProSubscriptionDetailsFragment$bindContent$1$contentAdapter$4, tProSubscriptionDetailsFragment$bindContent$1$contentAdapter$5, access$isTproSubscriptionUpgradeEnabled$p, tProSubscriptionDetailsFragment$bindContent$1$contentAdapter$6, tProSubscriptionDetailsFragment$bindContent$1$contentAdapter$7, tProSubscriptionDetailsFragment$bindContent$1$contentAdapter$8, booleanValue);
        FragmentTproSubscriptionDetailsBinding access$getBinding$p = this.f59309i.binding;
        FragmentTproSubscriptionDetailsBinding fragmentTproSubscriptionDetailsBinding = null;
        if (access$getBinding$p == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            access$getBinding$p = null;
        }
        DSPrimaryButton dSPrimaryButton = access$getBinding$p.btnRenew;
        Intrinsics.checkNotNullExpressionValue(dSPrimaryButton, "binding.btnRenew");
        if (this.f59309i.shouldDisplayRenew(this.f59310j)) {
            i11 = 0;
        } else {
            i11 = 8;
        }
        dSPrimaryButton.setVisibility(i11);
        FragmentTproSubscriptionDetailsBinding access$getBinding$p2 = this.f59309i.binding;
        if (access$getBinding$p2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            access$getBinding$p2 = null;
        }
        DSPrimaryButton dSPrimaryButton2 = access$getBinding$p2.btnRenew;
        final TProSubscriptionDetailsFragment tProSubscriptionDetailsFragment = this.f59309i;
        dSPrimaryButton2.setOnTap(new Function0<Unit>() {
            public final void invoke() {
                if (tProSubscriptionDetailsFragment.hasDefaultCard) {
                    tProSubscriptionDetailsFragment.renewSubscription();
                } else {
                    tProSubscriptionDetailsFragment.showAddCardNotification();
                }
            }
        });
        FragmentTproSubscriptionDetailsBinding access$getBinding$p3 = this.f59309i.binding;
        if (access$getBinding$p3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            fragmentTproSubscriptionDetailsBinding = access$getBinding$p3;
        }
        RecyclerView recyclerView = fragmentTproSubscriptionDetailsBinding.rvTproDetailsContent;
        TProSubscriptionDetailsFragment tProSubscriptionDetailsFragment2 = this.f59309i;
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(tProSubscriptionDetailsFragment2.requireContext(), 1, false));
        this.f59309i.trackIfUpgradeLoadedEvent(this.f59310j);
        return Unit.INSTANCE;
    }
}
