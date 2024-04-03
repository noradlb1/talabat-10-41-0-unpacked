package com.huawei.location.lite.common.chain;

import androidx.annotation.NonNull;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

public abstract class Result {

    public static final class Failure extends Result {
        private final Data mOutputData;

        public Failure() {
            this(Data.EMPTY);
        }

        public Failure(@NonNull Data data) {
            this.mOutputData = data;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || Failure.class != obj.getClass() || !(obj instanceof Failure)) {
                return false;
            }
            return this.mOutputData.equals(((Failure) obj).mOutputData);
        }

        @NonNull
        public Data getOutputData() {
            return this.mOutputData;
        }

        public int hashCode() {
            return this.mOutputData.hashCode() - 1087636498;
        }

        public String toString() {
            return "Failure {mOutputData=" + this.mOutputData + AbstractJsonLexerKt.END_OBJ;
        }
    }

    public static final class Retry extends Result {
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return obj != null && Retry.class == obj.getClass();
        }

        public int hashCode() {
            return 429412720;
        }

        public String toString() {
            return "Retry";
        }
    }

    public static final class Success extends Result {
        private final Data mOutputData;

        public Success() {
            this(Data.EMPTY);
        }

        public Success(@NonNull Data data) {
            this.mOutputData = data;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || Success.class != obj.getClass() || !(obj instanceof Success)) {
                return false;
            }
            return this.mOutputData.equals(((Success) obj).mOutputData);
        }

        @NonNull
        public Data getOutputData() {
            return this.mOutputData;
        }

        public int hashCode() {
            return this.mOutputData.hashCode() + 483703957;
        }

        public String toString() {
            return "Success {mOutputData=" + this.mOutputData + AbstractJsonLexerKt.END_OBJ;
        }
    }

    @NonNull
    public static Result failure() {
        return new Failure();
    }

    @NonNull
    public static Result failure(@NonNull Data data) {
        return new Failure(data);
    }

    @NonNull
    public static Result retry() {
        return new Retry();
    }

    @NonNull
    public static Result success() {
        return new Success();
    }

    @NonNull
    public static Result success(@NonNull Data data) {
        return new Success(data);
    }
}
