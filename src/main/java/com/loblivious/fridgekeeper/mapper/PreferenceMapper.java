package com.loblivious.fridgekeeper.mapper;

import com.loblivious.fridgekeeper.entity.Preference;
import com.loblivious.fridgekeeper.model.RecipePreferenceDTO;
import org.mapstruct.Mapper;

@Mapper
public interface PreferenceMapper {

  Preference preferenceDTOToPreference(RecipePreferenceDTO preferenceDTO);

  RecipePreferenceDTO preferenceToPreferenceDTO(Preference preference);
}
