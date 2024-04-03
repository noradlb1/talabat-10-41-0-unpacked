package com.facebook.share.internal;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.ParcelFileDescriptor;
import android.util.Pair;
import com.apptimize.fb;
import com.facebook.AccessToken;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookGraphResponseException;
import com.facebook.FacebookOperationCanceledException;
import com.facebook.FacebookRequestError;
import com.facebook.FacebookSdk;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.HttpMethod;
import com.facebook.appevents.InternalAppEventsLogger;
import com.facebook.devicerequests.internal.DeviceRequestsHelper;
import com.facebook.internal.AnalyticsEvents;
import com.facebook.internal.AppCall;
import com.facebook.internal.CallbackManagerImpl;
import com.facebook.internal.NativeAppCallAttachmentStore;
import com.facebook.internal.NativeProtocol;
import com.facebook.internal.Utility;
import com.facebook.share.Sharer;
import com.facebook.share.model.CameraEffectTextures;
import com.facebook.share.model.ShareCameraEffectContent;
import com.facebook.share.model.ShareMedia;
import com.facebook.share.model.ShareMediaContent;
import com.facebook.share.model.SharePhoto;
import com.facebook.share.model.SharePhotoContent;
import com.facebook.share.model.ShareStoryContent;
import com.facebook.share.model.ShareVideo;
import com.facebook.share.model.ShareVideoContent;
import d7.a;
import d7.b;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000î\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J$\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0002J&\u0010\r\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0002J\"\u0010\r\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u000e\u0010\u0015\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u0016H\u0002J\u001c\u0010\u0017\u001a\u0004\u0018\u00010\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\u0006\u0010\u001b\u001a\u00020\u0010H\u0007J\u001e\u0010\u001c\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0012\u0004\u0012\u00020\u00040\u001d2\u0006\u0010\u001e\u001a\u00020\u0004H\u0007J\"\u0010\u001f\u001a\n\u0012\u0004\u0012\u00020\u0018\u0018\u00010 2\b\u0010!\u001a\u0004\u0018\u00010\"2\u0006\u0010\u001b\u001a\u00020\u0010H\u0007J\u0012\u0010#\u001a\u0004\u0018\u00010\u00042\u0006\u0010$\u001a\u00020\u0018H\u0007J\"\u0010%\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010 2\b\u0010&\u001a\u0004\u0018\u00010'2\u0006\u0010\u001b\u001a\u00020\u0010H\u0007J\u0012\u0010(\u001a\u0004\u0018\u00010\u00042\u0006\u0010$\u001a\u00020\u0018H\u0007J\u0018\u0010)\u001a\u00020*2\u000e\u0010+\u001a\n\u0012\u0004\u0012\u00020-\u0018\u00010,H\u0007J\u001c\u0010.\u001a\u0004\u0018\u00010\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\u0006\u0010\u001b\u001a\u00020\u0010H\u0007J\u001c\u0010/\u001a\u0004\u0018\u00010\u00182\b\u00100\u001a\u0004\u0018\u0001012\u0006\u0010\u001b\u001a\u00020\u0010H\u0007J\u0014\u00102\u001a\u0004\u0018\u00010\u00042\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0007J\u001c\u00103\u001a\u0004\u0018\u00010\u00042\b\u00104\u001a\u0004\u0018\u0001052\u0006\u0010\u001b\u001a\u00020\u0010H\u0007J,\u00106\u001a\u0002072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\u00108\u001a\u0004\u0018\u00010*H\u0007J\"\u00109\u001a\u00020:2\u000e\u0010+\u001a\n\u0012\u0004\u0012\u00020-\u0018\u00010,2\b\u0010;\u001a\u0004\u0018\u00010\u0004H\u0007J \u0010<\u001a\u00020:2\u000e\u0010+\u001a\n\u0012\u0004\u0012\u00020-\u0018\u00010,2\u0006\u0010=\u001a\u00020>H\u0007J*\u0010?\u001a\u00020:2\u000e\u0010+\u001a\n\u0012\u0004\u0012\u00020-\u0018\u00010,2\b\u0010@\u001a\u0004\u0018\u00010\u00042\u0006\u0010A\u001a\u00020BH\u0007J\u0018\u0010C\u001a\u00020:2\u000e\u0010+\u001a\n\u0012\u0004\u0012\u00020-\u0018\u00010,H\u0007J \u0010D\u001a\u00020:2\u000e\u0010+\u001a\n\u0012\u0004\u0012\u00020-\u0018\u00010,2\u0006\u0010E\u001a\u00020FH\u0007J,\u0010D\u001a\u00020:2\u000e\u0010+\u001a\n\u0012\u0004\u0012\u00020-\u0018\u00010,2\b\u0010G\u001a\u0004\u0018\u00010B2\b\u0010H\u001a\u0004\u0018\u00010\u0004H\u0007J\"\u0010D\u001a\u00020:2\u000e\u0010+\u001a\n\u0012\u0004\u0012\u00020-\u0018\u00010,2\b\u0010H\u001a\u0004\u0018\u00010\u0004H\u0007J\"\u0010I\u001a\u00020:2\u000e\u0010+\u001a\n\u0012\u0004\u0012\u00020-\u0018\u00010,2\b\u0010@\u001a\u0004\u0018\u00010\u0004H\u0007J\u001a\u0010J\u001a\u00020:2\u0006\u0010K\u001a\u00020\u00042\b\u0010L\u001a\u0004\u0018\u00010\u0004H\u0002J&\u0010M\u001a\u00020N2\b\u0010O\u001a\u0004\u0018\u00010P2\b\u0010Q\u001a\u0004\u0018\u00010\u00142\b\u0010+\u001a\u0004\u0018\u00010RH\u0007J$\u0010M\u001a\u00020N2\b\u0010O\u001a\u0004\u0018\u00010P2\u0006\u0010S\u001a\u00020\u00122\b\u0010+\u001a\u0004\u0018\u00010RH\u0007J&\u0010M\u001a\u00020N2\b\u0010O\u001a\u0004\u0018\u00010P2\b\u0010T\u001a\u0004\u0018\u00010U2\b\u0010+\u001a\u0004\u0018\u00010RH\u0007J*\u0010V\u001a\u00020:2\u0006\u0010\b\u001a\u00020\t2\b\u0010W\u001a\u0004\u0018\u00010X2\u000e\u0010+\u001a\n\u0012\u0004\u0012\u00020-\u0018\u00010,H\u0007J\u0010\u0010Y\u001a\u00020:2\u0006\u0010\b\u001a\u00020\tH\u0007J\u0018\u0010Z\u001a\u00020[2\u0006\u0010\\\u001a\u00020[2\u0006\u0010]\u001a\u000207H\u0007J\u001c\u0010^\u001a\u0004\u0018\u00010_2\b\u0010`\u001a\u0004\u0018\u00010_2\u0006\u0010]\u001a\u000207H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006a"}, d2 = {"Lcom/facebook/share/internal/ShareInternalUtility;", "", "()V", "MY_STAGING_RESOURCES", "", "STAGING_PARAM", "getAppCallFromActivityResult", "Lcom/facebook/internal/AppCall;", "requestCode", "", "resultCode", "data", "Landroid/content/Intent;", "getAttachment", "Lcom/facebook/internal/NativeAppCallAttachmentStore$Attachment;", "callId", "Ljava/util/UUID;", "uri", "Landroid/net/Uri;", "bitmap", "Landroid/graphics/Bitmap;", "medium", "Lcom/facebook/share/model/ShareMedia;", "getBackgroundAssetMediaInfo", "Landroid/os/Bundle;", "storyContent", "Lcom/facebook/share/model/ShareStoryContent;", "appCallId", "getFieldNameAndNamespaceFromFullName", "Landroid/util/Pair;", "fullName", "getMediaInfos", "", "mediaContent", "Lcom/facebook/share/model/ShareMediaContent;", "getNativeDialogCompletionGesture", "result", "getPhotoUrls", "photoContent", "Lcom/facebook/share/model/SharePhotoContent;", "getShareDialogPostId", "getShareResultProcessor", "Lcom/facebook/share/internal/ResultProcessor;", "callback", "Lcom/facebook/FacebookCallback;", "Lcom/facebook/share/Sharer$Result;", "getStickerUrl", "getTextureUrlBundle", "cameraEffectContent", "Lcom/facebook/share/model/ShareCameraEffectContent;", "getUriExtension", "getVideoUrl", "videoContent", "Lcom/facebook/share/model/ShareVideoContent;", "handleActivityResult", "", "resultProcessor", "invokeCallbackWithError", "", "error", "invokeCallbackWithException", "exception", "Ljava/lang/Exception;", "invokeCallbackWithResults", "postId", "graphResponse", "Lcom/facebook/GraphResponse;", "invokeOnCancelCallback", "invokeOnErrorCallback", "ex", "Lcom/facebook/FacebookException;", "response", "message", "invokeOnSuccessCallback", "logShareResult", "shareOutcome", "errorMessage", "newUploadStagingResourceWithImageRequest", "Lcom/facebook/GraphRequest;", "accessToken", "Lcom/facebook/AccessToken;", "image", "Lcom/facebook/GraphRequest$Callback;", "imageUri", "file", "Ljava/io/File;", "registerSharerCallback", "callbackManager", "Lcom/facebook/CallbackManager;", "registerStaticShareCallback", "removeNamespacesFromOGJsonArray", "Lorg/json/JSONArray;", "jsonArray", "requireNamespace", "removeNamespacesFromOGJsonObject", "Lorg/json/JSONObject;", "jsonObject", "facebook-common_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class ShareInternalUtility {
    @NotNull
    public static final ShareInternalUtility INSTANCE = new ShareInternalUtility();
    @NotNull
    public static final String MY_STAGING_RESOURCES = "me/staging_resources";
    @NotNull
    public static final String STAGING_PARAM = "file";

    private ShareInternalUtility() {
    }

    private final AppCall getAppCallFromActivityResult(int i11, int i12, Intent intent) {
        UUID callIdFromIntent = NativeProtocol.getCallIdFromIntent(intent);
        if (callIdFromIntent == null) {
            return null;
        }
        return AppCall.Companion.finishPendingCall(callIdFromIntent, i11);
    }

    private final NativeAppCallAttachmentStore.Attachment getAttachment(UUID uuid, ShareMedia<?, ?> shareMedia) {
        Uri uri;
        Bitmap bitmap;
        if (shareMedia instanceof SharePhoto) {
            SharePhoto sharePhoto = (SharePhoto) shareMedia;
            bitmap = sharePhoto.getBitmap();
            uri = sharePhoto.getImageUrl();
        } else if (shareMedia instanceof ShareVideo) {
            uri = ((ShareVideo) shareMedia).getLocalUrl();
            bitmap = null;
        } else {
            uri = null;
            bitmap = null;
        }
        return getAttachment(uuid, uri, bitmap);
    }

    @JvmStatic
    @Nullable
    public static final Bundle getBackgroundAssetMediaInfo(@Nullable ShareStoryContent shareStoryContent, @NotNull UUID uuid) {
        Intrinsics.checkNotNullParameter(uuid, "appCallId");
        Bundle bundle = null;
        if (!(shareStoryContent == null || shareStoryContent.getBackgroundAsset() == null)) {
            ShareMedia<?, ?> backgroundAsset = shareStoryContent.getBackgroundAsset();
            NativeAppCallAttachmentStore.Attachment attachment = INSTANCE.getAttachment(uuid, backgroundAsset);
            if (attachment == null) {
                return null;
            }
            bundle = new Bundle();
            bundle.putString("type", backgroundAsset.getMediaType().name());
            bundle.putString("uri", attachment.getAttachmentUrl());
            String uriExtension = getUriExtension(attachment.getOriginalUri());
            if (uriExtension != null) {
                Utility.putNonEmptyString(bundle, ShareConstants.MEDIA_EXTENSION, uriExtension);
            }
            NativeAppCallAttachmentStore nativeAppCallAttachmentStore = NativeAppCallAttachmentStore.INSTANCE;
            NativeAppCallAttachmentStore.addAttachments(CollectionsKt__CollectionsJVMKt.listOf(attachment));
        }
        return bundle;
    }

    @JvmStatic
    @NotNull
    public static final Pair<String, String> getFieldNameAndNamespaceFromFullName(@NotNull String str) {
        String str2;
        int i11;
        Intrinsics.checkNotNullParameter(str, "fullName");
        int indexOf$default = StringsKt__StringsKt.indexOf$default((CharSequence) str, (char) AbstractJsonLexerKt.COLON, 0, false, 6, (Object) null);
        if (indexOf$default == -1 || str.length() <= (i11 = indexOf$default + 1)) {
            str2 = null;
        } else {
            str2 = str.substring(0, indexOf$default);
            Intrinsics.checkNotNullExpressionValue(str2, "(this as java.lang.Strin…ing(startIndex, endIndex)");
            str = str.substring(i11);
            Intrinsics.checkNotNullExpressionValue(str, "(this as java.lang.String).substring(startIndex)");
        }
        return new Pair<>(str2, str);
    }

    @JvmStatic
    @Nullable
    public static final List<Bundle> getMediaInfos(@Nullable ShareMediaContent shareMediaContent, @NotNull UUID uuid) {
        List<ShareMedia<?, ?>> list;
        Bundle bundle;
        Intrinsics.checkNotNullParameter(uuid, "appCallId");
        if (shareMediaContent == null) {
            list = null;
        } else {
            list = shareMediaContent.getMedia();
        }
        if (list == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (ShareMedia shareMedia : list) {
            NativeAppCallAttachmentStore.Attachment attachment = INSTANCE.getAttachment(uuid, shareMedia);
            if (attachment == null) {
                bundle = null;
            } else {
                arrayList.add(attachment);
                bundle = new Bundle();
                bundle.putString("type", shareMedia.getMediaType().name());
                bundle.putString("uri", attachment.getAttachmentUrl());
            }
            if (bundle != null) {
                arrayList2.add(bundle);
            }
        }
        NativeAppCallAttachmentStore.addAttachments(arrayList);
        return arrayList2;
    }

    @JvmStatic
    @Nullable
    public static final String getNativeDialogCompletionGesture(@NotNull Bundle bundle) {
        Intrinsics.checkNotNullParameter(bundle, "result");
        if (bundle.containsKey(NativeProtocol.RESULT_ARGS_DIALOG_COMPLETION_GESTURE_KEY)) {
            return bundle.getString(NativeProtocol.RESULT_ARGS_DIALOG_COMPLETION_GESTURE_KEY);
        }
        return bundle.getString(NativeProtocol.EXTRA_DIALOG_COMPLETION_GESTURE_KEY);
    }

    @JvmStatic
    @Nullable
    public static final List<String> getPhotoUrls(@Nullable SharePhotoContent sharePhotoContent, @NotNull UUID uuid) {
        List<SharePhoto> list;
        Intrinsics.checkNotNullParameter(uuid, "appCallId");
        if (sharePhotoContent == null) {
            list = null;
        } else {
            list = sharePhotoContent.getPhotos();
        }
        if (list == null) {
            return null;
        }
        ArrayList<NativeAppCallAttachmentStore.Attachment> arrayList = new ArrayList<>();
        for (SharePhoto attachment : list) {
            NativeAppCallAttachmentStore.Attachment attachment2 = INSTANCE.getAttachment(uuid, attachment);
            if (attachment2 != null) {
                arrayList.add(attachment2);
            }
        }
        ArrayList arrayList2 = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList, 10));
        for (NativeAppCallAttachmentStore.Attachment attachmentUrl : arrayList) {
            arrayList2.add(attachmentUrl.getAttachmentUrl());
        }
        NativeAppCallAttachmentStore.addAttachments(arrayList);
        return arrayList2;
    }

    @JvmStatic
    @Nullable
    public static final String getShareDialogPostId(@NotNull Bundle bundle) {
        Intrinsics.checkNotNullParameter(bundle, "result");
        if (bundle.containsKey(ShareConstants.RESULT_POST_ID)) {
            return bundle.getString(ShareConstants.RESULT_POST_ID);
        }
        if (bundle.containsKey(ShareConstants.EXTRA_RESULT_POST_ID)) {
            return bundle.getString(ShareConstants.EXTRA_RESULT_POST_ID);
        }
        return bundle.getString(ShareConstants.WEB_DIALOG_RESULT_PARAM_POST_ID);
    }

    @JvmStatic
    @NotNull
    public static final ResultProcessor getShareResultProcessor(@Nullable FacebookCallback<Sharer.Result> facebookCallback) {
        return new ShareInternalUtility$getShareResultProcessor$1(facebookCallback);
    }

    @JvmStatic
    @Nullable
    public static final Bundle getStickerUrl(@Nullable ShareStoryContent shareStoryContent, @NotNull UUID uuid) {
        Intrinsics.checkNotNullParameter(uuid, "appCallId");
        if (shareStoryContent == null || shareStoryContent.getStickerAsset() == null) {
            return null;
        }
        new ArrayList().add(shareStoryContent.getStickerAsset());
        NativeAppCallAttachmentStore.Attachment attachment = INSTANCE.getAttachment(uuid, shareStoryContent.getStickerAsset());
        if (attachment == null) {
            return null;
        }
        Bundle bundle = new Bundle();
        bundle.putString("uri", attachment.getAttachmentUrl());
        String uriExtension = getUriExtension(attachment.getOriginalUri());
        if (uriExtension != null) {
            Utility.putNonEmptyString(bundle, ShareConstants.MEDIA_EXTENSION, uriExtension);
        }
        NativeAppCallAttachmentStore nativeAppCallAttachmentStore = NativeAppCallAttachmentStore.INSTANCE;
        NativeAppCallAttachmentStore.addAttachments(CollectionsKt__CollectionsJVMKt.listOf(attachment));
        return bundle;
    }

    @JvmStatic
    @Nullable
    public static final Bundle getTextureUrlBundle(@Nullable ShareCameraEffectContent shareCameraEffectContent, @NotNull UUID uuid) {
        CameraEffectTextures cameraEffectTextures;
        Intrinsics.checkNotNullParameter(uuid, "appCallId");
        if (shareCameraEffectContent == null) {
            cameraEffectTextures = null;
        } else {
            cameraEffectTextures = shareCameraEffectContent.getTextures();
        }
        if (cameraEffectTextures == null) {
            return null;
        }
        Bundle bundle = new Bundle();
        ArrayList arrayList = new ArrayList();
        for (String next : cameraEffectTextures.keySet()) {
            NativeAppCallAttachmentStore.Attachment attachment = INSTANCE.getAttachment(uuid, cameraEffectTextures.getTextureUri(next), cameraEffectTextures.getTextureBitmap(next));
            if (attachment != null) {
                arrayList.add(attachment);
                bundle.putString(next, attachment.getAttachmentUrl());
            }
        }
        NativeAppCallAttachmentStore.addAttachments(arrayList);
        return bundle;
    }

    @JvmStatic
    @Nullable
    public static final String getUriExtension(@Nullable Uri uri) {
        if (uri == null) {
            return null;
        }
        String uri2 = uri.toString();
        Intrinsics.checkNotNullExpressionValue(uri2, "uri.toString()");
        int lastIndexOf$default = StringsKt__StringsKt.lastIndexOf$default((CharSequence) uri2, '.', 0, false, 6, (Object) null);
        if (lastIndexOf$default == -1) {
            return null;
        }
        String substring = uri2.substring(lastIndexOf$default);
        Intrinsics.checkNotNullExpressionValue(substring, "(this as java.lang.String).substring(startIndex)");
        return substring;
    }

    @JvmStatic
    @Nullable
    public static final String getVideoUrl(@Nullable ShareVideoContent shareVideoContent, @NotNull UUID uuid) {
        Uri uri;
        ShareVideo video;
        Intrinsics.checkNotNullParameter(uuid, "appCallId");
        if (shareVideoContent == null || (video = shareVideoContent.getVideo()) == null) {
            uri = null;
        } else {
            uri = video.getLocalUrl();
        }
        if (uri == null) {
            return null;
        }
        NativeAppCallAttachmentStore.Attachment createAttachment = NativeAppCallAttachmentStore.createAttachment(uuid, uri);
        NativeAppCallAttachmentStore.addAttachments(CollectionsKt__CollectionsJVMKt.listOf(createAttachment));
        return createAttachment.getAttachmentUrl();
    }

    @JvmStatic
    public static final boolean handleActivityResult(int i11, int i12, @Nullable Intent intent, @Nullable ResultProcessor resultProcessor) {
        FacebookException facebookException;
        AppCall appCallFromActivityResult = INSTANCE.getAppCallFromActivityResult(i11, i12, intent);
        if (appCallFromActivityResult == null) {
            return false;
        }
        NativeAppCallAttachmentStore nativeAppCallAttachmentStore = NativeAppCallAttachmentStore.INSTANCE;
        NativeAppCallAttachmentStore.cleanupAttachmentsForCall(appCallFromActivityResult.getCallId());
        if (resultProcessor == null) {
            return true;
        }
        Bundle bundle = null;
        if (intent != null) {
            facebookException = NativeProtocol.getExceptionFromErrorData(NativeProtocol.getErrorDataFromResultIntent(intent));
        } else {
            facebookException = null;
        }
        if (facebookException == null) {
            if (intent != null) {
                bundle = NativeProtocol.getSuccessResultsFromIntent(intent);
            }
            resultProcessor.onSuccess(appCallFromActivityResult, bundle);
        } else if (facebookException instanceof FacebookOperationCanceledException) {
            resultProcessor.onCancel(appCallFromActivityResult);
        } else {
            resultProcessor.onError(appCallFromActivityResult, facebookException);
        }
        return true;
    }

    @JvmStatic
    public static final void invokeCallbackWithError(@Nullable FacebookCallback<Sharer.Result> facebookCallback, @Nullable String str) {
        invokeOnErrorCallback(facebookCallback, str);
    }

    @JvmStatic
    public static final void invokeCallbackWithException(@Nullable FacebookCallback<Sharer.Result> facebookCallback, @NotNull Exception exc) {
        Intrinsics.checkNotNullParameter(exc, "exception");
        if (exc instanceof FacebookException) {
            invokeOnErrorCallback(facebookCallback, (FacebookException) exc);
        } else {
            invokeCallbackWithError(facebookCallback, Intrinsics.stringPlus("Error preparing share content: ", exc.getLocalizedMessage()));
        }
    }

    @JvmStatic
    public static final void invokeCallbackWithResults(@Nullable FacebookCallback<Sharer.Result> facebookCallback, @Nullable String str, @NotNull GraphResponse graphResponse) {
        Intrinsics.checkNotNullParameter(graphResponse, "graphResponse");
        FacebookRequestError error = graphResponse.getError();
        if (error != null) {
            String errorMessage = error.getErrorMessage();
            if (Utility.isNullOrEmpty(errorMessage)) {
                errorMessage = "Unexpected error sharing.";
            }
            invokeOnErrorCallback(facebookCallback, graphResponse, errorMessage);
            return;
        }
        invokeOnSuccessCallback(facebookCallback, str);
    }

    @JvmStatic
    public static final void invokeOnCancelCallback(@Nullable FacebookCallback<Sharer.Result> facebookCallback) {
        INSTANCE.logShareResult(AnalyticsEvents.PARAMETER_SHARE_OUTCOME_CANCELLED, (String) null);
        if (facebookCallback != null) {
            facebookCallback.onCancel();
        }
    }

    @JvmStatic
    public static final void invokeOnErrorCallback(@Nullable FacebookCallback<Sharer.Result> facebookCallback, @Nullable GraphResponse graphResponse, @Nullable String str) {
        INSTANCE.logShareResult("error", str);
        if (facebookCallback != null) {
            facebookCallback.onError(new FacebookGraphResponseException(graphResponse, str));
        }
    }

    @JvmStatic
    public static final void invokeOnSuccessCallback(@Nullable FacebookCallback<Sharer.Result> facebookCallback, @Nullable String str) {
        INSTANCE.logShareResult("succeeded", (String) null);
        if (facebookCallback != null) {
            facebookCallback.onSuccess(new Sharer.Result(str));
        }
    }

    private final void logShareResult(String str, String str2) {
        InternalAppEventsLogger internalAppEventsLogger = new InternalAppEventsLogger(FacebookSdk.getApplicationContext());
        Bundle bundle = new Bundle();
        bundle.putString(AnalyticsEvents.PARAMETER_SHARE_OUTCOME, str);
        if (str2 != null) {
            bundle.putString("error_message", str2);
        }
        internalAppEventsLogger.logEventImplicitly(AnalyticsEvents.EVENT_SHARE_RESULT, bundle);
    }

    @JvmStatic
    @NotNull
    public static final GraphRequest newUploadStagingResourceWithImageRequest(@Nullable AccessToken accessToken, @Nullable Bitmap bitmap, @Nullable GraphRequest.Callback callback) {
        Bundle bundle = new Bundle(1);
        bundle.putParcelable("file", bitmap);
        return new GraphRequest(accessToken, MY_STAGING_RESOURCES, bundle, HttpMethod.POST, callback, (String) null, 32, (DefaultConstructorMarker) null);
    }

    @JvmStatic
    public static final void registerSharerCallback(int i11, @Nullable CallbackManager callbackManager, @Nullable FacebookCallback<Sharer.Result> facebookCallback) {
        if (callbackManager instanceof CallbackManagerImpl) {
            ((CallbackManagerImpl) callbackManager).registerCallback(i11, new b(i11, facebookCallback));
            return;
        }
        throw new FacebookException("Unexpected CallbackManager, please use the provided Factory.");
    }

    /* access modifiers changed from: private */
    /* renamed from: registerSharerCallback$lambda-1  reason: not valid java name */
    public static final boolean m9012registerSharerCallback$lambda1(int i11, FacebookCallback facebookCallback, int i12, Intent intent) {
        return handleActivityResult(i11, i12, intent, getShareResultProcessor(facebookCallback));
    }

    @JvmStatic
    public static final void registerStaticShareCallback(int i11) {
        CallbackManagerImpl.Companion.registerStaticCallback(i11, new a(i11));
    }

    /* access modifiers changed from: private */
    /* renamed from: registerStaticShareCallback$lambda-0  reason: not valid java name */
    public static final boolean m9013registerStaticShareCallback$lambda0(int i11, int i12, Intent intent) {
        return handleActivityResult(i11, i12, intent, getShareResultProcessor((FacebookCallback<Sharer.Result>) null));
    }

    @JvmStatic
    @NotNull
    public static final JSONArray removeNamespacesFromOGJsonArray(@NotNull JSONArray jSONArray, boolean z11) throws JSONException {
        Intrinsics.checkNotNullParameter(jSONArray, "jsonArray");
        JSONArray jSONArray2 = new JSONArray();
        int length = jSONArray.length();
        if (length > 0) {
            int i11 = 0;
            while (true) {
                int i12 = i11 + 1;
                Object obj = jSONArray.get(i11);
                if (obj instanceof JSONArray) {
                    obj = removeNamespacesFromOGJsonArray((JSONArray) obj, z11);
                } else if (obj instanceof JSONObject) {
                    obj = removeNamespacesFromOGJsonObject((JSONObject) obj, z11);
                }
                jSONArray2.put(obj);
                if (i12 >= length) {
                    break;
                }
                i11 = i12;
            }
        }
        return jSONArray2;
    }

    @JvmStatic
    @Nullable
    public static final JSONObject removeNamespacesFromOGJsonObject(@Nullable JSONObject jSONObject, boolean z11) {
        if (jSONObject == null) {
            return null;
        }
        try {
            JSONObject jSONObject2 = new JSONObject();
            JSONObject jSONObject3 = new JSONObject();
            JSONArray names = jSONObject.names();
            if (names == null) {
                return null;
            }
            int length = names.length();
            if (length > 0) {
                int i11 = 0;
                while (true) {
                    int i12 = i11 + 1;
                    String string = names.getString(i11);
                    Object obj = jSONObject.get(string);
                    if (obj instanceof JSONObject) {
                        obj = removeNamespacesFromOGJsonObject((JSONObject) obj, true);
                    } else if (obj instanceof JSONArray) {
                        obj = removeNamespacesFromOGJsonArray((JSONArray) obj, true);
                    }
                    Intrinsics.checkNotNullExpressionValue(string, "key");
                    Pair<String, String> fieldNameAndNamespaceFromFullName = getFieldNameAndNamespaceFromFullName(string);
                    String str = (String) fieldNameAndNamespaceFromFullName.first;
                    String str2 = (String) fieldNameAndNamespaceFromFullName.second;
                    if (z11) {
                        if (str == null || !Intrinsics.areEqual((Object) str, (Object) DeviceRequestsHelper.SDK_HEADER)) {
                            if (str != null) {
                                if (!Intrinsics.areEqual((Object) str, (Object) "og")) {
                                    jSONObject3.put(str2, obj);
                                }
                            }
                            jSONObject2.put(str2, obj);
                        } else {
                            jSONObject2.put(string, obj);
                        }
                    } else if (str == null || !Intrinsics.areEqual((Object) str, (Object) fb.f42395a)) {
                        jSONObject2.put(str2, obj);
                    } else {
                        jSONObject2.put(string, obj);
                    }
                    if (i12 >= length) {
                        break;
                    }
                    i11 = i12;
                }
            }
            if (jSONObject3.length() > 0) {
                jSONObject2.put("data", (Object) jSONObject3);
            }
            return jSONObject2;
        } catch (JSONException unused) {
            throw new FacebookException("Failed to create json object from share content");
        }
    }

    @JvmStatic
    public static final void invokeOnErrorCallback(@Nullable FacebookCallback<Sharer.Result> facebookCallback, @Nullable String str) {
        INSTANCE.logShareResult("error", str);
        if (facebookCallback != null) {
            facebookCallback.onError(new FacebookException(str));
        }
    }

    @JvmStatic
    @NotNull
    public static final GraphRequest newUploadStagingResourceWithImageRequest(@Nullable AccessToken accessToken, @Nullable File file, @Nullable GraphRequest.Callback callback) throws FileNotFoundException {
        GraphRequest.ParcelableResourceWithMimeType parcelableResourceWithMimeType = new GraphRequest.ParcelableResourceWithMimeType(ParcelFileDescriptor.open(file, 268435456), "image/png");
        Bundle bundle = new Bundle(1);
        bundle.putParcelable("file", parcelableResourceWithMimeType);
        return new GraphRequest(accessToken, MY_STAGING_RESOURCES, bundle, HttpMethod.POST, callback, (String) null, 32, (DefaultConstructorMarker) null);
    }

    @JvmStatic
    public static final void invokeOnErrorCallback(@Nullable FacebookCallback<Sharer.Result> facebookCallback, @NotNull FacebookException facebookException) {
        Intrinsics.checkNotNullParameter(facebookException, "ex");
        INSTANCE.logShareResult("error", facebookException.getMessage());
        if (facebookCallback != null) {
            facebookCallback.onError(facebookException);
        }
    }

    private final NativeAppCallAttachmentStore.Attachment getAttachment(UUID uuid, Uri uri, Bitmap bitmap) {
        if (bitmap != null) {
            return NativeAppCallAttachmentStore.createAttachment(uuid, bitmap);
        }
        if (uri != null) {
            return NativeAppCallAttachmentStore.createAttachment(uuid, uri);
        }
        return null;
    }

    @JvmStatic
    @NotNull
    public static final GraphRequest newUploadStagingResourceWithImageRequest(@Nullable AccessToken accessToken, @NotNull Uri uri, @Nullable GraphRequest.Callback callback) throws FileNotFoundException {
        Intrinsics.checkNotNullParameter(uri, "imageUri");
        String path = uri.getPath();
        if (Utility.isFileUri(uri) && path != null) {
            return newUploadStagingResourceWithImageRequest(accessToken, new File(path), callback);
        }
        if (Utility.isContentUri(uri)) {
            GraphRequest.ParcelableResourceWithMimeType parcelableResourceWithMimeType = new GraphRequest.ParcelableResourceWithMimeType(uri, "image/png");
            Bundle bundle = new Bundle(1);
            bundle.putParcelable("file", parcelableResourceWithMimeType);
            return new GraphRequest(accessToken, MY_STAGING_RESOURCES, bundle, HttpMethod.POST, callback, (String) null, 32, (DefaultConstructorMarker) null);
        }
        throw new FacebookException("The image Uri must be either a file:// or content:// Uri");
    }
}
