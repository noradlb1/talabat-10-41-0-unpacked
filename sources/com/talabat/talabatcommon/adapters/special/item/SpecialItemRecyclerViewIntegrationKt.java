package com.talabat.talabatcommon.adapters.special.item;

import android.app.Application;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a%\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0017\u0010\u0003\u001a\u0013\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00010\u0004¢\u0006\u0002\b\u0006H\u0007¨\u0006\u0007"}, d2 = {"SpecialItemRecyclerView", "", "Landroid/app/Application;", "builder", "Lkotlin/Function1;", "Lcom/talabat/talabatcommon/adapters/special/item/SpecialItemRecyclerViewBuilder;", "Lkotlin/ExtensionFunctionType;", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class SpecialItemRecyclerViewIntegrationKt {
    @SpecialItemRecyclerViewDsl
    public static final void SpecialItemRecyclerView(@NotNull Application application, @NotNull Function1<? super SpecialItemRecyclerViewBuilder, Unit> function1) {
        Intrinsics.checkNotNullParameter(application, "<this>");
        Intrinsics.checkNotNullParameter(function1, "builder");
        SpecialItemRecyclerViewBuilder specialItemRecyclerViewBuilder = new SpecialItemRecyclerViewBuilder();
        function1.invoke(specialItemRecyclerViewBuilder);
        application.registerActivityLifecycleCallbacks(new SpecialItemRecyclerViewScanner(specialItemRecyclerViewBuilder.getCreateSpecialItemViewHolder$com_talabat_NewArchi_TalabatCommon_TalabatCommon()));
    }
}
