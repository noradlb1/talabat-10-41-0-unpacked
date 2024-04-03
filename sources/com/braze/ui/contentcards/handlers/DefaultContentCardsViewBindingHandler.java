package com.braze.ui.contentcards.handlers;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import android.view.ViewGroup;
import androidx.annotation.VisibleForTesting;
import com.appboy.enums.CardType;
import com.appboy.models.cards.Card;
import com.braze.ui.contentcards.view.BannerImageContentCardView;
import com.braze.ui.contentcards.view.BaseContentCardView;
import com.braze.ui.contentcards.view.CaptionedImageContentCardView;
import com.braze.ui.contentcards.view.ContentCardViewHolder;
import com.braze.ui.contentcards.view.DefaultContentCardView;
import com.braze.ui.contentcards.view.ShortNewsContentCardView;
import com.braze.ui.contentcards.view.TextAnnouncementContentCardView;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u001e2\u00020\u0001:\u0001\u001eB\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0007\u001a\u00020\bH\u0016J\u001c\u0010\t\u001a\u0006\u0012\u0002\b\u00030\u00062\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0005H\u0007J&\u0010\r\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u000b2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f2\u0006\u0010\u0011\u001a\u00020\bH\u0016J.\u0010\u0012\u001a\u00020\u00132\u0006\u0010\n\u001a\u00020\u000b2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0011\u001a\u00020\bH\u0016J.\u0010\u0016\u001a\u00020\u00152\u0006\u0010\n\u001a\u00020\u000b2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f2\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\bH\u0016J\u0018\u0010\u001a\u001a\u00020\u00132\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\bH\u0016R\u001e\u0010\u0003\u001a\u0012\u0012\u0004\u0012\u00020\u0005\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00060\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\u001f"}, d2 = {"Lcom/braze/ui/contentcards/handlers/DefaultContentCardsViewBindingHandler;", "Lcom/braze/ui/contentcards/handlers/IContentCardsViewBindingHandler;", "()V", "contentCardViewCache", "", "Lcom/appboy/enums/CardType;", "Lcom/braze/ui/contentcards/view/BaseContentCardView;", "describeContents", "", "getContentCardsViewFromCache", "context", "Landroid/content/Context;", "cardType", "getItemViewType", "cards", "", "Lcom/appboy/models/cards/Card;", "adapterPosition", "onBindViewHolder", "", "viewHolder", "Lcom/braze/ui/contentcards/view/ContentCardViewHolder;", "onCreateViewHolder", "viewGroup", "Landroid/view/ViewGroup;", "viewType", "writeToParcel", "dest", "Landroid/os/Parcel;", "flags", "Companion", "android-sdk-ui_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class DefaultContentCardsViewBindingHandler implements IContentCardsViewBindingHandler {
    @NotNull
    @JvmField
    public static final Parcelable.Creator<DefaultContentCardsViewBindingHandler> CREATOR = new DefaultContentCardsViewBindingHandler$Companion$CREATOR$1();
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @NotNull
    private final Map<CardType, BaseContentCardView<?>> contentCardViewCache = new LinkedHashMap();

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0016\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/braze/ui/contentcards/handlers/DefaultContentCardsViewBindingHandler$Companion;", "", "()V", "CREATOR", "Landroid/os/Parcelable$Creator;", "Lcom/braze/ui/contentcards/handlers/DefaultContentCardsViewBindingHandler;", "android-sdk-ui_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[CardType.values().length];
            iArr[CardType.BANNER.ordinal()] = 1;
            iArr[CardType.CAPTIONED_IMAGE.ordinal()] = 2;
            iArr[CardType.SHORT_NEWS.ordinal()] = 3;
            iArr[CardType.TEXT_ANNOUNCEMENT.ordinal()] = 4;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public int describeContents() {
        return 0;
    }

    @NotNull
    @VisibleForTesting
    public final BaseContentCardView<?> getContentCardsViewFromCache(@NotNull Context context, @NotNull CardType cardType) {
        Object obj;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(cardType, "cardType");
        if (!this.contentCardViewCache.containsKey(cardType) || this.contentCardViewCache.get(cardType) == null) {
            int i11 = WhenMappings.$EnumSwitchMapping$0[cardType.ordinal()];
            if (i11 == 1) {
                obj = new BannerImageContentCardView(context);
            } else if (i11 == 2) {
                obj = new CaptionedImageContentCardView(context);
            } else if (i11 == 3) {
                obj = new ShortNewsContentCardView(context);
            } else if (i11 != 4) {
                obj = new DefaultContentCardView(context);
            } else {
                obj = new TextAnnouncementContentCardView(context);
            }
            this.contentCardViewCache.put(cardType, obj);
        }
        BaseContentCardView<?> baseContentCardView = this.contentCardViewCache.get(cardType);
        if (baseContentCardView == null) {
            return new DefaultContentCardView(context);
        }
        return baseContentCardView;
    }

    public int getItemViewType(@NotNull Context context, @NotNull List<? extends Card> list, int i11) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(list, "cards");
        if (i11 < 0 || i11 >= list.size()) {
            return -1;
        }
        return ((Card) list.get(i11)).getCardType().getValue();
    }

    public void onBindViewHolder(@NotNull Context context, @NotNull List<? extends Card> list, @NotNull ContentCardViewHolder contentCardViewHolder, int i11) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(list, "cards");
        Intrinsics.checkNotNullParameter(contentCardViewHolder, "viewHolder");
        if (i11 >= 0 && i11 < list.size()) {
            Card card = (Card) list.get(i11);
            getContentCardsViewFromCache(context, card.getCardType()).bindViewHolder(contentCardViewHolder, card);
        }
    }

    @NotNull
    public ContentCardViewHolder onCreateViewHolder(@NotNull Context context, @NotNull List<? extends Card> list, @NotNull ViewGroup viewGroup, int i11) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(list, "cards");
        Intrinsics.checkNotNullParameter(viewGroup, "viewGroup");
        return getContentCardsViewFromCache(context, CardType.Companion.fromValue(i11)).createViewHolder(viewGroup);
    }

    public void writeToParcel(@NotNull Parcel parcel, int i11) {
        Intrinsics.checkNotNullParameter(parcel, "dest");
    }
}
