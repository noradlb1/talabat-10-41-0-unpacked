package androidx.compose.ui.tooling;

import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.material.FloatingActionButtonElevation;
import androidx.compose.material.FloatingActionButtonKt;
import androidx.compose.material.ScaffoldKt;
import androidx.compose.material.ScaffoldState;
import androidx.compose.material.SnackbarHostState;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotMutationPolicy;
import androidx.compose.runtime.internal.ComposableLambda;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Shape;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0006\n\u0002\u0010\u0002\n\u0000\u0010\u0001\u001a\u00020\u0000H\u000b"}, d2 = {"", "<anonymous>"}, k = 3, mv = {1, 5, 1})
public final class PreviewActivity$setParameterizedContent$1 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ Object[] f10263g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ String f10264h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ String f10265i;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public PreviewActivity$setParameterizedContent$1(Object[] objArr, String str, String str2) {
        super(2);
        this.f10263g = objArr;
        this.f10264h = str;
        this.f10265i = str2;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    @Composable
    public final void invoke(@Nullable Composer composer, int i11) {
        Composer composer2 = composer;
        if (((i11 & 11) ^ 2) != 0 || !composer.getSkipping()) {
            composer2.startReplaceableGroup(-3687241);
            Object rememberedValue = composer.rememberedValue();
            if (rememberedValue == Composer.Companion.getEmpty()) {
                rememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(0, (SnapshotMutationPolicy) null, 2, (Object) null);
                composer2.updateRememberedValue(rememberedValue);
            }
            composer.endReplaceableGroup();
            final MutableState mutableState = (MutableState) rememberedValue;
            final Object[] objArr = this.f10263g;
            ComposableLambda composableLambda = ComposableLambdaKt.composableLambda(composer2, -819891175, true, new Function2<Composer, Integer, Unit>() {
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    invoke((Composer) obj, ((Number) obj2).intValue());
                    return Unit.INSTANCE;
                }

                @Composable
                public final void invoke(@Nullable Composer composer, int i11) {
                    if (((i11 & 11) ^ 2) != 0 || !composer.getSkipping()) {
                        Function2<Composer, Integer, Unit> r22 = ComposableSingletons$PreviewActivityKt.INSTANCE.m5408getLambda1$ui_tooling_release();
                        final MutableState<Integer> mutableState = mutableState;
                        final Object[] objArr = objArr;
                        FloatingActionButtonKt.m1275ExtendedFloatingActionButtonwqdebIU(r22, new Function0<Unit>() {
                            public final void invoke() {
                                MutableState<Integer> mutableState = mutableState;
                                mutableState.setValue(Integer.valueOf((mutableState.getValue().intValue() + 1) % objArr.length));
                            }
                        }, (Modifier) null, (Function2<? super Composer, ? super Integer, Unit>) null, (MutableInteractionSource) null, (Shape) null, 0, 0, (FloatingActionButtonElevation) null, composer, 0, 508);
                        return;
                    }
                    composer.skipToGroupEnd();
                }
            });
            final MutableState mutableState2 = mutableState;
            final String str = this.f10264h;
            final String str2 = this.f10265i;
            final Object[] objArr2 = this.f10263g;
            ScaffoldKt.m1353Scaffold27mzLpw((Modifier) null, (ScaffoldState) null, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, (Function3<? super SnackbarHostState, ? super Composer, ? super Integer, Unit>) null, composableLambda, 0, false, (Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit>) null, false, (Shape) null, 0.0f, 0, 0, 0, 0, 0, ComposableLambdaKt.composableLambda(composer2, -819890235, true, new Function3<PaddingValues, Composer, Integer, Unit>() {
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
                    invoke((PaddingValues) obj, (Composer) obj2, ((Number) obj3).intValue());
                    return Unit.INSTANCE;
                }

                @Composable
                public final void invoke(@NotNull PaddingValues paddingValues, @Nullable Composer composer, int i11) {
                    Intrinsics.checkNotNullParameter(paddingValues, "it");
                    if (((i11 & 81) ^ 16) != 0 || !composer.getSkipping()) {
                        CommonPreviewUtils.INSTANCE.invokeComposableViaReflection$ui_tooling_release(str, str2, composer, objArr2[mutableState2.getValue().intValue()]);
                        return;
                    }
                    composer.skipToGroupEnd();
                }
            }), composer, 2293760, 12582912, 131039);
            return;
        }
        composer.skipToGroupEnd();
    }
}
