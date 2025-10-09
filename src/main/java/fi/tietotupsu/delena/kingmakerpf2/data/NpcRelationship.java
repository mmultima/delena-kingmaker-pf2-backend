package fi.tietotupsu.delena.kingmakerpf2.data;

public class NpcRelationship {
    private String npcId;
    private int bonus;
    private String description;

    public String getNpcId() {
        return npcId;
    }

    public void setNpcId(String npcId) {
        this.npcId = npcId;
    }

    public int getBonus() {
        return bonus;
    }

    public void setBonus(int bonus) {
        this.bonus = bonus;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
