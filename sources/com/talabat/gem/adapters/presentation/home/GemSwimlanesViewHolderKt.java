package com.talabat.gem.adapters.presentation.home;

import android.view.ViewGroup;
import com.talabat.gem.adapters.presentation.GemEntryViewConfigurations;
import com.talabat.gem.adapters.presentation.GemViewsDsl;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000:\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u001a)\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0017\u0010\r\u001a\u0013\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00100\u000e¢\u0006\u0002\b\u0011H\u0007\"\u000e\u0010\u0000\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0007\u001a\u00020\bXT¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"ANIMATION_DEBOUNCE_MILLIS", "", "ANIMATION_MILLIS", "LAYOUT_TOP_MARGIN_DP", "", "RESTAURANTS_PER_COLUMN", "", "RESTAURANT_ROW_WIDTH_PERCENTAGE", "", "GemSwimlanesViewHolder", "Lcom/talabat/gem/adapters/presentation/home/GemSwimlanesViewHolder;", "parent", "Landroid/view/ViewGroup;", "configurations", "Lkotlin/Function1;", "Lcom/talabat/gem/adapters/presentation/GemEntryViewConfigurations;", "", "Lkotlin/ExtensionFunctionType;", "com_talabat_Components_gem_gem"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class GemSwimlanesViewHolderKt {
    private static final long ANIMATION_DEBOUNCE_MILLIS = 16;
    private static final long ANIMATION_MILLIS = 16;
    private static final float LAYOUT_TOP_MARGIN_DP = 40.0f;
    private static final int RESTAURANTS_PER_COLUMN = 2;
    private static final double RESTAURANT_ROW_WIDTH_PERCENTAGE = 0.85d;

    @GemViewsDsl
    @NotNull
    public static final GemSwimlanesViewHolder GemSwimlanesViewHolder(@NotNull ViewGroup viewGroup, @NotNull Function1<? super GemEntryViewConfigurations, Unit> function1) {
        Intrinsics.checkNotNullParameter(viewGroup, "parent");
        Intrinsics.checkNotNullParameter(function1, "configurations");
        return new GemSwimlanesViewHolder(viewGroup).invoke$com_talabat_Components_gem_gem(function1);
    }
}
