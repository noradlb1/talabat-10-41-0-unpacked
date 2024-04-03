package com.braze.ui.inappmessage.utils;

import android.content.Context;
import androidx.annotation.VisibleForTesting;
import com.braze.Braze;
import com.braze.coroutine.BrazeCoroutineScope;
import com.braze.enums.BrazeViewBounds;
import com.braze.enums.inappmessage.InAppMessageFailureType;
import com.braze.enums.inappmessage.MessageType;
import com.braze.images.IBrazeImageLoader;
import com.braze.models.inappmessage.IInAppMessage;
import com.braze.models.inappmessage.IInAppMessageWithImage;
import com.braze.models.inappmessage.IInAppMessageZippedAssetHtml;
import com.braze.models.inappmessage.InAppMessageFull;
import com.braze.models.inappmessage.InAppMessageHtml;
import com.braze.support.BrazeLogger;
import com.braze.support.WebContentUtils;
import com.braze.ui.inappmessage.BrazeInAppMessageManager;
import java.io.File;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0019\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H@ø\u0001\u0000¢\u0006\u0002\u0010\u0007J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u0006H\u0002J8\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\tH\u0002J\u0012\u0010\u0015\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0016\u001a\u00020\u0006H\u0002J\u0010\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u0006H\u0007J\u0012\u0010\u0018\u001a\u00020\u000b2\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0007J\u0010\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u001aH\u0007J\u0010\u0010\u001b\u001a\u00020\u000b2\u0006\u0010\u001c\u001a\u00020\u001dH\u0007\u0002\u0004\n\u0002\b\u0019¨\u0006\u001e"}, d2 = {"Lcom/braze/ui/inappmessage/utils/BackgroundInAppMessagePreparer;", "", "()V", "displayPreparedInAppMessage", "", "inAppMessage", "Lcom/braze/models/inappmessage/IInAppMessage;", "(Lcom/braze/models/inappmessage/IInAppMessage;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getViewBoundsByType", "Lcom/braze/enums/BrazeViewBounds;", "handleLocalImage", "", "localImageUrl", "", "inAppMessageWithImage", "Lcom/braze/models/inappmessage/IInAppMessageWithImage;", "imageLoader", "Lcom/braze/images/IBrazeImageLoader;", "applicationContext", "Landroid/content/Context;", "viewBounds", "prepareInAppMessage", "inAppMessageToPrepare", "prepareInAppMessageForDisplay", "prepareInAppMessageWithBitmapDownload", "prepareInAppMessageWithHtml", "Lcom/braze/models/inappmessage/InAppMessageHtml;", "prepareInAppMessageWithZippedAssetHtml", "inAppMessageHtml", "Lcom/braze/models/inappmessage/IInAppMessageZippedAssetHtml;", "android-sdk-ui_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class BackgroundInAppMessagePreparer {
    @NotNull
    public static final BackgroundInAppMessagePreparer INSTANCE = new BackgroundInAppMessagePreparer();

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[MessageType.values().length];
            iArr[MessageType.HTML_FULL.ordinal()] = 1;
            iArr[MessageType.HTML.ordinal()] = 2;
            iArr[MessageType.SLIDEUP.ordinal()] = 3;
            iArr[MessageType.MODAL.ordinal()] = 4;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    private BackgroundInAppMessagePreparer() {
    }

    /* access modifiers changed from: private */
    public final Object displayPreparedInAppMessage(IInAppMessage iInAppMessage, Continuation<? super Unit> continuation) {
        Object withContext = BuildersKt.withContext(Dispatchers.getMain(), new BackgroundInAppMessagePreparer$displayPreparedInAppMessage$2(this, iInAppMessage, (Continuation<? super BackgroundInAppMessagePreparer$displayPreparedInAppMessage$2>) null), continuation);
        return withContext == IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED() ? withContext : Unit.INSTANCE;
    }

    private final BrazeViewBounds getViewBoundsByType(IInAppMessage iInAppMessage) {
        int i11 = WhenMappings.$EnumSwitchMapping$0[iInAppMessage.getMessageType().ordinal()];
        if (i11 == 3) {
            return BrazeViewBounds.IN_APP_MESSAGE_SLIDEUP;
        }
        if (i11 != 4) {
            return BrazeViewBounds.NO_BOUNDS;
        }
        return BrazeViewBounds.IN_APP_MESSAGE_MODAL;
    }

    private final boolean handleLocalImage(String str, IInAppMessageWithImage iInAppMessageWithImage, IBrazeImageLoader iBrazeImageLoader, Context context, IInAppMessage iInAppMessage, BrazeViewBounds brazeViewBounds) {
        BrazeLogger brazeLogger = BrazeLogger.INSTANCE;
        BrazeLogger.brazelog$default(brazeLogger, (Object) this, BrazeLogger.Priority.I, (Throwable) null, false, (Function0) new BackgroundInAppMessagePreparer$handleLocalImage$1(str), 6, (Object) null);
        iInAppMessageWithImage.setBitmap(iBrazeImageLoader.getInAppMessageBitmapFromUrl(context, iInAppMessage, str, brazeViewBounds));
        if (iInAppMessageWithImage.getBitmap() != null) {
            iInAppMessageWithImage.setImageDownloadSuccessful(true);
            return true;
        }
        BrazeLogger.brazelog$default(brazeLogger, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, false, (Function0) new BackgroundInAppMessagePreparer$handleLocalImage$2(str), 7, (Object) null);
        iInAppMessageWithImage.setLocalImageUrl((String) null);
        return false;
    }

    /* access modifiers changed from: private */
    public final IInAppMessage prepareInAppMessage(IInAppMessage iInAppMessage) {
        IInAppMessage iInAppMessage2 = iInAppMessage;
        if (iInAppMessage.isControl()) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, false, (Function0) BackgroundInAppMessagePreparer$prepareInAppMessage$1.INSTANCE, 7, (Object) null);
            return iInAppMessage2;
        }
        BrazeLogger brazeLogger = BrazeLogger.INSTANCE;
        BrazeLogger.brazelog$default(brazeLogger, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, false, (Function0) BackgroundInAppMessagePreparer$prepareInAppMessage$2.INSTANCE, 7, (Object) null);
        int i11 = WhenMappings.$EnumSwitchMapping$0[iInAppMessage.getMessageType().ordinal()];
        if (i11 == 1) {
            if (!prepareInAppMessageWithZippedAssetHtml((IInAppMessageZippedAssetHtml) iInAppMessage2)) {
                BrazeLogger.brazelog$default(brazeLogger, (Object) this, BrazeLogger.Priority.W, (Throwable) null, false, (Function0) BackgroundInAppMessagePreparer$prepareInAppMessage$3.INSTANCE, 6, (Object) null);
                iInAppMessage2.logDisplayFailure(InAppMessageFailureType.ZIP_ASSET_DOWNLOAD);
                return null;
            }
        } else if (i11 == 2) {
            prepareInAppMessageWithHtml((InAppMessageHtml) iInAppMessage2);
        } else if (!prepareInAppMessageWithBitmapDownload(iInAppMessage)) {
            BrazeLogger.brazelog$default(brazeLogger, (Object) this, BrazeLogger.Priority.W, (Throwable) null, false, (Function0) BackgroundInAppMessagePreparer$prepareInAppMessage$4.INSTANCE, 6, (Object) null);
            iInAppMessage2.logDisplayFailure(InAppMessageFailureType.IMAGE_DOWNLOAD);
            return null;
        }
        return iInAppMessage2;
    }

    @JvmStatic
    public static final void prepareInAppMessageForDisplay(@NotNull IInAppMessage iInAppMessage) {
        Intrinsics.checkNotNullParameter(iInAppMessage, "inAppMessageToPrepare");
        Job unused = BuildersKt__Builders_commonKt.launch$default(BrazeCoroutineScope.INSTANCE, (CoroutineContext) null, (CoroutineStart) null, new BackgroundInAppMessagePreparer$prepareInAppMessageForDisplay$1(iInAppMessage, (Continuation<? super BackgroundInAppMessagePreparer$prepareInAppMessageForDisplay$1>) null), 3, (Object) null);
    }

    @JvmStatic
    @VisibleForTesting
    public static final boolean prepareInAppMessageWithBitmapDownload(@Nullable IInAppMessage iInAppMessage) {
        boolean z11;
        boolean z12;
        IInAppMessage iInAppMessage2 = iInAppMessage;
        if (!(iInAppMessage2 instanceof IInAppMessageWithImage)) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) INSTANCE, (BrazeLogger.Priority) null, (Throwable) null, false, (Function0) BackgroundInAppMessagePreparer$prepareInAppMessageWithBitmapDownload$1.INSTANCE, 7, (Object) null);
            return false;
        }
        IInAppMessageWithImage iInAppMessageWithImage = (IInAppMessageWithImage) iInAppMessage2;
        if (iInAppMessageWithImage.getBitmap() != null) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) INSTANCE, BrazeLogger.Priority.I, (Throwable) null, false, (Function0) BackgroundInAppMessagePreparer$prepareInAppMessageWithBitmapDownload$2.INSTANCE, 6, (Object) null);
            iInAppMessageWithImage.setImageDownloadSuccessful(true);
            return true;
        }
        BackgroundInAppMessagePreparer backgroundInAppMessagePreparer = INSTANCE;
        BrazeViewBounds viewBoundsByType = backgroundInAppMessagePreparer.getViewBoundsByType(iInAppMessage2);
        Context applicationContext = BrazeInAppMessageManager.Companion.getInstance().getApplicationContext();
        if (applicationContext == null) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) backgroundInAppMessagePreparer, BrazeLogger.Priority.W, (Throwable) null, false, (Function0) BackgroundInAppMessagePreparer$prepareInAppMessageWithBitmapDownload$3.INSTANCE, 6, (Object) null);
            return false;
        }
        IBrazeImageLoader imageLoader = Braze.Companion.getInstance(applicationContext).getImageLoader();
        String localImageUrl = iInAppMessageWithImage.getLocalImageUrl();
        if (localImageUrl == null || StringsKt__StringsJVMKt.isBlank(localImageUrl)) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (!z11 && backgroundInAppMessagePreparer.handleLocalImage(localImageUrl, iInAppMessageWithImage, imageLoader, applicationContext, iInAppMessage, viewBoundsByType)) {
            return true;
        }
        String remoteImageUrl = iInAppMessageWithImage.getRemoteImageUrl();
        if (remoteImageUrl == null || StringsKt__StringsJVMKt.isBlank(remoteImageUrl)) {
            z12 = true;
        } else {
            z12 = false;
        }
        if (!z12) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) backgroundInAppMessagePreparer, BrazeLogger.Priority.I, (Throwable) null, false, (Function0) new BackgroundInAppMessagePreparer$prepareInAppMessageWithBitmapDownload$4(remoteImageUrl), 6, (Object) null);
            iInAppMessageWithImage.setBitmap(imageLoader.getInAppMessageBitmapFromUrl(applicationContext, iInAppMessage2, remoteImageUrl, viewBoundsByType));
            if (iInAppMessageWithImage.getBitmap() == null) {
                return false;
            }
            iInAppMessageWithImage.setImageDownloadSuccessful(true);
            return true;
        }
        BrazeLogger brazeLogger = BrazeLogger.INSTANCE;
        BrazeLogger.Priority priority = BrazeLogger.Priority.W;
        BrazeLogger.brazelog$default(brazeLogger, (Object) backgroundInAppMessagePreparer, priority, (Throwable) null, false, (Function0) BackgroundInAppMessagePreparer$prepareInAppMessageWithBitmapDownload$5.INSTANCE, 6, (Object) null);
        if (!(iInAppMessageWithImage instanceof InAppMessageFull)) {
            return true;
        }
        BrazeLogger.brazelog$default(brazeLogger, (Object) backgroundInAppMessagePreparer, priority, (Throwable) null, false, (Function0) BackgroundInAppMessagePreparer$prepareInAppMessageWithBitmapDownload$6.INSTANCE, 6, (Object) null);
        return false;
    }

    @JvmStatic
    @VisibleForTesting
    public static final boolean prepareInAppMessageWithZippedAssetHtml(@NotNull IInAppMessageZippedAssetHtml iInAppMessageZippedAssetHtml) {
        boolean z11;
        boolean z12;
        boolean z13;
        IInAppMessageZippedAssetHtml iInAppMessageZippedAssetHtml2 = iInAppMessageZippedAssetHtml;
        Intrinsics.checkNotNullParameter(iInAppMessageZippedAssetHtml2, "inAppMessageHtml");
        String localAssetsDirectoryUrl = iInAppMessageZippedAssetHtml.getLocalAssetsDirectoryUrl();
        if (localAssetsDirectoryUrl == null || StringsKt__StringsJVMKt.isBlank(localAssetsDirectoryUrl)) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (z11 || !new File(localAssetsDirectoryUrl).exists()) {
            String assetsZipRemoteUrl = iInAppMessageZippedAssetHtml.getAssetsZipRemoteUrl();
            if (assetsZipRemoteUrl == null || StringsKt__StringsJVMKt.isBlank(assetsZipRemoteUrl)) {
                z12 = true;
            } else {
                z12 = false;
            }
            if (z12) {
                BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) INSTANCE, BrazeLogger.Priority.I, (Throwable) null, false, (Function0) BackgroundInAppMessagePreparer$prepareInAppMessageWithZippedAssetHtml$2.INSTANCE, 6, (Object) null);
                return true;
            }
            Context applicationContext = BrazeInAppMessageManager.Companion.getInstance().getApplicationContext();
            if (applicationContext == null) {
                BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) INSTANCE, BrazeLogger.Priority.W, (Throwable) null, false, (Function0) BackgroundInAppMessagePreparer$prepareInAppMessageWithZippedAssetHtml$3.INSTANCE, 6, (Object) null);
                return false;
            }
            String localHtmlUrlFromRemoteUrl = WebContentUtils.getLocalHtmlUrlFromRemoteUrl(WebContentUtils.getHtmlInAppMessageAssetCacheDirectory(applicationContext), assetsZipRemoteUrl);
            if (localHtmlUrlFromRemoteUrl == null || StringsKt__StringsJVMKt.isBlank(localHtmlUrlFromRemoteUrl)) {
                z13 = true;
            } else {
                z13 = false;
            }
            if (!z13) {
                BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) INSTANCE, (BrazeLogger.Priority) null, (Throwable) null, false, (Function0) new BackgroundInAppMessagePreparer$prepareInAppMessageWithZippedAssetHtml$4(localHtmlUrlFromRemoteUrl), 7, (Object) null);
                iInAppMessageZippedAssetHtml2.setLocalAssetsDirectoryUrl(localHtmlUrlFromRemoteUrl);
                return true;
            }
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) INSTANCE, BrazeLogger.Priority.W, (Throwable) null, false, (Function0) new BackgroundInAppMessagePreparer$prepareInAppMessageWithZippedAssetHtml$5(iInAppMessageZippedAssetHtml2, localHtmlUrlFromRemoteUrl), 6, (Object) null);
            return false;
        }
        BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) INSTANCE, BrazeLogger.Priority.I, (Throwable) null, false, (Function0) new BackgroundInAppMessagePreparer$prepareInAppMessageWithZippedAssetHtml$1(localAssetsDirectoryUrl), 6, (Object) null);
        return true;
    }

    @VisibleForTesting
    public final void prepareInAppMessageWithHtml(@NotNull InAppMessageHtml inAppMessageHtml) {
        Intrinsics.checkNotNullParameter(inAppMessageHtml, "inAppMessage");
        if (inAppMessageHtml.getLocalPrefetchedAssetPaths().isEmpty()) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, false, (Function0) BackgroundInAppMessagePreparer$prepareInAppMessageWithHtml$1.INSTANCE, 7, (Object) null);
            return;
        }
        String message = inAppMessageHtml.getMessage();
        if (message == null) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, false, (Function0) BackgroundInAppMessagePreparer$prepareInAppMessageWithHtml$2.INSTANCE, 7, (Object) null);
            return;
        }
        inAppMessageHtml.setMessage(WebContentUtils.replacePrefetchedUrlsWithLocalAssets(message, inAppMessageHtml.getLocalPrefetchedAssetPaths()));
    }
}
