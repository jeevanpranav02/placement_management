package com.tns.management.placement.placementmanagement.constants;

import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

/**
 * AddCollegeRequest
 */
@Data
@Builder
@RequiredArgsConstructor
public class AddCollegeRequest {
  private final String name;
  private final String location;
  private final String affiliation;
}
