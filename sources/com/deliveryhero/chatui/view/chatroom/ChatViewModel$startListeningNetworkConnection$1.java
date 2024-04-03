package com.deliveryhero.chatui.view.chatroom;

import android.os.Handler;
import androidx.lifecycle.ViewModelKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "isConnected", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class ChatViewModel$startListeningNetworkConnection$1 extends Lambda implements Function1<Boolean, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ Handler f29583g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ ChatViewModel f29584h;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ChatViewModel$startListeningNetworkConnection$1(Handler handler, ChatViewModel chatViewModel) {
        super(1);
        this.f29583g = handler;
        this.f29584h = chatViewModel;
    }

    /* access modifiers changed from: private */
    /* renamed from: invoke$lambda-0  reason: not valid java name */
    public static final void m8157invoke$lambda0(ChatViewModel chatViewModel) {
        Intrinsics.checkNotNullParameter(chatViewModel, "this$0");
        if (chatViewModel.isInternetDisconnected) {
            chatViewModel.isInternetDisconnected = false;
            Job unused = BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(chatViewModel), (CoroutineContext) null, (CoroutineStart) null, new ChatViewModel$startListeningNetworkConnection$1$1$1(chatViewModel, (Continuation<? super ChatViewModel$startListeningNetworkConnection$1$1$1>) null), 3, (Object) null);
        }
        chatViewModel._noInternetLiveData.setValue(8);
        if (chatViewModel.f29493service.getAutoBackgroundDetection() && (chatViewModel.f29493service.isConnectionClosed() || !chatViewModel.f29493service.reconnect())) {
            chatViewModel.connect();
        } else if (!chatViewModel.f29493service.getAutoBackgroundDetection()) {
            chatViewModel.subscribeForMessages();
            chatViewModel._refreshing.setValue(Boolean.FALSE);
        }
        chatViewModel.f29493service.setAutoBackgroundDetection(true);
    }

    /* access modifiers changed from: private */
    /* renamed from: invoke$lambda-1  reason: not valid java name */
    public static final void m8158invoke$lambda1(ChatViewModel chatViewModel) {
        Intrinsics.checkNotNullParameter(chatViewModel, "this$0");
        chatViewModel._refreshing.setValue(Boolean.TRUE);
        chatViewModel._noInternetLiveData.setValue(0);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke(((Boolean) obj).booleanValue());
        return Unit.INSTANCE;
    }

    public final void invoke(boolean z11) {
        if (z11) {
            this.f29583g.post(new a(this.f29584h));
            return;
        }
        this.f29584h.isInternetDisconnected = true;
        this.f29583g.post(new b(this.f29584h));
    }
}
