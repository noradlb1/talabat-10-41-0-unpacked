package com.deliveryhero.fluid;

import android.content.Context;
import android.graphics.drawable.Drawable;
import com.deliveryhero.fluid.utils.ContextUtilsKt;
import java.util.concurrent.Executor;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\b\u0018\u0000 \u001b2\u00020\u0001:\u0001\u001bB'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J\t\u0010\u0012\u001a\u00020\bHÆ\u0003J-\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\b\b\u0002\u0010\u0007\u001a\u00020\bHÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001c"}, d2 = {"Lcom/deliveryhero/fluid/UiConfig;", "", "context", "Landroid/content/Context;", "clickDrawable", "Lkotlin/Function0;", "Landroid/graphics/drawable/Drawable;", "cellsDiffExecutor", "Ljava/util/concurrent/Executor;", "(Landroid/content/Context;Lkotlin/jvm/functions/Function0;Ljava/util/concurrent/Executor;)V", "getCellsDiffExecutor", "()Ljava/util/concurrent/Executor;", "getClickDrawable", "()Lkotlin/jvm/functions/Function0;", "getContext", "()Landroid/content/Context;", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "", "Companion", "core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class UiConfig {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @NotNull
    private final Executor cellsDiffExecutor;
    @NotNull
    private final Function0<Drawable> clickDrawable;
    @NotNull
    private final Context context;

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006J\u0016\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\u0005\u001a\u00020\u0006H\u0002¨\u0006\n"}, d2 = {"Lcom/deliveryhero/fluid/UiConfig$Companion;", "", "()V", "createDefault", "Lcom/deliveryhero/fluid/UiConfig;", "context", "Landroid/content/Context;", "getDefaultClickDrawable", "Lkotlin/Function0;", "Landroid/graphics/drawable/Drawable;", "core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* access modifiers changed from: private */
        public final Function0<Drawable> getDefaultClickDrawable(Context context) {
            return new UiConfig$Companion$getDefaultClickDrawable$1(context, ContextUtilsKt.getThemeAttributeResourceId(context, R.attr.selectableItemBackground));
        }

        @NotNull
        public final UiConfig createDefault(@NotNull Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            return new UiConfig(context, (Function0) null, (Executor) null, 6, (DefaultConstructorMarker) null);
        }
    }

    public UiConfig(@NotNull Context context2, @NotNull Function0<? extends Drawable> function0, @NotNull Executor executor) {
        Intrinsics.checkNotNullParameter(context2, "context");
        Intrinsics.checkNotNullParameter(function0, "clickDrawable");
        Intrinsics.checkNotNullParameter(executor, "cellsDiffExecutor");
        this.context = context2;
        this.clickDrawable = function0;
        this.cellsDiffExecutor = executor;
    }

    public static /* synthetic */ UiConfig copy$default(UiConfig uiConfig, Context context2, Function0<Drawable> function0, Executor executor, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            context2 = uiConfig.context;
        }
        if ((i11 & 2) != 0) {
            function0 = uiConfig.clickDrawable;
        }
        if ((i11 & 4) != 0) {
            executor = uiConfig.cellsDiffExecutor;
        }
        return uiConfig.copy(context2, function0, executor);
    }

    @NotNull
    public final Context component1() {
        return this.context;
    }

    @NotNull
    public final Function0<Drawable> component2() {
        return this.clickDrawable;
    }

    @NotNull
    public final Executor component3() {
        return this.cellsDiffExecutor;
    }

    @NotNull
    public final UiConfig copy(@NotNull Context context2, @NotNull Function0<? extends Drawable> function0, @NotNull Executor executor) {
        Intrinsics.checkNotNullParameter(context2, "context");
        Intrinsics.checkNotNullParameter(function0, "clickDrawable");
        Intrinsics.checkNotNullParameter(executor, "cellsDiffExecutor");
        return new UiConfig(context2, function0, executor);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof UiConfig)) {
            return false;
        }
        UiConfig uiConfig = (UiConfig) obj;
        return Intrinsics.areEqual((Object) this.context, (Object) uiConfig.context) && Intrinsics.areEqual((Object) this.clickDrawable, (Object) uiConfig.clickDrawable) && Intrinsics.areEqual((Object) this.cellsDiffExecutor, (Object) uiConfig.cellsDiffExecutor);
    }

    @NotNull
    public final Executor getCellsDiffExecutor() {
        return this.cellsDiffExecutor;
    }

    @NotNull
    public final Function0<Drawable> getClickDrawable() {
        return this.clickDrawable;
    }

    @NotNull
    public final Context getContext() {
        return this.context;
    }

    public int hashCode() {
        return (((this.context.hashCode() * 31) + this.clickDrawable.hashCode()) * 31) + this.cellsDiffExecutor.hashCode();
    }

    @NotNull
    public String toString() {
        return "UiConfig(context=" + this.context + ", clickDrawable=" + this.clickDrawable + ", cellsDiffExecutor=" + this.cellsDiffExecutor + ')';
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ UiConfig(android.content.Context r1, kotlin.jvm.functions.Function0 r2, java.util.concurrent.Executor r3, int r4, kotlin.jvm.internal.DefaultConstructorMarker r5) {
        /*
            r0 = this;
            r5 = r4 & 2
            if (r5 == 0) goto L_0x000a
            com.deliveryhero.fluid.UiConfig$Companion r2 = Companion
            kotlin.jvm.functions.Function0 r2 = r2.getDefaultClickDrawable(r1)
        L_0x000a:
            r4 = r4 & 4
            if (r4 == 0) goto L_0x0018
            r3 = 2
            java.util.concurrent.ExecutorService r3 = java.util.concurrent.Executors.newFixedThreadPool(r3)
            java.lang.String r4 = "newFixedThreadPool(2)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r4)
        L_0x0018:
            r0.<init>(r1, r2, r3)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.deliveryhero.fluid.UiConfig.<init>(android.content.Context, kotlin.jvm.functions.Function0, java.util.concurrent.Executor, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }
}
