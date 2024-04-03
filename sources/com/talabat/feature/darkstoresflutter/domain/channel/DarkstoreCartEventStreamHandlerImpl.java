package com.talabat.feature.darkstoresflutter.domain.channel;

import androidx.annotation.VisibleForTesting;
import com.talabat.core.dispatcher.domain.RxSchedulersFactory;
import com.talabat.feature.darkstoresflutter.domain.usecase.GetCartChanges;
import com.talabat.fluttercore.channels.dto.EventChannels;
import io.flutter.embedding.engine.FlutterEngine;
import io.flutter.plugin.common.EventChannel;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.rxkotlin.DisposableKt;
import java.util.Map;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mm.a;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u00012\u00020\u0002B\u0017\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u001e\u0010\u0017\u001a\u00020\u00182\u0014\u0010\u0019\u001a\u0010\u0012\u0004\u0012\u00020\u001b\u0012\u0006\u0012\u0004\u0018\u00010\u001c0\u001aH\u0002J\u0012\u0010\u001d\u001a\u00020\u00182\b\u0010\u001e\u001a\u0004\u0018\u00010\u001cH\u0016J\u001c\u0010\u001f\u001a\u00020\u00182\b\u0010\u001e\u001a\u0004\u0018\u00010\u001c2\b\u0010 \u001a\u0004\u0018\u00010\tH\u0016J\u0010\u0010!\u001a\u00020\u00182\u0006\u0010\"\u001a\u00020#H\u0016J\u0010\u0010$\u001a\u00020\u00182\u0006\u0010%\u001a\u00020\u001bH\u0002J\b\u0010&\u001a\u00020\u0018H\u0016J%\u0010'\u001a\u0004\u0018\u0001H(\"\u0004\b\u0000\u0010(*\u0004\u0018\u00010\u001c2\b\u0010)\u001a\u0004\u0018\u00010\u001bH\u0002¢\u0006\u0002\u0010*R&\u0010\b\u001a\u0004\u0018\u00010\t8\u0000@\u0000X\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR$\u0010\u0010\u001a\u00020\u00118\u0000@\u0000X\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u0012\u0010\u000b\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006+"}, d2 = {"Lcom/talabat/feature/darkstoresflutter/domain/channel/DarkstoreCartEventStreamHandlerImpl;", "Lio/flutter/plugin/common/EventChannel$StreamHandler;", "Lcom/talabat/feature/darkstoresflutter/domain/channel/DarkstoreCartEventStreamHandler;", "getCartChanges", "Lcom/talabat/feature/darkstoresflutter/domain/usecase/GetCartChanges;", "rxSchedulersFactory", "Lcom/talabat/core/dispatcher/domain/RxSchedulersFactory;", "(Lcom/talabat/feature/darkstoresflutter/domain/usecase/GetCartChanges;Lcom/talabat/core/dispatcher/domain/RxSchedulersFactory;)V", "cartEventSink", "Lio/flutter/plugin/common/EventChannel$EventSink;", "getCartEventSink$com_talabat_feature_darkstores_flutter_domain_domain$annotations", "()V", "getCartEventSink$com_talabat_feature_darkstores_flutter_domain_domain", "()Lio/flutter/plugin/common/EventChannel$EventSink;", "setCartEventSink$com_talabat_feature_darkstores_flutter_domain_domain", "(Lio/flutter/plugin/common/EventChannel$EventSink;)V", "compositeDisposable", "Lio/reactivex/disposables/CompositeDisposable;", "getCompositeDisposable$com_talabat_feature_darkstores_flutter_domain_domain$annotations", "getCompositeDisposable$com_talabat_feature_darkstores_flutter_domain_domain", "()Lio/reactivex/disposables/CompositeDisposable;", "setCompositeDisposable$com_talabat_feature_darkstores_flutter_domain_domain", "(Lio/reactivex/disposables/CompositeDisposable;)V", "dispatchCart", "", "cart", "", "", "", "onCancel", "arguments", "onListen", "events", "setUpWithEngine", "engine", "Lio/flutter/embedding/engine/FlutterEngine;", "startObservingCartChanges", "vendorId", "terminate", "getArgument", "T", "key", "(Ljava/lang/Object;Ljava/lang/String;)Ljava/lang/Object;", "com_talabat_feature_darkstores-flutter_domain_domain"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class DarkstoreCartEventStreamHandlerImpl implements EventChannel.StreamHandler, DarkstoreCartEventStreamHandler {
    @Nullable
    private EventChannel.EventSink cartEventSink;
    @NotNull
    private CompositeDisposable compositeDisposable = new CompositeDisposable();
    @NotNull
    private final GetCartChanges getCartChanges;
    @NotNull
    private final RxSchedulersFactory rxSchedulersFactory;

    @Inject
    public DarkstoreCartEventStreamHandlerImpl(@NotNull GetCartChanges getCartChanges2, @NotNull RxSchedulersFactory rxSchedulersFactory2) {
        Intrinsics.checkNotNullParameter(getCartChanges2, "getCartChanges");
        Intrinsics.checkNotNullParameter(rxSchedulersFactory2, "rxSchedulersFactory");
        this.getCartChanges = getCartChanges2;
        this.rxSchedulersFactory = rxSchedulersFactory2;
    }

    /* access modifiers changed from: private */
    public final void dispatchCart(Map<String, ? extends Object> map) {
        EventChannel.EventSink eventSink = this.cartEventSink;
        if (eventSink != null) {
            eventSink.success(map);
        }
    }

    private final <T> T getArgument(Object obj, String str) {
        if (obj == null) {
            return null;
        }
        if (obj instanceof Map) {
            return ((Map) obj).get(str);
        }
        if (obj instanceof JSONObject) {
            return ((JSONObject) obj).opt(str);
        }
        throw new ClassCastException();
    }

    @VisibleForTesting
    public static /* synthetic */ void getCartEventSink$com_talabat_feature_darkstores_flutter_domain_domain$annotations() {
    }

    @VisibleForTesting
    public static /* synthetic */ void getCompositeDisposable$com_talabat_feature_darkstores_flutter_domain_domain$annotations() {
    }

    private final void startObservingCartChanges(String str) {
        this.compositeDisposable.clear();
        Disposable subscribe = this.getCartChanges.invoke(str).retry().distinctUntilChanged().subscribeOn(this.rxSchedulersFactory.io()).observeOn(this.rxSchedulersFactory.main()).subscribe(new a(this));
        Intrinsics.checkNotNullExpressionValue(subscribe, "getCartChanges(vendorId)…subscribe(::dispatchCart)");
        DisposableKt.addTo(subscribe, this.compositeDisposable);
    }

    @Nullable
    public final EventChannel.EventSink getCartEventSink$com_talabat_feature_darkstores_flutter_domain_domain() {
        return this.cartEventSink;
    }

    @NotNull
    public final CompositeDisposable getCompositeDisposable$com_talabat_feature_darkstores_flutter_domain_domain() {
        return this.compositeDisposable;
    }

    public void onCancel(@Nullable Object obj) {
        this.cartEventSink = null;
        this.compositeDisposable.clear();
    }

    public void onListen(@Nullable Object obj, @Nullable EventChannel.EventSink eventSink) {
        this.cartEventSink = eventSink;
        String str = (String) getArgument(obj, "vendorId");
        if (str != null) {
            startObservingCartChanges(str);
        }
    }

    public final void setCartEventSink$com_talabat_feature_darkstores_flutter_domain_domain(@Nullable EventChannel.EventSink eventSink) {
        this.cartEventSink = eventSink;
    }

    public final void setCompositeDisposable$com_talabat_feature_darkstores_flutter_domain_domain(@NotNull CompositeDisposable compositeDisposable2) {
        Intrinsics.checkNotNullParameter(compositeDisposable2, "<set-?>");
        this.compositeDisposable = compositeDisposable2;
    }

    public void setUpWithEngine(@NotNull FlutterEngine flutterEngine) {
        Intrinsics.checkNotNullParameter(flutterEngine, "engine");
        new EventChannel(flutterEngine.getDartExecutor(), EventChannels.DARKSTORES_CART_UPDATES_CHANNEL).setStreamHandler(this);
    }

    public void terminate() {
        this.compositeDisposable.clear();
    }
}
