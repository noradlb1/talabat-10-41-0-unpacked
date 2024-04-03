package com.instabug.library.tracking;

import com.instabug.library.core.eventbus.EventBus;
import io.reactivex.disposables.Disposable;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

final class y implements w, FirstFGTimeProvider {
    @NotNull

    /* renamed from: b  reason: collision with root package name */
    private final EventBus f51952b;
    @Nullable

    /* renamed from: c  reason: collision with root package name */
    private Disposable f51953c;

    /* renamed from: d  reason: collision with root package name */
    private int f51954d;
    @Nullable

    /* renamed from: e  reason: collision with root package name */
    private Long f51955e;

    public y(@NotNull EventBus eventBus) {
        Intrinsics.checkNotNullParameter(eventBus, "activityLifeCycleEvents");
        this.f51952b = eventBus;
    }

    public void a(int i11) {
        this.f51954d = i11;
    }

    public void b() {
        if (this.f51953c == null) {
            this.f51953c = this.f51952b.subscribe(new c0(this));
        }
    }

    public int getCount() {
        return this.f51954d;
    }

    @Nullable
    public Long getFirstFGTime() {
        return this.f51955e;
    }

    public void a(@Nullable Long l11) {
        if (this.f51955e == null) {
            this.f51955e = l11;
        }
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ y(com.instabug.library.core.eventbus.EventBus r1, int r2, kotlin.jvm.internal.DefaultConstructorMarker r3) {
        /*
            r0 = this;
            r2 = r2 & 1
            if (r2 == 0) goto L_0x000d
            com.instabug.library.core.eventbus.CurrentActivityLifeCycleEventBus r1 = com.instabug.library.core.eventbus.CurrentActivityLifeCycleEventBus.getInstance()
            java.lang.String r2 = "getInstance()"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
        L_0x000d:
            r0.<init>(r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.instabug.library.tracking.y.<init>(com.instabug.library.core.eventbus.EventBus, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    /* access modifiers changed from: private */
    public static final void a(y yVar, ActivityLifeCycleEvent activityLifeCycleEvent) {
        Intrinsics.checkNotNullParameter(yVar, "this$0");
        int i11 = activityLifeCycleEvent == null ? -1 : x.f51951a[activityLifeCycleEvent.ordinal()];
        if (i11 == 1) {
            yVar.a(yVar.getCount() + 1);
            yVar.a(Long.valueOf(System.currentTimeMillis()));
        } else if (i11 == 2) {
            yVar.a(yVar.getCount() - 1);
        }
    }
}
