package org.teamlaika.laikaspetpark.models.dto;

import org.teamlaika.laikaspetpark.models.ProviderReview;

import java.util.ArrayList;
import java.util.List;

public class FrontUserDTO {


    String name;

    String username;

    String userType;

    List<FrontProviderReviewDTO> reviews = new ArrayList<>();

    public FrontUserDTO(String name, String username, String userType, List<FrontProviderReviewDTO> reviews) {
        this.name = name;
        this.username = username;
        this.userType = userType;
        this.reviews = reviews;
    }

    public String getName() {
        return name;
    }

    public String getUsername() {
        return username;
    }

    public String getUserType() {
        return userType;
    }

    public List<FrontProviderReviewDTO> getReviews() {
        return reviews;
    }
}
