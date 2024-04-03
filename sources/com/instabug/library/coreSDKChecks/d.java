package com.instabug.library.coreSDKChecks;

import com.google.firebase.remoteconfig.RemoteConfigConstants;
import com.instabug.library.settings.SettingsManager;
import kotlin.Lazy;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class d {
    /* access modifiers changed from: private */
    @Nullable

    /* renamed from: a  reason: collision with root package name */
    public final SettingsManager f34208a;
    @NotNull

    /* renamed from: b  reason: collision with root package name */
    private final Lazy f34209b;
    @NotNull

    /* renamed from: c  reason: collision with root package name */
    private final Lazy f34210c;
    @NotNull

    /* renamed from: d  reason: collision with root package name */
    private final Lazy f34211d;

    @JvmOverloads
    public d() {
        this((SettingsManager) null, 1, (DefaultConstructorMarker) null);
    }

    @JvmOverloads
    public d(@Nullable SettingsManager settingsManager) {
        this.f34208a = settingsManager;
        this.f34209b = LazyKt__LazyJVMKt.lazy(new a(this));
        this.f34210c = LazyKt__LazyJVMKt.lazy(new b(this));
        this.f34211d = LazyKt__LazyJVMKt.lazy(new c(this));
    }

    private final f b() {
        return (f) this.f34210c.getValue();
    }

    private final g c() {
        return (g) this.f34211d.getValue();
    }

    private final e a() {
        return (e) this.f34209b.getValue();
    }

    public final void a(int i11, @NotNull String str) {
        Intrinsics.checkNotNullParameter(str, RemoteConfigConstants.RequestFieldKey.SDK_VERSION);
        a().b();
        b().b(i11);
        c().a(str);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ d(SettingsManager settingsManager, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this((i11 & 1) != 0 ? SettingsManager.getInstance() : settingsManager);
    }
}
