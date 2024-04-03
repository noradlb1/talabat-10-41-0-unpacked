package com.talabat.feature.rating.presentation.ui;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.viewmodel.CreationExtras;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\n\b\u0000\u0010\u0002\u0018\u0001*\u00020\u0003H\n¢\u0006\u0002\b\u0004¨\u0006\u0005"}, d2 = {"<anonymous>", "Landroidx/lifecycle/viewmodel/CreationExtras;", "VM", "Landroidx/lifecycle/ViewModel;", "invoke", "androidx/fragment/app/FragmentViewModelLazyKt$activityViewModels$5"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class RatingCommentFragment$special$$inlined$activityViewModels$default$2 extends Lambda implements Function0<CreationExtras> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ Function0 f58695g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ Fragment f58696h;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public RatingCommentFragment$special$$inlined$activityViewModels$default$2(Function0 function0, Fragment fragment) {
        super(0);
        this.f58695g = function0;
        this.f58696h = fragment;
    }

    @NotNull
    public final CreationExtras invoke() {
        CreationExtras creationExtras;
        Function0 function0 = this.f58695g;
        if (function0 != null && (creationExtras = (CreationExtras) function0.invoke()) != null) {
            return creationExtras;
        }
        CreationExtras defaultViewModelCreationExtras = this.f58696h.requireActivity().getDefaultViewModelCreationExtras();
        Intrinsics.checkNotNullExpressionValue(defaultViewModelCreationExtras, "requireActivity().defaultViewModelCreationExtras");
        return defaultViewModelCreationExtras;
    }
}
