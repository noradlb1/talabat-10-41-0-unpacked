package org.junit.experimental.theories;

public abstract class PotentialAssignment {

    public static class CouldNotGenerateValueException extends Exception {
        private static final long serialVersionUID = 1;

        public CouldNotGenerateValueException() {
        }

        public CouldNotGenerateValueException(Throwable th2) {
            super(th2);
        }
    }

    public static PotentialAssignment forValue(final String str, final Object obj) {
        return new PotentialAssignment() {
            public String getDescription() {
                String str;
                Object obj = obj;
                if (obj == null) {
                    str = "null";
                } else {
                    try {
                        str = String.format("\"%s\"", new Object[]{obj});
                    } catch (Throwable th2) {
                        str = String.format("[toString() threw %s: %s]", new Object[]{th2.getClass().getSimpleName(), th2.getMessage()});
                    }
                }
                return String.format("%s <from %s>", new Object[]{str, str});
            }

            public Object getValue() {
                return obj;
            }

            public String toString() {
                return String.format("[%s]", new Object[]{obj});
            }
        };
    }

    public abstract String getDescription() throws CouldNotGenerateValueException;

    public abstract Object getValue() throws CouldNotGenerateValueException;
}
