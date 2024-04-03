package com.deliveryhero.chatui.view.chatroom;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.koin.core.parameter.ParametersHolder;
import org.koin.core.parameter.ParametersHolderKt;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lorg/koin/core/parameter/ParametersHolder;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class ChatFragment$imageSelectionNavigator$2 extends Lambda implements Function0<ParametersHolder> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ ChatFragment f29464g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ChatFragment$imageSelectionNavigator$2(ChatFragment chatFragment) {
        super(0);
        this.f29464g = chatFragment;
    }

    @NotNull
    public final ParametersHolder invoke() {
        return ParametersHolderKt.parametersOf(this.f29464g.requireActivity().getActivityResultRegistry());
    }
}
