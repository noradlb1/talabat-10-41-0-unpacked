package com.talabat.darkstores.feature.categories.subcategories.experiment;

import android.os.Bundle;
import com.talabat.darkstores.feature.categories.subcategories.sort.SortOptionBottomSheetKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", "<anonymous parameter 0>", "", "bundle", "Landroid/os/Bundle;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class SubcategoriesFragmentNew$onViewCreated$10 extends Lambda implements Function2<String, Bundle, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ SubcategoriesFragmentNew f56334g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SubcategoriesFragmentNew$onViewCreated$10(SubcategoriesFragmentNew subcategoriesFragmentNew) {
        super(2);
        this.f56334g = subcategoriesFragmentNew;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((String) obj, (Bundle) obj2);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull String str, @NotNull Bundle bundle) {
        Intrinsics.checkNotNullParameter(str, "<anonymous parameter 0>");
        Intrinsics.checkNotNullParameter(bundle, "bundle");
        String string = bundle.getString(SortOptionBottomSheetKt.SORT_OPTION_KEY);
        if (!(string == null || string.length() == 0)) {
            this.f56334g.getViewModel().onSortApplied(string);
        }
    }
}
