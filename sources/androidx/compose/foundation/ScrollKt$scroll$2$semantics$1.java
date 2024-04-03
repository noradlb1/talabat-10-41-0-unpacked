package androidx.compose.foundation;

import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.foundation.gestures.ScrollExtensionsKt;
import androidx.compose.ui.semantics.ScrollAxisRange;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
public final class ScrollKt$scroll$2$semantics$1 extends Lambda implements Function1<SemanticsPropertyReceiver, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ boolean f1797g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ boolean f1798h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ boolean f1799i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ ScrollState f1800j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ CoroutineScope f1801k;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ScrollKt$scroll$2$semantics$1(boolean z11, boolean z12, boolean z13, ScrollState scrollState, CoroutineScope coroutineScope) {
        super(1);
        this.f1797g = z11;
        this.f1798h = z12;
        this.f1799i = z13;
        this.f1800j = scrollState;
        this.f1801k = coroutineScope;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((SemanticsPropertyReceiver) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull SemanticsPropertyReceiver semanticsPropertyReceiver) {
        Intrinsics.checkNotNullParameter(semanticsPropertyReceiver, "$this$semantics");
        ScrollAxisRange scrollAxisRange = new ScrollAxisRange(new ScrollKt$scroll$2$semantics$1$accessibilityScrollState$1(this.f1800j), new ScrollKt$scroll$2$semantics$1$accessibilityScrollState$2(this.f1800j), this.f1797g);
        if (this.f1798h) {
            SemanticsPropertiesKt.setVerticalScrollAxisRange(semanticsPropertyReceiver, scrollAxisRange);
        } else {
            SemanticsPropertiesKt.setHorizontalScrollAxisRange(semanticsPropertyReceiver, scrollAxisRange);
        }
        if (this.f1799i) {
            final CoroutineScope coroutineScope = this.f1801k;
            final boolean z11 = this.f1798h;
            final ScrollState scrollState = this.f1800j;
            SemanticsPropertiesKt.scrollBy$default(semanticsPropertyReceiver, (String) null, new Function2<Float, Float, Boolean>() {

                @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
                @DebugMetadata(c = "androidx.compose.foundation.ScrollKt$scroll$2$semantics$1$1$1", f = "Scroll.kt", i = {}, l = {275, 277}, m = "invokeSuspend", n = {}, s = {})
                /* renamed from: androidx.compose.foundation.ScrollKt$scroll$2$semantics$1$1$1  reason: invalid class name */
                public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

                    /* renamed from: h  reason: collision with root package name */
                    public int f1805h;

                    @NotNull
                    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
                        return new AnonymousClass1(z11, scrollState, f13, f14, continuation);
                    }

                    @Nullable
                    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
                        return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                    }

                    @Nullable
                    public final Object invokeSuspend(@NotNull Object obj) {
                        Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                        int i11 = this.f1805h;
                        if (i11 == 0) {
                            ResultKt.throwOnFailure(obj);
                            if (z11) {
                                ScrollState scrollState = scrollState;
                                Intrinsics.checkNotNull(scrollState, "null cannot be cast to non-null type androidx.compose.foundation.gestures.ScrollableState");
                                float f11 = f13;
                                this.f1805h = 1;
                                if (ScrollExtensionsKt.animateScrollBy$default(scrollState, f11, (AnimationSpec) null, this, 2, (Object) null) == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                            } else {
                                ScrollState scrollState2 = scrollState;
                                Intrinsics.checkNotNull(scrollState2, "null cannot be cast to non-null type androidx.compose.foundation.gestures.ScrollableState");
                                float f12 = f14;
                                this.f1805h = 2;
                                if (ScrollExtensionsKt.animateScrollBy$default(scrollState2, f12, (AnimationSpec) null, this, 2, (Object) null) == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                            }
                        } else if (i11 == 1 || i11 == 2) {
                            ResultKt.throwOnFailure(obj);
                        } else {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        return Unit.INSTANCE;
                    }
                }

                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    return invoke(((Number) obj).floatValue(), ((Number) obj2).floatValue());
                }

                @NotNull
                public final Boolean invoke(float f11, float f12) {
                    CoroutineScope coroutineScope = coroutineScope;
                    final boolean z11 = z11;
                    final ScrollState scrollState = scrollState;
                    final float f13 = f12;
                    final float f14 = f11;
                    Job unused = BuildersKt__Builders_commonKt.launch$default(coroutineScope, (CoroutineContext) null, (CoroutineStart) null, new AnonymousClass1((Continuation<? super AnonymousClass1>) null), 3, (Object) null);
                    return Boolean.TRUE;
                }
            }, 1, (Object) null);
        }
    }
}
