package com.facebook;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import androidx.activity.result.ActivityResultRegistryOwner;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import com.facebook.appevents.InternalAppEventsLogger;
import com.facebook.common.R;
import com.facebook.internal.FragmentWrapper;
import com.facebook.internal.instrument.crashshield.AutoHandleExceptions;
import k6.c;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\n\b'\u0018\u00002\u00020\u0001B9\b\u0004\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0002\u0010\fJ\u0012\u00100\u001a\u0002012\b\u00102\u001a\u0004\u0018\u000103H\u0014J*\u00104\u001a\u0002012\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H\u0014J\b\u00105\u001a\u00020\u0007H\u0016J\b\u00106\u001a\u00020\u0007H\u0016J\u0012\u00107\u001a\u0002012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\u0014J\u0012\u00108\u001a\u0002012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\u0014J\u0012\u00109\u001a\u00020\u00072\b\u0010:\u001a\u0004\u0018\u00010\nH\u0014J\b\u0010;\u001a\u000201H\u0014J\u0010\u0010<\u001a\u0002012\u0006\u0010=\u001a\u00020>H\u0014J*\u0010?\u001a\u0002012\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H\u0002J*\u0010@\u001a\u0002012\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H\u0003J*\u0010A\u001a\u0002012\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H\u0002J*\u0010B\u001a\u0002012\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H\u0002J\u000e\u0010C\u001a\u0002012\u0006\u0010\u001f\u001a\u00020%J\u000e\u0010C\u001a\u0002012\u0006\u0010\u001f\u001a\u00020 J\u0012\u0010D\u001a\u0002012\b\u0010E\u001a\u0004\u0018\u00010\u001eH\u0014J\u0012\u0010F\u001a\u0002012\b\u0010E\u001a\u0004\u0018\u00010\u001eH\u0016J\b\u0010G\u001a\u000201H\u0002R\u0014\u0010\r\u001a\u00020\u000e8TX\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010R\u0014\u0010\t\u001a\u00020\nX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0014\u0010\u000b\u001a\u00020\nX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0012R\u0013\u0010\u0014\u001a\u0004\u0018\u00010\u00158F¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017R\u0012\u0010\u0018\u001a\u00020\u0007X¤\u0004¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u001aR\u0014\u0010\u001b\u001a\u00020\u0007XD¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001aR\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u001eX\u000e¢\u0006\u0002\n\u0000R\u0013\u0010\u001f\u001a\u0004\u0018\u00010 8F¢\u0006\u0006\u001a\u0004\b!\u0010\"R\u0010\u0010#\u001a\u0004\u0018\u00010\u001eX\u000e¢\u0006\u0002\n\u0000R\u0013\u0010$\u001a\u0004\u0018\u00010%8F¢\u0006\u0006\u001a\u0004\b&\u0010'R\u000e\u0010(\u001a\u00020)X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010+\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010,\u001a\u0004\u0018\u00010-X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010.\u001a\u00020\u00078VX\u0004¢\u0006\u0006\u001a\u0004\b/\u0010\u001a¨\u0006H"}, d2 = {"Lcom/facebook/FacebookButtonBase;", "Landroid/widget/Button;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "defStyleRes", "analyticsButtonCreatedEventName", "", "analyticsButtonTappedEventName", "(Landroid/content/Context;Landroid/util/AttributeSet;IILjava/lang/String;Ljava/lang/String;)V", "activity", "Landroid/app/Activity;", "getActivity", "()Landroid/app/Activity;", "getAnalyticsButtonCreatedEventName", "()Ljava/lang/String;", "getAnalyticsButtonTappedEventName", "androidxActivityResultRegistryOwner", "Landroidx/activity/result/ActivityResultRegistryOwner;", "getAndroidxActivityResultRegistryOwner", "()Landroidx/activity/result/ActivityResultRegistryOwner;", "defaultRequestCode", "getDefaultRequestCode", "()I", "defaultStyleResource", "getDefaultStyleResource", "externalOnClickListener", "Landroid/view/View$OnClickListener;", "fragment", "Landroidx/fragment/app/Fragment;", "getFragment", "()Landroidx/fragment/app/Fragment;", "internalOnClickListener", "nativeFragment", "Landroid/app/Fragment;", "getNativeFragment", "()Landroid/app/Fragment;", "overrideCompoundPadding", "", "overrideCompoundPaddingLeft", "overrideCompoundPaddingRight", "parentFragment", "Lcom/facebook/internal/FragmentWrapper;", "requestCode", "getRequestCode", "callExternalOnClickListener", "", "v", "Landroid/view/View;", "configureButton", "getCompoundPaddingLeft", "getCompoundPaddingRight", "logButtonCreated", "logButtonTapped", "measureTextWidth", "text", "onAttachedToWindow", "onDraw", "canvas", "Landroid/graphics/Canvas;", "parseBackgroundAttributes", "parseCompoundDrawableAttributes", "parseContentAttributes", "parseTextAttributes", "setFragment", "setInternalOnClickListener", "l", "setOnClickListener", "setupOnClickListener", "facebook-common_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
@SuppressLint({"ResourceType"})
@AutoHandleExceptions
public abstract class FacebookButtonBase extends Button {
    @NotNull
    private final String analyticsButtonCreatedEventName;
    @NotNull
    private final String analyticsButtonTappedEventName;
    private final int defaultStyleResource;
    @Nullable
    private View.OnClickListener externalOnClickListener;
    @Nullable
    private View.OnClickListener internalOnClickListener;
    private boolean overrideCompoundPadding;
    private int overrideCompoundPaddingLeft;
    private int overrideCompoundPaddingRight;
    @Nullable
    private FragmentWrapper parentFragment;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FacebookButtonBase(@NotNull Context context, @Nullable AttributeSet attributeSet, int i11, int i12, @NotNull String str, @NotNull String str2) {
        super(context, attributeSet, 0);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(str, "analyticsButtonCreatedEventName");
        Intrinsics.checkNotNullParameter(str2, "analyticsButtonTappedEventName");
        i12 = i12 == 0 ? getDefaultStyleResource() : i12;
        configureButton(context, attributeSet, i11, i12 == 0 ? R.style.com_facebook_button : i12);
        this.analyticsButtonCreatedEventName = str;
        this.analyticsButtonTappedEventName = str2;
        setClickable(true);
        setFocusable(true);
    }

    private final void parseBackgroundAttributes(Context context, AttributeSet attributeSet, int i11, int i12) {
        if (!isInEditMode()) {
            TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, new int[]{16842964}, i11, i12);
            Intrinsics.checkNotNullExpressionValue(obtainStyledAttributes, "context.theme.obtainStyledAttributes(attrs, attrsResources, defStyleAttr, defStyleRes)");
            try {
                if (obtainStyledAttributes.hasValue(0)) {
                    int resourceId = obtainStyledAttributes.getResourceId(0, 0);
                    if (resourceId != 0) {
                        setBackgroundResource(resourceId);
                    } else {
                        setBackgroundColor(obtainStyledAttributes.getColor(0, 0));
                    }
                } else {
                    setBackgroundColor(ContextCompat.getColor(context, R.color.com_facebook_blue));
                }
            } finally {
                obtainStyledAttributes.recycle();
            }
        }
    }

    /* JADX INFO: finally extract failed */
    @SuppressLint({"ResourceType"})
    private final void parseCompoundDrawableAttributes(Context context, AttributeSet attributeSet, int i11, int i12) {
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, new int[]{16843119, 16843117, 16843120, 16843118, 16843121}, i11, i12);
        Intrinsics.checkNotNullExpressionValue(obtainStyledAttributes, "context.theme.obtainStyledAttributes(attrs, attrsResources, defStyleAttr, defStyleRes)");
        try {
            setCompoundDrawablesWithIntrinsicBounds(obtainStyledAttributes.getResourceId(0, 0), obtainStyledAttributes.getResourceId(1, 0), obtainStyledAttributes.getResourceId(2, 0), obtainStyledAttributes.getResourceId(3, 0));
            int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(4, 0);
            obtainStyledAttributes.recycle();
            setCompoundDrawablePadding(dimensionPixelSize);
        } catch (Throwable th2) {
            obtainStyledAttributes.recycle();
            throw th2;
        }
    }

    private final void parseContentAttributes(Context context, AttributeSet attributeSet, int i11, int i12) {
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, new int[]{16842966, 16842967, 16842968, 16842969}, i11, i12);
        Intrinsics.checkNotNullExpressionValue(obtainStyledAttributes, "context.theme.obtainStyledAttributes(attrs, attrsResources, defStyleAttr, defStyleRes)");
        try {
            setPadding(obtainStyledAttributes.getDimensionPixelSize(0, 0), obtainStyledAttributes.getDimensionPixelSize(1, 0), obtainStyledAttributes.getDimensionPixelSize(2, 0), obtainStyledAttributes.getDimensionPixelSize(3, 0));
        } finally {
            obtainStyledAttributes.recycle();
        }
    }

    /* JADX INFO: finally extract failed */
    private final void parseTextAttributes(Context context, AttributeSet attributeSet, int i11, int i12) {
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, new int[]{16842904}, i11, i12);
        Intrinsics.checkNotNullExpressionValue(obtainStyledAttributes, "context.theme.obtainStyledAttributes(attrs, colorResources, defStyleAttr, defStyleRes)");
        try {
            setTextColor(obtainStyledAttributes.getColorStateList(0));
            obtainStyledAttributes.recycle();
            TypedArray obtainStyledAttributes2 = context.getTheme().obtainStyledAttributes(attributeSet, new int[]{16842927}, i11, i12);
            Intrinsics.checkNotNullExpressionValue(obtainStyledAttributes2, "context.theme.obtainStyledAttributes(attrs, gravityResources, defStyleAttr, defStyleRes)");
            try {
                int i13 = obtainStyledAttributes2.getInt(0, 17);
                obtainStyledAttributes2.recycle();
                setGravity(i13);
                TypedArray obtainStyledAttributes3 = context.getTheme().obtainStyledAttributes(attributeSet, new int[]{16842901, 16842903, 16843087}, i11, i12);
                Intrinsics.checkNotNullExpressionValue(obtainStyledAttributes3, "context.theme.obtainStyledAttributes(attrs, attrsResources, defStyleAttr, defStyleRes)");
                try {
                    setTextSize(0, (float) obtainStyledAttributes3.getDimensionPixelSize(0, 0));
                    setTypeface(Typeface.create(getTypeface(), 1));
                    String string = obtainStyledAttributes3.getString(2);
                    obtainStyledAttributes3.recycle();
                    setText(string);
                } catch (Throwable th2) {
                    obtainStyledAttributes3.recycle();
                    throw th2;
                }
            } catch (Throwable th3) {
                obtainStyledAttributes2.recycle();
                throw th3;
            }
        } catch (Throwable th4) {
            obtainStyledAttributes.recycle();
            throw th4;
        }
    }

    private final void setupOnClickListener() {
        super.setOnClickListener(new c(this));
    }

    /* access modifiers changed from: private */
    /* renamed from: setupOnClickListener$lambda-0  reason: not valid java name */
    public static final void m8859setupOnClickListener$lambda0(FacebookButtonBase facebookButtonBase, View view) {
        Intrinsics.checkNotNullParameter(facebookButtonBase, "this$0");
        facebookButtonBase.logButtonTapped(facebookButtonBase.getContext());
        View.OnClickListener onClickListener = facebookButtonBase.internalOnClickListener;
        if (onClickListener != null) {
            onClickListener.onClick(view);
            return;
        }
        View.OnClickListener onClickListener2 = facebookButtonBase.externalOnClickListener;
        if (onClickListener2 != null) {
            onClickListener2.onClick(view);
        }
    }

    public void callExternalOnClickListener(@Nullable View view) {
        View.OnClickListener onClickListener = this.externalOnClickListener;
        if (onClickListener != null) {
            onClickListener.onClick(view);
        }
    }

    public void configureButton(@NotNull Context context, @Nullable AttributeSet attributeSet, int i11, int i12) {
        Intrinsics.checkNotNullParameter(context, "context");
        parseBackgroundAttributes(context, attributeSet, i11, i12);
        parseCompoundDrawableAttributes(context, attributeSet, i11, i12);
        parseContentAttributes(context, attributeSet, i11, i12);
        parseTextAttributes(context, attributeSet, i11, i12);
        setupOnClickListener();
    }

    /* JADX WARNING: Removed duplicated region for block: B:7:0x0015  */
    /* JADX WARNING: Removed duplicated region for block: B:9:0x0018  */
    @org.jetbrains.annotations.NotNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public android.app.Activity getActivity() {
        /*
            r3 = this;
            android.content.Context r0 = r3.getContext()
        L_0x0004:
            boolean r1 = r0 instanceof android.app.Activity
            if (r1 != 0) goto L_0x0013
            boolean r2 = r0 instanceof android.content.ContextWrapper
            if (r2 == 0) goto L_0x0013
            android.content.ContextWrapper r0 = (android.content.ContextWrapper) r0
            android.content.Context r0 = r0.getBaseContext()
            goto L_0x0004
        L_0x0013:
            if (r1 == 0) goto L_0x0018
            android.app.Activity r0 = (android.app.Activity) r0
            return r0
        L_0x0018:
            com.facebook.FacebookException r0 = new com.facebook.FacebookException
            java.lang.String r1 = "Unable to get Activity."
            r0.<init>((java.lang.String) r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.FacebookButtonBase.getActivity():android.app.Activity");
    }

    @NotNull
    public final String getAnalyticsButtonCreatedEventName() {
        return this.analyticsButtonCreatedEventName;
    }

    @NotNull
    public final String getAnalyticsButtonTappedEventName() {
        return this.analyticsButtonTappedEventName;
    }

    @Nullable
    public final ActivityResultRegistryOwner getAndroidxActivityResultRegistryOwner() {
        Activity activity = getActivity();
        if (activity instanceof ActivityResultRegistryOwner) {
            return (ActivityResultRegistryOwner) activity;
        }
        return null;
    }

    public int getCompoundPaddingLeft() {
        if (this.overrideCompoundPadding) {
            return this.overrideCompoundPaddingLeft;
        }
        return super.getCompoundPaddingLeft();
    }

    public int getCompoundPaddingRight() {
        if (this.overrideCompoundPadding) {
            return this.overrideCompoundPaddingRight;
        }
        return super.getCompoundPaddingRight();
    }

    public abstract int getDefaultRequestCode();

    public int getDefaultStyleResource() {
        return this.defaultStyleResource;
    }

    @Nullable
    public final Fragment getFragment() {
        FragmentWrapper fragmentWrapper = this.parentFragment;
        if (fragmentWrapper == null) {
            return null;
        }
        return fragmentWrapper.getSupportFragment();
    }

    @Nullable
    public final android.app.Fragment getNativeFragment() {
        FragmentWrapper fragmentWrapper = this.parentFragment;
        if (fragmentWrapper == null) {
            return null;
        }
        return fragmentWrapper.getNativeFragment();
    }

    public int getRequestCode() {
        return getDefaultRequestCode();
    }

    public void logButtonCreated(@Nullable Context context) {
        InternalAppEventsLogger.Companion.createInstance(context, (String) null).logEventImplicitly(this.analyticsButtonCreatedEventName);
    }

    public void logButtonTapped(@Nullable Context context) {
        InternalAppEventsLogger.Companion.createInstance(context, (String) null).logEventImplicitly(this.analyticsButtonTappedEventName);
    }

    public int measureTextWidth(@Nullable String str) {
        return (int) Math.ceil((double) getPaint().measureText(str));
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (!isInEditMode()) {
            logButtonCreated(getContext());
        }
    }

    public void onDraw(@NotNull Canvas canvas) {
        boolean z11;
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        if ((getGravity() & 1) != 0) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (z11) {
            int compoundPaddingLeft = getCompoundPaddingLeft();
            int compoundPaddingRight = getCompoundPaddingRight();
            int min = Math.min((((getWidth() - (getCompoundDrawablePadding() + compoundPaddingLeft)) - compoundPaddingRight) - measureTextWidth(getText().toString())) / 2, (compoundPaddingLeft - getPaddingLeft()) / 2);
            this.overrideCompoundPaddingLeft = compoundPaddingLeft - min;
            this.overrideCompoundPaddingRight = compoundPaddingRight + min;
            this.overrideCompoundPadding = true;
        }
        super.onDraw(canvas);
        this.overrideCompoundPadding = false;
    }

    public final void setFragment(@NotNull android.app.Fragment fragment) {
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        this.parentFragment = new FragmentWrapper(fragment);
    }

    public void setInternalOnClickListener(@Nullable View.OnClickListener onClickListener) {
        this.internalOnClickListener = onClickListener;
    }

    public void setOnClickListener(@Nullable View.OnClickListener onClickListener) {
        this.externalOnClickListener = onClickListener;
    }

    public final void setFragment(@NotNull Fragment fragment) {
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        this.parentFragment = new FragmentWrapper(fragment);
    }
}
