package hu.unideb.inf.factory;

import hu.unideb.inf.model.Entity;

public interface EntityFactory {

    Entity create(int level);

}
