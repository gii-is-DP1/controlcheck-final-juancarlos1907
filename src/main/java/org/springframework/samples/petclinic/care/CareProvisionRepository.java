package org.springframework.samples.petclinic.care;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface CareProvisionRepository extends CrudRepository<CareProvision,Integer>{
    List<CareProvision> findAll();        
    Optional<CareProvision> findById(int id);
    CareProvision save(CareProvision p);
    @Query("SELECT c FROM CareProvision c")
	List<Care> findAllCares();
    @Query("SELECT c FROM Care c WHERE ")
    List<Care> findCompatibleCares(@Param("name") String petTypeName);
    //Care findCareByName(String name);
    //List<CareProvision> findCaresProvidedByVisitId(Integer visitId);
    @Query("Select c FROM Care c WHERE c.name=:careName")
    Care getCare(@Param("careName") String careName);
}
