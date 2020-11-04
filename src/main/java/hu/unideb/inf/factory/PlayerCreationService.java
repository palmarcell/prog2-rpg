package hu.unideb.inf.factory;

import hu.unideb.inf.io.ConsoleIOService;
import hu.unideb.inf.io.IOService;
import hu.unideb.inf.model.Player;

public class PlayerCreationService implements EntityFactory {

    @Override
    public Player create(int level) {
        IOService ioService = new ConsoleIOService();

        return Player.builder()
                .name(ioService.input("Please define your nick:"))
                .gold(10)
                .damage(5)
                .health(100)
                .experiencePoints(0)
                .level(level)
                .build();
    }

}
