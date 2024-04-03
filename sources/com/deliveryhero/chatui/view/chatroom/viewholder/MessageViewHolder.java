package com.deliveryhero.chatui.view.chatroom.viewholder;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.content.res.ResourcesCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.deliveryhero.chatui.view.chatroom.ChatMessageViewModel;
import com.deliveryhero.chatui.view.chatroom.ImageMessage;
import com.deliveryhero.chatui.view.chatroom.LocationMessage;
import com.deliveryhero.chatui.view.chatroom.TextMessage;
import com.deliveryhero.chatui.view.chatroom.adapter.listener.ClickedItem;
import com.deliveryhero.chatui.view.chatroom.adapter.listener.MessageClickListener;
import com.deliveryhero.customerchat.R;
import com.squareup.picasso.MemoryPolicy;
import com.squareup.picasso.Picasso;
import java.io.File;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import s4.b;
import s4.c;

@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0010\u0018\u0000 32\u00020\u0001:\u00013B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020#H\u0016J\u000e\u0010$\u001a\u00020!2\u0006\u0010%\u001a\u00020&J\u000e\u0010'\u001a\u00020!2\u0006\u0010(\u001a\u00020)J\u000e\u0010*\u001a\u00020!2\u0006\u0010+\u001a\u00020,J\u000e\u0010-\u001a\u00020!2\u0006\u0010.\u001a\u00020/J\u0010\u00100\u001a\u00020!2\u0006\u00101\u001a\u000202H\u0002R\u001b\u0010\u0007\u001a\u00020\b8@X\u0002¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\t\u0010\nR\u000e\u0010\r\u001a\u00020\u000eX\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u000eX\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0010X\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\u0013\u001a\u00020\u00148BX\u0002¢\u0006\f\n\u0004\b\u0017\u0010\f\u001a\u0004\b\u0015\u0010\u0016R\u001b\u0010\u0018\u001a\u00020\u00038BX\u0002¢\u0006\f\n\u0004\b\u001b\u0010\f\u001a\u0004\b\u0019\u0010\u001aR\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\u001c\u001a\u00020\b8BX\u0002¢\u0006\f\n\u0004\b\u001e\u0010\f\u001a\u0004\b\u001d\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u001a¨\u00064"}, d2 = {"Lcom/deliveryhero/chatui/view/chatroom/viewholder/MessageViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "view", "Landroid/view/View;", "messageClickListener", "Lcom/deliveryhero/chatui/view/chatroom/adapter/listener/MessageClickListener;", "(Landroid/view/View;Lcom/deliveryhero/chatui/view/chatroom/adapter/listener/MessageClickListener;)V", "dateTextView", "Landroid/widget/TextView;", "getDateTextView$customerchat_basicRelease", "()Landroid/widget/TextView;", "dateTextView$delegate", "Lkotlin/Lazy;", "imageFailedDrawableRes", "", "imageFailedThumbnail", "Landroid/graphics/drawable/Drawable;", "imageLoadingDrawableRes", "imageLoadingThumbnail", "imageMessageView", "Landroid/widget/ImageView;", "getImageMessageView", "()Landroid/widget/ImageView;", "imageMessageView$delegate", "locationMessageContent", "getLocationMessageContent", "()Landroid/view/View;", "locationMessageContent$delegate", "messageTextView", "getMessageTextView", "messageTextView$delegate", "getView", "bind", "", "viewModel", "Lcom/deliveryhero/chatui/view/chatroom/ChatMessageViewModel;", "setDate", "date", "", "setImageMessage", "imageMessage", "Lcom/deliveryhero/chatui/view/chatroom/ImageMessage;", "setLocationMessage", "locationMessage", "Lcom/deliveryhero/chatui/view/chatroom/LocationMessage;", "setTextMessage", "textMessage", "Lcom/deliveryhero/chatui/view/chatroom/TextMessage;", "showLocationMessage", "location", "Lcom/deliveryhero/chatui/view/chatroom/LocationMessage$Location;", "Companion", "customerchat_basicRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public class MessageViewHolder extends RecyclerView.ViewHolder {
    @NotNull
    private static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @Deprecated
    public static final int IMAGE_DIMENSION = 500;
    @NotNull
    private final Lazy dateTextView$delegate = LazyKt__LazyJVMKt.lazy(new MessageViewHolder$dateTextView$2(this));
    private final int imageFailedDrawableRes;
    @Nullable
    private final Drawable imageFailedThumbnail;
    private final int imageLoadingDrawableRes;
    @Nullable
    private final Drawable imageLoadingThumbnail;
    @NotNull
    private final Lazy imageMessageView$delegate = LazyKt__LazyJVMKt.lazy(new MessageViewHolder$imageMessageView$2(this));
    @NotNull
    private final Lazy locationMessageContent$delegate = LazyKt__LazyJVMKt.lazy(new MessageViewHolder$locationMessageContent$2(this));
    @NotNull
    private final MessageClickListener messageClickListener;
    @NotNull
    private final Lazy messageTextView$delegate = LazyKt__LazyJVMKt.lazy(new MessageViewHolder$messageTextView$2(this));
    @NotNull
    private final View view;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/deliveryhero/chatui/view/chatroom/viewholder/MessageViewHolder$Companion;", "", "()V", "IMAGE_DIMENSION", "", "customerchat_basicRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public MessageViewHolder(@NotNull View view2, @NotNull MessageClickListener messageClickListener2) {
        super(view2);
        Intrinsics.checkNotNullParameter(view2, "view");
        Intrinsics.checkNotNullParameter(messageClickListener2, "messageClickListener");
        this.view = view2;
        this.messageClickListener = messageClickListener2;
        int i11 = R.drawable.customer_chat_loading_spinner;
        this.imageLoadingDrawableRes = i11;
        int i12 = R.drawable.customer_chat_ic_download_failed;
        this.imageFailedDrawableRes = i12;
        this.imageLoadingThumbnail = ResourcesCompat.getDrawable(view2.getResources(), i11, (Resources.Theme) null);
        this.imageFailedThumbnail = ResourcesCompat.getDrawable(view2.getResources(), i12, (Resources.Theme) null);
    }

    private final ImageView getImageMessageView() {
        return (ImageView) this.imageMessageView$delegate.getValue();
    }

    private final View getLocationMessageContent() {
        Object value = this.locationMessageContent$delegate.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-locationMessageContent>(...)");
        return (View) value;
    }

    private final TextView getMessageTextView() {
        return (TextView) this.messageTextView$delegate.getValue();
    }

    /* access modifiers changed from: private */
    /* renamed from: setImageMessage$lambda-0  reason: not valid java name */
    public static final void m8166setImageMessage$lambda0(MessageViewHolder messageViewHolder, ImageMessage imageMessage, View view2) {
        Intrinsics.checkNotNullParameter(messageViewHolder, "this$0");
        Intrinsics.checkNotNullParameter(imageMessage, "$imageMessage");
        messageViewHolder.messageClickListener.onClicked(new ClickedItem.ImageItem(((ImageMessage.Downloading) imageMessage).getUrl()));
    }

    private final void showLocationMessage(LocationMessage.Location location) {
        getLocationMessageContent().setVisibility(0);
        getLocationMessageContent().setOnClickListener(new c(this, location));
    }

    /* access modifiers changed from: private */
    /* renamed from: showLocationMessage$lambda-2  reason: not valid java name */
    public static final void m8167showLocationMessage$lambda2(MessageViewHolder messageViewHolder, LocationMessage.Location location, View view2) {
        Intrinsics.checkNotNullParameter(messageViewHolder, "this$0");
        Intrinsics.checkNotNullParameter(location, "$location");
        messageViewHolder.messageClickListener.onClicked(new ClickedItem.LocationItem(location.getLatitude(), location.getLongitude()));
    }

    public void bind(@NotNull ChatMessageViewModel chatMessageViewModel) {
        Intrinsics.checkNotNullParameter(chatMessageViewModel, "viewModel");
        setTextMessage(chatMessageViewModel.getOriginalMessage());
        setImageMessage(chatMessageViewModel.getImageMessage());
        setLocationMessage(chatMessageViewModel.getLocationMessage());
        setDate(chatMessageViewModel.getDate());
    }

    @NotNull
    public final TextView getDateTextView$customerchat_basicRelease() {
        return (TextView) this.dateTextView$delegate.getValue();
    }

    @NotNull
    public final View getView() {
        return this.view;
    }

    public final void setDate(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "date");
        getDateTextView$customerchat_basicRelease().setText(str);
    }

    public final void setImageMessage(@NotNull ImageMessage imageMessage) {
        Unit unit;
        Intrinsics.checkNotNullParameter(imageMessage, "imageMessage");
        if (imageMessage instanceof ImageMessage.Hidden) {
            getImageMessageView().setVisibility(((ImageMessage.Hidden) imageMessage).getVisibility());
        } else if (imageMessage instanceof ImageMessage.Uploading) {
            getImageMessageView().setVisibility(((ImageMessage.Uploading) imageMessage).getVisibility());
            getImageMessageView().setImageDrawable(this.imageLoadingThumbnail);
        } else if (imageMessage instanceof ImageMessage.Downloading) {
            ImageMessage.Downloading downloading = (ImageMessage.Downloading) imageMessage;
            getImageMessageView().setVisibility(downloading.getVisibility());
            Picasso.get().load(downloading.getThumbnail().getUrl()).placeholder(this.imageLoadingDrawableRes).error(this.imageFailedDrawableRes).resize(500, 500).centerInside().onlyScaleDown().into(getImageMessageView());
            getImageMessageView().setOnClickListener(new b(this, imageMessage));
        } else if (imageMessage instanceof ImageMessage.UploadFailed) {
            ImageMessage.UploadFailed uploadFailed = (ImageMessage.UploadFailed) imageMessage;
            getImageMessageView().setVisibility(uploadFailed.getVisibility());
            if (uploadFailed.getUrl() != null) {
                Picasso.get().load(new File(uploadFailed.getUrl())).memoryPolicy(MemoryPolicy.NO_CACHE, new MemoryPolicy[0]).placeholder(this.imageLoadingDrawableRes).error(this.imageFailedDrawableRes).centerCrop().resize(500, 500).onlyScaleDown().into(getImageMessageView());
                unit = Unit.INSTANCE;
            } else {
                unit = null;
            }
            if (unit == null) {
                getImageMessageView().setImageDrawable(this.imageFailedThumbnail);
            }
        }
    }

    public final void setLocationMessage(@NotNull LocationMessage locationMessage) {
        Intrinsics.checkNotNullParameter(locationMessage, "locationMessage");
        if (locationMessage instanceof LocationMessage.Location) {
            showLocationMessage((LocationMessage.Location) locationMessage);
        } else {
            getLocationMessageContent().setVisibility(8);
        }
    }

    public final void setTextMessage(@NotNull TextMessage textMessage) {
        Intrinsics.checkNotNullParameter(textMessage, "textMessage");
        getMessageTextView().setVisibility(textMessage.getVisibility());
        getMessageTextView().setText(textMessage.getMessage());
    }
}
