package com.talabat.feature.tpro.presentation.helperview.mov;

import androidx.lifecycle.ViewModelProvider;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Landroidx/lifecycle/ViewModelProvider$Factory;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class TProVendorMovView$viewModel$2 extends Lambda implements Function0<ViewModelProvider.Factory> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ TProVendorMovView f59288g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TProVendorMovView$viewModel$2(TProVendorMovView tProVendorMovView) {
        super(0);
        this.f59288g = tProVendorMovView;
    }

    @NotNull
    public final ViewModelProvider.Factory invoke() {
        return this.f59288g.getViewModelFactory();
    }
}
