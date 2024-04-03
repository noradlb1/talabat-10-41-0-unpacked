package com.talabat.fluid.homescreen.presentation.viewmodel;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "com.talabat.fluid.homescreen.presentation.viewmodel.FluidHomeScreenViewModel", f = "FluidHomeScreenViewModel.kt", i = {0}, l = {213}, m = "showRatingBottomSheet", n = {"this"}, s = {"L$0"})
public final class FluidHomeScreenViewModel$showRatingBottomSheet$1 extends ContinuationImpl {

    /* renamed from: h  reason: collision with root package name */
    public Object f59732h;

    /* renamed from: i  reason: collision with root package name */
    public /* synthetic */ Object f59733i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ FluidHomeScreenViewModel f59734j;

    /* renamed from: k  reason: collision with root package name */
    public int f59735k;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FluidHomeScreenViewModel$showRatingBottomSheet$1(FluidHomeScreenViewModel fluidHomeScreenViewModel, Continuation<? super FluidHomeScreenViewModel$showRatingBottomSheet$1> continuation) {
        super(continuation);
        this.f59734j = fluidHomeScreenViewModel;
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.f59733i = obj;
        this.f59735k |= Integer.MIN_VALUE;
        return this.f59734j.showRatingBottomSheet(this);
    }
}
