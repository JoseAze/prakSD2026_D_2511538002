package pekan1_2511538002;

public class jam_2511538002 {
    private int hh; // 0..23
    private int mm; // 0..59
    private int ss; // 0..59

    // validator
    public static boolean isValid(int h, int m, int s) {
        return (0 <= h && h <= 23) &&
               (0 <= m && m <= 59) &&
               (0 <= s && s <= 59);
    }

    // konstruktor
    public jam_2511538002(int h, int m, int s) {
        this.hh = h;
        this.mm = m;
        this.ss = s;
    }

    // selector
    public int getHour() { return hh; }
    public int getMinute() { return mm; }
    public int getSecond() { return ss; }

    // mutator
    public void setHour(int h) { this.hh = h; }
    public void setMinute(int m) { this.mm = m; }
    public void setSecond(int s) { this.ss = s; }

    // konversi
    public int toSecond() {
        return hh * 3600 + mm * 60 + ss;
    }

    public static jam_2511538002 fromSecond(int total) {
        if (total < 0) throw new IllegalArgumentException("detik negatif");

        total %= 24 * 3600; // wrap 24 jam
        int h = total / 3600;
        total %= 3600;
        int m = total / 60;
        int s = total % 60;

        return new jam_2511538002(h, m, s);
    }

    // relasional
    public int compareTo(jam_2511538002 other) {
        return Integer.compare(this.toSecond(), other.toSecond());
    }

    public boolean equals(Object o) {
        if (!(o instanceof jam_2511538002 j)) return false;
        return hh == j.hh && mm == j.mm && ss == j.ss;
    }

    // aritmatika
    public jam_2511538002 plus(jam_2511538002 other) {
        return fromSecond(this.toSecond() + other.toSecond());
    }

    public jam_2511538002 minus(jam_2511538002 other) {
        return fromSecond(Math.floorMod(this.toSecond() - other.toSecond(), 24 * 3600));
    }

    public jam_2511538002 nextSecond() {
        return fromSecond(this.toSecond() + 1);
    }

    public jam_2511538002 nextNSecond(int n) {
        return fromSecond(this.toSecond() + Math.max(0, n));
    }

    public jam_2511538002 prevSecond() {
        return fromSecond(Math.floorMod(this.toSecond() - 1, 24 * 3600));
    }

    public jam_2511538002 prevNSecond(int n) {
        return fromSecond(Math.floorMod(this.toSecond() - Math.max(0, n), 24 * 3600));
    }

    // durasi
    public static int durasiDetik(jam_2511538002 jaw, jam_2511538002 jakh) {
        return jakh.toSecond() - jaw.toSecond();
    }

    // overriding
    public String toString() {
        return String.format("%02d:%02d:%02d", hh, mm, ss);
    }

    public static void main(String[] args) {

    }
}
