package com.deliveryhero.chatui.view.chatroom.navigator;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.net.Uri;
import android.widget.Toast;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.ActivityResultRegistry;
import androidx.activity.result.PickVisualMediaRequest;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.deliveryhero.chatui.view.chatroom.navigator.ImageSelectionType;
import com.deliveryhero.customerchat.R;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import r4.a;
import r4.b;

@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u001b2\u00020\u0001:\u0001\u001bB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u001c\u0010\u000f\u001a\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\b\u0012\u0006\u0012\u0004\u0018\u00010\t0\u00070\u0010H\u0016J\u0018\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0016J&\u0010\u0017\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0018\u001a\u00020\b2\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00120\u001aH\u0002R\"\u0010\u0005\u001a\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\b\u0012\u0006\u0012\u0004\u0018\u00010\t0\u00070\u0006X\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\n\u001a\u0010\u0012\f\u0012\n \f*\u0004\u0018\u00010\t0\t0\u000bX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000e0\u000bX\u0004¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"Lcom/deliveryhero/chatui/view/chatroom/navigator/ImageSelectionNavigatorImpl;", "Lcom/deliveryhero/chatui/view/chatroom/navigator/ImageSelectionNavigator;", "registry", "Landroidx/activity/result/ActivityResultRegistry;", "(Landroidx/activity/result/ActivityResultRegistry;)V", "_contractUriResult", "Landroidx/lifecycle/MutableLiveData;", "Lkotlin/Pair;", "", "Landroid/net/Uri;", "cameraResultLauncher", "Landroidx/activity/result/ActivityResultLauncher;", "kotlin.jvm.PlatformType", "galleryResultLauncher", "Landroidx/activity/result/PickVisualMediaRequest;", "getImageResult", "Landroidx/lifecycle/LiveData;", "openActivity", "", "context", "Landroid/content/Context;", "type", "Lcom/deliveryhero/chatui/view/chatroom/navigator/ImageSelectionType;", "runOrError", "errorMessage", "block", "Lkotlin/Function0;", "Companion", "customerchat_basicRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class ImageSelectionNavigatorImpl implements ImageSelectionNavigator {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final int OPEN_CAMERA_REQUEST_CODE = 55660;
    @NotNull
    private static final String OPEN_CAMERA_REQUEST_KEY = "Camera";
    public static final int OPEN_GALLERY_REQUEST_CODE = 55661;
    @NotNull
    private static final String OPEN_GALLERY_REQUEST_KEY = "Image Picker";
    @NotNull
    private final MutableLiveData<Pair<Integer, Uri>> _contractUriResult = new MutableLiveData<>();
    /* access modifiers changed from: private */
    @NotNull
    public final ActivityResultLauncher<Uri> cameraResultLauncher;
    /* access modifiers changed from: private */
    @NotNull
    public final ActivityResultLauncher<PickVisualMediaRequest> galleryResultLauncher;

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/deliveryhero/chatui/view/chatroom/navigator/ImageSelectionNavigatorImpl$Companion;", "", "()V", "OPEN_CAMERA_REQUEST_CODE", "", "OPEN_CAMERA_REQUEST_KEY", "", "OPEN_GALLERY_REQUEST_CODE", "OPEN_GALLERY_REQUEST_KEY", "customerchat_basicRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public ImageSelectionNavigatorImpl(@NotNull ActivityResultRegistry activityResultRegistry) {
        Intrinsics.checkNotNullParameter(activityResultRegistry, "registry");
        ActivityResultLauncher<PickVisualMediaRequest> register = activityResultRegistry.register(OPEN_GALLERY_REQUEST_KEY, new ActivityResultContracts.PickVisualMedia(), new a(this));
        Intrinsics.checkNotNullExpressionValue(register, "registry.register(\n     …)\n            }\n        }");
        this.galleryResultLauncher = register;
        ActivityResultLauncher<Uri> register2 = activityResultRegistry.register(OPEN_CAMERA_REQUEST_KEY, new ActivityResultContracts.TakePicture(), new b(this));
        Intrinsics.checkNotNullExpressionValue(register2, "registry.register(\n     …)\n            }\n        }");
        this.cameraResultLauncher = register2;
    }

    /* access modifiers changed from: private */
    /* renamed from: cameraResultLauncher$lambda-2  reason: not valid java name */
    public static final void m8163cameraResultLauncher$lambda2(ImageSelectionNavigatorImpl imageSelectionNavigatorImpl, Boolean bool) {
        Intrinsics.checkNotNullParameter(imageSelectionNavigatorImpl, "this$0");
        Intrinsics.checkNotNullExpressionValue(bool, "isSuccess");
        if (bool.booleanValue()) {
            imageSelectionNavigatorImpl._contractUriResult.setValue(new Pair(Integer.valueOf(OPEN_CAMERA_REQUEST_CODE), null));
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: galleryResultLauncher$lambda-1  reason: not valid java name */
    public static final void m8164galleryResultLauncher$lambda1(ImageSelectionNavigatorImpl imageSelectionNavigatorImpl, Uri uri) {
        Intrinsics.checkNotNullParameter(imageSelectionNavigatorImpl, "this$0");
        if (uri != null) {
            imageSelectionNavigatorImpl._contractUriResult.setValue(new Pair(Integer.valueOf(OPEN_GALLERY_REQUEST_CODE), uri));
        }
    }

    private final void runOrError(Context context, int i11, Function0<Unit> function0) {
        try {
            function0.invoke();
        } catch (ActivityNotFoundException unused) {
            Toast.makeText(context, context.getText(i11), 0).show();
        }
    }

    @NotNull
    public LiveData<Pair<Integer, Uri>> getImageResult() {
        return this._contractUriResult;
    }

    public void openActivity(@NotNull Context context, @NotNull ImageSelectionType imageSelectionType) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(imageSelectionType, "type");
        if (imageSelectionType instanceof ImageSelectionType.GALLERY) {
            runOrError(context, R.string.customer_chat_error_open_gallery, new ImageSelectionNavigatorImpl$openActivity$1(this));
        } else if (imageSelectionType instanceof ImageSelectionType.CAMERA) {
            runOrError(context, R.string.customer_chat_error_open_camera, new ImageSelectionNavigatorImpl$openActivity$2(this, imageSelectionType));
        }
    }
}
