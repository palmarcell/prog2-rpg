package hu.unideb.inf.model;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

@Data
@SuperBuilder
@NoArgsConstructor
public class Entity {

    private String name;
    private int health;
    private int damage;
    private int level;
    private Armor armor;
    private Weapon weapon;

    @Builder.Default
    private List<Effect> effects = new LinkedList<>();

    public int takeDamage(int damage) {
        var maxDefense= Optional.ofNullable(armor).map(Armor::getDefense).orElse(0f);
        damage = Math.round(damage * (1 - maxDefense));
        this.health -= damage;
        return damage;
    }

    public void attack(Entity entityToBeAttacked) {
        var maxAttack= Optional.ofNullable(this.getWeapon())
                .map(this::calculateFinalAttack)
                .orElse(this.getDamage());

        entityToBeAttacked.takeDamage(maxAttack);
    }

    @Override
    public String toString() {
        return this.getName() + ":\n" +
                "\tLevel: " + this.getLevel() + "\n" +
                "\tHealth: " + this.getHealth() + "\n" +
                "\tDamage: " + this.getDamage();
    }

    private int calculateFinalAttack(Weapon weapon) {
        Optional.ofNullable(weapon.getEffect()).ifPresent(effect -> effect.apply(this));
        return weapon.getDamage() + this.getDamage();
    }

}
