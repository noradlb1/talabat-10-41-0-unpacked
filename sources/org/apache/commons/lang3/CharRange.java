package org.apache.commons.lang3;

import j$.util.Iterator;
import j$.util.function.Consumer;
import java.io.Serializable;
import java.util.Iterator;
import java.util.NoSuchElementException;
import net.bytebuddy.jar.asm.signature.SignatureVisitor;

final class CharRange implements Iterable<Character>, Serializable {
    private static final long serialVersionUID = 8270183163158333422L;
    /* access modifiers changed from: private */
    public final char end;
    private transient String iToString;
    /* access modifiers changed from: private */
    public final boolean negated;
    /* access modifiers changed from: private */
    public final char start;

    public static class CharacterIterator implements Iterator<Character>, j$.util.Iterator {
        private char current;
        private boolean hasNext;
        private final CharRange range;

        private void prepareNext() {
            if (this.range.negated) {
                char c11 = this.current;
                if (c11 == 65535) {
                    this.hasNext = false;
                } else if (c11 + 1 != this.range.start) {
                    this.current = (char) (this.current + 1);
                } else if (this.range.end == 65535) {
                    this.hasNext = false;
                } else {
                    this.current = (char) (this.range.end + 1);
                }
            } else if (this.current < this.range.end) {
                this.current = (char) (this.current + 1);
            } else {
                this.hasNext = false;
            }
        }

        public /* synthetic */ void forEachRemaining(Consumer consumer) {
            Iterator.CC.$default$forEachRemaining(this, consumer);
        }

        public /* synthetic */ void forEachRemaining(java.util.function.Consumer consumer) {
            forEachRemaining(Consumer.VivifiedWrapper.convert(consumer));
        }

        public boolean hasNext() {
            return this.hasNext;
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }

        private CharacterIterator(CharRange charRange) {
            this.range = charRange;
            this.hasNext = true;
            if (!charRange.negated) {
                this.current = charRange.start;
            } else if (charRange.start != 0) {
                this.current = 0;
            } else if (charRange.end == 65535) {
                this.hasNext = false;
            } else {
                this.current = (char) (charRange.end + 1);
            }
        }

        public Character next() {
            if (this.hasNext) {
                char c11 = this.current;
                prepareNext();
                return Character.valueOf(c11);
            }
            throw new NoSuchElementException();
        }
    }

    private CharRange(char c11, char c12, boolean z11) {
        if (c11 > c12) {
            char c13 = c12;
            c12 = c11;
            c11 = c13;
        }
        this.start = c11;
        this.end = c12;
        this.negated = z11;
    }

    public static CharRange is(char c11) {
        return new CharRange(c11, c11, false);
    }

    public static CharRange isIn(char c11, char c12) {
        return new CharRange(c11, c12, false);
    }

    public static CharRange isNot(char c11) {
        return new CharRange(c11, c11, true);
    }

    public static CharRange isNotIn(char c11, char c12) {
        return new CharRange(c11, c12, true);
    }

    public boolean contains(char c11) {
        return (c11 >= this.start && c11 <= this.end) != this.negated;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CharRange)) {
            return false;
        }
        CharRange charRange = (CharRange) obj;
        if (this.start == charRange.start && this.end == charRange.end && this.negated == charRange.negated) {
            return true;
        }
        return false;
    }

    public char getEnd() {
        return this.end;
    }

    public char getStart() {
        return this.start;
    }

    public int hashCode() {
        return this.start + 'S' + (this.end * 7) + (this.negated ? 1 : 0);
    }

    public boolean isNegated() {
        return this.negated;
    }

    public java.util.Iterator<Character> iterator() {
        return new CharacterIterator();
    }

    public String toString() {
        if (this.iToString == null) {
            StringBuilder sb2 = new StringBuilder(4);
            if (isNegated()) {
                sb2.append('^');
            }
            sb2.append(this.start);
            if (this.start != this.end) {
                sb2.append(SignatureVisitor.SUPER);
                sb2.append(this.end);
            }
            this.iToString = sb2.toString();
        }
        return this.iToString;
    }

    public boolean contains(CharRange charRange) {
        if (charRange == null) {
            throw new IllegalArgumentException("The Range must not be null");
        } else if (this.negated) {
            if (charRange.negated) {
                if (this.start < charRange.start || this.end > charRange.end) {
                    return false;
                }
                return true;
            } else if (charRange.end < this.start || charRange.start > this.end) {
                return true;
            } else {
                return false;
            }
        } else if (charRange.negated) {
            if (this.start == 0 && this.end == 65535) {
                return true;
            }
            return false;
        } else if (this.start > charRange.start || this.end < charRange.end) {
            return false;
        } else {
            return true;
        }
    }
}
