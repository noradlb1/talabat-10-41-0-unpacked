package com.instabug.library;

import java.lang.annotation.RetentionPolicy;
import kotlin.annotation.AnnotationRetention;
import kotlin.annotation.Retention;
import org.jetbrains.annotations.NotNull;

@Retention(AnnotationRetention.RUNTIME)
@java.lang.annotation.Retention(RetentionPolicy.RUNTIME)
public @interface IBGNetworkWorker {
    @NotNull
    public static final String ANNOUNCEMENTS = "ANNOUNCEMENTS";
    @NotNull
    public static final String BUGS = "BUGS";
    @NotNull
    public static final String CHATS = "CHATS";
    @NotNull
    public static final String CORE = "CORE";
    @NotNull
    public static final String CRASH = "CRASH";
    @NotNull
    public static final a Companion = a.f50496a;
    @NotNull
    public static final String FEATURES_REQUEST = "FEATURES_REQUEST";
    @NotNull
    public static final String SURVEYS = "SURVEYS";

    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ a f50496a = new a();

        private a() {
        }
    }
}
