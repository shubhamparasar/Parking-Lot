package respositories;

import models.Gate;

import java.util.Optional;

public class GateRepository {

    public Optional<Gate> getById(Long id){
        return Optional.of(new Gate());
    }
}
