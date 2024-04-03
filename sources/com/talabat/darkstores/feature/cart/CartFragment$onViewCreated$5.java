package com.talabat.darkstores.feature.cart;

import com.talabat.wrapper.EventWrapper;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u001a\u0010\u0002\u001a\u0016\u0012\u0004\u0012\u00020\u0004 \u0005*\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", "wrapper", "Lcom/talabat/wrapper/EventWrapper;", "", "kotlin.jvm.PlatformType", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class CartFragment$onViewCreated$5 extends Lambda implements Function1<EventWrapper<? extends String>, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ CartFragment f56254g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CartFragment$onViewCreated$5(CartFragment cartFragment) {
        super(1);
        this.f56254g = cartFragment;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((EventWrapper<String>) (EventWrapper) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(EventWrapper<String> eventWrapper) {
        String contentIfNotHandled = eventWrapper.getContentIfNotHandled();
        if (contentIfNotHandled != null) {
            this.f56254g.showAgeRestriction(contentIfNotHandled);
        }
    }
}
