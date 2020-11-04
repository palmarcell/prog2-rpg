package hu.unideb.inf.model;

public class TestEffect implements Effect {

    @Override
    public void apply(Entity entity) {
        entity.setDamage((int) (entity.getDamage() * 1.2));
    }
}
