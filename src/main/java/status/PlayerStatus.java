package status;

import java.util.function.Consumer;

public record PlayerStatus(String playerName,
                           String weaponName,
                           String armorName,
                           int lv,
                           int hp,
                           int atk,
                           int def) implements Status {

    public static void save(Consumer<PlayerStatus> con) {
        con.accept(new PlayerStatus("勇者",
                "ロングソード",
                "戦士の盾",
                1,
                10,
                5,
                3));
    }
}