package com.instabug.apm.fragment;

import androidx.fragment.app.Fragment;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.instabug.apm.model.e;
import com.instabug.library.transform.TransformationClass;
import com.instabug.library.transform.TransformationMethod;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.Executor;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@TransformationClass
public final class FragmentEventDispatcher {
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    public static final a f45306a = new a((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public static final Set f45307b = Collections.synchronizedSet(new HashSet());

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final Set a() {
            return FragmentEventDispatcher.f45307b;
        }

        @JvmStatic
        public final void a(@NotNull s sVar) {
            Intrinsics.checkNotNullParameter(sVar, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
            a().add(sVar);
        }

        @JvmStatic
        public final void b(@NotNull s sVar) {
            Intrinsics.checkNotNullParameter(sVar, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
            a().remove(sVar);
        }

        @JvmStatic
        @TransformationMethod
        public final void onFragmentPostActivityCreated(@NotNull Fragment fragment) {
            Intrinsics.checkNotNullParameter(fragment, "fragment");
            e eVar = new e();
            Executor a11 = com.instabug.apm.di.a.a("FragmentEventDispatcher");
            Intrinsics.checkNotNullExpressionValue(a11, "getSingleThreadExecutor(executorId)");
            a11.execute(new a(fragment, eVar));
        }

        @JvmStatic
        @TransformationMethod
        public final void onFragmentPostAttach(@NotNull Fragment fragment) {
            Intrinsics.checkNotNullParameter(fragment, "fragment");
            e eVar = new e();
            Executor a11 = com.instabug.apm.di.a.a("FragmentEventDispatcher");
            Intrinsics.checkNotNullExpressionValue(a11, "getSingleThreadExecutor(executorId)");
            a11.execute(new b(fragment, eVar));
        }

        @JvmStatic
        @TransformationMethod
        public final void onFragmentPostCreate(@NotNull Fragment fragment) {
            Intrinsics.checkNotNullParameter(fragment, "fragment");
            e eVar = new e();
            Executor a11 = com.instabug.apm.di.a.a("FragmentEventDispatcher");
            Intrinsics.checkNotNullExpressionValue(a11, "getSingleThreadExecutor(executorId)");
            a11.execute(new c(fragment, eVar));
        }

        @JvmStatic
        @TransformationMethod
        public final void onFragmentPostCreateView(@NotNull Fragment fragment) {
            Intrinsics.checkNotNullParameter(fragment, "fragment");
            e eVar = new e();
            Executor a11 = com.instabug.apm.di.a.a("FragmentEventDispatcher");
            Intrinsics.checkNotNullExpressionValue(a11, "getSingleThreadExecutor(executorId)");
            a11.execute(new d(fragment, eVar));
        }

        @JvmStatic
        @TransformationMethod
        public final void onFragmentPostDeAttach(@NotNull Fragment fragment) {
            Intrinsics.checkNotNullParameter(fragment, "fragment");
            e eVar = new e();
            Executor a11 = com.instabug.apm.di.a.a("FragmentEventDispatcher");
            Intrinsics.checkNotNullExpressionValue(a11, "getSingleThreadExecutor(executorId)");
            a11.execute(new e(fragment, eVar));
        }

        @JvmStatic
        @TransformationMethod
        public final void onFragmentPostResume(@NotNull Fragment fragment) {
            Intrinsics.checkNotNullParameter(fragment, "fragment");
            e eVar = new e();
            Executor a11 = com.instabug.apm.di.a.a("FragmentEventDispatcher");
            Intrinsics.checkNotNullExpressionValue(a11, "getSingleThreadExecutor(executorId)");
            a11.execute(new f(fragment, eVar));
        }

        @JvmStatic
        @TransformationMethod
        public final void onFragmentPostStart(@NotNull Fragment fragment) {
            Intrinsics.checkNotNullParameter(fragment, "fragment");
            e eVar = new e();
            Executor a11 = com.instabug.apm.di.a.a("FragmentEventDispatcher");
            Intrinsics.checkNotNullExpressionValue(a11, "getSingleThreadExecutor(executorId)");
            a11.execute(new g(fragment, eVar));
        }

        @JvmStatic
        @TransformationMethod
        public final void onFragmentPostViewCreated(@NotNull Fragment fragment) {
            Intrinsics.checkNotNullParameter(fragment, "fragment");
            e eVar = new e();
            Executor a11 = com.instabug.apm.di.a.a("FragmentEventDispatcher");
            Intrinsics.checkNotNullExpressionValue(a11, "getSingleThreadExecutor(executorId)");
            a11.execute(new h(fragment, eVar));
        }

        @JvmStatic
        @TransformationMethod
        public final void onFragmentPostViewStateRestore(@NotNull Fragment fragment) {
            Intrinsics.checkNotNullParameter(fragment, "fragment");
            e eVar = new e();
            Executor a11 = com.instabug.apm.di.a.a("FragmentEventDispatcher");
            Intrinsics.checkNotNullExpressionValue(a11, "getSingleThreadExecutor(executorId)");
            a11.execute(new i(fragment, eVar));
        }

        @JvmStatic
        @TransformationMethod
        public final void onFragmentPreActivityCreated(@NotNull Fragment fragment) {
            Intrinsics.checkNotNullParameter(fragment, "fragment");
            e eVar = new e();
            Executor a11 = com.instabug.apm.di.a.a("FragmentEventDispatcher");
            Intrinsics.checkNotNullExpressionValue(a11, "getSingleThreadExecutor(executorId)");
            a11.execute(new j(fragment, eVar));
        }

        @JvmStatic
        @TransformationMethod
        public final void onFragmentPreAttach(@NotNull Fragment fragment) {
            Intrinsics.checkNotNullParameter(fragment, "fragment");
            e eVar = new e();
            Executor a11 = com.instabug.apm.di.a.a("FragmentEventDispatcher");
            Intrinsics.checkNotNullExpressionValue(a11, "getSingleThreadExecutor(executorId)");
            a11.execute(new k(fragment, eVar));
        }

        @JvmStatic
        @TransformationMethod
        public final void onFragmentPreCreate(@NotNull Fragment fragment) {
            Intrinsics.checkNotNullParameter(fragment, "fragment");
            e eVar = new e();
            Executor a11 = com.instabug.apm.di.a.a("FragmentEventDispatcher");
            Intrinsics.checkNotNullExpressionValue(a11, "getSingleThreadExecutor(executorId)");
            a11.execute(new l(fragment, eVar));
        }

        @JvmStatic
        @TransformationMethod
        public final void onFragmentPreCreateView(@NotNull Fragment fragment) {
            Intrinsics.checkNotNullParameter(fragment, "fragment");
            e eVar = new e();
            Executor a11 = com.instabug.apm.di.a.a("FragmentEventDispatcher");
            Intrinsics.checkNotNullExpressionValue(a11, "getSingleThreadExecutor(executorId)");
            a11.execute(new m(fragment, eVar));
        }

        @JvmStatic
        @TransformationMethod
        public final void onFragmentPreDeAttach(@NotNull Fragment fragment) {
            Intrinsics.checkNotNullParameter(fragment, "fragment");
            e eVar = new e();
            Executor a11 = com.instabug.apm.di.a.a("FragmentEventDispatcher");
            Intrinsics.checkNotNullExpressionValue(a11, "getSingleThreadExecutor(executorId)");
            a11.execute(new n(fragment, eVar));
        }

        @JvmStatic
        @TransformationMethod
        public final void onFragmentPreResume(@NotNull Fragment fragment) {
            Intrinsics.checkNotNullParameter(fragment, "fragment");
            e eVar = new e();
            Executor a11 = com.instabug.apm.di.a.a("FragmentEventDispatcher");
            Intrinsics.checkNotNullExpressionValue(a11, "getSingleThreadExecutor(executorId)");
            a11.execute(new o(fragment, eVar));
        }

        @JvmStatic
        @TransformationMethod
        public final void onFragmentPreStart(@NotNull Fragment fragment) {
            Intrinsics.checkNotNullParameter(fragment, "fragment");
            e eVar = new e();
            Executor a11 = com.instabug.apm.di.a.a("FragmentEventDispatcher");
            Intrinsics.checkNotNullExpressionValue(a11, "getSingleThreadExecutor(executorId)");
            a11.execute(new p(fragment, eVar));
        }

        @JvmStatic
        @TransformationMethod
        public final void onFragmentPreViewCreated(@NotNull Fragment fragment) {
            Intrinsics.checkNotNullParameter(fragment, "fragment");
            e eVar = new e();
            Executor a11 = com.instabug.apm.di.a.a("FragmentEventDispatcher");
            Intrinsics.checkNotNullExpressionValue(a11, "getSingleThreadExecutor(executorId)");
            a11.execute(new q(fragment, eVar));
        }

        @JvmStatic
        @TransformationMethod
        public final void onFragmentPreViewStateRestore(@NotNull Fragment fragment) {
            Intrinsics.checkNotNullParameter(fragment, "fragment");
            e eVar = new e();
            Executor a11 = com.instabug.apm.di.a.a("FragmentEventDispatcher");
            Intrinsics.checkNotNullExpressionValue(a11, "getSingleThreadExecutor(executorId)");
            a11.execute(new r(fragment, eVar));
        }
    }

    @JvmStatic
    @TransformationMethod
    public static final void onFragmentPostActivityCreated(@NotNull Fragment fragment) {
        f45306a.onFragmentPostActivityCreated(fragment);
    }

    @JvmStatic
    @TransformationMethod
    public static final void onFragmentPostAttach(@NotNull Fragment fragment) {
        f45306a.onFragmentPostAttach(fragment);
    }

    @JvmStatic
    @TransformationMethod
    public static final void onFragmentPostCreate(@NotNull Fragment fragment) {
        f45306a.onFragmentPostCreate(fragment);
    }

    @JvmStatic
    @TransformationMethod
    public static final void onFragmentPostCreateView(@NotNull Fragment fragment) {
        f45306a.onFragmentPostCreateView(fragment);
    }

    @JvmStatic
    @TransformationMethod
    public static final void onFragmentPostDeAttach(@NotNull Fragment fragment) {
        f45306a.onFragmentPostDeAttach(fragment);
    }

    @JvmStatic
    @TransformationMethod
    public static final void onFragmentPostResume(@NotNull Fragment fragment) {
        f45306a.onFragmentPostResume(fragment);
    }

    @JvmStatic
    @TransformationMethod
    public static final void onFragmentPostStart(@NotNull Fragment fragment) {
        f45306a.onFragmentPostStart(fragment);
    }

    @JvmStatic
    @TransformationMethod
    public static final void onFragmentPostViewCreated(@NotNull Fragment fragment) {
        f45306a.onFragmentPostViewCreated(fragment);
    }

    @JvmStatic
    @TransformationMethod
    public static final void onFragmentPostViewStateRestore(@NotNull Fragment fragment) {
        f45306a.onFragmentPostViewStateRestore(fragment);
    }

    @JvmStatic
    @TransformationMethod
    public static final void onFragmentPreActivityCreated(@NotNull Fragment fragment) {
        f45306a.onFragmentPreActivityCreated(fragment);
    }

    @JvmStatic
    @TransformationMethod
    public static final void onFragmentPreAttach(@NotNull Fragment fragment) {
        f45306a.onFragmentPreAttach(fragment);
    }

    @JvmStatic
    @TransformationMethod
    public static final void onFragmentPreCreate(@NotNull Fragment fragment) {
        f45306a.onFragmentPreCreate(fragment);
    }

    @JvmStatic
    @TransformationMethod
    public static final void onFragmentPreCreateView(@NotNull Fragment fragment) {
        f45306a.onFragmentPreCreateView(fragment);
    }

    @JvmStatic
    @TransformationMethod
    public static final void onFragmentPreDeAttach(@NotNull Fragment fragment) {
        f45306a.onFragmentPreDeAttach(fragment);
    }

    @JvmStatic
    @TransformationMethod
    public static final void onFragmentPreResume(@NotNull Fragment fragment) {
        f45306a.onFragmentPreResume(fragment);
    }

    @JvmStatic
    @TransformationMethod
    public static final void onFragmentPreStart(@NotNull Fragment fragment) {
        f45306a.onFragmentPreStart(fragment);
    }

    @JvmStatic
    @TransformationMethod
    public static final void onFragmentPreViewCreated(@NotNull Fragment fragment) {
        f45306a.onFragmentPreViewCreated(fragment);
    }

    @JvmStatic
    @TransformationMethod
    public static final void onFragmentPreViewStateRestore(@NotNull Fragment fragment) {
        f45306a.onFragmentPreViewStateRestore(fragment);
    }
}
