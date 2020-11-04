package hu.unideb.inf.factory;

import hu.unideb.inf.model.Enemy;

public class EnemyCreationService implements EntityFactory {

    @Override
    public Enemy create(int level) {
        return Enemy.builder()
                .xpDrop(10 * level)
                .health(10)
                .level(level)
                .damage((5 * level))
                .build();
    }

}
