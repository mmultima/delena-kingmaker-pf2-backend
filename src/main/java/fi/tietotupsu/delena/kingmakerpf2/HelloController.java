
package fi.tietotupsu.delena.kingmakerpf2;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

import fi.tietotupsu.delena.kingmakerpf2.data.PfCharacter;
import fi.tietotupsu.delena.kingmakerpf2.repositories.PfCharacterRepository;

@RestController
public class HelloController {
    @Autowired
    private PfCharacterRepository pfCharacterRepository;

    @GetMapping("/hello")
    public String hello() {
        String defaultUser = "649e0759cca2d08fbc00abab";

        //return new ArrayList<PfCharacter>();
        List<PfCharacter> characters = pfCharacterRepository.findAll(defaultUser);

        String names = "";

        if (!characters.isEmpty()) {
            for (PfCharacter character : characters) {
                names += character.getName() + " ";
            }
            return "Hello from Kingmakerpf2 REST server! Characters: " + names;
        } else {
            return "Hello from Kingmakerpf2 REST server! No characters found for user " + defaultUser;
        }

        //return "Hello from Kingmakerpf2 REST server!";
    }
    @GetMapping("/character/{id}")
    public PfCharacter getCharacterById(@org.springframework.web.bind.annotation.PathVariable String id) {
        return pfCharacterRepository.findById(id).orElse(null);
    }


    @GetMapping("/characters")
    public List<PfCharacter> getAllCharacters() {
        //@RequestParam(required = false) String user) {
        String defaultUser = "649e0759cca2d08fbc00abab";

        //return new ArrayList<PfCharacter>();
        //return pfCharacterRepository.findAll(defaultUser);
        return pfCharacterRepository.findByKingmakerTrue();
        //return pfCharacterRepository.findAllCharacters();
/*

        if (user != null) {
            return pfCharacterRepository.findAll(user);
        } else {
            return pfCharacterRepository.findAll(defaultUser);
        }
            */
    }
    
    @PostMapping("/character")
    public PfCharacter createCharacter(@RequestBody PfCharacter character) {
        return pfCharacterRepository.save(character);
    }
}
