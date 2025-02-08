package status;

import java.util.function.Consumer;

public record PlayerStatus(int lv, int hp, int atk, int def) implements Status {

    public static void save(Consumer<PlayerStatus> con) {
        con.accept(new PlayerStatus(1, 10, 5, 3));
    }
}
