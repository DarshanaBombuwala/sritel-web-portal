import React, { useState } from 'react';

function SignIn() {
  // State to hold input values
  const [username, setUsername] = useState('');
  const [password, setPassword] = useState('');
  const [OTP, setOTP] = useState('');
  const [successOTP, setSuccessOTP] = useState(false);

  
  const handleSubmit = (event) => {
    event.preventDefault(); // Prevent default form submission behavior
    console.log('Username:', username);
    console.log('Password:', password);

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
            <br />
          <label>OTP: </label>
          <input
            type="text"
            value={OTP}
            onChange={(e) => setOTP(e.target.value)}
            required
          />
        </div>
        <div>
        {successOTP }
          <button type="submit">Sign In</button>
        </div>
      </form>
    </div>
  );
}

export default SignIn;
