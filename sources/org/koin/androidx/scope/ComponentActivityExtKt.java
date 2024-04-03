package org.koin.androidx.scope;

import android.app.Activity;
import androidx.activity.ComponentActivity;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.koin.android.ext.android.ComponentCallbackExtKt;
import org.koin.core.component.KoinScopeComponentKt;
import org.koin.core.context.KoinContext;
import org.koin.core.scope.Scope;

@Metadata(d1 = {"\u0000$\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0002\u001a\u0010\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004*\u00020\u0002\u001a\u0016\u0010\u0006\u001a\u00020\u0007*\u00020\u00022\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u001a\f\u0010\n\u001a\u0004\u0018\u00010\u0007*\u00020\u0002¨\u0006\u000b"}, d2 = {"activityRetainedScope", "Lorg/koin/androidx/scope/LifecycleViewModelScopeDelegate;", "Landroidx/activity/ComponentActivity;", "activityScope", "Lorg/koin/androidx/scope/LifecycleScopeDelegate;", "Landroid/app/Activity;", "createScope", "Lorg/koin/core/scope/Scope;", "source", "", "getScopeOrNull", "koin-android_release"}, k = 2, mv = {1, 5, 1}, xi = 48)
public final class ComponentActivityExtKt {
    @NotNull
    public static final LifecycleViewModelScopeDelegate activityRetainedScope(@NotNull ComponentActivity componentActivity) {
        Intrinsics.checkNotNullParameter(componentActivity, "<this>");
        return new LifecycleViewModelScopeDelegate(componentActivity, (KoinContext) null, (Function1) null, 6, (DefaultConstructorMarker) null);
    }

    @NotNull
    public static final LifecycleScopeDelegate<Activity> activityScope(@NotNull ComponentActivity componentActivity) {
        Intrinsics.checkNotNullParameter(componentActivity, "<this>");
        return new LifecycleScopeDelegate(componentActivity, (KoinContext) null, (Function1) null, 6, (DefaultConstructorMarker) null);
    }

    @NotNull
    public static final Scope createScope(@NotNull ComponentActivity componentActivity, @Nullable Object obj) {
        Intrinsics.checkNotNullParameter(componentActivity, "<this>");
        return ComponentCallbackExtKt.getKoin(componentActivity).createScope(KoinScopeComponentKt.getScopeId(componentActivity), KoinScopeComponentKt.getScopeName(componentActivity), obj);
    }

    public static /* synthetic */ Scope createScope$default(ComponentActivity componentActivity, Object obj, int i11, Object obj2) {
        if ((i11 & 1) != 0) {
            obj = null;
        }
        return createScope(componentActivity, obj);
    }

    @Nullable
    public static final Scope getScopeOrNull(@NotNull ComponentActivity componentActivity) {
        Intrinsics.checkNotNullParameter(componentActivity, "<this>");
        return ComponentCallbackExtKt.getKoin(componentActivity).getScopeOrNull(KoinScopeComponentKt.getScopeId(componentActivity));
    }
}
