package com.appboy.ui.widget;

import android.content.Context;
import android.os.Bundle;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.appboy.models.cards.Card;
import com.appboy.ui.R;
import com.appboy.ui.feed.AppboyImageSwitcher;
import com.braze.Braze;
import com.braze.configuration.BrazeConfigurationProvider;
import com.braze.enums.BrazeViewBounds;
import com.braze.images.IBrazeImageLoader;
import com.braze.support.BrazeLogger;
import com.braze.ui.BrazeDeeplinkHandler;
import com.braze.ui.actions.IAction;
import com.braze.ui.actions.UriAction;
import com.talabat.observability.squads.nfv.ObservableAttributesNames;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b&\u0018\u0000 &*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0003:\u0001&B\r\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\"\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00022\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0004J\"\u0010\u001a\u001a\u00020\u00132\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00022\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H$J\u0018\u0010\u001b\u001a\u00020\u00172\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\u0006\u0010\b\u001a\u00020\u0002J&\u0010\u001c\u001a\u00020\u00172\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u000b2\u0006\u0010 \u001a\u00020!2\u0006\u0010\b\u001a\u00020\u0002J\u0018\u0010\"\u001a\u00020\u00172\u0006\u0010#\u001a\u00020$2\b\u0010%\u001a\u0004\u0018\u00010\u000bR\u0010\u0010\u0007\u001a\u00020\u00058\u0004X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\b\u001a\u0004\u0018\u00018\u00008\u0004@\u0004X\u000e¢\u0006\u0004\n\u0002\u0010\tR\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0012\u0010\u000e\u001a\u00020\u000f8\u0004@\u0004X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0010\u001a\u0004\u0018\u00010\u00118\u0006@\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0014\u001a\u00020\u00138F¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015¨\u0006'"}, d2 = {"Lcom/appboy/ui/widget/BaseCardView;", "T", "Lcom/appboy/models/cards/Card;", "Landroid/widget/RelativeLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "applicationContext", "card", "Lcom/appboy/models/cards/Card;", "classLogTag", "", "getClassLogTag", "()Ljava/lang/String;", "configurationProvider", "Lcom/braze/configuration/BrazeConfigurationProvider;", "imageSwitcher", "Lcom/appboy/ui/feed/AppboyImageSwitcher;", "isUnreadCardVisualIndicatorEnabled", "", "isUnreadIndicatorEnabled", "()Z", "handleCardClick", "", "cardAction", "Lcom/braze/ui/actions/IAction;", "isClickHandled", "setCardViewedIndicator", "setImageViewToUrl", "imageView", "Landroid/widget/ImageView;", "imageUrl", "placeholderAspectRatio", "", "setOptionalTextView", "view", "Landroid/widget/TextView;", "text", "Companion", "android-sdk-ui_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public abstract class BaseCardView<T extends Card> extends RelativeLayout {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @NotNull
    private static final String ICON_READ_TAG = "icon_read";
    @NotNull
    private static final String ICON_UNREAD_TAG = "icon_unread";
    @NotNull
    @JvmField
    protected final Context applicationContext;
    @Nullable
    @JvmField
    protected T card;
    @NotNull
    private final String classLogTag = BrazeLogger.getBrazeLogTag(getClass());
    @NotNull
    @JvmField
    protected BrazeConfigurationProvider configurationProvider;
    @Nullable
    @JvmField
    public AppboyImageSwitcher imageSwitcher;
    private boolean isUnreadCardVisualIndicatorEnabled;

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\tH\u0005R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/appboy/ui/widget/BaseCardView$Companion;", "", "()V", "ICON_READ_TAG", "", "ICON_UNREAD_TAG", "getUriActionForCard", "Lcom/braze/ui/actions/UriAction;", "card", "Lcom/appboy/models/cards/Card;", "android-sdk-ui_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        @Nullable
        public final UriAction getUriActionForCard(@NotNull Card card) {
            Intrinsics.checkNotNullParameter(card, "card");
            Bundle bundle = new Bundle();
            for (String next : card.getExtras().keySet()) {
                bundle.putString(next, card.getExtras().get(next));
            }
            String url = card.getUrl();
            if (url != null) {
                return BrazeDeeplinkHandler.Companion.getInstance().createUriActionFromUrlString(url, bundle, card.getOpenUriInWebView(), card.getChannel());
            }
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.V, (Throwable) null, false, (Function0) BaseCardView$Companion$getUriActionForCard$1.INSTANCE, 6, (Object) null);
            return null;
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public BaseCardView(@NotNull Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        Context applicationContext2 = context.getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(applicationContext2, "context.applicationContext");
        this.applicationContext = applicationContext2;
        BrazeConfigurationProvider brazeConfigurationProvider = new BrazeConfigurationProvider(context);
        this.configurationProvider = brazeConfigurationProvider;
        this.isUnreadCardVisualIndicatorEnabled = brazeConfigurationProvider.isNewsfeedVisualIndicatorOn();
    }

    @JvmStatic
    @Nullable
    public static final UriAction getUriActionForCard(@NotNull Card card2) {
        return Companion.getUriActionForCard(card2);
    }

    @NotNull
    public final String getClassLogTag() {
        return this.classLogTag;
    }

    public final void handleCardClick(@NotNull Context context, @NotNull Card card2, @Nullable IAction iAction) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(card2, "card");
        BrazeLogger brazeLogger = BrazeLogger.INSTANCE;
        BrazeLogger.Priority priority = BrazeLogger.Priority.V;
        BrazeLogger.brazelog$default(brazeLogger, (Object) this, priority, (Throwable) null, false, (Function0) new BaseCardView$handleCardClick$1(card2), 6, (Object) null);
        card2.setIndicatorHighlighted(true);
        if (isClickHandled(context, card2, iAction)) {
            BrazeLogger.brazelog$default(brazeLogger, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, false, (Function0) new BaseCardView$handleCardClick$5(card2), 7, (Object) null);
            card2.logClick();
        } else if (iAction != null) {
            card2.logClick();
            BrazeLogger.brazelog$default(brazeLogger, (Object) this, priority, (Throwable) null, false, (Function0) new BaseCardView$handleCardClick$2(card2), 6, (Object) null);
            if (iAction instanceof UriAction) {
                BrazeDeeplinkHandler.Companion.getInstance().gotoUri(context, (UriAction) iAction);
                return;
            }
            BrazeLogger.brazelog$default(brazeLogger, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, false, (Function0) new BaseCardView$handleCardClick$3(card2), 7, (Object) null);
            iAction.execute(context);
        } else {
            BrazeLogger.brazelog$default(brazeLogger, (Object) this, priority, (Throwable) null, false, (Function0) new BaseCardView$handleCardClick$4(card2), 6, (Object) null);
        }
    }

    public abstract boolean isClickHandled(@NotNull Context context, @NotNull Card card2, @Nullable IAction iAction);

    public final boolean isUnreadIndicatorEnabled() {
        return this.isUnreadCardVisualIndicatorEnabled;
    }

    public final void setCardViewedIndicator(@Nullable AppboyImageSwitcher appboyImageSwitcher, @NotNull Card card2) {
        Intrinsics.checkNotNullParameter(card2, "card");
        if (appboyImageSwitcher == null) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.W, (Throwable) null, false, (Function0) BaseCardView$setCardViewedIndicator$1.INSTANCE, 6, (Object) null);
            return;
        }
        int i11 = R.string.com_braze_image_is_read_tag_key;
        Object tag = appboyImageSwitcher.getTag(i11);
        if (tag == null) {
            tag = "";
        }
        if (card2.isIndicatorHighlighted()) {
            if (!Intrinsics.areEqual(tag, (Object) ICON_READ_TAG)) {
                if (appboyImageSwitcher.getReadIcon() != null) {
                    appboyImageSwitcher.setImageDrawable(appboyImageSwitcher.getReadIcon());
                } else {
                    appboyImageSwitcher.setImageResource(R.drawable.com_braze_content_card_icon_read);
                }
                appboyImageSwitcher.setTag(i11, ICON_READ_TAG);
            }
        } else if (!Intrinsics.areEqual(tag, (Object) ICON_UNREAD_TAG)) {
            if (appboyImageSwitcher.getUnReadIcon() != null) {
                appboyImageSwitcher.setImageDrawable(appboyImageSwitcher.getUnReadIcon());
            } else {
                appboyImageSwitcher.setImageResource(R.drawable.com_braze_content_card_icon_unread);
            }
            appboyImageSwitcher.setTag(i11, ICON_UNREAD_TAG);
        }
    }

    public final void setImageViewToUrl(@NotNull ImageView imageView, @NotNull String str, float f11, @NotNull Card card2) {
        boolean z11;
        Intrinsics.checkNotNullParameter(imageView, "imageView");
        Intrinsics.checkNotNullParameter(str, ObservableAttributesNames.IMAGE_URL_V2);
        Intrinsics.checkNotNullParameter(card2, "card");
        int i11 = R.string.com_braze_image_resize_tag_key;
        if (!Intrinsics.areEqual((Object) str, imageView.getTag(i11))) {
            if (f11 == 0.0f) {
                z11 = true;
            } else {
                z11 = false;
            }
            if (!z11) {
                ViewTreeObserver viewTreeObserver = imageView.getViewTreeObserver();
                if (viewTreeObserver.isAlive()) {
                    viewTreeObserver.addOnPreDrawListener(new BaseCardView$setImageViewToUrl$1(imageView, f11));
                }
            }
            imageView.setImageResource(17170445);
            Braze.Companion companion = Braze.Companion;
            Context context = getContext();
            Intrinsics.checkNotNullExpressionValue(context, "context");
            IBrazeImageLoader imageLoader = companion.getInstance(context).getImageLoader();
            Context context2 = getContext();
            Intrinsics.checkNotNullExpressionValue(context2, "context");
            imageLoader.renderUrlIntoCardView(context2, card2, str, imageView, BrazeViewBounds.BASE_CARD_VIEW);
            imageView.setTag(i11, str);
        }
    }

    public final void setOptionalTextView(@NotNull TextView textView, @Nullable String str) {
        boolean z11;
        Intrinsics.checkNotNullParameter(textView, "view");
        if (str == null || StringsKt__StringsJVMKt.isBlank(str)) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (!z11) {
            textView.setText(str);
            textView.setVisibility(0);
            return;
        }
        textView.setText("");
        textView.setVisibility(8);
    }
}
