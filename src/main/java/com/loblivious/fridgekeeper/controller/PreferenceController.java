package com.loblivious.fridgekeeper.controller;

import com.loblivious.fridgekeeper.model.RecipePreferenceDTO;
import com.loblivious.fridgekeeper.service.PreferenceService;
import jakarta.validation.Valid;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/preferences")
@RequiredArgsConstructor
public class PreferenceController {

  private final PreferenceService preferenceService;

  @GetMapping("/{email}")
  public ResponseEntity<List<RecipePreferenceDTO>> getPreferences(
      @PathVariable("email") String email) {
    return ResponseEntity.ok(preferenceService.getPreferences(email));
  }

  @PostMapping("/{email}")
  public ResponseEntity<Void> savePreference(@PathVariable("email") String email,
      @Valid @RequestBody RecipePreferenceDTO preference) {
    preferenceService.savePreference(email, preference);
    return ResponseEntity.status(HttpStatus.CREATED).build();
  }
}
