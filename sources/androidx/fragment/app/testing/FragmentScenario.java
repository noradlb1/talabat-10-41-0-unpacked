package androidx.fragment.app.testing;

import android.annotation.SuppressLint;
import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.IdRes;
import androidx.annotation.StyleRes;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentFactory;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.fragment.testing.R;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelLazy;
import androidx.lifecycle.ViewModelProvider;
import androidx.test.core.app.ActivityScenario;
import androidx.test.core.app.ApplicationProvider;
import c2.a;
import c2.b;
import c2.c;
import c2.d;
import com.facebook.internal.NativeProtocol;
import java.io.Closeable;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u0015*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0003:\u0004\u0015\u0016\u0017\u0018B#\b\u0002\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\u0002\u0010\tJ\b\u0010\f\u001a\u00020\rH\u0016J\u0014\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010\u000f\u001a\u00020\u0010J\u001a\u0010\u0011\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00028\u00000\u0013J\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00028\u00000\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0019"}, d2 = {"Landroidx/fragment/app/testing/FragmentScenario;", "F", "Landroidx/fragment/app/Fragment;", "Ljava/io/Closeable;", "fragmentClass", "Ljava/lang/Class;", "activityScenario", "Landroidx/test/core/app/ActivityScenario;", "Landroidx/fragment/app/testing/FragmentScenario$EmptyFragmentActivity;", "(Ljava/lang/Class;Landroidx/test/core/app/ActivityScenario;)V", "getFragmentClass$fragment_testing_release", "()Ljava/lang/Class;", "close", "", "moveToState", "newState", "Landroidx/lifecycle/Lifecycle$State;", "onFragment", "action", "Landroidx/fragment/app/testing/FragmentScenario$FragmentAction;", "recreate", "Companion", "EmptyFragmentActivity", "FragmentAction", "FragmentFactoryHolderViewModel", "fragment-testing_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class FragmentScenario<F extends Fragment> implements Closeable {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @NotNull
    private static final String FRAGMENT_TAG = "FragmentScenario_Fragment_Tag";
    /* access modifiers changed from: private */
    @NotNull
    public final ActivityScenario<EmptyFragmentActivity> activityScenario;
    @NotNull
    private final Class<F> fragmentClass;

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u0000 \u00072\u00020\u0001:\u0001\u0007B\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0015¨\u0006\b"}, d2 = {"Landroidx/fragment/app/testing/FragmentScenario$EmptyFragmentActivity;", "Landroidx/fragment/app/FragmentActivity;", "()V", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "Companion", "fragment-testing_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class EmptyFragmentActivity extends FragmentActivity {
        @NotNull
        public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
        @NotNull
        public static final String THEME_EXTRAS_BUNDLE_KEY = "androidx.fragment.app.testing.FragmentScenario.EmptyFragmentActivity.THEME_EXTRAS_BUNDLE_KEY";

        @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Landroidx/fragment/app/testing/FragmentScenario$EmptyFragmentActivity$Companion;", "", "()V", "THEME_EXTRAS_BUNDLE_KEY", "", "fragment-testing_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        @SuppressLint({"RestrictedApi"})
        public void onCreate(@Nullable Bundle bundle) {
            setTheme(getIntent().getIntExtra(THEME_EXTRAS_BUNDLE_KEY, R.style.FragmentScenarioEmptyFragmentActivityTheme));
            FragmentFactory fragmentFactory = FragmentFactoryHolderViewModel.Companion.getInstance(this).getFragmentFactory();
            if (fragmentFactory != null) {
                getSupportFragmentManager().setFragmentFactory(fragmentFactory);
            }
            super.onCreate(bundle);
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bæ\u0001\u0018\u0000*\b\b\u0001\u0010\u0001*\u00020\u00022\u00020\u0003J\u0015\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00028\u0001H&¢\u0006\u0002\u0010\u0007¨\u0006\b"}, d2 = {"Landroidx/fragment/app/testing/FragmentScenario$FragmentAction;", "F", "Landroidx/fragment/app/Fragment;", "", "perform", "", "fragment", "(Landroidx/fragment/app/Fragment;)V", "fragment-testing_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public interface FragmentAction<F extends Fragment> {
        void perform(@NotNull F f11);
    }

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0000\u0018\u0000 \u000b2\u00020\u0001:\u0001\u000bB\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\t\u001a\u00020\nH\u0014R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\f"}, d2 = {"Landroidx/fragment/app/testing/FragmentScenario$FragmentFactoryHolderViewModel;", "Landroidx/lifecycle/ViewModel;", "()V", "fragmentFactory", "Landroidx/fragment/app/FragmentFactory;", "getFragmentFactory", "()Landroidx/fragment/app/FragmentFactory;", "setFragmentFactory", "(Landroidx/fragment/app/FragmentFactory;)V", "onCleared", "", "Companion", "fragment-testing_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class FragmentFactoryHolderViewModel extends ViewModel {
        @NotNull
        public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
        /* access modifiers changed from: private */
        @NotNull
        public static final ViewModelProvider.Factory FACTORY = new FragmentScenario$FragmentFactoryHolderViewModel$Companion$FACTORY$1();
        @Nullable
        private FragmentFactory fragmentFactory;

        @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bR\u001a\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0005\u0010\u0002\u001a\u0004\b\u0006\u0010\u0007¨\u0006\f²\u0006\u0014\u0010\r\u001a\u00020\t\"\b\b\u0000\u0010\u000e*\u00020\u000fX\u0002"}, d2 = {"Landroidx/fragment/app/testing/FragmentScenario$FragmentFactoryHolderViewModel$Companion;", "", "()V", "FACTORY", "Landroidx/lifecycle/ViewModelProvider$Factory;", "getFACTORY$fragment_testing_release$annotations", "getFACTORY$fragment_testing_release", "()Landroidx/lifecycle/ViewModelProvider$Factory;", "getInstance", "Landroidx/fragment/app/testing/FragmentScenario$FragmentFactoryHolderViewModel;", "activity", "Landroidx/fragment/app/FragmentActivity;", "fragment-testing_release", "viewModel", "F", "Landroidx/fragment/app/Fragment;"}, k = 1, mv = {1, 6, 0}, xi = 48)
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            public static /* synthetic */ void getFACTORY$fragment_testing_release$annotations() {
            }

            /* renamed from: getInstance$lambda-0  reason: not valid java name */
            private static final FragmentFactoryHolderViewModel m9088getInstance$lambda0(Lazy<FragmentFactoryHolderViewModel> lazy) {
                return lazy.getValue();
            }

            @NotNull
            public final ViewModelProvider.Factory getFACTORY$fragment_testing_release() {
                return FragmentFactoryHolderViewModel.FACTORY;
            }

            @NotNull
            public final FragmentFactoryHolderViewModel getInstance(@NotNull FragmentActivity fragmentActivity) {
                Intrinsics.checkNotNullParameter(fragmentActivity, "activity");
                Function0 function0 = FragmentScenario$FragmentFactoryHolderViewModel$Companion$getInstance$viewModel$2.INSTANCE;
                if (function0 == null) {
                    function0 = new FragmentScenario$FragmentFactoryHolderViewModel$Companion$getInstance$$inlined$viewModels$default$1(fragmentActivity);
                }
                return m9088getInstance$lambda0(new ViewModelLazy(Reflection.getOrCreateKotlinClass(FragmentFactoryHolderViewModel.class), new FragmentScenario$FragmentFactoryHolderViewModel$Companion$getInstance$$inlined$viewModels$default$2(fragmentActivity), function0, new FragmentScenario$FragmentFactoryHolderViewModel$Companion$getInstance$$inlined$viewModels$default$3((Function0) null, fragmentActivity)));
            }
        }

        @Nullable
        public final FragmentFactory getFragmentFactory() {
            return this.fragmentFactory;
        }

        public void onCleared() {
            super.onCleared();
            this.fragmentFactory = null;
        }

        public final void setFragmentFactory(@Nullable FragmentFactory fragmentFactory2) {
            this.fragmentFactory = fragmentFactory2;
        }
    }

    private FragmentScenario(Class<F> cls, ActivityScenario<EmptyFragmentActivity> activityScenario2) {
        this.fragmentClass = cls;
        this.activityScenario = activityScenario2;
    }

    public /* synthetic */ FragmentScenario(Class cls, ActivityScenario activityScenario2, DefaultConstructorMarker defaultConstructorMarker) {
        this(cls, activityScenario2);
    }

    @JvmStatic
    @NotNull
    @JvmOverloads
    public static final <F extends Fragment> FragmentScenario<F> launch(@NotNull Class<F> cls) {
        return Companion.launch(cls);
    }

    @JvmStatic
    @NotNull
    @JvmOverloads
    public static final <F extends Fragment> FragmentScenario<F> launch(@NotNull Class<F> cls, @Nullable Bundle bundle) {
        return Companion.launch(cls, bundle);
    }

    @JvmStatic
    @NotNull
    @JvmOverloads
    public static final <F extends Fragment> FragmentScenario<F> launch(@NotNull Class<F> cls, @Nullable Bundle bundle, @StyleRes int i11) {
        return Companion.launch(cls, bundle, i11);
    }

    @JvmStatic
    @NotNull
    public static final <F extends Fragment> FragmentScenario<F> launch(@NotNull Class<F> cls, @Nullable Bundle bundle, @StyleRes int i11, @Nullable FragmentFactory fragmentFactory) {
        return Companion.launch(cls, bundle, i11, fragmentFactory);
    }

    @JvmStatic
    @NotNull
    @JvmOverloads
    public static final <F extends Fragment> FragmentScenario<F> launch(@NotNull Class<F> cls, @Nullable Bundle bundle, @StyleRes int i11, @NotNull Lifecycle.State state) {
        return Companion.launch(cls, bundle, i11, state);
    }

    @JvmStatic
    @NotNull
    @JvmOverloads
    public static final <F extends Fragment> FragmentScenario<F> launch(@NotNull Class<F> cls, @Nullable Bundle bundle, @StyleRes int i11, @NotNull Lifecycle.State state, @Nullable FragmentFactory fragmentFactory) {
        return Companion.launch(cls, bundle, i11, state, fragmentFactory);
    }

    @JvmStatic
    @NotNull
    public static final <F extends Fragment> FragmentScenario<F> launch(@NotNull Class<F> cls, @Nullable Bundle bundle, @Nullable FragmentFactory fragmentFactory) {
        return Companion.launch(cls, bundle, fragmentFactory);
    }

    @JvmStatic
    @NotNull
    @JvmOverloads
    public static final <F extends Fragment> FragmentScenario<F> launchInContainer(@NotNull Class<F> cls) {
        return Companion.launchInContainer(cls);
    }

    @JvmStatic
    @NotNull
    @JvmOverloads
    public static final <F extends Fragment> FragmentScenario<F> launchInContainer(@NotNull Class<F> cls, @Nullable Bundle bundle) {
        return Companion.launchInContainer(cls, bundle);
    }

    @JvmStatic
    @NotNull
    @JvmOverloads
    public static final <F extends Fragment> FragmentScenario<F> launchInContainer(@NotNull Class<F> cls, @Nullable Bundle bundle, @StyleRes int i11) {
        return Companion.launchInContainer(cls, bundle, i11);
    }

    @JvmStatic
    @NotNull
    public static final <F extends Fragment> FragmentScenario<F> launchInContainer(@NotNull Class<F> cls, @Nullable Bundle bundle, @StyleRes int i11, @Nullable FragmentFactory fragmentFactory) {
        return Companion.launchInContainer(cls, bundle, i11, fragmentFactory);
    }

    @JvmStatic
    @NotNull
    @JvmOverloads
    public static final <F extends Fragment> FragmentScenario<F> launchInContainer(@NotNull Class<F> cls, @Nullable Bundle bundle, @StyleRes int i11, @NotNull Lifecycle.State state) {
        return Companion.launchInContainer(cls, bundle, i11, state);
    }

    @JvmStatic
    @NotNull
    @JvmOverloads
    public static final <F extends Fragment> FragmentScenario<F> launchInContainer(@NotNull Class<F> cls, @Nullable Bundle bundle, @StyleRes int i11, @NotNull Lifecycle.State state, @Nullable FragmentFactory fragmentFactory) {
        return Companion.launchInContainer(cls, bundle, i11, state, fragmentFactory);
    }

    @JvmStatic
    @NotNull
    public static final <F extends Fragment> FragmentScenario<F> launchInContainer(@NotNull Class<F> cls, @Nullable Bundle bundle, @Nullable FragmentFactory fragmentFactory) {
        return Companion.launchInContainer(cls, bundle, fragmentFactory);
    }

    /* access modifiers changed from: private */
    /* renamed from: moveToState$lambda-1  reason: not valid java name */
    public static final void m9084moveToState$lambda1(EmptyFragmentActivity emptyFragmentActivity) {
        Fragment findFragmentByTag = emptyFragmentActivity.getSupportFragmentManager().findFragmentByTag(FRAGMENT_TAG);
        if (findFragmentByTag != null) {
            FragmentManager supportFragmentManager = emptyFragmentActivity.getSupportFragmentManager();
            Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "activity.supportFragmentManager");
            FragmentTransaction beginTransaction = supportFragmentManager.beginTransaction();
            Intrinsics.checkNotNullExpressionValue(beginTransaction, "beginTransaction()");
            beginTransaction.remove(findFragmentByTag);
            beginTransaction.commitNow();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: moveToState$lambda-4  reason: not valid java name */
    public static final void m9085moveToState$lambda4(Lifecycle.State state, EmptyFragmentActivity emptyFragmentActivity) {
        Intrinsics.checkNotNullParameter(state, "$newState");
        Fragment findFragmentByTag = emptyFragmentActivity.getSupportFragmentManager().findFragmentByTag(FRAGMENT_TAG);
        if (findFragmentByTag != null) {
            Intrinsics.checkNotNullExpressionValue(findFragmentByTag, "requireNotNull(\n        …ready.\"\n                }");
            FragmentManager supportFragmentManager = emptyFragmentActivity.getSupportFragmentManager();
            Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "activity.supportFragmentManager");
            FragmentTransaction beginTransaction = supportFragmentManager.beginTransaction();
            Intrinsics.checkNotNullExpressionValue(beginTransaction, "beginTransaction()");
            beginTransaction.setMaxLifecycle(findFragmentByTag, state);
            beginTransaction.commitNow();
            return;
        }
        throw new IllegalArgumentException("The fragment has been removed from the FragmentManager already.".toString());
    }

    /* access modifiers changed from: private */
    /* renamed from: onFragment$lambda-6  reason: not valid java name */
    public static final void m9086onFragment$lambda6(FragmentScenario fragmentScenario, FragmentAction fragmentAction, EmptyFragmentActivity emptyFragmentActivity) {
        Intrinsics.checkNotNullParameter(fragmentScenario, "this$0");
        Intrinsics.checkNotNullParameter(fragmentAction, "$action");
        Fragment findFragmentByTag = emptyFragmentActivity.getSupportFragmentManager().findFragmentByTag(FRAGMENT_TAG);
        if (findFragmentByTag != null) {
            Intrinsics.checkNotNullExpressionValue(findFragmentByTag, "requireNotNull(\n        …r already.\"\n            }");
            if (fragmentScenario.fragmentClass.isInstance(findFragmentByTag)) {
                F cast = fragmentScenario.fragmentClass.cast(findFragmentByTag);
                if (cast != null) {
                    fragmentAction.perform((Fragment) cast);
                    return;
                }
                throw new IllegalArgumentException("Required value was null.".toString());
            }
            throw new IllegalStateException("Check failed.".toString());
        }
        throw new IllegalArgumentException("The fragment has been removed from the FragmentManager already.".toString());
    }

    public void close() {
        this.activityScenario.close();
    }

    @NotNull
    public final Class<F> getFragmentClass$fragment_testing_release() {
        return this.fragmentClass;
    }

    @NotNull
    public final FragmentScenario<F> moveToState(@NotNull Lifecycle.State state) {
        Intrinsics.checkNotNullParameter(state, "newState");
        if (state == Lifecycle.State.DESTROYED) {
            this.activityScenario.onActivity(new a());
        } else {
            this.activityScenario.onActivity(new b(state));
        }
        return this;
    }

    @NotNull
    public final FragmentScenario<F> onFragment(@NotNull FragmentAction<F> fragmentAction) {
        Intrinsics.checkNotNullParameter(fragmentAction, NativeProtocol.WEB_DIALOG_ACTION);
        this.activityScenario.onActivity(new c(this, fragmentAction));
        return this;
    }

    @NotNull
    public final FragmentScenario<F> recreate() {
        this.activityScenario.recreate();
        return this;
    }

    @Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J[\u0010\u0005\u001a\b\u0012\u0004\u0012\u0002H\u00070\u0006\"\b\b\u0001\u0010\u0007*\u00020\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u0002H\u00070\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\b\u0001\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u00122\b\b\u0001\u0010\u0013\u001a\u00020\u000eH\u0001¢\u0006\u0002\b\u0014J:\u0010\u0015\u001a\b\u0012\u0004\u0012\u0002H\u00070\u0006\"\b\b\u0001\u0010\u0007*\u00020\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u0002H\u00070\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0007JD\u0010\u0015\u001a\b\u0012\u0004\u0012\u0002H\u00070\u0006\"\b\b\u0001\u0010\u0007*\u00020\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u0002H\u00070\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\b\u0001\u0010\r\u001a\u00020\u000e2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0007JR\u0010\u0015\u001a\b\u0012\u0004\u0012\u0002H\u00070\u0006\"\b\b\u0001\u0010\u0007*\u00020\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u0002H\u00070\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\b\u0003\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0007J:\u0010\u0016\u001a\b\u0012\u0004\u0012\u0002H\u00070\u0006\"\b\b\u0001\u0010\u0007*\u00020\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u0002H\u00070\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0007JD\u0010\u0016\u001a\b\u0012\u0004\u0012\u0002H\u00070\u0006\"\b\b\u0001\u0010\u0007*\u00020\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u0002H\u00070\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\b\u0001\u0010\r\u001a\u00020\u000e2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0007JR\u0010\u0016\u001a\b\u0012\u0004\u0012\u0002H\u00070\u0006\"\b\b\u0001\u0010\u0007*\u00020\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u0002H\u00070\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\b\u0003\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Landroidx/fragment/app/testing/FragmentScenario$Companion;", "", "()V", "FRAGMENT_TAG", "", "internalLaunch", "Landroidx/fragment/app/testing/FragmentScenario;", "F", "Landroidx/fragment/app/Fragment;", "fragmentClass", "Ljava/lang/Class;", "fragmentArgs", "Landroid/os/Bundle;", "themeResId", "", "initialState", "Landroidx/lifecycle/Lifecycle$State;", "factory", "Landroidx/fragment/app/FragmentFactory;", "containerViewId", "internalLaunch$fragment_testing_release", "launch", "launchInContainer", "fragment-testing_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* access modifiers changed from: private */
        /* renamed from: internalLaunch$lambda-2  reason: not valid java name */
        public static final void m9087internalLaunch$lambda2(FragmentFactory fragmentFactory, Class cls, Bundle bundle, int i11, Lifecycle.State state, EmptyFragmentActivity emptyFragmentActivity) {
            Intrinsics.checkNotNullParameter(cls, "$fragmentClass");
            Intrinsics.checkNotNullParameter(state, "$initialState");
            if (fragmentFactory != null) {
                FragmentFactoryHolderViewModel.Companion companion = FragmentFactoryHolderViewModel.Companion;
                Intrinsics.checkNotNullExpressionValue(emptyFragmentActivity, "activity");
                companion.getInstance(emptyFragmentActivity).setFragmentFactory(fragmentFactory);
                emptyFragmentActivity.getSupportFragmentManager().setFragmentFactory(fragmentFactory);
            }
            FragmentFactory fragmentFactory2 = emptyFragmentActivity.getSupportFragmentManager().getFragmentFactory();
            ClassLoader classLoader = cls.getClassLoader();
            if (classLoader != null) {
                Fragment instantiate = fragmentFactory2.instantiate(classLoader, cls.getName());
                Intrinsics.checkNotNullExpressionValue(instantiate, "activity.supportFragment…der), fragmentClass.name)");
                instantiate.setArguments(bundle);
                FragmentManager supportFragmentManager = emptyFragmentActivity.getSupportFragmentManager();
                Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "activity.supportFragmentManager");
                FragmentTransaction beginTransaction = supportFragmentManager.beginTransaction();
                Intrinsics.checkNotNullExpressionValue(beginTransaction, "beginTransaction()");
                beginTransaction.add(i11, instantiate, FragmentScenario.FRAGMENT_TAG);
                beginTransaction.setMaxLifecycle(instantiate, state);
                beginTransaction.commitNow();
                return;
            }
            throw new IllegalArgumentException("Required value was null.".toString());
        }

        public static /* synthetic */ FragmentScenario launch$default(Companion companion, Class cls, Bundle bundle, int i11, Lifecycle.State state, FragmentFactory fragmentFactory, int i12, Object obj) {
            Bundle bundle2;
            FragmentFactory fragmentFactory2;
            if ((i12 & 2) != 0) {
                bundle2 = null;
            } else {
                bundle2 = bundle;
            }
            if ((i12 & 4) != 0) {
                i11 = R.style.FragmentScenarioEmptyFragmentActivityTheme;
            }
            int i13 = i11;
            if ((i12 & 8) != 0) {
                state = Lifecycle.State.RESUMED;
            }
            Lifecycle.State state2 = state;
            if ((i12 & 16) != 0) {
                fragmentFactory2 = null;
            } else {
                fragmentFactory2 = fragmentFactory;
            }
            return companion.launch(cls, bundle2, i13, state2, fragmentFactory2);
        }

        public static /* synthetic */ FragmentScenario launchInContainer$default(Companion companion, Class cls, Bundle bundle, int i11, Lifecycle.State state, FragmentFactory fragmentFactory, int i12, Object obj) {
            Bundle bundle2;
            FragmentFactory fragmentFactory2;
            if ((i12 & 2) != 0) {
                bundle2 = null;
            } else {
                bundle2 = bundle;
            }
            if ((i12 & 4) != 0) {
                i11 = R.style.FragmentScenarioEmptyFragmentActivityTheme;
            }
            int i13 = i11;
            if ((i12 & 8) != 0) {
                state = Lifecycle.State.RESUMED;
            }
            Lifecycle.State state2 = state;
            if ((i12 & 16) != 0) {
                fragmentFactory2 = null;
            } else {
                fragmentFactory2 = fragmentFactory;
            }
            return companion.launchInContainer(cls, bundle2, i13, state2, fragmentFactory2);
        }

        @NotNull
        @SuppressLint({"RestrictedApi"})
        public final <F extends Fragment> FragmentScenario<F> internalLaunch$fragment_testing_release(@NotNull Class<F> cls, @Nullable Bundle bundle, @StyleRes int i11, @NotNull Lifecycle.State state, @Nullable FragmentFactory fragmentFactory, @IdRes int i12) {
            boolean z11;
            Intrinsics.checkNotNullParameter(cls, "fragmentClass");
            Intrinsics.checkNotNullParameter(state, "initialState");
            if (state != Lifecycle.State.DESTROYED) {
                z11 = true;
            } else {
                z11 = false;
            }
            if (z11) {
                Intent putExtra = Intent.makeMainActivity(new ComponentName(ApplicationProvider.getApplicationContext(), EmptyFragmentActivity.class)).putExtra(EmptyFragmentActivity.THEME_EXTRAS_BUNDLE_KEY, i11);
                Intrinsics.checkNotNullExpressionValue(putExtra, "makeMainActivity(compone…S_BUNDLE_KEY, themeResId)");
                ActivityScenario launch = ActivityScenario.launch(putExtra);
                Intrinsics.checkNotNullExpressionValue(launch, "launch(\n                …yIntent\n                )");
                FragmentScenario<F> fragmentScenario = new FragmentScenario<>(cls, launch, (DefaultConstructorMarker) null);
                fragmentScenario.activityScenario.onActivity(new d(fragmentFactory, cls, bundle, i12, state));
                return fragmentScenario;
            }
            throw new IllegalArgumentException(("Cannot set initial Lifecycle state to " + state + " for FragmentScenario").toString());
        }

        @JvmStatic
        @NotNull
        @JvmOverloads
        public final <F extends Fragment> FragmentScenario<F> launch(@NotNull Class<F> cls) {
            Intrinsics.checkNotNullParameter(cls, "fragmentClass");
            return launch$default(this, cls, (Bundle) null, 0, (Lifecycle.State) null, (FragmentFactory) null, 30, (Object) null);
        }

        @JvmStatic
        @NotNull
        @JvmOverloads
        public final <F extends Fragment> FragmentScenario<F> launch(@NotNull Class<F> cls, @Nullable Bundle bundle) {
            Intrinsics.checkNotNullParameter(cls, "fragmentClass");
            return launch$default(this, cls, bundle, 0, (Lifecycle.State) null, (FragmentFactory) null, 28, (Object) null);
        }

        @JvmStatic
        @NotNull
        @JvmOverloads
        public final <F extends Fragment> FragmentScenario<F> launch(@NotNull Class<F> cls, @Nullable Bundle bundle, @StyleRes int i11) {
            Intrinsics.checkNotNullParameter(cls, "fragmentClass");
            return launch$default(this, cls, bundle, i11, (Lifecycle.State) null, (FragmentFactory) null, 24, (Object) null);
        }

        @JvmStatic
        @NotNull
        @JvmOverloads
        public final <F extends Fragment> FragmentScenario<F> launch(@NotNull Class<F> cls, @Nullable Bundle bundle, @StyleRes int i11, @NotNull Lifecycle.State state) {
            Intrinsics.checkNotNullParameter(cls, "fragmentClass");
            Intrinsics.checkNotNullParameter(state, "initialState");
            return launch$default(this, cls, bundle, i11, state, (FragmentFactory) null, 16, (Object) null);
        }

        @JvmStatic
        @NotNull
        public final <F extends Fragment> FragmentScenario<F> launch(@NotNull Class<F> cls, @Nullable Bundle bundle, @Nullable FragmentFactory fragmentFactory) {
            Intrinsics.checkNotNullParameter(cls, "fragmentClass");
            return launch(cls, bundle, R.style.FragmentScenarioEmptyFragmentActivityTheme, Lifecycle.State.RESUMED, fragmentFactory);
        }

        @JvmStatic
        @NotNull
        @JvmOverloads
        public final <F extends Fragment> FragmentScenario<F> launchInContainer(@NotNull Class<F> cls) {
            Intrinsics.checkNotNullParameter(cls, "fragmentClass");
            return launchInContainer$default(this, cls, (Bundle) null, 0, (Lifecycle.State) null, (FragmentFactory) null, 30, (Object) null);
        }

        @JvmStatic
        @NotNull
        @JvmOverloads
        public final <F extends Fragment> FragmentScenario<F> launchInContainer(@NotNull Class<F> cls, @Nullable Bundle bundle) {
            Intrinsics.checkNotNullParameter(cls, "fragmentClass");
            return launchInContainer$default(this, cls, bundle, 0, (Lifecycle.State) null, (FragmentFactory) null, 28, (Object) null);
        }

        @JvmStatic
        @NotNull
        @JvmOverloads
        public final <F extends Fragment> FragmentScenario<F> launchInContainer(@NotNull Class<F> cls, @Nullable Bundle bundle, @StyleRes int i11) {
            Intrinsics.checkNotNullParameter(cls, "fragmentClass");
            return launchInContainer$default(this, cls, bundle, i11, (Lifecycle.State) null, (FragmentFactory) null, 24, (Object) null);
        }

        @JvmStatic
        @NotNull
        @JvmOverloads
        public final <F extends Fragment> FragmentScenario<F> launchInContainer(@NotNull Class<F> cls, @Nullable Bundle bundle, @StyleRes int i11, @NotNull Lifecycle.State state) {
            Intrinsics.checkNotNullParameter(cls, "fragmentClass");
            Intrinsics.checkNotNullParameter(state, "initialState");
            return launchInContainer$default(this, cls, bundle, i11, state, (FragmentFactory) null, 16, (Object) null);
        }

        @JvmStatic
        @NotNull
        public final <F extends Fragment> FragmentScenario<F> launchInContainer(@NotNull Class<F> cls, @Nullable Bundle bundle, @Nullable FragmentFactory fragmentFactory) {
            Intrinsics.checkNotNullParameter(cls, "fragmentClass");
            return launchInContainer(cls, bundle, R.style.FragmentScenarioEmptyFragmentActivityTheme, Lifecycle.State.RESUMED, fragmentFactory);
        }

        @JvmStatic
        @NotNull
        public final <F extends Fragment> FragmentScenario<F> launch(@NotNull Class<F> cls, @Nullable Bundle bundle, @StyleRes int i11, @Nullable FragmentFactory fragmentFactory) {
            Intrinsics.checkNotNullParameter(cls, "fragmentClass");
            return launch(cls, bundle, i11, Lifecycle.State.RESUMED, fragmentFactory);
        }

        @JvmStatic
        @NotNull
        public final <F extends Fragment> FragmentScenario<F> launchInContainer(@NotNull Class<F> cls, @Nullable Bundle bundle, @StyleRes int i11, @Nullable FragmentFactory fragmentFactory) {
            Intrinsics.checkNotNullParameter(cls, "fragmentClass");
            return launchInContainer(cls, bundle, i11, Lifecycle.State.RESUMED, fragmentFactory);
        }

        @JvmStatic
        @NotNull
        @JvmOverloads
        public final <F extends Fragment> FragmentScenario<F> launch(@NotNull Class<F> cls, @Nullable Bundle bundle, @StyleRes int i11, @NotNull Lifecycle.State state, @Nullable FragmentFactory fragmentFactory) {
            Intrinsics.checkNotNullParameter(cls, "fragmentClass");
            Intrinsics.checkNotNullParameter(state, "initialState");
            return internalLaunch$fragment_testing_release(cls, bundle, i11, state, fragmentFactory, 0);
        }

        @JvmStatic
        @NotNull
        @JvmOverloads
        public final <F extends Fragment> FragmentScenario<F> launchInContainer(@NotNull Class<F> cls, @Nullable Bundle bundle, @StyleRes int i11, @NotNull Lifecycle.State state, @Nullable FragmentFactory fragmentFactory) {
            Intrinsics.checkNotNullParameter(cls, "fragmentClass");
            Intrinsics.checkNotNullParameter(state, "initialState");
            return internalLaunch$fragment_testing_release(cls, bundle, i11, state, fragmentFactory, 16908290);
        }
    }
}
