package com.talabat.vendormenu.presentation.flutter.channels;

import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\bf\u0018\u00002\u00020\u0001J9\u0010\u0002\u001a\u00020\u00032/\u0010\u0004\u001a+\u0012!\u0012\u001f\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0006¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\u00030\u0005H&J\u0010\u0010\u000b\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\rH&¨\u0006\u000e"}, d2 = {"Lcom/talabat/vendormenu/presentation/flutter/channels/TalabatProMethodChannelCallback;", "", "getTalabatProConfigs", "", "vendorMovCallback", "Lkotlin/Function1;", "", "", "Lkotlin/ParameterName;", "name", "map", "updateProStatus", "countryId", "", "com_talabat_NewArchi_TalabatVendorMenu_TalabatVendorMenu"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface TalabatProMethodChannelCallback {
    void getTalabatProConfigs(@NotNull Function1<? super Map<String, ? extends Object>, Unit> function1);

    void updateProStatus(int i11);
}
