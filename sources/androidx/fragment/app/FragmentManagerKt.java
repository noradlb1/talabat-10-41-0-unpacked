package androidx.fragment.app;

import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\"\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a3\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\b\b\u0002\u0010\u0003\u001a\u00020\u00042\u0017\u0010\u0005\u001a\u0013\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00010\u0006¢\u0006\u0002\b\bH\bø\u0001\u0000\u001a3\u0010\t\u001a\u00020\u0001*\u00020\u00022\b\b\u0002\u0010\u0003\u001a\u00020\u00042\u0017\u0010\u0005\u001a\u0013\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00010\u0006¢\u0006\u0002\b\bH\bø\u0001\u0000\u001a=\u0010\n\u001a\u00020\u0001*\u00020\u00022\b\b\u0002\u0010\u000b\u001a\u00020\u00042\b\b\u0002\u0010\u0003\u001a\u00020\u00042\u0017\u0010\u0005\u001a\u0013\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00010\u0006¢\u0006\u0002\b\bH\bø\u0001\u0000\u0002\u0007\n\u0005\b20\u0001¨\u0006\f"}, d2 = {"commit", "", "Landroidx/fragment/app/FragmentManager;", "allowStateLoss", "", "body", "Lkotlin/Function1;", "Landroidx/fragment/app/FragmentTransaction;", "Lkotlin/ExtensionFunctionType;", "commitNow", "transaction", "now", "fragment-ktx_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class FragmentManagerKt {
    public static final void commit(@NotNull FragmentManager fragmentManager, boolean z11, @NotNull Function1<? super FragmentTransaction, Unit> function1) {
        Intrinsics.checkNotNullParameter(fragmentManager, "<this>");
        Intrinsics.checkNotNullParameter(function1, "body");
        FragmentTransaction beginTransaction = fragmentManager.beginTransaction();
        Intrinsics.checkNotNullExpressionValue(beginTransaction, "beginTransaction()");
        function1.invoke(beginTransaction);
        if (z11) {
            beginTransaction.commitAllowingStateLoss();
        } else {
            beginTransaction.commit();
        }
    }

    public static /* synthetic */ void commit$default(FragmentManager fragmentManager, boolean z11, Function1 function1, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            z11 = false;
        }
        Intrinsics.checkNotNullParameter(fragmentManager, "<this>");
        Intrinsics.checkNotNullParameter(function1, "body");
        FragmentTransaction beginTransaction = fragmentManager.beginTransaction();
        Intrinsics.checkNotNullExpressionValue(beginTransaction, "beginTransaction()");
        function1.invoke(beginTransaction);
        if (z11) {
            beginTransaction.commitAllowingStateLoss();
        } else {
            beginTransaction.commit();
        }
    }

    public static final void commitNow(@NotNull FragmentManager fragmentManager, boolean z11, @NotNull Function1<? super FragmentTransaction, Unit> function1) {
        Intrinsics.checkNotNullParameter(fragmentManager, "<this>");
        Intrinsics.checkNotNullParameter(function1, "body");
        FragmentTransaction beginTransaction = fragmentManager.beginTransaction();
        Intrinsics.checkNotNullExpressionValue(beginTransaction, "beginTransaction()");
        function1.invoke(beginTransaction);
        if (z11) {
            beginTransaction.commitNowAllowingStateLoss();
        } else {
            beginTransaction.commitNow();
        }
    }

    public static /* synthetic */ void commitNow$default(FragmentManager fragmentManager, boolean z11, Function1 function1, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            z11 = false;
        }
        Intrinsics.checkNotNullParameter(fragmentManager, "<this>");
        Intrinsics.checkNotNullParameter(function1, "body");
        FragmentTransaction beginTransaction = fragmentManager.beginTransaction();
        Intrinsics.checkNotNullExpressionValue(beginTransaction, "beginTransaction()");
        function1.invoke(beginTransaction);
        if (z11) {
            beginTransaction.commitNowAllowingStateLoss();
        } else {
            beginTransaction.commitNow();
        }
    }

    @Deprecated(message = "Use commit { .. } or commitNow { .. } extensions")
    public static final void transaction(@NotNull FragmentManager fragmentManager, boolean z11, boolean z12, @NotNull Function1<? super FragmentTransaction, Unit> function1) {
        Intrinsics.checkNotNullParameter(fragmentManager, "<this>");
        Intrinsics.checkNotNullParameter(function1, "body");
        FragmentTransaction beginTransaction = fragmentManager.beginTransaction();
        Intrinsics.checkNotNullExpressionValue(beginTransaction, "beginTransaction()");
        function1.invoke(beginTransaction);
        if (z11) {
            if (z12) {
                beginTransaction.commitNowAllowingStateLoss();
            } else {
                beginTransaction.commitNow();
            }
        } else if (z12) {
            beginTransaction.commitAllowingStateLoss();
        } else {
            beginTransaction.commit();
        }
    }

    public static /* synthetic */ void transaction$default(FragmentManager fragmentManager, boolean z11, boolean z12, Function1 function1, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            z11 = false;
        }
        if ((i11 & 2) != 0) {
            z12 = false;
        }
        Intrinsics.checkNotNullParameter(fragmentManager, "<this>");
        Intrinsics.checkNotNullParameter(function1, "body");
        FragmentTransaction beginTransaction = fragmentManager.beginTransaction();
        Intrinsics.checkNotNullExpressionValue(beginTransaction, "beginTransaction()");
        function1.invoke(beginTransaction);
        if (z11) {
            if (z12) {
                beginTransaction.commitNowAllowingStateLoss();
            } else {
                beginTransaction.commitNow();
            }
        } else if (z12) {
            beginTransaction.commitAllowingStateLoss();
        } else {
            beginTransaction.commit();
        }
    }
}
