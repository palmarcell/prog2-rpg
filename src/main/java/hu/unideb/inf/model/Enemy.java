package hu.unideb.inf.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class Enemy extends Entity {

    private Weapon weaponDrop;
    private Armor armorDrop;
    private int xpDrop;

}
