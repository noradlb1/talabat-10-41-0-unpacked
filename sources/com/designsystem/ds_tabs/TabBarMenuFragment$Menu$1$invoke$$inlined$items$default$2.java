package com.designsystem.ds_tabs;

import androidx.compose.foundation.lazy.LazyItemScope;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.MutableState;
import androidx.compose.ui.Modifier;
import com.designsystem.ds_list_item_v2.DSMenuListItemKt;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import net.bytebuddy.jar.asm.Opcodes;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0006\u001a\u00020\u0004\"\u0004\b\u0000\u0010\u0000*\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0002H\u000b¨\u0006\u0005"}, d2 = {"T", "Landroidx/compose/foundation/lazy/LazyItemScope;", "", "it", "", "androidx/compose/foundation/lazy/LazyDslKt$items$2", "<anonymous>"}, k = 3, mv = {1, 5, 1})
public final class TabBarMenuFragment$Menu$1$invoke$$inlined$items$default$2 extends Lambda implements Function4<LazyItemScope, Integer, Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ List f33051g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ MutableState f33052h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ TabBarMenuFragment f33053i;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TabBarMenuFragment$Menu$1$invoke$$inlined$items$default$2(List list, MutableState mutableState, TabBarMenuFragment tabBarMenuFragment) {
        super(4);
        this.f33051g = list;
        this.f33052h = mutableState;
        this.f33053i = tabBarMenuFragment;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
        invoke((LazyItemScope) obj, ((Number) obj2).intValue(), (Composer) obj3, ((Number) obj4).intValue());
        return Unit.INSTANCE;
    }

    @Composable
    public final void invoke(@NotNull LazyItemScope lazyItemScope, int i11, @Nullable Composer composer, int i12) {
        int i13;
        Intrinsics.checkNotNullParameter(lazyItemScope, "$this$items");
        if ((i12 & 14) == 0) {
            i13 = (composer.changed((Object) lazyItemScope) ? 4 : 2) | i12;
        } else {
            i13 = i12;
        }
        int i14 = 32;
        if ((i12 & 112) == 0) {
            i13 |= composer.changed(i11) ? 32 : 16;
        }
        if (((i13 & 731) ^ Opcodes.I2C) != 0 || !composer.getSkipping()) {
            int i15 = i13 & 14;
            DSTabItemModel dSTabItemModel = (DSTabItemModel) this.f33051g.get(i11);
            if ((i15 & 112) == 0) {
                if (!composer.changed((Object) dSTabItemModel)) {
                    i14 = 16;
                }
                i15 |= i14;
            }
            if (((i15 & 721) ^ Opcodes.D2F) != 0 || !composer.getSkipping()) {
                DSMenuListItemKt.DSMenuListItem(dSTabItemModel.getTitle(), Intrinsics.areEqual((Object) TabBarMenuFragment.m8626Menu$lambda2(this.f33052h), (Object) dSTabItemModel), (Modifier) null, dSTabItemModel.getMenuDescription(), new TabBarMenuFragment$Menu$1$1$1(dSTabItemModel, this.f33053i, this.f33052h), composer, 0, 4);
            } else {
                composer.skipToGroupEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
    }
}
