package d2;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.lifecycle.viewmodel.ViewModelInitializer;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

public final /* synthetic */ class h {
    static {
        ViewModelProvider.Factory.Companion companion = ViewModelProvider.Factory.Companion;
    }

    @NotNull
    public static ViewModel a(ViewModelProvider.Factory factory, @NotNull Class cls) {
        Intrinsics.checkNotNullParameter(cls, "modelClass");
        throw new UnsupportedOperationException("Factory.create(String) is unsupported.  This Factory requires `CreationExtras` to be passed into `create` method.");
    }

    @NotNull
    public static ViewModel b(ViewModelProvider.Factory factory, @NotNull Class cls, @NotNull CreationExtras creationExtras) {
        Intrinsics.checkNotNullParameter(cls, "modelClass");
        Intrinsics.checkNotNullParameter(creationExtras, "extras");
        return factory.create(cls);
    }

    @JvmStatic
    @NotNull
    public static ViewModelProvider.Factory c(@NotNull ViewModelInitializer<?>... viewModelInitializerArr) {
        return ViewModelProvider.Factory.Companion.from(viewModelInitializerArr);
    }
}
