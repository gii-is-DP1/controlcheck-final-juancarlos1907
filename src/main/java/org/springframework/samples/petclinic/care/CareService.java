package org.springframework.samples.petclinic.care;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;


@Service
public class CareService {
    
    @Autowired
	CareProvisionRepository careProvisionRepository;

    public List<Care> getAllCares(){
        return careProvisionRepository.findAllCares();
    }

    public List<Care> getAllCompatibleCares(String petTypeName){
        return null;
    }

    public Care getCare(String careName) {
        return careProvisionRepository.getCare(careName);
    }

    
    public CareProvision save(CareProvision p) throws NonCompatibleCaresException, UnfeasibleCareException {
        return null;   
    }

    public List<CareProvision> getAllCaresProvided(){
        return null;
    }

    public List<CareProvision> getCaresProvided(Integer visitId){
        return null;

    }
    
}
