package com.designsystem.ds_bottom_navigation_bar;

import android.content.Context;
import android.util.AttributeSet;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotMutationPolicy;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.platform.AbstractComposeView;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u000f\b\u0007\u0018\u00002\u00020\u0001B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\r\u0010!\u001a\u00020\u0014H\u0017¢\u0006\u0002\u0010\"R;\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\n2\u000e\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\n8F@FX\u0002¢\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010RG\u0010\u0015\u001a\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u00132\u0014\u0010\t\u001a\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u00138F@FX\u0002¢\u0006\u0012\n\u0004\b\u001a\u0010\u0012\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R/\u0010\u001b\u001a\u0004\u0018\u00010\u000b2\b\u0010\t\u001a\u0004\u0018\u00010\u000b8F@FX\u0002¢\u0006\u0012\n\u0004\b \u0010\u0012\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001f¨\u0006#"}, d2 = {"Lcom/designsystem/ds_bottom_navigation_bar/DSBottomNavigationBar;", "Landroidx/compose/ui/platform/AbstractComposeView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "<set-?>", "", "Lcom/designsystem/ds_bottom_navigation_bar/DSBottomNavigationBarItem;", "items", "getItems", "()Ljava/util/List;", "setItems", "(Ljava/util/List;)V", "items$delegate", "Landroidx/compose/runtime/MutableState;", "Lkotlin/Function1;", "", "onItemSelected", "getOnItemSelected", "()Lkotlin/jvm/functions/Function1;", "setOnItemSelected", "(Lkotlin/jvm/functions/Function1;)V", "onItemSelected$delegate", "selectedItem", "getSelectedItem", "()Lcom/designsystem/ds_bottom_navigation_bar/DSBottomNavigationBarItem;", "setSelectedItem", "(Lcom/designsystem/ds_bottom_navigation_bar/DSBottomNavigationBarItem;)V", "selectedItem$delegate", "Content", "(Landroidx/compose/runtime/Composer;I)V", "marshmallow_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class DSBottomNavigationBar extends AbstractComposeView {
    public static final int $stable = 0;
    @NotNull
    private final MutableState items$delegate;
    @NotNull
    private final MutableState onItemSelected$delegate;
    @NotNull
    private final MutableState selectedItem$delegate;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public DSBottomNavigationBar(@NotNull Context context) {
        this(context, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public DSBottomNavigationBar(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ DSBottomNavigationBar(Context context, AttributeSet attributeSet, int i11, int i12, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i12 & 2) != 0 ? null : attributeSet, (i12 & 4) != 0 ? 0 : i11);
    }

    @Composable
    public void Content(@Nullable Composer composer, int i11) {
        int i12;
        int i13;
        Composer startRestartGroup = composer.startRestartGroup(201601315);
        if ((i11 & 14) == 0) {
            if (startRestartGroup.changed((Object) this)) {
                i13 = 4;
            } else {
                i13 = 2;
            }
            i12 = i13 | i11;
        } else {
            i12 = i11;
        }
        if (((i12 & 11) ^ 2) != 0 || !startRestartGroup.getSkipping()) {
            getItems();
            getOnItemSelected();
            Modifier.Companion companion = Modifier.Companion;
            List<DSBottomNavigationBarItem> items = getItems();
            if (items == null) {
                items = CollectionsKt__CollectionsKt.emptyList();
            }
            List<DSBottomNavigationBarItem> list = items;
            DSBottomNavigationBarItem selectedItem = getSelectedItem();
            Function1 onItemSelected = getOnItemSelected();
            if (onItemSelected == null) {
                onItemSelected = DSBottomNavigationBar$Content$3.INSTANCE;
            }
            DSBottomNavigationBarKt.DSBottomNavigationBar(companion, list, selectedItem, onItemSelected, startRestartGroup, 70, 0);
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new DSBottomNavigationBar$Content$4(this, i11));
        }
    }

    public void _$_clearFindViewByIdCache() {
    }

    @Nullable
    public final List<DSBottomNavigationBarItem> getItems() {
        return (List) this.items$delegate.getValue();
    }

    @Nullable
    public final Function1<DSBottomNavigationBarItem, Unit> getOnItemSelected() {
        return (Function1) this.onItemSelected$delegate.getValue();
    }

    @Nullable
    public final DSBottomNavigationBarItem getSelectedItem() {
        return (DSBottomNavigationBarItem) this.selectedItem$delegate.getValue();
    }

    public final void setItems(@Nullable List<DSBottomNavigationBarItem> list) {
        this.items$delegate.setValue(list);
    }

    public final void setOnItemSelected(@Nullable Function1<? super DSBottomNavigationBarItem, Unit> function1) {
        this.onItemSelected$delegate.setValue(function1);
    }

    public final void setSelectedItem(@Nullable DSBottomNavigationBarItem dSBottomNavigationBarItem) {
        this.selectedItem$delegate.setValue(dSBottomNavigationBarItem);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public DSBottomNavigationBar(@NotNull Context context, @Nullable AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        Intrinsics.checkNotNullParameter(context, "context");
        this.items$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default((Object) null, (SnapshotMutationPolicy) null, 2, (Object) null);
        this.selectedItem$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default((Object) null, (SnapshotMutationPolicy) null, 2, (Object) null);
        this.onItemSelected$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default((Object) null, (SnapshotMutationPolicy) null, 2, (Object) null);
    }
}
