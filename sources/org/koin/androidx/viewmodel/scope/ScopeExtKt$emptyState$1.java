package org.koin.androidx.viewmodel.scope;

import android.os.Bundle;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0006\n\u0002\u0018\u0002\n\u0000\u0010\u0001\u001a\u00020\u0000H\n"}, d2 = {"Landroid/os/Bundle;", "<anonymous>"}, k = 3, mv = {1, 5, 1})
public final class ScopeExtKt$emptyState$1 extends Lambda implements Function0<Bundle> {
    public static final ScopeExtKt$emptyState$1 INSTANCE = new ScopeExtKt$emptyState$1();

    public ScopeExtKt$emptyState$1() {
        super(0);
    }

    @NotNull
    public final Bundle invoke() {
        return new Bundle();
    }
}
