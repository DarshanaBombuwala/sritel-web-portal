import React, { useState } from "react";
import axios from "axios";
import { useNavigate } from "react-router-dom";
import "../../App.css";
import { useAxios } from "../../hooks/useAxiso";

function SignIn() {
  // State to hold input values
  const [username, setUsername] = useState("");
  const [password, setPassword] = useState("");
  const navigate = useNavigate();

  const { nonAuthApi } = useAxios();

  const handleSubmit = async (event) => {
    event.preventDefault(); // Prevent default form submission behavior
    await nonAuthApi
      .post("/AUTH-SERVICE/authentication/login", {
        userName: username,
        password: password,
      })
      .then((response) => {
        if (response.status === 200) {
          localStorage.setItem("token", response.data);
          navigate("/options");
        }
      })
      .catch((error) => {});
    // You can add your sign-in logic here (like calling an API)
  };

  return (
    <div className="signin-container">
      <h2 className="signin-title">Sign In</h2>
      <form className="signin-form" onSubmit={handleSubmit}>
        <div className="form-group">
          <label className="form-label">Username: </label>
          <input
            className="form-input"
            type="text"
            value={username}
            onChange={(e) => setUsername(e.target.value)}
            required
          />
        </div>
        <div className="form-group">
          <label className="form-label">Password: </label>
          <input
            className="form-input"
            type="password"
            value={password}
            onChange={(e) => setPassword(e.target.value)}
            required
          />
        </div>

        <div className="form-group">
          <button className="form-button" type="submit">
            Sign In
          </button>
        </div>
      </form>
    </div>
  );
}

export default SignIn;
