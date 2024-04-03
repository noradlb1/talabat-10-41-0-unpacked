package com.talabat.gem.adapters.presentation.checkout;

import com.talabat.talabatcommon.extentions.RxKt;
import io.reactivex.disposables.Disposable;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0004\u0018\u00010\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lio/reactivex/disposables/Disposable;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class GemCheckoutFooterView$initialize$1$1$1 extends Lambda implements Function0<Disposable> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ GemCheckoutFooterViewModel f59955g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public GemCheckoutFooterView$initialize$1$1$1(GemCheckoutFooterViewModel gemCheckoutFooterViewModel) {
        super(0);
        this.f59955g = gemCheckoutFooterViewModel;
    }

    @Nullable
    public final Disposable invoke() {
        return RxKt.invoke(this.f59955g.getErrors(), AnonymousClass1.INSTANCE);
    }
}
