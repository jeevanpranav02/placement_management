package com.tns.management.placement.placementmanagement.service;

import java.util.List;
import java.util.Optional;
import com.tns.management.placement.placementmanagement.constants.AddCollegeRequest;
import com.tns.management.placement.placementmanagement.model.College;
import com.tns.management.placement.placementmanagement.repository.CollegeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CollegeService {

  @Autowired
  private CollegeRepository collegeRepository;

  public College addCollege(AddCollegeRequest request) {
    College college = College.builder().name(request.getName()).location(request.getLocation())
        .affiliation(request.getAffiliation()).build();

    return collegeRepository.save(college);
  }

  public College updateCollege(Long id, AddCollegeRequest college) {
    Optional<College> optionalExistingCollege = collegeRepository.findById(id);

    if (optionalExistingCollege.isPresent()) {
      College existingCollege = optionalExistingCollege.get();

      existingCollege.setName(college.getName());
      existingCollege.setLocation(college.getLocation());
      existingCollege.setAffiliation(college.getAffiliation());

      return collegeRepository.save(existingCollege);
    }

    return null;
  }

  public List<College> getAllColleges() {
    return collegeRepository.findAll();
  }

  public College getCollegeById(Long id) {
    return collegeRepository.findById(id).orElse(null);
  }

  public boolean deleteCollege(Long id) {
    return collegeRepository.findById(id).map(college -> {
      collegeRepository.delete(college);
      return true;
    }).orElse(false);
  }
}
