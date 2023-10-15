import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;


public class GameTest {

    //регистрация всех игроков
    @Test
    public void registration() {
        Game game = new Game();
        Player player1 = new Player(1, "Анна", 50); // Создаем игроков
        Player player2 = new Player(2, "Илья", 40);
        Player player3 = new Player(3, "Людмила", 60);

        game.register(player1); // Регистрируем первого игрока
        game.register(player2); // Регистрируем второго игрока
        game.register(player3); // Регистрируем третьего игрока

        List<Player> actual = game.findAll();
        Assertions.assertTrue(actual.contains(player1));
        Assertions.assertTrue(actual.contains(player2));
        Assertions.assertTrue(actual.contains(player3));
    }

    //повторная регистрация игрока
    @Test
    public void repeatRegistration() {
        Game game = new Game();
        Player player1 = new Player(1, "Анна", 50); // Создаем игроков

        game.register(player1); // Регистрируем первого игрока

        List<Player> actual = game.findAll();

        Assertions.assertTrue(actual.contains(player1));

        game.register(player1); // Повторная регистрация первого игрока
        Assertions.assertTrue(actual.contains(player1));
    }

    //соревнование между 2 зарегистрирвоанными игроками, где у первого игрока больше силы
    @Test
    public void competitions1() {
        Game game = new Game();
        Player player1 = new Player(1, "Анна", 50); // Создаем игроков
        Player player2 = new Player(2, "Илья", 40);
        Player player3 = new Player(3, "Людмила", 60);

        game.register(player1); // Регистрируем первого игрока
        game.register(player2); // Регистрируем второго игрока
        game.register(player3); // Регистрируем третьего игрока

        int result = game.tournament("Анна", "Илья");
        Assertions.assertEquals(1, result); // Проверяем, что Анна победила Илью
    }

    //соревнование между 2 зарегистрирвоанными игроками, где у второго игрока больше силы
    @Test
    public void competitions2() {
        Game game = new Game();
        Player player1 = new Player(1, "Анна", 50); // Создаем игроков
        Player player2 = new Player(2, "Илья", 40);
        Player player3 = new Player(3, "Людмила", 60);

        game.register(player1); // Регистрируем первого игрока
        game.register(player2); // Регистрируем второго игрока
        game.register(player3); // Регистрируем третьего игрока

        int result = game.tournament("Илья", "Людмила");
        Assertions.assertEquals(2, result); // Проверяем, что Людмила победила Илью
    }

    //соревнование между 2 зарегистрирвоанными игроками, с одинаковой силой
    @Test
    public void competitions3() {
        Game game = new Game();
        Player player1 = new Player(1, "Анна", 50); // Создаем игроков
        Player player2 = new Player(2, "Илья", 50);
        Player player3 = new Player(3, "Людмила", 60);

        game.register(player1); // Регистрируем первого игрока
        game.register(player2); // Регистрируем второго игрока
        game.register(player3); // Регистрируем третьего игрока

        int result = game.tournament("Илья", "Анна");
        Assertions.assertEquals(0, result); // Проверяем, что ничья
    }

    //соревнование между 1 зарегистрирвоанным и 1 не зарегистрированным игроками
    @Test
    public void competitions4() {
        Game game = new Game();
        Player player1 = new Player(1, "Анна", 50); // Создаем игроков
        Player player2 = new Player(2, "Илья", 40);
        Player player3 = new Player(3, "Людмила", 60);

        game.register(player1); // Регистрируем первого игрока
        game.register(player2); // Регистрируем второго игрока
        game.register(player3); // Регистрируем третьего игрока

        Assertions.assertThrows(NotRegisteredException.class, () -> game.tournament("Анна", "Петя"));
    }

    //соревнование между 2 не зарегистрирвоанным игроками
    @Test
    public void competitions5() {
        Game game = new Game();
        Player player1 = new Player(1, "Анна", 50); // Создаем игроков
        Player player2 = new Player(2, "Илья", 40);
        Player player3 = new Player(3, "Людмила", 60);

        game.register(player1); // Регистрируем первого игрока
        game.register(player2); // Регистрируем второго игрока
        game.register(player3); // Регистрируем третьего игрока

        Assertions.assertThrows(NotRegisteredException.class, () -> game.tournament("Вася", "Петя"));
    }
}