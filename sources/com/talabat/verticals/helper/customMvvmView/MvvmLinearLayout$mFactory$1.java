package com.talabat.verticals.helper.customMvvmView;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.FunctionReferenceImpl;
import org.jetbrains.annotations.NotNull;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
public /* synthetic */ class MvvmLinearLayout$mFactory$1 extends FunctionReferenceImpl implements Function0<VM> {
    public MvvmLinearLayout$mFactory$1(Object obj) {
        super(0, obj, MvvmLinearLayout.class, "viewModelBuilder", "viewModelBuilder()Lcom/talabat/talabatcore/viewmodel/BaseViewModel;", 0);
    }

    @NotNull
    public final VM invoke() {
        return ((MvvmLinearLayout) this.receiver).viewModelBuilder();
    }
}
