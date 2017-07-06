package com.scalian.checkit.service.mapping;

import com.scalian.checkit.model.ThemeEntity;
import com.scalian.checkit.service.model.ThemeBO;

public class ThemeMapping {

    public static ThemeBO mapThemeEntityToBO(ThemeEntity themeEntity){
        ThemeBO themeBO = new ThemeBO();
        themeBO.setThemeId(themeEntity.getThemeId());
        themeBO.setThemeLabel(themeEntity.getThemeLabel());
        //List<QuestionBO> questions;
        //List<TestBO> tests;



        return themeBO;
    }

    public static ThemeEntity mapThemeBOToEntity(ThemeBO themeBO){
        ThemeEntity themeEntity = new ThemeEntity();
        themeEntity.setThemeId(themeBO.getThemeId());
        themeEntity.setThemeLabel(themeBO.getThemeLabel());
        //List<QuestionBO> questions;
        //List<TestBO> tests;

        return themeEntity;
    }
}
