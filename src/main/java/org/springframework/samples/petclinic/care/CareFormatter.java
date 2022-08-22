package org.springframework.samples.petclinic.care;

import java.text.ParseException;
import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.Formatter;
import org.springframework.stereotype.Component;



@Component
public class CareFormatter implements Formatter<Care>{

    @Autowired
    CareProvisionRepository careProvisionRepository;
    @Autowired
    CareService careService;

    @Override
    public String print(Care object, Locale locale) {
        return object.getName();
    }

    @Override
    public Care parse(String text, Locale locale) throws ParseException {
        Care c = careService.getCare(text);
        if(c==null){
            throw new ParseException("Care not found: " + text, 0);
        }else{
            return c;
        }
        
    }
    
}
