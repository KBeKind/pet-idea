package org.teamlaika.laikaspetpark.models.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import org.teamlaika.laikaspetpark.models.Provider;

public class FrontProviderReviewDTO {

  private String comment;

  private int rating;

  private int id;

    public FrontProviderReviewDTO(String comment, int rating, int id) {
        this.comment = comment;
        this.rating = rating;
        this.id = id;
    }

    public String getComment() {
        return comment;
    }

    public int getRating() {
        return rating;
    }

    public int getId() {
        return id;
    }
}