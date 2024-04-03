package com.designsystem.ds_header;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.exifinterface.media.ExifInterface;
import c6.a;
import c6.b;
import c6.c;
import c6.d;
import com.designsystem.marshmallow.R;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001:\u000234B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u001c\u0010\"\u001a\u00020\u000b2\u0006\u0010#\u001a\u00020\u00072\f\u0010$\u001a\b\u0012\u0004\u0012\u00020\u000b0\nJ\u001c\u0010%\u001a\u00020\u000b2\u0006\u0010&\u001a\u00020\u00112\f\u0010$\u001a\b\u0012\u0004\u0012\u00020\u000b0\nJ\u0016\u0010'\u001a\u00020\u000b2\u0006\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020+J\u0010\u0010,\u001a\u00020\u000b2\u0006\u0010-\u001a\u00020\u0011H\u0002J\b\u0010.\u001a\u00020\u000bH\u0002J\u0010\u0010/\u001a\u00020\u000b2\u0006\u0010-\u001a\u00020\u0011H\u0002J\b\u00100\u001a\u00020\u000bH\u0002J\u0010\u00101\u001a\u00020\u000b2\u0006\u0010-\u001a\u000202H\u0002R \u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nX.¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR$\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0010\u001a\u00020\u00118F@FX\u000e¢\u0006\f\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R$\u0010\u0017\u001a\u00020\u00112\u0006\u0010\u0010\u001a\u00020\u00118F@FX\u000e¢\u0006\f\u001a\u0004\b\u0018\u0010\u0014\"\u0004\b\u0019\u0010\u0016R\u000e\u0010\u001a\u001a\u00020\u0011X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0011X\u000e¢\u0006\u0002\n\u0000R$\u0010\u001c\u001a\u00020\u00112\u0006\u0010\u0010\u001a\u00020\u00118F@FX\u000e¢\u0006\f\u001a\u0004\b\u001d\u0010\u0014\"\u0004\b\u001e\u0010\u0016R$\u0010\u001f\u001a\u00020\u00112\u0006\u0010\u0010\u001a\u00020\u00118F@FX\u000e¢\u0006\f\u001a\u0004\b \u0010\u0014\"\u0004\b!\u0010\u0016¨\u00065"}, d2 = {"Lcom/designsystem/ds_header/DSHeaderView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "closeButtonCallback", "Lkotlin/Function0;", "", "getCloseButtonCallback", "()Lkotlin/jvm/functions/Function0;", "setCloseButtonCallback", "(Lkotlin/jvm/functions/Function0;)V", "value", "", "closeType", "getCloseType", "()Ljava/lang/String;", "setCloseType", "(Ljava/lang/String;)V", "headerType", "getHeaderType", "setHeaderType", "localCloseType", "localHeaderType", "subTitle", "getSubTitle", "setSubTitle", "title", "getTitle", "setTitle", "addActionImage", "image", "onClick", "addActionText", "text", "setAnimatedTitle", "scrollView", "Landroid/widget/ScrollView;", "textView", "Landroid/widget/TextView;", "setupCloseButton", "type", "setupCloseButtonClickListener", "setupHeaderType", "setupViewsVisibility", "updateHeaderBackground", "Lcom/designsystem/ds_header/DSHeaderView$HeaderType;", "CloseType", "HeaderType", "marshmallow_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
@Deprecated(message = "This component is no longer part of the Design System. It should be created on demand from other DS components")
public final class DSHeaderView extends ConstraintLayout {
    public static final int $stable = 8;
    public Function0<Unit> closeButtonCallback;
    @NotNull
    private String localCloseType;
    @NotNull
    private String localHeaderType;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/designsystem/ds_header/DSHeaderView$CloseType;", "", "value", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "CLOSE", "BACK", "NONE", "marshmallow_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public enum CloseType {
        CLOSE("0"),
        BACK("1"),
        NONE(ExifInterface.GPS_MEASUREMENT_2D);
        
        @NotNull
        private final String value;

        private CloseType(String str) {
            this.value = str;
        }

        @NotNull
        public final String getValue() {
            return this.value;
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/designsystem/ds_header/DSHeaderView$HeaderType;", "", "value", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "SOLID", "TRANSPARENT", "marshmallow_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public enum HeaderType {
        SOLID("0"),
        TRANSPARENT("1");
        
        @NotNull
        private final String value;

        private HeaderType(String str) {
            this.value = str;
        }

        @NotNull
        public final String getValue() {
            return this.value;
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public DSHeaderView(@NotNull Context context) {
        this(context, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public DSHeaderView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ DSHeaderView(Context context, AttributeSet attributeSet, int i11, int i12, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i12 & 2) != 0 ? null : attributeSet, (i12 & 4) != 0 ? 0 : i11);
    }

    /* access modifiers changed from: private */
    /* renamed from: addActionImage$lambda-2  reason: not valid java name */
    public static final void m8350addActionImage$lambda2(Function0 function0, View view) {
        Intrinsics.checkNotNullParameter(function0, "$onClick");
        function0.invoke();
    }

    /* access modifiers changed from: private */
    /* renamed from: addActionText$lambda-3  reason: not valid java name */
    public static final void m8351addActionText$lambda3(Function0 function0, View view) {
        Intrinsics.checkNotNullParameter(function0, "$onClick");
        function0.invoke();
    }

    /* access modifiers changed from: private */
    /* renamed from: setAnimatedTitle$lambda-4  reason: not valid java name */
    public static final void m8352setAnimatedTitle$lambda4(TextView textView, DSHeaderView dSHeaderView) {
        Intrinsics.checkNotNullParameter(textView, "$textView");
        Intrinsics.checkNotNullParameter(dSHeaderView, "this$0");
        Rect rect = new Rect();
        textView.getGlobalVisibleRect(rect);
        boolean z11 = false;
        if (rect.top <= 250) {
            int i11 = R.id.titleTextView;
            if (((TextView) dSHeaderView.findViewById(i11)).getAlpha() == 1.0f) {
                z11 = true;
            }
            if (!z11) {
                ((TextView) dSHeaderView.findViewById(i11)).startAnimation(AnimationUtils.loadAnimation(dSHeaderView.getContext(), R.anim.fade_in));
                ((TextView) dSHeaderView.findViewById(i11)).setAlpha(1.0f);
                dSHeaderView.updateHeaderBackground(HeaderType.SOLID);
                textView.setVisibility(4);
                return;
            }
            return;
        }
        ((TextView) dSHeaderView.findViewById(R.id.titleTextView)).setAlpha(0.0f);
        dSHeaderView.updateHeaderBackground(HeaderType.TRANSPARENT);
        textView.setVisibility(0);
    }

    private final void setupCloseButton(String str) {
        int i11;
        if (!Intrinsics.areEqual((Object) str, (Object) CloseType.NONE.getValue())) {
            if (Intrinsics.areEqual((Object) str, (Object) CloseType.CLOSE.getValue())) {
                i11 = R.drawable.ds_close;
            } else if (Intrinsics.areEqual((Object) str, (Object) CloseType.BACK.getValue())) {
                i11 = R.drawable.ds_arrow_back;
            } else {
                i11 = 0;
            }
            ((ImageView) findViewById(R.id.closeButton)).setImageResource(i11);
        }
    }

    private final void setupCloseButtonClickListener() {
        setCloseButtonCallback(DSHeaderView$setupCloseButtonClickListener$1.INSTANCE);
        ((ImageView) findViewById(R.id.closeButton)).setOnClickListener(new c(this));
    }

    /* access modifiers changed from: private */
    /* renamed from: setupCloseButtonClickListener$lambda-1  reason: not valid java name */
    public static final void m8353setupCloseButtonClickListener$lambda1(DSHeaderView dSHeaderView, View view) {
        Intrinsics.checkNotNullParameter(dSHeaderView, "this$0");
        dSHeaderView.getCloseButtonCallback().invoke();
    }

    private final void setupHeaderType(String str) {
        if (Intrinsics.areEqual((Object) str, (Object) HeaderType.SOLID.getValue())) {
            setBackgroundColor(ContextCompat.getColor(getContext(), R.color.ds_neutral_white));
        } else {
            setBackgroundColor(ContextCompat.getColor(getContext(), 17170445));
        }
    }

    private final void setupViewsVisibility() {
        if (!StringsKt__StringsJVMKt.isBlank(getTitle())) {
            ((TextView) findViewById(R.id.titleTextView)).setVisibility(0);
        } else {
            ((TextView) findViewById(R.id.titleTextView)).setVisibility(8);
        }
        if (!StringsKt__StringsJVMKt.isBlank(getSubTitle())) {
            ((TextView) findViewById(R.id.subTitleTextView)).setVisibility(0);
        } else {
            ((TextView) findViewById(R.id.subTitleTextView)).setVisibility(8);
        }
        if (!Intrinsics.areEqual((Object) getCloseType(), (Object) CloseType.NONE.getValue())) {
            ((ImageView) findViewById(R.id.closeButton)).setVisibility(0);
        } else {
            ((ImageView) findViewById(R.id.closeButton)).setVisibility(8);
        }
    }

    private final void updateHeaderBackground(HeaderType headerType) {
        if (!Intrinsics.areEqual((Object) getHeaderType(), (Object) HeaderType.TRANSPARENT.getValue())) {
            return;
        }
        if (headerType == HeaderType.SOLID) {
            setBackgroundColor(ContextCompat.getColor(getContext(), R.color.ds_neutral_white));
        } else {
            setBackgroundColor(ContextCompat.getColor(getContext(), 17170445));
        }
    }

    public void _$_clearFindViewByIdCache() {
    }

    public final void addActionImage(int i11, @NotNull Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(function0, "onClick");
        Resources resources = getResources();
        int i12 = R.dimen.ds_xxl;
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams((int) resources.getDimension(i12), (int) getResources().getDimension(i12));
        layoutParams.setMarginEnd((int) getResources().getDimension(R.dimen.ds_xxs));
        ImageView imageView = new ImageView(getContext());
        imageView.setImageResource(i11);
        imageView.setBackgroundResource(R.drawable.ds_header_icon_background);
        imageView.setScaleType(ImageView.ScaleType.CENTER);
        imageView.setLayoutParams(layoutParams);
        ((LinearLayout) findViewById(R.id.actionsLayout)).addView(imageView);
        imageView.setOnClickListener(new a(function0));
    }

    public final void addActionText(@NotNull String str, @NotNull Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(str, "text");
        Intrinsics.checkNotNullParameter(function0, "onClick");
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -1);
        layoutParams.setMarginEnd((int) getResources().getDimension(R.dimen.ds_xxs));
        TextView textView = new TextView(getContext());
        textView.setTextAppearance(R.style.DSTextAppearance_Button);
        textView.setGravity(17);
        textView.setTextColor(ContextCompat.getColor(getContext(), R.color.ds_primary_100));
        textView.setText(str);
        textView.setLayoutParams(layoutParams);
        ((LinearLayout) findViewById(R.id.actionsLayout)).addView(textView);
        textView.setOnClickListener(new d(function0));
    }

    @NotNull
    public final Function0<Unit> getCloseButtonCallback() {
        Function0<Unit> function0 = this.closeButtonCallback;
        if (function0 != null) {
            return function0;
        }
        Intrinsics.throwUninitializedPropertyAccessException("closeButtonCallback");
        return null;
    }

    @NotNull
    public final String getCloseType() {
        return this.localCloseType;
    }

    @NotNull
    public final String getHeaderType() {
        return this.localHeaderType;
    }

    @NotNull
    public final String getSubTitle() {
        return ((TextView) findViewById(R.id.subTitleTextView)).getText().toString();
    }

    @NotNull
    public final String getTitle() {
        return ((TextView) findViewById(R.id.titleTextView)).getText().toString();
    }

    public final void setAnimatedTitle(@NotNull ScrollView scrollView, @NotNull TextView textView) {
        Intrinsics.checkNotNullParameter(scrollView, "scrollView");
        Intrinsics.checkNotNullParameter(textView, "textView");
        int i11 = R.id.titleTextView;
        ((TextView) findViewById(i11)).setText(textView.getText().toString());
        ((TextView) findViewById(i11)).setVisibility(0);
        ((TextView) findViewById(i11)).setAlpha(0.0f);
        scrollView.getViewTreeObserver().addOnScrollChangedListener(new b(textView, this));
    }

    public final void setCloseButtonCallback(@NotNull Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(function0, "<set-?>");
        this.closeButtonCallback = function0;
    }

    public final void setCloseType(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "value");
        this.localCloseType = str;
        setupCloseButton(str);
        setupViewsVisibility();
    }

    public final void setHeaderType(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "value");
        this.localHeaderType = str;
        setupHeaderType(str);
        setupViewsVisibility();
    }

    public final void setSubTitle(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "value");
        ((TextView) findViewById(R.id.subTitleTextView)).setText(str);
        setupViewsVisibility();
    }

    public final void setTitle(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "value");
        ((TextView) findViewById(R.id.titleTextView)).setText(str);
        setupViewsVisibility();
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public DSHeaderView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        Intrinsics.checkNotNullParameter(context, "context");
        HeaderType headerType = HeaderType.SOLID;
        this.localHeaderType = headerType.getValue();
        CloseType closeType = CloseType.NONE;
        this.localCloseType = closeType.getValue();
        LayoutInflater.from(context).inflate(R.layout.ds_header_view, this, true);
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.DSHeaderView, 0, 0);
            Intrinsics.checkNotNullExpressionValue(obtainStyledAttributes, "context.obtainStyledAttr…eable.DSHeaderView, 0, 0)");
            String string = obtainStyledAttributes.getString(R.styleable.DSHeaderView_header_type);
            setHeaderType(string == null ? headerType.getValue() : string);
            String string2 = obtainStyledAttributes.getString(R.styleable.DSHeaderView_header_close_type);
            setCloseType(string2 == null ? closeType.getValue() : string2);
            String string3 = obtainStyledAttributes.getString(R.styleable.DSHeaderView_header_title);
            String str = "";
            setTitle(string3 == null ? str : string3);
            String string4 = obtainStyledAttributes.getString(R.styleable.DSHeaderView_header_subtitle);
            setSubTitle(string4 != null ? string4 : str);
            setupViewsVisibility();
            setupCloseButtonClickListener();
            obtainStyledAttributes.recycle();
        }
    }
}
