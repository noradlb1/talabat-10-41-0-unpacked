package com.instabug.library.model.common;

import java.lang.annotation.RetentionPolicy;
import kotlin.annotation.AnnotationRetention;
import kotlin.annotation.Retention;
import org.jetbrains.annotations.NotNull;

@Retention(AnnotationRetention.SOURCE)
@java.lang.annotation.Retention(RetentionPolicy.SOURCE)
public @interface SessionVersion {
    @NotNull
    public static final a Companion = a.f51513a;
    @NotNull
    public static final String V2 = "V2";
    @NotNull
    public static final String V3 = "V3";

    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ a f51513a = new a();

        private a() {
        }
    }
}
