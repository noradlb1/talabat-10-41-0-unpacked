package com.talabat.talabatcommon.views.customMvvmView;

import android.util.AttributeSet;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import com.talabat.talabatcore.viewmodel.BaseViewModel;
import com.talabat.talabatcore.viewmodel.BaseViewModelFactory;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\f\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u0002H\u0001\"\b\b\u0000\u0010\u0001*\u00020\u0002H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"<anonymous>", "VM", "Lcom/talabat/talabatcore/viewmodel/BaseViewModel;", "invoke", "()Lcom/talabat/talabatcore/viewmodel/BaseViewModel;"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class MvvmLinearLayout$viewModel$2 extends Lambda implements Function0<VM> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ MvvmLinearLayout<VM> f11720g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public MvvmLinearLayout$viewModel$2(MvvmLinearLayout<VM> mvvmLinearLayout) {
        super(0);
        this.f11720g = mvvmLinearLayout;
    }

    @NotNull
    public final VM invoke() {
        BaseViewModelFactory baseViewModelFactory = new BaseViewModelFactory(new MvvmLinearLayout$viewModel$2$mFactory$1(this.f11720g));
        MvvmLinearLayout<VM> mvvmLinearLayout = this.f11720g;
        return (BaseViewModel) ViewModelProviders.of(mvvmLinearLayout.scanForActivity(mvvmLinearLayout.getContext()), (ViewModelProvider.Factory) baseViewModelFactory).get(String.valueOf(MvvmLinearLayout.getLayoutId$default(mvvmLinearLayout, (AttributeSet) null, 1, (Object) null)), mvvmLinearLayout.getViewModelClass());
    }
}
