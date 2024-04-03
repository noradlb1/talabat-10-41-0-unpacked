package com.deliveryhero.chatui.view.chatroom.customview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import androidx.appcompat.widget.AppCompatImageButton;
import com.deliveryhero.chatui.view.chatroom.AttachmentViewOptions;
import com.deliveryhero.customerchat.R;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import q4.a;
import q4.b;
import q4.c;
import q4.d;

@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001:\u0001\u001cB%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u000e\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014J\u000e\u0010\u0015\u001a\u00020\u00122\u0006\u0010\u0016\u001a\u00020\u0017J\u001a\u0010\u0018\u001a\u00020\u00122\u0012\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020\u00120\u001aR\u000e\u0010\t\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fXD¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u000fXD¢\u0006\u0002\n\u0000¨\u0006\u001d"}, d2 = {"Lcom/deliveryhero/chatui/view/chatroom/customview/AttachmentView;", "Landroid/widget/LinearLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "addButton", "Landroidx/appcompat/widget/AppCompatImageButton;", "cameraButton", "galleryButton", "locationButton", "opaque", "", "translucent", "bind", "", "attachmentView", "Lcom/deliveryhero/chatui/view/chatroom/AttachmentViewOptions;", "isEnableButtons", "isEnabled", "", "onActionsClick", "clickListener", "Lkotlin/Function1;", "Lcom/deliveryhero/chatui/view/chatroom/customview/AttachmentView$AttachmentTypes;", "AttachmentTypes", "customerchat_basicRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class AttachmentView extends LinearLayout {
    @NotNull
    private AppCompatImageButton addButton;
    @NotNull
    private AppCompatImageButton cameraButton;
    @NotNull
    private AppCompatImageButton galleryButton;
    @NotNull
    private AppCompatImageButton locationButton;
    private final float opaque;
    private final float translucent;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/deliveryhero/chatui/view/chatroom/customview/AttachmentView$AttachmentTypes;", "", "(Ljava/lang/String;I)V", "GALLERY", "CAMERA", "LOCATION", "ADD", "customerchat_basicRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public enum AttachmentTypes {
        GALLERY,
        CAMERA,
        LOCATION,
        ADD
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public AttachmentView(@NotNull Context context) {
        this(context, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public AttachmentView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ AttachmentView(Context context, AttributeSet attributeSet, int i11, int i12, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i12 & 2) != 0 ? null : attributeSet, (i12 & 4) != 0 ? 0 : i11);
    }

    /* access modifiers changed from: private */
    /* renamed from: onActionsClick$lambda-0  reason: not valid java name */
    public static final void m8159onActionsClick$lambda0(Function1 function1, View view) {
        Intrinsics.checkNotNullParameter(function1, "$clickListener");
        function1.invoke(AttachmentTypes.ADD);
    }

    /* access modifiers changed from: private */
    /* renamed from: onActionsClick$lambda-1  reason: not valid java name */
    public static final void m8160onActionsClick$lambda1(Function1 function1, View view) {
        Intrinsics.checkNotNullParameter(function1, "$clickListener");
        function1.invoke(AttachmentTypes.CAMERA);
    }

    /* access modifiers changed from: private */
    /* renamed from: onActionsClick$lambda-2  reason: not valid java name */
    public static final void m8161onActionsClick$lambda2(Function1 function1, View view) {
        Intrinsics.checkNotNullParameter(function1, "$clickListener");
        function1.invoke(AttachmentTypes.GALLERY);
    }

    /* access modifiers changed from: private */
    /* renamed from: onActionsClick$lambda-3  reason: not valid java name */
    public static final void m8162onActionsClick$lambda3(Function1 function1, View view) {
        Intrinsics.checkNotNullParameter(function1, "$clickListener");
        function1.invoke(AttachmentTypes.LOCATION);
    }

    public final void bind(@NotNull AttachmentViewOptions attachmentViewOptions) {
        Intrinsics.checkNotNullParameter(attachmentViewOptions, "attachmentView");
        this.galleryButton.setVisibility(attachmentViewOptions.getGalleryVisibility());
        this.cameraButton.setVisibility(attachmentViewOptions.getCameraVisibility());
        this.locationButton.setVisibility(attachmentViewOptions.getLocationVisibility());
        this.addButton.setVisibility(attachmentViewOptions.getAddVisibility());
    }

    public final void isEnableButtons(boolean z11) {
        float f11;
        float f12;
        float f13;
        float f14;
        this.galleryButton.setEnabled(z11);
        this.cameraButton.setEnabled(z11);
        this.locationButton.setEnabled(z11);
        this.addButton.setEnabled(z11);
        AppCompatImageButton appCompatImageButton = this.galleryButton;
        if (z11) {
            f11 = this.opaque;
        } else {
            f11 = this.translucent;
        }
        appCompatImageButton.setAlpha(f11);
        AppCompatImageButton appCompatImageButton2 = this.cameraButton;
        if (z11) {
            f12 = this.opaque;
        } else {
            f12 = this.translucent;
        }
        appCompatImageButton2.setAlpha(f12);
        AppCompatImageButton appCompatImageButton3 = this.locationButton;
        if (z11) {
            f13 = this.opaque;
        } else {
            f13 = this.translucent;
        }
        appCompatImageButton3.setAlpha(f13);
        AppCompatImageButton appCompatImageButton4 = this.addButton;
        if (z11) {
            f14 = this.opaque;
        } else {
            f14 = this.translucent;
        }
        appCompatImageButton4.setAlpha(f14);
    }

    public final void onActionsClick(@NotNull Function1<? super AttachmentTypes, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "clickListener");
        this.addButton.setOnClickListener(new a(function1));
        this.cameraButton.setOnClickListener(new b(function1));
        this.galleryButton.setOnClickListener(new c(function1));
        this.locationButton.setOnClickListener(new d(function1));
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public AttachmentView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        Intrinsics.checkNotNullParameter(context, "context");
        View.inflate(context, R.layout.customer_chat_include_layout_attachment, this);
        View findViewById = findViewById(R.id.button_share_location);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.button_share_location)");
        this.locationButton = (AppCompatImageButton) findViewById;
        View findViewById2 = findViewById(R.id.button_compose_camera);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(R.id.button_compose_camera)");
        this.cameraButton = (AppCompatImageButton) findViewById2;
        View findViewById3 = findViewById(R.id.button_compose_gallery);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById(R.id.button_compose_gallery)");
        this.galleryButton = (AppCompatImageButton) findViewById3;
        View findViewById4 = findViewById(R.id.button_add_attachment);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "findViewById(R.id.button_add_attachment)");
        this.addButton = (AppCompatImageButton) findViewById4;
        this.opaque = 1.0f;
        this.translucent = 0.5f;
    }
}
