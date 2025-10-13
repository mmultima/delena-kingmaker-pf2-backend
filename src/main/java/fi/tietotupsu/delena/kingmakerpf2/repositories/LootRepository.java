package fi.tietotupsu.delena.kingmakerpf2.repositories;

import fi.tietotupsu.delena.kingmakerpf2.data.Loot;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LootRepository extends MongoRepository<Loot, String> {
    // Standard MongoRepository provides findAll() and save()
}
