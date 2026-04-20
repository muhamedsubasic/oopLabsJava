package Abstraction;

interface Playable {
    void play();
}

class Guitar implements Playable {
    private String brand;

    public Guitar(String brand) {
        this.brand = brand;
    }

    @Override
    public void play() {
        System.out.println("Strumming guitar chords");
    }

    public String getBrand() {
        return brand;
    }
}

class Piano implements Playable {
    private String brand;

    public Piano(String brand) {
        this.brand = brand;
    }

    @Override
    public void play() {
        System.out.println("Playing elegant piano melodies");
    }

    public String getBrand() {
        return brand;
    }
}

class Drum implements Playable {
    private String brand;

    public Drum(String brand) {
        this.brand = brand;
    }

    @Override
    public void play() {
        System.out.println("Beating drums with rhythm");
    }

    public String getBrand() {
        return brand;
    }
}

class InstrumentTest {
    public static void main(String[] args) {
        Playable[] instruments = {
                new Guitar("Fender"),
                new Piano("Steinway"),
                new Drum("Yamaha")
        };

        for (Playable p : instruments) {
            p.play();
            if (p instanceof Guitar) {
                System.out.println("Brand: " + ((Guitar) p).getBrand());
            } else if (p instanceof Piano) {
                System.out.println("Brand: " + ((Piano) p).getBrand());
            } else if (p instanceof Drum) {
                System.out.println("Brand: " + ((Drum) p).getBrand());
            }
            System.out.println();
        }
    }
    }
