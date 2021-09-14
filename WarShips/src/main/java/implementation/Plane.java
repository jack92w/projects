package implementation;

import java.util.List;
import java.util.Random;

public enum Plane {
    HORIZONTAL,
    VERTICAL;

    private static final List<Plane> VALUES =
            List.of(values());
    private static final int SIZE = VALUES.size();
    private static final Random RANDOM = new Random();

    /**
     * chooses random plane
     * @return plane
     */
    public static Plane randomPlane() {
        return VALUES.get(RANDOM.nextInt(SIZE));
    }
}
