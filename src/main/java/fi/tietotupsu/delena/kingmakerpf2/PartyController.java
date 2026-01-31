package fi.tietotupsu.delena.kingmakerpf2;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PartyController {
    @GetMapping("/party")
    public String getParty() {
        return "Party endpoint is under construction.";
    }
    
}
