package androidx.fragment.app.testing;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentFactory;
import com.newrelic.agent.android.agentdata.HexAttribute;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b"}, d2 = {"androidx/fragment/app/testing/FragmentScenarioKt$launchFragmentInContainer$2", "Landroidx/fragment/app/FragmentFactory;", "instantiate", "Landroidx/fragment/app/Fragment;", "classLoader", "Ljava/lang/ClassLoader;", "className", "", "fragment-testing_release"}, k = 1, mv = {1, 6, 0}, xi = 176)
public final class FragmentScenarioKt$launchFragmentInContainer$2 extends FragmentFactory {
    final /* synthetic */ Function0<F> $instantiate;

    public FragmentScenarioKt$launchFragmentInContainer$2(Function0<? extends F> function0) {
        this.$instantiate = function0;
    }

    @NotNull
    public Fragment instantiate(@NotNull ClassLoader classLoader, @NotNull String str) {
        Fragment fragment;
        Intrinsics.checkNotNullParameter(classLoader, "classLoader");
        Intrinsics.checkNotNullParameter(str, HexAttribute.HEX_ATTR_CLASS_NAME);
        Intrinsics.reifiedOperationMarker(4, "F");
        if (Intrinsics.areEqual((Object) str, (Object) Fragment.class.getName())) {
            fragment = (Fragment) this.$instantiate.invoke();
        } else {
            fragment = super.instantiate(classLoader, str);
        }
        Intrinsics.checkNotNullExpressionValue(fragment, "when (className) {\n     …der, className)\n        }");
        return fragment;
    }
}
