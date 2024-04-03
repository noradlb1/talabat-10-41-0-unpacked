package com.talabat.splash.core.exception;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\f\b\u0016\u0018\u00002\u00020\u0001:\n\u0003\u0004\u0005\u0006\u0007\b\t\n\u000b\fB\u0005¢\u0006\u0002\u0010\u0002¨\u0006\r"}, d2 = {"Lcom/talabat/splash/core/exception/Failure;", "", "()V", "BadRequest", "FeatureFailure", "Forbidden", "InternalServerError", "NetworkConnection", "NotFound", "ServerError", "TimeOutError", "UnKnownError", "Unauthorized", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
public class Failure {

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/talabat/splash/core/exception/Failure$BadRequest;", "Lcom/talabat/splash/core/exception/Failure;", "()V", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class BadRequest extends Failure {
        @NotNull
        public static final BadRequest INSTANCE = new BadRequest();

        private BadRequest() {
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b&\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/talabat/splash/core/exception/Failure$FeatureFailure;", "Lcom/talabat/splash/core/exception/Failure;", "()V", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static abstract class FeatureFailure extends Failure {
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/talabat/splash/core/exception/Failure$Forbidden;", "Lcom/talabat/splash/core/exception/Failure;", "()V", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Forbidden extends Failure {
        @NotNull
        public static final Forbidden INSTANCE = new Forbidden();

        private Forbidden() {
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/talabat/splash/core/exception/Failure$InternalServerError;", "Lcom/talabat/splash/core/exception/Failure;", "()V", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class InternalServerError extends Failure {
        @NotNull
        public static final InternalServerError INSTANCE = new InternalServerError();

        private InternalServerError() {
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/talabat/splash/core/exception/Failure$NetworkConnection;", "Lcom/talabat/splash/core/exception/Failure;", "()V", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class NetworkConnection extends Failure {
        @NotNull
        public static final NetworkConnection INSTANCE = new NetworkConnection();

        private NetworkConnection() {
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/talabat/splash/core/exception/Failure$NotFound;", "Lcom/talabat/splash/core/exception/Failure;", "()V", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class NotFound extends Failure {
        @NotNull
        public static final NotFound INSTANCE = new NotFound();

        private NotFound() {
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/talabat/splash/core/exception/Failure$ServerError;", "Lcom/talabat/splash/core/exception/Failure;", "()V", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class ServerError extends Failure {
        @NotNull
        public static final ServerError INSTANCE = new ServerError();

        private ServerError() {
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/talabat/splash/core/exception/Failure$TimeOutError;", "Lcom/talabat/splash/core/exception/Failure;", "()V", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class TimeOutError extends Failure {
        @NotNull
        public static final TimeOutError INSTANCE = new TimeOutError();

        private TimeOutError() {
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/talabat/splash/core/exception/Failure$UnKnownError;", "Lcom/talabat/splash/core/exception/Failure;", "()V", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class UnKnownError extends Failure {
        @NotNull
        public static final UnKnownError INSTANCE = new UnKnownError();

        private UnKnownError() {
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/talabat/splash/core/exception/Failure$Unauthorized;", "Lcom/talabat/splash/core/exception/Failure;", "()V", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Unauthorized extends Failure {
        @NotNull
        public static final Unauthorized INSTANCE = new Unauthorized();

        private Unauthorized() {
        }
    }
}
