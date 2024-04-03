package androidx.emoji2.text;

import android.text.Editable;
import android.text.Selection;
import android.text.Spannable;
import android.text.method.MetaKeyKeyListener;
import android.view.KeyEvent;
import android.view.inputmethod.InputConnection;
import androidx.annotation.AnyThread;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.emoji2.text.EmojiCompat;
import androidx.emoji2.text.MetadataRepo;
import java.util.Arrays;

@RequiresApi(19)
@AnyThread
@RestrictTo({RestrictTo.Scope.LIBRARY})
final class EmojiProcessor {
    private static final int ACTION_ADVANCE_BOTH = 1;
    private static final int ACTION_ADVANCE_END = 2;
    private static final int ACTION_FLUSH = 3;
    @Nullable
    private final int[] mEmojiAsDefaultStyleExceptions;
    @NonNull
    private EmojiCompat.GlyphChecker mGlyphChecker;
    @NonNull
    private final MetadataRepo mMetadataRepo;
    @NonNull
    private final EmojiCompat.SpanFactory mSpanFactory;
    private final boolean mUseEmojiAsDefaultStyle;

    @RequiresApi(19)
    public static final class CodepointIndexFinder {
        private static final int INVALID_INDEX = -1;

        private CodepointIndexFinder() {
        }

        public static int a(CharSequence charSequence, int i11, int i12) {
            int length = charSequence.length();
            if (i11 < 0 || length < i11 || i12 < 0) {
                return -1;
            }
            while (true) {
                boolean z11 = false;
                while (i12 != 0) {
                    i11--;
                    if (i11 >= 0) {
                        char charAt = charSequence.charAt(i11);
                        if (z11) {
                            if (!Character.isHighSurrogate(charAt)) {
                                return -1;
                            }
                            i12--;
                        } else if (!Character.isSurrogate(charAt)) {
                            i12--;
                        } else if (Character.isHighSurrogate(charAt)) {
                            return -1;
                        } else {
                            z11 = true;
                        }
                    } else if (z11) {
                        return -1;
                    } else {
                        return 0;
                    }
                }
                return i11;
            }
        }

        public static int b(CharSequence charSequence, int i11, int i12) {
            int length = charSequence.length();
            if (i11 < 0 || length < i11 || i12 < 0) {
                return -1;
            }
            while (true) {
                boolean z11 = false;
                while (i12 != 0) {
                    if (r7 < length) {
                        char charAt = charSequence.charAt(r7);
                        if (z11) {
                            if (!Character.isLowSurrogate(charAt)) {
                                return -1;
                            }
                            i12--;
                            i11 = r7 + 1;
                        } else if (!Character.isSurrogate(charAt)) {
                            i12--;
                            r7++;
                        } else if (Character.isLowSurrogate(charAt)) {
                            return -1;
                        } else {
                            r7++;
                            z11 = true;
                        }
                    } else if (z11) {
                        return -1;
                    } else {
                        return length;
                    }
                }
                return r7;
            }
        }
    }

    public static final class ProcessorSm {
        private static final int STATE_DEFAULT = 1;
        private static final int STATE_WALKING = 2;
        private int mCurrentDepth;
        private MetadataRepo.Node mCurrentNode;
        private final int[] mEmojiAsDefaultStyleExceptions;
        private MetadataRepo.Node mFlushNode;
        private int mLastCodepoint;
        private final MetadataRepo.Node mRootNode;
        private int mState = 1;
        private final boolean mUseEmojiAsDefaultStyle;

        public ProcessorSm(MetadataRepo.Node node, boolean z11, int[] iArr) {
            this.mRootNode = node;
            this.mCurrentNode = node;
            this.mUseEmojiAsDefaultStyle = z11;
            this.mEmojiAsDefaultStyleExceptions = iArr;
        }

        private static boolean isEmojiStyle(int i11) {
            return i11 == 65039;
        }

        private static boolean isTextStyle(int i11) {
            return i11 == 65038;
        }

        private int reset() {
            this.mState = 1;
            this.mCurrentNode = this.mRootNode;
            this.mCurrentDepth = 0;
            return 1;
        }

        private boolean shouldUseEmojiPresentationStyleForSingleCodepoint() {
            if (this.mCurrentNode.b().isDefaultEmoji() || isEmojiStyle(this.mLastCodepoint)) {
                return true;
            }
            if (this.mUseEmojiAsDefaultStyle) {
                if (this.mEmojiAsDefaultStyleExceptions == null) {
                    return true;
                }
                if (Arrays.binarySearch(this.mEmojiAsDefaultStyleExceptions, this.mCurrentNode.b().getCodepointAt(0)) < 0) {
                    return true;
                }
            }
            return false;
        }

        public int a(int i11) {
            MetadataRepo.Node a11 = this.mCurrentNode.a(i11);
            int i12 = 2;
            if (this.mState != 2) {
                if (a11 == null) {
                    i12 = reset();
                } else {
                    this.mState = 2;
                    this.mCurrentNode = a11;
                    this.mCurrentDepth = 1;
                }
            } else if (a11 != null) {
                this.mCurrentNode = a11;
                this.mCurrentDepth++;
            } else if (isTextStyle(i11)) {
                i12 = reset();
            } else if (!isEmojiStyle(i11)) {
                if (this.mCurrentNode.b() != null) {
                    i12 = 3;
                    if (this.mCurrentDepth != 1) {
                        this.mFlushNode = this.mCurrentNode;
                        reset();
                    } else if (shouldUseEmojiPresentationStyleForSingleCodepoint()) {
                        this.mFlushNode = this.mCurrentNode;
                        reset();
                    } else {
                        i12 = reset();
                    }
                } else {
                    i12 = reset();
                }
            }
            this.mLastCodepoint = i11;
            return i12;
        }

        public EmojiMetadata b() {
            return this.mCurrentNode.b();
        }

        public EmojiMetadata c() {
            return this.mFlushNode.b();
        }

        public boolean d() {
            if (this.mState != 2 || this.mCurrentNode.b() == null || (this.mCurrentDepth <= 1 && !shouldUseEmojiPresentationStyleForSingleCodepoint())) {
                return false;
            }
            return true;
        }
    }

    public EmojiProcessor(@NonNull MetadataRepo metadataRepo, @NonNull EmojiCompat.SpanFactory spanFactory, @NonNull EmojiCompat.GlyphChecker glyphChecker, boolean z11, @Nullable int[] iArr) {
        this.mSpanFactory = spanFactory;
        this.mMetadataRepo = metadataRepo;
        this.mGlyphChecker = glyphChecker;
        this.mUseEmojiAsDefaultStyle = z11;
        this.mEmojiAsDefaultStyleExceptions = iArr;
    }

    private void addEmoji(@NonNull Spannable spannable, EmojiMetadata emojiMetadata, int i11, int i12) {
        spannable.setSpan(this.mSpanFactory.a(emojiMetadata), i11, i12, 33);
    }

    public static boolean c(@NonNull InputConnection inputConnection, @NonNull Editable editable, @IntRange(from = 0) int i11, @IntRange(from = 0) int i12, boolean z11) {
        int i13;
        int i14;
        if (editable != null && inputConnection != null && i11 >= 0 && i12 >= 0) {
            int selectionStart = Selection.getSelectionStart(editable);
            int selectionEnd = Selection.getSelectionEnd(editable);
            if (hasInvalidSelection(selectionStart, selectionEnd)) {
                return false;
            }
            if (z11) {
                i14 = CodepointIndexFinder.a(editable, selectionStart, Math.max(i11, 0));
                i13 = CodepointIndexFinder.b(editable, selectionEnd, Math.max(i12, 0));
                if (i14 == -1 || i13 == -1) {
                    return false;
                }
            } else {
                i14 = Math.max(selectionStart - i11, 0);
                i13 = Math.min(selectionEnd + i12, editable.length());
            }
            EmojiSpan[] emojiSpanArr = (EmojiSpan[]) editable.getSpans(i14, i13, EmojiSpan.class);
            if (emojiSpanArr != null && emojiSpanArr.length > 0) {
                for (EmojiSpan emojiSpan : emojiSpanArr) {
                    int spanStart = editable.getSpanStart(emojiSpan);
                    int spanEnd = editable.getSpanEnd(emojiSpan);
                    i14 = Math.min(spanStart, i14);
                    i13 = Math.max(spanEnd, i13);
                }
                int max = Math.max(i14, 0);
                int min = Math.min(i13, editable.length());
                inputConnection.beginBatchEdit();
                editable.delete(max, min);
                inputConnection.endBatchEdit();
                return true;
            }
        }
        return false;
    }

    public static boolean d(@NonNull Editable editable, int i11, @NonNull KeyEvent keyEvent) {
        boolean z11;
        if (i11 == 67) {
            z11 = delete(editable, keyEvent, false);
        } else if (i11 != 112) {
            z11 = false;
        } else {
            z11 = delete(editable, keyEvent, true);
        }
        if (!z11) {
            return false;
        }
        MetaKeyKeyListener.adjustMetaAfterKeypress(editable);
        return true;
    }

    private static boolean delete(@NonNull Editable editable, @NonNull KeyEvent keyEvent, boolean z11) {
        EmojiSpan[] emojiSpanArr;
        if (hasModifiers(keyEvent)) {
            return false;
        }
        int selectionStart = Selection.getSelectionStart(editable);
        int selectionEnd = Selection.getSelectionEnd(editable);
        if (!hasInvalidSelection(selectionStart, selectionEnd) && (emojiSpanArr = (EmojiSpan[]) editable.getSpans(selectionStart, selectionEnd, EmojiSpan.class)) != null && emojiSpanArr.length > 0) {
            int length = emojiSpanArr.length;
            int i11 = 0;
            while (i11 < length) {
                EmojiSpan emojiSpan = emojiSpanArr[i11];
                int spanStart = editable.getSpanStart(emojiSpan);
                int spanEnd = editable.getSpanEnd(emojiSpan);
                if ((!z11 || spanStart != selectionStart) && ((z11 || spanEnd != selectionStart) && (selectionStart <= spanStart || selectionStart >= spanEnd))) {
                    i11++;
                } else {
                    editable.delete(spanStart, spanEnd);
                    return true;
                }
            }
        }
        return false;
    }

    private boolean hasGlyph(CharSequence charSequence, int i11, int i12, EmojiMetadata emojiMetadata) {
        if (emojiMetadata.getHasGlyph() == 0) {
            emojiMetadata.setHasGlyph(this.mGlyphChecker.hasGlyph(charSequence, i11, i12, emojiMetadata.getSdkAdded()));
        }
        if (emojiMetadata.getHasGlyph() == 2) {
            return true;
        }
        return false;
    }

    private static boolean hasInvalidSelection(int i11, int i12) {
        return i11 == -1 || i12 == -1 || i11 != i12;
    }

    private static boolean hasModifiers(@NonNull KeyEvent keyEvent) {
        return !KeyEvent.metaStateHasNoModifiers(keyEvent.getMetaState());
    }

    public int a(@NonNull CharSequence charSequence) {
        return b(charSequence, this.mMetadataRepo.a());
    }

    public int b(@NonNull CharSequence charSequence, int i11) {
        ProcessorSm processorSm = new ProcessorSm(this.mMetadataRepo.b(), this.mUseEmojiAsDefaultStyle, this.mEmojiAsDefaultStyleExceptions);
        int length = charSequence.length();
        int i12 = 0;
        int i13 = 0;
        int i14 = 0;
        while (i12 < length) {
            int codePointAt = Character.codePointAt(charSequence, i12);
            int a11 = processorSm.a(codePointAt);
            EmojiMetadata b11 = processorSm.b();
            if (a11 == 1) {
                i12 += Character.charCount(codePointAt);
                i14 = 0;
            } else if (a11 == 2) {
                i12 += Character.charCount(codePointAt);
            } else if (a11 == 3) {
                b11 = processorSm.c();
                if (b11.getCompatAdded() <= i11) {
                    i13++;
                }
            }
            if (b11 != null && b11.getCompatAdded() <= i11) {
                i14++;
            }
        }
        if (i13 != 0) {
            return 2;
        }
        if (processorSm.d() && processorSm.b().getCompatAdded() <= i11) {
            return 1;
        }
        if (i14 == 0) {
            return 0;
        }
        return 2;
    }

    /* JADX WARNING: Removed duplicated region for block: B:24:0x0046 A[Catch:{ all -> 0x0129 }] */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x0062 A[Catch:{ all -> 0x0129 }] */
    /* JADX WARNING: Removed duplicated region for block: B:78:0x0122  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.CharSequence e(@androidx.annotation.NonNull java.lang.CharSequence r11, @androidx.annotation.IntRange(from = 0) int r12, @androidx.annotation.IntRange(from = 0) int r13, @androidx.annotation.IntRange(from = 0) int r14, boolean r15) {
        /*
            r10 = this;
            boolean r0 = r11 instanceof androidx.emoji2.text.SpannableBuilder
            if (r0 == 0) goto L_0x000a
            r1 = r11
            androidx.emoji2.text.SpannableBuilder r1 = (androidx.emoji2.text.SpannableBuilder) r1
            r1.beginBatchEdit()
        L_0x000a:
            java.lang.Class<androidx.emoji2.text.EmojiSpan> r1 = androidx.emoji2.text.EmojiSpan.class
            if (r0 != 0) goto L_0x002c
            boolean r2 = r11 instanceof android.text.Spannable     // Catch:{ all -> 0x0129 }
            if (r2 == 0) goto L_0x0013
            goto L_0x002c
        L_0x0013:
            boolean r2 = r11 instanceof android.text.Spanned     // Catch:{ all -> 0x0129 }
            if (r2 == 0) goto L_0x002a
            r2 = r11
            android.text.Spanned r2 = (android.text.Spanned) r2     // Catch:{ all -> 0x0129 }
            int r3 = r12 + -1
            int r4 = r13 + 1
            int r2 = r2.nextSpanTransition(r3, r4, r1)     // Catch:{ all -> 0x0129 }
            if (r2 > r13) goto L_0x002a
            androidx.emoji2.text.UnprecomputeTextOnModificationSpannable r2 = new androidx.emoji2.text.UnprecomputeTextOnModificationSpannable     // Catch:{ all -> 0x0129 }
            r2.<init>((java.lang.CharSequence) r11)     // Catch:{ all -> 0x0129 }
            goto L_0x0034
        L_0x002a:
            r2 = 0
            goto L_0x0034
        L_0x002c:
            androidx.emoji2.text.UnprecomputeTextOnModificationSpannable r2 = new androidx.emoji2.text.UnprecomputeTextOnModificationSpannable     // Catch:{ all -> 0x0129 }
            r3 = r11
            android.text.Spannable r3 = (android.text.Spannable) r3     // Catch:{ all -> 0x0129 }
            r2.<init>((android.text.Spannable) r3)     // Catch:{ all -> 0x0129 }
        L_0x0034:
            r3 = 0
            if (r2 == 0) goto L_0x0060
            java.lang.Object[] r4 = r2.getSpans(r12, r13, r1)     // Catch:{ all -> 0x0129 }
            androidx.emoji2.text.EmojiSpan[] r4 = (androidx.emoji2.text.EmojiSpan[]) r4     // Catch:{ all -> 0x0129 }
            if (r4 == 0) goto L_0x0060
            int r5 = r4.length     // Catch:{ all -> 0x0129 }
            if (r5 <= 0) goto L_0x0060
            int r5 = r4.length     // Catch:{ all -> 0x0129 }
            r6 = r3
        L_0x0044:
            if (r6 >= r5) goto L_0x0060
            r7 = r4[r6]     // Catch:{ all -> 0x0129 }
            int r8 = r2.getSpanStart(r7)     // Catch:{ all -> 0x0129 }
            int r9 = r2.getSpanEnd(r7)     // Catch:{ all -> 0x0129 }
            if (r8 == r13) goto L_0x0055
            r2.removeSpan(r7)     // Catch:{ all -> 0x0129 }
        L_0x0055:
            int r12 = java.lang.Math.min(r8, r12)     // Catch:{ all -> 0x0129 }
            int r13 = java.lang.Math.max(r9, r13)     // Catch:{ all -> 0x0129 }
            int r6 = r6 + 1
            goto L_0x0044
        L_0x0060:
            if (r12 == r13) goto L_0x0120
            int r4 = r11.length()     // Catch:{ all -> 0x0129 }
            if (r12 < r4) goto L_0x006a
            goto L_0x0120
        L_0x006a:
            r4 = 2147483647(0x7fffffff, float:NaN)
            if (r14 == r4) goto L_0x007d
            if (r2 == 0) goto L_0x007d
            int r4 = r2.length()     // Catch:{ all -> 0x0129 }
            java.lang.Object[] r1 = r2.getSpans(r3, r4, r1)     // Catch:{ all -> 0x0129 }
            androidx.emoji2.text.EmojiSpan[] r1 = (androidx.emoji2.text.EmojiSpan[]) r1     // Catch:{ all -> 0x0129 }
            int r1 = r1.length     // Catch:{ all -> 0x0129 }
            int r14 = r14 - r1
        L_0x007d:
            androidx.emoji2.text.EmojiProcessor$ProcessorSm r1 = new androidx.emoji2.text.EmojiProcessor$ProcessorSm     // Catch:{ all -> 0x0129 }
            androidx.emoji2.text.MetadataRepo r4 = r10.mMetadataRepo     // Catch:{ all -> 0x0129 }
            androidx.emoji2.text.MetadataRepo$Node r4 = r4.b()     // Catch:{ all -> 0x0129 }
            boolean r5 = r10.mUseEmojiAsDefaultStyle     // Catch:{ all -> 0x0129 }
            int[] r6 = r10.mEmojiAsDefaultStyleExceptions     // Catch:{ all -> 0x0129 }
            r1.<init>(r4, r5, r6)     // Catch:{ all -> 0x0129 }
            int r4 = java.lang.Character.codePointAt(r11, r12)     // Catch:{ all -> 0x0129 }
            r5 = r4
            r4 = r3
            r3 = r2
        L_0x0093:
            r2 = r12
        L_0x0094:
            if (r12 >= r13) goto L_0x00e6
            if (r4 >= r14) goto L_0x00e6
            int r6 = r1.a(r5)     // Catch:{ all -> 0x0129 }
            r7 = 1
            if (r6 == r7) goto L_0x00d4
            r7 = 2
            if (r6 == r7) goto L_0x00c8
            r7 = 3
            if (r6 == r7) goto L_0x00a6
            goto L_0x0094
        L_0x00a6:
            if (r15 != 0) goto L_0x00b2
            androidx.emoji2.text.EmojiMetadata r6 = r1.c()     // Catch:{ all -> 0x0129 }
            boolean r6 = r10.hasGlyph(r11, r2, r12, r6)     // Catch:{ all -> 0x0129 }
            if (r6 != 0) goto L_0x0093
        L_0x00b2:
            if (r3 != 0) goto L_0x00be
            androidx.emoji2.text.UnprecomputeTextOnModificationSpannable r3 = new androidx.emoji2.text.UnprecomputeTextOnModificationSpannable     // Catch:{ all -> 0x0129 }
            android.text.SpannableString r6 = new android.text.SpannableString     // Catch:{ all -> 0x0129 }
            r6.<init>(r11)     // Catch:{ all -> 0x0129 }
            r3.<init>((android.text.Spannable) r6)     // Catch:{ all -> 0x0129 }
        L_0x00be:
            androidx.emoji2.text.EmojiMetadata r6 = r1.c()     // Catch:{ all -> 0x0129 }
            r10.addEmoji(r3, r6, r2, r12)     // Catch:{ all -> 0x0129 }
            int r4 = r4 + 1
            goto L_0x0093
        L_0x00c8:
            int r6 = java.lang.Character.charCount(r5)     // Catch:{ all -> 0x0129 }
            int r12 = r12 + r6
            if (r12 >= r13) goto L_0x0094
            int r5 = java.lang.Character.codePointAt(r11, r12)     // Catch:{ all -> 0x0129 }
            goto L_0x0094
        L_0x00d4:
            int r12 = java.lang.Character.codePointAt(r11, r2)     // Catch:{ all -> 0x0129 }
            int r12 = java.lang.Character.charCount(r12)     // Catch:{ all -> 0x0129 }
            int r2 = r2 + r12
            if (r2 >= r13) goto L_0x00e4
            int r12 = java.lang.Character.codePointAt(r11, r2)     // Catch:{ all -> 0x0129 }
            r5 = r12
        L_0x00e4:
            r12 = r2
            goto L_0x0094
        L_0x00e6:
            boolean r13 = r1.d()     // Catch:{ all -> 0x0129 }
            if (r13 == 0) goto L_0x0109
            if (r4 >= r14) goto L_0x0109
            if (r15 != 0) goto L_0x00fa
            androidx.emoji2.text.EmojiMetadata r13 = r1.b()     // Catch:{ all -> 0x0129 }
            boolean r13 = r10.hasGlyph(r11, r2, r12, r13)     // Catch:{ all -> 0x0129 }
            if (r13 != 0) goto L_0x0109
        L_0x00fa:
            if (r3 != 0) goto L_0x0102
            androidx.emoji2.text.UnprecomputeTextOnModificationSpannable r13 = new androidx.emoji2.text.UnprecomputeTextOnModificationSpannable     // Catch:{ all -> 0x0129 }
            r13.<init>((java.lang.CharSequence) r11)     // Catch:{ all -> 0x0129 }
            r3 = r13
        L_0x0102:
            androidx.emoji2.text.EmojiMetadata r13 = r1.b()     // Catch:{ all -> 0x0129 }
            r10.addEmoji(r3, r13, r2, r12)     // Catch:{ all -> 0x0129 }
        L_0x0109:
            if (r3 == 0) goto L_0x0117
            android.text.Spannable r12 = r3.a()     // Catch:{ all -> 0x0129 }
            if (r0 == 0) goto L_0x0116
            androidx.emoji2.text.SpannableBuilder r11 = (androidx.emoji2.text.SpannableBuilder) r11
            r11.endBatchEdit()
        L_0x0116:
            return r12
        L_0x0117:
            if (r0 == 0) goto L_0x011f
            r12 = r11
            androidx.emoji2.text.SpannableBuilder r12 = (androidx.emoji2.text.SpannableBuilder) r12
            r12.endBatchEdit()
        L_0x011f:
            return r11
        L_0x0120:
            if (r0 == 0) goto L_0x0128
            r12 = r11
            androidx.emoji2.text.SpannableBuilder r12 = (androidx.emoji2.text.SpannableBuilder) r12
            r12.endBatchEdit()
        L_0x0128:
            return r11
        L_0x0129:
            r12 = move-exception
            if (r0 == 0) goto L_0x0131
            androidx.emoji2.text.SpannableBuilder r11 = (androidx.emoji2.text.SpannableBuilder) r11
            r11.endBatchEdit()
        L_0x0131:
            throw r12
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.emoji2.text.EmojiProcessor.e(java.lang.CharSequence, int, int, int, boolean):java.lang.CharSequence");
    }
}
