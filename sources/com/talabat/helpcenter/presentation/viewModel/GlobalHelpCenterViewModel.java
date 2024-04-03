package com.talabat.helpcenter.presentation.viewModel;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Parcelable;
import android.webkit.ValueCallback;
import androidx.activity.result.ActivityResult;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import com.huawei.hms.push.AttributionReporter;
import com.huawei.location.lite.common.util.PermissionUtil;
import com.talabat.helpcenter.domain.repository.HelpCenterRepository;
import com.talabat.helpcenter.domain.usecases.UpdateActivationUseCase;
import com.talabat.helpcenter.presentation.utils.GlobalHelpCenterImageUtils;
import com.talabat.helpcenter.presentation.viewState.GlobalHelpCenterViewState;
import com.talabat.helpcenter.presentation.webInterface.WebMessageBuilder;
import com.talabat.helpcenter.presentation.webview.GlobalHelpCenterCallbacks;
import com.talabat.helpers.TalabatUtils;
import com.talabat.sidemenu.SideMenuRewardViewHolder;
import com.talabat.talabatcore.permissions.impl.TalabatPermissions;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableSharedFlow;
import kotlinx.coroutines.flow.SharedFlow;
import kotlinx.coroutines.flow.SharedFlowKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u0015\n\u0002\b\b\u0018\u00002\u00020\u00012\u00020\u0002B?\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\u0006\u0010\u000f\u001a\u00020\u000e¢\u0006\u0002\u0010\u0010J\u000e\u0010,\u001a\u00020\u000e2\u0006\u0010-\u001a\u00020.J\u000e\u0010/\u001a\u00020\u000e2\u0006\u0010-\u001a\u00020.J\u0010\u00100\u001a\u0004\u0018\u0001012\u0006\u0010-\u001a\u00020.J\u0006\u00102\u001a\u000201J\u0010\u00103\u001a\u0004\u0018\u0001012\u0006\u0010-\u001a\u00020.J\u0010\u00104\u001a\u00020\u000e2\u0006\u0010-\u001a\u00020.H\u0002J'\u00105\u001a\b\u0012\u0004\u0012\u00020\u000e0\"2\u0006\u0010-\u001a\u00020.2\f\u00106\u001a\b\u0012\u0004\u0012\u00020\u000e0\"¢\u0006\u0002\u00107J\b\u00108\u001a\u000209H\u0002J\u0016\u0010:\u001a\u00020;2\u0006\u0010-\u001a\u00020.2\u0006\u0010<\u001a\u00020\u000eJ\u001b\u0010=\u001a\n\u0012\u0004\u0012\u00020#\u0018\u00010\"2\u0006\u0010>\u001a\u00020?¢\u0006\u0002\u0010@J\"\u0010A\u001a\u0002092\b\u0010B\u001a\u0004\u0018\u00010\u000e2\b\u0010C\u001a\u0004\u0018\u00010\u000e2\u0006\u0010D\u001a\u00020\u000eJ\u0010\u0010E\u001a\u0002092\u0006\u0010F\u001a\u00020\u000eH\u0016J\u0010\u0010G\u001a\u0002092\u0006\u0010F\u001a\u00020\u000eH\u0016J\b\u0010H\u001a\u000209H\u0016J\b\u0010I\u001a\u000209H\u0016J3\u0010J\u001a\u0002092\u0006\u0010-\u001a\u00020.2\u0006\u0010K\u001a\u00020\f2\u000e\u0010L\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u000e0\"2\u0006\u0010M\u001a\u00020N¢\u0006\u0002\u0010OJ\u001c\u0010P\u001a\u0002092\u0014\u0010Q\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020#0\"\u0018\u00010!J\b\u0010R\u001a\u000209H\u0002J\u0010\u0010S\u001a\u0002092\u0006\u0010T\u001a\u00020\u000eH\u0002J\b\u0010U\u001a\u000209H\u0002R\u000e\u0010\u000f\u001a\u00020\u000eX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0017\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00180\u0017¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u001b\u001a\u00020\u000eX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR(\u0010 \u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020#0\"\u0018\u00010!X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R\u0014\u0010(\u001a\b\u0012\u0004\u0012\u00020\u00130)X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010*\u001a\b\u0012\u0004\u0012\u00020\u00180+X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000¨\u0006V"}, d2 = {"Lcom/talabat/helpcenter/presentation/viewModel/GlobalHelpCenterViewModel;", "Landroidx/lifecycle/ViewModel;", "Lcom/talabat/helpcenter/presentation/webview/GlobalHelpCenterCallbacks;", "helpCenterRepository", "Lcom/talabat/helpcenter/domain/repository/HelpCenterRepository;", "updateActivationUseCase", "Lcom/talabat/helpcenter/domain/usecases/UpdateActivationUseCase;", "webMessageBuilder", "Lcom/talabat/helpcenter/presentation/webInterface/WebMessageBuilder;", "talabatPermissions", "Lcom/talabat/talabatcore/permissions/impl/TalabatPermissions;", "country", "", "selectedLanguage", "", "appPlatform", "(Lcom/talabat/helpcenter/domain/repository/HelpCenterRepository;Lcom/talabat/helpcenter/domain/usecases/UpdateActivationUseCase;Lcom/talabat/helpcenter/presentation/webInterface/WebMessageBuilder;Lcom/talabat/talabatcore/permissions/impl/TalabatPermissions;ILjava/lang/String;Ljava/lang/String;)V", "globalHelpCenterEvents", "Lkotlinx/coroutines/flow/SharedFlow;", "Lcom/talabat/helpcenter/presentation/viewModel/GlobalHelpCenterWebEvent;", "getGlobalHelpCenterEvents", "()Lkotlinx/coroutines/flow/SharedFlow;", "globalHelpCenterLiveData", "Landroidx/lifecycle/LiveData;", "Lcom/talabat/helpcenter/presentation/viewState/GlobalHelpCenterViewState;", "getGlobalHelpCenterLiveData", "()Landroidx/lifecycle/LiveData;", "mCameraPhotoPath", "getMCameraPhotoPath", "()Ljava/lang/String;", "setMCameraPhotoPath", "(Ljava/lang/String;)V", "mFilePathCallback", "Landroid/webkit/ValueCallback;", "", "Landroid/net/Uri;", "getMFilePathCallback", "()Landroid/webkit/ValueCallback;", "setMFilePathCallback", "(Landroid/webkit/ValueCallback;)V", "mGlobalHelpCenterEvent", "Lkotlinx/coroutines/flow/MutableSharedFlow;", "mGlobalHelpCenterLiveData", "Landroidx/lifecycle/MutableLiveData;", "getBridgeMessage", "context", "Landroid/content/Context;", "getBridgeMessageForBackButton", "getCameraIntent", "Landroid/content/Intent;", "getGalleryIntent", "getIntent", "getRandomId", "getRequiredPermissionArray", "permissionsArray", "(Landroid/content/Context;[Ljava/lang/String;)[Ljava/lang/String;", "hideHelpCenter", "", "isPermissionGranted", "", "permission", "onActivityResult", "result", "Landroidx/activity/result/ActivityResult;", "(Landroidx/activity/result/ActivityResult;)[Landroid/net/Uri;", "onAttach", "orderId", "caseId", "appVersion", "onChatEnded", "chatId", "onChatStarted", "onCloseButtonTapped", "onGlobalHelpCenterStarted", "onRequestPermissionResult", "requestCode", "permissions", "grantResults", "", "(Landroid/content/Context;I[Ljava/lang/String;[I)V", "onShowFileChooser", "filePathCallback", "returnToChromeClientWithNoPermissionGiven", "showHelpCenter", "globalHelpCenterUrl", "showHelpCenterLoading", "com_talabat_NewArchi_TalabatHelpCenter_TalabatHelpCenter"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class GlobalHelpCenterViewModel extends ViewModel implements GlobalHelpCenterCallbacks {
    /* access modifiers changed from: private */
    @NotNull
    public final String appPlatform;
    /* access modifiers changed from: private */
    public final int country;
    @NotNull
    private final SharedFlow<GlobalHelpCenterWebEvent> globalHelpCenterEvents;
    @NotNull
    private final LiveData<GlobalHelpCenterViewState> globalHelpCenterLiveData;
    /* access modifiers changed from: private */
    @NotNull
    public final HelpCenterRepository helpCenterRepository;
    @NotNull
    private String mCameraPhotoPath;
    @Nullable
    private ValueCallback<Uri[]> mFilePathCallback;
    /* access modifiers changed from: private */
    @NotNull
    public final MutableSharedFlow<GlobalHelpCenterWebEvent> mGlobalHelpCenterEvent;
    @NotNull
    private final MutableLiveData<GlobalHelpCenterViewState> mGlobalHelpCenterLiveData;
    /* access modifiers changed from: private */
    @NotNull
    public final String selectedLanguage;
    @NotNull
    private final TalabatPermissions talabatPermissions;
    /* access modifiers changed from: private */
    @NotNull
    public final UpdateActivationUseCase updateActivationUseCase;
    @NotNull
    private final WebMessageBuilder webMessageBuilder;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ GlobalHelpCenterViewModel(HelpCenterRepository helpCenterRepository2, UpdateActivationUseCase updateActivationUseCase2, WebMessageBuilder webMessageBuilder2, TalabatPermissions talabatPermissions2, int i11, String str, String str2, int i12, DefaultConstructorMarker defaultConstructorMarker) {
        this(helpCenterRepository2, updateActivationUseCase2, webMessageBuilder2, (i12 & 8) != 0 ? new TalabatPermissions() : talabatPermissions2, i11, str, str2);
    }

    private final String getRandomId(Context context) {
        String deviceId = TalabatUtils.getDeviceId(context);
        UUID randomUUID = UUID.randomUUID();
        return deviceId + SideMenuRewardViewHolder.DEFAULT_LOGGED_IN_USER_POINTS_VALUE + randomUUID;
    }

    /* access modifiers changed from: private */
    public final void hideHelpCenter() {
        this.mGlobalHelpCenterLiveData.setValue(GlobalHelpCenterViewState.Hidden.INSTANCE);
    }

    private final void returnToChromeClientWithNoPermissionGiven() {
        MutableLiveData<GlobalHelpCenterViewState> mutableLiveData = this.mGlobalHelpCenterLiveData;
        Uri uri = Uri.EMPTY;
        Intrinsics.checkNotNullExpressionValue(uri, "EMPTY");
        mutableLiveData.setValue(new GlobalHelpCenterViewState.ReturnDataToClient(new Uri[]{uri}));
    }

    /* access modifiers changed from: private */
    public final void showHelpCenter(String str) {
        this.mGlobalHelpCenterLiveData.setValue(new GlobalHelpCenterViewState.Visible(str));
    }

    private final void showHelpCenterLoading() {
        this.mGlobalHelpCenterLiveData.setValue(GlobalHelpCenterViewState.Loading.INSTANCE);
    }

    @NotNull
    public final String getBridgeMessage(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return this.webMessageBuilder.buildInitialBridgeMessage(getRandomId(context));
    }

    @NotNull
    public final String getBridgeMessageForBackButton(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return this.webMessageBuilder.buildBridgeMessageForBackButton(getRandomId(context));
    }

    @Nullable
    public final Intent getCameraIntent(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        Pair<Intent, String> cameraIntentAndImagePath = GlobalHelpCenterImageUtils.Companion.getCameraIntentAndImagePath(context);
        Intent component1 = cameraIntentAndImagePath.component1();
        this.mCameraPhotoPath = cameraIntentAndImagePath.component2();
        return component1;
    }

    @NotNull
    public final Intent getGalleryIntent() {
        return GlobalHelpCenterImageUtils.Companion.getContentSelectionIntent();
    }

    @NotNull
    public final SharedFlow<GlobalHelpCenterWebEvent> getGlobalHelpCenterEvents() {
        return this.globalHelpCenterEvents;
    }

    @NotNull
    public final LiveData<GlobalHelpCenterViewState> getGlobalHelpCenterLiveData() {
        return this.globalHelpCenterLiveData;
    }

    @Nullable
    public final Intent getIntent(@NotNull Context context) {
        Intent intent;
        Intent intent2;
        Intrinsics.checkNotNullParameter(context, "context");
        boolean isPermissionGranted = isPermissionGranted(context, "android.permission.CAMERA");
        boolean isPermissionGranted2 = isPermissionGranted(context, PermissionUtil.READ_EXTERNAL_PERMISSION);
        if (isPermissionGranted || isPermissionGranted2) {
            if (isPermissionGranted) {
                intent = getCameraIntent(context);
            } else {
                intent = null;
            }
            if (isPermissionGranted2) {
                intent2 = getGalleryIntent();
            } else {
                intent2 = null;
            }
            if (intent != null && intent2 != null) {
                Intent intent3 = new Intent("android.intent.action.CHOOSER");
                intent3.putExtra("android.intent.extra.INTENT", intent2);
                intent3.putExtra("android.intent.extra.TITLE", "Image Chooser");
                intent3.putExtra("android.intent.extra.INITIAL_INTENTS", (Parcelable[]) new Intent[]{intent});
                return intent3;
            } else if (isPermissionGranted && intent != null) {
                return intent;
            } else {
                if (intent2 != null) {
                    return intent2;
                }
                returnToChromeClientWithNoPermissionGiven();
                return null;
            }
        } else {
            returnToChromeClientWithNoPermissionGiven();
            return null;
        }
    }

    @NotNull
    public final String getMCameraPhotoPath() {
        return this.mCameraPhotoPath;
    }

    @Nullable
    public final ValueCallback<Uri[]> getMFilePathCallback() {
        return this.mFilePathCallback;
    }

    @NotNull
    public final String[] getRequiredPermissionArray(@NotNull Context context, @NotNull String[] strArr) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(strArr, "permissionsArray");
        return this.talabatPermissions.getPermissionArray(context, strArr);
    }

    public final boolean isPermissionGranted(@NotNull Context context, @NotNull String str) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(str, AttributionReporter.SYSTEM_PERMISSION);
        return this.talabatPermissions.isPermissionGranted(context, str);
    }

    @Nullable
    public final Uri[] onActivityResult(@NotNull ActivityResult activityResult) {
        Intrinsics.checkNotNullParameter(activityResult, "result");
        if (activityResult.getResultCode() == -1) {
            Intent data = activityResult.getData();
            if (data == null) {
                Uri parse = Uri.parse(this.mCameraPhotoPath);
                Intrinsics.checkNotNullExpressionValue(parse, "parse(mCameraPhotoPath)");
                return new Uri[]{parse};
            }
            String dataString = data.getDataString();
            if (dataString != null) {
                Uri parse2 = Uri.parse(dataString);
                Intrinsics.checkNotNullExpressionValue(parse2, "parse(dataString)");
                return new Uri[]{parse2};
            }
        }
        return null;
    }

    public final void onAttach(@Nullable String str, @Nullable String str2, @NotNull String str3) {
        Intrinsics.checkNotNullParameter(str3, "appVersion");
        showHelpCenterLoading();
        Job unused = BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), (CoroutineContext) null, (CoroutineStart) null, new GlobalHelpCenterViewModel$onAttach$1(this, str, str2, str3, (Continuation<? super GlobalHelpCenterViewModel$onAttach$1>) null), 3, (Object) null);
    }

    public void onChatEnded(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "chatId");
        Job unused = BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), (CoroutineContext) null, (CoroutineStart) null, new GlobalHelpCenterViewModel$onChatEnded$1(this, (Continuation<? super GlobalHelpCenterViewModel$onChatEnded$1>) null), 3, (Object) null);
    }

    public void onChatStarted(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "chatId");
        Job unused = BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), (CoroutineContext) null, (CoroutineStart) null, new GlobalHelpCenterViewModel$onChatStarted$1(this, (Continuation<? super GlobalHelpCenterViewModel$onChatStarted$1>) null), 3, (Object) null);
    }

    public void onCloseButtonTapped() {
        Job unused = BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), (CoroutineContext) null, (CoroutineStart) null, new GlobalHelpCenterViewModel$onCloseButtonTapped$1(this, (Continuation<? super GlobalHelpCenterViewModel$onCloseButtonTapped$1>) null), 3, (Object) null);
    }

    public void onGlobalHelpCenterStarted() {
        Job unused = BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), (CoroutineContext) null, (CoroutineStart) null, new GlobalHelpCenterViewModel$onGlobalHelpCenterStarted$1(this, (Continuation<? super GlobalHelpCenterViewModel$onGlobalHelpCenterStarted$1>) null), 3, (Object) null);
    }

    public final void onRequestPermissionResult(@NotNull Context context, int i11, @NotNull String[] strArr, @NotNull int[] iArr) {
        boolean z11;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(strArr, "permissions");
        Intrinsics.checkNotNullParameter(iArr, "grantResults");
        if (i11 == 1000) {
            if (iArr.length == 0) {
                z11 = true;
            } else {
                z11 = false;
            }
            if (!z11) {
                for (int i12 : iArr) {
                    if (i12 == 0) {
                        this.mGlobalHelpCenterLiveData.setValue(GlobalHelpCenterViewState.ShowImageChooser.INSTANCE);
                        return;
                    }
                }
            }
        }
        if (isPermissionGranted(context, "android.permission.CAMERA") || isPermissionGranted(context, PermissionUtil.READ_EXTERNAL_PERMISSION)) {
            this.mGlobalHelpCenterLiveData.setValue(GlobalHelpCenterViewState.ShowImageChooser.INSTANCE);
            return;
        }
        MutableLiveData<GlobalHelpCenterViewState> mutableLiveData = this.mGlobalHelpCenterLiveData;
        Uri uri = Uri.EMPTY;
        Intrinsics.checkNotNullExpressionValue(uri, "EMPTY");
        mutableLiveData.setValue(new GlobalHelpCenterViewState.ReturnDataToClient(new Uri[]{uri}));
    }

    public final void onShowFileChooser(@Nullable ValueCallback<Uri[]> valueCallback) {
        if (valueCallback != null) {
            this.mFilePathCallback = valueCallback;
        }
        this.mGlobalHelpCenterLiveData.setValue(GlobalHelpCenterViewState.CheckPermissions.INSTANCE);
    }

    public final void setMCameraPhotoPath(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.mCameraPhotoPath = str;
    }

    public final void setMFilePathCallback(@Nullable ValueCallback<Uri[]> valueCallback) {
        this.mFilePathCallback = valueCallback;
    }

    public GlobalHelpCenterViewModel(@NotNull HelpCenterRepository helpCenterRepository2, @NotNull UpdateActivationUseCase updateActivationUseCase2, @NotNull WebMessageBuilder webMessageBuilder2, @NotNull TalabatPermissions talabatPermissions2, int i11, @NotNull String str, @NotNull String str2) {
        Intrinsics.checkNotNullParameter(helpCenterRepository2, "helpCenterRepository");
        Intrinsics.checkNotNullParameter(updateActivationUseCase2, "updateActivationUseCase");
        Intrinsics.checkNotNullParameter(webMessageBuilder2, "webMessageBuilder");
        Intrinsics.checkNotNullParameter(talabatPermissions2, "talabatPermissions");
        Intrinsics.checkNotNullParameter(str, "selectedLanguage");
        Intrinsics.checkNotNullParameter(str2, "appPlatform");
        this.helpCenterRepository = helpCenterRepository2;
        this.updateActivationUseCase = updateActivationUseCase2;
        this.webMessageBuilder = webMessageBuilder2;
        this.talabatPermissions = talabatPermissions2;
        this.country = i11;
        this.selectedLanguage = str;
        this.appPlatform = str2;
        MutableLiveData<GlobalHelpCenterViewState> mutableLiveData = new MutableLiveData<>();
        this.mGlobalHelpCenterLiveData = mutableLiveData;
        this.globalHelpCenterLiveData = mutableLiveData;
        MutableSharedFlow<GlobalHelpCenterWebEvent> MutableSharedFlow$default = SharedFlowKt.MutableSharedFlow$default(0, 0, (BufferOverflow) null, 7, (Object) null);
        this.mGlobalHelpCenterEvent = MutableSharedFlow$default;
        this.globalHelpCenterEvents = FlowKt.asSharedFlow(MutableSharedFlow$default);
        this.mCameraPhotoPath = "";
    }
}
