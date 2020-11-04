package hu.unideb.inf.room;

import hu.unideb.inf.factory.EnemyCreationService;
import hu.unideb.inf.factory.PlayerCreationService;
import hu.unideb.inf.io.ConsoleIOService;
import hu.unideb.inf.io.IOService;
import hu.unideb.inf.model.Enemy;
import hu.unideb.inf.model.Player;
import hu.unideb.inf.model.TestEffect;
import hu.unideb.inf.model.Weapon;
import hu.unideb.inf.service.FightService;

import java.util.List;

public class FirstRoom {

    PlayerCreationService playerCreationService = new PlayerCreationService();
    EnemyCreationService enemyCreationService = new EnemyCreationService();
    FightService fightService = new FightService();
    IOService ioService = new ConsoleIOService();

    public void enter() {

        Player player = playerCreationService.create(1);

        ioService.print("It was a gloomy night, once again staying up late working on the project..");
        ioService.print("I saw a warning but i didn't pay attention to it, I just wanted to get it done finally...");
        ioService.print("But when I ran the code, and finally felt like a real person again, I teleported into the computer,...");
        ioService.print("don't know how ,why and how will I get out, but I need to survive. ");
        ioService.print("Aid me on my journey and don't you ever forget to listen to the warnings kids!");


        Enemy goblin = enemyCreationService.create(1);
        goblin.setName("Goblin");

        Weapon dagger = Weapon.builder()
                .name("Broken dagger")
                .damage(5)
                .level(1)
                .effect(new TestEffect())
                .build();

        goblin.setWeapon(dagger);
        goblin.setWeaponDrop(dagger);

        List<Enemy> enemies = List.of(goblin);

        ioService.print("A random goblin just appeared and attacked you.");
        for (var enemy : enemies) {
            fightService.start(player, enemy);
        }
        // next rooms?


    }

}
