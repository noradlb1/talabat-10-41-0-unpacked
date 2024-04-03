package com.talabat.talabatcore;

import com.talabat.talabatcore.viewmodel.BaseViewModel;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.FunctionReferenceImpl;
import org.jetbrains.annotations.NotNull;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
public /* synthetic */ class BaseFragment$factory$1 extends FunctionReferenceImpl implements Function0 {
    public BaseFragment$factory$1(Object obj) {
        super(0, obj, BaseFragment.class, "viewModelBuilder", "viewModelBuilder()Lcom/talabat/talabatcore/viewmodel/BaseViewModel;", 0);
    }

    @NotNull
    public final BaseViewModel invoke() {
        return ((BaseFragment) this.receiver).viewModelBuilder();
    }
}
