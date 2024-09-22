import React from 'react';
import { BrowserRouter as Router, Route, Routes, Link, Navigate } from 'react-router-dom'; // Use BrowserRouter instead of Router
import './App.css';
import SignIn from './layouts/auth/signin'; 
import SignUp from './layouts/auth/signup';
import Optionpage from './layouts/option/optionpage';

function App() {
  return (
    <Router> 
      <div>
        <nav>
          <ul>
            <li><Link to="/">Home</Link></li>
            <li><Link to="/signin">Sign In</Link></li>
            <li><Link to="/signup">Sign up</Link></li>
            <li><Link to="/options">options</Link></li>
          </ul>
        </nav>

        <Routes>

          <Route path="/" element={<Navigate to="/signin" />} />

          <Route path="/signin" element={<SignIn />} />

          <Route path="/signup" element={<SignUp />} />
          <Route path="/options" element={<Optionpage />} />
          <Route path="/options" element={<Optionpage />} />
          
        </Routes>
      </div>
    </Router>
  );
}

export default App;
