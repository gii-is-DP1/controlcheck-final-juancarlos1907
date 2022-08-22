package org.springframework.samples.petclinic.care;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;


@Service
public class CareService {
    
    @Autowired
	CareProvisionRepository careProvisionRepository;

    public List<Care> getAllCares(){
        return careProvisionRepository.findAllCares();
    }

    public List<Care> getAllCompatibleCares(String petTypeName){
        return careProvisionRepository.findCompatibleCares(petTypeName);
    }

    public Care getCare(String careName) {
        return careProvisionRepository.getCare(careName);
    }

    @Transactional(rollbackFor = UnfeasibleCareException.class)
    public CareProvision save(CareProvision p) throws NonCompatibleCaresException, UnfeasibleCareException {
        if(p.getCare().getIncompatibleCares().contains(this.careProvisionRepository.getCaresPerformed(p.getVisit().getId()))){
            throw new NonCompatibleCaresException();
        }if(!p.getCare().getCompatiblePetTypes().contains(p.getVisit().getPet().getType())){
            throw new UnfeasibleCareException();
        }else{
            return this.careProvisionRepository.save(p);
        }
    }

    public List<CareProvision> getAllCaresProvided(){
        return careProvisionRepository.findAll();
    }

    public List<CareProvision> getCaresProvided(Integer visitId){
        return null;

    }
    
}
