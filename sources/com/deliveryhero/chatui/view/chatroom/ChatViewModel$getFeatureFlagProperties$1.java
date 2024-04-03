package com.deliveryhero.chatui.view.chatroom;

import com.deliveryhero.contract.configuration.ChatConfiguration;
import com.deliveryhero.customerchat.fwf.FeatureFlagProvider;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "com.deliveryhero.chatui.view.chatroom.ChatViewModel", f = "ChatViewModel.kt", i = {0, 0, 1, 1, 2}, l = {208, 216, 217}, m = "getFeatureFlagProperties", n = {"featureFlagProvider", "chatConfiguration", "featureFlagProvider", "chatConfiguration", "chatConfiguration"}, s = {"L$0", "L$1", "L$0", "L$1", "L$0"})
public final class ChatViewModel$getFeatureFlagProperties$1 extends ContinuationImpl {

    /* renamed from: h  reason: collision with root package name */
    public Object f29500h;

    /* renamed from: i  reason: collision with root package name */
    public Object f29501i;

    /* renamed from: j  reason: collision with root package name */
    public boolean f29502j;

    /* renamed from: k  reason: collision with root package name */
    public boolean f29503k;

    /* renamed from: l  reason: collision with root package name */
    public boolean f29504l;

    /* renamed from: m  reason: collision with root package name */
    public boolean f29505m;

    /* renamed from: n  reason: collision with root package name */
    public boolean f29506n;

    /* renamed from: o  reason: collision with root package name */
    public boolean f29507o;

    /* renamed from: p  reason: collision with root package name */
    public int f29508p;

    /* renamed from: q  reason: collision with root package name */
    public /* synthetic */ Object f29509q;

    /* renamed from: r  reason: collision with root package name */
    public final /* synthetic */ ChatViewModel f29510r;

    /* renamed from: s  reason: collision with root package name */
    public int f29511s;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ChatViewModel$getFeatureFlagProperties$1(ChatViewModel chatViewModel, Continuation<? super ChatViewModel$getFeatureFlagProperties$1> continuation) {
        super(continuation);
        this.f29510r = chatViewModel;
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.f29509q = obj;
        this.f29511s |= Integer.MIN_VALUE;
        return this.f29510r.getFeatureFlagProperties((FeatureFlagProvider) null, (ChatConfiguration) null, this);
    }
}
