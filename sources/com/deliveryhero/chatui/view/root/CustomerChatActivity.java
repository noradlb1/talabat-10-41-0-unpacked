package com.deliveryhero.chatui.view.root;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LifecycleOwnerKt;
import com.deliveryhero.chatui.data.CameraImageRepository;
import com.deliveryhero.chatui.data.event.Event;
import com.deliveryhero.chatui.data.event.EventHandler;
import com.deliveryhero.chatui.domain.call.CallStatus;
import com.deliveryhero.chatui.view.chatroom.ChatFragment;
import com.deliveryhero.chatui.view.chatroom.callback.ThumbnailClickedCallback;
import com.deliveryhero.chatui.view.fullscreenimage.FullScreenImageFragment;
import com.deliveryhero.contract.configuration.ChatConfiguration;
import com.deliveryhero.contract.configuration.PersistableChatConfiguration;
import com.deliveryhero.customerchat.CustomerChatModule;
import com.deliveryhero.customerchat.R;
import com.deliveryhero.customerchat.di.MyKoinComponent;
import com.deliveryhero.customerchat.view.util.AttributeUtils;
import com.google.android.exoplayer2.util.MimeTypes;
import com.newrelic.agent.android.api.v2.TraceFieldInterface;
import com.newrelic.agent.android.background.ApplicationStateMonitor;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.newrelic.agent.android.tracing.Trace;
import com.newrelic.agent.android.tracing.TraceMachine;
import com.talabat.core.observabilityNew.domain.squads.menu.MenuScreenPerformanceParams;
import java.util.ArrayList;
import kotlin.Lazy;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.koin.core.Koin;
import org.koin.core.qualifier.Qualifier;
import u4.a;
import u4.b;

@Instrumented
@Metadata(d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0000\u0018\u0000 >2\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004:\u0001>B\u0005¢\u0006\u0002\u0010\u0005J\b\u0010!\u001a\u00020\"H\u0002J\b\u0010#\u001a\u00020\"H\u0002J\u0010\u0010$\u001a\u00020\"2\u0006\u0010%\u001a\u00020&H\u0002J\b\u0010'\u001a\u00020\"H\u0016J\b\u0010(\u001a\u00020)H\u0002J\b\u0010*\u001a\u00020\"H\u0016J\u0012\u0010+\u001a\u00020\"2\b\u0010,\u001a\u0004\u0018\u00010\u0019H\u0014J\u0010\u0010-\u001a\u00020.2\u0006\u0010/\u001a\u000200H\u0016J\u0010\u00101\u001a\u00020.2\u0006\u00102\u001a\u00020\rH\u0016J\u0010\u00103\u001a\u00020\"2\u0006\u00104\u001a\u00020\u0019H\u0014J\b\u00105\u001a\u00020\"H\u0014J\b\u00106\u001a\u00020\"H\u0014J\u0010\u00107\u001a\u00020\"2\u0006\u00108\u001a\u000209H\u0016J\u0010\u0010:\u001a\u00020\"2\u0006\u0010,\u001a\u00020\u0019H\u0002J\u0018\u0010;\u001a\u00020\"2\u0006\u0010<\u001a\u00020\r2\u0006\u0010=\u001a\u00020.H\u0002R\u001b\u0010\u0006\u001a\u00020\u00078BX\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\tR\u000e\u0010\f\u001a\u00020\rX.¢\u0006\u0002\n\u0000R\u001b\u0010\u000e\u001a\u00020\u000f8BX\u0002¢\u0006\f\n\u0004\b\u0012\u0010\u000b\u001a\u0004\b\u0010\u0010\u0011R\u001b\u0010\u0013\u001a\u00020\u00148BX\u0002¢\u0006\f\n\u0004\b\u0017\u0010\u000b\u001a\u0004\b\u0015\u0010\u0016R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u001bX.¢\u0006\u0002\n\u0000R\u001b\u0010\u001c\u001a\u00020\u001d8BX\u0002¢\u0006\f\n\u0004\b \u0010\u000b\u001a\u0004\b\u001e\u0010\u001f¨\u0006?"}, d2 = {"Lcom/deliveryhero/chatui/view/root/CustomerChatActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "Lcom/deliveryhero/chatui/view/chatroom/callback/ThumbnailClickedCallback;", "Lcom/deliveryhero/customerchat/di/MyKoinComponent;", "Lcom/deliveryhero/chatui/view/root/ICanHideCallButton;", "()V", "attributeUtils", "Lcom/deliveryhero/customerchat/view/util/AttributeUtils;", "getAttributeUtils", "()Lcom/deliveryhero/customerchat/view/util/AttributeUtils;", "attributeUtils$delegate", "Lkotlin/Lazy;", "callButton", "Landroid/view/MenuItem;", "cameraImageRepo", "Lcom/deliveryhero/chatui/data/CameraImageRepository;", "getCameraImageRepo", "()Lcom/deliveryhero/chatui/data/CameraImageRepository;", "cameraImageRepo$delegate", "eventHandler", "Lcom/deliveryhero/chatui/data/event/EventHandler;", "getEventHandler", "()Lcom/deliveryhero/chatui/data/event/EventHandler;", "eventHandler$delegate", "restoredStateBundle", "Landroid/os/Bundle;", "toolbar", "Landroidx/appcompat/widget/Toolbar;", "viewModel", "Lcom/deliveryhero/chatui/view/root/CustomerChatViewModel;", "getViewModel", "()Lcom/deliveryhero/chatui/view/root/CustomerChatViewModel;", "viewModel$delegate", "configureViews", "", "disableCallButton", "enableCallButton", "callStatus", "Lcom/deliveryhero/chatui/domain/call/CallStatus;", "hide", "observeCallStatus", "Lkotlinx/coroutines/Job;", "onBackPressed", "onCreate", "savedInstanceState", "onCreateOptionsMenu", "", "menu", "Landroid/view/Menu;", "onOptionsItemSelected", "item", "onSaveInstanceState", "outState", "onStart", "onStop", "onThumbnailClicked", "image", "", "retrieveSavedFilePath", "setTranslationIcon", "translateButton", "enabled", "Companion", "customerchat_basicRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CustomerChatActivity extends AppCompatActivity implements ThumbnailClickedCallback, MyKoinComponent, ICanHideCallButton, TraceFieldInterface {
    @NotNull
    private static final String CAMERA_IMAGE_PATH = "CAMERA_IMAGE_PATH";
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @NotNull
    private static final String PERSISTABLE_CHAT_CONFIGURATION = "PERSISTABLE_CHAT_CONFIGURATION";
    /* access modifiers changed from: private */
    public static boolean visible;
    public Trace _nr_trace;
    @NotNull
    private final Lazy attributeUtils$delegate;
    /* access modifiers changed from: private */
    public MenuItem callButton;
    @NotNull
    private final Lazy cameraImageRepo$delegate;
    @NotNull
    private final Lazy eventHandler$delegate;
    /* access modifiers changed from: private */
    @Nullable
    public Bundle restoredStateBundle;
    private Toolbar toolbar;
    @NotNull
    private final Lazy viewModel$delegate = LazyKt__LazyJVMKt.lazy(LazyThreadSafetyMode.NONE, new CustomerChatActivity$special$$inlined$viewModel$default$2(this, (Qualifier) null, new CustomerChatActivity$special$$inlined$viewModel$default$1(this), (Function0) null));

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fR\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\u00020\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000b¨\u0006\u0010"}, d2 = {"Lcom/deliveryhero/chatui/view/root/CustomerChatActivity$Companion;", "", "()V", "CAMERA_IMAGE_PATH", "", "PERSISTABLE_CHAT_CONFIGURATION", "visible", "", "getVisible", "()Z", "setVisible", "(Z)V", "newInstance", "", "context", "Landroid/content/Context;", "customerchat_basicRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final boolean getVisible() {
            return CustomerChatActivity.visible;
        }

        public final void newInstance(@NotNull Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intent intent = new Intent(context, CustomerChatActivity.class);
            intent.setFlags(268435456);
            context.startActivity(intent);
        }

        public final void setVisible(boolean z11) {
            CustomerChatActivity.visible = z11;
        }
    }

    public CustomerChatActivity() {
        LazyThreadSafetyMode lazyThreadSafetyMode = LazyThreadSafetyMode.SYNCHRONIZED;
        this.eventHandler$delegate = LazyKt__LazyJVMKt.lazy(lazyThreadSafetyMode, new CustomerChatActivity$special$$inlined$inject$default$1(this, (Qualifier) null, (Function0) null));
        this.attributeUtils$delegate = LazyKt__LazyJVMKt.lazy(lazyThreadSafetyMode, new CustomerChatActivity$special$$inlined$inject$default$2(this, (Qualifier) null, (Function0) null));
        this.cameraImageRepo$delegate = LazyKt__LazyJVMKt.lazy(lazyThreadSafetyMode, new CustomerChatActivity$special$$inlined$inject$default$3(this, (Qualifier) null, (Function0) null));
    }

    private final void configureViews() {
        setContentView(R.layout.customer_chat_activity);
        View findViewById = findViewById(R.id.toolbar);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.toolbar)");
        Toolbar toolbar2 = (Toolbar) findViewById;
        this.toolbar = toolbar2;
        if (toolbar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("toolbar");
            toolbar2 = null;
        }
        setSupportActionBar(toolbar2);
        ActionBar supportActionBar = getSupportActionBar();
        if (supportActionBar != null) {
            supportActionBar.setDisplayHomeAsUpEnabled(true);
        }
        setTitle(getViewModel().getTitle$customerchat_basicRelease());
        getViewModel().getTypingLiveData$customerchat_basicRelease().observe(this, new a(this));
    }

    /* access modifiers changed from: private */
    /* renamed from: configureViews$lambda-2  reason: not valid java name */
    public static final void m8170configureViews$lambda2(CustomerChatActivity customerChatActivity, Integer num) {
        int i11;
        Intrinsics.checkNotNullParameter(customerChatActivity, "this$0");
        Toolbar toolbar2 = customerChatActivity.toolbar;
        String str = null;
        if (toolbar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("toolbar");
            toolbar2 = null;
        }
        Resources resources = customerChatActivity.getResources();
        if (resources != null) {
            if (num == null) {
                i11 = R.string.customer_chat_chat_typing_empty;
            } else {
                i11 = num.intValue();
            }
            str = resources.getString(i11);
        }
        toolbar2.setSubtitle((CharSequence) str);
    }

    /* access modifiers changed from: private */
    public final void disableCallButton() {
        MenuItem menuItem = this.callButton;
        MenuItem menuItem2 = null;
        if (menuItem == null) {
            Intrinsics.throwUninitializedPropertyAccessException("callButton");
            menuItem = null;
        }
        menuItem.setIcon(getAttributeUtils().getIconDrawable(this, R.attr.disabledCallIcon));
        MenuItem menuItem3 = this.callButton;
        if (menuItem3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("callButton");
        } else {
            menuItem2 = menuItem3;
        }
        menuItem2.setEnabled(false);
    }

    /* access modifiers changed from: private */
    public final void enableCallButton(CallStatus callStatus) {
        MenuItem menuItem = this.callButton;
        MenuItem menuItem2 = null;
        if (menuItem == null) {
            Intrinsics.throwUninitializedPropertyAccessException("callButton");
            menuItem = null;
        }
        menuItem.setIcon(getAttributeUtils().getIconDrawable(this, R.attr.enabledCallIcon));
        MenuItem menuItem3 = this.callButton;
        if (menuItem3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("callButton");
            menuItem3 = null;
        }
        menuItem3.setOnMenuItemClickListener(new b(this, callStatus));
        MenuItem menuItem4 = this.callButton;
        if (menuItem4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("callButton");
            menuItem4 = null;
        }
        menuItem4.setVisible(true);
        MenuItem menuItem5 = this.callButton;
        if (menuItem5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("callButton");
        } else {
            menuItem2 = menuItem5;
        }
        menuItem2.setEnabled(true);
    }

    /* access modifiers changed from: private */
    /* renamed from: enableCallButton$lambda-5  reason: not valid java name */
    public static final boolean m8171enableCallButton$lambda5(CustomerChatActivity customerChatActivity, CallStatus callStatus, MenuItem menuItem) {
        Intrinsics.checkNotNullParameter(customerChatActivity, "this$0");
        Intrinsics.checkNotNullParameter(callStatus, "$callStatus");
        Intrinsics.checkNotNullParameter(menuItem, "it");
        customerChatActivity.getViewModel().call(callStatus);
        return true;
    }

    private final AttributeUtils getAttributeUtils() {
        return (AttributeUtils) this.attributeUtils$delegate.getValue();
    }

    private final CameraImageRepository getCameraImageRepo() {
        return (CameraImageRepository) this.cameraImageRepo$delegate.getValue();
    }

    private final EventHandler getEventHandler() {
        return (EventHandler) this.eventHandler$delegate.getValue();
    }

    /* access modifiers changed from: private */
    public final CustomerChatViewModel getViewModel() {
        return (CustomerChatViewModel) this.viewModel$delegate.getValue();
    }

    /* access modifiers changed from: private */
    public final Job observeCallStatus() {
        return BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), (CoroutineContext) null, (CoroutineStart) null, new CustomerChatActivity$observeCallStatus$1(this, (Continuation<? super CustomerChatActivity$observeCallStatus$1>) null), 3, (Object) null);
    }

    private final void retrieveSavedFilePath(Bundle bundle) {
        boolean z11;
        if (bundle.containsKey(CAMERA_IMAGE_PATH)) {
            String string = bundle.getString(CAMERA_IMAGE_PATH);
            if (string == null) {
                string = "";
            }
            if (string.length() > 0) {
                z11 = true;
            } else {
                z11 = false;
            }
            if (z11) {
                getCameraImageRepo().cacheImageInfo(string);
            }
        }
    }

    private final void setTranslationIcon(MenuItem menuItem, boolean z11) {
        Drawable drawable;
        if (z11) {
            drawable = getAttributeUtils().getIconDrawable(this, R.attr.enabledTranslationIcon);
        } else {
            drawable = getAttributeUtils().getIconDrawable(this, R.attr.disabledTranslationIcon);
        }
        if (drawable != null) {
            menuItem.setIcon(drawable);
        }
    }

    @NotNull
    public Koin getKoin() {
        return MyKoinComponent.DefaultImpls.getKoin(this);
    }

    public void hide() {
        getViewModel().hideCallButton();
    }

    public void onBackPressed() {
        IOnBackPressed iOnBackPressed;
        Fragment findFragmentById = getSupportFragmentManager().findFragmentById(R.id.container_open_channel);
        if (findFragmentById instanceof IOnBackPressed) {
            iOnBackPressed = (IOnBackPressed) findFragmentById;
        } else {
            iOnBackPressed = null;
        }
        if (iOnBackPressed == null || CustomerChatActivityKt.takeIfTrue(Boolean.valueOf(iOnBackPressed.onBackPressed())) == null) {
            getOnBackPressedDispatcher().onBackPressed();
            Unit unit = Unit.INSTANCE;
        }
    }

    public void onCreate(@Nullable Bundle bundle) {
        PersistableChatConfiguration decode;
        TraceMachine.startTracing("CustomerChatActivity");
        ChatConfiguration chatConfiguration = null;
        try {
            TraceMachine.enterMethod(this._nr_trace, "CustomerChatActivity#onCreate", (ArrayList<String>) null);
        } catch (NoSuchFieldError unused) {
            TraceMachine.enterMethod((Trace) null, "CustomerChatActivity#onCreate", (ArrayList<String>) null);
        }
        super.onCreate(bundle);
        this.restoredStateBundle = bundle;
        if (bundle != null) {
            String string = bundle.getString(PERSISTABLE_CHAT_CONFIGURATION);
            if (!(string == null || (decode = PersistableChatConfiguration.Companion.decode(string)) == null)) {
                chatConfiguration = decode.toChatConfiguration();
            }
            if (chatConfiguration != null) {
                CustomerChatModule.Companion companion = CustomerChatModule.Companion;
                Application application = getApplication();
                Intrinsics.checkNotNullExpressionValue(application, MimeTypes.BASE_TYPE_APPLICATION);
                companion.getInstance(application).reconfigureSDK$customerchat_basicRelease(chatConfiguration);
            }
            retrieveSavedFilePath(bundle);
        }
        setTheme(getViewModel().getChatConfiguration().getThemeResID());
        getTheme().applyStyle(getViewModel().getChatConfiguration().getThemeResID(), true);
        getViewModel().init$customerchat_basicRelease();
        configureViews();
        if (bundle == null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.container_open_channel, new ChatFragment()).commit();
        }
        TraceMachine.exitMethod();
    }

    public boolean onCreateOptionsMenu(@NotNull Menu menu) {
        Intrinsics.checkNotNullParameter(menu, MenuScreenPerformanceParams.SCREEN_TYPE);
        getMenuInflater().inflate(R.menu.customer_chat_menu_chat, menu);
        MenuItem findItem = menu.findItem(R.id.action_call);
        Intrinsics.checkNotNullExpressionValue(findItem, "menu.findItem(R.id.action_call)");
        this.callButton = findItem;
        Job unused = BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), (CoroutineContext) null, (CoroutineStart) null, new CustomerChatActivity$onCreateOptionsMenu$1(this, (Continuation<? super CustomerChatActivity$onCreateOptionsMenu$1>) null), 3, (Object) null);
        MenuItem findItem2 = menu.findItem(R.id.action_translate);
        if (findItem2 != null) {
            findItem2.setVisible(getViewModel().getCanTranslate$customerchat_basicRelease());
            Fragment findFragmentById = getSupportFragmentManager().findFragmentById(R.id.container_open_channel);
            if (findFragmentById instanceof ChatFragment) {
                setTranslationIcon(findItem2, ((ChatFragment) findFragmentById).isTranslated());
            }
        }
        return super.onCreateOptionsMenu(menu);
    }

    public boolean onOptionsItemSelected(@NotNull MenuItem menuItem) {
        Intrinsics.checkNotNullParameter(menuItem, "item");
        int itemId = menuItem.getItemId();
        if (itemId == R.id.action_call) {
            return true;
        }
        if (itemId == R.id.action_translate) {
            Fragment findFragmentById = getSupportFragmentManager().findFragmentById(R.id.container_open_channel);
            if (!(findFragmentById instanceof ChatFragment)) {
                return true;
            }
            setTranslationIcon(menuItem, ((ChatFragment) findFragmentById).translate());
            return true;
        } else if (itemId != 16908332) {
            return super.onOptionsItemSelected(menuItem);
        } else {
            onBackPressed();
            return true;
        }
    }

    public void onSaveInstanceState(@NotNull Bundle bundle) {
        Intrinsics.checkNotNullParameter(bundle, "outState");
        super.onSaveInstanceState(bundle);
        bundle.putString(PERSISTABLE_CHAT_CONFIGURATION, getViewModel().getChatConfiguration().toPersistableChatConfiguration().encode());
        bundle.putString(CAMERA_IMAGE_PATH, getCameraImageRepo().getImagePath());
    }

    public void onStart() {
        ApplicationStateMonitor.getInstance().activityStarted();
        super.onStart();
        visible = true;
        getEventHandler().onEvent(Event.Open.INSTANCE);
    }

    public void onStop() {
        ApplicationStateMonitor.getInstance().activityStopped();
        visible = false;
        super.onStop();
        getEventHandler().onEvent(Event.Close.INSTANCE);
    }

    public void onThumbnailClicked(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "image");
        FullScreenImageFragment.Companion.newInstance(str).show(getSupportFragmentManager(), FullScreenImageFragment.TAG);
    }
}
