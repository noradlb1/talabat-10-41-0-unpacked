package com.deliveryhero.chatui.view.fullscreenimage;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import com.deliveryhero.chatui.view.root.IOnBackPressed;
import com.deliveryhero.customerchat.R;
import com.deliveryhero.customerchat.databinding.CustomerChatFragmentFullscreenImageBinding;
import com.github.chrisbanes.photoview.PhotoView;
import com.newrelic.agent.android.api.v2.TraceFieldInterface;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.newrelic.agent.android.tracing.Trace;
import com.newrelic.agent.android.tracing.TraceMachine;
import com.squareup.picasso.MemoryPolicy;
import com.squareup.picasso.Picasso;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t4.a;

@Instrumented
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u0000\u0018\u0000 \u001c2\u00020\u00012\u00020\u0002:\u0001\u001cB\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\f\u001a\u00020\nH\u0016J\b\u0010\r\u001a\u00020\u000eH\u0016J$\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0016J\b\u0010\u0017\u001a\u00020\u0018H\u0016J\u001a\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\u00102\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0016J\b\u0010\u001b\u001a\u00020\u0018H\u0002R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\u00020\u00058BX\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u000e\u0010\t\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000¨\u0006\u001d"}, d2 = {"Lcom/deliveryhero/chatui/view/fullscreenimage/FullScreenImageFragment;", "Landroidx/fragment/app/DialogFragment;", "Lcom/deliveryhero/chatui/view/root/IOnBackPressed;", "()V", "_binding", "Lcom/deliveryhero/customerchat/databinding/CustomerChatFragmentFullscreenImageBinding;", "binding", "getBinding", "()Lcom/deliveryhero/customerchat/databinding/CustomerChatFragmentFullscreenImageBinding;", "imageErrorDrawableRes", "", "imagePlaceholderDrawableRes", "getTheme", "onBackPressed", "", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onDestroyView", "", "onViewCreated", "view", "setViews", "Companion", "customerchat_basicRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class FullScreenImageFragment extends DialogFragment implements IOnBackPressed, TraceFieldInterface {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @NotNull
    private static final String IMAGE_SRC = "image_src";
    @NotNull
    public static final String TAG = "FullScreenImageFragment";
    @Nullable
    private CustomerChatFragmentFullscreenImageBinding _binding;
    public Trace _nr_trace;
    private final int imageErrorDrawableRes = R.drawable.customer_chat_ic_download_failed;
    private final int imagePlaceholderDrawableRes = R.drawable.customer_chat_loading_spinner;

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/deliveryhero/chatui/view/fullscreenimage/FullScreenImageFragment$Companion;", "", "()V", "IMAGE_SRC", "", "TAG", "newInstance", "Lcom/deliveryhero/chatui/view/fullscreenimage/FullScreenImageFragment;", "imageSrc", "customerchat_basicRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final FullScreenImageFragment newInstance(@NotNull String str) {
            Intrinsics.checkNotNullParameter(str, "imageSrc");
            FullScreenImageFragment fullScreenImageFragment = new FullScreenImageFragment();
            Bundle bundle = new Bundle();
            bundle.putString(FullScreenImageFragment.IMAGE_SRC, str);
            fullScreenImageFragment.setArguments(bundle);
            return fullScreenImageFragment;
        }
    }

    private final CustomerChatFragmentFullscreenImageBinding getBinding() {
        CustomerChatFragmentFullscreenImageBinding customerChatFragmentFullscreenImageBinding = this._binding;
        Intrinsics.checkNotNull(customerChatFragmentFullscreenImageBinding);
        return customerChatFragmentFullscreenImageBinding;
    }

    /* access modifiers changed from: private */
    /* renamed from: onCreateView$lambda-1  reason: not valid java name */
    public static final void m8169onCreateView$lambda1(FullScreenImageFragment fullScreenImageFragment, View view) {
        DialogFragment dialogFragment;
        Intrinsics.checkNotNullParameter(fullScreenImageFragment, "this$0");
        Fragment findFragmentByTag = fullScreenImageFragment.getParentFragmentManager().findFragmentByTag(TAG);
        if (findFragmentByTag != null) {
            if (findFragmentByTag instanceof DialogFragment) {
                dialogFragment = (DialogFragment) findFragmentByTag;
            } else {
                dialogFragment = null;
            }
            if (dialogFragment != null) {
                dialogFragment.dismiss();
            }
        }
    }

    /* access modifiers changed from: private */
    public final void setViews() {
        int width = getBinding().fullscreenImage.getWidth();
        int height = getBinding().fullscreenImage.getHeight();
        String string = requireArguments().getString(IMAGE_SRC);
        if (string != null) {
            Picasso.get().load(string).memoryPolicy(MemoryPolicy.NO_CACHE, new MemoryPolicy[0]).error(this.imageErrorDrawableRes).placeholder(this.imagePlaceholderDrawableRes).resize(width, height).centerInside().onlyScaleDown().into((ImageView) getBinding().fullscreenImage);
        }
    }

    public int getTheme() {
        return R.style.CustomerChatFullScreenDialogTheme;
    }

    public boolean onBackPressed() {
        return false;
    }

    @NotNull
    public View onCreateView(@NotNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        try {
            TraceMachine.enterMethod(this._nr_trace, "FullScreenImageFragment#onCreateView", (ArrayList<String>) null);
        } catch (NoSuchFieldError unused) {
            TraceMachine.enterMethod((Trace) null, "FullScreenImageFragment#onCreateView", (ArrayList<String>) null);
        }
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        this._binding = CustomerChatFragmentFullscreenImageBinding.inflate(layoutInflater, viewGroup, false);
        ConstraintLayout root = getBinding().getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "binding.root");
        getBinding().closeFullScreen.setOnClickListener(new a(this));
        TraceMachine.exitMethod();
        return root;
    }

    public void onDestroyView() {
        super.onDestroyView();
        this._binding = null;
    }

    public void onStart() {
        super.onStart();
    }

    public void onStop() {
        super.onStop();
    }

    public void onViewCreated(@NotNull View view, @Nullable Bundle bundle) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, bundle);
        PhotoView photoView = getBinding().fullscreenImage;
        Intrinsics.checkNotNullExpressionValue(photoView, "binding.fullscreenImage");
        photoView.addOnLayoutChangeListener(new FullScreenImageFragment$onViewCreated$$inlined$doOnNextLayout$1(this));
    }
}
