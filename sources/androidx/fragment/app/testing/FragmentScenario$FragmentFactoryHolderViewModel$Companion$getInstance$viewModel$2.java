package androidx.fragment.app.testing;

import androidx.fragment.app.testing.FragmentScenario;
import androidx.lifecycle.ViewModelProvider;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Landroidx/lifecycle/ViewModelProvider$Factory;", "F", "Landroidx/fragment/app/Fragment;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class FragmentScenario$FragmentFactoryHolderViewModel$Companion$getInstance$viewModel$2 extends Lambda implements Function0<ViewModelProvider.Factory> {
    public static final FragmentScenario$FragmentFactoryHolderViewModel$Companion$getInstance$viewModel$2 INSTANCE = new FragmentScenario$FragmentFactoryHolderViewModel$Companion$getInstance$viewModel$2();

    public FragmentScenario$FragmentFactoryHolderViewModel$Companion$getInstance$viewModel$2() {
        super(0);
    }

    @NotNull
    public final ViewModelProvider.Factory invoke() {
        return FragmentScenario.FragmentFactoryHolderViewModel.Companion.getFACTORY$fragment_testing_release();
    }
}
