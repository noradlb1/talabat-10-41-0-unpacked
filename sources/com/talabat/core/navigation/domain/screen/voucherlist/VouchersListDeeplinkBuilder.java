package com.talabat.core.navigation.domain.screen.voucherlist;

import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0003\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000eB\u0005¢\u0006\u0002\u0010\u0002J>\u0010\u0003\u001a\u00020\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\tJ\u001a\u0010\u0003\u001a\u00020\u00042\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\fJ@\u0010\r\u001a\u00020\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\tH\u0002¨\u0006\u000f"}, d2 = {"Lcom/talabat/core/navigation/domain/screen/voucherlist/VouchersListDeeplinkBuilder;", "", "()V", "build", "", "campaign", "src", "brandId", "openBottomSheet", "", "openHome", "data", "", "getQueryParametersString", "Companion", "com_talabat_core_navigation_domain_domain"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class VouchersListDeeplinkBuilder {
    @NotNull
    @Deprecated
    public static final String BRAND_ID = "brandId";
    @NotNull
    @Deprecated
    public static final String CAMPAIGN = "campaign";
    @NotNull
    private static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    @NotNull
    @Deprecated
    public static final Function1<String, String> FLUTTER_VOUCHERS_LIST_DEEPLINK = VouchersListDeeplinkBuilder$Companion$FLUTTER_VOUCHERS_LIST_DEEPLINK$1.INSTANCE;
    @NotNull
    @Deprecated
    public static final String OPEN_BOTTOMSHEET = "open_bottomsheet";
    @NotNull
    @Deprecated
    public static final String OPEN_HOME = "open_home";
    @NotNull
    @Deprecated
    public static final String SRC = "src";

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R,\u0010\u0006\u001a\u001d\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\u00040\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u000e\u0010\r\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/talabat/core/navigation/domain/screen/voucherlist/VouchersListDeeplinkBuilder$Companion;", "", "()V", "BRAND_ID", "", "CAMPAIGN", "FLUTTER_VOUCHERS_LIST_DEEPLINK", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "queryParams", "getFLUTTER_VOUCHERS_LIST_DEEPLINK", "()Lkotlin/jvm/functions/Function1;", "OPEN_BOTTOMSHEET", "OPEN_HOME", "SRC", "com_talabat_core_navigation_domain_domain"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final Function1<String, String> getFLUTTER_VOUCHERS_LIST_DEEPLINK() {
            return VouchersListDeeplinkBuilder.FLUTTER_VOUCHERS_LIST_DEEPLINK;
        }
    }

    public static /* synthetic */ String build$default(VouchersListDeeplinkBuilder vouchersListDeeplinkBuilder, String str, String str2, String str3, boolean z11, boolean z12, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = null;
        }
        if ((i11 & 2) != 0) {
            str2 = null;
        }
        if ((i11 & 4) != 0) {
            str3 = null;
        }
        if ((i11 & 8) != 0) {
            z11 = false;
        }
        if ((i11 & 16) != 0) {
            z12 = false;
        }
        return vouchersListDeeplinkBuilder.build(str, str2, str3, z11, z12);
    }

    private final String getQueryParametersString(String str, String str2, String str3, boolean z11, boolean z12) {
        StringBuilder sb2 = new StringBuilder();
        if (str != null) {
            sb2.append("&campaign=" + str);
        }
        if (str2 != null) {
            sb2.append("&src=" + str2);
        }
        if (str3 != null) {
            sb2.append("&brandId=" + str3);
        }
        sb2.append("&open_bottomsheet=" + z11);
        sb2.append("&open_home=" + z12);
        String sb3 = sb2.toString();
        Intrinsics.checkNotNullExpressionValue(sb3, "queryParamBuilder.toString()");
        return sb3;
    }

    @NotNull
    public final String build(@Nullable String str, @Nullable String str2, @Nullable String str3, boolean z11, boolean z12) {
        return FLUTTER_VOUCHERS_LIST_DEEPLINK.invoke(getQueryParametersString(str, str2, str3, z11, z12));
    }

    @NotNull
    public final String build(@NotNull Map<String, String> map) {
        Intrinsics.checkNotNullParameter(map, "data");
        Function1<String, String> function1 = FLUTTER_VOUCHERS_LIST_DEEPLINK;
        String str = map.get("campaign");
        String str2 = map.get("src");
        String str3 = map.get("brandId");
        String str4 = map.get(OPEN_BOTTOMSHEET);
        boolean parseBoolean = str4 != null ? Boolean.parseBoolean(str4) : false;
        String str5 = map.get(OPEN_HOME);
        return function1.invoke(getQueryParametersString(str, str2, str3, parseBoolean, str5 != null ? Boolean.parseBoolean(str5) : false));
    }
}
