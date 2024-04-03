package com.designsystem.ds_list_item_v2;

import androidx.compose.foundation.layout.RowScope;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import com.designsystem.ds_list_item_v2.composables.CommonListItemComposablesKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
public final class DSListItemKt$DSListItem$1 extends Lambda implements Function3<RowScope, Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ Integer f31986g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ Integer f31987h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ float f31988i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ boolean f31989j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ int f31990k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ int f31991l;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DSListItemKt$DSListItem$1(Integer num, Integer num2, float f11, boolean z11, int i11, int i12) {
        super(3);
        this.f31986g = num;
        this.f31987h = num2;
        this.f31988i = f11;
        this.f31989j = z11;
        this.f31990k = i11;
        this.f31991l = i12;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
        invoke((RowScope) obj, (Composer) obj2, ((Number) obj3).intValue());
        return Unit.INSTANCE;
    }

    @Composable
    public final void invoke(@NotNull RowScope rowScope, @Nullable Composer composer, int i11) {
        Intrinsics.checkNotNullParameter(rowScope, "scope");
        if ((i11 & 14) == 0) {
            i11 |= composer.changed((Object) rowScope) ? 4 : 2;
        }
        if (((i11 & 91) ^ 18) != 0 || !composer.getSkipping()) {
            Integer num = this.f31986g;
            Integer num2 = this.f31987h;
            float f11 = this.f31988i;
            boolean z11 = this.f31989j;
            int i12 = this.f31990k;
            int i13 = i12 >> 15;
            CommonListItemComposablesKt.m8488ListItemLeadingWidgethGBTI10(rowScope.align(Modifier.Companion, Alignment.Companion.getTop()), num, num2, f11, z11, composer, (i13 & 7168) | (i13 & 112) | (i13 & 896) | ((this.f31991l << 12) & 57344), 0);
            return;
        }
        composer.skipToGroupEnd();
    }
}
