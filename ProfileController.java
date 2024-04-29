package org.teamlaika.laikaspetpark.controllers;

import io.jsonwebtoken.Claims;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.teamlaika.laikaspetpark.JwtGenerator;
import org.teamlaika.laikaspetpark.models.Pet;
import org.teamlaika.laikaspetpark.models.ProviderReview;
import org.teamlaika.laikaspetpark.models.User;
import org.teamlaika.laikaspetpark.models.data.UserRepository;
import org.teamlaika.laikaspetpark.models.dto.FrontProviderReviewDTO;
import org.teamlaika.laikaspetpark.models.dto.FrontUserDTO;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/api/profile")
public class ProfileController {

    @Autowired
    UserRepository userRepository;

    @GetMapping
    public ResponseEntity<FrontUserDTO>getUserInfo(@RequestHeader("Authorization") String token) {

        Claims claims = JwtGenerator.decodeToken(token);

    System.out.println("TESTTEST********************************");

        String userId = claims.getSubject();

        System.out.println(userId);

        Optional<User> result = userRepository.findById(Integer.parseInt(userId));
        User aUser = result.get();

        FrontProviderReviewDTO testReview = new FrontProviderReviewDTO("commentest", 1, 1);
        List<FrontProviderReviewDTO> testList = new ArrayList<>();
        testList.add(testReview);

        FrontUserDTO aUserCopy = new FrontUserDTO(aUser.getName(), aUser.getUsername(),
                aUser.getAccountType(), testList );

    System.out.println(testList.get(0).getId());
        System.out.println(testList.get(0).getComment());
        System.out.println(testList.get(0).getRating());

        System.out.println(aUserCopy);
    System.out.println("TEST TEST)()+++++++++++++++++++++++++");
        return ResponseEntity.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(aUserCopy);
    }
}
