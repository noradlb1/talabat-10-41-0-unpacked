package com.designsystem.ds_list_item_v2.composables;

import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.material.ripple.RippleKt;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import com.designsystem.ds_theme.DSTheme;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
public final class ListItemComposablesKt$ListItemSurface$1 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ MutableInteractionSource f32247g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ Function0<Unit> f32248h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ boolean f32249i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ Function3<RowScope, Composer, Integer, Unit> f32250j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ int f32251k;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ListItemComposablesKt$ListItemSurface$1(MutableInteractionSource mutableInteractionSource, Function0<Unit> function0, boolean z11, Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function3, int i11) {
        super(2);
        this.f32247g = mutableInteractionSource;
        this.f32248h = function0;
        this.f32249i = z11;
        this.f32250j = function3;
        this.f32251k = i11;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    @Composable
    public final void invoke(@Nullable Composer composer, int i11) {
        if (((i11 & 11) ^ 2) != 0 || !composer.getSkipping()) {
            Modifier.Companion companion = Modifier.Companion;
            MutableInteractionSource mutableInteractionSource = this.f32247g;
            DSTheme dSTheme = DSTheme.INSTANCE;
            Modifier r12 = PaddingKt.m486padding3ABfNKs(ListItemComposablesKt.tappable(companion, mutableInteractionSource, RippleKt.m1485rememberRipple9IZ8Weo(false, 0.0f, dSTheme.getColors(composer, 0).m8764getDsNeutral350d7_KjU(), composer, 0, 3), this.f32248h, this.f32249i), dSTheme.getDimens(composer, 0).m8842getDsSD9Ej5fM());
            final Function3<RowScope, Composer, Integer, Unit> function3 = this.f32250j;
            final int i12 = this.f32251k;
            ListItemComposablesKt.ListItemInteractiveSurface(r12, ComposableLambdaKt.composableLambda(composer, -819890388, true, new Function3<RowScope, Composer, Integer, Unit>() {
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
                        function3.invoke(rowScope, composer, Integer.valueOf((i11 & 14) | ((i12 >> 9) & 112)));
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
