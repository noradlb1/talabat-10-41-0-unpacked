package com.talabat.talabatcommon.ports;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000$\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a!\u0010\f\u001a\u00020\r2\u0017\u0010\u000e\u001a\u0013\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\r0\u000f¢\u0006\u0002\b\u0010H\u0007\u001a\u0015\u0010\u0011\u001a\u00020\r*\u00020\u00072\u0006\u0010\u0011\u001a\u00020\u0001H\u0004\"\u001c\u0010\u0000\u001a\u0004\u0018\u00010\u0001X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0002\u0010\u0003\"\u0004\b\u0004\u0010\u0005\"\u001e\u0010\u0006\u001a\u00020\u0007*\u00020\u00078FX\u0004¢\u0006\f\u0012\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b¨\u0006\u0012"}, d2 = {"vendorMenuNavigator", "Lcom/talabat/talabatcommon/ports/VendorMenuFlutterNavigatorPort;", "getVendorMenuNavigator", "()Lcom/talabat/talabatcommon/ports/VendorMenuFlutterNavigatorPort;", "setVendorMenuNavigator", "(Lcom/talabat/talabatcommon/ports/VendorMenuFlutterNavigatorPort;)V", "set", "Lcom/talabat/talabatcommon/ports/VendorMenuIntegrator;", "getSet$annotations", "(Lcom/talabat/talabatcommon/ports/VendorMenuIntegrator;)V", "getSet", "(Lcom/talabat/talabatcommon/ports/VendorMenuIntegrator;)Lcom/talabat/talabatcommon/ports/VendorMenuIntegrator;", "VendorMenuFlutterIntegration", "", "integration", "Lkotlin/Function1;", "Lkotlin/ExtensionFunctionType;", "navigator", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class VendorMenuIntegratorKt {
    @Nullable
    private static VendorMenuFlutterNavigatorPort vendorMenuNavigator;

    @IntegrationDsl
    public static final void VendorMenuFlutterIntegration(@NotNull Function1<? super VendorMenuIntegrator, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "integration");
        function1.invoke(new VendorMenuIntegrator());
    }

    @NotNull
    public static final VendorMenuIntegrator getSet(@NotNull VendorMenuIntegrator vendorMenuIntegrator) {
        Intrinsics.checkNotNullParameter(vendorMenuIntegrator, "<this>");
        return vendorMenuIntegrator;
    }

    @IntegrationDsl
    public static /* synthetic */ void getSet$annotations(VendorMenuIntegrator vendorMenuIntegrator) {
    }

    @Nullable
    public static final VendorMenuFlutterNavigatorPort getVendorMenuNavigator() {
        return vendorMenuNavigator;
    }

    @IntegrationDsl
    public static final void navigator(@NotNull VendorMenuIntegrator vendorMenuIntegrator, @NotNull VendorMenuFlutterNavigatorPort vendorMenuFlutterNavigatorPort) {
        Intrinsics.checkNotNullParameter(vendorMenuIntegrator, "<this>");
        Intrinsics.checkNotNullParameter(vendorMenuFlutterNavigatorPort, "navigator");
        vendorMenuNavigator = vendorMenuFlutterNavigatorPort;
    }

    public static final void setVendorMenuNavigator(@Nullable VendorMenuFlutterNavigatorPort vendorMenuFlutterNavigatorPort) {
        vendorMenuNavigator = vendorMenuFlutterNavigatorPort;
    }
}
