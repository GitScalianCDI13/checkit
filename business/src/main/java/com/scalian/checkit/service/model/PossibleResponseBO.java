package com.scalian.checkit.service.model;

import java.util.List;

public class PossibleResponseBO {

    private Integer possibleResponseId;
    private Boolean possibleResponseChecked;
    private String possibleResponseLabel;
    private QuestionBO question;
    private List<UserResponseBO> userResponses;
}
