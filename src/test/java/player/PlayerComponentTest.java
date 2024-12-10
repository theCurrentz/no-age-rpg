package player;

import static org.junit.jupiter.api.Assertions.*;

class PlayerComponentTest {

    int currentHealth;
    int maxHealth = 100;

    int currentMana;
    int maxMana = 100;

    int currentExp;
    int maxExp = 100;

    int damage = 25;

    int level = 1;
    int maxLevel = 30;


    @org.junit.jupiter.api.Test
    void heal() {
        currentHealth = 15;
        int healAmount = 45;
        currentHealth += healAmount;
        assertEquals(60, currentHealth );
    }
    @org.junit.jupiter.api.Test
    void takeDamage() {
        currentHealth = maxHealth;
        int damage = 65;
        currentHealth -= damage;
        assertEquals(35, currentHealth );
    }

}