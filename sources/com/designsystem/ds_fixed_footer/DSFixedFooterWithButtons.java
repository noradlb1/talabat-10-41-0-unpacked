package com.designsystem.ds_fixed_footer;

import android.content.Context;
import android.util.AttributeSet;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotMutationPolicy;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.runtime.internal.StabilityInferred;
import com.designsystem.ds_button_v2.DSBaseButton;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\b'\u0018\u0000 \u00192\u00020\u0001:\u0001\u0019B'\b\u0007\u0012\u0006\u0010\u0012\u001a\u00020\u0011\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0013\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u0015¢\u0006\u0004\b\u0017\u0010\u0018J*\u0010\u0007\u001a\u0013\u0012\u000f\u0012\r\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0002\b\u00060\u0002*\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0005¢\u0006\u0004\b\u0007\u0010\bR7\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028F@FX\u0002¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u001a"}, d2 = {"Lcom/designsystem/ds_fixed_footer/DSFixedFooterWithButtons;", "Lcom/designsystem/ds_fixed_footer/DSBaseFixedFooter;", "", "Lcom/designsystem/ds_button_v2/DSBaseButton;", "Lkotlin/Function0;", "", "Landroidx/compose/runtime/Composable;", "a", "(Ljava/util/List;Landroidx/compose/runtime/Composer;I)Ljava/util/List;", "<set-?>", "buttons$delegate", "Landroidx/compose/runtime/MutableState;", "getButtons", "()Ljava/util/List;", "setButtons", "(Ljava/util/List;)V", "buttons", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "Companion", "marshmallow_release"}, k = 1, mv = {1, 5, 1})
public abstract class DSFixedFooterWithButtons extends DSBaseFixedFooter {
    public static final int $stable = 0;
    public static final int ButtonsMaxCount = 2;
    public static final int ButtonsMinCount = 1;
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @NotNull
    private final MutableState buttons$delegate;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/designsystem/ds_fixed_footer/DSFixedFooterWithButtons$Companion;", "", "()V", "ButtonsMaxCount", "", "ButtonsMinCount", "marshmallow_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public DSFixedFooterWithButtons(@NotNull Context context) {
        this(context, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public DSFixedFooterWithButtons(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ DSFixedFooterWithButtons(Context context, AttributeSet attributeSet, int i11, int i12, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i12 & 2) != 0 ? null : attributeSet, (i12 & 4) != 0 ? 0 : i11);
    }

    public void _$_clearFindViewByIdCache() {
    }

    @NotNull
    @Composable
    public final List<Function2<Composer, Integer, Unit>> a(@NotNull List<? extends DSBaseButton> list, @Nullable Composer composer, int i11) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        composer.startReplaceableGroup(469682325);
        Iterable<DSBaseButton> iterable = list;
        ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(iterable, 10));
        for (DSBaseButton dSFixedFooterWithButtons$toComposable$1$1 : iterable) {
            arrayList.add(ComposableLambdaKt.composableLambdaInstance(-985532528, true, new DSFixedFooterWithButtons$toComposable$1$1(dSFixedFooterWithButtons$toComposable$1$1)));
        }
        composer.endReplaceableGroup();
        return arrayList;
    }

    @NotNull
    public final List<DSBaseButton> getButtons() {
        return (List) this.buttons$delegate.getValue();
    }

    public final void setButtons(@NotNull List<? extends DSBaseButton> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.buttons$delegate.setValue(list);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public DSFixedFooterWithButtons(@NotNull Context context, @Nullable AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        Intrinsics.checkNotNullParameter(context, "context");
        this.buttons$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(CollectionsKt__CollectionsKt.emptyList(), (SnapshotMutationPolicy) null, 2, (Object) null);
    }
}
