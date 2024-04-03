package com.google.firebase.ktx;

import androidx.annotation.Keep;
import com.google.firebase.annotations.concurrent.Background;
import com.google.firebase.annotations.concurrent.Blocking;
import com.google.firebase.annotations.concurrent.Lightweight;
import com.google.firebase.annotations.concurrent.UiThread;
import com.google.firebase.components.Component;
import com.google.firebase.components.ComponentRegistrar;
import com.google.firebase.components.Dependency;
import com.google.firebase.components.Qualified;
import com.google.firebase.platforminfo.LibraryVersionComponent;
import java.util.List;
import java.util.concurrent.Executor;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineDispatcher;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00050\u0004H\u0016¨\u0006\u0006"}, d2 = {"Lcom/google/firebase/ktx/FirebaseCommonKtxRegistrar;", "Lcom/google/firebase/components/ComponentRegistrar;", "()V", "getComponents", "", "Lcom/google/firebase/components/Component;", "com.google.firebase-firebase-common-ktx"}, k = 1, mv = {1, 7, 1}, xi = 48)
@Keep
public final class FirebaseCommonKtxRegistrar implements ComponentRegistrar {
    @NotNull
    public List<Component<?>> getComponents() {
        Class<Background> cls = Background.class;
        Class<CoroutineDispatcher> cls2 = CoroutineDispatcher.class;
        Class<Executor> cls3 = Executor.class;
        Component<CoroutineDispatcher> build = Component.builder(Qualified.qualified(cls, cls2)).add(Dependency.required((Qualified<?>) Qualified.qualified(cls, cls3))).factory(FirebaseCommonKtxRegistrar$getComponents$$inlined$coroutineDispatcher$1.INSTANCE).build();
        Intrinsics.checkNotNullExpressionValue(build, "builder(Qualified.qualif…cher()\n    }\n    .build()");
        Class<Lightweight> cls4 = Lightweight.class;
        Component<Lightweight> build2 = Component.builder(Qualified.qualified(cls4, cls2)).add(Dependency.required((Qualified<?>) Qualified.qualified(cls4, cls3))).factory(FirebaseCommonKtxRegistrar$getComponents$$inlined$coroutineDispatcher$2.INSTANCE).build();
        Intrinsics.checkNotNullExpressionValue(build2, "builder(Qualified.qualif…cher()\n    }\n    .build()");
        Class<Blocking> cls5 = Blocking.class;
        Component<Blocking> build3 = Component.builder(Qualified.qualified(cls5, cls2)).add(Dependency.required((Qualified<?>) Qualified.qualified(cls5, cls3))).factory(FirebaseCommonKtxRegistrar$getComponents$$inlined$coroutineDispatcher$3.INSTANCE).build();
        Intrinsics.checkNotNullExpressionValue(build3, "builder(Qualified.qualif…cher()\n    }\n    .build()");
        Class<UiThread> cls6 = UiThread.class;
        Component<UiThread> build4 = Component.builder(Qualified.qualified(cls6, cls2)).add(Dependency.required((Qualified<?>) Qualified.qualified(cls6, cls3))).factory(FirebaseCommonKtxRegistrar$getComponents$$inlined$coroutineDispatcher$4.INSTANCE).build();
        Intrinsics.checkNotNullExpressionValue(build4, "builder(Qualified.qualif…cher()\n    }\n    .build()");
        return CollectionsKt__CollectionsKt.listOf(LibraryVersionComponent.create(FirebaseKt.LIBRARY_NAME, "unspecified"), build, build2, build3, build4);
    }
}
