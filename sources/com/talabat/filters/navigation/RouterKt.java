package com.talabat.filters.navigation;

import androidx.appcompat.app.AppCompatActivity;
import com.talabat.talabatcommon.views.StartForResultExecutor;
import com.talabat.talabatcommon.views.StartForResultKt;
import datamodels.filters.Selectables;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001c\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u001a\u001a\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003*\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0000\"\u000e\u0010\u0000\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"ACTION_OPEN_FILTERS_ACTIVITY", "", "startFragmentForResult", "Lcom/talabat/talabatcommon/views/StartForResultExecutor;", "Ldatamodels/filters/Selectables;", "Landroidx/appcompat/app/AppCompatActivity;", "type", "", "com_talabat_Components_filters_filters"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class RouterKt {
    @NotNull
    private static final String ACTION_OPEN_FILTERS_ACTIVITY = "talabat.components.filters";

    @NotNull
    public static final StartForResultExecutor<Selectables> startFragmentForResult(@NotNull AppCompatActivity appCompatActivity, int i11) {
        Intrinsics.checkNotNullParameter(appCompatActivity, "<this>");
        return StartForResultKt.StartForResultBuilder(appCompatActivity, new RouterKt$startFragmentForResult$1(i11));
    }
}
