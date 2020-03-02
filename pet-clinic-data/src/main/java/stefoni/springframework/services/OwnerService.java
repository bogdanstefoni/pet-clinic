package stefoni.springframework.services;

import stefoni.springframework.model.Owner;


public interface OwnerService extends CrudService<Owner, Long> {

    Owner findByLastName(String lastName);

}
