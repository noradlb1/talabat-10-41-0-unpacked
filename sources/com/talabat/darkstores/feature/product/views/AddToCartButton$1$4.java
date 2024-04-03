package com.talabat.darkstores.feature.product.views;

import io.reactivex.disposables.Disposable;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import lj.a;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0004\u0018\u00010\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lio/reactivex/disposables/Disposable;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class AddToCartButton$1$4 extends Lambda implements Function0<Disposable> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ AddToCartButtonViewModel f56530g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ AddToCartButton f56531h;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AddToCartButton$1$4(AddToCartButtonViewModel addToCartButtonViewModel, AddToCartButton addToCartButton) {
        super(0);
        this.f56530g = addToCartButtonViewModel;
        this.f56531h = addToCartButton;
    }

    @Nullable
    public final Disposable invoke() {
        return this.f56530g.getViewState().subscribe(new a(this.f56531h));
    }
}
