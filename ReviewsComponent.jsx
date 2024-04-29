import React, { useState, useEffect } from "react";
import axios from "axios";
import { useNavigate } from "react-router-dom";

const ReviewsComponent = ({ userData }) => {
  const navigate = useNavigate();

  // Function to handle click event on username
  const handleClick = async (userId) => {
    try {
      // Navigate to the user profile page
      navigate(`/user/${userId}`);
    } catch (error) {
      console.error("Error navigating to user profile:", error);
    }
  };

  useEffect(() => {
    console.log("IN REVIEW COMPNENT");
    console.log(userData);

    // Any cleanup code can go here if necessary
  }, []); // Empty dependency array

  return (
    <div>
      <h2>Provider Reviews</h2>
      {userData.reviews.length === 0 ? (
        <p>No reviews available</p>
      ) : (
        <ul>
          {userData.reviews.map((review) => (
            <li key={review.id}>
              <strong>Rating:</strong> {review.rating},{" "}
              <strong>Comment:</strong>
              {review.comment}{" "}
              {/* <span onClick={() => handleClick(review.user.id)}>
                {review.user.name}
              </span> */}
            </li>
          ))}
        </ul>
      )}
    </div>
  );
};

export default ReviewsComponent;
