import axios from 'axios';
import React, { useState } from 'react';
import { useNavigate } from 'react-router-dom';

const SignUp = () => {
  const [username, setUsername] = useState('');
  const [firstName, setFirstName] = useState('');
  const [lastName, setLastName] = useState('');
  const [email, setEmail] = useState('');
  const [mobileNumber, setMobileNumber] = useState('');
  const [password, setPassword] = useState('');
  const [confirmPassword, setConfirmPassword] = useState('');
  const [OTP, setOTP] = useState('');
  const [successOTP, setSuccessOTP] = useState(false);
  const navigate = useNavigate();

  const handleSubmit = async(e) => {
    e.preventDefault();
    
    if (password !== confirmPassword) {
      alert("Passwords do not match!");
      return;
    }

    axios.post('http://localhost:8081/USER-SERVICE/user/getOtp', {username: mobileNumber})
      .then(response => {
        
      })
      .catch(error => {
        
      })


  };

  const handleOtp = async(e) => {
    e.preventDefault();
    
    axios.post('http://localhost:8081/USER-SERVICE/user/verifyOtp', {otpCode: OTP})
      .then(response => {
       if(response.status===200) handleRegister()
      })
      .catch(error => {
        
      })
  };

  const handleRegister = async(e) => {
    e.preventDefault();
    
    axios.post('http://localhost:8081/USER-SERVICE/user/register', {userName: username, password: password, mobileNumber: mobileNumber, firstName: firstName, lastName: lastName, email: email})
      .then(response => {
       if(response.status===200) navigate('/options')
      })
      .catch(error => {
        
      })
  };

  return (
    <div>
      <h2>Sign Up</h2>
      <form onSubmit={handleSubmit}>
        <div>
          <label htmlFor="firstName">First name:</label>
          <input
            type="text"
            id="firstName"
            value={firstName}
            onChange={(e) => setFirstName(e.target.value)}
            required
          />
        </div>
        <div>
          <label htmlFor="lastName">Last name:</label>
          <input
            type="text"
            id="lastName"
            value={lastName}
            onChange={(e) => setLastName(e.target.value)}
            required
          />
        </div>
        <div>
          <label htmlFor="email">Email:</label>
          <input
            type="email"
            id="email"
            value={email}
            onChange={(e) => setEmail(e.target.value)}
            required
          />
        </div>
        <div>
          <label htmlFor="username">Username:</label>
          <input
            type="text"
            id="username"
            value={username}
            onChange={(e) => setUsername(e.target.value)}
            required
          />
        </div>
        <div>
          <label htmlFor="email">Mobile number:</label>
          <input
            type="text"
            id="mobileNumberl"
            value={mobileNumber}
            onChange={(e) => setMobileNumber(e.target.value)}
            required
          />
        </div>
        <div>
          <label htmlFor="password">Password:</label>
          <input
            type="password"
            id="password"
            value={password}
            onChange={(e) => setPassword(e.target.value)}
            required
          />
        </div>
        <div>
          <label htmlFor="confirmPassword">Confirm Password:</label>
          <input
            type="password"
            id="confirmPassword"
            value={confirmPassword}
            onChange={(e) => setConfirmPassword(e.target.value)}
            required
          />
        </div>
        <button type="submit">Sign Up</button>
      </form>
      <br></br>
      <form onSubmit={handleOtp}>
        <div>
          <br />
          <label>OTP: </label>
          <input
            type="text"
            value={OTP}
            onChange={(e) => setOTP(e.target.value)}
            required
          />
          <button type="submit">Submit</button>
        </div>
          {successOTP}
      </form>
    </div>
  );
};

export default SignUp;
