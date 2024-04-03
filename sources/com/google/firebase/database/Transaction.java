package com.google.firebase.database;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import com.google.firebase.database.snapshot.Node;

public class Transaction {

    public interface Handler {
        @NonNull
        Result doTransaction(@NonNull MutableData mutableData);

        void onComplete(@Nullable DatabaseError databaseError, boolean z11, @Nullable DataSnapshot dataSnapshot);
    }

    public static class Result {
        private Node data;
        private boolean success;

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public Node getNode() {
            return this.data;
        }

        public boolean isSuccess() {
            return this.success;
        }

        private Result(boolean z11, Node node) {
            this.success = z11;
            this.data = node;
        }
    }

    @NonNull
    public static Result abort() {
        return new Result(false, (Node) null);
    }

    @NonNull
    public static Result success(@NonNull MutableData mutableData) {
        return new Result(true, mutableData.getNode());
    }
}
