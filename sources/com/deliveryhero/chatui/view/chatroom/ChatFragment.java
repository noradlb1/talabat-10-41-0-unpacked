package com.deliveryhero.chatui.view.chatroom;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContract;
import androidx.annotation.StringRes;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.navigation.compose.DialogNavigator;
import androidx.recyclerview.widget.ConcatAdapter;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SimpleItemAnimator;
import com.deliveryhero.chatui.view.chatroom.adapter.ChatAdapter;
import com.deliveryhero.chatui.view.chatroom.adapter.DeliveryInfoAdapter;
import com.deliveryhero.chatui.view.chatroom.adapter.QuickReplyAdapter;
import com.deliveryhero.chatui.view.chatroom.adapter.QuickReplyClickListener;
import com.deliveryhero.chatui.view.chatroom.adapter.listener.ClickedItem;
import com.deliveryhero.chatui.view.chatroom.adapter.listener.MessageClickListener;
import com.deliveryhero.chatui.view.chatroom.callback.ThumbnailClickedCallback;
import com.deliveryhero.chatui.view.chatroom.customview.AttachmentDialog;
import com.deliveryhero.chatui.view.chatroom.customview.AttachmentView;
import com.deliveryhero.chatui.view.chatroom.dataholder.AttachmentDataHolder;
import com.deliveryhero.chatui.view.chatroom.dataholder.AttachmentDataModel;
import com.deliveryhero.chatui.view.chatroom.navigator.ImageSelectionNavigator;
import com.deliveryhero.chatui.view.chatroom.navigator.ImageSelectionType;
import com.deliveryhero.chatui.view.chatroom.navigator.MapNavigator;
import com.deliveryhero.chatui.view.root.IOnBackPressed;
import com.deliveryhero.chatui.view.util.DialogUtils;
import com.deliveryhero.chatui.view.util.PermissionModule;
import com.deliveryhero.contract.configuration.ChatConfiguration;
import com.deliveryhero.contract.configuration.ChatFeatureCallbacks;
import com.deliveryhero.contract.location.LocationProvider;
import com.deliveryhero.contract.model.BaseMessage;
import com.deliveryhero.contract.model.LocationData;
import com.deliveryhero.contract.model.Receipt;
import com.deliveryhero.customerchat.R;
import com.deliveryhero.customerchat.configuration.ChatConfigProvider;
import com.deliveryhero.customerchat.di.MyKoinComponent;
import com.deliveryhero.customerchat.fwf.FeatureFlagProvider;
import com.deliveryhero.customerchat.view.util.AttributeUtils;
import com.newrelic.agent.android.api.v2.TraceFieldInterface;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.newrelic.agent.android.tracing.Trace;
import java.util.ArrayList;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.koin.core.Koin;
import org.koin.core.qualifier.Qualifier;
import p4.a;
import p4.b;
import p4.c;
import p4.d;
import p4.e;
import p4.f;
import p4.g;
import p4.h;
import p4.i;

@Instrumented
@Metadata(d1 = {"\u0000¸\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\u0015\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\b\u0000\u0018\u0000 ©\u00012\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u0005:\u0002©\u0001B\u0005¢\u0006\u0002\u0010\u0006J\u0012\u0010f\u001a\u00020:2\b\u0010g\u001a\u0004\u0018\u00010hH\u0002J\u0010\u0010i\u001a\u00020:2\u0006\u0010j\u001a\u00020kH\u0002J\b\u0010l\u001a\u00020:H\u0002J\b\u0010m\u001a\u00020:H\u0002J\u001c\u0010n\u001a\b\u0012\u0004\u0012\u00020p0o2\f\u0010q\u001a\b\u0012\u0004\u0012\u00020p0oH\u0002J\u0010\u0010r\u001a\u00020\u00152\u0006\u0010s\u001a\u00020tH\u0002J\b\u0010u\u001a\u00020:H\u0002J\b\u0010v\u001a\u00020:H\u0002J\u0006\u0010w\u001a\u00020kJ\b\u0010x\u001a\u00020:H\u0002J\u0010\u0010y\u001a\u00020:2\u0006\u0010z\u001a\u00020{H\u0016J\b\u0010|\u001a\u00020kH\u0016J\u0010\u0010}\u001a\u00020:2\u0006\u0010s\u001a\u00020~H\u0016J,\u0010\u001a\u0004\u0018\u00010#2\b\u0010\u0001\u001a\u00030\u00012\n\u0010\u0001\u001a\u0005\u0018\u00010\u00012\n\u0010\u0001\u001a\u0005\u0018\u00010\u0001H\u0016J\t\u0010\u0001\u001a\u00020:H\u0016J\t\u0010\u0001\u001a\u00020:H\u0016J\u0013\u0010\u0001\u001a\u00020:2\b\u0010\u0001\u001a\u00030\u0001H\u0016J6\u0010\u0001\u001a\u00020:2\b\u0010\u0001\u001a\u00030\u00012\u0011\u0010\u0001\u001a\f\u0012\u0007\u0012\u0005\u0018\u00010\u00010\u00012\b\u0010\u0001\u001a\u00030\u0001H\u0016¢\u0006\u0003\u0010\u0001J\t\u0010\u0001\u001a\u00020:H\u0016J\u0013\u0010\u0001\u001a\u00020:2\b\u0010\u0001\u001a\u00030\u0001H\u0016J\u001e\u0010\u0001\u001a\u00020:2\u0007\u0010\u0001\u001a\u00020#2\n\u0010\u0001\u001a\u0005\u0018\u00010\u0001H\u0016J\u0013\u0010\u0001\u001a\u00020:2\b\u0010\u0001\u001a\u00030\u0001H\u0002J\u0013\u0010\u0001\u001a\u00020:2\b\u0010\u0001\u001a\u00030\u0001H\u0002J\t\u0010\u0001\u001a\u00020:H\u0002J\t\u0010\u0001\u001a\u00020:H\u0002J\u0015\u0010 \u0001\u001a\u00020:2\n\b\u0001\u0010¡\u0001\u001a\u00030\u0001H\u0002J\u0013\u0010¢\u0001\u001a\u00020:2\b\u0010\u0001\u001a\u00030\u0001H\u0002J\u0007\u0010£\u0001\u001a\u00020kJ\u0012\u0010¤\u0001\u001a\u00020:2\u0007\u0010¥\u0001\u001a\u00020kH\u0002J \u0010¦\u0001\u001a\u00020:2\f\u0010q\u001a\b\u0012\u0004\u0012\u00020p0o2\u0007\u0010\u0001\u001a\u00020kH\u0002J\u0012\u0010§\u0001\u001a\u00020:2\u0007\u0010¨\u0001\u001a\u00020kH\u0002R\u000e\u0010\u0007\u001a\u00020\bX.¢\u0006\u0002\n\u0000R\u001b\u0010\t\u001a\u00020\n8BX\u0002¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000b\u0010\fR\u001b\u0010\u000f\u001a\u00020\u00108BX\u0002¢\u0006\f\n\u0004\b\u0013\u0010\u000e\u001a\u0004\b\u0011\u0010\u0012R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0016\u001a\u00020\u00178BX\u0002¢\u0006\f\n\u0004\b\u001a\u0010\u000e\u001a\u0004\b\u0018\u0010\u0019R\u000e\u0010\u001b\u001a\u00020\u001cX.¢\u0006\u0002\n\u0000R\u001b\u0010\u001d\u001a\u00020\u001e8BX\u0002¢\u0006\f\n\u0004\b!\u0010\u000e\u001a\u0004\b\u001f\u0010 R\u001b\u0010\"\u001a\u00020#8BX\u0002¢\u0006\f\n\u0004\b&\u0010\u000e\u001a\u0004\b$\u0010%R\u001b\u0010'\u001a\u00020(8BX\u0002¢\u0006\f\n\u0004\b+\u0010\u000e\u001a\u0004\b)\u0010*R\u000e\u0010,\u001a\u00020-X.¢\u0006\u0002\n\u0000R\u001b\u0010.\u001a\u00020/8BX\u0002¢\u0006\f\n\u0004\b2\u0010\u000e\u001a\u0004\b0\u00101R\u001b\u00103\u001a\u0002048BX\u0002¢\u0006\f\n\u0004\b7\u0010\u000e\u001a\u0004\b5\u00106R\u0016\u00108\u001a\n\u0012\u0004\u0012\u00020:\u0018\u000109X\u000e¢\u0006\u0002\n\u0000R\u001b\u0010;\u001a\u00020<8BX\u0002¢\u0006\f\n\u0004\b?\u0010\u000e\u001a\u0004\b=\u0010>R\u001b\u0010@\u001a\u00020A8BX\u0002¢\u0006\f\n\u0004\bD\u0010\u000e\u001a\u0004\bB\u0010CR\u000e\u0010E\u001a\u00020FXD¢\u0006\u0002\n\u0000R\u001b\u0010G\u001a\u00020H8BX\u0002¢\u0006\f\n\u0004\bK\u0010\u000e\u001a\u0004\bI\u0010JR\u001b\u0010L\u001a\u00020M8BX\u0002¢\u0006\f\n\u0004\bP\u0010\u000e\u001a\u0004\bN\u0010OR\u001b\u0010Q\u001a\u00020R8BX\u0002¢\u0006\f\n\u0004\bU\u0010\u000e\u001a\u0004\bS\u0010TR\u001b\u0010V\u001a\u00020R8BX\u0002¢\u0006\f\n\u0004\bX\u0010\u000e\u001a\u0004\bW\u0010TR\u001b\u0010Y\u001a\u00020Z8BX\u0002¢\u0006\f\n\u0004\b]\u0010\u000e\u001a\u0004\b[\u0010\\R\u000e\u0010^\u001a\u00020_X.¢\u0006\u0002\n\u0000R\u000e\u0010`\u001a\u00020FXD¢\u0006\u0002\n\u0000R\u001b\u0010a\u001a\u00020b8BX\u0002¢\u0006\f\n\u0004\be\u0010\u000e\u001a\u0004\bc\u0010d¨\u0006ª\u0001"}, d2 = {"Lcom/deliveryhero/chatui/view/chatroom/ChatFragment;", "Landroidx/fragment/app/Fragment;", "Lcom/deliveryhero/chatui/view/chatroom/adapter/QuickReplyClickListener;", "Lcom/deliveryhero/chatui/view/root/IOnBackPressed;", "Lcom/deliveryhero/customerchat/di/MyKoinComponent;", "Lcom/deliveryhero/chatui/view/chatroom/adapter/listener/MessageClickListener;", "()V", "adapter", "Landroidx/recyclerview/widget/ConcatAdapter;", "attachmentView", "Lcom/deliveryhero/chatui/view/chatroom/customview/AttachmentView;", "getAttachmentView", "()Lcom/deliveryhero/chatui/view/chatroom/customview/AttachmentView;", "attachmentView$delegate", "Lkotlin/Lazy;", "attributeUtils", "Lcom/deliveryhero/customerchat/view/util/AttributeUtils;", "getAttributeUtils", "()Lcom/deliveryhero/customerchat/view/util/AttributeUtils;", "attributeUtils$delegate", "cameraImageUri", "Landroid/net/Uri;", "chatFeatureCallbacks", "Lcom/deliveryhero/contract/configuration/ChatFeatureCallbacks;", "getChatFeatureCallbacks", "()Lcom/deliveryhero/contract/configuration/ChatFeatureCallbacks;", "chatFeatureCallbacks$delegate", "chatListAdapter", "Lcom/deliveryhero/chatui/view/chatroom/adapter/ChatAdapter;", "composeEditText", "Landroid/widget/EditText;", "getComposeEditText", "()Landroid/widget/EditText;", "composeEditText$delegate", "composeViewGroup", "Landroid/view/View;", "getComposeViewGroup", "()Landroid/view/View;", "composeViewGroup$delegate", "configProvider", "Lcom/deliveryhero/customerchat/configuration/ChatConfigProvider;", "getConfigProvider", "()Lcom/deliveryhero/customerchat/configuration/ChatConfigProvider;", "configProvider$delegate", "dialog", "Landroid/app/AlertDialog;", "featureFlagProvider", "Lcom/deliveryhero/customerchat/fwf/FeatureFlagProvider;", "getFeatureFlagProvider", "()Lcom/deliveryhero/customerchat/fwf/FeatureFlagProvider;", "featureFlagProvider$delegate", "imageSelectionNavigator", "Lcom/deliveryhero/chatui/view/chatroom/navigator/ImageSelectionNavigator;", "getImageSelectionNavigator", "()Lcom/deliveryhero/chatui/view/chatroom/navigator/ImageSelectionNavigator;", "imageSelectionNavigator$delegate", "locationResultLauncher", "Landroidx/activity/result/ActivityResultLauncher;", "", "mapNavigator", "Lcom/deliveryhero/chatui/view/chatroom/navigator/MapNavigator;", "getMapNavigator", "()Lcom/deliveryhero/chatui/view/chatroom/navigator/MapNavigator;", "mapNavigator$delegate", "noInternetConnectionView", "Landroid/widget/TextView;", "getNoInternetConnectionView", "()Landroid/widget/TextView;", "noInternetConnectionView$delegate", "opaque", "", "permissionModule", "Lcom/deliveryhero/chatui/view/util/PermissionModule;", "getPermissionModule", "()Lcom/deliveryhero/chatui/view/util/PermissionModule;", "permissionModule$delegate", "progressBar", "Landroid/widget/ProgressBar;", "getProgressBar", "()Landroid/widget/ProgressBar;", "progressBar$delegate", "quickReplyRecyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "getQuickReplyRecyclerView", "()Landroidx/recyclerview/widget/RecyclerView;", "quickReplyRecyclerView$delegate", "recyclerView", "getRecyclerView", "recyclerView$delegate", "sendButton", "Landroid/widget/ImageButton;", "getSendButton", "()Landroid/widget/ImageButton;", "sendButton$delegate", "thumbnailClickedCallback", "Lcom/deliveryhero/chatui/view/chatroom/callback/ThumbnailClickedCallback;", "translucent", "viewModel", "Lcom/deliveryhero/chatui/view/chatroom/ChatViewModel;", "getViewModel", "()Lcom/deliveryhero/chatui/view/chatroom/ChatViewModel;", "viewModel$delegate", "configureRecyclerView", "deliveryViewModel", "Lcom/deliveryhero/chatui/view/chatroom/DeliveryViewModel;", "configureViewModel", "hasSavedInstance", "", "configureViews", "fetchLocation", "getDeepCopyOfList", "", "Lcom/deliveryhero/chatui/view/chatroom/ChatMessageViewModel;", "list", "getUri", "item", "Lcom/deliveryhero/chatui/view/chatroom/adapter/listener/ClickedItem$LocationItem;", "handleChatFrozenState", "hideKeyboard", "isTranslated", "observeUIEvents", "onAttach", "context", "Landroid/content/Context;", "onBackPressed", "onClicked", "Lcom/deliveryhero/chatui/view/chatroom/adapter/listener/ClickedItem;", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onDestroyView", "onPause", "onQuickReplyClick", "reply", "", "onRequestPermissionsResult", "requestCode", "", "permissions", "", "grantResults", "", "(I[Ljava/lang/String;[I)V", "onResume", "onSaveInstanceState", "outState", "onViewCreated", "view", "openImageSelector", "type", "Lcom/deliveryhero/chatui/view/chatroom/navigator/ImageSelectionType;", "performAttachmentAction", "attachmentDataModel", "Lcom/deliveryhero/chatui/view/chatroom/dataholder/AttachmentDataModel;", "scrollToBottom", "showAddAttachmentDialog", "showDialog", "message", "showSettingsDialogAndNavigate", "translate", "updateAttachmentButtonsState", "isEnable", "updateData", "updateSendButtonState", "enable", "Companion", "customerchat_basicRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class ChatFragment extends Fragment implements QuickReplyClickListener, IOnBackPressed, MyKoinComponent, MessageClickListener, TraceFieldInterface {
    @NotNull
    private static final String CAMERA_IMAGE_KEY = "CAMERA_IMAGE_KEY";
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final long SCROLL_DELAY_MS = 300;
    public Trace _nr_trace;
    /* access modifiers changed from: private */
    public ConcatAdapter adapter;
    @NotNull
    private final Lazy attachmentView$delegate;
    @NotNull
    private final Lazy attributeUtils$delegate;
    /* access modifiers changed from: private */
    @Nullable
    public Uri cameraImageUri;
    @NotNull
    private final Lazy chatFeatureCallbacks$delegate;
    private ChatAdapter chatListAdapter;
    @NotNull
    private final Lazy composeEditText$delegate;
    @NotNull
    private final Lazy composeViewGroup$delegate;
    @NotNull
    private final Lazy configProvider$delegate;
    private AlertDialog dialog;
    @NotNull
    private final Lazy featureFlagProvider$delegate;
    @NotNull
    private final Lazy imageSelectionNavigator$delegate;
    @Nullable
    private ActivityResultLauncher<Unit> locationResultLauncher;
    @NotNull
    private final Lazy mapNavigator$delegate;
    @NotNull
    private final Lazy noInternetConnectionView$delegate;
    private final float opaque;
    @NotNull
    private final Lazy permissionModule$delegate;
    @NotNull
    private final Lazy progressBar$delegate;
    @NotNull
    private final Lazy quickReplyRecyclerView$delegate;
    @NotNull
    private final Lazy recyclerView$delegate;
    @NotNull
    private final Lazy sendButton$delegate;
    private ThumbnailClickedCallback thumbnailClickedCallback;
    private final float translucent;
    @NotNull
    private final Lazy viewModel$delegate = LazyKt__LazyJVMKt.lazy(LazyThreadSafetyMode.NONE, new ChatFragment$special$$inlined$viewModel$default$2(this, (Qualifier) null, new ChatFragment$special$$inlined$viewModel$default$1(this), (Function0) null));

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/deliveryhero/chatui/view/chatroom/ChatFragment$Companion;", "", "()V", "CAMERA_IMAGE_KEY", "", "SCROLL_DELAY_MS", "", "customerchat_basicRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public ChatFragment() {
        ChatFragment$imageSelectionNavigator$2 chatFragment$imageSelectionNavigator$2 = new ChatFragment$imageSelectionNavigator$2(this);
        LazyThreadSafetyMode lazyThreadSafetyMode = LazyThreadSafetyMode.SYNCHRONIZED;
        this.imageSelectionNavigator$delegate = LazyKt__LazyJVMKt.lazy(lazyThreadSafetyMode, new ChatFragment$special$$inlined$inject$default$1(this, (Qualifier) null, chatFragment$imageSelectionNavigator$2));
        this.mapNavigator$delegate = LazyKt__LazyJVMKt.lazy(lazyThreadSafetyMode, new ChatFragment$special$$inlined$inject$default$2(this, (Qualifier) null, (Function0) null));
        this.permissionModule$delegate = LazyKt__LazyJVMKt.lazy(lazyThreadSafetyMode, new ChatFragment$special$$inlined$inject$default$3(this, (Qualifier) null, (Function0) null));
        this.attributeUtils$delegate = LazyKt__LazyJVMKt.lazy(lazyThreadSafetyMode, new ChatFragment$special$$inlined$inject$default$4(this, (Qualifier) null, (Function0) null));
        this.configProvider$delegate = LazyKt__LazyJVMKt.lazy(lazyThreadSafetyMode, new ChatFragment$special$$inlined$inject$default$5(this, (Qualifier) null, (Function0) null));
        this.chatFeatureCallbacks$delegate = LazyKt__LazyJVMKt.lazy(lazyThreadSafetyMode, new ChatFragment$special$$inlined$inject$default$6(this, (Qualifier) null, (Function0) null));
        this.featureFlagProvider$delegate = LazyKt__LazyJVMKt.lazy(lazyThreadSafetyMode, new ChatFragment$special$$inlined$inject$default$7(this, (Qualifier) null, (Function0) null));
        this.recyclerView$delegate = LazyKt__LazyJVMKt.lazy(new ChatFragment$recyclerView$2(this));
        this.composeEditText$delegate = LazyKt__LazyJVMKt.lazy(new ChatFragment$composeEditText$2(this));
        this.sendButton$delegate = LazyKt__LazyJVMKt.lazy(new ChatFragment$sendButton$2(this));
        this.attachmentView$delegate = LazyKt__LazyJVMKt.lazy(new ChatFragment$attachmentView$2(this));
        this.progressBar$delegate = LazyKt__LazyJVMKt.lazy(new ChatFragment$progressBar$2(this));
        this.quickReplyRecyclerView$delegate = LazyKt__LazyJVMKt.lazy(new ChatFragment$quickReplyRecyclerView$2(this));
        this.noInternetConnectionView$delegate = LazyKt__LazyJVMKt.lazy(new ChatFragment$noInternetConnectionView$2(this));
        this.composeViewGroup$delegate = LazyKt__LazyJVMKt.lazy(new ChatFragment$composeViewGroup$2(this));
        this.opaque = 1.0f;
        this.translucent = 0.5f;
    }

    private final void configureRecyclerView(DeliveryViewModel deliveryViewModel) {
        boolean z11;
        Context requireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext()");
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(requireContext);
        ChatConfiguration chatConfiguration = getConfigProvider().getChatConfiguration();
        if (chatConfiguration != null) {
            z11 = chatConfiguration.getStackFromEnd();
        } else {
            z11 = ChatConfiguration.Companion.getDEFAULT_CHAT_CONFIGURATION$customerchat_basicRelease().getStackFromEnd();
        }
        linearLayoutManager.setStackFromEnd(z11);
        getRecyclerView().setLayoutManager(linearLayoutManager);
        ChatAdapter chatAdapter = new ChatAdapter(this, getAttributeUtils());
        this.chatListAdapter = chatAdapter;
        chatAdapter.setHasStableIds(true);
        RecyclerView.Adapter[] adapterArr = new RecyclerView.Adapter[1];
        ChatAdapter chatAdapter2 = this.chatListAdapter;
        ConcatAdapter concatAdapter = null;
        if (chatAdapter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("chatListAdapter");
            chatAdapter2 = null;
        }
        adapterArr[0] = chatAdapter2;
        ConcatAdapter concatAdapter2 = new ConcatAdapter((RecyclerView.Adapter<? extends RecyclerView.ViewHolder>[]) adapterArr);
        this.adapter = concatAdapter2;
        if (deliveryViewModel != null) {
            concatAdapter2.addAdapter(0, new DeliveryInfoAdapter(deliveryViewModel));
        }
        RecyclerView recyclerView = getRecyclerView();
        ConcatAdapter concatAdapter3 = this.adapter;
        if (concatAdapter3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
        } else {
            concatAdapter = concatAdapter3;
        }
        recyclerView.setAdapter(concatAdapter);
        getQuickReplyRecyclerView().setLayoutManager(new LinearLayoutManager(requireContext, 0, false));
    }

    private final void configureViewModel(boolean z11) {
        getViewModel().init(z11);
        getViewModel().getMessagesLiveData().observe(getViewLifecycleOwner(), new b(this));
        observeUIEvents();
        getViewModel().getNoInternetLiveData().observe(getViewLifecycleOwner(), new c(this));
        getViewModel().getRefreshing().observe(getViewLifecycleOwner(), new d(this));
        getViewModel().getQuickReplies().observe(getViewLifecycleOwner(), new e(this));
        getViewModel().getAttachmentView().observe(getViewLifecycleOwner(), new f(this));
        getImageSelectionNavigator().getImageResult().observe(getViewLifecycleOwner(), new g(this));
        LifecycleOwnerKt.getLifecycleScope(this).launchWhenCreated(new ChatFragment$configureViewModel$7(this, (Continuation<? super ChatFragment$configureViewModel$7>) null));
    }

    /* access modifiers changed from: private */
    /* renamed from: configureViewModel$lambda-11  reason: not valid java name */
    public static final void m8148configureViewModel$lambda11(ChatFragment chatFragment, List list) {
        Intrinsics.checkNotNullParameter(chatFragment, "this$0");
        if (list != null) {
            chatFragment.getQuickReplyRecyclerView().setAdapter(new QuickReplyAdapter(list, chatFragment));
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: configureViewModel$lambda-13  reason: not valid java name */
    public static final void m8149configureViewModel$lambda13(ChatFragment chatFragment, AttachmentViewOptions attachmentViewOptions) {
        Intrinsics.checkNotNullParameter(chatFragment, "this$0");
        if (attachmentViewOptions != null) {
            chatFragment.getAttachmentView().bind(attachmentViewOptions);
            chatFragment.updateAttachmentButtonsState(attachmentViewOptions.isEnabled());
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: configureViewModel$lambda-14  reason: not valid java name */
    public static final void m8150configureViewModel$lambda14(ChatFragment chatFragment, Pair pair) {
        Intrinsics.checkNotNullParameter(chatFragment, "this$0");
        Uri uri = (Uri) pair.getSecond();
        if (uri == null) {
            uri = chatFragment.cameraImageUri;
        }
        if (uri != null) {
            ChatViewModel viewModel = chatFragment.getViewModel();
            Context requireContext = chatFragment.requireContext();
            Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext()");
            viewModel.showImageShareConfirmation(requireContext, ((Number) pair.getFirst()).intValue(), uri, chatFragment.getChatFeatureCallbacks().getChatLogger());
            chatFragment.cameraImageUri = null;
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: configureViewModel$lambda-7  reason: not valid java name */
    public static final void m8151configureViewModel$lambda7(ChatFragment chatFragment, List list) {
        Intrinsics.checkNotNullParameter(chatFragment, "this$0");
        if (list == null) {
            list = CollectionsKt__CollectionsKt.emptyList();
        }
        chatFragment.updateData(list, chatFragment.getViewModel().shouldScrollToBottom());
    }

    /* access modifiers changed from: private */
    /* renamed from: configureViewModel$lambda-8  reason: not valid java name */
    public static final void m8152configureViewModel$lambda8(ChatFragment chatFragment, Integer num) {
        int i11;
        Intrinsics.checkNotNullParameter(chatFragment, "this$0");
        TextView noInternetConnectionView = chatFragment.getNoInternetConnectionView();
        if (num == null) {
            i11 = 8;
        } else {
            i11 = num.intValue();
        }
        noInternetConnectionView.setVisibility(i11);
    }

    /* access modifiers changed from: private */
    /* renamed from: configureViewModel$lambda-9  reason: not valid java name */
    public static final void m8153configureViewModel$lambda9(ChatFragment chatFragment, Boolean bool) {
        boolean z11;
        Intrinsics.checkNotNullParameter(chatFragment, "this$0");
        int i11 = 0;
        if (bool == null) {
            z11 = false;
        } else {
            z11 = bool.booleanValue();
        }
        ProgressBar progressBar = chatFragment.getProgressBar();
        if (!z11) {
            i11 = 8;
        }
        progressBar.setVisibility(i11);
        chatFragment.getSendButton().setEnabled(!z11);
        chatFragment.updateAttachmentButtonsState(!z11);
    }

    private final void configureViews() {
        getAttachmentView().onActionsClick(new ChatFragment$configureViews$1(this));
        getSendButton().setOnClickListener(new h(this));
        getComposeEditText().addTextChangedListener(new ChatFragment$configureViews$3(this));
    }

    /* access modifiers changed from: private */
    /* renamed from: configureViews$lambda-4  reason: not valid java name */
    public static final void m8154configureViews$lambda4(ChatFragment chatFragment, View view) {
        Intrinsics.checkNotNullParameter(chatFragment, "this$0");
        if (chatFragment.getViewModel().sendNewMessage(chatFragment.getComposeEditText().getText().toString(), false)) {
            chatFragment.getComposeEditText().setText((CharSequence) null);
        }
    }

    /* access modifiers changed from: private */
    public final void fetchLocation() {
        ActivityResultLauncher<Unit> activityResultLauncher = this.locationResultLauncher;
        Unit unit = null;
        if (activityResultLauncher != null) {
            Job unused = BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), (CoroutineContext) null, (CoroutineStart) null, new ChatFragment$fetchLocation$1$1(this, (Continuation<? super ChatFragment$fetchLocation$1$1>) null), 3, (Object) null);
            unit = Unit.INSTANCE;
            activityResultLauncher.launch(unit);
        }
        if (unit == null) {
            getViewModel().locationSharingError();
        }
    }

    private final AttachmentView getAttachmentView() {
        return (AttachmentView) this.attachmentView$delegate.getValue();
    }

    private final AttributeUtils getAttributeUtils() {
        return (AttributeUtils) this.attributeUtils$delegate.getValue();
    }

    private final ChatFeatureCallbacks getChatFeatureCallbacks() {
        return (ChatFeatureCallbacks) this.chatFeatureCallbacks$delegate.getValue();
    }

    private final EditText getComposeEditText() {
        return (EditText) this.composeEditText$delegate.getValue();
    }

    private final View getComposeViewGroup() {
        return (View) this.composeViewGroup$delegate.getValue();
    }

    private final ChatConfigProvider getConfigProvider() {
        return (ChatConfigProvider) this.configProvider$delegate.getValue();
    }

    private final List<ChatMessageViewModel> getDeepCopyOfList(List<ChatMessageViewModel> list) {
        Iterable<ChatMessageViewModel> iterable = list;
        ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(iterable, 10));
        for (ChatMessageViewModel copy$default : iterable) {
            arrayList.add(ChatMessageViewModel.copy$default(copy$default, 0, (TextMessage) null, (TextMessage) null, (ImageMessage) null, (LocationMessage) null, (String) null, false, (Receipt) null, (BaseMessage) null, (String) null, 1023, (Object) null));
        }
        return arrayList;
    }

    /* access modifiers changed from: private */
    public final FeatureFlagProvider getFeatureFlagProvider() {
        return (FeatureFlagProvider) this.featureFlagProvider$delegate.getValue();
    }

    private final ImageSelectionNavigator getImageSelectionNavigator() {
        return (ImageSelectionNavigator) this.imageSelectionNavigator$delegate.getValue();
    }

    private final MapNavigator getMapNavigator() {
        return (MapNavigator) this.mapNavigator$delegate.getValue();
    }

    private final TextView getNoInternetConnectionView() {
        return (TextView) this.noInternetConnectionView$delegate.getValue();
    }

    /* access modifiers changed from: private */
    public final PermissionModule getPermissionModule() {
        return (PermissionModule) this.permissionModule$delegate.getValue();
    }

    private final ProgressBar getProgressBar() {
        return (ProgressBar) this.progressBar$delegate.getValue();
    }

    private final RecyclerView getQuickReplyRecyclerView() {
        return (RecyclerView) this.quickReplyRecyclerView$delegate.getValue();
    }

    /* access modifiers changed from: private */
    public final RecyclerView getRecyclerView() {
        return (RecyclerView) this.recyclerView$delegate.getValue();
    }

    private final ImageButton getSendButton() {
        return (ImageButton) this.sendButton$delegate.getValue();
    }

    private final Uri getUri(ClickedItem.LocationItem locationItem) {
        Uri parse = Uri.parse("geo:0,0?q=" + locationItem.getLatitude() + AbstractJsonLexerKt.COMMA + locationItem.getLongitude());
        Intrinsics.checkNotNullExpressionValue(parse, "parse(\"geo:0,0?q=${item.…tude},${item.longitude}\")");
        return parse;
    }

    /* access modifiers changed from: private */
    public final ChatViewModel getViewModel() {
        return (ChatViewModel) this.viewModel$delegate.getValue();
    }

    /* JADX WARNING: type inference failed for: r0v5, types: [androidx.fragment.app.FragmentActivity] */
    /* access modifiers changed from: private */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void handleChatFrozenState() {
        /*
            r4 = this;
            androidx.recyclerview.widget.ConcatAdapter r0 = r4.adapter
            java.lang.String r1 = "adapter"
            r2 = 0
            if (r0 != 0) goto L_0x000b
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r1)
            r0 = r2
        L_0x000b:
            java.util.List r0 = r0.getAdapters()
            java.lang.String r3 = "adapter.adapters"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r3)
            java.lang.Iterable r0 = (java.lang.Iterable) r0
            com.deliveryhero.chatui.view.chatroom.adapter.ChannelStatusAdapter r3 = com.deliveryhero.chatui.view.chatroom.adapter.ChannelStatusAdapter.INSTANCE
            boolean r0 = kotlin.collections.CollectionsKt___CollectionsKt.contains(r0, r3)
            if (r0 != 0) goto L_0x0029
            androidx.recyclerview.widget.ConcatAdapter r0 = r4.adapter
            if (r0 != 0) goto L_0x0026
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r1)
            r0 = r2
        L_0x0026:
            r0.addAdapter(r3)
        L_0x0029:
            androidx.fragment.app.FragmentActivity r0 = r4.getActivity()
            boolean r1 = r0 instanceof com.deliveryhero.chatui.view.root.ICanHideCallButton
            if (r1 == 0) goto L_0x0034
            r2 = r0
            com.deliveryhero.chatui.view.root.ICanHideCallButton r2 = (com.deliveryhero.chatui.view.root.ICanHideCallButton) r2
        L_0x0034:
            if (r2 == 0) goto L_0x0039
            r2.hide()
        L_0x0039:
            r4.hideKeyboard()
            androidx.recyclerview.widget.RecyclerView r0 = r4.getQuickReplyRecyclerView()
            r1 = 8
            r0.setVisibility(r1)
            android.view.View r0 = r4.getComposeViewGroup()
            r0.setVisibility(r1)
            androidx.recyclerview.widget.RecyclerView r0 = r4.getRecyclerView()
            com.deliveryhero.chatui.view.chatroom.ChatFragment$handleChatFrozenState$$inlined$postDelayed$1 r1 = new com.deliveryhero.chatui.view.chatroom.ChatFragment$handleChatFrozenState$$inlined$postDelayed$1
            r1.<init>(r4)
            r2 = 300(0x12c, double:1.48E-321)
            r0.postDelayed(r1, r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.deliveryhero.chatui.view.chatroom.ChatFragment.handleChatFrozenState():void");
    }

    private final void hideKeyboard() {
        InputMethodManager inputMethodManager;
        EditText composeEditText = getComposeEditText();
        Object systemService = requireContext().getSystemService("input_method");
        if (systemService instanceof InputMethodManager) {
            inputMethodManager = (InputMethodManager) systemService;
        } else {
            inputMethodManager = null;
        }
        if (inputMethodManager != null) {
            inputMethodManager.hideSoftInputFromWindow(composeEditText.getWindowToken(), 0);
        }
    }

    private final void observeUIEvents() {
        Job unused = BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), (CoroutineContext) null, (CoroutineStart) null, new ChatFragment$observeUIEvents$1(this, (Continuation<? super ChatFragment$observeUIEvents$1>) null), 3, (Object) null);
    }

    /* access modifiers changed from: private */
    /* renamed from: onViewCreated$lambda-1$lambda-0  reason: not valid java name */
    public static final void m8155onViewCreated$lambda1$lambda0(ChatFragment chatFragment, LocationData locationData) {
        Intrinsics.checkNotNullParameter(chatFragment, "this$0");
        chatFragment.getViewModel().onLocationReceived(locationData);
    }

    /* access modifiers changed from: private */
    public final void openImageSelector(ImageSelectionType imageSelectionType) {
        ImageSelectionNavigator imageSelectionNavigator = getImageSelectionNavigator();
        Context requireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(requireContext, "this.requireContext()");
        imageSelectionNavigator.openActivity(requireContext, imageSelectionType);
    }

    /* access modifiers changed from: private */
    public final void performAttachmentAction(AttachmentDataModel attachmentDataModel) {
        String attachmentType = attachmentDataModel.getAttachmentType();
        AttributeUtils attributeUtils = getAttributeUtils();
        Context requireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext()");
        if (Intrinsics.areEqual((Object) attachmentType, (Object) attributeUtils.getStringAttribute(requireContext, R.attr.customerChatSelectGalleryText))) {
            getViewModel().openGallery();
            return;
        }
        AttributeUtils attributeUtils2 = getAttributeUtils();
        Context requireContext2 = requireContext();
        Intrinsics.checkNotNullExpressionValue(requireContext2, "requireContext()");
        if (Intrinsics.areEqual((Object) attachmentType, (Object) attributeUtils2.getStringAttribute(requireContext2, R.attr.customerChatSelectCameraText))) {
            getViewModel().openCamera();
            return;
        }
        AttributeUtils attributeUtils3 = getAttributeUtils();
        Context requireContext3 = requireContext();
        Intrinsics.checkNotNullExpressionValue(requireContext3, "requireContext()");
        if (Intrinsics.areEqual((Object) attachmentType, (Object) attributeUtils3.getStringAttribute(requireContext3, R.attr.customerChatSelectLocationText))) {
            fetchLocation();
        }
    }

    private final void scrollToBottom() {
        RecyclerView recyclerView = getRecyclerView();
        ChatAdapter chatAdapter = this.chatListAdapter;
        if (chatAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("chatListAdapter");
            chatAdapter = null;
        }
        recyclerView.scrollToPosition(chatAdapter.getItemCount());
    }

    /* access modifiers changed from: private */
    public final void showAddAttachmentDialog() {
        Job unused = BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), (CoroutineContext) null, (CoroutineStart) null, new ChatFragment$showAddAttachmentDialog$1(this, (Continuation<? super ChatFragment$showAddAttachmentDialog$1>) null), 3, (Object) null);
        Context requireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext()");
        AttachmentDialog attachmentDialog = new AttachmentDialog(requireContext);
        Job unused2 = BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), (CoroutineContext) null, (CoroutineStart) null, new ChatFragment$showAddAttachmentDialog$2(this, new AttachmentDataHolder(getAttributeUtils()), attachmentDialog, (Continuation<? super ChatFragment$showAddAttachmentDialog$2>) null), 3, (Object) null);
    }

    /* access modifiers changed from: private */
    public final void showDialog(@StringRes int i11) {
        AlertDialog alertDialog = this.dialog;
        AlertDialog alertDialog2 = null;
        if (alertDialog != null) {
            if (alertDialog == null) {
                Intrinsics.throwUninitializedPropertyAccessException(DialogNavigator.NAME);
                alertDialog = null;
            }
            if (alertDialog.isShowing()) {
                AlertDialog alertDialog3 = this.dialog;
                if (alertDialog3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException(DialogNavigator.NAME);
                    alertDialog3 = null;
                }
                alertDialog3.dismiss();
            }
        }
        AlertDialog create = new AlertDialog.Builder(getContext()).setTitle(R.string.customer_chat_all_warning).setMessage(i11).setCancelable(false).setPositiveButton(17039370, (DialogInterface.OnClickListener) null).create();
        Intrinsics.checkNotNullExpressionValue(create, "Builder(context)\n       …ll)\n            .create()");
        this.dialog = create;
        if (create == null) {
            Intrinsics.throwUninitializedPropertyAccessException(DialogNavigator.NAME);
        } else {
            alertDialog2 = create;
        }
        alertDialog2.show();
    }

    private final void showSettingsDialogAndNavigate(int i11) {
        Context requireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext()");
        if (i11 == 25661) {
            DialogUtils.showDialog$default(DialogUtils.INSTANCE, requireContext, getAttributeUtils().getStringAttribute(requireContext, R.attr.customerChatEnableCameraAlertTitle), getAttributeUtils().getStringAttribute(requireContext, R.attr.customerChatEnableCameraAlertMessage), getAttributeUtils().getStringAttribute(requireContext, R.attr.customerChatEnableCameraAlertOpenSetting), getAttributeUtils().getStringAttribute(requireContext, R.attr.customerChatEnableCameraAlertDismiss), new ChatFragment$showSettingsDialogAndNavigate$1(requireContext, this), ChatFragment$showSettingsDialogAndNavigate$2.INSTANCE, false, true, 128, (Object) null);
        }
    }

    private final void updateAttachmentButtonsState(boolean z11) {
        getAttachmentView().isEnableButtons(z11);
    }

    private final void updateData(List<ChatMessageViewModel> list, boolean z11) {
        ChatAdapter chatAdapter = this.chatListAdapter;
        if (chatAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("chatListAdapter");
            chatAdapter = null;
        }
        chatAdapter.submitList(getDeepCopyOfList(list), new i(z11, this));
    }

    /* access modifiers changed from: private */
    /* renamed from: updateData$lambda-5  reason: not valid java name */
    public static final void m8156updateData$lambda5(boolean z11, ChatFragment chatFragment) {
        Intrinsics.checkNotNullParameter(chatFragment, "this$0");
        if (z11) {
            chatFragment.scrollToBottom();
        }
    }

    /* access modifiers changed from: private */
    public final void updateSendButtonState(boolean z11) {
        getSendButton().setAlpha(z11 ? this.opaque : this.translucent);
    }

    @NotNull
    public Koin getKoin() {
        return MyKoinComponent.DefaultImpls.getKoin(this);
    }

    public final boolean isTranslated() {
        return getViewModel().isTranslationEnabled();
    }

    public void onAttach(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        super.onAttach(context);
        this.thumbnailClickedCallback = (ThumbnailClickedCallback) context;
    }

    public boolean onBackPressed() {
        return getViewModel().onBackPressed();
    }

    public void onClicked(@NotNull ClickedItem clickedItem) {
        Intrinsics.checkNotNullParameter(clickedItem, "item");
        ThumbnailClickedCallback thumbnailClickedCallback2 = null;
        if (clickedItem instanceof ClickedItem.ImageItem) {
            ThumbnailClickedCallback thumbnailClickedCallback3 = this.thumbnailClickedCallback;
            if (thumbnailClickedCallback3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("thumbnailClickedCallback");
            } else {
                thumbnailClickedCallback2 = thumbnailClickedCallback3;
            }
            thumbnailClickedCallback2.onThumbnailClicked(((ClickedItem.ImageItem) clickedItem).getImageUrl());
        } else if (clickedItem instanceof ClickedItem.LocationItem) {
            Job unused = BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), (CoroutineContext) null, (CoroutineStart) null, new ChatFragment$onClicked$1(this, (Continuation<? super ChatFragment$onClicked$1>) null), 3, (Object) null);
            MapNavigator mapNavigator = getMapNavigator();
            Uri uri = getUri((ClickedItem.LocationItem) clickedItem);
            FragmentActivity requireActivity = requireActivity();
            Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity()");
            mapNavigator.openMap(uri, requireActivity);
        }
    }

    /* JADX WARNING: type inference failed for: r7v3, types: [android.os.Parcelable] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public android.view.View onCreateView(@org.jetbrains.annotations.NotNull android.view.LayoutInflater r5, @org.jetbrains.annotations.Nullable android.view.ViewGroup r6, @org.jetbrains.annotations.Nullable android.os.Bundle r7) {
        /*
            r4 = this;
            java.lang.String r0 = "ChatFragment#onCreateView"
            r1 = 0
            com.newrelic.agent.android.tracing.Trace r2 = r4._nr_trace     // Catch:{ NoSuchFieldError -> 0x0009 }
            com.newrelic.agent.android.tracing.TraceMachine.enterMethod(r2, r0, r1)     // Catch:{ NoSuchFieldError -> 0x0009 }
            goto L_0x000c
        L_0x0009:
            com.newrelic.agent.android.tracing.TraceMachine.enterMethod(r1, r0, r1)     // Catch:{ NoSuchFieldError -> 0x0009 }
        L_0x000c:
            java.lang.String r0 = "inflater"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r0)
            if (r7 == 0) goto L_0x0034
            int r0 = android.os.Build.VERSION.SDK_INT
            r2 = 33
            java.lang.String r3 = "CAMERA_IMAGE_KEY"
            if (r0 < r2) goto L_0x0024
            java.lang.Class<android.net.Uri> r0 = android.net.Uri.class
            java.lang.Object r7 = r7.getParcelable(r3, r0)
            android.os.Parcelable r7 = (android.os.Parcelable) r7
            goto L_0x0031
        L_0x0024:
            android.os.Parcelable r7 = r7.getParcelable(r3)
            boolean r0 = r7 instanceof android.net.Uri
            if (r0 != 0) goto L_0x002d
            goto L_0x002e
        L_0x002d:
            r1 = r7
        L_0x002e:
            r7 = r1
            android.net.Uri r7 = (android.net.Uri) r7
        L_0x0031:
            r1 = r7
            android.net.Uri r1 = (android.net.Uri) r1
        L_0x0034:
            r4.cameraImageUri = r1
            int r7 = com.deliveryhero.customerchat.R.layout.customer_chat_fragment_open_chat
            r0 = 0
            android.view.View r5 = r5.inflate(r7, r6, r0)
            com.newrelic.agent.android.tracing.TraceMachine.exitMethod()
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.deliveryhero.chatui.view.chatroom.ChatFragment.onCreateView(android.view.LayoutInflater, android.view.ViewGroup, android.os.Bundle):android.view.View");
    }

    public void onDestroyView() {
        getViewModel().disconnect();
        Job unused = BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), (CoroutineContext) null, (CoroutineStart) null, new ChatFragment$onDestroyView$1(this, (Continuation<? super ChatFragment$onDestroyView$1>) null), 3, (Object) null);
        super.onDestroyView();
    }

    public void onPause() {
        getViewModel().stopListeningAllConnection();
        super.onPause();
    }

    public void onQuickReplyClick(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "reply");
        getViewModel().sendQuickReply(str);
    }

    public void onRequestPermissionsResult(int i11, @NotNull String[] strArr, @NotNull int[] iArr) {
        Intrinsics.checkNotNullParameter(strArr, "permissions");
        Intrinsics.checkNotNullParameter(iArr, "grantResults");
        super.onRequestPermissionsResult(i11, strArr, iArr);
        int length = iArr.length;
        boolean z11 = false;
        int i12 = 0;
        while (true) {
            boolean z12 = true;
            if (i12 >= length) {
                z11 = true;
                break;
            }
            if (iArr[i12] != -1) {
                z12 = false;
            }
            if (z12) {
                break;
            }
            i12++;
        }
        if (z11) {
            if (i11 == 25661) {
                getViewModel().openCamera();
            }
        } else if (getPermissionModule().shouldShowSettingsIfPermanentlyDenied(this, i11)) {
            showSettingsDialogAndNavigate(i11);
        }
    }

    public void onResume() {
        super.onResume();
        getViewModel().listenAllConnection(new Handler(Looper.getMainLooper()));
    }

    public void onSaveInstanceState(@NotNull Bundle bundle) {
        Intrinsics.checkNotNullParameter(bundle, "outState");
        super.onSaveInstanceState(bundle);
        Uri uri = this.cameraImageUri;
        if (uri != null) {
            bundle.putParcelable(CAMERA_IMAGE_KEY, uri);
        }
    }

    public void onStart() {
        super.onStart();
    }

    public void onStop() {
        super.onStop();
    }

    public void onViewCreated(@NotNull View view, @Nullable Bundle bundle) {
        boolean z11;
        SimpleItemAnimator simpleItemAnimator;
        ActivityResultLauncher<Unit> activityResultLauncher;
        ActivityResultContract<Unit, LocationData> fetchLocation;
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, bundle);
        configureViews();
        if (bundle != null) {
            z11 = true;
        } else {
            z11 = false;
        }
        configureViewModel(z11);
        configureRecyclerView(getViewModel().getDeliveryViewModel());
        getViewModel().resetConnection();
        RecyclerView.ItemAnimator itemAnimator = getRecyclerView().getItemAnimator();
        if (itemAnimator instanceof SimpleItemAnimator) {
            simpleItemAnimator = (SimpleItemAnimator) itemAnimator;
        } else {
            simpleItemAnimator = null;
        }
        if (simpleItemAnimator != null) {
            simpleItemAnimator.setSupportsChangeAnimations(false);
        }
        LocationProvider locationProvider = getChatFeatureCallbacks().getLocationProvider();
        if (locationProvider == null || (fetchLocation = locationProvider.fetchLocation()) == null) {
            activityResultLauncher = null;
        } else {
            activityResultLauncher = registerForActivityResult(fetchLocation, new a(this));
        }
        this.locationResultLauncher = activityResultLauncher;
        Job unused = BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), (CoroutineContext) null, (CoroutineStart) null, new ChatFragment$onViewCreated$2(this, (Continuation<? super ChatFragment$onViewCreated$2>) null), 3, (Object) null);
    }

    public final boolean translate() {
        getViewModel().translate();
        return getViewModel().isTranslationEnabled();
    }
}
