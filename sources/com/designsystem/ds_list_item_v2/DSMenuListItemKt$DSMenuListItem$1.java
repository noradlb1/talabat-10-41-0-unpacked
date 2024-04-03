package com.designsystem.ds_list_item_v2;

import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.internal.ComposableLambda;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import com.designsystem.ds_list_item_v2.composables.SelectableListItemComposablesKt;
import com.designsystem.ds_theme.DSTheme;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
public final class DSMenuListItemKt$DSMenuListItem$1 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ String f32006g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ boolean f32007h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ Function1<Boolean, Unit> f32008i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ Modifier f32009j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ int f32010k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ String f32011l;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DSMenuListItemKt$DSMenuListItem$1(String str, boolean z11, Function1<? super Boolean, Unit> function1, Modifier modifier, int i11, String str2) {
        super(2);
        this.f32006g = str;
        this.f32007h = z11;
        this.f32008i = function1;
        this.f32009j = modifier;
        this.f32010k = i11;
        this.f32011l = str2;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    @Composable
    public final void invoke(@Nullable Composer composer, int i11) {
        Composer composer2 = composer;
        if (((i11 & 11) ^ 2) != 0 || !composer.getSkipping()) {
            float r102 = DSTheme.INSTANCE.getDimens(composer2, 0).m8849getDsZeroD9Ej5fM();
            String str = this.f32006g;
            boolean z11 = this.f32007h;
            Function1<Boolean, Unit> function1 = this.f32008i;
            Modifier modifier = this.f32009j;
            final String str2 = this.f32011l;
            final int i12 = this.f32010k;
            ComposableLambda composableLambda = ComposableLambdaKt.composableLambda(composer2, -819894940, true, new Function3<Boolean, Composer, Integer, Unit>() {
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
                    invoke(((Boolean) obj).booleanValue(), (Composer) obj2, ((Number) obj3).intValue());
                    return Unit.INSTANCE;
                }

                @Composable
                public final void invoke(boolean z11, @Nullable Composer composer, int i11) {
                    if (((i11 & 81) ^ 16) != 0 || !composer.getSkipping()) {
                        DSMenuListItemKt.MenuItemDescription(str2, composer, (i12 >> 9) & 14);
                    } else {
                        composer.skipToGroupEnd();
                    }
                }
            });
            int i13 = this.f32010k;
            SelectableListItemComposablesKt.m8492SelectionListItem_zuBKE(str, z11, function1, modifier, (String) null, (String) null, (Integer) null, (Integer) null, (Integer) null, r102, true, (String) null, (String) null, true, composableLambda, composer, (i13 & 14) | 113467392 | (i13 & 112) | ((i13 >> 6) & 896) | ((i13 << 3) & 7168), 28086, 64);
            return;
        }
        composer.skipToGroupEnd();
    }
}
