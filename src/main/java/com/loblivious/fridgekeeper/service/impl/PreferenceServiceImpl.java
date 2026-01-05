package com.loblivious.fridgekeeper.service.impl;

import com.loblivious.fridgekeeper.entity.Preference;
import com.loblivious.fridgekeeper.entity.User;
import com.loblivious.fridgekeeper.mapper.PreferenceMapper;
import com.loblivious.fridgekeeper.model.RecipePreferenceDTO;
import com.loblivious.fridgekeeper.repository.PreferenceRepository;
import com.loblivious.fridgekeeper.service.PreferenceService;
import com.loblivious.fridgekeeper.service.UserService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PreferenceServiceImpl implements PreferenceService {

  private final PreferenceRepository preferenceRepository;
  private final PreferenceMapper preferenceMapper;
  private final UserService userService;


  @Override
  public List<RecipePreferenceDTO> getPreferences(String userEmail) {
    return preferenceRepository.findByUserEmail(userEmail).stream()
        .map(preferenceMapper::preferenceToPreferenceDTO).toList();
  }

  @Override
  public void savePreference(String userEmail, RecipePreferenceDTO preferenceDTO) {
    User user = userService.getUserByEmail(userEmail);
    Preference entity = preferenceMapper.preferenceDTOToPreference(preferenceDTO);
    entity.setUser(user);
    preferenceRepository.save(entity);
  }
}
