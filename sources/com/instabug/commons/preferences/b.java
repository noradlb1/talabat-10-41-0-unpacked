package com.instabug.commons.preferences;

import android.content.SharedPreferences;
import com.instabug.library.internal.sharedpreferences.PreferencesProperty;
import kotlin.Lazy;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class b extends PreferencesProperty {
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    private final Lazy f46332a = LazyKt__LazyJVMKt.lazy(a.f46331a);

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public b(@NotNull String str, Object obj) {
        super(str, obj);
        Intrinsics.checkNotNullParameter(str, "key");
    }

    @Nullable
    public SharedPreferences getPref() {
        return (SharedPreferences) this.f46332a.getValue();
    }
}
