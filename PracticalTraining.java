package projekt3.copy;

public class PracticalTraining extends Training {
    private Player top;  
    private Player jng;  
    private Player mid;  
    private Player adc;  
    private Player sup;  

    public PracticalTraining(int day, int month, int year, String description, Player top, Player jng, Player mid, Player adc, Player sup) {
        super(day, month, year, description);

        if (top == null || jng == null || mid == null || adc == null || sup == null) {
            throw new IllegalArgumentException("Alle fünf Spieler müssen zugewiesen werden.");
        }

        this.top = top;
        this.jng = jng;
        this.mid = mid;
        this.adc = adc;
        this.sup = sup;
    }

    public Player getTop() {
        return top;
    }

    public void setTop(Player top) {
        if (top != null) {
            this.top = top;
        } else {
            throw new IllegalArgumentException("Ein gültiger Spieler muss zugewiesen werden.");
        }
    }

    public Player getJng() {
        return jng;
    }

    public void setJng(Player jng) {
        if (jng != null) {
            this.jng = jng;
        } else {
            throw new IllegalArgumentException("Ein gültiger Spieler muss zugewiesen werden.");
        }
    }

    public Player getMid() {
        return mid;
    }

    public void setMid(Player mid) {
        if (mid != null) {
            this.mid = mid;
        } else {
            throw new IllegalArgumentException("Ein gültiger Spieler muss zugewiesen werden.");
        }
    }

    public Player getAdc() {
        return adc;
    }

    public void setAdc(Player adc) {
        if (adc != null) {
            this.adc = adc;
        } else {
            throw new IllegalArgumentException("Ein gültiger Spieler muss zugewiesen werden.");
        }
    }

    public Player getSup() {
        return sup;
    }

    public void setSup(Player sup) {
        if (sup != null) {
            this.sup = sup;
        } else {
            throw new IllegalArgumentException("Ein gültiger Spieler muss zugewiesen werden.");
        }
    }

    @Override
    public void displayDetails() {
        System.out.println("Praxis-Training am " + getDay() + "." + getMonth() + "." + getYear());
        System.out.println("Beschreibung: " + getDescription());
        System.out.println("Spieler:");
        System.out.println("Top: " + top.getVorName() + " " + top.getNachName());
        System.out.println("Jungle: " + jng.getVorName() + " " + jng.getNachName());
        System.out.println("Mid: " + mid.getVorName() + " " + mid.getNachName());
        System.out.println("ADC: " + adc.getVorName() + " " + adc.getNachName());
        System.out.println("Support: " + sup.getVorName() + " " + sup.getNachName());
    }
}