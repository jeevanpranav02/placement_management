package com.tns.management.placement.placementmanagement.controller;

import java.util.List;
import com.tns.management.placement.placementmanagement.constants.AddCollegeRequest;
import com.tns.management.placement.placementmanagement.model.College;
import com.tns.management.placement.placementmanagement.service.CollegeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class CollegeController {

  @Autowired
  private CollegeService collegeService;

  @PostMapping("/colleges")
  public College addCollege(@RequestBody AddCollegeRequest college) {
    return collegeService.addCollege(college);
  }

  @GetMapping("/colleges/{id}")
  public College getCollegeById(@PathVariable Long id) {
    return collegeService.getCollegeById(id);
  }

  @GetMapping("/colleges")
  public List<College> getAllColleges() {
    return collegeService.getAllColleges();
  }

  @PutMapping("/colleges/update/{id}")
  public College updateCollege(@PathVariable Long id, @RequestBody AddCollegeRequest college) {
    return collegeService.updateCollege(id, college);
  }


  @DeleteMapping("/colleges/{id}")
  public ResponseEntity<String> deleteCollege(@PathVariable Long id) {
    boolean deleted= collegeService.deleteCollege(id);
    if(deleted){
      return ResponseEntity.ok("College Deleted");
    }
    return ResponseEntity.badRequest().body("College not found");
  }

}
