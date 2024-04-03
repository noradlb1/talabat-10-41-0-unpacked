package com.facebook.login.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import c7.g;
import com.facebook.AccessToken;
import com.facebook.FacebookException;
import com.facebook.LoggingBehavior;
import com.facebook.Profile;
import com.facebook.ProfileTracker;
import com.facebook.internal.ImageDownloader;
import com.facebook.internal.ImageRequest;
import com.facebook.internal.ImageResponse;
import com.facebook.internal.Logger;
import com.facebook.internal.instrument.crashshield.AutoHandleExceptions;
import com.facebook.login.R;
import com.instabug.library.internal.storage.cache.UserAttributesCacheManager;
import com.newrelic.agent.android.instrumentation.BitmapFactoryInstrumentation;
import com.newrelic.agent.android.instrumentation.Instrumented;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Instrumented
@Metadata(d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u0000 T2\u00020\u0001:\u0002TUB\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u0017\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007B\u001f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u0010\u00100\u001a\u00020\t2\u0006\u00101\u001a\u00020\u0011H\u0003J\u0010\u00102\u001a\u0002032\u0006\u00104\u001a\u00020#H\u0002J\b\u00105\u001a\u000206H\u0003J\b\u00107\u001a\u00020\u0011H\u0002J\b\u00108\u001a\u000206H\u0014J0\u00109\u001a\u0002062\u0006\u0010:\u001a\u00020\u00112\u0006\u0010;\u001a\u00020\t2\u0006\u0010<\u001a\u00020\t2\u0006\u0010=\u001a\u00020\t2\u0006\u0010>\u001a\u00020\tH\u0014J\u0018\u0010?\u001a\u0002062\u0006\u0010@\u001a\u00020\t2\u0006\u0010A\u001a\u00020\tH\u0014J\u0010\u0010B\u001a\u0002062\u0006\u0010C\u001a\u00020DH\u0014J\b\u0010E\u001a\u00020DH\u0014J\u0010\u0010F\u001a\u0002062\u0006\u0010\u0005\u001a\u00020\u0006H\u0003J\u0012\u0010G\u001a\u0002062\b\u0010H\u001a\u0004\u0018\u00010IH\u0003J\u0010\u0010J\u001a\u0002062\u0006\u0010K\u001a\u00020\u0011H\u0003J\u0010\u0010L\u001a\u0002062\u0006\u0010M\u001a\u00020\u0011H\u0003J\b\u0010N\u001a\u000206H\u0003J\u0010\u0010O\u001a\u0002062\b\u0010P\u001a\u0004\u0018\u00010\fJ\u0012\u0010Q\u001a\u0002062\b\u0010R\u001a\u0004\u0018\u00010\fH\u0003J\b\u0010S\u001a\u00020\u0011H\u0003R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u0002\n\u0000R$\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0010\u001a\u00020\u0011@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR$\u0010\u001e\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\t@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R(\u0010$\u001a\u0004\u0018\u00010#2\b\u0010\u0010\u001a\u0004\u0018\u00010#@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R\u0010\u0010)\u001a\u0004\u0018\u00010*X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010+\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010,\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R$\u0010-\u001a\u00020\u00112\u0006\u0010\u0010\u001a\u00020\u00118F@FX\u000e¢\u0006\f\u001a\u0004\b.\u0010\u0013\"\u0004\b/\u0010\u0015¨\u0006V"}, d2 = {"Lcom/facebook/login/widget/ProfilePictureView;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyle", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "customizedDefaultProfilePicture", "Landroid/graphics/Bitmap;", "image", "Landroid/widget/ImageView;", "imageContents", "value", "", "isCropped", "()Z", "setCropped", "(Z)V", "lastRequest", "Lcom/facebook/internal/ImageRequest;", "onErrorListener", "Lcom/facebook/login/widget/ProfilePictureView$OnErrorListener;", "getOnErrorListener", "()Lcom/facebook/login/widget/ProfilePictureView$OnErrorListener;", "setOnErrorListener", "(Lcom/facebook/login/widget/ProfilePictureView$OnErrorListener;)V", "presetSize", "getPresetSize", "()I", "setPresetSize", "(I)V", "", "profileId", "getProfileId", "()Ljava/lang/String;", "setProfileId", "(Ljava/lang/String;)V", "profileTracker", "Lcom/facebook/ProfileTracker;", "queryHeight", "queryWidth", "shouldUpdateOnProfileChange", "getShouldUpdateOnProfileChange", "setShouldUpdateOnProfileChange", "getPresetSizeInPixels", "forcePreset", "getProfilePictureUri", "Landroid/net/Uri;", "accessToken", "initialize", "", "isUnspecifiedDimensions", "onDetachedFromWindow", "onLayout", "changed", "left", "top", "right", "bottom", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "onRestoreInstanceState", "state", "Landroid/os/Parcelable;", "onSaveInstanceState", "parseAttributes", "processResponse", "response", "Lcom/facebook/internal/ImageResponse;", "refreshImage", "force", "sendImageRequest", "allowCachedResponse", "setBlankProfilePicture", "setDefaultProfilePicture", "inputBitmap", "setImageBitmap", "imageBitmap", "updateImageQueryParameters", "Companion", "OnErrorListener", "facebook-login_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class ProfilePictureView extends FrameLayout {
    @NotNull
    private static final String BITMAP_HEIGHT_KEY = "ProfilePictureView_height";
    @NotNull
    private static final String BITMAP_KEY = "ProfilePictureView_bitmap";
    @NotNull
    private static final String BITMAP_WIDTH_KEY = "ProfilePictureView_width";
    public static final int CUSTOM = -1;
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final boolean IS_CROPPED_DEFAULT_VALUE = true;
    @NotNull
    private static final String IS_CROPPED_KEY = "ProfilePictureView_isCropped";
    public static final int LARGE = -4;
    private static final int MIN_SIZE = 1;
    public static final int NORMAL = -3;
    @NotNull
    private static final String PENDING_REFRESH_KEY = "ProfilePictureView_refresh";
    @NotNull
    private static final String PRESET_SIZE_KEY = "ProfilePictureView_presetSize";
    @NotNull
    private static final String PROFILE_ID_KEY = "ProfilePictureView_profileId";
    public static final int SMALL = -2;
    @NotNull
    private static final String SUPER_STATE_KEY = "ProfilePictureView_superState";
    /* access modifiers changed from: private */
    @NotNull
    public static final String TAG;
    @Nullable
    private Bitmap customizedDefaultProfilePicture;
    @NotNull
    private final ImageView image = new ImageView(getContext());
    @Nullable
    private Bitmap imageContents;
    private boolean isCropped = true;
    @Nullable
    private ImageRequest lastRequest;
    @Nullable
    private OnErrorListener onErrorListener;
    private int presetSize = -1;
    @Nullable
    private String profileId;
    @Nullable
    private ProfileTracker profileTracker;
    private int queryHeight;
    private int queryWidth;

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\r\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bXT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nXT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\bXT¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\bXT¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\bXT¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\bXT¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u0011\u0010\u0014\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016¨\u0006\u0017"}, d2 = {"Lcom/facebook/login/widget/ProfilePictureView$Companion;", "", "()V", "BITMAP_HEIGHT_KEY", "", "BITMAP_KEY", "BITMAP_WIDTH_KEY", "CUSTOM", "", "IS_CROPPED_DEFAULT_VALUE", "", "IS_CROPPED_KEY", "LARGE", "MIN_SIZE", "NORMAL", "PENDING_REFRESH_KEY", "PRESET_SIZE_KEY", "PROFILE_ID_KEY", "SMALL", "SUPER_STATE_KEY", "TAG", "getTAG", "()Ljava/lang/String;", "facebook-login_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final String getTAG() {
            return ProfilePictureView.TAG;
        }
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, d2 = {"Lcom/facebook/login/widget/ProfilePictureView$OnErrorListener;", "", "onError", "", "error", "Lcom/facebook/FacebookException;", "facebook-login_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public interface OnErrorListener {
        void onError(@NotNull FacebookException facebookException);
    }

    static {
        String simpleName = ProfilePictureView.class.getSimpleName();
        Intrinsics.checkNotNullExpressionValue(simpleName, "ProfilePictureView::class.java.simpleName");
        TAG = simpleName;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ProfilePictureView(@NotNull Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        initialize();
    }

    @AutoHandleExceptions
    private final int getPresetSizeInPixels(boolean z11) {
        int i11;
        int i12 = this.presetSize;
        if (i12 == -1 && !z11) {
            return 0;
        }
        if (i12 == -4) {
            i11 = R.dimen.com_facebook_profilepictureview_preset_size_large;
        } else if (i12 == -3) {
            i11 = R.dimen.com_facebook_profilepictureview_preset_size_normal;
        } else if (i12 == -2) {
            i11 = R.dimen.com_facebook_profilepictureview_preset_size_small;
        } else if (i12 != -1) {
            return 0;
        } else {
            i11 = R.dimen.com_facebook_profilepictureview_preset_size_normal;
        }
        return getResources().getDimensionPixelSize(i11);
    }

    private final Uri getProfilePictureUri(String str) {
        Profile currentProfile = Profile.Companion.getCurrentProfile();
        if (currentProfile == null || !AccessToken.Companion.isLoggedInWithInstagram()) {
            return ImageRequest.Companion.getProfilePictureUri(this.profileId, this.queryWidth, this.queryHeight, str);
        }
        return currentProfile.getProfilePictureUri(this.queryWidth, this.queryHeight);
    }

    @AutoHandleExceptions
    private final void initialize() {
        removeAllViews();
        this.image.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        this.image.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        addView(this.image);
        this.profileTracker = new ProfilePictureView$initialize$1(this);
    }

    private final boolean isUnspecifiedDimensions() {
        if (this.queryWidth == 0 && this.queryHeight == 0) {
            return true;
        }
        return false;
    }

    @AutoHandleExceptions
    private final void parseAttributes(AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.com_facebook_profile_picture_view);
        Intrinsics.checkNotNullExpressionValue(obtainStyledAttributes, "context.obtainStyledAttributes(attrs, R.styleable.com_facebook_profile_picture_view)");
        setPresetSize(obtainStyledAttributes.getInt(R.styleable.com_facebook_profile_picture_view_com_facebook_preset_size, -1));
        setCropped(obtainStyledAttributes.getBoolean(R.styleable.com_facebook_profile_picture_view_com_facebook_is_cropped, true));
        obtainStyledAttributes.recycle();
    }

    @AutoHandleExceptions
    private final void processResponse(ImageResponse imageResponse) {
        if (imageResponse != null && Intrinsics.areEqual((Object) imageResponse.getRequest(), (Object) this.lastRequest)) {
            this.lastRequest = null;
            Bitmap bitmap = imageResponse.getBitmap();
            Exception error = imageResponse.getError();
            if (error != null) {
                OnErrorListener onErrorListener2 = this.onErrorListener;
                if (onErrorListener2 != null) {
                    onErrorListener2.onError(new FacebookException(Intrinsics.stringPlus("Error in downloading profile picture for profileId: ", this.profileId), (Throwable) error));
                } else {
                    Logger.Companion.log(LoggingBehavior.REQUESTS, 6, TAG, error.toString());
                }
            } else if (bitmap != null) {
                setImageBitmap(bitmap);
                if (imageResponse.isCachedRedirect()) {
                    sendImageRequest(false);
                }
            }
        }
    }

    /* access modifiers changed from: private */
    @AutoHandleExceptions
    public final void refreshImage(boolean z11) {
        boolean z12;
        boolean updateImageQueryParameters = updateImageQueryParameters();
        String str = this.profileId;
        if (str != null) {
            if (str.length() == 0) {
                z12 = true;
            } else {
                z12 = false;
            }
            if (!z12 && !isUnspecifiedDimensions()) {
                if (updateImageQueryParameters || z11) {
                    sendImageRequest(true);
                    return;
                }
                return;
            }
        }
        setBlankProfilePicture();
    }

    @AutoHandleExceptions
    private final void sendImageRequest(boolean z11) {
        AccessToken currentAccessToken;
        String token;
        AccessToken.Companion companion = AccessToken.Companion;
        String str = "";
        if (!(!companion.isCurrentAccessTokenActive() || (currentAccessToken = companion.getCurrentAccessToken()) == null || (token = currentAccessToken.getToken()) == null)) {
            str = token;
        }
        Uri profilePictureUri = getProfilePictureUri(str);
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        ImageRequest build = new ImageRequest.Builder(context, profilePictureUri).setAllowCachedRedirects(z11).setCallerTag(this).setCallback(new g(this)).build();
        ImageRequest imageRequest = this.lastRequest;
        if (imageRequest != null) {
            ImageDownloader.cancelRequest(imageRequest);
        }
        this.lastRequest = build;
        ImageDownloader.downloadAsync(build);
    }

    /* access modifiers changed from: private */
    /* renamed from: sendImageRequest$lambda-2  reason: not valid java name */
    public static final void m9008sendImageRequest$lambda2(ProfilePictureView profilePictureView, ImageResponse imageResponse) {
        Intrinsics.checkNotNullParameter(profilePictureView, "this$0");
        profilePictureView.processResponse(imageResponse);
    }

    @AutoHandleExceptions
    private final void setBlankProfilePicture() {
        int i11;
        ImageRequest imageRequest = this.lastRequest;
        if (imageRequest != null) {
            ImageDownloader.cancelRequest(imageRequest);
        }
        Bitmap bitmap = this.customizedDefaultProfilePicture;
        if (bitmap == null) {
            if (this.isCropped) {
                i11 = R.drawable.com_facebook_profile_picture_blank_square;
            } else {
                i11 = R.drawable.com_facebook_profile_picture_blank_portrait;
            }
            setImageBitmap(BitmapFactoryInstrumentation.decodeResource(getResources(), i11));
            return;
        }
        updateImageQueryParameters();
        setImageBitmap(Bitmap.createScaledBitmap(bitmap, this.queryWidth, this.queryHeight, false));
    }

    @AutoHandleExceptions
    private final void setImageBitmap(Bitmap bitmap) {
        if (bitmap != null) {
            this.imageContents = bitmap;
            this.image.setImageBitmap(bitmap);
        }
    }

    @AutoHandleExceptions
    private final boolean updateImageQueryParameters() {
        int height = getHeight();
        int width = getWidth();
        boolean z11 = false;
        if (width >= 1 && height >= 1) {
            int presetSizeInPixels = getPresetSizeInPixels(false);
            if (presetSizeInPixels != 0) {
                height = presetSizeInPixels;
                width = height;
            }
            if (width <= height) {
                if (this.isCropped) {
                    height = width;
                } else {
                    height = 0;
                }
            } else if (this.isCropped) {
                width = height;
            } else {
                width = 0;
            }
            if (!(width == this.queryWidth && height == this.queryHeight)) {
                z11 = true;
            }
            this.queryWidth = width;
            this.queryHeight = height;
        }
        return z11;
    }

    @Nullable
    public final OnErrorListener getOnErrorListener() {
        return this.onErrorListener;
    }

    public final int getPresetSize() {
        return this.presetSize;
    }

    @Nullable
    public final String getProfileId() {
        return this.profileId;
    }

    public final boolean getShouldUpdateOnProfileChange() {
        ProfileTracker profileTracker2 = this.profileTracker;
        if (profileTracker2 == null) {
            return false;
        }
        return profileTracker2.isTracking();
    }

    public final boolean isCropped() {
        return this.isCropped;
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.lastRequest = null;
    }

    public void onLayout(boolean z11, int i11, int i12, int i13, int i14) {
        super.onLayout(z11, i11, i12, i13, i14);
        refreshImage(false);
    }

    public void onMeasure(int i11, int i12) {
        boolean z11;
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        int size = View.MeasureSpec.getSize(i12);
        int size2 = View.MeasureSpec.getSize(i11);
        boolean z12 = true;
        if (View.MeasureSpec.getMode(i12) == 1073741824 || layoutParams.height != -2) {
            z11 = false;
        } else {
            size = getPresetSizeInPixels(true);
            i12 = View.MeasureSpec.makeMeasureSpec(size, 1073741824);
            z11 = true;
        }
        if (View.MeasureSpec.getMode(i11) == 1073741824 || layoutParams.width != -2) {
            z12 = z11;
        } else {
            size2 = getPresetSizeInPixels(true);
            i11 = View.MeasureSpec.makeMeasureSpec(size2, 1073741824);
        }
        if (z12) {
            setMeasuredDimension(size2, size);
            measureChildren(i11, i12);
            return;
        }
        super.onMeasure(i11, i12);
    }

    public void onRestoreInstanceState(@NotNull Parcelable parcelable) {
        Intrinsics.checkNotNullParameter(parcelable, "state");
        if (!Intrinsics.areEqual((Object) parcelable.getClass(), (Object) Bundle.class)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        Bundle bundle = (Bundle) parcelable;
        super.onRestoreInstanceState(bundle.getParcelable(SUPER_STATE_KEY));
        setProfileId(bundle.getString(PROFILE_ID_KEY));
        setPresetSize(bundle.getInt(PRESET_SIZE_KEY));
        setCropped(bundle.getBoolean(IS_CROPPED_KEY));
        this.queryWidth = bundle.getInt(BITMAP_WIDTH_KEY);
        this.queryHeight = bundle.getInt(BITMAP_HEIGHT_KEY);
        refreshImage(true);
    }

    @NotNull
    public Parcelable onSaveInstanceState() {
        boolean z11;
        Parcelable onSaveInstanceState = super.onSaveInstanceState();
        Bundle bundle = new Bundle();
        bundle.putParcelable(SUPER_STATE_KEY, onSaveInstanceState);
        bundle.putString(PROFILE_ID_KEY, this.profileId);
        bundle.putInt(PRESET_SIZE_KEY, this.presetSize);
        bundle.putBoolean(IS_CROPPED_KEY, this.isCropped);
        bundle.putInt(BITMAP_WIDTH_KEY, this.queryWidth);
        bundle.putInt(BITMAP_HEIGHT_KEY, this.queryHeight);
        if (this.lastRequest != null) {
            z11 = true;
        } else {
            z11 = false;
        }
        bundle.putBoolean(PENDING_REFRESH_KEY, z11);
        return bundle;
    }

    public final void setCropped(boolean z11) {
        this.isCropped = z11;
        refreshImage(false);
    }

    public final void setDefaultProfilePicture(@Nullable Bitmap bitmap) {
        this.customizedDefaultProfilePicture = bitmap;
    }

    public final void setOnErrorListener(@Nullable OnErrorListener onErrorListener2) {
        this.onErrorListener = onErrorListener2;
    }

    public final void setPresetSize(int i11) {
        if (i11 == -4 || i11 == -3 || i11 == -2 || i11 == -1) {
            this.presetSize = i11;
            requestLayout();
            return;
        }
        throw new IllegalArgumentException("Must use a predefined preset size");
    }

    public final void setProfileId(@Nullable String str) {
        boolean z11;
        String str2 = this.profileId;
        boolean z12 = true;
        if (str2 == null || str2.length() == 0) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (z11 || !StringsKt__StringsJVMKt.equals(this.profileId, str, true)) {
            setBlankProfilePicture();
        } else {
            z12 = false;
        }
        this.profileId = str;
        refreshImage(z12);
    }

    public final void setShouldUpdateOnProfileChange(boolean z11) {
        if (z11) {
            ProfileTracker profileTracker2 = this.profileTracker;
            if (profileTracker2 != null) {
                profileTracker2.startTracking();
                return;
            }
            return;
        }
        ProfileTracker profileTracker3 = this.profileTracker;
        if (profileTracker3 != null) {
            profileTracker3.stopTracking();
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ProfilePictureView(@NotNull Context context, @NotNull AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(attributeSet, UserAttributesCacheManager.USER_ATTRIBUTES_CACHE_KEY);
        initialize();
        parseAttributes(attributeSet);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ProfilePictureView(@NotNull Context context, @NotNull AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(attributeSet, UserAttributesCacheManager.USER_ATTRIBUTES_CACHE_KEY);
        initialize();
        parseAttributes(attributeSet);
    }
}
