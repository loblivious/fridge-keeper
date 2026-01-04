package com.loblivious.fridgekeeper.model;

import static java.time.temporal.ChronoUnit.DAYS;

import java.time.LocalDate;
import java.util.UUID;

public record IngredientDTO(
    UUID id,
    String name,
    String category,
    LocalDate purchaseDate,
    LocalDate expiryDate
) {

  // Helper to calculate days remaining
  public long getDaysRemaining() {
    if (expiryDate == null) {
      return 0;
    }
    return DAYS.between(LocalDate.now(), expiryDate);
  }
}
