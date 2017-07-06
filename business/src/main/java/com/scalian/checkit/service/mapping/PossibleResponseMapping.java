package com.scalian.checkit.service.mapping;

import com.scalian.checkit.model.PossibleResponseEntity;
import com.scalian.checkit.service.model.PossibleResponseBO;

public class PossibleResponseMapping {


    public static PossibleResponseBO mapPossibleResponseEntityToBO(PossibleResponseEntity possibleResponseEntity){
        PossibleResponseBO possibleResponseBO = new PossibleResponseBO();

        return possibleResponseBO;
    }

    public static PossibleResponseEntity mapPossibleResponseBOToEntity(PossibleResponseBO possibleResponseBO){
        PossibleResponseEntity possibleResponseEntity = new PossibleResponseEntity();


        return possibleResponseEntity;
    }

}
