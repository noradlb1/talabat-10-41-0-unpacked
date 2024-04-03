package com.talabat.talabatcommon.extentions;

import android.os.Bundle;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0019\u0012\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0002\u0010\u0006J\u000e\u0010\u0007\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0004R\u001a\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/talabat/talabatcommon/extentions/BundlePair;", "", "block", "Lkotlin/Function1;", "Landroid/os/Bundle;", "", "(Lkotlin/jvm/functions/Function1;)V", "apply", "bundle", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class BundlePair {
    @NotNull
    private final Function1<Bundle, Unit> block;

    public BundlePair(@NotNull Function1<? super Bundle, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "block");
        this.block = function1;
    }

    public final void apply(@NotNull Bundle bundle) {
        Intrinsics.checkNotNullParameter(bundle, "bundle");
        this.block.invoke(bundle);
    }
}
