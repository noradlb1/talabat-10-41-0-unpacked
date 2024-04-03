package androidx.lifecycle.viewmodel.compose;

import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.lifecycle.HasDefaultViewModelProviderFactory;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.lifecycle.viewmodel.InitializerViewModelFactoryBuilder;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000:\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u001a<\u0010\u0000\u001a\u0002H\u0001\"\n\b\u0000\u0010\u0001\u0018\u0001*\u00020\u00022\b\b\u0002\u0010\u0003\u001a\u00020\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\bH\b¢\u0006\u0002\u0010\t\u001aF\u0010\u0000\u001a\u0002H\u0001\"\n\b\u0000\u0010\u0001\u0018\u0001*\u00020\u00022\b\b\u0002\u0010\u0003\u001a\u00020\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\b\u0002\u0010\n\u001a\u00020\u000bH\b¢\u0006\u0002\u0010\f\u001aN\u0010\u0000\u001a\u0002H\u0001\"\n\b\u0000\u0010\u0001\u0018\u0001*\u00020\u00022\b\b\u0002\u0010\u0003\u001a\u00020\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0019\b\b\u0010\r\u001a\u0013\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u0002H\u00010\u000e¢\u0006\u0002\b\u000fH\bø\u0001\u0000¢\u0006\u0002\u0010\u0010\u001aG\u0010\u0000\u001a\u0002H\u0001\"\b\b\u0000\u0010\u0001*\u00020\u00022\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u0002H\u00010\u00122\b\b\u0002\u0010\u0003\u001a\u00020\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0007¢\u0006\u0002\u0010\u0013\u001aQ\u0010\u0000\u001a\u0002H\u0001\"\b\b\u0000\u0010\u0001*\u00020\u00022\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u0002H\u00010\u00122\b\b\u0002\u0010\u0003\u001a\u00020\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\b\u0002\u0010\n\u001a\u00020\u000bH\u0007¢\u0006\u0002\u0010\u0014\u001aK\u0010\u0015\u001a\u0002H\u0001\"\b\b\u0000\u0010\u0001*\u00020\u0002*\u00020\u00042\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u0002H\u00010\u00122\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\b\u0002\u0010\n\u001a\u00020\u000bH\u0002¢\u0006\u0002\u0010\u0017\u0002\u0007\n\u0005\b20\u0001¨\u0006\u0018"}, d2 = {"viewModel", "VM", "Landroidx/lifecycle/ViewModel;", "viewModelStoreOwner", "Landroidx/lifecycle/ViewModelStoreOwner;", "key", "", "factory", "Landroidx/lifecycle/ViewModelProvider$Factory;", "(Landroidx/lifecycle/ViewModelStoreOwner;Ljava/lang/String;Landroidx/lifecycle/ViewModelProvider$Factory;Landroidx/compose/runtime/Composer;II)Landroidx/lifecycle/ViewModel;", "extras", "Landroidx/lifecycle/viewmodel/CreationExtras;", "(Landroidx/lifecycle/ViewModelStoreOwner;Ljava/lang/String;Landroidx/lifecycle/ViewModelProvider$Factory;Landroidx/lifecycle/viewmodel/CreationExtras;Landroidx/compose/runtime/Composer;II)Landroidx/lifecycle/ViewModel;", "initializer", "Lkotlin/Function1;", "Lkotlin/ExtensionFunctionType;", "(Landroidx/lifecycle/ViewModelStoreOwner;Ljava/lang/String;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)Landroidx/lifecycle/ViewModel;", "modelClass", "Ljava/lang/Class;", "(Ljava/lang/Class;Landroidx/lifecycle/ViewModelStoreOwner;Ljava/lang/String;Landroidx/lifecycle/ViewModelProvider$Factory;Landroidx/compose/runtime/Composer;II)Landroidx/lifecycle/ViewModel;", "(Ljava/lang/Class;Landroidx/lifecycle/ViewModelStoreOwner;Ljava/lang/String;Landroidx/lifecycle/ViewModelProvider$Factory;Landroidx/lifecycle/viewmodel/CreationExtras;Landroidx/compose/runtime/Composer;II)Landroidx/lifecycle/ViewModel;", "get", "javaClass", "(Landroidx/lifecycle/ViewModelStoreOwner;Ljava/lang/Class;Ljava/lang/String;Landroidx/lifecycle/ViewModelProvider$Factory;Landroidx/lifecycle/viewmodel/CreationExtras;)Landroidx/lifecycle/ViewModel;", "lifecycle-viewmodel-compose_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class ViewModelKt {
    public static /* synthetic */ ViewModel a(ViewModelStoreOwner viewModelStoreOwner, Class cls, String str, ViewModelProvider.Factory factory, CreationExtras creationExtras, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            str = null;
        }
        if ((i11 & 4) != 0) {
            factory = null;
        }
        if ((i11 & 8) != 0) {
            if (viewModelStoreOwner instanceof HasDefaultViewModelProviderFactory) {
                creationExtras = ((HasDefaultViewModelProviderFactory) viewModelStoreOwner).getDefaultViewModelCreationExtras();
                Intrinsics.checkNotNullExpressionValue(creationExtras, "{\n        this.defaultVi…ModelCreationExtras\n    }");
            } else {
                creationExtras = CreationExtras.Empty.INSTANCE;
            }
        }
        return get(viewModelStoreOwner, cls, str, factory, creationExtras);
    }

    private static final <VM extends ViewModel> VM get(ViewModelStoreOwner viewModelStoreOwner, Class<VM> cls, String str, ViewModelProvider.Factory factory, CreationExtras creationExtras) {
        ViewModelProvider viewModelProvider;
        if (factory != null) {
            ViewModelStore viewModelStore = viewModelStoreOwner.getViewModelStore();
            Intrinsics.checkNotNullExpressionValue(viewModelStore, "this.viewModelStore");
            viewModelProvider = new ViewModelProvider(viewModelStore, factory, creationExtras);
        } else if (viewModelStoreOwner instanceof HasDefaultViewModelProviderFactory) {
            ViewModelStore viewModelStore2 = viewModelStoreOwner.getViewModelStore();
            Intrinsics.checkNotNullExpressionValue(viewModelStore2, "this.viewModelStore");
            ViewModelProvider.Factory defaultViewModelProviderFactory = ((HasDefaultViewModelProviderFactory) viewModelStoreOwner).getDefaultViewModelProviderFactory();
            Intrinsics.checkNotNullExpressionValue(defaultViewModelProviderFactory, "this.defaultViewModelProviderFactory");
            viewModelProvider = new ViewModelProvider(viewModelStore2, defaultViewModelProviderFactory, creationExtras);
        } else {
            viewModelProvider = new ViewModelProvider(viewModelStoreOwner);
        }
        if (str != null) {
            return viewModelProvider.get(str, cls);
        }
        return viewModelProvider.get(cls);
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Superseded by viewModel that takes CreationExtras")
    @Composable
    public static final /* synthetic */ <VM extends ViewModel> VM viewModel(ViewModelStoreOwner viewModelStoreOwner, String str, ViewModelProvider.Factory factory, Composer composer, int i11, int i12) {
        composer.startReplaceableGroup(-384969861);
        if ((i12 & 1) == 0 || (viewModelStoreOwner = LocalViewModelStoreOwner.INSTANCE.getCurrent(composer, 6)) != null) {
            ViewModelStoreOwner viewModelStoreOwner2 = viewModelStoreOwner;
            String str2 = (i12 & 2) != 0 ? null : str;
            ViewModelProvider.Factory factory2 = (i12 & 4) != 0 ? null : factory;
            Intrinsics.reifiedOperationMarker(4, "VM");
            VM viewModel = viewModel(ViewModel.class, viewModelStoreOwner2, str2, factory2, (CreationExtras) null, composer, ((i11 << 3) & 896) | 4168, 16);
            composer.endReplaceableGroup();
            return viewModel;
        }
        throw new IllegalStateException("No ViewModelStoreOwner was provided via LocalViewModelStoreOwner".toString());
    }

    @Composable
    public static final /* synthetic */ <VM extends ViewModel> VM viewModel(ViewModelStoreOwner viewModelStoreOwner, String str, ViewModelProvider.Factory factory, CreationExtras creationExtras, Composer composer, int i11, int i12) {
        CreationExtras creationExtras2;
        composer.startReplaceableGroup(1729797275);
        if ((i12 & 1) == 0 || (viewModelStoreOwner = LocalViewModelStoreOwner.INSTANCE.getCurrent(composer, 6)) != null) {
            ViewModelStoreOwner viewModelStoreOwner2 = viewModelStoreOwner;
            String str2 = (i12 & 2) != 0 ? null : str;
            ViewModelProvider.Factory factory2 = (i12 & 4) != 0 ? null : factory;
            if ((i12 & 8) != 0) {
                if (viewModelStoreOwner2 instanceof HasDefaultViewModelProviderFactory) {
                    creationExtras2 = ((HasDefaultViewModelProviderFactory) viewModelStoreOwner2).getDefaultViewModelCreationExtras();
                    Intrinsics.checkNotNullExpressionValue(creationExtras2, "{\n        viewModelStore…ModelCreationExtras\n    }");
                } else {
                    creationExtras2 = CreationExtras.Empty.INSTANCE;
                }
                creationExtras = creationExtras2;
            }
            Intrinsics.reifiedOperationMarker(4, "VM");
            VM viewModel = viewModel(ViewModel.class, viewModelStoreOwner2, str2, factory2, creationExtras, composer, ((i11 << 3) & 896) | 36936, 0);
            composer.endReplaceableGroup();
            return viewModel;
        }
        throw new IllegalStateException("No ViewModelStoreOwner was provided via LocalViewModelStoreOwner".toString());
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Superseded by viewModel that takes CreationExtras")
    @Composable
    public static final /* synthetic */ ViewModel viewModel(Class cls, ViewModelStoreOwner viewModelStoreOwner, String str, ViewModelProvider.Factory factory, Composer composer, int i11, int i12) {
        Intrinsics.checkNotNullParameter(cls, "modelClass");
        composer.startReplaceableGroup(1324836815);
        if ((i12 & 2) == 0 || (viewModelStoreOwner = LocalViewModelStoreOwner.INSTANCE.getCurrent(composer, 6)) != null) {
            ViewModel a11 = a(viewModelStoreOwner, cls, (i12 & 4) != 0 ? null : str, (i12 & 8) != 0 ? null : factory, (CreationExtras) null, 8, (Object) null);
            composer.endReplaceableGroup();
            return a11;
        }
        throw new IllegalStateException("No ViewModelStoreOwner was provided via LocalViewModelStoreOwner".toString());
    }

    @NotNull
    @Composable
    public static final <VM extends ViewModel> VM viewModel(@NotNull Class<VM> cls, @Nullable ViewModelStoreOwner viewModelStoreOwner, @Nullable String str, @Nullable ViewModelProvider.Factory factory, @Nullable CreationExtras creationExtras, @Nullable Composer composer, int i11, int i12) {
        Intrinsics.checkNotNullParameter(cls, "modelClass");
        composer.startReplaceableGroup(-1439476281);
        if ((i12 & 2) == 0 || (viewModelStoreOwner = LocalViewModelStoreOwner.INSTANCE.getCurrent(composer, 6)) != null) {
            if ((i12 & 4) != 0) {
                str = null;
            }
            if ((i12 & 8) != 0) {
                factory = null;
            }
            if ((i12 & 16) != 0) {
                if (viewModelStoreOwner instanceof HasDefaultViewModelProviderFactory) {
                    creationExtras = ((HasDefaultViewModelProviderFactory) viewModelStoreOwner).getDefaultViewModelCreationExtras();
                    Intrinsics.checkNotNullExpressionValue(creationExtras, "{\n        viewModelStore…ModelCreationExtras\n    }");
                } else {
                    creationExtras = CreationExtras.Empty.INSTANCE;
                }
            }
            VM vm2 = get(viewModelStoreOwner, cls, str, factory, creationExtras);
            composer.endReplaceableGroup();
            return vm2;
        }
        throw new IllegalStateException("No ViewModelStoreOwner was provided via LocalViewModelStoreOwner".toString());
    }

    @Composable
    public static final /* synthetic */ <VM extends ViewModel> VM viewModel(ViewModelStoreOwner viewModelStoreOwner, String str, Function1<? super CreationExtras, ? extends VM> function1, Composer composer, int i11, int i12) {
        CreationExtras creationExtras;
        Intrinsics.checkNotNullParameter(function1, "initializer");
        composer.startReplaceableGroup(419377738);
        if ((i12 & 1) == 0 || (viewModelStoreOwner = LocalViewModelStoreOwner.INSTANCE.getCurrent(composer, 6)) != null) {
            ViewModelStoreOwner viewModelStoreOwner2 = viewModelStoreOwner;
            if ((i12 & 2) != 0) {
                str = null;
            }
            String str2 = str;
            Intrinsics.reifiedOperationMarker(4, "VM");
            Class<ViewModel> cls = ViewModel.class;
            InitializerViewModelFactoryBuilder initializerViewModelFactoryBuilder = new InitializerViewModelFactoryBuilder();
            Intrinsics.reifiedOperationMarker(4, "VM");
            initializerViewModelFactoryBuilder.addInitializer(Reflection.getOrCreateKotlinClass(ViewModel.class), function1);
            ViewModelProvider.Factory build = initializerViewModelFactoryBuilder.build();
            if (viewModelStoreOwner2 instanceof HasDefaultViewModelProviderFactory) {
                creationExtras = ((HasDefaultViewModelProviderFactory) viewModelStoreOwner2).getDefaultViewModelCreationExtras();
            } else {
                creationExtras = CreationExtras.Empty.INSTANCE;
            }
            CreationExtras creationExtras2 = creationExtras;
            Intrinsics.checkNotNullExpressionValue(creationExtras2, "if (viewModelStoreOwner …reationExtras.Empty\n    }");
            VM viewModel = viewModel(cls, viewModelStoreOwner2, str2, build, creationExtras2, composer, ((i11 << 3) & 896) | 36936, 0);
            composer.endReplaceableGroup();
            return viewModel;
        }
        throw new IllegalStateException("No ViewModelStoreOwner was provided via LocalViewModelStoreOwner".toString());
    }
}
