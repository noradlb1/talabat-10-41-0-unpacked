package com.talabat.darkstores.feature.mission.control;

import androidx.navigation.NavDirections;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.FunctionReferenceImpl;
import org.jetbrains.annotations.NotNull;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
public /* synthetic */ class MainViewModel$navigateToCart$2 extends FunctionReferenceImpl implements Function0<NavDirections> {
    public MainViewModel$navigateToCart$2(Object obj) {
        super(0, obj, MainViewModel.class, "buildNativeCartAction", "buildNativeCartAction()Landroidx/navigation/NavDirections;", 0);
    }

    @NotNull
    public final NavDirections invoke() {
        return ((MainViewModel) this.receiver).buildNativeCartAction();
    }
}
