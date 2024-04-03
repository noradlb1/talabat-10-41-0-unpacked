package com.talabat.darkstores.common.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import ci.p;
import com.google.android.material.button.MaterialButton;
import com.talabat.darkstores.R;
import com.talabat.darkstores.data.NetworkConnectionException;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0000\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002B%\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\b\u0010\u0011\u001a\u00020\fH\u0016J\b\u0010\u0012\u001a\u00020\u0013H\u0016J\u0010\u0010\u0014\u001a\u00020\f2\u0006\u0010\u0015\u001a\u00020\u0016H\u0016R \u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010¨\u0006\u0017"}, d2 = {"Lcom/talabat/darkstores/common/view/LoadingFailedView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "Lcom/talabat/darkstores/common/view/ErrorView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "onReloadClicked", "Lkotlin/Function0;", "", "getOnReloadClicked", "()Lkotlin/jvm/functions/Function0;", "setOnReloadClicked", "(Lkotlin/jvm/functions/Function0;)V", "hide", "isVisible", "", "show", "error", "", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class LoadingFailedView extends ConstraintLayout implements ErrorView {
    @NotNull
    public Map<Integer, View> _$_findViewCache;
    @NotNull
    private Function0<Unit> onReloadClicked;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public LoadingFailedView(@NotNull Context context) {
        this(context, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public LoadingFailedView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public LoadingFailedView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        Intrinsics.checkNotNullParameter(context, "context");
        this._$_findViewCache = new LinkedHashMap();
        this.onReloadClicked = LoadingFailedView$onReloadClicked$1.INSTANCE;
        View.inflate(context, R.layout.darkstores_error, this);
        ((MaterialButton) _$_findCachedViewById(R.id.reloadButton)).setOnClickListener(new p(this));
    }

    /* access modifiers changed from: private */
    /* renamed from: _init_$lambda-0  reason: not valid java name */
    public static final void m9656_init_$lambda0(LoadingFailedView loadingFailedView, View view) {
        Intrinsics.checkNotNullParameter(loadingFailedView, "this$0");
        loadingFailedView.getOnReloadClicked().invoke();
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

    @NotNull
    public Function0<Unit> getOnReloadClicked() {
        return this.onReloadClicked;
    }

    public void hide() {
        setVisibility(8);
    }

    public boolean isVisible() {
        return getVisibility() == 0;
    }

    public void setOnReloadClicked(@NotNull Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(function0, "<set-?>");
        this.onReloadClicked = function0;
    }

    public void show(@NotNull Throwable th2) {
        String str;
        Intrinsics.checkNotNullParameter(th2, "error");
        setVisibility(0);
        if (th2 instanceof NetworkConnectionException) {
            str = getContext().getString(com.talabat.localization.R.string.no_internet_connection_error);
        } else {
            str = getContext().getString(com.talabat.localization.R.string.generic_error);
        }
        Intrinsics.checkNotNullExpressionValue(str, "if (error is NetworkConn….generic_error)\n        }");
        ((TextView) _$_findCachedViewById(R.id.message)).setText(str);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ LoadingFailedView(Context context, AttributeSet attributeSet, int i11, int i12, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i12 & 2) != 0 ? null : attributeSet, (i12 & 4) != 0 ? 0 : i11);
    }
}
