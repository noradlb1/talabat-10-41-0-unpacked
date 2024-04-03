package com.talabat.vendormenu.presentation.flutter;

import androidx.lifecycle.ViewModelProvider;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Landroidx/lifecycle/ViewModelProvider$Factory;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class VendorMenuFlutterActivity$vendorMovViewModel$2 extends Lambda implements Function0<ViewModelProvider.Factory> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ VendorMenuFlutterActivity f12443g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public VendorMenuFlutterActivity$vendorMovViewModel$2(VendorMenuFlutterActivity vendorMenuFlutterActivity) {
        super(0);
        this.f12443g = vendorMenuFlutterActivity;
    }

    @NotNull
    public final ViewModelProvider.Factory invoke() {
        return this.f12443g.getVendorMovViewModelFactory();
    }
}
