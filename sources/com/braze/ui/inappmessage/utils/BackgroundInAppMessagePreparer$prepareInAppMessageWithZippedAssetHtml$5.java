package com.braze.ui.inappmessage.utils;

import com.braze.models.inappmessage.IInAppMessageZippedAssetHtml;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class BackgroundInAppMessagePreparer$prepareInAppMessageWithZippedAssetHtml$5 extends Lambda implements Function0<String> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ IInAppMessageZippedAssetHtml f44158g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ String f44159h;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public BackgroundInAppMessagePreparer$prepareInAppMessageWithZippedAssetHtml$5(IInAppMessageZippedAssetHtml iInAppMessageZippedAssetHtml, String str) {
        super(0);
        this.f44158g = iInAppMessageZippedAssetHtml;
        this.f44159h = str;
    }

    @NotNull
    public final String invoke() {
        return "Download of html content to local directory failed for remote url: " + this.f44158g.getAssetsZipRemoteUrl() + " . Returned local url is: " + this.f44159h;
    }
}
