package g2;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentOnAttachListener;
import androidx.navigation.fragment.DialogFragmentNavigator;

public final /* synthetic */ class a implements FragmentOnAttachListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ DialogFragmentNavigator f44294b;

    public /* synthetic */ a(DialogFragmentNavigator dialogFragmentNavigator) {
        this.f44294b = dialogFragmentNavigator;
    }

    public final void onAttachFragment(FragmentManager fragmentManager, Fragment fragment) {
        DialogFragmentNavigator.m9115onAttach$lambda5(this.f44294b, fragmentManager, fragment);
    }
}
