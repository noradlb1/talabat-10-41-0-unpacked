package com.talabat.feature.nfvinvendorsearch.presentation.activity;

import androidx.activity.ComponentActivity;
import androidx.lifecycle.viewmodel.CreationExtras;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\n\b\u0000\u0010\u0002\u0018\u0001*\u00020\u0003H\n¢\u0006\u0002\b\u0004¨\u0006\u0005"}, d2 = {"<anonymous>", "Landroidx/lifecycle/viewmodel/CreationExtras;", "VM", "Landroidx/lifecycle/ViewModel;", "invoke", "androidx/activity/ActivityViewModelLazyKt$viewModels$4"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class QCommerceFlutterActivity$special$$inlined$viewModels$default$3 extends Lambda implements Function0<CreationExtras> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ Function0 f58615g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ ComponentActivity f58616h;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public QCommerceFlutterActivity$special$$inlined$viewModels$default$3(Function0 function0, ComponentActivity componentActivity) {
        super(0);
        this.f58615g = function0;
        this.f58616h = componentActivity;
    }

    @NotNull
    public final CreationExtras invoke() {
        CreationExtras creationExtras;
        Function0 function0 = this.f58615g;
        if (function0 != null && (creationExtras = (CreationExtras) function0.invoke()) != null) {
            return creationExtras;
        }
        CreationExtras defaultViewModelCreationExtras = this.f58616h.getDefaultViewModelCreationExtras();
        Intrinsics.checkNotNullExpressionValue(defaultViewModelCreationExtras, "this.defaultViewModelCreationExtras");
        return defaultViewModelCreationExtras;
    }
}
