package ma.projects.ws.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import ma.projects.ws.entities.AddressEntity;
import ma.projects.ws.entities.UserEntity;

@Repository
public interface AddressRepository extends CrudRepository<AddressEntity, Long> {

    List<AddressEntity> findByUser(UserEntity currentUser);

    AddressEntity findByAddressId(String addressId);
}
