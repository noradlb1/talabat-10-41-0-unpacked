package com.talabat.fluid.homescreen.presentation.viewmodel;

import com.talabat.homescreen.adapter.model.vetrical.VerticalItem;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Lcom/talabat/homescreen/adapter/model/vetrical/VerticalItem;", "it", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class FluidHomeScreenViewModel$onEntryPointLoaded$2 extends Lambda implements Function1<String, VerticalItem> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ FluidHomeScreenViewModel f59728g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FluidHomeScreenViewModel$onEntryPointLoaded$2(FluidHomeScreenViewModel fluidHomeScreenViewModel) {
        super(1);
        this.f59728g = fluidHomeScreenViewModel;
    }

    @Nullable
    public final VerticalItem invoke(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "it");
        return this.f59728g.verticalItemViewEntityMapper.getVerticalItem(str);
    }
}
