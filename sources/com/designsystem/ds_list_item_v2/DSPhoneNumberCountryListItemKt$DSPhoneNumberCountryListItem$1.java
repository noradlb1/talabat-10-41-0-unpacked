package com.designsystem.ds_list_item_v2;

import androidx.compose.foundation.layout.RowScope;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
public final class DSPhoneNumberCountryListItemKt$DSPhoneNumberCountryListItem$1 extends Lambda implements Function3<RowScope, Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ Integer f32023g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ int f32024h;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DSPhoneNumberCountryListItemKt$DSPhoneNumberCountryListItem$1(Integer num, int i11) {
        super(3);
        this.f32023g = num;
        this.f32024h = i11;
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
            DSPhoneNumberCountryListItemKt.PhoneNumberCountryFlag(rowScope.align(Modifier.Companion, Alignment.Companion.getTop()), this.f32023g, composer, (this.f32024h >> 6) & 112, 0);
        } else {
            composer.skipToGroupEnd();
        }
    }
}
