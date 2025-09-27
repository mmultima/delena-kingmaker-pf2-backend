package fi.tietotupsu.delena.kingmakerpf2.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import fi.tietotupsu.delena.kingmakerpf2.data.PfCharacter;

public interface PfCharacterRepository extends MongoRepository<PfCharacter, String> {
    List<PfCharacter> findByKingmakerTrue();
    
    @Query("{name:'?0'}")
    PfCharacter findItemByName(String name);
    
    @Query(value="{user:'?0'}") //, fields="{'name' : 1, 'quantity' : 1}")
    List<PfCharacter> findAll(String user);
    
    @Query("{}")
    List<PfCharacter> findAllCharacters();
    
    @Query("{id:'?0'}")
    Optional<PfCharacter> findById(String id);

    public long count();

}
