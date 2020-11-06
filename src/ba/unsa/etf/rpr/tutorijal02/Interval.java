package ba.unsa.etf.rpr.tutorijal02;

import java.util.Objects;

public class Interval {

    private double pocetnaTacka, krajnjaTacka;
    private boolean pripadaPocetna, pripadaKrajnja;

    public Interval(double pocetnaTacka, double krajnjaTacka, boolean pripadaPocetna, boolean pripadaKrajnja) {
        this.pocetnaTacka = pocetnaTacka;
        this.krajnjaTacka = krajnjaTacka;

        if (this.pocetnaTacka > this.krajnjaTacka)
            throw new IllegalArgumentException();

        this.pripadaPocetna = pripadaPocetna;
        this.pripadaKrajnja = pripadaKrajnja;
    }

    public Interval() {
        this.pocetnaTacka = 0;
        this.krajnjaTacka = 0;
        this.pripadaPocetna = false;
        this.pripadaKrajnja = false;
    }

    public double getPocetnaTacka() {
        return pocetnaTacka;
    }

    public void setPocetnaTacka(double pocetnaTacka) {
        this.pocetnaTacka = pocetnaTacka;
    }

    public double getKrajnjaTacka() {
        return krajnjaTacka;
    }

    public void setKrajnjaTacka(double krajnjaTacka) {
        this.krajnjaTacka = krajnjaTacka;
    }

    public boolean isPripadaPocetna() {
        return pripadaPocetna;
    }

    public void setPripadaPocetna(boolean pripadaPocetna) {
        this.pripadaPocetna = pripadaPocetna;
    }

    public boolean isPripadaKrajnja() {
        return pripadaKrajnja;
    }

    public void setPripadaKrajnja(boolean pripadaKrajnja) {
        this.pripadaKrajnja = pripadaKrajnja;
    }

    public double getRazlika() {
        return this.getKrajnjaTacka() - this.getPocetnaTacka();
    }

    public double getRazlikaSaPocetnom(double tacka) {
        return tacka - this.getPocetnaTacka();
    }

    public double getRazlikaSaKrajnjom(double tacka) {
        return tacka - this.getKrajnjaTacka();
    }

    public boolean isNull() {
        if (this.getRazlika() == 0)
            return true;
        return false;
    }

    public boolean isIn(double tacka) {
        if (tacka >= this.getPocetnaTacka() && tacka <= this.getKrajnjaTacka())
            return true;
        return false;
    }

    public Interval intersect(Interval i) {
        Interval rvalue = new Interval();
        if (this.getRazlikaSaPocetnom(i.getPocetnaTacka()) >= 0)
            rvalue.setPocetnaTacka(i.getPocetnaTacka());
        else if (this.getRazlikaSaPocetnom(i.getPocetnaTacka()) < 0)
            rvalue.setPocetnaTacka(this.getPocetnaTacka());

        if (this.getRazlikaSaKrajnjom(i.getKrajnjaTacka()) >= 0)
            rvalue.setKrajnjaTacka(this.getKrajnjaTacka());
        else if (this.getRazlikaSaKrajnjom(i.getKrajnjaTacka()) < 0)
            rvalue.setKrajnjaTacka(i.getKrajnjaTacka());

        return rvalue;
    }

    

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Interval interval = (Interval) o;
        return Double.compare(interval.pocetnaTacka, pocetnaTacka) == 0 &&
                Double.compare(interval.krajnjaTacka, krajnjaTacka) == 0 &&
                pripadaPocetna == interval.pripadaPocetna &&
                pripadaKrajnja == interval.pripadaKrajnja;
    }

    @Override
    public int hashCode() {
        return Objects.hash(pocetnaTacka, krajnjaTacka, pripadaPocetna, pripadaKrajnja);
    }

    @Override
    public String toString() {
        return "Interval{" +
                "pocetnaTacka=" + pocetnaTacka +
                ", krajnjaTacka=" + krajnjaTacka +
                ", pripadaPocetna=" + pripadaPocetna +
                ", pripadaKrajnja=" + pripadaKrajnja +
                '}';
    }
}
