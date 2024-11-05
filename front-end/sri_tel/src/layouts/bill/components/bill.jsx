import React from 'react';
import { useNavigate } from 'react-router-dom';
import '../../../App.css';

const Bill = ({ key, description, amount, createdDate, pay }) => {

  const navigate = useNavigate()

  const handlePay = () => {
    navigate('/payments', {state: { id: key }})
  }

  return (
    <div className="bill">
      <p className="bill-date"><strong>Created Date:</strong> {createdDate}</p>
      <p className="bill-description"><strong>Description:</strong> {description}</p>
      <p className="bill-amount"><strong>Amount:</strong> ${amount}</p>
      {pay && <button onClick={handlePay}>Pay Now</button>}
      <hr className="bill-divider" />
    </div>
  );
};

export default Bill;
