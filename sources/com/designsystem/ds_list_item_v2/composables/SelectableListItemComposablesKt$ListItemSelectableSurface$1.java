package com.designsystem.ds_list_item_v2.composables;

import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.material.ripple.RippleKt;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import com.designsystem.ds_theme.DSTheme;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
public final class SelectableListItemComposablesKt$ListItemSelectableSurface$1 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ MutableInteractionSource f32286g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ Function1<Boolean, Unit> f32287h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ boolean f32288i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ MutableState<Boolean> f32289j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ Function3<RowScope, Composer, Integer, Unit> f32290k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ int f32291l;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SelectableListItemComposablesKt$ListItemSelectableSurface$1(MutableInteractionSource mutableInteractionSource, Function1<? super Boolean, Unit> function1, boolean z11, MutableState<Boolean> mutableState, Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function3, int i11) {
        super(2);
        this.f32286g = mutableInteractionSource;
        this.f32287h = function1;
        this.f32288i = z11;
        this.f32289j = mutableState;
        this.f32290k = function3;
        this.f32291l = i11;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    @Composable
    public final void invoke(@Nullable Composer composer, int i11) {
        if (((i11 & 11) ^ 2) != 0 || !composer.getSkipping()) {
            Modifier access$selectable = SelectableListItemComposablesKt.selectable(Modifier.Companion, this.f32286g, RippleKt.m1485rememberRipple9IZ8Weo(false, 0.0f, DSTheme.INSTANCE.getColors(composer, 0).m8764getDsNeutral350d7_KjU(), composer, 0, 3), this.f32287h, this.f32288i, this.f32289j);
            final Function3<RowScope, Composer, Integer, Unit> function3 = this.f32290k;
            final int i12 = this.f32291l;
            ListItemComposablesKt.ListItemInteractiveSurface(access$selectable, ComposableLambdaKt.composableLambda(composer, -819904363, true, new Function3<RowScope, Composer, Integer, Unit>() {
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
                    invoke((RowScope) obj, (Composer) obj2, ((Number) obj3).intValue());
                    return Unit.INSTANCE;
                }

                @Composable
                public final void invoke(@NotNull RowScope rowScope, @Nullable Composer composer, int i11) {
                    Intrinsics.checkNotNullParameter(rowScope, "$this$ListItemInteractiveSurface");
                    if ((i11 & 14) == 0) {
                        i11 |= composer.changed((Object) rowScope) ? 4 : 2;
                    }
                    if (((i11 & 91) ^ 18) != 0 || !composer.getSkipping()) {
                        function3.invoke(rowScope, composer, Integer.valueOf((i11 & 14) | ((i12 >> 12) & 112)));
                    } else {
                        composer.skipToGroupEnd();
                    }
                }
            }), composer, 48, 0);
            return;
        }
        composer.skipToGroupEnd();
    }
}
