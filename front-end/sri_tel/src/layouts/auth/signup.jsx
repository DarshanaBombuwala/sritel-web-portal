import axios from "axios";
import React, { useState } from "react";
import { useNavigate } from "react-router-dom";
import "../../App.css";
import { useAxios } from "../../hooks/useAxiso";

const SignUp = () => {
  const [username, setUsername] = useState("");
  const [firstName, setFirstName] = useState("");
  const [lastName, setLastName] = useState("");
  const [email, setEmail] = useState("");
  const [mobileNumber, setMobileNumber] = useState("");
  const [password, setPassword] = useState("");
  const [confirmPassword, setConfirmPassword] = useState("");
  const [OTP, setOTP] = useState("");
  const [successOTP, setSuccessOTP] = useState(false);
  const navigate = useNavigate();
  const { nonAuthApi } = useAxios();
  const handleRegister = async (e) => {
    e.preventDefault();

    if (password !== confirmPassword) {
      alert("Passwords do not match!");
      return;
    }

    nonAuthApi
      .post("/USER-SERVICE/users/register", {
        userName: username,
        password: password,
        mobileNumber: mobileNumber,
        firstName: firstName,
        lastName: lastName,
        email: email,
      })
      .then((response) => {
        if (response.status === 200) navigate("/options");
      })
      .catch((error) => {
        console.error("Registration failed:", error);
      });
  };

  const handleOtp = async (e) => {
    e.preventDefault();

    nonAuthApi
      .post("/USER-SERVICE/users/verifyOtp", {
        otp: OTP,
        mobileNumber: mobileNumber,
      })
      .then((response) => {
        if (response.status === 200) {
          setSuccessOTP(true);
          alert("OTP Verified Successfully!");
          handleRegister(e);
        }
      })
      .catch((error) => {
        console.error("OTP verification failed:", error);
      });
  };

  const getOtp = async (e) => {
    e.preventDefault();

    nonAuthApi
      .post("/USER-SERVICE/users/getOtp", {
        mobileNumber: mobileNumber,
      })
      .then((response) => {
        if (response.status === 200) {
          alert("OTP code successfully sent.");
        }
      })
      .catch((error) => {
        console.error("Error ocured while sending OTP code.");
      });
  };

  return (
    <div className="form-container">
      <h2 className="form-title">Sign Up</h2>
      <form className="form" onSubmit={getOtp}>
        <div className="form-group">
          <label className="form-label" htmlFor="firstName">
            First Name:
          </label>
          <input
            className="form-input"
            type="text"
            id="firstName"
            value={firstName}
            onChange={(e) => setFirstName(e.target.value)}
            required
          />
        </div>
        <div className="form-group">
          <label className="form-label" htmlFor="lastName">
            Last Name:
          </label>
          <input
            className="form-input"
            type="text"
            id="lastName"
            value={lastName}
            onChange={(e) => setLastName(e.target.value)}
            required
          />
        </div>
        <div className="form-group">
          <label className="form-label" htmlFor="email">
            Email:
          </label>
          <input
            className="form-input"
            type="email"
            id="email"
            value={email}
            onChange={(e) => setEmail(e.target.value)}
            required
          />
        </div>
        <div className="form-group">
          <label className="form-label" htmlFor="username">
            Username:
          </label>
          <input
            className="form-input"
            type="text"
            id="username"
            value={username}
            onChange={(e) => setUsername(e.target.value)}
            required
          />
        </div>
        <div className="form-group">
          <label className="form-label" htmlFor="mobileNumber">
            Mobile Number:
          </label>
          <input
            className="form-input"
            type="text"
            id="mobileNumber"
            value={mobileNumber}
            onChange={(e) => setMobileNumber(e.target.value)}
            required
          />
        </div>
        <div className="form-group">
          <label className="form-label" htmlFor="password">
            Password:
          </label>
          <input
            className="form-input"
            type="password"
            id="password"
            value={password}
            onChange={(e) => setPassword(e.target.value)}
            required
          />
        </div>
        <div className="form-group">
          <label className="form-label" htmlFor="confirmPassword">
            Confirm Password:
          </label>
          <input
            className="form-input"
            type="password"
            id="confirmPassword"
            value={confirmPassword}
            onChange={(e) => setConfirmPassword(e.target.value)}
            required
          />
        </div>
        <button className="form-button" type="submit">
          Sign Up
        </button>
      </form>

      <br />

      <form className="form" onSubmit={handleOtp}>
        <div className="form-group">
          <label className="form-label">OTP: </label>
          <input
            className="form-input"
            type="text"
            value={OTP}
            onChange={(e) => setOTP(e.target.value)}
            required
          />
          <button className="form-button" type="submit">
            Submit
          </button>
        </div>
        {successOTP && (
          <p className="form-success">OTP Verified Successfully!</p>
        )}
      </form>
    </div>
  );
};

export default SignUp;
