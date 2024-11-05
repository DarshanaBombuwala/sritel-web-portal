import React from 'react';
import { BrowserRouter as Router, Route, Routes, Link, Navigate } from 'react-router-dom'; // Use BrowserRouter instead of Router
import './App.css';
import SignIn from './layouts/auth/signin'; 
import SignUp from './layouts/auth/signup';
import Optionpage from './layouts/option/optionpage';
import ServicesPage from './layouts/servicesubcription/servicesubscriptionpage';
import BillsPage from './layouts/bill/billspage';
import PaymentsPage from './layouts/payment/paymentpage';
import CustomerCare from './layouts/customercare/customercarepage';
import Navbar from './layouts/navbar/navbar';

function App() {
  return (
    <Router> 
      <div>
        {<Navbar/>}

        <Routes>

          <Route path="/" element={<Navigate to="/signin" />} />

          <Route path="/signin" element={<SignIn />} />

          <Route path="/signup" element={<SignUp />} />
          <Route path="/options" element={<Optionpage />} />
          <Route path="/services" element={<ServicesPage />} />
          <Route path="/bills" element={<BillsPage />} />
          <Route path="/payments" element={<PaymentsPage />} />
          <Route path="/customercare" element={<CustomerCare />} />
          
        </Routes>
      </div>
    </Router>
  );
}

export default App;
