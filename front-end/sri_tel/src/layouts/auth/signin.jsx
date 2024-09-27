import React, { useState } from 'react';
import axios from 'axios';
import { useNavigate } from 'react-router-dom';

function SignIn() {
  // State to hold input values
  const [username, setUsername] = useState('');
  const [password, setPassword] = useState('');
  const navigate = useNavigate()

  
  const handleSubmit = async (event) => {
    event.preventDefault(); // Prevent default form submission behavior
    await axios.post('http://localhost:8081/AUTH-SERVICE/authentication/login', {username: username, password: password})
      .then(response => {
        if(response.status===200){
          navigate('/options')
        }
      })
      .catch(error => {
        
      })
    // You can add your sign-in logic here (like calling an API)
  };

  return (
    <div>
      <h2>Sign In</h2>
      <form onSubmit={handleSubmit}>
        <div>
          <label>Username: </label>
          <input
            type="text"
            value={username}
            onChange={(e) => setUsername(e.target.value)}
            required
          />
        </div>
        <div>
          <label>Password: </label>
          <input
            type="password"
            value={password}
            onChange={(e) => setPassword(e.target.value)}
            required
          />
        </div>
        
        <div>
          <button type="submit">Sign In</button>
        </div>
      </form>

    </div>
  );
}

export default SignIn;
