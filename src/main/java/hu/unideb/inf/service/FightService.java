package hu.unideb.inf.service;

import hu.unideb.inf.io.ConsoleIOService;
import hu.unideb.inf.io.IOService;
import hu.unideb.inf.model.Enemy;
import hu.unideb.inf.model.Entity;
import hu.unideb.inf.model.Player;

import java.util.Random;

public class FightService {

    IOService ioService = new ConsoleIOService();
    Random random = new Random();

    public void start(Player player, Enemy enemy) {

        int starterEntity = random.nextInt(2);

        Entity first;
        Entity second;
        if (0 == starterEntity) {
            first = player;
            second = enemy;
        } else {
            first = enemy;
            second = player;
        }

        while (!hasAnyoneDied(first, second)) {

            first.attack(second);
            ioService.print(first.getName() + " has attacked " + second.getName());

            if (hasAnyoneDied(first, second)) {
                ioService.print("Someone has died, will implement this later.");
                break;
            }

            second.attack(first);
            ioService.print(second.getName() + " has attacked " + first.getName());

            ioService.print(first.toString());
            ioService.print(second.toString());

        }

        ioService.print(first.toString());
        ioService.print(second.toString());

    }

    private boolean hasAnyoneDied(Entity first, Entity second) {
        return first.getHealth() <= 0 || second.getHealth() <= 0;
    }

}
