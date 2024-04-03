package com.talabat.fluid.homescreen.ui.fragment;

import androidx.fragment.app.FragmentActivity;
import com.talabat.core.deeplink.domain.DeepLinkNavigator;
import com.talabat.fluid.homescreen.presentation.displaymodel.CollectionItem;
import com.talabat.fluid.homescreen.ui.integration.FluidHomeScreenIntegrable;
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
@DebugMetadata(c = "com.talabat.fluid.homescreen.ui.fragment.FluidHomeScreenFragment$observeViewModel$10$1", f = "FluidHomeScreenFragment.kt", i = {}, l = {286}, m = "invokeSuspend", n = {}, s = {})
public final class FluidHomeScreenFragment$observeViewModel$10$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* renamed from: h  reason: collision with root package name */
    public int f59742h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ FluidHomeScreenFragment f59743i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ CollectionItem f59744j;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FluidHomeScreenFragment$observeViewModel$10$1(FluidHomeScreenFragment fluidHomeScreenFragment, CollectionItem collectionItem, Continuation<? super FluidHomeScreenFragment$observeViewModel$10$1> continuation) {
        super(2, continuation);
        this.f59743i = fluidHomeScreenFragment;
        this.f59744j = collectionItem;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new FluidHomeScreenFragment$observeViewModel$10$1(this.f59743i, this.f59744j, continuation);
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((FluidHomeScreenFragment$observeViewModel$10$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i11 = this.f59742h;
        if (i11 == 0) {
            ResultKt.throwOnFailure(obj);
            DeepLinkNavigator deepLinkNavigator = this.f59743i.getDeepLinkNavigator();
            String deepLink = this.f59744j.getDeepLink();
            this.f59742h = 1;
            obj = deepLinkNavigator.canHandleDeepLink(deepLink, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i11 == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        if (((Boolean) obj).booleanValue()) {
            DeepLinkNavigator deepLinkNavigator2 = this.f59743i.getDeepLinkNavigator();
            FragmentActivity requireActivity = this.f59743i.requireActivity();
            Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity()");
            DeepLinkNavigator.DefaultImpls.navigateTo$default(deepLinkNavigator2, requireActivity, this.f59744j.getDeepLink(), (Function0) null, 4, (Object) null);
        } else {
            FluidHomeScreenIntegrable access$getIntegration$p = this.f59743i.integration;
            if (access$getIntegration$p != null) {
                access$getIntegration$p.handleDeepLink(this.f59744j.getDeepLink());
            }
        }
        return Unit.INSTANCE;
    }
}
