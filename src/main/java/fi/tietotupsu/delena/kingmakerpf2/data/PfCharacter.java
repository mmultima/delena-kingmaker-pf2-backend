package fi.tietotupsu.delena.kingmakerpf2.data;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.util.List;

@Document("pfcharacters")
public class PfCharacter {
    @Id
    private String id;

    private String name;

    /* Currently only cdn.paizo.com images allowed */
    private String image;

    /* Colour of circle around the image. Probably will change. */
    private String colour;

    //private BasicInfo basicInfo;

    private String basicInfoId;

    private String castingIdString;

    // Getter for BasicInfoId
    public String getBasicInfoId() {
        return basicInfoId;
    }

    // Setter for BasicInfoId
    public void setBasicInfoId(String basicInfoId) {
        this.basicInfoId = basicInfoId;
    }

    public String getImage() {
        return image;
    }

    /*
    public BasicInfo getBasicInfo() {
        return basicInfo;
    }

    public void setBasicInfo(BasicInfo basicInfo) {
        this.basicInfo = basicInfo;
    }
    */

    public void setImage(String image) {
        this.image = image;
    }

    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    private String user;

    private boolean kingmaker;

    private boolean npc;

    private List<NpcRelationship> npcRelationships;
    public List<NpcRelationship> getNpcRelationships() {
        return npcRelationships;
    }

    public void setNpcRelationships(List<NpcRelationship> npcRelationships) {
        this.npcRelationships = npcRelationships;
    }
    public boolean isNpc() {
        return npc;
    }

    public void setNpc(boolean npc) {
        this.npc = npc;
    }
    public boolean isKingmaker() {
        return kingmaker;
    }

    public void setKingmaker(boolean kingmaker) {
        this.kingmaker = kingmaker;
    }
    
    public PfCharacter(String id, String name) {
        super();
        this.id = id;
        this.name = name;
    }

    public PfCharacter(String name) {
        super();
        this.name=name;
    }

    public PfCharacter() {
        super();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCastingIdString() {
        return castingIdString;
    }

    public void setCastingIdString(String castingIdString) {
        this.castingIdString = castingIdString;
    }


}