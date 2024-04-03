package com.talabat.helpers;

import com.talabat.integration.VendorMenuFlutterNavigator;
import com.talabat.talabatcommon.ports.VendorMenuIntegrator;
import com.talabat.talabatcommon.ports.VendorMenuIntegratorKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "Lcom/talabat/talabatcommon/ports/VendorMenuIntegrator;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class TalabatApplication$initializeVendorMenuFlutterIntegration$1 extends Lambda implements Function1<VendorMenuIntegrator, Unit> {
    public static final TalabatApplication$initializeVendorMenuFlutterIntegration$1 INSTANCE = new TalabatApplication$initializeVendorMenuFlutterIntegration$1();

    public TalabatApplication$initializeVendorMenuFlutterIntegration$1() {
        super(1);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((VendorMenuIntegrator) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull VendorMenuIntegrator vendorMenuIntegrator) {
        Intrinsics.checkNotNullParameter(vendorMenuIntegrator, "$this$VendorMenuFlutterIntegration");
        VendorMenuIntegratorKt.navigator(VendorMenuIntegratorKt.getSet(vendorMenuIntegrator), new VendorMenuFlutterNavigator());
    }
}
