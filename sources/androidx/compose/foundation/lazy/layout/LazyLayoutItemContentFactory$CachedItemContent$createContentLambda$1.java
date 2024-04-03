package androidx.compose.foundation.lazy.layout;

import androidx.compose.foundation.lazy.layout.LazyLayoutItemContentFactory;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.DisposableEffectResult;
import androidx.compose.runtime.DisposableEffectScope;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\u000b¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "", "invoke", "(Landroidx/compose/runtime/Composer;I)V"}, k = 3, mv = {1, 7, 1}, xi = 48)
public final class LazyLayoutItemContentFactory$CachedItemContent$createContentLambda$1 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ LazyLayoutItemContentFactory f3011g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ LazyLayoutItemContentFactory.CachedItemContent f3012h;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public LazyLayoutItemContentFactory$CachedItemContent$createContentLambda$1(LazyLayoutItemContentFactory lazyLayoutItemContentFactory, LazyLayoutItemContentFactory.CachedItemContent cachedItemContent) {
        super(2);
        this.f3011g = lazyLayoutItemContentFactory;
        this.f3012h = cachedItemContent;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    @Composable
    public final void invoke(@Nullable Composer composer, int i11) {
        final int i12;
        if ((i11 & 11) != 2 || !composer.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1403994769, i11, -1, "androidx.compose.foundation.lazy.layout.LazyLayoutItemContentFactory.CachedItemContent.createContentLambda.<anonymous> (LazyLayoutItemContentFactory.kt:89)");
            }
            final LazyLayoutItemProvider invoke = this.f3011g.getItemProvider().invoke();
            Integer num = invoke.getKeyToIndexMap().get(this.f3012h.getKey());
            if (num != null) {
                this.f3012h.setLastKnownIndex(num.intValue());
                i12 = num.intValue();
            } else {
                i12 = this.f3012h.getLastKnownIndex();
            }
            composer.startReplaceableGroup(-715770513);
            if (i12 < invoke.getItemCount()) {
                Object key = invoke.getKey(i12);
                if (Intrinsics.areEqual(key, this.f3012h.getKey())) {
                    this.f3011g.saveableStateHolder.SaveableStateProvider(key, ComposableLambdaKt.composableLambda(composer, -1238863364, true, new Function2<Composer, Integer, Unit>() {
                        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                            invoke((Composer) obj, ((Number) obj2).intValue());
                            return Unit.INSTANCE;
                        }

                        @Composable
                        public final void invoke(@Nullable Composer composer, int i11) {
                            if ((i11 & 11) != 2 || !composer.getSkipping()) {
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(-1238863364, i11, -1, "androidx.compose.foundation.lazy.layout.LazyLayoutItemContentFactory.CachedItemContent.createContentLambda.<anonymous>.<anonymous> (LazyLayoutItemContentFactory.kt:97)");
                                }
                                invoke.Item(i12, composer, 0);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                    return;
                                }
                                return;
                            }
                            composer.skipToGroupEnd();
                        }
                    }), composer, 568);
                }
            }
            composer.endReplaceableGroup();
            Object key2 = this.f3012h.getKey();
            final LazyLayoutItemContentFactory.CachedItemContent cachedItemContent = this.f3012h;
            EffectsKt.DisposableEffect(key2, (Function1<? super DisposableEffectScope, ? extends DisposableEffectResult>) new Function1<DisposableEffectScope, DisposableEffectResult>() {
                @NotNull
                public final DisposableEffectResult invoke(@NotNull DisposableEffectScope disposableEffectScope) {
                    Intrinsics.checkNotNullParameter(disposableEffectScope, "$this$DisposableEffect");
                    return new LazyLayoutItemContentFactory$CachedItemContent$createContentLambda$1$2$invoke$$inlined$onDispose$1(cachedItemContent);
                }
            }, composer, 8);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
                return;
            }
            return;
        }
        composer.skipToGroupEnd();
    }
}
