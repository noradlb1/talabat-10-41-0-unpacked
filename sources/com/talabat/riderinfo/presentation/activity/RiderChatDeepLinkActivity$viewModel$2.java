package com.talabat.riderinfo.presentation.activity;

import com.talabat.riderinfo.di.RiderInfoDependencyInjector;
import com.talabat.riderinfo.presentation.viewmodel.RiderChatDeepLinkViewModel;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/talabat/riderinfo/presentation/viewmodel/RiderChatDeepLinkViewModel;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class RiderChatDeepLinkActivity$viewModel$2 extends Lambda implements Function0<RiderChatDeepLinkViewModel> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ RiderChatDeepLinkActivity f61292g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public RiderChatDeepLinkActivity$viewModel$2(RiderChatDeepLinkActivity riderChatDeepLinkActivity) {
        super(0);
        this.f61292g = riderChatDeepLinkActivity;
    }

    @NotNull
    public final RiderChatDeepLinkViewModel invoke() {
        return RiderInfoDependencyInjector.INSTANCE.initRiderChatDeepLinkViewModel(this.f61292g);
    }
}
