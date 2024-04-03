package com.talabat.talabatcommon.views.wallet.dsalert;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.core.view.ViewCompat;
import com.talabat.talabatcommon.R;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import yv.a;
import yv.b;

@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u000b\u0018\u0000 82\u00020\u0001:\u00018B/\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007¢\u0006\u0002\u0010\tJ\u0006\u0010+\u001a\u00020,J\b\u0010-\u001a\u00020.H\u0002J\b\u0010/\u001a\u00020.H\u0002J\b\u00100\u001a\u00020.H\u0002J\b\u00101\u001a\u00020.H\u0002J\b\u00102\u001a\u00020.H\u0002J\b\u00103\u001a\u00020.H\u0002J\b\u00104\u001a\u00020.H\u0002J\b\u00105\u001a\u00020.H\u0002J\b\u00106\u001a\u00020.H\u0002J\b\u00107\u001a\u00020.H\u0002R(\u0010\f\u001a\u0004\u0018\u00010\u000b2\b\u0010\n\u001a\u0004\u0018\u00010\u000b@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R$\u0010\u0012\u001a\u00020\u00112\u0006\u0010\n\u001a\u00020\u0011@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R$\u0010\u0017\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\u000b@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u000e\"\u0004\b\u0019\u0010\u0010R$\u0010\u001a\u001a\u00020\u00112\u0006\u0010\n\u001a\u00020\u0011@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u0014\"\u0004\b\u001b\u0010\u0016R(\u0010\u001c\u001a\u0004\u0018\u00010\u000b2\b\u0010\n\u001a\u0004\u0018\u00010\u000b@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u000e\"\u0004\b\u001e\u0010\u0010R$\u0010 \u001a\u00020\u001f2\u0006\u0010\n\u001a\u00020\u001f@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\u0016\u0010%\u001a\n '*\u0004\u0018\u00010&0&X\u0004¢\u0006\u0002\n\u0000R$\u0010(\u001a\u00020\u00112\u0006\u0010\n\u001a\u00020\u0011@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010\u0014\"\u0004\b*\u0010\u0016¨\u00069"}, d2 = {"Lcom/talabat/talabatcommon/views/wallet/dsalert/DSAlertView;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "defStyleRes", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "value", "", "action", "getAction", "()Ljava/lang/String;", "setAction", "(Ljava/lang/String;)V", "", "canDismiss", "getCanDismiss", "()Z", "setCanDismiss", "(Z)V", "descriptor", "getDescriptor", "setDescriptor", "isFullDescriptor", "setFullDescriptor", "title", "getTitle", "setTitle", "Lcom/talabat/talabatcommon/views/wallet/dsalert/DSAlertType;", "type", "getType", "()Lcom/talabat/talabatcommon/views/wallet/dsalert/DSAlertType;", "setType", "(Lcom/talabat/talabatcommon/views/wallet/dsalert/DSAlertType;)V", "view", "Landroid/view/View;", "kotlin.jvm.PlatformType", "withLeadingIcon", "getWithLeadingIcon", "setWithLeadingIcon", "getActionText", "Landroidx/appcompat/widget/AppCompatTextView;", "handleCanDismiss", "", "handleIsFullDescriptor", "hide", "initAction", "initDescriptor", "initLeadingIcon", "initListeners", "initTitle", "initType", "initViews", "Companion", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class DSAlertView extends FrameLayout {
    @Deprecated
    private static final long ANIMATION_DURATION = 500;
    @NotNull
    private static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @NotNull
    public Map<Integer, View> _$_findViewCache;
    @Nullable
    private String action;
    private boolean canDismiss;
    @NotNull
    private String descriptor;
    private boolean isFullDescriptor;
    @Nullable
    private String title;
    @NotNull
    private DSAlertType type;
    private final View view;
    private boolean withLeadingIcon;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/talabat/talabatcommon/views/wallet/dsalert/DSAlertView$Companion;", "", "()V", "ANIMATION_DURATION", "", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public DSAlertView(@NotNull Context context) {
        this(context, (AttributeSet) null, 0, 0, 14, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public DSAlertView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 0, 12, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public DSAlertView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i11) {
        this(context, attributeSet, i11, 0, 8, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public DSAlertView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i11, int i12) {
        super(context, attributeSet, i11, i12);
        Intrinsics.checkNotNullParameter(context, "context");
        this._$_findViewCache = new LinkedHashMap();
        this.view = LayoutInflater.from(context).inflate(R.layout.view_ds_alert, this, true);
        this.withLeadingIcon = true;
        this.descriptor = "";
        DSAlertType dSAlertType = DSAlertType.INFO;
        this.type = dSAlertType;
        this.canDismiss = true;
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, R.styleable.DSAlertView, i11, i12);
        Intrinsics.checkNotNullExpressionValue(obtainStyledAttributes, "context.theme.obtainStyl…efStyleAttr, defStyleRes)");
        setTitle(obtainStyledAttributes.getString(R.styleable.DSAlertView_alertTitle));
        int i13 = R.styleable.DSAlertView_alertDescriptor;
        if (obtainStyledAttributes.hasValue(i13)) {
            String string = obtainStyledAttributes.getString(i13);
            Intrinsics.checkNotNull(string);
            setDescriptor(string);
            setWithLeadingIcon(obtainStyledAttributes.getBoolean(R.styleable.DSAlertView_withLeadingIcon, true));
            setType(DSAlertType.Companion.valueOf(obtainStyledAttributes.getInt(R.styleable.DSAlertView_alertType, dSAlertType.ordinal())));
            setCanDismiss(obtainStyledAttributes.getBoolean(R.styleable.DSAlertView_canDismiss, true));
            setFullDescriptor(obtainStyledAttributes.getBoolean(R.styleable.DSAlertView_isFullDescriptor, false));
            setAction(obtainStyledAttributes.getString(R.styleable.DSAlertView_actionText));
            obtainStyledAttributes.recycle();
            initViews();
            initListeners();
            return;
        }
        throw new IllegalStateException("Descriptor is required");
    }

    private final void handleCanDismiss() {
        int i11;
        AppCompatImageView appCompatImageView = (AppCompatImageView) this.view.findViewById(R.id.image_view_close_icon);
        Intrinsics.checkNotNullExpressionValue(appCompatImageView, "view.image_view_close_icon");
        if (this.canDismiss) {
            i11 = 0;
        } else {
            i11 = 8;
        }
        appCompatImageView.setVisibility(i11);
    }

    private final void handleIsFullDescriptor() {
        if (this.isFullDescriptor) {
            ((AppCompatTextView) this.view.findViewById(R.id.text_view_descriptor)).setMaxLines(Integer.MAX_VALUE);
        }
    }

    private final void hide() {
        if (!ViewCompat.isLaidOut(this) || isLayoutRequested()) {
            addOnLayoutChangeListener(new DSAlertView$hide$$inlined$doOnLayout$1(this));
            return;
        }
        ValueAnimator ofInt = ValueAnimator.ofInt(new int[]{getHeight(), 0});
        ofInt.setDuration(500);
        ofInt.addUpdateListener(new DSAlertView$hide$1$1(this));
        Intrinsics.checkNotNullExpressionValue(ofInt, "valueAnimator");
        ofInt.addListener(new DSAlertView$hide$lambda3$$inlined$doOnEnd$1(this));
        ofInt.start();
    }

    private final void initAction() {
        boolean z11;
        View view2 = this.view;
        int i11 = R.id.text_view_action;
        AppCompatTextView appCompatTextView = (AppCompatTextView) view2.findViewById(i11);
        Intrinsics.checkNotNullExpressionValue(appCompatTextView, "view.text_view_action");
        String str = this.action;
        int i12 = 0;
        if (str == null || str.length() == 0) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (z11) {
            i12 = 8;
        }
        appCompatTextView.setVisibility(i12);
        ((AppCompatTextView) this.view.findViewById(i11)).setText(this.action);
    }

    private final void initDescriptor() {
        ((AppCompatTextView) this.view.findViewById(R.id.text_view_descriptor)).setText(this.descriptor);
    }

    private final void initLeadingIcon() {
        int i11;
        AppCompatImageView appCompatImageView = (AppCompatImageView) this.view.findViewById(R.id.image_view_icon);
        Intrinsics.checkNotNullExpressionValue(appCompatImageView, "view.image_view_icon");
        if (this.withLeadingIcon) {
            i11 = 0;
        } else {
            i11 = 8;
        }
        appCompatImageView.setVisibility(i11);
    }

    private final void initListeners() {
        ((AppCompatImageView) this.view.findViewById(R.id.image_view_close_icon)).setOnClickListener(new b(this));
    }

    /* access modifiers changed from: private */
    /* renamed from: initListeners$lambda-1  reason: not valid java name */
    public static final void m5793initListeners$lambda1(DSAlertView dSAlertView, View view2) {
        Intrinsics.checkNotNullParameter(dSAlertView, "this$0");
        dSAlertView.animate().alpha(0.0f).setDuration(500).withEndAction(new a(dSAlertView)).start();
    }

    /* access modifiers changed from: private */
    /* renamed from: initListeners$lambda-1$lambda-0  reason: not valid java name */
    public static final void m5794initListeners$lambda1$lambda0(DSAlertView dSAlertView) {
        Intrinsics.checkNotNullParameter(dSAlertView, "this$0");
        dSAlertView.hide();
    }

    private final void initTitle() {
        boolean z11;
        View view2 = this.view;
        int i11 = R.id.text_view_title;
        AppCompatTextView appCompatTextView = (AppCompatTextView) view2.findViewById(i11);
        Intrinsics.checkNotNullExpressionValue(appCompatTextView, "view.text_view_title");
        String str = this.title;
        int i12 = 0;
        if (str == null || str.length() == 0) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (z11) {
            i12 = 8;
        }
        appCompatTextView.setVisibility(i12);
        ((AppCompatTextView) this.view.findViewById(i11)).setText(this.title);
    }

    private final void initType() {
        ((AppCompatImageView) this.view.findViewById(R.id.image_view_icon)).setImageResource(this.type.getIcon());
        ((ConstraintLayout) this.view.findViewById(R.id.root_view)).setBackgroundTintList(ColorStateList.valueOf(ContextCompat.getColor(getContext(), this.type.getColor())));
    }

    private final void initViews() {
        initTitle();
        initDescriptor();
        initType();
        initLeadingIcon();
        initAction();
    }

    public void _$_clearFindViewByIdCache() {
        this._$_findViewCache.clear();
    }

    @Nullable
    public View _$_findCachedViewById(int i11) {
        Map<Integer, View> map = this._$_findViewCache;
        View view2 = map.get(Integer.valueOf(i11));
        if (view2 != null) {
            return view2;
        }
        View findViewById = findViewById(i11);
        if (findViewById == null) {
            return null;
        }
        map.put(Integer.valueOf(i11), findViewById);
        return findViewById;
    }

    @Nullable
    public final String getAction() {
        return this.action;
    }

    @NotNull
    public final AppCompatTextView getActionText() {
        AppCompatTextView appCompatTextView = (AppCompatTextView) _$_findCachedViewById(R.id.text_view_action);
        Intrinsics.checkNotNullExpressionValue(appCompatTextView, "text_view_action");
        return appCompatTextView;
    }

    public final boolean getCanDismiss() {
        return this.canDismiss;
    }

    @NotNull
    public final String getDescriptor() {
        return this.descriptor;
    }

    @Nullable
    public final String getTitle() {
        return this.title;
    }

    @NotNull
    public final DSAlertType getType() {
        return this.type;
    }

    public final boolean getWithLeadingIcon() {
        return this.withLeadingIcon;
    }

    public final boolean isFullDescriptor() {
        return this.isFullDescriptor;
    }

    public final void setAction(@Nullable String str) {
        this.action = str;
        initAction();
    }

    public final void setCanDismiss(boolean z11) {
        this.canDismiss = z11;
        handleCanDismiss();
    }

    public final void setDescriptor(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "value");
        this.descriptor = str;
        initDescriptor();
    }

    public final void setFullDescriptor(boolean z11) {
        this.isFullDescriptor = z11;
        handleIsFullDescriptor();
    }

    public final void setTitle(@Nullable String str) {
        this.title = str;
        initTitle();
    }

    public final void setType(@NotNull DSAlertType dSAlertType) {
        Intrinsics.checkNotNullParameter(dSAlertType, "value");
        this.type = dSAlertType;
        initType();
    }

    public final void setWithLeadingIcon(boolean z11) {
        this.withLeadingIcon = z11;
        initLeadingIcon();
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ DSAlertView(Context context, AttributeSet attributeSet, int i11, int i12, int i13, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i13 & 2) != 0 ? null : attributeSet, (i13 & 4) != 0 ? 0 : i11, (i13 & 8) != 0 ? 0 : i12);
    }
}
