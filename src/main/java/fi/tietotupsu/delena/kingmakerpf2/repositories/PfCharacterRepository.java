package fi.tietotupsu.delena.kingmakerpf2.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import fi.tietotupsu.delena.kingmakerpf2.data.PfCharacter;

public interface PfCharacterRepository extends MongoRepository<PfCharacter, String> {
    
    @Query("{name:'?0'}")
    PfCharacter findItemByName(String name);
    
    @Query(value="{user:'?0'}") //, fields="{'name' : 1, 'quantity' : 1}")
    List<PfCharacter> findAll(String user);
    
    public long count();

}
