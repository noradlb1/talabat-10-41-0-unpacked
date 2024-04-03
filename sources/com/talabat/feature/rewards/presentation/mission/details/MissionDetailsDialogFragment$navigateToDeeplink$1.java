package com.talabat.feature.rewards.presentation.mission.details;

import android.content.Context;
import androidx.fragment.app.FragmentActivity;
import com.talabat.core.deeplink.domain.DeepLinkNavigator;
import com.talabat.talabatnavigation.Navigator;
import com.talabat.talabatnavigation.home.HomeNavigationActions;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 6, 0})
@DebugMetadata(c = "com.talabat.feature.rewards.presentation.mission.details.MissionDetailsDialogFragment$navigateToDeeplink$1", f = "MissionDetailsDialogFragment.kt", i = {}, l = {172}, m = "invokeSuspend", n = {}, s = {})
public final class MissionDetailsDialogFragment$navigateToDeeplink$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* renamed from: h  reason: collision with root package name */
    public int f58773h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ MissionDetailsDialogFragment f58774i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ String f58775j;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public MissionDetailsDialogFragment$navigateToDeeplink$1(MissionDetailsDialogFragment missionDetailsDialogFragment, String str, Continuation<? super MissionDetailsDialogFragment$navigateToDeeplink$1> continuation) {
        super(2, continuation);
        this.f58774i = missionDetailsDialogFragment;
        this.f58775j = str;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new MissionDetailsDialogFragment$navigateToDeeplink$1(this.f58774i, this.f58775j, continuation);
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((MissionDetailsDialogFragment$navigateToDeeplink$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i11 = this.f58773h;
        if (i11 == 0) {
            ResultKt.throwOnFailure(obj);
            DeepLinkNavigator deepLinkNavigator = this.f58774i.getDeepLinkNavigator();
            String str = this.f58775j;
            this.f58773h = 1;
            obj = deepLinkNavigator.canHandleDeepLink(str, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i11 == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        if (((Boolean) obj).booleanValue()) {
            Context context = this.f58774i.getContext();
            if (context != null) {
                MissionDetailsDialogFragment missionDetailsDialogFragment = this.f58774i;
                DeepLinkNavigator.DefaultImpls.navigateTo$default(missionDetailsDialogFragment.getDeepLinkNavigator(), context, this.f58775j, (Function0) null, 4, (Object) null);
            }
        } else {
            FragmentActivity activity = this.f58774i.getActivity();
            if (activity != null) {
                Navigator.Companion.navigate((Context) activity, HomeNavigationActions.INSTANCE.createNavigationModelToVoucherDeepLink(this.f58775j));
                activity.finish();
            }
        }
        return Unit.INSTANCE;
    }
}
