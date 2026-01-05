package com.loblivious.fridgekeeper.repository;

import com.loblivious.fridgekeeper.entity.Preference;
import java.util.List;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PreferenceRepository extends JpaRepository<Preference, UUID> {

  List<Preference> findByUserEmail(String email);
}
