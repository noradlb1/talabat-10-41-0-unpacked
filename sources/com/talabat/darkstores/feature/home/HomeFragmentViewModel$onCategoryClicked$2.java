package com.talabat.darkstores.feature.home;

import androidx.navigation.NavDirections;
import com.talabat.darkstores.feature.home.HomeFragmentDirections;
import kotlin.Metadata;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
public /* synthetic */ class HomeFragmentViewModel$onCategoryClicked$2 extends FunctionReferenceImpl implements Function3<String, String, String, NavDirections> {
    public HomeFragmentViewModel$onCategoryClicked$2(Object obj) {
        super(3, obj, HomeFragmentDirections.Companion.class, "actionHomeFragmentToSubcategoriesFragmentNew", "actionHomeFragmentToSubcategoriesFragmentNew(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroidx/navigation/NavDirections;", 0);
    }

    @NotNull
    public final NavDirections invoke(@NotNull String str, @NotNull String str2, @NotNull String str3) {
        Intrinsics.checkNotNullParameter(str, "p0");
        Intrinsics.checkNotNullParameter(str2, "p1");
        Intrinsics.checkNotNullParameter(str3, "p2");
        return ((HomeFragmentDirections.Companion) this.receiver).actionHomeFragmentToSubcategoriesFragmentNew(str, str2, str3);
    }
}
