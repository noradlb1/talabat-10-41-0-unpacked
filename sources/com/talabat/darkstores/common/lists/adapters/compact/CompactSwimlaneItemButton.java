package com.talabat.darkstores.common.lists.adapters.compact;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import androidx.cardview.widget.CardView;
import androidx.transition.Explode;
import androidx.transition.TransitionManager;
import com.talabat.darkstores.R;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0000\u0018\u0000 #2\u00020\u0001:\u0001#B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u000e\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"R\u001d\u0010\t\u001a\u0004\u0018\u00010\n8BX\u0002¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000b\u0010\fR#\u0010\u000f\u001a\n \u0011*\u0004\u0018\u00010\u00100\u00108BX\u0002¢\u0006\f\n\u0004\b\u0014\u0010\u000e\u001a\u0004\b\u0012\u0010\u0013R\u001b\u0010\u0015\u001a\u00020\u00078BX\u0002¢\u0006\f\n\u0004\b\u0018\u0010\u000e\u001a\u0004\b\u0016\u0010\u0017R\u001d\u0010\u0019\u001a\u0004\u0018\u00010\n8BX\u0002¢\u0006\f\n\u0004\b\u001b\u0010\u000e\u001a\u0004\b\u001a\u0010\fR\u001b\u0010\u001c\u001a\u00020\u00078BX\u0002¢\u0006\f\n\u0004\b\u001e\u0010\u000e\u001a\u0004\b\u001d\u0010\u0017¨\u0006$"}, d2 = {"Lcom/talabat/darkstores/common/lists/adapters/compact/CompactSwimlaneItemButton;", "Landroidx/cardview/widget/CardView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "checkIcon", "Landroid/graphics/drawable/Drawable;", "getCheckIcon", "()Landroid/graphics/drawable/Drawable;", "checkIcon$delegate", "Lkotlin/Lazy;", "iconView", "Landroid/widget/ImageView;", "kotlin.jvm.PlatformType", "getIconView", "()Landroid/widget/ImageView;", "iconView$delegate", "orangeBackground", "getOrangeBackground", "()I", "orangeBackground$delegate", "plusIcon", "getPlusIcon", "plusIcon$delegate", "whiteBackground", "getWhiteBackground", "whiteBackground$delegate", "setChecked", "", "checked", "", "Companion", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CompactSwimlaneItemButton extends CardView {
    private static final long ANIMATION_DURATION = 300;
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @NotNull
    public Map<Integer, View> _$_findViewCache;
    @NotNull
    private final Lazy checkIcon$delegate;
    @NotNull
    private final Lazy iconView$delegate;
    @NotNull
    private final Lazy orangeBackground$delegate;
    @NotNull
    private final Lazy plusIcon$delegate;
    @NotNull
    private final Lazy whiteBackground$delegate;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/talabat/darkstores/common/lists/adapters/compact/CompactSwimlaneItemButton$Companion;", "", "()V", "ANIMATION_DURATION", "", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public CompactSwimlaneItemButton(@NotNull Context context) {
        this(context, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public CompactSwimlaneItemButton(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public CompactSwimlaneItemButton(@NotNull Context context, @Nullable AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        Intrinsics.checkNotNullParameter(context, "context");
        this._$_findViewCache = new LinkedHashMap();
        View.inflate(context, R.layout.compact_swimlane_item_button, this);
        setRadius(getResources().getDimension(com.designsystem.marshmallow.R.dimen.ds_xxs));
        LazyThreadSafetyMode lazyThreadSafetyMode = LazyThreadSafetyMode.NONE;
        this.orangeBackground$delegate = LazyKt__LazyJVMKt.lazy(lazyThreadSafetyMode, new CompactSwimlaneItemButton$orangeBackground$2(context));
        this.whiteBackground$delegate = LazyKt__LazyJVMKt.lazy(lazyThreadSafetyMode, new CompactSwimlaneItemButton$whiteBackground$2(context));
        this.plusIcon$delegate = LazyKt__LazyJVMKt.lazy(lazyThreadSafetyMode, new CompactSwimlaneItemButton$plusIcon$2(context, this));
        this.checkIcon$delegate = LazyKt__LazyJVMKt.lazy(lazyThreadSafetyMode, new CompactSwimlaneItemButton$checkIcon$2(context, this));
        this.iconView$delegate = LazyKt__LazyJVMKt.lazy(lazyThreadSafetyMode, new CompactSwimlaneItemButton$iconView$2(this));
    }

    private final Drawable getCheckIcon() {
        return (Drawable) this.checkIcon$delegate.getValue();
    }

    private final ImageView getIconView() {
        return (ImageView) this.iconView$delegate.getValue();
    }

    /* access modifiers changed from: private */
    public final int getOrangeBackground() {
        return ((Number) this.orangeBackground$delegate.getValue()).intValue();
    }

    private final Drawable getPlusIcon() {
        return (Drawable) this.plusIcon$delegate.getValue();
    }

    /* access modifiers changed from: private */
    public final int getWhiteBackground() {
        return ((Number) this.whiteBackground$delegate.getValue()).intValue();
    }

    public void _$_clearFindViewByIdCache() {
        this._$_findViewCache.clear();
    }

    @Nullable
    public View _$_findCachedViewById(int i11) {
        Map<Integer, View> map = this._$_findViewCache;
        View view = map.get(Integer.valueOf(i11));
        if (view != null) {
            return view;
        }
        View findViewById = findViewById(i11);
        if (findViewById == null) {
            return null;
        }
        map.put(Integer.valueOf(i11), findViewById);
        return findViewById;
    }

    public final void setChecked(boolean z11) {
        int i11;
        Drawable drawable;
        setEnabled(!z11);
        Explode explode = new Explode();
        explode.setDuration(ANIMATION_DURATION);
        TransitionManager.beginDelayedTransition(this, explode);
        if (z11) {
            i11 = getOrangeBackground();
        } else {
            i11 = getWhiteBackground();
        }
        setCardBackgroundColor(i11);
        ImageView iconView = getIconView();
        if (z11) {
            drawable = getCheckIcon();
        } else {
            drawable = getPlusIcon();
        }
        iconView.setImageDrawable(drawable);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ CompactSwimlaneItemButton(Context context, AttributeSet attributeSet, int i11, int i12, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i12 & 2) != 0 ? null : attributeSet, (i12 & 4) != 0 ? 0 : i11);
    }
}
