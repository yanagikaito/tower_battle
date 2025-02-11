package status;

import java.util.function.Consumer;

public record MonsterStatus(String name,
                            int lv,
                            int hp,
                            int atk,
                            int def) implements Status {

    public static void save(Consumer<MonsterStatus> con) {
        con.accept(new MonsterStatus("スライム ",
                1,
                10,
                5,
                3));
    }
}