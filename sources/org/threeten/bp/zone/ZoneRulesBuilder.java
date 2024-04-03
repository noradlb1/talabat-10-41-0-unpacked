package org.threeten.bp.zone;

import com.huawei.hms.push.constant.RemoteMessageConst;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.threeten.bp.DayOfWeek;
import org.threeten.bp.LocalDate;
import org.threeten.bp.LocalDateTime;
import org.threeten.bp.LocalTime;
import org.threeten.bp.Month;
import org.threeten.bp.Year;
import org.threeten.bp.ZoneOffset;
import org.threeten.bp.chrono.ChronoLocalDate;
import org.threeten.bp.chrono.IsoChronology;
import org.threeten.bp.jdk8.Jdk8Methods;
import org.threeten.bp.temporal.ChronoField;
import org.threeten.bp.temporal.TemporalAdjusters;
import org.threeten.bp.zone.ZoneOffsetTransitionRule;

class ZoneRulesBuilder {
    private Map<Object, Object> deduplicateMap;
    private List<TZWindow> windowList = new ArrayList();

    public class TZRule implements Comparable<TZRule> {
        /* access modifiers changed from: private */
        public int adjustDays;
        /* access modifiers changed from: private */
        public int dayOfMonthIndicator;
        /* access modifiers changed from: private */
        public DayOfWeek dayOfWeek;
        /* access modifiers changed from: private */
        public Month month;
        /* access modifiers changed from: private */
        public int savingAmountSecs;
        /* access modifiers changed from: private */
        public LocalTime time;
        /* access modifiers changed from: private */
        public ZoneOffsetTransitionRule.TimeDefinition timeDefinition;
        /* access modifiers changed from: private */
        public int year;

        public TZRule(int i11, Month month2, int i12, DayOfWeek dayOfWeek2, LocalTime localTime, int i13, ZoneOffsetTransitionRule.TimeDefinition timeDefinition2, int i14) {
            this.year = i11;
            this.month = month2;
            this.dayOfMonthIndicator = i12;
            this.dayOfWeek = dayOfWeek2;
            this.time = localTime;
            this.adjustDays = i13;
            this.timeDefinition = timeDefinition2;
            this.savingAmountSecs = i14;
        }

        private LocalDate toLocalDate() {
            int i11 = this.dayOfMonthIndicator;
            if (i11 < 0) {
                LocalDate of2 = LocalDate.of(this.year, this.month, this.month.length(IsoChronology.INSTANCE.isLeapYear((long) this.year)) + 1 + this.dayOfMonthIndicator);
                DayOfWeek dayOfWeek2 = this.dayOfWeek;
                if (dayOfWeek2 != null) {
                    return of2.with(TemporalAdjusters.previousOrSame(dayOfWeek2));
                }
                return of2;
            }
            LocalDate of3 = LocalDate.of(this.year, this.month, i11);
            DayOfWeek dayOfWeek3 = this.dayOfWeek;
            if (dayOfWeek3 != null) {
                return of3.with(TemporalAdjusters.nextOrSame(dayOfWeek3));
            }
            return of3;
        }

        public ZoneOffsetTransition j(ZoneOffset zoneOffset, int i11) {
            LocalDate localDate = toLocalDate();
            ZoneOffset zoneOffset2 = (ZoneOffset) ZoneRulesBuilder.this.a(ZoneOffset.ofTotalSeconds(zoneOffset.getTotalSeconds() + i11));
            return new ZoneOffsetTransition((LocalDateTime) ZoneRulesBuilder.this.a(this.timeDefinition.createDateTime((LocalDateTime) ZoneRulesBuilder.this.a(LocalDateTime.of(((LocalDate) ZoneRulesBuilder.this.a(localDate)).plusDays((long) this.adjustDays), this.time)), zoneOffset, zoneOffset2)), zoneOffset2, (ZoneOffset) ZoneRulesBuilder.this.a(ZoneOffset.ofTotalSeconds(zoneOffset.getTotalSeconds() + this.savingAmountSecs)));
        }

        public ZoneOffsetTransitionRule k(ZoneOffset zoneOffset, int i11) {
            Month month2;
            if (this.dayOfMonthIndicator < 0 && (month2 = this.month) != Month.FEBRUARY) {
                this.dayOfMonthIndicator = month2.maxLength() - 6;
            }
            ZoneOffsetTransition j11 = j(zoneOffset, i11);
            return new ZoneOffsetTransitionRule(this.month, this.dayOfMonthIndicator, this.dayOfWeek, this.time, this.adjustDays, this.timeDefinition, zoneOffset, j11.getOffsetBefore(), j11.getOffsetAfter());
        }

        public int compareTo(TZRule tZRule) {
            int i11 = this.year - tZRule.year;
            if (i11 == 0) {
                i11 = this.month.compareTo(tZRule.month);
            }
            if (i11 == 0) {
                i11 = toLocalDate().compareTo((ChronoLocalDate) tZRule.toLocalDate());
            }
            if (i11 != 0) {
                return i11;
            }
            int i12 = (((long) (this.time.toSecondOfDay() + (this.adjustDays * RemoteMessageConst.DEFAULT_TTL))) > ((long) (tZRule.time.toSecondOfDay() + (tZRule.adjustDays * RemoteMessageConst.DEFAULT_TTL))) ? 1 : (((long) (this.time.toSecondOfDay() + (this.adjustDays * RemoteMessageConst.DEFAULT_TTL))) == ((long) (tZRule.time.toSecondOfDay() + (tZRule.adjustDays * RemoteMessageConst.DEFAULT_TTL))) ? 0 : -1));
            if (i12 < 0) {
                return -1;
            }
            return i12 > 0 ? 1 : 0;
        }
    }

    public class TZWindow {
        /* access modifiers changed from: private */
        public Integer fixedSavingAmountSecs;
        /* access modifiers changed from: private */
        public List<TZRule> lastRuleList = new ArrayList();
        private int maxLastRuleStartYear = Year.MIN_VALUE;
        /* access modifiers changed from: private */
        public List<TZRule> ruleList = new ArrayList();
        /* access modifiers changed from: private */
        public final ZoneOffset standardOffset;
        private final ZoneOffsetTransitionRule.TimeDefinition timeDefinition;
        private final LocalDateTime windowEnd;

        public TZWindow(ZoneOffset zoneOffset, LocalDateTime localDateTime, ZoneOffsetTransitionRule.TimeDefinition timeDefinition2) {
            this.windowEnd = localDateTime;
            this.timeDefinition = timeDefinition2;
            this.standardOffset = zoneOffset;
        }

        public void e(int i11, int i12, Month month, int i13, DayOfWeek dayOfWeek, LocalTime localTime, int i14, ZoneOffsetTransitionRule.TimeDefinition timeDefinition2, int i15) {
            boolean z11;
            if (this.fixedSavingAmountSecs != null) {
                throw new IllegalStateException("Window has a fixed DST saving, so cannot have DST rules");
            } else if (this.ruleList.size() < 2000) {
                int i16 = i12;
                if (i16 == 999999999) {
                    z11 = true;
                    i16 = i11;
                } else {
                    z11 = false;
                }
                for (int i17 = i11; i17 <= i16; i17++) {
                    TZRule tZRule = new TZRule(i17, month, i13, dayOfWeek, localTime, i14, timeDefinition2, i15);
                    if (z11) {
                        this.lastRuleList.add(tZRule);
                        this.maxLastRuleStartYear = Math.max(i11, this.maxLastRuleStartYear);
                    } else {
                        int i18 = i11;
                        this.ruleList.add(tZRule);
                    }
                }
            } else {
                throw new IllegalStateException("Window has reached the maximum number of allowed rules");
            }
        }

        public long f(int i11) {
            ZoneOffset g11 = g(i11);
            return this.timeDefinition.createDateTime(this.windowEnd, this.standardOffset, g11).toEpochSecond(g11);
        }

        public ZoneOffset g(int i11) {
            return ZoneOffset.ofTotalSeconds(this.standardOffset.getTotalSeconds() + i11);
        }

        public void h(int i11) {
            if (this.ruleList.size() > 0 || this.lastRuleList.size() > 0) {
                throw new IllegalStateException("Window has DST rules, so cannot have fixed savings");
            }
            this.fixedSavingAmountSecs = Integer.valueOf(i11);
        }

        public void i(int i11) {
            if (this.lastRuleList.size() != 1) {
                if (this.windowEnd.equals(LocalDateTime.MAX)) {
                    this.maxLastRuleStartYear = Math.max(this.maxLastRuleStartYear, i11) + 1;
                    for (TZRule next : this.lastRuleList) {
                        e(next.year, this.maxLastRuleStartYear, next.month, next.dayOfMonthIndicator, next.dayOfWeek, next.time, next.adjustDays, next.timeDefinition, next.savingAmountSecs);
                        int unused = next.year = this.maxLastRuleStartYear + 1;
                    }
                    int i12 = this.maxLastRuleStartYear;
                    if (i12 == 999999999) {
                        this.lastRuleList.clear();
                    } else {
                        this.maxLastRuleStartYear = i12 + 1;
                    }
                } else {
                    int year = this.windowEnd.getYear();
                    for (TZRule next2 : this.lastRuleList) {
                        e(next2.year, year + 1, next2.month, next2.dayOfMonthIndicator, next2.dayOfWeek, next2.time, next2.adjustDays, next2.timeDefinition, next2.savingAmountSecs);
                    }
                    this.lastRuleList.clear();
                    this.maxLastRuleStartYear = Year.MAX_VALUE;
                }
                Collections.sort(this.ruleList);
                Collections.sort(this.lastRuleList);
                if (this.ruleList.size() == 0 && this.fixedSavingAmountSecs == null) {
                    this.fixedSavingAmountSecs = 0;
                    return;
                }
                return;
            }
            throw new IllegalStateException("Cannot have only one rule defined as being forever");
        }

        public void j(TZWindow tZWindow) {
            if (this.windowEnd.isBefore(tZWindow.windowEnd)) {
                throw new IllegalStateException("Windows must be added in date-time order: " + this.windowEnd + " < " + tZWindow.windowEnd);
            }
        }
    }

    public <T> T a(T t11) {
        if (!this.deduplicateMap.containsKey(t11)) {
            this.deduplicateMap.put(t11, t11);
        }
        return this.deduplicateMap.get(t11);
    }

    public ZoneRulesBuilder addRuleToWindow(LocalDateTime localDateTime, ZoneOffsetTransitionRule.TimeDefinition timeDefinition, int i11) {
        Jdk8Methods.requireNonNull(localDateTime, "transitionDateTime");
        return addRuleToWindow(localDateTime.getYear(), localDateTime.getYear(), localDateTime.getMonth(), localDateTime.getDayOfMonth(), (DayOfWeek) null, localDateTime.toLocalTime(), false, timeDefinition, i11);
    }

    public ZoneRulesBuilder addWindow(ZoneOffset zoneOffset, LocalDateTime localDateTime, ZoneOffsetTransitionRule.TimeDefinition timeDefinition) {
        Jdk8Methods.requireNonNull(zoneOffset, "standardOffset");
        Jdk8Methods.requireNonNull(localDateTime, "until");
        Jdk8Methods.requireNonNull(timeDefinition, "untilDefinition");
        TZWindow tZWindow = new TZWindow(zoneOffset, localDateTime, timeDefinition);
        if (this.windowList.size() > 0) {
            List<TZWindow> list = this.windowList;
            tZWindow.j(list.get(list.size() - 1));
        }
        this.windowList.add(tZWindow);
        return this;
    }

    public ZoneRulesBuilder addWindowForever(ZoneOffset zoneOffset) {
        return addWindow(zoneOffset, LocalDateTime.MAX, ZoneOffsetTransitionRule.TimeDefinition.WALL);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v9, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v2, resolved type: org.threeten.bp.ZoneOffset} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public org.threeten.bp.zone.ZoneRules b(java.lang.String r21, java.util.Map<java.lang.Object, java.lang.Object> r22) {
        /*
            r20 = this;
            r0 = r20
            java.lang.String r1 = "zoneId"
            r2 = r21
            org.threeten.bp.jdk8.Jdk8Methods.requireNonNull(r2, r1)
            r1 = r22
            r0.deduplicateMap = r1
            java.util.List<org.threeten.bp.zone.ZoneRulesBuilder$TZWindow> r1 = r0.windowList
            boolean r1 = r1.isEmpty()
            if (r1 != 0) goto L_0x01b7
            java.util.ArrayList r5 = new java.util.ArrayList
            r1 = 4
            r5.<init>(r1)
            java.util.ArrayList r6 = new java.util.ArrayList
            r1 = 256(0x100, float:3.59E-43)
            r6.<init>(r1)
            java.util.ArrayList r7 = new java.util.ArrayList
            r1 = 2
            r7.<init>(r1)
            java.util.List<org.threeten.bp.zone.ZoneRulesBuilder$TZWindow> r1 = r0.windowList
            r2 = 0
            java.lang.Object r1 = r1.get(r2)
            org.threeten.bp.zone.ZoneRulesBuilder$TZWindow r1 = (org.threeten.bp.zone.ZoneRulesBuilder.TZWindow) r1
            org.threeten.bp.ZoneOffset r3 = r1.standardOffset
            java.lang.Integer r4 = r1.fixedSavingAmountSecs
            if (r4 == 0) goto L_0x0044
            java.lang.Integer r4 = r1.fixedSavingAmountSecs
            int r4 = r4.intValue()
            goto L_0x0045
        L_0x0044:
            r4 = r2
        L_0x0045:
            int r8 = r3.getTotalSeconds()
            int r8 = r8 + r4
            org.threeten.bp.ZoneOffset r8 = org.threeten.bp.ZoneOffset.ofTotalSeconds(r8)
            java.lang.Object r8 = r0.a(r8)
            org.threeten.bp.ZoneOffset r8 = (org.threeten.bp.ZoneOffset) r8
            r9 = -999999999(0xffffffffc4653601, float:-916.8438)
            r10 = 1
            org.threeten.bp.LocalDateTime r9 = org.threeten.bp.LocalDateTime.of((int) r9, (int) r10, (int) r10, (int) r2, (int) r2)
            java.lang.Object r9 = r0.a(r9)
            org.threeten.bp.LocalDateTime r9 = (org.threeten.bp.LocalDateTime) r9
            java.util.List<org.threeten.bp.zone.ZoneRulesBuilder$TZWindow> r11 = r0.windowList
            java.util.Iterator r11 = r11.iterator()
            r12 = r8
        L_0x0069:
            boolean r13 = r11.hasNext()
            if (r13 == 0) goto L_0x01ab
            java.lang.Object r13 = r11.next()
            org.threeten.bp.zone.ZoneRulesBuilder$TZWindow r13 = (org.threeten.bp.zone.ZoneRulesBuilder.TZWindow) r13
            int r14 = r9.getYear()
            r13.i(r14)
            java.lang.Integer r14 = r13.fixedSavingAmountSecs
            if (r14 != 0) goto L_0x00b7
            java.lang.Integer r14 = java.lang.Integer.valueOf(r2)
            java.util.List r15 = r13.ruleList
            java.util.Iterator r15 = r15.iterator()
        L_0x008e:
            boolean r16 = r15.hasNext()
            if (r16 == 0) goto L_0x00b7
            java.lang.Object r16 = r15.next()
            r10 = r16
            org.threeten.bp.zone.ZoneRulesBuilder$TZRule r10 = (org.threeten.bp.zone.ZoneRulesBuilder.TZRule) r10
            org.threeten.bp.zone.ZoneOffsetTransition r16 = r10.j(r3, r4)
            long r16 = r16.toEpochSecond()
            long r18 = r9.toEpochSecond(r12)
            int r16 = (r16 > r18 ? 1 : (r16 == r18 ? 0 : -1))
            if (r16 <= 0) goto L_0x00ad
            goto L_0x00b7
        L_0x00ad:
            int r10 = r10.savingAmountSecs
            java.lang.Integer r14 = java.lang.Integer.valueOf(r10)
            r10 = 1
            goto L_0x008e
        L_0x00b7:
            org.threeten.bp.ZoneOffset r4 = r13.standardOffset
            boolean r4 = r3.equals(r4)
            if (r4 != 0) goto L_0x00e6
            org.threeten.bp.zone.ZoneOffsetTransition r4 = new org.threeten.bp.zone.ZoneOffsetTransition
            r22 = r11
            long r10 = r9.toEpochSecond(r12)
            org.threeten.bp.LocalDateTime r10 = org.threeten.bp.LocalDateTime.ofEpochSecond(r10, r2, r3)
            org.threeten.bp.ZoneOffset r11 = r13.standardOffset
            r4.<init>((org.threeten.bp.LocalDateTime) r10, (org.threeten.bp.ZoneOffset) r3, (org.threeten.bp.ZoneOffset) r11)
            java.lang.Object r3 = r0.a(r4)
            r5.add(r3)
            org.threeten.bp.ZoneOffset r3 = r13.standardOffset
            java.lang.Object r3 = r0.a(r3)
            org.threeten.bp.ZoneOffset r3 = (org.threeten.bp.ZoneOffset) r3
            goto L_0x00e8
        L_0x00e6:
            r22 = r11
        L_0x00e8:
            int r4 = r3.getTotalSeconds()
            int r10 = r14.intValue()
            int r4 = r4 + r10
            org.threeten.bp.ZoneOffset r4 = org.threeten.bp.ZoneOffset.ofTotalSeconds(r4)
            java.lang.Object r4 = r0.a(r4)
            org.threeten.bp.ZoneOffset r4 = (org.threeten.bp.ZoneOffset) r4
            boolean r10 = r12.equals(r4)
            if (r10 != 0) goto L_0x010f
            org.threeten.bp.zone.ZoneOffsetTransition r10 = new org.threeten.bp.zone.ZoneOffsetTransition
            r10.<init>((org.threeten.bp.LocalDateTime) r9, (org.threeten.bp.ZoneOffset) r12, (org.threeten.bp.ZoneOffset) r4)
            java.lang.Object r4 = r0.a(r10)
            org.threeten.bp.zone.ZoneOffsetTransition r4 = (org.threeten.bp.zone.ZoneOffsetTransition) r4
            r6.add(r4)
        L_0x010f:
            int r4 = r14.intValue()
            java.util.List r10 = r13.ruleList
            java.util.Iterator r10 = r10.iterator()
        L_0x011b:
            boolean r11 = r10.hasNext()
            if (r11 == 0) goto L_0x0166
            java.lang.Object r11 = r10.next()
            org.threeten.bp.zone.ZoneRulesBuilder$TZRule r11 = (org.threeten.bp.zone.ZoneRulesBuilder.TZRule) r11
            org.threeten.bp.zone.ZoneOffsetTransition r14 = r11.j(r3, r4)
            java.lang.Object r14 = r0.a(r14)
            org.threeten.bp.zone.ZoneOffsetTransition r14 = (org.threeten.bp.zone.ZoneOffsetTransition) r14
            long r15 = r14.toEpochSecond()
            long r17 = r9.toEpochSecond(r12)
            int r15 = (r15 > r17 ? 1 : (r15 == r17 ? 0 : -1))
            if (r15 >= 0) goto L_0x013f
            r15 = 1
            goto L_0x0140
        L_0x013f:
            r15 = r2
        L_0x0140:
            if (r15 != 0) goto L_0x0164
            long r15 = r14.toEpochSecond()
            long r17 = r13.f(r4)
            int r15 = (r15 > r17 ? 1 : (r15 == r17 ? 0 : -1))
            if (r15 >= 0) goto L_0x0164
            org.threeten.bp.ZoneOffset r15 = r14.getOffsetBefore()
            org.threeten.bp.ZoneOffset r2 = r14.getOffsetAfter()
            boolean r2 = r15.equals(r2)
            if (r2 != 0) goto L_0x0164
            r6.add(r14)
            int r2 = r11.savingAmountSecs
            r4 = r2
        L_0x0164:
            r2 = 0
            goto L_0x011b
        L_0x0166:
            java.util.List r2 = r13.lastRuleList
            java.util.Iterator r2 = r2.iterator()
        L_0x016e:
            boolean r9 = r2.hasNext()
            if (r9 == 0) goto L_0x018c
            java.lang.Object r9 = r2.next()
            org.threeten.bp.zone.ZoneRulesBuilder$TZRule r9 = (org.threeten.bp.zone.ZoneRulesBuilder.TZRule) r9
            org.threeten.bp.zone.ZoneOffsetTransitionRule r4 = r9.k(r3, r4)
            java.lang.Object r4 = r0.a(r4)
            org.threeten.bp.zone.ZoneOffsetTransitionRule r4 = (org.threeten.bp.zone.ZoneOffsetTransitionRule) r4
            r7.add(r4)
            int r4 = r9.savingAmountSecs
            goto L_0x016e
        L_0x018c:
            org.threeten.bp.ZoneOffset r2 = r13.g(r4)
            java.lang.Object r2 = r0.a(r2)
            r12 = r2
            org.threeten.bp.ZoneOffset r12 = (org.threeten.bp.ZoneOffset) r12
            long r9 = r13.f(r4)
            r2 = 0
            org.threeten.bp.LocalDateTime r9 = org.threeten.bp.LocalDateTime.ofEpochSecond(r9, r2, r12)
            java.lang.Object r9 = r0.a(r9)
            org.threeten.bp.LocalDateTime r9 = (org.threeten.bp.LocalDateTime) r9
            r11 = r22
            r10 = 1
            goto L_0x0069
        L_0x01ab:
            org.threeten.bp.zone.StandardZoneRules r9 = new org.threeten.bp.zone.StandardZoneRules
            org.threeten.bp.ZoneOffset r3 = r1.standardOffset
            r2 = r9
            r4 = r8
            r2.<init>((org.threeten.bp.ZoneOffset) r3, (org.threeten.bp.ZoneOffset) r4, (java.util.List<org.threeten.bp.zone.ZoneOffsetTransition>) r5, (java.util.List<org.threeten.bp.zone.ZoneOffsetTransition>) r6, (java.util.List<org.threeten.bp.zone.ZoneOffsetTransitionRule>) r7)
            return r9
        L_0x01b7:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r2 = "No windows have been added to the builder"
            r1.<init>(r2)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: org.threeten.bp.zone.ZoneRulesBuilder.b(java.lang.String, java.util.Map):org.threeten.bp.zone.ZoneRules");
    }

    public ZoneRulesBuilder setFixedSavingsToWindow(int i11) {
        if (!this.windowList.isEmpty()) {
            List<TZWindow> list = this.windowList;
            list.get(list.size() - 1).h(i11);
            return this;
        }
        throw new IllegalStateException("Must add a window before setting the fixed savings");
    }

    public ZoneRules toRules(String str) {
        return b(str, new HashMap());
    }

    public ZoneRulesBuilder addRuleToWindow(int i11, Month month, int i12, LocalTime localTime, boolean z11, ZoneOffsetTransitionRule.TimeDefinition timeDefinition, int i13) {
        return addRuleToWindow(i11, i11, month, i12, (DayOfWeek) null, localTime, z11, timeDefinition, i13);
    }

    public ZoneRulesBuilder addRuleToWindow(int i11, int i12, Month month, int i13, DayOfWeek dayOfWeek, LocalTime localTime, boolean z11, ZoneOffsetTransitionRule.TimeDefinition timeDefinition, int i14) {
        int i15 = i13;
        LocalTime localTime2 = localTime;
        Month month2 = month;
        Jdk8Methods.requireNonNull(month, "month");
        Jdk8Methods.requireNonNull(localTime2, "time");
        Jdk8Methods.requireNonNull(timeDefinition, "timeDefinition");
        ChronoField chronoField = ChronoField.YEAR;
        chronoField.checkValidValue((long) i11);
        chronoField.checkValidValue((long) i12);
        if (i15 < -28 || i15 > 31 || i15 == 0) {
            throw new IllegalArgumentException("Day of month indicator must be between -28 and 31 inclusive excluding zero");
        } else if (z11 && !localTime2.equals(LocalTime.MIDNIGHT)) {
            throw new IllegalArgumentException("Time must be midnight when end of day flag is true");
        } else if (!this.windowList.isEmpty()) {
            List<TZWindow> list = this.windowList;
            list.get(list.size() - 1).e(i11, i12, month, i13, dayOfWeek, localTime, z11 ? 1 : 0, timeDefinition, i14);
            return this;
        } else {
            throw new IllegalStateException("Must add a window before adding a rule");
        }
    }
}
