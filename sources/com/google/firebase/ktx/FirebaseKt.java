package com.google.firebase.ktx;

import android.content.Context;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.components.Component;
import com.google.firebase.components.Dependency;
import com.google.firebase.components.Qualified;
import java.lang.annotation.Annotation;
import java.util.concurrent.Executor;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineDispatcher;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00004\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u001b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\u001a\u001b\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\f\"\n\b\u0000\u0010\u000e\u0018\u0001*\u00020\u000fH\b\u001a\u0012\u0010\u0002\u001a\u00020\u0003*\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u0001\u001a\u0014\u0010\u0011\u001a\u0004\u0018\u00010\u0003*\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u0013\u001a\u001a\u0010\u0011\u001a\u00020\u0003*\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0007\u001a\u00020\b\u001a\"\u0010\u0011\u001a\u00020\u0003*\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\u0001\"\u000e\u0010\u0000\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001a\u00020\u0003*\u00020\u00048F¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006\"\u0015\u0010\u0007\u001a\u00020\b*\u00020\u00048F¢\u0006\u0006\u001a\u0004\b\t\u0010\n¨\u0006\u0014"}, d2 = {"LIBRARY_NAME", "", "app", "Lcom/google/firebase/FirebaseApp;", "Lcom/google/firebase/ktx/Firebase;", "getApp", "(Lcom/google/firebase/ktx/Firebase;)Lcom/google/firebase/FirebaseApp;", "options", "Lcom/google/firebase/FirebaseOptions;", "getOptions", "(Lcom/google/firebase/ktx/Firebase;)Lcom/google/firebase/FirebaseOptions;", "coroutineDispatcher", "Lcom/google/firebase/components/Component;", "Lkotlinx/coroutines/CoroutineDispatcher;", "T", "", "name", "initialize", "context", "Landroid/content/Context;", "com.google.firebase-firebase-common-ktx"}, k = 2, mv = {1, 7, 1}, xi = 48)
public final class FirebaseKt {
    @NotNull
    public static final String LIBRARY_NAME = "fire-core-ktx";

    @NotNull
    public static final FirebaseApp app(@NotNull Firebase firebase2, @NotNull String str) {
        Intrinsics.checkNotNullParameter(firebase2, "<this>");
        Intrinsics.checkNotNullParameter(str, "name");
        FirebaseApp instance = FirebaseApp.getInstance(str);
        Intrinsics.checkNotNullExpressionValue(instance, "getInstance(name)");
        return instance;
    }

    private static final /* synthetic */ <T extends Annotation> Component<CoroutineDispatcher> coroutineDispatcher() {
        Intrinsics.reifiedOperationMarker(4, "T");
        Class<Annotation> cls = Annotation.class;
        Component.Builder<Annotation> builder = Component.builder(Qualified.qualified(cls, CoroutineDispatcher.class));
        Intrinsics.reifiedOperationMarker(4, "T");
        Component.Builder<Annotation> add = builder.add(Dependency.required((Qualified<?>) Qualified.qualified(cls, Executor.class)));
        Intrinsics.needClassReification();
        Component<Annotation> build = add.factory(FirebaseKt$coroutineDispatcher$1.INSTANCE).build();
        Intrinsics.checkNotNullExpressionValue(build, "builder(Qualified.qualif…cher()\n    }\n    .build()");
        return build;
    }

    @NotNull
    public static final FirebaseApp getApp(@NotNull Firebase firebase2) {
        Intrinsics.checkNotNullParameter(firebase2, "<this>");
        FirebaseApp instance = FirebaseApp.getInstance();
        Intrinsics.checkNotNullExpressionValue(instance, "getInstance()");
        return instance;
    }

    @NotNull
    public static final FirebaseOptions getOptions(@NotNull Firebase firebase2) {
        Intrinsics.checkNotNullParameter(firebase2, "<this>");
        FirebaseOptions options = getApp(Firebase.INSTANCE).getOptions();
        Intrinsics.checkNotNullExpressionValue(options, "Firebase.app.options");
        return options;
    }

    @Nullable
    public static final FirebaseApp initialize(@NotNull Firebase firebase2, @NotNull Context context) {
        Intrinsics.checkNotNullParameter(firebase2, "<this>");
        Intrinsics.checkNotNullParameter(context, "context");
        return FirebaseApp.initializeApp(context);
    }

    @NotNull
    public static final FirebaseApp initialize(@NotNull Firebase firebase2, @NotNull Context context, @NotNull FirebaseOptions firebaseOptions) {
        Intrinsics.checkNotNullParameter(firebase2, "<this>");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(firebaseOptions, "options");
        FirebaseApp initializeApp = FirebaseApp.initializeApp(context, firebaseOptions);
        Intrinsics.checkNotNullExpressionValue(initializeApp, "initializeApp(context, options)");
        return initializeApp;
    }

    @NotNull
    public static final FirebaseApp initialize(@NotNull Firebase firebase2, @NotNull Context context, @NotNull FirebaseOptions firebaseOptions, @NotNull String str) {
        Intrinsics.checkNotNullParameter(firebase2, "<this>");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(firebaseOptions, "options");
        Intrinsics.checkNotNullParameter(str, "name");
        FirebaseApp initializeApp = FirebaseApp.initializeApp(context, firebaseOptions, str);
        Intrinsics.checkNotNullExpressionValue(initializeApp, "initializeApp(context, options, name)");
        return initializeApp;
    }
}
