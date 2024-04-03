package androidx.fragment.app.testing;

import android.os.Bundle;
import androidx.annotation.StyleRes;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentFactory;
import androidx.fragment.app.testing.FragmentScenario;
import androidx.fragment.testing.R;
import androidx.lifecycle.Lifecycle;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

@Metadata(d1 = {"\u0000@\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001aD\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\n\b\u0000\u0010\u0002\u0018\u0001*\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0003\u0010\u0006\u001a\u00020\u00072\u000e\b\u0004\u0010\b\u001a\b\u0012\u0004\u0012\u0002H\u00020\tH\bø\u0001\u0000\u001a=\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\n\b\u0000\u0010\u0002\u0018\u0001*\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0003\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000bH\b\u001aN\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\n\b\u0000\u0010\u0002\u0018\u0001*\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0003\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\f\u001a\u00020\r2\u000e\b\u0004\u0010\b\u001a\b\u0012\u0004\u0012\u0002H\u00020\tH\bø\u0001\u0000\u001aG\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\n\b\u0000\u0010\u0002\u0018\u0001*\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0003\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\f\u001a\u00020\r2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000bH\b\u001aD\u0010\u000e\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\n\b\u0000\u0010\u0002\u0018\u0001*\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0003\u0010\u0006\u001a\u00020\u00072\u000e\b\u0004\u0010\b\u001a\b\u0012\u0004\u0012\u0002H\u00020\tH\bø\u0001\u0000\u001a=\u0010\u000e\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\n\b\u0000\u0010\u0002\u0018\u0001*\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0003\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000bH\b\u001aN\u0010\u000e\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\n\b\u0000\u0010\u0002\u0018\u0001*\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0003\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\f\u001a\u00020\r2\u000e\b\u0004\u0010\b\u001a\b\u0012\u0004\u0012\u0002H\u00020\tH\bø\u0001\u0000\u001aG\u0010\u000e\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\n\b\u0000\u0010\u0002\u0018\u0001*\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0003\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\f\u001a\u00020\r2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000bH\b\u001aL\u0010\u000f\u001a\u0002H\u0010\"\n\b\u0000\u0010\u0002\u0018\u0001*\u00020\u0003\"\b\b\u0001\u0010\u0010*\u00020\u0011*\b\u0012\u0004\u0012\u0002H\u00020\u00012\u0019\b\u0004\u0010\u0012\u001a\u0013\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00100\u0013¢\u0006\u0002\b\u0014H\bø\u0001\u0000¢\u0006\u0002\u0010\u0015\u0002\u0007\n\u0005\b20\u0001¨\u0006\u0016"}, d2 = {"launchFragment", "Landroidx/fragment/app/testing/FragmentScenario;", "F", "Landroidx/fragment/app/Fragment;", "fragmentArgs", "Landroid/os/Bundle;", "themeResId", "", "instantiate", "Lkotlin/Function0;", "factory", "Landroidx/fragment/app/FragmentFactory;", "initialState", "Landroidx/lifecycle/Lifecycle$State;", "launchFragmentInContainer", "withFragment", "T", "", "block", "Lkotlin/Function1;", "Lkotlin/ExtensionFunctionType;", "(Landroidx/fragment/app/testing/FragmentScenario;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "fragment-testing_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class FragmentScenarioKt {
    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Superseded by launchFragment that takes an initialState")
    public static final /* synthetic */ <F extends Fragment> FragmentScenario<F> launchFragment(Bundle bundle, @StyleRes int i11, FragmentFactory fragmentFactory) {
        Lifecycle.State state = Lifecycle.State.RESUMED;
        FragmentScenario.Companion companion = FragmentScenario.Companion;
        Intrinsics.reifiedOperationMarker(4, "F");
        return companion.launch(Fragment.class, bundle, i11, state, fragmentFactory);
    }

    public static /* synthetic */ FragmentScenario launchFragment$default(Bundle bundle, int i11, FragmentFactory fragmentFactory, int i12, Object obj) {
        Bundle bundle2 = (i12 & 1) != 0 ? null : bundle;
        if ((i12 & 2) != 0) {
            i11 = R.style.FragmentScenarioEmptyFragmentActivityTheme;
        }
        int i13 = i11;
        FragmentFactory fragmentFactory2 = (i12 & 4) != 0 ? null : fragmentFactory;
        Lifecycle.State state = Lifecycle.State.RESUMED;
        FragmentScenario.Companion companion = FragmentScenario.Companion;
        Intrinsics.reifiedOperationMarker(4, "F");
        return companion.launch(Fragment.class, bundle2, i13, state, fragmentFactory2);
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Superseded by launchFragmentInContainer that takes an initialState")
    public static final /* synthetic */ <F extends Fragment> FragmentScenario<F> launchFragmentInContainer(Bundle bundle, @StyleRes int i11, FragmentFactory fragmentFactory) {
        Lifecycle.State state = Lifecycle.State.RESUMED;
        FragmentScenario.Companion companion = FragmentScenario.Companion;
        Intrinsics.reifiedOperationMarker(4, "F");
        return companion.launchInContainer(Fragment.class, bundle, i11, state, fragmentFactory);
    }

    public static /* synthetic */ FragmentScenario launchFragmentInContainer$default(Bundle bundle, int i11, FragmentFactory fragmentFactory, int i12, Object obj) {
        Bundle bundle2 = (i12 & 1) != 0 ? null : bundle;
        if ((i12 & 2) != 0) {
            i11 = R.style.FragmentScenarioEmptyFragmentActivityTheme;
        }
        int i13 = i11;
        FragmentFactory fragmentFactory2 = (i12 & 4) != 0 ? null : fragmentFactory;
        Lifecycle.State state = Lifecycle.State.RESUMED;
        FragmentScenario.Companion companion = FragmentScenario.Companion;
        Intrinsics.reifiedOperationMarker(4, "F");
        return companion.launchInContainer(Fragment.class, bundle2, i13, state, fragmentFactory2);
    }

    public static final /* synthetic */ <F extends Fragment, T> T withFragment(FragmentScenario<F> fragmentScenario, Function1<? super F, ? extends T> function1) {
        Intrinsics.checkNotNullParameter(fragmentScenario, "<this>");
        Intrinsics.checkNotNullParameter(function1, "block");
        Ref.ObjectRef objectRef = new Ref.ObjectRef();
        Ref.ObjectRef objectRef2 = new Ref.ObjectRef();
        fragmentScenario.onFragment(new FragmentScenarioKt$withFragment$1(objectRef, function1, objectRef2));
        Throwable th2 = (Throwable) objectRef2.element;
        if (th2 == null) {
            T t11 = objectRef.element;
            if (t11 != null) {
                return t11;
            }
            Intrinsics.throwUninitializedPropertyAccessException("value");
            return Unit.INSTANCE;
        }
        throw th2;
    }

    public static final /* synthetic */ <F extends Fragment> FragmentScenario<F> launchFragment(Bundle bundle, @StyleRes int i11, Lifecycle.State state, FragmentFactory fragmentFactory) {
        Intrinsics.checkNotNullParameter(state, "initialState");
        FragmentScenario.Companion companion = FragmentScenario.Companion;
        Intrinsics.reifiedOperationMarker(4, "F");
        return companion.launch(Fragment.class, bundle, i11, state, fragmentFactory);
    }

    public static final /* synthetic */ <F extends Fragment> FragmentScenario<F> launchFragmentInContainer(Bundle bundle, @StyleRes int i11, Lifecycle.State state, FragmentFactory fragmentFactory) {
        Intrinsics.checkNotNullParameter(state, "initialState");
        FragmentScenario.Companion companion = FragmentScenario.Companion;
        Intrinsics.reifiedOperationMarker(4, "F");
        return companion.launchInContainer(Fragment.class, bundle, i11, state, fragmentFactory);
    }

    public static final /* synthetic */ <F extends Fragment> FragmentScenario<F> launchFragment(Bundle bundle, @StyleRes int i11, Lifecycle.State state, Function0<? extends F> function0) {
        Intrinsics.checkNotNullParameter(state, "initialState");
        Intrinsics.checkNotNullParameter(function0, "instantiate");
        FragmentScenario.Companion companion = FragmentScenario.Companion;
        Intrinsics.reifiedOperationMarker(4, "F");
        Intrinsics.needClassReification();
        return companion.launch(Fragment.class, bundle, i11, state, new FragmentScenarioKt$launchFragment$2(function0));
    }

    public static /* synthetic */ FragmentScenario launchFragment$default(Bundle bundle, int i11, Function0 function0, int i12, Object obj) {
        if ((i12 & 1) != 0) {
            bundle = null;
        }
        Bundle bundle2 = bundle;
        if ((i12 & 2) != 0) {
            i11 = R.style.FragmentScenarioEmptyFragmentActivityTheme;
        }
        Intrinsics.checkNotNullParameter(function0, "instantiate");
        Lifecycle.State state = Lifecycle.State.RESUMED;
        FragmentScenario.Companion companion = FragmentScenario.Companion;
        Intrinsics.reifiedOperationMarker(4, "F");
        Class<Fragment> cls = Fragment.class;
        Intrinsics.needClassReification();
        return companion.launch(cls, bundle2, i11, state, new FragmentScenarioKt$launchFragment$$inlined$launchFragment$default$1(function0));
    }

    public static final /* synthetic */ <F extends Fragment> FragmentScenario<F> launchFragmentInContainer(Bundle bundle, @StyleRes int i11, Lifecycle.State state, Function0<? extends F> function0) {
        Intrinsics.checkNotNullParameter(state, "initialState");
        Intrinsics.checkNotNullParameter(function0, "instantiate");
        FragmentScenario.Companion companion = FragmentScenario.Companion;
        Intrinsics.reifiedOperationMarker(4, "F");
        Intrinsics.needClassReification();
        return companion.launchInContainer(Fragment.class, bundle, i11, state, new FragmentScenarioKt$launchFragmentInContainer$2(function0));
    }

    public static /* synthetic */ FragmentScenario launchFragmentInContainer$default(Bundle bundle, int i11, Function0 function0, int i12, Object obj) {
        if ((i12 & 1) != 0) {
            bundle = null;
        }
        Bundle bundle2 = bundle;
        if ((i12 & 2) != 0) {
            i11 = R.style.FragmentScenarioEmptyFragmentActivityTheme;
        }
        Intrinsics.checkNotNullParameter(function0, "instantiate");
        Lifecycle.State state = Lifecycle.State.RESUMED;
        FragmentScenario.Companion companion = FragmentScenario.Companion;
        Intrinsics.reifiedOperationMarker(4, "F");
        Class<Fragment> cls = Fragment.class;
        Intrinsics.needClassReification();
        return companion.launchInContainer(cls, bundle2, i11, state, new FragmentScenarioKt$launchFragmentInContainer$$inlined$launchFragmentInContainer$default$1(function0));
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Superseded by launchFragment that takes an initialState")
    public static final /* synthetic */ <F extends Fragment> FragmentScenario<F> launchFragment(Bundle bundle, @StyleRes int i11, Function0<? extends F> function0) {
        Intrinsics.checkNotNullParameter(function0, "instantiate");
        Lifecycle.State state = Lifecycle.State.RESUMED;
        FragmentScenario.Companion companion = FragmentScenario.Companion;
        Intrinsics.reifiedOperationMarker(4, "F");
        Intrinsics.needClassReification();
        return companion.launch(Fragment.class, bundle, i11, state, new FragmentScenarioKt$launchFragment$$inlined$launchFragment$default$1(function0));
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Superseded by launchFragmentInContainer that takes an initialState")
    public static final /* synthetic */ <F extends Fragment> FragmentScenario<F> launchFragmentInContainer(Bundle bundle, @StyleRes int i11, Function0<? extends F> function0) {
        Intrinsics.checkNotNullParameter(function0, "instantiate");
        Lifecycle.State state = Lifecycle.State.RESUMED;
        FragmentScenario.Companion companion = FragmentScenario.Companion;
        Intrinsics.reifiedOperationMarker(4, "F");
        Intrinsics.needClassReification();
        return companion.launchInContainer(Fragment.class, bundle, i11, state, new FragmentScenarioKt$launchFragmentInContainer$$inlined$launchFragmentInContainer$default$1(function0));
    }

    public static /* synthetic */ FragmentScenario launchFragment$default(Bundle bundle, int i11, Lifecycle.State state, FragmentFactory fragmentFactory, int i12, Object obj) {
        Bundle bundle2 = (i12 & 1) != 0 ? null : bundle;
        if ((i12 & 2) != 0) {
            i11 = R.style.FragmentScenarioEmptyFragmentActivityTheme;
        }
        int i13 = i11;
        if ((i12 & 4) != 0) {
            state = Lifecycle.State.RESUMED;
        }
        Lifecycle.State state2 = state;
        FragmentFactory fragmentFactory2 = (i12 & 8) != 0 ? null : fragmentFactory;
        Intrinsics.checkNotNullParameter(state2, "initialState");
        FragmentScenario.Companion companion = FragmentScenario.Companion;
        Intrinsics.reifiedOperationMarker(4, "F");
        return companion.launch(Fragment.class, bundle2, i13, state2, fragmentFactory2);
    }

    public static /* synthetic */ FragmentScenario launchFragmentInContainer$default(Bundle bundle, int i11, Lifecycle.State state, FragmentFactory fragmentFactory, int i12, Object obj) {
        Bundle bundle2 = (i12 & 1) != 0 ? null : bundle;
        if ((i12 & 2) != 0) {
            i11 = R.style.FragmentScenarioEmptyFragmentActivityTheme;
        }
        int i13 = i11;
        if ((i12 & 4) != 0) {
            state = Lifecycle.State.RESUMED;
        }
        Lifecycle.State state2 = state;
        FragmentFactory fragmentFactory2 = (i12 & 8) != 0 ? null : fragmentFactory;
        Intrinsics.checkNotNullParameter(state2, "initialState");
        FragmentScenario.Companion companion = FragmentScenario.Companion;
        Intrinsics.reifiedOperationMarker(4, "F");
        return companion.launchInContainer(Fragment.class, bundle2, i13, state2, fragmentFactory2);
    }

    public static /* synthetic */ FragmentScenario launchFragment$default(Bundle bundle, int i11, Lifecycle.State state, Function0 function0, int i12, Object obj) {
        if ((i12 & 1) != 0) {
            bundle = null;
        }
        Bundle bundle2 = bundle;
        if ((i12 & 2) != 0) {
            i11 = R.style.FragmentScenarioEmptyFragmentActivityTheme;
        }
        int i13 = i11;
        if ((i12 & 4) != 0) {
            state = Lifecycle.State.RESUMED;
        }
        Lifecycle.State state2 = state;
        Intrinsics.checkNotNullParameter(state2, "initialState");
        Intrinsics.checkNotNullParameter(function0, "instantiate");
        FragmentScenario.Companion companion = FragmentScenario.Companion;
        Intrinsics.reifiedOperationMarker(4, "F");
        Intrinsics.needClassReification();
        return companion.launch(Fragment.class, bundle2, i13, state2, new FragmentScenarioKt$launchFragment$2(function0));
    }

    public static /* synthetic */ FragmentScenario launchFragmentInContainer$default(Bundle bundle, int i11, Lifecycle.State state, Function0 function0, int i12, Object obj) {
        if ((i12 & 1) != 0) {
            bundle = null;
        }
        Bundle bundle2 = bundle;
        if ((i12 & 2) != 0) {
            i11 = R.style.FragmentScenarioEmptyFragmentActivityTheme;
        }
        int i13 = i11;
        if ((i12 & 4) != 0) {
            state = Lifecycle.State.RESUMED;
        }
        Lifecycle.State state2 = state;
        Intrinsics.checkNotNullParameter(state2, "initialState");
        Intrinsics.checkNotNullParameter(function0, "instantiate");
        FragmentScenario.Companion companion = FragmentScenario.Companion;
        Intrinsics.reifiedOperationMarker(4, "F");
        Intrinsics.needClassReification();
        return companion.launchInContainer(Fragment.class, bundle2, i13, state2, new FragmentScenarioKt$launchFragmentInContainer$2(function0));
    }
}
