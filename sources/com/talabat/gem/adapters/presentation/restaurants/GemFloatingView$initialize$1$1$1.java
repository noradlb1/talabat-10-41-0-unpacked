package com.talabat.gem.adapters.presentation.restaurants;

import com.talabat.talabatcommon.extentions.RxKt;
import io.reactivex.disposables.Disposable;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0004\u0018\u00010\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lio/reactivex/disposables/Disposable;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class GemFloatingView$initialize$1$1$1 extends Lambda implements Function0<Disposable> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ GemFloatingViewModel f60290g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public GemFloatingView$initialize$1$1$1(GemFloatingViewModel gemFloatingViewModel) {
        super(0);
        this.f60290g = gemFloatingViewModel;
    }

    @Nullable
    public final Disposable invoke() {
        return RxKt.invoke(this.f60290g.getErrors(), AnonymousClass1.INSTANCE);
    }
}
