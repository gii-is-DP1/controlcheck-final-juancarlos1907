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
    @Query("SELECT c FROM Care c")
	List<Care> findAllCares();
    @Query("SELECT c FROM Care c INNER JOIN c.compatiblePetTypes cp WHERE cp.name=?1")
    List<Care> findCompatibleCares(@Param("name") String name);
    //Care findCareByName(String name);
    //List<CareProvision> findCaresProvidedByVisitId(Integer visitId);
    @Query("Select c FROM Care c WHERE c.name=:careName")
    Care getCare(@Param("careName") String careName);
    @Query("SELECT c FROM Care c INNER JOIN CareProvision cp WHERE cp.visit.id=?1")
    List<Care> getCaresPerformed(Integer visitId);
}
