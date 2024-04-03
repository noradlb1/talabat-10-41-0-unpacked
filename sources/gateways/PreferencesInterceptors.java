package gateways;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u000f\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\u001f\u0010\u0015\u001a\u00020\n2\u0014\u0010\u0016\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00018\u0000\u0012\u0004\u0012\u00020\n0\tH\u0004J!\u0010\u0017\u001a\u00020\n2\u0016\u0010\u0016\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00018\u0000\u0012\u0006\u0012\u0004\u0018\u00018\u00000\tH\u0004J\u001f\u0010\u0018\u001a\u00020\n2\u0014\u0010\u0016\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00018\u0000\u0012\u0004\u0012\u00020\n0\tH\u0004R\"\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u00008\u0006X\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0005\u0010\u0003\u001a\u0004\b\u0006\u0010\u0007R(\u0010\b\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00018\u0000\u0012\u0004\u0012\u00020\n0\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR*\u0010\u000f\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00018\u0000\u0012\u0006\u0012\u0004\u0018\u00018\u00000\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\f\"\u0004\b\u0011\u0010\u000eR(\u0010\u0012\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00018\u0000\u0012\u0004\u0012\u00020\n0\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\f\"\u0004\b\u0014\u0010\u000e¨\u0006\u0019"}, d2 = {"Lgateways/PreferencesInterceptors;", "T", "", "()V", "on", "getOn$annotations", "getOn", "()Lgateways/PreferencesInterceptors;", "onInitialized", "Lkotlin/Function1;", "", "getOnInitialized$com_talabat_talabatlib_talabatlib", "()Lkotlin/jvm/functions/Function1;", "setOnInitialized$com_talabat_talabatlib_talabatlib", "(Lkotlin/jvm/functions/Function1;)V", "onLoaded", "getOnLoaded$com_talabat_talabatlib_talabatlib", "setOnLoaded$com_talabat_talabatlib_talabatlib", "onSaved", "getOnSaved$com_talabat_talabatlib_talabatlib", "setOnSaved$com_talabat_talabatlib_talabatlib", "initialized", "intercept", "loaded", "saved", "com_talabat_talabatlib_talabatlib"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class PreferencesInterceptors<T> {
    @NotNull

    /* renamed from: on  reason: collision with root package name */
    private final PreferencesInterceptors<T> f14082on = this;
    @NotNull
    private Function1<? super T, Unit> onInitialized = PreferencesInterceptors$onInitialized$1.INSTANCE;
    @NotNull
    private Function1<? super T, ? extends T> onLoaded = PreferencesInterceptors$onLoaded$1.INSTANCE;
    @NotNull
    private Function1<? super T, Unit> onSaved = PreferencesInterceptors$onSaved$1.INSTANCE;

    @PreferencesInterceptorsDsl
    public static /* synthetic */ void getOn$annotations() {
    }

    @NotNull
    public final PreferencesInterceptors<T> getOn() {
        return this.f14082on;
    }

    @NotNull
    public final Function1<T, Unit> getOnInitialized$com_talabat_talabatlib_talabatlib() {
        return this.onInitialized;
    }

    @NotNull
    public final Function1<T, T> getOnLoaded$com_talabat_talabatlib_talabatlib() {
        return this.onLoaded;
    }

    @NotNull
    public final Function1<T, Unit> getOnSaved$com_talabat_talabatlib_talabatlib() {
        return this.onSaved;
    }

    @PreferencesInterceptorsDsl
    public final void initialized(@NotNull Function1<? super T, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "intercept");
        this.onInitialized = function1;
    }

    @PreferencesInterceptorsDsl
    public final void loaded(@NotNull Function1<? super T, ? extends T> function1) {
        Intrinsics.checkNotNullParameter(function1, "intercept");
        this.onLoaded = function1;
    }

    @PreferencesInterceptorsDsl
    public final void saved(@NotNull Function1<? super T, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "intercept");
        this.onSaved = function1;
    }

    public final void setOnInitialized$com_talabat_talabatlib_talabatlib(@NotNull Function1<? super T, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "<set-?>");
        this.onInitialized = function1;
    }

    public final void setOnLoaded$com_talabat_talabatlib_talabatlib(@NotNull Function1<? super T, ? extends T> function1) {
        Intrinsics.checkNotNullParameter(function1, "<set-?>");
        this.onLoaded = function1;
    }

    public final void setOnSaved$com_talabat_talabatlib_talabatlib(@NotNull Function1<? super T, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "<set-?>");
        this.onSaved = function1;
    }
}
