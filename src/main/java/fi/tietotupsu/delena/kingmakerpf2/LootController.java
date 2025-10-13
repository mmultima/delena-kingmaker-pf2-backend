package fi.tietotupsu.delena.kingmakerpf2;

import org.springframework.web.bind.annotation.RestController;

import fi.tietotupsu.delena.kingmakerpf2.data.Loot;
import fi.tietotupsu.delena.kingmakerpf2.repositories.LootRepository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("/loot")
public class LootController {
    @Autowired
    private LootRepository lootRepository;

    @GetMapping
    public List<Loot> getLoot() {
        return lootRepository.findAll();
    }

    @PostMapping
    public Loot saveLoot(@RequestBody Loot loot) {
        return lootRepository.save(loot);
    }

    @PutMapping("/{id}")
    public Loot updateLoot(@PathVariable String id, @RequestBody Loot loot) {
        loot.setId(id);
        return lootRepository.save(loot);
    }

    @DeleteMapping("/{id}")
    public void deleteLoot(@PathVariable String id) {
        lootRepository.deleteById(id);
    }
}
