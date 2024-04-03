package com.talabat.talabatcore.extensions;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000&\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\u0011\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002¢\u0006\u0002\u0010\u0003\u001a)\u0010\u0004\u001a\u00020\u0005*\u00020\u00062\u0017\u0010\u0007\u001a\u0013\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t0\b¢\u0006\u0002\b\nH\bø\u0001\u0000\u0002\u0007\n\u0005\b20\u0001¨\u0006\u000b"}, d2 = {"close", "", "Landroidx/fragment/app/Fragment;", "(Landroidx/fragment/app/Fragment;)Lkotlin/Unit;", "inTransaction", "", "Landroidx/fragment/app/FragmentManager;", "func", "Lkotlin/Function1;", "Landroidx/fragment/app/FragmentTransaction;", "Lkotlin/ExtensionFunctionType;", "com_talabat_NewArchi_TalabatCore_TalabatCore"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class FragmentKt {
    @Nullable
    public static final Unit close(@NotNull Fragment fragment) {
        Intrinsics.checkNotNullParameter(fragment, "<this>");
        FragmentManager fragmentManager = fragment.getFragmentManager();
        if (fragmentManager == null) {
            return null;
        }
        fragmentManager.popBackStack();
        return Unit.INSTANCE;
    }

    public static final int inTransaction(@NotNull FragmentManager fragmentManager, @NotNull Function1<? super FragmentTransaction, ? extends FragmentTransaction> function1) {
        Intrinsics.checkNotNullParameter(fragmentManager, "<this>");
        Intrinsics.checkNotNullParameter(function1, "func");
        FragmentTransaction beginTransaction = fragmentManager.beginTransaction();
        Intrinsics.checkNotNullExpressionValue(beginTransaction, "beginTransaction()");
        return ((FragmentTransaction) function1.invoke(beginTransaction)).commit();
    }
}
