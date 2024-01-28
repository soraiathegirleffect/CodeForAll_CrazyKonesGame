package game;

public class KoneFactory {

    public Kone[] createKone(int TotalKones, Position position) {
        Kone[] kones = new Kone[TotalKones];

        for (int i = 0; i < kones.length; i++) {
            kones[i] = new Kone(position);
        }
        return kones;
    }
}
