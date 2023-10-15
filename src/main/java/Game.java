import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Game {
    private List<Player> allRegisteredPlayers = new ArrayList<Player>(); // все зарегистрированные игроки, создаем список

    public List<Player> findAll() {
        return allRegisteredPlayers;
    }

    //метод регистрации игрока
    public void register(Player player) {
        if (!allRegisteredPlayers.contains(player) == true) {
            allRegisteredPlayers.add(player);
            System.out.println("Игрок " + player.getName() + " успешно зарегистрирован.");
        } else {
            System.out.println("Игрок " + player.getName() + " уже зарегистрирован.");
        }
    }

    //метод соревнования между двумя игроками
    public int tournament(String playerName1, String playerName2) {
        Player player1 = findByName(playerName1);
        Player player2 = findByName(playerName2);

        if (player1 == null) {
            throw new NotRegisteredException
                    ("Первый игрок не зарегистрирован, поэтому не может учавствовать в соревновании");
        } else if (player2 == null) {
            throw new NotRegisteredException
                    ("Второй игрок не зарегистрирован, поэтому не может учавствовать в соревновании");
        }

        if (player1.getStrength() > player2.getStrength()) {
            return 1;
        } else if (player1.getStrength() < player2.getStrength()) {
            return 2;
        } else {
            return 0;
        }
    }

    public Player findByName(String name) {
        for (Player player : allRegisteredPlayers) {
            if (player.getName().equals(name)) {
                return player;
            }
        }
        return null;
    }
}


