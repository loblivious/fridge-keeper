package com.loblivious.fridgekeeper.service;

import com.loblivious.fridgekeeper.model.RecipePreferenceDTO;
import java.util.List;

public interface PreferenceService {

  List<RecipePreferenceDTO> getPreferences(String userEmail);

  void savePreference(String userEmail, RecipePreferenceDTO pref);
}
